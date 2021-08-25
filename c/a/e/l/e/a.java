package c.a.e.l.e;

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
    public Context f2966e;

    /* renamed from: f  reason: collision with root package name */
    public w f2967f;

    /* renamed from: g  reason: collision with root package name */
    public x f2968g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f2969h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f2970i;

    /* renamed from: j  reason: collision with root package name */
    public r<n> f2971j;
    public V k;
    public c.a.e.l.c.a l;

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
        this.f2966e = context;
        this.f2969h = bdUniqueId;
        this.l = new c.a.e.l.c.a();
    }

    public w A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2967f : (w) invokeV.objValue;
    }

    public x B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2968g : (x) invokeV.objValue;
    }

    public int D(int i2) {
        InterceptResult invokeI;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            r<n> rVar = this.f2971j;
            if (rVar == null || (bdUniqueId = this.f2969h) == null) {
                return -1;
            }
            return rVar.getPositionByType(i2, bdUniqueId.getId());
        }
        return invokeI.intValue;
    }

    public c.a.e.l.c.c J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.l.a(i2) : (c.a.e.l.c.c) invokeI.objValue;
    }

    public BdUniqueId K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2969h : (BdUniqueId) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: c.a.e.l.e.a<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View L(int i2, View view, ViewGroup viewGroup, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t})) == null) {
            if (O(view)) {
                V v = (V) V(viewGroup, t);
                this.k = v;
                view = v.getView();
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("convertView is creating" + this.k.getClass().getName());
                }
            }
            View view2 = view;
            return a0(i2, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public boolean N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.l.b(i2) : invokeI.booleanValue;
    }

    public final boolean O(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) ? view == null || view.getTag() == null || (v = this.k) == null || !v.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.k.getClass()) : invokeL.booleanValue;
    }

    public void P() {
        r<n> rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (rVar = this.f2971j) == null) {
            return;
        }
        rVar.notifyDataSetChanged();
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

    public V T(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public abstract V U(ViewGroup viewGroup);

    public V V(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, viewGroup, t)) == null) ? U(viewGroup) : (V) invokeLL.objValue;
    }

    public View W(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? a0(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View X(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? a0(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View Y(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? a0(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View Z(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) ? a0(i2, view, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public abstract View a0(int i2, View view, ViewGroup viewGroup, T t, V v);

    public void b0(int i2, ViewGroup viewGroup, V v, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), viewGroup, v, t}) == null) {
            a0(i2, v.getView(), viewGroup, t, v);
        }
    }

    public void c0(r<n> rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rVar) == null) {
            this.f2971j = rVar;
        }
    }

    public void d0(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, wVar) == null) {
            this.f2967f = wVar;
        }
    }

    public void e0(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, xVar) == null) {
            this.f2968g = xVar;
        }
    }

    public void f0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.f2970i = bdUniqueId;
        }
    }

    public boolean g0(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048601, this, i2, i3, i4)) == null) ? this.l.c(i2, i3, i4) : invokeIII.booleanValue;
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
            r<n> rVar = this.f2971j;
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
        this.f2966e = context;
        this.f2969h = bdUniqueId;
        this.f2970i = bdUniqueId2;
        this.l = new c.a.e.l.c.a();
    }
}
