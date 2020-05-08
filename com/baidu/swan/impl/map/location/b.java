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
    private List<g> cWf;
    private e cWg;
    private boolean cWh;
    private String cWi;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.cWg = eVar;
        this.cWh = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.cWg);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aAw());
                return;
            default:
                ((c) viewHolder).a(this.cWf.get(i), this.cWi, aAx());
                return;
        }
    }

    private boolean aAw() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.cWf = list;
            this.cWi = str;
            notifyDataSetChanged();
        }
    }

    private boolean aAx() {
        return !TextUtils.isEmpty(this.cWi);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cWf == null) {
            return 0;
        }
        return (this.cWh ? 1 : 0) + this.cWf.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.cWh || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aAy() {
        for (g gVar : this.cWf) {
            gVar.isSelected = false;
        }
    }
}
