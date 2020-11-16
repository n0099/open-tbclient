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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private h cIs;
    private SwanAppMenuHeaderView cIt;
    private c ddZ;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0452a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static final boolean dec = com.baidu.swan.apps.t.a.avV().agm();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cIs = hVar;
        this.cIt = swanAppMenuHeaderView;
        this.ddZ = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aAU();
    }

    private void aAU() {
        com.baidu.swan.apps.t.a.awD().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aAV() {
        e aGN;
        if (this.cIs != null && this.ddZ != null && this.mContext != null && (aGN = e.aGN()) != null) {
            this.cIs.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.cIt != null) {
                this.cIt.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cIs.dismiss();
                        a.this.aBg();
                    }
                });
                if (b.dec) {
                    this.cIt.setAttentionBtnShow(true);
                    this.cIt.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cIs.dismiss();
                            a.this.aBc();
                        }
                    });
                }
                if (!aGN.aHf()) {
                    this.cIt.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cIs.dismiss();
                            return a.this.aAX();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAW() {
        this.cIt.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.nI(d.aGI().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAX() {
        if (this.ddZ == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aBa() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).ki(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.ddZ == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                aBb();
                return true;
            case 5:
                aBd();
                return true;
            case 35:
                aBe();
                return true;
            case 37:
                aBh();
                return true;
            case 38:
                aBc();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aBf();
                return true;
            case 49:
                aAZ();
                return true;
            case 50:
                aAY();
                return true;
            default:
                return com.baidu.swan.apps.t.a.avW().a(iVar);
        }
    }

    private void aAY() {
        this.cIs.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.ddZ.anB(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void jr(int i) {
                com.baidu.swan.apps.adaptation.b.c aoi;
                NgWebView ngWebView;
                if ((a.this.ddZ instanceof com.baidu.swan.apps.core.d.e) && (aoi = ((com.baidu.swan.apps.core.d.e) a.this.ddZ).aoi()) != null) {
                    if (aoi.ahS() != null) {
                        ngWebView = (NgWebView) aoi.ahS().ahZ();
                    } else {
                        ngWebView = (NgWebView) aoi.ahZ();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aBj()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jt(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.js(i);
                    com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBi()));
            }
        });
        qh("typeface");
    }

    private void aAZ() {
        com.baidu.swan.apps.core.d.f afe = this.ddZ.afe();
        if (afe == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afe.mV("navigateTo").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("settings", null).commit();
        qh("set");
    }

    private boolean aBa() {
        al.cU(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aMu()));
        return true;
    }

    private void aBb() {
        this.ddZ.anl();
        qh(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        String appId = d.aGI().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nI(appId)) {
                mL(appId);
            } else {
                mM(appId);
            }
        }
    }

    private void mL(String str) {
        SwanFavorDataManager.atJ().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anp() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).ki(2).showHighlightToast();
                a.this.aAW();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anq() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).ki(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.atf().is(3).atg());
        qh("deletemyswan");
    }

    private void mM(String str) {
        if (com.baidu.swan.apps.ad.a.a.aEj()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cwm = null;
        final String page = ak.aMu().getPage();
        SwanFavorDataManager.atJ().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anr() {
                com.baidu.swan.apps.database.favorite.a.asf();
                if (a.D(a.this.ddZ.bca())) {
                    a.bY("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).ki(2).ke(2).showToast();
                a.this.aAW();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void ans() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).ki(2).showToast();
            }
        });
        bY("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0452a interfaceC0452a) {
        String appId = d.aGI().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0452a != null) {
            interfaceC0452a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.nI(appId)) {
            SwanFavorDataManager.atJ().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void anr() {
                    com.baidu.swan.apps.database.favorite.a.asf();
                    if (a.D(activity)) {
                        if (interfaceC0452a != null) {
                            interfaceC0452a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).ki(2).ke(2).showToast();
                    if (interfaceC0452a != null) {
                        interfaceC0452a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void ans() {
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).ki(2).showToast();
                    if (interfaceC0452a != null) {
                        interfaceC0452a.onFail();
                    }
                }
            });
        } else if (interfaceC0452a != null) {
            interfaceC0452a.onSuccess();
        }
    }

    public static boolean D(Activity activity) {
        return com.baidu.swan.apps.t.a.awW().D(activity);
    }

    private void aBd() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.awo().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.ddZ.bca() != null && (this.ddZ.bca() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.ddZ.bca()).k(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).kj(a.e.aiapps_day_mode_toast_icon).ki(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).kj(a.e.aiapps_night_mode_toast_icon).ki(2).showHighlightToast();
        }
        qh("daynightmode");
    }

    private void aBe() {
        b.a afg;
        if (com.baidu.swan.apps.ad.a.a.aEj()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aGN() != null) {
            afg = e.aGN().aGQ();
        } else {
            afg = ((SwanAppActivity) this.ddZ.bca()).afg();
        }
        com.baidu.swan.apps.ai.a.a(this.ddZ.getContext(), afg);
        qh("addshortcut");
    }

    private void aBf() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        qh(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.azg().ayQ());
        com.baidu.swan.apps.console.c.bm("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afe.mV("navigateTo").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("about", null).commit();
        qh("about");
    }

    private void aBh() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f afe = this.ddZ.afe();
        if (afe == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        afe.mV("navigateTo").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("authority", null).commit();
        qh("permission");
    }

    public static void qh(String str) {
        bY(str, null);
    }

    public static void bY(String str, String str2) {
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
            SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
            if (ayQ != null) {
                ayQ.a(fVar);
            }
        }
    }
}
