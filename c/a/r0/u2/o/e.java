package c.a.r0.u2.o;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import c.a.q0.r.r.e2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.u2.h.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.u2.h.f f23951b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23952c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<e2> f23953d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f23954e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23955f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<c.a.r0.u2.h.f> f23956g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<e2> f23957h;

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<e2> f23958i;

    /* renamed from: j  reason: collision with root package name */
    public MutableLiveData<Boolean> f23959j;
    public MutableLiveData<Boolean> k;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    public e() {
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
        this.f23953d = new MutableLiveData<>();
        this.f23956g = new LinkedList<>();
        this.f23957h = new MutableLiveData<>();
        this.f23958i = new MutableLiveData<>();
        this.f23959j = new MutableLiveData<>();
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

    public c.a.r0.u2.h.f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23951b : (c.a.r0.u2.h.f) invokeV.objValue;
    }

    public c.a.r0.u2.h.f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.r0.u2.h.f) invokeV.objValue;
    }

    public MutableLiveData<Boolean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23959j : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<e2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23958i : (MutableLiveData) invokeV.objValue;
    }

    public Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23954e : (Rect) invokeV.objValue;
    }

    public MutableLiveData<e2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23957h : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<e2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23953d : (MutableLiveData) invokeV.objValue;
    }

    public LinkedList<c.a.r0.u2.h.f> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f23956g : (LinkedList) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23952c : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f23955f : invokeV.booleanValue;
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

    public void o(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.f23951b = fVar;
            if (fVar != null) {
                this.f23953d.setValue(fVar.O());
                if (ListUtils.isEmpty(fVar.f())) {
                    return;
                }
                v(fVar.f().get(0));
            }
        }
    }

    public void p(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            this.a = fVar;
            o(fVar);
            this.f23957h.setValue(null);
            this.f23953d.setValue(fVar.O());
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f23952c = z;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f23959j.setValue(Boolean.valueOf(z));
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
            this.f23955f = z;
        }
    }

    public void v(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, e2Var) == null) {
            this.f23958i.setValue(e2Var);
        }
    }

    public void w(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rect) == null) {
            this.f23954e = rect;
        }
    }

    public void x(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, e2Var) == null) {
            this.f23957h.setValue(e2Var);
        }
    }
}
