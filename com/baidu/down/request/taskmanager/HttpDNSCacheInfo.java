package com.baidu.down.request.taskmanager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.loopj.android.http.HttpResponseException;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.utils.Utils;
import com.baidu.sapi2.utils.SapiUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes6.dex */
public class HttpDNSCacheInfo {
    private static final boolean DEBUG = false;
    private static final String TAG = "HttpDNSCacheInfo";
    public String mApn;
    public int mDownFlowLiveTime;
    public String mDownloadUri;
    public String mHost;
    public int mIpLiveTime;
    public String mRequestId;
    public long mRequestTime;
    public List<RetryRequestInfo> mRetryRequestUrl;
    public int mStatus;
    public String mXCode;
    public List<String> mIpList = new ArrayList();
    public TreeSet<HttpDNSInfo> mBackupHttpDNSInfoSet = null;
    public boolean mIsTestSpeed = false;
    public int mMode = -1;
    public long mDownFlowCostTime = -1;

    public boolean isNeedRequest(Context context) {
        return this.mIpList == null || this.mIpList.size() == 0 || SystemClock.elapsedRealtime() - this.mRequestTime >= ((long) this.mIpLiveTime) * 1000 || TextUtils.isEmpty(this.mApn) || !Utils.getWifiOr2gOr3G(context).equals(this.mApn) || TextUtils.isEmpty(this.mHost);
    }

    public boolean isHttpDNSInAvailable(Context context) {
        return this.mStatus == 1 && SystemClock.elapsedRealtime() - this.mRequestTime < ((long) this.mIpLiveTime) * 1000 && !TextUtils.isEmpty(this.mApn) && Utils.getWifiOr2gOr3G(context).equals(this.mApn);
    }

    public boolean isRetryStrategyCacheAvailable(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return this.mIpLiveTime > 0 ? elapsedRealtime - this.mRequestTime < ((long) Math.min(this.mIpLiveTime, this.mDownFlowLiveTime)) * 1000 : elapsedRealtime - this.mRequestTime < ((long) this.mDownFlowLiveTime) * 1000;
    }

    public String getRetryStrategyUrlUseIp(String str, int i) {
        String str2;
        MalformedURLException malformedURLException;
        if (this.mIpList != null && this.mIpList.size() - 1 < i) {
            return null;
        }
        try {
            String replace = str.replace(new URL(str).getHost(), this.mIpList.get(i));
            try {
                if (URLUtil.isHttpsUrl(str)) {
                    replace = replace.replaceFirst(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://");
                }
                if (Utils.isUrlContainsQ(replace)) {
                    return replace + "&xcode=" + this.mXCode;
                }
                return replace + "?xcode=" + this.mXCode;
            } catch (MalformedURLException e) {
                str2 = replace;
                malformedURLException = e;
                malformedURLException.printStackTrace();
                return str2;
            }
        } catch (MalformedURLException e2) {
            str2 = null;
            malformedURLException = e2;
        }
    }

    public List<RetryRequestInfo> getSequenceRetryRequest(String str, Exception exc) {
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        if (exc instanceof UnknownHostException) {
            str2 = getRetryStrategyUrlUseIp(str, 0);
        } else if ((exc instanceof HttpResponseException) || (exc instanceof ConnectTimeoutException) || (exc instanceof RetryStrategyException)) {
            str2 = getRetryStrategyUrlUseIp(str, 1);
        }
        switch (this.mMode) {
            case 4:
                if (!TextUtils.isEmpty(str2)) {
                    RetryRequestInfo retryRequestInfo = new RetryRequestInfo();
                    retryRequestInfo.url = str2;
                    retryRequestInfo.header = new HashMap();
                    retryRequestInfo.header.put("host", this.mHost);
                    arrayList.add(retryRequestInfo);
                }
                if (!Utils.isEmpty(this.mRetryRequestUrl)) {
                    arrayList.addAll(this.mRetryRequestUrl);
                    break;
                }
                break;
            case 5:
                if (!Utils.isEmpty(this.mRetryRequestUrl)) {
                    arrayList.addAll(this.mRetryRequestUrl);
                }
                if (!TextUtils.isEmpty(str2)) {
                    RetryRequestInfo retryRequestInfo2 = new RetryRequestInfo();
                    retryRequestInfo2.url = str2;
                    retryRequestInfo2.header = new HashMap();
                    retryRequestInfo2.header.put("host", this.mHost);
                    arrayList.add(retryRequestInfo2);
                    break;
                }
                break;
            case 6:
                if (!TextUtils.isEmpty(str2)) {
                    RetryRequestInfo retryRequestInfo3 = new RetryRequestInfo();
                    retryRequestInfo3.url = str2;
                    retryRequestInfo3.header = new HashMap();
                    retryRequestInfo3.header.put("host", this.mHost);
                    arrayList.add(retryRequestInfo3);
                    break;
                }
                break;
            case 7:
                if (!Utils.isEmpty(this.mRetryRequestUrl)) {
                    arrayList.addAll(this.mRetryRequestUrl);
                    break;
                }
                break;
        }
        return arrayList;
    }
}
