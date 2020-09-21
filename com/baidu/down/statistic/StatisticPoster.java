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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
/* loaded from: classes14.dex */
public final class StatisticPoster {
    private static final boolean DEBUG = false;
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_FINISH = 0;
    public static final int DOWNLOAD_STATUS_PAUSE = 1;
    private static final String TAG = "StatisticPoster";
    private static StatisticPoster instance = null;
    private Context mContext;
    private ScheduledThreadPoolExecutor mNetThreadPool = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1, new NamingThreadFactory(TAG));
    private String mPostContent;
    private String mUrl;

    private StatisticPoster(Context context) {
        this.mContext = null;
        this.mContext = context.getApplicationContext();
    }

    public static StatisticPoster getInstance(Context context) {
        if (instance == null) {
            instance = new StatisticPoster(context);
        }
        return instance;
    }

    public void sendStatisticData(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.mUrl = IdentityManager.getInstance(this.mContext).processCommonParams(DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_LOG_HOST, Constants.PREF_LOG_HOST_DEFAULT)) + "&type=" + i + "&packagename=" + this.mContext.getPackageName();
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
                        if (httpURLConnection.getResponseCode() == 200) {
                        }
                    } catch (Exception e) {
                    }
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public void statisticDownload(AbstractTask abstractTask, int i) {
        String str;
        String str2;
        MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = (MultiSrcBinaryTaskHandler) abstractTask.mTaskHandler;
        long elapsedRealtime = SystemClock.elapsedRealtime() - abstractTask.mStartTime;
        long currentLength = abstractTask.mProgressInfo.getCurrentLength() - abstractTask.mCurLength;
        long j = abstractTask.mTotalLength;
        TreeSet<HttpDNSInfo> priorityDownloadIpInfoSet = ((MultiSrcBinaryReqTask) abstractTask).getPriorityDownloadIpInfoSet();
        String str3 = "";
        if (priorityDownloadIpInfoSet != null && !priorityDownloadIpInfoSet.isEmpty()) {
            Iterator<HttpDNSInfo> it = priorityDownloadIpInfoSet.iterator();
            while (true) {
                String str4 = str3;
                if (it.hasNext()) {
                    HttpDNSInfo next = it.next();
                    String str5 = next.mCDNSequence + UgcConstant.AT_RULE_TAG;
                    try {
                        str5 = str5 + new URI(next.mUrl).getHost() + UgcConstant.AT_RULE_TAG;
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    switch (next.mStatus) {
                        case 2:
                            String str6 = str5 + "0@";
                            if (next.mDownloadTimes == 0) {
                                str2 = str6 + "0@";
                            } else {
                                str2 = str6 + next.getTestAverageSpeed() + UgcConstant.AT_RULE_TAG;
                            }
                            if (next.mHttpConnectTime != null && next.mHttpConnectTime.size() > 0) {
                                long j2 = 0;
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 < next.mHttpConnectTime.size()) {
                                        j2 += next.mHttpConnectTime.get(i3).longValue();
                                        i2 = i3 + 1;
                                    } else {
                                        str = str2 + (j2 / next.mHttpConnectTime.size());
                                        break;
                                    }
                                }
                            } else {
                                str = str2 + "-1";
                                break;
                            }
                            break;
                        case 3:
                            str = str5 + "1@-1@-1";
                            break;
                        default:
                            str = str5 + "2@-1@-1";
                            break;
                    }
                    str3 = str4 + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP;
                } else {
                    str3 = str4;
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cstatus", multiSrcBinaryTaskHandler.mMultiSrcStatData.cstatus + "");
            jSONObject.put("ccost", multiSrcBinaryTaskHandler.mMultiSrcStatData.ccost + "");
            jSONObject.put("dfstat", multiSrcBinaryTaskHandler.mMultiSrcStatData.dfstat + "");
            jSONObject.put("dfcost", multiSrcBinaryTaskHandler.mMultiSrcStatData.dfcost + "");
            jSONObject.put("dyget", multiSrcBinaryTaskHandler.mMultiSrcStatData.dyget + "");
            jSONObject.put("dyuse", multiSrcBinaryTaskHandler.mMultiSrcStatData.dyuse + "");
            jSONObject.put("cinfo", str3);
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
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SID, "0");
            } else {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SID, multiSrcBinaryTaskHandler.mMultiSrcStatData.sid);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        sendStatisticData(jSONObject.toString(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<NameValuePair> getPostData(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("data", encodeData(str)));
        return arrayList;
    }

    public static String encodeData(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            return Base64.encodeToString(bArr, 0);
        }
        return null;
    }
}
