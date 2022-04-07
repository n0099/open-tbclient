package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.repackage.ko;
import com.repackage.vo;
/* loaded from: classes.dex */
public class BdRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements vo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ko b;
    public RecyclerView.Adapter c;
    public RecyclerView.AdapterDataObserver d;
    public RecyclerView.AdapterDataObserver e;
    public BdRecyclerView.i f;
    public BdRecyclerView.j g;

    /* loaded from: classes.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdRecyclerAdapter a;

        public a(BdRecyclerAdapter bdRecyclerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
                RecyclerView.AdapterDataObserver adapterDataObserver = this.a.d;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onChanged();
                }
                if (this.a.b.c != null) {
                    this.a.b.c.onPreLoad();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                super.onItemRangeChanged(i, i2);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.a.d;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeChanged(i, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                super.onItemRangeInserted(i, i2);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.a.d;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeInserted(i, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
                super.onItemRangeMoved(i, i2, i3);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.a.d;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeMoved(i, i2, i3);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                super.onItemRangeRemoved(i, i2);
                RecyclerView.AdapterDataObserver adapterDataObserver = this.a.d;
                if (adapterDataObserver != null) {
                    adapterDataObserver.onItemRangeRemoved(i, i2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecyclerView.ViewHolder a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ BdRecyclerAdapter c;

        public b(BdRecyclerAdapter bdRecyclerAdapter, RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerAdapter, viewHolder, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bdRecyclerAdapter;
            this.a = viewHolder;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.f == null) {
                return;
            }
            int adapterPosition = this.a.getAdapterPosition();
            this.c.f.b(this.b, this.a.itemView, this.c.getItem(adapterPosition), adapterPosition, this.c.getItemId(adapterPosition));
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecyclerView.ViewHolder a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ BdRecyclerAdapter c;

        public c(BdRecyclerAdapter bdRecyclerAdapter, RecyclerView.ViewHolder viewHolder, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdRecyclerAdapter, viewHolder, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bdRecyclerAdapter;
            this.a = viewHolder;
            this.b = viewGroup;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.c.g != null) {
                    int adapterPosition = this.a.getAdapterPosition();
                    return this.c.g.a(this.b, this.a.itemView, this.c.getItem(adapterPosition), adapterPosition, this.c.getItemId(adapterPosition));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f = null;
        this.g = null;
        this.a = context;
        this.b = new ko();
        this.e = new a(this);
    }

    public void addFooterView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            g(view2, null, true, -1);
        }
    }

    public void g(View view2, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, obj, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || view2 == null) {
            return;
        }
        this.b.a(view2, obj, z, true, i);
        notifyDataSetChanged();
    }

    @Override // com.repackage.vo
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getItemCount() : invokeV.intValue;
    }

    @Override // com.repackage.vo
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i < 0) {
                return null;
            }
            int o = o();
            if (i < o) {
                return this.b.a.get(i).d;
            }
            int i2 = i - o;
            int i3 = 0;
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null && i2 < (i3 = adapter.getItemCount())) {
                RecyclerView.Adapter adapter2 = this.c;
                if (adapter2 instanceof vo) {
                    return ((vo) adapter2).getItem(i2);
                }
            }
            int n = n();
            int i4 = i2 - i3;
            if (i4 < 0 || i4 >= n) {
                return null;
            }
            return this.b.b.get(i4).d;
        }
        return invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        int n;
        int o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c != null) {
                n = n() + o();
                o = this.c.getItemCount();
            } else {
                n = n();
                o = o();
            }
            return n + o;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i < 0) {
                return -1L;
            }
            int o = o();
            if (i < o) {
                return this.b.a.get(i).a;
            }
            int i2 = 0;
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null && i >= o) {
                int i3 = i - o;
                int itemCount = adapter.getItemCount();
                if (i3 < itemCount) {
                    return this.c.getItemId(i3);
                }
                i2 = itemCount;
            }
            int i4 = (i - o) - i2;
            if (i4 <= -1 || i4 >= n()) {
                return -1L;
            }
            return this.b.b.get(i4).a;
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < 0) {
                return -1;
            }
            int o = o();
            if (i < o) {
                return this.b.a.get(i).b;
            }
            int i2 = i - o;
            int i3 = 0;
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null && i2 < (i3 = adapter.getItemCount())) {
                return this.c.getItemViewType(i2);
            }
            int n = n();
            int i4 = i2 - i3;
            if (i4 < 0 || i4 >= n) {
                return -1;
            }
            return this.b.b.get(i4).b;
        }
        return invokeI.intValue;
    }

    public void h(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, view2, i) == null) {
            i(view2, null, true, true, i);
        }
    }

    public void i(View view2, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || view2 == null) {
            return;
        }
        this.b.b(view2, obj, z, z2, i);
        notifyDataSetChanged();
    }

    public final void j(ViewGroup viewGroup, RecyclerView.ViewHolder viewHolder) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, viewGroup, viewHolder) == null) || viewGroup == null || viewHolder == null || (view2 = viewHolder.itemView) == null) {
            return;
        }
        view2.setOnClickListener(new b(this, viewHolder, viewGroup));
        viewHolder.itemView.setOnLongClickListener(new c(this, viewHolder, viewGroup));
    }

    public ko.c k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.b.e(i) : (ko.c) invokeI.objValue;
    }

    @Nullable
    public View l(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) ? this.b.g(obj) : (View) invokeL.objValue;
    }

    public ko.c m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this.b.h(i) : (ko.c) invokeI.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b.i() : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b.j() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, recyclerView) == null) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, viewHolder, i) == null) || i < 0 || getItemViewType(i) == -1 || (viewHolder instanceof ko.b)) {
            return;
        }
        int o = o();
        RecyclerView.Adapter adapter = this.c;
        if (adapter == null || i < o || (i2 = i - o) >= adapter.getItemCount()) {
            return;
        }
        this.c.onBindViewHolder(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        TypeAdapter.ViewHolder viewHolder;
        boolean z;
        RecyclerView.Adapter adapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, viewGroup, i)) == null) {
            ko.c m = m(i);
            boolean z2 = true;
            if (m != null) {
                viewHolder = m.c;
                z = m.e;
            } else {
                viewHolder = null;
                z = true;
            }
            if (viewHolder == null) {
                ko.c k = k(i);
                TypeAdapter.ViewHolder viewHolder2 = k != null ? k.c : null;
                if (k != null && !k.e) {
                    z2 = false;
                }
                z = z2;
                viewHolder = viewHolder2;
            }
            if (viewHolder == null && (adapter = this.c) != null) {
                viewHolder = adapter.onCreateViewHolder(viewGroup, i);
            }
            if (viewHolder == null) {
                viewHolder = this.b.c(this.a);
            }
            if (z) {
                j(viewGroup, viewHolder);
            }
            return viewHolder;
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, viewHolder)) == null) {
            RecyclerView.Adapter adapter = this.c;
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
        if (interceptable == null || interceptable.invokeL(1048596, this, viewHolder) == null) {
            super.onViewAttachedToWindow(viewHolder);
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.onViewAttachedToWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.onViewDetachedFromWindow(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, viewHolder) == null) {
            super.onViewRecycled(viewHolder);
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
        }
    }

    public RecyclerView.Adapter p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.c : (RecyclerView.Adapter) invokeV.objValue;
    }

    public boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view2)) == null) {
            if (this.b.k(view2)) {
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
            this.d = adapterDataObserver;
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.e);
            }
        }
    }

    public boolean s(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, view2)) == null) {
            if (this.b.l(view2)) {
                notifyDataSetChanged();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.setHasStableIds(z);
            }
            super.setHasStableIds(z);
        }
    }

    public void t(RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, adapter) == null) {
            this.c = adapter;
            notifyDataSetChanged();
        }
    }

    public void u(View view2, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{view2, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || view2 == null) {
            return;
        }
        int d = this.b.d(view2);
        if (d < 0) {
            this.b.a(view2, obj, z, z2, i);
            notifyDataSetChanged();
        } else if (d != i) {
            this.b.k(view2);
            this.b.a(view2, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, adapterDataObserver) == null) {
            super.unregisterAdapterDataObserver(adapterDataObserver);
            this.d = adapterDataObserver;
            RecyclerView.Adapter adapter = this.c;
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.e);
            }
        }
    }

    public void v(View view2, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{view2, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || view2 == null) {
            return;
        }
        int f = this.b.f(view2);
        if (f < 0) {
            this.b.b(view2, obj, z, z2, i);
            notifyDataSetChanged();
        } else if (f != i) {
            this.b.l(view2);
            this.b.b(view2, obj, z, z2, i);
            notifyDataSetChanged();
        }
    }

    public void w(ko.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, aVar) == null) {
            this.b.m(aVar);
        }
    }

    public void x(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, iVar) == null) {
            this.f = iVar;
        }
    }

    public void y(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, jVar) == null) {
            this.g = jVar;
        }
    }
}
