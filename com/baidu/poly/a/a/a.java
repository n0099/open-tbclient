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
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static String aBb = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static a aBc;
    private d aAN;
    private final String aBd = zF();
    private final int aBe;

    private a(d dVar, int i) {
        this.aAN = dVar;
        this.aBe = i;
    }

    public static void a(d dVar, int i) {
        aBc = new a(dVar, i);
    }

    public static a zE() {
        return aBc;
    }

    private String zF() {
        return this.aBe == a.b.aAR ? "https://nop.nuomi.com/nop/server/rest" : this.aBe == a.b.aAS ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest";
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar, PayChannel payChannel) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> zO = c.zO();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                zO.put(str, bundle.get(str).toString());
            }
        }
        zO.put("nop_method", "nuomi.integration_cashier.launchpayment");
        zO.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        zO.put("payChannel", payChannel.getPayChannel());
        a(bundle, zO, bVar);
        HttpSigner.b(zO, this.aBe);
        String c = c(this.aBd, zO);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + c);
        }
        this.aAN.a(c, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(O(jSONObject.optJSONObject("data")));
                    } else {
                        c(new RuntimeException("errno:" + optInt), jSONObject.optString("errmsg"));
                    }
                } catch (Throwable th) {
                    c(th, null);
                }
            }

            private Map<String, String> O(JSONObject jSONObject) {
                Map<String, String> zO2 = c.zO();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            zO2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return zO2;
            }

            @Override // com.baidu.poly.a.a
            public void c(Throwable th, String str2) {
                aVar.c(th, str2);
            }
        });
    }

    public Map<String, String> a(Bundle bundle, b bVar) {
        Map<String, String> zO = c.zO();
        a(zO, bundle);
        zO.put("payType", "android");
        zO.put("nop_method", "nuomi.pay_platform.pay");
        zO.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, zO, bVar);
        HttpSigner.b(zO, this.aBe);
        return zO;
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        String c = c(this.aBd, a(bundle, bVar));
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + c);
        }
        this.aAN.a(c, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(O(jSONObject.optJSONObject("data")));
                    } else {
                        c(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    c(th, null);
                }
            }

            private Map<String, String> O(JSONObject jSONObject) {
                Map<String, String> zO = c.zO();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            zO.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return zO;
            }

            @Override // com.baidu.poly.a.a
            public void c(Throwable th, String str) {
                aVar.c(th, str);
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
            map.put("bduss", aBb);
            String str = bVar.get(SM.COOKIE);
            String str2 = "BDUSS=" + string;
            if (str == null) {
                bVar.W(SM.COOKIE, str2);
            } else {
                bVar.W(SM.COOKIE, str + "; " + str2);
            }
        }
    }

    public void b(Bundle bundle, final com.baidu.poly.a.a<PayChannel[]> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> zO = c.zO();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                zO.put(str, bundle.get(str).toString());
            }
        }
        zO.put("nop_method", "nuomi.integration_cashier.gatewaylist");
        zO.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, zO, bVar);
        HttpSigner.b(zO, this.aBe);
        String c = c(this.aBd, zO);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "getChannelList via url " + c);
        }
        this.aAN.a(c, bVar, aVar == null ? null : new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.3
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
                        aVar.c(new RuntimeException("data is empty"), jSONObject.optString("msg"));
                        return;
                    }
                    aVar.c(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                } catch (Throwable th) {
                    c(th, null);
                }
            }

            @Override // com.baidu.poly.a.a
            public void c(Throwable th, String str2) {
                aVar.c(th, str2);
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
