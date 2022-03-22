package c.a.d.o.e;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ListAdapter f2586b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f2587c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c> f2588d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2589e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f2590f;

    /* renamed from: g  reason: collision with root package name */
    public DataSetObserver f2591g;

    /* renamed from: h  reason: collision with root package name */
    public b f2592h;

    /* loaded from: classes.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
                if (this.a.f2590f != null) {
                    this.a.f2590f.onChanged();
                }
                if (this.a.f2592h != null) {
                    this.a.f2592h.onPreLoad();
                }
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onInvalidated();
                if (this.a.f2590f != null) {
                    this.a.f2590f.onInvalidated();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onPreLoad();
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public Object f2593b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2594c;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f2586b = null;
        this.f2587c = null;
        this.f2588d = null;
        boolean z = false;
        this.f2589e = false;
        this.f2590f = null;
        this.f2591g = null;
        this.f2592h = null;
        this.a = context;
        this.f2587c = new ArrayList<>();
        this.f2588d = new ArrayList<>();
        if (i(this.f2587c) && i(this.f2588d)) {
            z = true;
        }
        this.f2589e = z;
        this.f2591g = new a(this);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                return this.f2589e && listAdapter.areAllItemsEnabled();
            }
            return super.areAllItemsEnabled();
        }
        return invokeV.booleanValue;
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            f(view, null, true, -1);
        }
    }

    public void f(View view, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.a = view;
        cVar.f2593b = obj;
        cVar.f2594c = z;
        if (i >= 0 && i <= this.f2588d.size()) {
            this.f2588d.add(i, cVar);
        } else {
            this.f2588d.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void g(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i) == null) {
            h(view, null, true, i);
        }
    }

    @Override // android.widget.Adapter, c.a.d.o.e.o
    public int getCount() {
        InterceptResult invokeV;
        int l;
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f2586b != null) {
                l = l() + n();
                n = this.f2586b.getCount();
            } else {
                l = l();
                n = n();
            }
            return l + n;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter, c.a.d.o.e.o
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int n = n();
            if (i < n) {
                return this.f2587c.get(i).f2593b;
            }
            int i2 = i - n;
            int i3 = 0;
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                return this.f2586b.getItem(i2);
            }
            int i4 = i2 - i3;
            if (i4 < 0 || i4 >= this.f2588d.size()) {
                return null;
            }
            return this.f2588d.get(i4).f2593b;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            int n = n();
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter == null || i < n || (i2 = i - n) >= listAdapter.getCount()) {
                return Long.MIN_VALUE;
            }
            return this.f2586b.getItemId(i2);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int n = n();
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter == null || i < n || (i2 = i - n) >= listAdapter.getCount()) {
                return -2;
            }
            return this.f2586b.getItemViewType(i2);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            int n = n();
            if (i < n) {
                View view2 = this.f2587c.get(i).a;
                return view2 == null ? j() : view2;
            }
            int i2 = i - n;
            int i3 = 0;
            ListAdapter listAdapter = this.f2586b;
            View view3 = null;
            if (listAdapter != null && i2 < (i3 = listAdapter.getCount())) {
                try {
                    view3 = this.f2586b.getView(i2, view, viewGroup);
                } catch (Exception e2) {
                    if (e2.getMessage() != null) {
                        BdLog.detailException(e2);
                        Log.e("BdListAdapter", e2.getMessage());
                        e2.printStackTrace();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                    view3 = this.f2586b.getView(i2, view, viewGroup);
                }
                return view3 == null ? j() : view3;
            }
            try {
                view3 = this.f2588d.get(i2 - i3).a;
            } catch (Exception e3) {
                BdLog.detailException(e3);
            }
            return view3 == null ? j() : view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount() + 1;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public ListAdapter getWrappedAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2586b : (ListAdapter) invokeV.objValue;
    }

    public void h(View view, Object obj, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.a = view;
        cVar.f2593b = obj;
        cVar.f2594c = z;
        if (i >= 0 && i <= this.f2587c.size()) {
            this.f2587c.add(i, cVar);
        } else {
            this.f2587c.add(cVar);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return super.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    public final boolean i(ArrayList<c> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().f2594c) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.f2586b;
            return listAdapter == null || listAdapter.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            int n = n();
            if (i < n) {
                return this.f2587c.get(i).f2594c;
            }
            int i3 = i - n;
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                i2 = listAdapter.getCount();
                if (i3 < i2) {
                    return this.f2586b.isEnabled(i3);
                }
            } else {
                i2 = 0;
            }
            int i4 = i3 - i2;
            if (i4 < 0 || i4 >= this.f2588d.size()) {
                return false;
            }
            return this.f2588d.get(i4).f2594c;
        }
        return invokeI.booleanValue;
    }

    public final View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TextView textView = new TextView(this.a);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0a2d));
            int d2 = c.a.d.f.p.n.d(this.a, 15.0f);
            textView.setPadding(d2, d2, d2, d2);
            return textView;
        }
        return (View) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f2588d.size() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f2588d.size() : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f2587c.size() : invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f2587c.size() : invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, c.a.d.o.e.o
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && c.a.d.f.p.n.B()) {
            super.notifyDataSetChanged();
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                return listAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean p(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view)) == null) {
            boolean z = false;
            if (view == null) {
                return false;
            }
            for (int i = 0; i < this.f2588d.size(); i++) {
                if (this.f2588d.get(i).a == view) {
                    this.f2588d.remove(i);
                    if (i(this.f2587c) && i(this.f2588d)) {
                        z = true;
                    }
                    this.f2589e = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            boolean z = false;
            if (view == null) {
                return false;
            }
            for (int i = 0; i < this.f2587c.size(); i++) {
                if (this.f2587c.get(i).a == view) {
                    this.f2587c.remove(i);
                    if (i(this.f2587c) && i(this.f2588d)) {
                        z = true;
                    }
                    this.f2589e = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void r(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.f2586b;
            this.f2586b = listAdapter;
            if (listAdapter != null) {
                boolean z = listAdapter instanceof Filterable;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dataSetObserver) == null) {
            super.registerDataSetObserver(dataSetObserver);
            this.f2590f = dataSetObserver;
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.f2591g);
            }
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.f2592h = bVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dataSetObserver) == null) {
            super.unregisterDataSetObserver(dataSetObserver);
            this.f2590f = dataSetObserver;
            ListAdapter listAdapter = this.f2586b;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(this.f2591g);
            }
        }
    }
}
