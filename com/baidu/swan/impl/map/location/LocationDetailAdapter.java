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
    private List<c> enR;
    private b enS;
    private boolean enT;
    private String enU;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.enS = bVar;
        this.enT = z;
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
                return new LocationDetailViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.enS);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((LocationFooterViewHolder) viewHolder).it(baN());
                return;
            default:
                ((LocationDetailViewHolder) viewHolder).a(this.enR.get(i), this.enU, baO());
                return;
        }
    }

    private boolean baN() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<c> list) {
        c(list, null);
    }

    public void c(List<c> list, String str) {
        if (list != null) {
            this.enR = list;
            this.enU = str;
            notifyDataSetChanged();
        }
    }

    private boolean baO() {
        return !TextUtils.isEmpty(this.enU);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.enR == null) {
            return 0;
        }
        return (this.enT ? 1 : 0) + this.enR.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.enT || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void baP() {
        for (c cVar : this.enR) {
            cVar.isSelected = false;
        }
    }
}
