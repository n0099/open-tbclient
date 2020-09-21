package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes24.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> dDT;
    private e dDU;
    private boolean dDV;
    private String dDW;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.dDU = eVar;
        this.dDV = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.dDU);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aSN());
                return;
            default:
                ((c) viewHolder).a(this.dDT.get(i), this.dDW, aSO());
                return;
        }
    }

    private boolean aSN() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.dDT = list;
            this.dDW = str;
            notifyDataSetChanged();
        }
    }

    private boolean aSO() {
        return !TextUtils.isEmpty(this.dDW);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dDT == null) {
            return 0;
        }
        return (this.dDV ? 1 : 0) + this.dDT.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.dDV || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aSP() {
        for (g gVar : this.dDT) {
            gVar.isSelected = false;
        }
    }
}
