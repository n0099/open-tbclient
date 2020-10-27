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
    private h cEj;
    private SwanAppMenuHeaderView cEk;
    private c cZK;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0442a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static final boolean cZN = com.baidu.swan.apps.t.a.aud().aeu();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cEj = hVar;
        this.cEk = swanAppMenuHeaderView;
        this.cZK = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        azc();
    }

    private void azc() {
        com.baidu.swan.apps.t.a.auL().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void azd() {
        e aEV;
        if (this.cEj != null && this.cZK != null && this.mContext != null && (aEV = e.aEV()) != null) {
            this.cEj.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cEk != null) {
                this.cEk.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cEj.dismiss();
                        a.this.azo();
                    }
                });
                if (b.cZN) {
                    this.cEk.setAttentionBtnShow(true);
                    this.cEk.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cEj.dismiss();
                            a.this.azk();
                        }
                    });
                }
                if (!aEV.aFn()) {
                    this.cEk.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cEj.dismiss();
                            return a.this.azf();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aze() {
        this.cEk.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nA(d.aEQ().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azf() {
        if (this.cZK == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, azi() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).kc(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cZK == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                azj();
                return true;
            case 5:
                azl();
                return true;
            case 35:
                azm();
                return true;
            case 37:
                azp();
                return true;
            case 38:
                azk();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                azn();
                return true;
            case 49:
                azh();
                return true;
            case 50:
                azg();
                return true;
            default:
                return com.baidu.swan.apps.t.a.aue().a(iVar);
        }
    }

    private void azg() {
        this.cEj.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.cZK.alJ(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void jl(int i) {
                com.baidu.swan.apps.adaptation.b.c amq;
                NgWebView ngWebView;
                if ((a.this.cZK instanceof com.baidu.swan.apps.core.d.e) && (amq = ((com.baidu.swan.apps.core.d.e) a.this.cZK).amq()) != null) {
                    if (amq.aga() != null) {
                        ngWebView = (NgWebView) amq.aga().agh();
                    } else {
                        ngWebView = (NgWebView) amq.agh();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.azr()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jn(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.jm(i);
                    com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.azq()));
            }
        });
        pZ("typeface");
    }

    private void azh() {
        com.baidu.swan.apps.core.d.f adm = this.cZK.adm();
        if (adm == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        adm.mM("navigateTo").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("settings", null).commit();
        pZ("set");
    }

    private boolean azi() {
        al.cU(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aKC()));
        return true;
    }

    private void azj() {
        this.cZK.alt();
        pZ(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        String appId = d.aEQ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nA(appId)) {
                mC(appId);
            } else {
                mD(appId);
            }
        }
    }

    private void mC(String str) {
        SwanFavorDataManager.arQ().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void alx() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).kc(2).showHighlightToast();
                a.this.aze();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aly() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).kc(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.arm().im(3).arn());
        pZ("deletemyswan");
    }

    private void mD(String str) {
        if (com.baidu.swan.apps.ad.a.a.aCr()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.crZ = null;
        final String page = ak.aKC().getPage();
        SwanFavorDataManager.arQ().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void alz() {
                com.baidu.swan.apps.database.favorite.a.aqn();
                if (a.E(a.this.cZK.bah())) {
                    a.bZ("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).kc(2).jY(2).showToast();
                a.this.aze();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void alA() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).kc(2).showToast();
            }
        });
        bZ("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0442a interfaceC0442a) {
        String appId = d.aEQ().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0442a != null) {
            interfaceC0442a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.nA(appId)) {
            SwanFavorDataManager.arQ().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void alz() {
                    com.baidu.swan.apps.database.favorite.a.aqn();
                    if (a.E(activity)) {
                        if (interfaceC0442a != null) {
                            interfaceC0442a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).kc(2).jY(2).showToast();
                    if (interfaceC0442a != null) {
                        interfaceC0442a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void alA() {
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).kc(2).showToast();
                    if (interfaceC0442a != null) {
                        interfaceC0442a.onFail();
                    }
                }
            });
        } else if (interfaceC0442a != null) {
            interfaceC0442a.onSuccess();
        }
    }

    public static boolean E(Activity activity) {
        return com.baidu.swan.apps.t.a.ave().E(activity);
    }

    private void azl() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.auw().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cZK.bah() != null && (this.cZK.bah() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cZK.bah()).k(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).kd(a.e.aiapps_day_mode_toast_icon).kc(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).kd(a.e.aiapps_night_mode_toast_icon).kc(2).showHighlightToast();
        }
        pZ("daynightmode");
    }

    private void azm() {
        b.a ado;
        if (com.baidu.swan.apps.ad.a.a.aCr()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aEV() != null) {
            ado = e.aEV().aEY();
        } else {
            ado = ((SwanAppActivity) this.cZK.bah()).ado();
        }
        com.baidu.swan.apps.ai.a.a(this.cZK.getContext(), ado);
        pZ("addshortcut");
    }

    private void azn() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        pZ(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.axo().awY());
        com.baidu.swan.apps.console.c.bn("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azo() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        adm.mM("navigateTo").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("about", null).commit();
        pZ("about");
    }

    private void azp() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f adm = this.cZK.adm();
        if (adm == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        adm.mM("navigateTo").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("authority", null).commit();
        pZ("permission");
    }

    public static void pZ(String str) {
        bZ(str, null);
    }

    public static void bZ(String str, String str2) {
        P(str, str2, null);
    }

    public static void P(String str, String str2, String str3) {
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
            SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
            if (awY != null) {
                awY.a(fVar);
            }
        }
    }
}
