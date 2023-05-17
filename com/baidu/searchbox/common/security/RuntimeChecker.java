package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.antivr.AntiVirtualRuntime;
import com.baidu.searchbox.antivr.RuntimeResult;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RuntimeChecker {
    public static final boolean DEBUG = SecurityConfig.DEBUG;
    public static final String PKG_NAME = "com.baidu.searchbox";
    public static final int SDK_VERSION_P = 28;
    public static final String TAG = "RuntimeChecker";
    public static final String UBC_ID = "488";
    public final AntiVirtualRuntime mAntiVR;
    public Application mApplication;

    public RuntimeChecker() {
        Application application = AppRuntime.getApplication();
        this.mApplication = application;
        AntiVirtualRuntime antiVirtualRuntime = new AntiVirtualRuntime(application, "com.baidu.searchbox");
        this.mAntiVR = antiVirtualRuntime;
        antiVirtualRuntime.setDebug(DEBUG);
    }

    private String getRebootTime() {
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        if (DEBUG) {
            Log.d(TAG, "reboot time: " + currentTimeMillis);
        }
        return String.valueOf(currentTimeMillis / 1000);
    }

    @SuppressLint({"MissingPermission", "PrivateApi", "HardwareIds"})
    private String getRomSerial() {
        String str = null;
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                str = (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "ro.serialno");
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "getRomSerial", e);
            }
        }
        if (DEBUG) {
            Log.e(TAG, "SystemProperties getRomSerial = " + str);
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals("unknown", str)) {
            if (DeviceUtil.OSInfo.hasOreo()) {
                try {
                    str = Build.getSerial();
                } catch (Exception e2) {
                    if (DEBUG) {
                        Log.e(TAG, "Build.getSerial", e2);
                    }
                }
            } else {
                str = Build.SERIAL;
            }
            if (DEBUG) {
                Log.e(TAG, "Build.SERIAL getRomSerial = " + str);
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals("unknown", str)) {
            str = RomUtils.getProp("ro.serialno");
            if (DEBUG) {
                Log.e(TAG, "getProp getRomSerial = " + str);
            }
        }
        if (TextUtils.isEmpty(str)) {
            return StringUtil.NULL_STRING;
        }
        return str;
    }

    public void checkRuntime() {
        if (DEBUG) {
            Log.d(TAG, "start runtime check");
        }
        try {
            RuntimeResult startVRChecker = this.mAntiVR.startVRChecker();
            if (DEBUG) {
                Log.d(TAG, "is virtual = " + startVRChecker.isInVirtual());
                Log.d(TAG, "hook = " + startVRChecker.getHookName());
                Log.d(TAG, "host = " + startVRChecker.getHostPkgName());
                Log.d(TAG, "uid pkgs = " + startVRChecker.getUidPkgs());
            }
            if (startVRChecker.isInVirtual()) {
                sendUBCData(startVRChecker);
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "runtime check, Exception", e);
            }
        }
        QuickPersistConfig.getInstance().putBoolean(QuickPersistConfigConst.KEY_VIRTUAL_RUNTIME_CHECKED, true);
    }

    private String getUserProcessFromPsLine() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.startsWith("u")) {
                    sb.append(readLine);
                    sb.append("\n");
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "getPsInfo", e);
        }
        return sb.toString();
    }

    private void sendUBCData(RuntimeResult runtimeResult) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "vmcheck");
            jSONObject.put("type", runtimeResult.isInVirtual());
            if (runtimeResult.getHostPkgName() != null) {
                jSONObject.put("page", runtimeResult.getHostPkgName());
            }
            if (runtimeResult.getUidPkgs() != null) {
                jSONObject.put("value", runtimeResult.getUidPkgs());
            }
            jSONObject.put("source", getRomSerial());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("reboot", getRebootTime());
            jSONObject2.put(Config.ROM, Build.DISPLAY);
            if (runtimeResult.getHookName() != null) {
                jSONObject2.put("hook", runtimeResult.getHookName());
            }
            if (runtimeResult.isInVirtual()) {
                jSONObject2.put("psLine", getUserProcessFromPsLine());
            }
            jSONObject.put("ext", jSONObject2);
            if (DEBUG) {
                Log.e(TAG, "ubc data,  = " + jSONObject.toString());
            }
            SecUbcLog.onEvent(UBC_ID, jSONObject.toString());
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "addUBCObj exception", e);
            }
        }
    }
}
