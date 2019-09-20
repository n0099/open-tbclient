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
    private RecyclerView.Adapter Nu;
    RecyclerView.AdapterDataObserver Nv;
    private Context mContext;
    private BdRecyclerView.a Nx = null;
    private BdRecyclerView.b Ny = null;
    private d Nt = new d();
    RecyclerView.AdapterDataObserver Nw = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.g.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (g.this.Nv != null) {
                g.this.Nv.onChanged();
            }
            if (g.this.Nt.Nc != null) {
                g.this.Nt.Nc.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (g.this.Nv != null) {
                g.this.Nv.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (g.this.Nv != null) {
                g.this.Nv.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (g.this.Nv != null) {
                g.this.Nv.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (g.this.Nv != null) {
                g.this.Nv.onItemRangeMoved(i, i2, i3);
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
        int oe = oe();
        if (i < oe) {
            return this.Nt.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - oe;
        int i3 = 0;
        if (this.Nu != null && i2 < (i3 = this.Nu.getItemCount())) {
            return this.Nu.getItemViewType(i2);
        }
        int og = og();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= og) {
            return -1;
        }
        return this.Nt.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v.a aN = aN(i);
        if (aN == null) {
            aN = aO(i);
        }
        if (aN == null && this.Nu != null) {
            aN = this.Nu.onCreateViewHolder(viewGroup, i);
        }
        if (aN == null) {
            aN = this.Nt.ak(this.mContext);
        }
        a(viewGroup, aN);
        return aN;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof d.b)) {
            int oe = oe();
            if (this.Nu != null && i >= oe && i - oe < this.Nu.getItemCount()) {
                this.Nu.onBindViewHolder(viewHolder, i - oe);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Nu != null ? og() + oe() + this.Nu.getItemCount() : og() + oe();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Nu != null) {
            this.Nu.setHasStableIds(z);
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
        int oe = oe();
        if (i < oe) {
            return this.Nt.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - oe;
        int i3 = 0;
        if (this.Nu != null && i2 < (i3 = this.Nu.getItemCount()) && (this.Nu instanceof n)) {
            return ((n) this.Nu).getItem(i2);
        }
        int og = og();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= og) {
            return null;
        }
        return this.Nt.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int oe = oe();
        if (i < oe) {
            return this.Nt.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Nu != null && i >= oe && (i2 = i - oe) < (i3 = this.Nu.getItemCount())) {
            return this.Nu.getItemId(i2);
        }
        int i4 = (i - oe) - i3;
        if (i4 <= -1 || i4 >= og()) {
            return -1L;
        }
        return this.Nt.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Nu != null) {
            this.Nu.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Nu != null ? this.Nu.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Nu != null) {
            this.Nu.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Nu != null) {
            this.Nu.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Nu != null) {
            this.Nu.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Nu != null) {
            this.Nu.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Nv = adapterDataObserver;
        if (this.Nu != null) {
            this.Nu.registerAdapterDataObserver(this.Nw);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Nv = adapterDataObserver;
        if (this.Nu != null) {
            this.Nu.unregisterAdapterDataObserver(this.Nw);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Nu = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Nu;
    }

    public void a(d.a aVar) {
        this.Nt.a(aVar);
    }

    public int oe() {
        return this.Nt.oe();
    }

    public int og() {
        return this.Nt.og();
    }

    public boolean B(View view) {
        if (this.Nt.B(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean C(View view) {
        if (this.Nt.C(view)) {
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
            this.Nt.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Nt.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder aN(int i) {
        return this.Nt.aK(i);
    }

    public RecyclerView.ViewHolder aO(int i) {
        return this.Nt.aL(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.Nx != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        g.this.Nx.a(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.g.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (g.this.Ny != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return g.this.Ny.b(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Nx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Ny = bVar;
    }
}
