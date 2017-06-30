package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private static final AtomicLong ack = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> acl;
    final Map<String, Object> acm;
    final String acn;
    final long aco;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private t(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.acl = map;
        this.acm = map2;
        this.type = i;
        this.acn = str3;
        this.aco = j;
        this.start = System.currentTimeMillis();
    }

    /* synthetic */ t(int i, String str, String str2, Map map, Map map2, String str3, long j, t tVar) {
        this(i, str, str2, map, map2, str3, j);
    }

    private static t a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new t(i, str, str2, map, null, z ? tK() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t a(Map<String, Object> map, long j, q qVar) {
        return new a(1, null, null, map, null, tK(), qVar, j, null);
    }

    public static t a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static t a(String str, String str2, Map<String, Object> map, long j, q qVar) {
        if (qVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, tK(), qVar, j, null);
    }

    public static t c(String str, Map<String, Object> map) {
        return new t(3, null, null, null, map, str, -1L);
    }

    private String tI() {
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

    public String tJ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put(PushConstants.EXTRA_METHOD, this.method);
        }
        if (this.acl != null && !this.acl.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            a(this.acl, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.acm != null && !this.acm.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            a(this.acm, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", tI());
        if (!TextUtils.isEmpty(this.acn)) {
            jSONObject.put("callbackId", this.acn);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(JSONObject jSONObject) {
    }

    private static String tK() {
        return "TBCWebViewJsBridge_callback_ID_" + ack.getAndIncrement();
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
    private static final class a extends t {
        private final q acp;

        /* synthetic */ a(int i, String str, String str2, Map map, Map map2, String str3, q qVar, long j, a aVar) {
            this(i, str, str2, map, map2, str3, qVar, j);
        }

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, q qVar, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            this.acp = qVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.t
        protected void j(JSONObject jSONObject) {
            this.acp.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.t
        void b(int i, Throwable th) {
            this.acp.b(i, th);
        }
    }
}
