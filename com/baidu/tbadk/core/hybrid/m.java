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
    private static final AtomicLong aug = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> auh;
    final Map<String, Object> aui;
    final String auj;
    final long auk;
    final long aul;
    final String cmd;
    final String method;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.auh = map;
        this.aui = map2;
        this.type = i;
        this.auj = str3;
        this.auk = j;
        this.aul = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? Ba() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, Ba(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m e(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String AY() {
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

    public String AZ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.auh != null && !this.auh.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.auh, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.aui != null && !this.aui.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.aui, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", AY());
        if (!TextUtils.isEmpty(this.auj)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.auj);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(JSONObject jSONObject) {
    }

    private static String Ba() {
        return "TBCWebViewJsBridge_callback_ID_" + aug.getAndIncrement();
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
        private final k aum;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.aum = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void z(JSONObject jSONObject) {
            this.aum.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.aum.b(i, th);
        }
    }
}
