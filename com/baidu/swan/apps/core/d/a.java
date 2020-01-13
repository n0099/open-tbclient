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
/* loaded from: classes10.dex */
public class a extends b implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView biV;
    private BdBaseImageView biW;
    private TextView biX;
    private com.baidu.swan.apps.view.a biY;
    private long[] biZ = new long[5];

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
        if (this.biY != null) {
            this.biY.afb();
        }
        setRequestedOrientation(1);
        if (this.bjm != null && this.bjm.isShowing()) {
            this.bjm.eM(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ag(view);
        ed(-1);
        ee(ViewCompat.MEASURED_STATE_MASK);
        gE(null);
        cj(true);
    }

    private void initView(View view) {
        final com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null && aap.En() != null) {
            final b.a En = aap.En();
            this.biV = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(En.OL());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(En.Te());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(En.Tj());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(En.Tk());
            final String Gb = com.baidu.swan.apps.w.a.RS().Gb();
            if (!TextUtils.isEmpty(Gb)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.gP(Gb).gQ(a.this.getString(a.h.swan_app_service_agreement)).co(false).Mp();
                    }
                });
            }
            this.biX = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.biW = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.biV.setImageBitmap(ai.a((com.baidu.swan.apps.x.b.b) En, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo Tl = En.Tl();
            if (Tl != null && Tl.isValid()) {
                this.biY = new com.baidu.swan.apps.view.a(this.mActivity, view, Tl, a.f.bear_layout);
            }
            ec(En.getType());
            Lh();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.y.f.UC().Uh()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (Lv() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(En.TF() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                    FullScreenFloatView bjc;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bjc == null) {
                                    this.bjc = com.baidu.swan.apps.y.f.UC().N(a.this.mActivity);
                                }
                                if (a.this.Lv()) {
                                    if (com.baidu.swan.apps.console.a.Ja()) {
                                        com.baidu.swan.apps.console.a.i(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.b.d.akH().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                                            @Override // com.baidu.swan.games.b.d.a
                                            public void cg(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.i(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.b.d.akH().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bjc.setVisibility(this.bjc.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.Lv()) {
                                a.this.Ld();
                            } else {
                                com.baidu.swan.apps.console.a.bN(a.this.getContext());
                            }
                        }
                    }
                });
                if (!Lv()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                        SwanAppPropertyWindow bje;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bje == null) {
                                this.bje = com.baidu.swan.apps.y.f.UC().O(a.this.mActivity);
                            }
                            this.bje.setVisibility(this.bje.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.w.a.RJ().dD(a.this.Ed())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.k.d.Og().Ou()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(En.getVersion()) ? "" : En.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.fU(aap.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), En.Tm());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(En.Tm()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).ku(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).dw(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.ZZ();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (Lv()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String gd;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.Lv()) {
                                    gd = com.baidu.swan.apps.swancore.a.adc().gd(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gd = com.baidu.swan.apps.swancore.a.adc().gd(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).ku(gd).a(new com.baidu.swan.apps.view.c.a()).dw(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.ZZ();
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
                                aVar.en(a.h.aiapps_debug_report_performance).ku(a.this.Lc() ? "Done!" : "Failed!").a(new com.baidu.swan.apps.view.c.a()).dw(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.ZZ();
                            }
                        }
                    });
                }
            }
            PMSAppInfo TJ = En.TJ();
            if ((TJ == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : TJ.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ai.aeS()) {
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
    public boolean Lc() {
        com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
        if (UC.UD()) {
            UC.a(new com.baidu.swan.apps.n.a.b("report_performance"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aap(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
            @Override // com.baidu.swan.apps.core.c.c.a
            public void e(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.aj(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Ja()) {
                    com.baidu.swan.apps.console.a.bN(a.this.getContext());
                } else {
                    com.baidu.swan.games.b.d.akH().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                        @Override // com.baidu.swan.games.b.d.a
                        public void cg(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bN(a.this.getContext());
                            } else {
                                com.baidu.swan.games.b.d.akH().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void ec(int i) {
        af.a(this.biW, this.biX, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void GR() {
        FragmentActivity ask = ask();
        if (ask != null && this.bjm == null) {
            this.bjm = new com.baidu.swan.menu.h(ask, this.bjl, 13, com.baidu.swan.apps.w.a.RK(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.aa.a(this.bjm, this).VU();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Le() {
        GR();
        this.bjm.show(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean GO() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Lf() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Gt() {
        return false;
    }

    public static a Lg() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.runtime.e aap;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e El = El();
            if (El == null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            } else {
                El.gM("navigateBack").Y(0, e.bjV).Mf().commit();
            }
        } else if (id == a.f.open_app_button && (aap = com.baidu.swan.apps.runtime.e.aap()) != null && aap.En() != null) {
            b.a En = aap.En();
            String TC = En.TC();
            String TD = En.TD();
            if (TextUtils.isEmpty(TC) || TextUtils.isEmpty(TD)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String bm = ai.bm(TC, TD);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(bm), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void Lh() {
        if (this.biV != null) {
            this.biV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.biZ, 1, a.this.biZ, 0, a.this.biZ.length - 1);
                    a.this.biZ[a.this.biZ.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.biZ[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.Li();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        String str;
        b.a En;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        int Ed = Ed();
        if (aap != null && Ed != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Uf = com.baidu.swan.apps.y.f.UC().Uf();
            if (Lv()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Uf, Ed));
            sb.append("\n");
            if (Ed == 0) {
                ExtensionCore OB = com.baidu.swan.apps.core.k.d.Og().OB();
                if (OB == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = OB.extensionCoreVersionName;
                    i = OB.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String FH = com.baidu.swan.apps.w.a.RS().FH();
            if (!TextUtils.isEmpty(FH) && FH.length() > 7) {
                FH = FH.substring(0, 7);
            }
            sb.append("commitId : ").append(FH);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.w.a.RS().FI());
            sb.append("\n");
            sb.append("version : ").append(ai.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null && (En = com.baidu.swan.apps.runtime.e.aap().En()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.w.a.RJ().dD(Ed())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.k.d.Og().Ou()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(En.getVersion()) ? "" : En.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), En.Tm());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = En.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String akQ = com.baidu.swan.games.b.d.akH().akQ();
            if (!TextUtils.isEmpty(akQ)) {
                sb.append("app sconsole version: ").append(akQ).append("\n");
            }
            if (aap.aaG()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long Fw = com.baidu.swan.games.utils.so.d.Fw();
            sb.append("v8 so version: ").append(Fw).append(Fw < 0 ? "(old)" : "(new)").append("\n");
            if (!aap.aaG()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(o(0, com.baidu.swan.apps.core.k.d.Og().Ou()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.biZ = new long[5];
        }
    }

    private String o(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.Yp() ? com.baidu.swan.apps.as.g.t(i, true) : "" : (com.baidu.swan.apps.as.g.ael() && com.baidu.swan.apps.w.a.RJ().EO()) ? com.baidu.swan.apps.as.g.t(i, z) : "";
    }
}
