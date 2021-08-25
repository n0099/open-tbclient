package c.a.o0.a.h0.i;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f5989a;

    /* renamed from: b  reason: collision with root package name */
    public int f5990b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f5991c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f5992d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.h0.i.a f5993e;

    /* renamed from: f  reason: collision with root package name */
    public long f5994f;

    /* loaded from: classes.dex */
    public interface a {
        void a(@NonNull g gVar);
    }

    public g() {
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
        this.f5990b = 0;
        this.f5991c = new ArrayList();
        this.f5992d = new TreeMap();
        this.f5989a = 0;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5994f : invokeV.longValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.a.h0.i.a aVar = this.f5993e;
            return aVar != null ? aVar.b() : "";
        }
        return (String) invokeV.objValue;
    }

    public c.a.o0.a.h0.i.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5993e : (c.a.o0.a.h0.i.a) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5989a & 3 : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d2 = d();
            return d2 != 0 ? d2 != 1 ? d2 != 2 ? d2 != 3 ? "good" : "unknown" : "offline" : "bad" : "good";
        }
        return (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5989a & 12 : invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int f2 = f();
            return f2 != 0 ? f2 != 4 ? f2 != 8 ? "unknown" : "slow" : "failRate" : "ok";
        }
        return (String) invokeV.objValue;
    }

    public void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f5994f = j2;
        }
    }

    public void i(c.a.o0.a.h0.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f5993e = aVar;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f5989a = i2 | f();
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f5989a = i2 | d();
        }
    }
}
