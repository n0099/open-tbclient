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
    public final Context f11232e;

    /* renamed from: f  reason: collision with root package name */
    public View f11233f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11234g;

    /* renamed from: h  reason: collision with root package name */
    public int f11235h;

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
        public String f11236a = null;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f11237b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f11238c = -16777216;

        /* renamed from: d  reason: collision with root package name */
        public int f11239d = 102;

        /* renamed from: e  reason: collision with root package name */
        public int f11240e = 1000;

        /* renamed from: f  reason: collision with root package name */
        public int f11241f = 18;

        /* renamed from: g  reason: collision with root package name */
        public int f11242g = -1;

        /* renamed from: h  reason: collision with root package name */
        public Typeface f11243h = Typeface.DEFAULT;
        public boolean i = true;
        public int j = 39;

        public BDSplashActionView k(Context context) {
            return new BDSplashActionView(context, this);
        }

        public a l(String str) {
            this.f11236a = str;
            return this;
        }

        public a m(int i) {
            this.j = i;
            return this;
        }

        public a n(View.OnClickListener onClickListener) {
            this.f11237b = onClickListener;
            return this;
        }

        public a o(boolean z) {
            this.i = z;
            return this;
        }
    }

    public BDSplashActionView(Context context, a aVar) {
        super(context);
        this.f11232e = context;
        this.f11234g = aVar.i;
        this.f11235h = aVar.j;
        setBackgroundDrawable(b(aVar.f11238c, aVar.f11239d, aVar.f11240e));
        this.f11233f = d(this.f11232e, aVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f11233f, layoutParams);
        setOnClickListener(aVar.f11237b);
    }

    public void a(ViewGroup viewGroup) {
        BaseActionLayout baseActionLayout = new BaseActionLayout(this.f11232e);
        viewGroup.addView(baseActionLayout, new ViewGroup.LayoutParams(-1, -1));
        int i = this.f11232e.getResources().getDisplayMetrics().widthPixels;
        if (viewGroup.getMeasuredWidth() != 0) {
            i = viewGroup.getMeasuredWidth();
        }
        double d2 = i;
        int i2 = (int) (0.7d * d2);
        int i3 = (int) (d2 * 0.15d);
        if (i2 == 0) {
            i2 = -2;
        }
        if (i3 == 0) {
            i3 = -2;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        if (this.f11234g) {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f11232e, this.f11235h);
        } else {
            layoutParams.bottomMargin = CommonUtils.dip2px(this.f11232e, this.f11235h);
        }
        baseActionLayout.addView(this, layoutParams);
    }

    public final GradientDrawable b(int i, int i2, int i3) {
        return c(i, i2, i3, i3, i3, i3);
    }

    public final GradientDrawable c(int i, int i2, int i3, int i4, int i5, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setAlpha(i2);
            gradientDrawable.setColor(i);
            float f2 = i3;
            float f3 = i4;
            float f4 = i5;
            float f5 = i6;
            gradientDrawable.setCornerRadii(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
        } catch (Throwable unused) {
        }
        return gradientDrawable;
    }

    public final LinearLayout d(Context context, a aVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        TextView textView = new TextView(context);
        textView.setText(aVar.f11236a);
        textView.setTextSize(aVar.f11241f);
        textView.setTextColor(aVar.f11242g);
        textView.setTypeface(aVar.f11243h);
        textView.setIncludeFontPadding(false);
        TextView textView2 = new TextView(context);
        textView2.setText(">>");
        textView2.setTextColor(aVar.f11242g);
        textView2.setTextSize((int) (aVar.f11241f * 1.2d));
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        linearLayout.addView(textView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = CommonUtils.dip2px(this.f11232e, 10.0f);
        layoutParams2.gravity = 16;
        linearLayout.addView(textView2, layoutParams2);
        return linearLayout;
    }
}
