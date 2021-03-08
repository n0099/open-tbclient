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
    private g cTi;
    private SwanAppMenuHeaderView cTj;
    private c doV;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0442a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static final boolean doY = com.baidu.swan.apps.t.a.axc().ahk();
    }

    public a(g gVar, c cVar) {
        this(gVar, cVar, null);
    }

    public a(g gVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cTi = gVar;
        this.cTj = swanAppMenuHeaderView;
        this.doV = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aCd();
    }

    private void aCd() {
        com.baidu.swan.apps.t.a.axK().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aCe() {
        e aIO;
        if (this.cTi != null && this.doV != null && this.mContext != null && (aIO = e.aIO()) != null) {
            this.cTi.a(new com.baidu.swan.menu.e() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, h hVar) {
                    return a.this.b(hVar);
                }
            });
            if (this.cTj != null) {
                this.cTj.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cTi.dismiss();
                        a.this.aCp();
                    }
                });
                if (b.doY) {
                    this.cTj.setAttentionBtnShow(true);
                    this.cTj.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cTi.dismiss();
                            a.this.aCl();
                        }
                    });
                }
                if (!aIO.aJg()) {
                    this.cTj.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cTi.dismiss();
                            return a.this.aCg();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCf() {
        this.cTj.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nw(d.aIJ().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCg() {
        if (this.doV == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aCj() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).jk(2).aIv();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(h hVar) {
        if (this.doV == null || this.mContext == null) {
            return false;
        }
        switch (hVar.getItemId()) {
            case 4:
                aCk();
                return true;
            case 5:
                aCm();
                return true;
            case 35:
                aCn();
                return true;
            case 37:
                aCq();
                return true;
            case 38:
                aCl();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aCo();
                return true;
            case 49:
                aCi();
                return true;
            case 50:
                aCh();
                return true;
            default:
                return com.baidu.swan.apps.t.a.axd().a(hVar);
        }
    }

    private void aCh() {
        this.cTi.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.doV.aoC(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void ii(int i) {
                com.baidu.swan.apps.adaptation.b.c app;
                NgWebView ngWebView;
                if ((a.this.doV instanceof com.baidu.swan.apps.core.d.e) && (app = ((com.baidu.swan.apps.core.d.e) a.this.doV).app()) != null) {
                    if (app.aiS() != null) {
                        ngWebView = (NgWebView) app.aiS().aiZ();
                    } else {
                        ngWebView = (NgWebView) app.aiZ();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aCs()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.ik(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.ij(i);
                    com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aCr()));
            }
        });
        pW("typeface");
    }

    private void aCi() {
        f aga = this.doV.aga();
        if (aga == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIv();
            return;
        }
        aga.mJ("navigateTo").af(f.cTZ, f.cUb).a("settings", null).commit();
        pW("set");
    }

    private boolean aCj() {
        al.dQ(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aOu()));
        return true;
    }

    private void aCk() {
        this.doV.aom();
        pW(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCl() {
        String appId = d.aIJ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nw(appId)) {
                mz(appId);
            } else {
                mA(appId);
            }
        }
    }

    private void mz(String str) {
        SwanFavorDataManager.auR().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aoq() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).jk(2).aIy();
                a.this.aCf();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aor() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).jk(2).aIv();
            }
        }, com.baidu.swan.apps.env.c.c.aun().hj(3).auo());
        pW("deletemyswan");
    }

    private void mA(String str) {
        if (com.baidu.swan.apps.ad.a.a.aFp()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).aIv();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cHe = null;
        final String page = ak.aOu().getPage();
        SwanFavorDataManager.auR().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aos() {
                com.baidu.swan.apps.database.favorite.a.ato();
                if (a.w(a.this.doV.bdW())) {
                    a.bX("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).jk(2).jg(2).aIv();
                a.this.aCf();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aot() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).jk(2).aIv();
            }
        });
        bX("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0442a interfaceC0442a) {
        String appId = d.aIJ().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0442a != null) {
            interfaceC0442a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.nw(appId)) {
            SwanFavorDataManager.auR().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aos() {
                    com.baidu.swan.apps.database.favorite.a.ato();
                    if (a.w(activity)) {
                        if (interfaceC0442a != null) {
                            interfaceC0442a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_success).jk(2).jg(2).aIv();
                    if (interfaceC0442a != null) {
                        interfaceC0442a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aot() {
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_fail).jk(2).aIv();
                    if (interfaceC0442a != null) {
                        interfaceC0442a.onFail();
                    }
                }
            });
        } else if (interfaceC0442a != null) {
            interfaceC0442a.onSuccess();
        }
    }

    public static boolean w(Activity activity) {
        return com.baidu.swan.apps.t.a.ayd().w(activity);
    }

    private void aCm() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean ail = com.baidu.swan.apps.t.a.axv().ail();
        com.baidu.swan.apps.t.a.axv().eJ(!ail);
        if (this.doV.bdW() != null && (this.doV.bdW() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.doV.bdW()).l(com.baidu.swan.apps.t.a.axv().ail(), true);
        }
        if (ail) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).jl(a.e.aiapps_day_mode_toast_icon).jk(2).aIy();
        } else {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).jl(a.e.aiapps_night_mode_toast_icon).jk(2).aIy();
        }
        pW("daynightmode");
    }

    private void aCn() {
        b.a agc;
        if (com.baidu.swan.apps.ad.a.a.aFp()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).aIv();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aIO() != null) {
            agc = e.aIO().aIR();
        } else {
            agc = ((SwanAppActivity) this.doV.bdW()).agc();
        }
        com.baidu.swan.apps.ah.a.a(this.doV.getContext(), agc);
        pW("addshortcut");
    }

    private void aCo() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        pW(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.aAo().azY());
        com.baidu.swan.apps.console.c.bl("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCp() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIv();
            return;
        }
        aga.mJ("navigateTo").af(f.cTZ, f.cUb).a("about", null).commit();
        pW("about");
    }

    private void aCq() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        f aga = this.doV.aga();
        if (aga == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIv();
            return;
        }
        aga.mJ("navigateTo").af(f.cTZ, f.cUb).a("authority", null).commit();
        pW("permission");
    }

    public static void pW(String str) {
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
                fVar.s("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                fVar.s(str4, str5);
            }
            SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
            if (azY != null) {
                azY.a(fVar);
            }
        }
    }
}
