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
    private static String byU = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private static String byV = "nop_method";
    private static String byW = "nop_timestamp";
    private static String byX = "payChannel";
    private static volatile a byY = null;
    private static String rc = "payType";
    private final String byZ = NV();
    private final int bza;
    private e bzb;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0240a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a byQ;

        C0240a(com.baidu.poly.a.a.a aVar) {
            this.byQ = aVar;
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
                        this.byQ.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.byQ.a(optJSONObject);
                    }
                } else {
                    com.baidu.poly.a.g.a.a("7", optInt2 + "", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    this.byQ.a(new com.baidu.poly.a.h.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                com.baidu.poly.a.g.a.a("7", null, null);
                this.byQ.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.g.a.h("7");
            this.byQ.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a byQ;

        b(com.baidu.poly.a.a.a aVar) {
            this.byQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.byQ.a(a.this.aa(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.g.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.byQ.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), jSONObject.optString("msg"));
                }
            } catch (Throwable th) {
                com.baidu.poly.a.g.a.a("8", null, null);
                this.byQ.a(th, g.Os().getResources().getString(b.g.common_error_tips));
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.g.a.h("8");
            this.byQ.a(th, g.Os().getResources().getString(b.g.common_error_tips));
        }
    }

    /* loaded from: classes11.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a byQ;

        c(com.baidu.poly.a.a.a aVar) {
            this.byQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.byQ.a(a.this.aa(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.g.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.byQ.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                com.baidu.poly.a.g.a.a("8", null, null);
                this.byQ.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.g.a.h("8");
            this.byQ.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a byQ;

        d(com.baidu.poly.a.a.a aVar) {
            this.byQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.byQ.a(jSONObject.optJSONObject("data"));
                } else {
                    this.byQ.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.byQ.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.byQ.a(th, str);
        }
    }

    private a(e eVar, int i) {
        this.bzb = eVar;
        this.bza = i;
        com.baidu.poly.a.j.b.bAB = i;
    }

    public static a NU() {
        if (byY == null) {
            dS(1);
        }
        return byY;
    }

    private String NV() {
        int i = this.bza;
        return i != 1 ? i != 3 ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest" : "https://nop.nuomi.com/nop/server/rest";
    }

    private com.baidu.poly.a.a.c NW() {
        return new com.baidu.poly.a.a.c();
    }

    public static void dS(int i) {
        if (byY == null) {
            synchronized (a.class) {
                if (byY == null) {
                    byY = new a(new f(), i);
                }
            }
        }
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c NW = NW();
        com.baidu.poly.a.a.b a = a(bundle, NW);
        this.bzb.a(this.byZ, NW, a, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c NW = NW();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        bVar.g(byV, "nuomi.pay_platform.sdkAdaptH5QueryPay");
        bVar.g(byW, String.valueOf(System.currentTimeMillis()));
        HttpSigner.a(bVar, this.bza);
        this.bzb.a(this.byZ, NW, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c NW = NW();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        bVar.g(byV, "nuomi.integration_cashier.gatewaylist");
        bVar.g(byW, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, NW);
        HttpSigner.a(bVar, this.bza);
        this.bzb.a(this.byZ, NW, bVar, new C0240a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> aa(JSONObject jSONObject) {
        Map<String, String> Or = com.baidu.poly.util.e.Or();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    Or.put(next, jSONObject.optString(next));
                }
            }
        }
        return Or;
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar, String str) {
        com.baidu.poly.a.a.c NW = NW();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.g(str2, bundle.get(str2).toString());
            }
        }
        bVar.g(byV, "nuomi.integration_cashier.launchpayment");
        bVar.g(byW, String.valueOf(System.currentTimeMillis()));
        bVar.g(byX, str);
        a(bundle, bVar, NW);
        HttpSigner.a(bVar, this.bza);
        this.bzb.a(this.byZ, NW, bVar, new b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.g(rc, "android");
        bVar.g(byV, "nuomi.pay_platform.pay");
        bVar.g(byW, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, cVar);
        HttpSigner.a(bVar, this.bza);
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
            bVar.g("bduss", byU);
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
