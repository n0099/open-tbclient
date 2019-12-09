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
    private Button bvV;
    private RewardVideoView bwf;
    private com.baidu.swan.apps.media.d.a bwg;
    private CircleTextProgressbar bwh;
    private com.baidu.swan.game.ad.a.a bwi;
    private a.b bwk;
    private a.c bwl;
    public Context c;
    private RelativeLayout d;
    private View e;
    private int h;
    private LinearLayout j;
    private ImageView k;
    private TextView l;
    private RelativeLayout m;
    private final Handler bwj = new Handler();
    private Runnable s = new Runnable() { // from class: com.baidu.swan.game.ad.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bwg != null) {
                int currentPosition = c.this.bwg.getCurrentPosition();
                c.this.h = c.this.bwg.getDuration();
                int i = 0;
                if (c.this.h > 0 && currentPosition <= c.this.h && currentPosition >= 0) {
                    i = (int) Math.round((c.this.h - currentPosition) / 1000.0d);
                }
                int min = Math.min(currentPosition + 1000, c.this.h);
                c.this.bwh.a(c.this.h, min);
                c.this.bwh.setText(String.valueOf(i));
                if (min < c.this.h) {
                    c.this.bwj.postDelayed(c.this.s, 100L);
                }
            }
        }
    };
    private View.OnClickListener bwm = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bwf != null) {
                if (c.this.bwf.a()) {
                    c.this.k.setImageResource(a.c.ng_game_vol_open);
                    c.this.bwf.a(false);
                    return;
                }
                c.this.k.setImageResource(a.c.ng_game_vol_close);
                c.this.bwf.a(true);
            }
        }
    };
    private View.OnClickListener bwn = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bwk != null) {
                c.this.bwk.a();
            }
        }
    };
    private View.OnClickListener bwo = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bwl != null) {
                c.this.bwl.b();
            }
        }
    };
    public int a = com.baidu.swan.games.view.a.c.Yu();
    public int b = com.baidu.swan.games.view.a.c.Yv();

    public abstract View VB();

    public c(Context context, com.baidu.swan.game.ad.a.a aVar) {
        this.c = context;
        this.bwi = aVar;
        j();
    }

    private void j() {
        Resources resources = this.c.getResources();
        this.e = VB();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, this.b);
        this.e.setLayoutParams(layoutParams);
        this.d = (RelativeLayout) this.e.findViewById(a.d.reward_relative);
        this.bwf = (RewardVideoView) this.e.findViewById(a.d.video_view);
        this.bwf.setLayoutParams(layoutParams);
        this.bwh = (CircleTextProgressbar) this.e.findViewById(a.d.progress);
        this.bwh.setVisibility(4);
        this.bwh.setOutLineColor(resources.getColor(a.b.out_line_color));
        this.bwh.setProgressColor(resources.getColor(a.b.progress_color));
        this.bwh.setProgressLineWidth(z.dip2px(this.c, 2.0f));
        this.bwh.setTextColor(resources.getColor(a.b.progress_text_color));
        this.bwh.setProgressType(CircleTextProgressbar.b.COUNT);
        this.j = (LinearLayout) this.e.findViewById(a.d.vol_clo);
        this.k = (ImageView) this.e.findViewById(a.d.volume);
        this.l = (TextView) this.e.findViewById(a.d.close_ad);
        this.m = (RelativeLayout) this.e.findViewById(a.d.banner);
        ((AdImageVIew) this.e.findViewById(a.d.reward_icon)).setImageUrl(this.bwi.d());
        ((TextView) this.e.findViewById(a.d.title)).setText(this.bwi.a());
        ((TextView) this.e.findViewById(a.d.desc)).setText(this.bwi.b());
        this.bvV = (Button) this.e.findViewById(a.d.download);
        if (this.bwi.g() == 1) {
            this.bvV.setText(resources.getString(a.f.see_detail));
        }
        if (this.bwi.g() == 2) {
            this.bvV.setText(resources.getString(a.f.down_immediately));
        }
        this.bwg = this.bwf.getPlayer();
        k();
    }

    private void k() {
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.k.setOnClickListener(this.bwm);
        this.l.setOnClickListener(this.bwn);
        this.m.setOnClickListener(this.bwo);
        this.bvV.setOnClickListener(this.bwo);
    }

    public void a(a.c cVar) {
        this.bwl = cVar;
    }

    public void a(a.b bVar) {
        this.bwk = bVar;
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.bwf != null) {
            this.bwf.a(str);
        }
    }

    public com.baidu.swan.apps.media.d.a VA() {
        if (this.bwf != null) {
            return this.bwf.getPlayer();
        }
        return null;
    }

    private void l() {
        if (this.bwh != null) {
            this.bwj.removeCallbacksAndMessages(null);
            this.bwj.postDelayed(this.s, 0L);
        }
    }

    private void m() {
        if (this.bwh != null) {
            this.bwj.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        l();
        if (this.bwh.getVisibility() != 0) {
            this.bwh.setVisibility(0);
            this.bwh.setTimeMillis(this.h);
        }
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        if (this.m.getVisibility() != 0) {
            this.m.setAnimation(AnimationUtils.loadAnimation(this.c, a.C0234a.ng_game_ad_open));
            this.m.setVisibility(0);
        }
    }

    public void d() {
        if (this.bwg != null) {
            this.h = this.bwg.getDuration();
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
        if (this.bwh != null) {
            this.bwh.setVisibility(4);
        }
        m();
    }
}
