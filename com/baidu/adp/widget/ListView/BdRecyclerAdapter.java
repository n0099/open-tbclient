package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.c.j.e.d;
import d.a.c.j.e.o;
/* loaded from: classes.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements o {

    /* renamed from: e  reason: collision with root package name */
    public Context f2336e;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f2338g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2339h;
    public BdRecyclerView.i j = null;
    public BdRecyclerView.j k = null;

    /* renamed from: f  reason: collision with root package name */
    public d f2337f = new d();

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2340i = new a();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            super.onChanged();
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2339h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onChanged();
            }
            if (BdRecyclerAdapter.this.f2337f.f40332c != null) {
                BdRecyclerAdapter.this.f2337f.f40332c.onPreLoad();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            super.onItemRangeChanged(i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2339h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeChanged(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            super.onItemRangeInserted(i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2339h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeInserted(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            super.onItemRangeMoved(i2, i3, i4);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2339h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeMoved(i2, i3, i4);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            super.onItemRangeRemoved(i2, i3);
            RecyclerView.AdapterDataObserver adapterDataObserver = BdRecyclerAdapter.this.f2339h;
            if (adapterDataObserver != null) {
                adapterDataObserver.onItemRangeRemoved(i2, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2342e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2343f;

        public b(RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f2342e = viewHolder;
            this.f2343f = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BdRecyclerAdapter.this.j != null) {
                int adapterPosition = this.f2342e.getAdapterPosition();
                BdRecyclerAdapter.this.j.b(this.f2343f, this.f2342e.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2345e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2346f;

        public c(RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            this.f2345e = viewHolder;
            this.f2346f = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (BdRecyclerAdapter.this.k != null) {
                int adapterPosition = this.f2345e.getAdapterPosition();
                return BdRecyclerAdapter.this.k.a(this.f2346f, this.f2345e.itemView, BdRecyclerAdapter.this.getItem(adapterPosition), adapterPosition, BdRecyclerAdapter.this.getItemId(adapterPosition));
            }
            return false;
        }
    }

    public BdRecyclerAdapter(Context context) {
        this.f2336e = null;
        this.f2336e = context;
    }

    public void f(View view) {
        g(view, null, true, -1);
    }

    public void g(View view, Object obj, boolean z, int i2) {
        if (view == null) {
            return;
        }
        this.f2337f.a(view, obj, z, true, i2);
        notifyDataSetChanged();
    }

    @Override // d.a.c.j.e.o
    public int getCount() {
        return getItemCount();
    }

    @Override // d.a.c.j.e.o
    public Object getItem(int i2) {
        if (i2 < 0) {
            return null;
        }
        int n = n();
        if (i2 < n) {
            return this.f2337f.f40330a.get(i2).f40336d;
        }
        int i3 = i2 - n;
        int i4 = 0;
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
            RecyclerView.Adapter adapter2 = this.f2338g;
            if (adapter2 instanceof o) {
                return ((o) adapter2).getItem(i3);
            }
        }
        int m = m();
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= m) {
            return null;
        }
        return this.f2337f.f40331b.get(i5).f40336d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int m;
        int n;
        if (this.f2338g != null) {
            m = m() + n();
            n = this.f2338g.getItemCount();
        } else {
            m = m();
            n = n();
        }
        return m + n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        if (i2 < 0) {
            return -1L;
        }
        int n = n();
        if (i2 < n) {
            return this.f2337f.f40330a.get(i2).f40333a;
        }
        int i3 = 0;
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null && i2 >= n) {
            int i4 = i2 - n;
            int itemCount = adapter.getItemCount();
            if (i4 < itemCount) {
                return this.f2338g.getItemId(i4);
            }
            i3 = itemCount;
        }
        int i5 = (i2 - n) - i3;
        if (i5 <= -1 || i5 >= m()) {
            return -1L;
        }
        return this.f2337f.f40331b.get(i5).f40333a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int n = n();
        if (i2 < n) {
            return this.f2337f.f40330a.get(i2).f40334b;
        }
        int i3 = i2 - n;
        int i4 = 0;
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
            return this.f2338g.getItemViewType(i3);
        }
        int m = m();
        int i5 = i3 - i4;
        if (i5 < 0 || i5 >= m) {
            return -1;
        }
        return this.f2337f.f40331b.get(i5).f40334b;
    }

    public void h(View view, int i2) {
        i(view, null, true, true, i2);
    }

    public void i(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        this.f2337f.b(view, obj, z, z2, i2);
        notifyDataSetChanged();
    }

    public final void j(ViewGroup viewGroup, RecyclerView.ViewHolder viewHolder) {
        View view;
        if (viewGroup == null || viewHolder == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setOnClickListener(new b(viewHolder, viewGroup));
        viewHolder.itemView.setOnLongClickListener(new c(viewHolder, viewGroup));
    }

    public d.c k(int i2) {
        return this.f2337f.e(i2);
    }

    public d.c l(int i2) {
        return this.f2337f.g(i2);
    }

    public int m() {
        return this.f2337f.h();
    }

    public int n() {
        return this.f2337f.i();
    }

    public RecyclerView.Adapter o() {
        return this.f2338g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        int i3;
        if (i2 < 0 || getItemViewType(i2) == -1 || (viewHolder instanceof d.b)) {
            return;
        }
        int n = n();
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter == null || i2 < n || (i3 = i2 - n) >= adapter.getItemCount()) {
            return;
        }
        this.f2338g.onBindViewHolder(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        TypeAdapter.ViewHolder viewHolder;
        boolean z;
        RecyclerView.Adapter adapter;
        d.c l = l(i2);
        boolean z2 = true;
        if (l != null) {
            viewHolder = l.f40335c;
            z = l.f40337e;
        } else {
            viewHolder = null;
            z = true;
        }
        if (viewHolder == null) {
            d.c k = k(i2);
            TypeAdapter.ViewHolder viewHolder2 = k != null ? k.f40335c : null;
            if (k != null && !k.f40337e) {
                z2 = false;
            }
            z = z2;
            viewHolder = viewHolder2;
        }
        if (viewHolder == null && (adapter = this.f2338g) != null) {
            viewHolder = adapter.onCreateViewHolder(viewGroup, i2);
        }
        if (viewHolder == null) {
            viewHolder = this.f2337f.c(this.f2336e);
        }
        if (z) {
            j(viewGroup, viewHolder);
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            return adapter.onFailedToRecycleView(viewHolder);
        }
        return super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.onViewRecycled(viewHolder);
        }
    }

    public boolean p(View view) {
        if (this.f2337f.j(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public boolean q(View view) {
        if (this.f2337f.k(view)) {
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

    public void r(RecyclerView.Adapter adapter) {
        this.f2338g = adapter;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.f2339h = adapterDataObserver;
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f2340i);
        }
    }

    public void s(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        int d2 = this.f2337f.d(view);
        if (d2 < 0) {
            this.f2337f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (d2 != i2) {
            this.f2337f.j(view);
            this.f2337f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.setHasStableIds(z);
        }
        super.setHasStableIds(z);
    }

    public void t(View view, Object obj, boolean z, boolean z2, int i2) {
        if (view == null) {
            return;
        }
        int f2 = this.f2337f.f(view);
        if (f2 < 0) {
            this.f2337f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (f2 != i2) {
            this.f2337f.k(view);
            this.f2337f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    public void u(d.a aVar) {
        this.f2337f.l(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.f2339h = adapterDataObserver;
        RecyclerView.Adapter adapter = this.f2338g;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f2340i);
        }
    }

    public void v(BdRecyclerView.i iVar) {
        this.j = iVar;
    }

    public void w(BdRecyclerView.j jVar) {
        this.k = jVar;
    }
}
