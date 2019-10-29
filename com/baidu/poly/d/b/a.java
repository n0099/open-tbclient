package com.baidu.poly.d.b;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.poly.bean.PayChannel;
import com.baidu.poly.d.a;
import com.baidu.poly.d.a.d;
import com.baidu.poly.d.a.e;
import com.baidu.poly.util.c;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.poly.d.a {
    int aBZ = 0;
    int aCa = 1;
    private Activity activity;

    public a(Activity activity) {
        this.activity = activity;
    }

    @Override // com.baidu.poly.d.a
    public void a(Map<String, String> map, String str, a.C0131a c0131a) {
        try {
            String optString = new JSONObject(map).optString("extData");
            int optInt = TextUtils.isEmpty(optString) ? 0 : new JSONObject(optString).optInt("isNewCashier", 0);
            if (optInt == this.aBZ) {
                b(map, str, c0131a);
            } else if (optInt == this.aCa) {
                a(c.k(map), str, c0131a);
            }
        } catch (Throwable th) {
            c0131a.onFail(th.getMessage());
        }
    }

    public void a(Bundle bundle, final String str, final a.C0131a c0131a) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        com.baidu.poly.a.a.a.zE().a(bundle, new com.baidu.poly.a.a<Map<String, String>>() { // from class: com.baidu.poly.d.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            /* renamed from: l */
            public void onSuccess(Map<String, String> map) {
                a.this.c(map, str, c0131a);
            }
        });
    }

    public void b(Map<String, String> map, String str, final a.C0131a c0131a) {
        JSONObject b = b(map, str);
        Bundle bundle = new Bundle();
        bundle.putString("params", b.toString());
        bundle.putString("channel", str);
        bundle.putBoolean(PluginDelegateActivity.ENABLE_FALLBACK_FINISH_KEY, false);
        DelegateUtils.callOnMainWithActivity(this.activity, PluginDelegateActivity.class, b.class, bundle, new DelegateListener() { // from class: com.baidu.poly.d.b.a.2
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(DelegateResult delegateResult) {
                Bundle bundle2 = delegateResult.mResult;
                c0131a.onResult(bundle2.getInt("stateCode", 0), bundle2.getString("payDesc"));
            }
        });
    }

    public void c(final Map<String, String> map, String str, final a.C0131a c0131a) {
        d dJ = dJ(str);
        if (dJ != null) {
            dJ.a(this.activity, map, new a.C0131a() { // from class: com.baidu.poly.d.b.a.3
                @Override // com.baidu.poly.d.a.C0131a
                public void onResult(int i, String str2) {
                    c0131a.onResult(0, a.this.c(i, (String) map.get("payOrderNo"), str2));
                }
            });
        }
    }

    public d dJ(String str) {
        if (PayChannel.ALIPAY.equalsIgnoreCase(str)) {
            return com.baidu.poly.d.a.a.zQ();
        }
        if (PayChannel.WECHAT.equalsIgnoreCase(str)) {
            return e.zS();
        }
        if (PayChannel.BAIFUBAO.equalsIgnoreCase(str)) {
            return com.baidu.poly.d.a.b.zR();
        }
        return null;
    }

    public String c(int i, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2)) {
            str3 = "statecode={" + i + "};order_no={" + str + "};notify=" + str2;
        } else {
            str3 = "statecode={" + i + "};order_no={" + str + "};notify={" + str2 + "}";
        }
        try {
            jSONObject.put("statusCode", i);
            jSONObject.put("responseData", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject b(Map<String, String> map, String str) {
        try {
            JSONObject jSONObject = new JSONObject(map);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("token", "lbspay");
            jSONObject2.put("payChannel", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("order_info", jSONObject);
            jSONObject3.put("req_data", jSONObject2);
            return jSONObject3;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }
}
