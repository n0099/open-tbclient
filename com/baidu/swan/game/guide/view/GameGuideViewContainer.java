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
import com.baidu.tieba.dn3;
import com.baidu.tieba.wm3;
/* loaded from: classes3.dex */
public class GameGuideViewContainer extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.rightMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            GameGuideViewContainer.this.requestLayout();
        }
    }

    public GameGuideViewContainer(@NonNull Context context) {
        this(context, null);
    }

    public final int d(int i) {
        int i2;
        if (i < dn3.g(10.0f)) {
            i2 = dn3.g(10.0f);
        } else {
            i2 = i;
        }
        int i3 = this.d;
        int i4 = this.a;
        if (i > i3 - i4) {
            return i3 - i4;
        }
        return i2;
    }

    public final int e(int i) {
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            i2 = i;
        }
        int i3 = this.c;
        int i4 = this.b;
        if (i > i3 - i4) {
            return i3 - i4;
        }
        return i2;
    }

    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final boolean c(int i, int i2) {
        if (Math.sqrt((i * i) + (i2 * i2)) > this.g) {
            return true;
        }
        return false;
    }

    public GameGuideViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public final void a(int i) {
        int i2;
        int i3;
        int i4 = this.d;
        int i5 = i4 / 2;
        if (i >= i5) {
            i2 = (int) (((i4 - i) / i5) * 400.0f);
            i3 = dn3.g(10.0f);
        } else {
            i2 = (int) ((i / i5) * 400.0f);
            i3 = i4 - this.a;
        }
        if (i2 <= 0) {
            i2 = 400;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(marginLayoutParams.rightMargin, i3);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(i2);
        ofInt.addUpdateListener(new a(marginLayoutParams));
        ofInt.start();
    }

    public final void b() {
        this.d = getContext().getResources().getDisplayMetrics().widthPixels;
        this.c = getContext().getResources().getDisplayMetrics().heightPixels;
        if (2 == getContext().getResources().getConfiguration().orientation) {
            this.d += wm3.c();
        } else {
            this.c += wm3.c();
        }
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && c(((int) motionEvent.getRawX()) - this.e, ((int) motionEvent.getRawY()) - this.f)) {
                return true;
            }
        } else {
            this.e = (int) motionEvent.getRawX();
            this.f = (int) motionEvent.getRawY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i;
        this.b = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        a((int) motionEvent.getRawX());
                    }
                } else {
                    int rawX = (int) motionEvent.getRawX();
                    int rawY = (int) motionEvent.getRawY();
                    int i = rawX - this.e;
                    int i2 = rawY - this.f;
                    if (c(i, i2)) {
                        marginLayoutParams.rightMargin = d(marginLayoutParams.rightMargin - i);
                        marginLayoutParams.topMargin = e(marginLayoutParams.topMargin + i2);
                        setLayoutParams(marginLayoutParams);
                        this.e = rawX;
                        this.f = rawY;
                        return true;
                    }
                }
            } else {
                a((int) motionEvent.getRawX());
                performClick();
            }
            return true;
        }
        this.e = (int) motionEvent.getRawX();
        this.f = (int) motionEvent.getRawY();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }
}
