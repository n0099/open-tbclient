package com.baidu.poly.a.j;

import android.text.TextUtils;
import com.baidu.poly.a.a.c;
import com.baidu.poly.a.j.a;
import com.baidu.poly.b;
import com.baidu.poly.util.f;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static int aNo = 1;
    private static String aNp;

    /* loaded from: classes10.dex */
    static class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.j.a aNn;

        a(com.baidu.poly.a.j.a aVar) {
            this.aNn = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            a.C0152a c0152a = new a.C0152a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno") == 0) {
                    c0152a.statusCode = 0;
                    c0152a.message = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    c0152a.aNk = optJSONObject.optLong("totalAmount");
                    c0152a.aNl = optJSONObject.optLong("userPayAmount");
                    c0152a.aNm = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0152a.statusCode = jSONObject.optInt("errorLevel", 2);
                    c0152a.message = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                c0152a.statusCode = 2;
                c0152a.message = f.Cm().getResources().getString(b.g.calculate_price_default_error);
            }
            this.aNn.a(c0152a);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.C0152a c0152a = new a.C0152a();
            c0152a.statusCode = 2;
            c0152a.message = f.Cm().getResources().getString(b.g.calculate_price_default_error);
            this.aNn.a(c0152a);
        }
    }

    private static void T() {
        if (aNo == 1) {
            aNp = "https://etrade.baidu.com/trade/order/calcMoney";
        } else {
            aNp = "http://sandbox.y.nuomi.com/c/order/calcMoney";
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, com.baidu.poly.a.j.a aVar) {
        T();
        c cVar = new c();
        if (!TextUtils.isEmpty(str)) {
            cVar.f(SM.COOKIE, "BDUSS=" + str);
        }
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("appKey", str2);
        bVar.f("totalAmount", str3);
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (String str4 : list) {
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        jSONArray.put(new JSONObject(str4));
                    } catch (Exception e) {
                    }
                }
            }
            bVar.f("hostMarketingDetail", jSONArray.toString());
        }
        new com.baidu.poly.a.a.f().a(aNp, cVar, bVar, new a(aVar));
    }
}
