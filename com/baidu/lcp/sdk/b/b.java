package com.baidu.lcp.sdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.lcp.sdk.d.e;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.lcp.sdk.b.a {
    private a axc;

    /* loaded from: classes3.dex */
    public interface a {
        void eo(String str);

        void onFailure(int i, String str);
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.axc = aVar;
    }

    @Override // com.baidu.lcp.sdk.b.c.InterfaceC0156c
    public void onSuccess(byte[] bArr) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            com.baidu.lcp.sdk.d.d.d("GetTokenRequest", "onSuccess :" + jSONObject2.toString());
            int optInt = jSONObject2.optInt("error_code", -1);
            String optString = jSONObject2.optString("error_msg", "");
            if (optInt == 0) {
                e.k(this.context, jSONObject2.optBoolean("bddns_enable", false));
                String optString2 = jSONObject2.optString("token");
                JSONArray jSONArray = jSONObject2.getJSONArray(WebSocketRequest.PARAM_KEY_PROTOCOLS);
                if (TextUtils.isEmpty(optString2) || jSONArray == null || jSONArray.length() < 1) {
                    this.axc.onFailure(10002, "token or protocol is empty");
                    return;
                }
                e.l(this.context, jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i);
                    e.d(this.context, jSONObject3.optString(AlaRecorderLog.KEY_CONTENT_EXT_PROTOCOL) + ":" + jSONObject3.optString("domain") + ":" + jSONObject3.optString(ClientCookie.PORT_ATTR), i);
                }
                e.o(this.context, jSONObject2.optInt("ipv6_strategy", 3));
                this.axc.eo(optString2);
                e.D(this.context, optString2);
                try {
                    String optString3 = jSONObject2.optString("client_log_config", "");
                    if (!TextUtils.isEmpty(optString3)) {
                        JSONObject jSONObject4 = new JSONObject(optString3);
                        com.baidu.lcp.sdk.a.d.h(this.context, jSONObject4.optInt("client_upload_log_switch", 0));
                        JSONArray jSONArray2 = jSONObject4.getJSONArray("realtime_log_switch");
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray2.length() && (jSONObject = jSONArray2.getJSONObject(i2)) != null; i2++) {
                                com.baidu.lcp.sdk.a.d.b(this.context, jSONObject.optInt("id", 0), jSONObject.optInt("switch", 0));
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e) {
                    com.baidu.lcp.sdk.d.d.e("GetTokenRequest", "Json Exception");
                    return;
                }
            }
            this.axc.onFailure(optInt, optString);
        } catch (JSONException e2) {
            this.axc.onFailure(10001, "parse response exception ：" + e2);
        }
    }

    @Override // com.baidu.lcp.sdk.b.c.InterfaceC0156c
    public void onFailure(int i, String str) {
        this.axc.onFailure(i, str);
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public String getHost() {
        int aH = com.baidu.lcp.sdk.d.b.aH(this.context);
        if (aH == 1) {
            return "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token";
        }
        if (aH == 2) {
            return "http://bjyz-migrate-big-mem-xyq-02.epc.baidu.com:8911/rest/5.0/generate_lcm_token";
        }
        return com.baidu.lcp.sdk.d.b.aG(this.context) ? "http://rd-im-server.bcc-szth.baidu.com:8089/rest/5.0/generate_lcm_token" : "https://pim.baidu.com/rest/5.0/generate_lcm_token";
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public byte[] getRequestParameter() {
        try {
            JSONObject jSONObject = (JSONObject) com.baidu.lcp.sdk.d.a.i(this.context, true);
            return jSONObject != null ? jSONObject.toString().getBytes() : new byte[0];
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @Override // com.baidu.lcp.sdk.b.a, com.baidu.lcp.sdk.b.c.a
    public String getMediaType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.lcp.sdk.b.c.a
    public Map<String, String> getHeaders() {
        return null;
    }
}
