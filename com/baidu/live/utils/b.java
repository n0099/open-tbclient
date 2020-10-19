package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public static String a(int i, String str, boolean z, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> a2 = a(z, str2, str3, str4, str5);
                a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                str7 = WebviewHelper.addQueryParams(str, a2);
                if (!TextUtils.isEmpty(str6)) {
                    str7 = str7 + ETAG.ITEM_SEPARATOR + str6;
                }
            } else {
                if (i == 1) {
                    str = WebviewHelper.addQueryParams(str, a(z, str2, str3, str4, str5));
                }
                str7 = !TextUtils.isEmpty(str6) ? str + ETAG.ITEM_SEPARATOR + str6 : str;
            }
            return str7;
        }
        return str;
    }

    public static String a(int i, String str, boolean z, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            Map<String, Object> a2 = a(z, str2, str3, str4, str5);
            if (i == 2) {
                a2.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            if (map != null) {
                a2.putAll(map);
            }
            return WebviewHelper.addQueryParams(str, a2);
        }
        return str;
    }

    public static Map<String, Object> a(boolean z, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("is_host", 1);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("user_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("charm_user_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("room_id", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("live_id", str4);
        }
        hashMap.put("subapp_type", TbConfig.getSubappType());
        hashMap.put("_client_type", "2");
        hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        return hashMap;
    }
}
