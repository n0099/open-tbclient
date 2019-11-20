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
    private static String aAJ = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static a aAK;
    private final String aAL = zG();
    private final int aAM;
    private d aAv;

    private a(d dVar, int i) {
        this.aAv = dVar;
        this.aAM = i;
    }

    public static void a(d dVar, int i) {
        aAK = new a(dVar, i);
    }

    public static a zF() {
        return aAK;
    }

    private String zG() {
        return this.aAM == a.b.aAz ? "https://nop.nuomi.com/nop/server/rest" : this.aAM == a.b.aAA ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest";
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar, PayChannel payChannel) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> zP = c.zP();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                zP.put(str, bundle.get(str).toString());
            }
        }
        zP.put("nop_method", "nuomi.integration_cashier.launchpayment");
        zP.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        zP.put("payChannel", payChannel.getPayChannel());
        a(bundle, zP, bVar);
        HttpSigner.b(zP, this.aAM);
        String c = c(this.aAL, zP);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + c);
        }
        this.aAv.a(c, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(P(jSONObject.optJSONObject("data")));
                    } else {
                        c(new RuntimeException("errno:" + optInt), jSONObject.optString("errmsg"));
                    }
                } catch (Throwable th) {
                    c(th, null);
                }
            }

            private Map<String, String> P(JSONObject jSONObject) {
                Map<String, String> zP2 = c.zP();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            zP2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return zP2;
            }

            @Override // com.baidu.poly.a.a
            public void c(Throwable th, String str2) {
                aVar.c(th, str2);
            }
        });
    }

    public Map<String, String> a(Bundle bundle, b bVar) {
        Map<String, String> zP = c.zP();
        a(zP, bundle);
        zP.put("payType", "android");
        zP.put("nop_method", "nuomi.pay_platform.pay");
        zP.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, zP, bVar);
        HttpSigner.b(zP, this.aAM);
        return zP;
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        String c = c(this.aAL, a(bundle, bVar));
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + c);
        }
        this.aAv.a(c, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(P(jSONObject.optJSONObject("data")));
                    } else {
                        c(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    c(th, null);
                }
            }

            private Map<String, String> P(JSONObject jSONObject) {
                Map<String, String> zP = c.zP();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            zP.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return zP;
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
            map.put("bduss", aAJ);
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
        Map<String, String> zP = c.zP();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                zP.put(str, bundle.get(str).toString());
            }
        }
        zP.put("nop_method", "nuomi.integration_cashier.gatewaylist");
        zP.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, zP, bVar);
        HttpSigner.b(zP, this.aAM);
        String c = c(this.aAL, zP);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "getChannelList via url " + c);
        }
        this.aAv.a(c, bVar, aVar == null ? null : new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.3
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
