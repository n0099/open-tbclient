package com.baidu.searchbox.suspensionball;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class SuspensionSchemeUtil {
    public static final String DEFAULT_KEY_PREFIX = "suspensionball";
    public static final String SUSPENSION_KEY = "suspensionkey";

    public static String generateDefaultKey() {
        return generateKey(DEFAULT_KEY_PREFIX);
    }

    private static String generateKey(String str) {
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_KEY_PREFIX;
        }
        return str + ":" + System.currentTimeMillis();
    }

    public static String generateDefaultSchemeByIntent(Intent intent, String str) {
        return generateDefaultSchemeByIntent(intent, str, null);
    }

    public static String generateDefaultSchemeByIntent(Intent intent, String str, String str2) {
        if (intent == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", str);
            jSONObject.put("intent", intent.toUri(1));
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("min_v", str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static Intent intentAddSuspensionKey(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        intent.putExtra(SUSPENSION_KEY, str);
        return intent;
    }

    public static String schemeAddSuspensionKey(String str, String str2) {
        if (UnitedSchemeUtility.isUnitedScheme(str)) {
            int indexOf = str.indexOf("?");
            int indexOf2 = str.indexOf("#");
            if (indexOf < 0) {
                return str + "?" + SUSPENSION_KEY + ETAG.EQUAL + str2;
            }
            if (indexOf2 < 0) {
                return str + ETAG.ITEM_SEPARATOR + SUSPENSION_KEY + ETAG.EQUAL + str2;
            }
            return str.substring(0, indexOf2) + ETAG.ITEM_SEPARATOR + SUSPENSION_KEY + ETAG.EQUAL + str2;
        }
        return str;
    }
}
