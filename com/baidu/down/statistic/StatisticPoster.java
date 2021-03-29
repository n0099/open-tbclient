package com.baidu.down.statistic;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.down.common.BasicNameValuePair;
import com.baidu.down.common.NameValuePair;
import com.baidu.down.loopj.android.http.MultiSrcBinaryTaskHandler;
import com.baidu.down.loopj.android.urlconnection.ProxyURLConnection;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.task.MultiSrcBinaryReqTask;
import com.baidu.down.request.taskmanager.HttpDNSInfo;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.IdentityManager;
import com.baidu.down.utils.NamingThreadFactory;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class StatisticPoster {
    public static final boolean DEBUG = false;
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_FINISH = 0;
    public static final int DOWNLOAD_STATUS_PAUSE = 1;
    public static final String TAG = "StatisticPoster";
    public static StatisticPoster instance;
    public Context mContext;
    public ScheduledThreadPoolExecutor mNetThreadPool = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1, new NamingThreadFactory(TAG));
    public String mPostContent;
    public String mUrl;

    public StatisticPoster(Context context) {
        this.mContext = null;
        this.mContext = context.getApplicationContext();
    }

    public static String encodeData(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            return Base64.encodeToString(bArr, 0);
        }
        return null;
    }

    public static StatisticPoster getInstance(Context context) {
        if (instance == null) {
            instance = new StatisticPoster(context);
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<NameValuePair> getPostData(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("data", encodeData(str)));
        return arrayList;
    }

    public void sendStatisticData(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String processCommonParams = IdentityManager.getInstance(this.mContext).processCommonParams(DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_LOG_HOST, Constants.PREF_LOG_HOST_DEFAULT));
        this.mUrl = processCommonParams + "&type=" + i + "&packagename=" + this.mContext.getPackageName();
        this.mPostContent = str;
        this.mNetThreadPool.schedule(new Runnable() { // from class: com.baidu.down.statistic.StatisticPoster.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ProxyURLConnection proxyURLConnection = new ProxyURLConnection(StatisticPoster.this.mContext, false);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                    HttpURLConnection httpURLConnection = proxyURLConnection.getHttpURLConnection(StatisticPoster.this.mUrl, hashMap, "POST", StatisticPoster.this.getPostData(StatisticPoster.this.mPostContent), false, false);
                    httpURLConnection.connect();
                    httpURLConnection.getResponseCode();
                } catch (Exception unused) {
                }
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    public void statisticDownload(AbstractTask abstractTask, int i) {
        long j;
        String str;
        long j2;
        String str2;
        MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = (MultiSrcBinaryTaskHandler) abstractTask.mTaskHandler;
        long elapsedRealtime = SystemClock.elapsedRealtime() - abstractTask.mStartTime;
        long currentLength = abstractTask.mProgressInfo.getCurrentLength() - abstractTask.mCurLength;
        long j3 = abstractTask.mTotalLength;
        TreeSet<HttpDNSInfo> priorityDownloadIpInfoSet = ((MultiSrcBinaryReqTask) abstractTask).getPriorityDownloadIpInfoSet();
        if (priorityDownloadIpInfoSet == null || priorityDownloadIpInfoSet.isEmpty()) {
            j = j3;
            str = "";
        } else {
            Iterator<HttpDNSInfo> it = priorityDownloadIpInfoSet.iterator();
            str = "";
            while (it.hasNext()) {
                HttpDNSInfo next = it.next();
                String str3 = next.mCDNSequence + "@";
                try {
                    str3 = str3 + new URI(next.mUrl).getHost() + "@";
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
                int i2 = next.mStatus;
                if (i2 != 2) {
                    str2 = i2 != 3 ? str3 + "2@-1@-1" : str3 + "1@-1@-1";
                    j2 = j3;
                } else {
                    String str4 = str3 + "0@";
                    j2 = j3;
                    long j4 = 0;
                    String str5 = next.mDownloadTimes == 0 ? str4 + "0@" : str4 + next.getTestAverageSpeed() + "@";
                    List<Long> list = next.mHttpConnectTime;
                    if (list != null && list.size() > 0) {
                        for (int i3 = 0; i3 < next.mHttpConnectTime.size(); i3++) {
                            j4 += next.mHttpConnectTime.get(i3).longValue();
                        }
                        str2 = str5 + (j4 / next.mHttpConnectTime.size());
                    } else {
                        str2 = str5 + "-1";
                    }
                }
                str = str + str2 + ",";
                j3 = j2;
            }
            j = j3;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cstatus", multiSrcBinaryTaskHandler.mMultiSrcStatData.cstatus + "");
            jSONObject.put("ccost", multiSrcBinaryTaskHandler.mMultiSrcStatData.ccost + "");
            jSONObject.put("dfstat", multiSrcBinaryTaskHandler.mMultiSrcStatData.dfstat + "");
            jSONObject.put("dfcost", multiSrcBinaryTaskHandler.mMultiSrcStatData.dfcost + "");
            jSONObject.put("dyget", multiSrcBinaryTaskHandler.mMultiSrcStatData.dyget + "");
            jSONObject.put("dyuse", multiSrcBinaryTaskHandler.mMultiSrcStatData.dyuse + "");
            jSONObject.put("cinfo", str);
            jSONObject.put("cuseip", ((MultiSrcBinaryReqTask) abstractTask).getWorkingDownloadIpInfoStat());
            jSONObject.put("tnum", multiSrcBinaryTaskHandler.mMultiSrcStatData.tnum + "");
            jSONObject.put("dcost", elapsedRealtime + "");
            jSONObject.put("dnowsize", currentLength + "");
            jSONObject.put("dallsize", j + "");
            jSONObject.put("network", multiSrcBinaryTaskHandler.mMultiSrcStatData.network);
            jSONObject.put("dtest", multiSrcBinaryTaskHandler.mMultiSrcStatData.dtest + "");
            jSONObject.put("dbtype", multiSrcBinaryTaskHandler.mMultiSrcStatData.dbtype + "");
            jSONObject.put("dlib", "1");
            if (TextUtils.isEmpty(multiSrcBinaryTaskHandler.mMultiSrcStatData.sid)) {
                jSONObject.put("sid", "0");
            } else {
                jSONObject.put("sid", multiSrcBinaryTaskHandler.mMultiSrcStatData.sid);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        sendStatisticData(jSONObject.toString(), i);
    }
}
