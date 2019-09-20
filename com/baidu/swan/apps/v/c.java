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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
        cVar.aqb = uuid;
        com.baidu.swan.apps.v.c.a al = com.baidu.swan.apps.v.c.a.eY(uuid).al("dl_type", "PMS");
        al.eZ(IntentConfig.START);
        cVar.Fy().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        cVar.Fy().putLong("page_display_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.performance.b.IG().q(uuid, "aiapp_abtest_info", a.Fq());
        a.clean();
        com.baidu.swan.apps.performance.b.IG().f(uuid, "is_sileng_updating_when_start", com.baidu.swan.apps.core.a.c.b.zq().zr());
        cVar.Fy().putLong("aiapp_start_timestamp", System.currentTimeMillis());
        PMSAppInfo kr = com.baidu.swan.pms.database.a.Wi().kr(cVar.mAppId);
        com.baidu.swan.apps.performance.b.IG().as(uuid, "aiapp_query_db_timestamp");
        if (c(kr)) {
            z2 = false;
        } else {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "本地无包，走Server强制下载");
            }
            cVar.Fy().putInt("aiapp_launch_state", 0);
            if (kr != null) {
                com.baidu.swan.pms.database.a.Wi().ks(cVar.mAppId);
            }
            z2 = true;
        }
        if (!z2 && !a(kr, cVar, uuid)) {
            z3 = false;
        }
        al.al("WithDL", String.valueOf(z3));
        if (z) {
            cVar.Fy().putLong("ext_launch_time", System.currentTimeMillis());
            a(cVar, kr, bt(z3));
        }
        cVar.Fy().putString("aiapp_extra_need_download", bt(z3));
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        final com.baidu.swan.pms.b.d.b a = a(cVar, kr, z2);
        if (z3) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", " 同步从Server获取小程序包，不执行并行操作");
            }
            a.kE("3");
            al.eZ("start sync PMS");
            com.baidu.swan.pms.c.a(a, new e(context, cVar, uuid) { // from class: com.baidu.swan.apps.v.c.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void zn() {
                    X("670", "aiapp_aps_check_start_timestamp");
                    super.zn();
                }

                @Override // com.baidu.swan.apps.core.pms.e, com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void Br() {
                    super.Br();
                    X("670", "aiapp_aps_check_end_timestamp");
                }

                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.f
                public void a(com.baidu.swan.pms.e.e eVar) {
                    X("670", "aiapp_download_start_timestamp");
                    super.a(eVar);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.swan.apps.core.pms.e, com.baidu.swan.apps.core.pms.d
                public void Bo() {
                    X("670", "aiapp_download_end_timestamp");
                    super.Bo();
                }

                @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                public void X(String str, String str2) {
                    super.X(str, str2);
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
                                com.baidu.swan.apps.performance.b.IG().as(uuid, str2);
                                return;
                            case 1:
                                if (this.aqi != null) {
                                    this.aqi.add(new UbcFlowEvent(str2));
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
        if (!TextUtils.isEmpty(kr.appId) && !TextUtils.isEmpty(kr.iconUrl)) {
            com.baidu.swan.apps.core.a.c.b(kr.appId, kr.iconUrl, String.valueOf(kr.versionCode), kr.btj);
        }
        if (DEBUG) {
            Log.e("SwanAppLauncher", "本地有包，Local");
        }
        d.a(context, cVar, kr, uuid);
        if (DEBUG) {
            Log.i("SwanAppLauncher", "本地有包，并行请求APS");
        }
        int wl = com.baidu.swan.apps.u.a.Er() != null ? com.baidu.swan.apps.u.a.Er().wl() : 0;
        if (wl > 0) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.v.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.pms.b.d.b.this.kE("4");
                    com.baidu.swan.pms.c.a(com.baidu.swan.pms.b.d.b.this, new com.baidu.swan.apps.core.pms.c(cVar) { // from class: com.baidu.swan.apps.v.c.2.1
                        @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
                        public void X(String str, String str2) {
                            super.X(str, str2);
                            if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.aqi != null) {
                                this.aqi.add(new UbcFlowEvent(str2));
                            }
                        }
                    });
                }
            }, wl, TimeUnit.MILLISECONDS);
            return;
        }
        a.kE("4");
        com.baidu.swan.pms.c.a(a, new com.baidu.swan.apps.core.pms.c(cVar) { // from class: com.baidu.swan.apps.v.c.3
            @Override // com.baidu.swan.pms.a.f, com.baidu.swan.pms.a.b
            public void X(String str, String str2) {
                super.X(str, str2);
                if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.aqi != null) {
                    this.aqi.add(new UbcFlowEvent(str2));
                }
            }
        });
    }

    private static com.baidu.swan.pms.b.d.b a(com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo, boolean z) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.c.a.eY(cVar.aqb).Gc().cI(1);
        com.baidu.swan.pms.b.d.b bVar = new com.baidu.swan.pms.b.d.b(cVar.mAppId, cVar.azX);
        if (!z && pMSAppInfo != null) {
            bVar.fM(pMSAppInfo.versionCode);
            bVar.ah(pMSAppInfo.bte);
        }
        String is = aa.is(cVar.azQ);
        if (!TextUtils.isEmpty(is)) {
            if (is.startsWith(File.separator)) {
                is = is.substring(1);
            }
            bVar.kA(is);
        }
        return bVar;
    }

    public static boolean eJ(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return c(com.baidu.swan.pms.database.a.Wi().kr(str));
    }

    private static boolean a(@Nullable PMSAppInfo pMSAppInfo, @NonNull com.baidu.swan.apps.v.b.c cVar, String str) {
        if (pMSAppInfo == null) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "AppInfo 为空，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.IG().d(str, "aiapp_launch_state", 0);
            return true;
        } else if (pMSAppInfo.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "有错误code，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.IG().d(str, "aiapp_launch_state", 2);
            return true;
        } else if (pMSAppInfo.Wq()) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.IG().d(str, "aiapp_launch_state", 2);
            return true;
        } else if (pMSAppInfo.Cx()) {
            if (com.baidu.swan.apps.core.a.c.b.zq().dF(pMSAppInfo.appId)) {
                if (DEBUG) {
                    Log.i("SwanAppLauncher", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + pMSAppInfo.appId);
                }
                com.baidu.swan.apps.performance.b.IG().d(str, "aiapp_launch_state", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanAppLauncher", "本地包已过期");
            }
            com.baidu.swan.apps.performance.b.IG().d(str, "aiapp_launch_state", 1);
            return true;
        } else {
            com.baidu.swan.apps.performance.b.IG().d(str, "aiapp_launch_state", 4);
            return false;
        }
    }

    private static boolean c(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.versionCode == 0) {
            return false;
        }
        if (pMSAppInfo.btj == 1) {
            return d(pMSAppInfo);
        }
        File ae = e.d.ae(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (ae == null || !ae.exists()) {
            File q = e.d.q(pMSAppInfo.appId, false);
            return q != null && q.exists();
        }
        return true;
    }

    private static boolean d(PMSAppInfo pMSAppInfo) {
        File ae = a.d.ae(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
        if (ae == null || !ae.exists()) {
            File q = a.d.q(pMSAppInfo.appId, false);
            return q != null && q.exists();
        }
        return true;
    }

    private static String bt(boolean z) {
        return z ? "1" : "0";
    }

    private static void a(com.baidu.swan.apps.v.b.c cVar, PMSAppInfo pMSAppInfo, String str) {
        f fVar = new f();
        fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(cVar.azX);
        fVar.d(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.aWv = str;
        if (pMSAppInfo != null) {
            fVar.mAppVersion = String.valueOf(pMSAppInfo.versionCode);
        }
        fVar.ak(com.baidu.swan.apps.statistic.e.hv(cVar.azU));
        com.baidu.swan.apps.statistic.e.onEvent(fVar);
    }
}
