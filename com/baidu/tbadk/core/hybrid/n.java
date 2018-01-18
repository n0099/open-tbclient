package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private static final AtomicLong aRM = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> aRN;
    final Map<String, Object> aRO;
    final String aRP;
    final long aRQ;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private n(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.aRN = map;
        this.aRO = map2;
        this.type = i;
        this.aRP = str3;
        this.aRQ = j;
        this.start = System.currentTimeMillis();
    }

    private static n a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new n(i, str, str2, map, null, z ? Bh() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(Map<String, Object> map, long j, l lVar) {
        return new a(1, null, null, map, null, Bh(), lVar, j);
    }

    public static n a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static n a(String str, String str2, Map<String, Object> map, long j, l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, Bh(), lVar, j);
    }

    public static n b(String str, Map<String, Object> map) {
        return new n(3, null, null, null, map, str, -1L);
    }

    private String Bf() {
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

    public String Bg() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.aRN != null && !this.aRN.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.aRN, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.aRO != null && !this.aRO.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.aRO, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", Bf());
        if (!TextUtils.isEmpty(this.aRP)) {
            jSONObject.put("callbackId", this.aRP);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(JSONObject jSONObject) {
    }

    private static String Bh() {
        return "TBCWebViewJsBridge_callback_ID_" + aRM.getAndIncrement();
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
    private static final class a extends n {
        private final l aRR;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, l lVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.aRR = lVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.n
        protected void f(JSONObject jSONObject) {
            this.aRR.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.n
        void b(int i, Throwable th) {
            this.aRR.b(i, th);
        }
    }
}
