package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
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
public class TypeAdapter extends BaseAdapter implements ti<oi> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<bi<oi, ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})
    public SparseArray<Integer> b;
    public List<oi> c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.itemView.setTag(this);
        }

        public View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.itemView;
            }
            return (View) invokeV.objValue;
        }
    }

    public TypeAdapter() {
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
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SparseArray<bi<oi, ViewHolder>> sparseArray = this.a;
            if (sparseArray != null) {
                sparseArray.clear();
            }
            SparseArray<Integer> sparseArray2 = this.b;
            if (sparseArray2 != null) {
                sparseArray2.clear();
            }
        }
    }

    public List<oi> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter, com.baidu.tieba.pi
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<oi> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SparseArray<bi<oi, ViewHolder>> sparseArray = this.a;
            if (sparseArray != null) {
                return sparseArray.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a(bi<oi, ViewHolder> biVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, biVar) == null) && biVar != null && biVar.getType() != null) {
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

    @Override // com.baidu.tieba.ti
    public bi<oi, ViewHolder> g(oi oiVar) {
        InterceptResult invokeL;
        SparseArray<bi<oi, ViewHolder>> sparseArray;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, oiVar)) == null) {
            if (oiVar != null && (sparseArray = this.a) != null) {
                int i = -1;
                if (sparseArray.size() != 0 && (type = oiVar.getType()) != null && (num = this.b.get(type.getId())) != null) {
                    i = num.intValue();
                }
                if (i >= 0 && i < this.a.size()) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (bi) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.baidu.tieba.pi
    /* renamed from: d */
    public oi getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
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

    public void i(List<? extends oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
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

    @Override // com.baidu.tieba.ti
    public void notifyItemChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            notifyDataSetChanged();
        }
    }

    public void e(ViewGroup viewGroup, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a == null) {
            return;
        }
        oi item = getItem(i);
        bi<oi, ViewHolder> biVar = null;
        int itemViewType = getItemViewType(i);
        if (itemViewType >= 0) {
            biVar = this.a.valueAt(itemViewType);
        }
        if (biVar != null && biVar.getOnAdapterItemClickListener() != null) {
            biVar.getOnAdapterItemClickListener().b(view2, item, biVar.getType(), viewGroup, i, j);
        }
    }

    public boolean h(ViewGroup viewGroup, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            oi item = getItem(i);
            bi<oi, ViewHolder> biVar = null;
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

    @Override // com.baidu.tieba.ti
    public int f(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        oi item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            SparseArray<bi<oi, ViewHolder>> sparseArray = this.a;
            if (sparseArray != null && sparseArray.size() != 0 && (item = getItem(i)) != null && (type = item.getType()) != null && (num = this.b.get(type.getId())) != null) {
                return num.intValue();
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        bi<oi, ViewHolder> biVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            View view3 = null;
            if (this.a != null && this.c != null) {
                int count = getCount();
                if (i >= 0 && i < count && (biVar = this.a.get(getItemViewType(i))) != null) {
                    oi item = getItem(i);
                    if (item != null && (item instanceof oi)) {
                        view3 = biVar.getView(i, view2, viewGroup, item);
                    }
                    if (view3 == null) {
                        Log.e("BdTypeListView", biVar.getClass().getName());
                    }
                }
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.baidu.tieba.ti
    public void notifyItemChanged(int i, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, obj) == null) {
            notifyDataSetChanged();
        }
    }
}
