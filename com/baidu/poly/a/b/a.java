package com.baidu.poly.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.poly.a.a.e;
import com.baidu.poly.a.a.f;
import com.baidu.poly.util.HttpSigner;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static String aKQ = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static String aKR = "nop_method";
    private static String aKS = "nop_timestamp";
    private static String aKT = "payChannel";
    private static String aKU = "payType";
    private static volatile a aKV;
    private final String aKW = nH();
    private final int aKX;
    private e aKY;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0144a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aKM;

        C0144a(com.baidu.poly.a.a.a aVar) {
            this.aKM = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errCode", -1);
                int optInt2 = jSONObject.optInt("errno", -1);
                if (optInt == 0 && optInt2 == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        this.aKM.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.aKM.a(optJSONObject);
                    }
                } else {
                    this.aKM.a(new com.baidu.poly.a.h.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                this.aKM.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aKM.a(th, str);
        }
    }

    /* loaded from: classes9.dex */
    class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aKM;

        b(com.baidu.poly.a.a.a aVar) {
            this.aKM = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aKM.a(a.this.I(jSONObject.optJSONObject("data")));
                } else {
                    this.aKM.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aKM.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aKM.a(th, str);
        }
    }

    /* loaded from: classes9.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aKM;

        c(com.baidu.poly.a.a.a aVar) {
            this.aKM = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aKM.a(a.this.I(jSONObject.optJSONObject("data")));
                } else {
                    this.aKM.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aKM.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aKM.a(th, str);
        }
    }

    /* loaded from: classes9.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aKM;

        d(com.baidu.poly.a.a.a aVar) {
            this.aKM = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aKM.a(jSONObject.optJSONObject("data"));
                } else {
                    this.aKM.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aKM.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aKM.a(th, str);
        }
    }

    private a(e eVar, int i) {
        this.aKY = eVar;
        this.aKX = i;
        com.baidu.poly.a.j.b.aMw = i;
    }

    public static a BG() {
        if (aKV == null) {
            init(1);
        }
        return aKV;
    }

    private com.baidu.poly.a.a.c BH() {
        return new com.baidu.poly.a.a.c();
    }

    public static void init(int i) {
        if (aKV == null) {
            synchronized (a.class) {
                if (aKV == null) {
                    aKV = new a(new f(), i);
                }
            }
        }
    }

    private String nH() {
        int i = this.aKX;
        return i != 1 ? i != 3 ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest" : "https://nop.nuomi.com/nop/server/rest";
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c BH = BH();
        com.baidu.poly.a.a.b a = a(bundle, BH);
        this.aKY.a(this.aKW, BH, a, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c BH = BH();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(aKR, "nuomi.pay_platform.sdkAdaptH5QueryPay");
        bVar.f(aKS, String.valueOf(System.currentTimeMillis()));
        HttpSigner.a(bVar, this.aKX);
        this.aKY.a(this.aKW, BH, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c BH = BH();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(aKR, "nuomi.integration_cashier.gatewaylist");
        bVar.f(aKS, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, BH);
        HttpSigner.a(bVar, this.aKX);
        this.aKY.a(this.aKW, BH, bVar, new C0144a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> I(JSONObject jSONObject) {
        Map<String, String> p = com.baidu.poly.util.d.p();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    p.put(next, jSONObject.optString(next));
                }
            }
        }
        return p;
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar, String str) {
        com.baidu.poly.a.a.c BH = BH();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.f(str2, bundle.get(str2).toString());
            }
        }
        bVar.f(aKR, "nuomi.integration_cashier.launchpayment");
        bVar.f(aKS, String.valueOf(System.currentTimeMillis()));
        bVar.f(aKT, str);
        a(bundle, bVar, BH);
        HttpSigner.a(bVar, this.aKX);
        this.aKY.a(this.aKW, BH, bVar, new b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.f(aKU, PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f(aKR, "nuomi.pay_platform.pay");
        bVar.f(aKS, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, cVar);
        HttpSigner.a(bVar, this.aKX);
        return bVar;
    }

    private void a(com.baidu.poly.a.a.b bVar, Bundle bundle) {
        if (bundle != null && bVar != null) {
            for (String str : bundle.keySet()) {
                bVar.f(str, bundle.getString(str));
            }
            Iterator<Map.Entry<String, String>> it = bVar.getMap().entrySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next().getValue())) {
                    it.remove();
                }
            }
        }
    }

    private void a(Bundle bundle, com.baidu.poly.a.a.b bVar, com.baidu.poly.a.a.c cVar) {
        String string = bundle.getString("bduss");
        if (!TextUtils.isEmpty(string)) {
            bVar.f("bduss", aKQ);
            String str = cVar.get(SM.COOKIE);
            String str2 = "BDUSS=" + string;
            if (str == null) {
                cVar.f(SM.COOKIE, str2);
            } else {
                cVar.f(SM.COOKIE, str + "; " + str2);
            }
        }
    }
}
