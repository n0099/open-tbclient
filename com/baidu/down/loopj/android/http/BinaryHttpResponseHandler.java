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
import com.baidubce.http.Headers;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
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

    public void handleRedirectUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void onDownload(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, byteArrayInfo) == null) {
        }
    }

    public void onFileLengthRec(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048591, this, j, str) == null) {
        }
    }

    public void onPaused(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    public void onSuccess(byte[] bArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, bArr, j) == null) {
        }
    }

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

    public void cleanDomainNameAndIpInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDomainNameAndIpList = new CopyOnWriteArrayList();
        }
    }

    public List<UrlDNSInfo> getDomainNameAndIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDomainNameAndIpList;
        }
        return (List) invokeV.objValue;
    }

    public long getFileLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFileTotalBytes;
        }
        return invokeV.longValue;
    }

    public int getTestSpeedStage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mTestSpeedStage;
        }
        return invokeV.intValue;
    }

    public long getTestSpeedStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTestSpeedStartTime;
        }
        return invokeV.longValue;
    }

    public long getTotalLen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.totalLen;
        }
        return invokeV.longValue;
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

    public void setRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mRunning = true;
        }
    }

    public void stopRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mRunning = false;
        }
    }

    public BinaryHttpResponseHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public void handleDownloadMessage(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, byteArrayInfo) == null) {
            onDownload(byteArrayInfo);
        }
    }

    public void handlePausedMessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            onPaused(i);
        }
    }

    public void sendDownloadMessage(ByteArrayInfo byteArrayInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, byteArrayInfo) == null) {
            sendMessage(obtainMessage(4, new Object[]{byteArrayInfo}));
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

    public void setCurTask(AbstractTask abstractTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, abstractTask) == null) {
            this.mtask = abstractTask;
        }
    }

    public void setTestSpeedStage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.mTestSpeedStage = i;
            if (i == 1) {
                this.mTestSpeedStartTime = System.currentTimeMillis();
            }
        }
    }

    public void handleFailureMessage(Throwable th, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048583, this, th, bArr, i) == null) {
            onFailure(th, bArr, i);
        }
    }

    public void handleSuccessMessage(int i, byte[] bArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), bArr, Long.valueOf(j)}) == null) {
            onSuccess(i, bArr, j);
        }
    }

    public void onFailure(Throwable th, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048590, this, th, bArr, i) == null) {
            onFailure(th, i);
        }
    }

    public void onSuccess(int i, byte[] bArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), bArr, Long.valueOf(j)}) == null) {
            onSuccess(bArr, j);
        }
    }

    public void handleFileLengthMessage(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, str) == null) {
            onFileLengthRec(j, str);
        }
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, message) == null) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                    super.handleMessage(message);
                                    return;
                                } else if (message.getData() != null) {
                                    handleRedirectUrl(message.getData().getString("redirect_url", ""));
                                    return;
                                } else {
                                    return;
                                }
                            }
                            Bundle data = message.getData();
                            handleFileLengthMessage(data.getLong("filetotalbytes"), data.getString("etag"));
                            return;
                        }
                        Object obj = message.obj;
                        if (obj == null) {
                            handlePausedMessage(0);
                            return;
                        } else {
                            handlePausedMessage(((Integer) obj).intValue());
                            return;
                        }
                    }
                    handleDownloadMessage((ByteArrayInfo) ((Object[]) message.obj)[0]);
                    return;
                }
                Object[] objArr = (Object[]) message.obj;
                if (objArr[0] != null && objArr[1] != null) {
                    handleFailureMessage((Throwable) objArr[0], objArr[1].toString(), ((Integer) objArr[2]).intValue());
                    return;
                } else if (objArr[1] == null) {
                    handleFailureMessage((Throwable) objArr[0], "error", ((Integer) objArr[2]).intValue());
                    return;
                } else if (objArr[0] == null) {
                    handleFailureMessage((Throwable) null, objArr[1].toString(), ((Integer) objArr[2]).intValue());
                    return;
                } else {
                    handleFailureMessage((Throwable) null, "error", ((Integer) objArr[2]).intValue());
                    return;
                }
            }
            Object[] objArr2 = (Object[]) message.obj;
            handleSuccessMessage(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Long) objArr2[2]).longValue());
        }
    }

    /* JADX DEBUG: Incorrect finally slice size: {[IF, INVOKE, INVOKE, IGET, INVOKE, IPUT, INVOKE, INVOKE, IGET] complete}, expected: {[IF, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    public long receiveResponseData(ICommonRequestHandler iCommonRequestHandler, long j, int i, AsyncHttpRequest asyncHttpRequest) throws IOException {
        InterceptResult invokeCommon;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{iCommonRequestHandler, Long.valueOf(j), Integer.valueOf(i), asyncHttpRequest})) == null) {
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
                            if (read <= i2) {
                                i2 = read;
                            }
                            if (byteArray.mByteArrayLength + i2 >= length) {
                                System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i2);
                                byteArray.mByteArrayLength += i2;
                                sendDownloadMessage(byteArray);
                                j += i2;
                                byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                                byteArray.mFilePos = j;
                                byteArray.mByteArrayLength = 0;
                            } else {
                                System.arraycopy(bArr, 0, byteArray.mByteArray, byteArray.mByteArrayLength, i2);
                                byteArray.mByteArrayLength += i2;
                                j += i2;
                            }
                            if (i2 < read) {
                                int i3 = read - i2;
                                System.arraycopy(bArr, i2, byteArray.mByteArray, byteArray.mByteArrayLength, i3);
                                byteArray.mByteArrayLength += i3;
                                j += i3;
                            }
                            if (threadSpeedStat != null) {
                                threadSpeedStat.dTempDownSize = j;
                            }
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

    public long sendResponseMessage(ICommonRequestHandler iCommonRequestHandler, AsyncHttpRequest asyncHttpRequest) throws IOException {
        InterceptResult invokeLL;
        long j;
        long j2;
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
            this.mHeaderETag = iCommonRequestHandler.onGetResponseHeader(Headers.ETAG);
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
        return invokeLL.longValue;
    }

    @Override // com.baidu.down.loopj.android.http.AsyncHttpResponseHandler
    public void sendSuccessMessage(int i, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)}) == null) {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)}));
        }
    }
}
