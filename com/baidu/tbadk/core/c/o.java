package com.baidu.tbadk.core.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private static final AtomicLong Xy = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> XA;
    final String XB;
    final long XC;
    final Map<String, Object> Xz;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private o(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.Xz = map;
        this.XA = map2;
        this.type = i;
        this.XB = str3;
        this.XC = j;
        this.start = System.currentTimeMillis();
    }

    /* synthetic */ o(int i, String str, String str2, Map map, Map map2, String str3, long j, o oVar) {
        this(i, str, str2, map, map2, str3, j);
    }

    private static o a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new o(i, str, str2, map, null, z ? tF() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(Map<String, Object> map, long j, m mVar) {
        return new a(1, null, null, map, null, tF(), mVar, j, null);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, tF(), mVar, j, null);
    }

    public static o c(String str, Map<String, Object> map) {
        return new o(3, null, null, null, map, str, -1L);
    }

    private String tD() {
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

    public String tE() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.Xz != null && !this.Xz.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.Xz, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.XA != null && !this.XA.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.XA, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", tD());
        if (!TextUtils.isEmpty(this.XB)) {
            jSONObject.put("callbackId", this.XB);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(JSONObject jSONObject) {
    }

    private static String tF() {
        return "TBCWebViewJsBridge_callback_ID_" + Xy.getAndIncrement();
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
    public void a(int i, Throwable th) {
    }

    /* loaded from: classes.dex */
    private static final class a extends o {
        private final m XD;

        /* synthetic */ a(int i, String str, String str2, Map map, Map map2, String str3, m mVar, long j, a aVar) {
            this(i, str, str2, map, map2, str3, mVar, j);
        }

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, m mVar, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            this.XD = mVar;
        }

        @Override // com.baidu.tbadk.core.c.o
        protected void l(JSONObject jSONObject) {
            this.XD.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.c.o
        void a(int i, Throwable th) {
            this.XD.a(i, th);
        }
    }
}
