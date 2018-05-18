package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private static final AtomicLong aeG = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> aeH;
    final Map<String, Object> aeI;
    final String aeJ;
    final long aeK;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.aeH = map;
        this.aeI = map2;
        this.type = i;
        this.aeJ = str3;
        this.aeK = j;
        this.start = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? uj() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, uj(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m c(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String uh() {
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

    public String ui() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.aeH != null && !this.aeH.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.aeH, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.aeI != null && !this.aeI.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.aeI, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", uh());
        if (!TextUtils.isEmpty(this.aeJ)) {
            jSONObject.put("callbackId", this.aeJ);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(JSONObject jSONObject) {
    }

    private static String uj() {
        return "TBCWebViewJsBridge_callback_ID_" + aeG.getAndIncrement();
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
        private final k aeL;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.aeL = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void m(JSONObject jSONObject) {
            this.aeL.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.aeL.b(i, th);
        }
    }
}
