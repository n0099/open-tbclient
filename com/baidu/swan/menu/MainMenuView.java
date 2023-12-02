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
import com.baidu.tieba.R;
import com.baidu.tieba.sc4;
import java.util.List;
/* loaded from: classes4.dex */
public class MainMenuView extends BaseMenuView {
    public LinearLayout f;
    public View g;
    public View h;
    public RecyclerView i;
    public MenuContentAdapter j;
    public RecyclerView k;
    public MenuContentAdapter l;
    public List<List<sc4>> m;
    public View n;
    public boolean o;

    public MainMenuView(@NonNull Context context) {
        this(context, null);
    }

    private void setMenuHeader(View view2) {
        View view3;
        if (view2 == null || view2 == (view3 = this.g)) {
            return;
        }
        if (view3 != null) {
            this.f.removeView(view3);
        }
        this.g = view2;
        this.f.addView(view2, 0);
    }

    public final void d(int i) {
        this.h.setVisibility(8);
        this.k.setVisibility(8);
        if (this.j == null) {
            MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
            this.j = menuContentAdapter;
            this.i.setAdapter(menuContentAdapter);
        }
        this.j.p(this.m, this.o, i);
    }

    public void setCoverView(View view2) {
        this.n = view2;
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        this.f = linearLayout;
        linearLayout.setOrientation(1);
        RecyclerView recyclerView = new RecyclerView(context, attributeSet, i);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.i.setPadding(0, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0700e5), 0, 0);
        this.f.addView(this.i, layoutParams);
        View view2 = new View(context);
        this.h = view2;
        view2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07058d);
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        this.f.addView(this.h, layoutParams2);
        RecyclerView recyclerView2 = new RecyclerView(context, attributeSet, i);
        this.k = recyclerView2;
        recyclerView2.setVisibility(8);
        this.k.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f.addView(this.k, new LinearLayout.LayoutParams(-1, -2));
        b(this.f, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.baidu.swan.menu.BaseMenuView
    public boolean a() {
        List<List<sc4>> list = this.m;
        if (list != null && list.size() > 1) {
            return true;
        }
        return false;
    }

    public void e() {
        MenuContentAdapter menuContentAdapter = this.j;
        if (menuContentAdapter != null) {
            menuContentAdapter.notifyDataSetChanged();
        }
        MenuContentAdapter menuContentAdapter2 = this.l;
        if (menuContentAdapter2 != null) {
            menuContentAdapter2.notifyDataSetChanged();
        }
    }

    public void f() {
        RecyclerView recyclerView = this.i;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        if (this.k != null) {
            this.i.scrollToPosition(0);
        }
    }

    @Nullable
    public View getCoverView() {
        return this.n;
    }

    public final void c(int i) {
        this.h.setVisibility(0);
        this.k.setVisibility(0);
        if (this.j == null) {
            MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getContext());
            this.j = menuContentAdapter;
            this.i.setAdapter(menuContentAdapter);
        }
        this.j.p(this.m.subList(0, 1), this.o, i);
        if (this.l == null) {
            MenuContentAdapter menuContentAdapter2 = new MenuContentAdapter(getContext());
            this.l = menuContentAdapter2;
            this.k.setAdapter(menuContentAdapter2);
        }
        this.l.p(this.m.subList(1, 2), this.o, i);
    }

    public void g(List<List<sc4>> list, View view2, boolean z, int i) {
        setMode();
        setMenuHeader(view2);
        h(list, z, i);
    }

    public final void h(List<List<sc4>> list, boolean z, int i) {
        this.m = list;
        this.o = z;
        if (z && list.size() > 1) {
            c(i);
        } else {
            d(i);
        }
    }
}
