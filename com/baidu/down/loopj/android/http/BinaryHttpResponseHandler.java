package com.baidu.down.loopj.android.http;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.UrlDNSInfo;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.statistic.ThreadSpeedStat;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BinaryHttpResponseHandler";
    public static final int TEST_SPEED_STAGE_AFTER = 2;
    public static final int TEST_SPEED_STAGE_BEFORE = 0;
    public static final int TEST_SPEED_STAGE_EXE = 1;
    public static Pattern mContentRangPattern;
    public transient /* synthetic */ FieldHolder $fh;
    public List<UrlDNSInfo> mDomainNameAndIpList;
    public long mFileTotalBytes;
    public String mHeaderETag;
    public int mTestSpeedStage;
    public long mTestSpeedStartTime;
    public AbstractTask mtask;
    public long totalLen;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1005979558, "Lcom/baidu/down/loopj/android/http/BinaryHttpResponseHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1005979558, "Lcom/baidu/down/loopj/android/http/BinaryHttpResponseHandler;");
                return;
            }
        }
        mContentRangPattern = Pattern.compile("\\s*(bytes)?\\s*(\\d+)\\s*\\-+\\s*\\d+\\s*/\\s*(\\d+)\\s*");
    }

    public BinaryHttpResponseHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.totalLen = 0L;
        this.mFileTotalBytes = 0L;
        this.mTestSpeedStage = 0;
        this.mDomainNameAndIpList = new CopyOnWriteArrayList();
        this.mtask = null;
    }

    public void cleanDomainNameAndIpInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDomainNameAndIpList = new CopyOnWriteArrayList();
        }
    }

    public List<UrlDNSInfo> getDomainNameAndIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDomainNameAndIpList : (List) invokeV.objValue;
    }

    public long getFileLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFileTotalBytes : invokeV.longValue;
    }

    public int getTestSpeedStage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTestSpeedStage : invokeV.intValue;
    }

    public long getTestSpeedStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTestSpeedStartTime : invokeV.longValue;
    }

    public long getTotalLen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.totalLen : invokeV.longValue;
    }

    public void handleDownloadMessage(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, byteArrayInfo) == null) {
            onDownload(byteArrayInfo);
        }
    }

    public void handleFailureMessage(Throwable th, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, th, bArr, i2) == null) {
            onFailure(th, bArr, i2);
        }
    }

    public void handleFileLengthMessage(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, str) == null) {
            onFileLengthRec(j2, str);
        }
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
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
    }

    public void handlePausedMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            onPaused(i2);
        }
    }

    public void handleRedirectUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void handleSuccessMessage(int i2, byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), bArr, Long.valueOf(j2)}) == null) {
            onSuccess(i2, bArr, j2);
        }
    }

    public void onDownload(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, byteArrayInfo) == null) {
        }
    }

    public void onFailure(Throwable th, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, th, bArr, i2) == null) {
            onFailure(th, i2);
        }
    }

    public void onFileLengthRec(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048591, this, j2, str) == null) {
        }
    }

    public void onPaused(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    public void onSuccess(int i2, byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), bArr, Long.valueOf(j2)}) == null) {
            onSuccess(bArr, j2);
        }
    }

    public void onSuccess(byte[] bArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, bArr, j2) == null) {
        }
    }

    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, IGET, INVOKE, IPUT, INVOKE, INVOKE, IGET] complete}, expected: {[IF, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j2, int i2, AsyncHttpRequest asyncHttpRequest) throws IOException {
        InterceptResult invokeCommon;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{iCommonRequestHandler, Long.valueOf(j2), Integer.valueOf(i2), asyncHttpRequest})) == null) {
            InputStream inputStream = iCommonRequestHandler.getInputStream();
            long contentLength = iCommonRequestHandler.getContentLength();
            ThreadSpeedStat threadSpeedStat = asyncHttpRequest.getThreadSpeedStat();
            if (threadSpeedStat != null) {
                asyncHttpRequest.setDownStartPos(j2);
                threadSpeedStat.dsize = this.mFileTotalBytes;
            }
            if (inputStream != null) {
                this.totalLen = contentLength;
                ByteArrayInfo byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                byteArray.mFilePos = j2;
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
                                j2 += i3;
                                byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                                byteArray.mFilePos = j2;
                                byteArray.mByteArrayLength = 0;
                            } else {
                                System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                                byteArray.mByteArrayLength += i3;
                                j2 += i3;
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
                sendSuccessMessage(i2, null, j2);
            }
            if (this.mTrunked) {
                this.mRunning = false;
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public void saveDomainNameAndIpInfo(UrlDNSInfo urlDNSInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, urlDNSInfo) == null) {
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
    }

    public void sendDownloadMessage(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, byteArrayInfo) == null) {
            sendMessage(obtainMessage(4, new Object[]{byteArrayInfo}));
        }
    }

    public void sendFileLengthMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            Bundle bundle = new Bundle();
            bundle.putLong("filetotalbytes", this.mFileTotalBytes);
            bundle.putString("etag", this.mHeaderETag);
            obtain.setData(bundle);
            sendMessage(obtain);
        }
    }

    public void sendRedirectMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            Message obtain = Message.obtain();
            obtain.what = 7;
            Bundle bundle = new Bundle();
            bundle.putString("redirect_url", str);
            obtain.setData(bundle);
            sendMessage(obtain);
        }
    }

    public long sendResponseMessage(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) throws IOException {
        InterceptResult invokeLL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, iCommonRequestHandler, asyncHttpRequest)) == null) {
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
                    j3 = Long.valueOf(matcher.group(2)).longValue();
                    this.mFileTotalBytes = Long.valueOf(matcher.group(3)).longValue();
                } else {
                    j3 = 0;
                }
                j2 = j3;
            } else {
                this.mSupportRange = false;
                String onGetHttpHeader2 = iCommonRequestHandler.onGetHttpHeader(false);
                this.mtask.mStrRedownload = "server not support resume broken transfer, sc=" + httpStatus + ", headers : \n" + onGetHttpHeader2.toString();
                String onGetResponseHeader2 = iCommonRequestHandler.onGetResponseHeader("Content-Length");
                if (onGetResponseHeader2 != null) {
                    this.mFileTotalBytes = Long.valueOf(onGetResponseHeader2).longValue();
                }
                j2 = 0;
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
            return receiveResponseData(iCommonRequestHandler, j2, httpStatus, asyncHttpRequest);
        }
        return invokeLL.longValue;
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void sendSuccessMessage(int i2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}));
        }
    }

    public void setCurTask(AbstractTask abstractTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, abstractTask) == null) {
            this.mtask = abstractTask;
        }
    }

    public void setRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mRunning = true;
        }
    }

    public void setTestSpeedStage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.mTestSpeedStage = i2;
            if (i2 == 1) {
                this.mTestSpeedStartTime = System.currentTimeMillis();
            }
        }
    }

    public void stopRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mRunning = false;
        }
    }
}
