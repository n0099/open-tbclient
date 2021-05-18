package com.baidu.swan.bdprivate.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import d.a.i0.a.k;
import d.a.i0.a.z1.b.e.a;
import d.a.i0.b.c;
import d.a.i0.b.d;
/* loaded from: classes3.dex */
public class BdContextMenuView extends FrameLayout implements a.g {

    /* renamed from: e  reason: collision with root package name */
    public b f11534e;

    /* renamed from: f  reason: collision with root package name */
    public Context f11535f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f11536g;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            BdContextMenuView.this.f11534e.a(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        public abstract void a(int i2);
    }

    static {
        boolean z = k.f43025a;
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11535f = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.f11535f.getResources().getDrawable(d.aiapps_context_menu_bg));
        ListView listView = new ListView(this.f11535f);
        this.f11536g = listView;
        listView.setCacheColorHint(0);
        this.f11536g.setDivider(getResources().getDrawable(c.aiapps_context_menu_divider_color));
        this.f11536g.setDividerHeight(1);
        this.f11536g.setSelector(new ColorDrawable(0));
        addView(this.f11536g, new FrameLayout.LayoutParams(-1, -1));
        this.f11536g.setOnItemClickListener(new a());
    }

    public void setLayoutInCenter(boolean z) {
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11535f = context;
        b();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.f11535f = context;
        b();
    }
}
