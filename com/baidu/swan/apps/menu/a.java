package com.baidu.swan.apps.menu;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.al;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.menu.fontsize.c;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.swan.menu.g;
import com.baidu.swan.menu.h;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cRI;
    private SwanAppMenuHeaderView cRJ;
    private c dnr;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0436a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static final boolean dnv = com.baidu.swan.apps.t.a.awZ().ahh();
    }

    public a(g gVar, c cVar) {
        this(gVar, cVar, null);
    }

    public a(g gVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cRI = gVar;
        this.cRJ = swanAppMenuHeaderView;
        this.dnr = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aCa();
    }

    private void aCa() {
        com.baidu.swan.apps.t.a.axH().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aCb() {
        e aIL;
        if (this.cRI != null && this.dnr != null && this.mContext != null && (aIL = e.aIL()) != null) {
            this.cRI.a(new com.baidu.swan.menu.e() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, h hVar) {
                    return a.this.b(hVar);
                }
            });
            if (this.cRJ != null) {
                this.cRJ.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cRI.dismiss();
                        a.this.aCm();
                    }
                });
                if (b.dnv) {
                    this.cRJ.setAttentionBtnShow(true);
                    this.cRJ.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cRI.dismiss();
                            a.this.aCi();
                        }
                    });
                }
                if (!aIL.aJd()) {
                    this.cRJ.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cRI.dismiss();
                            return a.this.aCd();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCc() {
        this.cRJ.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.np(d.aIG().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCd() {
        if (this.dnr == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aCg() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).jj(2).aIs();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(h hVar) {
        if (this.dnr == null || this.mContext == null) {
            return false;
        }
        switch (hVar.getItemId()) {
            case 4:
                aCh();
                return true;
            case 5:
                aCj();
                return true;
            case 35:
                aCk();
                return true;
            case 37:
                aCn();
                return true;
            case 38:
                aCi();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aCl();
                return true;
            case 49:
                aCf();
                return true;
            case 50:
                aCe();
                return true;
            default:
                return com.baidu.swan.apps.t.a.axa().a(hVar);
        }
    }

    private void aCe() {
        this.cRI.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.dnr.aoz(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void ih(int i) {
                com.baidu.swan.apps.adaptation.b.c apm;
                NgWebView ngWebView;
                if ((a.this.dnr instanceof com.baidu.swan.apps.core.d.e) && (apm = ((com.baidu.swan.apps.core.d.e) a.this.dnr).apm()) != null) {
                    if (apm.aiP() != null) {
                        ngWebView = (NgWebView) apm.aiP().aiW();
                    } else {
                        ngWebView = (NgWebView) apm.aiW();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aCp()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.ij(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.ii(i);
                    com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aCo()));
            }
        });
        pP("typeface");
    }

    private void aCf() {
        f afX = this.dnr.afX();
        if (afX == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIs();
            return;
        }
        afX.mC("navigateTo").af(f.cSz, f.cSB).a("settings", null).commit();
        pP("set");
    }

    private boolean aCg() {
        al.dR(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aOr()));
        return true;
    }

    private void aCh() {
        this.dnr.aoj();
        pP(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCi() {
        String appId = d.aIG().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.np(appId)) {
                ms(appId);
            } else {
                mt(appId);
            }
        }
    }

    private void ms(String str) {
        SwanFavorDataManager.auO().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aon() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).jj(2).aIv();
                a.this.aCc();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aoo() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).jj(2).aIs();
            }
        }, com.baidu.swan.apps.env.c.c.auk().hi(3).aul());
        pP("deletemyswan");
    }

    private void mt(String str) {
        if (com.baidu.swan.apps.ad.a.a.aFm()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).aIs();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cFE = null;
        final String page = ak.aOr().getPage();
        SwanFavorDataManager.auO().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aop() {
                com.baidu.swan.apps.database.favorite.a.atl();
                if (a.w(a.this.dnr.bdU())) {
                    a.bX("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).jj(2).jf(2).aIs();
                a.this.aCc();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aoq() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).jj(2).aIs();
            }
        });
        bX("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0436a interfaceC0436a) {
        String appId = d.aIG().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0436a != null) {
            interfaceC0436a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.np(appId)) {
            SwanFavorDataManager.auO().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aop() {
                    com.baidu.swan.apps.database.favorite.a.atl();
                    if (a.w(activity)) {
                        if (interfaceC0436a != null) {
                            interfaceC0436a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_success).jj(2).jf(2).aIs();
                    if (interfaceC0436a != null) {
                        interfaceC0436a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aoq() {
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_fail).jj(2).aIs();
                    if (interfaceC0436a != null) {
                        interfaceC0436a.onFail();
                    }
                }
            });
        } else if (interfaceC0436a != null) {
            interfaceC0436a.onSuccess();
        }
    }

    public static boolean w(Activity activity) {
        return com.baidu.swan.apps.t.a.aya().w(activity);
    }

    private void aCj() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean aii = com.baidu.swan.apps.t.a.axs().aii();
        com.baidu.swan.apps.t.a.axs().eJ(!aii);
        if (this.dnr.bdU() != null && (this.dnr.bdU() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.dnr.bdU()).l(com.baidu.swan.apps.t.a.axs().aii(), true);
        }
        if (aii) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).jk(a.e.aiapps_day_mode_toast_icon).jj(2).aIv();
        } else {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).jk(a.e.aiapps_night_mode_toast_icon).jj(2).aIv();
        }
        pP("daynightmode");
    }

    private void aCk() {
        b.a afZ;
        if (com.baidu.swan.apps.ad.a.a.aFm()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).aIs();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aIL() != null) {
            afZ = e.aIL().aIO();
        } else {
            afZ = ((SwanAppActivity) this.dnr.bdU()).afZ();
        }
        com.baidu.swan.apps.ah.a.a(this.dnr.getContext(), afZ);
        pP("addshortcut");
    }

    private void aCl() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        pP(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.aAl().azV());
        com.baidu.swan.apps.console.c.bl("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCm() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIs();
            return;
        }
        afX.mC("navigateTo").af(f.cSz, f.cSB).a("about", null).commit();
        pP("about");
    }

    private void aCn() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        f afX = this.dnr.afX();
        if (afX == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIs();
            return;
        }
        afX.mC("navigateTo").af(f.cSz, f.cSB).a("authority", null).commit();
        pP("permission");
    }

    public static void pP(String str) {
        bX(str, null);
    }

    public static void bX(String str, String str2) {
        V(str, str2, null);
    }

    public static void V(String str, String str2, String str3) {
        f(str, str2, str3, null, null);
    }

    public static void f(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.r("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                fVar.r(str4, str5);
            }
            SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
            if (azV != null) {
                azV.a(fVar);
            }
        }
    }
}
