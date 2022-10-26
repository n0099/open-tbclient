package com.baidu.rtc.logreport;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.rtc.config.Constraints;
import com.baidu.rtc.utils.CommonUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Logging;
import org.webrtc.StatsReport;
/* loaded from: classes2.dex */
public class RtcReportHandle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMMUNICATION_REPORT_INTERVAL = 2000;
    public static final int DEVICEINFO_REPORT_INTERVAL = 300000;
    public static final int INTERNAL_STATES_INTERVAL = 200;
    public static final int SLI_REPORT_INTERVAL = 5000;
    public static final String TAG = "RtcReportHandle";
    public static RtcReportHandle instance = null;
    public static boolean mIsEnableErrorInfoMonitor = false;
    public static boolean mIsEnableInternalStatesMonitor = true;
    public static boolean mIsEnablePullQualityMonitor = true;
    public static boolean mIsEnablePushQualityMonitor;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppId;
    public WeakReference mContext;
    public final CpuMonitor mCpuMonitor;
    public final ErrorInfoReport mErrorInfoReport;
    public String mFeedId;
    public ConcurrentHashMap mHUDStatisticsMap;
    public String mHandleId;
    public Handler mHandler;
    public final HandlerThread mHandlerThread;
    public boolean mIsDeviceInfoReporting;
    public BigInteger mPublisherHandle;
    public String mQualityMonitorEnv;
    public String mRoomId;
    public final RtcLogReport mRtcLogReport;
    public String mSessionId;
    public long mUserId;
    public Runnable reportDeviceInfoRun;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1895629519, "Lcom/baidu/rtc/logreport/RtcReportHandle;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1895629519, "Lcom/baidu/rtc/logreport/RtcReportHandle;");
        }
    }

    /* loaded from: classes2.dex */
    public class AudioStuckEvent implements SLIReportInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RtcReportHandle this$0;

        public AudioStuckEvent(RtcReportHandle rtcReportHandle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rtcReportHandle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rtcReportHandle;
        }

        @Override // com.baidu.rtc.logreport.SLIReportInterface
        public void onStuckData(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && RtcReportHandle.mIsEnablePullQualityMonitor) {
                for (Map.Entry entry : this.this$0.mHUDStatisticsMap.entrySet()) {
                    if (entry.getKey() != this.this$0.mPublisherHandle && entry.getValue() != null) {
                        ((HUDStatistics) entry.getValue()).addAudioStuckData(j, j2);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class VideoStuckEvent implements SLIReportInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BigInteger handleId;
        public final /* synthetic */ RtcReportHandle this$0;

        public VideoStuckEvent(RtcReportHandle rtcReportHandle, BigInteger bigInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rtcReportHandle, bigInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rtcReportHandle;
            this.handleId = bigInteger;
        }

        @Override // com.baidu.rtc.logreport.SLIReportInterface
        public void onStuckData(long j, long j2) {
            HUDStatistics hUDStatistics;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && RtcReportHandle.mIsEnablePullQualityMonitor && this.handleId != null && (hUDStatistics = (HUDStatistics) this.this$0.mHUDStatisticsMap.get(this.handleId)) != null) {
                hUDStatistics.addVideoStuckData(j, j2);
            }
        }
    }

    public RtcReportHandle(Context context) {
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
        this.mContext = null;
        this.mIsDeviceInfoReporting = false;
        this.mQualityMonitorEnv = "online";
        this.mHUDStatisticsMap = new ConcurrentHashMap();
        this.mPublisherHandle = new BigInteger("0");
        this.mUserId = -1L;
        this.reportDeviceInfoRun = new Runnable(this) { // from class: com.baidu.rtc.logreport.RtcReportHandle.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RtcReportHandle this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mRtcLogReport != null && (RtcReportHandle.mIsEnablePushQualityMonitor || RtcReportHandle.mIsEnablePullQualityMonitor)) {
                        this.this$0.reportDeviceInfo();
                    }
                    this.this$0.mHandler.postDelayed(this.this$0.reportDeviceInfoRun, 300000L);
                }
            }
        };
        this.mContext = new WeakReference(context);
        this.mCpuMonitor = new CpuMonitor(context);
        HandlerThread handlerThread = new HandlerThread("" + RtcReportHandle.class.getSimpleName());
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mRtcLogReport = RtcLogReport.getInstance();
        ErrorInfoReport errorInfoReport = ErrorInfoReport.getInstance();
        this.mErrorInfoReport = errorInfoReport;
        errorInfoReport.setVersion(Constraints.sdkVersion());
    }

    public static synchronized RtcReportHandle getInstance(Context context) {
        InterceptResult invokeL;
        RtcReportHandle rtcReportHandle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            synchronized (RtcReportHandle.class) {
                if (instance == null) {
                    instance = new RtcReportHandle(context);
                }
                rtcReportHandle = instance;
            }
            return rtcReportHandle;
        }
        return (RtcReportHandle) invokeL.objValue;
    }

    public HUDStatistics getStreamingStats(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bigInteger)) == null) {
            if (bigInteger == null) {
                return null;
            }
            return (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger);
        }
        return (HUDStatistics) invokeL.objValue;
    }

    public void onPeerStatisticsReport(PeerConnectionClient.StatsEventsType statsEventsType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, statsEventsType) == null) {
            if ((mIsEnablePushQualityMonitor || mIsEnablePullQualityMonitor) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
                reportCommunicationQualityInfo();
            } else if ((mIsEnablePushQualityMonitor || mIsEnablePullQualityMonitor) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT) {
                reportSLIStuckInfo();
            }
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mUserId = j;
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacks(this.reportDeviceInfoRun);
            }
            instance = null;
        }
    }

    public void startDeviceInfoReport() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (handler = this.mHandler) != null && !this.mIsDeviceInfoReporting) {
            this.mIsDeviceInfoReporting = true;
            handler.post(this.reportDeviceInfoRun);
        }
    }

    public static void enableMonitor(boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            mIsEnableInternalStatesMonitor = z;
            mIsEnablePullQualityMonitor = z2;
            mIsEnableErrorInfoMonitor = z3;
            mIsEnablePushQualityMonitor = z4;
        }
    }

    private void reportCommunicationQualityInfo() {
        boolean z;
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            HashMap hashMap = new HashMap();
            HUDStatistics hUDStatistics2 = (HUDStatistics) this.mHUDStatisticsMap.get(this.mPublisherHandle);
            if (hUDStatistics2 == null) {
                z = false;
            } else {
                hUDStatistics2.getStatsSendInfo(hashMap);
                z = true;
            }
            if (hashMap.size() == 0) {
                z = false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", 2);
                JSONObject jSONObject3 = new JSONObject();
                if (this.mCpuMonitor != null) {
                    jSONObject3.put("sysCpuUsage", this.mCpuMonitor.getFrequencyScaleAverage());
                }
                jSONObject3.put("appCpuUsage", 0);
                jSONObject2.put("resourceUsageInfo", jSONObject3);
                if (mIsEnablePushQualityMonitor) {
                    JSONObject jSONObject4 = new JSONObject();
                    if (z) {
                        jSONObject4.put("bitrate", hashMap.get("bitrate_s"));
                        jSONObject4.put("packetloss", hashMap.get("packetloss_s"));
                        jSONObject4.put("cfps", hashMap.get("fps_s"));
                        jSONObject4.put(FpsConstants.REPORT_FPS, hashMap.get("fps_i"));
                        if (hUDStatistics2 == null) {
                            jSONObject4.put("resolution", "");
                        } else {
                            jSONObject4.put("resolution", hUDStatistics2.getSendResolution());
                        }
                    } else {
                        jSONObject4.put("bitrate", 0);
                        jSONObject4.put("packetloss", 0);
                        jSONObject4.put(FpsConstants.REPORT_FPS, 0);
                        jSONObject4.put("resolution", "");
                    }
                    jSONObject2.put("senderQualityInfo", jSONObject4);
                }
                if (mIsEnablePullQualityMonitor) {
                    JSONArray jSONArray = new JSONArray();
                    for (BigInteger bigInteger : this.mHUDStatisticsMap.keySet()) {
                        if (bigInteger != this.mPublisherHandle && (hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger)) != null) {
                            HashMap hashMap2 = new HashMap();
                            hUDStatistics.getStatsRecvInfo(hashMap2);
                            if (hashMap2.size() != 0) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("feedId", this.mFeedId);
                                jSONObject5.put("bitrate", hashMap2.get("bitrate_r"));
                                jSONObject5.put("packetloss", hashMap2.get("packetloss_r"));
                                jSONObject5.put(FpsConstants.REPORT_FPS, hashMap2.get("fps_r"));
                                jSONObject5.put("resolution", hUDStatistics.getRecvResolution());
                                jSONArray.put(jSONObject5);
                            }
                        }
                    }
                    jSONObject2.put("receiverQualityInfoList", jSONArray);
                }
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("communicationQualityInfo", jSONObject2);
                jSONObject.put("env", this.mQualityMonitorEnv);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mRoomId);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("userId", this.mUserId);
                jSONObject.put("message", jSONObject6);
            } catch (JSONException e) {
                Log.e(TAG, "Caught error on reportCommunicationQualityInfo: " + e);
            }
            reportData(jSONObject.toString(), 2);
        }
    }

    private void reportSLIStuckInfo() {
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && mIsEnablePullQualityMonitor) {
            for (BigInteger bigInteger : this.mHUDStatisticsMap.keySet()) {
                if (bigInteger != this.mPublisherHandle && (hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger)) != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("feedId", this.mFeedId);
                        JSONArray jSONArray = new JSONArray();
                        JSONArray jSONArray2 = new JSONArray();
                        HashMap hashMap = new HashMap();
                        hUDStatistics.getSlIStuckData(hashMap);
                        ArrayList arrayList = (ArrayList) hashMap.get("aStuck");
                        if (arrayList.size() == 0) {
                            jSONArray.put(0);
                        } else {
                            for (int i = 0; i < arrayList.size(); i++) {
                                jSONArray.put(arrayList.get(i));
                            }
                        }
                        ArrayList arrayList2 = (ArrayList) hashMap.get("vStuck");
                        if (arrayList2.size() == 0) {
                            jSONArray2.put(0);
                        } else {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                jSONArray2.put(arrayList2.get(i2));
                            }
                        }
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("durations", jSONArray);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("durations", jSONArray2);
                        jSONObject3.put("astuck", jSONObject4);
                        jSONObject3.put("vstuck", jSONObject5);
                        hUDStatistics.clearSLIStuckData();
                        JSONObject jSONObject6 = new JSONObject();
                        if (hUDStatistics.getEndTOEndTime() > 0) {
                            jSONObject6.put("duration", hUDStatistics.getEndTOEndTime());
                            jSONObject3.put("e2eDelay", jSONObject6);
                        }
                        jSONObject2.put("sli", jSONObject3);
                        jSONObject.put("env", this.mQualityMonitorEnv);
                        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
                        jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mRoomId);
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("userId", this.mUserId);
                        jSONObject.put("message", jSONObject2);
                    } catch (JSONException e) {
                        Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
                    }
                    reportData(jSONObject.toString(), 3);
                }
            }
        }
    }

    private void reportData(String str, int i) {
        RtcLogReport rtcLogReport;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65549, this, str, i) == null) && (rtcLogReport = this.mRtcLogReport) != null) {
            rtcLogReport.report(str, i);
        }
    }

    public String getStreamingStatesInfo(BigInteger bigInteger, int i) {
        InterceptResult invokeLI;
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bigInteger, i)) == null) {
            if (bigInteger == null || (hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger)) == null) {
                return StringUtil.NULL_STRING;
            }
            return hUDStatistics.statsString(i);
        }
        return (String) invokeLI.objValue;
    }

    public void reportError(int i, String str) {
        ErrorInfoReport errorInfoReport;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (errorInfoReport = this.mErrorInfoReport) != null) {
            errorInfoReport.reportErrorInfo(i, str, CommonUtils.strToLong(this.mFeedId), CommonUtils.strToLong(this.mHandleId));
        }
    }

    public HUDStatistics updateStatsData(StatsReport[] statsReportArr, BigInteger bigInteger) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, statsReportArr, bigInteger)) == null) {
            if (bigInteger == null) {
                return null;
            }
            HUDStatistics hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger);
            if (hUDStatistics != null) {
                hUDStatistics.updateEncoderStatistics(statsReportArr);
            }
            return hUDStatistics;
        }
        return (HUDStatistics) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDeviceInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CommandMessage.SDK_VERSION, Constraints.sdkVersion());
                jSONObject2.put("networkType", RtcLogReport.getNetworkType((Context) this.mContext.get()));
                jSONObject2.put(Config.DEVICE_PART, RtcLogReport.getDeviceModel());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject2);
                jSONObject.put("env", this.mQualityMonitorEnv);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mRoomId);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("userId", this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
            }
            reportData(jSONObject.toString(), 0);
        }
    }

    public void onFfDelayChange(BigInteger bigInteger) {
        HUDStatistics hUDStatistics;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bigInteger) == null) && mIsEnablePullQualityMonitor && (hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger)) != null) {
            hUDStatistics.setFirstFrameTime(System.currentTimeMillis());
            reportSLIFfDelay(this.mUserId, hUDStatistics.getFirstFrameTime() - hUDStatistics.getRequestSubscribeTime());
        }
    }

    public void onPeerStatisticsReport(StatsReport[] statsReportArr, BigInteger bigInteger, PeerConnectionClient.StatsEventsType statsEventsType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, statsReportArr, bigInteger, statsEventsType) != null) || bigInteger == null) {
            return;
        }
        HUDStatistics hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger);
        if (hUDStatistics != null) {
            hUDStatistics.updateEncoderStatistics(statsReportArr);
        }
        if ((mIsEnablePushQualityMonitor || mIsEnablePullQualityMonitor) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT) {
            reportCommunicationQualityInfo();
        } else if ((mIsEnablePushQualityMonitor || mIsEnablePullQualityMonitor) && statsEventsType == PeerConnectionClient.StatsEventsType.GET_SLI_EVENT) {
            reportSLIStuckInfo();
        }
    }

    public void reportSLIFfDelay(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject2.put("feedId", j);
                jSONObject4.put("duration", j2);
                jSONObject2.put("ffDelay", jSONObject4);
                jSONObject3.put("sli", jSONObject2);
                jSONObject.put("env", this.mQualityMonitorEnv);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.mAppId);
                jSONObject.put(ILiveNPSPlugin.PARAMS_ROOM_ID, this.mRoomId);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("userId", this.mUserId);
                jSONObject.put("message", jSONObject3);
            } catch (JSONException e) {
                Log.e(TAG, "Caught error on reportDeviceInfo: " + e);
            }
            reportData(jSONObject.toString(), 3);
        }
    }

    public void startPeerPullReport(BigInteger bigInteger, PeerConnectionClient peerConnectionClient) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, bigInteger, peerConnectionClient) == null) && peerConnectionClient != null && bigInteger != null) {
            if (mIsEnablePullQualityMonitor) {
                if (this.mHUDStatisticsMap.get(bigInteger) != null) {
                    peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                    this.mHUDStatisticsMap.remove(bigInteger);
                }
                peerConnectionClient.enableStatsEvents(mIsEnablePullQualityMonitor, 2000, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                peerConnectionClient.enableStatsEvents(mIsEnablePullQualityMonitor, 5000, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
            }
            if (mIsEnableInternalStatesMonitor) {
                peerConnectionClient.enableStatsEvents(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
            }
            HUDStatistics hUDStatistics = new HUDStatistics();
            this.mHUDStatisticsMap.put(bigInteger, hUDStatistics);
            hUDStatistics.setRequestSubscribeTime(System.currentTimeMillis());
        }
    }

    public void stopPeerReport(BigInteger bigInteger, PeerConnectionClient peerConnectionClient) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, bigInteger, peerConnectionClient) == null) && peerConnectionClient != null && bigInteger != null && this.mHUDStatisticsMap.get(bigInteger) != null) {
            this.mHUDStatisticsMap.remove(bigInteger);
            if (peerConnectionClient != null) {
                if (mIsEnablePullQualityMonitor) {
                    peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_QUALITY_MONITOR_EVENT);
                    peerConnectionClient.enableStatsEvents(false, 0, bigInteger, PeerConnectionClient.StatsEventsType.GET_SLI_EVENT);
                }
                if (mIsEnableInternalStatesMonitor) {
                    peerConnectionClient.enableStatsEvents(true, 200, bigInteger, PeerConnectionClient.StatsEventsType.GET_AUDIOLEVEL_EVENT);
                }
            }
        }
    }

    public boolean streamingValidityDetect(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bigInteger)) == null) {
            if (bigInteger == null) {
                return false;
            }
            HUDStatistics hUDStatistics = (HUDStatistics) this.mHUDStatisticsMap.get(bigInteger);
            if (hUDStatistics != null) {
                if ((hUDStatistics.hasVideo() && hUDStatistics.getVideoRecvBitrateTracker().getBytesDelta() == 0) || (hUDStatistics.hasAudio() && hUDStatistics.getAudioRecvBitrateTracker().getBytesDelta() == 0)) {
                    Logging.d(TAG, "No streaming date received in current period, hasVideo: " + hUDStatistics.hasVideo() + " hasAudio: " + hUDStatistics.hasAudio());
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void updateRoomInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            this.mAppId = str;
            this.mRoomId = str2;
            if (!TextUtils.isEmpty(str3)) {
                try {
                    this.mUserId = Long.valueOf(str3).longValue();
                } catch (NumberFormatException e) {
                    this.mUserId = -1L;
                    Logging.e(TAG, "UserID must be number format " + e.getMessage());
                }
            }
            this.mFeedId = str4;
            this.mHandleId = str5;
            this.mSessionId = str6;
            this.mErrorInfoReport.setAppId(this.mAppId);
            this.mErrorInfoReport.setRoomId(CommonUtils.strToLong(this.mRoomId));
            this.mErrorInfoReport.setUserId(this.mUserId);
            this.mErrorInfoReport.setSessionId(CommonUtils.strToLong(this.mSessionId));
            Logging.d(TAG, "update room info : userId = " + this.mUserId + " handleId =" + this.mHandleId);
        }
    }
}
