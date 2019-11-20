package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.coloros.mcssdk.PushManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private static final AtomicLong cgm = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final long bCV;
    final Map<String, Object> cgn;
    final Map<String, Object> cgo;
    final String cgp;
    final long cgq;
    final String cmd;
    final String method;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.cgn = map;
        this.cgo = map2;
        this.type = i;
        this.cgp = str3;
        this.cgq = j;
        this.bCV = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? alA() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, alA(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m h(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String aly() {
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

    public String alz() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put("cmd", this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.cgn != null && !this.cgn.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.cgn, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.cgo != null && !this.cgo.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.cgo, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put(PushManager.MESSAGE_TYPE, aly());
        if (!TextUtils.isEmpty(this.cgp)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.cgp);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bv(JSONObject jSONObject) {
    }

    private static String alA() {
        return "TBCWebViewJsBridge_callback_ID_" + cgm.getAndIncrement();
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
        private final k cgr;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.cgr = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void bv(JSONObject jSONObject) {
            this.cgr.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.cgr.b(i, th);
        }
    }
}
