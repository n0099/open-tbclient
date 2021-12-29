package c.a.t0.h.b;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.q.o0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements n, c.a.t0.h.c, o0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static SparseArray<BdUniqueId> f18396g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Object f18397e;

    /* renamed from: f  reason: collision with root package name */
    public int f18398f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(201288890, "Lc/a/t0/h/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(201288890, "Lc/a/t0/h/b/b;");
                return;
            }
        }
        f18396g = new SparseArray<>();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void d(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || f18396g.size() > 0 || list == null) {
            return;
        }
        for (Integer num : list) {
            f18396g.put(num.intValue(), BdUniqueId.gen());
        }
    }

    public static List<BdUniqueId> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < f18396g.size(); i2++) {
                arrayList.add(f18396g.valueAt(i2));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static int h(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        int indexOfValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdUniqueId)) == null) {
            if (f18396g.size() == 0 || (indexOfValue = f18396g.indexOfValue(bdUniqueId)) == -1 || f18396g.size() <= indexOfValue) {
                return -1;
            }
            return f18396g.keyAt(indexOfValue);
        }
        return invokeL.intValue;
    }

    @Override // c.a.t0.h.c
    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18397e : invokeV.objValue;
    }

    @Override // c.a.s0.s.q.o0
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.s.q.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (a() instanceof AdvertAppInfo) {
                return ((o0) a()).f();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18398f : invokeV.intValue;
    }

    @Override // c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f18396g.get(this.f18398f) : (BdUniqueId) invokeV.objValue;
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            this.f18397e = obj;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f18398f = i2;
        }
    }

    @Override // c.a.s0.s.q.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (a() instanceof o0) {
                return (AdvertAppInfo) a();
            }
            return null;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.s0.s.q.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (a() instanceof o0)) {
            ((o0) a()).setPosition(i2);
        }
    }
}
