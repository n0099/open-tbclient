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
    private static String ahO = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static a ahP;
    private d ahB;
    private final String ahQ = uv();
    private final int ahR;

    private a(d dVar, int i) {
        this.ahB = dVar;
        this.ahR = i;
    }

    public static void a(d dVar, int i) {
        ahP = new a(dVar, i);
    }

    public static a uu() {
        return ahP;
    }

    private String uv() {
        return this.ahR == a.b.ONLINE ? "https://nop.nuomi.com/nop/server/rest" : this.ahR == a.b.ahF ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest";
    }

    public void a(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> uE = com.baidu.poly.util.b.uE();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                uE.put(str, bundle.get(str).toString());
            }
        }
        uE.put("nop_method", "nuomi.integration_cashier.launchpayment");
        uE.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uE, bVar);
        HttpSigner.a(uE, this.ahR);
        String e = e(this.ahQ, uE);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + e);
        }
        this.ahB.a(e, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.1
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
                Map<String, String> uE2 = com.baidu.poly.util.b.uE();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            uE2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return uE2;
            }

            @Override // com.baidu.poly.a.a
            public void b(Throwable th, String str2) {
                aVar.b(th, str2);
            }
        });
    }

    public void b(Bundle bundle, final com.baidu.poly.a.a<Map<String, String>> aVar) {
        b bVar = new b();
        Map<String, String> uE = com.baidu.poly.util.b.uE();
        a(uE, bundle);
        uE.put("payType", HttpConstants.OS_TYPE_VALUE);
        uE.put("nop_method", "nuomi.pay_platform.pay");
        uE.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uE, bVar);
        HttpSigner.a(uE, this.ahR);
        String e = e(this.ahQ, uE);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "launchPayment via url " + e);
        }
        this.ahB.a(e, bVar, new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.2
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
                Map<String, String> uE2 = com.baidu.poly.util.b.uE();
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            uE2.put(next, jSONObject.optString(next));
                        }
                    }
                }
                return uE2;
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
            map.put("bduss", ahO);
            String str = bVar.get(SM.COOKIE);
            String str2 = "BDUSS=" + string;
            if (str == null) {
                bVar.ah(SM.COOKIE, str2);
            } else {
                bVar.ah(SM.COOKIE, str + "; " + str2);
            }
        }
    }

    public void c(Bundle bundle, final com.baidu.poly.a.a<PayChannel[]> aVar) {
        b bVar = new b();
        Set<String> keySet = bundle.keySet();
        Map<String, String> uE = com.baidu.poly.util.b.uE();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                uE.put(str, bundle.get(str).toString());
            }
        }
        uE.put("nop_method", "nuomi.integration_cashier.gatewaylist");
        uE.put("nop_timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(bundle, uE, bVar);
        HttpSigner.a(uE, this.ahR);
        String e = e(this.ahQ, uE);
        if (Log.isLoggable(TAG, 4)) {
            Log.i(TAG, "getChannelList via url " + e);
        }
        this.ahB.a(e, bVar, aVar == null ? null : new com.baidu.poly.a.a<String>() { // from class: com.baidu.poly.a.a.a.3
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
