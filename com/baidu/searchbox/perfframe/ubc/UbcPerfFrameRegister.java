package com.baidu.searchbox.perfframe.ubc;

import android.content.Context;
import c.a.k0.b.a.a;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.baidu.searchbox.perfframe.impl.PerfExpInfo;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes11.dex */
public class UbcPerfFrameRegister implements IPerfFrameRegister {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UbcPerfFrameRegister";
    public static final int UI_TRACE_MAX_SIZE = 20;
    public transient /* synthetic */ FieldHolder $fh;

    public UbcPerfFrameRegister() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister
    public void onEvent(Context context, PerfExpInfo perfExpInfo) {
        LinkedList<TrackUI> trackUIs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, perfExpInfo) == null) {
            AppConfig.isDebug();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constant.KEY_PERFTYPE, perfExpInfo.getType());
                jSONObject.put("logid", perfExpInfo.getLogId());
                jSONObject.put("time", String.valueOf(perfExpInfo.getTime()));
                jSONObject.put("description", perfExpInfo.getException());
                jSONObject.put("page", perfExpInfo.getPage());
                jSONObject.put("processName", a.b());
                jSONObject.put(Constant.KEY_BUSINESS, perfExpInfo.getBusiness());
                JSONObject jSONObject2 = new JSONObject();
                if (perfExpInfo.isNeedPageTrace() && (trackUIs = perfExpInfo.getTrackUIs()) != null && trackUIs.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 1;
                    int size = trackUIs.size() - 1;
                    while (true) {
                        TrackUI trackUI = trackUIs.get(size);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", trackUI.getType());
                        jSONObject3.put("time", trackUI.getTimeStamp());
                        jSONObject3.put("page", PerfFrameTrackUIUtil.trackUI2StringPage(trackUI));
                        jSONObject3.put("event", trackUI.getEvent());
                        jSONArray.put(jSONObject3);
                        int i3 = i2 + 1;
                        if (i2 >= 20) {
                            break;
                        }
                        int i4 = size - 1;
                        if (size <= 0) {
                            break;
                        }
                        size = i4;
                        i2 = i3;
                    }
                    jSONObject2.put("pageTrace", jSONArray);
                }
                if (perfExpInfo.isNeedDynamicperf()) {
                    JSONObject jSONObject4 = new JSONObject();
                    String network = CommonUtils.getNetwork();
                    if (network != null) {
                        jSONObject4.put("network", network);
                    }
                    jSONObject4.put("launchTime", String.valueOf(perfExpInfo.getLaunchTime()));
                    jSONObject4.put(Constant.KEY_PROCESSTIME_DURATION, perfExpInfo.getProcessDuration());
                    jSONObject4.put("inStorage", CommonUtils.getInStorage());
                    jSONObject4.put("exStorage", CommonUtils.getExStorage());
                    jSONObject4.put("heap", CommonUtils.getHeapInfo());
                    jSONObject4.put("sysMem", CommonUtils.getSysMem());
                    jSONObject4.put("VSSRSS", CommonUtils.getVSSRSS());
                    jSONObject4.put("PSS", CommonUtils.getPSS());
                    jSONObject4.put("isLowMemory", CommonUtils.isLowMemory());
                    if (AppConfig.isDebug()) {
                        String str = "dynamicperfObj : " + jSONObject4;
                    }
                    jSONObject2.put(Constant.KEY_DYNAMICPERF, jSONObject4);
                }
                if (perfExpInfo.isNeedStaticperf()) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("launchid", perfExpInfo.getLogId());
                    String packageName = CommonUtils.getPackageName();
                    if (packageName != null) {
                        jSONObject5.put("packagename", packageName);
                    }
                    String oSVersion = CommonUtils.getOSVersion();
                    if (oSVersion != null) {
                        jSONObject5.put("osversion", oSVersion);
                    }
                    String appVersion = CommonUtils.getAppVersion();
                    if (appVersion != null) {
                        jSONObject5.put("appversion", appVersion);
                    }
                    String sDKVersion = CommonUtils.getSDKVersion(Constant.KEY_PERFFRAME_CONFIG);
                    if (sDKVersion != null) {
                        jSONObject5.put("sdkversion", sDKVersion);
                    }
                    jSONObject5.put("memory", String.valueOf(CommonUtils.getMemoryInfo()));
                    jSONObject5.put("cpu", CommonUtils.getCPUInfo());
                    IDeviceScore iDeviceScore = (IDeviceScore) ServiceManager.getService(IDeviceScore.SERVICE_REFERENCE);
                    if (iDeviceScore != null) {
                        jSONObject5.put("devicescore", String.valueOf(iDeviceScore.getFinalScore(context)));
                    }
                    jSONObject5.put("root", CommonUtils.getRootedInfo());
                    jSONObject5.put("emulator", CommonUtils.getEmulator());
                    jSONObject5.put("procBit", CommonUtils.getProcessBit());
                    jSONObject5.put("ROM", CommonUtils.getROM());
                    if (AppConfig.isDebug()) {
                        String str2 = "staticperfObj : " + jSONObject5;
                    }
                    jSONObject2.put(Constant.KEY_STATICPERF, jSONObject5);
                }
                if (perfExpInfo.isNeedMainStackTrace()) {
                    String mainThreadStackTrace = ThreadCollector.getMainThreadStackTrace();
                    if (AppConfig.isDebug()) {
                        String str3 = "stack : " + mainThreadStackTrace;
                    }
                    jSONObject2.put("stacktrace", mainThreadStackTrace);
                }
                jSONObject.put("ext", jSONObject2);
                if (AppConfig.isDebug()) {
                    String str4 = "content : " + jSONObject.toString();
                }
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(perfExpInfo.getUbcId(), jSONObject);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
