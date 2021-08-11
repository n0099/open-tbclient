package c.a.p0.i2.o;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import c.a.o0.s.q.c2;
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
    public c.a.p0.i2.h.e f19677a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.i2.h.e f19678b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19679c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<c2> f19680d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f19681e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19682f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<c.a.p0.i2.h.e> f19683g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<c2> f19684h;

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<c2> f19685i;

    /* renamed from: j  reason: collision with root package name */
    public MutableLiveData<Boolean> f19686j;
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
        this.f19680d = new MutableLiveData<>();
        this.f19683g = new LinkedList<>();
        this.f19684h = new MutableLiveData<>();
        this.f19685i = new MutableLiveData<>();
        this.f19686j = new MutableLiveData<>();
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

    public c.a.p0.i2.h.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19678b : (c.a.p0.i2.h.e) invokeV.objValue;
    }

    public c.a.p0.i2.h.e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19677a : (c.a.p0.i2.h.e) invokeV.objValue;
    }

    public MutableLiveData<Boolean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19686j : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<c2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19685i : (MutableLiveData) invokeV.objValue;
    }

    public Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19681e : (Rect) invokeV.objValue;
    }

    public MutableLiveData<c2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f19684h : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<c2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19680d : (MutableLiveData) invokeV.objValue;
    }

    public LinkedList<c.a.p0.i2.h.e> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19683g : (LinkedList) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19679c : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f19682f : invokeV.booleanValue;
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

    public void o(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.f19678b = eVar;
            if (eVar != null) {
                this.f19680d.setValue(eVar.O());
                if (ListUtils.isEmpty(eVar.f())) {
                    return;
                }
                v(eVar.f().get(0));
            }
        }
    }

    public void p(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f19677a = eVar;
            o(eVar);
            this.f19684h.setValue(null);
            this.f19680d.setValue(eVar.O());
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f19679c = z;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f19686j.setValue(Boolean.valueOf(z));
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
            this.f19682f = z;
        }
    }

    public void v(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, c2Var) == null) {
            this.f19685i.setValue(c2Var);
        }
    }

    public void w(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rect) == null) {
            this.f19681e = rect;
        }
    }

    public void x(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, c2Var) == null) {
            this.f19684h.setValue(c2Var);
        }
    }
}
