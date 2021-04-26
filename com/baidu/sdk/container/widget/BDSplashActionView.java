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
    public final Context f11045e;

    /* renamed from: f  reason: collision with root package name */
    public View f11046f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11047g;

    /* renamed from: h  reason: collision with root package name */
    public int f11048h;

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
        public String f11049a = null;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f11050b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f11051c = -16777216;

        /* renamed from: d  reason: collision with root package name */
        public int f11052d = 102;

        /* renamed from: e  reason: collision with root package name */
        public int f11053e = 1000;

        /* renamed from: f  reason: collision with root package name */
        public int f11054f = 18;

        /* renamed from: g  reason: collision with root package name */
        public int f11055g = -1;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f11056h = Typeface.DEFAULT;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11057i = true;
        public int j = 39;

        public BDSplashActionView k(Context context) {
            return new BDSplashActionView(context, this);
        }

        public a l(String str) {
            this.f11049a = str;
            return this;
        }

        public a m(int i2) {
            this.j = i2;
            return this;
        }

        public a n(View.OnClickListener onClickListener) {
            this.f11050b = onClickListener;
            return this;
        }

        public a o(boolean z) {
            this.f11057i = z;
            return this;
        }
    }

    public BDSplashActionView(Context context, a aVar) {
        super(context);
        this.f11045e = context;
        this.f11047g = aVar.f11057i;
        this.f11048h = aVar.j;
        setBackgroundDrawable(b(aVar.f11051c, aVar.f11052d, aVar.f11053e));
        this.f11046f = d(this.f11045e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f11046f, layoutParams);
        setOnClickListener(aVar.f11050b);
    }

    public void a(ViewGroup viewGroup) {
        BaseActionLayout baseActionLayout = new BaseActionLayout(this.f11045e);
        viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
        int i2 = this.f11045e.getResources().getDisplayMetrics().widthPixels;
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
        if (this.f11047g) {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f11045e, this.f11048h);
        } else {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f11045e, this.f11048h);
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
        textView.setText(aVar.f11049a);
        textView.setTextSize(aVar.f11054f);
        textView.setTextColor(aVar.f11055g);
        textView.setTypeface(aVar.f11056h);
        textView.setIncludeFontPadding(false);
        TextView textView2 = new TextView(context);
        textView2.setText(">>");
        textView2.setTextColor(aVar.f11055g);
        textView2.setTextSize((int) (aVar.f11054f * 1.2d));
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        linearLayout.addView(textView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = CommonUtils.dip2px(this.f11045e, 10.0f);
        layoutParams2.gravity = 16;
        linearLayout.addView(textView2, layoutParams2);
        return linearLayout;
    }
}
