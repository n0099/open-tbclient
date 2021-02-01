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
    private SwanAppRoundedImageView cQW;
    private BdBaseImageView cQX;
    private TextView cQY;
    private com.baidu.swan.apps.view.a cQZ;
    private long[] cRa = new long[5];
    private String cRb;
    private String cRc;
    private String cRd;
    private Button cRe;
    private RecyclerView cRf;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_about_fragment, viewGroup, false);
        aq(inflate);
        am(inflate);
        if (aoI()) {
            inflate = av(inflate);
        }
        return a(inflate, this);
    }

    @Override // com.baidu.swan.apps.core.d.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.cQZ != null) {
            this.cQZ.aOO();
        }
        setRequestedOrientation(1);
        if (this.cRI != null && this.cRI.isShowing()) {
            this.cRI.iA(com.baidu.swan.apps.t.a.axs().aii());
        }
        if (this.cRe != null) {
            aod();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public void aq(View view) {
        au(view);
        fh(true);
        gH(-1);
        gI(ViewCompat.MEASURED_STATE_MASK);
        mv(null);
        fl(true);
    }

    private void am(View view) {
        final com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL != null && aIL.aIO() != null) {
            final b.a aIO = aIL.aIO();
            this.cQW = (SwanAppRoundedImageView) view.findViewById(a.f.aiapps_icon);
            TextView textView = (TextView) view.findViewById(a.f.aiapps_title);
            textView.setText(aIO.atc());
            if (aIO.getAppFrameType() == 0) {
                com.baidu.swan.apps.view.d.a(textView, new Runnable() { // from class: com.baidu.swan.apps.core.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.core.f.anl();
                    }
                });
            }
            com.baidu.swan.apps.performance.a.f.aEk().aEl().aC(textView);
            ((TextView) view.findViewById(a.f.aiapps_description)).setText(aIO.ayK());
            ((Button) view.findViewById(a.f.share_friends)).setOnClickListener(this);
            this.cRe = (Button) view.findViewById(a.f.add_favor);
            this.cRe.setOnClickListener(this);
            aod();
            ((TextView) view.findViewById(a.f.service_category_value)).setText(aIO.ayP());
            ((TextView) view.findViewById(a.f.subject_info_value)).setText(aIO.ayQ());
            this.cRd = com.baidu.swan.apps.t.a.axi().ait();
            if (!TextUtils.isEmpty(this.cRd)) {
                View findViewById = view.findViewById(a.f.agreement_layout);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this);
            }
            this.cRf = (RecyclerView) view.findViewById(a.f.related_swan_app_list);
            PMSAppInfo azq = aIO.azq();
            if (a(azq)) {
                f(view, azq.brandsInfo);
            }
            this.cQY = (TextView) view.findViewById(a.f.aiapps_label_tv);
            this.cQX = (BdBaseImageView) view.findViewById(a.f.aiapps_label_bg);
            this.cQW.setImageBitmap(ak.a((com.baidu.swan.apps.u.c.b) aIO, "SwanAppAboutFragment", false));
            this.cQW.setOnClickListener(this);
            SwanAppBearInfo ayR = aIO.ayR();
            if (ayR != null && ayR.isValid()) {
                this.cQZ = new com.baidu.swan.apps.view.a(this.mActivity, view, ayR, a.f.bear_layout);
            }
            gF(aIO.getType());
            ((Button) view.findViewById(a.f.open_app_button)).setVisibility(8);
            if (DEBUG || com.baidu.swan.apps.v.f.aAl().azP()) {
                View inflate = ((ViewStub) view.findViewById(a.f.ai_app_console)).inflate();
                if (aoQ() && (inflate instanceof Button)) {
                    ((Button) inflate).setText(aIO.azm() ? a.h.aiapps_close_debug_mode : a.h.aiapps_open_debug_mode);
                }
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.8
                    FullScreenFloatView cRo;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            if (a.DEBUG) {
                                if (this.cRo == null) {
                                    this.cRo = com.baidu.swan.apps.v.f.aAl().B(a.this.mActivity);
                                }
                                if (a.this.aoQ()) {
                                    if (com.baidu.swan.apps.console.a.alL()) {
                                        com.baidu.swan.apps.console.a.q(a.this.getContext(), false);
                                        return;
                                    } else {
                                        com.baidu.swan.games.c.d.aVA().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.8.1
                                            @Override // com.baidu.swan.games.c.d.a
                                            public void fg(boolean z) {
                                                if (z) {
                                                    com.baidu.swan.apps.console.a.q(a.this.getContext(), true);
                                                } else {
                                                    com.baidu.swan.games.c.d.aVA().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                                }
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.cRo.setVisibility(this.cRo.getVisibility() == 0 ? 8 : 0);
                            } else if (a.this.aoQ()) {
                                a.this.aoe();
                            } else {
                                com.baidu.swan.apps.console.a.cE(a.this.getContext());
                            }
                        }
                    }
                });
                if (!aoQ()) {
                    ((ViewStub) view.findViewById(a.f.ai_app_property)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.9
                        SwanAppPropertyWindow cRq;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (this.cRq == null) {
                                this.cRq = com.baidu.swan.apps.v.f.aAl().C(a.this.mActivity);
                            }
                            this.cRq.setVisibility(this.cRq.getVisibility() == 0 ? 8 : 0);
                        }
                    });
                }
                ((ViewStub) view.findViewById(a.f.ai_app_show_ext_info)).inflate().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (a.this.mActivity != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("ENABLE CODE CACHE: ").append(com.baidu.swan.apps.t.a.awZ().gc(a.this.getFrameType())).append("\n");
                            sb.append("ENABLE V8: ").append(com.baidu.swan.apps.core.turbo.d.ase().aqB()).append("\n");
                            sb.append("APS VERSION: ").append(TextUtils.isEmpty(aIO.getVersion()) ? "" : aIO.getVersion()).append("\n");
                            sb.append("APPID VERSION: ").append(com.baidu.swan.apps.f.a.lD(aIL.id)).append("\n");
                            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), aIO.ayT());
                            StringBuilder append = sb.append("小程序包大小: ");
                            if (TextUtils.isEmpty(formatFileSize)) {
                                formatFileSize = "";
                            }
                            append.append(formatFileSize).append("(").append(aIO.ayT()).append(")").append("\n");
                            g.a aVar = new g.a(a.this.mActivity);
                            aVar.f(a.this.mActivity.getResources().getString(a.h.aiapps_show_ext_info_title)).rx(sb.toString()).a(new com.baidu.swan.apps.view.c.a()).gT(false);
                            aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.10.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            aVar.aHX();
                        }
                    }
                });
                View inflate2 = ((ViewStub) view.findViewById(a.f.ai_app_swan_core_history_info)).inflate();
                if (inflate2 instanceof Button) {
                    Button button = (Button) inflate2;
                    if (aoQ()) {
                        button.setText(a.h.ai_games_debug_game_core_version);
                    } else {
                        button.setText(a.h.aiapps_debug_swan_core_version);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            String jx;
                            String string;
                            if (a.this.mActivity != null) {
                                if (a.this.aoQ()) {
                                    jx = com.baidu.swan.apps.swancore.a.aMi().jx(1);
                                    string = a.this.mActivity.getResources().getString(a.h.ai_games_debug_game_core_version);
                                } else {
                                    jx = com.baidu.swan.apps.swancore.a.aMi().jx(0);
                                    string = a.this.mActivity.getResources().getString(a.h.aiapps_swan_core_history_title);
                                }
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.f(string).rx(jx).a(new com.baidu.swan.apps.view.c.a()).gT(false);
                                aVar.c(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.11.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                aVar.aHX();
                            }
                        }
                    });
                }
                if (k.aEe().isAvailable()) {
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
            if (b(azq)) {
                ImageView imageView = (ImageView) view.findViewById(a.f.apply_guarantee);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ak.dN(a.this.getContext());
                        a.this.bu("click", "baozhang");
                    }
                });
            }
            if (!aoQ()) {
                a(this.cQW, 2000L, new View.OnLongClickListener() { // from class: com.baidu.swan.apps.core.d.a.15
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        a.this.aob();
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
                k.aEe().a(new k.a() { // from class: com.baidu.swan.apps.core.d.a.12.1
                    @Override // com.baidu.swan.apps.performance.k.a
                    public void mu(final String str) {
                        a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.12.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                g.a aVar = new g.a(a.this.mActivity);
                                aVar.gR(a.h.aiapps_debug_report_performance).rx(str).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null);
                                aVar.aHX();
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
        com.baidu.swan.apps.console.v8inspector.a cRx;

        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar = new g.a(a.this.mActivity);
            aVar.gR(a.h.aiapps_debug_start_inspect).gQ(a.h.aiapps_debug_inspect_message).a(new com.baidu.swan.apps.view.c.a()).gT(true);
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() == 0) {
                aVar.c(a.h.aiapps_debug_inspect_normal, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(1);
                        AnonymousClass13.this.cRx = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awW());
                        AnonymousClass13.this.cRx.start();
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 2) {
                aVar.e(a.h.aiapps_debug_inspect_enhance, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aor();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(2);
                        System.exit(0);
                    }
                });
            }
            if (com.baidu.swan.apps.console.v8inspector.a.getStatus() != 0) {
                aVar.d(a.h.aiapps_debug_inspect_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.13.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AnonymousClass13.this.aor();
                        com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    }
                });
            }
            aVar.aHX();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aor() {
            if (this.cRx != null) {
                this.cRx.stop();
                this.cRx = null;
            }
        }
    }

    private void a(final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        if (view != null && onLongClickListener != null && j > 0) {
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.apps.core.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.ak.j.b.a.aMQ().aMS();
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
    public void aob() {
        if (this.mActivity != null) {
            String str = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().azq().webUrl;
            if (TextUtils.isEmpty(str)) {
                al.dR(this.mActivity).setText("");
                com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, a.h.swanapp_web_url_copy_fail).aIs();
                return;
            }
            String bt = bt(str, com.baidu.swan.apps.model.b.d(ak.aOr()));
            int i = a.h.swanapp_web_url_copy_success;
            if (bt.length() > 4000) {
                i = a.h.swanapp_web_url_param_to_long;
            } else {
                str = bt;
            }
            al.dR(this.mActivity).setText(str);
            com.baidu.swan.apps.res.widget.b.d.u(this.mActivity, i).aIs();
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
        return (com.baidu.swan.apps.runtime.d.aIG().getFrameType() != 0 || pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.brandsInfo)) ? false : true;
    }

    private void aoc() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.cRf.setLayoutManager(linearLayoutManager);
        final SwanAppRelatedSwanListAdapter swanAppRelatedSwanListAdapter = new SwanAppRelatedSwanListAdapter(getContext());
        this.cRf.setAdapter(swanAppRelatedSwanListAdapter);
        com.baidu.swan.apps.relateswans.b.a(new b.a() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // com.baidu.swan.apps.relateswans.b.a
            public void a(final com.baidu.swan.apps.relateswans.a aVar) {
                if (aVar != null) {
                    if (!((aVar.dur == null) | (aVar.dur.size() <= 0))) {
                        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.d.a.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.cRf.setVisibility(0);
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
        return (pMSAppInfo == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : pMSAppInfo.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type && ak.aOp();
    }

    private void aod() {
        if (com.baidu.swan.apps.database.favorite.a.np(com.baidu.swan.apps.runtime.d.aIG().getAppId())) {
            this.cRe.setText(a.h.swanapp_favored);
            this.cRe.setTextColor(getResources().getColorStateList(a.c.swan_app_about_attentation_text_selector));
            this.cRe.setBackgroundResource(a.e.swan_app_about_cancel_attention_selector);
            return;
        }
        this.cRe.setText(a.h.swanapp_add_favor);
        this.cRe.setTextColor(-1);
        this.cRe.setBackgroundResource(a.e.swan_app_about_attention_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoe() {
        if (com.baidu.swan.apps.runtime.e.aIL() != null) {
            com.baidu.swan.apps.core.c.c.a(com.baidu.swan.apps.runtime.e.aIL(), this.mActivity, new c.a() { // from class: com.baidu.swan.apps.core.d.a.5
                @Override // com.baidu.swan.apps.core.c.c.a
                public void n(boolean z, String str) {
                    if (!z) {
                        com.baidu.swan.apps.core.c.c.af(a.this.mActivity, str);
                    } else if (com.baidu.swan.apps.console.a.alL()) {
                        com.baidu.swan.apps.console.a.cE(a.this.getContext());
                    } else {
                        com.baidu.swan.games.c.d.aVA().a(new d.a() { // from class: com.baidu.swan.apps.core.d.a.5.1
                            @Override // com.baidu.swan.games.c.d.a
                            public void fg(boolean z2) {
                                if (z2) {
                                    com.baidu.swan.apps.console.a.cE(a.this.getContext());
                                } else {
                                    com.baidu.swan.games.c.d.aVA().a(a.this.mActivity, (DialogInterface.OnClickListener) null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void gF(int i) {
        ah.a(this.cQX, this.cQY, String.valueOf(i));
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void ajx() {
        FragmentActivity bdU = bdU();
        if (bdU != null && this.cRI == null) {
            this.cRI = new com.baidu.swan.menu.g(bdU, this.cRH, 13, com.baidu.swan.apps.t.a.axa(), new com.baidu.swan.apps.view.c.b());
            if (!aoQ()) {
                this.cRI.lD(35);
                this.cRI.lD(37);
            }
            new com.baidu.swan.apps.menu.a(this.cRI, this).aCb();
        }
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected void aof() {
        ajx();
        this.cRI.show(com.baidu.swan.apps.t.a.axs().aii());
    }

    @Override // com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.d.c
    public boolean aog() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        return false;
    }

    public static a aoh() {
        return new a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.aiapps_icon) {
            aok();
        } else if (id == a.f.open_app_button) {
            aol();
        } else if (id == a.f.brands_introduction_ll) {
            SchemeRouter.invoke(getContext(), this.cRb);
            bu("click", Constants.PHONE_BRAND);
        } else if (id == a.f.agreement_layout) {
            aom();
        } else if (id == a.f.share_friends) {
            aoj();
        } else if (id == a.f.add_favor) {
            aoi();
        }
    }

    private void aoi() {
        String appId = com.baidu.swan.apps.runtime.d.aIG().getAppId();
        if (!TextUtils.isEmpty(appId)) {
            if (com.baidu.swan.apps.database.favorite.a.np(appId)) {
                ms(appId);
            } else {
                mt(appId);
            }
            aod();
        }
    }

    private void ms(String str) {
        SwanFavorDataManager.auO().b(str, new com.baidu.swan.apps.favordata.a.b() { // from class: com.baidu.swan.apps.core.d.a.6
            @Override // com.baidu.swan.apps.favordata.a.b
            public void aon() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_success).jj(2).aIv();
            }

            @Override // com.baidu.swan.apps.favordata.a.b
            public void aoo() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_cancel_fav_fail).jj(2).aIs();
            }
        }, com.baidu.swan.apps.env.c.c.auk().hi(3).aul());
        bu("click", "aboutmove");
    }

    private void mt(String str) {
        if (com.baidu.swan.apps.ad.a.a.aFm()) {
            if (DEBUG) {
                Log.d("SwanAppAboutFragment", "in debug mode cannot add favor");
            }
            com.baidu.swan.apps.res.widget.b.d.u(getContext(), a.h.aiapps_debug_forbid_favor).aIs();
            return;
        }
        com.baidu.swan.apps.api.module.favorite.a.cFE = null;
        final String page = ak.aOr().getPage();
        SwanFavorDataManager.auO().b(str, 1, new com.baidu.swan.apps.favordata.a.a() { // from class: com.baidu.swan.apps.core.d.a.7
            @Override // com.baidu.swan.apps.favordata.a.a
            public void aop() {
                com.baidu.swan.apps.database.favorite.a.atl();
                if (com.baidu.swan.apps.menu.a.w(a.this.bdU())) {
                    com.baidu.swan.apps.menu.a.bX("aboutconcern", page);
                } else {
                    com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_success).jj(2).jf(2).aIs();
                }
            }

            @Override // com.baidu.swan.apps.favordata.a.a
            public void aoq() {
                com.baidu.swan.apps.res.widget.b.d.u(a.this.getContext(), a.h.aiapps_fav_fail).jj(2).aIs();
            }
        });
        com.baidu.swan.apps.menu.a.bX("aboutconcern", page);
    }

    @Override // com.baidu.swan.apps.core.d.c
    public void aoj() {
        e eVar;
        f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null && (eVar = (e) afX.j(e.class)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", eVar.apg());
            com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.b("sharebtn", hashMap));
            bu("click", "aboutshare");
        }
    }

    private void aok() {
        System.arraycopy(this.cRa, 1, this.cRa, 0, this.cRa.length - 1);
        this.cRa[this.cRa.length - 1] = SystemClock.uptimeMillis();
        if (this.cRa[0] >= SystemClock.uptimeMillis() - 1000) {
            Ha();
        }
    }

    private void aol() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL != null) {
            b.a aIO = aIL.aIO();
            String azj = aIO.azj();
            String azk = aIO.azk();
            if (TextUtils.isEmpty(azj) || TextUtils.isEmpty(azk)) {
                if (DEBUG) {
                    Log.d("SwanAppAboutFragment", "appOpenUrl or appDownloadUrl is empty, click no response");
                    return;
                }
                return;
            }
            String cH = ak.cH(azj, azk);
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

    private void aom() {
        i.mF(this.cRd).mG(getString(a.h.swan_app_service_agreement)).fq(false).apN();
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
                this.cRb = jSONObject.optString("scheme");
                this.cRc = jSONObject.optString("description");
                if (!TextUtils.isEmpty(this.cRb) && !TextUtils.isEmpty(this.cRc) && (length = this.cRc.length()) >= 20) {
                    if (length > 100) {
                        this.cRc = this.cRc.substring(0, 100);
                    }
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(a.f.brands_introduction_ll);
                    linearLayout.setOnClickListener(this);
                    linearLayout.setVisibility(0);
                    ((TextView) view.findViewById(a.f.brands_introduction_details)).setText(this.cRc);
                    SwanAppRelatedSwanListAdapter.V(Constants.PHONE_BRAND, null, "show");
                    aoc();
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.i("SwanAppAboutFragment", e.getMessage());
                }
            }
        }
    }

    private void Ha() {
        String L = o.L(this.mActivity);
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), L).aIt();
        com.baidu.swan.apps.console.c.bl("SwanAppAboutFragment", "showExtraInfo\n" + L);
        this.cRa = new long[5];
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
