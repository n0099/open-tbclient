package com.baidu.down.request.taskmanager;

import com.baidu.down.utils.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class HttpDNSInfo implements Comparable<HttpDNSInfo> {
    public static final int STATUS_IP_AVAILABLE = 2;
    public static final int STATUS_IP_INAVAILABLE = 3;
    public static final int STATUS_IP_MEASURING = 1;
    public static final int STATUS_IP_NOT_MEASURE = 0;
    public int mCDNSequence;
    public String mCNDIp;
    public long mDownloadBytes;
    public long mDownloadTimes;
    public int mTestSpeedThread;
    public String mUrl;
    public int mStatus = 0;
    public List<Long> mHttpConnectTime = new ArrayList();
    public int mIsWorking = 0;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(HttpDNSInfo httpDNSInfo) {
        if (this.mDownloadTimes == 0 || this.mTestSpeedThread == 0) {
            return 1;
        }
        if (httpDNSInfo.mDownloadTimes == 0 || httpDNSInfo.mTestSpeedThread == 0) {
            return -1;
        }
        float f = (float) (this.mDownloadBytes / (this.mDownloadTimes * this.mTestSpeedThread));
        float f2 = (float) (httpDNSInfo.mDownloadBytes / (httpDNSInfo.mDownloadTimes * httpDNSInfo.mTestSpeedThread));
        if (f <= f2) {
            if (f == f2 && this.mCDNSequence <= httpDNSInfo.mCDNSequence) {
                return this.mCDNSequence >= httpDNSInfo.mCDNSequence ? 0 : -1;
            }
            return 1;
        }
        return -1;
    }

    public long getTestAverageSpeed() {
        if (this.mDownloadTimes == 0 || this.mTestSpeedThread == 0) {
            return 0L;
        }
        return (this.mDownloadBytes * 1000) / (this.mDownloadTimes * this.mTestSpeedThread);
    }

    public HttpDNSInfo clone(String str, String str2) {
        HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
        try {
            httpDNSInfo.mUrl = str.replace(new URL(str).getHost(), this.mCNDIp);
            if (Utils.isUrlContainsQ(httpDNSInfo.mUrl)) {
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

    public HttpDNSInfo backupHttpDNSInfo() {
        HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
        httpDNSInfo.mCNDIp = this.mCNDIp;
        httpDNSInfo.mDownloadTimes = this.mDownloadTimes;
        httpDNSInfo.mDownloadBytes = this.mDownloadBytes;
        httpDNSInfo.mStatus = this.mStatus;
        httpDNSInfo.mCDNSequence = this.mCDNSequence;
        httpDNSInfo.mTestSpeedThread = this.mTestSpeedThread;
        return httpDNSInfo;
    }
}
