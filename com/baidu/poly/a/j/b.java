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
    public static int bvK = 1;
    private static String bvL;

    /* loaded from: classes11.dex */
    static class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.j.a bvJ;

        a(com.baidu.poly.a.j.a aVar) {
            this.bvJ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            a.C0240a c0240a = new a.C0240a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    c0240a.statusCode = 0;
                    c0240a.message = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    c0240a.bvG = optJSONObject.optLong("totalAmount");
                    c0240a.bvH = optJSONObject.optLong("userPayAmount");
                    c0240a.bvI = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0240a.statusCode = jSONObject.optInt("errorLevel", 2);
                    c0240a.message = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                c0240a.statusCode = 2;
                c0240a.message = g.Nj().getResources().getString(b.g.calculate_price_default_error);
            }
            this.bvJ.a(c0240a);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.C0240a c0240a = new a.C0240a();
            c0240a.statusCode = 2;
            c0240a.message = g.Nj().getResources().getString(b.g.calculate_price_default_error);
            this.bvJ.a(c0240a);
        }
    }

    private static void Nd() {
        if (bvK == 1) {
            bvL = "https://etrade.baidu.com/trade/order/calcMoney";
        } else {
            bvL = "http://sandbox.y.nuomi.com/c/order/calcMoney";
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, com.baidu.poly.a.j.a aVar) {
        Nd();
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
        new f().a(bvL, cVar, bVar, new a(aVar));
    }
}
