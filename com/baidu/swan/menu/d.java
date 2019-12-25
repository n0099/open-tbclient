package com.baidu.swan.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends RecyclerView.Adapter<a> {
    private Context mContext;
    private int mItemWidth;
    private List<i> cuz = new ArrayList();
    private List<i> cuA = new ArrayList();

    public d(Context context) {
        this.mContext = context;
    }

    public void d(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.cuz.clear();
        this.cuA.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.cuz.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.cuA.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (eG(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean eG(boolean z) {
        return z || this.cuz.size() > 5 || this.cuA.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: g */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(g.e.swan_app_menu_item_layout, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.mItemWidth, -2);
        } else {
            layoutParams.width = this.mItemWidth;
        }
        inflate.setLayoutParams(layoutParams);
        return new a(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams.width != this.mItemWidth) {
            layoutParams.width = this.mItemWidth;
            aVar.itemView.setLayoutParams(layoutParams);
        }
        if (i < this.cuz.size()) {
            aVar.cuB.setVisibility(0);
            aVar.cuB.g(this.cuz.get(i));
            aVar.cuB.setOnClickListener(null);
        } else {
            aVar.cuB.setVisibility(this.cuz.size() == 0 ? 8 : 4);
            aVar.cuB.setOnClickListener(null);
        }
        if (i < this.cuA.size()) {
            aVar.cuC.setVisibility(0);
            aVar.cuC.g(this.cuA.get(i));
            aVar.cuC.setOnClickListener(null);
            return;
        }
        aVar.cuC.setVisibility(this.cuA.size() != 0 ? 4 : 8);
        aVar.cuC.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.cuz.size(), this.cuA.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView cuB;
        SwanAppMenuItemView cuC;

        public a(View view) {
            super(view);
            this.cuB = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.cuC = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
