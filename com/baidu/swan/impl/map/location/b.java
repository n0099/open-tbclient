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
    private List<g> cwR;
    private e cwS;
    private boolean cwT;
    private String cwU;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.cwS = eVar;
        this.cwT = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.cwS);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(asg());
                return;
            default:
                ((c) viewHolder).a(this.cwR.get(i), this.cwU, ash());
                return;
        }
    }

    private boolean asg() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.cwR = list;
            this.cwU = str;
            notifyDataSetChanged();
        }
    }

    private boolean ash() {
        return !TextUtils.isEmpty(this.cwU);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cwR == null) {
            return 0;
        }
        return (this.cwT ? 1 : 0) + this.cwR.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.cwT || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void asi() {
        for (g gVar : this.cwR) {
            gVar.isSelected = false;
        }
    }
}
