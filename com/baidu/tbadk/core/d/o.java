package com.baidu.tbadk.core.d;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private static final AtomicLong WS = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> WT;
    final Map<String, Object> WU;
    final String WV;
    final long WW;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private o(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.WT = map;
        this.WU = map2;
        this.type = i;
        this.WV = str3;
        this.WW = j;
        this.start = System.currentTimeMillis();
    }

    /* synthetic */ o(int i, String str, String str2, Map map, Map map2, String str3, long j, o oVar) {
        this(i, str, str2, map, map2, str3, j);
    }

    private static o a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new o(i, str, str2, map, null, z ? tD() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(Map<String, Object> map, long j, m mVar) {
        return new a(1, null, null, map, null, tD(), mVar, j, null);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, tD(), mVar, j, null);
    }

    public static o c(String str, Map<String, Object> map) {
        return new o(3, null, null, null, map, str, -1L);
    }

    private String tB() {
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

    public String tC() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.WT != null && !this.WT.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.WT, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.WU != null && !this.WU.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.WU, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", tB());
        if (!TextUtils.isEmpty(this.WV)) {
            jSONObject.put("callbackId", this.WV);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(JSONObject jSONObject) {
    }

    private static String tD() {
        return "TBCWebViewJsBridge_callback_ID_" + WS.getAndIncrement();
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
        private final m WX;

        /* synthetic */ a(int i, String str, String str2, Map map, Map map2, String str3, m mVar, long j, a aVar) {
            this(i, str, str2, map, map2, str3, mVar, j);
        }

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, m mVar, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            this.WX = mVar;
        }

        @Override // com.baidu.tbadk.core.d.o
        protected void k(JSONObject jSONObject) {
            this.WX.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.d.o
        void a(int i, Throwable th) {
            this.WX.a(i, th);
        }
    }
}
