package c.a.d.m.e;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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

    /* renamed from: e  reason: collision with root package name */
    public Context f2927e;

    /* renamed from: f  reason: collision with root package name */
    public ListAdapter f2928f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f2929g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c> f2930h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2931i;

    /* renamed from: j  reason: collision with root package name */
    public DataSetObserver f2932j;

    /* renamed from: k  reason: collision with root package name */
    public DataSetObserver f2933k;
    public b l;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.f2932j != null) {
                    this.a.f2932j.onChanged();
                }
                if (this.a.l != null) {
                    this.a.l.onPreLoad();
                }
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onInvalidated();
                if (this.a.f2932j != null) {
                    this.a.f2932j.onInvalidated();
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
        public Object f2934b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2935c;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2927e = null;
        this.f2928f = null;
        this.f2929g = null;
        this.f2930h = null;
        boolean z = false;
        this.f2931i = false;
        this.f2932j = null;
        this.f2933k = null;
        this.l = null;
        this.f2927e = context;
        this.f2929g = new ArrayList<>();
        this.f2930h = new ArrayList<>();
        if (g(this.f2929g) && g(this.f2930h)) {
            z = true;
        }
        this.f2931i = z;
        this.f2933k = new a(this);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null) {
                return this.f2931i && listAdapter.areAllItemsEnabled();
            }
            return super.areAllItemsEnabled();
        }
        return invokeV.booleanValue;
    }

    public void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            d(view, null, true, -1);
        }
    }

    public void d(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.a = view;
        cVar.f2934b = obj;
        cVar.f2935c = z;
        if (i2 >= 0 && i2 <= this.f2930h.size()) {
            this.f2930h.add(i2, cVar);
        } else {
            this.f2930h.add(cVar);
        }
        notifyDataSetChanged();
    }

    public void e(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            f(view, null, true, i2);
        }
    }

    public void f(View view, Object obj, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, obj, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || view == null) {
            return;
        }
        c cVar = new c(this);
        cVar.a = view;
        cVar.f2934b = obj;
        cVar.f2935c = z;
        if (i2 >= 0 && i2 <= this.f2929g.size()) {
            this.f2929g.add(i2, cVar);
        } else {
            this.f2929g.add(cVar);
        }
        notifyDataSetChanged();
    }

    public final boolean g(ArrayList<c> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!it.next().f2935c) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter, c.a.d.m.e.o
    public int getCount() {
        InterceptResult invokeV;
        int j2;
        int l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f2928f != null) {
                j2 = j() + l();
                l = this.f2928f.getCount();
            } else {
                j2 = j();
                l = l();
            }
            return j2 + l;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter, c.a.d.m.e.o
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int l = l();
            if (i2 < l) {
                return this.f2929g.get(i2).f2934b;
            }
            int i3 = i2 - l;
            int i4 = 0;
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                return this.f2928f.getItem(i3);
            }
            int i5 = i3 - i4;
            if (i5 < 0 || i5 >= this.f2930h.size()) {
                return null;
            }
            return this.f2930h.get(i5).f2934b;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            int l = l();
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter == null || i2 < l || (i3 = i2 - l) >= listAdapter.getCount()) {
                return Long.MIN_VALUE;
            }
            return this.f2928f.getItemId(i3);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int l = l();
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter == null || i2 < l || (i3 = i2 - l) >= listAdapter.getCount()) {
                return -2;
            }
            return this.f2928f.getItemViewType(i3);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            int l = l();
            if (i2 < l) {
                View view2 = this.f2929g.get(i2).a;
                return view2 == null ? h() : view2;
            }
            int i3 = i2 - l;
            int i4 = 0;
            ListAdapter listAdapter = this.f2928f;
            View view3 = null;
            if (listAdapter != null && i3 < (i4 = listAdapter.getCount())) {
                try {
                    view3 = this.f2928f.getView(i3, view, viewGroup);
                } catch (Exception e2) {
                    if (e2.getMessage() != null) {
                        BdLog.detailException(e2);
                        e2.getMessage();
                        e2.printStackTrace();
                    }
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                    view3 = this.f2928f.getView(i3, view, viewGroup);
                }
                return view3 == null ? h() : view3;
            }
            try {
                view3 = this.f2930h.get(i3 - i4).a;
            } catch (Exception e3) {
                BdLog.detailException(e3);
            }
            return view3 == null ? h() : view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ListAdapter listAdapter = this.f2928f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f2928f : (ListAdapter) invokeV.objValue;
    }

    public final View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TextView textView = new TextView(this.f2927e);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
            int d2 = c.a.d.f.p.l.d(this.f2927e, 15.0f);
            textView.setPadding(d2, d2, d2, d2);
            return textView;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null) {
                return listAdapter.hasStableIds();
            }
            return super.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f2930h.size() : invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ListAdapter listAdapter = this.f2928f;
            return listAdapter == null || listAdapter.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            int l = l();
            if (i2 < l) {
                return this.f2929g.get(i2).f2935c;
            }
            int i4 = i2 - l;
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null) {
                i3 = listAdapter.getCount();
                if (i4 < i3) {
                    return this.f2928f.isEnabled(i4);
                }
            } else {
                i3 = 0;
            }
            int i5 = i4 - i3;
            if (i5 < 0 || i5 >= this.f2930h.size()) {
                return false;
            }
            return this.f2930h.get(i5).f2935c;
        }
        return invokeI.booleanValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f2930h.size() : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f2929g.size() : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f2929g.size() : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null) {
                return listAdapter.getCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean n(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view)) == null) {
            boolean z = false;
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2930h.size(); i2++) {
                if (this.f2930h.get(i2).a == view) {
                    this.f2930h.remove(i2);
                    if (g(this.f2929g) && g(this.f2930h)) {
                        z = true;
                    }
                    this.f2931i = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.BaseAdapter, c.a.d.m.e.o
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && c.a.d.f.p.l.B()) {
            super.notifyDataSetChanged();
        }
    }

    public boolean o(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            boolean z = false;
            if (view == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2929g.size(); i2++) {
                if (this.f2929g.get(i2).a == view) {
                    this.f2929g.remove(i2);
                    if (g(this.f2929g) && g(this.f2930h)) {
                        z = true;
                    }
                    this.f2931i = z;
                    notifyDataSetChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, listAdapter) == null) {
            ListAdapter listAdapter2 = this.f2928f;
            this.f2928f = listAdapter;
            if (listAdapter != null) {
                boolean z = listAdapter instanceof Filterable;
            }
            notifyDataSetChanged();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, dataSetObserver) == null) {
            super.registerDataSetObserver(dataSetObserver);
            this.f2932j = dataSetObserver;
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(this.f2933k);
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, dataSetObserver) == null) {
            super.unregisterDataSetObserver(dataSetObserver);
            this.f2932j = dataSetObserver;
            ListAdapter listAdapter = this.f2928f;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(this.f2933k);
            }
        }
    }
}
