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
/* loaded from: classes10.dex */
public class d extends RecyclerView.Adapter<a> {
    private List<i> cuK = new ArrayList();
    private List<i> cuL = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.cuK.clear();
        this.cuL.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.cuK.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.cuL.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (eL(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean eL(boolean z) {
        return z || this.cuK.size() > 5 || this.cuL.size() > 5;
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
        if (i < this.cuK.size()) {
            aVar.cuM.setVisibility(0);
            aVar.cuM.g(this.cuK.get(i));
            aVar.cuM.setOnClickListener(null);
        } else {
            aVar.cuM.setVisibility(this.cuK.size() == 0 ? 8 : 4);
            aVar.cuM.setOnClickListener(null);
        }
        if (i < this.cuL.size()) {
            aVar.cuN.setVisibility(0);
            aVar.cuN.g(this.cuL.get(i));
            aVar.cuN.setOnClickListener(null);
            return;
        }
        aVar.cuN.setVisibility(this.cuL.size() != 0 ? 4 : 8);
        aVar.cuN.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.cuK.size(), this.cuL.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView cuM;
        SwanAppMenuItemView cuN;

        public a(View view) {
            super(view);
            this.cuM = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.cuN = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
