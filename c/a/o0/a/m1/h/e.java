package c.a.o0.a.m1.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7341e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.o0.a.p.e.e f7342f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.o0.a.p.e.e eVar, boolean z) {
        super(6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7341e = z;
        this.f7342f = eVar;
    }

    @Override // c.a.o0.a.m1.h.c
    public String d() {
        InterceptResult invokeV;
        c.a.o0.a.c2.f.r0.d params;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.o0.a.p.e.e eVar = this.f7342f;
            if (eVar == null || (params = eVar.getParams()) == null) {
                return null;
            }
            return params.f4630g;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7341e : invokeV.booleanValue;
    }
}
