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
    private List<i> cyI = new ArrayList();
    private List<i> cyJ = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.cyI.clear();
        this.cyJ.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.cyI.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.cyJ.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (eS(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean eS(boolean z) {
        return z || this.cyI.size() > 5 || this.cyJ.size() > 5;
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
        if (i < this.cyI.size()) {
            aVar.cyK.setVisibility(0);
            aVar.cyK.g(this.cyI.get(i));
            aVar.cyK.setOnClickListener(null);
        } else {
            aVar.cyK.setVisibility(this.cyI.size() == 0 ? 8 : 4);
            aVar.cyK.setOnClickListener(null);
        }
        if (i < this.cyJ.size()) {
            aVar.cyL.setVisibility(0);
            aVar.cyL.g(this.cyJ.get(i));
            aVar.cyL.setOnClickListener(null);
            return;
        }
        aVar.cyL.setVisibility(this.cyJ.size() != 0 ? 4 : 8);
        aVar.cyL.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.cyI.size(), this.cyJ.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView cyK;
        SwanAppMenuItemView cyL;

        public a(View view) {
            super(view);
            this.cyK = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.cyL = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
