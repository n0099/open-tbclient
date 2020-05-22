package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.restnet.fp.a;
import com.baidu.fsg.base.utils.SharedPreferencesUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class BdWalletUtils {
    private static final String DEVICE_FP = "rim_device_fp";
    private static final String PREF_FILE_NAME_FP = "__RIM_SDK_FP_V1";
    private static final String RIM_ALLCONFIG = "rim_allconfig";
    private static final String RIM_ALLCONFIG_CHANGESIGN = "rim_allconfig_changesign";
    private static final String RIM_EXPS = "rim_exps";
    private static final String RIM_SO_DOWN_LOAD = "rim_so_down_load_info";

    public static void addFlagsSecure(Activity activity) {
        activity.getWindow().addFlags(8192);
    }

    public static void clearFlagsSecure(Activity activity) {
        activity.getWindow().clearFlags(8192);
    }

    public static String getFPFileLastModified(Context context) {
        File file = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + PREF_FILE_NAME_FP + ".xml");
        return file.exists() ? "" + (file.lastModified() / 1000) : "";
    }

    public static String getDeviceFP(Context context) {
        String str = (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, DEVICE_FP, "");
        if (!TextUtils.isEmpty(str)) {
            return RimArmor.getInstance().localDecrypt(str);
        }
        return str;
    }

    public static void setDeviceFP(Context context, String str) {
        if (str != null) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, DEVICE_FP, RimArmor.getInstance().localEncryptProxy(str));
        }
    }

    public static void setRimAllConfig(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG, str);
        }
    }

    public static void setRimSoDownload(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_SO_DOWN_LOAD, str);
        }
    }

    public static String getRimAllConfig(Context context) {
        return (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG, "");
    }

    public static String getRimSoDownLoad(Context context) {
        return (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_SO_DOWN_LOAD, "");
    }

    public static void setRimAllConfiChangeSign(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG_CHANGESIGN, str);
        }
    }

    public static String getRimAllConfigChangesign(Context context) {
        return (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG_CHANGESIGN, "");
    }

    public static void setExps(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_EXPS, str);
        }
    }

    public static void cleanExps(Context context) {
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_EXPS, "");
    }

    public static String getExps(Context context) {
        return (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_EXPS, "");
    }

    public static void loadDeviceFP(Context context, Map<String, Object> map) {
        a aVar = new a(context.getApplicationContext());
        aVar.a(getSpParams(map));
        aVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils.1
            @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i, Object obj, String str, String str2) {
            }

            @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i, int i2, String str) {
            }
        });
        aVar.execBean();
    }

    public static void realTimeStatistics(Context context, String str, String str2, String str3, String str4) {
        com.baidu.fsg.base.restnet.c.a aVar = new com.baidu.fsg.base.restnet.c.a(context);
        aVar.setSpParameter(str);
        aVar.a(str2, str3, str4);
        aVar.execBean();
    }

    public static boolean isSpnoValidate(Map<String, Object> map) {
        return !BeanConstants.TestSpNo.equals(getSpNo(getSpParams(map))) || BeanConstants.TestRimId.equals(BeanConstants.RIMID);
    }

    private static String getSpParams(Map<String, Object> map) {
        if (map != null) {
            if (map.get("spParams") != null) {
                return map.get("spParams") + "";
            }
            if (map.get("sp_params") != null) {
                return map.get("sp_params") + "";
            }
            if (map.get("supPro") != null) {
                return "sp_no=" + map.get("supPro");
            }
        }
        return "";
    }

    private static String getSpNo(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split2 = str.split(ETAG.ITEM_SEPARATOR);
                if (split2 != null && split2.length > 0) {
                    for (String str2 : split2) {
                        if (str2 != null && (split = str2.split(ETAG.EQUAL)) != null && split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap.containsKey(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID) ? (String) hashMap.get(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID) : "";
    }
}
