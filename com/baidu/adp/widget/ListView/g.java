package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.d;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements i {
    private RecyclerView.Adapter Mb;
    RecyclerView.AdapterDataObserver Mc;
    private Context mContext;
    private BdRecyclerView.a Me = null;
    private BdRecyclerView.b Mf = null;
    private d Ma = new d();
    RecyclerView.AdapterDataObserver Md = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.g.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (g.this.Mc != null) {
                g.this.Mc.onChanged();
            }
            if (g.this.Ma.LJ != null) {
                g.this.Ma.LJ.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (g.this.Mc != null) {
                g.this.Mc.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (g.this.Mc != null) {
                g.this.Mc.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (g.this.Mc != null) {
                g.this.Mc.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (g.this.Mc != null) {
                g.this.Mc.onItemRangeMoved(i, i2, i3);
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
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Ma.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Mb != null && i2 < (i3 = this.Mb.getItemCount())) {
            return this.Mb.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Ma.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        q.a aL = aL(i);
        if (aL == null) {
            aL = aM(i);
        }
        if (aL == null && this.Mb != null) {
            aL = this.Mb.onCreateViewHolder(viewGroup, i);
        }
        if (aL == null) {
            aL = this.Ma.am(this.mContext);
        }
        a(viewGroup, aL);
        return aL;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof d.b)) {
            int headersCount = getHeadersCount();
            if (this.Mb != null && i >= headersCount && i - headersCount < this.Mb.getItemCount()) {
                this.Mb.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Mb != null ? getFootersCount() + getHeadersCount() + this.Mb.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Mb != null) {
            this.Mb.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public int getCount() {
        return getItemCount();
    }

    @Override // com.baidu.adp.widget.ListView.i
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Ma.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Mb != null && i2 < (i3 = this.Mb.getItemCount()) && (this.Mb instanceof i)) {
            return ((i) this.Mb).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Ma.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Ma.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Mb != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Mb.getItemCount())) {
            return this.Mb.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Ma.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Mb != null) {
            this.Mb.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Mb != null ? this.Mb.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Mb != null) {
            this.Mb.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Mb != null) {
            this.Mb.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Mb != null) {
            this.Mb.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Mb != null) {
            this.Mb.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Mc = adapterDataObserver;
        if (this.Mb != null) {
            this.Mb.registerAdapterDataObserver(this.Md);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Mc = adapterDataObserver;
        if (this.Mb != null) {
            this.Mb.unregisterAdapterDataObserver(this.Md);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Mb = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Mb;
    }

    public void a(d.a aVar) {
        this.Ma.a(aVar);
    }

    public int getHeadersCount() {
        return this.Ma.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Ma.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Ma.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Ma.removeFooter(view)) {
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
            this.Ma.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Ma.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder aL(int i) {
        return this.Ma.aI(i);
    }

    public RecyclerView.ViewHolder aM(int i) {
        return this.Ma.aJ(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.Me != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        g.this.Me.a(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.g.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (g.this.Mf != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return g.this.Mf.b(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Me = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Mf = bVar;
    }
}
