package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes25.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> dYr;
    private e dYs;
    private boolean dYt;
    private String dYu;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.dYs = eVar;
        this.dYt = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.dYs);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aXq());
                return;
            default:
                ((c) viewHolder).a(this.dYr.get(i), this.dYu, aXr());
                return;
        }
    }

    private boolean aXq() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        c(list, null);
    }

    public void c(List<g> list, String str) {
        if (list != null) {
            this.dYr = list;
            this.dYu = str;
            notifyDataSetChanged();
        }
    }

    private boolean aXr() {
        return !TextUtils.isEmpty(this.dYu);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dYr == null) {
            return 0;
        }
        return (this.dYt ? 1 : 0) + this.dYr.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.dYt || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aXs() {
        for (g gVar : this.dYr) {
            gVar.isSelected = false;
        }
    }
}
