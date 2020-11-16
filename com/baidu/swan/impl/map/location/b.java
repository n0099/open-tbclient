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
    private List<g> ecA;
    private e ecB;
    private boolean ecC;
    private String ecD;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.ecB = eVar;
        this.ecC = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.ecB);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aZj());
                return;
            default:
                ((c) viewHolder).a(this.ecA.get(i), this.ecD, aZk());
                return;
        }
    }

    private boolean aZj() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        c(list, null);
    }

    public void c(List<g> list, String str) {
        if (list != null) {
            this.ecA = list;
            this.ecD = str;
            notifyDataSetChanged();
        }
    }

    private boolean aZk() {
        return !TextUtils.isEmpty(this.ecD);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ecA == null) {
            return 0;
        }
        return (this.ecC ? 1 : 0) + this.ecA.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.ecC || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aZl() {
        for (g gVar : this.ecA) {
            gVar.isSelected = false;
        }
    }
}
