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
        public static final boolean dqa = com.baidu.swan.apps.t.a.aAv().akD();
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
        aFx();
    }

    private void aFx() {
        com.baidu.swan.apps.t.a.aBd().a((com.baidu.swan.apps.commonsync.a.a) null);
    }

    public void aFy() {
        e aMm;
        if (this.cUg != null && this.dpX != null && this.mContext != null && (aMm = e.aMm()) != null) {
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
                        a.this.aFJ();
                    }
                });
                if (b.dqa) {
                    this.cUh.setAttentionBtnShow(true);
                    this.cUh.setOnAttentionBtnClickListener(new SwanAppMenuHeaderView.a() { // from class: com.baidu.swan.apps.menu.a.3
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.a
                        public void onClick(View view) {
                            a.this.cUg.dismiss();
                            a.this.aFF();
                        }
                    });
                }
                if (!aMm.aME()) {
                    this.cUh.setOnMenuHeaderLongClickListener(new SwanAppMenuHeaderView.b() { // from class: com.baidu.swan.apps.menu.a.4
                        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.b
                        public boolean onLongClick(View view) {
                            a.this.cUg.dismiss();
                            return a.this.aFA();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFz() {
        this.cUh.setAttentionBtnStates(com.baidu.swan.apps.database.favorite.a.oj(d.aMh().getAppId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFA() {
        if (this.dpX == null || this.mContext == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.b.d.a(this.mContext, aFD() ? this.mContext.getString(a.h.swanapp_write_to_clipborad_succ) : this.mContext.getString(a.h.swanapp_write_to_clipborad_fail)).kM(2).aLT();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(h hVar) {
        if (this.dpX == null || this.mContext == null) {
            return false;
        }
        switch (hVar.getItemId()) {
            case 4:
                aFE();
                return true;
            case 5:
                aFG();
                return true;
            case 35:
                aFH();
                return true;
            case 37:
                aFK();
                return true;
            case 38:
                aFF();
                return true;
            case 39:
                restart();
                return true;
            case 42:
                aFI();
                return true;
            case 49:
                aFC();
                return true;
            case 50:
                aFB();
                return true;
            default:
                return com.baidu.swan.apps.t.a.aAw().a(hVar);
        }
    }

    private void aFB() {
        this.cUg.dismiss();
        com.baidu.swan.apps.menu.fontsize.c cVar = new com.baidu.swan.apps.menu.fontsize.c(this.mContext, this.dpX.arW(), new com.baidu.swan.apps.view.c.b());
        cVar.showView();
        cVar.a(new c.a() { // from class: com.baidu.swan.apps.menu.a.5
            @Override // com.baidu.swan.apps.menu.fontsize.c.a
            public void jK(int i) {
                com.baidu.swan.apps.adaptation.b.c asJ;
                NgWebView ngWebView;
                if ((a.this.dpX instanceof com.baidu.swan.apps.core.d.e) && (asJ = ((com.baidu.swan.apps.core.d.e) a.this.dpX).asJ()) != null) {
                    if (asJ.aml() != null) {
                        ngWebView = (NgWebView) asJ.aml().ams();
                    } else {
                        ngWebView = (NgWebView) asJ.ams();
                    }
                    if (!com.baidu.swan.apps.menu.fontsize.b.aFM()) {
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
                a.f("fontSizeChanged", null, null, "fontSizeLevel", String.valueOf(com.baidu.swan.apps.menu.fontsize.b.aFL()));
            }
        });
        qI("typeface");
    }

    private void aFC() {
        f ajt = this.dpX.ajt();
        if (ajt == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLT();
            return;
        }
        ajt.nv("navigateTo").ai(f.cUY, f.cVa).a("settings", null).commit();
        qI("set");
    }

    private boolean aFD() {
        al.dT(this.mContext).setText(com.baidu.swan.apps.model.b.d(ak.aRS()));
        return true;
    }

    private void aFE() {
        this.dpX.arG();
        qI(TbConfig.TMP_SHARE_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFF() {
        String appId = d.aMh().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.oj(appId)) {
                nl(appId);
            } else {
                nm(appId);
            }
        }
    }

    private void nl(String str) {
        SwanFavorDataManager.ayk().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.menu.a.7
            @Override // com.baidu.swan.apps.favordata.a.b
            public void arK() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_success).kM(2).aLW();
                a.this.aFz();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void arL() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_cancel_fav_fail).kM(2).aLT();
            }
        }, com.baidu.swan.apps.env.c.c.axG().iL(3).axH());
        qI("deletemyswan");
    }

    private void nm(String str) {
        if (com.baidu.swan.apps.ad.a.a.aIL()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_favor).aLT();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cHU = null;
        final String page = ak.aRS().getPage();
        SwanFavorDataManager.ayk().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.8
            @Override // com.baidu.swan.apps.favordata.a.a
            public void arM() {
                com.baidu.swan.apps.database.favorite.a.awH();
                if (a.C(a.this.dpX.bhB())) {
                    a.ce("addmyswan", page);
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_success).kM(2).kI(2).aLT();
                a.this.aFz();
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void arN() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.mContext.getApplicationContext(), a.h.aiapps_fav_fail).kM(2).aLT();
            }
        });
        ce("addmyswan", page);
    }

    public static void a(@NonNull final Activity activity, final InterfaceC0456a interfaceC0456a) {
        String appId = d.aMh().getAppId();
        if (TextUtils.isEmpty(appId) && interfaceC0456a != null) {
            interfaceC0456a.onFail();
        }
        if (!com.baidu.swan.apps.database.favorite.a.oj(appId)) {
            SwanFavorDataManager.ayk().b(appId, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.menu.a.9
                @Override // com.baidu.swan.apps.favordata.a.a
                public void arM() {
                    com.baidu.swan.apps.database.favorite.a.awH();
                    if (a.C(activity)) {
                        if (interfaceC0456a != null) {
                            interfaceC0456a.onSuccess();
                            return;
                        }
                        return;
                    }
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_success).kM(2).kI(2).aLT();
                    if (interfaceC0456a != null) {
                        interfaceC0456a.onSuccess();
                    }
                }

                @Override // com.baidu.swan.apps.favordata.a.a
                public void arN() {
                    com.baidu.swan.apps.res.widget.b.d.u(activity.getApplicationContext(), a.h.aiapps_fav_fail).kM(2).aLT();
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
        return com.baidu.swan.apps.t.a.aBw().C(activity);
    }

    private void aFG() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean alE = com.baidu.swan.apps.t.a.aAO().alE();
        com.baidu.swan.apps.t.a.aAO().eL(!alE);
        if (this.dpX.bhB() != null && (this.dpX.bhB() instanceof SwanAppActivity)) {
            ((SwanAppActivity) this.dpX.bhB()).k(com.baidu.swan.apps.t.a.aAO().alE(), true);
        }
        if (alE) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_day_mode).kN(a.e.aiapps_day_mode_toast_icon).kM(2).aLW();
        } else {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_browser_menu_toast_night_mode).kN(a.e.aiapps_night_mode_toast_icon).kM(2).aLW();
        }
        qI("daynightmode");
    }

    private void aFH() {
        b.a ajv;
        if (com.baidu.swan.apps.ad.a.a.aIL()) {
            if (DEBUG) {
                Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
            }
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext.getApplicationContext(), a.h.aiapps_debug_forbid_shortcut).aLT();
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "add shortcut");
        }
        if (e.aMm() != null) {
            ajv = e.aMm().aMp();
        } else {
            ajv = ((SwanAppActivity) this.dpX.bhB()).ajv();
        }
        com.baidu.swan.apps.ah.a.a(this.dpX.getContext(), ajv);
        qI("addshortcut");
    }

    private void aFI() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "restart");
        }
        if (this.mContext != null) {
            com.baidu.swan.games.utils.a.n((SwanAppActivity) this.mContext);
        }
    }

    protected void restart() {
        qI(Headers.REFRESH);
        com.baidu.swan.games.utils.a.n(com.baidu.swan.apps.v.f.aDH().aDr());
        com.baidu.swan.apps.console.c.bs("SwanAppMenuHelper", "restart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFJ() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startAboutFragment");
        }
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLT();
            return;
        }
        ajt.nv("navigateTo").ai(f.cUY, f.cVa).a("about", null).commit();
        qI("about");
    }

    private void aFK() {
        if (DEBUG) {
            Log.d("SwanAppMenuHelper", "startSettingFragment");
        }
        f ajt = this.dpX.ajt();
        if (ajt == null) {
            com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLT();
            return;
        }
        ajt.nv("navigateTo").ai(f.cUY, f.cVa).a("authority", null).commit();
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
            SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
            if (aDr != null) {
                aDr.a(fVar);
            }
        }
    }
}
