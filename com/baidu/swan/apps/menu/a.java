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
    private g cUg;
    private SwanAppMenuHeaderView cUh;
    private c dpX;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.menu.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0456a {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static final boolean dqa = com.baidu.swan.apps.t.a.aAu().akC();
    }

    public a(g gVar, c cVar) {
        this(gVar, cVar, null);
    }

    public a(g gVar, c cVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        this.cUg = gVar;
        this.cUh = swanAppMenuHeaderView;
        this.dpX = cVar;
        if (cVar != null) {
            this.mContext = cVar.getContext();
        }
        aFw();
    }

    private void aFw() {
        com.baidu.swan.apps.t.a.aBc().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aFx() {
        e aMl;
        if (this.cUg != null && this.dpX != null && this.mContext != null && (aMl = e.aMl()) != null) {
            this.cUg.a(new com.baidu.swan.menu.e() { // from class: com.baidu.swan.apps.menu.a.1
                @Override // com.baidu.swan.menu.e
                public boolean a(View view, h hVar) {
                    return a.this.b(hVar);
                }
            });
            if (this.cUh != null) {
                this.cUh.setOnMenuHeaderClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.2
                    @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                    public void onClick(View view) {
                        a.this.cUg.dismiss();
                        a.this.aFI();
                    }
                });
                if (b.dqa) {
                    this.cUh.setAttentionBtnShow(true);
                    this.cUh.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cUg.dismiss();
                            a.this.aFE();
                        }
                    });
                }
                if (!aMl.aMD()) {
                    this.cUh.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cUg.dismiss();
                            return a.this.aFz();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFy() {
        this.cUh.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.oj(d.aMg().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFz() {
        if (this.dpX == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aFC() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).kM(2).aLS();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(h hVar) {
        if (this.dpX == null || this.mContext == null) {
            return false;
        }
        switch (hVar.getItemId()) {
            case 4:
                aFD();
                return true;
            case 5:
                aFF();
                return true;
            case 35:
                aFG();
                return true;
            case 37:
                aFJ();
                return true;
            case 38:
                aFE();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aFH();
                return true;
            case 49:
                aFB();
                return true;
            case 50:
                aFA();
                return true;
            default:
                return com.baidu.swan.apps.t.a.aAv().a(hVar);
        }
    }

    private void aFA() {
        this.cUg.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.dpX.arV(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void jK(int i) {
                com.baidu.swan.apps.adaptation.b.c asI;
                NgWebView ngWebView;
                if ((a.this.dpX instanceof com.baidu.swan.apps.core.d.e) && (asI = ((com.baidu.swan.apps.core.d.e) a.this.dpX).asI()) != null) {
                    if (asI.amk() != null) {
                        ngWebView = (NgWebView) asI.amk().amr();
                    } else {
                        ngWebView = (NgWebView) asI.amr();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aFL()) {
                        ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jM(i));
                    }
                    com.baidu.swan.apps.menu.fontsize.b.jL(i);
                    com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(i + 1));
                }
            }
        });
        cVar.a(new PopupWindow.a() { // from class: com.baidu.swan.apps.menu.a.6
            @Override // com.baidu.swan.menu.PopupWindow.a
            public void onDismiss() {
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aFK()));
            }
        });
        qI("typeface");
    }

    private void aFB() {
        f ajs = this.dpX.ajs();
        if (ajs == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLS();
            return;
        }
        ajs.nv("navigateTo").ai(f.cUY, f.cVa).a("settings", null).commit();
        qI("set");
    }

    private boolean aFC() {
        al.dT(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aRR()));
        return true;
    }

    private void aFD() {
        this.dpX.arF();
        qI(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFE() {
        String appId = d.aMg().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.oj(appId)) {
                nl(appId);
            } else {
                nm(appId);
            }
        }
    }

    private void nl(String str) {
        SwanFavorDataManager.ayj().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void arJ() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).kM(2).aLV();
                a.this.aFy();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void arK() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).kM(2).aLS();
            }
        }, com.baidu.swan.apps.env.c.c.axF().iL(3).axG());
        qI("deletemyswan");
    }

    private void nm(String str) {
        if (com.baidu.swan.apps.ad.a.a.aIK()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).aLS();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cHU = null;
        final String page = ak.aRR().getPage();
        SwanFavorDataManager.ayj().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void arL() {
                com.baidu.swan.apps.database.favorite.a.awG();
                if (a.C(a.this.dpX.bhA())) {
                    a.ce("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).kM(2).kI(2).aLS();
                a.this.aFy();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void arM() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).kM(2).aLS();
            }
        });
        ce("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0456a interfaceC0456a) {
        String appId = d.aMg().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0456a != null) {
            interfaceC0456a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.oj(appId)) {
            SwanFavorDataManager.ayj().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void arL() {
                    com.baidu.swan.apps.database.favorite.a.awG();
                    if (a.C(activity)) {
                        if (interfaceC0456a != null) {
                            interfaceC0456a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_success).kM(2).kI(2).aLS();
                    if (interfaceC0456a != null) {
                        interfaceC0456a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void arM() {
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_fail).kM(2).aLS();
                    if (interfaceC0456a != null) {
                        interfaceC0456a.onFail();
                    }
                }
            });
        } else if (interfaceC0456a != null) {
            interfaceC0456a.onSuccess();
        }
    }

    public static boolean C(Activity activity) {
        return com.baidu.swan.apps.t.a.aBv().C(activity);
    }

    private void aFF() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
        com.baidu.swan.apps.t.a.aAN().eL(!alD);
        if (this.dpX.bhA() != null && (this.dpX.bhA() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.dpX.bhA()).k(com.baidu.swan.apps.t.a.aAN().alD(), true);
        }
        if (alD) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).kN(a.e.aiapps_day_mode_toast_icon).kM(2).aLV();
        } else {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).kN(a.e.aiapps_night_mode_toast_icon).kM(2).aLV();
        }
        qI("daynightmode");
    }

    private void aFG() {
        b.a aju;
        if (com.baidu.swan.apps.ad.a.a.aIK()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).aLS();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aMl() != null) {
            aju = e.aMl().aMo();
        } else {
            aju = ((SwanAppActivity) this.dpX.bhA()).aju();
        }
        com.baidu.swan.apps.ah.a.a(this.dpX.getContext(), aju);
        qI("addshortcut");
    }

    private void aFH() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        qI(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.aDG().aDq());
        com.baidu.swan.apps.console.c.bs("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFI() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLS();
            return;
        }
        ajs.nv("navigateTo").ai(f.cUY, f.cVa).a("about", null).commit();
        qI("about");
    }

    private void aFJ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        f ajs = this.dpX.ajs();
        if (ajs == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLS();
            return;
        }
        ajs.nv("navigateTo").ai(f.cUY, f.cVa).a("authority", null).commit();
        qI("permission");
    }

    public static void qI(String str) {
        ce(str, null);
    }

    public static void ce(String str, String str2) {
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
                fVar.t("page", str2);
                fVar.mPage = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.mType = str3;
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                fVar.t(str4, str5);
            }
            SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
            if (aDq != null) {
                aDq.a(fVar);
            }
        }
    }
}
