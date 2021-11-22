package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.m.e.d;
import b.a.e.m.e.o;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35419e;

    /* renamed from: f  reason: collision with root package name */
    public d f35420f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f35421g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f35422h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f35423i;
    public BdRecyclerView.i j;
    public BdRecyclerView.j k;

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerAdapter f35424a;

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
            this.f35424a = bdRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f35424a.f35422h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onChanged();
                }
                if (this.f35424a.f35420f.f2434c != null) {
                    this.f35424a.f35420f.f2434c.onPreLoad();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                super.onItemRangeChanged(i2, i3);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f35424a.f35422h;
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
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f35424a.f35422h;
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
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f35424a.f35422h;
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
                RecyclerView.AdapterDataObserver adapterDataObserver = this.f35424a.f35422h;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeRemoved(i2, i3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f35425e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f35426f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerAdapter f35427g;

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
            this.f35427g = bdRecyclerAdapter;
            this.f35425e = viewHolder;
            this.f35426f = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f35427g.j == null) {
                return;
            }
            int adapterPosition = this.f35425e.getAdapterPosition();
            this.f35427g.j.b(this.f35426f, this.f35425e.itemView, this.f35427g.getItem(adapterPosition), adapterPosition, this.f35427g.getItemId(adapterPosition));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f35428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f35429f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdRecyclerAdapter f35430g;

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
            this.f35430g = bdRecyclerAdapter;
            this.f35428e = viewHolder;
            this.f35429f = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f35430g.k != null) {
                    int adapterPosition = this.f35428e.getAdapterPosition();
                    return this.f35430g.k.a(this.f35429f, this.f35428e.itemView, this.f35430g.getItem(adapterPosition), adapterPosition, this.f35430g.getItemId(adapterPosition));
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
        this.f35419e = null;
        this.j = null;
        this.k = null;
        this.f35419e = context;
        this.f35420f = new d();
        this.f35423i = new a(this);
    }

    public void addFooterView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            addFooterView(view, null, true, -1);
        }
    }

    public void addHeaderView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            addHeaderView(view, null, true, true, -1);
        }
    }

    public final void d(ViewGroup viewGroup, RecyclerView.ViewHolder viewHolder) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, viewGroup, viewHolder) == null) || viewGroup == null || viewHolder == null || (view = viewHolder.itemView) == null) {
            return;
        }
        view.setOnClickListener(new b(this, viewHolder, viewGroup));
        viewHolder.itemView.setOnLongClickListener(new c(this, viewHolder, viewGroup));
    }

    public d.c findFooterViewByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f35420f.e(i2) : (d.c) invokeI.objValue;
    }

    public d.c findHeaderViewByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f35420f.g(i2) : (d.c) invokeI.objValue;
    }

    @Override // b.a.e.m.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getItemCount() : invokeV.intValue;
    }

    public int getFootersCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35420f.h() : invokeV.intValue;
    }

    public int getHeadersCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35420f.i() : invokeV.intValue;
    }

    @Override // b.a.e.m.e.o
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 < 0) {
                return null;
            }
            int headersCount = getHeadersCount();
            if (i2 < headersCount) {
                return this.f35420f.f2432a.get(i2).f2438d;
            }
            int i3 = i2 - headersCount;
            int i4 = 0;
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
                RecyclerView.Adapter adapter2 = this.f35421g;
                if (adapter2 instanceof o) {
                    return ((o) adapter2).getItem(i3);
                }
            }
            int footersCount = getFootersCount();
            int i5 = i3 - i4;
            if (i5 < 0 || i5 >= footersCount) {
                return null;
            }
            return this.f35420f.f2433b.get(i5).f2438d;
        }
        return invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        int footersCount;
        int headersCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f35421g != null) {
                footersCount = getFootersCount() + getHeadersCount();
                headersCount = this.f35421g.getItemCount();
            } else {
                footersCount = getFootersCount();
                headersCount = getHeadersCount();
            }
            return footersCount + headersCount;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (i2 < 0) {
                return -1L;
            }
            int headersCount = getHeadersCount();
            if (i2 < headersCount) {
                return this.f35420f.f2432a.get(i2).f2435a;
            }
            int i3 = 0;
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null && i2 >= headersCount) {
                int i4 = i2 - headersCount;
                int itemCount = adapter.getItemCount();
                if (i4 < itemCount) {
                    return this.f35421g.getItemId(i4);
                }
                i3 = itemCount;
            }
            int i5 = (i2 - headersCount) - i3;
            if (i5 <= -1 || i5 >= getFootersCount()) {
                return -1L;
            }
            return this.f35420f.f2433b.get(i5).f2435a;
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 < 0) {
                return -1;
            }
            int headersCount = getHeadersCount();
            if (i2 < headersCount) {
                return this.f35420f.f2432a.get(i2).f2436b;
            }
            int i3 = i2 - headersCount;
            int i4 = 0;
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null && i3 < (i4 = adapter.getItemCount())) {
                return this.f35421g.getItemViewType(i3);
            }
            int footersCount = getFootersCount();
            int i5 = i3 - i4;
            if (i5 < 0 || i5 >= footersCount) {
                return -1;
            }
            return this.f35420f.f2433b.get(i5).f2436b;
        }
        return invokeI.intValue;
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f35421g : (RecyclerView.Adapter) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, recyclerView) == null) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, viewHolder, i2) == null) || i2 < 0 || getItemViewType(i2) == -1 || (viewHolder instanceof d.b)) {
            return;
        }
        int headersCount = getHeadersCount();
        RecyclerView.Adapter adapter = this.f35421g;
        if (adapter == null || i2 < headersCount || (i3 = i2 - headersCount) >= adapter.getItemCount()) {
            return;
        }
        this.f35421g.onBindViewHolder(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        TypeAdapter.ViewHolder viewHolder;
        boolean z;
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, viewGroup, i2)) == null) {
            d.c findHeaderViewByType = findHeaderViewByType(i2);
            boolean z2 = true;
            if (findHeaderViewByType != null) {
                viewHolder = findHeaderViewByType.f2437c;
                z = findHeaderViewByType.f2439e;
            } else {
                viewHolder = null;
                z = true;
            }
            if (viewHolder == null) {
                d.c findFooterViewByType = findFooterViewByType(i2);
                TypeAdapter.ViewHolder viewHolder2 = findFooterViewByType != null ? findFooterViewByType.f2437c : null;
                if (findFooterViewByType != null && !findFooterViewByType.f2439e) {
                    z2 = false;
                }
                z = z2;
                viewHolder = viewHolder2;
            }
            if (viewHolder == null && (adapter = this.f35421g) != null) {
                viewHolder = adapter.onCreateViewHolder(viewGroup, i2);
            }
            if (viewHolder == null) {
                viewHolder = this.f35420f.c(this.f35419e);
            }
            if (z) {
                d(viewGroup, viewHolder);
            }
            return viewHolder;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, viewHolder)) == null) {
            RecyclerView.Adapter adapter = this.f35421g;
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
        if (interceptable == null || interceptable.invokeL(1048598, this, viewHolder) == null) {
            super.onViewAttachedToWindow(viewHolder);
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.onViewAttachedToWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.onViewDetachedFromWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, viewHolder) == null) {
            super.onViewRecycled(viewHolder);
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, adapterDataObserver) == null) {
            super.registerAdapterDataObserver(adapterDataObserver);
            this.f35422h = adapterDataObserver;
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f35423i);
            }
        }
    }

    public boolean removeFooter(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, view)) == null) {
            if (this.f35420f.j(view)) {
                notifyDataSetChanged();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean removeHeader(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view)) == null) {
            if (this.f35420f.k(view)) {
                notifyDataSetChanged();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, adapter) == null) {
            this.f35421g = adapter;
            notifyDataSetChanged();
        }
    }

    public void setFooterView(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        int d2 = this.f35420f.d(view);
        if (d2 < 0) {
            this.f35420f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (d2 != i2) {
            this.f35420f.j(view);
            this.f35420f.a(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.setHasStableIds(z);
            }
            super.setHasStableIds(z);
        }
    }

    public void setHeaderView(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        int f2 = this.f35420f.f(view);
        if (f2 < 0) {
            this.f35420f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        } else if (f2 != i2) {
            this.f35420f.k(view);
            this.f35420f.b(view, obj, z, z2, i2);
            notifyDataSetChanged();
        }
    }

    public void setListPreLoad(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            this.f35420f.l(aVar);
        }
    }

    public void setOnItemClickListener(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, iVar) == null) {
            this.j = iVar;
        }
    }

    public void setOnItemLongClickListener(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jVar) == null) {
            this.k = jVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, adapterDataObserver) == null) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
            this.f35422h = adapterDataObserver;
            RecyclerView.Adapter adapter = this.f35421g;
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f35423i);
            }
        }
    }

    public void addFooterView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            addFooterView(view, null, true, i2);
        }
    }

    public void addHeaderView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) {
            addHeaderView(view, null, true, true, i2);
        }
    }

    public void addFooterView(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        this.f35420f.a(view, obj, z, true, i2);
        notifyDataSetChanged();
    }

    public void addHeaderView(View view, Object obj, boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        this.f35420f.b(view, obj, z, z2, i2);
        notifyDataSetChanged();
    }
}
