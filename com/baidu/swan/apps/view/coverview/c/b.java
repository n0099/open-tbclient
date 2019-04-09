package com.baidu.swan.apps.view.coverview.c;

import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.b.b.g;
import com.baidu.swan.apps.b.c.c;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.h;
import com.baidu.swan.menu.k;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.c.b aZu;
    private h aqc;
    private Context mContext;

    public b(h hVar, com.baidu.swan.apps.core.c.b bVar) {
        this.aqc = hVar;
        this.aZu = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void MS() {
        if (this.aqc != null && this.aZu != null && this.mContext != null) {
            this.aqc.a(new f() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, k kVar) {
                    return b.this.b(kVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(k kVar) {
        if (this.aZu == null || this.mContext == null) {
            return false;
        }
        switch (kVar.getItemId()) {
            case 4:
                this.aZu.yu();
                return true;
            case 5:
                MU();
                return true;
            case 9:
                MY();
                return true;
            case 34:
                this.aZu.yt();
                return true;
            case 35:
                MV();
                return true;
            case 36:
                MW();
                return true;
            case 37:
                MX();
                return true;
            case 38:
                MT();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.CA().a(kVar);
        }
    }

    private void MT() {
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (!TextUtils.isEmpty(Jg)) {
            boolean er = com.baidu.swan.apps.database.favorite.a.er(Jg);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mSource = "menu";
            fVar.aB("appid", Jg);
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (IV != null) {
                fVar.aB("appversion", IV.getVersion());
            }
            if (er) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.ep(Jg)) {
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).dv(2).IL();
                } else {
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).dv(2).II();
                }
            } else {
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.eo(Jg)) {
                    com.baidu.swan.apps.database.favorite.a.AL();
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).dv(2).IL();
                } else {
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).dv(2).II();
                }
            }
            this.aZu.a(fVar);
        }
    }

    private void MU() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Dq = com.baidu.swan.apps.u.a.CR().Dq();
        com.baidu.swan.apps.u.a.CR().be(!Dq);
        if (this.aZu.Sw() != null && (this.aZu.Sw() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.aZu.Sw()).aK(com.baidu.swan.apps.u.a.CR().Dq());
        }
        if (Dq) {
            d.l(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).dw(a.e.aiapps_day_mode_toast_icon).dv(2).IL();
        } else {
            d.l(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).dw(a.e.aiapps_night_mode_toast_icon).dv(2).IL();
        }
    }

    private void MV() {
        com.baidu.swan.apps.v.b.b uA;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.IV() != null) {
            uA = com.baidu.swan.apps.ae.b.IV().uA();
        } else {
            uA = ((SwanAppActivity) this.aZu.Sw()).uA();
        }
        com.baidu.swan.apps.ah.a.d(this.aZu.getContext(), uA);
        hV("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.aZu instanceof com.baidu.swan.apps.core.c.d) {
            com.baidu.swan.apps.core.c.d dVar = (com.baidu.swan.apps.core.c.d) this.aZu;
            c yF = dVar.yF();
            if (yF == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", e.Ea().DL());
            hashMap.put("pagePath", dVar.yD());
            hashMap.put("slaveId", yF.wd());
            e.Ea().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            hV(Headers.REFRESH);
        }
    }

    private void MW() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.c.e uy = e.Ea().uy();
        if (uy == null) {
            if (this.aZu != null) {
                d.l(this.aZu.getContext(), a.h.aiapps_open_fragment_failed_toast).II();
                return;
            }
            return;
        }
        uy.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqO, com.baidu.swan.apps.core.c.e.aqQ).a("about", null).commit();
        hV("about");
    }

    private void MX() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.c.e uy = this.aZu.uy();
        if (uy == null) {
            d.l(this.mContext, a.h.aiapps_open_fragment_failed_toast).II();
            return;
        }
        uy.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqO, com.baidu.swan.apps.core.c.e.aqQ).a("setting", null).commit();
        hV("permission");
    }

    private void MY() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.CF().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.l(com.baidu.swan.apps.u.a.Cw(), a.h.aiapps_report_tips).dv(2).II();
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

    private void hV(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            this.aZu.a(fVar);
        }
    }
}
