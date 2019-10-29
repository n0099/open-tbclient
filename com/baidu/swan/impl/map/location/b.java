package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<g> bIf;
    private e bIg;
    private boolean bIh;
    private String bIi;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.bIg = eVar;
        this.bIh = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.bIg);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).dt(ZS());
                return;
            default:
                ((c) viewHolder).a(this.bIf.get(i), this.bIi, ZT());
                return;
        }
    }

    private boolean ZS() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        b(list, null);
    }

    public void b(List<g> list, String str) {
        if (list != null) {
            this.bIf = list;
            this.bIi = str;
            notifyDataSetChanged();
        }
    }

    private boolean ZT() {
        return !TextUtils.isEmpty(this.bIi);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bIf == null) {
            return 0;
        }
        return (this.bIh ? 1 : 0) + this.bIf.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.bIh || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void ZU() {
        for (g gVar : this.bIf) {
            gVar.isSelected = false;
        }
    }
}
