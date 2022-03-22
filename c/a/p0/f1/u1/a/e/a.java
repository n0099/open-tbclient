package c.a.p0.f1.u1.a.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14715b;

    public a() {
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
        this.f14715b = true;
    }

    public final View a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            e eVar = this.a;
            if (eVar == null) {
                return view;
            }
            if (view == null || view != eVar.getArrowView()) {
                view = this.a.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, d()));
                }
            }
            this.a.a(view);
            return view;
        }
        return (View) invokeL.objValue;
    }

    public abstract int b();

    public abstract Object c(int i);

    public abstract int d();

    public abstract long e(int i);

    public int f(int i) {
        InterceptResult invokeI;
        int arrowIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            e eVar = this.a;
            if (eVar == null || !eVar.b() || i < (arrowIndex = this.a.getArrowIndex())) {
                return i;
            }
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return invokeI.intValue;
    }

    public abstract View g(int i, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (h()) {
                if (this.f14715b) {
                    b2 = this.a.getArrowIndex();
                } else {
                    e eVar = this.a;
                    if (eVar != null && eVar.b()) {
                        b2 = b();
                    } else {
                        return b();
                    }
                }
                return b2 + 1;
            }
            return b();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (h()) {
                int f2 = f(i);
                if (f2 >= 0) {
                    return c(f2);
                }
                return c(i);
            }
            return c(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (h()) {
                int f2 = f(i);
                if (f2 >= 0) {
                    return e(f2);
                }
                return e(i);
            }
            return e(i);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int arrowIndex;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? (h() && (arrowIndex = this.a.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view, viewGroup)) == null) {
            if (getItemViewType(i) == 0) {
                return g(f(i), view, viewGroup);
            }
            return a(view);
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? h() ? 2 : 1 : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            e eVar = this.a;
            return eVar != null && eVar.b() && b() - 1 > this.a.getArrowIndex();
        }
        return invokeV.booleanValue;
    }

    public void i(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.a = eVar;
        }
    }

    public abstract void j(int i);

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f14715b = z;
        }
    }
}
