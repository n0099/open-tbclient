package b.a.r0.i1.b;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class d implements WrapperListAdapter, Filterable {
    public static /* synthetic */ Interceptable $ic;
    public static final ArrayList<HListView.c> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ListAdapter f19353e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<HListView.c> f19354f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<HListView.c> f19355g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19356h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f19357i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-552259295, "Lb/a/r0/i1/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-552259295, "Lb/a/r0/i1/b/d;");
                return;
            }
        }
        j = new ArrayList<>();
    }

    public d(ArrayList<HListView.c> arrayList, ArrayList<HListView.c> arrayList2, ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, arrayList2, listAdapter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f19353e = listAdapter;
        this.f19357i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f19354f = j;
        } else {
            this.f19354f = arrayList;
        }
        if (arrayList2 == null) {
            this.f19355g = j;
        } else {
            this.f19355g = arrayList2;
        }
        this.f19356h = a(this.f19354f) && a(this.f19355g);
    }

    public final boolean a(ArrayList<HListView.c> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<HListView.c> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().f50889c) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter != null) {
                return this.f19356h && listAdapter.areAllItemsEnabled();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19355g.size() : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19354f.size() : invokeV.intValue;
    }

    public boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f19355g.size(); i2++) {
                if (this.f19355g.get(i2).f50887a == view) {
                    this.f19355g.remove(i2);
                    if (a(this.f19354f) && a(this.f19355g)) {
                        z = true;
                    }
                    this.f19356h = z;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f19354f.size(); i2++) {
                if (this.f19354f.get(i2).f50887a == view) {
                    this.f19354f.remove(i2);
                    if (a(this.f19354f) && a(this.f19355g)) {
                        z = true;
                    }
                    this.f19356h = z;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int b2;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f19353e != null) {
                b2 = b() + c();
                c2 = this.f19353e.getCount();
            } else {
                b2 = b();
                c2 = c();
            }
            return b2 + c2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f19357i) {
                return ((Filterable) this.f19353e).getFilter();
            }
            return null;
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int c2 = c();
            if (i2 < c2) {
                return this.f19354f.get(i2).f50888b;
            }
            int i3 = i2 - c2;
            int i4 = 0;
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f19353e.getItem(i3);
            }
            return this.f19355g.get(i3 - i4).f50888b;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int c2 = c();
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
                return -1L;
            }
            return this.f19353e.getItemId(i3);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int c2 = c();
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
                return -2;
            }
            return this.f19353e.getItemViewType(i3);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            int c2 = c();
            if (i2 < c2) {
                return this.f19354f.get(i2).f50887a;
            }
            int i3 = i2 - c2;
            int i4 = 0;
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f19353e.getView(i3, view, viewGroup);
            }
            return this.f19355g.get(i3 - i4).f50887a;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f19353e : (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ListAdapter listAdapter = this.f19353e;
            return listAdapter == null || listAdapter.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            int c2 = c();
            if (i2 < c2) {
                return this.f19354f.get(i2).f50889c;
            }
            int i3 = i2 - c2;
            int i4 = 0;
            ListAdapter listAdapter = this.f19353e;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f19353e.isEnabled(i3);
            }
            return this.f19355g.get(i3 - i4).f50889c;
        }
        return invokeI.booleanValue;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, dataSetObserver) == null) || (listAdapter = this.f19353e) == null) {
            return;
        }
        listAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, dataSetObserver) == null) || (listAdapter = this.f19353e) == null) {
            return;
        }
        listAdapter.unregisterDataSetObserver(dataSetObserver);
    }
}
