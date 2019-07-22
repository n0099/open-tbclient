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
    private RewardVideoView bdD;
    private com.baidu.swan.apps.media.d.a bdE;
    private CircleTextProgressbar bdF;
    private com.baidu.swan.game.ad.a.a bdG;
    private a.b bdH;
    private a.c bdI;
    private Button bdt;
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
            if (c.this.bdE != null) {
                int currentPosition = c.this.bdE.getCurrentPosition();
                c.this.h = c.this.bdE.getDuration();
                int i = 0;
                if (c.this.h > 0 && currentPosition <= c.this.h && currentPosition >= 0) {
                    i = (int) Math.round((c.this.h - currentPosition) / 1000.0d);
                }
                int min = Math.min(currentPosition + 1000, c.this.h);
                c.this.bdF.a(c.this.h, min);
                c.this.bdF.setText(String.valueOf(i));
                if (min < c.this.h) {
                    c.this.p.postDelayed(c.this.s, 100L);
                }
            }
        }
    };
    private View.OnClickListener bdJ = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bdD != null) {
                if (c.this.bdD.a()) {
                    c.this.k.setImageResource(a.c.ng_game_vol_open);
                    c.this.bdD.a(false);
                    return;
                }
                c.this.k.setImageResource(a.c.ng_game_vol_close);
                c.this.bdD.a(true);
            }
        }
    };
    private View.OnClickListener bdK = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bdH != null) {
                c.this.bdH.a();
            }
        }
    };
    private View.OnClickListener bdL = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bdI != null) {
                c.this.bdI.b();
            }
        }
    };
    public int a = com.baidu.swan.games.view.a.c.TB();
    public int b = com.baidu.swan.games.view.a.c.TC();

    public abstract View QJ();

    public c(Context context, com.baidu.swan.game.ad.a.a aVar) {
        this.c = context;
        this.bdG = aVar;
        j();
    }

    private void j() {
        Resources resources = this.c.getResources();
        this.e = QJ();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, this.b);
        this.e.setLayoutParams(layoutParams);
        this.d = (RelativeLayout) this.e.findViewById(a.d.reward_relative);
        this.bdD = (RewardVideoView) this.e.findViewById(a.d.video_view);
        this.bdD.setLayoutParams(layoutParams);
        this.bdF = (CircleTextProgressbar) this.e.findViewById(a.d.progress);
        this.bdF.setVisibility(4);
        this.bdF.setOutLineColor(resources.getColor(a.b.out_line_color));
        this.bdF.setProgressColor(resources.getColor(a.b.progress_color));
        this.bdF.setProgressLineWidth(z.dip2px(this.c, 2.0f));
        this.bdF.setTextColor(resources.getColor(a.b.progress_text_color));
        this.bdF.setProgressType(CircleTextProgressbar.b.COUNT);
        this.j = (LinearLayout) this.e.findViewById(a.d.vol_clo);
        this.k = (ImageView) this.e.findViewById(a.d.volume);
        this.l = (TextView) this.e.findViewById(a.d.close_ad);
        this.m = (RelativeLayout) this.e.findViewById(a.d.banner);
        ((AdImageVIew) this.e.findViewById(a.d.reward_icon)).setImageUrl(this.bdG.d());
        ((TextView) this.e.findViewById(a.d.title)).setText(this.bdG.a());
        ((TextView) this.e.findViewById(a.d.desc)).setText(this.bdG.b());
        this.bdt = (Button) this.e.findViewById(a.d.download);
        if (this.bdG.g() == 1) {
            this.bdt.setText(resources.getString(a.f.see_detail));
        }
        if (this.bdG.g() == 2) {
            this.bdt.setText(resources.getString(a.f.down_immediately));
        }
        this.bdE = this.bdD.getPlayer();
        k();
    }

    private void k() {
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.k.setOnClickListener(this.bdJ);
        this.l.setOnClickListener(this.bdK);
        this.m.setOnClickListener(this.bdL);
        this.bdt.setOnClickListener(this.bdL);
    }

    public void a(a.c cVar) {
        this.bdI = cVar;
    }

    public void a(a.b bVar) {
        this.bdH = bVar;
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.bdD != null) {
            this.bdD.a(str);
        }
    }

    public com.baidu.swan.apps.media.d.a QI() {
        if (this.bdD != null) {
            return this.bdD.getPlayer();
        }
        return null;
    }

    private void l() {
        if (this.bdF != null) {
            this.p.removeCallbacksAndMessages(null);
            this.p.postDelayed(this.s, 0L);
        }
    }

    private void m() {
        if (this.bdF != null) {
            this.p.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        l();
        if (this.bdF.getVisibility() != 0) {
            this.bdF.setVisibility(0);
            this.bdF.setTimeMillis(this.h);
        }
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        if (this.m.getVisibility() != 0) {
            this.m.setAnimation(AnimationUtils.loadAnimation(this.c, a.C0193a.ng_game_ad_open));
            this.m.setVisibility(0);
        }
    }

    public void d() {
        if (this.bdE != null) {
            this.h = this.bdE.getDuration();
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
        if (this.bdF != null) {
            this.bdF.setVisibility(4);
        }
        m();
    }
}
