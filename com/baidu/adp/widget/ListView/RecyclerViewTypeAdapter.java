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
import com.repackage.jn;
import com.repackage.on;
import com.repackage.wm;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements on<jn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<wm<jn, TypeAdapter.ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})
    public SparseArray<Integer> b;
    public List<jn> c;
    public RecyclerView d;
    public int e;

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
        this.b = new SparseArray<>();
        this.c = new ArrayList();
        this.d = null;
        this.e = -1;
    }

    @Override // com.repackage.on
    public int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            List<jn> list = this.c;
            if (list != null && list.size() != 0) {
                int size = this.c.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.c.get(i4) != null && this.c.get(i4).getType() != null) {
                        if (i2 == this.c.get(i4).getType().getId()) {
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

    @Override // com.repackage.on
    public wm<jn, TypeAdapter.ViewHolder> c(jn jnVar) {
        InterceptResult invokeL;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jnVar)) == null) {
            if (jnVar == null) {
                return null;
            }
            int i = -1;
            SparseArray<wm<jn, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (type = jnVar.getType()) != null && (num = this.b.get(type.getId())) != null) {
                i = num.intValue();
            }
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (wm) invokeL.objValue;
    }

    public void d(wm<jn, TypeAdapter.ViewHolder> wmVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wmVar) == null) || wmVar == null || wmVar.getType() == null) {
            return;
        }
        if (this.a == null) {
            this.a = new SparseArray<>();
        }
        if (wmVar.getType() != null) {
            wmVar.U(this);
            int id = wmVar.getType().getId();
            int size = this.a.size();
            this.a.put(size, wmVar);
            this.b.put(id, Integer.valueOf(size));
        }
    }

    public List<jn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.kn
    /* renamed from: f */
    public jn getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<jn> list = this.c;
            if (list != null) {
                int size = list.size();
                if (i < 0 || i >= size) {
                    return null;
                }
                return this.c.get(i);
            }
            return null;
        }
        return (jn) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i) {
        wm<jn, TypeAdapter.ViewHolder> wmVar;
        jn item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i) == null) || viewHolder == null || this.a == null || this.c == null) {
            return;
        }
        int itemCount = getItemCount();
        if (i < 0 || i >= itemCount || (wmVar = this.a.get(getItemViewType(i))) == null || (item = getItem(i)) == null || !(item instanceof jn)) {
            return;
        }
        try {
            wmVar.T(i, this.d, viewHolder, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.repackage.kn
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
            List<jn> list = this.c;
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
        jn item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.e = i;
            SparseArray<wm<jn, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.b.get(type.getId())) == null) {
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
        wm<jn, TypeAdapter.ViewHolder> wmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i)) == null) {
            if (this.d == null) {
                this.d = (RecyclerView) viewGroup;
            }
            jn item = getItem(this.e);
            SparseArray<wm<jn, TypeAdapter.ViewHolder>> sparseArray = this.a;
            TypeAdapter.ViewHolder viewHolder = null;
            if (sparseArray != null && (wmVar = sparseArray.get(i)) != null) {
                try {
                    viewHolder = wmVar.N(viewGroup, item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (viewHolder == null) {
                    Log.e("RecyclerViewTypeAdapter", wmVar.getClass().getName());
                }
            }
            return viewHolder;
        }
        return (TypeAdapter.ViewHolder) invokeLI.objValue;
    }

    public void i(ViewGroup viewGroup, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        jn item = getItem(i);
        int itemViewType = getItemViewType(i);
        wm<jn, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view2, item, valueAt.getType(), viewGroup, i, j);
    }

    public boolean j(ViewGroup viewGroup, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            jn item = getItem(i);
            int itemViewType = getItemViewType(i);
            wm<jn, TypeAdapter.ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.B() == null) {
                return false;
            }
            return valueAt.B().a(view2, item, valueAt.getType(), viewGroup, i, j);
        }
        return invokeCommon.booleanValue;
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) || i >= this.c.size()) {
            return;
        }
        this.c.remove(i);
        notifyItemRemoved(i + i2);
    }

    public void l(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) || i >= this.c.size() || i2 >= this.c.size() || i > i2) {
            return;
        }
        this.c.subList(i, i2 + 1).clear();
        notifyItemRangeRemoved(i3 + i, (i2 - i) + 1);
    }

    public void m(List<? extends jn> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, list, i, i2) == null) {
            List<jn> list2 = this.c;
            if (list2 == null) {
                this.c = new ArrayList();
            } else {
                list2.clear();
            }
            this.c.addAll(list);
            notifyItemRangeChanged(i, i2);
        }
    }

    public void setData(List<? extends jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            List<jn> list2 = this.c;
            if (list2 == null) {
                this.c = new ArrayList();
            } else {
                list2.clear();
            }
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }
}
