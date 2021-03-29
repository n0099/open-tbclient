package com.baidu.swan.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import d.b.g0.i.g;
import d.b.g0.i.o;
import java.util.List;
/* loaded from: classes3.dex */
public class MainMenuView extends BaseMenuView {
    public LinearLayout k;
    public View l;
    public View m;
    public RecyclerView n;
    public MenuContentAdapter o;
    public RecyclerView p;
    public MenuContentAdapter q;
    public List<List<o>> r;
    public View s;
    public boolean t;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    private void setMenuHeader(View view) {
        View view2;
        if (view == null || view == (view2 = this.l)) {
            return;
        }
        if (view2 != null) {
            this.k.removeView(view2);
        }
        this.l = view;
        this.k.addView(view, 0);
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean b() {
        List<List<o>> list = this.r;
        return list != null && list.size() > 1;
    }

    public final void d(int i) {
        this.m.setVisibility(0);
        this.p.setVisibility(0);
        if (this.o == null) {
            MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
            this.o = menuContentAdapter;
            this.n.setAdapter(menuContentAdapter);
        }
        this.o.f(this.r.subList(0, 1), this.t, i);
        if (this.q == null) {
            MenuContentAdapter menuContentAdapter2 = new MenuContentAdapter(getContext());
            this.q = menuContentAdapter2;
            this.p.setAdapter(menuContentAdapter2);
        }
        this.q.f(this.r.subList(1, 2), this.t, i);
    }

    public final void e(int i) {
        this.m.setVisibility(8);
        this.p.setVisibility(8);
        if (this.o == null) {
            MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
            this.o = menuContentAdapter;
            this.n.setAdapter(menuContentAdapter);
        }
        this.o.f(this.r, this.t, i);
    }

    public void f() {
        MenuContentAdapter menuContentAdapter = this.o;
        if (menuContentAdapter != null) {
            menuContentAdapter.notifyDataSetChanged();
        }
        MenuContentAdapter menuContentAdapter2 = this.q;
        if (menuContentAdapter2 != null) {
            menuContentAdapter2.notifyDataSetChanged();
        }
    }

    public void g() {
        RecyclerView recyclerView = this.n;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        if (this.p != null) {
            this.n.scrollToPosition(0);
        }
    }

    @Nullable
    public View getCoverView() {
        return this.s;
    }

    public void h(List<List<o>> list, View view, boolean z, int i) {
        setMode();
        setMenuHeader(view);
        i(list, z, i);
    }

    public final void i(List<List<o>> list, boolean z, int i) {
        this.r = list;
        this.t = z;
        if (z && list.size() > 1) {
            d(i);
        } else {
            e(i);
        }
    }

    public void setCoverView(View view) {
        this.s = view;
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        this.k = linearLayout;
        linearLayout.setOrientation(1);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet, i);
        this.n = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.n.setPadding(0, (int) this.f12982e.getResources().getDimension(g.aiapp_menu_gridview_padding_top), 0, 0);
        this.k.addView(this.n, layoutParams);
        View view = new View(context);
        this.m = view;
        view.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.k.addView(this.m, layoutParams2);
        RecyclerView recyclerView2 = new RecyclerView(context, attributeSet, i);
        this.p = recyclerView2;
        recyclerView2.setVisibility(8);
        this.p.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.k.addView(this.p, new LinearLayout.LayoutParams(-1, -2));
        c(this.k, new FrameLayout.LayoutParams(-1, -2));
    }
}
