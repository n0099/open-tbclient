package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<c> erA;
    private b erB;
    private boolean erC;
    private String erD;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.erB = bVar;
        this.erC = z;
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
                return new LocationDetailViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.erB);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((LocationFooterViewHolder) viewHolder).iv(bbd());
                return;
            default:
                ((LocationDetailViewHolder) viewHolder).a(this.erA.get(i), this.erD, bbe());
                return;
        }
    }

    private boolean bbd() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<c> list) {
        setData(list, null);
    }

    public void setData(List<c> list, String str) {
        if (list != null) {
            this.erA = list;
            this.erD = str;
            notifyDataSetChanged();
        }
    }

    private boolean bbe() {
        return !TextUtils.isEmpty(this.erD);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.erA == null) {
            return 0;
        }
        return (this.erC ? 1 : 0) + this.erA.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.erC || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void bbf() {
        for (c cVar : this.erA) {
            cVar.isSelected = false;
        }
    }
}
