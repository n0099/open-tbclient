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
    private List<c> epY;
    private b epZ;
    private boolean eqa;
    private String eqb;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.epZ = bVar;
        this.eqa = z;
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
                return new LocationDetailViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.epZ);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((LocationFooterViewHolder) viewHolder).iv(bba());
                return;
            default:
                ((LocationDetailViewHolder) viewHolder).a(this.epY.get(i), this.eqb, bbb());
                return;
        }
    }

    private boolean bba() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<c> list) {
        setData(list, null);
    }

    public void setData(List<c> list, String str) {
        if (list != null) {
            this.epY = list;
            this.eqb = str;
            notifyDataSetChanged();
        }
    }

    private boolean bbb() {
        return !TextUtils.isEmpty(this.eqb);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.epY == null) {
            return 0;
        }
        return (this.eqa ? 1 : 0) + this.epY.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.eqa || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void bbc() {
        for (c cVar : this.epY) {
            cVar.isSelected = false;
        }
    }
}
