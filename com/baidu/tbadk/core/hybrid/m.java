package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.down.common.intercepter.IIntercepter;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private static final AtomicLong dKG = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final String cmd;
    final Map<String, Object> dKH;
    final Map<String, Object> dKI;
    final String dKJ;
    final String method;
    final long start;
    final long timeout;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.dKH = map;
        this.dKI = map2;
        this.type = i;
        this.dKJ = str3;
        this.timeout = j;
        this.start = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? aTI() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, aTI(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m m(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String aTG() {
        switch (this.type) {
            case 1:
                return "ping";
            case 2:
                return "request";
            case 3:
                return IIntercepter.TYPE_RESPONSE;
            default:
                throw new IllegalArgumentException("Unsupported request type");
        }
    }

    public String aTH() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put("cmd", this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.dKH != null && !this.dKH.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.dKH, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.dKI != null && !this.dKI.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.dKI, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", aTG());
        if (!TextUtils.isEmpty(this.dKJ)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.dKJ);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cC(JSONObject jSONObject) {
    }

    private static String aTI() {
        return "TBCWebViewJsBridge_callback_ID_" + dKG.getAndIncrement();
    }

    private void b(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    private String encode(String str) {
        return "javascript:__tb_js_bridge.send('" + str.replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029") + "');";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, Throwable th) {
    }

    /* loaded from: classes.dex */
    private static final class a extends m {
        private final k dKK;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.dKK = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void cC(JSONObject jSONObject) {
            this.dKK.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.dKK.b(i, th);
        }
    }
}
