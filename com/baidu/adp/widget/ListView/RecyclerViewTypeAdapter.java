package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.n.e.a;
import c.a.d.n.e.n;
import c.a.d.n.e.r;
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
/* loaded from: classes9.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements r<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, TypeAdapter.ViewHolder>> f32394e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f32395f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f32396g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f32397h;

    /* renamed from: i  reason: collision with root package name */
    public int f32398i;

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
        this.f32395f = new SparseArray<>();
        this.f32396g = new ArrayList();
        this.f32397h = null;
        this.f32398i = -1;
    }

    public void addAdapter(a<n, TypeAdapter.ViewHolder> aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getType() == null) {
            return;
        }
        if (this.f32394e == null) {
            this.f32394e = new SparseArray<>();
        }
        if (aVar.getType() != null) {
            aVar.U(this);
            int id = aVar.getType().getId();
            int size = this.f32394e.size();
            this.f32394e.put(size, aVar);
            this.f32395f.put(id, Integer.valueOf(size));
        }
    }

    @Override // c.a.d.n.e.r
    public a<n, TypeAdapter.ViewHolder> getAdapterByData(n nVar) {
        InterceptResult invokeL;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar)) == null) {
            if (nVar == null) {
                return null;
            }
            int i2 = -1;
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f32394e;
            if (sparseArray != null && sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f32395f.get(type.getId())) != null) {
                i2 = num.intValue();
            }
            if (i2 < 0 || i2 >= this.f32394e.size()) {
                return null;
            }
            return this.f32394e.get(i2);
        }
        return (a) invokeL.objValue;
    }

    @Override // c.a.d.n.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getItemCount() : invokeV.intValue;
    }

    public int getCountByBdUniqueId(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return 0;
            }
            return getCountByType(bdUniqueId.getId());
        }
        return invokeL.intValue;
    }

    public int getCountByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = 0;
            for (n nVar : this.f32396g) {
                if (nVar != null && nVar.getType() != null && nVar.getType().getId() == i2) {
                    i3++;
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32396g : (List) invokeV.objValue;
    }

    public n getItemByBdUniqueId(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return null;
            }
            return getItemByType(i2, bdUniqueId.getId());
        }
        return (n) invokeIL.objValue;
    }

    public n getItemByType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            List<n> list = this.f32396g;
            if (list != null && list.size() != 0) {
                int i4 = 0;
                for (n nVar : this.f32396g) {
                    if (nVar != null && nVar.getType() != null && nVar.getType().getId() == i3) {
                        if (i4 == i2) {
                            return nVar;
                        }
                        i4++;
                    }
                }
            }
            return null;
        }
        return (n) invokeII.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<n> list = this.f32396g;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        n item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.f32398i = i2;
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f32394e;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i2)) == null || (type = item.getType()) == null || (num = this.f32395f.get(type.getId())) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    @Override // c.a.d.n.e.r
    public int getPositionByType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            List<n> list = this.f32396g;
            if (list != null && list.size() != 0) {
                int size = this.f32396g.size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f32396g.get(i5) != null && this.f32396g.get(i5).getType() != null) {
                        if (i3 == this.f32396g.get(i5).getType().getId()) {
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

    public void onItemClick(ViewGroup viewGroup, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{viewGroup, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f32394e == null) {
            return;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f32394e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.getType(), viewGroup, i2, j2);
    }

    public boolean onItemLongClick(ViewGroup viewGroup, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{viewGroup, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (this.f32394e == null) {
                return false;
            }
            n item = getItem(i2);
            int itemViewType = getItemViewType(i2);
            a<n, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.f32394e.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.B() == null) {
                return false;
            }
            return valueAt.B().a(view, item, valueAt.getType(), viewGroup, i2, j2);
        }
        return invokeCommon.booleanValue;
    }

    public void removeItem(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) || i2 >= this.f32396g.size()) {
            return;
        }
        this.f32396g.remove(i2);
        notifyItemRemoved(i2 + i3);
    }

    public void removeItemList(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) || i2 >= this.f32396g.size() || i3 >= this.f32396g.size() || i2 > i3) {
            return;
        }
        this.f32396g.subList(i2, i3 + 1).clear();
        notifyItemRangeRemoved(i2, (i3 - i2) + 1);
    }

    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            List<n> list2 = this.f32396g;
            if (list2 == null) {
                this.f32396g = new ArrayList();
            } else {
                list2.clear();
            }
            this.f32396g.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setDataWithPartChanged(List<? extends n> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048600, this, list, i2, i3) == null) {
            List<n> list2 = this.f32396g;
            if (list2 == null) {
                this.f32396g = new ArrayList();
            } else {
                list2.clear();
            }
            this.f32396g.addAll(list);
            notifyItemRangeChanged(i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.o
    public n getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<n> list = this.f32396g;
            if (list != null) {
                int size = list.size();
                if (i2 < 0 || i2 >= size) {
                    return null;
                }
                return this.f32396g.get(i2);
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i2) {
        a<n, TypeAdapter.ViewHolder> aVar;
        n item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, viewHolder, i2) == null) || viewHolder == null || this.f32394e == null || this.f32396g == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i2 < 0 || i2 >= itemCount || (aVar = this.f32394e.get(getItemViewType(i2))) == null || (item = getItem(i2)) == null || !(item instanceof n)) {
            return;
        }
        try {
            aVar.T(i2, this.f32397h, viewHolder, item);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        a<n, TypeAdapter.ViewHolder> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, viewGroup, i2)) == null) {
            if (this.f32397h == null) {
                this.f32397h = (RecyclerView) viewGroup;
            }
            n item = getItem(this.f32398i);
            SparseArray<a<n, TypeAdapter.ViewHolder>> sparseArray = this.f32394e;
            TypeAdapter.ViewHolder viewHolder = null;
            if (sparseArray != null && (aVar = sparseArray.get(i2)) != null) {
                try {
                    viewHolder = aVar.N(viewGroup, item);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (viewHolder == null) {
                    aVar.getClass().getName();
                }
            }
            return viewHolder;
        }
        return (TypeAdapter.ViewHolder) invokeLI.objValue;
    }

    public void removeItemList(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048598, this, i2, i3, i4) == null) || i2 >= this.f32396g.size() || i3 >= this.f32396g.size() || i2 > i3) {
            return;
        }
        this.f32396g.subList(i2, i3 + 1).clear();
        notifyItemRangeRemoved(i4 + i2, (i3 - i2) + 1);
    }
}
