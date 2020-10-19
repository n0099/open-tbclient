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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cRo;
    private h cvN;
    private SwanAppMenuHeaderView cvO;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0428a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static final boolean cRr = com.baidu.swan.apps.t.a.asi().acA();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cvN = hVar;
        this.cvO = swanAppMenuHeaderView;
        this.cRo = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        axi();
    }

    private void axi() {
        com.baidu.swan.apps.t.a.asR().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void axj() {
        e aDb;
        if (this.cvN != null && this.cRo != null && this.mContext != null && (aDb = e.aDb()) != null) {
            this.cvN.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cvO != null) {
                this.cvO.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cvN.dismiss();
                        a.this.axu();
                    }
                });
                if (b.cRr) {
                    this.cvO.setAttentionBtnShow(true);
                    this.cvO.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cvN.dismiss();
                            a.this.axq();
                        }
                    });
                }
                if (!aDb.aDt()) {
                    this.cvO.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cvN.dismiss();
                            return a.this.axl();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axk() {
        this.cvO.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nh(d.aCW().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axl() {
        if (this.cRo == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, axo() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).jR(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cRo == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                axp();
                return true;
            case 5:
                axr();
                return true;
            case 35:
                axs();
                return true;
            case 37:
                axv();
                return true;
            case 38:
                axq();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                axt();
                return true;
            case 49:
                axn();
                return true;
            case 50:
                axm();
                return true;
            default:
                return com.baidu.swan.apps.t.a.asj().a(iVar);
        }
    }

    private void axm() {
        this.cvN.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.cRo.ajP(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void ja(int i) {
                com.baidu.swan.apps.adaptation.b.c akw;
                NgWebView ngWebView;
                if ((a.this.cRo instanceof com.baidu.swan.apps.core.d.e) && (akw = ((com.baidu.swan.apps.core.d.e) a.this.cRo).akw()) != null) {
                    if (akw.aeg() != null) {
                        ngWebView = (NgWebView) akw.aeg().aen();
                    } else {
                        ngWebView = (NgWebView) akw.aen();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.axx()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jc(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.jb(i);
                    com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.axw()));
            }
        });
        pG("typeface");
    }

    private void axn() {
        com.baidu.swan.apps.core.d.f abs = this.cRo.abs();
        if (abs == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        abs.mt("navigateTo").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("settings", null).commit();
        pG("set");
    }

    private boolean axo() {
        al.cU(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aII()));
        return true;
    }

    private void axp() {
        this.cRo.ajz();
        pG(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axq() {
        String appId = d.aCW().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nh(appId)) {
                mj(appId);
            } else {
                mk(appId);
            }
        }
    }

    private void mj(String str) {
        SwanFavorDataManager.apW().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void ajD() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).jR(2).showHighlightToast();
                a.this.axk();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void ajE() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).jR(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.aps().ib(3).apt());
        pG("deletemyswan");
    }

    private void mk(String str) {
        if (com.baidu.swan.apps.ad.a.a.aAx()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cjy = null;
        final String page = ak.aII().getPage();
        SwanFavorDataManager.apW().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void ajF() {
                com.baidu.swan.apps.database.favorite.a.aos();
                if (a.E(a.this.cRo.aYo())) {
                    a.bS("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).jR(2).jN(2).showToast();
                a.this.axk();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void ajG() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).jR(2).showToast();
            }
        });
        bS("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0428a interfaceC0428a) {
        String appId = d.aCW().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0428a != null) {
            interfaceC0428a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.nh(appId)) {
            SwanFavorDataManager.apW().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void ajF() {
                    com.baidu.swan.apps.database.favorite.a.aos();
                    if (a.E(activity)) {
                        if (interfaceC0428a != null) {
                            interfaceC0428a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).jR(2).jN(2).showToast();
                    if (interfaceC0428a != null) {
                        interfaceC0428a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void ajG() {
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).jR(2).showToast();
                    if (interfaceC0428a != null) {
                        interfaceC0428a.onFail();
                    }
                }
            });
        } else if (interfaceC0428a != null) {
            interfaceC0428a.onSuccess();
        }
    }

    public static boolean E(Activity activity) {
        return com.baidu.swan.apps.t.a.atk().E(activity);
    }

    private void axr() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.asC().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cRo.aYo() != null && (this.cRo.aYo() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cRo.aYo()).k(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).jS(a.e.aiapps_day_mode_toast_icon).jR(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).jS(a.e.aiapps_night_mode_toast_icon).jR(2).showHighlightToast();
        }
        pG("daynightmode");
    }

    private void axs() {
        b.a abu;
        if (com.baidu.swan.apps.ad.a.a.aAx()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aDb() != null) {
            abu = e.aDb().aDe();
        } else {
            abu = ((SwanAppActivity) this.cRo.aYo()).abu();
        }
        com.baidu.swan.apps.ai.a.a(this.cRo.getContext(), abu);
        pG("addshortcut");
    }

    private void axt() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        pG(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.avu().ave());
        com.baidu.swan.apps.console.c.bg("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axu() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        abs.mt("navigateTo").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("about", null).commit();
        pG("about");
    }

    private void axv() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f abs = this.cRo.abs();
        if (abs == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        abs.mt("navigateTo").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("authority", null).commit();
        pG("permission");
    }

    public static void pG(String str) {
        bS(str, null);
    }

    public static void bS(String str, String str2) {
        I(str, str2, null);
    }

    public static void I(String str, String str2, String str3) {
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
            SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
            if (ave != null) {
                ave.a(fVar);
            }
        }
    }
}
