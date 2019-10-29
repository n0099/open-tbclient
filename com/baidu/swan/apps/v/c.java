package com.baidu.swan.apps.v;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.core.pms.e;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.games.i.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void b(Context context, com.baidu.swan.apps.v.b.c cVar) {
        b(context, cVar, true);
    }

    public static void b(Context context, final com.baidu.swan.apps.v.b.c cVar, boolean z) {
        boolean z2;
        boolean z3 = true;
        final String uuid = UUID.randomUUID().toString();
        cVar.aJr = uuid;
        com.baidu.swan.apps.v.c.a at = com.baidu.swan.apps.v.c.a.fF(uuid).at("dl_type", "PMS");
        at.fG("start");
        cVar.Ks().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        cVar.Ks().putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.performance.b.NA().u(uuid, "aiapp_abtest_info", a.Kk());
        a.clean();
        com.baidu.swan.apps.performance.b.NA().i(uuid, "is_sileng_updating_when_start", com.baidu.swan.apps.core.a.c.b.El().Em());
        cVar.Ks().putLong("aiapp_start_timestamp", System.currentTimeMillis());
        PMSAppInfo kT = com.baidu.swan.pms.database.a.aaX().kT(cVar.mAppId);
        com.baidu.swan.apps.performance.b.NA().aA(uuid, "aiapp_query_db_timestamp");
        if (c(kT)) {
            z2 = false;
        } else {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "本地无包，走Server强制下载");
            }
            cVar.Ks().putInt("aiapp_launch_state", 0);
            if (kT != null) {
                com.baidu.swan.pms.database.a.aaX().kU(cVar.mAppId);
            }
            z2 = true;
        }
        if (!z2 && !a(kT, cVar, uuid)) {
            z3 = false;
        }
        at.at("WithDL", String.valueOf(z3));
        if (z) {
            cVar.Ks().putLong("ext_launch_time", System.currentTimeMillis());
            a(cVar, kT, bL(z3));
        }
        cVar.Ks().putString("aiapp_extra_need_download", bL(z3));
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        final com.baidu.swan.pms.b.d.b a = a(cVar, kT, z2);
        if (z3) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", " 同步从Server获取小程序包，不执行并行操作");
            }
            a.lg("3");
            at.fG("start sync PMS");
            com.baidu.swan.pms.c.a(a, new e(context, cVar, uuid) { // from class: com.baidu.swan.apps.v.c.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void Ei() {
                    af("670", "aiapp_aps_check_start_timestamp");
                    super.Ei();
                }

                @Override // com.baidu.swan.apps.core.pms.e, com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void Gm() {
                    super.Gm();
                    af("670", "aiapp_aps_check_end_timestamp");
                }

                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void a(com.baidu.swan.pms.e.e eVar) {
                    af("670", "aiapp_download_start_timestamp");
                    super.a(eVar);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.swan.apps.core.pms.e, com.baidu.swan.apps.core.pms.d
                public void Gj() {
                    af("670", "aiapp_download_end_timestamp");
                    super.Gj();
                }

                @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                public void af(String str, String str2) {
                    super.af(str, str2);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        char c = 65535;
                        switch (str.hashCode()) {
                            case 53647:
                                if (str.equals("670")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 54608:
                                if (str.equals("770")) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                com.baidu.swan.apps.performance.b.NA().aA(uuid, str2);
                                return;
                            case 1:
                                if (this.aJy != null) {
                                    this.aJy.add(new UbcFlowEvent(str2));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
            return;
        }
        if (!TextUtils.isEmpty(kT.appId) && !TextUtils.isEmpty(kT.iconUrl)) {
            com.baidu.swan.apps.core.a.c.c(kT.appId, kT.iconUrl, String.valueOf(kT.versionCode), kT.bLU);
        }
        if (DEBUG) {
            Log.e("SwanAppLauncher", "本地有包，Local");
        }
        d.a(context, cVar, kT, uuid);
        if (DEBUG) {
            Log.i("SwanAppLauncher", "本地有包，并行请求APS");
        }
        int Bf = com.baidu.swan.apps.u.a.Jl() != null ? com.baidu.swan.apps.u.a.Jl().Bf() : 0;
        if (Bf > 0) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.v.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.pms.b.d.b.this.lg("4");
                    com.baidu.swan.pms.c.a(com.baidu.swan.pms.b.d.b.this, new com.baidu.swan.apps.core.pms.c(cVar) { // from class: com.baidu.swan.apps.v.c.2.1
                        @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                        public void af(String str, String str2) {
                            super.af(str, str2);
                            if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.aJy != null) {
                                this.aJy.add(new UbcFlowEvent(str2));
                            }
                        }
                    });
                }
            }, Bf, TimeUnit.MILLISECONDS);
            return;
        }
        a.lg("4");
        com.baidu.swan.pms.c.a(a, new com.baidu.swan.apps.core.pms.c(cVar) { // from class: com.baidu.swan.apps.v.c.3
            @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
            public void af(String str, String str2) {
                super.af(str, str2);
                if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.aJy != null) {
                    this.aJy.add(new UbcFlowEvent(str2));
                }
            }
        });
    }

    private static com.baidu.swan.pms.b.d.b a(com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo, boolean z) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.c.a.fF(cVar.aJr).KW().dD(1);
        com.baidu.swan.pms.b.d.b bVar = new com.baidu.swan.pms.b.d.b(cVar.mAppId, cVar.aTl);
        if (!z && pMSAppInfo != null) {
            bVar.gH(pMSAppInfo.versionCode);
            bVar.aA(pMSAppInfo.bLP);
        }
        String iV = aa.iV(cVar.aTe);
        if (!TextUtils.isEmpty(iV)) {
            if (iV.startsWith(File.separator)) {
                iV = iV.substring(1);
            }
            bVar.lc(iV);
        }
        return bVar;
    }

    public static boolean fq(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return c(com.baidu.swan.pms.database.a.aaX().kT(str));
    }

    private static boolean a(@Nullable PMSAppInfo pMSAppInfo, @NonNull com.baidu.swan.apps.v.b.c cVar, String str) {
        if (pMSAppInfo == null) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "AppInfo 为空，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.NA().d(str, "aiapp_launch_state", 0);
            return true;
        } else if (pMSAppInfo.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "有错误code，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.NA().d(str, "aiapp_launch_state", 2);
            return true;
        } else if (pMSAppInfo.abf()) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.NA().d(str, "aiapp_launch_state", 2);
            return true;
        } else if (pMSAppInfo.Hr()) {
            if (com.baidu.swan.apps.core.a.c.b.El().en(pMSAppInfo.appId)) {
                if (DEBUG) {
                    Log.i("SwanAppLauncher", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + pMSAppInfo.appId);
                }
                com.baidu.swan.apps.performance.b.NA().d(str, "aiapp_launch_state", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanAppLauncher", "本地包已过期");
            }
            com.baidu.swan.apps.performance.b.NA().d(str, "aiapp_launch_state", 1);
            return true;
        } else {
            com.baidu.swan.apps.performance.b.NA().d(str, "aiapp_launch_state", 4);
            return false;
        }
    }

    private static boolean c(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0) {
            return false;
        }
        if (pMSAppInfo.bLU == 1) {
            return d(pMSAppInfo);
        }
        File am = e.d.am(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (am == null || !am.exists()) {
            File t = e.d.t(pMSAppInfo.appId, false);
            return t != null && t.exists();
        }
        return true;
    }

    private static boolean d(PMSAppInfo pMSAppInfo) {
        File am = a.d.am(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (am == null || !am.exists()) {
            File t = a.d.t(pMSAppInfo.appId, false);
            return t != null && t.exists();
        }
        return true;
    }

    private static String bL(boolean z) {
        return z ? "1" : "0";
    }

    private static void a(com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo, String str) {
        f fVar = new f();
        fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(cVar.aTl);
        fVar.d(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.bpz = str;
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        fVar.aI(com.baidu.swan.apps.statistic.e.hY(cVar.aTi));
        com.baidu.swan.apps.statistic.e.onEvent(fVar);
    }
}
