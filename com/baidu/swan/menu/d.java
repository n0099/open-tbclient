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
/* loaded from: classes11.dex */
public class d extends RecyclerView.Adapter<a> {
    private List<i> cyV = new ArrayList();
    private List<i> cyW = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.cyV.clear();
        this.cyW.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.cyV.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.cyW.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (eT(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean eT(boolean z) {
        return z || this.cyV.size() > 5 || this.cyW.size() > 5;
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
        if (i < this.cyV.size()) {
            aVar.cyX.setVisibility(0);
            aVar.cyX.g(this.cyV.get(i));
            aVar.cyX.setOnClickListener(null);
        } else {
            aVar.cyX.setVisibility(this.cyV.size() == 0 ? 8 : 4);
            aVar.cyX.setOnClickListener(null);
        }
        if (i < this.cyW.size()) {
            aVar.cyY.setVisibility(0);
            aVar.cyY.g(this.cyW.get(i));
            aVar.cyY.setOnClickListener(null);
            return;
        }
        aVar.cyY.setVisibility(this.cyW.size() != 0 ? 4 : 8);
        aVar.cyY.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.cyV.size(), this.cyW.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView cyX;
        SwanAppMenuItemView cyY;

        public a(View view) {
            super(view);
            this.cyX = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.cyY = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
