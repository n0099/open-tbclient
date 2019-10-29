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
    private static final AtomicLong chd = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final long bDM;
    final Map<String, Object> che;
    final Map<String, Object> chf;
    final String chg;
    final long chh;
    final String cmd;
    final String method;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.che = map;
        this.chf = map2;
        this.type = i;
        this.chg = str3;
        this.chh = j;
        this.bDM = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? alC() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, alC(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m h(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String alA() {
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

    public String alB() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put("cmd", this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.che != null && !this.che.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.che, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.chf != null && !this.chf.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.chf, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put(PushManager.MESSAGE_TYPE, alA());
        if (!TextUtils.isEmpty(this.chg)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.chg);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bu(JSONObject jSONObject) {
    }

    private static String alC() {
        return "TBCWebViewJsBridge_callback_ID_" + chd.getAndIncrement();
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
        private final k chi;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.chi = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void bu(JSONObject jSONObject) {
            this.chi.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.chi.b(i, th);
        }
    }
}
