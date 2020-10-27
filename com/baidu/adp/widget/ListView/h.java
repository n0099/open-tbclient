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
    private RecyclerView.Adapter Wg;
    RecyclerView.AdapterDataObserver Wh;
    private Context mContext;
    private BdRecyclerView.a Wj = null;
    private BdRecyclerView.b Wk = null;
    private e Wf = new e();
    RecyclerView.AdapterDataObserver Wi = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.h.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (h.this.Wh != null) {
                h.this.Wh.onChanged();
            }
            if (h.this.Wf.VG != null) {
                h.this.Wf.VG.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (h.this.Wh != null) {
                h.this.Wh.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (h.this.Wh != null) {
                h.this.Wh.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (h.this.Wh != null) {
                h.this.Wh.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (h.this.Wh != null) {
                h.this.Wh.onItemRangeMoved(i, i2, i3);
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
            return this.Wf.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Wg != null && i2 < (i3 = this.Wg.getItemCount())) {
            return this.Wg.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Wf.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        af.a aO = aO(i);
        if (aO == null) {
            aO = aP(i);
        }
        if (aO == null && this.Wg != null) {
            aO = this.Wg.onCreateViewHolder(viewGroup, i);
        }
        if (aO == null) {
            aO = this.Wf.K(this.mContext);
        }
        a(viewGroup, aO);
        return aO;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof e.b)) {
            int headersCount = getHeadersCount();
            if (this.Wg != null && i >= headersCount && i - headersCount < this.Wg.getItemCount()) {
                this.Wg.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Wg != null ? getFootersCount() + getHeadersCount() + this.Wg.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Wg != null) {
            this.Wg.setHasStableIds(z);
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
            return this.Wf.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Wg != null && i2 < (i3 = this.Wg.getItemCount()) && (this.Wg instanceof r)) {
            return ((r) this.Wg).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Wf.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Wf.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Wg != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Wg.getItemCount())) {
            return this.Wg.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Wf.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Wg != null) {
            this.Wg.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Wg != null ? this.Wg.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Wg != null) {
            this.Wg.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Wg != null) {
            this.Wg.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Wg != null) {
            this.Wg.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Wg != null) {
            this.Wg.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Wh = adapterDataObserver;
        if (this.Wg != null) {
            this.Wg.registerAdapterDataObserver(this.Wi);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Wh = adapterDataObserver;
        if (this.Wg != null) {
            this.Wg.unregisterAdapterDataObserver(this.Wi);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Wg = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Wg;
    }

    public void a(e.a aVar) {
        this.Wf.a(aVar);
    }

    public int getHeadersCount() {
        return this.Wf.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Wf.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Wf.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Wf.removeFooter(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void a(View view, Object obj, boolean z, int i) {
        if (view != null) {
            int z2 = this.Wf.z(view);
            if (z2 < 0) {
                this.Wf.addHeaderView(view, obj, z, i);
                notifyDataSetChanged();
            } else if (z2 != i) {
                this.Wf.removeHeader(view);
                this.Wf.addHeaderView(view, obj, z, i);
                notifyDataSetChanged();
            }
        }
    }

    public void b(View view, Object obj, boolean z, int i) {
        if (view != null) {
            int A = this.Wf.A(view);
            if (A < 0) {
                this.Wf.addFooterView(view, obj, z, i);
                notifyDataSetChanged();
            } else if (A != i) {
                this.Wf.removeFooter(view);
                this.Wf.addFooterView(view, obj, z, i);
                notifyDataSetChanged();
            }
        }
    }

    public void addHeaderView(View view, int i) {
        addHeaderView(view, null, true, i);
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Wf.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Wf.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder aO(int i) {
        return this.Wf.aM(i);
    }

    public RecyclerView.ViewHolder aP(int i) {
        return this.Wf.aN(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.Wj != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        h.this.Wj.a(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.h.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (h.this.Wk != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return h.this.Wk.b(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Wj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Wk = bVar;
    }
}
