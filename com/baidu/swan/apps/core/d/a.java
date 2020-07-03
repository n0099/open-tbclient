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
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.games.c.d;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends b implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView bZr;
    private BdBaseImageView bZs;
    private TextView bZt;
    private com.baidu.swan.apps.view.a bZu;
    private long[] bZv = new long[5];
    private String bZw;
    private String bZx;
    private String bZy;

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
        if (this.bZu != null) {
            this.bZu.avo();
        }
        setRequestedOrientation(1);
        if (this.bZP != null && this.bZP.isShowing()) {
            this.bZP.gh(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ah(view);
        dE(true);
        eU(-1);
        eV(ViewCompat.MEASURED_STATE_MASK);
        jq(null);
        dH(true);
    }

    private void ag(View view) {
        final com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN != null && apN.apQ() != null) {
            final b.a apQ = apN.apQ();
            this.bZr = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(apQ.acZ());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(apQ.ahB());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(apQ.ahG());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(apQ.ahH());
            this.bZy = com.baidu.swan.apps.u.a.agj().TQ();
            if (!TextUtils.isEmpty(this.bZy)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            PMSAppInfo aig = apQ.aig();
            if (apN.RF() == 0 && aig != null && !TextUtils.isEmpty(aig.brandsInfo)) {
                e(view, aig.brandsInfo);
            }
            this.bZt = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bZs = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bZr.setImageBitmap(aj.a((com.baidu.swan.apps.v.b.b) apQ, "SwanAppAboutFragment", false));
            this.bZr.setOnClickListener(this);
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo ahI = apQ.ahI();
            if (ahI != null && ahI.isValid()) {
                this.bZu = new com.baidu.swan.apps.view.a(this.mActivity, view, ahI, a.f.bear_layout);
            }
            eT(apQ.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.f.ajb().aiF()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (Zs() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(apQ.aic() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView bZz;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bZz == null) {
                                    this.bZz = com.baidu.swan.apps.w.f.ajb().I(a.this.mActivity);
                                }
                                if (a.this.Zs()) {
                                    if (com.baidu.swan.apps.console.a.WU()) {
                                        com.baidu.swan.apps.console.a.k(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aAi().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void dD(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.k(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aAi().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bZz.setVisibility(this.bZz.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.Zs()) {
                                a.this.YU();
                            } else {
                                com.baidu.swan.apps.console.a.bD(a.this.getContext());
                            }
                        }
                    }
                });
                if (!Zs()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow bZC;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bZC == null) {
                                this.bZC = com.baidu.swan.apps.w.f.ajb().J(a.this.mActivity);
                            }
                            this.bZC.setVisibility(this.bZC.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.aga().er(a.this.RF())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.acr().acG()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(apQ.getVersion()) ? "" : apQ.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.iE(apN.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), apQ.ahJ());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(apQ.ahJ()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).ny(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).eY(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.apu();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (Zs()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String hi;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.Zs()) {
                                    hi = com.baidu.swan.apps.swancore.a.asW().hi(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    hi = com.baidu.swan.apps.swancore.a.asW().hi(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).ny(hi).a(new com.baidu.swan.apps.view.c.a()).eY(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.apu();
                            }
                        }
                    });
                }
                if (com.baidu.swan.apps.performance.i.amG().isAvailable()) {
                    View inflate3 = ((ViewStub) view.findViewById(a.f.ai_app_report_performance)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button2 = (Button) inflate3;
                        button2.setText(a.h.aiapps_debug_report_performance);
                        button2.setOnClickListener(new AnonymousClass5());
                    }
                }
                View inflate4 = ((ViewStub) view.findViewById(a.f.ai_app_start_inspector)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(a.h.aiapps_debug_start_inspect);
                }
                inflate4.setOnClickListener(new AnonymousClass6());
            }
            if ((aig == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : aig.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && aj.auY()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        aj.cA(a.this.getContext());
                        a.this.ba("click", "guarantee");
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$5  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                com.baidu.swan.apps.performance.i.amG().a(new i.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                    @Override // com.baidu.swan.apps.performance.i.a
                    public void jp(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.fe(a.h.aiapps_debug_report_performance).ny(str).a(new com.baidu.swan.apps.view.c.a()).eY(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.apu();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$6  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass6 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a bZJ;

        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.fe(a.h.aiapps_debug_start_inspect).fd(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).eY(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass6.this.bZJ = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.u.a.afX());
                        AnonymousClass6.this.bZJ.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass6.this.Zc();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass6.this.Zc();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.apu();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Zc() {
            if (this.bZJ != null) {
                this.bZJ.stop();
                this.bZJ = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YU() {
        if (com.baidu.swan.apps.runtime.e.apN() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.apN(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
                @Override // com.baidu.swan.apps.core.c.c.a
                public void h(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.R(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.WU()) {
                        com.baidu.swan.apps.console.a.bD(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aAi().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void dD(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bD(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aAi().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void eT(int i) {
        ag.a(this.bZs, this.bZt, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void UI() {
        FragmentActivity aIB = aIB();
        if (aIB != null && this.bZP == null) {
            this.bZP = new com.baidu.swan.menu.h(aIB, this.bZO, 13, com.baidu.swan.apps.u.a.agb(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bZP, this).akM();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void YV() {
        UI();
        this.bZP.show(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean UE() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean YW() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ui() {
        return false;
    }

    public static a YX() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            YY();
        } else if (id == a.f.aiapps_icon) {
            YZ();
        } else if (id == a.f.open_app_button) {
            Za();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.bZw);
            ba("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            Zb();
        }
    }

    private void YY() {
        e RN = RN();
        if (RN == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        RN.jx("navigateBack").ag(0, e.caC).aad().commit();
        ba("click", "aboutswan");
    }

    private void YZ() {
        System.arraycopy(this.bZv, 1, this.bZv, 0, this.bZv.length - 1);
        this.bZv[this.bZv.length - 1] = SystemClock.uptimeMillis();
        if (this.bZv[0] >= SystemClock.uptimeMillis() - 1000) {
            Ay();
        }
    }

    private void Za() {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN != null) {
            b.a apQ = apN.apQ();
            String ahZ = apQ.ahZ();
            String aia = apQ.aia();
            if (TextUtils.isEmpty(ahZ) || TextUtils.isEmpty(aia)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cd = aj.cd(ahZ, aia);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cd), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void Zb() {
        h.jA(this.bZy).jB(getString(a.h.swan_app_service_agreement)).dM(false).aao();
        ba("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bZw = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                this.bZx = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.bZw) && !TextUtils.isEmpty(this.bZx) && (length = this.bZx.length()) >= 20) {
                    if (length > 100) {
                        this.bZx = this.bZx.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.bZx);
                    ba("show", Constants.PHONE_BRAND);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Ay() {
        String str;
        b.a RP;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        int RF = RF();
        if (apM != null && RF != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion aiD = com.baidu.swan.apps.w.f.ajb().aiD();
            if (Zs()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(aiD, RF));
            sb.append("\n");
            if (RF == 0) {
                ExtensionCore acN = com.baidu.swan.apps.core.turbo.d.acr().acN();
                if (acN == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = acN.extensionCoreVersionName;
                    i = acN.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String TI = com.baidu.swan.apps.u.a.agj().TI();
            if (!TextUtils.isEmpty(TI) && TI.length() > 7) {
                TI = TI.substring(0, 7);
            }
            sb.append("commitId : ").append(TI);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.agj().TJ());
            sb.append("\n");
            sb.append("version : ").append(aj.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null && (RP = com.baidu.swan.apps.runtime.e.apM().RP()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.aga().er(RF())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.acr().acG()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(RP.getVersion()) ? "" : RP.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), RP.ahJ());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = RP.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String aAr = com.baidu.swan.games.c.d.aAi().aAr();
            if (!TextUtils.isEmpty(aAr)) {
                sb.append("app sconsole version: ").append(aAr).append("\n");
            }
            if (apM.aqf()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long Ty = com.baidu.swan.games.utils.so.d.Ty();
            sb.append("v8 so version: ").append(Ty).append(Ty < 0 ? "(old)" : "(new)").append("\n");
            if (!apM.aqf()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(t(0, com.baidu.swan.apps.core.turbo.d.acr().acG()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bZv = new long[5];
        }
    }

    private String t(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.af.a.a.anz() ? com.baidu.swan.apps.aq.h.A(i, true) : "" : (com.baidu.swan.apps.aq.h.auo() && com.baidu.swan.apps.u.a.aga().Sn()) ? com.baidu.swan.apps.aq.h.A(i, z) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(String str, String str2) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        if (!TextUtils.isEmpty(str)) {
            fVar.mType = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            fVar.mValue = str2;
        }
        a(fVar);
    }
}
