package com.baidu.down.request.taskmanager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HttpDNSInfo implements Comparable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_IP_AVAILABLE = 2;
    public static final int STATUS_IP_INAVAILABLE = 3;
    public static final int STATUS_IP_MEASURING = 1;
    public static final int STATUS_IP_NOT_MEASURE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCDNSequence;
    public String mCNDIp;
    public long mDownloadBytes;
    public long mDownloadTimes;
    public List mHttpConnectTime;
    public int mIsWorking;
    public int mStatus;
    public int mTestSpeedThread;
    public String mUrl;

    public HttpDNSInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStatus = 0;
        this.mHttpConnectTime = new ArrayList();
        this.mIsWorking = 0;
    }

    public HttpDNSInfo backupHttpDNSInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
            httpDNSInfo.mCNDIp = this.mCNDIp;
            httpDNSInfo.mDownloadTimes = this.mDownloadTimes;
            httpDNSInfo.mDownloadBytes = this.mDownloadBytes;
            httpDNSInfo.mStatus = this.mStatus;
            httpDNSInfo.mCDNSequence = this.mCDNSequence;
            httpDNSInfo.mTestSpeedThread = this.mTestSpeedThread;
            return httpDNSInfo;
        }
        return (HttpDNSInfo) invokeV.objValue;
    }

    public long getTestAverageSpeed() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long j = this.mDownloadTimes;
            if (j == 0 || (i = this.mTestSpeedThread) == 0) {
                return 0L;
            }
            return (this.mDownloadBytes * 1000) / (j * i);
        }
        return invokeV.longValue;
    }

    public HttpDNSInfo clone(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
            try {
                String replace = str.replace(new URL(str).getHost(), this.mCNDIp);
                httpDNSInfo.mUrl = replace;
                if (Utils.isUrlContainsQ(replace)) {
                    httpDNSInfo.mUrl += "&xcode=" + str2;
                } else {
                    httpDNSInfo.mUrl += "?xcode=" + str2;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            httpDNSInfo.mDownloadTimes = this.mDownloadTimes;
            httpDNSInfo.mDownloadBytes = this.mDownloadBytes;
            httpDNSInfo.mStatus = this.mStatus;
            httpDNSInfo.mCDNSequence = this.mCDNSequence;
            httpDNSInfo.mTestSpeedThread = this.mTestSpeedThread;
            httpDNSInfo.mHttpConnectTime = new ArrayList();
            httpDNSInfo.mIsWorking = 0;
            return httpDNSInfo;
        }
        return (HttpDNSInfo) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(HttpDNSInfo httpDNSInfo) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpDNSInfo)) == null) {
            long j = this.mDownloadTimes;
            if (j == 0 || (i = this.mTestSpeedThread) == 0) {
                return 1;
            }
            long j2 = httpDNSInfo.mDownloadTimes;
            if (j2 == 0 || (i2 = httpDNSInfo.mTestSpeedThread) == 0 || ((float) (this.mDownloadBytes / (j * i))) > ((float) (httpDNSInfo.mDownloadBytes / (j2 * i2)))) {
                return -1;
            }
            if (i3 != 0 || (i4 = this.mCDNSequence) > (i5 = httpDNSInfo.mCDNSequence)) {
                return 1;
            }
            if (i4 < i5) {
                return -1;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
