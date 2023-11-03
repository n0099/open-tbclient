package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.bi;
import com.baidu.tieba.oi;
import com.baidu.tieba.ti;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements ti<oi> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<bi<oi, TypeAdapter.ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})
    public SparseArray<Integer> b;
    public List<oi> c;
    public RecyclerView d;
    public int e;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

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

    @Override // com.baidu.tieba.ti
    public int f(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            List<oi> list = this.c;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(TypeAdapter.ViewHolder viewHolder, int i) {
        bi<oi, TypeAdapter.ViewHolder> biVar;
        oi item;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, viewHolder, i) == null) && viewHolder != null && this.a != null && this.c != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (biVar = this.a.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof oi)) {
                try {
                    biVar.onFillViewHolder(i, this.d, viewHolder, item);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (GlobalBuildConfig.isDebug()) {
                        throw e;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        bi<oi, TypeAdapter.ViewHolder> biVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, viewGroup, i)) == null) {
            if (this.d == null) {
                this.d = (RecyclerView) viewGroup;
            }
            oi item = getItem(this.e);
            SparseArray<bi<oi, TypeAdapter.ViewHolder>> sparseArray = this.a;
            TypeAdapter.ViewHolder viewHolder = null;
            if (sparseArray == null || (biVar = sparseArray.get(i)) == null) {
                return null;
            }
            try {
                viewHolder = biVar.onCreateViewHolder(viewGroup, item);
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    throw e;
                }
            }
            if (viewHolder == null) {
                Log.e("RecyclerViewTypeAdapter", biVar.getClass().getName());
            }
            return viewHolder;
        }
        return (TypeAdapter.ViewHolder) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ti
    public bi<oi, TypeAdapter.ViewHolder> g(oi oiVar) {
        InterceptResult invokeL;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oiVar)) == null) {
            if (oiVar == null) {
                return null;
            }
            int i = -1;
            SparseArray<bi<oi, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (type = oiVar.getType()) != null && (num = this.b.get(type.getId())) != null) {
                i = num.intValue();
            }
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (bi) invokeL.objValue;
    }

    public void l(bi<oi, TypeAdapter.ViewHolder> biVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, biVar) == null) && biVar != null && biVar.getType() != null) {
            if (this.a == null) {
                this.a = new SparseArray<>();
            }
            if (biVar.getType() != null) {
                biVar.setAdapter(this);
                int id = biVar.getType().getId();
                int size = this.a.size();
                this.a.put(size, biVar);
                this.b.put(id, Integer.valueOf(size));
            }
        }
    }

    @Override // com.baidu.tieba.pi
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getItemCount();
        }
        return invokeV.intValue;
    }

    @NonNull
    public List<oi> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<oi> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pi
    /* renamed from: m */
    public oi getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            List<oi> list = this.c;
            if (list != null) {
                int size = list.size();
                if (i >= 0 && i < size) {
                    return this.c.get(i);
                }
                return null;
            }
            return null;
        }
        return (oi) invokeI.objValue;
    }

    public void setData(List<? extends oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            List<oi> list2 = this.c;
            if (list2 == null) {
                this.c = new ArrayList();
            } else {
                list2.clear();
            }
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        oi item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.e = i;
            SparseArray<bi<oi, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (item = getItem(i)) != null && (type = item.getType()) != null && (num = this.b.get(type.getId())) != null) {
                return num.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NonNull TypeAdapter.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
        bi<oi, TypeAdapter.ViewHolder> biVar;
        oi item;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, viewHolder, i, list) == null) {
            if (list.isEmpty()) {
                super.onBindViewHolder(viewHolder, i, list);
            } else if (viewHolder != null && this.a != null && this.c != null) {
                int itemCount = getItemCount();
                if (i >= 0 && i < itemCount && (biVar = this.a.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof oi)) {
                    try {
                        biVar.onFillViewHolder(i, (ViewGroup) this.d, (RecyclerView) viewHolder, (TypeAdapter.ViewHolder) item, list);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (GlobalBuildConfig.isDebug()) {
                            throw e;
                        }
                    }
                }
            }
        }
    }

    public void t(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) && i < this.c.size()) {
            this.c.remove(i);
            notifyItemRemoved(i + i2);
        }
    }

    public void q(ViewGroup viewGroup, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a == null) {
            return;
        }
        oi item = getItem(i);
        bi<oi, TypeAdapter.ViewHolder> biVar = null;
        int itemViewType = getItemViewType(i);
        if (itemViewType >= 0) {
            biVar = this.a.valueAt(itemViewType);
        }
        if (biVar != null && biVar.getOnAdapterItemClickListener() != null) {
            biVar.getOnAdapterItemClickListener().b(view2, item, biVar.getType(), viewGroup, i, j);
        }
    }

    public boolean s(ViewGroup viewGroup, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            oi item = getItem(i);
            bi<oi, TypeAdapter.ViewHolder> biVar = null;
            int itemViewType = getItemViewType(i);
            if (itemViewType >= 0) {
                biVar = this.a.valueAt(itemViewType);
            }
            if (biVar == null || biVar.getOnAdapterItemLongClickListener() == null) {
                return false;
            }
            return biVar.getOnAdapterItemLongClickListener().a(view2, item, biVar.getType(), viewGroup, i, j);
        }
        return invokeCommon.booleanValue;
    }

    public void u(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048596, this, i, i2, i3) == null) && i < this.c.size() && i2 < this.c.size() && i <= i2) {
            this.c.subList(i, i2 + 1).clear();
            notifyItemRangeRemoved(i3 + i, (i2 - i) + 1);
        }
    }
}
