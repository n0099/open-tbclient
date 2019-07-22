package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.d;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements n {
    private RecyclerView.Adapter Nt;
    RecyclerView.AdapterDataObserver Nu;
    private Context mContext;
    private BdRecyclerView.a Nw = null;
    private BdRecyclerView.b Nx = null;
    private d Ns = new d();
    RecyclerView.AdapterDataObserver Nv = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.g.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (g.this.Nu != null) {
                g.this.Nu.onChanged();
            }
            if (g.this.Ns.Nb != null) {
                g.this.Ns.Nb.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (g.this.Nu != null) {
                g.this.Nu.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (g.this.Nu != null) {
                g.this.Nu.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (g.this.Nu != null) {
                g.this.Nu.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (g.this.Nu != null) {
                g.this.Nu.onItemRangeMoved(i, i2, i3);
            }
        }
    };

    public g(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0) {
            return -1;
        }
        int od = od();
        if (i < od) {
            return this.Ns.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - od;
        int i3 = 0;
        if (this.Nt != null && i2 < (i3 = this.Nt.getItemCount())) {
            return this.Nt.getItemViewType(i2);
        }
        int oe = oe();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= oe) {
            return -1;
        }
        return this.Ns.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v.a aN = aN(i);
        if (aN == null) {
            aN = aO(i);
        }
        if (aN == null && this.Nt != null) {
            aN = this.Nt.onCreateViewHolder(viewGroup, i);
        }
        if (aN == null) {
            aN = this.Ns.ak(this.mContext);
        }
        a(viewGroup, aN);
        return aN;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof d.b)) {
            int od = od();
            if (this.Nt != null && i >= od && i - od < this.Nt.getItemCount()) {
                this.Nt.onBindViewHolder(viewHolder, i - od);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Nt != null ? oe() + od() + this.Nt.getItemCount() : oe() + od();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Nt != null) {
            this.Nt.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    @Override // com.baidu.adp.widget.ListView.n
    public int getCount() {
        return getItemCount();
    }

    @Override // com.baidu.adp.widget.ListView.n
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int od = od();
        if (i < od) {
            return this.Ns.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - od;
        int i3 = 0;
        if (this.Nt != null && i2 < (i3 = this.Nt.getItemCount()) && (this.Nt instanceof n)) {
            return ((n) this.Nt).getItem(i2);
        }
        int oe = oe();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= oe) {
            return null;
        }
        return this.Ns.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int od = od();
        if (i < od) {
            return this.Ns.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Nt != null && i >= od && (i2 = i - od) < (i3 = this.Nt.getItemCount())) {
            return this.Nt.getItemId(i2);
        }
        int i4 = (i - od) - i3;
        if (i4 <= -1 || i4 >= oe()) {
            return -1L;
        }
        return this.Ns.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Nt != null) {
            this.Nt.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Nt != null ? this.Nt.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Nt != null) {
            this.Nt.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Nt != null) {
            this.Nt.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Nt != null) {
            this.Nt.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Nt != null) {
            this.Nt.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Nu = adapterDataObserver;
        if (this.Nt != null) {
            this.Nt.registerAdapterDataObserver(this.Nv);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Nu = adapterDataObserver;
        if (this.Nt != null) {
            this.Nt.unregisterAdapterDataObserver(this.Nv);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Nt = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Nt;
    }

    public void a(d.a aVar) {
        this.Ns.a(aVar);
    }

    public int od() {
        return this.Ns.od();
    }

    public int oe() {
        return this.Ns.oe();
    }

    public boolean B(View view) {
        if (this.Ns.B(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean C(View view) {
        if (this.Ns.C(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void addHeaderView(View view, int i) {
        addHeaderView(view, null, true, i);
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Ns.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Ns.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder aN(int i) {
        return this.Ns.aK(i);
    }

    public RecyclerView.ViewHolder aO(int i) {
        return this.Ns.aL(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.Nw != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        g.this.Nw.a(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.g.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (g.this.Nx != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return g.this.Nx.b(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Nw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Nx = bVar;
    }
}
