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
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
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
import com.baidu.swan.games.c.a.b;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class a extends b implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView aqU;
    private BdBaseImageView aqV;
    private TextView aqW;
    private com.baidu.swan.apps.view.a aqX;
    private long[] aqY = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        O(inflate);
        Q(inflate);
        if (zN()) {
            inflate = S(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aqX != null) {
            this.aqX.PY();
        }
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
        R(view);
        cc(-1);
        cd(ViewCompat.MEASURED_STATE_MASK);
        dM(null);
        bd(true);
    }

    private void Q(View view) {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null && Mh.vP() != null) {
            com.baidu.swan.apps.v.b.b vP = Mh.vP();
            this.aqU = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(vP.Cz());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(vP.FA());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(vP.FF());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(vP.FG());
            this.aqW = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.aqV = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.aqU.setImageBitmap(ac.a(vP, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo FH = vP.FH();
            if (FH != null && FH.isValid()) {
                this.aqX = new com.baidu.swan.apps.view.a(this.mActivity, view, FH, a.f.bear_layout);
            }
            cb(com.baidu.swan.apps.ae.b.Mh().vP().getType());
            zC();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.GJ().Gq()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (zS() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(vP.FV() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView aqZ;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.aqZ == null) {
                                    this.aqZ = com.baidu.swan.apps.w.e.GJ().F(a.this.mActivity);
                                }
                                if (a.this.zS()) {
                                    if (com.baidu.swan.apps.console.a.yh()) {
                                        com.baidu.swan.apps.console.a.h(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.Rs().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void ba(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.h(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.Rs().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.aqZ.setVisibility(this.aqZ.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.zS()) {
                                a.this.zx();
                            } else {
                                com.baidu.swan.apps.console.a.aO(a.this.getContext());
                            }
                        }
                    }
                });
                if (!zS()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow arc;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.arc == null) {
                                this.arc = com.baidu.swan.apps.w.e.GJ().G(a.this.mActivity);
                            }
                            this.arc.setVisibility(this.arc.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b Mh2;
                        if (a.this.mActivity != null && (Mh2 = com.baidu.swan.apps.ae.b.Mh()) != null && Mh2.vP() != null) {
                            com.baidu.swan.apps.v.b.b vP2 = Mh2.vP();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.Er().wx()).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.j.c.BU().Cg()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(vP2.getVersion()) ? "" : vP2.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.dj(Mh2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), vP2.FI());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(vP2.FI()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).gE(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).ce(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.LB();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (zS()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String dS;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.zS()) {
                                    dS = com.baidu.swan.apps.swancore.a.Oc().dS(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    dS = com.baidu.swan.apps.swancore.a.Oc().dS(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.d(string).gE(dS).a(new com.baidu.swan.apps.view.b.a()).ce(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.LB();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zx() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.ae.b.Mh(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
            @Override // com.baidu.swan.apps.core.c.c.a
            public void c(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.S(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.yh()) {
                    com.baidu.swan.apps.console.a.aO(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.Rs().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void ba(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.aO(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.Rs().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void cb(int i) {
        z.a(this.aqV, this.aqW, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zy() {
        FragmentActivity Xg = Xg();
        if (Xg != null && this.arj == null) {
            this.arj = new com.baidu.swan.menu.g(Xg, this.ari, 13, new com.baidu.swan.apps.view.b.b());
            this.arj.setStatisticSource("tool");
            this.arj.setMenuSource("swan");
            this.arj.a(com.baidu.swan.apps.u.a.Es());
            new com.baidu.swan.apps.view.coverview.c.b(this.arj, this).Qx();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zz() {
        zy();
        this.arj.i(com.baidu.swan.apps.u.a.EJ().Fi(), zX());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xH() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zA() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xt() {
        return false;
    }

    public static a zB() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b Mh;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e vN = vN();
            if (vN == null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).LU();
            } else {
                vN.dU("navigateBack").B(0, e.arV).AD().commit();
            }
        } else if (id == a.f.open_app_button && (Mh = com.baidu.swan.apps.ae.b.Mh()) != null && Mh.vP() != null) {
            com.baidu.swan.apps.v.b.b vP = Mh.vP();
            String FR = vP.FR();
            String FS = vP.FS();
            if (TextUtils.isEmpty(FR) || TextUtils.isEmpty(FS)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String aO = ac.aO(FR, FS);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swan", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(aO), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void zC() {
        if (this.aqU != null) {
            this.aqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.aqY, 1, a.this.aqY, 0, a.this.aqY.length - 1);
                    a.this.aqY[a.this.aqY.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.aqY[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.zD();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zD() {
        String str;
        com.baidu.swan.apps.v.b.b vP;
        String str2;
        int i;
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        int vH = vH();
        if (Mh != null && vH != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Go = com.baidu.swan.apps.w.e.GJ().Go();
            if (zS()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Go, vH));
            sb.append("\n");
            if (vH == 0) {
                ExtensionCore Cn = com.baidu.swan.apps.core.j.c.BU().Cn();
                if (Cn == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = Cn.axq;
                    i = Cn.axo;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String wT = com.baidu.swan.apps.u.a.EA().wT();
            if (!TextUtils.isEmpty(wT) && wT.length() > 7) {
                wT = wT.substring(0, 7);
            }
            sb.append("commitId : ").append(wT);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.EA().wU());
            sb.append("\n");
            sb.append("version : ").append(ac.Y(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null && (vP = com.baidu.swan.apps.ae.b.Mh().vP()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.Er().wx()).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.j.c.BU().Cg()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(vP.getVersion()) ? "" : vP.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), vP.FI());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = vP.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String RA = com.baidu.swan.games.c.a.b.Rs().RA();
            if (!TextUtils.isEmpty(RA)) {
                sb.append("app sconsole version: ").append(RA).append("\n");
            }
            if (Mh.Mt()) {
                sb.append("game engine version: ").append("1.1.1.92").append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).LV();
            this.aqY = new long[5];
        }
    }
}
