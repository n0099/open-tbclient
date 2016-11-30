package com.baidu.tbadk.core.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private static final AtomicLong Yj = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> Yk;
    final Map<String, Object> Yl;
    final String Ym;
    final long Yn;
    final String cmd;
    final String method;
    final long start;
    final int type;

    private o(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.Yk = map;
        this.Yl = map2;
        this.type = i;
        this.Ym = str3;
        this.Yn = j;
        this.start = System.currentTimeMillis();
    }

    /* synthetic */ o(int i, String str, String str2, Map map, Map map2, String str3, long j, o oVar) {
        this(i, str, str2, map, map2, str3, j);
    }

    private static o a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new o(i, str, str2, map, null, z ? tY() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(Map<String, Object> map, long j, m mVar) {
        return new a(1, null, null, map, null, tY(), mVar, j, null);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static o a(String str, String str2, Map<String, Object> map, long j, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("handler can't be null.");
        }
        return new a(2, str, str2, map, null, tY(), mVar, j, null);
    }

    public static o c(String str, Map<String, Object> map) {
        return new o(3, null, null, null, map, str, -1L);
    }

    private String tW() {
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

    public String tX() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put(IntentConfig.CMD, this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.Yk != null && !this.Yk.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.Yk, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.Yl != null && !this.Yl.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.Yl, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", tW());
        if (!TextUtils.isEmpty(this.Ym)) {
            jSONObject.put("callbackId", this.Ym);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(JSONObject jSONObject) {
    }

    private static String tY() {
        return "TBCWebViewJsBridge_callback_ID_" + Yj.getAndIncrement();
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
        private final m Yo;

        /* synthetic */ a(int i, String str, String str2, Map map, Map map2, String str3, m mVar, long j, a aVar) {
            this(i, str, str2, map, map2, str3, mVar, j);
        }

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, m mVar, long j) {
            super(i, str, str2, map, map2, str3, j, null);
            this.Yo = mVar;
        }

        @Override // com.baidu.tbadk.core.c.o
        protected void l(JSONObject jSONObject) {
            this.Yo.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.c.o
        void a(int i, Throwable th) {
            this.Yo.a(i, th);
        }
    }
}
