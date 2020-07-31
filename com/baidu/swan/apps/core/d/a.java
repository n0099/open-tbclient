package com.baidu.swan.apps.core.d;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.baidu.swan.apps.ag.b;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.o;
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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView caJ;
    private BdBaseImageView caK;
    private TextView caL;
    private com.baidu.swan.apps.view.a caM;
    private long[] caN = new long[5];
    private String caO;
    private String caP;
    private String caQ;
    private Button caR;
    private RecyclerView caS;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        ah(inflate);
        aj(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.caM != null) {
            this.caM.axC();
        }
        setRequestedOrientation(1);
        if (this.cbu != null && this.cbu.isShowing()) {
            this.cbu.gD(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState());
        }
        if (this.caR != null) {
            ZO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ah(View view) {
        ak(view);
        dH(true);
        eZ(-1);
        fa(ViewCompat.MEASURED_STATE_MASK);
        jH(null);
        dL(true);
    }

    private void aj(View view) {
        final com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw != null && arw.arz() != null) {
            final b.a arz = arw.arz();
            this.caJ = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(arz.aee());
            com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.core.d.YW();
                }
            });
            com.baidu.swan.apps.performance.d.b.aoz().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(arz.aiR());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.caR = (Button) view.findViewById(a.f.add_favor);
            this.caR.setOnClickListener(this);
            ZO();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(arz.aiW());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(arz.aiX());
            this.caQ = com.baidu.swan.apps.t.a.ahv().Un();
            if (!TextUtils.isEmpty(this.caQ)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.caS = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo ajw = arz.ajw();
            if (a(ajw)) {
                e(view, ajw.brandsInfo);
            }
            this.caL = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.caK = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.caJ.setImageBitmap(al.a((com.baidu.swan.apps.u.c.b) arz, "SwanAppAboutFragment", false));
            this.caJ.setOnClickListener(this);
            SwanAppBearInfo aiY = arz.aiY();
            if (aiY != null && aiY.isValid()) {
                this.caM = new com.baidu.swan.apps.view.a(this.mActivity, view, aiY, a.f.bear_layout);
            }
            eX(arz.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.akr().ajV()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aaw() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(arz.ajs() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.5
                    FullScreenFloatView caW;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.caW == null) {
                                    this.caW = com.baidu.swan.apps.v.f.akr().H(a.this.mActivity);
                                }
                                if (a.this.aaw()) {
                                    if (com.baidu.swan.apps.console.a.XA()) {
                                        com.baidu.swan.apps.console.a.k(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aDN().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void dG(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.k(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aDN().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.caW.setVisibility(this.caW.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aaw()) {
                                a.this.ZP();
                            } else {
                                com.baidu.swan.apps.console.a.bG(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aaw()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.6
                        SwanAppPropertyWindow caY;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.caY == null) {
                                this.caY = com.baidu.swan.apps.v.f.akr().I(a.this.mActivity);
                            }
                            this.caY.setVisibility(this.caY.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.ahm().et(a.this.RU())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.adw().adL()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(arz.getVersion()) ? "" : arz.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.e.a.iO(arw.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), arz.aiZ());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(arz.aiZ()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.e(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).og(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).fh(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.7.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.ard();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aaw()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String hr;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.aaw()) {
                                    hr = com.baidu.swan.apps.swancore.a.auX().hr(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    hr = com.baidu.swan.apps.swancore.a.auX().hr(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.e(string).og(hr).a(new com.baidu.swan.apps.view.c.a()).fh(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.ard();
                            }
                        }
                    });
                }
                if (k.aoa().isAvailable()) {
                    View inflate3 = ((ViewStub) view.findViewById(a.f.ai_app_report_performance)).inflate();
                    if (inflate3 instanceof Button) {
                        Button button2 = (Button) inflate3;
                        button2.setText(a.h.aiapps_debug_report_performance);
                        button2.setOnClickListener(new AnonymousClass9());
                    }
                }
                View inflate4 = ((ViewStub) view.findViewById(a.f.ai_app_start_inspector)).inflate();
                if (inflate4 instanceof Button) {
                    ((Button) inflate4).setText(a.h.aiapps_debug_start_inspect);
                }
                inflate4.setOnClickListener(new AnonymousClass10());
            }
            if (b(ajw)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        al.cE(a.this.getContext());
                        a.this.bc("click", "baozhang");
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$9  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.aoa().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.9.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void jG(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.9.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.fi(a.h.aiapps_debug_report_performance).og(str).a(new com.baidu.swan.apps.view.c.a()).fh(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.ard();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$10  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass10 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a cbf;

        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.fi(a.h.aiapps_debug_start_inspect).fh(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).fh(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass10.this.cbf = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.ahj());
                        AnonymousClass10.this.cbf.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass10.this.aac();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass10.this.aac();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.ard();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aac() {
            if (this.cbf != null) {
                this.cbf.stop();
                this.cbf = null;
            }
        }
    }

    private boolean a(PMSAppInfo pMSAppInfo) {
        return (com.baidu.swan.apps.runtime.d.arr().RU() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void ZN() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.caS.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.ag.c cVar = new com.baidu.swan.apps.ag.c(getContext());
        this.caS.setAdapter(cVar);
        com.baidu.swan.apps.ag.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.12
            @Override // com.baidu.swan.apps.ag.b.a
            public void a(final com.baidu.swan.apps.ag.a aVar) {
                if (aVar != null) {
                    if (!((aVar.cBL == null) | (aVar.cBL.size() <= 0))) {
                        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.caS.setVisibility(0);
                                cVar.b(aVar);
                            }
                        });
                        com.baidu.swan.apps.ag.c.G("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && al.axe();
    }

    private void ZO() {
        if (com.baidu.swan.apps.database.favorite.a.ky(com.baidu.swan.apps.runtime.d.arr().getAppId())) {
            this.caR.setText(a.h.swanapp_favored);
            this.caR.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.caR.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.caR.setText(a.h.swanapp_add_favor);
        this.caR.setTextColor(-1);
        this.caR.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZP() {
        if (com.baidu.swan.apps.runtime.e.arw() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.arw(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // com.baidu.swan.apps.core.c.c.a
                public void h(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.R(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.XA()) {
                        com.baidu.swan.apps.console.a.bG(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aDN().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.2.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void dG(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bG(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aDN().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void eX(int i) {
        ai.a(this.caK, this.caL, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void Vn() {
        FragmentActivity aMt = aMt();
        if (aMt != null && this.cbu == null) {
            this.cbu = new com.baidu.swan.menu.h(aMt, this.cbt, 13, com.baidu.swan.apps.t.a.ahn(), new com.baidu.swan.apps.view.c.b());
            if (!aaw()) {
                this.cbu.jr(35);
                this.cbu.jr(37);
            }
            new com.baidu.swan.apps.x.a(this.cbu, this).amc();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ZQ() {
        Vn();
        this.cbu.show(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean Vi() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ZR() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean UJ() {
        return false;
    }

    public static a ZS() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            ZV();
        } else if (id == a.f.open_app_button) {
            ZW();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.caO);
            bc("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            ZX();
        } else if (id == a.f.share_friends) {
            ZU();
        } else if (id == a.f.add_favor) {
            ZT();
        }
    }

    private void ZT() {
        String appId = com.baidu.swan.apps.runtime.d.arr().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.ky(appId)) {
                jE(appId);
            } else {
                jF(appId);
            }
            ZO();
        }
    }

    private void jE(String str) {
        SwanFavorDataManager.aft().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.3
            @Override // com.baidu.swan.apps.favordata.a.b
            public void ZY() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).hc(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void ZZ() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).hc(2).showToast();
            }
        }, com.baidu.swan.apps.env.b.c.aeQ().fy(3).aeR());
        bc("click", "aboutmove");
    }

    private void jF(String str) {
        if (com.baidu.swan.apps.ae.a.a.apg()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.bPE = null;
        final String page = al.axg().getPage();
        SwanFavorDataManager.aft().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aaa() {
                com.baidu.swan.apps.database.favorite.a.aen();
                if (com.baidu.swan.apps.x.a.J(a.this.aMt())) {
                    com.baidu.swan.apps.x.a.bA("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).hc(2).gY(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aab() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).hc(2).showToast();
            }
        });
        com.baidu.swan.apps.x.a.bA("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void ZU() {
        e eVar;
        f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && (eVar = (e) Sc.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.aaL());
            com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bc("click", "aboutshare");
        }
    }

    private void ZV() {
        System.arraycopy(this.caN, 1, this.caN, 0, this.caN.length - 1);
        this.caN[this.caN.length - 1] = SystemClock.uptimeMillis();
        if (this.caN[0] >= SystemClock.uptimeMillis() - 1000) {
            Ba();
        }
    }

    private void ZW() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw != null) {
            b.a arz = arw.arz();
            String ajp = arz.ajp();
            String ajq = arz.ajq();
            if (TextUtils.isEmpty(ajp) || TextUtils.isEmpty(ajq)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String ce = al.ce(ajp, ajq);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(ce), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void ZX() {
        i.jR(this.caQ).jS(getString(a.h.swan_app_service_agreement)).dQ(false).abq();
        bc("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.caO = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
                this.caP = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.caO) && !TextUtils.isEmpty(this.caP) && (length = this.caP.length()) >= 20) {
                    if (length > 100) {
                        this.caP = this.caP.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.caP);
                    com.baidu.swan.apps.ag.c.G(Constants.PHONE_BRAND, null, "show");
                    ZN();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Ba() {
        String Q = o.Q(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Q).showMultiToast();
        com.baidu.swan.apps.console.c.aW("SwanAppAboutFragment", "showExtraInfo\n" + Q);
        this.caN = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(String str, String str2) {
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
