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
    public final Context f10082e;

    /* renamed from: f  reason: collision with root package name */
    public View f10083f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10084g;

    /* renamed from: h  reason: collision with root package name */
    public int f10085h;

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
        public String f10086a = null;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f10087b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f10088c = -16777216;

        /* renamed from: d  reason: collision with root package name */
        public int f10089d = 102;

        /* renamed from: e  reason: collision with root package name */
        public int f10090e = 1000;

        /* renamed from: f  reason: collision with root package name */
        public int f10091f = 18;

        /* renamed from: g  reason: collision with root package name */
        public int f10092g = -1;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f10093h = Typeface.DEFAULT;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10094i = true;
        public int j = 39;

        public BDSplashActionView k(Context context) {
            return new BDSplashActionView(context, this);
        }

        public a l(String str) {
            this.f10086a = str;
            return this;
        }

        public a m(int i2) {
            this.j = i2;
            return this;
        }

        public a n(View.OnClickListener onClickListener) {
            this.f10087b = onClickListener;
            return this;
        }

        public a o(boolean z) {
            this.f10094i = z;
            return this;
        }
    }

    public BDSplashActionView(Context context, a aVar) {
        super(context);
        this.f10082e = context;
        this.f10084g = aVar.f10094i;
        this.f10085h = aVar.j;
        setBackgroundDrawable(b(aVar.f10088c, aVar.f10089d, aVar.f10090e));
        this.f10083f = d(this.f10082e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f10083f, layoutParams);
        setOnClickListener(aVar.f10087b);
    }

    public void a(ViewGroup viewGroup) {
        BaseActionLayout baseActionLayout = new BaseActionLayout(this.f10082e);
        viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
        int i2 = this.f10082e.getResources().getDisplayMetrics().widthPixels;
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
        if (this.f10084g) {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f10082e, this.f10085h);
        } else {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f10082e, this.f10085h);
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
        textView.setText(aVar.f10086a);
        textView.setTextSize(aVar.f10091f);
        textView.setTextColor(aVar.f10092g);
        textView.setTypeface(aVar.f10093h);
        textView.setIncludeFontPadding(false);
        TextView textView2 = new TextView(context);
        textView2.setText(">>");
        textView2.setTextColor(aVar.f10092g);
        textView2.setTextSize((int) (aVar.f10091f * 1.2d));
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        linearLayout.addView(textView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = CommonUtils.dip2px(this.f10082e, 10.0f);
        layoutParams2.gravity = 16;
        linearLayout.addView(textView2, layoutParams2);
        return linearLayout;
    }
}
