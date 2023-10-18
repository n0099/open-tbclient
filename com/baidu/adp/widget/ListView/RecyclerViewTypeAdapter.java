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
import com.baidu.tieba.di;
import com.baidu.tieba.lh;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RecyclerViewTypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> implements di<yh> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<lh<yh, TypeAdapter.ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})
    public SparseArray<Integer> b;
    public List<yh> c;
    public RecyclerView d;
    public int e;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
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

    @Override // com.baidu.tieba.di
    public int g(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            List<yh> list = this.c;
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
        lh<yh, TypeAdapter.ViewHolder> lhVar;
        yh item;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, viewHolder, i) == null) && viewHolder != null && this.a != null && this.c != null) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount && (lhVar = this.a.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof yh)) {
                try {
                    lhVar.onFillViewHolder(i, this.d, viewHolder, item);
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
        lh<yh, TypeAdapter.ViewHolder> lhVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, viewGroup, i)) == null) {
            if (this.d == null) {
                this.d = (RecyclerView) viewGroup;
            }
            yh item = getItem(this.e);
            SparseArray<lh<yh, TypeAdapter.ViewHolder>> sparseArray = this.a;
            TypeAdapter.ViewHolder viewHolder = null;
            if (sparseArray == null || (lhVar = sparseArray.get(i)) == null) {
                return null;
            }
            try {
                viewHolder = lhVar.onCreateViewHolder(viewGroup, item);
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    throw e;
                }
            }
            if (viewHolder == null) {
                Log.e("RecyclerViewTypeAdapter", lhVar.getClass().getName());
            }
            return viewHolder;
        }
        return (TypeAdapter.ViewHolder) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.zh
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getItemCount();
        }
        return invokeV.intValue;
    }

    @NonNull
    public List<yh> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<yh> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zh
    /* renamed from: m */
    public yh getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            List<yh> list = this.c;
            if (list != null) {
                int size = list.size();
                if (i >= 0 && i < size) {
                    return this.c.get(i);
                }
                return null;
            }
            return null;
        }
        return (yh) invokeI.objValue;
    }

    public void setData(List<? extends yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            List<yh> list2 = this.c;
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
        yh item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.e = i;
            SparseArray<lh<yh, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (item = getItem(i)) != null && (type = item.getType()) != null && (num = this.b.get(type.getId())) != null) {
                return num.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.di
    public lh<yh, TypeAdapter.ViewHolder> h(yh yhVar) {
        InterceptResult invokeL;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yhVar)) == null) {
            if (yhVar == null) {
                return null;
            }
            int i = -1;
            SparseArray<lh<yh, TypeAdapter.ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (type = yhVar.getType()) != null && (num = this.b.get(type.getId())) != null) {
                i = num.intValue();
            }
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (lh) invokeL.objValue;
    }

    public void l(lh<yh, TypeAdapter.ViewHolder> lhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lhVar) == null) && lhVar != null && lhVar.getType() != null) {
            if (this.a == null) {
                this.a = new SparseArray<>();
            }
            if (lhVar.getType() != null) {
                lhVar.setAdapter(this);
                int id = lhVar.getType().getId();
                int size = this.a.size();
                this.a.put(size, lhVar);
                this.b.put(id, Integer.valueOf(size));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NonNull TypeAdapter.ViewHolder viewHolder, int i, @NonNull List<Object> list) {
        lh<yh, TypeAdapter.ViewHolder> lhVar;
        yh item;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, viewHolder, i, list) == null) {
            if (list.isEmpty()) {
                super.onBindViewHolder(viewHolder, i, list);
            } else if (viewHolder != null && this.a != null && this.c != null) {
                int itemCount = getItemCount();
                if (i >= 0 && i < itemCount && (lhVar = this.a.get(getItemViewType(i))) != null && (item = getItem(i)) != null && (item instanceof yh)) {
                    try {
                        lhVar.onFillViewHolder(i, (ViewGroup) this.d, (RecyclerView) viewHolder, (TypeAdapter.ViewHolder) item, list);
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

    public void s(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) && i < this.c.size()) {
            this.c.remove(i);
            notifyItemRemoved(i + i2);
        }
    }

    public void q(ViewGroup viewGroup, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a == null) {
            return;
        }
        yh item = getItem(i);
        lh<yh, TypeAdapter.ViewHolder> lhVar = null;
        int itemViewType = getItemViewType(i);
        if (itemViewType >= 0) {
            lhVar = this.a.valueAt(itemViewType);
        }
        if (lhVar != null && lhVar.getOnAdapterItemClickListener() != null) {
            lhVar.getOnAdapterItemClickListener().b(view2, item, lhVar.getType(), viewGroup, i, j);
        }
    }

    public boolean r(ViewGroup viewGroup, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            yh item = getItem(i);
            lh<yh, TypeAdapter.ViewHolder> lhVar = null;
            int itemViewType = getItemViewType(i);
            if (itemViewType >= 0) {
                lhVar = this.a.valueAt(itemViewType);
            }
            if (lhVar == null || lhVar.getOnAdapterItemLongClickListener() == null) {
                return false;
            }
            return lhVar.getOnAdapterItemLongClickListener().a(view2, item, lhVar.getType(), viewGroup, i, j);
        }
        return invokeCommon.booleanValue;
    }

    public void t(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048596, this, i, i2, i3) == null) && i < this.c.size() && i2 < this.c.size() && i <= i2) {
            this.c.subList(i, i2 + 1).clear();
            notifyItemRangeRemoved(i3 + i, (i2 - i) + 1);
        }
    }
}
