package com.baidu.platform.comapi.walknavi.g.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends com.baidu.platform.comapi.walknavi.g.b.b implements CompoundButton.OnCheckedChangeListener, com.baidu.platform.comapi.walknavi.d.b {
    public TextView A;
    public RelativeLayout B;
    public ImageButton C;
    public boolean D;
    public a E;
    public RelativeLayout F;
    public RelativeLayout G;
    public RelativeLayout H;
    public RelativeLayout I;
    public ImageView J;
    public ImageView K;
    public ImageView L;
    public View N;
    public String Q;
    public String S;
    public com.baidu.platform.comapi.walknavi.widget.a U;
    public IWMoreNPCModelOnClickListener V;
    public IWNPCLoadAndInitListener W;

    /* renamed from: a  reason: collision with root package name */
    public Animation f10083a;
    public View aa;
    public View ab;
    public View ac;
    public TextView ad;
    public ImageView ae;
    public TextView af;

    /* renamed from: b  reason: collision with root package name */
    public Animation f10084b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f10085c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f10086d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f10087e;

    /* renamed from: f  reason: collision with root package name */
    public Button f10088f;

    /* renamed from: g  reason: collision with root package name */
    public View f10089g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f10090h;
    public FrameLayout k;
    public Context l;
    public com.baidu.platform.comapi.walknavi.g.a m;
    public ad o;
    public RelativeLayout p;
    public ImageButton q;
    public ImageButton r;
    public int v;
    public RelativeLayout y;
    public ImageButton z;
    public Handler n = new Handler();
    public final int s = 1;
    public final int t = 2;
    public final int u = 3;
    public int w = 1;
    public int x = 1;
    public boolean M = false;
    public AlphaAnimation O = new AlphaAnimation(1.0f, 0.0f);
    public AlphaAnimation P = new AlphaAnimation(0.0f, 1.0f);
    public boolean R = false;
    public boolean T = false;
    public boolean X = true;
    public long Y = 0;
    public boolean Z = true;
    public final View.OnClickListener ag = new l(this);
    public final Runnable i = new o(this);
    public final Runnable j = new v(this);

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i);

        void a(String str);
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.g.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0125c implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<com.baidu.platform.comapi.walknavi.g.b.b> f10091a;

        public C0125c(com.baidu.platform.comapi.walknavi.g.b.b bVar) {
            this.f10091a = null;
            this.f10091a = new WeakReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.g.a
        public void a(g.b bVar) {
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b();
    }

    public c(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        Bitmap imageToAR;
        Bitmap imageToNormal;
        this.J = null;
        this.l = context;
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(context, R.attr.SapiSdkDividerWidth);
        this.f10083a = c2;
        c2.setFillAfter(true);
        Animation c3 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.attr.SapiSdkDividerPadding);
        this.f10084b = c3;
        c3.setFillAfter(true);
        this.O.setDuration(300L);
        this.P.setDuration(300L);
        this.m = aVar;
        this.o = new ad(context, view);
        b(view);
        this.H = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_list_padding_bottom_no_buttons);
        this.I = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_padding_material);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.dimen.abc_dropdownitem_icon_width);
        this.G = relativeLayout;
        a(relativeLayout);
        this.J = (ImageView) view.findViewById(R.dimen.abc_dialog_padding_top_material);
        if (com.baidu.platform.comapi.walknavi.b.a().l() != null && (imageToNormal = com.baidu.platform.comapi.walknavi.b.a().l().getImageToNormal()) != null) {
            this.J.setImageBitmap(imageToNormal);
        }
        this.J.setOnClickListener(new com.baidu.platform.comapi.walknavi.g.b.d(this));
        this.K = (ImageView) view.findViewById(R.dimen.abc_dialog_title_divider_material);
        a(view);
        this.L = (ImageView) view.findViewById(R.dimen.abc_dialog_min_width_minor);
        if (com.baidu.platform.comapi.walknavi.b.a().b()) {
            this.L.setVisibility(0);
            if (com.baidu.platform.comapi.walknavi.b.a().l() != null && (imageToAR = com.baidu.platform.comapi.walknavi.b.a().l().getImageToAR()) != null) {
                this.L.setImageBitmap(imageToAR);
            }
        } else {
            this.L.setVisibility(8);
        }
        this.L.setOnClickListener(new r(this));
        this.p = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_list_padding_top_no_title);
        com.baidu.platform.comapi.walknavi.b.a().r();
        int i = com.baidu.platform.comapi.walknavi.b.f9894a;
        ImageButton imageButton = (ImageButton) view.findViewById(R.dimen.abc_dialog_min_width_major);
        this.q = imageButton;
        imageButton.setOnClickListener(new w(this));
        this.y = (RelativeLayout) view.findViewById(R.dimen.abc_control_inset_material);
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.dimen.abc_dialog_fixed_height_major);
        this.C = imageButton2;
        imageButton2.setOnClickListener(new x(this));
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_corner_radius_material);
        this.B = relativeLayout2;
        relativeLayout2.setOnClickListener(new y(this));
        TextView textView = (TextView) view.findViewById(R.dimen.abc_dialog_fixed_width_minor);
        this.A = textView;
        this.D = true;
        textView.setOnClickListener(new z(this));
        this.z = (ImageButton) view.findViewById(R.dimen.abc_dialog_fixed_width_major);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.dimen.abc_dialog_fixed_height_minor);
        this.F = relativeLayout3;
        relativeLayout3.setOnClickListener(this.ag);
        this.z.setOnClickListener(this.ag);
        View findViewById = view.findViewById(R.dimen.abc_disabled_alpha_material_light);
        this.N = findViewById;
        findViewById.setOnClickListener(new aa(this));
    }

    private void n() {
    }

    public void b(int i) {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.dimen.abc_edit_text_inset_bottom_material) {
            if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
                return;
            }
            com.baidu.platform.comapi.wnplatform.d.a.c("yang12", "onCheckedChanged:sound_check:" + z);
            if (z) {
                if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("sound", 1);
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                }
                WNaviTTSPlayer.resumeVoiceTTSOutput();
                com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_VOICE_ON_OFF", true);
                return;
            }
            if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("sound", 0);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
            }
            WNaviTTSPlayer.pauseVoiceTTSOutput();
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_VOICE_ON_OFF", false);
        } else if (compoundButton.getId() == R.dimen.abc_floating_window_z) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang12", "onCheckedChanged:panocheck:" + z);
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_STREET_POI_ON_OFF", true);
                com.baidu.platform.comapi.walknavi.b.a().D().b(true);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("streetPoi", 1);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_STREET_POI_ON_OFF", false);
            com.baidu.platform.comapi.walknavi.b.a().D().b(false);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("streetPoi", 0);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
        } else if (compoundButton.getId() == R.dimen.abc_progress_bar_height_material) {
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_THREED_MAP_ON_OFF", true);
                d(true);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("threeD", 1);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_THREED_MAP_ON_OFF", false);
            d(false);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("threeD", 0);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n != null) {
            boolean z = false;
            for (int i = 0; i < n.size(); i++) {
                if (TextUtils.equals(str, n.get(i).c())) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    private void l() {
        if (com.baidu.platform.comapi.wnplatform.o.a.a()) {
            this.f10089g.setVisibility(0);
            this.f10090h.setVisibility(0);
            com.baidu.platform.comapi.walknavi.b.a().D().b(true);
            return;
        }
        this.f10089g.setVisibility(8);
        this.f10090h.setVisibility(8);
        com.baidu.platform.comapi.walknavi.b.a().D().b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        double d2;
        Point K;
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == 0) {
            MapStatus i = com.baidu.platform.comapi.walknavi.b.a().G().i();
            if (i != null) {
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.overlook(0.0f);
                builder.zoom(19.0f);
                WinRound winRound = i.winRound;
                Double.isNaN(Math.abs(winRound.bottom - winRound.top) - 75);
                WinRound winRound2 = i.winRound;
                builder.targetScreen(new android.graphics.Point((winRound2.right + winRound2.left) / 2, ((winRound2.top + winRound2.bottom) / 2) - ((int) (0.0d - (d2 * 0.25d)))));
                if (com.baidu.platform.comapi.walknavi.b.a().K() != null) {
                    builder.target(new LatLng(K.getmPty(), K.getmPtx()));
                }
                com.baidu.platform.comapi.walknavi.b.a().G().a(i, 500);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        if (TextUtils.isEmpty(a2)) {
            this.N.setVisibility(0);
            ((ImageView) this.N).setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, 2130837786));
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a a3 = com.baidu.platform.comapi.walknavi.b.a().a(a2);
        if (a3 == null) {
            return;
        }
        Bitmap d2 = a3.d();
        if (d2 != null) {
            this.N.setVisibility(0);
            ((ImageView) this.N).setImageBitmap(d2);
            return;
        }
        this.N.setVisibility(0);
        ((ImageView) this.N).setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, 2130837800));
    }

    private void p() {
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_AR_NPC_IS_DOWNLOADING", false)) {
            com.baidu.platform.comapi.walknavi.d.e.c().n();
        }
    }

    private int q() {
        return com.baidu.platform.comapi.wnplatform.o.g.c(this.l);
    }

    public void g() {
        this.o.c();
        this.l = null;
        if (this.V != null) {
            this.V = null;
        }
        if (this.W != null) {
            this.W = null;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().i();
    }

    public ImageView h() {
        return this.K;
    }

    public void i() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.k.setVisibility(0);
        com.baidu.platform.comapi.walknavi.d.e.c().h();
    }

    public void j() {
        Runnable runnable;
        com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
        if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            p();
            com.baidu.platform.comapi.walknavi.d.e.c().c(true);
            com.baidu.platform.comapi.walknavi.d.e.c().a(false);
            com.baidu.platform.comapi.walknavi.d.e.c().i();
            this.k.removeAllViews();
        }
        Handler handler = this.n;
        if (handler == null || (runnable = this.i) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.n = null;
    }

    public void k() {
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        if (TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.b.a().H().a(a2, ""))) {
            com.baidu.platform.comapi.walknavi.d.e.c().b(a2, new t(this, a2));
        }
    }

    public void d() {
        n();
    }

    private void b(View view) {
        this.ac = view.findViewById(R.dimen.abc_button_inset_vertical_material);
        this.aa = view.findViewById(R.dimen.abc_config_prefDialogWidth);
        this.ab = view.findViewById(R.dimen.abc_button_padding_horizontal_material);
        this.ad = (TextView) view.findViewById(R.dimen.abc_control_corner_material);
        this.ae = (ImageView) view.findViewById(R.dimen.abc_button_padding_vertical_material);
        this.af = (TextView) view.findViewById(R.dimen.abc_cascading_menus_min_smallest_width);
    }

    private void d(boolean z) {
        MapStatus i = com.baidu.platform.comapi.walknavi.b.a().G().i();
        MapStatus.Builder builder = new MapStatus.Builder();
        if (i == null) {
            return;
        }
        if (z) {
            builder.overlook(-50.0f);
            com.baidu.platform.comapi.walknavi.b.a().b(-50);
        } else {
            builder.overlook(0.0f);
            com.baidu.platform.comapi.walknavi.b.a().b(0);
        }
        com.baidu.platform.comapi.walknavi.b.a().G().a(i, TbConfig.POST_IMAGE_SMALL);
    }

    public void c() {
        if (this.T) {
            com.baidu.platform.comapi.walknavi.d.e.c().a(new C0125c(this));
            String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
            if (TextUtils.isEmpty(a2)) {
                b(true);
                com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
                o();
            } else {
                a(a2, (d) null);
            }
            this.T = false;
        }
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        this.V = iWMoreNPCModelOnClickListener;
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        this.W = iWNPCLoadAndInitListener;
    }

    private void a(View view) {
        this.k = (FrameLayout) view.findViewById(R.dimen.abc_alert_dialog_button_bar_height);
    }

    private void a(String str, String str2) {
        if (!a(str2)) {
            Log.e("LoadLocalNPCError", "the localNPCPath is not found, please check");
        } else if (com.baidu.platform.comapi.walknavi.d.e.c().o()) {
            b(str, str2);
            com.baidu.platform.comapi.walknavi.b.a().H().b(str, str2);
            IWNPCLoadAndInitListener iWNPCLoadAndInitListener = this.W;
            if (iWNPCLoadAndInitListener != null) {
                iWNPCLoadAndInitListener.onSuccess();
            }
        } else {
            com.baidu.platform.comapi.walknavi.b.a().a(new ab(this, str, str2));
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.attr.SapiSdkDividerWidth);
        this.o.b();
        if (com.baidu.platform.comapi.walknavi.g.a.b.f10066a == 2) {
            if (this.r.isShown()) {
                this.r.setAnimation(c2);
            }
            this.r.setVisibility(8);
        }
        View view = this.ac;
        if (view != null) {
            if (view.isShown()) {
                this.ac.setAnimation(c2);
            }
            this.ac.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.baidu.platform.comapi.walknavi.d.e.c().b(str, this.k.getWidth(), this.k.getHeight());
        com.baidu.platform.comapi.walknavi.d.e.c().c(false);
    }

    public void c(int i) {
        if (i == 2130837750) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, 2130837750));
            this.v = 1;
        } else if (i == 2130837753) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, 2130837753));
            this.v = 2;
        } else if (i == 2130837751) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, 2130837751));
            this.v = 3;
        }
    }

    public void a(BaseNpcModel baseNpcModel) {
        if (this.l == null) {
            return;
        }
        if (baseNpcModel == null) {
            Log.e("BaseNpcModel error", "BaseNpcModel is null,please check!");
        } else if (TextUtils.equals(baseNpcModel.getDownLoadKey(), "")) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            o();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c() && baseNpcModel.isLoadFromLocal()) {
            a(baseNpcModel.getDownLoadKey(), baseNpcModel.getLocalPath());
        } else if (!NetworkUtil.isNetworkAvailable(this.l)) {
            Toast.makeText(this.l, (int) R.drawable.res_0x7f08001f_ic_icon_mask_live__0, 0).show();
        } else if (!NetworkUtil.isWifiState(this.l)) {
            a(baseNpcModel.getDownLoadKey(), com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.drawable.res_0x7f08001e_ic_icon_mask_guide_travel_svg__1), 4);
        } else {
            a(baseNpcModel.getDownLoadKey(), new ac(this, baseNpcModel));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.platform.comapi.walknavi.d.e.c().a(str);
        b(str2);
        o();
    }

    private void b(String str) {
        this.k.setVisibility(0);
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> n = com.baidu.platform.comapi.walknavi.b.a().n();
        if (n != null) {
            for (int i = 0; i < n.size(); i++) {
                if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, n.get(i).c())) {
                    String a3 = n.get(i).a();
                    String b2 = n.get(i).b();
                    if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2)) {
                        try {
                            com.baidu.platform.comapi.walknavi.b.a().D().a(Integer.parseInt(a3), Integer.parseInt(b2));
                        } catch (Exception unused) {
                        }
                    } else {
                        com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
                    }
                }
            }
        }
        if (!com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            com.baidu.platform.comapi.walknavi.d.e.c().a(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (q() / 9) * 9);
            com.baidu.platform.comapi.walknavi.d.e.c().m().setZOrderOnTop(true);
            com.baidu.platform.comapi.walknavi.d.e.c().m().setFrameRate(30);
            this.k.addView(com.baidu.platform.comapi.walknavi.d.e.c().m(), layoutParams);
            com.baidu.platform.comapi.walknavi.d.e.c().f();
            this.n.postDelayed(new m(this, str), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().f();
        this.n.postDelayed(new n(this, str), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "call npcSwitchCase");
        com.baidu.platform.comapi.walknavi.d.e.c().a(str, this.k.getHeight(), this.k.getWidth());
        com.baidu.platform.comapi.walknavi.d.e.c().c(false);
    }

    public void c(boolean z) {
        if (com.baidu.platform.comapi.walknavi.d.e.c().p()) {
            b(z);
        }
    }

    private boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        Context context;
        com.baidu.platform.comapi.walknavi.widget.a a2 = new com.baidu.platform.comapi.walknavi.widget.a(this.l).a(true).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.drawable.res_0x7f080004_avd_show_password__1)).a(String.format(str2, Integer.valueOf(i))).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.drawable.res_0x7f080000_avd_hide_password__0)).b().b(new f(this, str)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.drawable.res_0x7f080005_avd_show_password__2)).a(new e(this));
        this.U = a2;
        if (a2.isShowing() || (context = this.l) == null || ((Activity) context).isFinishing()) {
            return;
        }
        this.U.show();
    }

    public void a(int i, boolean z) {
        if (i == 1) {
            this.M = false;
            this.ac.setVisibility(0);
            this.y.setVisibility(0);
            this.H.setVisibility(0);
            this.I.setVisibility(8);
            this.k.setVisibility(8);
            if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
                c(true);
            }
            if (z) {
                return;
            }
            this.y.startAnimation(this.f10084b);
            this.H.startAnimation(this.f10084b);
        } else if (i == 2) {
            this.M = true;
            this.ac.setVisibility(8);
            if (z) {
                this.y.setVisibility(8);
                this.H.setVisibility(8);
                this.I.setVisibility(0);
            } else {
                this.y.setVisibility(8);
                this.y.startAnimation(this.f10083a);
                this.H.startAnimation(this.f10083a);
                this.f10083a.setAnimationListener(new g(this));
            }
            com.baidu.platform.comapi.walknavi.b.a().D().c(true);
            this.n.postDelayed(this.i, 500L);
        }
    }

    public void b(boolean z) {
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().D().c(false);
            this.k.setVisibility(8);
            com.baidu.platform.comapi.walknavi.d.e.c().g();
            com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().e();
    }

    public void a(int i) {
        TextView textView = this.ad;
        textView.setText(i + "");
        com.baidu.platform.comapi.walknavi.g.c.a.a().a(i, new h(this));
    }

    private void a(RelativeLayout relativeLayout) {
        CheckBox checkBox = (CheckBox) relativeLayout.findViewById(R.dimen.abc_edit_text_inset_bottom_material);
        this.f10085c = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            this.f10085c.setClickable(false);
        }
        CheckBox checkBox2 = (CheckBox) relativeLayout.findViewById(R.dimen.abc_floating_window_z);
        this.f10086d = checkBox2;
        checkBox2.setOnCheckedChangeListener(this);
        this.f10089g = relativeLayout.findViewById(R.dimen.abc_edit_text_inset_top_material);
        this.f10090h = (ImageView) relativeLayout.findViewById(R.dimen.abc_list_item_padding_horizontal_material);
        l();
        CheckBox checkBox3 = (CheckBox) relativeLayout.findViewById(R.dimen.abc_progress_bar_height_material);
        this.f10087e = checkBox3;
        checkBox3.setOnCheckedChangeListener(this);
        Button button = (Button) relativeLayout.findViewById(R.dimen.abc_search_view_preferred_width);
        this.f10088f = button;
        button.setOnClickListener(new k(this));
    }

    public void a(a aVar) {
        this.E = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
        Animation c2 = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.attr.SapiSdkDividerPadding);
        this.o.a();
        if (com.baidu.platform.comapi.walknavi.b.a().u() == 1) {
            if (!this.p.isShown()) {
                this.p.setAnimation(c2);
            }
            this.p.setVisibility(0);
            View view = this.ac;
            if (view != null) {
                if (!view.isShown()) {
                    this.ac.setAnimation(c2);
                }
                this.ac.setVisibility(0);
            }
            if (!this.y.isShown()) {
                this.y.setAnimation(c2);
            }
            this.y.setVisibility(0);
        }
    }

    public void a(boolean z) {
        this.D = z;
        if (z) {
            this.A.setTextColor(-8749952);
            this.A.setText("查看全览");
            return;
        }
        this.A.setTextColor(-13400577);
        this.A.setText("继续");
    }

    private void a(String str, b bVar) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("arKey", str);
        com.baidu.platform.comapi.walknavi.d.e.c().a(str, new q(this, bVar));
    }

    public void a(String str, d dVar) {
        String a2 = com.baidu.platform.comapi.walknavi.b.a().H().a(str, "");
        if (!TextUtils.isEmpty(a2)) {
            a(str, a2);
            return;
        }
        this.S = com.baidu.platform.comapi.walknavi.d.e.c().d(str);
        if (!com.baidu.platform.comapi.walknavi.d.e.c().c(str) && !this.R) {
            String str2 = this.S + File.separator + "ar";
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                b(str, str2);
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            return;
        }
        a(str, new s(this, str, dVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0137, code lost:
        if (r10.equals("helpless") != false) goto L41;
     */
    @Override // com.baidu.platform.comapi.walknavi.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, HashMap<String, Object> hashMap) {
        Runnable runnable;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "messageType:" + i);
        if (i == 1) {
            if (((Integer) hashMap.get("succeeded")).intValue() == 1) {
                com.baidu.platform.comapi.walknavi.d.e.c().c(true);
                com.baidu.platform.comapi.walknavi.d.e.c().b();
                k();
                com.baidu.platform.comapi.walknavi.d.e.c().k();
                com.baidu.platform.comapi.walknavi.d.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/start.mp3\", -1, 0)\n\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"enter\"\nfunction run()\n    local cfg = an.ActionPriorityConfig:new()\n    cfg.forward_logic = 1\n    cfg.backward_logic = 1\n    local param = an.GpbAnimationParam:new()\n    param._speed = 1.0\n    param._repeat_count = 1\n    param._name = pod_name\n    local id_play_pod = pod_node:play_gpb_animation(param, cfg)\n    if id_play_pod == -1 then\n        local mapData = an.MapData:new()\n        mapData:put_string(\"action_type\", \"animation_failed\")\n        mapData:put_string(\"token\", token)\n        lua_handler:send_message_tosdk(mapData)\n        return\n    end\n    \n    local podFinishedHandlerId = lua_handler:register_handle(\"onEnterPlayPodFinished\")\n    pod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\n\nfunction onEnterPlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"enter\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", RGState.METHOD_NAME_ENTER);
                return;
            }
            return;
        }
        char c2 = 4;
        if (i != 2) {
            if (i != 3) {
                if (i == 4 && hashMap.containsKey("url")) {
                    String str = (String) hashMap.get("url");
                    if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_VOICE_ON_OFF", true)) {
                        com.baidu.platform.comapi.wnplatform.o.i.a().a(str);
                    }
                }
            } else if (System.currentTimeMillis() - this.Y < 300) {
                if (this.Z) {
                    this.Z = false;
                    this.Y = System.currentTimeMillis();
                    Handler handler = this.n;
                    if (handler != null && (runnable = this.j) != null) {
                        handler.removeCallbacks(runnable);
                    }
                    com.baidu.platform.comapi.walknavi.d.e.c().k();
                    com.baidu.platform.comapi.walknavi.d.e.c().b(false);
                    com.baidu.platform.comapi.walknavi.d.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/tap2.mp3\", -1, 0)\n\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"multiClickAndTumble\"\n\nfunction run()\nlocal cfg = an.ActionPriorityConfig:new()\ncfg.forward_logic = 1\ncfg.backward_logic = 0\nlocal param = an.GpbAnimationParam:new()\nparam._speed = 1.2\nparam._repeat_count = 1\nparam._name = pod_name\nlocal id_play_pod = pod_node:play_gpb_animation(param, cfg)\nif id_play_pod == -1 then\nlocal mapData = an.MapData:new()\nmapData:put_string(\"action_type\", \"animation_failed\")\nmapData:put_string(\"token\", token)\nlua_handler:send_message_tosdk(mapData)\nreturn\nend\nlocal podFinishedHandlerId = lua_handler:register_handle(\"onMultiClickAndTumblePlayPodFinished\")\npod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\nfunction onMultiClickAndTumblePlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"multiClickAndTumble\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "multiClickAndTumble");
                }
            } else {
                this.Z = true;
                this.Y = System.currentTimeMillis();
                this.n.postDelayed(this.j, 500L);
            }
        } else if (hashMap == null || hashMap.isEmpty() || !hashMap.containsKey("action_name")) {
        } else {
            String str2 = (String) hashMap.get("action_name");
            com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "animation end:" + str2);
            switch (str2.hashCode()) {
                case -1838009598:
                    if (str2.equals("stopBreath")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1672022665:
                    if (str2.equals("multiClickAndTumble")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1311375678:
                    if (str2.equals("withoutGPS")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -789059494:
                    break;
                case -788629758:
                    if (str2.equals("turnAndGuide")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -778128814:
                    if (str2.equals("turnAndSayHi")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -420935824:
                    if (str2.equals("turnAndCry")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -136570977:
                    if (str2.equals("turnRight")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3641801:
                    if (str2.equals("walk")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 96667352:
                    if (str2.equals(RGState.METHOD_NAME_ENTER)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 133959204:
                    if (str2.equals("turnLeft")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1746496772:
                    if (str2.equals("achieveGoal")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    com.baidu.platform.comapi.walknavi.d.e.c().k();
                    com.baidu.platform.comapi.walknavi.d.e.c().a(false);
                    com.baidu.platform.comapi.walknavi.d.e.c().b(false);
                    return;
                case 1:
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    return;
                case 2:
                    com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().b("\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"stopBreath\"\n\nfunction run()\nlocal cfg = an.ActionPriorityConfig:new()\ncfg.forward_logic = 1\ncfg.backward_logic = 0\nlocal param = an.GpbAnimationParam:new()\nparam._speed = 1.0\nparam._repeat_count = -1\nparam._name = pod_name\nlocal id_play_pod = pod_node:play_gpb_animation(param, cfg)\nif id_play_pod == -1 then\nlocal mapData = an.MapData:new()\nmapData:put_string(\"action_type\", \"animation_failed\")\nmapData:put_string(\"token\", token)\nlua_handler:send_message_tosdk(mapData)\nreturn\nend\nlocal podFinishedHandlerId = lua_handler:register_handle(\"onStopBreathPlayPodFinished\")\npod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\nfunction onStopBreathPlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n \nlocal onClickHandler = lua_handler:register_handle(\"onStopBreathClick\")\ncurrent_scene:set_event_handler(0, onClickHandler)\nfunction onStopBreathClick()\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_type\", \"click\")\n    mapData:put_string(\"name\", pod_name)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "stopBreath");
                    return;
                case 3:
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    return;
                case 4:
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    return;
                case 5:
                    com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    return;
                case 6:
                case '\t':
                default:
                    return;
                case 7:
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                    return;
                case '\b':
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                    return;
                case '\n':
                    com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    this.Z = true;
                    return;
                case 11:
                    com.baidu.platform.comapi.walknavi.d.e.c().b(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().a(true);
                    return;
            }
        }
    }
}
