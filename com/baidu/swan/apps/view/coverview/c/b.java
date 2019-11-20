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
    private g aKh;
    private com.baidu.swan.apps.core.d.b bvz;
    private Context mContext;

    public b(g gVar, com.baidu.swan.apps.core.d.b bVar) {
        this.aKh = gVar;
        this.bvz = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void Vl() {
        if (this.aKh != null && this.bvz != null && this.mContext != null) {
            this.aKh.a(new e() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, j jVar) {
                    return b.this.b(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(j jVar) {
        if (this.bvz == null || this.mContext == null) {
            return false;
        }
        switch (jVar.getItemId()) {
            case 4:
                this.bvz.EV();
                return true;
            case 5:
                Vn();
                return true;
            case 9:
                Vr();
                return true;
            case 34:
                this.bvz.EU();
                return true;
            case 35:
                Vo();
                return true;
            case 36:
                Vp();
                return true;
            case 37:
                Vq();
                return true;
            case 38:
                Vm();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.Jn().a(jVar);
        }
    }

    private void Vm() {
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (!TextUtils.isEmpty(Rm)) {
            boolean eT = com.baidu.swan.apps.database.favorite.a.eT(Rm);
            f fVar = new f();
            fVar.mSource = "menu";
            fVar.h("appid", Rm);
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            if (Ra != null) {
                fVar.h("appversion", Ra.getVersion());
            }
            if (eT) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.eR(Rm)) {
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).eF(2).QR();
                } else {
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).eF(2).QO();
                }
            } else {
                ShowFavoriteGuideAction.bmb = null;
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.eQ(Rm)) {
                    com.baidu.swan.apps.database.favorite.a.HA();
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).eF(2).QR();
                } else {
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).eF(2).QO();
                }
            }
            this.bvz.a(fVar);
        }
    }

    public static boolean S(@NonNull Activity activity) {
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (TextUtils.isEmpty(Rm)) {
            return false;
        }
        if (com.baidu.swan.apps.database.favorite.a.eT(Rm)) {
            return true;
        }
        if (com.baidu.swan.apps.database.favorite.a.eQ(Rm)) {
            com.baidu.swan.apps.database.favorite.a.HA();
            d.i(activity.getApplicationContext(), a.h.aiapps_fav_success).eF(2).QR();
            return true;
        }
        d.i(activity.getApplicationContext(), a.h.aiapps_fav_fail).eF(2).QO();
        return false;
    }

    private void Vn() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Kd = com.baidu.swan.apps.u.a.JE().Kd();
        com.baidu.swan.apps.u.a.JE().bG(!Kd);
        if (this.bvz.abT() != null && (this.bvz.abT() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bvz.abT()).bi(com.baidu.swan.apps.u.a.JE().Kd());
        }
        if (Kd) {
            d.i(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).eG(a.e.aiapps_day_mode_toast_icon).eF(2).QR();
        } else {
            d.i(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).eG(a.e.aiapps_night_mode_toast_icon).eF(2).QR();
        }
    }

    private void Vo() {
        com.baidu.swan.apps.v.b.b AK;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.Ra() != null) {
            AK = com.baidu.swan.apps.ae.b.Ra().AK();
        } else {
            AK = ((SwanAppActivity) this.bvz.abT()).AK();
        }
        com.baidu.swan.apps.ah.a.d(this.bvz.getContext(), AK);
        jl("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.bvz instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bvz;
            c Fh = dVar.Fh();
            if (Fh == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.w.e.LE().Lp());
            hashMap.put("pagePath", dVar.Ff());
            hashMap.put("slaveId", Fh.Cu());
            com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            jl(Headers.REFRESH);
        }
    }

    private void Vp() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            if (this.bvz != null) {
                d.i(this.bvz.getContext(), a.h.aiapps_open_fragment_failed_toast).QO();
                return;
            }
            return;
        }
        AI.eC("navigateTo").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).a("about", null).commit();
        jl("about");
    }

    private void Vq() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e AI = this.bvz.AI();
        if (AI == null) {
            d.i(this.mContext, a.h.aiapps_open_fragment_failed_toast).QO();
            return;
        }
        AI.eC("navigateTo").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).a("setting", null).commit();
        jl("permission");
    }

    private void Vr() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.Js().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.i(com.baidu.swan.apps.u.a.Jj(), a.h.aiapps_report_tips).eF(2).QO();
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

    private void jl(String str) {
        if (!TextUtils.isEmpty(str)) {
            f fVar = new f();
            fVar.mValue = str;
            this.bvz.a(fVar);
        }
    }
}
