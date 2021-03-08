package com.baidu.searchbox.unitedscheme;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UnitedSchemeStatisticUtil {
    private static final String UBC_KEY_SCHEME_INVALID = "326";
    private static final String UBC_KEY_SCHEME_INVOKE = "327";
    private static final String UBC_KEY_SCHEME_UPDATE = "328";

    public static void doUBCForInvalidScheme(Uri uri, String str) {
        String uri2;
        JSONObject jSONObject = new JSONObject();
        if (uri == null) {
            uri2 = "null";
        } else {
            try {
                uri2 = uri.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("scheme", uri2);
        if (TextUtils.isEmpty(str)) {
            str = "null";
        }
        jSONObject.put("msg", str);
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_KEY_SCHEME_INVALID, jSONObject.toString());
    }

    public static void doUBCForSchemeInvoke(String str, Uri uri) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str);
            jSONObject.put("scheme", uri == null ? "null" : uri.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_KEY_SCHEME_INVOKE, jSONObject.toString());
    }

    public static void doUBCForUpdateDialog(Uri uri) {
        String uri2;
        JSONObject jSONObject = new JSONObject();
        if (uri == null) {
            uri2 = "null";
        } else {
            try {
                uri2 = uri.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("scheme", uri2);
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_KEY_SCHEME_UPDATE, jSONObject.toString());
    }
}
