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
    private SwanAppRoundedImageView cJq;
    private BdBaseImageView cJr;
    private TextView cJs;
    private com.baidu.swan.apps.view.a cJt;
    private long[] cJu = new long[5];
    private String cJv;
    private String cJw;
    private String cJx;
    private Button cJy;
    private RecyclerView cJz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        ar(inflate);
        al(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cJt != null) {
            this.cJt.aNx();
        }
        setRequestedOrientation(1);
        if (this.cKc != null && this.cKc.isShowing()) {
            this.cKc.hQ(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState());
        }
        if (this.cJy != null) {
            anN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        at(view);
        eI(true);
        hW(-1);
        hX(ViewCompat.MEASURED_STATE_MASK);
        mU(null);
        eM(true);
    }

    private void al(View view) {
        final com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv != null && aHv.aHy() != null) {
            final b.a aHy = aHv.aHy();
            this.cJq = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aHy.asF());
            if (aHy.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.amU();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aHy.ayn());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cJy = (Button) view.findViewById(a.f.add_favor);
            this.cJy.setOnClickListener(this);
            anN();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aHy.ays());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aHy.ayt());
            this.cJx = com.baidu.swan.apps.t.a.awM().aie();
            if (!TextUtils.isEmpty(this.cJx)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cJz = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo ayT = aHy.ayT();
            if (a(ayT)) {
                e(view, ayT.brandsInfo);
            }
            this.cJs = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cJr = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cJq.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aHy, "SwanAppAboutFragment", false));
            this.cJq.setOnClickListener(this);
            SwanAppBearInfo ayu = aHy.ayu();
            if (ayu != null && ayu.isValid()) {
                this.cJt = new com.baidu.swan.apps.view.a(this.mActivity, view, ayu, a.f.bear_layout);
            }
            hU(aHy.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.azO().azs()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aov() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aHy.ayP() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cJI;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cJI == null) {
                                    this.cJI = com.baidu.swan.apps.v.f.azO().J(a.this.mActivity);
                                }
                                if (a.this.aov()) {
                                    if (com.baidu.swan.apps.console.a.alv()) {
                                        com.baidu.swan.apps.console.a.n(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aUq().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void eH(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.n(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aUq().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cJI.setVisibility(this.cJI.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aov()) {
                                a.this.anO();
                            } else {
                                com.baidu.swan.apps.console.a.bS(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aov()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cJK;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cJK == null) {
                                this.cJK = com.baidu.swan.apps.v.f.azO().K(a.this.mActivity);
                            }
                            this.cJK.setVisibility(this.cJK.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.awD().hs(a.this.afE())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.arI().aqg()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aHy.getVersion()) ? "" : aHy.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.mc(aHv.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aHy.ayw());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aHy.ayw()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).rR(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gr(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aHb();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aov()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String kB;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.aov()) {
                                    kB = com.baidu.swan.apps.swancore.a.aKT().kB(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    kB = com.baidu.swan.apps.swancore.a.aKT().kB(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).rR(kB).a(new com.baidu.swan.apps.view.c.a()).gr(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aHb();
                            }
                        }
                    });
                }
                if (k.aDJ().isAvailable()) {
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
            if (b(ayT)) {
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
            if (!aov()) {
                a(this.cJq, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.anL();
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
                k.aDJ().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void mT(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.mo33if(a.h.aiapps_debug_report_performance).rR(str).a(new com.baidu.swan.apps.view.c.a()).gr(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aHb();
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
        com.baidu.swan.apps.console.v8inspector.a cJR;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.mo33if(a.h.aiapps_debug_start_inspect).ie(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gr(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cJR = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awA());
                        AnonymousClass13.this.cJR.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aob();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aob();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aHb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aob() {
            if (this.cJR != null) {
                this.cJR.stop();
                this.cJR = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aLB().aLC();
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
    public void anL() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aHq().aHm().aHy().ayT().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.cU(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bv = bv(str, com.baidu.swan.apps.model.b.d(ak.aNc()));
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
        return (com.baidu.swan.apps.runtime.d.aHq().afE() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void anM() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cJz.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.cJz.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dmC == null) | (aVar.dmC.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cJz.setVisibility(0);
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
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aNa();
    }

    private void anN() {
        if (com.baidu.swan.apps.database.favorite.a.nO(com.baidu.swan.apps.runtime.d.aHq().getAppId())) {
            this.cJy.setText(a.h.swanapp_favored);
            this.cJy.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cJy.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cJy.setText(a.h.swanapp_add_favor);
        this.cJy.setTextColor(-1);
        this.cJy.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anO() {
        if (com.baidu.swan.apps.runtime.e.aHv() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aHv(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void j(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.ab(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.alv()) {
                        com.baidu.swan.apps.console.a.bS(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aUq().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void eH(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bS(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aUq().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void hU(int i) {
        ah.a(this.cJr, this.cJs, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aji() {
        FragmentActivity bcH = bcH();
        if (bcH != null && this.cKc == null) {
            this.cKc = new com.baidu.swan.menu.h(bcH, this.cKb, 13, com.baidu.swan.apps.t.a.awE(), new com.baidu.swan.apps.view.c.b());
            if (!aov()) {
                this.cKc.mD(35);
                this.cKc.mD(37);
            }
            new com.baidu.swan.apps.menu.a(this.cKc, this).aBD();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anP() {
        aji();
        this.cKc.show(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anQ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiB() {
        return false;
    }

    public static a anR() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            anU();
        } else if (id == a.f.open_app_button) {
            anV();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cJv);
            bw("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            anW();
        } else if (id == a.f.share_friends) {
            anT();
        } else if (id == a.f.add_favor) {
            anS();
        }
    }

    private void anS() {
        String appId = com.baidu.swan.apps.runtime.d.aHq().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nO(appId)) {
                mR(appId);
            } else {
                mS(appId);
            }
            anN();
        }
    }

    private void mR(String str) {
        SwanFavorDataManager.aur().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anX() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).km(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anY() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).km(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.atN().iw(3).atO());
        bw("click", "aboutmove");
    }

    private void mS(String str) {
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cxW = null;
        final String page = ak.aNc().getPage();
        SwanFavorDataManager.aur().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anZ() {
                com.baidu.swan.apps.database.favorite.a.asO();
                if (com.baidu.swan.apps.menu.a.E(a.this.bcH())) {
                    com.baidu.swan.apps.menu.a.bZ("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).km(2).ki(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aoa() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).km(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.bZ("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anT() {
        e eVar;
        f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null && (eVar = (e) afM.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.aoL());
            com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bw("click", "aboutshare");
        }
    }

    private void anU() {
        System.arraycopy(this.cJu, 1, this.cJu, 0, this.cJu.length - 1);
        this.cJu[this.cJu.length - 1] = SystemClock.uptimeMillis();
        if (this.cJu[0] >= SystemClock.uptimeMillis() - 1000) {
            IV();
        }
    }

    private void anV() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv != null) {
            b.a aHy = aHv.aHy();
            String ayM = aHy.ayM();
            String ayN = aHy.ayN();
            if (TextUtils.isEmpty(ayM) || TextUtils.isEmpty(ayN)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cJ = ak.cJ(ayM, ayN);
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

    private void anW() {
        i.ne(this.cJx).nf(getString(a.h.swan_app_service_agreement)).eR(false).aps();
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
                this.cJv = jSONObject.optString("scheme");
                this.cJw = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cJv) && !TextUtils.isEmpty(this.cJw) && (length = this.cJw.length()) >= 20) {
                    if (length > 100) {
                        this.cJw = this.cJw.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cJw);
                    com.baidu.swan.apps.af.c.P(Constants.PHONE_BRAND, null, "show");
                    anM();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void IV() {
        String R = o.R(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), R).showMultiToast();
        com.baidu.swan.apps.console.c.bn("SwanAppAboutFragment", "showExtraInfo\n" + R);
        this.cJu = new long[5];
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
