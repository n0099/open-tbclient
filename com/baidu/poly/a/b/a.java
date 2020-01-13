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
/* loaded from: classes10.dex */
public class a {
    private static String aLI = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static String aLJ = "nop_method";
    private static String aLK = "nop_timestamp";
    private static String aLL = "payChannel";
    private static String aLM = "payType";
    private static volatile a aLN;
    private final String aLO = nI();
    private final int aLP;
    private e aLQ;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0146a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aLE;

        C0146a(com.baidu.poly.a.a.a aVar) {
            this.aLE = aVar;
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
                        this.aLE.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.aLE.a(optJSONObject);
                    }
                } else {
                    this.aLE.a(new com.baidu.poly.a.h.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                this.aLE.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aLE.a(th, str);
        }
    }

    /* loaded from: classes10.dex */
    class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aLE;

        b(com.baidu.poly.a.a.a aVar) {
            this.aLE = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aLE.a(a.this.I(jSONObject.optJSONObject("data")));
                } else {
                    this.aLE.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aLE.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aLE.a(th, str);
        }
    }

    /* loaded from: classes10.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aLE;

        c(com.baidu.poly.a.a.a aVar) {
            this.aLE = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aLE.a(a.this.I(jSONObject.optJSONObject("data")));
                } else {
                    this.aLE.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aLE.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aLE.a(th, str);
        }
    }

    /* loaded from: classes10.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aLE;

        d(com.baidu.poly.a.a.a aVar) {
            this.aLE = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aLE.a(jSONObject.optJSONObject("data"));
                } else {
                    this.aLE.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aLE.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aLE.a(th, str);
        }
    }

    private a(e eVar, int i) {
        this.aLQ = eVar;
        this.aLP = i;
        com.baidu.poly.a.j.b.aNo = i;
    }

    public static a Cc() {
        if (aLN == null) {
            init(1);
        }
        return aLN;
    }

    private com.baidu.poly.a.a.c Cd() {
        return new com.baidu.poly.a.a.c();
    }

    public static void init(int i) {
        if (aLN == null) {
            synchronized (a.class) {
                if (aLN == null) {
                    aLN = new a(new f(), i);
                }
            }
        }
    }

    private String nI() {
        int i = this.aLP;
        return i != 1 ? i != 3 ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest" : "https://nop.nuomi.com/nop/server/rest";
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c Cd = Cd();
        com.baidu.poly.a.a.b a = a(bundle, Cd);
        this.aLQ.a(this.aLO, Cd, a, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c Cd = Cd();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(aLJ, "nuomi.pay_platform.sdkAdaptH5QueryPay");
        bVar.f(aLK, String.valueOf(System.currentTimeMillis()));
        HttpSigner.a(bVar, this.aLP);
        this.aLQ.a(this.aLO, Cd, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c Cd = Cd();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(aLJ, "nuomi.integration_cashier.gatewaylist");
        bVar.f(aLK, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, Cd);
        HttpSigner.a(bVar, this.aLP);
        this.aLQ.a(this.aLO, Cd, bVar, new C0146a(aVar));
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
        com.baidu.poly.a.a.c Cd = Cd();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.f(str2, bundle.get(str2).toString());
            }
        }
        bVar.f(aLJ, "nuomi.integration_cashier.launchpayment");
        bVar.f(aLK, String.valueOf(System.currentTimeMillis()));
        bVar.f(aLL, str);
        a(bundle, bVar, Cd);
        HttpSigner.a(bVar, this.aLP);
        this.aLQ.a(this.aLO, Cd, bVar, new b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.f(aLM, PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f(aLJ, "nuomi.pay_platform.pay");
        bVar.f(aLK, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, cVar);
        HttpSigner.a(bVar, this.aLP);
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
            bVar.f("bduss", aLI);
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
