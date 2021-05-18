package com.baidu.sdk.container.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class DisplayInfoView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public double f10098e;

    /* renamed from: f  reason: collision with root package name */
    public double f10099f;

    /* renamed from: g  reason: collision with root package name */
    public int f10100g;

    /* renamed from: h  reason: collision with root package name */
    public String f10101h;

    /* renamed from: i  reason: collision with root package name */
    public String f10102i;
    public final Context j;
    public d k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DisplayInfoView.this.k != null) {
                DisplayInfoView.this.k.onPrivacyClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DisplayInfoView.this.k != null) {
                DisplayInfoView.this.k.onPermissionClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public DisplayInfoView f10105a;

        public c(Context context) {
            this.f10105a = new DisplayInfoView(context, null);
        }

        public c a(String str, String str2) {
            String str3 = "版本 " + str;
            if (str.indexOf("版本") == -1) {
                str = str3;
            }
            this.f10105a.f10102i = str;
            this.f10105a.f10101h = str2;
            return this;
        }

        public c b(d dVar) {
            this.f10105a.k = dVar;
            return this;
        }

        public c c(int i2) {
            this.f10105a.f10100g = i2;
            return this;
        }

        public DisplayInfoView d() {
            return this.f10105a;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onPermissionClick();

        void onPrivacyClick();
    }

    public /* synthetic */ DisplayInfoView(Context context, a aVar) {
        this(context);
    }

    public final TextView f(String str) {
        TextView textView = new TextView(this.j);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        textView.setText(str);
        textView.setTextColor(this.f10100g);
        textView.setTextSize(1, (int) ((this.f10098e * displayMetrics.widthPixels) / displayMetrics.density));
        addView(textView, g(this.f10099f));
        return textView;
    }

    public final LinearLayout.LayoutParams g(double d2) {
        int i2 = (int) (d2 * getResources().getDisplayMetrics().widthPixels);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i2, 0, i2, 0);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final void h() {
        f(this.f10102i);
        f(this.f10101h);
        f(com.baidu.mobads.container.widget.DisplayInfoView.PRI_TEXT).setOnClickListener(new a());
        f(com.baidu.mobads.container.widget.DisplayInfoView.AUTH_TEXT).setOnClickListener(new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    public DisplayInfoView(Context context) {
        super(context);
        this.f10098e = 0.027777777777777776d;
        this.f10099f = 0.0196078431372549d;
        this.f10100g = -1728053248;
        setOrientation(0);
        this.j = context;
        removeAllViews();
    }
}
