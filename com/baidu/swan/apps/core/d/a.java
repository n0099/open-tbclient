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
/* loaded from: classes25.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private BdBaseImageView cOA;
    private TextView cOB;
    private com.baidu.swan.apps.view.a cOC;
    private long[] cOD = new long[5];
    private String cOE;
    private String cOF;
    private String cOG;
    private Button cOH;
    private RecyclerView cOI;
    private SwanAppRoundedImageView cOz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        at(inflate);
        an(inflate);
        if (immersionEnabled()) {
            inflate = initImmersion(inflate);
        }
        return enableSliding(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cOC != null) {
            this.cOC.aPV();
        }
        setRequestedOrientation(1);
        if (this.cPl != null && this.cPl.isShowing()) {
            this.cPl.ii(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState());
        }
        if (this.cOH != null) {
            aqn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void at(View view) {
        av(view);
        fa(true);
        iq(-1);
        ir(ViewCompat.MEASURED_STATE_MASK);
        nv(null);
        fe(true);
    }

    private void an(View view) {
        final com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV != null && aJV.aJY() != null) {
            final b.a aJY = aJV.aJY();
            this.cOz = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aJY.avf());
            if (aJY.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.apv();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aGp().aGq().bindView(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aJY.aAO());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cOH = (Button) view.findViewById(a.f.add_favor);
            this.cOH.setOnClickListener(this);
            aqn();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aJY.aAT());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aJY.aAU());
            this.cOG = com.baidu.swan.apps.t.a.azm().akE();
            if (!TextUtils.isEmpty(this.cOG)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cOI = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo aBu = aJY.aBu();
            if (a(aBu)) {
                e(view, aBu.brandsInfo);
            }
            this.cOB = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cOA = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cOz.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aJY, "SwanAppAboutFragment", false));
            this.cOz.setOnClickListener(this);
            SwanAppBearInfo aAV = aJY.aAV();
            if (aAV != null && aAV.isValid()) {
                this.cOC = new com.baidu.swan.apps.view.a(this.mActivity, view, aAV, a.f.bear_layout);
            }
            io(aJY.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.aCp().aBT()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aqV() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aJY.aBq() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cOR;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cOR == null) {
                                    this.cOR = com.baidu.swan.apps.v.f.aCp().I(a.this.mActivity);
                                }
                                if (a.this.aqV()) {
                                    if (com.baidu.swan.apps.console.a.anV()) {
                                        com.baidu.swan.apps.console.a.r(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aWN().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void eZ(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.r(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aWN().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cOR.setVisibility(this.cOR.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aqV()) {
                                a.this.aqo();
                            } else {
                                com.baidu.swan.apps.console.a.cy(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aqV()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cOT;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cOT == null) {
                                this.cOT = com.baidu.swan.apps.v.f.aCp().J(a.this.mActivity);
                            }
                            this.cOT.setVisibility(this.cOT.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.azd().hM(a.this.aie())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.aui().asG()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aJY.getVersion()) ? "" : aJY.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.mD(aJV.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aJY.aAX());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aJY.aAX()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).st(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gJ(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aJB();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aqV()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String kV;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.aqV()) {
                                    kV = com.baidu.swan.apps.swancore.a.aNs().kV(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    kV = com.baidu.swan.apps.swancore.a.aNs().kV(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).st(kV).a(new com.baidu.swan.apps.view.c.a()).gJ(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aJB();
                            }
                        }
                    });
                }
                if (k.aGj().isAvailable()) {
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
            if (b(aBu)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.dw(a.this.getContext());
                        a.this.bC("click", "baozhang");
                    }
                });
            }
            if (!aqV()) {
                a(this.cOz, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.aql();
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$12  reason: invalid class name */
    /* loaded from: classes25.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.aGj().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void nu(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.iz(a.h.aiapps_debug_report_performance).st(str).a(new com.baidu.swan.apps.view.c.a()).gJ(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aJB();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$13  reason: invalid class name */
    /* loaded from: classes25.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a cPa;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.iz(a.h.aiapps_debug_start_inspect).iy(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gJ(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cPa = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aza());
                        AnonymousClass13.this.cPa.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aqB();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aqB();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aJB();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aqB() {
            if (this.cPa != null) {
                this.cPa.stop();
                this.cPa = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.al.j.b.a.aOa().aOb();
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
    public void aql() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().aBu().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.dA(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.t(this.mActivity, a.h.swanapp_web_url_copy_fail).showToast();
                return;
            }
            String bB = bB(str, com.baidu.swan.apps.model.b.d(ak.aPA()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bB.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bB;
            }
            al.dA(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.t(this.mActivity, i).showToast();
        }
    }

    @NonNull
    private String bB(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aJQ().aie() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void aqm() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cOI.setLayoutManager(linearLayoutManager);
        final com.baidu.swan.apps.af.c cVar = new com.baidu.swan.apps.af.c(getContext());
        this.cOI.setAdapter(cVar);
        com.baidu.swan.apps.af.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.af.b.a
            public void a(final com.baidu.swan.apps.af.a aVar) {
                if (aVar != null) {
                    if (!((aVar.drV == null) | (aVar.drV.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cOI.setVisibility(0);
                                cVar.b(aVar);
                            }
                        });
                        com.baidu.swan.apps.af.c.S("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aPy();
    }

    private void aqn() {
        if (com.baidu.swan.apps.database.favorite.a.or(com.baidu.swan.apps.runtime.d.aJQ().getAppId())) {
            this.cOH.setText(a.h.swanapp_favored);
            this.cOH.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cOH.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cOH.setText(a.h.swanapp_add_favor);
        this.cOH.setTextColor(-1);
        this.cOH.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqo() {
        if (com.baidu.swan.apps.runtime.e.aJV() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aJV(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void j(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.ab(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.anV()) {
                        com.baidu.swan.apps.console.a.cy(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aWN().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void eZ(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.cy(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aWN().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void io(int i) {
        ah.a(this.cOA, this.cOB, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void alI() {
        FragmentActivity bff = bff();
        if (bff != null && this.cPl == null) {
            this.cPl = new com.baidu.swan.menu.h(bff, this.cPk, 13, com.baidu.swan.apps.t.a.aze(), new com.baidu.swan.apps.view.c.b());
            if (!aqV()) {
                this.cPl.mX(35);
                this.cPl.mX(37);
            }
            new com.baidu.swan.apps.menu.a(this.cPl, this).aEe();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aqp() {
        alI();
        this.cPl.show(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aqq() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean alb() {
        return false;
    }

    public static a aqr() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            aqu();
        } else if (id == a.f.open_app_button) {
            aqv();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cOE);
            bC("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            aqw();
        } else if (id == a.f.share_friends) {
            aqt();
        } else if (id == a.f.add_favor) {
            aqs();
        }
    }

    private void aqs() {
        String appId = com.baidu.swan.apps.runtime.d.aJQ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.or(appId)) {
                ns(appId);
            } else {
                nt(appId);
            }
            aqn();
        }
    }

    private void ns(String str) {
        SwanFavorDataManager.awR().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aqx() {
                com.baidu.swan.apps.res.widget.b.d.t(a.this.getContext(), a.h.aiapps_cancel_fav_success).kG(2).showHighlightToast();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aqy() {
                com.baidu.swan.apps.res.widget.b.d.t(a.this.getContext(), a.h.aiapps_cancel_fav_fail).kG(2).showToast();
            }
        }, com.baidu.swan.apps.env.c.c.awn().iQ(3).awo());
        bC("click", "aboutmove");
    }

    private void nt(String str) {
        if (com.baidu.swan.apps.ad.a.a.aHr()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.t(getContext(), a.h.aiapps_debug_forbid_favor).showToast();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cDe = null;
        final String page = ak.aPA().getPage();
        SwanFavorDataManager.awR().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aqz() {
                com.baidu.swan.apps.database.favorite.a.avo();
                if (com.baidu.swan.apps.menu.a.D(a.this.bff())) {
                    com.baidu.swan.apps.menu.a.cf("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.t(a.this.getContext(), a.h.aiapps_fav_success).kG(2).kC(2).showToast();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aqA() {
                com.baidu.swan.apps.res.widget.b.d.t(a.this.getContext(), a.h.aiapps_fav_fail).kG(2).showToast();
            }
        });
        com.baidu.swan.apps.menu.a.cf("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aqt() {
        e eVar;
        f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null && (eVar = (e) aim.q(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.arl());
            com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bC("click", "aboutshare");
        }
    }

    private void aqu() {
        System.arraycopy(this.cOD, 1, this.cOD, 0, this.cOD.length - 1);
        this.cOD[this.cOD.length - 1] = SystemClock.uptimeMillis();
        if (this.cOD[0] >= SystemClock.uptimeMillis() - 1000) {
            Kd();
        }
    }

    private void aqv() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV != null) {
            b.a aJY = aJV.aJY();
            String aBn = aJY.aBn();
            String aBo = aJY.aBo();
            if (TextUtils.isEmpty(aBn) || TextUtils.isEmpty(aBo)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cP = ak.cP(aBn, aBo);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cP), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void aqw() {
        i.nF(this.cOG).nG(getString(a.h.swan_app_service_agreement)).fj(false).arR();
        bC("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cOE = jSONObject.optString("scheme");
                this.cOF = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cOE) && !TextUtils.isEmpty(this.cOF) && (length = this.cOF.length()) >= 20) {
                    if (length > 100) {
                        this.cOF = this.cOF.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cOF);
                    com.baidu.swan.apps.af.c.S(Constants.PHONE_BRAND, null, "show");
                    aqm();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Kd() {
        String Q = o.Q(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Q).showMultiToast();
        com.baidu.swan.apps.console.c.bt("SwanAppAboutFragment", "showExtraInfo\n" + Q);
        this.cOD = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(String str, String str2) {
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
