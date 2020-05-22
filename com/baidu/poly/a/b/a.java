package com.baidu.poly.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.poly.a.a.e;
import com.baidu.poly.a.a.f;
import com.baidu.poly.b;
import com.baidu.poly.util.HttpSigner;
import com.baidu.poly.util.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static String bub = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static String buc = "nop_method";
    private static String bud = "nop_timestamp";
    private static String bue = "payChannel";
    private static volatile a bug = null;
    private static String rc = "payType";
    private final String buh = MM();
    private final int bui;
    private e buj;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0234a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a btX;

        C0234a(com.baidu.poly.a.a.a aVar) {
            this.btX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errCode", -1);
                int optInt2 = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0 && optInt2 == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        com.baidu.poly.a.g.a.a("7", optInt2 + "", jSONObject.optString("msg"));
                        this.btX.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.btX.a(optJSONObject);
                    }
                } else {
                    com.baidu.poly.a.g.a.a("7", optInt2 + "", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    this.btX.a(new com.baidu.poly.a.h.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                com.baidu.poly.a.g.a.a("7", null, null);
                this.btX.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.g.a.h("7");
            this.btX.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a btX;

        b(com.baidu.poly.a.a.a aVar) {
            this.btX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.btX.a(a.this.T(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.g.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.btX.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), jSONObject.optString("msg"));
                }
            } catch (Throwable th) {
                com.baidu.poly.a.g.a.a("8", null, null);
                this.btX.a(th, g.Nj().getResources().getString(b.g.common_error_tips));
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.g.a.h("8");
            this.btX.a(th, g.Nj().getResources().getString(b.g.common_error_tips));
        }
    }

    /* loaded from: classes11.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a btX;

        c(com.baidu.poly.a.a.a aVar) {
            this.btX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.btX.a(a.this.T(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.g.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.btX.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                com.baidu.poly.a.g.a.a("8", null, null);
                this.btX.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.g.a.h("8");
            this.btX.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a btX;

        d(com.baidu.poly.a.a.a aVar) {
            this.btX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.btX.a(jSONObject.optJSONObject("data"));
                } else {
                    this.btX.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.btX.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.btX.a(th, str);
        }
    }

    private a(e eVar, int i) {
        this.buj = eVar;
        this.bui = i;
        com.baidu.poly.a.j.b.bvK = i;
    }

    public static a ML() {
        if (bug == null) {
            dF(1);
        }
        return bug;
    }

    private String MM() {
        int i = this.bui;
        return i != 1 ? i != 3 ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest" : "https://nop.nuomi.com/nop/server/rest";
    }

    private com.baidu.poly.a.a.c MN() {
        return new com.baidu.poly.a.a.c();
    }

    public static void dF(int i) {
        if (bug == null) {
            synchronized (a.class) {
                if (bug == null) {
                    bug = new a(new f(), i);
                }
            }
        }
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c MN = MN();
        com.baidu.poly.a.a.b a = a(bundle, MN);
        this.buj.a(this.buh, MN, a, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c MN = MN();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        bVar.g(buc, "nuomi.pay_platform.sdkAdaptH5QueryPay");
        bVar.g(bud, String.valueOf(System.currentTimeMillis()));
        HttpSigner.a(bVar, this.bui);
        this.buj.a(this.buh, MN, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c MN = MN();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        bVar.g(buc, "nuomi.integration_cashier.gatewaylist");
        bVar.g(bud, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, MN);
        HttpSigner.a(bVar, this.bui);
        this.buj.a(this.buh, MN, bVar, new C0234a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> T(JSONObject jSONObject) {
        Map<String, String> Ni = com.baidu.poly.util.e.Ni();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    Ni.put(next, jSONObject.optString(next));
                }
            }
        }
        return Ni;
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar, String str) {
        com.baidu.poly.a.a.c MN = MN();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.g(str2, bundle.get(str2).toString());
            }
        }
        bVar.g(buc, "nuomi.integration_cashier.launchpayment");
        bVar.g(bud, String.valueOf(System.currentTimeMillis()));
        bVar.g(bue, str);
        a(bundle, bVar, MN);
        HttpSigner.a(bVar, this.bui);
        this.buj.a(this.buh, MN, bVar, new b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.g(rc, "android");
        bVar.g(buc, "nuomi.pay_platform.pay");
        bVar.g(bud, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, cVar);
        HttpSigner.a(bVar, this.bui);
        return bVar;
    }

    private void a(com.baidu.poly.a.a.b bVar, Bundle bundle) {
        if (bundle != null && bVar != null) {
            for (String str : bundle.keySet()) {
                bVar.g(str, bundle.getString(str));
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
            bVar.g("bduss", bub);
            String str = cVar.get(SM.COOKIE);
            String str2 = "BDUSS=" + string;
            if (str == null) {
                cVar.g(SM.COOKIE, str2);
            } else {
                cVar.g(SM.COOKIE, str + "; " + str2);
            }
        }
    }
}
