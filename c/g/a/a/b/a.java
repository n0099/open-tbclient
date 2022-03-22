package c.g.a.a.b;

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
/* loaded from: classes3.dex */
public class a implements WrapperListAdapter, Filterable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final ArrayList<PLA_ListView.a> f23321f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ListAdapter a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f23322b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<PLA_ListView.a> f23323c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23324d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f23325e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1536370499, "Lc/g/a/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1536370499, "Lc/g/a/a/b/a;");
                return;
            }
        }
        f23321f = new ArrayList<>();
    }

    public a(ArrayList<PLA_ListView.a> arrayList, ArrayList<PLA_ListView.a> arrayList2, ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, arrayList2, listAdapter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = listAdapter;
        this.f23325e = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.f23322b = f23321f;
        } else {
            this.f23322b = arrayList;
        }
        if (arrayList2 == null) {
            this.f23323c = f23321f;
        } else {
            this.f23323c = arrayList2;
        }
        this.f23324d = a(this.f23322b) && a(this.f23323c);
    }

    public final boolean a(ArrayList<PLA_ListView.a> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<PLA_ListView.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().f38771c) {
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
            ListAdapter listAdapter = this.a;
            if (listAdapter != null) {
                return this.f23324d && listAdapter.areAllItemsEnabled();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23323c.size() : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23322b.size() : invokeV.intValue;
    }

    public boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            boolean z = false;
            for (int i = 0; i < this.f23323c.size(); i++) {
                if (this.f23323c.get(i).a == view) {
                    this.f23323c.remove(i);
                    if (a(this.f23322b) && a(this.f23323c)) {
                        z = true;
                    }
                    this.f23324d = z;
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
            for (int i = 0; i < this.f23322b.size(); i++) {
                if (this.f23322b.get(i).a == view) {
                    this.f23322b.remove(i);
                    if (a(this.f23322b) && a(this.f23323c)) {
                        z = true;
                    }
                    this.f23324d = z;
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
            if (this.a != null) {
                b2 = b() + c();
                c2 = this.a.getCount();
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
            if (this.f23325e) {
                return ((Filterable) this.a).getFilter();
            }
            return null;
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            int c2 = c();
            if (i < c2) {
                return this.f23322b.get(i).f38770b;
            }
            int i2 = i - c2;
            int i3 = 0;
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.a.getItem(i2);
            }
            return this.f23323c.get(i2 - i3).f38770b;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int c2 = c();
            ListAdapter listAdapter = this.a;
            if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
                return -1L;
            }
            return this.a.getItemId(i2);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int c2 = c();
            ListAdapter listAdapter = this.a;
            if (listAdapter == null || i < c2 || (i2 = i - c2) >= listAdapter.getCount()) {
                return -2;
            }
            return this.a.getItemViewType(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view, viewGroup)) == null) {
            int c2 = c();
            if (i < c2) {
                return this.f23322b.get(i).a;
            }
            int i2 = i - c2;
            int i3 = 0;
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.a.getView(i2, view, viewGroup);
            }
            return this.f23323c.get(i2 - i3).a;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (ListAdapter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.a;
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
            ListAdapter listAdapter = this.a;
            return listAdapter == null || listAdapter.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            int c2 = c();
            if (i < c2) {
                return this.f23322b.get(i).f38771c;
            }
            int i2 = i - c2;
            int i3 = 0;
            ListAdapter listAdapter = this.a;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.a.isEnabled(i2);
            }
            return this.f23323c.get(i2 - i3).f38771c;
        }
        return invokeI.booleanValue;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, dataSetObserver) == null) || (listAdapter = this.a) == null) {
            return;
        }
        listAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, dataSetObserver) == null) || (listAdapter = this.a) == null) {
            return;
        }
        listAdapter.unregisterDataSetObserver(dataSetObserver);
    }
}
