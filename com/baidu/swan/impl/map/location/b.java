package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes12.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> dlS;
    private e dlT;
    private boolean dlU;
    private String dlV;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.dlT = eVar;
        this.dlU = z;
    }

    public b(Context context, RecyclerView recyclerView, e eVar) {
        this(context, recyclerView, eVar, true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 101:
                return new d(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_footer, viewGroup, false));
            default:
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.dlT);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aFu());
                return;
            default:
                ((c) viewHolder).a(this.dlS.get(i), this.dlV, aFv());
                return;
        }
    }

    private boolean aFu() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.dlS = list;
            this.dlV = str;
            notifyDataSetChanged();
        }
    }

    private boolean aFv() {
        return !TextUtils.isEmpty(this.dlV);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dlS == null) {
            return 0;
        }
        return (this.dlU ? 1 : 0) + this.dlS.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.dlU || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aFw() {
        for (g gVar : this.dlS) {
            gVar.isSelected = false;
        }
    }
}
