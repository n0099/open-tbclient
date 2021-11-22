package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.m.e.a;
import b.a.e.m.e.n;
import b.a.e.m.e.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class TypeAdapter extends BaseAdapter implements r<n> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<a<n, ViewHolder>> f35461e;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<Integer> f35462f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f35463g;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35462f = new SparseArray<>();
        this.f35463g = new ArrayList();
    }

    public void a(a<n, ViewHolder> aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getType() == null) {
            return;
        }
        if (this.f35461e == null) {
            this.f35461e = new SparseArray<>();
        }
        if (aVar.getType() != null) {
            aVar.b0(this);
            int id = aVar.getType().getId();
            int size = this.f35461e.size();
            this.f35461e.put(size, aVar);
            this.f35462f.put(id, Integer.valueOf(size));
        }
    }

    public List<n> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35463g : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter, b.a.e.m.e.o
    /* renamed from: c */
    public n getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<n> list = this.f35463g;
            if (list != null) {
                int size = list.size();
                if (i2 < 0 || i2 >= size) {
                    return null;
                }
                return this.f35463g.get(i2);
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    public void d(ViewGroup viewGroup, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{viewGroup, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f35461e == null) {
            return;
        }
        n item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.f35461e.valueAt(itemViewType) : null;
        if (valueAt == null || valueAt.A() == null) {
            return;
        }
        valueAt.A().b(view, item, valueAt.getType(), viewGroup, i2, j);
    }

    public boolean e(ViewGroup viewGroup, View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{viewGroup, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (this.f35461e == null) {
                return false;
            }
            n item = getItem(i2);
            int itemViewType = getItemViewType(i2);
            a<n, ViewHolder> valueAt = itemViewType >= 0 ? this.f35461e.valueAt(itemViewType) : null;
            if (valueAt == null || valueAt.B() == null) {
                return false;
            }
            return valueAt.B().a(view, item, valueAt.getType(), viewGroup, i2, j);
        }
        return invokeCommon.booleanValue;
    }

    public void f(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            List<n> list2 = this.f35463g;
            if (list2 == null) {
                this.f35463g = new ArrayList();
            } else {
                list2.clear();
            }
            this.f35463g.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // b.a.e.m.e.r
    public a<n, ViewHolder> getAdapterByData(n nVar) {
        InterceptResult invokeL;
        SparseArray<a<n, ViewHolder>> sparseArray;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nVar)) == null) {
            if (nVar != null && (sparseArray = this.f35461e) != null) {
                int i2 = -1;
                if (sparseArray.size() != 0 && (type = nVar.getType()) != null && (num = this.f35462f.get(type.getId())) != null) {
                    i2 = num.intValue();
                }
                if (i2 >= 0 && i2 < this.f35461e.size()) {
                    return this.f35461e.get(i2);
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    @Override // android.widget.Adapter, b.a.e.m.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<n> list = this.f35463g;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        n item;
        BdUniqueId type;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            SparseArray<a<n, ViewHolder>> sparseArray = this.f35461e;
            if (sparseArray == null || sparseArray.size() == 0 || (item = getItem(i2)) == null || (type = item.getType()) == null || (num = this.f35462f.get(type.getId())) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    @Override // b.a.e.m.e.r
    public int getPositionByType(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            List<n> list = this.f35463g;
            if (list != null && list.size() != 0) {
                int size = this.f35463g.size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.f35463g.get(i5) != null && this.f35463g.get(i5).getType() != null) {
                        if (i3 == this.f35463g.get(i5).getType().getId()) {
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

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a<n, ViewHolder> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048588, this, i2, view, viewGroup)) == null) {
            View view2 = null;
            if (this.f35461e != null && this.f35463g != null) {
                int count = getCount();
                if (i2 >= 0 && i2 < count && (aVar = this.f35461e.get(getItemViewType(i2))) != null) {
                    n item = getItem(i2);
                    if (item != null && (item instanceof n)) {
                        view2 = aVar.L(i2, view, viewGroup, item);
                    }
                    if (view2 == null) {
                        aVar.getClass().getName();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SparseArray<a<n, ViewHolder>> sparseArray = this.f35461e;
            if (sparseArray != null) {
                return sparseArray.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
