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
    private SwanAppRoundedImageView bng;
    private BdBaseImageView bnh;
    private TextView bni;
    private com.baidu.swan.apps.view.a bnj;
    private long[] bnk = new long[5];

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
        if (this.bnj != null) {
            this.bnj.ahr();
        }
        setRequestedOrientation(1);
        if (this.bnx != null && this.bnx.isShowing()) {
            this.bnx.eT(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ag(view);
        et(-1);
        eu(ViewCompat.MEASURED_STATE_MASK);
        gT(null);
        cq(true);
    }

    private void initView(View view) {
        final com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null && acF.GE() != null) {
            final b.a GE = acF.GE();
            this.bng = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(GE.Rb());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(GE.Vu());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(GE.Vz());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(GE.VA());
            final String Is = com.baidu.swan.apps.w.a.Ui().Is();
            if (!TextUtils.isEmpty(Is)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.he(Is).hf(a.this.getString(a.h.swan_app_service_agreement)).cv(false).OF();
                    }
                });
            }
            this.bni = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bnh = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bng.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) GE, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo VB = GE.VB();
            if (VB != null && VB.isValid()) {
                this.bnj = new com.baidu.swan.apps.view.a(this.mActivity, view, VB, a.f.bear_layout);
            }
            es(GE.getType());
            Ny();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.WS().Wx()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (NL() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(GE.VV() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bnn;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bnn == null) {
                                    this.bnn = com.baidu.swan.apps.y.f.WS().O(a.this.mActivity);
                                }
                                if (a.this.NL()) {
                                    if (com.baidu.swan.apps.console.a.Lr()) {
                                        com.baidu.swan.apps.console.a.i(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.b.d.amX().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                                            @Override // com.baidu.swan.games.b.d.a
                                            public void cn(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.i(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.b.d.amX().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bnn.setVisibility(this.bnn.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.NL()) {
                                a.this.Nu();
                            } else {
                                com.baidu.swan.apps.console.a.bR(a.this.getContext());
                            }
                        }
                    }
                });
                if (!NL()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bnp;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bnp == null) {
                                this.bnp = com.baidu.swan.apps.y.f.WS().P(a.this.mActivity);
                            }
                            this.bnp.setVisibility(this.bnp.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.TZ().dT(a.this.Gu())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.Qw().QK()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(GE.getVersion()) ? "" : GE.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.gj(acF.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), GE.VC());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(GE.VC()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).kJ(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).dD(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.acp();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (NL()) {
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
                                if (a.this.NL()) {
                                    gu = com.baidu.swan.apps.swancore.a.afs().gu(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gu = com.baidu.swan.apps.swancore.a.afs().gu(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).kJ(gu).a(new com.baidu.swan.apps.view.c.a()).dD(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.acp();
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
                                aVar.eD(a.h.aiapps_debug_report_performance).kJ(a.this.Nt() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).dD(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.acp();
                            }
                        }
                    });
                }
            }
            PMSAppInfo VZ = GE.VZ();
            if ((VZ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : VZ.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.ahi()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ai.cM(a.this.getContext());
                        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                        fVar.mValue = "guarantee";
                        a.this.a(fVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nt() {
        com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        if (WS.WT()) {
            WS.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nu() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.acF(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void f(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.aj(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Lr()) {
                    com.baidu.swan.apps.console.a.bR(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.amX().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void cn(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bR(a.this.getContext());
                            } else {
                                com.baidu.swan.games.b.d.amX().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void es(int i) {
        af.a(this.bnh, this.bni, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ji() {
        FragmentActivity auA = auA();
        if (auA != null && this.bnx == null) {
            this.bnx = new com.baidu.swan.menu.h(auA, this.bnw, 13, com.baidu.swan.apps.w.a.Ua(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnx, this).Yk();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nv() {
        Ji();
        this.bnx.show(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean IK() {
        return false;
    }

    public static a Nx() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e acF;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e GC = GC();
            if (GC == null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                GC.hb("navigateBack").Y(0, e.bog).Ov().commit();
            }
        } else if (id == a.f.open_app_button && (acF = com.baidu.swan.apps.runtime.e.acF()) != null && acF.GE() != null) {
            b.a GE = acF.GE();
            String VS = GE.VS();
            String VT = GE.VT();
            if (TextUtils.isEmpty(VS) || TextUtils.isEmpty(VT)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bv = ai.bv(VS, VT);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(bv), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void Ny() {
        if (this.bng != null) {
            this.bng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.bnk, 1, a.this.bnk, 0, a.this.bnk.length - 1);
                    a.this.bnk[a.this.bnk.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.bnk[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.ul();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul() {
        String str;
        b.a GE;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        int Gu = Gu();
        if (acF != null && Gu != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Wv = com.baidu.swan.apps.y.f.WS().Wv();
            if (NL()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Wv, Gu));
            sb.append("\n");
            if (Gu == 0) {
                ExtensionCore QR = com.baidu.swan.apps.core.k.d.Qw().QR();
                if (QR == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = QR.extensionCoreVersionName;
                    i = QR.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String HY = com.baidu.swan.apps.w.a.Ui().HY();
            if (!TextUtils.isEmpty(HY) && HY.length() > 7) {
                HY = HY.substring(0, 7);
            }
            sb.append("commitId : ").append(HY);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.Ui().HZ());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.acF() != null && com.baidu.swan.apps.runtime.e.acF().GE() != null && (GE = com.baidu.swan.apps.runtime.e.acF().GE()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.TZ().dT(Gu())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.Qw().QK()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(GE.getVersion()) ? "" : GE.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), GE.VC());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = GE.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String ang = com.baidu.swan.games.b.d.amX().ang();
            if (!TextUtils.isEmpty(ang)) {
                sb.append("app sconsole version: ").append(ang).append("\n");
            }
            if (acF.acW()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long HN = com.baidu.swan.games.utils.so.d.HN();
            sb.append("v8 so version: ").append(HN).append(HN < 0 ? "(old)" : "(new)").append("\n");
            if (!acF.acW()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(o(0, com.baidu.swan.apps.core.k.d.Qw().QK()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bnk = new long[5];
        }
    }

    private String o(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaF() ? com.baidu.swan.apps.as.g.t(i, true) : "" : (com.baidu.swan.apps.as.g.agB() && com.baidu.swan.apps.w.a.TZ().Hf()) ? com.baidu.swan.apps.as.g.t(i, z) : "";
    }
}
