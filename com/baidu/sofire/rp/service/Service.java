package com.baidu.sofire.rp.service;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.rp.config.ReportConfigInfo;
import com.baidu.sofire.rp.db.ReportDb;
import com.baidu.sofire.rp.info.ReportItemInfo;
import com.baidu.sofire.rp.info.ReportTopicBean;
import com.baidu.sofire.rp.network.engine.ReportEngine;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.CtrlUtil;
import com.baidu.sofire.utility.HandlerHelper;
import com.baidu.sofire.utility.MD5Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_INIT_CONFIGER = 5;
    public static final int ACTION_RECORD_COMMONS = 4;
    public static final int ACTION_REPORT_ALIVE = 0;
    public static final int ACTION_REPORT_ALL = 9;
    public static final int ACTION_REPORT_DATA = 2;
    public static final int ACTION_REPORT_DELAY = 8;
    public static final int ACTION_REPORT_INIT = 7;
    public static final int ACTION_REPORT_NOW = 6;
    public static final int ACTION_REPORT_REALTIME_LOG = 11;
    public static final int ACTION_REPORT_RECORD = 1;
    public static final int ACTION_REPORT_TRIGGER = 10;
    public static final long TRIGGER_INTERVAL = 180000;
    public static long sFailTime;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastTriggerTime;
    public Context mContext;
    public ReportEngine mEngine;
    public SharedPreferenceManager mPref;
    public Receiver mReceiver;
    public ReportHandler mReportHandler;

    /* loaded from: classes4.dex */
    public class ReportHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Service this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReportHandler(Service service, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {service, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = service;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    switch (message.what) {
                        case 0:
                            this.this$0.reportAlives();
                            return;
                        case 1:
                            ReportDb.getInstance(this.this$0.mContext).insertEvent((ReportItemInfo) message.obj);
                            Message message2 = new Message();
                            message2.what = 10;
                            sendMessage(message2);
                            return;
                        case 2:
                            this.this$0.reportAlives();
                            this.this$0.reportData(0, CommonMethods.getNetworkType(this.this$0.mContext));
                            return;
                        case 3:
                        default:
                            return;
                        case 4:
                            String valueOf = String.valueOf(message.obj);
                            if (TextUtils.isEmpty(valueOf)) {
                                return;
                            }
                            ReportDb.getInstance(this.this$0.mContext).insertCommon(MD5Util.getMD5(valueOf));
                            return;
                        case 5:
                            this.this$0.initOfflineReport();
                            return;
                        case 6:
                            int networkType = CommonMethods.getNetworkType(this.this$0.mContext);
                            if (2 == networkType) {
                                this.this$0.reportData(0, networkType);
                                return;
                            } else {
                                this.this$0.reportData(1, networkType);
                                return;
                            }
                        case 7:
                            this.this$0.reportAlives();
                            int networkType2 = CommonMethods.getNetworkType(this.this$0.mContext);
                            if (2 == networkType2) {
                                this.this$0.reportData(0, networkType2);
                                return;
                            } else {
                                this.this$0.reportData(1, networkType2);
                                return;
                            }
                        case 8:
                            this.this$0.reportData(3, CommonMethods.getNetworkType(this.this$0.mContext));
                            return;
                        case 9:
                            this.this$0.reportData(0, 2);
                            return;
                        case 10:
                            if (System.currentTimeMillis() - this.this$0.lastTriggerTime >= Service.TRIGGER_INTERVAL) {
                                this.this$0.lastTriggerTime = System.currentTimeMillis();
                                int networkType3 = CommonMethods.getNetworkType(this.this$0.mContext);
                                if (2 != networkType3) {
                                    if (1 == networkType3) {
                                        this.this$0.reportData(4, networkType3);
                                        return;
                                    }
                                    return;
                                } else if (ReportDb.getInstance(this.this$0.mContext).getAllReportInfoSize() >= SharedPreferenceManager.getInstance(this.this$0.mContext).getUploadNumberCondition()) {
                                    this.this$0.reportData(0, networkType3);
                                    return;
                                } else {
                                    List<ReportItemInfo> reportDelayData = ReportDb.getInstance(this.this$0.mContext).getReportDelayData(true, networkType3);
                                    if (reportDelayData == null || reportDelayData.size() <= 0) {
                                        return;
                                    }
                                    this.this$0.reportData(0, networkType3);
                                    return;
                                }
                            }
                            return;
                        case 11:
                            String valueOf2 = String.valueOf(message.obj);
                            if (this.this$0.mEngine.report(new JSONArray().put(CommonMethods.createLog(this.this$0.mContext, new JSONObject(valueOf2))).toString(), this.this$0.getReportTopicFromJson(new JSONObject(valueOf2)))) {
                                return;
                            }
                            CommonMethods.s(this.this$0.mContext, valueOf2, false);
                            return;
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1387267234, "Lcom/baidu/sofire/rp/service/Service;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1387267234, "Lcom/baidu/sofire/rp/service/Service;");
        }
    }

    public Service(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.lastTriggerTime = 0L;
        this.mContext = context.getApplicationContext();
        this.mReportHandler = new ReportHandler(this, HandlerHelper.getLooper());
        this.mPref = SharedPreferenceManager.getInstance(this.mContext);
        this.mEngine = new ReportEngine(this.mContext);
    }

    private List<ReportItemInfo> checkAndGetOfflineList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, this, i, i2)) == null) {
            if (i == 0 && i2 == 2) {
                return ReportDb.getInstance(this.mContext).getReportData(i2);
            }
            return null;
        }
        return (List) invokeII.objValue;
    }

    private boolean checkInArray(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.equals(this.mContext.getPackageName())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (str2.equals(jSONArray.get(i))) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean checkReportFail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (sFailTime > 0) {
                if (System.currentTimeMillis() - sFailTime < 300000) {
                    return false;
                }
                sFailTime = 0L;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getReportTopicFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
                if (jSONObject2 != null && jSONObject2.has("12")) {
                    return jSONObject2.optString("12", "");
                }
                return null;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOfflineReport() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(this.mContext);
            int reportPollHour = sharedPreferenceManager.getReportPollHour();
            long currentTimeMillis = System.currentTimeMillis() - sharedPreferenceManager.getReportOffLineTimestap();
            long j = reportPollHour * 3600000;
            if (currentTimeMillis >= j) {
                CtrlUtil.getInstance(this.mContext).report();
                CommonMethods.setUpgradeAlarm(this.mContext, j);
                sharedPreferenceManager.setReportOffLineTimestap(System.currentTimeMillis());
                return;
            }
            CommonMethods.setUpgradeAlarm(this.mContext, j - currentTimeMillis);
        }
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (this.mReceiver == null) {
                this.mReceiver = new Receiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Receiver.ACTION_REPORT_POLL);
            this.mContext.getApplicationContext().registerReceiver(this.mReceiver, intentFilter, this.mContext.getPackageName() + ".permission.sofire.RECEIVE", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAlives() {
        List<ReportConfigInfo> configInfos;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (configInfos = this.mPref.getConfigInfos()) == null) {
            return;
        }
        for (ReportConfigInfo reportConfigInfo : configInfos) {
            if (checkInArray(this.mPref.getAlivePkgs(), reportConfigInfo.pkgName)) {
                reportAliveInfo(reportConfigInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportData(int i, int i2) {
        List<ReportItemInfo> reportData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65553, this, i, i2) == null) && i2 != 0 && checkReportFail()) {
            if (i == 1) {
                reportData = ReportDb.getInstance(this.mContext).getReportPriorData();
            } else if (i == 3) {
                reportData = ReportDb.getInstance(this.mContext).getReportDelayData(false, i2);
            } else if (i == 4) {
                reportData = ReportDb.getInstance(this.mContext).getReportDelayData(true, i2);
            } else {
                reportData = ReportDb.getInstance(this.mContext).getReportData(i2);
            }
            if (reportData == null || reportData.size() <= 0) {
                return;
            }
            long todayReportLen = this.mPref.getTodayReportLen();
            long currentTimeMillis = System.currentTimeMillis();
            long todayReportBeginTime = this.mPref.getTodayReportBeginTime();
            int reportDayLimit = this.mPref.getReportDayLimit();
            if (todayReportBeginTime == 0) {
                this.mPref.setTodayReportBeginTime(currentTimeMillis);
                todayReportBeginTime = currentTimeMillis;
            }
            if (currentTimeMillis - todayReportBeginTime < 86400000) {
                if (i == 3) {
                    int reportDelayDataNum = this.mPref.getReportDelayDataNum();
                    if (reportDelayDataNum >= 5) {
                        return;
                    }
                    this.mPref.setReportDelayDataNum(reportDelayDataNum + 1);
                }
                if (todayReportLen > reportDayLimit * 1048576) {
                    return;
                }
            } else {
                this.mPref.setTodayReportLen(0L);
                this.mPref.setTodayReportBeginTime(currentTimeMillis);
                if (i == 3) {
                    this.mPref.setReportDelayDataNum(0);
                }
            }
            reportDetailData(reportData, i2, todayReportLen);
            if (checkReportFail() && i == 0 && i2 == 2 && reportData.size() >= 100) {
                List<ReportItemInfo> checkAndGetOfflineList = checkAndGetOfflineList(i, i2);
                while (checkAndGetOfflineList != null && checkAndGetOfflineList.size() != 0) {
                    reportDetailData(checkAndGetOfflineList, i2, todayReportLen);
                    if (checkAndGetOfflineList.size() < 100 || !checkReportFail()) {
                        return;
                    }
                    checkAndGetOfflineList = checkAndGetOfflineList(i, i2);
                }
            }
        }
    }

    private void reportDetailData(List<ReportItemInfo> list, int i, long j) {
        JSONObject jSONObject;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{list, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            int reportOneceLimit = this.mPref.getReportOneceLimit();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            for (ReportItemInfo reportItemInfo : list) {
                try {
                    String jSONObject2 = CommonMethods.createLog(this.mContext, new JSONObject(reportItemInfo.data)).toString();
                    try {
                        jSONObject = new JSONObject(jSONObject2);
                        length = jSONObject2.length() + i2;
                    } catch (Exception e2) {
                        CommonMethods.handleNuLException(e2);
                    }
                } catch (Exception e3) {
                    CommonMethods.handleNuLException(e3);
                }
                if (length >= 1048576 * reportOneceLimit) {
                    break;
                }
                arrayList.add(Integer.valueOf(reportItemInfo.id));
                arrayList2.add(new ReportTopicBean(jSONObject, reportItemInfo.reportTopic, reportItemInfo.id));
                i2 = length;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                ReportTopicBean reportTopicBean = (ReportTopicBean) arrayList2.get(i3);
                if (reportTopicBean != null) {
                    String reportTopic = reportTopicBean.getReportTopic();
                    if (TextUtils.isEmpty(reportTopic)) {
                        jSONArray.put(reportTopicBean.getReportContent());
                        arrayList3.add(Integer.valueOf(reportTopicBean.getId()));
                    } else {
                        if (hashMap.containsKey(reportTopic)) {
                            JSONArray jSONArray2 = (JSONArray) hashMap.get(reportTopic);
                            if (jSONArray2 == null) {
                                jSONArray2 = new JSONArray();
                            }
                            jSONArray2.put(reportTopicBean.getReportContent());
                            hashMap.put(reportTopic, jSONArray2);
                        } else {
                            JSONArray jSONArray3 = new JSONArray();
                            jSONArray3.put(reportTopicBean.getReportContent());
                            hashMap.put(reportTopic, jSONArray3);
                        }
                        ArrayList arrayList4 = (ArrayList) hashMap2.get(reportTopic);
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(Integer.valueOf(reportTopicBean.getId()));
                        hashMap2.put(reportTopic, arrayList4);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                if (this.mEngine.report(jSONArray.toString(), null)) {
                    ReportDb.getInstance(this.mContext).deleteEvent(arrayList3);
                } else {
                    sFailTime = System.currentTimeMillis();
                }
            }
            if (hashMap.size() > 0) {
                for (String str : hashMap.keySet()) {
                    JSONArray jSONArray4 = (JSONArray) hashMap.get(str);
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        if (this.mEngine.report(jSONArray4.toString(), str)) {
                            ReportDb.getInstance(this.mContext).deleteEvent((List) hashMap2.get(str));
                        } else {
                            sFailTime = System.currentTimeMillis();
                        }
                    }
                }
            }
            ReportDb.getInstance(this.mContext).deleteOverTimeData();
            if (2 != i) {
                this.mPref.setTodayReportLen(i2 + j);
            }
        }
    }

    public void initReport() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Message message = new Message();
            message.what = 7;
            sendMessage(message);
        }
    }

    public synchronized void reportAliveInfo(ReportConfigInfo reportConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reportConfigInfo) == null) {
            synchronized (this) {
                String reportAliveTime = this.mPref.getReportAliveTime(reportConfigInfo.aliveLogId);
                String dayTime = CommonMethods.getDayTime();
                if (reportAliveTime.equals(dayTime)) {
                    return;
                }
                String aliveData = this.mPref.getAliveData(reportConfigInfo.aliveLogId);
                ReportItemInfo reportItemInfo = new ReportItemInfo();
                reportItemInfo.eventId = reportConfigInfo.aliveLogId;
                reportItemInfo.frequency = 0;
                reportItemInfo.eventType = 2;
                reportItemInfo.timestamp = System.currentTimeMillis();
                reportItemInfo.network = 1;
                reportItemInfo.tag = 5;
                reportItemInfo.data = CommonMethods.createAliveOrInstall(this.mContext, reportConfigInfo, aliveData, true).toString();
                ReportDb.getInstance(this.mContext).insertEvent(reportItemInfo);
                this.mPref.setReportAliveTime(reportConfigInfo.aliveLogId, dayTime);
            }
        }
    }

    public void reportInstallInfo(ReportConfigInfo reportConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, reportConfigInfo) == null) {
            String aliveData = this.mPref.getAliveData(reportConfigInfo.installLogId);
            ReportItemInfo reportItemInfo = new ReportItemInfo();
            reportItemInfo.eventId = reportConfigInfo.installLogId;
            reportItemInfo.frequency = 0;
            reportItemInfo.eventType = 1;
            reportItemInfo.timestamp = System.currentTimeMillis();
            reportItemInfo.network = 1;
            reportItemInfo.data = CommonMethods.createAliveOrInstall(this.mContext, reportConfigInfo, aliveData, false).toString();
            ReportDb.getInstance(this.mContext).insertEvent(reportItemInfo);
            this.mPref.setReportInstall(reportConfigInfo.installLogId, true);
        }
    }

    public void sendMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            this.mReportHandler.sendMessage(message);
        }
    }

    public void start(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            registerReceiver();
            Message message = new Message();
            message.what = 5;
            sendMessage(message);
        }
    }
}
