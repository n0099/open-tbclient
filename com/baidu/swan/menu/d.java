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
/* loaded from: classes14.dex */
public class d extends RecyclerView.Adapter<a> {
    private List<i> dDK = new ArrayList();
    private List<i> dDL = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.dDK.clear();
        this.dDL.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.dDK.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.dDL.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (gZ(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean gZ(boolean z) {
        return z || this.dDK.size() > 5 || this.dDL.size() > 5;
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
        if (i < this.dDK.size()) {
            aVar.dDM.setVisibility(0);
            aVar.dDM.f(this.dDK.get(i));
            aVar.dDM.setOnClickListener(null);
        } else {
            aVar.dDM.setVisibility(this.dDK.size() == 0 ? 8 : 4);
            aVar.dDM.setOnClickListener(null);
        }
        if (i < this.dDL.size()) {
            aVar.dDN.setVisibility(0);
            aVar.dDN.f(this.dDL.get(i));
            aVar.dDN.setOnClickListener(null);
            return;
        }
        aVar.dDN.setVisibility(this.dDL.size() != 0 ? 4 : 8);
        aVar.dDN.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.dDK.size(), this.dDL.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView dDM;
        SwanAppMenuItemView dDN;

        public a(View view) {
            super(view);
            this.dDM = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.dDN = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
