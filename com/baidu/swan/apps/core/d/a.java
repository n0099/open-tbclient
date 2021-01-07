package com.baidu.swan.apps.core.d;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
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
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.al;
import com.baidu.swan.apps.ao.o;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.c.c;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.swan.apps.relateswans.b;
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
/* loaded from: classes9.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cTA;
    private String cTB;
    private Button cTC;
    private RecyclerView cTD;
    private SwanAppRoundedImageView cTu;
    private BdBaseImageView cTv;
    private TextView cTw;
    private com.baidu.swan.apps.view.a cTx;
    private long[] cTy = new long[5];
    private String cTz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        av(inflate);
        ap(inflate);
        if (asf()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cTx != null) {
            this.cTx.aSp();
        }
        setRequestedOrientation(1);
        if (this.cUg != null && this.cUg.isShowing()) {
            this.cUg.iC(com.baidu.swan.apps.t.a.aAO().alE());
        }
        if (this.cTC != null) {
            arA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        ay(view);
        fj(true);
        ik(-1);
        il(ViewCompat.MEASURED_STATE_MASK);
        no(null);
        fn(true);
    }

    private void ap(View view) {
        final com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm != null && aMm.aMp() != null) {
            final b.a aMp = aMm.aMp();
            this.cTu = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aMp.awy());
            if (aMp.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.aqI();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aHJ().aHK().aG(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aMp.aCg());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cTC = (Button) view.findViewById(a.f.add_favor);
            this.cTC.setOnClickListener(this);
            arA();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aMp.aCl());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aMp.aCm());
            this.cTB = com.baidu.swan.apps.t.a.aAE().alP();
            if (!TextUtils.isEmpty(this.cTB)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cTD = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo aCM = aMp.aCM();
            if (a(aCM)) {
                e(view, aCM.brandsInfo);
            }
            this.cTw = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cTv = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cTu.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aMp, "SwanAppAboutFragment", false));
            this.cTu.setOnClickListener(this);
            SwanAppBearInfo aCn = aMp.aCn();
            if (aCn != null && aCn.isValid()) {
                this.cTx = new com.baidu.swan.apps.view.a(this.mActivity, view, aCn, a.f.bear_layout);
            }
            ii(aMp.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.aDH().aDl()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aso() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aMp.aCI() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cTM;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cTM == null) {
                                    this.cTM = com.baidu.swan.apps.v.f.aDH().H(a.this.mActivity);
                                }
                                if (a.this.aso()) {
                                    if (com.baidu.swan.apps.console.a.aph()) {
                                        com.baidu.swan.apps.console.a.p(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aZi().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void fi(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.p(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aZi().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cTM.setVisibility(this.cTM.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aso()) {
                                a.this.arB();
                            } else {
                                com.baidu.swan.apps.console.a.cG(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aso()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cTO;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cTO == null) {
                                this.cTO = com.baidu.swan.apps.v.f.aDH().I(a.this.mActivity);
                            }
                            this.cTO.setVisibility(this.cTO.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.aAv().hG(a.this.ajl())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.avB().atY()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aMp.getVersion()) ? "" : aMp.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.mw(aMm.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aMp.aCp());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aMp.aCp()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).sp(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gV(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aLy();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aso()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String la;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.aso()) {
                                    la = com.baidu.swan.apps.swancore.a.aPJ().la(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    la = com.baidu.swan.apps.swancore.a.aPJ().la(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).sp(la).a(new com.baidu.swan.apps.view.c.a()).gV(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aLy();
                            }
                        }
                    });
                }
                if (k.aHD().isAvailable()) {
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
            if (b(aCM)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.dP(a.this.getContext());
                        a.this.bB("click", "baozhang");
                    }
                });
            }
            if (!aso()) {
                a(this.cTu, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.ary();
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$12  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.mActivity != null) {
                k.aHD().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void nn(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.iu(a.h.aiapps_debug_report_performance).sp(str).a(new com.baidu.swan.apps.view.c.a()).gV(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aLy();
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.apps.core.d.a$13  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        com.baidu.swan.apps.console.v8inspector.a cTV;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.iu(a.h.aiapps_debug_start_inspect).it(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gV(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cTV = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aAs());
                        AnonymousClass13.this.cTV.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.arO();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.arO();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aLy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void arO() {
            if (this.cTV != null) {
                this.cTV.stop();
                this.cTV = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.ak.j.b.a.aQr().aQt();
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
    public void ary() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aMh().aMd().aMp().aCM().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.dT(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.swanapp_web_url_copy_fail).aLT();
                return;
            }
            String bA = bA(str, com.baidu.swan.apps.model.b.d(ak.aRS()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bA.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bA;
            }
            al.dT(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, i).aLT();
        }
    }

    @NonNull
    private String bA(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aMh().ajl() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void arz() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cTD.setLayoutManager(linearLayoutManager);
        final SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
        this.cTD.setAdapter(swanAppRelatedSwanListAdapter);
        com.baidu.swan.apps.relateswans.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.relateswans.b.a
            public void a(final com.baidu.swan.apps.relateswans.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dwT == null) | (aVar.dwT.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cTD.setVisibility(0);
                                swanAppRelatedSwanListAdapter.b(aVar);
                            }
                        });
                        SwanAppRelatedSwanListAdapter.V("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aRQ();
    }

    private void arA() {
        if (com.baidu.swan.apps.database.favorite.a.oj(com.baidu.swan.apps.runtime.d.aMh().getAppId())) {
            this.cTC.setText(a.h.swanapp_favored);
            this.cTC.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cTC.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cTC.setText(a.h.swanapp_add_favor);
        this.cTC.setTextColor(-1);
        this.cTC.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arB() {
        if (com.baidu.swan.apps.runtime.e.aMm() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aMm(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void j(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.ah(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.aph()) {
                        com.baidu.swan.apps.console.a.cG(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aZi().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void fi(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.cG(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aZi().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void ii(int i) {
        ah.a(this.cTv, this.cTw, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void amT() {
        FragmentActivity bhB = bhB();
        if (bhB != null && this.cUg == null) {
            this.cUg = new com.baidu.swan.menu.g(bhB, this.cUf, 13, com.baidu.swan.apps.t.a.aAw(), new com.baidu.swan.apps.view.c.b());
            if (!aso()) {
                this.cUg.ng(35);
                this.cUg.ng(37);
            }
            new com.baidu.swan.apps.menu.a(this.cUg, this).aFy();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void arC() {
        amT();
        this.cUg.show(com.baidu.swan.apps.t.a.aAO().alE());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean amN() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean arD() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean amm() {
        return false;
    }

    public static a arE() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            arH();
        } else if (id == a.f.open_app_button) {
            arI();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cTz);
            bB("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            arJ();
        } else if (id == a.f.share_friends) {
            arG();
        } else if (id == a.f.add_favor) {
            arF();
        }
    }

    private void arF() {
        String appId = com.baidu.swan.apps.runtime.d.aMh().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.oj(appId)) {
                nl(appId);
            } else {
                nm(appId);
            }
            arA();
        }
    }

    private void nl(String str) {
        SwanFavorDataManager.ayk().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void arK() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_success).kM(2).aLW();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void arL() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_fail).kM(2).aLT();
            }
        }, com.baidu.swan.apps.env.c.c.axG().iL(3).axH());
        bB("click", "aboutmove");
    }

    private void nm(String str) {
        if (com.baidu.swan.apps.ad.a.a.aIL()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_debug_forbid_favor).aLT();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cHU = null;
        final String page = ak.aRS().getPage();
        SwanFavorDataManager.ayk().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void arM() {
                com.baidu.swan.apps.database.favorite.a.awH();
                if (com.baidu.swan.apps.menu.a.C(a.this.bhB())) {
                    com.baidu.swan.apps.menu.a.ce("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_success).kM(2).kI(2).aLT();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void arN() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_fail).kM(2).aLT();
            }
        });
        com.baidu.swan.apps.menu.a.ce("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void arG() {
        e eVar;
        f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null && (eVar = (e) ajt.j(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.asE());
            com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bB("click", "aboutshare");
        }
    }

    private void arH() {
        System.arraycopy(this.cTy, 1, this.cTy, 0, this.cTy.length - 1);
        this.cTy[this.cTy.length - 1] = SystemClock.uptimeMillis();
        if (this.cTy[0] >= SystemClock.uptimeMillis() - 1000) {
            JF();
        }
    }

    private void arI() {
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm != null) {
            b.a aMp = aMm.aMp();
            String aCF = aMp.aCF();
            String aCG = aMp.aCG();
            if (TextUtils.isEmpty(aCF) || TextUtils.isEmpty(aCG)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cO = ak.cO(aCF, aCG);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cO), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void arJ() {
        i.ny(this.cTB).nz(getString(a.h.swan_app_service_agreement)).fs(false).atk();
        bB("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cTz = jSONObject.optString("scheme");
                this.cTA = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cTz) && !TextUtils.isEmpty(this.cTA) && (length = this.cTA.length()) >= 20) {
                    if (length > 100) {
                        this.cTA = this.cTA.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cTA);
                    SwanAppRelatedSwanListAdapter.V(Constants.PHONE_BRAND, null, "show");
                    arz();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void JF() {
        String R = o.R(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), R).aLU();
        com.baidu.swan.apps.console.c.bs("SwanAppAboutFragment", "showExtraInfo\n" + R);
        this.cTy = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(String str, String str2) {
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
