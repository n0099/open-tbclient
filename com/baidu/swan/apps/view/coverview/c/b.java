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
    private g aqi;
    private com.baidu.swan.apps.core.d.b bci;
    private Context mContext;

    public b(g gVar, com.baidu.swan.apps.core.d.b bVar) {
        this.aqi = gVar;
        this.bci = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void PB() {
        if (this.aqi != null && this.bci != null && this.mContext != null) {
            this.aqi.a(new e() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, j jVar) {
                    return b.this.b(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(j jVar) {
        if (this.bci == null || this.mContext == null) {
            return false;
        }
        switch (jVar.getItemId()) {
            case 4:
                this.bci.zo();
                return true;
            case 5:
                PD();
                return true;
            case 9:
                PH();
                return true;
            case 34:
                this.bci.zn();
                return true;
            case 35:
                PE();
                return true;
            case 36:
                PF();
                return true;
            case 37:
                PG();
                return true;
            case 38:
                PC();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.DF().a(jVar);
        }
    }

    private void PC() {
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (!TextUtils.isEmpty(LB)) {
            boolean eg = com.baidu.swan.apps.database.favorite.a.eg(LB);
            f fVar = new f();
            fVar.mSource = "menu";
            fVar.k("appid", LB);
            com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
            if (Lq != null) {
                fVar.k("appversion", Lq.getVersion());
            }
            if (eg) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.ee(LB)) {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).dG(2).Lg();
                } else {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).dG(2).Ld();
                }
            } else {
                ShowFavoriteGuideAction.aSh = null;
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.ed(LB)) {
                    com.baidu.swan.apps.database.favorite.a.BS();
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).dG(2).Lg();
                } else {
                    d.k(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).dG(2).Ld();
                }
            }
            this.bci.a(fVar);
        }
    }

    public static boolean Q(@NonNull Activity activity) {
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (TextUtils.isEmpty(LB)) {
            return false;
        }
        if (com.baidu.swan.apps.database.favorite.a.eg(LB)) {
            return true;
        }
        if (com.baidu.swan.apps.database.favorite.a.ed(LB)) {
            com.baidu.swan.apps.database.favorite.a.BS();
            d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).dG(2).Lg();
            return true;
        }
        d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).dG(2).Ld();
        return false;
    }

    private void PD() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Ev = com.baidu.swan.apps.u.a.DW().Ev();
        com.baidu.swan.apps.u.a.DW().bl(!Ev);
        if (this.bci.Wi() != null && (this.bci.Wi() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bci.Wi()).aN(com.baidu.swan.apps.u.a.DW().Ev());
        }
        if (Ev) {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).dH(a.e.aiapps_day_mode_toast_icon).dG(2).Lg();
        } else {
            d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).dH(a.e.aiapps_night_mode_toast_icon).dG(2).Lg();
        }
    }

    private void PE() {
        com.baidu.swan.apps.v.b.b vk;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.Lq() != null) {
            vk = com.baidu.swan.apps.ae.b.Lq().vk();
        } else {
            vk = ((SwanAppActivity) this.bci.Wi()).vk();
        }
        com.baidu.swan.apps.ah.a.d(this.bci.getContext(), vk);
        iA("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.bci instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bci;
            c zA = dVar.zA();
            if (zA == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.w.e.FV().FG());
            hashMap.put("pagePath", dVar.zy());
            hashMap.put("slaveId", zA.wU());
            com.baidu.swan.apps.w.e.FV().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            iA(Headers.REFRESH);
        }
    }

    private void PF() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            if (this.bci != null) {
                d.k(this.bci.getContext(), a.h.aiapps_open_fragment_failed_toast).Ld();
                return;
            }
            return;
        }
        vi.dO("navigateTo").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).a("about", null).commit();
        iA("about");
    }

    private void PG() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e vi = this.bci.vi();
        if (vi == null) {
            d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).Ld();
            return;
        }
        vi.dO("navigateTo").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).a("setting", null).commit();
        iA("permission");
    }

    private void PH() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.DK().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.k(com.baidu.swan.apps.u.a.DB(), a.h.aiapps_report_tips).dG(2).Ld();
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

    private void iA(String str) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = new f();
            fVar.mValue = str;
            this.bci.a(fVar);
        }
    }
}
