package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bn;
import com.repackage.on;
import com.repackage.tn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TypeAdapter extends BaseAdapter implements tn<on> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<bn<on, ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})
    public SparseArray<Integer> b;
    public List<on> c;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.itemView : (View) invokeV.objValue;
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

    public void a(bn<on, ViewHolder> bnVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bnVar) == null) || bnVar == null || bnVar.getType() == null) {
            return;
        }
        if (this.a == null) {
            this.a = new SparseArray<>();
        }
        if (bnVar.getType() != null) {
            bnVar.setAdapter(this);
            int id = bnVar.getType().getId();
            int size = this.a.size();
            this.a.put(size, bnVar);
            this.b.put(id, Integer.valueOf(size));
        }
    }

    @Override // com.repackage.tn
    public int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            List<on> list = this.c;
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

    @Override // com.repackage.tn
    public bn<on, ViewHolder> c(on onVar) {
        InterceptResult invokeL;
        SparseArray<bn<on, ViewHolder>> sparseArray;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onVar)) == null) {
            if (onVar != null && (sparseArray = this.a) != null) {
                int i = -1;
                if (sparseArray.size() != 0 && (type = onVar.getType()) != null && (num = this.b.get(type.getId())) != null) {
                    i = num.intValue();
                }
                if (i >= 0 && i < this.a.size()) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (bn) invokeL.objValue;
    }

    public List<on> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, com.repackage.pn
    /* renamed from: e */
    public on getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<on> list = this.c;
            if (list != null) {
                int size = list.size();
                if (i < 0 || i >= size) {
                    return null;
                }
                return this.c.get(i);
            }
            return null;
        }
        return (on) invokeI.objValue;
    }

    public void f(ViewGroup viewGroup, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        on item = getItem(i);
        int itemViewType = getItemViewType(i);
        bn<on, ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.getOnAdapterItemClickListener() == null) {
            return;
        }
        valueAt.getOnAdapterItemClickListener().b(view2, item, valueAt.getType(), viewGroup, i, j);
    }

    public boolean g(ViewGroup viewGroup, View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{viewGroup, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            on item = getItem(i);
            int itemViewType = getItemViewType(i);
            bn<on, ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.getOnAdapterItemLongClickListener() == null) {
                return false;
            }
            return valueAt.getOnAdapterItemLongClickListener().a(view2, item, valueAt.getType(), viewGroup, i, j);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.widget.Adapter, com.repackage.pn
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<on> list = this.c;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        on item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            SparseArray<bn<on, ViewHolder>> sparseArray = this.a;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.b.get(type.getId())) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        bn<on, ViewHolder> bnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            View view3 = null;
            if (this.a != null && this.c != null) {
                int count = getCount();
                if (i >= 0 && i < count && (bnVar = this.a.get(getItemViewType(i))) != null) {
                    on item = getItem(i);
                    if (item != null && (item instanceof on)) {
                        view3 = bnVar.getView(i, view2, viewGroup, item);
                    }
                    if (view3 == null) {
                        Log.e("BdTypeListView", bnVar.getClass().getName());
                    }
                }
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SparseArray<bn<on, ViewHolder>> sparseArray = this.a;
            if (sparseArray != null) {
                return sparseArray.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void h(List<? extends on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            List<on> list2 = this.c;
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
