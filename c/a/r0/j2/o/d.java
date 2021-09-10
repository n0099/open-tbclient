package c.a.r0.j2.o;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.j2.h.e f20565a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j2.h.e f20566b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20567c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<d2> f20568d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f20569e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20570f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<c.a.r0.j2.h.e> f20571g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<d2> f20572h;

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<d2> f20573i;

    /* renamed from: j  reason: collision with root package name */
    public MutableLiveData<Boolean> f20574j;
    public MutableLiveData<Boolean> k;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    public d() {
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
        this.f20568d = new MutableLiveData<>();
        this.f20571g = new LinkedList<>();
        this.f20572h = new MutableLiveData<>();
        this.f20573i = new MutableLiveData<>();
        this.f20574j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        new MutableLiveData();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (MutableLiveData) invokeV.objValue;
    }

    public c.a.r0.j2.h.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20566b : (c.a.r0.j2.h.e) invokeV.objValue;
    }

    public c.a.r0.j2.h.e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20565a : (c.a.r0.j2.h.e) invokeV.objValue;
    }

    public MutableLiveData<Boolean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20574j : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<d2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20573i : (MutableLiveData) invokeV.objValue;
    }

    public Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20569e : (Rect) invokeV.objValue;
    }

    public MutableLiveData<d2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20572h : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<d2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20568d : (MutableLiveData) invokeV.objValue;
    }

    public LinkedList<c.a.r0.j2.h.e> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f20571g : (LinkedList) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f20567c : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20570f : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (MutableLiveData) invokeV.objValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.m.setValue(Integer.valueOf(i2));
        }
    }

    public void o(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.f20566b = eVar;
            if (eVar != null) {
                this.f20568d.setValue(eVar.O());
                if (ListUtils.isEmpty(eVar.f())) {
                    return;
                }
                v(eVar.f().get(0));
            }
        }
    }

    public void p(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f20565a = eVar;
            o(eVar);
            this.f20572h.setValue(null);
            this.f20568d.setValue(eVar.O());
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f20567c = z;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f20574j.setValue(Boolean.valueOf(z));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.l.setValue(Boolean.valueOf(z));
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.k.postValue(Boolean.valueOf(z));
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f20570f = z;
        }
    }

    public void v(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, d2Var) == null) {
            this.f20573i.setValue(d2Var);
        }
    }

    public void w(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rect) == null) {
            this.f20569e = rect;
        }
    }

    public void x(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, d2Var) == null) {
            this.f20572h.setValue(d2Var);
        }
    }
}
