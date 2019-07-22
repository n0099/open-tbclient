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
    private long[] aqA = new long[5];
    private SwanAppRoundedImageView aqw;
    private BdBaseImageView aqx;
    private TextView aqy;
    private com.baidu.swan.apps.view.a aqz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        O(inflate);
        Q(inflate);
        if (zJ()) {
            inflate = S(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aqz != null) {
            this.aqz.PU();
        }
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void O(View view) {
        R(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        dK(null);
        bd(true);
    }

    private void Q(View view) {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null && Md.vL() != null) {
            com.baidu.swan.apps.v.b.b vL = Md.vL();
            this.aqw = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(vL.Cv());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(vL.Fw());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(vL.FB());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(vL.FC());
            this.aqy = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.aqx = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.aqw.setImageBitmap(ac.a(vL, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo FD = vL.FD();
            if (FD != null && FD.isValid()) {
                this.aqz = new com.baidu.swan.apps.view.a(this.mActivity, view, FD, a.f.bear_layout);
            }
            ca(com.baidu.swan.apps.ae.b.Md().vL().getType());
            zy();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.GF().Gm()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (zO() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(vL.FR() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView aqB;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.aqB == null) {
                                    this.aqB = com.baidu.swan.apps.w.e.GF().F(a.this.mActivity);
                                }
                                if (a.this.zO()) {
                                    if (com.baidu.swan.apps.console.a.yd()) {
                                        com.baidu.swan.apps.console.a.h(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.Ro().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void ba(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.h(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.Ro().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.aqB.setVisibility(this.aqB.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.zO()) {
                                a.this.zt();
                            } else {
                                com.baidu.swan.apps.console.a.aO(a.this.getContext());
                            }
                        }
                    }
                });
                if (!zO()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow aqE;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.aqE == null) {
                                this.aqE = com.baidu.swan.apps.w.e.GF().G(a.this.mActivity);
                            }
                            this.aqE.setVisibility(this.aqE.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b Md2;
                        if (a.this.mActivity != null && (Md2 = com.baidu.swan.apps.ae.b.Md()) != null && Md2.vL() != null) {
                            com.baidu.swan.apps.v.b.b vL2 = Md2.vL();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.En().wt()).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.j.c.BQ().Cc()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(vL2.getVersion()) ? "" : vL2.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.dh(Md2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), vL2.FE());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(vL2.FE()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).gC(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).ce(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.Lx();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (zO()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String dR;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.zO()) {
                                    dR = com.baidu.swan.apps.swancore.a.NY().dR(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    dR = com.baidu.swan.apps.swancore.a.NY().dR(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.d(string).gC(dR).a(new com.baidu.swan.apps.view.b.a()).ce(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.Lx();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.ae.b.Md(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
            @Override // com.baidu.swan.apps.core.c.c.a
            public void c(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.S(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.yd()) {
                    com.baidu.swan.apps.console.a.aO(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.Ro().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void ba(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.aO(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.Ro().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void ca(int i) {
        z.a(this.aqx, this.aqy, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zu() {
        FragmentActivity Xc = Xc();
        if (Xc != null && this.aqL == null) {
            this.aqL = new com.baidu.swan.menu.g(Xc, this.aqK, 13, new com.baidu.swan.apps.view.b.b());
            this.aqL.setStatisticSource("tool");
            this.aqL.setMenuSource("swan");
            this.aqL.a(com.baidu.swan.apps.u.a.Eo());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqL, this).Qt();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void zv() {
        zu();
        this.aqL.i(com.baidu.swan.apps.u.a.EF().Fe(), zT());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xD() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean zw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean xp() {
        return false;
    }

    public static a zx() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b Md;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e vJ = vJ();
            if (vJ == null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).LQ();
            } else {
                vJ.dS("navigateBack").B(0, e.arx).Az().commit();
            }
        } else if (id == a.f.open_app_button && (Md = com.baidu.swan.apps.ae.b.Md()) != null && Md.vL() != null) {
            com.baidu.swan.apps.v.b.b vL = Md.vL();
            String FN = vL.FN();
            String FO = vL.FO();
            if (TextUtils.isEmpty(FN) || TextUtils.isEmpty(FO)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String aO = ac.aO(FN, FO);
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

    private void zy() {
        if (this.aqw != null) {
            this.aqw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.aqA, 1, a.this.aqA, 0, a.this.aqA.length - 1);
                    a.this.aqA[a.this.aqA.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.aqA[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.zz();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz() {
        String str;
        com.baidu.swan.apps.v.b.b vL;
        String str2;
        int i;
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        int vD = vD();
        if (Md != null && vD != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Gk = com.baidu.swan.apps.w.e.GF().Gk();
            if (zO()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Gk, vD));
            sb.append("\n");
            if (vD == 0) {
                ExtensionCore Cj = com.baidu.swan.apps.core.j.c.BQ().Cj();
                if (Cj == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = Cj.awS;
                    i = Cj.awQ;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String wP = com.baidu.swan.apps.u.a.Ew().wP();
            if (!TextUtils.isEmpty(wP) && wP.length() > 7) {
                wP = wP.substring(0, 7);
            }
            sb.append("commitId : ").append(wP);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.Ew().wQ());
            sb.append("\n");
            sb.append("version : ").append(ac.Y(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.Md() != null && com.baidu.swan.apps.ae.b.Md().vL() != null && (vL = com.baidu.swan.apps.ae.b.Md().vL()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.En().wt()).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.j.c.BQ().Cc()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(vL.getVersion()) ? "" : vL.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), vL.FE());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = vL.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String Rw = com.baidu.swan.games.c.a.b.Ro().Rw();
            if (!TextUtils.isEmpty(Rw)) {
                sb.append("app sconsole version: ").append(Rw).append("\n");
            }
            if (Md.Mp()) {
                sb.append("game engine version: ").append("1.1.1.92").append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).LR();
            this.aqA = new long[5];
        }
    }
}
