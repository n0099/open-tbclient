package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes19.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> dBO;
    private e dBP;
    private boolean dBQ;
    private String dBR;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.dBP = eVar;
        this.dBQ = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.dBP);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aSb());
                return;
            default:
                ((c) viewHolder).a(this.dBO.get(i), this.dBR, aSc());
                return;
        }
    }

    private boolean aSb() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.dBO = list;
            this.dBR = str;
            notifyDataSetChanged();
        }
    }

    private boolean aSc() {
        return !TextUtils.isEmpty(this.dBR);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dBO == null) {
            return 0;
        }
        return (this.dBQ ? 1 : 0) + this.dBO.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.dBQ || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aSd() {
        for (g gVar : this.dBO) {
            gVar.isSelected = false;
        }
    }
}
