package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<c> esF;
    private b esG;
    private boolean esH;
    private String esI;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.esG = bVar;
        this.esH = z;
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar) {
        this(context, recyclerView, bVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 101:
                return new LocationFooterViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_footer, viewGroup, false));
            default:
                return new LocationDetailViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.esG);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((LocationFooterViewHolder) viewHolder).ix(beG());
                return;
            default:
                ((LocationDetailViewHolder) viewHolder).a(this.esF.get(i), this.esI, beH());
                return;
        }
    }

    private boolean beG() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<c> list) {
        c(list, null);
    }

    public void c(List<c> list, String str) {
        if (list != null) {
            this.esF = list;
            this.esI = str;
            notifyDataSetChanged();
        }
    }

    private boolean beH() {
        return !TextUtils.isEmpty(this.esI);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.esF == null) {
            return 0;
        }
        return (this.esH ? 1 : 0) + this.esF.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.esH || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void beI() {
        for (c cVar : this.esF) {
            cVar.isSelected = false;
        }
    }
}
