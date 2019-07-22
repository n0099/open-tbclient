package com.baidu.swan.apps.view.coverview.c;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b.b.g;
import com.baidu.swan.apps.b.c.c;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.scheme.actions.favorite.ShowFavoriteGuideAction;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.menu.e;
import com.baidu.swan.menu.g;
import com.baidu.swan.menu.j;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g aqL;
    private com.baidu.swan.apps.core.d.b bcU;
    private Context mContext;

    public b(g gVar, com.baidu.swan.apps.core.d.b bVar) {
        this.aqL = gVar;
        this.bcU = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void Qt() {
        if (this.aqL != null && this.bcU != null && this.mContext != null) {
            this.aqL.a(new e() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, j jVar) {
                    return b.this.b(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(j jVar) {
        if (this.bcU == null || this.mContext == null) {
            return false;
        }
        switch (jVar.getItemId()) {
            case 4:
                this.bcU.zV();
                return true;
            case 5:
                Qv();
                return true;
            case 9:
                Qz();
                return true;
            case 34:
                this.bcU.zU();
                return true;
            case 35:
                Qw();
                return true;
            case 36:
                Qx();
                return true;
            case 37:
                Qy();
                return true;
            case 38:
                Qu();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.Eo().a(jVar);
        }
    }

    private void Qu() {
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (!TextUtils.isEmpty(Mo)) {
            boolean ek = com.baidu.swan.apps.database.favorite.a.ek(Mo);
            f fVar = new f();
            fVar.mSource = "menu";
            fVar.k("appid", Mo);
            com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
            if (Md != null) {
                fVar.k("appversion", Md.getVersion());
            }
            if (ek) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.ei(Mo)) {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).dJ(2).LT();
                } else {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).dJ(2).LQ();
                }
            } else {
                ShowFavoriteGuideAction.aSR = null;
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.eh(Mo)) {
                    com.baidu.swan.apps.database.favorite.a.CB();
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).dJ(2).LT();
                } else {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).dJ(2).LQ();
                }
            }
            this.bcU.a(fVar);
        }
    }

    public static boolean T(@NonNull Activity activity) {
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (TextUtils.isEmpty(Mo)) {
            return false;
        }
        if (com.baidu.swan.apps.database.favorite.a.ek(Mo)) {
            return true;
        }
        if (com.baidu.swan.apps.database.favorite.a.eh(Mo)) {
            com.baidu.swan.apps.database.favorite.a.CB();
            d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).dJ(2).LT();
            return true;
        }
        d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).dJ(2).LQ();
        return false;
    }

    private void Qv() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Fe = com.baidu.swan.apps.u.a.EF().Fe();
        com.baidu.swan.apps.u.a.EF().bo(!Fe);
        if (this.bcU.Xc() != null && (this.bcU.Xc() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bcU.Xc()).aQ(com.baidu.swan.apps.u.a.EF().Fe());
        }
        if (Fe) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).dK(a.e.aiapps_day_mode_toast_icon).dJ(2).LT();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).dK(a.e.aiapps_night_mode_toast_icon).dJ(2).LT();
        }
    }

    private void Qw() {
        com.baidu.swan.apps.v.b.b vL;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            vL = com.baidu.swan.apps.ae.b.Md().vL();
        } else {
            vL = ((SwanAppActivity) this.bcU.Xc()).vL();
        }
        com.baidu.swan.apps.ah.a.d(this.bcU.getContext(), vL);
        iG("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.bcU instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bcU;
            c Ah = dVar.Ah();
            if (Ah == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.w.e.GF().Gq());
            hashMap.put("pagePath", dVar.Af());
            hashMap.put("slaveId", Ah.xv());
            com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            iG(Headers.REFRESH);
        }
    }

    private void Qx() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            if (this.bcU != null) {
                d.k(this.bcU.getContext(), a.h.aiapps_open_fragment_failed_toast).LQ();
                return;
            }
            return;
        }
        vJ.dS("navigateTo").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).a("about", null).commit();
        iG("about");
    }

    private void Qy() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e vJ = this.bcU.vJ();
        if (vJ == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).LQ();
            return;
        }
        vJ.dS("navigateTo").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).a("setting", null).commit();
        iG("permission");
    }

    private void Qz() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.Et().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.k(com.baidu.swan.apps.u.a.Ek(), a.h.aiapps_report_tips).dJ(2).LQ();
                            }
                        } catch (JSONException e) {
                            if (b.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }

    private void iG(String str) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = new f();
            fVar.mValue = str;
            this.bcU.a(fVar);
        }
    }
}
