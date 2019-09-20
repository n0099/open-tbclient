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
    private g arj;
    private com.baidu.swan.apps.core.d.b bds;
    private Context mContext;

    public b(g gVar, com.baidu.swan.apps.core.d.b bVar) {
        this.arj = gVar;
        this.bds = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void Qx() {
        if (this.arj != null && this.bds != null && this.mContext != null) {
            this.arj.a(new e() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, j jVar) {
                    return b.this.b(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(j jVar) {
        if (this.bds == null || this.mContext == null) {
            return false;
        }
        switch (jVar.getItemId()) {
            case 4:
                this.bds.zZ();
                return true;
            case 5:
                Qz();
                return true;
            case 9:
                QD();
                return true;
            case 34:
                this.bds.zY();
                return true;
            case 35:
                QA();
                return true;
            case 36:
                QB();
                return true;
            case 37:
                QC();
                return true;
            case 38:
                Qy();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.Es().a(jVar);
        }
    }

    private void Qy() {
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (!TextUtils.isEmpty(Ms)) {
            boolean em = com.baidu.swan.apps.database.favorite.a.em(Ms);
            f fVar = new f();
            fVar.mSource = "menu";
            fVar.k("appid", Ms);
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            if (Mh != null) {
                fVar.k("appversion", Mh.getVersion());
            }
            if (em) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.ek(Ms)) {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).dK(2).LX();
                } else {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).dK(2).LU();
                }
            } else {
                ShowFavoriteGuideAction.aTp = null;
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.ej(Ms)) {
                    com.baidu.swan.apps.database.favorite.a.CF();
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).dK(2).LX();
                } else {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).dK(2).LU();
                }
            }
            this.bds.a(fVar);
        }
    }

    public static boolean T(@NonNull Activity activity) {
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (TextUtils.isEmpty(Ms)) {
            return false;
        }
        if (com.baidu.swan.apps.database.favorite.a.em(Ms)) {
            return true;
        }
        if (com.baidu.swan.apps.database.favorite.a.ej(Ms)) {
            com.baidu.swan.apps.database.favorite.a.CF();
            d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).dK(2).LX();
            return true;
        }
        d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).dK(2).LU();
        return false;
    }

    private void Qz() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Fi = com.baidu.swan.apps.u.a.EJ().Fi();
        com.baidu.swan.apps.u.a.EJ().bo(!Fi);
        if (this.bds.Xg() != null && (this.bds.Xg() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bds.Xg()).aQ(com.baidu.swan.apps.u.a.EJ().Fi());
        }
        if (Fi) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).dL(a.e.aiapps_day_mode_toast_icon).dK(2).LX();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).dL(a.e.aiapps_night_mode_toast_icon).dK(2).LX();
        }
    }

    private void QA() {
        com.baidu.swan.apps.v.b.b vP;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.Mh() != null) {
            vP = com.baidu.swan.apps.ae.b.Mh().vP();
        } else {
            vP = ((SwanAppActivity) this.bds.Xg()).vP();
        }
        com.baidu.swan.apps.ah.a.d(this.bds.getContext(), vP);
        iI("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.bds instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bds;
            c Al = dVar.Al();
            if (Al == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.w.e.GJ().Gu());
            hashMap.put("pagePath", dVar.Aj());
            hashMap.put("slaveId", Al.xz());
            com.baidu.swan.apps.w.e.GJ().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            iI(Headers.REFRESH);
        }
    }

    private void QB() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            if (this.bds != null) {
                d.k(this.bds.getContext(), a.h.aiapps_open_fragment_failed_toast).LU();
                return;
            }
            return;
        }
        vN.dU("navigateTo").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).a("about", null).commit();
        iI("about");
    }

    private void QC() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e vN = this.bds.vN();
        if (vN == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).LU();
            return;
        }
        vN.dU("navigateTo").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).a("setting", null).commit();
        iI("permission");
    }

    private void QD() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.Ex().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.k(com.baidu.swan.apps.u.a.Eo(), a.h.aiapps_report_tips).dK(2).LU();
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

    private void iI(String str) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = new f();
            fVar.mValue = str;
            this.bds.a(fVar);
        }
    }
}
