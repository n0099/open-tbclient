package com.baidu.swan.apps.core.d;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.b;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.al;
import com.baidu.swan.apps.ap.o;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.games.c.d;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView cgC;
    private BdBaseImageView cgD;
    private TextView cgE;
    private com.baidu.swan.apps.view.a cgF;
    private long[] cgG = new long[5];
    private String cgH;
    private String cgI;
    private String cgJ;
    private Button cgK;
    private RecyclerView cgL;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        ai(inflate);
        ak(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cgF != null) {
            this.cgF.aFK();
        }
        setRequestedOrientation(1);
        if (this.chp != null && this.chp.isShowing()) {
            this.chp.gZ(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState());
        }
        if (this.cgK != null) {
            afY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ai(View view) {
        al(view);
        dR(true);
        gV(-1);
        gW(ViewCompat.MEASURED_STATE_MASK);
        lg(null);
        dV(true);
    }

    private void ak(View view) {
        final com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ != null && azJ.azM() != null) {
            final b.a azM = azJ.azM();
            this.cgC = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(azM.akO());
            if (azM.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.aff();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.awb().awc().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(azM.aqx());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cgK = (Button) view.findViewById(a.f.add_favor);
            this.cgK.setOnClickListener(this);
            afY();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(azM.aqC());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(azM.aqD());
            this.cgJ = com.baidu.swan.apps.t.a.aoV().aap();
            if (!TextUtils.isEmpty(this.cgJ)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cgL = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo ard = azM.ard();
            if (a(ard)) {
                e(view, ard.brandsInfo);
            }
            this.cgE = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cgD = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cgC.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) azM, "SwanAppAboutFragment", false));
            this.cgC.setOnClickListener(this);
            SwanAppBearInfo aqE = azM.aqE();
            if (aqE != null && aqE.isValid()) {
                this.cgF = new com.baidu.swan.apps.view.a(this.mActivity, view, aqE, a.f.bear_layout);
            }
            gT(azM.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.arY().arC()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (agG() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(azM.aqZ() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cgU;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cgU == null) {
                                    this.cgU = com.baidu.swan.apps.v.f.arY().H(a.this.mActivity);
                                }
                                if (a.this.agG()) {
                                    if (com.baidu.swan.apps.console.a.adG()) {
                                        com.baidu.swan.apps.console.a.l(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aMC().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void dQ(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.l(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aMC().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cgU.setVisibility(this.cgU.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.agG()) {
                                a.this.afZ();
                            } else {
                                com.baidu.swan.apps.console.a.bN(a.this.getContext());
                            }
                        }
                    }
                });
                if (!agG()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cgW;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cgW == null) {
                                this.cgW = com.baidu.swan.apps.v.f.arY().I(a.this.mActivity);
                            }
                            this.cgW.setVisibility(this.cgW.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.aoM().gr(a.this.XP())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.ajS().aiq()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(azM.getVersion()) ? "" : azM.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.ko(azJ.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), azM.aqG());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(azM.aqG()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).qe(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).fA(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.azp();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (agG()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String jy;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.agG()) {
                                    jy = com.baidu.swan.apps.swancore.a.aDg().jy(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    jy = com.baidu.swan.apps.swancore.a.aDg().jy(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).qe(jy).a(new com.baidu.swan.apps.view.c.a()).fA(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.azp();
                            }
                        }
                    });
                }
                if (k.avV().isAvailable()) {
                    View inflate3 = ((ViewStub) view.findViewById(a.f.ai_app_report_performance)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button2 = (Button) inflate3;
                        button2.setText(a.h.aiapps_debug_report_performance);
                        button2.setOnClickListener(new AnonymousClass12());
                    }
                }
                View inflate4 = ((ViewStub) view.findViewById(a.f.ai_app_start_inspector)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(a.h.aiapps_debug_start_inspect);
                }
                inflate4.setOnClickListener(new AnonymousClass13());
            }
            if (b(ard)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.cL(a.this.getContext());
                        a.this.bk("click", "baozhang");
                    }
                });
            }
            if (!agG()) {
                a(this.cgC, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.afW();
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$12  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.avV().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void lf(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.he(a.h.aiapps_debug_report_performance).qe(str).a(new com.baidu.swan.apps.view.c.a()).fA(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.azp();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$13  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a chd;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.he(a.h.aiapps_debug_start_inspect).hd(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).fA(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.chd = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aoJ());
                        AnonymousClass13.this.chd.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.agm();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.agm();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.azp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void agm() {
            if (this.chd != null) {
                this.chd.stop();
                this.chd = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aDO().aDP();
                    onLongClickListener.onLongClick(view);
                }
            };
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.core.d.a.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            view2.postDelayed(runnable, j);
                            return false;
                        case 1:
                        case 3:
                            view2.removeCallbacks(runnable);
                            return false;
                        case 2:
                        default:
                            return false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afW() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.azE().azA().azM().ard().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.cP(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bj = bj(str, com.baidu.swan.apps.model.b.d(ak.aFp()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bj.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bj;
            }
            al.cP(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, i).showToast();
        }
    }

    @NonNull
    private String bj(@NonNull String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str2.startsWith(File.separator)) {
                str2 = str2.substring(1);
            }
            return str + File.separator + str2;
        }
        return str;
    }

    private boolean a(PMSAppInfo pMSAppInfo) {
        return (com.baidu.swan.apps.runtime.d.azE().XP() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void afX() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cgL.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.cgL.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.cJZ == null) | (aVar.cJZ.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cgL.setVisibility(0);
                                cVar.b(aVar);
                            }
                        });
                        com.baidu.swan.apps.af.c.H("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aFn();
    }

    private void afY() {
        if (com.baidu.swan.apps.database.favorite.a.mb(com.baidu.swan.apps.runtime.d.azE().getAppId())) {
            this.cgK.setText(a.h.swanapp_favored);
            this.cgK.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cgK.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cgK.setText(a.h.swanapp_add_favor);
        this.cgK.setTextColor(-1);
        this.cgK.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afZ() {
        if (com.baidu.swan.apps.runtime.e.azJ() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.azJ(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void h(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.U(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.adG()) {
                        com.baidu.swan.apps.console.a.bN(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aMC().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void dQ(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bN(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aMC().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void gT(int i) {
        ah.a(this.cgD, this.cgE, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void abt() {
        FragmentActivity aUT = aUT();
        if (aUT != null && this.chp == null) {
            this.chp = new com.baidu.swan.menu.h(aUT, this.cho, 13, com.baidu.swan.apps.t.a.aoN(), new com.baidu.swan.apps.view.c.b());
            if (!agG()) {
                this.chp.lA(35);
                this.chp.lA(37);
            }
            new com.baidu.swan.apps.menu.a(this.chp, this).atP();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aga() {
        abt();
        this.chp.show(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abn() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aaM() {
        return false;
    }

    public static a agc() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            agf();
        } else if (id == a.f.open_app_button) {
            agg();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cgH);
            bk("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            agh();
        } else if (id == a.f.share_friends) {
            age();
        } else if (id == a.f.add_favor) {
            agd();
        }
    }

    private void agd() {
        String appId = com.baidu.swan.apps.runtime.d.azE().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.mb(appId)) {
                ld(appId);
            } else {
                le(appId);
            }
            afY();
        }
    }

    private void ld(String str) {
        SwanFavorDataManager.amA().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void agi() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).jj(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void agj() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).jj(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.alW().hv(3).alX());
        bk("click", "aboutmove");
    }

    private void le(String str) {
        if (com.baidu.swan.apps.ad.a.a.axd()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bVe = null;
        final String page = ak.aFp().getPage();
        SwanFavorDataManager.amA().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void agk() {
                com.baidu.swan.apps.database.favorite.a.akX();
                if (com.baidu.swan.apps.menu.a.C(a.this.aUT())) {
                    com.baidu.swan.apps.menu.a.bN("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).jj(2).jf(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void agl() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).jj(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.bN("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void age() {
        e eVar;
        f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null && (eVar = (e) XX.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.agW());
            com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bk("click", "aboutshare");
        }
    }

    private void agf() {
        System.arraycopy(this.cgG, 1, this.cgG, 0, this.cgG.length - 1);
        this.cgG[this.cgG.length - 1] = SystemClock.uptimeMillis();
        if (this.cgG[0] >= SystemClock.uptimeMillis() - 1000) {
            GD();
        }
    }

    private void agg() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ != null) {
            b.a azM = azJ.azM();
            String aqW = azM.aqW();
            String aqX = azM.aqX();
            if (TextUtils.isEmpty(aqW) || TextUtils.isEmpty(aqX)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cx = ak.cx(aqW, aqX);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cx), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void agh() {
        i.lq(this.cgJ).lr(getString(a.h.swan_app_service_agreement)).ea(false).ahC();
        bk("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cgH = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                this.cgI = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cgH) && !TextUtils.isEmpty(this.cgI) && (length = this.cgI.length()) >= 20) {
                    if (length > 100) {
                        this.cgI = this.cgI.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cgI);
                    com.baidu.swan.apps.af.c.H(Constants.PHONE_BRAND, null, "show");
                    afX();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void GD() {
        String O = o.O(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), O).showMultiToast();
        com.baidu.swan.apps.console.c.bb("SwanAppAboutFragment", "showExtraInfo\n" + O);
        this.cgG = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(String str, String str2) {
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
