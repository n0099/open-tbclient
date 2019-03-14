package com.baidu.swan.apps.core.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.l;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.games.i.a;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
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
    public static boolean dE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(xD(), str + ".aiapps").exists();
    }

    static File xD() {
        return c.d.Cu();
    }

    @SuppressLint({"MobilebdThread"})
    public static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar, String str) {
        com.baidu.swan.apps.v.b.b a2 = a(aVar, cVar);
        if (!com.baidu.swan.apps.storage.b.f.KL().getBoolean("used_aiapps", false)) {
            com.baidu.swan.apps.storage.b.f.KL().putBoolean("used_aiapps", true);
        }
        c(context, a2, str);
    }

    public static void a(final Context context, final com.baidu.b.a.b.a.a aVar, final com.baidu.swan.apps.v.b.c cVar, final String str, final a aVar2) {
        if (DEBUG) {
            Log.i("LaunchSwanApp", "updateDbInfo");
        }
        j.c(new Runnable() { // from class: com.baidu.swan.apps.core.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ae.a.c Y;
                int i;
                int i2 = 1;
                SwanAppDbControl bE = SwanAppDbControl.bE(context);
                int i3 = b.dE(aVar.packageName) ? 0 : 1;
                String str2 = cVar.mAppId;
                com.baidu.swan.apps.database.a a2 = b.a(bE.ef(str2), cVar, aVar, i3, str);
                String valueOf = String.valueOf(aVar.acC);
                if (a2.category == 1) {
                    com.baidu.swan.games.o.a.a Z = b.Z(str2, valueOf);
                    if (Z == null || Z.beP != 1) {
                        i2 = 0;
                    }
                    i = i2;
                    Y = null;
                } else {
                    Y = b.Y(str2, valueOf);
                    i = 0;
                }
                a2.orientation = i;
                a2.aui = false;
                bE.c(a2);
                if (aVar2 != null) {
                    aVar2.a(a2, Y);
                }
                if (i3 != 0) {
                    com.baidu.swan.apps.ak.e.LG().b(new com.baidu.swan.apps.ak.a().L(3L).M(6L).hw("aiapps zip not exist "));
                }
            }
        }, "update SwanApp DB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.apps.ae.a.c Y(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.apps.ae.a.c.gk(com.baidu.swan.c.b.B(new File(c.d.ah(str, str2), "app.json")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.swan.games.o.a.a Z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.baidu.swan.games.o.a.a.iU(com.baidu.swan.c.b.B(new File(a.c.ah(str, str2), "game.json")));
    }

    private static com.baidu.swan.apps.v.b.b a(com.baidu.swan.apps.database.a aVar, com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.v.b.b bVar = new com.baidu.swan.apps.v.b.b();
        if (aVar == null) {
            return null;
        }
        bVar.axD = aVar.name;
        bVar.axE = aVar.iconUrl;
        bVar.mAppId = cVar.mAppId;
        bVar.axG = cVar.mFrom;
        bVar.axI = cVar.axI;
        bVar.axS = cVar.axS;
        bVar.mAppKey = aVar.appKey;
        bVar.mDescription = aVar.description;
        bVar.mErrorCode = aVar.errorCode;
        bVar.axJ = aVar.errorDetail;
        bVar.mErrorMsg = aVar.errorMsg;
        bVar.axK = aVar.atU;
        bVar.axL = aVar.atV;
        bVar.axM = aVar.atW;
        bVar.axN = aVar.atX;
        bVar.axO = aVar.atY;
        bVar.axP = new SwanAppBearInfo(aVar.atZ);
        bVar.mVersion = aVar.version;
        bVar.axQ = cVar.DC();
        bVar.axH = cVar.axH;
        bVar.mType = aVar.type;
        bVar.axT = cVar.axT;
        bVar.axU = aVar.aub;
        bVar.axV = aVar.auc;
        bVar.axW = aVar.aud;
        bVar.atq = cVar.atq;
        bVar.atr = cVar.atr;
        bVar.aue = aVar.aue;
        bVar.aug = aVar.aug;
        bVar.axR = cVar.axR;
        bVar.axZ = cVar.axZ;
        if (aVar.category == 1) {
            bVar.axX = 1;
        } else {
            bVar.axX = 0;
        }
        bVar.orientation = aVar.orientation;
        return bVar;
    }

    private static void b(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        SwanAppLauncherActivity.a(context, bVar, str);
    }

    private static void a(Context context, com.baidu.swan.apps.v.b.b bVar) {
        Intent c = com.baidu.swan.apps.v.b.b.c(context, bVar);
        if (c != null) {
            c.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            context.startActivity(c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.baidu.swan.apps.database.a a(@Nullable com.baidu.swan.apps.database.a aVar, @NonNull com.baidu.swan.apps.v.b.c cVar, @Nullable com.baidu.b.a.b.a.a aVar2, int i, String str) {
        com.baidu.swan.apps.database.a aVar3 = (aVar == null || !TextUtils.equals(cVar.mAppId, aVar.appId)) ? new com.baidu.swan.apps.database.a() : aVar;
        if (aVar2 == null) {
            return aVar3;
        }
        aVar3.version = String.valueOf(aVar2.acC);
        aVar3.aue = aVar2.acG;
        try {
            JSONObject jSONObject = new JSONObject(aVar2.acE);
            if (DEBUG) {
                Log.i("LaunchSwanApp", jSONObject.toString());
            }
            aVar3.appId = cVar.mAppId;
            aVar3.name = aVar2.name;
            aVar3.description = jSONObject.optString(SocialConstants.PARAM_COMMENT);
            aVar3.appKey = jSONObject.optString("app_key");
            aVar3.errorCode = jSONObject.optInt("error_code");
            aVar3.errorDetail = jSONObject.optString("error_detail");
            aVar3.errorMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            aVar3.atV = jSONObject.optString("max_swan_version");
            aVar3.atW = jSONObject.optString("min_swan_version");
            aVar3.type = jSONObject.optInt("type");
            aVar3.sign = jSONObject.optString("sign");
            aVar3.atU = jSONObject.optString("resume_date");
            aVar3.atX = jSONObject.optString("service_category");
            aVar3.atY = jSONObject.optString("subject_info");
            JSONObject optJSONObject = jSONObject.optJSONObject("bear_info");
            aVar3.atZ = optJSONObject == null ? "" : optJSONObject.toString();
            aVar3.iconUrl = str;
            aVar3.aua = i;
            aVar3.version = String.valueOf(aVar2.acC);
            aVar3.aud = jSONObject.optString("cur_swan_version");
            aVar3.aug = jSONObject.optString("version_code");
            if (jSONObject.has("max_age")) {
                aVar3.auh = jSONObject.optLong("max_age", 432000L);
            }
            if (cVar.axX == 1) {
                aVar3.category = 1;
            } else {
                aVar3.category = 0;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("swan_conf");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("call_app_config");
                if (optJSONObject3 != null) {
                    aVar3.aub = optJSONObject3.optString("invoke_url");
                    aVar3.auc = optJSONObject3.optString("download_url");
                }
                com.baidu.swan.apps.af.a.c.a(aVar3.appId, "", optJSONObject2.optJSONArray("web_view_domains"));
                com.baidu.swan.apps.af.a.c.b("", optJSONObject2.optJSONArray("web_action"));
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("domains");
                if (optJSONObject4 != null) {
                    com.baidu.swan.apps.af.a.c.g(aVar3.appId, optJSONObject4);
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
            com.baidu.swan.apps.v.b.Dx().Dz();
            com.baidu.swan.apps.ak.a bX = bX(a2);
            com.baidu.swan.apps.ak.e.LG().b(bX);
            a(context, cVar, bX);
            return;
        }
        c(context, a(aVar, cVar), str);
    }

    private static com.baidu.swan.apps.ak.a bX(int i) {
        com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
        switch (i) {
            case 1:
                aVar.L(4L).M(3L).hw("no aiapps info in database");
                break;
            case 2:
                aVar.L(1L).M(27L).hw("category not match");
                break;
        }
        return aVar;
    }

    private static int a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.database.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId)) {
            return 1;
        }
        if ((cVar.axX == 0 && aVar.category != 0) || (cVar.axX == 1 && aVar.category != 1)) {
            return 2;
        }
        return 0;
    }

    private static void a(Context context, com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.apps.ak.a aVar) {
        if (aVar == null) {
            aVar = new com.baidu.swan.apps.ak.a().L(4L).M(3L).hw("no aiapps info in database");
            com.baidu.swan.apps.ak.e.LG().b(aVar);
        }
        if (aVar.Lz() == 1104) {
            a(context, cVar.mAppId, aVar);
        } else {
            if (aVar.Ly() == 4 && aVar.Lz() == 3) {
                if (cVar.axX == 1) {
                    com.baidu.b.a.c.a.T("51", cVar.mAppId);
                } else {
                    com.baidu.b.a.c.a.T(Constants.VIA_REPORT_TYPE_QQFAVORITES, cVar.mAppId);
                }
            }
            com.baidu.swan.apps.v.a.a.a(context, aVar, cVar.axX);
        }
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(cVar.axX);
        fVar.mType = "launch";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        fVar.d(cVar);
        fVar.aB("errcode", String.valueOf(aVar.LC()));
        fVar.aB("msg", aVar.LB().toString());
        com.baidu.swan.apps.statistic.c.onEvent(fVar);
        if (!aVar.LD()) {
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(cVar.axX)).a(aVar).c(cVar).gS(cVar.mAppId).gT(cVar.mFrom));
            aVar.LE();
        }
        com.baidu.swan.apps.storage.b.f.KL().putLong(cVar.mAppId, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Context context, @NonNull com.baidu.swan.apps.v.b.c cVar, int i, String str) {
        com.baidu.swan.apps.performance.b.FJ().ar(str, "aiapp_aps_check_start_timestamp");
        ArrayList arrayList = new ArrayList();
        com.baidu.swan.apps.core.a.a.a xL = new a.C0126a().bZ(i).aU(false).xL();
        if (cVar.axX == 0) {
            arrayList.add(new g(context, cVar, xL, str));
        } else {
            arrayList.add(new com.baidu.swan.games.b.b(context, cVar, xL, str));
        }
        com.baidu.b.a.a.init(AppRuntime.getAppContext(), true);
        com.baidu.b.a.c.a.a(context.getApplicationContext(), com.baidu.swan.apps.u.a.CV().Dt());
        com.baidu.b.a.c.a.c(arrayList, true);
    }

    private static void c(Context context, com.baidu.swan.apps.v.b.b bVar, String str) {
        if (bVar.mErrorCode == 0) {
            b(context, bVar, str);
            return;
        }
        com.baidu.swan.apps.v.b.Dx().Dz();
        a(context, bVar);
    }

    public static void a(String str, l.a aVar) {
        a(str, (com.baidu.swan.apps.v.b.c) null, aVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.v.b.c cVar, final l.a aVar) {
        Uri hL = aa.hL(str);
        if (hL == null) {
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(4L).M(10L).hw("download icon fail: icon url is null");
            com.baidu.swan.apps.ak.e.LG().b(hw);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(cVar != null ? cVar.axX : 0)).a(hw).c(cVar));
            aVar.d(str, null);
            return;
        }
        com.facebook.drawee.a.a.c.cuF().e(ImageRequestBuilder.O(hL).cAI(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.core.a.b.2
            @Override // com.facebook.imagepipeline.e.b
            protected void f(Bitmap bitmap) {
                Bitmap copy;
                if (bitmap == null || bitmap.isRecycled()) {
                    b.a(str, cVar, l.a.this, "download icon fail: bitmap is null or is recycled");
                    return;
                }
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    l.a.this.d(str, copy);
                } catch (Exception e) {
                    b.a(str, cVar, l.a.this, "download icon fail: " + e.getMessage());
                }
            }

            @Override // com.facebook.datasource.a
            protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                b.a(str, cVar, l.a.this, "download icon fail: onFailureImpl");
            }

            @Override // com.facebook.datasource.a, com.facebook.datasource.d
            public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                super.b(bVar);
                b.a(str, cVar, l.a.this, "download icon fail: onCancellation");
            }
        }, com.facebook.common.b.f.ctJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, com.baidu.swan.apps.v.b.c cVar, l.a aVar, String str2) {
        com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(4L).M(10L).hw(str2);
        com.baidu.swan.apps.ak.e.LG().b(hw);
        com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().a(hw).gR(com.baidu.swan.apps.statistic.c.dC(cVar != null ? cVar.axX : 0)).c(cVar));
        aVar.d(str, null);
    }

    private static void a(Context context, String str, com.baidu.swan.apps.ak.a aVar) {
        com.baidu.swan.apps.u.a.De().h(str, aVar.Lz());
    }
}
