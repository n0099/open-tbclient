package com.baidu.swan.menu;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.a.h0.i.i;
import d.a.h0.i.j;
import d.a.h0.i.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<o> f12556a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<o> f12557b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f12558c;

    /* renamed from: d  reason: collision with root package name */
    public Context f12559d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f12560a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f12561b;

        public a(View view) {
            super(view);
            this.f12560a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f12561b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
        }
    }

    public MenuContentAdapter(Context context) {
        this.f12559d = context;
    }

    public final boolean c(boolean z) {
        return z || this.f12556a.size() > 5 || this.f12557b.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i2) {
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            int i3 = layoutParams.width;
            int i4 = this.f12558c;
            if (i3 != i4) {
                layoutParams.width = i4;
                aVar.itemView.setLayoutParams(layoutParams);
            }
        }
        if (i2 < this.f12556a.size()) {
            aVar.f12560a.setVisibility(0);
            aVar.f12560a.h(this.f12556a.get(i2));
            aVar.f12560a.setOnClickListener(null);
        } else {
            aVar.f12560a.setVisibility(this.f12556a.size() == 0 ? 8 : 4);
            aVar.f12560a.setOnClickListener(null);
        }
        if (i2 < this.f12557b.size()) {
            aVar.f12561b.setVisibility(0);
            aVar.f12561b.h(this.f12557b.get(i2));
            aVar.f12561b.setOnClickListener(null);
            return;
        }
        aVar.f12561b.setVisibility(this.f12557b.size() != 0 ? 4 : 8);
        aVar.f12561b.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(this.f12559d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f12558c, -2);
        } else {
            layoutParams.width = this.f12558c;
        }
        inflate.setLayoutParams(layoutParams);
        return new a(inflate);
    }

    public void f(List<List<o>> list, boolean z, int i2) {
        int max;
        List<o> list2;
        List<o> list3;
        this.f12556a.clear();
        this.f12557b.clear();
        if (list == null) {
            return;
        }
        if (list.size() > 0 && (list3 = list.get(0)) != null) {
            this.f12556a.addAll(list3);
        }
        if (list.size() > 1 && (list2 = list.get(1)) != null) {
            this.f12557b.addAll(list2);
        }
        DisplayMetrics displayMetrics = this.f12559d.getResources().getDisplayMetrics();
        if (i2 == 0) {
            max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        this.f12558c = (int) (max / (c(z) ? 5.5f : 5.0f));
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.f12556a.size(), this.f12557b.size());
    }
}
