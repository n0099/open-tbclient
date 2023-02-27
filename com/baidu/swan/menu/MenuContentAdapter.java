package com.baidu.swan.menu;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.rp4;
import com.baidu.tieba.uf4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {
    public List<uf4> a = new ArrayList();
    public List<uf4> b = new ArrayList();
    public int c;
    public Context d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public SwanAppMenuItemView a;
        public SwanAppMenuItemView b;

        public a(View view2) {
            super(view2);
            this.a = (SwanAppMenuItemView) view2.findViewById(R.id.obfuscated_res_0x7f090a96);
            this.b = (SwanAppMenuItemView) view2.findViewById(R.id.obfuscated_res_0x7f091fa0);
        }
    }

    public MenuContentAdapter(Context context) {
        this.d = context;
    }

    public final boolean d(boolean z) {
        if (!z && this.a.size() <= 5 && this.b.size() <= 5) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(a aVar, int i) {
        int i2;
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null) {
            int i3 = layoutParams.width;
            int i4 = this.c;
            if (i3 != i4) {
                layoutParams.width = i4;
                aVar.itemView.setLayoutParams(layoutParams);
            }
        }
        int i5 = 8;
        if (i < this.a.size()) {
            aVar.a.setVisibility(0);
            aVar.a.h(this.a.get(i), this.c);
            aVar.a.setOnClickListener(null);
        } else {
            SwanAppMenuItemView swanAppMenuItemView = aVar.a;
            if (this.a.size() == 0) {
                i2 = 8;
            } else {
                i2 = 4;
            }
            swanAppMenuItemView.setVisibility(i2);
            aVar.a.setOnClickListener(null);
        }
        if (i < this.b.size()) {
            aVar.b.setVisibility(0);
            aVar.b.h(this.b.get(i), this.c);
            aVar.b.setOnClickListener(null);
            return;
        }
        SwanAppMenuItemView swanAppMenuItemView2 = aVar.b;
        if (this.b.size() != 0) {
            i5 = 4;
        }
        swanAppMenuItemView2.setVisibility(i5);
        aVar.b.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.d).inflate(R.layout.obfuscated_res_0x7f0d086c, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.c, -2);
        } else {
            layoutParams.width = this.c;
        }
        inflate.setLayoutParams(layoutParams);
        return new a(inflate);
    }

    public void g(List<List<uf4>> list, boolean z, int i) {
        int max;
        float f;
        List<uf4> list2;
        List<uf4> list3;
        this.a.clear();
        this.b.clear();
        if (list == null) {
            return;
        }
        if (list.size() > 0 && (list3 = list.get(0)) != null) {
            this.a.addAll(list3);
        }
        if (list.size() > 1 && (list2 = list.get(1)) != null) {
            this.b.addAll(list2);
        }
        DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
        if (i == 0) {
            max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        if (d(z)) {
            f = 5.5f;
        } else {
            f = 5.0f;
        }
        if (rp4.d()) {
            Context context = this.d;
            if ((context instanceof Activity) && rp4.e((Activity) context)) {
                max = rp4.a((Activity) this.d);
            }
        }
        this.c = (int) (max / f);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.a.size(), this.b.size());
    }
}
