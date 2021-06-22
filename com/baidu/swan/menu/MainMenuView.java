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
import d.a.m0.k.g;
import d.a.m0.k.o;
import java.util.List;
/* loaded from: classes3.dex */
public class MainMenuView extends BaseMenuView {
    public LinearLayout j;
    public View k;
    public View l;
    public RecyclerView m;
    public MenuContentAdapter n;
    public RecyclerView o;
    public MenuContentAdapter p;
    public List<List<o>> q;
    public View r;
    public boolean s;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    private void setMenuHeader(View view) {
        View view2;
        if (view == null || view == (view2 = this.k)) {
            return;
        }
        if (view2 != null) {
            this.j.removeView(view2);
        }
        this.k = view;
        this.j.addView(view, 0);
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean b() {
        List<List<o>> list = this.q;
        return list != null && list.size() > 1;
    }

    public final void d(int i2) {
        this.l.setVisibility(0);
        this.o.setVisibility(0);
        if (this.n == null) {
            MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
            this.n = menuContentAdapter;
            this.m.setAdapter(menuContentAdapter);
        }
        this.n.f(this.q.subList(0, 1), this.s, i2);
        if (this.p == null) {
            MenuContentAdapter menuContentAdapter2 = new MenuContentAdapter(getContext());
            this.p = menuContentAdapter2;
            this.o.setAdapter(menuContentAdapter2);
        }
        this.p.f(this.q.subList(1, 2), this.s, i2);
    }

    public final void e(int i2) {
        this.l.setVisibility(8);
        this.o.setVisibility(8);
        if (this.n == null) {
            MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
            this.n = menuContentAdapter;
            this.m.setAdapter(menuContentAdapter);
        }
        this.n.f(this.q, this.s, i2);
    }

    public void f() {
        MenuContentAdapter menuContentAdapter = this.n;
        if (menuContentAdapter != null) {
            menuContentAdapter.notifyDataSetChanged();
        }
        MenuContentAdapter menuContentAdapter2 = this.p;
        if (menuContentAdapter2 != null) {
            menuContentAdapter2.notifyDataSetChanged();
        }
    }

    public void g() {
        RecyclerView recyclerView = this.m;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        if (this.o != null) {
            this.m.scrollToPosition(0);
        }
    }

    @Nullable
    public View getCoverView() {
        return this.r;
    }

    public void h(List<List<o>> list, View view, boolean z, int i2) {
        setMode();
        setMenuHeader(view);
        i(list, z, i2);
    }

    public final void i(List<List<o>> list, boolean z, int i2) {
        this.q = list;
        this.s = z;
        if (z && list.size() > 1) {
            d(i2);
        } else {
            e(i2);
        }
    }

    public void setCoverView(View view) {
        this.r = view;
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i2);
        this.j = linearLayout;
        linearLayout.setOrientation(1);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet, i2);
        this.m = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.m.setPadding(0, (int) this.f11938e.getResources().getDimension(g.aiapp_menu_gridview_padding_top), 0, 0);
        this.j.addView(this.m, layoutParams);
        View view = new View(context);
        this.l = view;
        view.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(g.main_menu_divider_margin);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.j.addView(this.l, layoutParams2);
        RecyclerView recyclerView2 = new RecyclerView(context, attributeSet, i2);
        this.o = recyclerView2;
        recyclerView2.setVisibility(8);
        this.o.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.j.addView(this.o, new LinearLayout.LayoutParams(-1, -2));
        c(this.j, new FrameLayout.LayoutParams(-1, -2));
    }
}
