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
    private SwanAppRoundedImageView bnf;
    private BdBaseImageView bng;
    private TextView bnh;
    private com.baidu.swan.apps.view.a bni;
    private long[] bnj = new long[5];

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
        if (this.bni != null) {
            this.bni.ahp();
        }
        setRequestedOrientation(1);
        if (this.bnw != null && this.bnw.isShowing()) {
            this.bnw.eT(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState());
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
        final com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null && acD.GC() != null) {
            final b.a GC = acD.GC();
            this.bnf = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(GC.QZ());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(GC.Vs());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(GC.Vx());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(GC.Vy());
            final String Iq = com.baidu.swan.apps.w.a.Ug().Iq();
            if (!TextUtils.isEmpty(Iq)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.he(Iq).hf(a.this.getString(a.h.swan_app_service_agreement)).cv(false).OD();
                    }
                });
            }
            this.bnh = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bng = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bnf.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) GC, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo Vz = GC.Vz();
            if (Vz != null && Vz.isValid()) {
                this.bni = new com.baidu.swan.apps.view.a(this.mActivity, view, Vz, a.f.bear_layout);
            }
            es(GC.getType());
            Nw();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.WQ().Wv()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (NJ() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(GC.VT() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bnm;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bnm == null) {
                                    this.bnm = com.baidu.swan.apps.y.f.WQ().O(a.this.mActivity);
                                }
                                if (a.this.NJ()) {
                                    if (com.baidu.swan.apps.console.a.Lp()) {
                                        com.baidu.swan.apps.console.a.i(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.b.d.amV().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                                            @Override // com.baidu.swan.games.b.d.a
                                            public void cn(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.i(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.b.d.amV().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bnm.setVisibility(this.bnm.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.NJ()) {
                                a.this.Ns();
                            } else {
                                com.baidu.swan.apps.console.a.bR(a.this.getContext());
                            }
                        }
                    }
                });
                if (!NJ()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bno;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bno == null) {
                                this.bno = com.baidu.swan.apps.y.f.WQ().P(a.this.mActivity);
                            }
                            this.bno.setVisibility(this.bno.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.TX().dT(a.this.Gs())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.Qu().QI()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(GC.getVersion()) ? "" : GC.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.gj(acD.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), GC.VA());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(GC.VA()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).kJ(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).dD(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.acn();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (NJ()) {
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
                                if (a.this.NJ()) {
                                    gu = com.baidu.swan.apps.swancore.a.afq().gu(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gu = com.baidu.swan.apps.swancore.a.afq().gu(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).kJ(gu).a(new com.baidu.swan.apps.view.c.a()).dD(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.acn();
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
                                aVar.eD(a.h.aiapps_debug_report_performance).kJ(a.this.Nr() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).dD(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.acn();
                            }
                        }
                    });
                }
            }
            PMSAppInfo VX = GC.VX();
            if ((VX == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : VX.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.ahg()) {
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
    public boolean Nr() {
        com.baidu.swan.apps.y.f WQ = com.baidu.swan.apps.y.f.WQ();
        if (WQ.WR()) {
            WQ.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.acD(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void f(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.aj(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Lp()) {
                    com.baidu.swan.apps.console.a.bR(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.amV().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void cn(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bR(a.this.getContext());
                            } else {
                                com.baidu.swan.games.b.d.amV().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void es(int i) {
        af.a(this.bng, this.bnh, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Jg() {
        FragmentActivity auy = auy();
        if (auy != null && this.bnw == null) {
            this.bnw = new com.baidu.swan.menu.h(auy, this.bnv, 13, com.baidu.swan.apps.w.a.TY(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bnw, this).Yi();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Nt() {
        Jg();
        this.bnw.show(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Jd() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Nu() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean II() {
        return false;
    }

    public static a Nv() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e acD;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e GA = GA();
            if (GA == null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                GA.hb("navigateBack").Y(0, e.bof).Ot().commit();
            }
        } else if (id == a.f.open_app_button && (acD = com.baidu.swan.apps.runtime.e.acD()) != null && acD.GC() != null) {
            b.a GC = acD.GC();
            String VQ = GC.VQ();
            String VR = GC.VR();
            if (TextUtils.isEmpty(VQ) || TextUtils.isEmpty(VR)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bv = ai.bv(VQ, VR);
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

    private void Nw() {
        if (this.bnf != null) {
            this.bnf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.bnj, 1, a.this.bnj, 0, a.this.bnj.length - 1);
                    a.this.bnj[a.this.bnj.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.bnj[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.ul();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul() {
        String str;
        b.a GC;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        int Gs = Gs();
        if (acD != null && Gs != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Wt = com.baidu.swan.apps.y.f.WQ().Wt();
            if (NJ()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Wt, Gs));
            sb.append("\n");
            if (Gs == 0) {
                ExtensionCore QP = com.baidu.swan.apps.core.k.d.Qu().QP();
                if (QP == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = QP.extensionCoreVersionName;
                    i = QP.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String HW = com.baidu.swan.apps.w.a.Ug().HW();
            if (!TextUtils.isEmpty(HW) && HW.length() > 7) {
                HW = HW.substring(0, 7);
            }
            sb.append("commitId : ").append(HW);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.Ug().HX());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.acD() != null && com.baidu.swan.apps.runtime.e.acD().GC() != null && (GC = com.baidu.swan.apps.runtime.e.acD().GC()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.TX().dT(Gs())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.Qu().QI()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(GC.getVersion()) ? "" : GC.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), GC.VA());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = GC.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String ane = com.baidu.swan.games.b.d.amV().ane();
            if (!TextUtils.isEmpty(ane)) {
                sb.append("app sconsole version: ").append(ane).append("\n");
            }
            if (acD.acU()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long HL = com.baidu.swan.games.utils.so.d.HL();
            sb.append("v8 so version: ").append(HL).append(HL < 0 ? "(old)" : "(new)").append("\n");
            if (!acD.acU()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(o(0, com.baidu.swan.apps.core.k.d.Qu().QI()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bnj = new long[5];
        }
    }

    private String o(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaD() ? com.baidu.swan.apps.as.g.t(i, true) : "" : (com.baidu.swan.apps.as.g.agz() && com.baidu.swan.apps.w.a.TX().Hd()) ? com.baidu.swan.apps.as.g.t(i, z) : "";
    }
}
