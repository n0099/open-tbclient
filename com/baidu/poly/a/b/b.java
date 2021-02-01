package com.baidu.poly.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
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
/* loaded from: classes4.dex */
public class b {
    private static String cne = "payChannel";
    private static String cnf = "payType";
    private static volatile b cng;
    private e cnh;

    /* loaded from: classes4.dex */
    class a extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a cmX;

        a(com.baidu.poly.a.a.a aVar) {
            this.cmX = aVar;
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
                        this.cmX.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), "data is empty");
                    } else {
                        this.cmX.a(optJSONObject);
                    }
                } else {
                    com.baidu.poly.a.h.a.a("7", optInt2 + "", jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                    this.cmX.a(new com.baidu.poly.a.i.b("errmsg = " + jSONObject.optString(BaseJsonData.TAG_ERRMSG)), "errno is " + optInt2);
                }
            } catch (JSONException e) {
                com.baidu.poly.a.h.a.a("7", null, null);
                this.cmX.a(e, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.h.a.i("7");
            this.cmX.a(th, str);
        }
    }

    /* renamed from: com.baidu.poly.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0297b extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a cmX;

        C0297b(com.baidu.poly.a.a.a aVar) {
            this.cmX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.cmX.a(b.this.ax(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.h.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.cmX.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), jSONObject.optString("msg"));
                }
            } catch (Throwable th) {
                com.baidu.poly.a.h.a.a("8", null, null);
                this.cmX.a(th, g.adH().getResources().getString(b.g.common_error_tips));
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.h.a.i("8");
            this.cmX.a(th, g.adH().getResources().getString(b.g.common_error_tips));
        }
    }

    /* loaded from: classes4.dex */
    class c extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a cmX;

        c(com.baidu.poly.a.a.a aVar) {
            this.cmX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.cmX.a(b.this.ax(jSONObject.optJSONObject("data")));
                } else {
                    com.baidu.poly.a.h.a.a("8", optInt + "", jSONObject.optString("msg"));
                    this.cmX.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                com.baidu.poly.a.h.a.a("8", null, null);
                this.cmX.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            com.baidu.poly.a.h.a.i("8");
            this.cmX.a(th, str);
        }
    }

    /* loaded from: classes4.dex */
    class d extends com.baidu.poly.a.a.a<String> {
        final /* synthetic */ com.baidu.poly.a.a.a cmX;

        d(com.baidu.poly.a.a.a aVar) {
            this.cmX = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        /* renamed from: b */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1);
                if (optInt == 0) {
                    this.cmX.a(jSONObject.optJSONObject("data"));
                } else {
                    this.cmX.a(new com.baidu.poly.a.i.b("msg = " + jSONObject.optString("msg")), "errno is " + optInt);
                }
            } catch (Throwable th) {
                this.cmX.a(th, BdStatsConstant.StatsType.ERROR);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            this.cmX.a(th, str);
        }
    }

    private b(e eVar) {
        this.cnh = eVar;
    }

    public static b adj() {
        if (cng == null) {
            synchronized (b.class) {
                if (cng == null) {
                    cng = new b(new f());
                }
            }
        }
        return cng;
    }

    private com.baidu.poly.a.a.c adk() {
        return new com.baidu.poly.a.a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> ax(JSONObject jSONObject) {
        Map<String, String> adG = com.baidu.poly.util.e.adG();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    adG.put(next, jSONObject.optString(next));
                }
            }
        }
        return adG;
    }

    public void b(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar) {
        com.baidu.poly.a.a.c adk = adk();
        com.baidu.poly.a.a.b a2 = a(bundle, adk);
        this.cnh.a(com.baidu.poly.a.b.d.y(), adk, a2, new c(aVar));
    }

    public void c(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c adk = adk();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        this.cnh.a(com.baidu.poly.a.b.d.z(), adk, bVar, new d(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<JSONObject> aVar) {
        com.baidu.poly.a.a.c adk = adk();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.g(str, bundle.get(str).toString());
            }
        }
        a(bundle, bVar, adk);
        this.cnh.a(com.baidu.poly.a.b.d.u(), adk, bVar, new a(aVar));
    }

    public void a(Bundle bundle, com.baidu.poly.a.a.a<Map<String, String>> aVar, String str) {
        com.baidu.poly.a.a.c adk = adk();
        Set<String> keySet = bundle.keySet();
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.g(str2, bundle.get(str2).toString());
            }
        }
        bVar.g(cne, str);
        a(bundle, bVar, adk);
        this.cnh.a(com.baidu.poly.a.b.d.x(), adk, bVar, new C0297b(aVar));
    }

    public com.baidu.poly.a.a.b a(Bundle bundle, com.baidu.poly.a.a.c cVar) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        a(bVar, bundle);
        bVar.g(cnf, HttpConstants.OS_TYPE_VALUE);
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
