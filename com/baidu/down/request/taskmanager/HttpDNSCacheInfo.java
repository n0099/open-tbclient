package com.baidu.down.request.taskmanager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.loopj.android.http.HttpResponseException;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.utils.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes.dex */
public class HttpDNSCacheInfo {
    public static final boolean DEBUG = false;
    public static final String TAG = "HttpDNSCacheInfo";
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

    public String getRetryStrategyUrlUseIp(String str, int i) {
        List<String> list = this.mIpList;
        if (list == null || list.size() - 1 >= i) {
            try {
                String replace = str.replace(new URL(str).getHost(), this.mIpList.get(i));
                if (URLUtil.isHttpsUrl(str)) {
                    replace = replace.replaceFirst("https://", "http://");
                }
                if (Utils.isUrlContainsQ(replace)) {
                    return replace + "&xcode=" + this.mXCode;
                }
                return replace + "?xcode=" + this.mXCode;
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public List<RetryRequestInfo> getSequenceRetryRequest(String str, Exception exc) {
        String retryStrategyUrlUseIp;
        ArrayList arrayList = new ArrayList();
        if (exc instanceof UnknownHostException) {
            retryStrategyUrlUseIp = getRetryStrategyUrlUseIp(str, 0);
        } else {
            retryStrategyUrlUseIp = ((exc instanceof HttpResponseException) || (exc instanceof ConnectTimeoutException) || (exc instanceof RetryStrategyException)) ? getRetryStrategyUrlUseIp(str, 1) : null;
        }
        int i = this.mMode;
        if (i == 4) {
            if (!TextUtils.isEmpty(retryStrategyUrlUseIp)) {
                RetryRequestInfo retryRequestInfo = new RetryRequestInfo();
                retryRequestInfo.url = retryStrategyUrlUseIp;
                HashMap hashMap = new HashMap();
                retryRequestInfo.header = hashMap;
                hashMap.put("host", this.mHost);
                arrayList.add(retryRequestInfo);
            }
            if (!Utils.isEmpty(this.mRetryRequestUrl)) {
                arrayList.addAll(this.mRetryRequestUrl);
            }
        } else if (i == 5) {
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
        } else if (i != 6) {
            if (i == 7 && !Utils.isEmpty(this.mRetryRequestUrl)) {
                arrayList.addAll(this.mRetryRequestUrl);
            }
        } else if (!TextUtils.isEmpty(retryStrategyUrlUseIp)) {
            RetryRequestInfo retryRequestInfo3 = new RetryRequestInfo();
            retryRequestInfo3.url = retryStrategyUrlUseIp;
            HashMap hashMap3 = new HashMap();
            retryRequestInfo3.header = hashMap3;
            hashMap3.put("host", this.mHost);
            arrayList.add(retryRequestInfo3);
        }
        return arrayList;
    }

    public boolean isHttpDNSInAvailable(Context context) {
        return this.mStatus == 1 && SystemClock.elapsedRealtime() - this.mRequestTime < ((long) this.mIpLiveTime) * 1000 && !TextUtils.isEmpty(this.mApn) && Utils.getWifiOr2gOr3G(context).equals(this.mApn);
    }

    public boolean isNeedRequest(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(context);
        List<String> list = this.mIpList;
        return list == null || list.size() == 0 || elapsedRealtime - this.mRequestTime >= ((long) this.mIpLiveTime) * 1000 || TextUtils.isEmpty(this.mApn) || !wifiOr2gOr3G.equals(this.mApn) || TextUtils.isEmpty(this.mHost);
    }

    public boolean isRetryStrategyCacheAvailable(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = this.mIpLiveTime;
        return i > 0 ? elapsedRealtime - this.mRequestTime < ((long) Math.min(i, this.mDownFlowLiveTime)) * 1000 : elapsedRealtime - this.mRequestTime < ((long) this.mDownFlowLiveTime) * 1000;
    }
}
