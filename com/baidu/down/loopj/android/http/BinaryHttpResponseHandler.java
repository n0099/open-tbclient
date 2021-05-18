package com.baidu.down.loopj.android.http;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.down.common.UrlDNSInfo;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.statistic.ThreadSpeedStat;
import com.baidu.down.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    public static final boolean DEBUG = false;
    public static final String TAG = "BinaryHttpResponseHandler";
    public static final int TEST_SPEED_STAGE_AFTER = 2;
    public static final int TEST_SPEED_STAGE_BEFORE = 0;
    public static final int TEST_SPEED_STAGE_EXE = 1;
    public static Pattern mContentRangPattern = Pattern.compile("\\s*(bytes)?\\s*(\\d+)\\s*\\-+\\s*\\d+\\s*/\\s*(\\d+)\\s*");
    public String mHeaderETag;
    public long mTestSpeedStartTime;
    public long totalLen = 0;
    public long mFileTotalBytes = 0;
    public int mTestSpeedStage = 0;
    public List<UrlDNSInfo> mDomainNameAndIpList = new CopyOnWriteArrayList();
    public AbstractTask mtask = null;

    public void cleanDomainNameAndIpInfo() {
        this.mDomainNameAndIpList = new CopyOnWriteArrayList();
    }

    public List<UrlDNSInfo> getDomainNameAndIpInfo() {
        return this.mDomainNameAndIpList;
    }

    public long getFileLength() {
        return this.mFileTotalBytes;
    }

    public int getTestSpeedStage() {
        return this.mTestSpeedStage;
    }

    public long getTestSpeedStartTime() {
        return this.mTestSpeedStartTime;
    }

    public long getTotalLen() {
        return this.totalLen;
    }

    public void handleDownloadMessage(ByteArrayInfo byteArrayInfo) {
        onDownload(byteArrayInfo);
    }

    public void handleFailureMessage(Throwable th, byte[] bArr, int i2) {
        onFailure(th, bArr, i2);
    }

    public void handleFileLengthMessage(long j, String str) {
        onFileLengthRec(j, str);
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Object[] objArr = (Object[]) message.obj;
            handleSuccessMessage(((Integer) objArr[0]).intValue(), (byte[]) objArr[1], ((Long) objArr[2]).longValue());
        } else if (i2 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2[0] != null && objArr2[1] != null) {
                handleFailureMessage((Throwable) objArr2[0], objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
            } else if (objArr2[1] == null) {
                handleFailureMessage((Throwable) objArr2[0], "error", ((Integer) objArr2[2]).intValue());
            } else if (objArr2[0] == null) {
                handleFailureMessage((Throwable) null, objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
            } else {
                handleFailureMessage((Throwable) null, "error", ((Integer) objArr2[2]).intValue());
            }
        } else if (i2 == 4) {
            handleDownloadMessage((ByteArrayInfo) ((Object[]) message.obj)[0]);
        } else if (i2 == 5) {
            Object obj = message.obj;
            if (obj == null) {
                handlePausedMessage(0);
            } else {
                handlePausedMessage(((Integer) obj).intValue());
            }
        } else if (i2 == 6) {
            Bundle data = message.getData();
            handleFileLengthMessage(data.getLong("filetotalbytes"), data.getString("etag"));
        } else if (i2 != 7) {
            super.handleMessage(message);
        } else if (message.getData() != null) {
            handleRedirectUrl(message.getData().getString("redirect_url", ""));
        }
    }

    public void handlePausedMessage(int i2) {
        onPaused(i2);
    }

    public void handleRedirectUrl(String str) {
    }

    public void handleSuccessMessage(int i2, byte[] bArr, long j) {
        onSuccess(i2, bArr, j);
    }

    public void onDownload(ByteArrayInfo byteArrayInfo) {
    }

    public void onFailure(Throwable th, byte[] bArr, int i2) {
        onFailure(th, i2);
    }

    public void onFileLengthRec(long j, String str) {
    }

    public void onPaused(int i2) {
    }

    public void onSuccess(int i2, byte[] bArr, long j) {
        onSuccess(bArr, j);
    }

    public void onSuccess(byte[] bArr, long j) {
    }

    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, IGET, INVOKE, IPUT, INVOKE, INVOKE, IGET] complete}, expected: {[IF, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j, int i2, AsyncHttpRequest asyncHttpRequest) throws IOException {
        int read;
        InputStream inputStream = iCommonRequestHandler.getInputStream();
        long contentLength = iCommonRequestHandler.getContentLength();
        ThreadSpeedStat threadSpeedStat = asyncHttpRequest.getThreadSpeedStat();
        if (threadSpeedStat != null) {
            asyncHttpRequest.setDownStartPos(j);
            threadSpeedStat.dsize = this.mFileTotalBytes;
        }
        if (inputStream != null) {
            this.totalLen = contentLength;
            ByteArrayInfo byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
            byteArray.mFilePos = j;
            byteArray.mByteArrayLength = 0;
            this.mRunning = true;
            int length = byteArray.mByteArray.length;
            byte[] bArr = new byte[length];
            while (this.mRunning && (read = inputStream.read(bArr)) != -1) {
                try {
                    try {
                        int i3 = length - byteArray.mByteArrayLength;
                        if (read <= i3) {
                            i3 = read;
                        }
                        if (byteArray.mByteArrayLength + i3 >= length) {
                            System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                            byteArray.mByteArrayLength += i3;
                            sendDownloadMessage(byteArray);
                            j += i3;
                            byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                            byteArray.mFilePos = j;
                            byteArray.mByteArrayLength = 0;
                        } else {
                            System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                            byteArray.mByteArrayLength += i3;
                            j += i3;
                        }
                        if (i3 < read) {
                            int i4 = read - i3;
                            System.arraycopy(bArr, i3, byteArray.mByteArray, byteArray.mByteArrayLength, i4);
                            byteArray.mByteArrayLength += i4;
                            j += i4;
                        }
                        if (threadSpeedStat != null) {
                            threadSpeedStat.dTempDownSize = j;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    }
                } catch (Throwable th) {
                    if (threadSpeedStat != null) {
                        threadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
                    }
                    iCommonRequestHandler.closeInputStream();
                    throw th;
                }
            }
            if (threadSpeedStat != null) {
                threadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
            }
            iCommonRequestHandler.closeInputStream();
            if (this.mRunning && byteArray.mByteArrayLength > 0) {
                sendDownloadMessage(byteArray);
            } else {
                TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().recycle(byteArray);
            }
        }
        if (this.mRunning) {
            if (threadSpeedStat != null) {
                threadSpeedStat.dend += threadSpeedStat.dTempDownSize;
                threadSpeedStat.dTempDownSize = 0L;
            }
            sendSuccessMessage(i2, null, j);
        }
        if (this.mTrunked) {
            this.mRunning = false;
        }
        return j;
    }

    public void saveDomainNameAndIpInfo(UrlDNSInfo urlDNSInfo) {
        if (!Utils.isEmpty(this.mDomainNameAndIpList)) {
            for (UrlDNSInfo urlDNSInfo2 : this.mDomainNameAndIpList) {
                if (urlDNSInfo2.compareTo(urlDNSInfo) == 0) {
                    return;
                }
            }
            this.mDomainNameAndIpList.add(urlDNSInfo);
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mDomainNameAndIpList = copyOnWriteArrayList;
        copyOnWriteArrayList.add(urlDNSInfo);
    }

    public void sendDownloadMessage(ByteArrayInfo byteArrayInfo) {
        sendMessage(obtainMessage(4, new Object[]{byteArrayInfo}));
    }

    public void sendFileLengthMessage() {
        Message obtain = Message.obtain();
        obtain.what = 6;
        Bundle bundle = new Bundle();
        bundle.putLong("filetotalbytes", this.mFileTotalBytes);
        bundle.putString("etag", this.mHeaderETag);
        obtain.setData(bundle);
        sendMessage(obtain);
    }

    public void sendRedirectMessage(String str) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        Bundle bundle = new Bundle();
        bundle.putString("redirect_url", str);
        obtain.setData(bundle);
        sendMessage(obtain);
    }

    public long sendResponseMessage(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) throws IOException {
        long j;
        long j2;
        int httpStatus = iCommonRequestHandler.getHttpStatus();
        this.mSupportRange = true;
        if (httpStatus != 200 && httpStatus != 206) {
            String onGetHttpHeader = iCommonRequestHandler.onGetHttpHeader(false);
            if (httpStatus == 412) {
                this.mSupportRange = false;
            }
            throw new HttpResponseException(httpStatus, onGetHttpHeader);
        }
        this.mHeaderETag = iCommonRequestHandler.onGetResponseHeader("ETag");
        String onGetResponseHeader = iCommonRequestHandler.onGetResponseHeader("Content-Range");
        if (onGetResponseHeader != null) {
            Matcher matcher = mContentRangPattern.matcher(onGetResponseHeader);
            if (matcher.matches()) {
                j2 = Long.valueOf(matcher.group(2)).longValue();
                this.mFileTotalBytes = Long.valueOf(matcher.group(3)).longValue();
            } else {
                j2 = 0;
            }
            j = j2;
        } else {
            this.mSupportRange = false;
            String onGetHttpHeader2 = iCommonRequestHandler.onGetHttpHeader(false);
            this.mtask.mStrRedownload = "server not support resume broken transfer, sc=" + httpStatus + ", headers : \n" + onGetHttpHeader2.toString();
            String onGetResponseHeader2 = iCommonRequestHandler.onGetResponseHeader("Content-Length");
            if (onGetResponseHeader2 != null) {
                this.mFileTotalBytes = Long.valueOf(onGetResponseHeader2).longValue();
            }
            j = 0;
        }
        if (this.mFileTotalBytes > 0) {
            sendFileLengthMessage();
        } else if (!this.mTrunked) {
            String onGetResponseHeader3 = iCommonRequestHandler.onGetResponseHeader("Transfer-Encoding");
            if (onGetResponseHeader3 != null && ("trunked".equalsIgnoreCase(onGetResponseHeader3) || "chunked".equalsIgnoreCase(onGetResponseHeader3))) {
                this.mFileTotalBytes = Long.MAX_VALUE;
                this.mTrunked = true;
                sendFileLengthMessage();
                return 0L;
            }
            String onGetHttpHeader3 = iCommonRequestHandler.onGetHttpHeader(false);
            throw new IOException("Oops! content-length illegal : \n" + onGetHttpHeader3.toString());
        }
        return receiveResponseData(iCommonRequestHandler, j, httpStatus, asyncHttpRequest);
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void sendSuccessMessage(int i2, String str, long j) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}));
    }

    public void setCurTask(AbstractTask abstractTask) {
        this.mtask = abstractTask;
    }

    public void setRunning() {
        this.mRunning = true;
    }

    public void setTestSpeedStage(int i2) {
        this.mTestSpeedStage = i2;
        if (i2 == 1) {
            this.mTestSpeedStartTime = System.currentTimeMillis();
        }
    }

    public void stopRunning() {
        this.mRunning = false;
    }
}
