package com.baidu.down.request.taskmanager;

import com.baidu.down.utils.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
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

    public HttpDNSInfo clone(String str, String str2) {
        HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
        try {
            String replace = str.replace(new URL(str).getHost(), this.mCNDIp);
            httpDNSInfo.mUrl = replace;
            if (Utils.isUrlContainsQ(replace)) {
                httpDNSInfo.mUrl += "&xcode=" + str2;
            } else {
                httpDNSInfo.mUrl += "?xcode=" + str2;
            }
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
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

    public long getTestAverageSpeed() {
        int i;
        long j = this.mDownloadTimes;
        if (j == 0 || (i = this.mTestSpeedThread) == 0) {
            return 0L;
        }
        return (this.mDownloadBytes * 1000) / (j * i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(HttpDNSInfo httpDNSInfo) {
        int i;
        int i2;
        int i3;
        int i4;
        long j = this.mDownloadTimes;
        if (j == 0 || (i = this.mTestSpeedThread) == 0) {
            return 1;
        }
        long j2 = httpDNSInfo.mDownloadTimes;
        if (j2 == 0 || (i2 = httpDNSInfo.mTestSpeedThread) == 0) {
            return -1;
        }
        float f2 = (float) (this.mDownloadBytes / (j * i));
        float f3 = (float) (httpDNSInfo.mDownloadBytes / (j2 * i2));
        if (f2 > f3) {
            return -1;
        }
        if (f2 != f3 || (i3 = this.mCDNSequence) > (i4 = httpDNSInfo.mCDNSequence)) {
            return 1;
        }
        return i3 < i4 ? -1 : 0;
    }
}
