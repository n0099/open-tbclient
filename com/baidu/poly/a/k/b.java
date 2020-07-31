package com.baidu.poly.a.k;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.poly.a.a.c;
import com.baidu.poly.a.a.f;
import com.baidu.poly.a.b.d;
import com.baidu.poly.a.k.a;
import com.baidu.poly.b;
import com.baidu.poly.util.g;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {

    /* loaded from: classes9.dex */
    static class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.k.a bAQ;

        a(com.baidu.poly.a.k.a aVar) {
            this.bAQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            a.C0249a c0249a = new a.C0249a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                    c0249a.statusCode = 0;
                    c0249a.message = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    c0249a.bAN = optJSONObject.optLong("totalAmount");
                    c0249a.bAO = optJSONObject.optLong("userPayAmount");
                    c0249a.bAP = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0249a.statusCode = jSONObject.optInt("errorLevel", 2);
                    c0249a.message = jSONObject.optString("msg");
                }
            } catch (Exception e) {
                c0249a.statusCode = 2;
                c0249a.message = g.OA().getResources().getString(b.g.calculate_price_default_error);
            }
            this.bAQ.a(c0249a);
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.C0249a c0249a = new a.C0249a();
            c0249a.statusCode = 2;
            c0249a.message = g.OA().getResources().getString(b.g.calculate_price_default_error);
            this.bAQ.a(c0249a);
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, com.baidu.poly.a.k.a aVar) {
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
        new f().a(d.r(), cVar, bVar, new a(aVar));
    }
}
