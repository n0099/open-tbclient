package com.baidu.tbadk.core.hybrid;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.down.common.intercepter.IIntercepter;
import com.coloros.mcssdk.PushManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private static final AtomicLong cWZ = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> cXa;
    final Map<String, Object> cXb;
    final String cXc;
    final String cmd;
    final String method;
    final long start;
    final long timeout;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.cXa = map;
        this.cXb = map2;
        this.type = i;
        this.cXc = str3;
        this.timeout = j;
        this.start = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? aFo() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, aFo(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m i(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String aFm() {
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

    public String aFn() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put("cmd", this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.cXa != null && !this.cXa.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.cXa, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.cXb != null && !this.cXb.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.cXb, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put(PushManager.MESSAGE_TYPE, aFm());
        if (!TextUtils.isEmpty(this.cXc)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.cXc);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cl(JSONObject jSONObject) {
    }

    private static String aFo() {
        return "TBCWebViewJsBridge_callback_ID_" + cWZ.getAndIncrement();
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
        private final k cXd;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.cXd = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void cl(JSONObject jSONObject) {
            this.cXd.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.cXd.b(i, th);
        }
    }
}
