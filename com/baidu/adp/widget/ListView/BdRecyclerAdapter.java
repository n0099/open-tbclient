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
    private RecyclerView.Adapter WY;
    RecyclerView.AdapterDataObserver WZ;
    private Context mContext;
    private BdRecyclerView.a Xb = null;
    private BdRecyclerView.b Xc = null;
    private d WX = new d();
    RecyclerView.AdapterDataObserver Xa = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.BdRecyclerAdapter.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (BdRecyclerAdapter.this.WZ != null) {
                BdRecyclerAdapter.this.WZ.onChanged();
            }
            if (BdRecyclerAdapter.this.WX.Ww != null) {
                BdRecyclerAdapter.this.WX.Ww.onPreLoad();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (BdRecyclerAdapter.this.WZ != null) {
                BdRecyclerAdapter.this.WZ.onItemRangeChanged(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (BdRecyclerAdapter.this.WZ != null) {
                BdRecyclerAdapter.this.WZ.onItemRangeInserted(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (BdRecyclerAdapter.this.WZ != null) {
                BdRecyclerAdapter.this.WZ.onItemRangeRemoved(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (BdRecyclerAdapter.this.WZ != null) {
                BdRecyclerAdapter.this.WZ.onItemRangeMoved(i, i2, i3);
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
            return this.WX.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.WY != null && i2 < (i3 = this.WY.getItemCount())) {
            return this.WY.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.WX.mFooterViewInfos.get(i4).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean z;
        TypeAdapter.ViewHolder viewHolder;
        boolean z2 = true;
        d.c aU = aU(i);
        if (aU != null) {
            viewHolder = aU.Wy;
            z = aU.Wz;
        } else {
            z = true;
            viewHolder = null;
        }
        if (viewHolder == null) {
            d.c aV = aV(i);
            viewHolder = aV != null ? aV.Wy : null;
            if (aV != null && !aV.Wz) {
                z2 = false;
            }
            z = z2;
        }
        TypeAdapter.ViewHolder onCreateViewHolder = (viewHolder != null || this.WY == null) ? viewHolder : this.WY.onCreateViewHolder(viewGroup, i);
        if (onCreateViewHolder == null) {
            onCreateViewHolder = this.WX.M(this.mContext);
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
            if (this.WY != null && i >= headersCount && i - headersCount < this.WY.getItemCount()) {
                this.WY.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.WY != null ? getFootersCount() + getHeadersCount() + this.WY.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.WY != null) {
            this.WY.setHasStableIds(z);
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
            return this.WX.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.WY != null && i2 < (i3 = this.WY.getItemCount()) && (this.WY instanceof o)) {
            return ((o) this.WY).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.WX.mFooterViewInfos.get(i4).data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.WX.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.WY != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.WY.getItemCount())) {
            return this.WY.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.WX.mFooterViewInfos.get(i4).id;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.WY != null) {
            this.WY.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.WY != null ? this.WY.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.WY != null) {
            this.WY.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.WY != null) {
            this.WY.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.WY != null) {
            this.WY.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.WY != null) {
            this.WY.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.WZ = adapterDataObserver;
        if (this.WY != null) {
            this.WY.registerAdapterDataObserver(this.Xa);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.WZ = adapterDataObserver;
        if (this.WY != null) {
            this.WY.unregisterAdapterDataObserver(this.Xa);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.WY = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.WY;
    }

    public void a(d.a aVar) {
        this.WX.a(aVar);
    }

    public int getHeadersCount() {
        return this.WX.getHeadersCount();
    }

    public int getFootersCount() {
        return this.WX.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.WX.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.WX.removeFooter(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void c(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int z3 = this.WX.z(view);
            if (z3 < 0) {
                this.WX.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (z3 != i) {
                this.WX.removeHeader(view);
                this.WX.a(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void d(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            int A = this.WX.A(view);
            if (A < 0) {
                this.WX.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            } else if (A != i) {
                this.WX.removeFooter(view);
                this.WX.b(view, obj, z, z2, i);
                notifyDataSetChanged();
            }
        }
    }

    public void addHeaderView(View view, int i) {
        a(view, null, true, true, i);
    }

    public void a(View view, Object obj, boolean z, boolean z2, int i) {
        if (view != null) {
            this.WX.a(view, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true, -1);
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.WX.b(view, obj, z, true, i);
            notifyDataSetChanged();
        }
    }

    public d.c aU(int i) {
        return this.WX.aS(i);
    }

    public d.c aV(int i) {
        return this.WX.aT(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.BdRecyclerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BdRecyclerAdapter.this.Xb != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        BdRecyclerAdapter.this.Xb.a(viewGroup, viewHolder.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.BdRecyclerAdapter.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (BdRecyclerAdapter.this.Xc != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return BdRecyclerAdapter.this.Xc.b(viewGroup, viewHolder.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(BdRecyclerView.a aVar) {
        this.Xb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(BdRecyclerView.b bVar) {
        this.Xc = bVar;
    }
}
