package com.baidu.searchbox.schemedispatch.forbid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.utils.BdussParamProcessUtil;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SchemeForbidStatisticUtils {
    public static final String KEY_SOURCE = "source";
    public static final String SCHEME_FORBID_STAT_KEY = "380";
    public static final String SCHEME_FORBID_WHITLIST_V = "invoke_v";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = SchemeForbidStatisticUtils.class.getSimpleName();

    public static void doSchemeForbidStatistic(String str, String str2, boolean z, boolean z2, String str3, SchemeStatisticField schemeStatisticField) {
        onEvent(str, str2, z, z2, "global", str3, schemeStatisticField);
    }

    public static void onEvent(String str, String str2, boolean z, boolean z2, String str3, String str4) {
        onEvent(str, str2, z, z2, str3, str4, null);
    }

    public static boolean hasLocalApk(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void onEvent(SchemeStatisticField schemeStatisticField) {
        HashMap hashMap = new HashMap();
        if (schemeStatisticField != null) {
            schemeStatisticField.apply(hashMap);
        }
        hashMap.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
        hashMap.put("version", PreferenceUtils.getString("invoke_v", "0"));
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, hashMap);
    }

    public static void onEvent(String str, String str2, boolean z, boolean z2, String str3, String str4, SchemeStatisticField schemeStatisticField) {
        Object obj;
        String str5 = "0";
        String string = PreferenceUtils.getString("invoke_v", "0");
        HashMap hashMap = new HashMap();
        if (schemeStatisticField != null) {
            schemeStatisticField.apply(hashMap);
        }
        hashMap.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
        hashMap.put("type", "clk_" + str3);
        hashMap.put("pageurl", BdussParamProcessUtil.excludeBdussParam(str));
        hashMap.put("scheme", BdussParamProcessUtil.excludeBdussParam(str2));
        if (!z) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("enable", obj);
        if (z2) {
            str5 = "1";
        }
        hashMap.put("invokable", str5);
        hashMap.put("version", string);
        hashMap.put("refer", BdussParamProcessUtil.excludeBdussParam(str4));
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, hashMap);
    }

    public static void onEvent(String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6) {
        Object obj;
        String str7 = "0";
        String string = PreferenceUtils.getString("invoke_v", "0");
        HashMap hashMap = new HashMap();
        hashMap.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
        hashMap.put("pageurl", BdussParamProcessUtil.excludeBdussParam(str));
        hashMap.put("scheme", BdussParamProcessUtil.excludeBdussParam(str2));
        if (!z) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("enable", obj);
        if (z2) {
            str7 = "1";
        }
        hashMap.put("invokable", str7);
        hashMap.put("version", string);
        hashMap.put("refer", BdussParamProcessUtil.excludeBdussParam(str4));
        hashMap.put("source", str5);
        hashMap.put("ext", str6);
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, hashMap);
    }

    public static void ubcSchemaDialog(int i) {
        String str;
        if (i == 1) {
            str = MediaAEffect.AE_ANIM_ONCE;
        } else if (i == 2) {
            str = "always";
        } else {
            str = "cancel";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
            jSONObject.put("type", MapController.POPUP_LAYER_TAG);
            jSONObject.put("value", str);
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void ubcSchemeRule(boolean z) {
        String str;
        if (z) {
            str = UniversalToast.ToastCallbackWithAction.PARAMS_RESULT_KEY;
        } else {
            str = "forbidden";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
            jSONObject.put("type", MapController.POPUP_LAYER_TAG);
            jSONObject.put("value", str);
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void ubcShowDialog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
            jSONObject.put("type", "show");
            jSONObject.put("value", "dialog");
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public static void ubcWhetherInstallApk(Context context, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", DownloadStatisticConstants.UBC_VALUE_OPENBOX);
            jSONObject.put("type", "show");
            jSONObject.put("value", "dialog");
            JSONObject jSONObject2 = new JSONObject();
            if (hasLocalApk(context, str)) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            jSONObject2.put("exsist_app", str3);
            jSONObject2.put("scheme", BdussParamProcessUtil.excludeBdussParam(str2));
            jSONObject.put("ext", jSONObject2.toString());
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(SCHEME_FORBID_STAT_KEY, jSONObject.toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
