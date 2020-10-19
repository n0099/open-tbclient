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
/* loaded from: classes10.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView cvb;
    private BdBaseImageView cvc;
    private TextView cvd;
    private com.baidu.swan.apps.view.a cve;
    private long[] cvf = new long[5];
    private String cvg;
    private String cvh;
    private String cvi;
    private Button cvj;
    private RecyclerView cvk;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        al(inflate);
        an(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cve != null) {
            this.cve.aJd();
        }
        setRequestedOrientation(1);
        if (this.cvN != null && this.cvN.isShowing()) {
            this.cvN.hu(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState());
        }
        if (this.cvj != null) {
            ajt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void al(View view) {
        ao(view);
        em(true);
        hB(-1);
        hC(ViewCompat.MEASURED_STATE_MASK);
        mm(null);
        eq(true);
    }

    private void an(View view) {
        final com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb != null && aDb.aDe() != null) {
            final b.a aDe = aDb.aDe();
            this.cvb = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aDe.aoj());
            if (aDe.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.aiA();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.azv().azw().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aDe.atT());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cvj = (Button) view.findViewById(a.f.add_favor);
            this.cvj.setOnClickListener(this);
            ajt();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aDe.atY());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aDe.atZ());
            this.cvi = com.baidu.swan.apps.t.a.ass().adK();
            if (!TextUtils.isEmpty(this.cvi)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cvk = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo auz = aDe.auz();
            if (a(auz)) {
                e(view, auz.brandsInfo);
            }
            this.cvd = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cvc = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cvb.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aDe, "SwanAppAboutFragment", false));
            this.cvb.setOnClickListener(this);
            SwanAppBearInfo aua = aDe.aua();
            if (aua != null && aua.isValid()) {
                this.cve = new com.baidu.swan.apps.view.a(this.mActivity, view, aua, a.f.bear_layout);
            }
            hz(aDe.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.avu().auY()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (akb() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aDe.auv() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cvt;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cvt == null) {
                                    this.cvt = com.baidu.swan.apps.v.f.avu().J(a.this.mActivity);
                                }
                                if (a.this.akb()) {
                                    if (com.baidu.swan.apps.console.a.ahb()) {
                                        com.baidu.swan.apps.console.a.m(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aPW().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void el(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.m(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aPW().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cvt.setVisibility(this.cvt.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.akb()) {
                                a.this.aju();
                            } else {
                                com.baidu.swan.apps.console.a.bS(a.this.getContext());
                            }
                        }
                    }
                });
                if (!akb()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cvv;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cvv == null) {
                                this.cvv = com.baidu.swan.apps.v.f.avu().K(a.this.mActivity);
                            }
                            this.cvv.setVisibility(this.cvv.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.asi().gX(a.this.abk())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.ann().alL()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aDe.getVersion()) ? "" : aDe.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.lu(aDb.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aDe.auc());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aDe.auc()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).rk(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).fV(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aCH();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (akb()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String kg;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.akb()) {
                                    kg = com.baidu.swan.apps.swancore.a.aGz().kg(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    kg = com.baidu.swan.apps.swancore.a.aGz().kg(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).rk(kg).a(new com.baidu.swan.apps.view.c.a()).fV(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aCH();
                            }
                        }
                    });
                }
                if (k.azp().isAvailable()) {
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
            if (b(auz)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.cQ(a.this.getContext());
                        a.this.bp("click", "baozhang");
                    }
                });
            }
            if (!akb()) {
                a(this.cvb, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.ajr();
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$12  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.azp().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void ml(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.hK(a.h.aiapps_debug_report_performance).rk(str).a(new com.baidu.swan.apps.view.c.a()).fV(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aCH();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$13  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a cvC;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.hK(a.h.aiapps_debug_start_inspect).hJ(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).fV(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cvC = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.asf());
                        AnonymousClass13.this.cvC.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.ajH();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.ajH();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aCH();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ajH() {
            if (this.cvC != null) {
                this.cvC.stop();
                this.cvC = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aHh().aHi();
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
    public void ajr() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aCW().aCS().aDe().auz().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.cU(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bo = bo(str, com.baidu.swan.apps.model.b.d(ak.aII()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bo.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bo;
            }
            al.cU(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, i).showToast();
        }
    }

    @NonNull
    private String bo(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aCW().abk() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void ajs() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cvk.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.cvk.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.cYg == null) | (aVar.cYg.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cvk.setVisibility(0);
                                cVar.b(aVar);
                            }
                        });
                        com.baidu.swan.apps.af.c.I("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aIG();
    }

    private void ajt() {
        if (com.baidu.swan.apps.database.favorite.a.nh(com.baidu.swan.apps.runtime.d.aCW().getAppId())) {
            this.cvj.setText(a.h.swanapp_favored);
            this.cvj.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cvj.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cvj.setText(a.h.swanapp_add_favor);
        this.cvj.setTextColor(-1);
        this.cvj.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aju() {
        if (com.baidu.swan.apps.runtime.e.aDb() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aDb(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void h(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.aa(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.ahb()) {
                        com.baidu.swan.apps.console.a.bS(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aPW().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void el(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bS(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aPW().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void hz(int i) {
        ah.a(this.cvc, this.cvd, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aeO() {
        FragmentActivity aYo = aYo();
        if (aYo != null && this.cvN == null) {
            this.cvN = new com.baidu.swan.menu.h(aYo, this.cvM, 13, com.baidu.swan.apps.t.a.asj(), new com.baidu.swan.apps.view.c.b());
            if (!akb()) {
                this.cvN.mi(35);
                this.cvN.mi(37);
            }
            new com.baidu.swan.apps.menu.a(this.cvN, this).axj();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajv() {
        aeO();
        this.cvN.show(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aeI() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ajw() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aeh() {
        return false;
    }

    public static a ajx() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            ajA();
        } else if (id == a.f.open_app_button) {
            ajB();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cvg);
            bp("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            ajC();
        } else if (id == a.f.share_friends) {
            ajz();
        } else if (id == a.f.add_favor) {
            ajy();
        }
    }

    private void ajy() {
        String appId = com.baidu.swan.apps.runtime.d.aCW().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nh(appId)) {
                mj(appId);
            } else {
                mk(appId);
            }
            ajt();
        }
    }

    private void mj(String str) {
        SwanFavorDataManager.apW().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void ajD() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).jR(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void ajE() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).jR(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.aps().ib(3).apt());
        bp("click", "aboutmove");
    }

    private void mk(String str) {
        if (com.baidu.swan.apps.ad.a.a.aAx()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cjy = null;
        final String page = ak.aII().getPage();
        SwanFavorDataManager.apW().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void ajF() {
                com.baidu.swan.apps.database.favorite.a.aos();
                if (com.baidu.swan.apps.menu.a.E(a.this.aYo())) {
                    com.baidu.swan.apps.menu.a.bS("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).jR(2).jN(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void ajG() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).jR(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.bS("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ajz() {
        e eVar;
        f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null && (eVar = (e) abs.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.akr());
            com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bp("click", "aboutshare");
        }
    }

    private void ajA() {
        System.arraycopy(this.cvf, 1, this.cvf, 0, this.cvf.length - 1);
        this.cvf[this.cvf.length - 1] = SystemClock.uptimeMillis();
        if (this.cvf[0] >= SystemClock.uptimeMillis() - 1000) {
            HZ();
        }
    }

    private void ajB() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb != null) {
            b.a aDe = aDb.aDe();
            String aus = aDe.aus();
            String aut = aDe.aut();
            if (TextUtils.isEmpty(aus) || TextUtils.isEmpty(aut)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cC = ak.cC(aus, aut);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cC), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void ajC() {
        i.mw(this.cvi).mx(getString(a.h.swan_app_service_agreement)).ev(false).akX();
        bp("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cvg = jSONObject.optString("scheme");
                this.cvh = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cvg) && !TextUtils.isEmpty(this.cvh) && (length = this.cvh.length()) >= 20) {
                    if (length > 100) {
                        this.cvh = this.cvh.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cvh);
                    com.baidu.swan.apps.af.c.I(Constants.PHONE_BRAND, null, "show");
                    ajs();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void HZ() {
        String R = o.R(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), R).showMultiToast();
        com.baidu.swan.apps.console.c.bg("SwanAppAboutFragment", "showExtraInfo\n" + R);
        this.cvf = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(String str, String str2) {
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
