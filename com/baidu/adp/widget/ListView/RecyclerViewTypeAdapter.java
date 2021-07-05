package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.a;
import d.a.c.k.e.n;
import d.a.c.k.e.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, TypeAdapter.ViewHolder>> f2395e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f2396f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f2397g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f2398h;

    /* renamed from: i  reason: collision with root package name */
    public int f2399i;

    public RecyclerViewTypeAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2396f = new SparseArray<>();
        this.f2397g = new ArrayList();
        this.f2398h = null;
        this.f2399i = -1;
    }

    @Override // d.a.c.k.e.r
    public int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            List<n> list = this.f2397g;
            if (list != null && list.size() != 0) {
                int size = this.f2397g.size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f2397g.get(i5) != null && this.f2397g.get(i5).getType() != null) {
                        if (i3 == this.f2397g.get(i5).getType().getId()) {
                            i4++;
                        }
                        if (i5 == i2) {
                            return i4;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeII.intValue;
    }

    @Override // d.a.c.k.e.r
    public a<n, TypeAdapter.ViewHolder> c(n nVar) {
        InterceptResult invokeL;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar)) == null) {
            if (nVar == null) {
                return null;
            }
            int i2 = -1;
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2395e;
            if (sparseArray != null && sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f2396f.get(type.getId())) != null) {
                i2 = num.intValue();
            }
            if (i2 < 0 || i2 >= this.f2395e.size()) {
                return null;
            }
            return this.f2395e.get(i2);
        }
        return (a) invokeL.objValue;
    }

    public void d(a<n, TypeAdapter.ViewHolder> aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null || aVar.H() == null) {
            return;
        }
        if (this.f2395e == null) {
            this.f2395e = new SparseArray<>();
        }
        if (aVar.H() != null) {
            aVar.Z(this);
            int id = aVar.H().getId();
            int size = this.f2395e.size();
            this.f2395e.put(size, aVar);
            this.f2396f.put(id, Integer.valueOf(size));
        }
    }

    @Override // d.a.c.k.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getItemCount() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<n> list = this.f2397g;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        n item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f2399i = i2;
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2395e;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i2)) == null || (type = item.getType()) == null || (num = this.f2396f.get(type.getId())) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2397g : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.o
    /* renamed from: n */
    public n getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            List<n> list = this.f2397g;
            if (list != null) {
                int size = list.size();
                if (i2 < 0 || i2 >= size) {
                    return null;
                }
                return this.f2397g.get(i2);
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i2) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, viewHolder, i2) == null) || viewHolder == null || this.f2395e == null || this.f2397g == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i2 < 0 || i2 >= itemCount || (aVar = this.f2395e.get(getItemViewType(i2))) == null || (item = getItem(i2)) == null || !(item instanceof n)) {
            return;
        }
        try {
            aVar.Y(i2, this.f2398h, viewHolder, item);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        a<n, TypeAdapter.ViewHolder> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, viewGroup, i2)) == null) {
            if (this.f2398h == null) {
                this.f2398h = (RecyclerView) viewGroup;
            }
            n item = getItem(this.f2399i);
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f2395e;
            TypeAdapter.ViewHolder viewHolder = null;
            if (sparseArray != null && (aVar = sparseArray.get(i2)) != null) {
                try {
                    viewHolder = aVar.R(viewGroup, item);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (viewHolder == null) {
                    Log.e("RecyclerViewTypeAdapter", aVar.getClass().getName());
                }
            }
            return viewHolder;
        }
        return (TypeAdapter.ViewHolder) invokeLI.objValue;
    }

    public void q(ViewGroup viewGroup, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{viewGroup, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f2395e == null) {
            return;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2395e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.H(), viewGroup, i2, j);
    }

    public boolean r(ViewGroup viewGroup, View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{viewGroup, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (this.f2395e == null) {
                return false;
            }
            n item = getItem(i2);
            int itemViewType = getItemViewType(i2);
            a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f2395e.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.B() == null) {
                return false;
            }
            return valueAt.B().a(view, item, valueAt.H(), viewGroup, i2, j);
        }
        return invokeCommon.booleanValue;
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || i2 >= this.f2397g.size()) {
            return;
        }
        this.f2397g.remove(i2);
        notifyItemRemoved(i2 + i3);
    }

    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            List<n> list2 = this.f2397g;
            if (list2 == null) {
                this.f2397g = new ArrayList();
            } else {
                list2.clear();
            }
            this.f2397g.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void t(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048594, this, i2, i3, i4) == null) || i2 >= this.f2397g.size() || i3 >= this.f2397g.size() || i2 > i3) {
            return;
        }
        this.f2397g.subList(i2, i3 + 1).clear();
        notifyItemRangeRemoved(i4 + i2, (i3 - i2) + 1);
    }

    public void u(List<? extends n> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, list, i2, i3) == null) {
            List<n> list2 = this.f2397g;
            if (list2 == null) {
                this.f2397g = new ArrayList();
            } else {
                list2.clear();
            }
            this.f2397g.addAll(list);
            notifyItemRangeChanged(i2, i3);
        }
    }
}
