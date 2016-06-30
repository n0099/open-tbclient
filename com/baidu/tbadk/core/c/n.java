package com.baidu.tbadk.core.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private static final AtomicLong Ub = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> Uc;
    final Map<String, Object> Ud;
    final String Ue;
    final long Uf;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private n(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.Uc = map;
        this.Ud = map2;
        this.type = i;
        this.Ue = str3;
        this.Uf = j;
        this.start = System.currentTimeMillis();
    }

    /* synthetic */ n(int i, String str, String str2, Map map, Map map2, String str3, long j, n nVar) {
        this(i, str, str2, map, map2, str3, j);
    }

    private static n a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new n(i, str, str2, map, null, z ? sB() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(Map<String, Object> map, long j, l lVar) {
        return new a(1, null, null, map, null, sB(), lVar, j, null);
    }

    public static n a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static n a(String str, String str2, Map<String, Object> map, long j, l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, sB(), lVar, j, null);
    }

    public static n b(String str, Map<String, Object> map) {
        return new n(3, null, null, null, map, str, -1L);
    }

    private String sz() {
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

    public String sA() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.Uc != null && !this.Uc.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.Uc, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.Ud != null && !this.Ud.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.Ud, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", sz());
        if (!TextUtils.isEmpty(this.Ue)) {
            jSONObject.put("callbackId", this.Ue);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(JSONObject jSONObject) {
    }

    private static String sB() {
        return "TBCWebViewJsBridge_callback_ID_" + Ub.getAndIncrement();
    }

    private void b(Map<String, Object> map, JSONObject jSONObject) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    private String encode(String str) {
        return "javascript:__tb_js_bridge.send('" + str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029") + "');";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Throwable th) {
    }

    /* loaded from: classes.dex */
    private static final class a extends n {
        private final l Ug;

        /* synthetic */ a(int i, String str, String str2, Map map, Map map2, String str3, l lVar, long j, a aVar) {
            this(i, str, str2, map, map2, str3, lVar, j);
        }

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, l lVar, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            this.Ug = lVar;
        }

        @Override // com.baidu.tbadk.core.c.n
        protected void j(JSONObject jSONObject) {
            this.Ug.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.c.n
        void a(int i, Throwable th) {
            this.Ug.a(i, th);
        }
    }
}
