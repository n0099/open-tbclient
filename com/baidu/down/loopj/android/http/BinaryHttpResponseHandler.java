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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final boolean DEBUG = false;
    private static final String TAG = "BinaryHttpResponseHandler";
    public static final int TEST_SPEED_STAGE_AFTER = 2;
    public static final int TEST_SPEED_STAGE_BEFORE = 0;
    public static final int TEST_SPEED_STAGE_EXE = 1;
    private static Pattern mContentRangPattern = Pattern.compile("\\s*(bytes)?\\s*(\\d+)\\s*\\-+\\s*\\d+\\s*/\\s*(\\d+)\\s*");
    private String mHeaderETag;
    protected long mTestSpeedStartTime;
    protected long totalLen = 0;
    private long mFileTotalBytes = 0;
    protected int mTestSpeedStage = 0;
    private List<UrlDNSInfo> mDomainNameAndIpList = new CopyOnWriteArrayList();
    public AbstractTask mtask = null;

    public void setRunning() {
        this.mRunning = true;
    }

    public void stopRunning() {
        this.mRunning = false;
    }

    public long getTotalLen() {
        return this.totalLen;
    }

    public long getFileLength() {
        return this.mFileTotalBytes;
    }

    public void onSuccess(byte[] bArr, long j) {
    }

    public void onSuccess(int i, byte[] bArr, long j) {
        onSuccess(bArr, j);
    }

    public void onFailure(Throwable th, byte[] bArr, int i) {
        onFailure(th, i);
    }

    public void onDownload(ByteArrayInfo byteArrayInfo) {
    }

    public void onPaused(int i) {
    }

    public void onFileLengthRec(long j, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void sendSuccessMessage(int i, String str, long j) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendDownloadMessage(ByteArrayInfo byteArrayInfo) {
        sendMessage(obtainMessage(4, new Object[]{byteArrayInfo}));
    }

    protected void sendFileLengthMessage() {
        Message obtain = Message.obtain();
        obtain.what = 6;
        Bundle bundle = new Bundle();
        bundle.putLong("filetotalbytes", this.mFileTotalBytes);
        bundle.putString("etag", this.mHeaderETag);
        obtain.setData(bundle);
        sendMessage(obtain);
    }

    protected void handleSuccessMessage(int i, byte[] bArr, long j) {
        onSuccess(i, bArr, j);
    }

    protected void handleDownloadMessage(ByteArrayInfo byteArrayInfo) {
        onDownload(byteArrayInfo);
    }

    protected void handleFailureMessage(Throwable th, byte[] bArr, int i) {
        onFailure(th, bArr, i);
    }

    protected void handlePausedMessage(int i) {
        onPaused(i);
    }

    protected void handleFileLengthMessage(long j, String str) {
        onFileLengthRec(j, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (byte[]) objArr[1], ((Long) objArr[2]).longValue());
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2[0] != null && objArr2[1] != null) {
                    handleFailureMessage((Throwable) objArr2[0], objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
                    return;
                } else if (objArr2[1] == null) {
                    handleFailureMessage((Throwable) objArr2[0], BdStatsConstant.StatsType.ERROR, ((Integer) objArr2[2]).intValue());
                    return;
                } else if (objArr2[0] == null) {
                    handleFailureMessage((Throwable) null, objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
                    return;
                } else {
                    handleFailureMessage((Throwable) null, BdStatsConstant.StatsType.ERROR, ((Integer) objArr2[2]).intValue());
                    return;
                }
            case 2:
            case 3:
            default:
                super.handleMessage(message);
                return;
            case 4:
                handleDownloadMessage((ByteArrayInfo) ((Object[]) message.obj)[0]);
                return;
            case 5:
                if (message.obj == null) {
                    handlePausedMessage(0);
                    return;
                } else {
                    handlePausedMessage(((Integer) message.obj).intValue());
                    return;
                }
            case 6:
                Bundle data = message.getData();
                handleFileLengthMessage(data.getLong("filetotalbytes"), data.getString("etag"));
                return;
        }
    }

    public long sendResponseMessage(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) throws IOException {
        long j;
        long j2;
        int httpStatus = iCommonRequestHandler.getHttpStatus();
        this.mSupportRange = true;
        if (httpStatus == 200 || httpStatus == 206) {
            this.mHeaderETag = iCommonRequestHandler.onGetResponseHeader(Headers.ETAG);
            String onGetResponseHeader = iCommonRequestHandler.onGetResponseHeader(Headers.CONTENT_RANGE);
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
                String onGetHttpHeader = iCommonRequestHandler.onGetHttpHeader(false);
                this.mtask.mStrRedownload = "server not support resume broken transfer, sc=" + httpStatus + ", headers : \n" + onGetHttpHeader.toString();
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
                if (onGetResponseHeader3 != null && ("trunked".equalsIgnoreCase(onGetResponseHeader3) || HTTP.CHUNK_CODING.equalsIgnoreCase(onGetResponseHeader3))) {
                    this.mFileTotalBytes = Long.MAX_VALUE;
                    this.mTrunked = true;
                    sendFileLengthMessage();
                    return 0L;
                }
                throw new IOException("Oops! content-length illegal : \n" + iCommonRequestHandler.onGetHttpHeader(false).toString());
            }
            return receiveResponseData(iCommonRequestHandler, j, httpStatus, asyncHttpRequest);
        }
        String onGetHttpHeader2 = iCommonRequestHandler.onGetHttpHeader(false);
        if (httpStatus == 412) {
            this.mSupportRange = false;
        }
        throw new HttpResponseException(httpStatus, onGetHttpHeader2);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, INVOKE] complete} */
    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, IGET, INVOKE, IPUT, INVOKE, INVOKE, IGET] complete}, expected: {[IF, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j, int i, AsyncHttpRequest asyncHttpRequest) throws IOException {
        int read;
        long j2;
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
                        int i2 = length - byteArray.mByteArrayLength;
                        int i3 = read <= i2 ? read : i2;
                        if (byteArray.mByteArrayLength + i3 >= length) {
                            System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                            byteArray.mByteArrayLength += i3;
                            sendDownloadMessage(byteArray);
                            j2 = i3 + j;
                            byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                            byteArray.mFilePos = j2;
                            byteArray.mByteArrayLength = 0;
                        } else {
                            System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                            byteArray.mByteArrayLength += i3;
                            j2 = i3 + j;
                        }
                        if (i3 < read) {
                            int i4 = read - i3;
                            System.arraycopy(bArr, i3, byteArray.mByteArray, byteArray.mByteArrayLength, i4);
                            byteArray.mByteArrayLength += i4;
                            j2 += i4;
                        }
                        if (threadSpeedStat != null) {
                            threadSpeedStat.dTempDownSize = j2;
                        }
                        j = j2;
                    } catch (IOException e) {
                        throw e;
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
            sendSuccessMessage(i, null, j);
        }
        if (this.mTrunked) {
            this.mRunning = false;
        }
        return j;
    }

    public void setCurTask(AbstractTask abstractTask) {
        this.mtask = abstractTask;
    }

    public long getTestSpeedStartTime() {
        return this.mTestSpeedStartTime;
    }

    public int getTestSpeedStage() {
        return this.mTestSpeedStage;
    }

    public void setTestSpeedStage(int i) {
        this.mTestSpeedStage = i;
        if (i == 1) {
            this.mTestSpeedStartTime = System.currentTimeMillis();
        }
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
        this.mDomainNameAndIpList = new CopyOnWriteArrayList();
        this.mDomainNameAndIpList.add(urlDNSInfo);
    }

    public List<UrlDNSInfo> getDomainNameAndIpInfo() {
        return this.mDomainNameAndIpList;
    }

    public void cleanDomainNameAndIpInfo() {
        this.mDomainNameAndIpList = new CopyOnWriteArrayList();
    }
}
