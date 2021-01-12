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
/* loaded from: classes8.dex */
public class a extends c implements View.OnClickListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SwanAppRoundedImageView cOI;
    private BdBaseImageView cOJ;
    private TextView cOK;
    private com.baidu.swan.apps.view.a cOL;
    private long[] cOM = new long[5];
    private String cON;
    private String cOO;
    private String cOP;
    private Button cOQ;
    private RecyclerView cOR;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        av(inflate);
        ap(inflate);
        if (aok()) {
            inflate = az(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cOL != null) {
            this.cOL.aOv();
        }
        setRequestedOrientation(1);
        if (this.cPu != null && this.cPu.isShowing()) {
            this.cPu.iy(com.baidu.swan.apps.t.a.awU().ahK());
        }
        if (this.cOQ != null) {
            anF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void av(View view) {
        ay(view);
        ff(true);
        gE(-1);
        gF(ViewCompat.MEASURED_STATE_MASK);
        md(null);
        fj(true);
    }

    private void ap(View view) {
        final com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs != null && aIs.aIv() != null) {
            final b.a aIv = aIs.aIv();
            this.cOI = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aIv.asE());
            if (aIv.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.amN();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().aG(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aIv.aym());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cOQ = (Button) view.findViewById(a.f.add_favor);
            this.cOQ.setOnClickListener(this);
            anF();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aIv.ayr());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aIv.ays());
            this.cOP = com.baidu.swan.apps.t.a.awK().ahV();
            if (!TextUtils.isEmpty(this.cOP)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cOR = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo ayS = aIv.ayS();
            if (a(ayS)) {
                e(view, ayS.brandsInfo);
            }
            this.cOK = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cOJ = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cOI.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aIv, "SwanAppAboutFragment", false));
            this.cOI.setOnClickListener(this);
            SwanAppBearInfo ayt = aIv.ayt();
            if (ayt != null && ayt.isValid()) {
                this.cOL = new com.baidu.swan.apps.view.a(this.mActivity, view, ayt, a.f.bear_layout);
            }
            gC(aIv.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.azN().azr()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aos() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aIv.ayO() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cPa;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cPa == null) {
                                    this.cPa = com.baidu.swan.apps.v.f.azN().H(a.this.mActivity);
                                }
                                if (a.this.aos()) {
                                    if (com.baidu.swan.apps.console.a.aln()) {
                                        com.baidu.swan.apps.console.a.p(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aVo().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void fe(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.p(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aVo().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cPa.setVisibility(this.cPa.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aos()) {
                                a.this.anG();
                            } else {
                                com.baidu.swan.apps.console.a.cF(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aos()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cPc;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cPc == null) {
                                this.cPc = com.baidu.swan.apps.v.f.azN().I(a.this.mActivity);
                            }
                            this.cPc.setVisibility(this.cPc.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.awB().fZ(a.this.afr())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.arG().aqd()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aIv.getVersion()) ? "" : aIv.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.ll(aIs.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aIv.ayv());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aIv.ayv()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).re(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gR(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aHE();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aos()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String ju;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.aos()) {
                                    ju = com.baidu.swan.apps.swancore.a.aLP().ju(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    ju = com.baidu.swan.apps.swancore.a.aLP().ju(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).re(ju).a(new com.baidu.swan.apps.view.c.a()).gR(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aHE();
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
            if (b(ayS)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.dO(a.this.getContext());
                        a.this.bA("click", "baozhang");
                    }
                });
            }
            if (!aos()) {
                a(this.cOI, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.anD();
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
                k.aDJ().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void mc(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.gO(a.h.aiapps_debug_report_performance).re(str).a(new com.baidu.swan.apps.view.c.a()).gR(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aHE();
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
        com.baidu.swan.apps.console.v8inspector.a cPj;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.gO(a.h.aiapps_debug_start_inspect).gN(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gR(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cPj = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awy());
                        AnonymousClass13.this.cPj.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.anT();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.anT();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aHE();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void anT() {
            if (this.cPj != null) {
                this.cPj.stop();
                this.cPj = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.ak.j.b.a.aMx().aMz();
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
    public void anD() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayS().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.dS(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.swanapp_web_url_copy_fail).aHZ();
                return;
            }
            String bz = bz(str, com.baidu.swan.apps.model.b.d(ak.aNY()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bz.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bz;
            }
            al.dS(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, i).aHZ();
        }
    }

    @NonNull
    private String bz(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aIn().afr() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void anE() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cOR.setLayoutManager(linearLayoutManager);
        final SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
        this.cOR.setAdapter(swanAppRelatedSwanListAdapter);
        com.baidu.swan.apps.relateswans.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.relateswans.b.a
            public void a(final com.baidu.swan.apps.relateswans.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dsf == null) | (aVar.dsf.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cOR.setVisibility(0);
                                swanAppRelatedSwanListAdapter.b(aVar);
                            }
                        });
                        SwanAppRelatedSwanListAdapter.U("aboutrelated", null, "show");
                    }
                }
            }
        });
    }

    private boolean b(PMSAppInfo pMSAppInfo) {
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aNW();
    }

    private void anF() {
        if (com.baidu.swan.apps.database.favorite.a.mX(com.baidu.swan.apps.runtime.d.aIn().getAppId())) {
            this.cOQ.setText(a.h.swanapp_favored);
            this.cOQ.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cOQ.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cOQ.setText(a.h.swanapp_add_favor);
        this.cOQ.setTextColor(-1);
        this.cOQ.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anG() {
        if (com.baidu.swan.apps.runtime.e.aIs() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aIs(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void j(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.ah(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.aln()) {
                        com.baidu.swan.apps.console.a.cF(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aVo().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void fe(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.cF(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aVo().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void gC(int i) {
        ah.a(this.cOJ, this.cOK, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aiZ() {
        FragmentActivity bdH = bdH();
        if (bdH != null && this.cPu == null) {
            this.cPu = new com.baidu.swan.menu.g(bdH, this.cPt, 13, com.baidu.swan.apps.t.a.awC(), new com.baidu.swan.apps.view.c.b());
            if (!aos()) {
                this.cPu.lA(35);
                this.cPu.lA(37);
            }
            new com.baidu.swan.apps.menu.a(this.cPu, this).aBE();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void anH() {
        aiZ();
        this.cPu.show(com.baidu.swan.apps.t.a.awU().ahK());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aiT() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean anI() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean ais() {
        return false;
    }

    public static a anJ() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            anM();
        } else if (id == a.f.open_app_button) {
            anN();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cON);
            bA("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            anO();
        } else if (id == a.f.share_friends) {
            anL();
        } else if (id == a.f.add_favor) {
            anK();
        }
    }

    private void anK() {
        String appId = com.baidu.swan.apps.runtime.d.aIn().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.mX(appId)) {
                ma(appId);
            } else {
                mb(appId);
            }
            anF();
        }
    }

    private void ma(String str) {
        SwanFavorDataManager.auq().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void anP() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_success).jg(2).aIc();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void anQ() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_fail).jg(2).aHZ();
            }
        }, com.baidu.swan.apps.env.c.c.atM().hf(3).atN());
        bA("click", "aboutmove");
    }

    private void mb(String str) {
        if (com.baidu.swan.apps.ad.a.a.aER()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_debug_forbid_favor).aHZ();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cDi = null;
        final String page = ak.aNY().getPage();
        SwanFavorDataManager.auq().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void anR() {
                com.baidu.swan.apps.database.favorite.a.asN();
                if (com.baidu.swan.apps.menu.a.C(a.this.bdH())) {
                    com.baidu.swan.apps.menu.a.cd("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_success).jg(2).jc(2).aHZ();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void anS() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_fail).jg(2).aHZ();
            }
        });
        com.baidu.swan.apps.menu.a.cd("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void anL() {
        e eVar;
        f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && (eVar = (e) afz.j(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.aoI());
            com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bA("click", "aboutshare");
        }
    }

    private void anM() {
        System.arraycopy(this.cOM, 1, this.cOM, 0, this.cOM.length - 1);
        this.cOM[this.cOM.length - 1] = SystemClock.uptimeMillis();
        if (this.cOM[0] >= SystemClock.uptimeMillis() - 1000) {
            FK();
        }
    }

    private void anN() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs != null) {
            b.a aIv = aIs.aIv();
            String ayL = aIv.ayL();
            String ayM = aIv.ayM();
            if (TextUtils.isEmpty(ayL) || TextUtils.isEmpty(ayM)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cN = ak.cN(ayL, ayM);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cN), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void anO() {
        i.mn(this.cOP).mo(getString(a.h.swan_app_service_agreement)).fo(false).app();
        bA("click", "servicenote");
    }

    private void e(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cON = jSONObject.optString("scheme");
                this.cOO = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cON) && !TextUtils.isEmpty(this.cOO) && (length = this.cOO.length()) >= 20) {
                    if (length > 100) {
                        this.cOO = this.cOO.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cOO);
                    SwanAppRelatedSwanListAdapter.U(Constants.PHONE_BRAND, null, "show");
                    anE();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void FK() {
        String R = o.R(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), R).aIa();
        com.baidu.swan.apps.console.c.br("SwanAppAboutFragment", "showExtraInfo\n" + R);
        this.cOM = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, String str2) {
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
