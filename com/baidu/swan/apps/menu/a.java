package com.baidu.swan.apps.menu;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.al;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.menu.fontsize.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.f;
import com.baidu.swan.menu.h;
import com.baidu.swan.menu.i;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cFk;
    private h cjv;
    private SwanAppMenuHeaderView cjw;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0411a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static final boolean cFn = com.baidu.swan.apps.t.a.apx().ZO();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cjv = hVar;
        this.cjw = swanAppMenuHeaderView;
        this.cFk = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aux();
    }

    private void aux() {
        com.baidu.swan.apps.t.a.aqf().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void auy() {
        e aAs;
        if (this.cjv != null && this.cFk != null && this.mContext != null && (aAs = e.aAs()) != null) {
            this.cjv.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cjw != null) {
                this.cjw.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cjv.dismiss();
                        a.this.auJ();
                    }
                });
                if (b.cFn) {
                    this.cjw.setAttentionBtnShow(true);
                    this.cjw.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cjv.dismiss();
                            a.this.auF();
                        }
                    });
                }
                if (!aAs.aAK()) {
                    this.cjw.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cjv.dismiss();
                            return a.this.auA();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auz() {
        this.cjw.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mv(d.aAn().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auA() {
        if (this.cFk == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, auD() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).ju(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cFk == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                auE();
                return true;
            case 5:
                auG();
                return true;
            case 35:
                auH();
                return true;
            case 37:
                auK();
                return true;
            case 38:
                auF();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                auI();
                return true;
            case 49:
                auC();
                return true;
            case 50:
                auB();
                return true;
            default:
                return com.baidu.swan.apps.t.a.apy().a(iVar);
        }
    }

    private void auB() {
        this.cjv.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.cFk.ahe(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void iD(int i) {
                com.baidu.swan.apps.adaptation.b.c ahL;
                NgWebView ngWebView;
                if ((a.this.cFk instanceof com.baidu.swan.apps.core.d.e) && (ahL = ((com.baidu.swan.apps.core.d.e) a.this.cFk).ahL()) != null) {
                    if (ahL.abu() != null) {
                        ngWebView = (NgWebView) ahL.abu().abB();
                    } else {
                        ngWebView = (NgWebView) ahL.abB();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.auM()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.iF(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.iE(i);
                    com.baidu.swan.apps.menu.fontsize.a.c(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.auL()));
            }
        });
        oU("typeface");
    }

    private void auC() {
        com.baidu.swan.apps.core.d.f YG = this.cFk.YG();
        if (YG == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        YG.lH("navigateTo").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("settings", null).commit();
        oU("set");
    }

    private boolean auD() {
        al.cO(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aFZ()));
        return true;
    }

    private void auE() {
        this.cFk.agO();
        oU(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auF() {
        String appId = d.aAn().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.mv(appId)) {
                lx(appId);
            } else {
                ly(appId);
            }
        }
    }

    private void lx(String str) {
        SwanFavorDataManager.ank().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void agS() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).ju(2).showHighlightToast();
                a.this.auz();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void agT() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).ju(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.amG().hE(3).amH());
        oU("deletemyswan");
    }

    private void ly(String str) {
        if (com.baidu.swan.apps.ad.a.a.axM()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bXj = null;
        final String page = ak.aFZ().getPage();
        SwanFavorDataManager.ank().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void agU() {
                com.baidu.swan.apps.database.favorite.a.alH();
                if (a.D(a.this.cFk.aVF())) {
                    a.bN("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).ju(2).jq(2).showToast();
                a.this.auz();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void agV() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).ju(2).showToast();
            }
        });
        bN("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0411a interfaceC0411a) {
        String appId = d.aAn().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0411a != null) {
            interfaceC0411a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.mv(appId)) {
            SwanFavorDataManager.ank().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void agU() {
                    com.baidu.swan.apps.database.favorite.a.alH();
                    if (a.D(activity)) {
                        if (interfaceC0411a != null) {
                            interfaceC0411a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).ju(2).jq(2).showToast();
                    if (interfaceC0411a != null) {
                        interfaceC0411a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void agV() {
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).ju(2).showToast();
                    if (interfaceC0411a != null) {
                        interfaceC0411a.onFail();
                    }
                }
            });
        } else if (interfaceC0411a != null) {
            interfaceC0411a.onSuccess();
        }
    }

    public static boolean D(Activity activity) {
        return com.baidu.swan.apps.t.a.aqy().D(activity);
    }

    private void auG() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.apQ().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cFk.aVF() != null && (this.cFk.aVF() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cFk.aVF()).k(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).jv(a.e.aiapps_day_mode_toast_icon).ju(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).jv(a.e.aiapps_night_mode_toast_icon).ju(2).showHighlightToast();
        }
        oU("daynightmode");
    }

    private void auH() {
        b.a YI;
        if (com.baidu.swan.apps.ad.a.a.axM()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aAs() != null) {
            YI = e.aAs().aAv();
        } else {
            YI = ((SwanAppActivity) this.cFk.aVF()).YI();
        }
        com.baidu.swan.apps.ai.a.a(this.cFk.getContext(), YI);
        oU("addshortcut");
    }

    private void auI() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        oU(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.asJ().ast());
        com.baidu.swan.apps.console.c.bb("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auJ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        YG.lH("navigateTo").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("about", null).commit();
        oU("about");
    }

    private void auK() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f YG = this.cFk.YG();
        if (YG == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        YG.lH("navigateTo").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("authority", null).commit();
        oU("permission");
    }

    public static void oU(String str) {
        bN(str, null);
    }

    public static void bN(String str, String str2) {
        H(str, str2, null);
    }

    public static void H(String str, String str2, String str3) {
        f(str, str2, str3, null, null);
    }

    public static void f(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.u("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                fVar.u(str4, str5);
            }
            SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
            if (ast != null) {
                ast.a(fVar);
            }
        }
    }
}
