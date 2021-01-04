package com.baidu.swan.menu;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.menu.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {
    private List<h> euy = new ArrayList();
    private List<h> euz = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public MenuContentAdapter(Context context) {
        this.mContext = context;
    }

    public void b(List<List<h>> list, boolean z, int i) {
        int max;
        List<h> list2;
        List<h> list3;
        this.euy.clear();
        this.euz.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.euy.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.euz.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (iA(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean iA(boolean z) {
        return z || this.euy.size() > 5 || this.euz.size() > 5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.mContext).inflate(f.e.swan_app_menu_item_layout, viewGroup, false);
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
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams.width != this.mItemWidth) {
            layoutParams.width = this.mItemWidth;
            aVar.itemView.setLayoutParams(layoutParams);
        }
        if (i < this.euy.size()) {
            aVar.euA.setVisibility(0);
            aVar.euA.f(this.euy.get(i));
            aVar.euA.setOnClickListener(null);
        } else {
            aVar.euA.setVisibility(this.euy.size() == 0 ? 8 : 4);
            aVar.euA.setOnClickListener(null);
        }
        if (i < this.euz.size()) {
            aVar.euB.setVisibility(0);
            aVar.euB.f(this.euz.get(i));
            aVar.euB.setOnClickListener(null);
            return;
        }
        aVar.euB.setVisibility(this.euz.size() != 0 ? 4 : 8);
        aVar.euB.setOnClickListener(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.euy.size(), this.euz.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView euA;
        SwanAppMenuItemView euB;

        public a(View view) {
            super(view);
            this.euA = (SwanAppMenuItemView) view.findViewById(f.d.first_line_menu_item_view);
            this.euB = (SwanAppMenuItemView) view.findViewById(f.d.second_line_menu_item_view);
        }
    }
}
