package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.o.e.a;
import c.a.d.o.e.n;
import c.a.d.o.e.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class TypeAdapter extends BaseAdapter implements r<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<a<n, ViewHolder>> a;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f23991b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f23992c;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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

        public View b() {
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
        this.f23991b = new SparseArray<>();
        this.f23992c = new ArrayList();
    }

    public void a(a<n, ViewHolder> aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getType() == null) {
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
            this.f23991b.put(id, Integer.valueOf(size));
        }
    }

    @Override // c.a.d.o.e.r
    public int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            List<n> list = this.f23992c;
            if (list != null && list.size() != 0) {
                int size = this.f23992c.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.f23992c.get(i4) != null && this.f23992c.get(i4).getType() != null) {
                        if (i2 == this.f23992c.get(i4).getType().getId()) {
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
    public a<n, ViewHolder> c(n nVar) {
        InterceptResult invokeL;
        SparseArray<a<n, ViewHolder>> sparseArray;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar)) == null) {
            if (nVar != null && (sparseArray = this.a) != null) {
                int i = -1;
                if (sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f23991b.get(type.getId())) != null) {
                    i = num.intValue();
                }
                if (i >= 0 && i < this.a.size()) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public List<n> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23992c : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, c.a.d.o.e.o
    /* renamed from: e */
    public n getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<n> list = this.f23992c;
            if (list != null) {
                int size = list.size();
                if (i < 0 || i >= size) {
                    return null;
                }
                return this.f23992c.get(i);
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    public void f(ViewGroup viewGroup, View view, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{viewGroup, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        n item = getItem(i);
        int itemViewType = getItemViewType(i);
        a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.getType(), viewGroup, i, j);
    }

    public boolean g(ViewGroup viewGroup, View view, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{viewGroup, view, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a == null) {
                return false;
            }
            n item = getItem(i);
            int itemViewType = getItemViewType(i);
            a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.a.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.B() == null) {
                return false;
            }
            return valueAt.B().a(view, item, valueAt.getType(), viewGroup, i, j);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.widget.Adapter, c.a.d.o.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<n> list = this.f23992c;
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
        n item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            SparseArray<a<n, ViewHolder>> sparseArray = this.a;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i)) == null || (type = item.getType()) == null || (num = this.f23991b.get(type.getId())) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a<n, ViewHolder> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view, viewGroup)) == null) {
            View view2 = null;
            if (this.a != null && this.f23992c != null) {
                int count = getCount();
                if (i >= 0 && i < count && (aVar = this.a.get(getItemViewType(i))) != null) {
                    n item = getItem(i);
                    if (item != null && (item instanceof n)) {
                        view2 = aVar.E(i, view, viewGroup, item);
                    }
                    if (view2 == null) {
                        Log.e("BdTypeListView", aVar.getClass().getName());
                    }
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SparseArray<a<n, ViewHolder>> sparseArray = this.a;
            if (sparseArray != null) {
                return sparseArray.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void h(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            List<n> list2 = this.f23992c;
            if (list2 == null) {
                this.f23992c = new ArrayList();
            } else {
                list2.clear();
            }
            this.f23992c.addAll(list);
            notifyDataSetChanged();
        }
    }
}
