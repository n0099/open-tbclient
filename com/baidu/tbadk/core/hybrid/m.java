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
    private static final AtomicLong bGQ = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> bGR;
    final Map<String, Object> bGS;
    final String bGT;
    final long bGU;
    final long bGV;
    final String cmd;
    final String method;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.bGR = map;
        this.bGS = map2;
        this.type = i;
        this.bGT = str3;
        this.bGU = j;
        this.bGV = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? abI() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, abI(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m i(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String abG() {
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

    public String abH() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.bGR != null && !this.bGR.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.bGR, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.bGS != null && !this.bGS.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.bGS, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", abG());
        if (!TextUtils.isEmpty(this.bGT)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.bGT);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aK(JSONObject jSONObject) {
    }

    private static String abI() {
        return "TBCWebViewJsBridge_callback_ID_" + bGQ.getAndIncrement();
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
        private final k bGW;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.bGW = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void aK(JSONObject jSONObject) {
            this.bGW.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.bGW.b(i, th);
        }
    }
}
