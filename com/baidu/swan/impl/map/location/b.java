package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> csP;
    private e csQ;
    private boolean csR;
    private String csS;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.csQ = eVar;
        this.csR = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.csQ);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(apT());
                return;
            default:
                ((c) viewHolder).a(this.csP.get(i), this.csS, apU());
                return;
        }
    }

    private boolean apT() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.csP = list;
            this.csS = str;
            notifyDataSetChanged();
        }
    }

    private boolean apU() {
        return !TextUtils.isEmpty(this.csS);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.csP == null) {
            return 0;
        }
        return (this.csR ? 1 : 0) + this.csP.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.csR || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void apV() {
        for (g gVar : this.csP) {
            gVar.isSelected = false;
        }
    }
}
