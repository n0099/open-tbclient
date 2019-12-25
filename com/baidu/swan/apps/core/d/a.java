package com.baidu.swan.apps.core.d;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.b.d;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes9.dex */
public class a extends b implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView bie;
    private BdBaseImageView bif;
    private TextView bih;
    private com.baidu.swan.apps.view.a bii;
    private long[] bij = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        aa(inflate);
        initView(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bii != null) {
            this.bii.aeI();
        }
        setRequestedOrientation(1);
        if (this.bix != null && this.bix.isShowing()) {
            this.bix.eH(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void aa(View view) {
        ac(view);
        ec(-1);
        ed(ViewCompat.MEASURED_STATE_MASK);
        gB(null);
        ce(true);
    }

    private void initView(View view) {
        final com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null && ZS.DR() != null) {
            final b.a DR = ZS.DR();
            this.bie = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(DR.Op());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(DR.SH());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(DR.SM());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(DR.SN());
            final String FF = com.baidu.swan.apps.w.a.Rw().FF();
            if (!TextUtils.isEmpty(FF)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.gM(FF).gN(a.this.getString(a.h.swan_app_service_agreement)).cj(false).LT();
                    }
                });
            }
            this.bih = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bif = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bie.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) DR, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo SO = DR.SO();
            if (SO != null && SO.isValid()) {
                this.bii = new com.baidu.swan.apps.view.a(this.mActivity, view, SO, a.f.bear_layout);
            }
            eb(DR.getType());
            KL();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.Uf().TK()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (KZ() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(DR.Ti() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bim;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bim == null) {
                                    this.bim = com.baidu.swan.apps.y.f.Uf().M(a.this.mActivity);
                                }
                                if (a.this.KZ()) {
                                    if (com.baidu.swan.apps.console.a.IE()) {
                                        com.baidu.swan.apps.console.a.i(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.b.d.ako().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                                            @Override // com.baidu.swan.games.b.d.a
                                            public void cb(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.i(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.b.d.ako().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bim.setVisibility(this.bim.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.KZ()) {
                                a.this.KH();
                            } else {
                                com.baidu.swan.apps.console.a.bN(a.this.getContext());
                            }
                        }
                    }
                });
                if (!KZ()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bip;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bip == null) {
                                this.bip = com.baidu.swan.apps.y.f.Uf().N(a.this.mActivity);
                            }
                            this.bip.setVisibility(this.bip.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.Rn().dC(a.this.DH())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.NK().NY()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(DR.getVersion()) ? "" : DR.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.fR(ZS.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), DR.SP());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(DR.SP()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).kr(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).dr(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.ZC();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (KZ()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String gc;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.KZ()) {
                                    gc = com.baidu.swan.apps.swancore.a.acF().gc(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gc = com.baidu.swan.apps.swancore.a.acF().gc(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).kr(gc).a(new com.baidu.swan.apps.view.c.a()).dr(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.ZC();
                            }
                        }
                    });
                }
                View inflate3 = ((ViewStub) view.findViewById(a.f.ai_app_report_performance)).inflate();
                if (inflate3 instanceof Button) {
                    Button button2 = (Button) inflate3;
                    button2.setText(a.h.aiapps_debug_report_performance);
                    button2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.mActivity != null) {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.em(a.h.aiapps_debug_report_performance).kr(a.this.KG() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).dr(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.ZC();
                            }
                        }
                    });
                }
            }
            PMSAppInfo Tm = DR.Tm();
            if ((Tm == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : Tm.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.aez()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ai.cI(a.this.getContext());
                        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                        fVar.mValue = "guarantee";
                        a.this.a(fVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KG() {
        com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
        if (Uf.Ug()) {
            Uf.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.ZS(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void e(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.ah(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.IE()) {
                    com.baidu.swan.apps.console.a.bN(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.ako().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void cb(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bN(a.this.getContext());
                            } else {
                                com.baidu.swan.games.b.d.ako().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void eb(int i) {
        af.a(this.bif, this.bih, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Gv() {
        FragmentActivity arR = arR();
        if (arR != null && this.bix == null) {
            this.bix = new com.baidu.swan.menu.h(arR, this.biw, 13, com.baidu.swan.apps.w.a.Ro(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bix, this).Vx();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void KI() {
        Gv();
        this.bix.show(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Gs() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean KJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean FX() {
        return false;
    }

    public static a KK() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e ZS;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e DP = DP();
            if (DP == null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                DP.gJ("navigateBack").U(0, e.bjg).LJ().commit();
            }
        } else if (id == a.f.open_app_button && (ZS = com.baidu.swan.apps.runtime.e.ZS()) != null && ZS.DR() != null) {
            b.a DR = ZS.DR();
            String Tf = DR.Tf();
            String Tg = DR.Tg();
            if (TextUtils.isEmpty(Tf) || TextUtils.isEmpty(Tg)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bl = ai.bl(Tf, Tg);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(bl), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void KL() {
        if (this.bie != null) {
            this.bie.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.bij, 1, a.this.bij, 0, a.this.bij.length - 1);
                    a.this.bij[a.this.bij.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.bij[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.KM();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM() {
        String str;
        b.a DR;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        int DH = DH();
        if (ZS != null && DH != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion TI = com.baidu.swan.apps.y.f.Uf().TI();
            if (KZ()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(TI, DH));
            sb.append("\n");
            if (DH == 0) {
                ExtensionCore Of = com.baidu.swan.apps.core.k.d.NK().Of();
                if (Of == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = Of.extensionCoreVersionName;
                    i = Of.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String Fl = com.baidu.swan.apps.w.a.Rw().Fl();
            if (!TextUtils.isEmpty(Fl) && Fl.length() > 7) {
                Fl = Fl.substring(0, 7);
            }
            sb.append("commitId : ").append(Fl);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.Rw().Fm());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null && (DR = com.baidu.swan.apps.runtime.e.ZS().DR()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.Rn().dC(DH())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.NK().NY()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(DR.getVersion()) ? "" : DR.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), DR.SP());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = DR.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String akx = com.baidu.swan.games.b.d.ako().akx();
            if (!TextUtils.isEmpty(akx)) {
                sb.append("app sconsole version: ").append(akx).append("\n");
            }
            if (ZS.aaj()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long Fa = com.baidu.swan.games.utils.so.d.Fa();
            sb.append("v8 so version: ").append(Fa).append(Fa < 0 ? "(old)" : "(new)").append("\n");
            if (!ZS.aaj()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(o(0, com.baidu.swan.apps.core.k.d.NK().NY()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bij = new long[5];
        }
    }

    private String o(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.XS() ? com.baidu.swan.apps.as.g.t(i, true) : "" : (com.baidu.swan.apps.as.g.adS() && com.baidu.swan.apps.w.a.Rn().Es()) ? com.baidu.swan.apps.as.g.t(i, z) : "";
    }
}
