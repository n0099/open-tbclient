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
    private List<h> erR = new ArrayList();
    private List<h> erS = new ArrayList();
    private Context mContext;
    private int mItemWidth;

    public MenuContentAdapter(Context context) {
        this.mContext = context;
    }

    public void b(List<List<h>> list, boolean z, int i) {
        int max;
        List<h> list2;
        List<h> list3;
        this.erR.clear();
        this.erS.clear();
        if (list != null) {
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.erR.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.erS.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            this.mItemWidth = (int) (max / (iy(z) ? 5.5f : 5.0f));
            notifyDataSetChanged();
        }
    }

    private boolean iy(boolean z) {
        return z || this.erR.size() > 5 || this.erS.size() > 5;
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
        if (i < this.erR.size()) {
            aVar.erT.setVisibility(0);
            aVar.erT.f(this.erR.get(i));
            aVar.erT.setOnClickListener(null);
        } else {
            aVar.erT.setVisibility(this.erR.size() == 0 ? 8 : 4);
            aVar.erT.setOnClickListener(null);
        }
        if (i < this.erS.size()) {
            aVar.erU.setVisibility(0);
            aVar.erU.f(this.erS.get(i));
            aVar.erU.setOnClickListener(null);
            return;
        }
        aVar.erU.setVisibility(this.erS.size() != 0 ? 4 : 8);
        aVar.erU.setOnClickListener(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Math.max(this.erR.size(), this.erS.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends RecyclerView.ViewHolder {
        SwanAppMenuItemView erT;
        SwanAppMenuItemView erU;

        public a(View view) {
            super(view);
            this.erT = (SwanAppMenuItemView) view.findViewById(f.d.first_line_menu_item_view);
            this.erU = (SwanAppMenuItemView) view.findViewById(f.d.second_line_menu_item_view);
        }
    }
}
