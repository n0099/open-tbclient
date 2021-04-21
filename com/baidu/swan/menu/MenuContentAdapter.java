package com.baidu.swan.menu;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.b.h0.i.i;
import d.b.h0.i.j;
import d.b.h0.i.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<o> f12655a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<o> f12656b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f12657c;

    /* renamed from: d  reason: collision with root package name */
    public Context f12658d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f12659a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f12660b;

        public a(View view) {
            super(view);
            this.f12659a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f12660b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
        }
    }

    public MenuContentAdapter(Context context) {
        this.f12658d = context;
    }

    public final boolean c(boolean z) {
        return z || this.f12655a.size() > 5 || this.f12656b.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i) {
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            int i2 = layoutParams.width;
            int i3 = this.f12657c;
            if (i2 != i3) {
                layoutParams.width = i3;
                aVar.itemView.setLayoutParams(layoutParams);
            }
        }
        if (i < this.f12655a.size()) {
            aVar.f12659a.setVisibility(0);
            aVar.f12659a.h(this.f12655a.get(i));
            aVar.f12659a.setOnClickListener(null);
        } else {
            aVar.f12659a.setVisibility(this.f12655a.size() == 0 ? 8 : 4);
            aVar.f12659a.setOnClickListener(null);
        }
        if (i < this.f12656b.size()) {
            aVar.f12660b.setVisibility(0);
            aVar.f12660b.h(this.f12656b.get(i));
            aVar.f12660b.setOnClickListener(null);
            return;
        }
        aVar.f12660b.setVisibility(this.f12656b.size() != 0 ? 4 : 8);
        aVar.f12660b.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f12658d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f12657c, -2);
        } else {
            layoutParams.width = this.f12657c;
        }
        inflate.setLayoutParams(layoutParams);
        return new a(inflate);
    }

    public void f(List<List<o>> list, boolean z, int i) {
        int max;
        List<o> list2;
        List<o> list3;
        this.f12655a.clear();
        this.f12656b.clear();
        if (list == null) {
            return;
        }
        if (list.size() > 0 && (list3 = list.get(0)) != null) {
            this.f12655a.addAll(list3);
        }
        if (list.size() > 1 && (list2 = list.get(1)) != null) {
            this.f12656b.addAll(list2);
        }
        DisplayMetrics displayMetrics = this.f12658d.getResources().getDisplayMetrics();
        if (i == 0) {
            max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        this.f12657c = (int) (max / (c(z) ? 5.5f : 5.0f));
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.f12655a.size(), this.f12656b.size());
    }
}
