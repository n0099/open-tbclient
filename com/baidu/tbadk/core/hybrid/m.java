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
    private static final AtomicLong cSV = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);
    final Map<String, Object> cSW;
    final Map<String, Object> cSX;
    final String cSY;
    final String cmd;
    final String method;
    final long start;
    final long timeout;
    final int type;

    private m(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.cmd = str;
        this.method = str2;
        this.cSW = map;
        this.cSX = map2;
        this.type = i;
        this.cSY = str3;
        this.timeout = j;
        this.start = System.currentTimeMillis();
    }

    private static m a(int i, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i, str, str2, map, null, z ? aDc() : null, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Map<String, Object> map, long j, k kVar) {
        return new a(1, null, null, map, null, aDc(), kVar, j);
    }

    public static m a(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m j(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    private String aDa() {
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

    public String aDb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.cmd)) {
            jSONObject.put("cmd", this.cmd);
        }
        if (!TextUtils.isEmpty(this.method)) {
            jSONObject.put("method", this.method);
        }
        if (this.cSW != null && !this.cSW.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            b(this.cSW, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        if (this.cSX != null && !this.cSX.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            b(this.cSX, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put(PushManager.MESSAGE_TYPE, aDa());
        if (!TextUtils.isEmpty(this.cSY)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.cSY);
        }
        return encode(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cl(JSONObject jSONObject) {
    }

    private static String aDc() {
        return "TBCWebViewJsBridge_callback_ID_" + cSV.getAndIncrement();
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
        private final k cSZ;

        private a(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.cSZ = kVar;
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        protected void cl(JSONObject jSONObject) {
            this.cSZ.a(this, jSONObject);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        void b(int i, Throwable th) {
            this.cSZ.b(i, th);
        }
    }
}
