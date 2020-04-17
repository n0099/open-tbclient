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
    private SwanAppRoundedImageView bLB;
    private BdBaseImageView bLC;
    private TextView bLD;
    private com.baidu.swan.apps.view.a bLE;
    private long[] bLF = new long[5];

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
        if (this.bLE != null) {
            this.bLE.apC();
        }
        setRequestedOrientation(1);
        if (this.bLS != null && this.bLS.isShowing()) {
            this.bLS.fR(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState());
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
        final com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && akN.Ow() != null) {
            final b.a Ow = akN.Ow();
            this.bLB = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(Ow.YT());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(Ow.adm());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(Ow.adr());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(Ow.ads());
            final String Qh = com.baidu.swan.apps.w.a.aca().Qh();
            if (!TextUtils.isEmpty(Qh)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.ir(Qh).is(a.this.getString(a.h.swan_app_service_agreement)).ds(false).Wx();
                    }
                });
            }
            this.bLD = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bLC = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bLB.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) Ow, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo adt = Ow.adt();
            if (adt != null && adt.isValid()) {
                this.bLE = new com.baidu.swan.apps.view.a(this.mActivity, view, adt, a.f.bear_layout);
            }
            ex(Ow.getType());
            Vo();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.aeK().aep()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (VC() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(Ow.adN() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bLI;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bLI == null) {
                                    this.bLI = com.baidu.swan.apps.y.f.aeK().K(a.this.mActivity);
                                }
                                if (a.this.VC()) {
                                    if (com.baidu.swan.apps.console.a.Ti()) {
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
                                this.bLI.setVisibility(this.bLI.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.VC()) {
                                a.this.Vk();
                            } else {
                                com.baidu.swan.apps.console.a.bE(a.this.getContext());
                            }
                        }
                    }
                });
                if (!VC()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bLK;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bLK == null) {
                                this.bLK = com.baidu.swan.apps.y.f.aeK().L(a.this.mActivity);
                            }
                            this.bLK.setVisibility(this.bLK.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.abR().dY(a.this.Om())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.Yo().YC()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(Ow.getVersion()) ? "" : Ow.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.hw(akN.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), Ow.adu());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(Ow.adu()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).lV(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).eA(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.akx();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (VC()) {
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
                                if (a.this.VC()) {
                                    gB = com.baidu.swan.apps.swancore.a.anA().gB(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gB = com.baidu.swan.apps.swancore.a.anA().gB(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).lV(gB).a(new com.baidu.swan.apps.view.c.a()).eA(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.akx();
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
                                aVar.eI(a.h.aiapps_debug_report_performance).lV(a.this.Vj() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).eA(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.akx();
                            }
                        }
                    });
                }
            }
            PMSAppInfo adR = Ow.adR();
            if ((adR == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : adR.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.apt()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ai.cz(a.this.getContext());
                        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                        fVar.mValue = "guarantee";
                        a.this.a(fVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vj() {
        com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
        if (aeK.aeM()) {
            aeK.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vk() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.akN(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void g(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.ad(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Ti()) {
                    com.baidu.swan.apps.console.a.bE(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.avn().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void dk(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bE(a.this.getContext());
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
        af.a(this.bLC, this.bLD, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void QX() {
        FragmentActivity aCO = aCO();
        if (aCO != null && this.bLS == null) {
            this.bLS = new com.baidu.swan.menu.h(aCO, this.bLR, 13, com.baidu.swan.apps.w.a.abS(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bLS, this).agt();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Vl() {
        QX();
        this.bLS.show(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean QU() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Vm() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Qz() {
        return false;
    }

    public static a Vn() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e akN;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e Ou = Ou();
            if (Ou == null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                Ou.io("navigateBack").ab(0, e.bMA).Wm().commit();
            }
        } else if (id == a.f.open_app_button && (akN = com.baidu.swan.apps.runtime.e.akN()) != null && akN.Ow() != null) {
            b.a Ow = akN.Ow();
            String adK = Ow.adK();
            String adL = Ow.adL();
            if (TextUtils.isEmpty(adK) || TextUtils.isEmpty(adL)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bF = ai.bF(adK, adL);
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

    private void Vo() {
        if (this.bLB != null) {
            this.bLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.bLF, 1, a.this.bLF, 0, a.this.bLF.length - 1);
                    a.this.bLF[a.this.bLF.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.bLF[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.yK();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK() {
        String str;
        b.a Ow;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        int Om = Om();
        if (akN != null && Om != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion aen = com.baidu.swan.apps.y.f.aeK().aen();
            if (VC()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(aen, Om));
            sb.append("\n");
            if (Om == 0) {
                ExtensionCore YJ = com.baidu.swan.apps.core.k.d.Yo().YJ();
                if (YJ == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = YJ.extensionCoreVersionName;
                    i = YJ.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String PN = com.baidu.swan.apps.w.a.aca().PN();
            if (!TextUtils.isEmpty(PN) && PN.length() > 7) {
                PN = PN.substring(0, 7);
            }
            sb.append("commitId : ").append(PN);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.aca().PO());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null && (Ow = com.baidu.swan.apps.runtime.e.akN().Ow()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.abR().dY(Om())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.Yo().YC()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(Ow.getVersion()) ? "" : Ow.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), Ow.adu());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = Ow.getVersionCode();
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
            if (akN.ale()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long PC = com.baidu.swan.games.utils.so.d.PC();
            sb.append("v8 so version: ").append(PC).append(PC < 0 ? "(old)" : "(new)").append("\n");
            if (!akN.ale()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(r(0, com.baidu.swan.apps.core.k.d.Yo().YC()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bLF = new long[5];
        }
    }

    private String r(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aiN() ? com.baidu.swan.apps.as.g.w(i, true) : "" : (com.baidu.swan.apps.as.g.aoJ() && com.baidu.swan.apps.w.a.abR().OX()) ? com.baidu.swan.apps.as.g.w(i, z) : "";
    }
}
