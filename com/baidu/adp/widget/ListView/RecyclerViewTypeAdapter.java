package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.o.e.a;
import c.a.d.o.e.n;
import c.a.d.o.e.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<a<n, TypeAdapter.ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f23985b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f23986c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f23987d;

    /* renamed from: e  reason: collision with root package name */
    public int f23988e;

    public RecyclerViewTypeAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23985b = new SparseArray<>();
        this.f23986c = new ArrayList();
        this.f23987d = null;
        this.f23988e = -1;
    }

    @Override // c.a.d.o.e.r
    public int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            List<n> list = this.f23986c;
            if (list != null && list.size() != 0) {
                int size = this.f23986c.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.f23986c.get(i4) != null && this.f23986c.get(i4).getType() != null) {
                        if (i2 == this.f23986c.get(i4).getType().getId()) {
                            i3++;
                        }
                        if (i4 == i) {
                            return i3;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeII.intValue;
    }

    @Override // c.a.d.o.e.r
    public a<n, TypeAdapter.ViewHolder> c(n nVar) {
        InterceptResult invokeL;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar)) == null) {
            if (nVar == null) {
                return null;
            }
            int i = -1;
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f23985b.get(type.getId())) != null) {
                i = num.intValue();
            }
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (a) invokeL.objValue;
    }

    public void d(a<n, TypeAdapter.ViewHolder> aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null || aVar.getType() == null) {
            return;
        }
        if (this.a == null) {
            this.a = new SparseArray<>();
        }
        if (aVar.getType() != null) {
            aVar.U(this);
            int id = aVar.getType().getId();
            int size = this.a.size();
            this.a.put(size, aVar);
            this.f23985b.put(id, Integer.valueOf(size));
        }
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23986c : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.o
    /* renamed from: f */
    public n getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<n> list = this.f23986c;
            if (list != null) {
                int size = list.size();
                if (i < 0 || i >= size) {
                    return null;
                }
                return this.f23986c.get(i);
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) || viewHolder == null || this.a == null || this.f23986c == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i < 0 || i >= itemCount || (aVar = this.a.get(getItemViewType(i))) == null || (item = getItem(i)) == null || !(item instanceof n)) {
            return;
        }
        try {
            aVar.T(i, this.f23987d, viewHolder, item);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.a.d.o.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getItemCount() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<n> list = this.f23986c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        n item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.f23988e = i;
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.f23985b.get(type.getId())) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        a<n, TypeAdapter.ViewHolder> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            if (this.f23987d == null) {
                this.f23987d = (RecyclerView) viewGroup;
            }
            n item = getItem(this.f23988e);
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.a;
            TypeAdapter.ViewHolder viewHolder = null;
            if (sparseArray != null && (aVar = sparseArray.get(i)) != null) {
                try {
                    viewHolder = aVar.N(viewGroup, item);
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

    public void i(ViewGroup viewGroup, View view, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{viewGroup, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.getType(), viewGroup, i, j);
    }

    public boolean j(ViewGroup viewGroup, View view, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{viewGroup, view, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            n item = getItem(i);
            int itemViewType = getItemViewType(i);
            a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.B() == null) {
                return false;
            }
            return valueAt.B().a(view, item, valueAt.getType(), viewGroup, i, j);
        }
        return invokeCommon.booleanValue;
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) || i >= this.f23986c.size()) {
            return;
        }
        this.f23986c.remove(i);
        notifyItemRemoved(i + i2);
    }

    public void l(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) || i >= this.f23986c.size() || i2 >= this.f23986c.size() || i > i2) {
            return;
        }
        this.f23986c.subList(i, i2 + 1).clear();
        notifyItemRangeRemoved(i3 + i, (i2 - i) + 1);
    }

    public void m(List<? extends n> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, list, i, i2) == null) {
            List<n> list2 = this.f23986c;
            if (list2 == null) {
                this.f23986c = new ArrayList();
            } else {
                list2.clear();
            }
            this.f23986c.addAll(list);
            notifyItemRangeChanged(i, i2);
        }
    }

    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            List<n> list2 = this.f23986c;
            if (list2 == null) {
                this.f23986c = new ArrayList();
            } else {
                list2.clear();
            }
            this.f23986c.addAll(list);
            notifyDataSetChanged();
        }
    }
}
