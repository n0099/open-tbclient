package com.baidu.sdk.container.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class DisplayInfoView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public double f11246e;

    /* renamed from: f  reason: collision with root package name */
    public double f11247f;

    /* renamed from: g  reason: collision with root package name */
    public int f11248g;

    /* renamed from: h  reason: collision with root package name */
    public String f11249h;
    public String i;
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
        public DisplayInfoView f11252a;

        public c(Context context) {
            this.f11252a = new DisplayInfoView(context, null);
        }

        public c a(String str, String str2) {
            String str3 = "版本 " + str;
            if (str.indexOf("版本") == -1) {
                str = str3;
            }
            this.f11252a.i = str;
            this.f11252a.f11249h = str2;
            return this;
        }

        public c b(d dVar) {
            this.f11252a.k = dVar;
            return this;
        }

        public c c(int i) {
            this.f11252a.f11248g = i;
            return this;
        }

        public DisplayInfoView d() {
            return this.f11252a;
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
        textView.setTextColor(this.f11248g);
        textView.setTextSize(1, (int) ((this.f11246e * displayMetrics.widthPixels) / displayMetrics.density));
        addView(textView, g(this.f11247f));
        return textView;
    }

    public final LinearLayout.LayoutParams g(double d2) {
        int i = (int) (d2 * getResources().getDisplayMetrics().widthPixels);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, 0, i, 0);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final void h() {
        f(this.i);
        f(this.f11249h);
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
        this.f11246e = 0.027777777777777776d;
        this.f11247f = 0.0196078431372549d;
        this.f11248g = -1728053248;
        setOrientation(0);
        this.j = context;
        removeAllViews();
    }
}
