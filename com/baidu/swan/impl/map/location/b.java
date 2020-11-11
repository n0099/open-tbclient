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
    private List<g> eei;
    private e eej;
    private boolean eek;
    private String eel;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public b(Context context, RecyclerView recyclerView, e eVar, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.eej = eVar;
        this.eek = z;
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
                return new c(LayoutInflater.from(this.mContext).inflate(R.layout.ai_apps_location_item, viewGroup, false), this, this.eej);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((d) viewHolder).setVisibility(aZQ());
                return;
            default:
                ((c) viewHolder).a(this.eei.get(i), this.eel, aZR());
                return;
        }
    }

    private boolean aZQ() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<g> list) {
        c(list, null);
    }

    public void c(List<g> list, String str) {
        if (list != null) {
            this.eei = list;
            this.eel = str;
            notifyDataSetChanged();
        }
    }

    private boolean aZR() {
        return !TextUtils.isEmpty(this.eel);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.eei == null) {
            return 0;
        }
        return (this.eek ? 1 : 0) + this.eei.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.eek || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void aZS() {
        for (g gVar : this.eei) {
            gVar.isSelected = false;
        }
    }
}
