package com.baidu.poly.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.poly.a;
import com.baidu.poly.a.b;
import com.baidu.poly.a.d;
import com.baidu.poly.bean.PayChannel;
import com.baidu.poly.util.HttpSigner;
import com.baidu.webkit.internal.ETAG;
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
    private static String ahF = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static a ahG;
    private final String ahH = ur();
    private final int ahI;
    private d ahs;

    private a(d dVar, int i) {
        this.ahs = dVar;
        this.ahI = i;
    }

    public static void a(d dVar, int i) {
        ahG = new a(dVar, i);
    }

    public static a uq() {
        return ahG;
    }

    private String ur() {
        return this.ahI == a.b.ONLINE ? "https://nop.nuomi.com/nop/server/rest" : this.ahI == a.b.ahw ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest";
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> uA = com.baidu.poly.util.b.uA();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                uA.put(str, bundle.get(str).toString());
            }
        }
        uA.put("nop_method", "nuomi.integration_cashier.launchpayment");
        uA.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uA, bVar);
        HttpSigner.a(uA, this.ahI);
        String e = e(this.ahH, uA);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + e);
        }
        this.ahs.a(e, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(y(jSONObject.optJSONObject("data")));
                    } else {
                        b(new RuntimeException("errno:" + optInt), jSONObject.optString("errmsg"));
                    }
                } catch (Throwable th) {
                    b(th, null);
                }
            }

            private Map<String, String> y(JSONObject jSONObject) {
                Map<String, String> uA2 = com.baidu.poly.util.b.uA();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            uA2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return uA2;
            }

            @Override // com.baidu.poly.a.a
            public void b(Throwable th, String str2) {
                aVar.b(th, str2);
            }
        });
    }

    public void b(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        Map<String, String> uA = com.baidu.poly.util.b.uA();
        a(uA, bundle);
        uA.put("payType", HttpConstants.OS_TYPE_VALUE);
        uA.put("nop_method", "nuomi.pay_platform.pay");
        uA.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uA, bVar);
        HttpSigner.a(uA, this.ahI);
        String e = e(this.ahH, uA);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + e);
        }
        this.ahs.a(e, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.poly.a.a
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        aVar.onSuccess(y(jSONObject.optJSONObject("data")));
                    } else {
                        b(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    b(th, null);
                }
            }

            private Map<String, String> y(JSONObject jSONObject) {
                Map<String, String> uA2 = com.baidu.poly.util.b.uA();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            uA2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return uA2;
            }

            @Override // com.baidu.poly.a.a
            public void b(Throwable th, String str) {
                aVar.b(th, str);
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
            map.put("bduss", ahF);
            String str = bVar.get(SM.COOKIE);
            String str2 = "BDUSS=" + string;
            if (str == null) {
                bVar.ag(SM.COOKIE, str2);
            } else {
                bVar.ag(SM.COOKIE, str + "; " + str2);
            }
        }
    }

    public void c(Bundle bundle, final com.baidu.poly.a.a<PayChannel[]> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> uA = com.baidu.poly.util.b.uA();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                uA.put(str, bundle.get(str).toString());
            }
        }
        uA.put("nop_method", "nuomi.integration_cashier.gatewaylist");
        uA.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uA, bVar);
        HttpSigner.a(uA, this.ahI);
        String e = e(this.ahH, uA);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "getChannelList via url " + e);
        }
        this.ahs.a(e, bVar, aVar == null ? null : new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.3
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
                        aVar.b(new RuntimeException("data is empty"), jSONObject.optString("msg"));
                        return;
                    }
                    aVar.b(new RuntimeException("errno:" + optInt), jSONObject.optString("msg"));
                } catch (Throwable th) {
                    b(th, null);
                }
            }

            @Override // com.baidu.poly.a.a
            public void b(Throwable th, String str2) {
                aVar.b(th, str2);
            }
        });
    }

    private String e(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        } else {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                sb.append(entry.getKey()).append(ETAG.EQUAL).append(URLEncoder.encode(value)).append(ETAG.ITEM_SEPARATOR);
            }
        }
        return sb.toString();
    }
}
