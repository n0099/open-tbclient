package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> bhZ;
    private e bia;
    private boolean bib;
    private String bic;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.bia = eVar;
        this.bib = z;
    }

    public b(Context context, RecyclerView recyclerView, e eVar) {
        this(context, recyclerView, eVar, true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 101:
                return new d(LayoutInflater.from(this.mContext).inflate(d.h.ai_apps_location_footer, viewGroup, false));
            default:
                return new c(LayoutInflater.from(this.mContext).inflate(d.h.ai_apps_location_item, viewGroup, false), this, this.bia);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).cI(Qx());
                return;
            default:
                ((c) viewHolder).a(this.bhZ.get(i), this.bic, Qy());
                return;
        }
    }

    private boolean Qx() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.bhZ = list;
            this.bic = str;
            notifyDataSetChanged();
        }
    }

    private boolean Qy() {
        return !TextUtils.isEmpty(this.bic);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bhZ == null) {
            return 0;
        }
        return (this.bib ? 1 : 0) + this.bhZ.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.bib || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void Qz() {
        for (g gVar : this.bhZ) {
            gVar.isSelected = false;
        }
    }
}
