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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private h cPl;
    private SwanAppMenuHeaderView cPm;
    private c dkY;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0464a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes25.dex */
    public static final class b {
        public static final boolean dlb = com.baidu.swan.apps.t.a.azd().aju();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cPl = hVar;
        this.cPm = swanAppMenuHeaderView;
        this.dkY = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aEd();
    }

    private void aEd() {
        com.baidu.swan.apps.t.a.azL().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aEe() {
        e aJV;
        if (this.cPl != null && this.dkY != null && this.mContext != null && (aJV = e.aJV()) != null) {
            this.cPl.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cPm != null) {
                this.cPm.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cPl.dismiss();
                        a.this.aEp();
                    }
                });
                if (b.dlb) {
                    this.cPm.setAttentionBtnShow(true);
                    this.cPm.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cPl.dismiss();
                            a.this.aEl();
                        }
                    });
                }
                if (!aJV.aKn()) {
                    this.cPm.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cPl.dismiss();
                            return a.this.aEg();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEf() {
        this.cPm.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.or(d.aJQ().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEg() {
        if (this.dkY == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aEj() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).kG(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.dkY == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                aEk();
                return true;
            case 5:
                aEm();
                return true;
            case 35:
                aEn();
                return true;
            case 37:
                aEq();
                return true;
            case 38:
                aEl();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aEo();
                return true;
            case 49:
                aEi();
                return true;
            case 50:
                aEh();
                return true;
            default:
                return com.baidu.swan.apps.t.a.aze().a(iVar);
        }
    }

    private void aEh() {
        this.cPl.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.dkY.aqJ(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void jP(int i) {
                com.baidu.swan.apps.adaptation.b.c arq;
                NgWebView ngWebView;
                if ((a.this.dkY instanceof com.baidu.swan.apps.core.d.e) && (arq = ((com.baidu.swan.apps.core.d.e) a.this.dkY).arq()) != null) {
                    if (arq.ala() != null) {
                        ngWebView = (NgWebView) arq.ala().alh();
                    } else {
                        ngWebView = (NgWebView) arq.alh();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aEs()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jR(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.jQ(i);
                    com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aEr()));
            }
        });
        qO("typeface");
    }

    private void aEi() {
        com.baidu.swan.apps.core.d.f aim = this.dkY.aim();
        if (aim == null) {
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        aim.nC("navigateTo").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("settings", null).commit();
        qO("set");
    }

    private boolean aEj() {
        al.dA(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aPA()));
        return true;
    }

    private void aEk() {
        this.dkY.aqt();
        qO(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEl() {
        String appId = d.aJQ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.or(appId)) {
                ns(appId);
            } else {
                nt(appId);
            }
        }
    }

    private void ns(String str) {
        SwanFavorDataManager.awR().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aqx() {
                com.baidu.swan.apps.res.widget.b.d.t(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).kG(2).showHighlightToast();
                a.this.aEf();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aqy() {
                com.baidu.swan.apps.res.widget.b.d.t(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).kG(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.awn().iQ(3).awo());
        qO("deletemyswan");
    }

    private void nt(String str) {
        if (com.baidu.swan.apps.ad.a.a.aHr()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cDe = null;
        final String page = ak.aPA().getPage();
        SwanFavorDataManager.awR().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aqz() {
                com.baidu.swan.apps.database.favorite.a.avo();
                if (a.D(a.this.dkY.bff())) {
                    a.cf("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.t(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).kG(2).kC(2).showToast();
                a.this.aEf();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aqA() {
                com.baidu.swan.apps.res.widget.b.d.t(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).kG(2).showToast();
            }
        });
        cf("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0464a interfaceC0464a) {
        String appId = d.aJQ().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0464a != null) {
            interfaceC0464a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.or(appId)) {
            SwanFavorDataManager.awR().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void aqz() {
                    com.baidu.swan.apps.database.favorite.a.avo();
                    if (a.D(activity)) {
                        if (interfaceC0464a != null) {
                            interfaceC0464a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.t(activity.getApplicationContext(), a.h.aiapps_fav_success).kG(2).kC(2).showToast();
                    if (interfaceC0464a != null) {
                        interfaceC0464a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void aqA() {
                    com.baidu.swan.apps.res.widget.b.d.t(activity.getApplicationContext(), a.h.aiapps_fav_fail).kG(2).showToast();
                    if (interfaceC0464a != null) {
                        interfaceC0464a.onFail();
                    }
                }
            });
        } else if (interfaceC0464a != null) {
            interfaceC0464a.onSuccess();
        }
    }

    public static boolean D(Activity activity) {
        return com.baidu.swan.apps.t.a.aAe().D(activity);
    }

    private void aEm() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.azw().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.dkY.bff() != null && (this.dkY.bff() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.dkY.bff()).k(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).kH(a.e.aiapps_day_mode_toast_icon).kG(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).kH(a.e.aiapps_night_mode_toast_icon).kG(2).showHighlightToast();
        }
        qO("daynightmode");
    }

    private void aEn() {
        b.a aio;
        if (com.baidu.swan.apps.ad.a.a.aHr()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aJV() != null) {
            aio = e.aJV().aJY();
        } else {
            aio = ((SwanAppActivity) this.dkY.bff()).aio();
        }
        com.baidu.swan.apps.ai.a.a(this.dkY.getContext(), aio);
        qO("addshortcut");
    }

    private void aEo() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        qO(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.aCp().aBZ());
        com.baidu.swan.apps.console.c.bt("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEp() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        aim.nC("navigateTo").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("about", null).commit();
        qO("about");
    }

    private void aEq() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f aim = this.dkY.aim();
        if (aim == null) {
            com.baidu.swan.apps.res.widget.b.d.t(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        aim.nC("navigateTo").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("authority", null).commit();
        qO("permission");
    }

    public static void qO(String str) {
        cf(str, null);
    }

    public static void cf(String str, String str2) {
        S(str, str2, null);
    }

    public static void S(String str, String str2, String str3) {
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
            SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
            if (aBZ != null) {
                aBZ.a(fVar);
            }
        }
    }
}
