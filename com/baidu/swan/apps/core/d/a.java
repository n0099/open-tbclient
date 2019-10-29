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
    private SwanAppRoundedImageView aKk;
    private BdBaseImageView aKl;
    private TextView aKm;
    private com.baidu.swan.apps.view.a aKn;
    private long[] aKo = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        U(inflate);
        W(inflate);
        if (EI()) {
            inflate = Y(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.aKn != null) {
            this.aKn.UO();
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
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null && QZ.AJ() != null) {
            com.baidu.swan.apps.v.b.b AJ = QZ.AJ();
            this.aKk = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(AJ.Ht());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(AJ.Ku());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(AJ.Kz());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(AJ.KA());
            this.aKm = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.aKl = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.aKk.setImageBitmap(ac.a(AJ, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo KB = AJ.KB();
            if (KB != null && KB.isValid()) {
                this.aKn = new com.baidu.swan.apps.view.a(this.mActivity, view, KB, a.f.bear_layout);
            }
            cX(com.baidu.swan.apps.ae.b.QZ().AJ().getType());
            Ex();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.LD().Lk()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (EN() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(AJ.KP() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView aKp;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.aKp == null) {
                                    this.aKp = com.baidu.swan.apps.w.e.LD().E(a.this.mActivity);
                                }
                                if (a.this.EN()) {
                                    if (com.baidu.swan.apps.console.a.Dc()) {
                                        com.baidu.swan.apps.console.a.h(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.Wj().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void bs(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.h(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.Wj().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.aKp.setVisibility(this.aKp.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.EN()) {
                                a.this.Es();
                            } else {
                                com.baidu.swan.apps.console.a.aQ(a.this.getContext());
                            }
                        }
                    }
                });
                if (!EN()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow aKs;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.aKs == null) {
                                this.aKs = com.baidu.swan.apps.w.e.LD().F(a.this.mActivity);
                            }
                            this.aKs.setVisibility(this.aKs.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b QZ2;
                        if (a.this.mActivity != null && (QZ2 = com.baidu.swan.apps.ae.b.QZ()) != null && QZ2.AJ() != null) {
                            com.baidu.swan.apps.v.b.b AJ2 = QZ2.AJ();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.Jl().Br()).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.j.c.GO().Ha()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(AJ2.getVersion()) ? "" : AJ2.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.dS(QZ2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), AJ2.KC());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(AJ2.KC()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).hi(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).cv(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.Qu();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (EN()) {
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
                                if (a.this.EN()) {
                                    eN = com.baidu.swan.apps.swancore.a.SS().eN(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    eN = com.baidu.swan.apps.swancore.a.SS().eN(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.d(string).hi(eN).a(new com.baidu.swan.apps.view.b.a()).cv(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.Qu();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.ae.b.QZ(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
            @Override // com.baidu.swan.apps.core.c.c.a
            public void d(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.R(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.Dc()) {
                    com.baidu.swan.apps.console.a.aQ(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.Wj().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void bs(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.aQ(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.Wj().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void cX(int i) {
        z.a(this.aKl, this.aKm, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Et() {
        FragmentActivity abV = abV();
        if (abV != null && this.aKz == null) {
            this.aKz = new com.baidu.swan.menu.g(abV, this.aKy, 13, new com.baidu.swan.apps.view.b.b());
            this.aKz.setStatisticSource("tool");
            this.aKz.setMenuSource("swan");
            this.aKz.a(com.baidu.swan.apps.u.a.Jm());
            new com.baidu.swan.apps.view.coverview.c.b(this.aKz, this).Vn();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void Eu() {
        Et();
        this.aKz.m(com.baidu.swan.apps.u.a.JD().Kc(), ES());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean CB() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean Ev() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean Cn() {
        return false;
    }

    public static a Ew() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b QZ;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e AH = AH();
            if (AH == null) {
                com.baidu.swan.apps.res.widget.b.d.i(this.mActivity, a.h.aiapps_open_fragment_failed_toast).QN();
            } else {
                AH.eC("navigateBack").H(0, e.aLm).Fy().commit();
            }
        } else if (id == a.f.open_app_button && (QZ = com.baidu.swan.apps.ae.b.QZ()) != null && QZ.AJ() != null) {
            com.baidu.swan.apps.v.b.b AJ = QZ.AJ();
            String KL = AJ.KL();
            String KM = AJ.KM();
            if (TextUtils.isEmpty(KL) || TextUtils.isEmpty(KM)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String aV = ac.aV(KL, KM);
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

    private void Ex() {
        if (this.aKk != null) {
            this.aKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.aKo, 1, a.this.aKo, 0, a.this.aKo.length - 1);
                    a.this.aKo[a.this.aKo.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.aKo[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.Ey();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey() {
        String str;
        com.baidu.swan.apps.v.b.b AJ;
        String str2;
        int i;
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        int AB = AB();
        if (QZ != null && AB != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion Li = com.baidu.swan.apps.w.e.LD().Li();
            if (EN()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(Li, AB));
            sb.append("\n");
            if (AB == 0) {
                ExtensionCore Hh = com.baidu.swan.apps.core.j.c.GO().Hh();
                if (Hh == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = Hh.aQF;
                    i = Hh.aQD;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String BN = com.baidu.swan.apps.u.a.Ju().BN();
            if (!TextUtils.isEmpty(BN) && BN.length() > 7) {
                BN = BN.substring(0, 7);
            }
            sb.append("commitId : ").append(BN);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.Ju().BO());
            sb.append("\n");
            sb.append("version : ").append(ac.X(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.QZ() != null && com.baidu.swan.apps.ae.b.QZ().AJ() != null && (AJ = com.baidu.swan.apps.ae.b.QZ().AJ()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.Jl().Br()).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.j.c.GO().Ha()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(AJ.getVersion()) ? "" : AJ.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), AJ.KC());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = AJ.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String Wr = com.baidu.swan.games.c.a.b.Wj().Wr();
            if (!TextUtils.isEmpty(Wr)) {
                sb.append("app sconsole version: ").append(Wr).append("\n");
            }
            if (QZ.Rl()) {
                sb.append("game engine version: ").append("1.1.1.92").append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).QO();
            this.aKo = new long[5];
        }
    }
}
