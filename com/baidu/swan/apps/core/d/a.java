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
/* loaded from: classes11.dex */
public class a extends b implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView bLG;
    private BdBaseImageView bLH;
    private TextView bLI;
    private com.baidu.swan.apps.view.a bLJ;
    private long[] bLK = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        ae(inflate);
        ag(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bLJ != null) {
            this.bLJ.apB();
        }
        setRequestedOrientation(1);
        if (this.bLX != null && this.bLX.isShowing()) {
            this.bLX.fR(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ah(view);
        ey(-1);
        ez(ViewCompat.MEASURED_STATE_MASK);
        ig(null);
        dn(true);
    }

    private void ag(View view) {
        final com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null && akM.Ov() != null) {
            final b.a Ov = akM.Ov();
            this.bLG = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(Ov.YS());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(Ov.adl());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(Ov.adq());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(Ov.adr());
            final String Qg = com.baidu.swan.apps.w.a.abZ().Qg();
            if (!TextUtils.isEmpty(Qg)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.ir(Qg).is(a.this.getString(a.h.swan_app_service_agreement)).ds(false).Ww();
                    }
                });
            }
            this.bLI = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bLH = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bLG.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) Ov, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo ads = Ov.ads();
            if (ads != null && ads.isValid()) {
                this.bLJ = new com.baidu.swan.apps.view.a(this.mActivity, view, ads, a.f.bear_layout);
            }
            ex(Ov.getType());
            Vn();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.aeJ().aeo()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (VB() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(Ov.adM() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bLN;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bLN == null) {
                                    this.bLN = com.baidu.swan.apps.y.f.aeJ().K(a.this.mActivity);
                                }
                                if (a.this.VB()) {
                                    if (com.baidu.swan.apps.console.a.Th()) {
                                        com.baidu.swan.apps.console.a.i(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.b.d.avn().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                                            @Override // com.baidu.swan.games.b.d.a
                                            public void dk(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.i(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.b.d.avn().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bLN.setVisibility(this.bLN.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.VB()) {
                                a.this.Vj();
                            } else {
                                com.baidu.swan.apps.console.a.bs(a.this.getContext());
                            }
                        }
                    }
                });
                if (!VB()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bLP;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bLP == null) {
                                this.bLP = com.baidu.swan.apps.y.f.aeJ().L(a.this.mActivity);
                            }
                            this.bLP.setVisibility(this.bLP.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.abQ().dY(a.this.Ol())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.Yn().YB()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(Ov.getVersion()) ? "" : Ov.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.hw(akM.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), Ov.adt());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(Ov.adt()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).lV(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).eA(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.akw();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (VB()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String gB;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.VB()) {
                                    gB = com.baidu.swan.apps.swancore.a.anz().gB(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gB = com.baidu.swan.apps.swancore.a.anz().gB(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).lV(gB).a(new com.baidu.swan.apps.view.c.a()).eA(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.akw();
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
                                aVar.eI(a.h.aiapps_debug_report_performance).lV(a.this.Vi() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).eA(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.akw();
                            }
                        }
                    });
                }
            }
            PMSAppInfo adQ = Ov.adQ();
            if ((adQ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : adQ.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.aps()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ai.cn(a.this.getContext());
                        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                        fVar.mValue = "guarantee";
                        a.this.a(fVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vi() {
        com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
        if (aeJ.aeL()) {
            aeJ.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.akM(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void g(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.R(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Th()) {
                    com.baidu.swan.apps.console.a.bs(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.avn().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void dk(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bs(a.this.getContext());
                            } else {
                                com.baidu.swan.games.b.d.avn().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void ex(int i) {
        af.a(this.bLH, this.bLI, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QW() {
        FragmentActivity aCO = aCO();
        if (aCO != null && this.bLX == null) {
            this.bLX = new com.baidu.swan.menu.h(aCO, this.bLW, 13, com.baidu.swan.apps.w.a.abR(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLX, this).ags();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vk() {
        QW();
        this.bLX.show(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QT() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vl() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qy() {
        return false;
    }

    public static a Vm() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e akM;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e Ot = Ot();
            if (Ot == null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                Ot.io("navigateBack").ab(0, e.bMF).Wl().commit();
            }
        } else if (id == a.f.open_app_button && (akM = com.baidu.swan.apps.runtime.e.akM()) != null && akM.Ov() != null) {
            b.a Ov = akM.Ov();
            String adJ = Ov.adJ();
            String adK = Ov.adK();
            if (TextUtils.isEmpty(adJ) || TextUtils.isEmpty(adK)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bF = ai.bF(adJ, adK);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(bF), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void Vn() {
        if (this.bLG != null) {
            this.bLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.bLK, 1, a.this.bLK, 0, a.this.bLK.length - 1);
                    a.this.bLK[a.this.bLK.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.bLK[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.yJ();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ() {
        String str;
        b.a Ov;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        int Ol = Ol();
        if (akM != null && Ol != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion aem = com.baidu.swan.apps.y.f.aeJ().aem();
            if (VB()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(aem, Ol));
            sb.append("\n");
            if (Ol == 0) {
                ExtensionCore YI = com.baidu.swan.apps.core.k.d.Yn().YI();
                if (YI == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = YI.extensionCoreVersionName;
                    i = YI.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String PM = com.baidu.swan.apps.w.a.abZ().PM();
            if (!TextUtils.isEmpty(PM) && PM.length() > 7) {
                PM = PM.substring(0, 7);
            }
            sb.append("commitId : ").append(PM);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.abZ().PN());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null && (Ov = com.baidu.swan.apps.runtime.e.akM().Ov()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.abQ().dY(Ol())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.Yn().YB()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(Ov.getVersion()) ? "" : Ov.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), Ov.adt());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = Ov.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String avw = com.baidu.swan.games.b.d.avn().avw();
            if (!TextUtils.isEmpty(avw)) {
                sb.append("app sconsole version: ").append(avw).append("\n");
            }
            if (akM.ald()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long PB = com.baidu.swan.games.utils.so.d.PB();
            sb.append("v8 so version: ").append(PB).append(PB < 0 ? "(old)" : "(new)").append("\n");
            if (!akM.ald()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(r(0, com.baidu.swan.apps.core.k.d.Yn().YB()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bLK = new long[5];
        }
    }

    private String r(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aiM() ? com.baidu.swan.apps.as.g.w(i, true) : "" : (com.baidu.swan.apps.as.g.aoI() && com.baidu.swan.apps.w.a.abQ().OW()) ? com.baidu.swan.apps.as.g.w(i, z) : "";
    }
}
