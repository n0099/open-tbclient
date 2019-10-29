package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.b.a;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.component.CircleTextProgressbar;
import com.baidu.swan.game.ad.component.RewardVideoView;
/* loaded from: classes2.dex */
public abstract class c {
    private Button bwM;
    private RewardVideoView bwW;
    private com.baidu.swan.apps.media.d.a bwX;
    private CircleTextProgressbar bwY;
    private com.baidu.swan.game.ad.a.a bwZ;
    private a.b bxb;
    private a.c bxc;
    public Context c;
    private RelativeLayout d;
    private View e;
    private int h;
    private LinearLayout j;
    private ImageView k;
    private TextView l;
    private RelativeLayout m;
    private final Handler bxa = new Handler();
    private Runnable s = new Runnable() { // from class: com.baidu.swan.game.ad.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bwX != null) {
                int currentPosition = c.this.bwX.getCurrentPosition();
                c.this.h = c.this.bwX.getDuration();
                int i = 0;
                if (c.this.h > 0 && currentPosition <= c.this.h && currentPosition >= 0) {
                    i = (int) Math.round((c.this.h - currentPosition) / 1000.0d);
                }
                int min = Math.min(currentPosition + 1000, c.this.h);
                c.this.bwY.a(c.this.h, min);
                c.this.bwY.setText(String.valueOf(i));
                if (min < c.this.h) {
                    c.this.bxa.postDelayed(c.this.s, 100L);
                }
            }
        }
    };
    private View.OnClickListener bxd = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bwW != null) {
                if (c.this.bwW.a()) {
                    c.this.k.setImageResource(a.c.ng_game_vol_open);
                    c.this.bwW.a(false);
                    return;
                }
                c.this.k.setImageResource(a.c.ng_game_vol_close);
                c.this.bwW.a(true);
            }
        }
    };
    private View.OnClickListener bxe = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bxb != null) {
                c.this.bxb.a();
            }
        }
    };
    private View.OnClickListener bxf = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bxc != null) {
                c.this.bxc.b();
            }
        }
    };
    public int a = com.baidu.swan.games.view.a.c.Yw();
    public int b = com.baidu.swan.games.view.a.c.Yx();

    public abstract View VD();

    public c(Context context, com.baidu.swan.game.ad.a.a aVar) {
        this.c = context;
        this.bwZ = aVar;
        j();
    }

    private void j() {
        Resources resources = this.c.getResources();
        this.e = VD();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, this.b);
        this.e.setLayoutParams(layoutParams);
        this.d = (RelativeLayout) this.e.findViewById(a.d.reward_relative);
        this.bwW = (RewardVideoView) this.e.findViewById(a.d.video_view);
        this.bwW.setLayoutParams(layoutParams);
        this.bwY = (CircleTextProgressbar) this.e.findViewById(a.d.progress);
        this.bwY.setVisibility(4);
        this.bwY.setOutLineColor(resources.getColor(a.b.out_line_color));
        this.bwY.setProgressColor(resources.getColor(a.b.progress_color));
        this.bwY.setProgressLineWidth(z.dip2px(this.c, 2.0f));
        this.bwY.setTextColor(resources.getColor(a.b.progress_text_color));
        this.bwY.setProgressType(CircleTextProgressbar.b.COUNT);
        this.j = (LinearLayout) this.e.findViewById(a.d.vol_clo);
        this.k = (ImageView) this.e.findViewById(a.d.volume);
        this.l = (TextView) this.e.findViewById(a.d.close_ad);
        this.m = (RelativeLayout) this.e.findViewById(a.d.banner);
        ((AdImageVIew) this.e.findViewById(a.d.reward_icon)).setImageUrl(this.bwZ.d());
        ((TextView) this.e.findViewById(a.d.title)).setText(this.bwZ.a());
        ((TextView) this.e.findViewById(a.d.desc)).setText(this.bwZ.b());
        this.bwM = (Button) this.e.findViewById(a.d.download);
        if (this.bwZ.g() == 1) {
            this.bwM.setText(resources.getString(a.f.see_detail));
        }
        if (this.bwZ.g() == 2) {
            this.bwM.setText(resources.getString(a.f.down_immediately));
        }
        this.bwX = this.bwW.getPlayer();
        k();
    }

    private void k() {
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.k.setOnClickListener(this.bxd);
        this.l.setOnClickListener(this.bxe);
        this.m.setOnClickListener(this.bxf);
        this.bwM.setOnClickListener(this.bxf);
    }

    public void a(a.c cVar) {
        this.bxc = cVar;
    }

    public void a(a.b bVar) {
        this.bxb = bVar;
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.bwW != null) {
            this.bwW.a(str);
        }
    }

    public com.baidu.swan.apps.media.d.a VC() {
        if (this.bwW != null) {
            return this.bwW.getPlayer();
        }
        return null;
    }

    private void l() {
        if (this.bwY != null) {
            this.bxa.removeCallbacksAndMessages(null);
            this.bxa.postDelayed(this.s, 0L);
        }
    }

    private void m() {
        if (this.bwY != null) {
            this.bxa.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        l();
        if (this.bwY.getVisibility() != 0) {
            this.bwY.setVisibility(0);
            this.bwY.setTimeMillis(this.h);
        }
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        if (this.m.getVisibility() != 0) {
            this.m.setAnimation(AnimationUtils.loadAnimation(this.c, a.C0239a.ng_game_ad_open));
            this.m.setVisibility(0);
        }
    }

    public void d() {
        if (this.bwX != null) {
            this.h = this.bwX.getDuration();
        }
    }

    public void e() {
        m();
    }

    public void f() {
        l();
    }

    public void g() {
        m();
    }

    public void h() {
        if (this.bwY != null) {
            this.bwY.setVisibility(4);
        }
        m();
    }
}
