package com.baidu.live.business.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class BannerViewPager extends ViewPager {
    public a a;

    /* loaded from: classes2.dex */
    public static class a extends Scroller {
        public int a;

        public a(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.a = 1000;
        }

        public void a(int i) {
            this.a = i;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.a);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.a);
        }
    }

    public BannerViewPager(@NonNull Context context) {
        super(context);
    }

    public void setSwitchDuration(int i) {
        a();
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public BannerViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            a aVar = new a(getContext(), new AccelerateInterpolator());
            this.a = aVar;
            declaredField.set(this, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
