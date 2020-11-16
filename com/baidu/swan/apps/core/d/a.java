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
/* loaded from: classes7.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView cHG;
    private BdBaseImageView cHH;
    private TextView cHI;
    private com.baidu.swan.apps.view.a cHJ;
    private long[] cHK = new long[5];
    private String cHL;
    private String cHM;
    private String cHN;
    private Button cHO;
    private RecyclerView cHP;

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
        if (this.cHJ != null) {
            this.cHJ.aMP();
        }
        setRequestedOrientation(1);
        if (this.cIs != null && this.cIs.isShowing()) {
            this.cIs.hT(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState());
        }
        if (this.cHO != null) {
            anf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void ar(View view) {
        at(view);
        eL(true);
        hS(-1);
        hT(ViewCompat.MEASURED_STATE_MASK);
        mO(null);
        eP(true);
    }

    private void al(View view) {
        final com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN != null && aGN.aGQ() != null) {
            final b.a aGQ = aGN.aGQ();
            this.cHG = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aGQ.arW());
            if (aGQ.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.amm();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aDh().aDi().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aGQ.axF());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cHO = (Button) view.findViewById(a.f.add_favor);
            this.cHO.setOnClickListener(this);
            anf();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aGQ.axK());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aGQ.axL());
            this.cHN = com.baidu.swan.apps.t.a.awe().ahw();
            if (!TextUtils.isEmpty(this.cHN)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cHP = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo ayl = aGQ.ayl();
            if (a(ayl)) {
                e(view, ayl.brandsInfo);
            }
            this.cHI = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cHH = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cHG.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aGQ, "SwanAppAboutFragment", false));
            this.cHG.setOnClickListener(this);
            SwanAppBearInfo axM = aGQ.axM();
            if (axM != null && axM.isValid()) {
                this.cHJ = new com.baidu.swan.apps.view.a(this.mActivity, view, axM, a.f.bear_layout);
            }
            hQ(aGQ.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.azg().ayK()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (anN() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aGQ.ayh() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cHY;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cHY == null) {
                                    this.cHY = com.baidu.swan.apps.v.f.azg().I(a.this.mActivity);
                                }
                                if (a.this.anN()) {
                                    if (com.baidu.swan.apps.console.a.akN()) {
                                        com.baidu.swan.apps.console.a.m(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aTI().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void eK(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.m(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aTI().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cHY.setVisibility(this.cHY.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.anN()) {
                                a.this.ang();
                            } else {
                                com.baidu.swan.apps.console.a.bS(a.this.getContext());
                            }
                        }
                    }
                });
                if (!anN()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cIa;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cIa == null) {
                                this.cIa = com.baidu.swan.apps.v.f.azg().J(a.this.mActivity);
                            }
                            this.cIa.setVisibility(this.cIa.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.avV().ho(a.this.aeW())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.ara().apy()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aGQ.getVersion()) ? "" : aGQ.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.lW(aGN.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aGQ.axO());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aGQ.axO()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).rL(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gu(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aGt();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (anN()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String kx;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.anN()) {
                                    kx = com.baidu.swan.apps.swancore.a.aKl().kx(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    kx = com.baidu.swan.apps.swancore.a.aKl().kx(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).rL(kx).a(new com.baidu.swan.apps.view.c.a()).gu(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aGt();
                            }
                        }
                    });
                }
                if (k.aDb().isAvailable()) {
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
            if (b(ayl)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.cQ(a.this.getContext());
                        a.this.bv("click", "baozhang");
                    }
                });
            }
            if (!anN()) {
                a(this.cHG, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.and();
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$12  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.aDb().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void mN(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.ib(a.h.aiapps_debug_report_performance).rL(str).a(new com.baidu.swan.apps.view.c.a()).gu(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aGt();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$13  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a cIh;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.ib(a.h.aiapps_debug_start_inspect).ia(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gu(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cIh = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.avS());
                        AnonymousClass13.this.cIh.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.ant();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.ant();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aGt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ant() {
            if (this.cIh != null) {
                this.cIh.stop();
                this.cIh = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aKT().aKU();
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
    public void and() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ().ayl().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.cU(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bu = bu(str, com.baidu.swan.apps.model.b.d(ak.aMu()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bu.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bu;
            }
            al.cU(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.k(this.mActivity, i).showToast();
        }
    }

    @NonNull
    private String bu(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aGI().aeW() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void ane() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cHP.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.cHP.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dkV == null) | (aVar.dkV.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cHP.setVisibility(0);
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
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aMs();
    }

    private void anf() {
        if (com.baidu.swan.apps.database.favorite.a.nI(com.baidu.swan.apps.runtime.d.aGI().getAppId())) {
            this.cHO.setText(a.h.swanapp_favored);
            this.cHO.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cHO.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cHO.setText(a.h.swanapp_add_favor);
        this.cHO.setTextColor(-1);
        this.cHO.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ang() {
        if (com.baidu.swan.apps.runtime.e.aGN() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aGN(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void k(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.Y(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.akN()) {
                        com.baidu.swan.apps.console.a.bS(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aTI().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void eK(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.bS(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aTI().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void hQ(int i) {
        ah.a(this.cHH, this.cHI, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiA() {
        FragmentActivity bca = bca();
        if (bca != null && this.cIs == null) {
            this.cIs = new com.baidu.swan.menu.h(bca, this.cIr, 13, com.baidu.swan.apps.t.a.avW(), new com.baidu.swan.apps.view.c.b());
            if (!anN()) {
                this.cIs.mz(35);
                this.cIs.mz(37);
            }
            new com.baidu.swan.apps.menu.a(this.cIs, this).aAV();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anh() {
        aiA();
        this.cIs.show(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiu() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ahT() {
        return false;
    }

    public static a anj() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            anm();
        } else if (id == a.f.open_app_button) {
            ann();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cHL);
            bv("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            ano();
        } else if (id == a.f.share_friends) {
            anl();
        } else if (id == a.f.add_favor) {
            ank();
        }
    }

    private void ank() {
        String appId = com.baidu.swan.apps.runtime.d.aGI().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nI(appId)) {
                mL(appId);
            } else {
                mM(appId);
            }
            anf();
        }
    }

    private void mL(String str) {
        SwanFavorDataManager.atJ().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anp() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_success).ki(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anq() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_cancel_fav_fail).ki(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.atf().is(3).atg());
        bv("click", "aboutmove");
    }

    private void mM(String str) {
        if (com.baidu.swan.apps.ad.a.a.aEj()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.k(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cwm = null;
        final String page = ak.aMu().getPage();
        SwanFavorDataManager.atJ().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anr() {
                com.baidu.swan.apps.database.favorite.a.asf();
                if (com.baidu.swan.apps.menu.a.D(a.this.bca())) {
                    com.baidu.swan.apps.menu.a.bY("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_success).ki(2).ke(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void ans() {
                com.baidu.swan.apps.res.widget.b.d.k(a.this.getContext(), a.h.aiapps_fav_fail).ki(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.bY("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anl() {
        e eVar;
        f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null && (eVar = (e) afe.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.aod());
            com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bv("click", "aboutshare");
        }
    }

    private void anm() {
        System.arraycopy(this.cHK, 1, this.cHK, 0, this.cHK.length - 1);
        this.cHK[this.cHK.length - 1] = SystemClock.uptimeMillis();
        if (this.cHK[0] >= SystemClock.uptimeMillis() - 1000) {
            Im();
        }
    }

    private void ann() {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN != null) {
            b.a aGQ = aGN.aGQ();
            String aye = aGQ.aye();
            String ayf = aGQ.ayf();
            if (TextUtils.isEmpty(aye) || TextUtils.isEmpty(ayf)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cI = ak.cI(aye, ayf);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cI), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void ano() {
        i.mY(this.cHN).mZ(getString(a.h.swan_app_service_agreement)).eU(false).aoJ();
        bv("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cHL = jSONObject.optString("scheme");
                this.cHM = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cHL) && !TextUtils.isEmpty(this.cHM) && (length = this.cHM.length()) >= 20) {
                    if (length > 100) {
                        this.cHM = this.cHM.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cHM);
                    com.baidu.swan.apps.af.c.P(Constants.PHONE_BRAND, null, "show");
                    ane();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Im() {
        String Q = o.Q(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Q).showMultiToast();
        com.baidu.swan.apps.console.c.bm("SwanAppAboutFragment", "showExtraInfo\n" + Q);
        this.cHK = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(String str, String str2) {
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
