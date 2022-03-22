package c.a.p0.w2.q;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.w2.i.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.i.f f20453b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20454c;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<ThreadData> f20455d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f20456e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20457f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<c.a.p0.w2.i.f> f20458g;

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<ThreadData> f20459h;
    public MutableLiveData<ThreadData> i;
    public MutableLiveData<Boolean> j;
    public MutableLiveData<Boolean> k;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    public e() {
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
        this.f20455d = new MutableLiveData<>();
        this.f20458g = new LinkedList<>();
        this.f20459h = new MutableLiveData<>();
        this.i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
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

    public c.a.p0.w2.i.f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20453b : (c.a.p0.w2.i.f) invokeV.objValue;
    }

    public c.a.p0.w2.i.f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.p0.w2.i.f) invokeV.objValue;
    }

    public MutableLiveData<Boolean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (MutableLiveData) invokeV.objValue;
    }

    public Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20456e : (Rect) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f20459h : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20455d : (MutableLiveData) invokeV.objValue;
    }

    public LinkedList<c.a.p0.w2.i.f> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f20458g : (LinkedList) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f20454c : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f20457f : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (MutableLiveData) invokeV.objValue;
    }

    public void n(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f20453b = fVar;
            if (fVar != null) {
                this.f20455d.setValue(fVar.O());
                if (ListUtils.isEmpty(fVar.f())) {
                    return;
                }
                u(fVar.f().get(0));
            }
        }
    }

    public void o(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.a = fVar;
            n(fVar);
            this.f20459h.setValue(null);
            this.f20455d.setValue(fVar.O());
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f20454c = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.j.setValue(Boolean.valueOf(z));
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.l.setValue(Boolean.valueOf(z));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.k.postValue(Boolean.valueOf(z));
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f20457f = z;
        }
    }

    public void u(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, threadData) == null) {
            this.i.setValue(threadData);
        }
    }

    public void v(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
            this.f20456e = rect;
        }
    }

    public void w(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) {
            this.f20459h.setValue(threadData);
        }
    }
}
