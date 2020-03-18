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
    private SwanAppRoundedImageView bnu;
    private BdBaseImageView bnv;
    private TextView bnw;
    private com.baidu.swan.apps.view.a bnx;
    private long[] bny = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        ae(inflate);
        initView(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bnx != null) {
            this.bnx.ahu();
        }
        setRequestedOrientation(1);
        if (this.bnL != null && this.bnL.isShowing()) {
            this.bnL.eU(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ag(view);
        et(-1);
        eu(ViewCompat.MEASURED_STATE_MASK);
        gS(null);
        cr(true);
    }

    private void initView(View view) {
        final com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null && acI.GJ() != null) {
            final b.a GJ = acI.GJ();
            this.bnu = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(GJ.Re());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(GJ.Vx());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(GJ.VC());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(GJ.VD());
            final String Iv = com.baidu.swan.apps.w.a.Ul().Iv();
            if (!TextUtils.isEmpty(Iv)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.hd(Iv).he(a.this.getString(a.h.swan_app_service_agreement)).cw(false).OI();
                    }
                });
            }
            this.bnw = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bnv = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bnu.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) GJ, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo VE = GJ.VE();
            if (VE != null && VE.isValid()) {
                this.bnx = new com.baidu.swan.apps.view.a(this.mActivity, view, VE, a.f.bear_layout);
            }
            es(GJ.getType());
            NB();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.WV().WA()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (NO() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(GJ.VY() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bnB;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bnB == null) {
                                    this.bnB = com.baidu.swan.apps.y.f.WV().O(a.this.mActivity);
                                }
                                if (a.this.NO()) {
                                    if (com.baidu.swan.apps.console.a.Lu()) {
                                        com.baidu.swan.apps.console.a.i(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.b.d.ana().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                                            @Override // com.baidu.swan.games.b.d.a
                                            public void co(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.i(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.b.d.ana().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bnB.setVisibility(this.bnB.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.NO()) {
                                a.this.Nx();
                            } else {
                                com.baidu.swan.apps.console.a.bQ(a.this.getContext());
                            }
                        }
                    }
                });
                if (!NO()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bnD;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bnD == null) {
                                this.bnD = com.baidu.swan.apps.y.f.WV().P(a.this.mActivity);
                            }
                            this.bnD.setVisibility(this.bnD.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.Uc().dT(a.this.Gz())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.Qz().QN()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(GJ.getVersion()) ? "" : GJ.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.gi(acI.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), GJ.VF());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(GJ.VF()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).kI(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).dE(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.acs();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (NO()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String gu;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.NO()) {
                                    gu = com.baidu.swan.apps.swancore.a.afv().gu(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gu = com.baidu.swan.apps.swancore.a.afv().gu(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).kI(gu).a(new com.baidu.swan.apps.view.c.a()).dE(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.acs();
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
                                aVar.eD(a.h.aiapps_debug_report_performance).kI(a.this.Nw() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).dE(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.acs();
                            }
                        }
                    });
                }
            }
            PMSAppInfo Wc = GJ.Wc();
            if ((Wc == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : Wc.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.ahl()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ai.cL(a.this.getContext());
                        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                        fVar.mValue = "guarantee";
                        a.this.a(fVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nw() {
        com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        if (WV.WW()) {
            WV.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nx() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.acI(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void f(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.aj(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Lu()) {
                    com.baidu.swan.apps.console.a.bQ(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.ana().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void co(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bQ(a.this.getContext());
                            } else {
                                com.baidu.swan.games.b.d.ana().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void es(int i) {
        af.a(this.bnv, this.bnw, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jl() {
        FragmentActivity auD = auD();
        if (auD != null && this.bnL == null) {
            this.bnL = new com.baidu.swan.menu.h(auD, this.bnK, 13, com.baidu.swan.apps.w.a.Ud(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnL, this).Yn();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ny() {
        Jl();
        this.bnL.show(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ji() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nz() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IN() {
        return false;
    }

    public static a NA() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e acI;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e GH = GH();
            if (GH == null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                GH.ha("navigateBack").Y(0, e.bot).Oy().commit();
            }
        } else if (id == a.f.open_app_button && (acI = com.baidu.swan.apps.runtime.e.acI()) != null && acI.GJ() != null) {
            b.a GJ = acI.GJ();
            String VV = GJ.VV();
            String VW = GJ.VW();
            if (TextUtils.isEmpty(VV) || TextUtils.isEmpty(VW)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bu = ai.bu(VV, VW);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(bu), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void NB() {
        if (this.bnu != null) {
            this.bnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.bny, 1, a.this.bny, 0, a.this.bny.length - 1);
                    a.this.bny[a.this.bny.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.bny[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.uq();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq() {
        String str;
        b.a GJ;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        int Gz = Gz();
        if (acI != null && Gz != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Wy = com.baidu.swan.apps.y.f.WV().Wy();
            if (NO()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Wy, Gz));
            sb.append("\n");
            if (Gz == 0) {
                ExtensionCore QU = com.baidu.swan.apps.core.k.d.Qz().QU();
                if (QU == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = QU.extensionCoreVersionName;
                    i = QU.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String Ib = com.baidu.swan.apps.w.a.Ul().Ib();
            if (!TextUtils.isEmpty(Ib) && Ib.length() > 7) {
                Ib = Ib.substring(0, 7);
            }
            sb.append("commitId : ").append(Ib);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.Ul().Ic());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.acI() != null && com.baidu.swan.apps.runtime.e.acI().GJ() != null && (GJ = com.baidu.swan.apps.runtime.e.acI().GJ()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.Uc().dT(Gz())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.Qz().QN()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(GJ.getVersion()) ? "" : GJ.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), GJ.VF());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = GJ.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String anj = com.baidu.swan.games.b.d.ana().anj();
            if (!TextUtils.isEmpty(anj)) {
                sb.append("app sconsole version: ").append(anj).append("\n");
            }
            if (acI.acZ()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long HQ = com.baidu.swan.games.utils.so.d.HQ();
            sb.append("v8 so version: ").append(HQ).append(HQ < 0 ? "(old)" : "(new)").append("\n");
            if (!acI.acZ()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(o(0, com.baidu.swan.apps.core.k.d.Qz().QN()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bny = new long[5];
        }
    }

    private String o(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaI() ? com.baidu.swan.apps.as.g.t(i, true) : "" : (com.baidu.swan.apps.as.g.agE() && com.baidu.swan.apps.w.a.Uc().Hk()) ? com.baidu.swan.apps.as.g.t(i, z) : "";
    }
}
