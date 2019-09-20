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
    private Button bdR;
    private RewardVideoView beb;
    private com.baidu.swan.apps.media.d.a bec;
    private CircleTextProgressbar bed;
    private com.baidu.swan.game.ad.a.a bee;
    private a.b bef;
    private a.c beh;
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
            if (c.this.bec != null) {
                int currentPosition = c.this.bec.getCurrentPosition();
                c.this.h = c.this.bec.getDuration();
                int i = 0;
                if (c.this.h > 0 && currentPosition <= c.this.h && currentPosition >= 0) {
                    i = (int) Math.round((c.this.h - currentPosition) / 1000.0d);
                }
                int min = Math.min(currentPosition + 1000, c.this.h);
                c.this.bed.a(c.this.h, min);
                c.this.bed.setText(String.valueOf(i));
                if (min < c.this.h) {
                    c.this.p.postDelayed(c.this.s, 100L);
                }
            }
        }
    };
    private View.OnClickListener bei = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.beb != null) {
                if (c.this.beb.a()) {
                    c.this.k.setImageResource(a.c.ng_game_vol_open);
                    c.this.beb.a(false);
                    return;
                }
                c.this.k.setImageResource(a.c.ng_game_vol_close);
                c.this.beb.a(true);
            }
        }
    };
    private View.OnClickListener bej = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bef != null) {
                c.this.bef.a();
            }
        }
    };
    private View.OnClickListener bek = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.beh != null) {
                c.this.beh.b();
            }
        }
    };
    public int a = com.baidu.swan.games.view.a.c.TF();
    public int b = com.baidu.swan.games.view.a.c.TG();

    public abstract View QN();

    public c(Context context, com.baidu.swan.game.ad.a.a aVar) {
        this.c = context;
        this.bee = aVar;
        j();
    }

    private void j() {
        Resources resources = this.c.getResources();
        this.e = QN();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a, this.b);
        this.e.setLayoutParams(layoutParams);
        this.d = (RelativeLayout) this.e.findViewById(a.d.reward_relative);
        this.beb = (RewardVideoView) this.e.findViewById(a.d.video_view);
        this.beb.setLayoutParams(layoutParams);
        this.bed = (CircleTextProgressbar) this.e.findViewById(a.d.progress);
        this.bed.setVisibility(4);
        this.bed.setOutLineColor(resources.getColor(a.b.out_line_color));
        this.bed.setProgressColor(resources.getColor(a.b.progress_color));
        this.bed.setProgressLineWidth(z.dip2px(this.c, 2.0f));
        this.bed.setTextColor(resources.getColor(a.b.progress_text_color));
        this.bed.setProgressType(CircleTextProgressbar.b.COUNT);
        this.j = (LinearLayout) this.e.findViewById(a.d.vol_clo);
        this.k = (ImageView) this.e.findViewById(a.d.volume);
        this.l = (TextView) this.e.findViewById(a.d.close_ad);
        this.m = (RelativeLayout) this.e.findViewById(a.d.banner);
        ((AdImageVIew) this.e.findViewById(a.d.reward_icon)).setImageUrl(this.bee.d());
        ((TextView) this.e.findViewById(a.d.title)).setText(this.bee.a());
        ((TextView) this.e.findViewById(a.d.desc)).setText(this.bee.b());
        this.bdR = (Button) this.e.findViewById(a.d.download);
        if (this.bee.g() == 1) {
            this.bdR.setText(resources.getString(a.f.see_detail));
        }
        if (this.bee.g() == 2) {
            this.bdR.setText(resources.getString(a.f.down_immediately));
        }
        this.bec = this.beb.getPlayer();
        k();
    }

    private void k() {
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.game.ad.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.k.setOnClickListener(this.bei);
        this.l.setOnClickListener(this.bej);
        this.m.setOnClickListener(this.bek);
        this.bdR.setOnClickListener(this.bek);
    }

    public void a(a.c cVar) {
        this.beh = cVar;
    }

    public void a(a.b bVar) {
        this.bef = bVar;
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.beb != null) {
            this.beb.a(str);
        }
    }

    public com.baidu.swan.apps.media.d.a QM() {
        if (this.beb != null) {
            return this.beb.getPlayer();
        }
        return null;
    }

    private void l() {
        if (this.bed != null) {
            this.p.removeCallbacksAndMessages(null);
            this.p.postDelayed(this.s, 0L);
        }
    }

    private void m() {
        if (this.bed != null) {
            this.p.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        l();
        if (this.bed.getVisibility() != 0) {
            this.bed.setVisibility(0);
            this.bed.setTimeMillis(this.h);
        }
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        if (this.m.getVisibility() != 0) {
            this.m.setAnimation(AnimationUtils.loadAnimation(this.c, a.C0207a.ng_game_ad_open));
            this.m.setVisibility(0);
        }
    }

    public void d() {
        if (this.bec != null) {
            this.h = this.bec.getDuration();
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
        if (this.bed != null) {
            this.bed.setVisibility(4);
        }
        m();
    }
}
