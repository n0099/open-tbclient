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
    private List<g> cxe;
    private e cxf;
    private boolean cxg;
    private String cxh;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.cxf = eVar;
        this.cxg = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.cxf);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(asl());
                return;
            default:
                ((c) viewHolder).a(this.cxe.get(i), this.cxh, asn());
                return;
        }
    }

    private boolean asl() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.cxe = list;
            this.cxh = str;
            notifyDataSetChanged();
        }
    }

    private boolean asn() {
        return !TextUtils.isEmpty(this.cxh);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cxe == null) {
            return 0;
        }
        return (this.cxg ? 1 : 0) + this.cxe.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.cxg || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aso() {
        for (g gVar : this.cxe) {
            gVar.isSelected = false;
        }
    }
}
