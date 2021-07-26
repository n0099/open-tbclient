package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.d;
import d.a.d.k.e.o;
/* loaded from: classes.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f2385e;

    /* renamed from: f  reason: collision with root package name */
    public d f2386f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f2387g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2388h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f2389i;
    public BdRecyclerView.i j;
    public BdRecyclerView.j k;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerAdapter f2390a;

        public a(BdRecyclerAdapter bdRecyclerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2390a = bdRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f2390a.f2388h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onChanged();
                }
                if (this.f2390a.f2386f.f42354c != null) {
                    this.f2390a.f2386f.f42354c.onPreLoad();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                super.onItemRangeChanged(i2, i3);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f2390a.f2388h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeChanged(i2, i3);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                super.onItemRangeInserted(i2, i3);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f2390a.f2388h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeInserted(i2, i3);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
                super.onItemRangeMoved(i2, i3, i4);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f2390a.f2388h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeMoved(i2, i3, i4);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                super.onItemRangeRemoved(i2, i3);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f2390a.f2388h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeRemoved(i2, i3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2392f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerAdapter f2393g;

        public b(BdRecyclerAdapter bdRecyclerAdapter, RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerAdapter, viewHolder, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2393g = bdRecyclerAdapter;
            this.f2391e = viewHolder;
            this.f2392f = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f2393g.j == null) {
                return;
            }
            int adapterPosition = this.f2391e.getAdapterPosition();
            this.f2393g.j.b(this.f2392f, this.f2391e.itemView, this.f2393g.getItem(adapterPosition), adapterPosition, this.f2393g.getItemId(adapterPosition));
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f2394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2395f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerAdapter f2396g;

        public c(BdRecyclerAdapter bdRecyclerAdapter, RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerAdapter, viewHolder, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2396g = bdRecyclerAdapter;
            this.f2394e = viewHolder;
            this.f2395f = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f2396g.k != null) {
                    int adapterPosition = this.f2394e.getAdapterPosition();
                    return this.f2396g.k.a(this.f2395f, this.f2394e.itemView, this.f2396g.getItem(adapterPosition), adapterPosition, this.f2396g.getItemId(adapterPosition));
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public BdRecyclerAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2385e = null;
        this.j = null;
        this.k = null;
        this.f2385e = context;
        this.f2386f = new d();
        this.f2389i = new a(this);
    }

    public void g(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            h(view, null, true, -1);
        }
    }

    @Override // d.a.d.k.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getItemCount() : invokeV.intValue;
    }

    @Override // d.a.d.k.e.o
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 < 0) {
                return null;
            }
            int o = o();
            if (i2 < o) {
                return this.f2386f.f42352a.get(i2).f42358d;
            }
            int i3 = i2 - o;
            int i4 = 0;
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
                RecyclerView.Adapter adapter2 = this.f2387g;
                if (adapter2 instanceof o) {
                    return ((o) adapter2).getItem(i3);
                }
            }
            int n = n();
            int i5 = i3 - i4;
            if (i5 < 0 || i5 >= n) {
                return null;
            }
            return this.f2386f.f42353b.get(i5).f42358d;
        }
        return invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        int n;
        int o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f2387g != null) {
                n = n() + o();
                o = this.f2387g.getItemCount();
            } else {
                n = n();
                o = o();
            }
            return n + o;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 < 0) {
                return -1L;
            }
            int o = o();
            if (i2 < o) {
                return this.f2386f.f42352a.get(i2).f42355a;
            }
            int i3 = 0;
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null && i2 >= o) {
                int i4 = i2 - o;
                int itemCount = adapter.getItemCount();
                if (i4 < itemCount) {
                    return this.f2387g.getItemId(i4);
                }
                i3 = itemCount;
            }
            int i5 = (i2 - o) - i3;
            if (i5 <= -1 || i5 >= n()) {
                return -1L;
            }
            return this.f2386f.f42353b.get(i5).f42355a;
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < 0) {
                return -1;
            }
            int o = o();
            if (i2 < o) {
                return this.f2386f.f42352a.get(i2).f42356b;
            }
            int i3 = i2 - o;
            int i4 = 0;
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
                return this.f2387g.getItemViewType(i3);
            }
            int n = n();
            int i5 = i3 - i4;
            if (i5 < 0 || i5 >= n) {
                return -1;
            }
            return this.f2386f.f42353b.get(i5).f42356b;
        }
        return invokeI.intValue;
    }

    public void h(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        this.f2386f.a(view, obj, z, true, i2);
        notifyDataSetChanged();
    }

    public void i(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view, i2) == null) {
            j(view, null, true, true, i2);
        }
    }

    public void j(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        this.f2386f.b(view, obj, z, z2, i2);
        notifyDataSetChanged();
    }

    public final void k(ViewGroup viewGroup, RecyclerView.ViewHolder viewHolder) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, viewGroup, viewHolder) == null) || viewGroup == null || viewHolder == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setOnClickListener(new b(this, viewHolder, viewGroup));
        viewHolder.itemView.setOnLongClickListener(new c(this, viewHolder, viewGroup));
    }

    public d.c l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f2386f.e(i2) : (d.c) invokeI.objValue;
    }

    public d.c m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.f2386f.g(i2) : (d.c) invokeI.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f2386f.h() : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2386f.i() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, recyclerView) == null) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, viewHolder, i2) == null) || i2 < 0 || getItemViewType(i2) == -1 || (viewHolder instanceof d.b)) {
            return;
        }
        int o = o();
        RecyclerView.Adapter adapter = this.f2387g;
        if (adapter == null || i2 < o || (i3 = i2 - o) >= adapter.getItemCount()) {
            return;
        }
        this.f2387g.onBindViewHolder(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        TypeAdapter.ViewHolder viewHolder;
        boolean z;
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, viewGroup, i2)) == null) {
            d.c m = m(i2);
            boolean z2 = true;
            if (m != null) {
                viewHolder = m.f42357c;
                z = m.f42359e;
            } else {
                viewHolder = null;
                z = true;
            }
            if (viewHolder == null) {
                d.c l = l(i2);
                TypeAdapter.ViewHolder viewHolder2 = l != null ? l.f42357c : null;
                if (l != null && !l.f42359e) {
                    z2 = false;
                }
                z = z2;
                viewHolder = viewHolder2;
            }
            if (viewHolder == null && (adapter = this.f2387g) != null) {
                viewHolder = adapter.onCreateViewHolder(viewGroup, i2);
            }
            if (viewHolder == null) {
                viewHolder = this.f2386f.c(this.f2385e);
            }
            if (z) {
                k(viewGroup, viewHolder);
            }
            return viewHolder;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, viewHolder)) == null) {
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                return adapter.onFailedToRecycleView(viewHolder);
            }
            return super.onFailedToRecycleView(viewHolder);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewHolder) == null) {
            super.onViewAttachedToWindow(viewHolder);
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.onViewAttachedToWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.onViewDetachedFromWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, viewHolder) == null) {
            super.onViewRecycled(viewHolder);
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
        }
    }

    public RecyclerView.Adapter p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f2387g : (RecyclerView.Adapter) invokeV.objValue;
    }

    public boolean q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view)) == null) {
            if (this.f2386f.j(view)) {
                notifyDataSetChanged();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            if (this.f2386f.k(view)) {
                notifyDataSetChanged();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, adapterDataObserver) == null) {
            super.registerAdapterDataObserver(adapterDataObserver);
            this.f2388h = adapterDataObserver;
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f2389i);
            }
        }
    }

    public void s(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, adapter) == null) {
            this.f2387g = adapter;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.setHasStableIds(z);
            }
            super.setHasStableIds(z);
        }
    }

    public void t(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        int d2 = this.f2386f.d(view);
        if (d2 < 0) {
            this.f2386f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (d2 != i2) {
            this.f2386f.j(view);
            this.f2386f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    public void u(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        int f2 = this.f2386f.f(view);
        if (f2 < 0) {
            this.f2386f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (f2 != i2) {
            this.f2386f.k(view);
            this.f2386f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, adapterDataObserver) == null) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
            this.f2388h = adapterDataObserver;
            RecyclerView.Adapter adapter = this.f2387g;
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f2389i);
            }
        }
    }

    public void v(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            this.f2386f.l(aVar);
        }
    }

    public void w(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iVar) == null) {
            this.j = iVar;
        }
    }

    public void x(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jVar) == null) {
            this.k = jVar;
        }
    }
}
