package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends com.alipay.sdk.packet.e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.packet.e
    public String a(String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.alipay.sdk.packet.e.f1940a, String.valueOf(z));
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put(com.alipay.sdk.packet.e.f1946g, "CBC");
        return hashMap;
    }

    @Override // com.alipay.sdk.packet.e
    public JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    public String c() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.alipay.sdk.packet.e.i, "/sdk/log");
        hashMap.put(com.alipay.sdk.packet.e.j, BuildConfig.VERSION_NAME);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(t, "1.0");
        return a(hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(Context context, String str) throws Throwable {
        return a(context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }
}
