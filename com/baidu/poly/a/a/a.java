package com.baidu.poly.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.poly.a;
import com.baidu.poly.a.b;
import com.baidu.poly.a.d;
import com.baidu.poly.bean.PayChannel;
import com.baidu.poly.util.HttpSigner;
import com.baidu.poly.util.c;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static String agI = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static a agJ;
    private final String agK = uh();
    private final int agL;
    private d agw;

    private a(d dVar, int i) {
        this.agw = dVar;
        this.agL = i;
    }

    public static void a(d dVar, int i) {
        agJ = new a(dVar, i);
    }

    public static a ug() {
        return agJ;
    }

    private String uh() {
        return this.agL == a.b.agA ? "https://nop.nuomi.com/nop/server/rest" : this.agL == a.b.agB ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest";
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar, PayChannel payChannel) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> uq = c.uq();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                uq.put(str, bundle.get(str).toString());
            }
        }
        uq.put("nop_method", "nuomi.integration_cashier.launchpayment");
        uq.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        uq.put("payChannel", payChannel.getPayChannel());
        a(bundle, uq, bVar);
        HttpSigner.a(uq, this.agL);
        String c = c(this.agK, uq);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + c);
        }
        this.agw.a(c, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(q(jSONObject.optJSONObject("data")));
                    } else {
                        d(new RuntimeException("errno:" + optInt), jSONObject.optString("errmsg"));
                    }
                } catch (Throwable th) {
                    d(th, null);
                }
            }

            private Map<String, String> q(JSONObject jSONObject) {
                Map<String, String> uq2 = c.uq();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            uq2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return uq2;
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str2) {
                aVar.d(th, str2);
            }
        });
    }

    public Map<String, String> a(Bundle bundle, b bVar) {
        Map<String, String> uq = c.uq();
        a(uq, bundle);
        uq.put("payType", "android");
        uq.put("nop_method", "nuomi.pay_platform.pay");
        uq.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uq, bVar);
        HttpSigner.a(uq, this.agL);
        return uq;
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        String c = c(this.agK, a(bundle, bVar));
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + c);
        }
        this.agw.a(c, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(q(jSONObject.optJSONObject("data")));
                    } else {
                        d(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    d(th, null);
                }
            }

            private Map<String, String> q(JSONObject jSONObject) {
                Map<String, String> uq = c.uq();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            uq.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return uq;
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str) {
                aVar.d(th, str);
            }
        });
    }

    private void a(Map<String, String> map, Bundle bundle) {
        for (String str : bundle.keySet()) {
            map.put(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    private void a(Bundle bundle, Map<String, String> map, b bVar) {
        String string = bundle.getString("bduss");
        if (!TextUtils.isEmpty(string)) {
            map.put("bduss", agI);
            String str = bVar.get("Cookie");
            String str2 = "BDUSS=" + string;
            if (str == null) {
                bVar.P("Cookie", str2);
            } else {
                bVar.P("Cookie", str + "; " + str2);
            }
        }
    }

    public void b(Bundle bundle, final com.baidu.poly.a.a<PayChannel[]> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> uq = c.uq();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                uq.put(str, bundle.get(str).toString());
            }
        }
        uq.put("nop_method", "nuomi.integration_cashier.gatewaylist");
        uq.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uq, bVar);
        HttpSigner.a(uq, this.agL);
        String c = c(this.agK, uq);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "getChannelList via url " + c);
        }
        this.agw.a(c, bVar, aVar == null ? null : new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            PayChannel[] payChannelArr = new PayChannel[length];
                            for (int i = 0; i < length; i++) {
                                payChannelArr[i] = new PayChannel(optJSONArray.optJSONObject(i));
                            }
                            aVar.onSuccess(payChannelArr);
                            return;
                        }
                        aVar.d(new RuntimeException("data is empty"), jSONObject.optString("msg"));
                        return;
                    }
                    aVar.d(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                } catch (Throwable th) {
                    d(th, null);
                }
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str2) {
                aVar.d(th, str2);
            }
        });
    }

    public String c(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                sb.append(entry.getKey()).append("=").append(URLEncoder.encode(value)).append("&");
            }
        }
        return sb.toString();
    }
}
