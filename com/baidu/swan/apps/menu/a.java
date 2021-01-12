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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cPu;
    private SwanAppMenuHeaderView cPv;
    private c dlh;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0439a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static final boolean dlk = com.baidu.swan.apps.t.a.awB().agJ();
    }

    public a(g gVar, c cVar) {
        this(gVar, cVar, null);
    }

    public a(g gVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cPu = gVar;
        this.cPv = swanAppMenuHeaderView;
        this.dlh = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aBD();
    }

    private void aBD() {
        com.baidu.swan.apps.t.a.axj().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aBE() {
        e aIs;
        if (this.cPu != null && this.dlh != null && this.mContext != null && (aIs = e.aIs()) != null) {
            this.cPu.a(new com.baidu.swan.menu.e() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, h hVar) {
                    return a.this.b(hVar);
                }
            });
            if (this.cPv != null) {
                this.cPv.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cPu.dismiss();
                        a.this.aBP();
                    }
                });
                if (b.dlk) {
                    this.cPv.setAttentionBtnShow(true);
                    this.cPv.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cPu.dismiss();
                            a.this.aBL();
                        }
                    });
                }
                if (!aIs.aIK()) {
                    this.cPv.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cPu.dismiss();
                            return a.this.aBG();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBF() {
        this.cPv.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mX(d.aIn().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBG() {
        if (this.dlh == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aBJ() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).jg(2).aHZ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(h hVar) {
        if (this.dlh == null || this.mContext == null) {
            return false;
        }
        switch (hVar.getItemId()) {
            case 4:
                aBK();
                return true;
            case 5:
                aBM();
                return true;
            case 35:
                aBN();
                return true;
            case 37:
                aBQ();
                return true;
            case 38:
                aBL();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aBO();
                return true;
            case 49:
                aBI();
                return true;
            case 50:
                aBH();
                return true;
            default:
                return com.baidu.swan.apps.t.a.awC().a(hVar);
        }
    }

    private void aBH() {
        this.cPu.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.dlh.aob(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void ie(int i) {
                com.baidu.swan.apps.adaptation.b.c aoN;
                NgWebView ngWebView;
                if ((a.this.dlh instanceof com.baidu.swan.apps.core.d.e) && (aoN = ((com.baidu.swan.apps.core.d.e) a.this.dlh).aoN()) != null) {
                    if (aoN.air() != null) {
                        ngWebView = (NgWebView) aoN.air().aiy();
                    } else {
                        ngWebView = (NgWebView) aoN.aiy();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aBS()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.ig(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.m26if(i);
                    com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBR()));
            }
        });
        px("typeface");
    }

    private void aBI() {
        f afz = this.dlh.afz();
        if (afz == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aHZ();
            return;
        }
        afz.mk("navigateTo").ai(f.cQm, f.cQo).a("settings", null).commit();
        px("set");
    }

    private boolean aBJ() {
        al.dS(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aNY()));
        return true;
    }

    private void aBK() {
        this.dlh.anL();
        px(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBL() {
        String appId = d.aIn().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.mX(appId)) {
                ma(appId);
            } else {
                mb(appId);
            }
        }
    }

    private void ma(String str) {
        SwanFavorDataManager.auq().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anP() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).jg(2).aIc();
                a.this.aBF();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anQ() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).jg(2).aHZ();
            }
        }, com.baidu.swan.apps.env.c.c.atM().hf(3).atN());
        px("deletemyswan");
    }

    private void mb(String str) {
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).aHZ();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cDi = null;
        final String page = ak.aNY().getPage();
        SwanFavorDataManager.auq().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anR() {
                com.baidu.swan.apps.database.favorite.a.asN();
                if (a.C(a.this.dlh.bdH())) {
                    a.cd("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).jg(2).jc(2).aHZ();
                a.this.aBF();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void anS() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).jg(2).aHZ();
            }
        });
        cd("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0439a interfaceC0439a) {
        String appId = d.aIn().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0439a != null) {
            interfaceC0439a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.mX(appId)) {
            SwanFavorDataManager.auq().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void anR() {
                    com.baidu.swan.apps.database.favorite.a.asN();
                    if (a.C(activity)) {
                        if (interfaceC0439a != null) {
                            interfaceC0439a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_success).jg(2).jc(2).aHZ();
                    if (interfaceC0439a != null) {
                        interfaceC0439a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void anS() {
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_fail).jg(2).aHZ();
                    if (interfaceC0439a != null) {
                        interfaceC0439a.onFail();
                    }
                }
            });
        } else if (interfaceC0439a != null) {
            interfaceC0439a.onSuccess();
        }
    }

    public static boolean C(Activity activity) {
        return com.baidu.swan.apps.t.a.axC().C(activity);
    }

    private void aBM() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean ahK = com.baidu.swan.apps.t.a.awU().ahK();
        com.baidu.swan.apps.t.a.awU().eH(!ahK);
        if (this.dlh.bdH() != null && (this.dlh.bdH() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.dlh.bdH()).k(com.baidu.swan.apps.t.a.awU().ahK(), true);
        }
        if (ahK) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).jh(a.e.aiapps_day_mode_toast_icon).jg(2).aIc();
        } else {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).jh(a.e.aiapps_night_mode_toast_icon).jg(2).aIc();
        }
        px("daynightmode");
    }

    private void aBN() {
        b.a afB;
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).aHZ();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aIs() != null) {
            afB = e.aIs().aIv();
        } else {
            afB = ((SwanAppActivity) this.dlh.bdH()).afB();
        }
        com.baidu.swan.apps.ah.a.a(this.dlh.getContext(), afB);
        px("addshortcut");
    }

    private void aBO() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        px(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.azN().azx());
        com.baidu.swan.apps.console.c.br("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBP() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aHZ();
            return;
        }
        afz.mk("navigateTo").ai(f.cQm, f.cQo).a("about", null).commit();
        px("about");
    }

    private void aBQ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        f afz = this.dlh.afz();
        if (afz == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aHZ();
            return;
        }
        afz.mk("navigateTo").ai(f.cQm, f.cQo).a("authority", null).commit();
        px("permission");
    }

    public static void px(String str) {
        cd(str, null);
    }

    public static void cd(String str, String str2) {
        U(str, str2, null);
    }

    public static void U(String str, String str2, String str3) {
        f(str, str2, str3, null, null);
    }

    public static void f(String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mValue = str;
            if (!TextUtils.isEmpty(str2)) {
                fVar.t("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                fVar.t(str4, str5);
            }
            SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
            if (azx != null) {
                azx.a(fVar);
            }
        }
    }
}
