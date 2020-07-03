package com.baidu.poly.a.j;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.poly.a.a.c;
import com.baidu.poly.a.a.f;
import com.baidu.poly.a.j.a;
import com.baidu.poly.b;
import com.baidu.poly.util.g;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public static int bAB = 1;
    private static String bAC;

    /* loaded from: classes11.dex */
    static class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.j.a bAA;

        a(com.baidu.poly.a.j.a aVar) {
            this.bAA = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            a.C0246a c0246a = new a.C0246a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    c0246a.statusCode = 0;
                    c0246a.message = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    c0246a.bAx = optJSONObject.optLong("totalAmount");
                    c0246a.bAy = optJSONObject.optLong("userPayAmount");
                    c0246a.bAz = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0246a.statusCode = jSONObject.optInt("errorLevel", 2);
                    c0246a.message = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                c0246a.statusCode = 2;
                c0246a.message = g.Os().getResources().getString(b.g.calculate_price_default_error);
            }
            this.bAA.a(c0246a);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.C0246a c0246a = new a.C0246a();
            c0246a.statusCode = 2;
            c0246a.message = g.Os().getResources().getString(b.g.calculate_price_default_error);
            this.bAA.a(c0246a);
        }
    }

    private static void Om() {
        if (bAB == 1) {
            bAC = "https://etrade.baidu.com/trade/order/calcMoney";
        } else {
            bAC = "http://sandbox.y.nuomi.com/c/order/calcMoney";
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, com.baidu.poly.a.j.a aVar) {
        Om();
        c cVar = new c();
        if (!TextUtils.isEmpty(str)) {
            cVar.g(SM.COOKIE, "BDUSS=" + str);
        }
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.g("appKey", str2);
        bVar.g("totalAmount", str3);
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
            bVar.g("hostMarketingDetail", jSONArray.toString());
        }
        new f().a(bAC, cVar, bVar, new a(aVar));
    }
}
