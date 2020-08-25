package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.e;
/* loaded from: classes2.dex */
public class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements r {
    private RecyclerView.Adapter Vv;
    RecyclerView.AdapterDataObserver Vw;
    private Context mContext;
    private BdRecyclerView.a Vy = null;
    private BdRecyclerView.b Vz = null;
    private e Vu = new e();
    RecyclerView.AdapterDataObserver Vx = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.h.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (h.this.Vw != null) {
                h.this.Vw.onChanged();
            }
            if (h.this.Vu.UX != null) {
                h.this.Vu.UX.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (h.this.Vw != null) {
                h.this.Vw.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (h.this.Vw != null) {
                h.this.Vw.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (h.this.Vw != null) {
                h.this.Vw.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (h.this.Vw != null) {
                h.this.Vw.onItemRangeMoved(i, i2, i3);
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
            return this.Vu.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Vv != null && i2 < (i3 = this.Vv.getItemCount())) {
            return this.Vv.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Vu.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        af.a aK = aK(i);
        if (aK == null) {
            aK = aL(i);
        }
        if (aK == null && this.Vv != null) {
            aK = this.Vv.onCreateViewHolder(viewGroup, i);
        }
        if (aK == null) {
            aK = this.Vu.K(this.mContext);
        }
        a(viewGroup, aK);
        return aK;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof e.b)) {
            int headersCount = getHeadersCount();
            if (this.Vv != null && i >= headersCount && i - headersCount < this.Vv.getItemCount()) {
                this.Vv.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Vv != null ? getFootersCount() + getHeadersCount() + this.Vv.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Vv != null) {
            this.Vv.setHasStableIds(z);
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
            return this.Vu.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Vv != null && i2 < (i3 = this.Vv.getItemCount()) && (this.Vv instanceof r)) {
            return ((r) this.Vv).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Vu.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Vu.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Vv != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Vv.getItemCount())) {
            return this.Vv.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Vu.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Vv != null) {
            this.Vv.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Vv != null ? this.Vv.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Vv != null) {
            this.Vv.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Vv != null) {
            this.Vv.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Vv != null) {
            this.Vv.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Vv != null) {
            this.Vv.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Vw = adapterDataObserver;
        if (this.Vv != null) {
            this.Vv.registerAdapterDataObserver(this.Vx);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Vw = adapterDataObserver;
        if (this.Vv != null) {
            this.Vv.unregisterAdapterDataObserver(this.Vx);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Vv = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Vv;
    }

    public void a(e.a aVar) {
        this.Vu.a(aVar);
    }

    public int getHeadersCount() {
        return this.Vu.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Vu.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Vu.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Vu.removeFooter(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void a(View view, Object obj, boolean z, int i) {
        if (view != null) {
            int z2 = this.Vu.z(view);
            if (z2 < 0) {
                this.Vu.addHeaderView(view, obj, z, i);
                notifyDataSetChanged();
            } else if (z2 != i) {
                this.Vu.removeHeader(view);
                this.Vu.addHeaderView(view, obj, z, i);
                notifyDataSetChanged();
            }
        }
    }

    public void b(View view, Object obj, boolean z, int i) {
        if (view != null) {
            int A = this.Vu.A(view);
            if (A < 0) {
                this.Vu.addFooterView(view, obj, z, i);
                notifyDataSetChanged();
            } else if (A != i) {
                this.Vu.removeFooter(view);
                this.Vu.addFooterView(view, obj, z, i);
                notifyDataSetChanged();
            }
        }
    }

    public void addHeaderView(View view, int i) {
        addHeaderView(view, null, true, i);
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Vu.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Vu.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder aK(int i) {
        return this.Vu.aI(i);
    }

    public RecyclerView.ViewHolder aL(int i) {
        return this.Vu.aJ(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.h.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.Vy != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        h.this.Vy.a(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.h.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (h.this.Vz != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return h.this.Vz.b(viewGroup, viewHolder.itemView, h.this.getItem(adapterPosition), adapterPosition, h.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Vy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Vz = bVar;
    }
}
