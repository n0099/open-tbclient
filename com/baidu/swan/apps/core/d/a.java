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
    private com.baidu.swan.apps.view.a cDA;
    private long[] cDB = new long[5];
    private String cDC;
    private String cDD;
    private String cDE;
    private Button cDF;
    private RecyclerView cDG;
    private SwanAppRoundedImageView cDx;
    private BdBaseImageView cDy;
    private TextView cDz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        an(inflate);
        ah(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cDA != null) {
            this.cDA.aKX();
        }
        setRequestedOrientation(1);
        if (this.cEj != null && this.cEj.isShowing()) {
            this.cEj.hH(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState());
        }
        if (this.cDF != null) {
            aln();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void an(View view) {
        ap(view);
        ez(true);
        hM(-1);
        hN(ViewCompat.MEASURED_STATE_MASK);
        mF(null);
        eD(true);
    }

    private void ah(View view) {
        final com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV != null && aEV.aEY() != null) {
            final b.a aEY = aEV.aEY();
            this.cDx = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aEY.aqe());
            if (aEY.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.aku();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aEY.avN());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cDF = (Button) view.findViewById(a.f.add_favor);
            this.cDF.setOnClickListener(this);
            aln();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aEY.avS());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aEY.avT());
            this.cDE = com.baidu.swan.apps.t.a.aum().afE();
            if (!TextUtils.isEmpty(this.cDE)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cDG = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo awt = aEY.awt();
            if (a(awt)) {
                e(view, awt.brandsInfo);
            }
            this.cDz = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cDy = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cDx.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aEY, "SwanAppAboutFragment", false));
            this.cDx.setOnClickListener(this);
            SwanAppBearInfo avU = aEY.avU();
            if (avU != null && avU.isValid()) {
                this.cDA = new com.baidu.swan.apps.view.a(this.mActivity, view, avU, a.f.bear_layout);
            }
            hK(aEY.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.axo().awS()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (alV() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aEY.awp() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cDP;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cDP == null) {
                                    this.cDP = com.baidu.swan.apps.v.f.axo().J(a.this.mActivity);
                                }
                                if (a.this.alV()) {
                                    if (com.baidu.swan.apps.console.a.aiV()) {
                                        com.baidu.swan.apps.console.a.m(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aRQ().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void ey(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.m(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aRQ().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cDP.setVisibility(this.cDP.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.alV()) {
                                a.this.alo();
                            } else {
                                com.baidu.swan.apps.console.a.bS(a.this.getContext());
                            }
                        }
                    }
                });
                if (!alV()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cDR;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cDR == null) {
                                this.cDR = com.baidu.swan.apps.v.f.axo().K(a.this.mActivity);
                            }
                            this.cDR.setVisibility(this.cDR.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.aud().hi(a.this.ade())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.aph().anF()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aEY.getVersion()) ? "" : aEY.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.lN(aEV.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aEY.avW());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aEY.avW()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).rD(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gi(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aEB();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (alV()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String kr;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.alV()) {
                                    kr = com.baidu.swan.apps.swancore.a.aIt().kr(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    kr = com.baidu.swan.apps.swancore.a.aIt().kr(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).rD(kr).a(new com.baidu.swan.apps.view.c.a()).gi(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aEB();
                            }
                        }
                    });
                }
                if (k.aBj().isAvailable()) {
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
            if (b(awt)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.cQ(a.this.getContext());
                        a.this.bw("click", "baozhang");
                    }
                });
            }
            if (!alV()) {
                a(this.cDx, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.all();
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
                k.aBj().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void mE(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.hV(a.h.aiapps_debug_report_performance).rD(str).a(new com.baidu.swan.apps.view.c.a()).gi(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aEB();
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
        com.baidu.swan.apps.console.v8inspector.a cDY;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.hV(a.h.aiapps_debug_start_inspect).hU(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gi(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cDY = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aua());
                        AnonymousClass13.this.cDY.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.alB();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.alB();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aEB();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void alB() {
            if (this.cDY != null) {
                this.cDY.stop();
                this.cDY = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aJb().aJc();
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
    public void all() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY().awt().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.cU(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bv = bv(str, com.baidu.swan.apps.model.b.d(ak.aKC()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bv.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bv;
            }
            al.cU(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, i).showToast();
        }
    }

    @NonNull
    private String bv(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aEQ().ade() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void alm() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cDG.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.cDG.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dgH == null) | (aVar.dgH.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cDG.setVisibility(0);
                                cVar.b(aVar);
                            }
                        });
                        com.baidu.swan.apps.af.c.P("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aKA();
    }

    private void aln() {
        if (com.baidu.swan.apps.database.favorite.a.nA(com.baidu.swan.apps.runtime.d.aEQ().getAppId())) {
            this.cDF.setText(a.h.swanapp_favored);
            this.cDF.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cDF.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cDF.setText(a.h.swanapp_add_favor);
        this.cDF.setTextColor(-1);
        this.cDF.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alo() {
        if (com.baidu.swan.apps.runtime.e.aEV() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aEV(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void j(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.ab(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.aiV()) {
                        com.baidu.swan.apps.console.a.bS(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aRQ().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void ey(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bS(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aRQ().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void hK(int i) {
        ah.a(this.cDy, this.cDz, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void agI() {
        FragmentActivity bah = bah();
        if (bah != null && this.cEj == null) {
            this.cEj = new com.baidu.swan.menu.h(bah, this.cEi, 13, com.baidu.swan.apps.t.a.aue(), new com.baidu.swan.apps.view.c.b());
            if (!alV()) {
                this.cEj.mt(35);
                this.cEj.mt(37);
            }
            new com.baidu.swan.apps.menu.a(this.cEj, this).azd();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alp() {
        agI();
        this.cEj.show(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean alq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean agb() {
        return false;
    }

    public static a alr() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            alu();
        } else if (id == a.f.open_app_button) {
            alv();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cDC);
            bw("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            alw();
        } else if (id == a.f.share_friends) {
            alt();
        } else if (id == a.f.add_favor) {
            als();
        }
    }

    private void als() {
        String appId = com.baidu.swan.apps.runtime.d.aEQ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nA(appId)) {
                mC(appId);
            } else {
                mD(appId);
            }
            aln();
        }
    }

    private void mC(String str) {
        SwanFavorDataManager.arQ().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void alx() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).kc(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aly() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).kc(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.arm().im(3).arn());
        bw("click", "aboutmove");
    }

    private void mD(String str) {
        if (com.baidu.swan.apps.ad.a.a.aCr()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.crZ = null;
        final String page = ak.aKC().getPage();
        SwanFavorDataManager.arQ().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void alz() {
                com.baidu.swan.apps.database.favorite.a.aqn();
                if (com.baidu.swan.apps.menu.a.E(a.this.bah())) {
                    com.baidu.swan.apps.menu.a.bZ("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).kc(2).jY(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void alA() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).kc(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.bZ("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void alt() {
        e eVar;
        f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null && (eVar = (e) adm.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.aml());
            com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bw("click", "aboutshare");
        }
    }

    private void alu() {
        System.arraycopy(this.cDB, 1, this.cDB, 0, this.cDB.length - 1);
        this.cDB[this.cDB.length - 1] = SystemClock.uptimeMillis();
        if (this.cDB[0] >= SystemClock.uptimeMillis() - 1000) {
            Iu();
        }
    }

    private void alv() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV != null) {
            b.a aEY = aEV.aEY();
            String awm = aEY.awm();
            String awn = aEY.awn();
            if (TextUtils.isEmpty(awm) || TextUtils.isEmpty(awn)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cJ = ak.cJ(awm, awn);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cJ), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void alw() {
        i.mP(this.cDE).mQ(getString(a.h.swan_app_service_agreement)).eI(false).amR();
        bw("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cDC = jSONObject.optString("scheme");
                this.cDD = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cDC) && !TextUtils.isEmpty(this.cDD) && (length = this.cDD.length()) >= 20) {
                    if (length > 100) {
                        this.cDD = this.cDD.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cDD);
                    com.baidu.swan.apps.af.c.P(Constants.PHONE_BRAND, null, "show");
                    alm();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Iu() {
        String R = o.R(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), R).showMultiToast();
        com.baidu.swan.apps.console.c.bn("SwanAppAboutFragment", "showExtraInfo\n" + R);
        this.cDB = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str, String str2) {
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
