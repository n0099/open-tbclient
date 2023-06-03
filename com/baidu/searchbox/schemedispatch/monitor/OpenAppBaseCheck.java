package com.baidu.searchbox.schemedispatch.monitor;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.utils.CheckListUtils;
import com.baidu.searchbox.utils.SchemeSpUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class OpenAppBaseCheck {
    public static final String AD_INVOKE_FLAG_DISABLE = "0";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String SCHEME_FORBID_TYPE_DISABLE = "0";
    public static final String SCHEME_FORBID_TYPE_SPKEY = "scheme_forbid_type_key";
    public static final List<SchemeCheckInfo> SDEFAULT_LIST;
    public static final String TAG = "OpenAppBaseCheck";

    public static boolean canInvoke(SchemeCheckInfo schemeCheckInfo) {
        return schemeCheckInfo != null;
    }

    public abstract void loadWhiteListAsync();

    public abstract boolean saveWhiteListDispatch(JSONObject jSONObject);

    static {
        ArrayList arrayList = new ArrayList();
        SDEFAULT_LIST = arrayList;
        arrayList.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("http"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("https"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("rtsp"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("ftp"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("search"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("addwidget"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo(BaiduIdentityManager.PARAM_SERVICE));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo(BaiduIdentityManager.VALUE_OSNAME));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("widgetid"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("scenetype"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("package"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("baidupush"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("content"));
        SDEFAULT_LIST.add(SchemeCheckInfoKt.defaultNoAlertSchemeInfo("file"));
    }

    public static boolean checkSchemeInDefault(String str) {
        return canInvoke(getSchemeInDefault(str));
    }

    public static SchemeCheckInfo getPublicScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (SchemeCheckInfo schemeCheckInfo : SDEFAULT_LIST) {
            if (str.toLowerCase(Locale.getDefault()).startsWith(schemeCheckInfo.getScheme())) {
                return schemeCheckInfo;
            }
        }
        return null;
    }

    public static boolean isPublicScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (SchemeCheckInfo schemeCheckInfo : SDEFAULT_LIST) {
            if (str.toLowerCase(Locale.getDefault()).startsWith(schemeCheckInfo.getScheme())) {
                return true;
            }
        }
        return false;
    }

    public static List<String> readCache(String str) {
        return CheckListUtils.readCache(str);
    }

    public boolean saveWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d(TAG, "No data send");
            }
            return false;
        }
        try {
            return saveWhiteListDispatch(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.e(TAG, "Data parse exception");
            }
            return false;
        }
    }

    public static SchemeCheckInfo checkTypeClose(SchemeCheckInfo schemeCheckInfo, String str) {
        if (schemeCheckInfo != null) {
            return schemeCheckInfo;
        }
        if (TextUtils.equals(SchemeSpUtil.getInstance().getString("scheme_forbid_type_key", "0"), "0")) {
            if (DEBUG) {
                Log.d(TAG, "Scheme White List Check: Enabe=false");
            }
            return SchemeCheckInfoKt.defaultSchemeCheckInfo(str);
        }
        return null;
    }

    public static boolean isInWhiteList(String str, List<String> list) {
        return CheckListUtils.checkInList(str, list);
    }

    public static boolean writeCache(List<String> list, String str) {
        return CheckListUtils.writeCache(list, str);
    }

    public static SchemeCheckInfo getInfoInList(String str, List<SchemeCheckInfo> list) {
        String str2;
        String str3;
        String str4;
        String str5;
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf >= str.length()) {
            indexOf = 0;
        }
        if (indexOf2 >= str.length()) {
            indexOf2 = 0;
        }
        if (indexOf2 > 0 && indexOf2 < indexOf) {
            indexOf = 0;
        }
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (indexOf2 > 0) {
                String substring2 = str.substring(indexOf + 1, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                str3 = substring2;
                str2 = substring3;
            } else {
                str3 = str.substring(indexOf + 1);
                str2 = null;
            }
            str = substring;
        } else if (indexOf2 > 0) {
            String substring4 = str.substring(0, indexOf2);
            String substring5 = str.substring(indexOf2 + 1);
            str3 = null;
            str2 = substring5;
            str = substring4;
        } else {
            str2 = null;
            str3 = null;
        }
        for (SchemeCheckInfo schemeCheckInfo : list) {
            if (schemeCheckInfo != null && !TextUtils.isEmpty(schemeCheckInfo.getScheme())) {
                String scheme = schemeCheckInfo.getScheme();
                int indexOf3 = scheme.indexOf("?");
                int indexOf4 = scheme.indexOf("#");
                if (indexOf3 >= scheme.length()) {
                    indexOf3 = 0;
                }
                if (indexOf4 >= scheme.length()) {
                    indexOf4 = 0;
                }
                if (indexOf4 > 0 && indexOf4 < indexOf3) {
                    indexOf3 = 0;
                }
                if (indexOf3 > 0) {
                    String substring6 = scheme.substring(0, indexOf3);
                    if (indexOf4 > 0) {
                        String substring7 = scheme.substring(indexOf3 + 1, indexOf4);
                        String substring8 = scheme.substring(indexOf4 + 1);
                        str5 = substring7;
                        str4 = substring8;
                        scheme = substring6;
                    } else {
                        str5 = scheme.substring(indexOf3 + 1);
                        scheme = substring6;
                        str4 = null;
                    }
                } else if (indexOf4 > 0) {
                    String substring9 = scheme.substring(0, indexOf4);
                    String substring10 = scheme.substring(indexOf4 + 1);
                    str5 = null;
                    str4 = substring10;
                    scheme = substring9;
                } else {
                    str4 = null;
                    str5 = null;
                }
                if (!str.startsWith(scheme)) {
                    continue;
                } else if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4)) {
                    return schemeCheckInfo;
                } else {
                    if (TextUtils.isEmpty(str5) || (!TextUtils.isEmpty(str3) && CheckListUtils.compare(str3.split("&"), str5.split("&")))) {
                        if (TextUtils.equals(str2, str4)) {
                            return schemeCheckInfo;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static SchemeCheckInfo getSchemeInDefault(String str) {
        if (str.indexOf(32) < 0 && str.indexOf(10) < 0) {
            Uri parse = Uri.parse(str);
            if (parse != null && parse.getScheme() != null && (parse.getAuthority() != null || parse.getPath() != null)) {
                SchemeCheckInfo publicScheme = getPublicScheme(str);
                if (canInvoke(publicScheme)) {
                    return publicScheme;
                }
                if (UrlUtil.isUrl(str)) {
                    return SchemeCheckInfoKt.defaultNoAlertSchemeInfo(str);
                }
                return null;
            }
            return SchemeCheckInfoKt.defaultSchemeCheckInfo(str);
        }
        return SchemeCheckInfoKt.defaultSchemeCheckInfo(str);
    }
}
