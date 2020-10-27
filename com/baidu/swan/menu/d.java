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
    private List<i> eai = new ArrayList();
    private List<i> eaj = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public d(Context context) {
        this.mContext = context;
    }

    public void b(List<List<i>> list, boolean z, int i) {
        int max;
        List<i> list2;
        List<i> list3;
        this.eai.clear();
        this.eaj.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.eai.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.eaj.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (hG(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean hG(boolean z) {
        return z || this.eai.size() > 5 || this.eaj.size() > 5;
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
        if (i < this.eai.size()) {
            aVar.eak.setVisibility(0);
            aVar.eak.f(this.eai.get(i));
            aVar.eak.setOnClickListener(null);
        } else {
            aVar.eak.setVisibility(this.eai.size() == 0 ? 8 : 4);
            aVar.eak.setOnClickListener(null);
        }
        if (i < this.eaj.size()) {
            aVar.eal.setVisibility(0);
            aVar.eal.f(this.eaj.get(i));
            aVar.eal.setOnClickListener(null);
            return;
        }
        aVar.eal.setVisibility(this.eaj.size() != 0 ? 4 : 8);
        aVar.eal.setOnClickListener(null);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.eai.size(), this.eaj.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView eak;
        SwanAppMenuItemView eal;

        public a(View view) {
            super(view);
            this.eak = (SwanAppMenuItemView) view.findViewById(g.d.first_line_menu_item_view);
            this.eal = (SwanAppMenuItemView) view.findViewById(g.d.second_line_menu_item_view);
        }
    }
}
