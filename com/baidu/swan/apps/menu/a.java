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
    private h cKc;
    private SwanAppMenuHeaderView cKd;
    private c dfH;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0454a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static final boolean dfK = com.baidu.swan.apps.t.a.awD().agU();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cKc = hVar;
        this.cKd = swanAppMenuHeaderView;
        this.dfH = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aBC();
    }

    private void aBC() {
        com.baidu.swan.apps.t.a.axl().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aBD() {
        e aHv;
        if (this.cKc != null && this.dfH != null && this.mContext != null && (aHv = e.aHv()) != null) {
            this.cKc.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cKd != null) {
                this.cKd.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cKc.dismiss();
                        a.this.aBO();
                    }
                });
                if (b.dfK) {
                    this.cKd.setAttentionBtnShow(true);
                    this.cKd.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cKc.dismiss();
                            a.this.aBK();
                        }
                    });
                }
                if (!aHv.aHN()) {
                    this.cKd.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cKc.dismiss();
                            return a.this.aBF();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBE() {
        this.cKd.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nO(d.aHq().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBF() {
        if (this.dfH == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aBI() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).km(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.dfH == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                aBJ();
                return true;
            case 5:
                aBL();
                return true;
            case 35:
                aBM();
                return true;
            case 37:
                aBP();
                return true;
            case 38:
                aBK();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aBN();
                return true;
            case 49:
                aBH();
                return true;
            case 50:
                aBG();
                return true;
            default:
                return com.baidu.swan.apps.t.a.awE().a(iVar);
        }
    }

    private void aBG() {
        this.cKc.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.dfH.aoj(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void jv(int i) {
                com.baidu.swan.apps.adaptation.b.c aoQ;
                NgWebView ngWebView;
                if ((a.this.dfH instanceof com.baidu.swan.apps.core.d.e) && (aoQ = ((com.baidu.swan.apps.core.d.e) a.this.dfH).aoQ()) != null) {
                    if (aoQ.aiA() != null) {
                        ngWebView = (NgWebView) aoQ.aiA().aiH();
                    } else {
                        ngWebView = (NgWebView) aoQ.aiH();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aBR()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jx(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.jw(i);
                    com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBQ()));
            }
        });
        qn("typeface");
    }

    private void aBH() {
        com.baidu.swan.apps.core.d.f afM = this.dfH.afM();
        if (afM == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afM.nb("navigateTo").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("settings", null).commit();
        qn("set");
    }

    private boolean aBI() {
        al.cU(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aNc()));
        return true;
    }

    private void aBJ() {
        this.dfH.anT();
        qn(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBK() {
        String appId = d.aHq().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nO(appId)) {
                mR(appId);
            } else {
                mS(appId);
            }
        }
    }

    private void mR(String str) {
        SwanFavorDataManager.aur().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anX() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).km(2).showHighlightToast();
                a.this.aBE();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anY() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).km(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.atN().iw(3).atO());
        qn("deletemyswan");
    }

    private void mS(String str) {
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cxW = null;
        final String page = ak.aNc().getPage();
        SwanFavorDataManager.aur().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anZ() {
                com.baidu.swan.apps.database.favorite.a.asO();
                if (a.E(a.this.dfH.bcH())) {
                    a.bZ("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).km(2).ki(2).showToast();
                a.this.aBE();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aoa() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).km(2).showToast();
            }
        });
        bZ("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0454a interfaceC0454a) {
        String appId = d.aHq().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0454a != null) {
            interfaceC0454a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.nO(appId)) {
            SwanFavorDataManager.aur().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void anZ() {
                    com.baidu.swan.apps.database.favorite.a.asO();
                    if (a.E(activity)) {
                        if (interfaceC0454a != null) {
                            interfaceC0454a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).km(2).ki(2).showToast();
                    if (interfaceC0454a != null) {
                        interfaceC0454a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aoa() {
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).km(2).showToast();
                    if (interfaceC0454a != null) {
                        interfaceC0454a.onFail();
                    }
                }
            });
        } else if (interfaceC0454a != null) {
            interfaceC0454a.onSuccess();
        }
    }

    public static boolean E(Activity activity) {
        return com.baidu.swan.apps.t.a.axE().E(activity);
    }

    private void aBL() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.awW().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.dfH.bcH() != null && (this.dfH.bcH() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.dfH.bcH()).k(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).kn(a.e.aiapps_day_mode_toast_icon).km(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).kn(a.e.aiapps_night_mode_toast_icon).km(2).showHighlightToast();
        }
        qn("daynightmode");
    }

    private void aBM() {
        b.a afO;
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aHv() != null) {
            afO = e.aHv().aHy();
        } else {
            afO = ((SwanAppActivity) this.dfH.bcH()).afO();
        }
        com.baidu.swan.apps.ai.a.a(this.dfH.getContext(), afO);
        qn("addshortcut");
    }

    private void aBN() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        qn(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.azO().azy());
        com.baidu.swan.apps.console.c.bn("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afM.nb("navigateTo").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("about", null).commit();
        qn("about");
    }

    private void aBP() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f afM = this.dfH.afM();
        if (afM == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afM.nb("navigateTo").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("authority", null).commit();
        qn("permission");
    }

    public static void qn(String str) {
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
            SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
            if (azy != null) {
                azy.a(fVar);
            }
        }
    }
}
