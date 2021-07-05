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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
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
/* loaded from: classes3.dex */
public final class StatisticPoster {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_FINISH = 0;
    public static final int DOWNLOAD_STATUS_PAUSE = 1;
    public static final String TAG = "StatisticPoster";
    public static StatisticPoster instance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public ScheduledThreadPoolExecutor mNetThreadPool;
    public String mPostContent;
    public String mUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-232244004, "Lcom/baidu/down/statistic/StatisticPoster;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-232244004, "Lcom/baidu/down/statistic/StatisticPoster;");
        }
    }

    public StatisticPoster(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mContext = context.getApplicationContext();
        this.mNetThreadPool = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1, new NamingThreadFactory(TAG));
    }

    public static String encodeData(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static StatisticPoster getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (instance == null) {
                instance = new StatisticPoster(context);
            }
            return instance;
        }
        return (StatisticPoster) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<NameValuePair> getPostData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("data", encodeData(str)));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void sendStatisticData(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String processCommonParams = IdentityManager.getInstance(this.mContext).processCommonParams(DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_LOG_HOST, Constants.PREF_LOG_HOST_DEFAULT));
        this.mUrl = processCommonParams + "&type=" + i2 + "&packagename=" + this.mContext.getPackageName();
        this.mPostContent = str;
        this.mNetThreadPool.schedule(new Runnable(this) { // from class: com.baidu.down.statistic.StatisticPoster.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ StatisticPoster this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        ProxyURLConnection proxyURLConnection = new ProxyURLConnection(this.this$0.mContext, false);
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                        HttpURLConnection httpURLConnection = proxyURLConnection.getHttpURLConnection(this.this$0.mUrl, hashMap, "POST", this.this$0.getPostData(this.this$0.mPostContent), false, false);
                        httpURLConnection.connect();
                        httpURLConnection.getResponseCode();
                    } catch (Exception unused) {
                    }
                }
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    public void statisticDownload(AbstractTask abstractTask, int i2) {
        long j;
        String str;
        long j2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractTask, i2) == null) {
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
                    String str3 = next.mCDNSequence + TNCManager.TNC_PROBE_HEADER_SECEPTOR;
                    try {
                        str3 = str3 + new URI(next.mUrl).getHost() + TNCManager.TNC_PROBE_HEADER_SECEPTOR;
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                    int i3 = next.mStatus;
                    if (i3 != 2) {
                        str2 = i3 != 3 ? str3 + "2@-1@-1" : str3 + "1@-1@-1";
                        j2 = j3;
                    } else {
                        String str4 = str3 + "0@";
                        j2 = j3;
                        long j4 = 0;
                        String str5 = next.mDownloadTimes == 0 ? str4 + "0@" : str4 + next.getTestAverageSpeed() + TNCManager.TNC_PROBE_HEADER_SECEPTOR;
                        List<Long> list = next.mHttpConnectTime;
                        if (list != null && list.size() > 0) {
                            for (int i4 = 0; i4 < next.mHttpConnectTime.size(); i4++) {
                                j4 += next.mHttpConnectTime.get(i4).longValue();
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
            sendStatisticData(jSONObject.toString(), i2);
        }
    }
}
