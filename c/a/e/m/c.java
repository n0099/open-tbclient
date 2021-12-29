package c.a.e.m;

import c.a.s0.e1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public int f3492b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3493c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3494d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3495e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f3496f;

    public c(int i2, int i3, String str, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f3495e = str;
        this.f3492b = i4;
        this.f3493c = i5;
        this.f3494d = i6;
    }

    public static a h(int i2, int i3, String str, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? new c(i2, i3, str, i4, i5, i6) : (a) invokeCommon.objValue;
    }

    @Override // c.a.e.m.a
    public void a(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            this.f3496f = hashMap;
            if (hashMap.containsKey(AdExtParam.KEY_IADEX)) {
                return;
            }
            hashMap.put(AdExtParam.KEY_IADEX, h.e());
        }
    }

    @Override // c.a.e.m.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3492b : invokeV.intValue;
    }

    @Override // c.a.e.m.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // c.a.e.m.a
    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3496f : (Map) invokeV.objValue;
    }

    @Override // c.a.e.m.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f3494d : invokeV.intValue;
    }

    @Override // c.a.e.m.a
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3493c : invokeV.intValue;
    }

    @Override // c.a.e.m.a
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3495e : (String) invokeV.objValue;
    }
}
