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
    private SwanAppRoundedImageView aJS;
    private BdBaseImageView aJT;
    private TextView aJU;
    private com.baidu.swan.apps.view.a aJV;
    private long[] aJW = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        U(inflate);
        W(inflate);
        if (EJ()) {
            inflate = Y(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aJV != null) {
            this.aJV.UM();
        }
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void U(View view) {
        X(view);
        cY(-1);
        cZ(ViewCompat.MEASURED_STATE_MASK);
        eu(null);
        bv(true);
    }

    private void W(View view) {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && Ra.AK() != null) {
            com.baidu.swan.apps.v.b.b AK = Ra.AK();
            this.aJS = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(AK.Hu());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(AK.Kv());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(AK.KA());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(AK.KB());
            this.aJU = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.aJT = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.aJS.setImageBitmap(ac.a(AK, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo KC = AK.KC();
            if (KC != null && KC.isValid()) {
                this.aJV = new com.baidu.swan.apps.view.a(this.mActivity, view, KC, a.f.bear_layout);
            }
            cX(com.baidu.swan.apps.ae.b.Ra().AK().getType());
            Ey();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.LE().Ll()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (EO() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(AK.KQ() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView aJX;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.aJX == null) {
                                    this.aJX = com.baidu.swan.apps.w.e.LE().E(a.this.mActivity);
                                }
                                if (a.this.EO()) {
                                    if (com.baidu.swan.apps.console.a.Dd()) {
                                        com.baidu.swan.apps.console.a.h(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.Wh().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void bs(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.h(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.Wh().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.aJX.setVisibility(this.aJX.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.EO()) {
                                a.this.Et();
                            } else {
                                com.baidu.swan.apps.console.a.aQ(a.this.getContext());
                            }
                        }
                    }
                });
                if (!EO()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow aKa;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.aKa == null) {
                                this.aKa = com.baidu.swan.apps.w.e.LE().F(a.this.mActivity);
                            }
                            this.aKa.setVisibility(this.aKa.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b Ra2;
                        if (a.this.mActivity != null && (Ra2 = com.baidu.swan.apps.ae.b.Ra()) != null && Ra2.AK() != null) {
                            com.baidu.swan.apps.v.b.b AK2 = Ra2.AK();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.Jm().Bs()).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.j.c.GP().Hb()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(AK2.getVersion()) ? "" : AK2.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.dS(Ra2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), AK2.KD());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(AK2.KD()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).hi(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).cv(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.Qv();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (EO()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String eN;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.EO()) {
                                    eN = com.baidu.swan.apps.swancore.a.SU().eN(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    eN = com.baidu.swan.apps.swancore.a.SU().eN(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.d(string).hi(eN).a(new com.baidu.swan.apps.view.b.a()).cv(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.Qv();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.ae.b.Ra(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
            @Override // com.baidu.swan.apps.core.c.c.a
            public void d(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.R(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Dd()) {
                    com.baidu.swan.apps.console.a.aQ(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.Wh().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void bs(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.aQ(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.Wh().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void cX(int i) {
        z.a(this.aJT, this.aJU, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        FragmentActivity abT = abT();
        if (abT != null && this.aKh == null) {
            this.aKh = new com.baidu.swan.menu.g(abT, this.aKg, 13, new com.baidu.swan.apps.view.b.b());
            this.aKh.setStatisticSource("tool");
            this.aKh.setMenuSource("swan");
            this.aKh.a(com.baidu.swan.apps.u.a.Jn());
            new com.baidu.swan.apps.view.coverview.c.b(this.aKh, this).Vl();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Ev() {
        Eu();
        this.aKh.m(com.baidu.swan.apps.u.a.JE().Kd(), ET());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ew() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Co() {
        return false;
    }

    public static a Ex() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b Ra;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e AI = AI();
            if (AI == null) {
                com.baidu.swan.apps.res.widget.b.d.i(this.mActivity, a.h.aiapps_open_fragment_failed_toast).QO();
            } else {
                AI.eC("navigateBack").F(0, e.aKU).Fz().commit();
            }
        } else if (id == a.f.open_app_button && (Ra = com.baidu.swan.apps.ae.b.Ra()) != null && Ra.AK() != null) {
            com.baidu.swan.apps.v.b.b AK = Ra.AK();
            String KM = AK.KM();
            String KN = AK.KN();
            if (TextUtils.isEmpty(KM) || TextUtils.isEmpty(KN)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String aV = ac.aV(KM, KN);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swan", new j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(aV), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void Ey() {
        if (this.aJS != null) {
            this.aJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.aJW, 1, a.this.aJW, 0, a.this.aJW.length - 1);
                    a.this.aJW[a.this.aJW.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.aJW[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.Ez();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        String str;
        com.baidu.swan.apps.v.b.b AK;
        String str2;
        int i;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        int AC = AC();
        if (Ra != null && AC != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Lj = com.baidu.swan.apps.w.e.LE().Lj();
            if (EO()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Lj, AC));
            sb.append("\n");
            if (AC == 0) {
                ExtensionCore Hi = com.baidu.swan.apps.core.j.c.GP().Hi();
                if (Hi == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = Hi.aQn;
                    i = Hi.aQl;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String BO = com.baidu.swan.apps.u.a.Jv().BO();
            if (!TextUtils.isEmpty(BO) && BO.length() > 7) {
                BO = BO.substring(0, 7);
            }
            sb.append("commitId : ").append(BO);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.Jv().BP());
            sb.append("\n");
            sb.append("version : ").append(ac.X(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.Ra() != null && com.baidu.swan.apps.ae.b.Ra().AK() != null && (AK = com.baidu.swan.apps.ae.b.Ra().AK()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.Jm().Bs()).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.j.c.GP().Hb()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(AK.getVersion()) ? "" : AK.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), AK.KD());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = AK.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String Wp = com.baidu.swan.games.c.a.b.Wh().Wp();
            if (!TextUtils.isEmpty(Wp)) {
                sb.append("app sconsole version: ").append(Wp).append("\n");
            }
            if (Ra.Rn()) {
                sb.append("game engine version: ").append("1.1.1.92").append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).QP();
            this.aJW = new long[5];
        }
    }
}
