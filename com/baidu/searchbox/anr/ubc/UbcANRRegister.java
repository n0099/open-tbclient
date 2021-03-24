package com.baidu.searchbox.anr.ubc;

import android.content.Context;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.anr.impl.ANRInfo;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.searchbox.ruka.ioc.Constant;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.ubc.UBCManager;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes2.dex */
public class UbcANRRegister implements IANRRegister {
    public static final String KEY_EXT = "ext";
    public static final String TAG = "UbcANRRegister";
    public static final String UBC_ANR = "1794";
    public static final int UI_TRACE_MAX_SIZE = 20;
    public String separator = Part.CRLF;
    public static String KEY_ANR_ACTIVE_UPLOAD = "key_anr_active_upload";
    public static boolean sEnable = QuickPersistConfig.getInstance().getBoolean(KEY_ANR_ACTIVE_UPLOAD, false);

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public boolean checkEnable() {
        return sEnable;
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public void onANR(Context context, ANRInfo aNRInfo) {
        if (checkEnable()) {
            AppConfig.isDebug();
            Log.d("Ruka", "onANR  at UbcANRRegister");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", aNRInfo.getType());
                jSONObject.put("logid", aNRInfo.getLogId());
                Object oSVersion = CommonUtils.getOSVersion();
                if (oSVersion != null) {
                    jSONObject.put("osversion", oSVersion);
                }
                Object appVersion = CommonUtils.getAppVersion();
                if (appVersion != null) {
                    jSONObject.put("appversion", appVersion);
                }
                jSONObject.put("cpu", CommonUtils.getCPUInfo());
                jSONObject.put("memory", String.valueOf(CommonUtils.getMemoryInfo()));
                Object sDKVersion = CommonUtils.getSDKVersion(Constant.KEY_RUKA_CONFIG);
                if (sDKVersion != null) {
                    jSONObject.put("sdkversion", sDKVersion);
                }
                Object network = CommonUtils.getNetwork();
                if (network != null) {
                    jSONObject.put("network", network);
                }
                Object packageName = CommonUtils.getPackageName();
                if (packageName != null) {
                    jSONObject.put("packagename", packageName);
                }
                jSONObject.put("page", aNRInfo.getCurrentPage());
                jSONObject.put("fileid", aNRInfo.getLogId());
                jSONObject.put(Constant.KEY_ANR_TIMESTAMP, aNRInfo.getTimeStamp());
                jSONObject.put("launchTime", String.valueOf(Ruka.getProcessLaunchTime()));
                String stackTrace = aNRInfo.getStackTrace();
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "stack format before: " + stackTrace);
                }
                String str = "ANR" + this.separator + this.separator + stackTrace;
                jSONObject.put("stacktrace", str);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "stack format after: " + str);
                }
                LinkedList<TrackUI> trackUIs = aNRInfo.getTrackUIs();
                if (trackUIs != null && trackUIs.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i = 1;
                    int size = trackUIs.size() - 1;
                    while (true) {
                        TrackUI trackUI = trackUIs.get(size);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("time", trackUI.getTimeStamp());
                        jSONObject2.put("page", trackUI.toStringPage());
                        jSONObject2.put("event", trackUI.getEvent());
                        jSONArray.put(jSONObject2);
                        int i2 = i + 1;
                        if (i >= 20) {
                            break;
                        }
                        int i3 = size - 1;
                        if (size <= 0) {
                            break;
                        }
                        size = i3;
                        i = i2;
                    }
                    jSONObject.put("pageTrace", jSONArray);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ext", jSONObject);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, jSONObject3.toString());
                }
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(UBC_ANR, jSONObject3);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
