package com.baidu.swan.apps.v;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.core.pms.e;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.games.i.a;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
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
        cVar.DC().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.performance.b.FJ().q(uuid, "aiapp_abtest_info", a.getInfo());
        a.clean();
        com.baidu.swan.apps.performance.b.FJ().f(uuid, "is_sileng_updating_when_start", com.baidu.swan.apps.core.a.c.b.xP().isInProgress());
        cVar.DC().putLong("aiapp_start_timestamp", System.currentTimeMillis());
        com.baidu.swan.pms.model.a ji = com.baidu.swan.pms.database.a.RA().ji(cVar.mAppId);
        com.baidu.swan.apps.performance.b.FJ().ar(uuid, "aiapp_query_db_timestamp");
        if (ji != null && !TextUtils.isEmpty(ji.appId) && !TextUtils.isEmpty(ji.iconUrl)) {
            com.baidu.swan.apps.core.a.c.b(ji.appId, ji.iconUrl, String.valueOf(ji.versionCode), ji.appCategory);
        }
        if (d(ji)) {
            z2 = false;
        } else {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "本地无包，走Server强制下载");
            }
            cVar.DC().putInt("aiapp_launch_state", 0);
            if (ji != null) {
                com.baidu.swan.pms.database.a.RA().jj(cVar.mAppId);
            }
            z2 = true;
        }
        if (!z2 && !a(ji, cVar, uuid)) {
            z3 = false;
        }
        if (z) {
            cVar.DC().putLong("ext_launch_time", System.currentTimeMillis());
            a(cVar, ji, bh(z3));
        }
        cVar.DC().putString("aiapp_extra_need_download", bh(z3));
        com.baidu.swan.apps.statistic.b.c.e(cVar);
        final com.baidu.swan.pms.b.d.a a = a(cVar, ji, z2);
        if (z3) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", " 同步从Server获取小程序包，不执行并行操作");
            }
            com.baidu.swan.pms.c.a(a, new e(context, cVar, uuid) { // from class: com.baidu.swan.apps.v.c.1
                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
                public void xM() {
                    ac("670", "aiapp_aps_check_start_timestamp");
                    super.xM();
                }

                @Override // com.baidu.swan.apps.core.pms.e, com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
                public void zC() {
                    super.zC();
                    ac("670", "aiapp_aps_check_end_timestamp");
                }

                @Override // com.baidu.swan.apps.core.pms.d, com.baidu.swan.pms.a.e
                public void a(com.baidu.swan.pms.d.e eVar) {
                    ac("670", "aiapp_download_start_timestamp");
                    super.a(eVar);
                }

                @Override // com.baidu.swan.pms.a.e, com.baidu.swan.pms.a.b
                public void DA() {
                    super.DA();
                    ac("670", "aiapp_download_end_timestamp");
                }

                @Override // com.baidu.swan.pms.a.e, com.baidu.swan.pms.a.b
                public void ac(String str, String str2) {
                    super.ac(str, str2);
                    if (!TextUtils.isEmpty(str2)) {
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
                                com.baidu.swan.apps.performance.b.FJ().ar(uuid, str2);
                                return;
                            case 1:
                                if (this.aoP != null) {
                                    this.aoP.add(new UbcFlowEvent(str2));
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
        if (DEBUG) {
            Log.e("SwanAppLauncher", "本地有包，Local");
        }
        d.a(context, cVar, ji, uuid);
        if (DEBUG) {
            Log.i("SwanAppLauncher", "本地有包，并行请求APS");
        }
        int vf = com.baidu.swan.apps.u.a.CB() != null ? com.baidu.swan.apps.u.a.CB().vf() : 0;
        if (vf > 0) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.v.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.pms.c.a(com.baidu.swan.pms.b.d.a.this, new com.baidu.swan.apps.core.pms.c(cVar) { // from class: com.baidu.swan.apps.v.c.2.1
                        @Override // com.baidu.swan.pms.a.e, com.baidu.swan.pms.a.b
                        public void ac(String str, String str2) {
                            super.ac(str, str2);
                            if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.aoP != null) {
                                this.aoP.add(new UbcFlowEvent(str2));
                            }
                        }
                    });
                }
            }, vf, TimeUnit.MILLISECONDS);
        } else {
            com.baidu.swan.pms.c.a(a, new com.baidu.swan.apps.core.pms.c(cVar) { // from class: com.baidu.swan.apps.v.c.3
                @Override // com.baidu.swan.pms.a.e, com.baidu.swan.pms.a.b
                public void ac(String str, String str2) {
                    super.ac(str, str2);
                    if (!TextUtils.isEmpty(str2) && TextUtils.equals(str, "770") && this.aoP != null) {
                        this.aoP.add(new UbcFlowEvent(str2));
                    }
                }
            });
        }
    }

    private static com.baidu.swan.pms.b.d.a a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.pms.model.a aVar, boolean z) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.pms.b.d.a aVar2 = new com.baidu.swan.pms.b.d.a(cVar.mAppId, 0);
        if (!z && aVar != null) {
            aVar2.fi(aVar.versionCode);
            aVar2.U(aVar.blM);
        }
        String hF = y.hF(cVar.axI);
        if (!TextUtils.isEmpty(hF)) {
            if (hF.startsWith(File.separator)) {
                hF = hF.substring(1);
            }
            aVar2.js(hF);
        }
        return aVar2;
    }

    private static boolean a(@Nullable com.baidu.swan.pms.model.a aVar, @NonNull com.baidu.swan.apps.v.b.c cVar, String str) {
        if (aVar == null) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "AppInfo 为空，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 0);
            return true;
        } else if (aVar.appStatus != 0) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "有错误code，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 2);
            return true;
        } else if (aVar.RI()) {
            if (DEBUG) {
                Log.i("SwanAppLauncher", "有悬而未决的的errCode要处理，走Server同步下载");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 2);
            return true;
        } else if (aVar.AF()) {
            if (com.baidu.swan.apps.core.a.c.b.xP().dK(aVar.appId)) {
                if (DEBUG) {
                    Log.i("SwanAppLauncher", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + aVar.appId);
                }
                com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 3);
                return false;
            }
            if (DEBUG) {
                Log.i("SwanAppLauncher", "本地包已过期");
            }
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 1);
            return true;
        } else {
            com.baidu.swan.apps.performance.b.FJ().e(str, "aiapp_launch_state", 4);
            return false;
        }
    }

    private static boolean d(@Nullable com.baidu.swan.pms.model.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.appId) || aVar.versionCode == 0) {
            return false;
        }
        if (aVar.appCategory == 1) {
            return e(aVar);
        }
        File ah = c.d.ah(aVar.appId, String.valueOf(aVar.versionCode));
        if (ah == null || !ah.exists()) {
            File q = c.d.q(aVar.appId, false);
            return q != null && q.exists();
        }
        return true;
    }

    private static boolean e(com.baidu.swan.pms.model.a aVar) {
        File ah = a.c.ah(aVar.appId, String.valueOf(aVar.versionCode));
        if (ah == null || !ah.exists()) {
            File q = a.c.q(aVar.appId, false);
            return q != null && q.exists();
        }
        return true;
    }

    private static String bh(boolean z) {
        return z ? "1" : "0";
    }

    private static void a(com.baidu.swan.apps.v.b.c cVar, com.baidu.swan.pms.model.a aVar, String str) {
        f fVar = new f();
        fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(cVar.axX);
        fVar.d(cVar);
        fVar.mType = "launch";
        fVar.aSu = str;
        if (aVar != null) {
            fVar.mAppVersion = String.valueOf(aVar.versionCode);
        }
        String str2 = cVar.axH;
        if (str2 != null) {
            String queryParameter = Uri.parse(str2).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null && TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                        fVar.ai(optJSONObject);
                    }
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        com.baidu.swan.apps.statistic.c.onEvent(fVar);
    }
}
