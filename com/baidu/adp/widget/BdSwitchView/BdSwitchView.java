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
import android.widget.LinearLayout;
import com.baidu.adp.d;
import com.baidu.adp.e;
/* loaded from: classes.dex */
public class BdSwitchView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f550a;
    ImageView b;
    private c c;
    private SwitchState d;
    private boolean e;
    private boolean f;
    private boolean g;
    private TranslateAnimation h;
    private TranslateAnimation i;
    private Animation.AnimationListener j;

    /* loaded from: classes.dex */
    public enum SwitchState {
        ON,
        OFF
    }

    /* loaded from: classes.dex */
    public enum SwitchStyle {
        DAY,
        NIGHT,
        SIDE_BAR
    }

    public BdSwitchView(Context context) {
        super(context);
        this.c = null;
        this.d = SwitchState.ON;
        this.e = false;
        this.f = false;
        this.g = false;
        this.j = null;
        this.f550a = null;
        this.b = null;
        a(context);
    }

    public BdSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = SwitchState.ON;
        this.e = false;
        this.f = false;
        this.g = false;
        this.j = null;
        this.f550a = null;
        this.b = null;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(e.bd_switch_view, (ViewGroup) this, true);
        this.f550a = (FrameLayout) findViewById(d.layout);
        this.b = (ImageView) findViewById(d.switch_image);
        d();
        e();
        this.j = new a(this);
        setOnClickListener(new b(this));
        f();
    }

    private void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f550a.getLayoutParams();
        layoutParams.width = this.f550a.getForeground().getIntrinsicWidth();
        this.f550a.setLayoutParams(layoutParams);
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
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
        if (!this.g) {
            this.h = new TranslateAnimation(-translateDis, 0.0f, 0.0f, 0.0f);
            this.i = new TranslateAnimation(0.0f, -translateDis, 0.0f, 0.0f);
        } else {
            this.h = new TranslateAnimation(0.0f, translateDis, 0.0f, 0.0f);
            this.i = new TranslateAnimation(translateDis, 0.0f, 0.0f, 0.0f);
        }
        this.h.setDuration(200L);
        this.h.setFillAfter(true);
        this.h.setAnimationListener(this.j);
        this.i.setDuration(200L);
        this.i.setFillAfter(true);
        this.i.setAnimationListener(this.j);
    }

    private float getTranslateDis() {
        return this.f550a.getForeground().getIntrinsicWidth() * 0.6666667f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (!this.f) {
            if (this.d == SwitchState.ON) {
                this.d = SwitchState.OFF;
                if (this.i != null) {
                    if (z) {
                        this.i.setDuration(200L);
                        this.b.startAnimation(this.i);
                    } else {
                        d(false);
                    }
                }
            } else {
                this.d = SwitchState.ON;
                if (this.h != null) {
                    if (z) {
                        this.h.setDuration(200L);
                        this.b.startAnimation(this.h);
                    } else {
                        d(true);
                    }
                }
            }
            if (this.c != null) {
                this.c.a(this, this.d);
            }
        }
    }

    public void setSwitchFrame(int i) {
        this.f550a.setForeground(getResources().getDrawable(i));
        d();
    }

    public void setSwitchImage(int i) {
        this.b.setBackgroundResource(i);
        e();
    }

    public void setSwitchStyle(SwitchStyle switchStyle) {
        if (switchStyle == SwitchStyle.DAY) {
            setSwitchFrame(com.baidu.adp.c.btn_switch_masking);
            setSwitchImage(com.baidu.adp.c.btn_switch);
        } else if (switchStyle == SwitchStyle.NIGHT) {
            setSwitchFrame(com.baidu.adp.c.btn_switch_masking_1);
            setSwitchImage(com.baidu.adp.c.btn_switch_1);
        } else if (switchStyle == SwitchStyle.SIDE_BAR) {
            setSwitchFrame(com.baidu.adp.c.btn_switch_masking_sidebar);
            setSwitchImage(com.baidu.adp.c.btn_switch_1);
        }
    }

    public void a() {
        a(false);
    }

    public void a(boolean z) {
        if (this.d != SwitchState.ON) {
            c(z);
        }
    }

    public void b() {
        b(false);
    }

    public void b(boolean z) {
        if (this.d != SwitchState.OFF) {
            c(z);
        }
    }

    public boolean c() {
        return this.d == SwitchState.ON;
    }

    private void d(boolean z) {
        if (!this.f) {
            this.f = true;
            float translateDis = getTranslateDis();
            if (!z) {
                this.d = SwitchState.OFF;
                if (!this.g) {
                    this.g = true;
                    setLeftMargin((int) (-translateDis));
                    f();
                } else {
                    return;
                }
            } else {
                this.d = SwitchState.ON;
                if (this.g) {
                    this.g = false;
                    setLeftMargin(0);
                    f();
                } else {
                    return;
                }
            }
            this.f = false;
        }
    }

    private void setLeftMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.setMargins(i, 0, 0, 0);
        this.b.setLayoutParams(layoutParams);
    }

    public void setOnSwitchStateChangeListener(c cVar) {
        this.c = cVar;
    }
}
