package com.baidu.nadcore.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import com.baidu.tieba.bb1;
import com.baidu.tieba.db1;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    public boolean B;
    public boolean C;
    public double D;
    public SlideInterceptor E;
    public WeakReference<Activity> F;
    public bb1 G;

    public void setNightMode(boolean z) {
    }

    /* loaded from: classes2.dex */
    public class a implements bb1 {
        public a() {
        }

        @Override // com.baidu.tieba.bb1
        public void onTranslucent(boolean z) {
            CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
            if (CustomSlidingPanelLayout.this.G != null) {
                CustomSlidingPanelLayout.this.G.onTranslucent(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements bb1 {
        public b() {
        }

        @Override // com.baidu.tieba.bb1
        public void onTranslucent(boolean z) {
            CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
            if (CustomSlidingPanelLayout.this.G != null) {
                CustomSlidingPanelLayout.this.G.onTranslucent(z);
            }
        }
    }

    public CustomSlidingPanelLayout(Context context) {
        super(context);
        this.B = true;
        this.C = false;
        this.D = 1.0d;
        L();
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
            if (!this.B) {
                return false;
            }
            try {
                if (this.E != null) {
                    if (!this.E.isSlidable(motionEvent)) {
                        return false;
                    }
                }
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCanSlidable(boolean z) {
        this.B = z;
    }

    public void setOnTransparentListener(bb1 bb1Var) {
        this.G = bb1Var;
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        this.E = slideInterceptor;
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void w(boolean z) {
        this.C = z;
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = true;
        this.C = false;
        this.D = 1.0d;
        L();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = true;
        this.C = false;
        this.D = 1.0d;
        L();
    }

    public void L() {
        setCanSlideRegionFactor(this.D);
        setActivityIsTranslucent(true);
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void q() {
        WeakReference<Activity> weakReference = this.F;
        if (weakReference != null && weakReference.get() != null) {
            db1.c(this.F.get(), new b());
            return;
        }
        bb1 bb1Var = this.G;
        if (bb1Var != null) {
            bb1Var.onTranslucent(true);
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void r() {
        WeakReference<Activity> weakReference = this.F;
        if (weakReference != null && weakReference.get() != null) {
            db1.d(this.F.get(), new a());
            return;
        }
        bb1 bb1Var = this.G;
        if (bb1Var != null) {
            bb1Var.onTranslucent(false);
        }
    }

    @Override // com.baidu.nadcore.widget.SlidingPaneLayout
    public void m(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            this.F = new WeakReference<>(activity);
            activity.getWindow().getDecorView().setBackgroundColor(0);
            if (!this.C) {
                q();
            }
        }
    }
}
