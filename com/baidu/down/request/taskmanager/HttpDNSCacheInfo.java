package com.baidu.down.request.taskmanager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.HttpResponseException;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes2.dex */
public class HttpDNSCacheInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "HttpDNSCacheInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public String mApn;
    public TreeSet mBackupHttpDNSInfoSet;
    public long mDownFlowCostTime;
    public int mDownFlowLiveTime;
    public String mDownloadUri;
    public String mHost;
    public List mIpList;
    public int mIpLiveTime;
    public boolean mIsTestSpeed;
    public int mMode;
    public String mRequestId;
    public long mRequestTime;
    public List mRetryRequestUrl;
    public int mStatus;
    public String mXCode;

    public HttpDNSCacheInfo() {
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
        this.mIpList = new ArrayList();
        this.mBackupHttpDNSInfoSet = null;
        this.mIsTestSpeed = false;
        this.mMode = -1;
        this.mDownFlowCostTime = -1L;
    }

    public String getRetryStrategyUrlUseIp(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            List list = this.mIpList;
            if (list != null && list.size() - 1 < i) {
                return null;
            }
            try {
                String replace = str.replace(new URL(str).getHost(), (CharSequence) this.mIpList.get(i));
                if (URLUtil.isHttpsUrl(str)) {
                    replace = replace.replaceFirst("https://", "http://");
                }
                if (Utils.isUrlContainsQ(replace)) {
                    return replace + "&xcode=" + this.mXCode;
                }
                return replace + "?xcode=" + this.mXCode;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeLI.objValue;
    }

    public List getSequenceRetryRequest(String str, Exception exc) {
        InterceptResult invokeLL;
        String retryStrategyUrlUseIp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, exc)) == null) {
            ArrayList arrayList = new ArrayList();
            if (exc instanceof UnknownHostException) {
                retryStrategyUrlUseIp = getRetryStrategyUrlUseIp(str, 0);
            } else if (!(exc instanceof HttpResponseException) && !(exc instanceof ConnectTimeoutException) && !(exc instanceof RetryStrategyException)) {
                retryStrategyUrlUseIp = null;
            } else {
                retryStrategyUrlUseIp = getRetryStrategyUrlUseIp(str, 1);
            }
            int i = this.mMode;
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        if (i == 7 && !Utils.isEmpty(this.mRetryRequestUrl)) {
                            arrayList.addAll(this.mRetryRequestUrl);
                        }
                    } else if (!TextUtils.isEmpty(retryStrategyUrlUseIp)) {
                        RetryRequestInfo retryRequestInfo = new RetryRequestInfo();
                        retryRequestInfo.url = retryStrategyUrlUseIp;
                        HashMap hashMap = new HashMap();
                        retryRequestInfo.header = hashMap;
                        hashMap.put("host", this.mHost);
                        arrayList.add(retryRequestInfo);
                    }
                } else {
                    if (!Utils.isEmpty(this.mRetryRequestUrl)) {
                        arrayList.addAll(this.mRetryRequestUrl);
                    }
                    if (!TextUtils.isEmpty(retryStrategyUrlUseIp)) {
                        RetryRequestInfo retryRequestInfo2 = new RetryRequestInfo();
                        retryRequestInfo2.url = retryStrategyUrlUseIp;
                        HashMap hashMap2 = new HashMap();
                        retryRequestInfo2.header = hashMap2;
                        hashMap2.put("host", this.mHost);
                        arrayList.add(retryRequestInfo2);
                    }
                }
            } else {
                if (!TextUtils.isEmpty(retryStrategyUrlUseIp)) {
                    RetryRequestInfo retryRequestInfo3 = new RetryRequestInfo();
                    retryRequestInfo3.url = retryStrategyUrlUseIp;
                    HashMap hashMap3 = new HashMap();
                    retryRequestInfo3.header = hashMap3;
                    hashMap3.put("host", this.mHost);
                    arrayList.add(retryRequestInfo3);
                }
                if (!Utils.isEmpty(this.mRetryRequestUrl)) {
                    arrayList.addAll(this.mRetryRequestUrl);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean isHttpDNSInAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(context);
            if (this.mStatus == 1 && elapsedRealtime - this.mRequestTime < this.mIpLiveTime * 1000 && !TextUtils.isEmpty(this.mApn) && wifiOr2gOr3G.equals(this.mApn)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isRetryStrategyCacheAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = this.mIpLiveTime;
            if (i > 0) {
                if (elapsedRealtime - this.mRequestTime < Math.min(i, this.mDownFlowLiveTime) * 1000) {
                    return true;
                }
                return false;
            } else if (elapsedRealtime - this.mRequestTime < this.mDownFlowLiveTime * 1000) {
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isNeedRequest(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(context);
            List list = this.mIpList;
            if (list != null && list.size() != 0 && elapsedRealtime - this.mRequestTime < this.mIpLiveTime * 1000 && !TextUtils.isEmpty(this.mApn) && wifiOr2gOr3G.equals(this.mApn) && !TextUtils.isEmpty(this.mHost)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
