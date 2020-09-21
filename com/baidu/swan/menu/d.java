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
/* loaded from: classes23.dex */
public class d extends RecyclerView.Adapter<a> {
    private List<i> dFL = new ArrayList();
    private List<i> dFM = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.dFL.clear();
        this.dFM.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.dFL.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.dFM.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (gX(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean gX(boolean z) {
        return z || this.dFL.size() > 5 || this.dFM.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: e */
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
        if (i < this.dFL.size()) {
            aVar.dFN.setVisibility(0);
            aVar.dFN.f(this.dFL.get(i));
            aVar.dFN.setOnClickListener(null);
        } else {
            aVar.dFN.setVisibility(this.dFL.size() == 0 ? 8 : 4);
            aVar.dFN.setOnClickListener(null);
        }
        if (i < this.dFM.size()) {
            aVar.dFO.setVisibility(0);
            aVar.dFO.f(this.dFM.get(i));
            aVar.dFO.setOnClickListener(null);
            return;
        }
        aVar.dFO.setVisibility(this.dFM.size() != 0 ? 4 : 8);
        aVar.dFO.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.dFL.size(), this.dFM.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView dFN;
        SwanAppMenuItemView dFO;

        public a(View view) {
            super(view);
            this.dFN = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.dFO = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
