package com.baidu.poly.a.j;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.poly.a.a.c;
import com.baidu.poly.a.j.a;
import com.baidu.poly.b;
import com.baidu.poly.util.f;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public static int bof = 1;
    private static String bog;

    /* loaded from: classes11.dex */
    static class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.j.a boe;

        a(com.baidu.poly.a.j.a aVar) {
            this.boe = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            a.C0185a c0185a = new a.C0185a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    c0185a.statusCode = 0;
                    c0185a.message = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    c0185a.bob = optJSONObject.optLong("totalAmount");
                    c0185a.boc = optJSONObject.optLong("userPayAmount");
                    c0185a.bod = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0185a.statusCode = jSONObject.optInt("errorLevel", 2);
                    c0185a.message = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                c0185a.statusCode = 2;
                c0185a.message = f.Lb().getResources().getString(b.g.calculate_price_default_error);
            }
            this.boe.a(c0185a);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.C0185a c0185a = new a.C0185a();
            c0185a.statusCode = 2;
            c0185a.message = f.Lb().getResources().getString(b.g.calculate_price_default_error);
            this.boe.a(c0185a);
        }
    }

    private static void T() {
        if (bof == 1) {
            bog = "https://etrade.baidu.com/trade/order/calcMoney";
        } else {
            bog = "http://sandbox.y.nuomi.com/c/order/calcMoney";
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
        new com.baidu.poly.a.a.f().a(bog, cVar, bVar, new a(aVar));
    }
}
