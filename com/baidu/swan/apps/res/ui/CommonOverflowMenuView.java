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
import d.b.h0.a.c;
import d.b.h0.a.e;
import d.b.h0.a.f;
import d.b.h0.a.g;
import d.b.h0.a.q1.b.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class CommonOverflowMenuView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f12116e;

    /* renamed from: f  reason: collision with root package name */
    public int f12117f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f12118g;

    /* renamed from: h  reason: collision with root package name */
    public List<ImageView> f12119h;
    public List<TextView> i;
    public HashMap<b, ImageView> j;
    public View k;
    public LinearLayout l;
    public SwanAppScrollView m;
    public Object n;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.x1.a {
        public a() {
        }
    }

    public CommonOverflowMenuView(Context context) {
        super(context);
        this.f12116e = e.aiapps_discovery_home_menu_item_selector;
        this.f12117f = c.aiapps_home_menu_separator_color;
        this.f12119h = new ArrayList();
        this.i = new ArrayList();
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
        this.f12118g = getResources().getColorStateList(c.aiapps_discovery_home_menu_text_color);
        setBackground(getResources().getDrawable(e.aiapps_discovery_feedback_menu_bg));
        for (ImageView imageView : this.f12119h) {
            imageView.setBackgroundColor(getResources().getColor(this.f12117f));
        }
        for (TextView textView : this.i) {
            textView.setTextColor(this.f12118g);
        }
        for (Map.Entry<b, ImageView> entry : this.j.entrySet()) {
            entry.getValue().setImageDrawable(entry.getKey().a());
        }
    }

    public int getItemBgRes() {
        return this.f12116e;
    }

    public LinearLayout getLinearContent() {
        return this.l;
    }

    public ColorStateList getTextColor() {
        return this.f12118g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.b.h0.a.w0.a.z().f(this.n, new a());
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.b.h0.a.w0.a.z().g(this.n);
    }

    public void setItemBackground(int i) {
        this.f12116e = i;
    }

    public void setItemDivider(int i, int i2) {
        this.f12117f = i;
    }

    public void setItemTextColor(int i) {
        this.f12118g = getResources().getColorStateList(i);
    }

    public void setMaxHeightPixel(int i) {
        this.m.setMaxHeight(i);
    }

    public void setMaxHeightRes(int i) {
        this.m.setMaxHeight(getContext().getResources().getDimensionPixelSize(i));
    }

    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12116e = e.aiapps_discovery_home_menu_item_selector;
        this.f12117f = c.aiapps_home_menu_separator_color;
        this.f12119h = new ArrayList();
        this.i = new ArrayList();
        this.j = new HashMap<>();
        new SparseArray();
        this.n = new Object();
        a(context);
    }
}
