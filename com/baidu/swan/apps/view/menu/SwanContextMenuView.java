package com.baidu.swan.apps.view.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import d.a.m0.a.c;
import d.a.m0.a.d;
import d.a.m0.a.e;
import d.a.m0.a.f;
import d.a.m0.a.g;
import d.a.m0.a.z1.b.e.a;
import d.a.m0.a.z1.b.e.b;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanContextMenuView extends FrameLayout implements a.g {

    /* renamed from: e  reason: collision with root package name */
    public final Context f11536e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11537f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f11538g;

    /* renamed from: h  reason: collision with root package name */
    public b f11539h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11540i;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            SwanContextMenuView.this.f11539h.a(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final Context f11542e;

        /* renamed from: f  reason: collision with root package name */
        public List<d.a.m0.a.z1.b.e.b> f11543f;

        /* loaded from: classes3.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f11545a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f11546b;

            public a(b bVar) {
            }
        }

        public b(Context context, List<d.a.m0.a.z1.b.e.b> list) {
            this.f11543f = list;
            this.f11542e = context;
        }

        public void a(int i2) {
            d.a.m0.a.z1.b.e.b bVar = this.f11543f.get(i2);
            b.a d2 = bVar.d();
            if (d2 != null) {
                d2.a(bVar);
            }
        }

        public final void b(View view, int i2) {
            if (getCount() == 1) {
                view.setBackground(this.f11542e.getResources().getDrawable(e.swan_app_context_menu_round_corner_selector));
            } else if (i2 == 0) {
                view.setBackground(this.f11542e.getResources().getDrawable(e.swan_app_context_menu_top_corner_selector));
            } else if (i2 == getCount() - 1) {
                view.setBackground(this.f11542e.getResources().getDrawable(e.swan_app_context_menu_bottom_corner_selector));
            } else {
                view.setBackground(this.f11542e.getResources().getDrawable(e.swan_app_context_menu_no_corner_selector));
            }
        }

        public void c(List<d.a.m0.a.z1.b.e.b> list) {
            this.f11543f = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f11543f.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f11543f.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f11542e).inflate(g.swan_app_menu_item_view, (ViewGroup) null);
                aVar = new a(this);
                aVar.f11545a = (ImageView) view.findViewById(f.item_icon);
                aVar.f11546b = (TextView) view.findViewById(f.item_title);
                b(view, i2);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            d.a.m0.a.z1.b.e.b bVar = this.f11543f.get(i2);
            aVar.f11546b.setText(bVar.e());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f11546b.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f11545a.getLayoutParams();
            if (bVar.b() != null) {
                aVar.f11545a.setVisibility(0);
                aVar.f11545a.setImageDrawable(bVar.b());
                layoutParams.setMarginStart(this.f11542e.getResources().getDimensionPixelSize(d.swan_context_menu_item_title_left_margin));
            } else {
                aVar.f11545a.setVisibility(8);
                layoutParams.setMarginStart(this.f11542e.getResources().getDimensionPixelSize(d.swan_context_menu_item_icon_left_margin));
            }
            aVar.f11546b.setLayoutParams(layoutParams);
            if (SwanContextMenuView.this.f11540i) {
                ((LinearLayout) view).setGravity(17);
                layoutParams.width = -2;
                if (bVar.b() != null) {
                    layoutParams2.setMarginStart(0);
                    aVar.f11545a.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.setMarginStart(0);
                    aVar.f11546b.setLayoutParams(layoutParams);
                }
            }
            return view;
        }
    }

    public SwanContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11537f = false;
        this.f11536e = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.f11536e.getResources().getDrawable(e.swan_app_context_menu_bg));
        ListView listView = new ListView(this.f11536e);
        this.f11538g = listView;
        listView.setCacheColorHint(0);
        this.f11538g.setDivider(getResources().getDrawable(c.swan_context_menu_divider_color));
        this.f11538g.setDividerHeight(1);
        this.f11538g.setSelector(new ColorDrawable(0));
        addView(this.f11538g, new FrameLayout.LayoutParams(-1, -1));
        this.f11538g.setOnItemClickListener(new a());
    }

    public void c(List<d.a.m0.a.z1.b.e.b> list) {
        if (this.f11537f) {
            return;
        }
        b bVar = this.f11539h;
        if (bVar == null) {
            b bVar2 = new b(this.f11536e, list);
            this.f11539h = bVar2;
            this.f11538g.setAdapter((ListAdapter) bVar2);
        } else {
            bVar.c(list);
        }
        this.f11537f = true;
    }

    public void setLayoutInCenter(boolean z) {
        this.f11540i = z;
    }

    public SwanContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11537f = false;
        this.f11536e = context;
        b();
    }

    public SwanContextMenuView(Context context) {
        super(context);
        this.f11537f = false;
        this.f11536e = context;
        b();
    }
}
