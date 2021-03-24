package com.baidu.swan.menu;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.b.g0.i.i;
import d.b.g0.i.j;
import d.b.g0.i.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<o> f12985a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<o> f12986b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f12987c;

    /* renamed from: d  reason: collision with root package name */
    public Context f12988d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f12989a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f12990b;

        public a(View view) {
            super(view);
            this.f12989a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f12990b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
        }
    }

    public MenuContentAdapter(Context context) {
        this.f12988d = context;
    }

    public final boolean c(boolean z) {
        return z || this.f12985a.size() > 5 || this.f12986b.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i) {
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            int i2 = layoutParams.width;
            int i3 = this.f12987c;
            if (i2 != i3) {
                layoutParams.width = i3;
                aVar.itemView.setLayoutParams(layoutParams);
            }
        }
        if (i < this.f12985a.size()) {
            aVar.f12989a.setVisibility(0);
            aVar.f12989a.h(this.f12985a.get(i));
            aVar.f12989a.setOnClickListener(null);
        } else {
            aVar.f12989a.setVisibility(this.f12985a.size() == 0 ? 8 : 4);
            aVar.f12989a.setOnClickListener(null);
        }
        if (i < this.f12986b.size()) {
            aVar.f12990b.setVisibility(0);
            aVar.f12990b.h(this.f12986b.get(i));
            aVar.f12990b.setOnClickListener(null);
            return;
        }
        aVar.f12990b.setVisibility(this.f12986b.size() != 0 ? 4 : 8);
        aVar.f12990b.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f12988d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f12987c, -2);
        } else {
            layoutParams.width = this.f12987c;
        }
        inflate.setLayoutParams(layoutParams);
        return new a(inflate);
    }

    public void f(List<List<o>> list, boolean z, int i) {
        int max;
        List<o> list2;
        List<o> list3;
        this.f12985a.clear();
        this.f12986b.clear();
        if (list == null) {
            return;
        }
        if (list.size() > 0 && (list3 = list.get(0)) != null) {
            this.f12985a.addAll(list3);
        }
        if (list.size() > 1 && (list2 = list.get(1)) != null) {
            this.f12986b.addAll(list2);
        }
        DisplayMetrics displayMetrics = this.f12988d.getResources().getDisplayMetrics();
        if (i == 0) {
            max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        double d2 = max;
        double d3 = c(z) ? 5.5f : 5.0f;
        Double.isNaN(d2);
        Double.isNaN(d3);
        this.f12987c = (int) (d2 / d3);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.f12985a.size(), this.f12986b.size());
    }
}
