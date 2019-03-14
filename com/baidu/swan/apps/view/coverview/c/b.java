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
    private com.baidu.swan.apps.core.c.b aZq;
    private h apX;
    private Context mContext;

    public b(h hVar, com.baidu.swan.apps.core.c.b bVar) {
        this.apX = hVar;
        this.aZq = bVar;
        if (bVar != null) {
            this.mContext = bVar.getContext();
        }
    }

    public void MU() {
        if (this.apX != null && this.aZq != null && this.mContext != null) {
            this.apX.a(new f() { // from class: com.baidu.swan.apps.view.coverview.c.b.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, k kVar) {
                    return b.this.b(kVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(k kVar) {
        if (this.aZq == null || this.mContext == null) {
            return false;
        }
        switch (kVar.getItemId()) {
            case 4:
                this.aZq.yv();
                return true;
            case 5:
                MW();
                return true;
            case 9:
                Na();
                return true;
            case 34:
                this.aZq.yu();
                return true;
            case 35:
                MX();
                return true;
            case 36:
                MY();
                return true;
            case 37:
                MZ();
                return true;
            case 38:
                MV();
                return true;
            case 39:
                restart();
                return true;
            default:
                return com.baidu.swan.apps.u.a.CC().a(kVar);
        }
    }

    private void MV() {
        String Ji = com.baidu.swan.apps.ae.b.Ji();
        if (!TextUtils.isEmpty(Ji)) {
            boolean eq = com.baidu.swan.apps.database.favorite.a.eq(Ji);
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mSource = "menu";
            fVar.aB("appid", Ji);
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            if (IX != null) {
                fVar.aB("appversion", IX.getVersion());
            }
            if (eq) {
                fVar.mValue = "deletemyswan";
                if (com.baidu.swan.apps.database.favorite.a.eo(Ji)) {
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).dw(2).IN();
                } else {
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).dw(2).IK();
                }
            } else {
                fVar.mValue = "addmyswan";
                if (com.baidu.swan.apps.database.favorite.a.en(Ji)) {
                    com.baidu.swan.apps.database.favorite.a.AN();
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_fav_success).dw(2).IN();
                } else {
                    d.l(this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).dw(2).IK();
                }
            }
            this.aZq.a(fVar);
        }
    }

    private void MW() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean Ds = com.baidu.swan.apps.u.a.CT().Ds();
        com.baidu.swan.apps.u.a.CT().be(!Ds);
        if (this.aZq.Sy() != null && (this.aZq.Sy() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.aZq.Sy()).aK(com.baidu.swan.apps.u.a.CT().Ds());
        }
        if (Ds) {
            d.l(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).dx(a.e.aiapps_day_mode_toast_icon).dw(2).IN();
        } else {
            d.l(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).dx(a.e.aiapps_night_mode_toast_icon).dw(2).IN();
        }
    }

    private void MX() {
        com.baidu.swan.apps.v.b.b uB;
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            uB = com.baidu.swan.apps.ae.b.IX().uB();
        } else {
            uB = ((SwanAppActivity) this.aZq.Sy()).uB();
        }
        com.baidu.swan.apps.ah.a.d(this.aZq.getContext(), uB);
        hU("addshortcut");
    }

    protected void restart() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.aZq instanceof com.baidu.swan.apps.core.c.d) {
            com.baidu.swan.apps.core.c.d dVar = (com.baidu.swan.apps.core.c.d) this.aZq;
            c yG = dVar.yG();
            if (yG == null) {
                if (DEBUG) {
                    Log.e("SwanAppMenuHelper", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("homePath", e.Ec().DN());
            hashMap.put("pagePath", dVar.yE());
            hashMap.put("slaveId", yG.we());
            e.Ec().a(new com.baidu.swan.apps.m.a.b("onForceReLaunch", hashMap));
            hU(Headers.REFRESH);
        }
    }

    private void MY() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.c.e uz = e.Ec().uz();
        if (uz == null) {
            if (this.aZq != null) {
                d.l(this.aZq.getContext(), a.h.aiapps_open_fragment_failed_toast).IK();
                return;
            }
            return;
        }
        uz.dY("navigateTo").A(com.baidu.swan.apps.core.c.e.aqJ, com.baidu.swan.apps.core.c.e.aqL).a("about", null).commit();
        hU("about");
    }

    private void MZ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.c.e uz = this.aZq.uz();
        if (uz == null) {
            d.l(this.mContext, a.h.aiapps_open_fragment_failed_toast).IK();
            return;
        }
        uz.dY("navigateTo").A(com.baidu.swan.apps.core.c.e.aqJ, com.baidu.swan.apps.core.c.e.aqL).a("setting", null).commit();
        hU("permission");
    }

    private void Na() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "MENU_ITEM_FEEDBACK");
        }
        com.baidu.swan.apps.u.a.CH().a(new Bundle(), new g.a() { // from class: com.baidu.swan.apps.view.coverview.c.b.2
            @Override // com.baidu.swan.apps.b.b.g.a
            public void onResult(final String str) {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.view.coverview.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(new JSONObject(str).optString("result"), "success")) {
                                d.l(com.baidu.swan.apps.u.a.Cy(), a.h.aiapps_report_tips).dw(2).IK();
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

    private void hU(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            this.aZq.a(fVar);
        }
    }
}
