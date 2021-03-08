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
    private long[] cSA = new long[5];
    private String cSB;
    private String cSC;
    private String cSD;
    private Button cSE;
    private RecyclerView cSF;
    private SwanAppRoundedImageView cSw;
    private BdBaseImageView cSx;
    private TextView cSy;
    private com.baidu.swan.apps.view.a cSz;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        aq(inflate);
        am(inflate);
        if (aoL()) {
            inflate = av(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cSz != null) {
            this.cSz.aOR();
        }
        setRequestedOrientation(1);
        if (this.cTi != null && this.cTi.isShowing()) {
            this.cTi.iA(com.baidu.swan.apps.t.a.axv().ail());
        }
        if (this.cSE != null) {
            aog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
        au(view);
        fh(true);
        gI(-1);
        gJ(ViewCompat.MEASURED_STATE_MASK);
        mC(null);
        fl(true);
    }

    private void am(View view) {
        final com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO != null && aIO.aIR() != null) {
            final b.a aIR = aIO.aIR();
            this.cSw = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aIR.atf());
            if (aIR.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.ano();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aEn().aEo().aC(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aIR.ayN());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cSE = (Button) view.findViewById(a.f.add_favor);
            this.cSE.setOnClickListener(this);
            aog();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aIR.ayS());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aIR.ayT());
            this.cSD = com.baidu.swan.apps.t.a.axl().aiw();
            if (!TextUtils.isEmpty(this.cSD)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cSF = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo azt = aIR.azt();
            if (a(azt)) {
                f(view, azt.brandsInfo);
            }
            this.cSy = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cSx = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cSw.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aIR, "SwanAppAboutFragment", false));
            this.cSw.setOnClickListener(this);
            SwanAppBearInfo ayU = aIR.ayU();
            if (ayU != null && ayU.isValid()) {
                this.cSz = new com.baidu.swan.apps.view.a(this.mActivity, view, ayU, a.f.bear_layout);
            }
            gG(aIR.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.aAo().azS()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aoT() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aIR.azp() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cSO;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cSO == null) {
                                    this.cSO = com.baidu.swan.apps.v.f.aAo().B(a.this.mActivity);
                                }
                                if (a.this.aoT()) {
                                    if (com.baidu.swan.apps.console.a.alO()) {
                                        com.baidu.swan.apps.console.a.q(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aVD().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void fg(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.q(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aVD().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cSO.setVisibility(this.cSO.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aoT()) {
                                a.this.aoh();
                            } else {
                                com.baidu.swan.apps.console.a.cD(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aoT()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cSQ;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cSQ == null) {
                                this.cSQ = com.baidu.swan.apps.v.f.aAo().C(a.this.mActivity);
                            }
                            this.cSQ.setVisibility(this.cSQ.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.axc().gd(a.this.getFrameType())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.ash().aqE()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aIR.getVersion()) ? "" : aIR.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.lK(aIO.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aIR.ayW());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aIR.ayW()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).rE(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gT(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aIa();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aoT()) {
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
                                if (a.this.aoT()) {
                                    jy = com.baidu.swan.apps.swancore.a.aMl().jy(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    jy = com.baidu.swan.apps.swancore.a.aMl().jy(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).rE(jy).a(new com.baidu.swan.apps.view.c.a()).gT(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aIa();
                            }
                        }
                    });
                }
                if (k.aEh().isAvailable()) {
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
            if (b(azt)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.dM(a.this.getContext());
                        a.this.bu("click", "baozhang");
                    }
                });
            }
            if (!aoT()) {
                a(this.cSw, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.aoe();
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
                k.aEh().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void mB(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.gS(a.h.aiapps_debug_report_performance).rE(str).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aIa();
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
        com.baidu.swan.apps.console.v8inspector.a cSX;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.gS(a.h.aiapps_debug_start_inspect).gR(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gT(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cSX = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awZ());
                        AnonymousClass13.this.cSX.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aou();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aou();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aIa();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aou() {
            if (this.cSX != null) {
                this.cSX.stop();
                this.cSX = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.ak.j.b.a.aMT().aMV();
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
    public void aoe() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().azt().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.dQ(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.swanapp_web_url_copy_fail).aIv();
                return;
            }
            String bt = bt(str, com.baidu.swan.apps.model.b.d(ak.aOu()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bt.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bt;
            }
            al.dQ(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, i).aIv();
        }
    }

    @NonNull
    private String bt(@NonNull String str, String str2) {
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
        return (com.baidu.swan.apps.runtime.d.aIJ().getFrameType() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void aof() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cSF.setLayoutManager(linearLayoutManager);
        final SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
        this.cSF.setAdapter(swanAppRelatedSwanListAdapter);
        com.baidu.swan.apps.relateswans.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.relateswans.b.a
            public void a(final com.baidu.swan.apps.relateswans.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dvS == null) | (aVar.dvS.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cSF.setVisibility(0);
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
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aOs();
    }

    private void aog() {
        if (com.baidu.swan.apps.database.favorite.a.nw(com.baidu.swan.apps.runtime.d.aIJ().getAppId())) {
            this.cSE.setText(a.h.swanapp_favored);
            this.cSE.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cSE.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cSE.setText(a.h.swanapp_add_favor);
        this.cSE.setTextColor(-1);
        this.cSE.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoh() {
        if (com.baidu.swan.apps.runtime.e.aIO() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aIO(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void n(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.af(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.alO()) {
                        com.baidu.swan.apps.console.a.cD(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aVD().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void fg(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.cD(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aVD().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void gG(int i) {
        ah.a(this.cSx, this.cSy, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajA() {
        FragmentActivity bdW = bdW();
        if (bdW != null && this.cTi == null) {
            this.cTi = new com.baidu.swan.menu.g(bdW, this.cTh, 13, com.baidu.swan.apps.t.a.axd(), new com.baidu.swan.apps.view.c.b());
            if (!aoT()) {
                this.cTi.lE(35);
                this.cTi.lE(37);
            }
            new com.baidu.swan.apps.menu.a(this.cTi, this).aCe();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aoi() {
        ajA();
        this.cTi.show(com.baidu.swan.apps.t.a.axv().ail());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aoj() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiT() {
        return false;
    }

    public static a aok() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            aon();
        } else if (id == a.f.open_app_button) {
            aoo();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cSB);
            bu("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            aop();
        } else if (id == a.f.share_friends) {
            aom();
        } else if (id == a.f.add_favor) {
            aol();
        }
    }

    private void aol() {
        String appId = com.baidu.swan.apps.runtime.d.aIJ().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.nw(appId)) {
                mz(appId);
            } else {
                mA(appId);
            }
            aog();
        }
    }

    private void mz(String str) {
        SwanFavorDataManager.auR().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aoq() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_success).jk(2).aIy();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aor() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_fail).jk(2).aIv();
            }
        }, com.baidu.swan.apps.env.c.c.aun().hj(3).auo());
        bu("click", "aboutmove");
    }

    private void mA(String str) {
        if (com.baidu.swan.apps.ad.a.a.aFp()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_debug_forbid_favor).aIv();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cHe = null;
        final String page = ak.aOu().getPage();
        SwanFavorDataManager.auR().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aos() {
                com.baidu.swan.apps.database.favorite.a.ato();
                if (com.baidu.swan.apps.menu.a.w(a.this.bdW())) {
                    com.baidu.swan.apps.menu.a.bX("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_success).jk(2).jg(2).aIv();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aot() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_fail).jk(2).aIv();
            }
        });
        com.baidu.swan.apps.menu.a.bX("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aom() {
        e eVar;
        f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null && (eVar = (e) aga.j(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.apk());
            com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bu("click", "aboutshare");
        }
    }

    private void aon() {
        System.arraycopy(this.cSA, 1, this.cSA, 0, this.cSA.length - 1);
        this.cSA[this.cSA.length - 1] = SystemClock.uptimeMillis();
        if (this.cSA[0] >= SystemClock.uptimeMillis() - 1000) {
            Hd();
        }
    }

    private void aoo() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO != null) {
            b.a aIR = aIO.aIR();
            String azm = aIR.azm();
            String azn = aIR.azn();
            if (TextUtils.isEmpty(azm) || TextUtils.isEmpty(azn)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cH = ak.cH(azm, azn);
            UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = new UnitedSchemeMainDispatcher();
            unitedSchemeMainDispatcher.setDynamicDispatcher("swanAPI", new com.baidu.swan.apps.scheme.j());
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cH), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            unitedSchemeEntity.setOnlyVerify(false);
            unitedSchemeMainDispatcher.dispatch(this.mActivity, unitedSchemeEntity);
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "Open or download app");
            }
        }
    }

    private void aop() {
        i.mM(this.cSD).mN(getString(a.h.swan_app_service_agreement)).fq(false).apQ();
        bu("click", "servicenote");
    }

    private void f(View view, String str) {
        int length;
        if (DEBUG) {
            Log.i("SwanAppAboutFragment", str + "");
        }
        if (!TextUtils.isEmpty(str) && view != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.cSB = jSONObject.optString("scheme");
                this.cSC = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cSB) && !TextUtils.isEmpty(this.cSC) && (length = this.cSC.length()) >= 20) {
                    if (length > 100) {
                        this.cSC = this.cSC.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cSC);
                    SwanAppRelatedSwanListAdapter.V(Constants.PHONE_BRAND, null, "show");
                    aof();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Hd() {
        String L = o.L(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), L).aIw();
        com.baidu.swan.apps.console.c.bl("SwanAppAboutFragment", "showExtraInfo\n" + L);
        this.cSA = new long[5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(String str, String str2) {
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
