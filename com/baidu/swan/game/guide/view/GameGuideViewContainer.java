package com.baidu.swan.game.guide.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.a.v2.n0;
/* loaded from: classes3.dex */
public class GameGuideViewContainer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f11769e;

    /* renamed from: f  reason: collision with root package name */
    public int f11770f;

    /* renamed from: g  reason: collision with root package name */
    public int f11771g;

    /* renamed from: h  reason: collision with root package name */
    public int f11772h;

    /* renamed from: i  reason: collision with root package name */
    public int f11773i;
    public int j;
    public int k;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f11774e;

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f11774e = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f11774e.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            GameGuideViewContainer.this.requestLayout();
        }
    }

    public GameGuideViewContainer(@NonNull Context context) {
        this(context, null);
    }

    public final void a(int i2) {
        int i3;
        int i4;
        int i5 = this.f11772h;
        int i6 = i5 / 2;
        if (i2 >= i6) {
            i3 = (int) (((i5 - i2) / i6) * 400.0f);
            i4 = n0.g(10.0f);
        } else {
            i3 = (int) ((i2 / i6) * 400.0f);
            i4 = i5 - this.f11769e;
        }
        if (i3 <= 0) {
            i3 = 400;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(marginLayoutParams.rightMargin, i4);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(i3);
        ofInt.addUpdateListener(new a(marginLayoutParams));
        ofInt.start();
    }

    public final void b() {
        this.f11772h = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f11771g = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            this.f11772h += n0.s();
        } else {
            this.f11771g += n0.s();
        }
        this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final boolean c(int i2, int i3) {
        return Math.sqrt((double) ((i2 * i2) + (i3 * i3))) > ((double) this.k);
    }

    public final int d(int i2) {
        int g2 = i2 < n0.g(10.0f) ? n0.g(10.0f) : i2;
        int i3 = this.f11772h;
        int i4 = this.f11769e;
        return i2 > i3 - i4 ? i3 - i4 : g2;
    }

    public final int e(int i2) {
        int i3 = i2 < 0 ? 0 : i2;
        int i4 = this.f11771g;
        int i5 = this.f11770f;
        return i2 > i4 - i5 ? i4 - i5 : i3;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && c(((int) motionEvent.getRawX()) - this.f11773i, ((int) motionEvent.getRawY()) - this.j)) {
                return true;
            }
        } else {
            this.f11773i = (int) motionEvent.getRawX();
            this.j = (int) motionEvent.getRawY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f11769e = i2;
        this.f11770f = i3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11773i = (int) motionEvent.getRawX();
            this.j = (int) motionEvent.getRawY();
            return true;
        }
        if (action == 1) {
            a((int) motionEvent.getRawX());
            performClick();
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int i2 = rawX - this.f11773i;
            int i3 = rawY - this.j;
            if (c(i2, i3)) {
                marginLayoutParams.rightMargin = d(marginLayoutParams.rightMargin - i2);
                marginLayoutParams.topMargin = e(marginLayoutParams.topMargin + i3);
                setLayoutParams(marginLayoutParams);
                this.f11773i = rawX;
                this.j = rawY;
                return true;
            }
        } else if (action == 3) {
            a((int) motionEvent.getRawX());
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
