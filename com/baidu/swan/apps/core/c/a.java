package com.baidu.swan.apps.core.c;

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
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.b.c;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.games.c.a.b;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class a extends b implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Button apC;
    private SwanAppRoundedImageView apD;
    private TextView apE;
    private TextView apF;
    private TextView apG;
    private TextView apH;
    private BdBaseImageView apI;
    private TextView apJ;
    private Button apK;
    private com.baidu.swan.apps.view.a apL;
    private long[] apM = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        M(inflate);
        O(inflate);
        if (yj()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.apL != null) {
            this.apL.Mw();
        }
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        P(view);
        cc(-1);
        cd(ViewCompat.MEASURED_STATE_MASK);
        dR(null);
        aW(true);
    }

    private void O(View view) {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null && IX.uB() != null) {
            com.baidu.swan.apps.v.b.b uB = IX.uB();
            this.apD = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            this.apE = (TextView) view.findViewById(a.f.aiapps_title);
            this.apF = (TextView) view.findViewById(a.f.aiapps_description);
            this.apG = (TextView) view.findViewById(a.f.service_category_value);
            this.apH = (TextView) view.findViewById(a.f.subject_info_value);
            this.apJ = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.apI = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.apD.setImageBitmap(aa.a(uB, "SwanAppAboutFragment", false));
            this.apE.setText(uB.axD);
            this.apF.setText(uB.mDescription);
            this.apG.setText(uB.axN);
            this.apH.setText(uB.axO);
            this.apC = (Button) view.findViewById(a.f.into_aiapps_button);
            this.apC.setOnClickListener(this);
            if (uB.axP != null && uB.axP.isValid()) {
                this.apL = new com.baidu.swan.apps.view.a(this.mActivity, view, uB.axP, a.f.bear_layout);
            }
            cb(com.baidu.swan.apps.ae.b.IX().uB().mType);
            ya();
            this.apK = (Button) view.findViewById(a.f.open_app_button);
            this.apK.setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.Ec().DJ()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (yo() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(uB.axY ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.1
                    FullScreenFloatView apN;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.apN == null) {
                                    this.apN = com.baidu.swan.apps.w.e.Ec().C(a.this.mActivity);
                                }
                                if (a.this.yo()) {
                                    if (com.baidu.swan.apps.console.a.wI()) {
                                        com.baidu.swan.apps.console.a.j(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.NF().a(new b.a() { // from class: com.baidu.swan.apps.core.c.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void aV(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.j(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.NF().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.apN.setVisibility(this.apN.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.yo()) {
                                a.this.xV();
                            } else {
                                com.baidu.swan.apps.console.a.bv(a.this.getContext());
                            }
                        }
                    }
                });
                if (!yo()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.2
                        SwanAppPropertyWindow apQ;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.apQ == null) {
                                this.apQ = com.baidu.swan.apps.w.e.Ec().D(a.this.mActivity);
                            }
                            this.apQ.setVisibility(this.apQ.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b IX2;
                        if (a.this.mActivity != null && (IX2 = com.baidu.swan.apps.ae.b.IX()) != null && IX2.uB() != null) {
                            com.baidu.swan.apps.v.b.b uB2 = IX2.uB();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.i.c.Ab().An()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(uB2.mVersion) ? "" : uB2.mVersion).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.m14do(IX2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), uB2.aue);
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(uB2.aue).append(")").append("\n");
                            e.a aVar = new e.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).gd(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).bR(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.Iu();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (yo()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String dE;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.yo()) {
                                    dE = com.baidu.swan.apps.swancore.a.KM().dE(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    dE = com.baidu.swan.apps.swancore.a.KM().dE(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                e.a aVar = new e.a(a.this.mActivity);
                                aVar.d(string).gd(dE).a(new com.baidu.swan.apps.view.b.a()).bR(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.Iu();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xV() {
        com.baidu.swan.apps.core.b.c.a(com.baidu.swan.apps.ae.b.IX(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.c.a.5
            @Override // com.baidu.swan.apps.core.b.c.a
            public void c(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.b.c.af(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.wI()) {
                    com.baidu.swan.apps.console.a.bv(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.NF().a(new b.a() { // from class: com.baidu.swan.apps.core.c.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void aV(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bv(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.NF().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void cb(int i) {
        x.a(this.apI, this.apJ, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        FragmentActivity Sy = Sy();
        if (Sy != null && this.apX == null) {
            this.apX = new com.baidu.swan.menu.h(Sy, this.apW, 13, new com.baidu.swan.apps.view.b.b());
            this.apX.setStatisticSource("tool");
            this.apX.setMenuSource("swan");
            this.apX.a(com.baidu.swan.apps.u.a.CC());
            new com.baidu.swan.apps.view.coverview.c.b(this.apX, this).MU();
        }
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xX() {
        xW();
        this.apX.i(com.baidu.swan.apps.u.a.CT().Ds(), yt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xY() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vY() {
        return false;
    }

    public static a xZ() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b IX;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e uz = uz();
            if (uz == null) {
                com.baidu.swan.apps.res.widget.b.d.l(this.mActivity, a.h.aiapps_open_fragment_failed_toast).IK();
            } else {
                uz.dY("navigateBack").A(0, e.aqK).yW().commit();
            }
        } else if (id == a.f.open_app_button && (IX = com.baidu.swan.apps.ae.b.IX()) != null && IX.uB() != null) {
            com.baidu.swan.apps.v.b.b uB = IX.uB();
            String str = uB.axU;
            String str2 = uB.axV;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String aL = aa.aL(str, str2);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swan", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(aL), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void ya() {
        if (this.apD != null) {
            this.apD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.apM, 1, a.this.apM, 0, a.this.apM.length - 1);
                    a.this.apM[a.this.apM.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.apM[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.yb();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        String str;
        String str2;
        int i;
        com.baidu.swan.apps.v.b.b uB;
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        int ut = ut();
        if (IX != null && ut != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion DH = com.baidu.swan.apps.w.e.Ec().DH();
            if (yo()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(DH, ut));
            sb.append("\n");
            ExtensionCore At = com.baidu.swan.apps.core.i.c.Ab().At();
            if (At == null) {
                str2 = "";
                i = -1;
            } else {
                str2 = At.avM;
                i = At.avK;
            }
            sb.append("extension-core version : ").append(str2).append("   type：").append(i);
            sb.append("\n");
            String vA = com.baidu.swan.apps.u.a.CK().vA();
            if (!TextUtils.isEmpty(vA) && vA.length() > 7) {
                vA = vA.substring(0, 7);
            }
            sb.append("commitId : ").append(vA);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.CK().vB());
            sb.append("\n");
            sb.append("version : ").append(aa.am(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.IX() != null && com.baidu.swan.apps.ae.b.IX().uB() != null && (uB = com.baidu.swan.apps.ae.b.IX().uB()) != null) {
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.i.c.Ab().An()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(uB.mVersion) ? "" : uB.mVersion).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), uB.aue);
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String str3 = uB.aug;
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                append2.append(str3).append("\n");
            }
            String NN = com.baidu.swan.games.c.a.b.NF().NN();
            if (!TextUtils.isEmpty(NN)) {
                sb.append("app sconsole version: ").append(NN).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).IL();
            this.apM = new long[5];
        }
    }
}
