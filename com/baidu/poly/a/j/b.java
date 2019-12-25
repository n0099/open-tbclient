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
/* loaded from: classes9.dex */
public class b {
    public static int aMw = 1;
    private static String aMx;

    /* loaded from: classes9.dex */
    static class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.j.a aMv;

        a(com.baidu.poly.a.j.a aVar) {
            this.aMv = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            a.C0150a c0150a = new a.C0150a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno") == 0) {
                    c0150a.statusCode = 0;
                    c0150a.message = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    c0150a.aMs = optJSONObject.optLong("totalAmount");
                    c0150a.aMt = optJSONObject.optLong("userPayAmount");
                    c0150a.aMu = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0150a.statusCode = jSONObject.optInt("errorLevel", 2);
                    c0150a.message = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                c0150a.statusCode = 2;
                c0150a.message = f.BQ().getResources().getString(b.g.calculate_price_default_error);
            }
            this.aMv.a(c0150a);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.C0150a c0150a = new a.C0150a();
            c0150a.statusCode = 2;
            c0150a.message = f.BQ().getResources().getString(b.g.calculate_price_default_error);
            this.aMv.a(c0150a);
        }
    }

    private static void T() {
        if (aMw == 1) {
            aMx = "https://etrade.baidu.com/trade/order/calcMoney";
        } else {
            aMx = "http://sandbox.y.nuomi.com/c/order/calcMoney";
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
        new com.baidu.poly.a.a.f().a(aMx, cVar, bVar, new a(aVar));
    }
}
