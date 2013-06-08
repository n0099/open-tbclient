package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.f;
/* loaded from: classes.dex */
public class BdSwitchView extends FrameLayout {
    FrameLayout a;
    ImageView b;
    private c c;
    private d d;
    private boolean e;
    private boolean f;
    private TranslateAnimation g;
    private TranslateAnimation h;
    private Animation.AnimationListener i;

    public BdSwitchView(Context context) {
        super(context);
        this.c = null;
        this.d = d.ON;
        this.e = false;
        this.f = false;
        this.i = null;
        this.a = null;
        this.b = null;
        a(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = d.ON;
        this.e = false;
        this.f = false;
        this.i = null;
        this.a = null;
        this.b = null;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(f.bd_switch_view, (ViewGroup) this, true);
        this.a = (FrameLayout) findViewById(com.baidu.adp.e.layout);
        this.b = (ImageView) findViewById(com.baidu.adp.e.switch_image);
        d();
        e();
        this.i = new a(this);
        setOnClickListener(new b(this));
        f();
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams.width = this.a.getForeground().getIntrinsicWidth();
        this.a.setLayoutParams(layoutParams);
    }

    private void e() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = this.b.getBackground().getIntrinsicWidth();
        this.b.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.e) {
            super.setOnClickListener(onClickListener);
            this.e = true;
        }
    }

    private void f() {
        float translateDis = getTranslateDis();
        this.g = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
        this.g.setDuration(200L);
        this.g.setFillAfter(true);
        this.g.setAnimationListener(this.i);
        this.h = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        this.h.setDuration(200L);
        this.h.setFillAfter(true);
        this.h.setAnimationListener(this.i);
    }

    private float getTranslateDis() {
        return this.a.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (!this.f) {
            if (this.d == d.ON) {
                this.d = d.OFF;
                if (this.h != null) {
                    if (z) {
                        this.h.setDuration(200L);
                    } else {
                        this.h.setDuration(1L);
                    }
                    this.b.startAnimation(this.h);
                }
            } else {
                this.d = d.ON;
                if (this.g != null) {
                    if (z) {
                        this.g.setDuration(200L);
                    } else {
                        this.g.setDuration(1L);
                    }
                    this.b.startAnimation(this.g);
                }
            }
            if (this.c != null) {
                this.c.a(this, this.d);
            }
        }
    }

    public void setSwitchFrame(int i) {
        this.a.setForeground(getResources().getDrawable(i));
        d();
    }

    public void setSwitchImage(int i) {
        this.b.setBackgroundResource(i);
        e();
    }

    public void setSwitchStyle(e eVar) {
        if (eVar == e.DAY) {
            setSwitchFrame(com.baidu.adp.d.btn_switch_masking);
            setSwitchImage(com.baidu.adp.d.btn_switch);
        } else if (eVar == e.NIGHT) {
            setSwitchFrame(com.baidu.adp.d.btn_switch_masking_1);
            setSwitchImage(com.baidu.adp.d.btn_switch_1);
        } else if (eVar == e.SIDE_BAR) {
            setSwitchFrame(com.baidu.adp.d.btn_switch_masking_sidebar);
            setSwitchImage(com.baidu.adp.d.btn_switch_1);
        }
    }

    public void a() {
        if (this.d != d.ON) {
            a(false);
        }
    }

    public void b() {
        if (this.d != d.OFF) {
            a(false);
        }
    }

    public boolean c() {
        return this.d == d.ON;
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.c = cVar;
    }
}
