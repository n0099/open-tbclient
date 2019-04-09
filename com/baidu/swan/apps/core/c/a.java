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
    private Button apH;
    private SwanAppRoundedImageView apI;
    private TextView apJ;
    private TextView apK;
    private TextView apL;
    private TextView apM;
    private BdBaseImageView apN;
    private TextView apO;
    private Button apP;
    private com.baidu.swan.apps.view.a apQ;
    private long[] apR = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        M(inflate);
        O(inflate);
        if (yi()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.c.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.apQ != null) {
            this.apQ.Mu();
        }
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public void M(View view) {
        P(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        dT(null);
        aW(true);
    }

    private void O(View view) {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null && IV.uA() != null) {
            com.baidu.swan.apps.v.b.b uA = IV.uA();
            this.apI = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            this.apJ = (TextView) view.findViewById(a.f.aiapps_title);
            this.apK = (TextView) view.findViewById(a.f.aiapps_description);
            this.apL = (TextView) view.findViewById(a.f.service_category_value);
            this.apM = (TextView) view.findViewById(a.f.subject_info_value);
            this.apO = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.apN = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.apI.setImageBitmap(aa.a(uA, "SwanAppAboutFragment", false));
            this.apJ.setText(uA.axH);
            this.apK.setText(uA.mDescription);
            this.apL.setText(uA.axR);
            this.apM.setText(uA.axS);
            this.apH = (Button) view.findViewById(a.f.into_aiapps_button);
            this.apH.setOnClickListener(this);
            if (uA.axT != null && uA.axT.isValid()) {
                this.apQ = new com.baidu.swan.apps.view.a(this.mActivity, view, uA.axT, a.f.bear_layout);
            }
            ca(com.baidu.swan.apps.ae.b.IV().uA().mType);
            xZ();
            this.apP = (Button) view.findViewById(a.f.open_app_button);
            this.apP.setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.Ea().DH()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (yn() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(uA.ayc ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.1
                    FullScreenFloatView apS;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.apS == null) {
                                    this.apS = com.baidu.swan.apps.w.e.Ea().C(a.this.mActivity);
                                }
                                if (a.this.yn()) {
                                    if (com.baidu.swan.apps.console.a.wH()) {
                                        com.baidu.swan.apps.console.a.j(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.ND().a(new b.a() { // from class: com.baidu.swan.apps.core.c.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void aV(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.j(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.ND().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.apS.setVisibility(this.apS.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.yn()) {
                                a.this.xU();
                            } else {
                                com.baidu.swan.apps.console.a.bv(a.this.getContext());
                            }
                        }
                    }
                });
                if (!yn()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.2
                        SwanAppPropertyWindow apV;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.apV == null) {
                                this.apV = com.baidu.swan.apps.w.e.Ea().D(a.this.mActivity);
                            }
                            this.apV.setVisibility(this.apV.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b IV2;
                        if (a.this.mActivity != null && (IV2 = com.baidu.swan.apps.ae.b.IV()) != null && IV2.uA() != null) {
                            com.baidu.swan.apps.v.b.b uA2 = IV2.uA();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.i.c.Aa().Am()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(uA2.mVersion) ? "" : uA2.mVersion).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.dq(IV2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), uA2.auj);
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(uA2.auj).append(")").append("\n");
                            e.a aVar = new e.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).ge(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).bR(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.Is();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (yn()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String dD;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.yn()) {
                                    dD = com.baidu.swan.apps.swancore.a.KK().dD(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    dD = com.baidu.swan.apps.swancore.a.KK().dD(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                e.a aVar = new e.a(a.this.mActivity);
                                aVar.d(string).ge(dD).a(new com.baidu.swan.apps.view.b.a()).bR(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.Is();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU() {
        com.baidu.swan.apps.core.b.c.a(com.baidu.swan.apps.ae.b.IV(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.c.a.5
            @Override // com.baidu.swan.apps.core.b.c.a
            public void c(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.b.c.af(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.wH()) {
                    com.baidu.swan.apps.console.a.bv(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.ND().a(new b.a() { // from class: com.baidu.swan.apps.core.c.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void aV(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.bv(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.ND().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void ca(int i) {
        x.a(this.apN, this.apO, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xV() {
        FragmentActivity Sw = Sw();
        if (Sw != null && this.aqc == null) {
            this.aqc = new com.baidu.swan.menu.h(Sw, this.aqb, 13, new com.baidu.swan.apps.view.b.b());
            this.aqc.setStatisticSource("tool");
            this.aqc.setMenuSource("swan");
            this.aqc.a(com.baidu.swan.apps.u.a.CA());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqc, this).MS();
        }
    }

    @Override // com.baidu.swan.apps.core.c.b
    protected void xW() {
        xV();
        this.aqc.i(com.baidu.swan.apps.u.a.CR().Dq(), ys());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.c.b
    public boolean xX() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.c.b
    public boolean vX() {
        return false;
    }

    public static a xY() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b IV;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e uy = uy();
            if (uy == null) {
                com.baidu.swan.apps.res.widget.b.d.l(this.mActivity, a.h.aiapps_open_fragment_failed_toast).II();
            } else {
                uy.ea("navigateBack").A(0, e.aqP).yV().commit();
            }
        } else if (id == a.f.open_app_button && (IV = com.baidu.swan.apps.ae.b.IV()) != null && IV.uA() != null) {
            com.baidu.swan.apps.v.b.b uA = IV.uA();
            String str = uA.axY;
            String str2 = uA.axZ;
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

    private void xZ() {
        if (this.apI != null) {
            this.apI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.c.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.apR, 1, a.this.apR, 0, a.this.apR.length - 1);
                    a.this.apR[a.this.apR.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.apR[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.ya();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        String str;
        String str2;
        int i;
        com.baidu.swan.apps.v.b.b uA;
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        int us = us();
        if (IV != null && us != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion DF = com.baidu.swan.apps.w.e.Ea().DF();
            if (yn()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(DF, us));
            sb.append("\n");
            ExtensionCore As = com.baidu.swan.apps.core.i.c.Aa().As();
            if (As == null) {
                str2 = "";
                i = -1;
            } else {
                str2 = As.avQ;
                i = As.avO;
            }
            sb.append("extension-core version : ").append(str2).append("   type：").append(i);
            sb.append("\n");
            String vz = com.baidu.swan.apps.u.a.CI().vz();
            if (!TextUtils.isEmpty(vz) && vz.length() > 7) {
                vz = vz.substring(0, 7);
            }
            sb.append("commitId : ").append(vz);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.CI().vA());
            sb.append("\n");
            sb.append("version : ").append(aa.am(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.IV() != null && com.baidu.swan.apps.ae.b.IV().uA() != null && (uA = com.baidu.swan.apps.ae.b.IV().uA()) != null) {
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.i.c.Aa().Am()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(uA.mVersion) ? "" : uA.mVersion).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), uA.auj);
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String str3 = uA.aul;
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                append2.append(str3).append("\n");
            }
            String NL = com.baidu.swan.games.c.a.b.ND().NL();
            if (!TextUtils.isEmpty(NL)) {
                sb.append("app sconsole version: ").append(NL).append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).IJ();
            this.apR = new long[5];
        }
    }
}
