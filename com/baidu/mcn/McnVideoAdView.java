package com.baidu.mcn;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.t2.y;
/* loaded from: classes2.dex */
public class McnVideoAdView extends FrameLayout {
    public static final int r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    public static final int s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    public static final int t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);

    /* renamed from: e  reason: collision with root package name */
    public Context f7954e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f7955f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f7956g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f7957h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f7958i;
    public Animation j;
    public float k;
    public float l;
    public boolean m;
    public d.a.x.a n;
    public c o;
    public final Handler p;
    public ViewParent q;

    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            McnVideoAdView.this.j();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (McnVideoAdView.this.q != null) {
                McnVideoAdView.this.q.requestDisallowInterceptTouchEvent(false);
                McnVideoAdView.this.q = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(d.a.x.a aVar);

        void b(d.a.x.a aVar);

        void c(d.a.x.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.m = false;
        this.p = new Handler();
        this.f7954e = context;
        h();
    }

    private void setData(d.a.x.a aVar) {
        if (aVar == null) {
            return;
        }
        this.n = aVar;
        this.f7955f.V(aVar.f64842a, 10, false);
        if (!StringUtils.isNull(aVar.f64843b)) {
            this.f7956g.setText(aVar.f64843b);
        }
        if (StringUtils.isNull(aVar.f64844c)) {
            return;
        }
        this.f7957h.setText(aVar.f64844c);
    }

    public final void d() {
        this.p.postDelayed(new b(), 500L);
    }

    public final void e() {
        d.a.x.a aVar;
        String str;
        Context context = this.f7954e;
        if (context == null || (aVar = this.n) == null || (str = aVar.f64845d) == null) {
            return;
        }
        y.d(context, str, null, null);
        c cVar = this.o;
        if (cVar != null) {
            cVar.b(this.n);
        }
    }

    public void f() {
        if (this.j != null) {
            clearAnimation();
            startAnimation(this.j);
        }
    }

    public void g() {
        j();
    }

    public final void h() {
        LayoutInflater.from(this.f7954e).inflate(R.layout.mcn_video_ad_layout, this);
        this.f7955f = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.f7956g = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.f7957h = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.f7955f.setConrers(5);
        this.f7955f.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.f7955f.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.f7955f.setRadius(l.g(this.f7954e, R.dimen.tbds20));
        this.f7958i = AnimationUtils.loadAnimation(this.f7954e, R.anim.mcn_video_ad_open_anim);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f7954e, R.anim.mcn_video_ad_close_anim);
        this.j = loadAnimation;
        loadAnimation.setAnimationListener(new a());
    }

    public boolean i() {
        return this.m;
    }

    public final void j() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) getParent()).removeView(this);
        this.m = false;
    }

    public void k() {
        j();
        this.m = false;
        this.n = null;
    }

    public void l(d.a.x.a aVar, ViewGroup viewGroup) {
        m(aVar, viewGroup);
        if (this.f7958i != null) {
            clearAnimation();
            startAnimation(this.f7958i);
        }
    }

    public void m(d.a.x.a aVar, ViewGroup viewGroup) {
        this.m = true;
        setData(aVar);
        viewGroup.removeView(this);
        viewGroup.addView(this);
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r, s);
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = t;
            setLayoutParams(layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(r, s);
            layoutParams2.addRule(11);
            layoutParams2.addRule(12);
            layoutParams2.setMargins(0, 0, 0, t);
            setLayoutParams(layoutParams2);
        }
        c cVar = this.o;
        if (cVar != null) {
            cVar.c(aVar);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = motionEvent.getX();
            this.l = motionEvent.getY();
            ViewParent parent = getParent();
            this.q = parent;
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 1) {
            d();
            if (Math.abs(motionEvent.getX() - this.k) < 5.0f && Math.abs(motionEvent.getY() - this.l) < 5.0f) {
                e();
            }
        } else if (action != 2) {
            if (action == 3) {
                d();
            }
        } else if (motionEvent.getX() - this.k > 10.0f && this.m) {
            f();
            c cVar = this.o;
            if (cVar != null) {
                cVar.a(this.n);
            }
        }
        return true;
    }

    public void setIMcnStatListener(c cVar) {
        this.o = cVar;
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = false;
        this.p = new Handler();
        this.f7954e = context;
        h();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = false;
        this.p = new Handler();
        this.f7954e = context;
        h();
    }
}
