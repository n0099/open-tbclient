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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cDk;
    private h cht;
    private SwanAppMenuHeaderView chu;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0416a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static final boolean cDn = com.baidu.swan.apps.t.a.aoM().Zf();
    }

    public a(h hVar, c cVar) {
        this(hVar, cVar, null);
    }

    public a(h hVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cht = hVar;
        this.chu = swanAppMenuHeaderView;
        this.cDk = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        atO();
    }

    private void atO() {
        com.baidu.swan.apps.t.a.apv().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void atP() {
        e azJ;
        if (this.cht != null && this.cDk != null && this.mContext != null && (azJ = e.azJ()) != null) {
            this.cht.a(new f() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.f
                public boolean a(View view, i iVar) {
                    return a.this.b(iVar);
                }
            });
            if (this.chu != null) {
                this.chu.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cht.dismiss();
                        a.this.aua();
                    }
                });
                if (b.cDn) {
                    this.chu.setAttentionBtnShow(true);
                    this.chu.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cht.dismiss();
                            a.this.atW();
                        }
                    });
                }
                if (!azJ.aAb()) {
                    this.chu.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cht.dismiss();
                            return a.this.atR();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atQ() {
        this.chu.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.mc(d.azE().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atR() {
        if (this.cDk == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, atU() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).jj(2).showToast();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(i iVar) {
        if (this.cDk == null || this.mContext == null) {
            return false;
        }
        switch (iVar.getItemId()) {
            case 4:
                atV();
                return true;
            case 5:
                atX();
                return true;
            case 35:
                atY();
                return true;
            case 37:
                aub();
                return true;
            case 38:
                atW();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                atZ();
                return true;
            case 49:
                atT();
                return true;
            case 50:
                atS();
                return true;
            default:
                return com.baidu.swan.apps.t.a.aoN().a(iVar);
        }
    }

    private void atS() {
        this.cht.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.cDk.agu(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void it(int i) {
                com.baidu.swan.apps.adaptation.b.c ahb;
                NgWebView ngWebView;
                if ((a.this.cDk instanceof com.baidu.swan.apps.core.d.e) && (ahb = ((com.baidu.swan.apps.core.d.e) a.this.cDk).ahb()) != null) {
                    if (ahb.aaL() != null) {
                        ngWebView = (NgWebView) ahb.aaL().aaS();
                    } else {
                        ngWebView = (NgWebView) ahb.aaS();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aud()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.iv(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.iu(i);
                    com.baidu.swan.apps.menu.fontsize.a.c(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.auc()));
            }
        });
        oB("typeface");
    }

    private void atT() {
        com.baidu.swan.apps.core.d.f XX = this.cDk.XX();
        if (XX == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        XX.lo("navigateTo").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("settings", null).commit();
        oB("set");
    }

    private boolean atU() {
        al.cP(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aFp()));
        return true;
    }

    private void atV() {
        this.cDk.age();
        oB(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atW() {
        String appId = d.azE().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.mc(appId)) {
                le(appId);
            } else {
                lf(appId);
            }
        }
    }

    private void le(String str) {
        SwanFavorDataManager.amA().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void agi() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).jj(2).showHighlightToast();
                a.this.atQ();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void agj() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).jj(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.alW().hv(3).alX());
        oB("deletemyswan");
    }

    private void lf(String str) {
        if (com.baidu.swan.apps.ad.a.a.axd()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bVi = null;
        final String page = ak.aFp().getPage();
        SwanFavorDataManager.amA().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void agk() {
                com.baidu.swan.apps.database.favorite.a.akX();
                if (a.C(a.this.cDk.aUT())) {
                    a.bN("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).jj(2).jf(2).showToast();
                a.this.atQ();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void agl() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).jj(2).showToast();
            }
        });
        bN("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0416a interfaceC0416a) {
        String appId = d.azE().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0416a != null) {
            interfaceC0416a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.mc(appId)) {
            SwanFavorDataManager.amA().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void agk() {
                    com.baidu.swan.apps.database.favorite.a.akX();
                    if (a.C(activity)) {
                        if (interfaceC0416a != null) {
                            interfaceC0416a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_success).jj(2).jf(2).showToast();
                    if (interfaceC0416a != null) {
                        interfaceC0416a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void agl() {
                    com.baidu.swan.apps.res.widget.b.d.k(activity.getApplicationContext(), a.h.aiapps_fav_fail).jj(2).showToast();
                    if (interfaceC0416a != null) {
                        interfaceC0416a.onFail();
                    }
                }
            });
        } else if (interfaceC0416a != null) {
            interfaceC0416a.onSuccess();
        }
    }

    public static boolean C(Activity activity) {
        return com.baidu.swan.apps.t.a.apO().C(activity);
    }

    private void atX() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
        com.baidu.swan.apps.t.a.apf().setNightModeSwitcherState(!nightModeSwitcherState);
        if (this.cDk.aUT() != null && (this.cDk.aUT() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.cDk.aUT()).k(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState(), true);
        }
        if (nightModeSwitcherState) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).jk(a.e.aiapps_day_mode_toast_icon).jj(2).showHighlightToast();
        } else {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).jk(a.e.aiapps_night_mode_toast_icon).jj(2).showHighlightToast();
        }
        oB("daynightmode");
    }

    private void atY() {
        b.a XZ;
        if (com.baidu.swan.apps.ad.a.a.axd()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).showToast();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.azJ() != null) {
            XZ = e.azJ().azM();
        } else {
            XZ = ((SwanAppActivity) this.cDk.aUT()).XZ();
        }
        com.baidu.swan.apps.ai.a.a(this.cDk.getContext(), XZ);
        oB("addshortcut");
    }

    private void atZ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        oB(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.arY().arI());
        com.baidu.swan.apps.console.c.bb("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aua() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        XX.lo("navigateTo").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("about", null).commit();
        oB("about");
    }

    private void aub() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        com.baidu.swan.apps.core.d.f XX = this.cDk.XX();
        if (XX == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        XX.lo("navigateTo").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("authority", null).commit();
        oB("permission");
    }

    public static void oB(String str) {
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
            SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
            if (arI != null) {
                arI.a(fVar);
            }
        }
    }
}
