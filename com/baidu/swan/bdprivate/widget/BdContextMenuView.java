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
import d.b.h0.a.k;
import d.b.h0.b.c;
import d.b.h0.b.d;
/* loaded from: classes3.dex */
public class BdContextMenuView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f12399e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12400f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f12401g;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BdContextMenuView.this.f12399e.a(i);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {
        public abstract void a(int i);
    }

    static {
        boolean z = k.f45772a;
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12400f = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.f12400f.getResources().getDrawable(d.aiapps_context_menu_bg));
        ListView listView = new ListView(this.f12400f);
        this.f12401g = listView;
        listView.setCacheColorHint(0);
        this.f12401g.setDivider(getResources().getDrawable(c.aiapps_context_menu_divider_color));
        this.f12401g.setDividerHeight(1);
        this.f12401g.setSelector(new ColorDrawable(0));
        addView(this.f12401g, new FrameLayout.LayoutParams(-1, -1));
        this.f12401g.setOnItemClickListener(new a());
    }

    public void setLayoutInCenter(boolean z) {
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12400f = context;
        b();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.f12400f = context;
        b();
    }
}
