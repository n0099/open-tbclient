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
    private Button bcH;
    private RewardVideoView bcR;
    private com.baidu.swan.apps.media.d.a bcS;
    private CircleTextProgressbar bcT;
    private com.baidu.swan.game.ad.a.a bcU;
    private a.b bcV;
    private a.c bcW;
    public Context c;
    private RelativeLayout d;
    private View e;
    private int h;
    private LinearLayout j;
    private ImageView k;
    private TextView l;
    private RelativeLayout m;
    private final Handler p = new Handler();
    private Runnable s = new Runnable() { // from class: com.baidu.swan.game.ad.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.bcS != null) {
                int currentPosition = c.this.bcS.getCurrentPosition();
                c.this.h = c.this.bcS.getDuration();
                int i = 0;
                if (c.this.h > 0 && currentPosition <= c.this.h && currentPosition >= 0) {
                    i = (int) Math.round((c.this.h - currentPosition) / 1000.0d);
                }
                int min = Math.min(currentPosition + 1000, c.this.h);
                c.this.bcT.a(c.this.h, min);
                c.this.bcT.setText(String.valueOf(i));
                if (min < c.this.h) {
                    c.this.p.postDelayed(c.this.s, 100L);
                }
            }
        }
    };
    private View.OnClickListener bcX = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bcR != null) {
                if (c.this.bcR.a()) {
                    c.this.k.setImageResource(a.c.ng_game_vol_open);
                    c.this.bcR.a(false);
                    return;
                }
                c.this.k.setImageResource(a.c.ng_game_vol_close);
                c.this.bcR.a(true);
            }
        }
    };
    private View.OnClickListener bcY = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bcV != null) {
                c.this.bcV.a();
            }
        }
    };
    private View.OnClickListener bcZ = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bcW != null) {
                c.this.bcW.b();
            }
        }
    };
    public int a = com.baidu.swan.games.view.a.c.SI();
    public int b = com.baidu.swan.games.view.a.c.SJ();

    public abstract View PR();

    public c(Context context, com.baidu.swan.game.ad.a.a aVar) {
        this.c = context;
        this.bcU = aVar;
        j();
    }

    private void j() {
        Resources resources = this.c.getResources();
        this.e = PR();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, this.b);
        this.e.setLayoutParams(layoutParams);
        this.d = (RelativeLayout) this.e.findViewById(a.d.reward_relative);
        this.bcR = (RewardVideoView) this.e.findViewById(a.d.video_view);
        this.bcR.setLayoutParams(layoutParams);
        this.bcT = (CircleTextProgressbar) this.e.findViewById(a.d.progress);
        this.bcT.setVisibility(4);
        this.bcT.setOutLineColor(resources.getColor(a.b.out_line_color));
        this.bcT.setProgressColor(resources.getColor(a.b.progress_color));
        this.bcT.setProgressLineWidth(z.dip2px(this.c, 2.0f));
        this.bcT.setTextColor(resources.getColor(a.b.progress_text_color));
        this.bcT.setProgressType(CircleTextProgressbar.b.COUNT);
        this.j = (LinearLayout) this.e.findViewById(a.d.vol_clo);
        this.k = (ImageView) this.e.findViewById(a.d.volume);
        this.l = (TextView) this.e.findViewById(a.d.close_ad);
        this.m = (RelativeLayout) this.e.findViewById(a.d.banner);
        ((AdImageVIew) this.e.findViewById(a.d.reward_icon)).setImageUrl(this.bcU.d());
        ((TextView) this.e.findViewById(a.d.title)).setText(this.bcU.a());
        ((TextView) this.e.findViewById(a.d.desc)).setText(this.bcU.b());
        this.bcH = (Button) this.e.findViewById(a.d.download);
        if (this.bcU.g() == 1) {
            this.bcH.setText(resources.getString(a.f.see_detail));
        }
        if (this.bcU.g() == 2) {
            this.bcH.setText(resources.getString(a.f.down_immediately));
        }
        this.bcS = this.bcR.getPlayer();
        k();
    }

    private void k() {
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.k.setOnClickListener(this.bcX);
        this.l.setOnClickListener(this.bcY);
        this.m.setOnClickListener(this.bcZ);
        this.bcH.setOnClickListener(this.bcZ);
    }

    public void a(a.c cVar) {
        this.bcW = cVar;
    }

    public void a(a.b bVar) {
        this.bcV = bVar;
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.bcR != null) {
            this.bcR.a(str);
        }
    }

    public com.baidu.swan.apps.media.d.a PQ() {
        if (this.bcR != null) {
            return this.bcR.getPlayer();
        }
        return null;
    }

    private void l() {
        if (this.bcT != null) {
            this.p.removeCallbacksAndMessages(null);
            this.p.postDelayed(this.s, 0L);
        }
    }

    private void m() {
        if (this.bcT != null) {
            this.p.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        l();
        if (this.bcT.getVisibility() != 0) {
            this.bcT.setVisibility(0);
            this.bcT.setTimeMillis(this.h);
        }
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        if (this.m.getVisibility() != 0) {
            this.m.setAnimation(AnimationUtils.loadAnimation(this.c, a.C0196a.ng_game_ad_open));
            this.m.setVisibility(0);
        }
    }

    public void d() {
        if (this.bcS != null) {
            this.h = this.bcS.getDuration();
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
        if (this.bcT != null) {
            this.bcT.setVisibility(4);
        }
        m();
    }
}
