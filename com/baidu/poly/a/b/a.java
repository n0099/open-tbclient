package com.baidu.poly.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.poly.a.a.e;
import com.baidu.poly.a.a.f;
import com.baidu.poly.util.HttpSigner;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static String bmA = "nop_method";
    private static String bmB = "nop_timestamp";
    private static String bmC = "payChannel";
    private static String bmD = "payType";
    private static volatile a bmE = null;
    private static String bmz = "b249MzEuMTg1NjM0JTJDMTIxLjYxMjgzJg==";
    private final String bmF = sJ();
    private final int bmG;
    private e bmH;

    /* renamed from: com.baidu.poly.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0179a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bmv;

        C0179a(com.baidu.poly.a.a.a aVar) {
            this.bmv = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errCode", -1);
                int optInt2 = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0 && optInt2 == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        this.bmv.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.bmv.a(optJSONObject);
                    }
                } else {
                    this.bmv.a(new com.baidu.poly.a.h.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                this.bmv.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bmv.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bmv;

        b(com.baidu.poly.a.a.a aVar) {
            this.bmv = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.bmv.a(a.this.O(jSONObject.optJSONObject("data")));
                } else {
                    this.bmv.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.bmv.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bmv.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bmv;

        c(com.baidu.poly.a.a.a aVar) {
            this.bmv = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.bmv.a(a.this.O(jSONObject.optJSONObject("data")));
                } else {
                    this.bmv.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.bmv.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bmv.a(th, str);
        }
    }

    /* loaded from: classes11.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bmv;

        d(com.baidu.poly.a.a.a aVar) {
            this.bmv = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.bmv.a(jSONObject.optJSONObject("data"));
                } else {
                    this.bmv.a(new com.baidu.poly.a.h.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.bmv.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bmv.a(th, str);
        }
    }

    private a(e eVar, int i) {
        this.bmH = eVar;
        this.bmG = i;
        com.baidu.poly.a.j.b.bof = i;
    }

    public static a KR() {
        if (bmE == null) {
            dz(1);
        }
        return bmE;
    }

    private com.baidu.poly.a.a.c KS() {
        return new com.baidu.poly.a.a.c();
    }

    public static void dz(int i) {
        if (bmE == null) {
            synchronized (a.class) {
                if (bmE == null) {
                    bmE = new a(new f(), i);
                }
            }
        }
    }

    private String sJ() {
        int i = this.bmG;
        return i != 1 ? i != 3 ? "http://nj03-orp-app0650.nj03.baidu.com:8222/nop/server/rest" : "http://sh01-orp-app0763.sh01.baidu.com:8290/nop/server/rest" : "https://nop.nuomi.com/nop/server/rest";
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c KS = KS();
        com.baidu.poly.a.a.b a = a(bundle, KS);
        this.bmH.a(this.bmF, KS, a, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c KS = KS();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(bmA, "nuomi.pay_platform.sdkAdaptH5QueryPay");
        bVar.f(bmB, String.valueOf(System.currentTimeMillis()));
        HttpSigner.a(bVar, this.bmG);
        this.bmH.a(this.bmF, KS, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c KS = KS();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.f(str, bundle.get(str).toString());
            }
        }
        bVar.f(bmA, "nuomi.integration_cashier.gatewaylist");
        bVar.f(bmB, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, KS);
        HttpSigner.a(bVar, this.bmG);
        this.bmH.a(this.bmF, KS, bVar, new C0179a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> O(JSONObject jSONObject) {
        Map<String, String> La = com.baidu.poly.util.d.La();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    La.put(next, jSONObject.optString(next));
                }
            }
        }
        return La;
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar, String str) {
        com.baidu.poly.a.a.c KS = KS();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.f(str2, bundle.get(str2).toString());
            }
        }
        bVar.f(bmA, "nuomi.integration_cashier.launchpayment");
        bVar.f(bmB, String.valueOf(System.currentTimeMillis()));
        bVar.f(bmC, str);
        a(bundle, bVar, KS);
        HttpSigner.a(bVar, this.bmG);
        this.bmH.a(this.bmF, KS, bVar, new b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.f(bmD, "android");
        bVar.f(bmA, "nuomi.pay_platform.pay");
        bVar.f(bmB, String.valueOf(System.currentTimeMillis()));
        a(bundle, bVar, cVar);
        HttpSigner.a(bVar, this.bmG);
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
            bVar.f("bduss", bmz);
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
