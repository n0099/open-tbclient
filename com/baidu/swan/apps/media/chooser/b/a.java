package com.baidu.swan.apps.media.chooser.b;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
/* loaded from: classes11.dex */
public class a extends Scroller {
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.baidu.swan.apps.media.chooser.b.a.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private boolean cqU;

    public a(Context context) {
        this(context, sInterpolator);
    }

    private a(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public void em(boolean z) {
        this.cqU = z;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        if (this.cqU) {
            super.startScroll(i, i2, i3, i4, 0);
        } else {
            super.startScroll(i, i2, i3, i4, i5);
        }
    }
}
