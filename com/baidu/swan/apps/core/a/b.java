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
    public static boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(za(), str + ".aiapps").exists();
    }

    static File za() {
        return e.d.Ed();
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
                int i3 = b.dx(aVar.packageName) ? 0 : 1;
                String str2 = cVar.mAppId;
                com.baidu.swan.apps.database.a a2 = b.a(aX.dZ(str2), cVar, aVar, i3, str);
                String valueOf = String.valueOf(aVar.version);
                if (a2.ave == 1) {
                    com.baidu.swan.games.p.a.a U = b.U(str2, valueOf);
                    if (U == null || U.bjX != 1) {
                        i2 = 0;
                    }
                    i = i2;
                    T = null;
                } else {
                    T = b.T(str2, valueOf);
                    i = 0;
                }
                a2.orientation = i;
                a2.avh = false;
                aX.c(a2);
                if (aVar2 != null) {
                    aVar2.a(a2, T);
                }
                if (i3 != 0) {
                    com.baidu.swan.apps.ak.e.OZ().b(new com.baidu.swan.apps.ak.a().Z(3L).aa(6L).ig("aiapps zip not exist "));
                }
            }
        }, "update SwanApp DB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.apps.ae.a.c T(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.apps.ae.a.c.gM(com.baidu.swan.c.a.v(new File(e.d.ae(str, str2), "app.json")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.games.p.a.a U(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.jQ(com.baidu.swan.c.a.v(new File(a.d.ae(str, str2), "game.json")));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.database.a aVar, com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        if (aVar == null) {
            return null;
        }
        bVar.e(com.baidu.swan.apps.database.a.f(aVar));
        bVar.eM(cVar.mFrom);
        bVar.setPage(cVar.azs);
        bVar.setDebug(cVar.azt);
        bVar.eO(aVar.auT);
        bVar.eP(aVar.auU);
        bVar.p(cVar.Fu());
        bVar.eN(cVar.azw);
        bVar.eR(cVar.azx);
        bVar.eS(aVar.auZ);
        bVar.eT(aVar.ava);
        bVar.eU(aVar.avb);
        bVar.a(cVar.aun);
        bVar.a(cVar.auo);
        bVar.eQ(cVar.azv);
        bVar.cF(cVar.azm);
        if (aVar.ave == 1) {
            bVar.cr(1);
            return bVar;
        }
        bVar.cr(0);
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
        aVar3.avc = aVar2.aaV;
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
            aVar3.auT = jSONObject.optString("max_swan_version");
            aVar3.auU = jSONObject.optString("min_swan_version");
            aVar3.type = jSONObject.optInt("type");
            aVar3.sign = jSONObject.optString("sign");
            aVar3.auS = jSONObject.optString("resume_date");
            aVar3.auV = jSONObject.optString("service_category");
            aVar3.auW = jSONObject.optString("subject_info");
            JSONObject optJSONObject = jSONObject.optJSONObject("bear_info");
            aVar3.auX = optJSONObject == null ? "" : optJSONObject.toString();
            aVar3.iconUrl = str;
            aVar3.auY = i;
            aVar3.version = String.valueOf(aVar2.version);
            aVar3.avb = jSONObject.optString("cur_swan_version");
            aVar3.avf = jSONObject.optString("version_code");
            if (jSONObject.has("max_age")) {
                aVar3.avg = jSONObject.optLong("max_age", 432000L);
            }
            if (cVar.azz == 1) {
                aVar3.ave = 1;
            } else {
                aVar3.ave = 0;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("call_app_config");
                if (optJSONObject3 != null) {
                    aVar3.auZ = optJSONObject3.optString("invoke_url");
                    aVar3.ava = optJSONObject3.optString("download_url");
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
            com.baidu.swan.apps.ak.a bW = bW(a2);
            com.baidu.swan.apps.ak.e.OZ().b(bW);
            a(context, cVar, bW);
            com.baidu.swan.apps.v.b.Fn().Fp();
            return;
        }
        c(context, a(aVar, cVar), str);
    }

    private static com.baidu.swan.apps.ak.a bW(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.Z(4L).aa(3L).ig("no aiapps info in database");
                break;
            case 2:
                aVar.Z(1L).aa(27L).ig("category not match");
                break;
        }
        return aVar;
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId)) {
            return 1;
        }
        if ((cVar.azz == 0 && aVar.ave != 0) || (cVar.azz == 1 && aVar.ave != 1)) {
            return 2;
        }
        return 0;
    }

    private static void a(Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.swan.apps.ak.a().Z(4L).aa(3L).ig("no aiapps info in database");
            com.baidu.swan.apps.ak.e.OZ().b(aVar);
        }
        if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aC(context)) {
            if (DEBUG) {
                Log.d("LaunchSwanApp", "launcher activity closed, ignore launch err");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(cVar.azz);
        fVar.mType = Config.LAUNCH;
        if (aVar.OS() == 1104) {
            a(context, cVar.mAppId, aVar);
            fVar.mValue = "success";
            fVar.k("status", "1");
        } else {
            if (aVar.OR() == 4 && aVar.OS() == 3) {
                if (cVar.azz == 1) {
                    com.baidu.b.a.c.a.N("51", cVar.mAppId);
                } else {
                    com.baidu.b.a.c.a.N(Constants.VIA_REPORT_TYPE_QQFAVORITES, cVar.mAppId);
                }
            }
            com.baidu.swan.apps.v.a.c cVar2 = new com.baidu.swan.apps.v.a.c();
            cVar2.mAppId = cVar.mAppId;
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.azz, cVar2);
            fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
            fVar.k("errcode", String.valueOf(aVar.OV()));
            fVar.k("msg", aVar.OU().toString());
        }
        fVar.d(cVar);
        fVar.k("errcode", String.valueOf(aVar.OV()));
        fVar.k("msg", aVar.OU().toString());
        fVar.ak(com.baidu.swan.apps.statistic.e.ht(cVar.azw));
        com.baidu.swan.apps.statistic.e.onEvent(fVar);
        if (!aVar.OW()) {
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hv(com.baidu.swan.apps.statistic.e.dP(cVar.azz)).a(aVar).c(cVar).hw(cVar.mAppId).hx(cVar.mFrom));
            aVar.OX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, int i, String str) {
        com.baidu.swan.apps.performance.b.IC().as(str, "aiapp_aps_check_start_timestamp");
        ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.core.a.a.a zi = new a.C0131a().bY(i).aZ(false).zi();
        if (cVar.azz == 0) {
            arrayList.add(new g(context, cVar, zi, str));
        } else {
            arrayList.add(new com.baidu.swan.games.b.b(context, cVar, zi, str));
        }
        com.baidu.b.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.b.a.c.a.a(context.getApplicationContext(), com.baidu.swan.apps.u.a.EH().Ff());
        com.baidu.b.a.c.a.b(arrayList, true);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.Fx() == 0) {
            b(context, bVar, str);
            return;
        }
        com.baidu.swan.apps.v.b.Fn().Fp();
        com.baidu.swan.apps.v.d.a(context, bVar);
    }

    public static void a(String str, m.a aVar) {
        a(str, (com.baidu.swan.apps.v.b.c) null, aVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.v.b.c cVar, final m.a aVar) {
        Uri iw = ac.iw(str);
        if (iw == null) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(4L).aa(10L).ig("download icon fail: icon url is null");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hv(com.baidu.swan.apps.statistic.e.dP(cVar != null ? cVar.azz : 0)).a(ig).c(cVar));
            aVar.d(str, null);
            return;
        }
        com.facebook.drawee.a.a.c.cFR().e(ImageRequestBuilder.U(iw).cLX(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.a.b.2
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
        }, com.facebook.common.b.f.cEW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, com.baidu.swan.apps.v.b.c cVar, m.a aVar, String str2) {
        com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(4L).aa(10L).ig(str2);
        com.baidu.swan.apps.ak.e.OZ().b(ig);
        com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(ig).hv(com.baidu.swan.apps.statistic.e.dP(cVar != null ? cVar.azz : 0)).c(cVar));
        aVar.d(str, null);
    }

    private static void a(Context context, String str, com.baidu.swan.apps.ak.a aVar) {
        com.baidu.swan.apps.u.a.EQ().h(str, aVar.OS());
    }
}
