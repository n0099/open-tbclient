package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import d.a.h0.a.c;
import d.a.h0.a.e;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.q1.b.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class CommonOverflowMenuView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f11962e;

    /* renamed from: f  reason: collision with root package name */
    public int f11963f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f11964g;

    /* renamed from: h  reason: collision with root package name */
    public List<ImageView> f11965h;

    /* renamed from: i  reason: collision with root package name */
    public List<TextView> f11966i;
    public HashMap<b, ImageView> j;
    public View k;
    public LinearLayout l;
    public SwanAppScrollView m;
    public Object n;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.x1.a {
        public a() {
        }
    }

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.f11962e = e.aiapps_discovery_home_menu_item_selector;
        this.f11963f = c.aiapps_home_menu_separator_color;
        this.f11965h = new ArrayList();
        this.f11966i = new ArrayList();
        this.j = new HashMap<>();
        new SparseArray();
        this.n = new Object();
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.aiapps_menu_scroll_view, (ViewGroup) this, true);
        this.k = inflate;
        this.l = (LinearLayout) inflate.findViewById(f.menu_linear);
        this.m = (SwanAppScrollView) this.k.findViewById(f.menu_scrollview);
        setFocusable(true);
        setFocusableInTouchMode(true);
        b();
    }

    public final void b() {
        this.f11964g = getResources().getColorStateList(c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.f11965h) {
            imageView.setBackgroundColor(getResources().getColor(this.f11963f));
        }
        for (TextView textView : this.f11966i) {
            textView.setTextColor(this.f11964g);
        }
        for (Map.Entry<b, ImageView> entry : this.j.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().a());
        }
    }

    public int getItemBgRes() {
        return this.f11962e;
    }

    public LinearLayout getLinearContent() {
        return this.l;
    }

    public ColorStateList getTextColor() {
        return this.f11964g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.a.h0.a.w0.a.z().f(this.n, new a());
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a.h0.a.w0.a.z().g(this.n);
    }

    public void setItemBackground(int i2) {
        this.f11962e = i2;
    }

    public void setItemDivider(int i2, int i3) {
        this.f11963f = i2;
    }

    public void setItemTextColor(int i2) {
        this.f11964g = getResources().getColorStateList(i2);
    }

    public void setMaxHeightPixel(int i2) {
        this.m.setMaxHeight(i2);
    }

    public void setMaxHeightRes(int i2) {
        this.m.setMaxHeight(getContext().getResources().getDimensionPixelSize(i2));
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11962e = e.aiapps_discovery_home_menu_item_selector;
        this.f11963f = c.aiapps_home_menu_separator_color;
        this.f11965h = new ArrayList();
        this.f11966i = new ArrayList();
        this.j = new HashMap<>();
        new SparseArray();
        this.n = new Object();
        a(context);
    }
}
