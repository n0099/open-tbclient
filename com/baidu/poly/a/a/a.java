package com.baidu.poly.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.poly.a;
import com.baidu.poly.a.b;
import com.baidu.poly.a.d;
import com.baidu.poly.bean.PayChannel;
import com.baidu.poly.util.HttpSigner;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private static String agy = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static a agz;
    private final String agA = tw();
    private final int agB;
    private d agm;

    private a(d dVar, int i) {
        this.agm = dVar;
        this.agB = i;
    }

    public static void a(d dVar, int i) {
        agz = new a(dVar, i);
    }

    public static a tv() {
        return agz;
    }

    private String tw() {
        return this.agB == a.b.agq ? "https://nop.nuomi.com/nop/server/rest" : this.agB == a.b.agr ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest";
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> tF = com.baidu.poly.util.b.tF();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                tF.put(str, bundle.get(str).toString());
            }
        }
        tF.put("nop_method", "nuomi.integration_cashier.launchpayment");
        tF.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, tF, bVar);
        HttpSigner.a(tF, this.agB);
        String d = d(this.agA, tF);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + d);
        }
        this.agm.a(d, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(v(jSONObject.optJSONObject("data")));
                    } else {
                        d(new RuntimeException("errno:" + optInt), jSONObject.optString("errmsg"));
                    }
                } catch (Throwable th) {
                    d(th, null);
                }
            }

            private Map<String, String> v(JSONObject jSONObject) {
                Map<String, String> tF2 = com.baidu.poly.util.b.tF();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            tF2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return tF2;
            }

            @Override // com.baidu.poly.a.a
            public void d(Throwable th, String str2) {
                aVar.d(th, str2);
            }
        });
    }

    public void b(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        Map<String, String> tF = com.baidu.poly.util.b.tF();
        a(tF, bundle);
        tF.put("payType", "android");
        tF.put("nop_method", "nuomi.pay_platform.pay");
        tF.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, tF, bVar);
        HttpSigner.a(tF, this.agB);
        String d = d(this.agA, tF);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + d);
        }
        this.agm.a(d, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(v(jSONObject.optJSONObject("data")));
                    } else {
                        d(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    d(th, null);
                }
            }

            private Map<String, String> v(JSONObject jSONObject) {
                Map<String, String> tF2 = com.baidu.poly.util.b.tF();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            tF2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return tF2;
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
            map.put("bduss", agy);
            String str = bVar.get("Cookie");
            String str2 = "BDUSS=" + string;
            if (str == null) {
                bVar.U("Cookie", str2);
            } else {
                bVar.U("Cookie", str + "; " + str2);
            }
        }
    }

    public void c(Bundle bundle, final com.baidu.poly.a.a<PayChannel[]> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> tF = com.baidu.poly.util.b.tF();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                tF.put(str, bundle.get(str).toString());
            }
        }
        tF.put("nop_method", "nuomi.integration_cashier.gatewaylist");
        tF.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, tF, bVar);
        HttpSigner.a(tF, this.agB);
        String d = d(this.agA, tF);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "getChannelList via url " + d);
        }
        this.agm.a(d, bVar, aVar == null ? null : new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.3
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

    private String d(String str, Map<String, String> map) {
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
