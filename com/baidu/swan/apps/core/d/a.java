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
    private SwanAppRoundedImageView bUD;
    private BdBaseImageView bUE;
    private TextView bUF;
    private com.baidu.swan.apps.view.a bUG;
    private long[] bUH = new long[5];
    private String bUI;
    private String bUJ;
    private String bUK;

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
        if (this.bUG != null) {
            this.bUG.aui();
        }
        setRequestedOrientation(1);
        if (this.bVb != null && this.bVb.isShowing()) {
            this.bVb.gc(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void ae(View view) {
        ah(view);
        dz(true);
        eJ(-1);
        eK(ViewCompat.MEASURED_STATE_MASK);
        ji(null);
        dC(true);
    }

    private void ag(View view) {
        final com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG != null && aoG.aoJ() != null) {
            final b.a aoJ = aoG.aoJ();
            this.bUD = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(aoJ.abT());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aoJ.agv());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aoJ.agA());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aoJ.agB());
            this.bUK = com.baidu.swan.apps.u.a.afd().SK();
            if (!TextUtils.isEmpty(this.bUK)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            PMSAppInfo aha = aoJ.aha();
            if (aoG.Qz() == 0 && aha != null && !TextUtils.isEmpty(aha.brandsInfo)) {
                e(view, aha.brandsInfo);
            }
            this.bUF = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.bUE = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.bUD.setImageBitmap(aj.a((com.baidu.swan.apps.v.b.b) aoJ, "SwanAppAboutFragment", false));
            this.bUD.setOnClickListener(this);
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo agC = aoJ.agC();
            if (agC != null && agC.isValid()) {
                this.bUG = new com.baidu.swan.apps.view.a(this.mActivity, view, agC, a.f.bear_layout);
            }
            eI(aoJ.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.f.ahV().ahz()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (Ym() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aoJ.agW() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView bUL;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.bUL == null) {
                                    this.bUL = com.baidu.swan.apps.w.f.ahV().I(a.this.mActivity);
                                }
                                if (a.this.Ym()) {
                                    if (com.baidu.swan.apps.console.a.VO()) {
                                        com.baidu.swan.apps.console.a.k(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.azc().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void dy(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.k(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.azc().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.bUL.setVisibility(this.bUL.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.Ym()) {
                                a.this.XO();
                            } else {
                                com.baidu.swan.apps.console.a.bC(a.this.getContext());
                            }
                        }
                    }
                });
                if (!Ym()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow bUO;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.bUO == null) {
                                this.bUO = com.baidu.swan.apps.w.f.ahV().J(a.this.mActivity);
                            }
                            this.bUO.setVisibility(this.bUO.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.aeU().eg(a.this.Qz())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.abl().abA()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aoJ.getVersion()) ? "" : aoJ.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.iw(aoG.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aoJ.agD());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aoJ.agD()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).nq(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).eT(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aon();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (Ym()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String gX;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.Ym()) {
                                    gX = com.baidu.swan.apps.swancore.a.arP().gX(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    gX = com.baidu.swan.apps.swancore.a.arP().gX(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).nq(gX).a(new com.baidu.swan.apps.view.c.a()).eT(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aon();
                            }
                        }
                    });
                }
                if (com.baidu.swan.apps.performance.i.alA().isAvailable()) {
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
            if ((aha == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : aha.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && aj.atS()) {
                ((LinearLayout) view.findViewById(a.f.guarantee_fl)).setVisibility(0);
                ((TextView) view.findViewById(a.f.apply_guarantee_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        aj.cz(a.this.getContext());
                        a.this.aY("click", "guarantee");
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
                com.baidu.swan.apps.performance.i.alA().a(new i.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                    @Override // com.baidu.swan.apps.performance.i.a
                    public void jh(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.eT(a.h.aiapps_debug_report_performance).nq(str).a(new com.baidu.swan.apps.view.c.a()).eT(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aon();
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
        com.baidu.swan.apps.console.v8inspector.a bUV;

        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.eT(a.h.aiapps_debug_start_inspect).eS(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).eT(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass6.this.bUV = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.u.a.aeR());
                        AnonymousClass6.this.bUV.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass6.this.XW();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass6.this.XW();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aon();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void XW() {
            if (this.bUV != null) {
                this.bUV.stop();
                this.bUV = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XO() {
        if (com.baidu.swan.apps.runtime.e.aoG() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aoG(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.8
                @Override // com.baidu.swan.apps.core.c.c.a
                public void g(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.R(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.VO()) {
                        com.baidu.swan.apps.console.a.bC(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.azc().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void dy(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bC(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.azc().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void eI(int i) {
        ag.a(this.bUE, this.bUF, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void TC() {
        FragmentActivity aHv = aHv();
        if (aHv != null && this.bVb == null) {
            this.bVb = new com.baidu.swan.menu.h(aHv, this.bVa, 13, com.baidu.swan.apps.u.a.aeV(), new com.baidu.swan.apps.view.c.b());
            new com.baidu.swan.apps.y.a(this.bVb, this).ajG();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void XP() {
        TC();
        this.bVb.show(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean Ty() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean XQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Tc() {
        return false;
    }

    public static a XR() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            XS();
        } else if (id == a.f.aiapps_icon) {
            XT();
        } else if (id == a.f.open_app_button) {
            XU();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.bUI);
            aY("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            XV();
        }
    }

    private void XS() {
        e QH = QH();
        if (QH == null) {
            com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).showToast();
            return;
        }
        QH.jp("navigateBack").ae(0, e.bVO).YX().commit();
        aY("click", "aboutswan");
    }

    private void XT() {
        System.arraycopy(this.bUH, 1, this.bUH, 0, this.bUH.length - 1);
        this.bUH[this.bUH.length - 1] = SystemClock.uptimeMillis();
        if (this.bUH[0] >= SystemClock.uptimeMillis() - 1000) {
            zY();
        }
    }

    private void XU() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG != null) {
            b.a aoJ = aoG.aoJ();
            String agT = aoJ.agT();
            String agU = aoJ.agU();
            if (TextUtils.isEmpty(agT) || TextUtils.isEmpty(agU)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cb = aj.cb(agT, agU);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cb), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void XV() {
        h.js(this.bUK).jt(getString(a.h.swan_app_service_agreement)).dH(false).Zi();
        aY("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.bUI = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                this.bUJ = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.bUI) && !TextUtils.isEmpty(this.bUJ) && (length = this.bUJ.length()) >= 20) {
                    if (length > 100) {
                        this.bUJ = this.bUJ.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.bUJ);
                    aY("show", Constants.PHONE_BRAND);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void zY() {
        String str;
        b.a QJ;
        String str2;
        int i;
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        int Qz = Qz();
        if (aoF != null && Qz != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion ahx = com.baidu.swan.apps.w.f.ahV().ahx();
            if (Ym()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(ahx, Qz));
            sb.append("\n");
            if (Qz == 0) {
                ExtensionCore abH = com.baidu.swan.apps.core.turbo.d.abl().abH();
                if (abH == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = abH.extensionCoreVersionName;
                    i = abH.extensionCoreType;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String SC = com.baidu.swan.apps.u.a.afd().SC();
            if (!TextUtils.isEmpty(SC) && SC.length() > 7) {
                SC = SC.substring(0, 7);
            }
            sb.append("commitId : ").append(SC);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.afd().SD());
            sb.append("\n");
            sb.append("version : ").append(aj.getPackageVersion(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null && (QJ = com.baidu.swan.apps.runtime.e.aoF().QJ()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.aeU().eg(Qz())).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.turbo.d.abl().abA()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(QJ.getVersion()) ? "" : QJ.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), QJ.agD());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = QJ.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String azl = com.baidu.swan.games.c.d.azc().azl();
            if (!TextUtils.isEmpty(azl)) {
                sb.append("app sconsole version: ").append(azl).append("\n");
            }
            if (aoF.aoY()) {
                sb.append("game engine version: ").append("1.0.0.1").append("\n");
            }
            long Ss = com.baidu.swan.games.utils.so.d.Ss();
            sb.append("v8 so version: ").append(Ss).append(Ss < 0 ? "(old)" : "(new)").append("\n");
            if (!aoF.aoY()) {
                sb.append("jsNativeEnble: ").append(!TextUtils.isEmpty(r(0, com.baidu.swan.apps.core.turbo.d.abl().abA()))).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).showMultiToast();
            this.bUH = new long[5];
        }
    }

    private String r(int i, boolean z) {
        return DEBUG ? com.baidu.swan.apps.af.a.a.amt() ? com.baidu.swan.apps.aq.h.z(i, true) : "" : (com.baidu.swan.apps.aq.h.ati() && com.baidu.swan.apps.u.a.aeU().Rh()) ? com.baidu.swan.apps.aq.h.z(i, z) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, String str2) {
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
