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
/* loaded from: classes11.dex */
public class a {
    private static String aQA = "payType";
    private static volatile a aQB = null;
    private static String aQw = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static String aQx = "nop_method";
    private static String aQy = "nop_timestamp";
    private static String aQz = "payChannel";
    private final String aQC = op();
    private final int aQD;
    private e aQE;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0155a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aQs;

        C0155a(com.baidu.poly.a.a.a aVar) {
            this.aQs = aVar;
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
                        this.aQs.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.aQs.a(optJSONObject);
                    }
                } else {
                    this.aQs.a(new com.baidu.poly.a.h.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                this.aQs.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aQs.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aQs;

        b(com.baidu.poly.a.a.a aVar) {
            this.aQs = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aQs.a(a.this.I(jSONObject.optJSONObject("data")));
                } else {
                    this.aQs.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aQs.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aQs.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aQs;

        c(com.baidu.poly.a.a.a aVar) {
            this.aQs = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aQs.a(a.this.I(jSONObject.optJSONObject("data")));
                } else {
                    this.aQs.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aQs.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aQs.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a aQs;

        d(com.baidu.poly.a.a.a aVar) {
            this.aQs = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.aQs.a(jSONObject.optJSONObject("data"));
                } else {
                    this.aQs.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.aQs.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.aQs.a(th, str);
        }
    }

    private a(e eVar, int i) {
        this.aQE = eVar;
        this.aQD = i;
        com.baidu.poly.a.j.b.aSc = i;
    }

    public static a EG() {
        if (aQB == null) {
            init(1);
        }
        return aQB;
    }

    private com.baidu.poly.a.a.c EH() {
        return new com.baidu.poly.a.a.c();
    }

    public static void init(int i) {
        if (aQB == null) {
            synchronized (a.class) {
                if (aQB == null) {
                    aQB = new a(new f(), i);
                }
            }
        }
    }

    private String op() {
        int i = this.aQD;
        return i != 1 ? i != 3 ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest" : "https://nop.nuomi.com/nop/server/rest";
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c EH = EH();
        com.baidu.poly.a.a.b a = a(bundle, EH);
        this.aQE.a(this.aQC, EH, a, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c EH = EH();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(aQx, "nuomi.pay_platform.sdkAdaptH5QueryPay");
        bVar.f(aQy, String.valueOf(System.currentTimeMillis()));
        HttpSigner.a(bVar, this.aQD);
        this.aQE.a(this.aQC, EH, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c EH = EH();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(aQx, "nuomi.integration_cashier.gatewaylist");
        bVar.f(aQy, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, EH);
        HttpSigner.a(bVar, this.aQD);
        this.aQE.a(this.aQC, EH, bVar, new C0155a(aVar));
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
        com.baidu.poly.a.a.c EH = EH();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.f(str2, bundle.get(str2).toString());
            }
        }
        bVar.f(aQx, "nuomi.integration_cashier.launchpayment");
        bVar.f(aQy, String.valueOf(System.currentTimeMillis()));
        bVar.f(aQz, str);
        a(bundle, bVar, EH);
        HttpSigner.a(bVar, this.aQD);
        this.aQE.a(this.aQC, EH, bVar, new b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.f(aQA, PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f(aQx, "nuomi.pay_platform.pay");
        bVar.f(aQy, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, cVar);
        HttpSigner.a(bVar, this.aQD);
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
            bVar.f("bduss", aQw);
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
