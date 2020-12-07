package com.baidu.searchbox.perfframe.ubc;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.a;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.baidu.searchbox.perfframe.impl.PerfExpInfo;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.ubc.ab;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class UbcPerfFrameRegister implements IPerfFrameRegister {
    private static final String TAG = "UbcPerfFrameRegister";
    private static final int UI_TRACE_MAX_SIZE = 20;

    @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister
    public void onEvent(Context context, PerfExpInfo perfExpInfo) {
        LinkedList<TrackUI> trackUIs;
        if (AppConfig.isDebug()) {
            Log.d("PerfFrame", "onException  at UbcPerfFrameRegister");
        }
        Log.d("PerfFrame", "onException  at UbcPerfFrameRegister");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.KEY_PERFTYPE, perfExpInfo.getType());
            jSONObject.put("logid", perfExpInfo.getLogId());
            jSONObject.put("time", String.valueOf(perfExpInfo.getTime()));
            jSONObject.put("description", perfExpInfo.getException());
            jSONObject.put("page", perfExpInfo.getPage());
            jSONObject.put(Constant.KEY_PROCESS_NAME, a.getProcessName());
            jSONObject.put(Constant.KEY_BUSINESS, perfExpInfo.getBusiness());
            JSONObject jSONObject2 = new JSONObject();
            if (perfExpInfo.isNeedPageTrace() && (trackUIs = perfExpInfo.getTrackUIs()) != null && trackUIs.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int size = trackUIs.size() - 1;
                int i = 1;
                while (true) {
                    int i2 = size;
                    int i3 = i;
                    TrackUI trackUI = trackUIs.get(i2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", trackUI.getType());
                    jSONObject3.put("time", trackUI.getTimeStamp());
                    jSONObject3.put("page", PerfFrameTrackUIUtil.trackUI2StringPage(trackUI));
                    jSONObject3.put("event", trackUI.getEvent());
                    jSONArray.put(jSONObject3);
                    i = i3 + 1;
                    if (i3 >= 20) {
                        break;
                    }
                    size = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
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
                jSONObject2.put(Constant.KEY_DYNAMICPERF, jSONObject4);
            }
            if (perfExpInfo.isNeedStaticperf()) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(Constant.KEY_LAUNCHID, perfExpInfo.getLogId());
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
                jSONObject2.put(Constant.KEY_STATICPERF, jSONObject5);
            }
            if (perfExpInfo.isNeedMainStackTrace()) {
                String mainThreadStackTrace = ThreadCollector.getMainThreadStackTrace();
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "stack : " + mainThreadStackTrace);
                }
                jSONObject2.put("stacktrace", mainThreadStackTrace);
            }
            jSONObject.put("ext", jSONObject2);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject.toString());
            }
            ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
            if (abVar != null) {
                Log.d(TAG, "ubc isDebug: " + abVar.ejc());
                Log.d(TAG, "content: " + jSONObject.toString());
                abVar.onEvent(perfExpInfo.getUbcId(), jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
