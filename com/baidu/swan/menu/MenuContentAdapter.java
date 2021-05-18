package com.baidu.swan.menu;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import d.a.i0.k.i;
import d.a.i0.k.j;
import d.a.i0.k.o;
import d.a.i0.t.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<o> f11898a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<o> f11899b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f11900c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11901d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f11902a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f11903b;

        public a(View view) {
            super(view);
            this.f11902a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f11903b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
        }
    }

    public MenuContentAdapter(Context context) {
        this.f11901d = context;
    }

    public final boolean c(boolean z) {
        return z || this.f11898a.size() > 5 || this.f11899b.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i2) {
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            int i3 = layoutParams.width;
            int i4 = this.f11900c;
            if (i3 != i4) {
                layoutParams.width = i4;
                aVar.itemView.setLayoutParams(layoutParams);
            }
        }
        if (i2 < this.f11898a.size()) {
            aVar.f11902a.setVisibility(0);
            aVar.f11902a.h(this.f11898a.get(i2), this.f11900c);
            aVar.f11902a.setOnClickListener(null);
        } else {
            aVar.f11902a.setVisibility(this.f11898a.size() == 0 ? 8 : 4);
            aVar.f11902a.setOnClickListener(null);
        }
        if (i2 < this.f11899b.size()) {
            aVar.f11903b.setVisibility(0);
            aVar.f11903b.h(this.f11899b.get(i2), this.f11900c);
            aVar.f11903b.setOnClickListener(null);
            return;
        }
        aVar.f11903b.setVisibility(this.f11899b.size() != 0 ? 4 : 8);
        aVar.f11903b.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(this.f11901d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f11900c, -2);
        } else {
            layoutParams.width = this.f11900c;
        }
        inflate.setLayoutParams(layoutParams);
        return new a(inflate);
    }

    public void f(List<List<o>> list, boolean z, int i2) {
        int max;
        List<o> list2;
        List<o> list3;
        this.f11898a.clear();
        this.f11899b.clear();
        if (list == null) {
            return;
        }
        if (list.size() > 0 && (list3 = list.get(0)) != null) {
            this.f11898a.addAll(list3);
        }
        if (list.size() > 1 && (list2 = list.get(1)) != null) {
            this.f11899b.addAll(list2);
        }
        DisplayMetrics displayMetrics = this.f11901d.getResources().getDisplayMetrics();
        if (i2 == 0) {
            max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        float f2 = c(z) ? 5.5f : 5.0f;
        if (e.d()) {
            Context context = this.f11901d;
            if ((context instanceof Activity) && e.e((Activity) context)) {
                max = e.a((Activity) this.f11901d);
            }
        }
        this.f11900c = (int) (max / f2);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.f11898a.size(), this.f11899b.size());
    }
}
