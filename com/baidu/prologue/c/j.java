package com.baidu.prologue.c;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.prologue.b;
import com.baidu.webkit.internal.ETAG;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class j {
    private static final boolean DEBUG = f.DEBUG;

    public static boolean isUnitedScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isUnitedScheme(Uri.parse(str));
    }

    public static boolean isUnitedScheme(Uri uri) {
        if (uri == null) {
            return false;
        }
        return TextUtils.equals(f.UNITED_SCHEME, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost());
    }

    public static boolean hasVersion(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        return !TextUtils.isEmpty(host) && host.startsWith("v") && isContainNumber(host);
    }

    public static boolean isContainNumber(String str) {
        return Pattern.compile("[0-9]").matcher(str).find();
    }

    public static String[] getPaths(Uri uri) {
        if (uri == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(uri.getPathSegments());
        if (!hasVersion(uri)) {
            arrayList.add(0, uri.getHost());
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static HashMap<String, String> getParams(String str) {
        String substring;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        if (indexOf < 0) {
            return hashMap;
        }
        if (indexOf2 < 0) {
            substring = str.substring(indexOf + 1);
        } else {
            substring = str.substring(indexOf + 1, indexOf2);
        }
        String[] split = substring.split(ETAG.ITEM_SEPARATOR);
        if (split == null) {
            return hashMap;
        }
        for (String str2 : split) {
            int indexOf3 = str2.indexOf(ETAG.EQUAL);
            if (indexOf3 > 0) {
                try {
                    hashMap.put(URLDecoder.decode(str2.substring(0, indexOf3)), URLDecoder.decode(str2.substring(indexOf3 + 1)));
                } catch (IllegalArgumentException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    public static JSONObject wrapCallbackParams(int i) {
        return wrapCallbackParams((JSONObject) null, i);
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i) {
        return wrapCallbackParams(jSONObject, i, getErrMessage(i));
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i, String str) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i, str);
        if (jSONObject != null) {
            try {
                wrapCallbackParams.put("data", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return wrapCallbackParams;
    }

    public static JSONObject wrapCallbackParams(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(i));
            jSONObject.put("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static String getErrMessage(int i) {
        switch (i) {
            case 0:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_ok);
            case 101:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_not_support);
            case 201:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_parse_fail);
            case 202:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_params_parse_fail);
            case 301:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_module_notfound);
            case 302:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_action_notfound);
            case 401:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_action_sec_check_fail);
            case 402:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_action_acl_check_fail);
            case 403:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_action_allow_close);
            default:
                return c.getAppContext().getString(b.d.prologue_united_scheme_err_message_parse_fail);
        }
    }
}
