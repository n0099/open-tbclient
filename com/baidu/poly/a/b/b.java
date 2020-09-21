package com.baidu.poly.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.poly.a.a.e;
import com.baidu.poly.a.a.f;
import com.baidu.poly.b;
import com.baidu.poly.util.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static String bGU = "payChannel";
    private static String bGV = "payType";
    private static volatile b bGW;
    private e bGX;

    /* loaded from: classes9.dex */
    class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bGO;

        a(com.baidu.poly.a.a.a aVar) {
            this.bGO = aVar;
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
                        com.baidu.poly.a.h.a.a("7", optInt2 + "", jSONObject.optString("msg"));
                        this.bGO.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.bGO.a(optJSONObject);
                    }
                } else {
                    com.baidu.poly.a.h.a.a("7", optInt2 + "", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    this.bGO.a(new com.baidu.poly.a.i.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                com.baidu.poly.a.h.a.a("7", null, null);
                this.bGO.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.h.a.i("7");
            this.bGO.a(th, str);
        }
    }

    /* renamed from: com.baidu.poly.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0260b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bGO;

        C0260b(com.baidu.poly.a.a.a aVar) {
            this.bGO = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.bGO.a(b.this.af(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.h.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.bGO.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), jSONObject.optString("msg"));
                }
            } catch (Throwable th) {
                com.baidu.poly.a.h.a.a("8", null, null);
                this.bGO.a(th, g.Vb().getResources().getString(b.g.common_error_tips));
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.h.a.i("8");
            this.bGO.a(th, g.Vb().getResources().getString(b.g.common_error_tips));
        }
    }

    /* loaded from: classes9.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bGO;

        c(com.baidu.poly.a.a.a aVar) {
            this.bGO = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.bGO.a(b.this.af(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.h.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.bGO.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                com.baidu.poly.a.h.a.a("8", null, null);
                this.bGO.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.h.a.i("8");
            this.bGO.a(th, str);
        }
    }

    /* loaded from: classes9.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a bGO;

        d(com.baidu.poly.a.a.a aVar) {
            this.bGO = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.bGO.a(jSONObject.optJSONObject("data"));
                } else {
                    this.bGO.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.bGO.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.bGO.a(th, str);
        }
    }

    private b(e eVar) {
        this.bGX = eVar;
    }

    public static b UC() {
        if (bGW == null) {
            synchronized (b.class) {
                if (bGW == null) {
                    bGW = new b(new f());
                }
            }
        }
        return bGW;
    }

    private com.baidu.poly.a.a.c UD() {
        return new com.baidu.poly.a.a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> af(JSONObject jSONObject) {
        Map<String, String> Va = com.baidu.poly.util.e.Va();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    Va.put(next, jSONObject.optString(next));
                }
            }
        }
        return Va;
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c UD = UD();
        com.baidu.poly.a.a.b a2 = a(bundle, UD);
        this.bGX.a(com.baidu.poly.a.b.d.y(), UD, a2, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c UD = UD();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        this.bGX.a(com.baidu.poly.a.b.d.z(), UD, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c UD = UD();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        a(bundle, bVar, UD);
        this.bGX.a(com.baidu.poly.a.b.d.u(), UD, bVar, new a(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar, String str) {
        com.baidu.poly.a.a.c UD = UD();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.g(str2, bundle.get(str2).toString());
            }
        }
        bVar.g(bGU, str);
        a(bundle, bVar, UD);
        this.bGX.a(com.baidu.poly.a.b.d.x(), UD, bVar, new C0260b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.g(bGV, "android");
        a(bundle, bVar, cVar);
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
