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
    public static boolean dz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(ze(), str + ".aiapps").exists();
    }

    static File ze() {
        return e.d.Eh();
    }

    @SuppressLint({"MobilebdThread"})
    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, String str) {
        c(context, a(aVar, cVar), str);
    }

    public static void a(final Context context, final com.baidu.b.a.b.a.a aVar, final com.baidu.swan.apps.v.b.c cVar, final String str, final a aVar2) {
        if (DEBUG) {
            Log.i("LaunchSwanApp", "updateDbInfo");
        }
        j.c(new Runnable() { // from class: com.baidu.swan.apps.core.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.a.c T;
                int i;
                int i2 = 1;
                SwanAppDbControl aX = SwanAppDbControl.aX(context);
                int i3 = b.dz(aVar.packageName) ? 0 : 1;
                String str2 = cVar.mAppId;
                com.baidu.swan.apps.database.a a2 = b.a(aX.eb(str2), cVar, aVar, i3, str);
                String valueOf = String.valueOf(aVar.version);
                if (a2.avC == 1) {
                    com.baidu.swan.games.p.a.a U = b.U(str2, valueOf);
                    if (U == null || U.bkv != 1) {
                        i2 = 0;
                    }
                    i = i2;
                    T = null;
                } else {
                    T = b.T(str2, valueOf);
                    i = 0;
                }
                a2.orientation = i;
                a2.avF = false;
                aX.c(a2);
                if (aVar2 != null) {
                    aVar2.a(a2, T);
                }
                if (i3 != 0) {
                    com.baidu.swan.apps.ak.e.Pd().b(new com.baidu.swan.apps.ak.a().Z(3L).aa(6L).ii("aiapps zip not exist "));
                }
            }
        }, "update SwanApp DB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.apps.ae.a.c T(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.apps.ae.a.c.gO(com.baidu.swan.c.a.v(new File(e.d.ae(str, str2), "app.json")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.games.p.a.a U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.jS(com.baidu.swan.c.a.v(new File(a.d.ae(str, str2), "game.json")));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.database.a aVar, com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        if (aVar == null) {
            return null;
        }
        bVar.e(com.baidu.swan.apps.database.a.f(aVar));
        bVar.eO(cVar.mFrom);
        bVar.setPage(cVar.azQ);
        bVar.setDebug(cVar.azR);
        bVar.eQ(aVar.avr);
        bVar.eR(aVar.avs);
        bVar.p(cVar.Fy());
        bVar.eP(cVar.azU);
        bVar.eT(cVar.azV);
        bVar.eU(aVar.avx);
        bVar.eV(aVar.avy);
        bVar.eW(aVar.avz);
        bVar.a(cVar.auL);
        bVar.a(cVar.auM);
        bVar.eS(cVar.azT);
        bVar.cG(cVar.azK);
        if (aVar.avC == 1) {
            bVar.cs(1);
            return bVar;
        }
        bVar.cs(0);
        return bVar;
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        SwanAppLauncherActivity.a(context, bVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.database.a a(@Nullable com.baidu.swan.apps.database.a aVar, @NonNull com.baidu.swan.apps.v.b.c cVar, @Nullable com.baidu.b.a.b.a.a aVar2, int i, String str) {
        com.baidu.swan.apps.database.a aVar3 = (aVar == null || !TextUtils.equals(cVar.mAppId, aVar.appId)) ? new com.baidu.swan.apps.database.a() : aVar;
        if (aVar2 == null) {
            return aVar3;
        }
        aVar3.version = String.valueOf(aVar2.version);
        aVar3.avA = aVar2.aaV;
        try {
            JSONObject jSONObject = new JSONObject(aVar2.aaT);
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
            aVar3.avr = jSONObject.optString("max_swan_version");
            aVar3.avs = jSONObject.optString("min_swan_version");
            aVar3.type = jSONObject.optInt("type");
            aVar3.sign = jSONObject.optString("sign");
            aVar3.avq = jSONObject.optString("resume_date");
            aVar3.avt = jSONObject.optString("service_category");
            aVar3.avu = jSONObject.optString("subject_info");
            JSONObject optJSONObject = jSONObject.optJSONObject("bear_info");
            aVar3.avv = optJSONObject == null ? "" : optJSONObject.toString();
            aVar3.iconUrl = str;
            aVar3.avw = i;
            aVar3.version = String.valueOf(aVar2.version);
            aVar3.avz = jSONObject.optString("cur_swan_version");
            aVar3.avD = jSONObject.optString("version_code");
            if (jSONObject.has("max_age")) {
                aVar3.avE = jSONObject.optLong("max_age", 432000L);
            }
            if (cVar.azX == 1) {
                aVar3.avC = 1;
            } else {
                aVar3.avC = 0;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("call_app_config");
                if (optJSONObject3 != null) {
                    aVar3.avx = optJSONObject3.optString("invoke_url");
                    aVar3.avy = optJSONObject3.optString("download_url");
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
            com.baidu.swan.apps.ak.a bX = bX(a2);
            com.baidu.swan.apps.ak.e.Pd().b(bX);
            a(context, cVar, bX);
            com.baidu.swan.apps.v.b.Fr().Ft();
            return;
        }
        c(context, a(aVar, cVar), str);
    }

    private static com.baidu.swan.apps.ak.a bX(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.Z(4L).aa(3L).ii("no aiapps info in database");
                break;
            case 2:
                aVar.Z(1L).aa(27L).ii("category not match");
                break;
        }
        return aVar;
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId)) {
            return 1;
        }
        if ((cVar.azX == 0 && aVar.avC != 0) || (cVar.azX == 1 && aVar.avC != 1)) {
            return 2;
        }
        return 0;
    }

    private static void a(Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.swan.apps.ak.a().Z(4L).aa(3L).ii("no aiapps info in database");
            com.baidu.swan.apps.ak.e.Pd().b(aVar);
        }
        if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aC(context)) {
            if (DEBUG) {
                Log.d("LaunchSwanApp", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(cVar.azX);
        fVar.mType = Config.LAUNCH;
        if (aVar.OW() == 1104) {
            a(context, cVar.mAppId, aVar);
            fVar.mValue = "success";
            fVar.k("status", "1");
        } else {
            if (aVar.OV() == 4 && aVar.OW() == 3) {
                if (cVar.azX == 1) {
                    com.baidu.b.a.c.a.N("51", cVar.mAppId);
                } else {
                    com.baidu.b.a.c.a.N(Constants.VIA_REPORT_TYPE_QQFAVORITES, cVar.mAppId);
                }
            }
            com.baidu.swan.apps.v.a.c cVar2 = new com.baidu.swan.apps.v.a.c();
            cVar2.mAppId = cVar.mAppId;
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.azX, cVar2);
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.k("errcode", String.valueOf(aVar.OZ()));
            fVar.k("msg", aVar.OY().toString());
        }
        fVar.d(cVar);
        fVar.k("errcode", String.valueOf(aVar.OZ()));
        fVar.k("msg", aVar.OY().toString());
        fVar.ak(com.baidu.swan.apps.statistic.e.hv(cVar.azU));
        com.baidu.swan.apps.statistic.e.onEvent(fVar);
        if (!aVar.Pa()) {
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hx(com.baidu.swan.apps.statistic.e.dQ(cVar.azX)).a(aVar).c(cVar).hy(cVar.mAppId).hz(cVar.mFrom));
            aVar.Pb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, int i, String str) {
        com.baidu.swan.apps.performance.b.IG().as(str, "aiapp_aps_check_start_timestamp");
        ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.core.a.a.a zm = new a.C0140a().bZ(i).aZ(false).zm();
        if (cVar.azX == 0) {
            arrayList.add(new g(context, cVar, zm, str));
        } else {
            arrayList.add(new com.baidu.swan.games.b.b(context, cVar, zm, str));
        }
        com.baidu.b.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.b.a.c.a.a(context.getApplicationContext(), com.baidu.swan.apps.u.a.EL().Fj());
        com.baidu.b.a.c.a.b((List<Object>) arrayList, true);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.FB() == 0) {
            b(context, bVar, str);
            return;
        }
        com.baidu.swan.apps.v.b.Fr().Ft();
        com.baidu.swan.apps.v.d.a(context, bVar);
    }

    public static void a(String str, m.a aVar) {
        a(str, (com.baidu.swan.apps.v.b.c) null, aVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.v.b.c cVar, final m.a aVar) {
        Uri iy = ac.iy(str);
        if (iy == null) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(4L).aa(10L).ii("download icon fail: icon url is null");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hx(com.baidu.swan.apps.statistic.e.dQ(cVar != null ? cVar.azX : 0)).a(ii).c(cVar));
            aVar.d(str, null);
            return;
        }
        com.facebook.drawee.a.a.c.cGF().e(ImageRequestBuilder.U(iy).cML(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.a.b.2
            @Override // com.facebook.imagepipeline.e.b
            protected void f(Bitmap bitmap) {
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
                    m.a.this.d(str, copy);
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
        }, com.facebook.common.b.f.cFK());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, com.baidu.swan.apps.v.b.c cVar, m.a aVar, String str2) {
        com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(4L).aa(10L).ii(str2);
        com.baidu.swan.apps.ak.e.Pd().b(ii);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(ii).hx(com.baidu.swan.apps.statistic.e.dQ(cVar != null ? cVar.azX : 0)).c(cVar));
        aVar.d(str, null);
    }

    private static void a(Context context, String str, com.baidu.swan.apps.ak.a aVar) {
        com.baidu.swan.apps.u.a.EU().j(str, aVar.OW());
    }
}
