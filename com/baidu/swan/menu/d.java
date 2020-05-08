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
    private List<i> cXX = new ArrayList();
    private List<i> cXY = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.cXX.clear();
        this.cXY.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.cXX.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.cXY.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (fQ(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean fQ(boolean z) {
        return z || this.cXX.size() > 5 || this.cXY.size() > 5;
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
        if (i < this.cXX.size()) {
            aVar.cXZ.setVisibility(0);
            aVar.cXZ.g(this.cXX.get(i));
            aVar.cXZ.setOnClickListener(null);
        } else {
            aVar.cXZ.setVisibility(this.cXX.size() == 0 ? 8 : 4);
            aVar.cXZ.setOnClickListener(null);
        }
        if (i < this.cXY.size()) {
            aVar.cYa.setVisibility(0);
            aVar.cYa.g(this.cXY.get(i));
            aVar.cYa.setOnClickListener(null);
            return;
        }
        aVar.cYa.setVisibility(this.cXY.size() != 0 ? 4 : 8);
        aVar.cYa.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.cXX.size(), this.cXY.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView cXZ;
        SwanAppMenuItemView cYa;

        public a(View view) {
            super(view);
            this.cXZ = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.cYa = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
