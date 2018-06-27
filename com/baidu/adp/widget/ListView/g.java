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
    private RecyclerView.Adapter Md;
    RecyclerView.AdapterDataObserver Me;
    private Context mContext;
    private BdRecyclerView.a Mg = null;
    private BdRecyclerView.b Mh = null;
    private d Mc = new d();
    RecyclerView.AdapterDataObserver Mf = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.g.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (g.this.Me != null) {
                g.this.Me.onChanged();
            }
            if (g.this.Mc.LM != null) {
                g.this.Mc.LM.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (g.this.Me != null) {
                g.this.Me.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (g.this.Me != null) {
                g.this.Me.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (g.this.Me != null) {
                g.this.Me.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (g.this.Me != null) {
                g.this.Me.onItemRangeMoved(i, i2, i3);
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
            return this.Mc.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Md != null && i2 < (i3 = this.Md.getItemCount())) {
            return this.Md.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Mc.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        q.a aL = aL(i);
        if (aL == null) {
            aL = aM(i);
        }
        if (aL == null && this.Md != null) {
            aL = this.Md.onCreateViewHolder(viewGroup, i);
        }
        if (aL == null) {
            aL = this.Mc.am(this.mContext);
        }
        a(viewGroup, aL);
        return aL;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof d.b)) {
            int headersCount = getHeadersCount();
            if (this.Md != null && i >= headersCount && i - headersCount < this.Md.getItemCount()) {
                this.Md.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Md != null ? getFootersCount() + getHeadersCount() + this.Md.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Md != null) {
            this.Md.setHasStableIds(z);
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
            return this.Mc.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Md != null && i2 < (i3 = this.Md.getItemCount()) && (this.Md instanceof i)) {
            return ((i) this.Md).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Mc.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Mc.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Md != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Md.getItemCount())) {
            return this.Md.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Mc.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Md != null) {
            this.Md.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Md != null ? this.Md.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Md != null) {
            this.Md.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Md != null) {
            this.Md.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Md != null) {
            this.Md.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Md != null) {
            this.Md.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Me = adapterDataObserver;
        if (this.Md != null) {
            this.Md.registerAdapterDataObserver(this.Mf);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Me = adapterDataObserver;
        if (this.Md != null) {
            this.Md.unregisterAdapterDataObserver(this.Mf);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Md = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Md;
    }

    public void a(d.a aVar) {
        this.Mc.a(aVar);
    }

    public int getHeadersCount() {
        return this.Mc.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Mc.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Mc.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Mc.removeFooter(view)) {
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
            this.Mc.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Mc.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder aL(int i) {
        return this.Mc.aI(i);
    }

    public RecyclerView.ViewHolder aM(int i) {
        return this.Mc.aJ(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.Mg != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        g.this.Mg.a(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.g.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (g.this.Mh != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return g.this.Mh.b(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Mg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Mh = bVar;
    }
}
