package b.a.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f2719a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2720b;

    /* renamed from: c  reason: collision with root package name */
    public int f2721c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap f2722d;

    public c(int i2, int i3, int i4, String str, String str2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2719a = i2;
        this.f2720b = i3;
        this.f2721c = i5;
    }

    public static h f(int i2, int i3, int i4, String str, String str2, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, Integer.valueOf(i5)})) == null) ? new c(i2, i3, i4, str, str2, i5) : (h) invokeCommon.objValue;
    }

    @Override // b.a.f.h
    public void a(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
            this.f2722d = hashMap;
            if (hashMap.containsKey("iadex")) {
                return;
            }
            hashMap.put("iadex", b.a.q0.d1.f.e());
        }
    }

    @Override // b.a.f.h
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2721c : invokeV.intValue;
    }

    @Override // b.a.f.h
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2719a : invokeV.intValue;
    }

    @Override // b.a.f.h
    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2722d : (Map) invokeV.objValue;
    }

    @Override // b.a.f.h
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2720b : invokeV.intValue;
    }
}
