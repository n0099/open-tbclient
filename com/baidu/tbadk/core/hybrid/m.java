package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private static final AtomicLong ayt = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> ayu;
    final Map<String, Object> ayv;
    final String ayw;
    final long ayx;
    final long ayy;
    final String cmd;
    final String method;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.ayu = map;
        this.ayv = map2;
        this.type = i;
        this.ayw = str3;
        this.ayx = j;
        this.ayy = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? Cl() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, Cl(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m f(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String Cj() {
        switch (this.type) {
            case 1:
                return "ping";
            case 2:
                return "request";
            case 3:
                return "response";
            default:
                throw new IllegalArgumentException("Unsupported request type");
        }
    }

    public String Ck() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.ayu != null && !this.ayu.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.ayu, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.ayv != null && !this.ayv.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.ayv, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", Cj());
        if (!TextUtils.isEmpty(this.ayw)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.ayw);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(JSONObject jSONObject) {
    }

    private static String Cl() {
        return "TBCWebViewJsBridge_callback_ID_" + ayt.getAndIncrement();
    }

    private void b(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    private String encode(String str) {
        return "javascript:__tb_js_bridge.send('" + str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029") + "');";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, Throwable th) {
    }

    /* loaded from: classes.dex */
    private static final class a extends m {
        private final k ayz;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.ayz = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void A(JSONObject jSONObject) {
            this.ayz.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.ayz.b(i, th);
        }
    }
}
