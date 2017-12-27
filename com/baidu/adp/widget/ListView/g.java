package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.d;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.r;
/* loaded from: classes.dex */
public class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements j {
    private RecyclerView.Adapter avu;
    RecyclerView.AdapterDataObserver avv;
    private Context mContext;
    private h.a avx = null;
    private h.b avy = null;
    private d avt = new d();
    RecyclerView.AdapterDataObserver avw = new RecyclerView.AdapterDataObserver() { // from class: com.baidu.adp.widget.ListView.g.1
        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            if (g.this.avv != null) {
                g.this.avv.onChanged();
            }
            if (g.this.avt.ave != null) {
                g.this.avt.ave.onPreLoad();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            if (g.this.avv != null) {
                g.this.avv.onItemRangeChanged(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            if (g.this.avv != null) {
                g.this.avv.onItemRangeInserted(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            if (g.this.avv != null) {
                g.this.avv.onItemRangeRemoved(i, i2);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            if (g.this.avv != null) {
                g.this.avv.onItemRangeMoved(i, i2, i3);
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
            return this.avt.mHeaderViewInfos.get(i).type;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.avu != null && i2 < (i3 = this.avu.getItemCount())) {
            return this.avu.getItemViewType(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return -1;
        }
        return this.avt.mFooterViewInfos.get(i4).type;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        r.a dI = dI(i);
        if (dI == null) {
            dI = dJ(i);
        }
        if (dI == null && this.avu != null) {
            dI = this.avu.onCreateViewHolder(viewGroup, i);
        }
        if (dI == null) {
            dI = this.avt.at(this.mContext);
        }
        a(viewGroup, dI);
        return dI;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i >= 0 && getItemViewType(i) != -1 && !(viewHolder instanceof d.b)) {
            int headersCount = getHeadersCount();
            if (this.avu != null && i >= headersCount && i - headersCount < this.avu.getItemCount()) {
                this.avu.onBindViewHolder(viewHolder, i - headersCount);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.avu != null ? getFootersCount() + getHeadersCount() + this.avu.getItemCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        if (this.avu != null) {
            this.avu.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    @Override // com.baidu.adp.widget.ListView.j
    public int getCount() {
        return getItemCount();
    }

    @Override // com.baidu.adp.widget.ListView.j
    public Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.avt.mHeaderViewInfos.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.avu != null && i2 < (i3 = this.avu.getItemCount()) && (this.avu instanceof j)) {
            return ((j) this.avu).getItem(i2);
        }
        int footersCount = getFootersCount();
        int i4 = i2 - i3;
        if (i4 < 0 || i4 >= footersCount) {
            return null;
        }
        return this.avt.mFooterViewInfos.get(i4).data;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        if (i < 0) {
            return -1L;
        }
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.avt.mHeaderViewInfos.get(i).id;
        }
        int i3 = 0;
        if (this.avu != null && i >= headersCount && (i2 = i - headersCount) < (i3 = this.avu.getItemCount())) {
            return this.avu.getItemId(i2);
        }
        int i4 = (i - headersCount) - i3;
        if (i4 <= -1 || i4 >= getFootersCount()) {
            return -1L;
        }
        return this.avt.mFooterViewInfos.get(i4).id;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (this.avu != null) {
            this.avu.onViewRecycled(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return this.avu != null ? this.avu.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (this.avu != null) {
            this.avu.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (this.avu != null) {
            this.avu.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.avu != null) {
            this.avu.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.avu != null) {
            this.avu.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.avv = adapterDataObserver;
        if (this.avu != null) {
            this.avu.registerAdapterDataObserver(this.avw);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.avv = adapterDataObserver;
        if (this.avu != null) {
            this.avu.unregisterAdapterDataObserver(this.avw);
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.avu = adapter;
        notifyDataSetChanged();
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        return this.avu;
    }

    public void a(d.a aVar) {
        this.avt.a(aVar);
    }

    public int getHeadersCount() {
        return this.avt.getHeadersCount();
    }

    public int getFootersCount() {
        return this.avt.getFootersCount();
    }

    public boolean removeHeader(View view) {
        if (this.avt.removeHeader(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean removeFooter(View view) {
        if (this.avt.removeFooter(view)) {
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
            this.avt.addHeaderView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            this.avt.addFooterView(view, obj, z, i);
            notifyDataSetChanged();
        }
    }

    public RecyclerView.ViewHolder dI(int i) {
        return this.avt.dF(i);
    }

    public RecyclerView.ViewHolder dJ(int i) {
        return this.avt.dG(i);
    }

    private void a(final ViewGroup viewGroup, final RecyclerView.ViewHolder viewHolder) {
        if (viewGroup != null && viewHolder != null && viewHolder.itemView != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.adp.widget.ListView.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.avx != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        g.this.avx.a(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.adp.widget.ListView.g.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (g.this.avy != null) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        return g.this.avy.b(viewGroup, viewHolder.itemView, g.this.getItem(adapterPosition), adapterPosition, g.this.getItemId(adapterPosition));
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemClickListener(h.a aVar) {
        this.avx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(h.b bVar) {
        this.avy = bVar;
    }
}
