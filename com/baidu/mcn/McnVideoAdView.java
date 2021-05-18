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
import d.a.k0.s2.y;
/* loaded from: classes2.dex */
public class McnVideoAdView extends FrameLayout {
    public static final int r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds626);
    public static final int s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds156);
    public static final int t = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112);

    /* renamed from: e  reason: collision with root package name */
    public Context f8054e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f8055f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f8056g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f8057h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f8058i;
    public Animation j;
    public float k;
    public float l;
    public boolean m;
    public d.a.v.a n;
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
        void a(d.a.v.a aVar);

        void b(d.a.v.a aVar);

        void c(d.a.v.a aVar);
    }

    public McnVideoAdView(Context context) {
        super(context);
        this.m = false;
        this.p = new Handler();
        this.f8054e = context;
        h();
    }

    private void setData(d.a.v.a aVar) {
        if (aVar == null) {
            return;
        }
        this.n = aVar;
        this.f8055f.V(aVar.f64789a, 10, false);
        if (!StringUtils.isNull(aVar.f64790b)) {
            this.f8056g.setText(aVar.f64790b);
        }
        if (StringUtils.isNull(aVar.f64791c)) {
            return;
        }
        this.f8057h.setText(aVar.f64791c);
    }

    public final void d() {
        this.p.postDelayed(new b(), 500L);
    }

    public final void e() {
        d.a.v.a aVar;
        String str;
        Context context = this.f8054e;
        if (context == null || (aVar = this.n) == null || (str = aVar.f64792d) == null) {
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
        LayoutInflater.from(this.f8054e).inflate(R.layout.mcn_video_ad_layout, this);
        this.f8055f = (TbImageView) findViewById(R.id.id_mcn_video_ad_image);
        this.f8056g = (TextView) findViewById(R.id.id_mcn_video_ad_title);
        this.f8057h = (TextView) findViewById(R.id.id_mcn_video_ad_jump_btn);
        this.f8055f.setConrers(5);
        this.f8055f.setDefaultResource(R.drawable.mcn_video_ad_default_img_bg);
        this.f8055f.setDefaultBgResource(R.drawable.mcn_video_ad_default_img_bg);
        this.f8055f.setRadius(l.g(this.f8054e, R.dimen.tbds20));
        this.f8058i = AnimationUtils.loadAnimation(this.f8054e, R.anim.mcn_video_ad_open_anim);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f8054e, R.anim.mcn_video_ad_close_anim);
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

    public void l(d.a.v.a aVar, ViewGroup viewGroup) {
        m(aVar, viewGroup);
        if (this.f8058i != null) {
            clearAnimation();
            startAnimation(this.f8058i);
        }
    }

    public void m(d.a.v.a aVar, ViewGroup viewGroup) {
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
        this.f8054e = context;
        h();
    }

    public McnVideoAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = false;
        this.p = new Handler();
        this.f8054e = context;
        h();
    }
}
