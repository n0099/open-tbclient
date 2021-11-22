package b.a.e.m.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f2421e;

    /* renamed from: f  reason: collision with root package name */
    public w f2422f;

    /* renamed from: g  reason: collision with root package name */
    public x f2423g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f2424h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f2425i;
    public r<n> j;
    public V k;
    public b.a.e.m.c.a l;

    public a(Context context, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2421e = context;
        this.f2424h = bdUniqueId;
        this.l = new b.a.e.m.c.a();
    }

    public w A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2422f : (w) invokeV.objValue;
    }

    public x B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2423g : (x) invokeV.objValue;
    }

    public int D(int i2) {
        InterceptResult invokeI;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            r<n> rVar = this.j;
            if (rVar == null || (bdUniqueId = this.f2424h) == null) {
                return -1;
            }
            return rVar.getPositionByType(i2, bdUniqueId.getId());
        }
        return invokeI.intValue;
    }

    public b.a.e.m.c.c K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.l.a(i2) : (b.a.e.m.c.c) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: b.a.e.m.e.a<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View L(int i2, View view, ViewGroup viewGroup, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t})) == null) {
            if (N(view)) {
                V v = (V) U(viewGroup, t);
                this.k = v;
                view = v.getView();
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("convertView is creating" + this.k.getClass().getName());
                }
            }
            View view2 = view;
            return Z(i2, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.l.b(i2) : invokeI.booleanValue;
    }

    public final boolean N(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) ? view == null || view.getTag() == null || (v = this.k) == null || !v.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.k.getClass()) : invokeL.booleanValue;
    }

    public void O() {
        r<n> rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (rVar = this.j) == null) {
            return;
        }
        rVar.notifyDataSetChanged();
    }

    public V P(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V Q(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V R(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V S(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public abstract V T(ViewGroup viewGroup);

    public V U(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, t)) == null) ? T(viewGroup) : (V) invokeLL.objValue;
    }

    public View V(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? Z(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View W(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? Z(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View X(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? Z(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View Y(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? Z(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public abstract View Z(int i2, View view, ViewGroup viewGroup, T t, V v);

    public void a0(int i2, ViewGroup viewGroup, V v, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), viewGroup, v, t}) == null) {
            Z(i2, v.getView(), viewGroup, t, v);
        }
    }

    public void b0(r<n> rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, rVar) == null) {
            this.j = rVar;
        }
    }

    public void c0(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, wVar) == null) {
            this.f2422f = wVar;
        }
    }

    public void d0(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, xVar) == null) {
            this.f2423g = xVar;
        }
    }

    public void e0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            this.f2425i = bdUniqueId;
        }
    }

    public boolean f0(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048600, this, i2, i3, i4)) == null) ? this.l.c(i2, i3, i4) : invokeIII.booleanValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f2424h : (BdUniqueId) invokeV.objValue;
    }

    public ViewGroup.LayoutParams u(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, viewGroup)) == null) {
            if (viewGroup instanceof ListView) {
                return new AbsListView.LayoutParams(-1, -2);
            }
            if (viewGroup instanceof RecyclerView) {
                return new RecyclerView.LayoutParams(-1, -2);
            }
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public n z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            r<n> rVar = this.j;
            if (rVar != null) {
                return rVar.getItem(i2);
            }
            return null;
        }
        return (n) invokeI.objValue;
    }

    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2421e = context;
        this.f2424h = bdUniqueId;
        this.f2425i = bdUniqueId2;
        this.l = new b.a.e.m.c.a();
    }
}
