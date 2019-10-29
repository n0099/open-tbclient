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
    private g aKz;
    private com.baidu.swan.apps.core.d.b bwq;
    private Context mContext;

    public b(g gVar, com.baidu.swan.apps.core.d.b bVar) {
        this.aKz = gVar;
        this.bwq = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void Vn() {
        if (this.aKz != null && this.bwq != null && this.mContext != null) {
            this.aKz.a(new e() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, j jVar) {
                    return b.this.b(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(j jVar) {
        if (this.bwq == null || this.mContext == null) {
            return false;
        }
        switch (jVar.getItemId()) {
            case 4:
                this.bwq.EU();
                return true;
            case 5:
                Vp();
                return true;
            case 9:
                Vt();
                return true;
            case 34:
                this.bwq.ET();
                return true;
            case 35:
                Vq();
                return true;
            case 36:
                Vr();
                return true;
            case 37:
                Vs();
                return true;
            case 38:
                Vo();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.Jm().a(jVar);
        }
    }

    private void Vo() {
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (!TextUtils.isEmpty(Rk)) {
            boolean eT = com.baidu.swan.apps.database.favorite.a.eT(Rk);
            f fVar = new f();
            fVar.mSource = "menu";
            fVar.h("appid", Rk);
            com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
            if (QZ != null) {
                fVar.h("appversion", QZ.getVersion());
            }
            if (eT) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.eR(Rk)) {
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).eF(2).QQ();
                } else {
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).eF(2).QN();
                }
            } else {
                ShowFavoriteGuideAction.bmu = null;
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.eQ(Rk)) {
                    com.baidu.swan.apps.database.favorite.a.Hz();
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).eF(2).QQ();
                } else {
                    d.i(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).eF(2).QN();
                }
            }
            this.bwq.a(fVar);
        }
    }

    public static boolean S(@NonNull Activity activity) {
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (TextUtils.isEmpty(Rk)) {
            return false;
        }
        if (com.baidu.swan.apps.database.favorite.a.eT(Rk)) {
            return true;
        }
        if (com.baidu.swan.apps.database.favorite.a.eQ(Rk)) {
            com.baidu.swan.apps.database.favorite.a.Hz();
            d.i(activity.getApplicationContext(), a.h.aiapps_fav_success).eF(2).QQ();
            return true;
        }
        d.i(activity.getApplicationContext(), a.h.aiapps_fav_fail).eF(2).QN();
        return false;
    }

    private void Vp() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Kc = com.baidu.swan.apps.u.a.JD().Kc();
        com.baidu.swan.apps.u.a.JD().bG(!Kc);
        if (this.bwq.abV() != null && (this.bwq.abV() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.bwq.abV()).bi(com.baidu.swan.apps.u.a.JD().Kc());
        }
        if (Kc) {
            d.i(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).eG(a.e.aiapps_day_mode_toast_icon).eF(2).QQ();
        } else {
            d.i(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).eG(a.e.aiapps_night_mode_toast_icon).eF(2).QQ();
        }
    }

    private void Vq() {
        com.baidu.swan.apps.v.b.b AJ;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.QZ() != null) {
            AJ = com.baidu.swan.apps.ae.b.QZ().AJ();
        } else {
            AJ = ((SwanAppActivity) this.bwq.abV()).AJ();
        }
        com.baidu.swan.apps.ah.a.d(this.bwq.getContext(), AJ);
        jl("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.bwq instanceof com.baidu.swan.apps.core.d.d) {
            com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) this.bwq;
            c Fg = dVar.Fg();
            if (Fg == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", com.baidu.swan.apps.w.e.LD().Lo());
            hashMap.put("pagePath", dVar.Fe());
            hashMap.put("slaveId", Fg.Ct());
            com.baidu.swan.apps.w.e.LD().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            jl(Headers.REFRESH);
        }
    }

    private void Vr() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            if (this.bwq != null) {
                d.i(this.bwq.getContext(), a.h.aiapps_open_fragment_failed_toast).QN();
                return;
            }
            return;
        }
        AH.eC("navigateTo").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).a("about", null).commit();
        jl("about");
    }

    private void Vs() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.e AH = this.bwq.AH();
        if (AH == null) {
            d.i(this.mContext, a.h.aiapps_open_fragment_failed_toast).QN();
            return;
        }
        AH.eC("navigateTo").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).a("setting", null).commit();
        jl("permission");
    }

    private void Vt() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.Jr().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.i(com.baidu.swan.apps.u.a.Ji(), a.h.aiapps_report_tips).eF(2).QN();
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
            this.bwq.a(fVar);
        }
    }
}
