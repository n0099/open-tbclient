package com.baidu.swan.apps.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.games.i.a;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.swan.apps.database.a aVar, com.baidu.swan.apps.ae.a.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean eh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(DZ(), str + ".aiapps").exists();
    }

    static File DZ() {
        return e.d.Jb();
    }

    @SuppressLint({"MobilebdThread"})
    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, String str) {
        c(context, a(aVar, cVar), str);
    }

    public static void a(final Context context, final com.baidu.a.a.b.a.a aVar, final com.baidu.swan.apps.v.b.c cVar, final String str, final a aVar2) {
        if (DEBUG) {
            Log.i("LaunchSwanApp", "updateDbInfo");
        }
        j.c(new Runnable() { // from class: com.baidu.swan.apps.core.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.a.c aa;
                int i;
                int i2 = 1;
                SwanAppDbControl aZ = SwanAppDbControl.aZ(context);
                int i3 = b.eh(aVar.packageName) ? 0 : 1;
                String str2 = cVar.mAppId;
                com.baidu.swan.apps.database.a a2 = b.a(aZ.eI(str2), cVar, aVar, i3, str);
                String valueOf = String.valueOf(aVar.version);
                if (a2.category == 1) {
                    com.baidu.swan.games.p.a.a ab = b.ab(str2, valueOf);
                    if (ab == null || ab.bDj != 1) {
                        i2 = 0;
                    }
                    i = i2;
                    aa = null;
                } else {
                    aa = b.aa(str2, valueOf);
                    i = 0;
                }
                a2.orientation = i;
                a2.aOU = false;
                aZ.c(a2);
                if (aVar2 != null) {
                    aVar2.a(a2, aa);
                }
                if (i3 != 0) {
                    com.baidu.swan.apps.ak.e.TT().b(new com.baidu.swan.apps.ak.a().as(3L).at(6L).iL("aiapps zip not exist "));
                }
            }
        }, "update SwanApp DB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.apps.ae.a.c aa(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.apps.ae.a.c.hs(com.baidu.swan.c.a.l(new File(e.d.am(str, str2), "app.json")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.games.p.a.a ab(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.ku(com.baidu.swan.c.a.l(new File(a.d.am(str, str2), "game.json")));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.database.a aVar, com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        if (aVar == null) {
            return null;
        }
        bVar.e(com.baidu.swan.apps.database.a.f(aVar));
        bVar.fv(cVar.mFrom);
        bVar.setPage(cVar.aTe);
        bVar.setDebug(cVar.aTf);
        bVar.fx(aVar.aOH);
        bVar.fy(aVar.aOI);
        bVar.p(cVar.Ks());
        bVar.fw(cVar.aTi);
        bVar.fA(cVar.aTj);
        bVar.fB(aVar.aON);
        bVar.fC(aVar.aOO);
        bVar.fD(aVar.aOP);
        bVar.a(cVar.aOc);
        bVar.a(cVar.aOd);
        bVar.fz(cVar.aTh);
        bVar.dB(cVar.aSY);
        if (aVar.category == 1) {
            bVar.m19do(1);
            return bVar;
        }
        bVar.m19do(0);
        return bVar;
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        SwanAppLauncherActivity.a(context, bVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.database.a a(@Nullable com.baidu.swan.apps.database.a aVar, @NonNull com.baidu.swan.apps.v.b.c cVar, @Nullable com.baidu.a.a.b.a.a aVar2, int i, String str) {
        com.baidu.swan.apps.database.a aVar3 = (aVar == null || !TextUtils.equals(cVar.mAppId, aVar.appId)) ? new com.baidu.swan.apps.database.a() : aVar;
        if (aVar2 == null) {
            return aVar3;
        }
        aVar3.version = String.valueOf(aVar2.version);
        aVar3.aOQ = aVar2.Lb;
        try {
            JSONObject jSONObject = new JSONObject(aVar2.KZ);
            if (DEBUG) {
                Log.i("LaunchSwanApp", jSONObject.toString());
            }
            aVar3.appId = cVar.mAppId;
            aVar3.name = aVar2.name;
            aVar3.description = jSONObject.optString("description");
            aVar3.appKey = jSONObject.optString("app_key");
            aVar3.errorCode = jSONObject.optInt("error_code");
            aVar3.errorDetail = jSONObject.optString("error_detail");
            aVar3.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            aVar3.aOH = jSONObject.optString("max_swan_version");
            aVar3.aOI = jSONObject.optString("min_swan_version");
            aVar3.type = jSONObject.optInt("type");
            aVar3.sign = jSONObject.optString("sign");
            aVar3.aOG = jSONObject.optString("resume_date");
            aVar3.aOJ = jSONObject.optString("service_category");
            aVar3.aOK = jSONObject.optString("subject_info");
            JSONObject optJSONObject = jSONObject.optJSONObject("bear_info");
            aVar3.aOL = optJSONObject == null ? "" : optJSONObject.toString();
            aVar3.iconUrl = str;
            aVar3.aOM = i;
            aVar3.version = String.valueOf(aVar2.version);
            aVar3.aOP = jSONObject.optString("cur_swan_version");
            aVar3.aOS = jSONObject.optString("version_code");
            if (jSONObject.has("max_age")) {
                aVar3.aOT = jSONObject.optLong("max_age", 432000L);
            }
            if (cVar.aTl == 1) {
                aVar3.category = 1;
            } else {
                aVar3.category = 0;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("call_app_config");
                if (optJSONObject3 != null) {
                    aVar3.aON = optJSONObject3.optString("invoke_url");
                    aVar3.aOO = optJSONObject3.optString("download_url");
                }
                com.baidu.swan.apps.af.a.c.a(aVar3.appId, "", optJSONObject2.optJSONArray("web_view_domains"));
                com.baidu.swan.apps.af.a.c.a("", optJSONObject2.optJSONArray("web_action"));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject4 != null) {
                    com.baidu.swan.apps.af.a.c.h(aVar3.appId, optJSONObject4);
                }
            }
            return aVar3;
        } catch (JSONException e) {
            e.printStackTrace();
            return aVar3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, boolean z, String str) {
        int a2 = a(cVar, aVar);
        if (a2 != 0) {
            com.baidu.swan.apps.ak.a cT = cT(a2);
            com.baidu.swan.apps.ak.e.TT().b(cT);
            a(context, cVar, cT);
            com.baidu.swan.apps.v.b.Kl().Kn();
            return;
        }
        c(context, a(aVar, cVar), str);
    }

    private static com.baidu.swan.apps.ak.a cT(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.as(4L).at(3L).iL("no aiapps info in database");
                break;
            case 2:
                aVar.as(1L).at(27L).iL("category not match");
                break;
        }
        return aVar;
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId)) {
            return 1;
        }
        if ((cVar.aTl == 0 && aVar.category != 0) || (cVar.aTl == 1 && aVar.category != 1)) {
            return 2;
        }
        return 0;
    }

    private static void a(Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.swan.apps.ak.a().as(4L).at(3L).iL("no aiapps info in database");
            com.baidu.swan.apps.ak.e.TT().b(aVar);
        }
        if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aG(context)) {
            if (DEBUG) {
                Log.d("LaunchSwanApp", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(cVar.aTl);
        fVar.mType = Config.LAUNCH;
        if (aVar.TM() == 1104) {
            a(context, cVar.mAppId, aVar);
            fVar.mValue = "success";
            fVar.h("status", "1");
        } else {
            if (aVar.TL() == 4 && aVar.TM() == 3) {
                if (cVar.aTl == 1) {
                    com.baidu.a.a.c.a.F("51", cVar.mAppId);
                } else {
                    com.baidu.a.a.c.a.F(Constants.VIA_REPORT_TYPE_QQFAVORITES, cVar.mAppId);
                }
            }
            com.baidu.swan.apps.v.a.c cVar2 = new com.baidu.swan.apps.v.a.c();
            cVar2.mAppId = cVar.mAppId;
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.aTl, cVar2);
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.h("errcode", String.valueOf(aVar.TP()));
            fVar.h("msg", aVar.TO().toString());
        }
        fVar.d(cVar);
        fVar.h("errcode", String.valueOf(aVar.TP()));
        fVar.h("msg", aVar.TO().toString());
        fVar.aI(com.baidu.swan.apps.statistic.e.hY(cVar.aTi));
        com.baidu.swan.apps.statistic.e.onEvent(fVar);
        if (!aVar.TQ()) {
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(cVar.aTl)).a(aVar).c(cVar).ib(cVar.mAppId).ic(cVar.mFrom));
            aVar.TR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, int i, String str) {
        com.baidu.swan.apps.performance.b.NA().aA(str, "aiapp_aps_check_start_timestamp");
        ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.core.a.a.a Eh = new a.C0172a().cV(i).br(false).Eh();
        if (cVar.aTl == 0) {
            arrayList.add(new g(context, cVar, Eh, str));
        } else {
            arrayList.add(new com.baidu.swan.games.b.b(context, cVar, Eh, str));
        }
        com.baidu.a.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.a.a.c.a.a(context.getApplicationContext(), com.baidu.swan.apps.u.a.JF().Kd());
        com.baidu.a.a.c.a.b((List<Object>) arrayList, true);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.Kv() == 0) {
            b(context, bVar, str);
            return;
        }
        com.baidu.swan.apps.v.b.Kl().Kn();
        com.baidu.swan.apps.v.d.a(context, bVar);
    }

    public static void a(String str, m.a aVar) {
        a(str, (com.baidu.swan.apps.v.b.c) null, aVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.v.b.c cVar, final m.a aVar) {
        Uri jb = ac.jb(str);
        if (jb == null) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(4L).at(10L).iL("download icon fail: icon url is null");
            com.baidu.swan.apps.ak.e.TT().b(iL);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(cVar != null ? cVar.aTl : 0)).a(iL).c(cVar));
            aVar.e(str, null);
            return;
        }
        com.facebook.drawee.a.a.c.cDD().e(ImageRequestBuilder.R(jb).cJI(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.a.b.2
            @Override // com.facebook.imagepipeline.e.b
            protected void h(Bitmap bitmap) {
                Bitmap copy;
                if (bitmap == null || bitmap.isRecycled()) {
                    b.a(str, cVar, m.a.this, "download icon fail: bitmap is null or is recycled");
                    return;
                }
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    m.a.this.e(str, copy);
                } catch (Exception e) {
                    b.a(str, cVar, m.a.this, "download icon fail: " + e.getMessage());
                }
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                b.a(str, cVar, m.a.this, "download icon fail: onFailureImpl");
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                super.b(bVar);
                b.a(str, cVar, m.a.this, "download icon fail: onCancellation");
            }
        }, com.facebook.common.b.f.cCI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, com.baidu.swan.apps.v.b.c cVar, m.a aVar, String str2) {
        com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(4L).at(10L).iL(str2);
        com.baidu.swan.apps.ak.e.TT().b(iL);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL).ia(com.baidu.swan.apps.statistic.e.eL(cVar != null ? cVar.aTl : 0)).c(cVar));
        aVar.e(str, null);
    }

    private static void a(Context context, String str, com.baidu.swan.apps.ak.a aVar) {
        com.baidu.swan.apps.u.a.JO().l(str, aVar.TM());
    }
}
