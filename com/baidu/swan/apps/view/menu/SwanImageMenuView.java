package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.view.SwanAppRoundCornerListView;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.l0.a.e;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.z1.b.e.a;
import d.a.l0.a.z1.b.e.b;
import d.a.l0.a.z1.b.e.d;
import java.util.List;
/* loaded from: classes3.dex */
public class SwanImageMenuView extends FrameLayout implements a.g {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11403e;

    /* renamed from: f  reason: collision with root package name */
    public c f11404f;

    /* renamed from: g  reason: collision with root package name */
    public Context f11405g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppRoundCornerListView f11406h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.a.w2.j.b f11407i;
    public View j;
    public int k;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            SwanImageMenuView.this.f11404f.b(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanImageMenuView.this.f11407i != null) {
                SwanImageMenuView.this.f11407i.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<d.a.l0.a.z1.b.e.b> f11410e;

        /* renamed from: f  reason: collision with root package name */
        public Context f11411f;

        public c(Context context, List<d.a.l0.a.z1.b.e.b> list) {
            this.f11410e = list;
            this.f11411f = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d.a.l0.a.z1.b.e.b getItem(int i2) {
            return this.f11410e.get(i2);
        }

        public void b(int i2) {
            d.a.l0.a.z1.b.e.b bVar = this.f11410e.get(i2);
            b.a d2 = bVar.d();
            if (d2 != null) {
                d2.a(bVar);
            }
        }

        public final void c(@NonNull View view, int i2) {
            if (i2 == 0) {
                view.setBackground(this.f11411f.getResources().getDrawable(e.swan_image_menu_item_rounded_bg));
            } else {
                view.setBackground(this.f11411f.getResources().getDrawable(e.swan_image_menu_item_bg));
            }
        }

        public void d(List<d.a.l0.a.z1.b.e.b> list) {
            this.f11410e = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f11410e.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View inflate;
            d.a.l0.a.z1.b.e.b item = getItem(i2);
            if (item instanceof d) {
                inflate = View.inflate(this.f11411f, g.swan_app_img_menu_swan_item_layout, null);
                String i3 = ((d) item).i();
                if (!TextUtils.isEmpty(i3)) {
                    ((SimpleDraweeView) inflate.findViewById(f.icon)).setImageURI(i3);
                }
                ((TextView) inflate.findViewById(f.name)).setText(item.e());
            } else {
                inflate = View.inflate(this.f11411f, g.aiapps_scheme_utils_show_action_sheet_item, null);
                TextView textView = (TextView) inflate.findViewById(f.text);
                textView.setTextColor(this.f11411f.getResources().getColor(d.a.l0.a.c.aiapps_action_sheet_item_color));
                textView.setText(item.e());
            }
            c(inflate, i2);
            return inflate;
        }
    }

    public SwanImageMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11403e = false;
        this.k = -1;
        this.f11405g = context;
        c();
    }

    public final void c() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f11405g).inflate(g.swan_app_img_menu, (ViewGroup) null);
        SwanAppRoundCornerListView swanAppRoundCornerListView = (SwanAppRoundCornerListView) linearLayout.findViewById(f.list);
        this.f11406h = swanAppRoundCornerListView;
        swanAppRoundCornerListView.setOnItemClickListener(new a());
        this.f11406h.setSelector(new ColorDrawable(0));
        ((TextView) linearLayout.findViewById(f.negative_button)).setOnClickListener(new b());
        addView(linearLayout);
        if (d.a.l0.a.c1.a.H().a()) {
            View view = new View(this.f11405g);
            this.j = view;
            view.setBackgroundResource(e.swan_image_menu_night_mask);
            this.j.setVisibility(8);
            addView(this.j);
        }
    }

    public void d(List<d.a.l0.a.z1.b.e.b> list) {
        if (this.f11403e) {
            return;
        }
        c cVar = this.f11404f;
        if (cVar == null) {
            c cVar2 = new c(this.f11405g, list);
            this.f11404f = cVar2;
            this.f11406h.setAdapter((ListAdapter) cVar2);
        } else {
            cVar.d(list);
        }
        this.f11403e = true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int measuredHeight = getMeasuredHeight();
        View view = this.j;
        if (view == null || this.k == measuredHeight) {
            return;
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, measuredHeight));
        this.j.setVisibility(0);
        this.k = measuredHeight;
    }

    public void setMenu(d.a.l0.a.w2.j.b bVar) {
        this.f11407i = bVar;
    }

    public SwanImageMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11403e = false;
        this.k = -1;
        this.f11405g = context;
        c();
    }

    public SwanImageMenuView(Context context) {
        super(context);
        this.f11403e = false;
        this.k = -1;
        this.f11405g = context;
        c();
    }
}
