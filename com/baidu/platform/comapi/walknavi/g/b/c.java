package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends b implements CompoundButton.OnCheckedChangeListener {
    private boolean A;
    private a B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    private RelativeLayout F;
    private RelativeLayout G;
    private ImageView H;
    private ImageView I;
    private View M;
    private View N;
    private View O;
    private TextView P;
    private ImageView Q;
    private TextView R;
    Animation a;
    Animation b;
    CheckBox c;
    CheckBox d;
    CheckBox e;
    Button f;
    View g;
    ImageView h;
    private Context i;
    private com.baidu.platform.comapi.walknavi.g.a j;
    private o k;
    private RelativeLayout l;
    private ImageButton m;
    private ImageButton n;
    private int r;
    private RelativeLayout u;
    private ImageButton v;
    private TextView w;
    private RelativeLayout x;
    private RelativeLayout y;
    private ImageButton z;
    private final int o = 1;
    private final int p = 2;
    private final int q = 3;
    private int s = 1;
    private int t = 1;
    private boolean J = false;
    private AlphaAnimation K = new AlphaAnimation(1.0f, 0.0f);
    private AlphaAnimation L = new AlphaAnimation(0.0f, 1.0f);
    private final View.OnClickListener S = new n(this);

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.platform.comapi.walknavi.segmentbrowse.b bVar);
    }

    public c(Context context, com.baidu.platform.comapi.walknavi.g.a aVar, View view) {
        this.G = null;
        this.i = context;
        this.a = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.i, R.anim.abc_popup_exit);
        this.a.setFillAfter(true);
        this.b = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.i, R.anim.abc_popup_enter);
        this.b.setFillAfter(true);
        this.K.setDuration(300L);
        this.L.setDuration(300L);
        this.j = aVar;
        this.k = new o(context, view);
        a(view);
        this.E = (RelativeLayout) view.findViewById(2131165275);
        this.F = (RelativeLayout) view.findViewById(2131165279);
        this.D = (RelativeLayout) view.findViewById(2131165282);
        a(this.D);
        this.G = (RelativeLayout) view.findViewById(2131165280);
        this.H = (ImageView) view.findViewById(2131165281);
        this.I = (ImageView) view.findViewById(2131165278);
        if (com.baidu.platform.comapi.walknavi.b.a().b()) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
        this.I.setOnClickListener(new d(this));
        this.l = (RelativeLayout) view.findViewById(2131165276);
        if (com.baidu.platform.comapi.walknavi.b.a().n() != com.baidu.platform.comapi.walknavi.b.a) {
        }
        this.m = (ImageButton) view.findViewById(2131165277);
        this.m.setOnClickListener(new e(this));
        this.u = (RelativeLayout) view.findViewById(2131165268);
        this.z = (ImageButton) view.findViewById(2131165271);
        this.z.setOnClickListener(new f(this));
        this.x = (RelativeLayout) view.findViewById(2131165270);
        this.x.setOnClickListener(new g(this));
        this.w = (TextView) view.findViewById(2131165274);
        this.A = true;
        this.w.setOnClickListener(new h(this));
        this.v = (ImageButton) view.findViewById(2131165273);
        this.C = (RelativeLayout) view.findViewById(2131165272);
        this.C.setOnClickListener(this.S);
        this.v.setOnClickListener(this.S);
    }

    public void a(int i, boolean z) {
        if (i == 1) {
            this.J = false;
            this.O.setVisibility(0);
            this.u.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setVisibility(8);
            if (!z) {
                this.u.startAnimation(this.b);
                this.E.startAnimation(this.b);
            }
        } else if (i == 2) {
            this.J = true;
            this.O.setVisibility(8);
            if (z) {
                this.u.setVisibility(8);
                this.E.setVisibility(8);
                this.F.setVisibility(0);
                return;
            }
            this.u.setVisibility(8);
            this.u.startAnimation(this.a);
            this.E.startAnimation(this.a);
            this.a.setAnimationListener(new i(this));
        }
    }

    private void a(View view) {
        this.O = view.findViewById(2131165262);
        this.M = view.findViewById(2131165266);
        this.N = view.findViewById(2131165263);
        this.P = (TextView) view.findViewById(2131165267);
        this.Q = (ImageView) view.findViewById(2131165264);
        this.R = (TextView) view.findViewById(2131165265);
    }

    public void a(int i) {
        this.P.setText(i + "");
        com.baidu.platform.comapi.walknavi.g.c.a.a().a(i, new j(this));
    }

    private void a(RelativeLayout relativeLayout) {
        this.c = (CheckBox) relativeLayout.findViewById(2131165285);
        this.c.setOnCheckedChangeListener(this);
        if (com.baidu.platform.comapi.walknavi.b.a().E() == 4) {
            this.c.setClickable(false);
        }
        this.d = (CheckBox) relativeLayout.findViewById(2131165288);
        this.d.setOnCheckedChangeListener(this);
        this.g = relativeLayout.findViewById(2131165287);
        this.h = (ImageView) relativeLayout.findViewById(2131165289);
        i();
        this.e = (CheckBox) relativeLayout.findViewById(2131165291);
        this.e.setOnCheckedChangeListener(this);
        this.f = (Button) relativeLayout.findViewById(2131165293);
        this.f.setOnClickListener(new m(this));
    }

    private void i() {
        if (com.baidu.platform.comapi.wnplatform.o.a.a()) {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            com.baidu.platform.comapi.walknavi.b.a().y().b(true);
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        com.baidu.platform.comapi.walknavi.b.a().y().b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.a() == 0) {
            MapStatus h = com.baidu.platform.comapi.walknavi.b.a().B().h();
            if (h != null) {
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.overlook(0.0f);
                builder.zoom(19.0f);
                builder.targetScreen(new Point((h.winRound.right + h.winRound.left) / 2, ((h.winRound.top + h.winRound.bottom) / 2) - ((int) (0.0d - ((Math.abs(h.winRound.bottom - h.winRound.top) - 75) * 0.25d)))));
                com.baidu.mapapi.model.inner.Point F = com.baidu.platform.comapi.walknavi.b.a().F();
                if (F != null) {
                    builder.target(new LatLng(F.getmPty(), F.getmPtx()));
                }
                com.baidu.platform.comapi.walknavi.b.a().B().a(h, 1700);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a());
    }

    public void c() {
        k();
    }

    public void a(a aVar) {
        this.B = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void a() {
        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.i, R.anim.abc_popup_enter);
        this.k.a();
        if (com.baidu.platform.comapi.walknavi.b.a().o() == 1) {
            if (!this.l.isShown()) {
                this.l.setAnimation(c);
            }
            this.l.setVisibility(0);
            if (this.O != null) {
                if (!this.O.isShown()) {
                    this.O.setAnimation(c);
                }
                this.O.setVisibility(0);
            }
            if (!this.u.isShown()) {
                this.u.setAnimation(c);
            }
            this.u.setVisibility(0);
            if (this.y != null) {
                if (!this.y.isShown()) {
                    this.y.setAnimation(c);
                }
                this.y.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.walknavi.g.b.b
    public void b() {
        Animation c = com.baidu.platform.comapi.wnplatform.o.a.a.c(this.i, R.anim.abc_popup_exit);
        this.k.b();
        if (com.baidu.platform.comapi.walknavi.g.a.b.a == 2) {
            if (this.n.isShown()) {
                this.n.setAnimation(c);
            }
            this.n.setVisibility(8);
        }
        if (this.y != null) {
            if (this.y.isShown()) {
                this.y.setAnimation(c);
            }
            this.y.setVisibility(8);
        }
        if (this.O != null) {
            if (this.O.isShown()) {
                this.O.setAnimation(c);
            }
            this.O.setVisibility(8);
        }
    }

    private void k() {
    }

    public void b(int i) {
        switch (i) {
            case 3:
            default:
                return;
        }
    }

    public void a(boolean z) {
        this.A = z;
        if (this.A) {
            this.w.setTextColor(-8749952);
            this.w.setText("查看全览");
            return;
        }
        this.w.setTextColor(-13400577);
        this.w.setText("继续");
    }

    public void c(int i) {
        if (i == R.drawable.aiapps_night_mode_toast_icon) {
            this.m.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.i, (int) R.drawable.aiapps_night_mode_toast_icon));
            this.r = 1;
        } else if (i == R.drawable.aiapps_open_app_buttion_selector) {
            this.m.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.i, (int) R.drawable.aiapps_open_app_buttion_selector));
            this.r = 2;
        } else if (i == R.drawable.aiapps_no_recommend) {
            this.m.setImageDrawable(com.baidu.platform.comapi.wnplatform.o.a.a.a(this.i, (int) R.drawable.aiapps_no_recommend));
            this.r = 3;
        }
    }

    public void d() {
        this.k.c();
        this.i = null;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == 2131165285) {
            if (com.baidu.platform.comapi.walknavi.b.a().E() != 4) {
                com.baidu.platform.comapi.wnplatform.c.a.c("yang12", "onCheckedChanged:sound_check:" + z);
                if (z) {
                    if (com.baidu.platform.comapi.walknavi.b.a().E() != 4) {
                        com.baidu.platform.comapi.wnplatform.k.a.a().a("sound", 1);
                        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                    }
                    WNaviTTSPlayer.resumeVoiceTTSOutput();
                    com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_VOICE_ON_OFF", true);
                    return;
                }
                if (com.baidu.platform.comapi.walknavi.b.a().E() != 4) {
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("sound", 0);
                    com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                }
                WNaviTTSPlayer.pauseVoiceTTSOutput();
                com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_VOICE_ON_OFF", false);
            }
        } else if (compoundButton.getId() == 2131165288) {
            com.baidu.platform.comapi.wnplatform.c.a.c("yang12", "onCheckedChanged:panocheck:" + z);
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_STREET_POI_ON_OFF", true);
                com.baidu.platform.comapi.walknavi.b.a().y().b(true);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("streetPoi", 1);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_STREET_POI_ON_OFF", false);
            com.baidu.platform.comapi.walknavi.b.a().y().b(false);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("streetPoi", 0);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
        } else if (compoundButton.getId() == 2131165291) {
            if (z) {
                com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_THREED_MAP_ON_OFF", true);
                b(true);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("threeD", 1);
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
                return;
            }
            com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_THREED_MAP_ON_OFF", false);
            b(false);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("threeD", 0);
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG");
        }
    }

    private void b(boolean z) {
        MapStatus h = com.baidu.platform.comapi.walknavi.b.a().B().h();
        MapStatus.Builder builder = new MapStatus.Builder();
        if (h != null) {
            if (z) {
                builder.overlook(-50.0f);
                com.baidu.platform.comapi.walknavi.b.a().b(-50);
            } else {
                builder.overlook(0.0f);
                com.baidu.platform.comapi.walknavi.b.a().b(0);
            }
            com.baidu.platform.comapi.walknavi.b.a().B().a(h, 1300);
        }
    }

    public RelativeLayout g() {
        return this.G;
    }

    public ImageView h() {
        return this.H;
    }
}
