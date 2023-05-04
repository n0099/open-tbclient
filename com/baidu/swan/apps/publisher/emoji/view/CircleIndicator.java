package com.baidu.swan.apps.publisher.emoji.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.j53;
/* loaded from: classes3.dex */
public class CircleIndicator extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Paint h;
    public int i;
    public ViewPager j;
    public int k;
    public int l;
    public final ViewPager.OnPageChangeListener m;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            j53.g(CircleIndicator.this.getContext().getApplicationContext()).k();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            CircleIndicator.this.b = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.0f) {
                CircleIndicator.this.f(i, f);
            }
        }
    }

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public final void b(Canvas canvas) {
        this.h.setColor(this.k);
        for (int i = 0; i < this.a; i++) {
            int i2 = this.d;
            canvas.drawCircle(this.f + (this.c * i), i2, i2, this.h);
        }
    }

    public final void d(Canvas canvas) {
        this.h.setColor(this.l);
        int i = (this.f + this.g) - (this.c / 2);
        canvas.drawRoundRect(new RectF(i, 0, this.e + i, (this.d * 2) + 0), 10.0f, 10.0f, this.h);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        d(canvas);
    }

    public void setViewPager(ViewPager viewPager) {
        this.j = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            c();
            this.j.removeOnPageChangeListener(this.m);
            this.j.addOnPageChangeListener(this.m);
            this.j.getCurrentItem();
            invalidate();
        }
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void f(int i, float f) {
        this.g = (int) (this.c * (f + i));
        invalidate();
    }

    public CircleIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1;
        this.g = 0;
        this.m = new a();
        e();
    }

    public final void c() {
        int count = this.j.getAdapter().getCount();
        this.a = count;
        if (count <= 0) {
            return;
        }
        int i = this.i;
        int i2 = this.c;
        this.f = (i - ((count - 1) * i2)) / 2;
        this.d = i2 / 5;
        invalidate();
    }

    public final void e() {
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.k = getResources().getColor(R.color.obfuscated_res_0x7f060966);
        this.l = getResources().getColor(R.color.obfuscated_res_0x7f060967);
        this.c = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070106);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i;
        int i5 = this.c;
        this.f = (i - ((this.a - 1) * i5)) / 2;
        this.d = i5 / 5;
        this.e = i5;
    }
}
