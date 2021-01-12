package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.d;
/* loaded from: classes.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements o {
    private RecyclerView.Adapter Xc;
    RecyclerView.AdapterDataObserver Xe;
    private Context mContext;
    private BdRecyclerView.a Xg = null;
    private BdRecyclerView.b Xh = null;
    private d Xb = new d();
    RecyclerView.AdapterDataObserver Xf = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.BdRecyclerAdapter.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (BdRecyclerAdapter.this.Xe != null) {
                BdRecyclerAdapter.this.Xe.onChanged();
            }
            if (BdRecyclerAdapter.this.Xb.WA != null) {
                BdRecyclerAdapter.this.Xb.WA.onPreLoad();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (BdRecyclerAdapter.this.Xe != null) {
                BdRecyclerAdapter.this.Xe.onItemRangeChanged(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (BdRecyclerAdapter.this.Xe != null) {
                BdRecyclerAdapter.this.Xe.onItemRangeInserted(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (BdRecyclerAdapter.this.Xe != null) {
                BdRecyclerAdapter.this.Xe.onItemRangeRemoved(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (BdRecyclerAdapter.this.Xe != null) {
                BdRecyclerAdapter.this.Xe.onItemRangeMoved(i, i2, i3);
            }
        }
    };

    public BdRecyclerAdapter(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0) {
            return -1;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Xb.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Xc != null && i2 < (i3 = this.Xc.getItemCount())) {
            return this.Xc.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.Xb.mFooterViewInfos.get(i4).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean z;
        TypeAdapter.ViewHolder viewHolder;
        boolean z2 = true;
        d.c aU = aU(i);
        if (aU != null) {
            viewHolder = aU.WC;
            z = aU.WD;
        } else {
            z = true;
            viewHolder = null;
        }
        if (viewHolder == null) {
            d.c aV = aV(i);
            viewHolder = aV != null ? aV.WC : null;
            if (aV != null && !aV.WD) {
                z2 = false;
            }
            z = z2;
        }
        TypeAdapter.ViewHolder onCreateViewHolder = (viewHolder != null || this.Xc == null) ? viewHolder : this.Xc.onCreateViewHolder(viewGroup, i);
        if (onCreateViewHolder == null) {
            onCreateViewHolder = this.Xb.M(this.mContext);
        }
        if (z) {
            a(viewGroup, onCreateViewHolder);
        }
        return onCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof d.b)) {
            int headersCount = getHeadersCount();
            if (this.Xc != null && i >= headersCount && i - headersCount < this.Xc.getItemCount()) {
                this.Xc.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.Xc != null ? getFootersCount() + getHeadersCount() + this.Xc.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.Xc != null) {
            this.Xc.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    @Override // com.baidu.adp.widget.ListView.o
    public int getCount() {
        return getItemCount();
    }

    @Override // com.baidu.adp.widget.ListView.o
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Xb.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.Xc != null && i2 < (i3 = this.Xc.getItemCount()) && (this.Xc instanceof o)) {
            return ((o) this.Xc).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.Xb.mFooterViewInfos.get(i4).data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.Xb.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.Xc != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.Xc.getItemCount())) {
            return this.Xc.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.Xb.mFooterViewInfos.get(i4).id;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.Xc != null) {
            this.Xc.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.Xc != null ? this.Xc.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.Xc != null) {
            this.Xc.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.Xc != null) {
            this.Xc.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.Xc != null) {
            this.Xc.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.Xc != null) {
            this.Xc.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.Xe = adapterDataObserver;
        if (this.Xc != null) {
            this.Xc.registerAdapterDataObserver(this.Xf);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.Xe = adapterDataObserver;
        if (this.Xc != null) {
            this.Xc.unregisterAdapterDataObserver(this.Xf);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.Xc = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.Xc;
    }

    public void a(d.a aVar) {
        this.Xb.a(aVar);
    }

    public int getHeadersCount() {
        return this.Xb.getHeadersCount();
    }

    public int getFootersCount() {
        return this.Xb.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.Xb.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.Xb.removeFooter(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void c(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int z3 = this.Xb.z(view);
            if (z3 < 0) {
                this.Xb.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (z3 != i) {
                this.Xb.removeHeader(view);
                this.Xb.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void d(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int A = this.Xb.A(view);
            if (A < 0) {
                this.Xb.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (A != i) {
                this.Xb.removeFooter(view);
                this.Xb.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void addHeaderView(View view, int i) {
        a(view, null, true, true, i);
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            this.Xb.a(view, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.Xb.b(view, obj, z, true, i);
            notifyDataSetChanged();
        }
    }

    public d.c aU(int i) {
        return this.Xb.aS(i);
    }

    public d.c aV(int i) {
        return this.Xb.aT(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.BdRecyclerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdRecyclerAdapter.this.Xg != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        BdRecyclerAdapter.this.Xg.a(viewGroup, viewHolder.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.BdRecyclerAdapter.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (BdRecyclerAdapter.this.Xh != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return BdRecyclerAdapter.this.Xh.b(viewGroup, viewHolder.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Xg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Xh = bVar;
    }
}
