package c.k.a.a.b;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_ListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a implements WrapperListAdapter, Filterable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final ArrayList<PLA_ListView.a> f34196j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ListAdapter f34197e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f34198f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f34199g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34200h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f34201i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750316479, "Lc/k/a/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(750316479, "Lc/k/a/a/b/a;");
                return;
            }
        }
        f34196j = new ArrayList<>();
    }

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
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
        this.f34197e = listAdapter;
        this.f34201i = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f34198f = f34196j;
        } else {
            this.f34198f = arrayList;
        }
        if (arrayList2 == null) {
            this.f34199g = f34196j;
        } else {
            this.f34199g = arrayList2;
        }
        this.f34200h = a(this.f34198f) && a(this.f34199g);
    }

    public final boolean a(ArrayList<PLA_ListView.a> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<PLA_ListView.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().f70751c) {
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
            ListAdapter listAdapter = this.f34197e;
            if (listAdapter != null) {
                return this.f34200h && listAdapter.areAllItemsEnabled();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34199g.size() : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34198f.size() : invokeV.intValue;
    }

    public boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f34199g.size(); i2++) {
                if (this.f34199g.get(i2).f70749a == view) {
                    this.f34199g.remove(i2);
                    if (a(this.f34198f) && a(this.f34199g)) {
                        z = true;
                    }
                    this.f34200h = z;
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
            for (int i2 = 0; i2 < this.f34198f.size(); i2++) {
                if (this.f34198f.get(i2).f70749a == view) {
                    this.f34198f.remove(i2);
                    if (a(this.f34198f) && a(this.f34199g)) {
                        z = true;
                    }
                    this.f34200h = z;
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
            if (this.f34197e != null) {
                b2 = b() + c();
                c2 = this.f34197e.getCount();
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
            if (this.f34201i) {
                return ((Filterable) this.f34197e).getFilter();
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
                return this.f34198f.get(i2).f70750b;
            }
            int i3 = i2 - c2;
            int i4 = 0;
            ListAdapter listAdapter = this.f34197e;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f34197e.getItem(i3);
            }
            return this.f34199g.get(i3 - i4).f70750b;
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
            ListAdapter listAdapter = this.f34197e;
            if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
                return -1L;
            }
            return this.f34197e.getItemId(i3);
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
            ListAdapter listAdapter = this.f34197e;
            if (listAdapter == null || i2 < c2 || (i3 = i2 - c2) >= listAdapter.getCount()) {
                return -2;
            }
            return this.f34197e.getItemViewType(i3);
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
                return this.f34198f.get(i2).f70749a;
            }
            int i3 = i2 - c2;
            int i4 = 0;
            ListAdapter listAdapter = this.f34197e;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f34197e.getView(i3, view, viewGroup);
            }
            return this.f34199g.get(i3 - i4).f70749a;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.f34197e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34197e : (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.f34197e;
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
            ListAdapter listAdapter = this.f34197e;
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
                return this.f34198f.get(i2).f70751c;
            }
            int i3 = i2 - c2;
            int i4 = 0;
            ListAdapter listAdapter = this.f34197e;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f34197e.isEnabled(i3);
            }
            return this.f34199g.get(i3 - i4).f70751c;
        }
        return invokeI.booleanValue;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, dataSetObserver) == null) || (listAdapter = this.f34197e) == null) {
            return;
        }
        listAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, dataSetObserver) == null) || (listAdapter = this.f34197e) == null) {
            return;
        }
        listAdapter.unregisterDataSetObserver(dataSetObserver);
    }
}
