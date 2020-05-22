package com.baidu.platform.comapi.walknavi.g.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
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
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.platform.comapi.walknavi.d.g;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.tieba.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c extends com.baidu.platform.comapi.walknavi.g.b.b implements CompoundButton.OnCheckedChangeListener, com.baidu.platform.comapi.walknavi.d.b {
    private TextView A;
    private RelativeLayout B;
    private ImageButton C;
    private boolean D;
    private a E;
    private RelativeLayout F;
    private RelativeLayout G;
    private RelativeLayout H;
    private RelativeLayout I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private View N;
    private String Q;
    private String S;
    private com.baidu.platform.comapi.walknavi.widget.a U;
    private IWMoreNPCModelOnClickListener V;
    private IWNPCLoadAndInitListener W;
    Animation a;
    private View aa;
    private View ab;
    private View ac;
    private TextView ad;
    private ImageView ae;
    private TextView af;
    Animation b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
    Button f;
    View g;
    ImageView h;
    private FrameLayout k;
    private Context l;
    private com.baidu.platform.comapi.walknavi.g.a m;
    private ad o;
    private RelativeLayout p;
    private ImageButton q;
    private ImageButton r;
    private int v;
    private RelativeLayout y;
    private ImageButton z;
    private Handler n = new Handler();
    private final int s = 1;
    private final int t = 2;
    private final int u = 3;
    private int w = 1;
    private int x = 1;
    private boolean M = false;
    private AlphaAnimation O = new AlphaAnimation(1.0f, 0.0f);
    private AlphaAnimation P = new AlphaAnimation(0.0f, 1.0f);
    private boolean R = false;
    private boolean T = false;
    private boolean X = true;
    private long Y = 0;
    private boolean Z = true;
    private final View.OnClickListener ag = new l(this);
    final Runnable i = new o(this);
    final Runnable j = new v(this);

    /* loaded from: classes8.dex */
    public interface a {
        void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);

        void a(String str);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void b();
    }

    public c(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        Bitmap imageToAR;
        Bitmap imageToNormal;
        this.J = null;
        this.l = context;
        this.a = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.anim.abc_popup_exit);
        this.a.setFillAfter(true);
        this.b = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.anim.abc_popup_enter);
        this.b.setFillAfter(true);
        this.O.setDuration(300L);
        this.P.setDuration(300L);
        this.m = aVar;
        this.o = new ad(context, view);
        b(view);
        this.H = (RelativeLayout) view.findViewById(2131165276);
        this.I = (RelativeLayout) view.findViewById(2131165280);
        this.G = (RelativeLayout) view.findViewById(2131165285);
        a(this.G);
        this.J = (ImageView) view.findViewById(2131165281);
        if (com.baidu.platform.comapi.walknavi.b.a().l() != null && (imageToNormal = com.baidu.platform.comapi.walknavi.b.a().l().getImageToNormal()) != null) {
            this.J.setImageBitmap(imageToNormal);
        }
        this.J.setOnClickListener(new com.baidu.platform.comapi.walknavi.g.b.d(this));
        this.K = (ImageView) view.findViewById(2131165282);
        a(view);
        this.L = (ImageView) view.findViewById(2131165279);
        if (com.baidu.platform.comapi.walknavi.b.a().b()) {
            this.L.setVisibility(0);
            if (com.baidu.platform.comapi.walknavi.b.a().l() != null && (imageToAR = com.baidu.platform.comapi.walknavi.b.a().l().getImageToAR()) != null) {
                this.L.setImageBitmap(imageToAR);
            }
        } else {
            this.L.setVisibility(8);
        }
        this.L.setOnClickListener(new r(this));
        this.p = (RelativeLayout) view.findViewById(2131165277);
        if (com.baidu.platform.comapi.walknavi.b.a().r() != com.baidu.platform.comapi.walknavi.b.a) {
        }
        this.q = (ImageButton) view.findViewById(2131165278);
        this.q.setOnClickListener(new w(this));
        this.y = (RelativeLayout) view.findViewById(R.raw.sapi_camera_too_near);
        this.C = (ImageButton) view.findViewById(R.raw.sweep);
        this.C.setOnClickListener(new x(this));
        this.B = (RelativeLayout) view.findViewById(R.raw.shake_tone);
        this.B.setOnClickListener(new y(this));
        this.A = (TextView) view.findViewById(2131165275);
        this.D = true;
        this.A.setOnClickListener(new z(this));
        this.z = (ImageButton) view.findViewById(2131165274);
        this.F = (RelativeLayout) view.findViewById(R.raw.tnconfig);
        this.F.setOnClickListener(this.ag);
        this.z.setOnClickListener(this.ag);
        this.N = view.findViewById(2131165284);
        this.N.setOnClickListener(new aa(this));
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        this.V = iWMoreNPCModelOnClickListener;
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        this.W = iWNPCLoadAndInitListener;
    }

    private void a(View view) {
        this.k = (FrameLayout) view.findViewById(R.raw.rim_video_too_near);
    }

    private void a(String str, String str2) {
        if (!a(str2)) {
            Log.e("LoadLocalNPCError", "the localNPCPath is not found, please check");
        } else if (com.baidu.platform.comapi.walknavi.d.e.c().o()) {
            b(str, str2);
            com.baidu.platform.comapi.walknavi.b.a().H().b(str, str2);
            if (this.W != null) {
                this.W.onSuccess();
            }
        } else {
            com.baidu.platform.comapi.walknavi.b.a().a(new ab(this, str, str2));
        }
    }

    public void a(BaseNpcModel baseNpcModel) {
        if (this.l != null) {
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
                Toast.makeText(this.l, (int) R.string.abc_font_family_body_2_material, 0).show();
            } else if (!NetworkUtil.isWifiState(this.l)) {
                a(baseNpcModel.getDownLoadKey(), com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.string.abc_font_family_body_1_material), 4);
            } else {
                a(baseNpcModel.getDownLoadKey(), new ac(this, baseNpcModel));
            }
        }
    }

    private boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i) {
        this.U = new com.baidu.platform.comapi.walknavi.widget.a(this.l).a(true).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.string.abc_activity_chooser_view_see_all)).a(String.format(str2, Integer.valueOf(i))).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.string.abc_action_bar_home_description)).b().b(new f(this, str)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.l, R.string.abc_activitychooserview_choose_application)).a(new e(this));
        if (!this.U.isShowing() && this.l != null && !((Activity) this.l).isFinishing()) {
            this.U.show();
        }
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
            if (!z) {
                this.y.startAnimation(this.b);
                this.H.startAnimation(this.b);
            }
        } else if (i == 2) {
            this.M = true;
            this.ac.setVisibility(8);
            if (z) {
                this.y.setVisibility(8);
                this.H.setVisibility(8);
                this.I.setVisibility(0);
            } else {
                this.y.setVisibility(8);
                this.y.startAnimation(this.a);
                this.H.startAnimation(this.a);
                this.a.setAnimationListener(new g(this));
            }
            com.baidu.platform.comapi.walknavi.b.a().D().c(true);
            this.n.postDelayed(this.i, 500L);
        }
    }

    private void b(View view) {
        this.ac = view.findViewById(R.raw.sapi_camera_nod);
        this.aa = view.findViewById(R.raw.sapi_camera_special_recg);
        this.ab = view.findViewById(R.raw.sapi_camera_open_mouth);
        this.ad = (TextView) view.findViewById(R.raw.sapi_camera_too_far);
        this.ae = (ImageView) view.findViewById(R.raw.sapi_camera_photo_done);
        this.af = (TextView) view.findViewById(R.raw.sapi_camera_put_face_round);
    }

    public void a(int i) {
        this.ad.setText(i + "");
        com.baidu.platform.comapi.walknavi.g.c.a.a().a(i, new h(this));
    }

    private void a(RelativeLayout relativeLayout) {
        this.c = (CheckBox) relativeLayout.findViewById(2131165288);
        this.c.setOnCheckedChangeListener(this);
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            this.c.setClickable(false);
        }
        this.d = (CheckBox) relativeLayout.findViewById(2131165291);
        this.d.setOnCheckedChangeListener(this);
        this.g = relativeLayout.findViewById(2131165290);
        this.h = (ImageView) relativeLayout.findViewById(2131165292);
        l();
        this.e = (CheckBox) relativeLayout.findViewById(2131165294);
        this.e.setOnCheckedChangeListener(this);
        this.f = (Button) relativeLayout.findViewById(2131165296);
        this.f.setOnClickListener(new k(this));
    }

    private void l() {
        if (com.baidu.platform.comapi.wnplatform.o.a.a()) {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            com.baidu.platform.comapi.walknavi.b.a().D().b(true);
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        com.baidu.platform.comapi.walknavi.b.a().D().b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == 0) {
            MapStatus i = com.baidu.platform.comapi.walknavi.b.a().G().i();
            if (i != null) {
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.overlook(0.0f);
                builder.zoom(19.0f);
                builder.targetScreen(new Point((i.winRound.right + i.winRound.left) / 2, ((i.winRound.f989top + i.winRound.bottom) / 2) - ((int) (0.0d - ((Math.abs(i.winRound.bottom - i.winRound.f989top) - 75) * 0.25d)))));
                com.baidu.mapapi.model.inner.Point K = com.baidu.platform.comapi.walknavi.b.a().K();
                if (K != null) {
                    builder.target(new LatLng(K.getmPty(), K.getmPtx()));
                }
                com.baidu.platform.comapi.walknavi.b.a().G().a(i, 500);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
    }

    public void c() {
        if (this.T) {
            com.baidu.platform.comapi.walknavi.d.e.c().a(new C0225c(this));
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0225c implements g.a {
        private WeakReference<com.baidu.platform.comapi.walknavi.g.b.b> a;

        public C0225c(com.baidu.platform.comapi.walknavi.g.b.b bVar) {
            this.a = null;
            this.a = new WeakReference<>(bVar);
        }

        @Override // com.baidu.platform.comapi.walknavi.d.g.a
        public void a(g.b bVar) {
        }
    }

    public void d() {
        n();
    }

    public void a(a aVar) {
        this.E = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.anim.abc_popup_enter);
        this.o.a();
        if (com.baidu.platform.comapi.walknavi.b.a().u() == 1) {
            if (!this.p.isShown()) {
                this.p.setAnimation(c);
            }
            this.p.setVisibility(0);
            if (this.ac != null) {
                if (!this.ac.isShown()) {
                    this.ac.setAnimation(c);
                }
                this.ac.setVisibility(0);
            }
            if (!this.y.isShown()) {
                this.y.setAnimation(c);
            }
            this.y.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.l, R.anim.abc_popup_exit);
        this.o.b();
        if (com.baidu.platform.comapi.walknavi.g.a.b.a == 2) {
            if (this.r.isShown()) {
                this.r.setAnimation(c);
            }
            this.r.setVisibility(8);
        }
        if (this.ac != null) {
            if (this.ac.isShown()) {
                this.ac.setAnimation(c);
            }
            this.ac.setVisibility(8);
        }
    }

    private void n() {
    }

    public void b(int i) {
        switch (i) {
            case 3:
            default:
                return;
        }
    }

    public void a(boolean z) {
        this.D = z;
        if (this.D) {
            this.A.setTextColor(-8749952);
            this.A.setText("查看全览");
            return;
        }
        this.A.setTextColor(-13400577);
        this.A.setText("继续");
    }

    public void c(int i) {
        if (i == R.drawable.aiapps_checkbox_checked) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, (int) R.drawable.aiapps_checkbox_checked));
            this.v = 1;
        } else if (i == R.drawable.aiapps_checkbox_normal_disable) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, (int) R.drawable.aiapps_checkbox_normal_disable));
            this.v = 2;
        } else if (i == R.drawable.aiapps_checkbox_checked_disable) {
            this.q.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, (int) R.drawable.aiapps_checkbox_checked_disable));
            this.v = 3;
        }
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

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == 2131165288) {
            if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
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
            }
        } else if (compoundButton.getId() == 2131165291) {
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
        } else if (compoundButton.getId() == 2131165294) {
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

    private void d(boolean z) {
        MapStatus i = com.baidu.platform.comapi.walknavi.b.a().G().i();
        MapStatus.Builder builder = new MapStatus.Builder();
        if (i != null) {
            if (z) {
                builder.overlook(-50.0f);
                com.baidu.platform.comapi.walknavi.b.a().b(-50);
            } else {
                builder.overlook(0.0f);
                com.baidu.platform.comapi.walknavi.b.a().b(0);
            }
            com.baidu.platform.comapi.walknavi.b.a().G().a(i, FeatureCodes.VO);
        }
    }

    public ImageView h() {
        return this.K;
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
                        } catch (Exception e) {
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
    public void o() {
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        if (TextUtils.isEmpty(a2)) {
            this.N.setVisibility(0);
            ((ImageView) this.N).setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, (int) R.drawable.aiapps_favorite_guide_bg));
            return;
        }
        com.baidu.platform.comapi.walknavi.d.a a3 = com.baidu.platform.comapi.walknavi.b.a().a(a2);
        if (a3 != null) {
            Bitmap d2 = a3.d();
            if (d2 != null) {
                this.N.setVisibility(0);
                ((ImageView) this.N).setImageBitmap(d2);
                return;
            }
            this.N.setVisibility(0);
            ((ImageView) this.N).setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.l, (int) R.drawable.aiapps_game_keyboard_sendbutton_disabled));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "call npcSwitchCase");
        com.baidu.platform.comapi.walknavi.d.e.c().a(str, this.k.getHeight(), this.k.getWidth());
        com.baidu.platform.comapi.walknavi.d.e.c().c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        com.baidu.platform.comapi.walknavi.d.e.c().b(str, this.k.getWidth(), this.k.getHeight());
        com.baidu.platform.comapi.walknavi.d.e.c().c(false);
    }

    public void i() {
        com.baidu.platform.comapi.walknavi.b.a().D().c(true);
        this.k.setVisibility(0);
        com.baidu.platform.comapi.walknavi.d.e.c().h();
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

    public void j() {
        com.baidu.platform.comapi.wnplatform.m.d.a().a(false);
        if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            p();
            com.baidu.platform.comapi.walknavi.d.e.c().c(true);
            com.baidu.platform.comapi.walknavi.d.e.c().a(false);
            com.baidu.platform.comapi.walknavi.d.e.c().i();
            this.k.removeAllViews();
        }
        if (this.n != null && this.i != null) {
            this.n.removeCallbacks(this.i);
            this.n = null;
        }
    }

    public void c(boolean z) {
        if (com.baidu.platform.comapi.walknavi.d.e.c().p()) {
            b(z);
        }
    }

    private void p() {
        if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_AR_NPC_IS_DOWNLOADING", false)) {
            com.baidu.platform.comapi.walknavi.d.e.c().n();
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

    private void a(String str, b bVar) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a(ARConfigKey.OLD_AR_KEY, str);
        com.baidu.platform.comapi.walknavi.d.e.c().a(str, new q(this, bVar));
    }

    public void a(String str, d dVar) {
        String a2 = com.baidu.platform.comapi.walknavi.b.a().H().a(str, "");
        if (!TextUtils.isEmpty(a2)) {
            a(str, a2);
            return;
        }
        this.S = com.baidu.platform.comapi.walknavi.d.e.c().d(str);
        if (com.baidu.platform.comapi.walknavi.d.e.c().c(str) || this.R) {
            a(str, new s(this, str, dVar));
            return;
        }
        String str2 = this.S + File.separator + "ar";
        if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            b(str, str2);
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void k() {
        String a2 = com.baidu.platform.comapi.walknavi.d.e.c().a();
        if (TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.b.a().H().a(a2, ""))) {
            com.baidu.platform.comapi.walknavi.d.e.c().b(a2, new t(this, a2));
        }
    }

    private int q() {
        return com.baidu.platform.comapi.wnplatform.o.g.c(this.l);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.platform.comapi.walknavi.d.b
    public void a(int i, HashMap<String, Object> hashMap) {
        char c;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "messageType:" + i);
        switch (i) {
            case 1:
                if (((Integer) hashMap.get("succeeded")).intValue() == 1) {
                    com.baidu.platform.comapi.walknavi.d.e.c().c(true);
                    com.baidu.platform.comapi.walknavi.d.e.c().b();
                    k();
                    com.baidu.platform.comapi.walknavi.d.e.c().k();
                    com.baidu.platform.comapi.walknavi.d.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/start.mp3\", -1, 0)\n\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"enter\"\nfunction run()\n    local cfg = an.ActionPriorityConfig:new()\n    cfg.forward_logic = 1\n    cfg.backward_logic = 1\n    local param = an.GpbAnimationParam:new()\n    param._speed = 1.0\n    param._repeat_count = 1\n    param._name = pod_name\n    local id_play_pod = pod_node:play_gpb_animation(param, cfg)\n    if id_play_pod == -1 then\n        local mapData = an.MapData:new()\n        mapData:put_string(\"action_type\", \"animation_failed\")\n        mapData:put_string(\"token\", token)\n        lua_handler:send_message_tosdk(mapData)\n        return\n    end\n    \n    local podFinishedHandlerId = lua_handler:register_handle(\"onEnterPlayPodFinished\")\n    pod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\n\nfunction onEnterPlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"enter\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "enter");
                    return;
                }
                return;
            case 2:
                if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("action_name")) {
                    String str = (String) hashMap.get("action_name");
                    com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "animation end:" + str);
                    switch (str.hashCode()) {
                        case -1838009598:
                            if (str.equals("stopBreath")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1672022665:
                            if (str.equals("multiClickAndTumble")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1311375678:
                            if (str.equals("withoutGPS")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -789059494:
                            if (str.equals("helpless")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -788629758:
                            if (str.equals("turnAndGuide")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case -778128814:
                            if (str.equals("turnAndSayHi")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -420935824:
                            if (str.equals("turnAndCry")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -136570977:
                            if (str.equals("turnRight")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3641801:
                            if (str.equals("walk")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case 96667352:
                            if (str.equals("enter")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 133959204:
                            if (str.equals("turnLeft")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1746496772:
                            if (str.equals("achieveGoal")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
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
                return;
            case 3:
                if (System.currentTimeMillis() - this.Y < 300) {
                    if (this.Z) {
                        this.Z = false;
                        this.Y = System.currentTimeMillis();
                        if (this.n != null && this.j != null) {
                            this.n.removeCallbacks(this.j);
                        }
                        com.baidu.platform.comapi.walknavi.d.e.c().k();
                        com.baidu.platform.comapi.walknavi.d.e.c().b(false);
                        com.baidu.platform.comapi.walknavi.d.e.c().b("\npod_node:stop_action(id_play_music)\nid_play_music = pod_node:play_audio(\"res/media/tap2.mp3\", -1, 0)\n\nlocal token = dfk7fghdsf7d33e\nlocal pod_name = \"multiClickAndTumble\"\n\nfunction run()\nlocal cfg = an.ActionPriorityConfig:new()\ncfg.forward_logic = 1\ncfg.backward_logic = 0\nlocal param = an.GpbAnimationParam:new()\nparam._speed = 1.2\nparam._repeat_count = 1\nparam._name = pod_name\nlocal id_play_pod = pod_node:play_gpb_animation(param, cfg)\nif id_play_pod == -1 then\nlocal mapData = an.MapData:new()\nmapData:put_string(\"action_type\", \"animation_failed\")\nmapData:put_string(\"token\", token)\nlua_handler:send_message_tosdk(mapData)\nreturn\nend\nlocal podFinishedHandlerId = lua_handler:register_handle(\"onMultiClickAndTumblePlayPodFinished\")\npod_node:set_action_completion_handler(id_play_pod, podFinishedHandlerId)\nend\nrun()\nfunction onMultiClickAndTumblePlayPodFinished(state, action_id)\n    local mapData = an.MapData:new()\n    mapData:put_string(\"action_id\", action_id)\n    mapData:put_string(\"action_type\", \"animation_end\")\n    mapData:put_string(\"action_name\", \"multiClickAndTumble\")\n    mapData:put_string(\"token\", token)\n    mapData:put_int(\"state\", state)\n    lua_handler:send_message_tosdk(mapData)\nend\n", "multiClickAndTumble");
                        return;
                    }
                    return;
                }
                this.Z = true;
                this.Y = System.currentTimeMillis();
                this.n.postDelayed(this.j, 500L);
                return;
            case 4:
                if (hashMap.containsKey("url")) {
                    String str2 = (String) hashMap.get("url");
                    if (com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_VOICE_ON_OFF", true)) {
                        com.baidu.platform.comapi.wnplatform.o.i.a().a(str2);
                        return;
                    }
                    return;
                }
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return;
        }
    }
}
