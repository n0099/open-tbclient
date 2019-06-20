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
    private SwanAppRoundedImageView apT;
    private BdBaseImageView apU;
    private TextView apV;
    private com.baidu.swan.apps.view.a apW;
    private long[] apX = new long[5];

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        M(inflate);
        O(inflate);
        if (zc()) {
            inflate = Q(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.b, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.apW != null) {
            this.apW.Pd();
        }
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public void M(View view) {
        P(view);
        cb(-1);
        cc(ViewCompat.MEASURED_STATE_MASK);
        dF(null);
        ba(true);
    }

    private void O(View view) {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.vk() != null) {
            com.baidu.swan.apps.v.b.b vk = Lq.vk();
            this.apT = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            ((TextView) view.findViewById(a.f.aiapps_title)).setText(vk.BM());
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(vk.EM());
            ((TextView) view.findViewById(a.f.service_category_value)).setText(vk.ER());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(vk.ES());
            this.apV = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.apU = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.apT.setImageBitmap(ac.a(vk, "SwanAppAboutFragment", false));
            ((Button) view.findViewById(a.f.into_aiapps_button)).setOnClickListener(this);
            SwanAppBearInfo ET = vk.ET();
            if (ET != null && ET.isValid()) {
                this.apW = new com.baidu.swan.apps.view.a(this.mActivity, view, ET, a.f.bear_layout);
            }
            ca(com.baidu.swan.apps.ae.b.Lq().vk().getType());
            yR();
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.w.e.FV().FC()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (zh() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(vk.Fh() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.1
                    FullScreenFloatView apY;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.apY == null) {
                                    this.apY = com.baidu.swan.apps.w.e.FV().C(a.this.mActivity);
                                }
                                if (a.this.zh()) {
                                    if (com.baidu.swan.apps.console.a.xz()) {
                                        com.baidu.swan.apps.console.a.h(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.a.b.Qv().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.1.1
                                            @Override // com.baidu.swan.games.c.a.b.a
                                            public void aX(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.h(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.a.b.Qv().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.apY.setVisibility(this.apY.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.zh()) {
                                a.this.yM();
                            } else {
                                com.baidu.swan.apps.console.a.aO(a.this.getContext());
                            }
                        }
                    }
                });
                if (!zh()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.2
                        SwanAppPropertyWindow aqb;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.aqb == null) {
                                this.aqb = com.baidu.swan.apps.w.e.FV().D(a.this.mActivity);
                            }
                            this.aqb.setVisibility(this.aqb.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.swan.apps.ae.b Lq2;
                        if (a.this.mActivity != null && (Lq2 = com.baidu.swan.apps.ae.b.Lq()) != null && Lq2.vk() != null) {
                            com.baidu.swan.apps.v.b.b vk2 = Lq2.vk();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.u.a.DE().vS()).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.j.c.Bi().Bu()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(vk2.getVersion()) ? "" : vk2.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.dc(Lq2.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), vk2.EU());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(vk2.EU()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.d(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).gw(sb.toString()).a(new com.baidu.swan.apps.view.b.a()).cb(false);
                            aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.KK();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (zh()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String dO;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.zh()) {
                                    dO = com.baidu.swan.apps.swancore.a.Nj().dO(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    dO = com.baidu.swan.apps.swancore.a.Nj().dO(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.d(string).gw(dO).a(new com.baidu.swan.apps.view.b.a()).cb(false);
                                aVar.b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.KK();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM() {
        com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.ae.b.Lq(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
            @Override // com.baidu.swan.apps.core.c.c.a
            public void c(boolean z, String str) {
                if (!z) {
                    com.baidu.swan.apps.core.c.c.S(a.this.mActivity, str);
                } else if (com.baidu.swan.apps.console.a.xz()) {
                    com.baidu.swan.apps.console.a.aO(a.this.getContext());
                } else {
                    com.baidu.swan.games.c.a.b.Qv().a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void aX(boolean z2) {
                            if (z2) {
                                com.baidu.swan.apps.console.a.aO(a.this.getContext());
                            } else {
                                com.baidu.swan.games.c.a.b.Qv().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                            }
                        }
                    });
                }
            }
        });
    }

    private void ca(int i) {
        z.a(this.apU, this.apV, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yN() {
        FragmentActivity Wi = Wi();
        if (Wi != null && this.aqi == null) {
            this.aqi = new com.baidu.swan.menu.g(Wi, this.aqh, 13, new com.baidu.swan.apps.view.b.b());
            this.aqi.setStatisticSource("tool");
            this.aqi.setMenuSource("swan");
            this.aqi.a(com.baidu.swan.apps.u.a.DF());
            new com.baidu.swan.apps.view.coverview.c.b(this.aqi, this).PB();
        }
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected void yO() {
        yN();
        this.aqi.i(com.baidu.swan.apps.u.a.DW().Ev(), zm());
    }

    @Override // com.baidu.swan.apps.core.d.b
    protected boolean xc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.b
    public boolean yP() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.b
    public boolean wO() {
        return false;
    }

    public static a yQ() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.swan.apps.ae.b Lq;
        int id = view.getId();
        if (id == a.f.into_aiapps_button) {
            e vi = vi();
            if (vi == null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.aiapps_open_fragment_failed_toast).Ld();
            } else {
                vi.dN("navigateBack").y(0, e.aqU).zS().commit();
            }
        } else if (id == a.f.open_app_button && (Lq = com.baidu.swan.apps.ae.b.Lq()) != null && Lq.vk() != null) {
            com.baidu.swan.apps.v.b.b vk = Lq.vk();
            String Fd = vk.Fd();
            String Fe = vk.Fe();
            if (TextUtils.isEmpty(Fd) || TextUtils.isEmpty(Fe)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String aO = ac.aO(Fd, Fe);
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

    private void yR() {
        if (this.apT != null) {
            this.apT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    System.arraycopy(a.this.apX, 1, a.this.apX, 0, a.this.apX.length - 1);
                    a.this.apX[a.this.apX.length - 1] = SystemClock.uptimeMillis();
                    if (a.this.apX[0] >= SystemClock.uptimeMillis() - 1000) {
                        a.this.yS();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS() {
        String str;
        com.baidu.swan.apps.v.b.b vk;
        String str2;
        int i;
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        int vc = vc();
        if (Lq != null && vc != -1) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion FA = com.baidu.swan.apps.w.e.FV().FA();
            if (zh()) {
                str = "game-core";
            } else {
                str = "swan-core";
            }
            sb.append(str + " version : ").append(com.baidu.swan.apps.swancore.b.a(FA, vc));
            sb.append("\n");
            if (vc == 0) {
                ExtensionCore BB = com.baidu.swan.apps.core.j.c.Bi().BB();
                if (BB == null) {
                    str2 = "";
                    i = -1;
                } else {
                    str2 = BB.awn;
                    i = BB.awl;
                }
                sb.append("extension-core version : ").append(str2).append("   type：").append(i);
                sb.append("\n");
            }
            String wo = com.baidu.swan.apps.u.a.DN().wo();
            if (!TextUtils.isEmpty(wo) && wo.length() > 7) {
                wo = wo.substring(0, 7);
            }
            sb.append("commitId : ").append(wo);
            sb.append("\n");
            sb.append("buildTime : ").append(com.baidu.swan.apps.u.a.DN().wp());
            sb.append("\n");
            sb.append("version : ").append(ac.Y(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            if (this.mActivity != null && com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null && (vk = com.baidu.swan.apps.ae.b.Lq().vk()) != null) {
                sb.append("enable code cache: ").append(com.baidu.swan.apps.u.a.DE().vS()).append("\n");
                sb.append("enable V8: ").append(com.baidu.swan.apps.core.j.c.Bi().Bu()).append("\n");
                sb.append("aps version: ").append(TextUtils.isEmpty(vk.getVersion()) ? "" : vk.getVersion()).append("\n");
                String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), vk.EU());
                StringBuilder append = sb.append("app bundle size: ");
                if (TextUtils.isEmpty(formatFileSize)) {
                    formatFileSize = "";
                }
                append.append(formatFileSize).append("\n");
                String versionCode = vk.getVersionCode();
                StringBuilder append2 = sb.append("app bundle version: ");
                if (TextUtils.isEmpty(versionCode)) {
                    versionCode = "";
                }
                append2.append(versionCode).append("\n");
            }
            String QD = com.baidu.swan.games.c.a.b.Qv().QD();
            if (!TextUtils.isEmpty(QD)) {
                sb.append("app sconsole version: ").append(QD).append("\n");
            }
            if (Lq.LC()) {
                sb.append("game engine version: ").append("1.1.1.92").append("\n");
            }
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), sb.toString()).Le();
            this.apX = new long[5];
        }
    }
}
