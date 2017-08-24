package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private static final AtomicLong aed = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> aee;
    final Map<String, Object> aef;
    final String aeg;
    final long aeh;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private q(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.aee = map;
        this.aef = map2;
        this.type = i;
        this.aeg = str3;
        this.aeh = j;
        this.start = System.currentTimeMillis();
    }

    private static q a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new q(i, str, str2, map, null, z ? ub() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q a(Map<String, Object> map, long j, n nVar) {
        return new a(1, null, null, map, null, ub(), nVar, j);
    }

    public static q a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static q a(String str, String str2, Map<String, Object> map, long j, n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, ub(), nVar, j);
    }

    public static q c(String str, Map<String, Object> map) {
        return new q(3, null, null, null, map, str, -1L);
    }

    private String tZ() {
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

    public String ua() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put(PushConstants.EXTRA_METHOD, this.method);
        }
        if (this.aee != null && !this.aee.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            a(this.aee, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.aef != null && !this.aef.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            a(this.aef, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", tZ());
        if (!TextUtils.isEmpty(this.aeg)) {
            jSONObject.put("callbackId", this.aeg);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(JSONObject jSONObject) {
    }

    private static String ub() {
        return "TBCWebViewJsBridge_callback_ID_" + aed.getAndIncrement();
    }

    private void a(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
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
    private static final class a extends q {
        private final n aei;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, n nVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.aei = nVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.q
        protected void k(JSONObject jSONObject) {
            this.aei.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.q
        void b(int i, Throwable th) {
            this.aei.b(i, th);
        }
    }
}
