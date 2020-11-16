package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.e;
/* loaded from: classes.dex */
public class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements r {
    private RecyclerView.Adapter Wk;
    RecyclerView.AdapterDataObserver Wl;
    private Context mContext;
    private BdRecyclerView.a Wn = null;
    private BdRecyclerView.b Wo = null;
    private e Wj = new e();
    RecyclerView.AdapterDataObserver Wm = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.h.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (h.this.Wl != null) {
                h.this.Wl.onChanged();
            }
            if (h.this.Wj.VH != null) {
                h.this.Wj.VH.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (h.this.Wl != null) {
                h.this.Wl.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (h.this.Wl != null) {
                h.this.Wl.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (h.this.Wl != null) {
                h.this.Wl.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (h.this.Wl != null) {
                h.this.Wl.onItemRangeMoved(i, i2, i3);
            }
        }
    };

    public h(Context context) {
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
            return this.Wj.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Wk != null && i2 < (i3 = this.Wk.getItemCount())) {
            return this.Wk.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Wj.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean z;
        af.a aVar;
        af.a aVar2;
        boolean z2 = true;
        e.c aP = aP(i);
        if (aP != null) {
            aVar = aP.VJ;
            z = aP.VK;
        } else {
            z = true;
            aVar = null;
        }
        if (aVar == null) {
            e.c aQ = aQ(i);
            af.a aVar3 = aQ != null ? aQ.VJ : null;
            if (aQ != null && !aQ.VK) {
                z2 = false;
            }
            boolean z3 = z2;
            aVar2 = aVar3;
            z = z3;
        } else {
            aVar2 = aVar;
        }
        if (aVar2 == null && this.Wk != null) {
            aVar2 = this.Wk.onCreateViewHolder(viewGroup, i);
        }
        if (aVar2 == null) {
            aVar2 = this.Wj.K(this.mContext);
        }
        if (z) {
            a(viewGroup, aVar2);
        }
        return aVar2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof e.b)) {
            int headersCount = getHeadersCount();
            if (this.Wk != null && i >= headersCount && i - headersCount < this.Wk.getItemCount()) {
                this.Wk.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Wk != null ? getFootersCount() + getHeadersCount() + this.Wk.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Wk != null) {
            this.Wk.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    @Override // com.baidu.adp.widget.ListView.r
    public int getCount() {
        return getItemCount();
    }

    @Override // com.baidu.adp.widget.ListView.r
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Wj.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Wk != null && i2 < (i3 = this.Wk.getItemCount()) && (this.Wk instanceof r)) {
            return ((r) this.Wk).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Wj.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Wj.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Wk != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Wk.getItemCount())) {
            return this.Wk.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Wj.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Wk != null) {
            this.Wk.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Wk != null ? this.Wk.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Wk != null) {
            this.Wk.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Wk != null) {
            this.Wk.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Wk != null) {
            this.Wk.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Wk != null) {
            this.Wk.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Wl = adapterDataObserver;
        if (this.Wk != null) {
            this.Wk.registerAdapterDataObserver(this.Wm);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Wl = adapterDataObserver;
        if (this.Wk != null) {
            this.Wk.unregisterAdapterDataObserver(this.Wm);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Wk = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Wk;
    }

    public void a(e.a aVar) {
        this.Wj.a(aVar);
    }

    public int getHeadersCount() {
        return this.Wj.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Wj.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Wj.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Wj.removeFooter(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void c(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int z3 = this.Wj.z(view);
            if (z3 < 0) {
                this.Wj.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (z3 != i) {
                this.Wj.removeHeader(view);
                this.Wj.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void d(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int A = this.Wj.A(view);
            if (A < 0) {
                this.Wj.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (A != i) {
                this.Wj.removeFooter(view);
                this.Wj.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void addHeaderView(View view, int i) {
        a(view, null, true, true, i);
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            this.Wj.a(view, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Wj.b(view, obj, z, true, i);
            notifyDataSetChanged();
        }
    }

    public e.c aP(int i) {
        return this.Wj.aN(i);
    }

    public e.c aQ(int i) {
        return this.Wj.aO(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.Wn != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        h.this.Wn.a(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.h.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (h.this.Wo != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return h.this.Wo.b(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Wn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Wo = bVar;
    }
}
