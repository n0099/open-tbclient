package com.baidu.sdk.container.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.CommonUtils;
/* loaded from: classes2.dex */
public class BDSplashActionView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f9982e;

    /* renamed from: f  reason: collision with root package name */
    public View f9983f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9984g;

    /* renamed from: h  reason: collision with root package name */
    public int f9985h;

    /* loaded from: classes2.dex */
    public static class BaseActionLayout extends RelativeLayout {
        public BaseActionLayout(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9986a = null;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f9987b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f9988c = -16777216;

        /* renamed from: d  reason: collision with root package name */
        public int f9989d = 102;

        /* renamed from: e  reason: collision with root package name */
        public int f9990e = 1000;

        /* renamed from: f  reason: collision with root package name */
        public int f9991f = 18;

        /* renamed from: g  reason: collision with root package name */
        public int f9992g = -1;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f9993h = Typeface.DEFAULT;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9994i = true;
        public int j = 39;

        public BDSplashActionView k(Context context) {
            return new BDSplashActionView(context, this);
        }

        public a l(String str) {
            this.f9986a = str;
            return this;
        }

        public a m(int i2) {
            this.j = i2;
            return this;
        }

        public a n(View.OnClickListener onClickListener) {
            this.f9987b = onClickListener;
            return this;
        }

        public a o(boolean z) {
            this.f9994i = z;
            return this;
        }
    }

    public BDSplashActionView(Context context, a aVar) {
        super(context);
        this.f9982e = context;
        this.f9984g = aVar.f9994i;
        this.f9985h = aVar.j;
        setBackgroundDrawable(b(aVar.f9988c, aVar.f9989d, aVar.f9990e));
        this.f9983f = d(this.f9982e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f9983f, layoutParams);
        setOnClickListener(aVar.f9987b);
    }

    public void a(ViewGroup viewGroup) {
        BaseActionLayout baseActionLayout = new BaseActionLayout(this.f9982e);
        viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
        int i2 = this.f9982e.getResources().getDisplayMetrics().widthPixels;
        if (viewGroup.getMeasuredWidth() != 0) {
            i2 = viewGroup.getMeasuredWidth();
        }
        double d2 = i2;
        int i3 = (int) (0.7d * d2);
        int i4 = (int) (d2 * 0.15d);
        if (i3 == 0) {
            i3 = -2;
        }
        if (i4 == 0) {
            i4 = -2;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        if (this.f9984g) {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f9982e, this.f9985h);
        } else {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f9982e, this.f9985h);
        }
        baseActionLayout.addView(this, layoutParams);
    }

    public final GradientDrawable b(int i2, int i3, int i4) {
        return c(i2, i3, i4, i4, i4, i4);
    }

    public final GradientDrawable c(int i2, int i3, int i4, int i5, int i6, int i7) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setAlpha(i3);
            gradientDrawable.setColor(i2);
            float f2 = i4;
            float f3 = i5;
            float f4 = i6;
            float f5 = i7;
            gradientDrawable.setCornerRadii(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
        } catch (Throwable unused) {
        }
        return gradientDrawable;
    }

    public final LinearLayout d(Context context, a aVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        TextView textView = new TextView(context);
        textView.setText(aVar.f9986a);
        textView.setTextSize(aVar.f9991f);
        textView.setTextColor(aVar.f9992g);
        textView.setTypeface(aVar.f9993h);
        textView.setIncludeFontPadding(false);
        TextView textView2 = new TextView(context);
        textView2.setText(">>");
        textView2.setTextColor(aVar.f9992g);
        textView2.setTextSize((int) (aVar.f9991f * 1.2d));
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        linearLayout.addView(textView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = CommonUtils.dip2px(this.f9982e, 10.0f);
        layoutParams2.gravity = 16;
        linearLayout.addView(textView2, layoutParams2);
        return linearLayout;
    }
}
