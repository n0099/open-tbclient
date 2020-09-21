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
/* loaded from: classes3.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView ciI;
    private BdBaseImageView ciJ;
    private TextView ciK;
    private com.baidu.swan.apps.view.a ciL;
    private long[] ciM = new long[5];
    private String ciN;
    private String ciO;
    private String ciP;
    private Button ciQ;
    private RecyclerView ciR;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        ak(inflate);
        am(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ciL != null) {
            this.ciL.aGu();
        }
        setRequestedOrientation(1);
        if (this.cjv != null && this.cjv.isShowing()) {
            this.cjv.gY(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState());
        }
        if (this.ciQ != null) {
            agI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ak(View view) {
        an(view);
        dQ(true);
        he(-1);
        hf(ViewCompat.MEASURED_STATE_MASK);
        lA(null);
        dU(true);
    }

    private void am(View view) {
        final com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs != null && aAs.aAv() != null) {
            final b.a aAv = aAs.aAv();
            this.ciI = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aAv.aly());
            if (aAv.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.afP();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.awK().awL().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aAv.arh());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.ciQ = (Button) view.findViewById(a.f.add_favor);
            this.ciQ.setOnClickListener(this);
            agI();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aAv.arm());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aAv.arn());
            this.ciP = com.baidu.swan.apps.t.a.apG().aaY();
            if (!TextUtils.isEmpty(this.ciP)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.ciR = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo arN = aAv.arN();
            if (a(arN)) {
                e(view, arN.brandsInfo);
            }
            this.ciK = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.ciJ = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.ciI.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aAv, "SwanAppAboutFragment", false));
            this.ciI.setOnClickListener(this);
            SwanAppBearInfo aro = aAv.aro();
            if (aro != null && aro.isValid()) {
                this.ciL = new com.baidu.swan.apps.view.a(this.mActivity, view, aro, a.f.bear_layout);
            }
            hc(aAv.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.asJ().asn()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (ahq() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aAv.arJ() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cja;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cja == null) {
                                    this.cja = com.baidu.swan.apps.v.f.asJ().I(a.this.mActivity);
                                }
                                if (a.this.ahq()) {
                                    if (com.baidu.swan.apps.console.a.aeq()) {
                                        com.baidu.swan.apps.console.a.m(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aNn().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void dP(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.m(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aNn().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cja.setVisibility(this.cja.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.ahq()) {
                                a.this.agJ();
                            } else {
                                com.baidu.swan.apps.console.a.bM(a.this.getContext());
                            }
                        }
                    }
                });
                if (!ahq()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cjc;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cjc == null) {
                                this.cjc = com.baidu.swan.apps.v.f.asJ().J(a.this.mActivity);
                            }
                            this.cjc.setVisibility(this.cjc.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.apx().gA(a.this.Yy())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.akC().aja()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aAv.getVersion()) ? "" : aAv.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.kI(aAs.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aAv.arq());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aAv.arq()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).qy(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).fz(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.azY();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (ahq()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String jJ;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.ahq()) {
                                    jJ = com.baidu.swan.apps.swancore.a.aDQ().jJ(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    jJ = com.baidu.swan.apps.swancore.a.aDQ().jJ(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).qy(jJ).a(new com.baidu.swan.apps.view.c.a()).fz(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.azY();
                            }
                        }
                    });
                }
                if (k.awE().isAvailable()) {
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
            if (b(arN)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.cK(a.this.getContext());
                        a.this.bk("click", "baozhang");
                    }
                });
            }
            if (!ahq()) {
                a(this.ciI, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.agG();
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$12  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.awE().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void lz(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.hn(a.h.aiapps_debug_report_performance).qy(str).a(new com.baidu.swan.apps.view.c.a()).fz(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.azY();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$13  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a cjj;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.hn(a.h.aiapps_debug_start_inspect).hm(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).fz(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cjj = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.apu());
                        AnonymousClass13.this.cjj.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.agW();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.agW();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.azY();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void agW() {
            if (this.cjj != null) {
                this.cjj.stop();
                this.cjj = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aEy().aEz();
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
    public void agG() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().arN().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.cO(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bj = bj(str, com.baidu.swan.apps.model.b.d(ak.aFZ()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bj.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bj;
            }
            al.cO(this.mActivity).setText(str);
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
        return (com.baidu.swan.apps.runtime.d.aAn().Yy() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void agH() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.ciR.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.ciR.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.cMd == null) | (aVar.cMd.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.ciR.setVisibility(0);
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
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aFX();
    }

    private void agI() {
        if (com.baidu.swan.apps.database.favorite.a.mv(com.baidu.swan.apps.runtime.d.aAn().getAppId())) {
            this.ciQ.setText(a.h.swanapp_favored);
            this.ciQ.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.ciQ.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.ciQ.setText(a.h.swanapp_add_favor);
        this.ciQ.setTextColor(-1);
        this.ciQ.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agJ() {
        if (com.baidu.swan.apps.runtime.e.aAs() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aAs(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void h(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.X(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.aeq()) {
                        com.baidu.swan.apps.console.a.bM(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aNn().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void dP(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bM(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aNn().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void hc(int i) {
        ah.a(this.ciJ, this.ciK, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void acc() {
        FragmentActivity aVF = aVF();
        if (aVF != null && this.cjv == null) {
            this.cjv = new com.baidu.swan.menu.h(aVF, this.cju, 13, com.baidu.swan.apps.t.a.apy(), new com.baidu.swan.apps.view.c.b());
            if (!ahq()) {
                this.cjv.lL(35);
                this.cjv.lL(37);
            }
            new com.baidu.swan.apps.menu.a(this.cjv, this).auy();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agK() {
        acc();
        this.cjv.show(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean abW() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean agL() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean abv() {
        return false;
    }

    public static a agM() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            agP();
        } else if (id == a.f.open_app_button) {
            agQ();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.ciN);
            bk("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            agR();
        } else if (id == a.f.share_friends) {
            agO();
        } else if (id == a.f.add_favor) {
            agN();
        }
    }

    private void agN() {
        String appId = com.baidu.swan.apps.runtime.d.aAn().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.mv(appId)) {
                lx(appId);
            } else {
                ly(appId);
            }
            agI();
        }
    }

    private void lx(String str) {
        SwanFavorDataManager.ank().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void agS() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).ju(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void agT() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).ju(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.amG().hE(3).amH());
        bk("click", "aboutmove");
    }

    private void ly(String str) {
        if (com.baidu.swan.apps.ad.a.a.axM()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bXj = null;
        final String page = ak.aFZ().getPage();
        SwanFavorDataManager.ank().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void agU() {
                com.baidu.swan.apps.database.favorite.a.alH();
                if (com.baidu.swan.apps.menu.a.D(a.this.aVF())) {
                    com.baidu.swan.apps.menu.a.bN("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).ju(2).jq(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void agV() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).ju(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.bN("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void agO() {
        e eVar;
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null && (eVar = (e) YG.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.ahG());
            com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bk("click", "aboutshare");
        }
    }

    private void agP() {
        System.arraycopy(this.ciM, 1, this.ciM, 0, this.ciM.length - 1);
        this.ciM[this.ciM.length - 1] = SystemClock.uptimeMillis();
        if (this.ciM[0] >= SystemClock.uptimeMillis() - 1000) {
            Hd();
        }
    }

    private void agQ() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs != null) {
            b.a aAv = aAs.aAv();
            String arG = aAv.arG();
            String arH = aAv.arH();
            if (TextUtils.isEmpty(arG) || TextUtils.isEmpty(arH)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cx = ak.cx(arG, arH);
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

    private void agR() {
        i.lK(this.ciP).lL(getString(a.h.swan_app_service_agreement)).dZ(false).aim();
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
                this.ciN = jSONObject.optString("scheme");
                this.ciO = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.ciN) && !TextUtils.isEmpty(this.ciO) && (length = this.ciO.length()) >= 20) {
                    if (length > 100) {
                        this.ciO = this.ciO.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.ciO);
                    com.baidu.swan.apps.af.c.H(Constants.PHONE_BRAND, null, "show");
                    agH();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Hd() {
        String Q = o.Q(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Q).showMultiToast();
        com.baidu.swan.apps.console.c.bb("SwanAppAboutFragment", "showExtraInfo\n" + Q);
        this.ciM = new long[5];
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
