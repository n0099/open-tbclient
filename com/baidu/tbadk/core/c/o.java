package com.baidu.tbadk.core.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private static final AtomicLong XD = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> XE;
    final Map<String, Object> XF;
    final String XG;
    final long XH;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private o(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.XE = map;
        this.XF = map2;
        this.type = i;
        this.XG = str3;
        this.XH = j;
        this.start = System.currentTimeMillis();
    }

    /* synthetic */ o(int i, String str, String str2, Map map, Map map2, String str3, long j, o oVar) {
        this(i, str, str2, map, map2, str3, j);
    }

    private static o a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new o(i, str, str2, map, null, z ? tJ() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(Map<String, Object> map, long j, m mVar) {
        return new a(1, null, null, map, null, tJ(), mVar, j, null);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, tJ(), mVar, j, null);
    }

    public static o c(String str, Map<String, Object> map) {
        return new o(3, null, null, null, map, str, -1L);
    }

    private String tH() {
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

    public String tI() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.XE != null && !this.XE.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.XE, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.XF != null && !this.XF.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.XF, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", tH());
        if (!TextUtils.isEmpty(this.XG)) {
            jSONObject.put("callbackId", this.XG);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(JSONObject jSONObject) {
    }

    private static String tJ() {
        return "TBCWebViewJsBridge_callback_ID_" + XD.getAndIncrement();
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
        private final m XI;

        /* synthetic */ a(int i, String str, String str2, Map map, Map map2, String str3, m mVar, long j, a aVar) {
            this(i, str, str2, map, map2, str3, mVar, j);
        }

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, m mVar, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            this.XI = mVar;
        }

        @Override // com.baidu.tbadk.core.c.o
        protected void j(JSONObject jSONObject) {
            this.XI.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.c.o
        void a(int i, Throwable th) {
            this.XI.a(i, th);
        }
    }
}
