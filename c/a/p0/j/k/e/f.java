package c.a.p0.j.k.e;

import android.content.Context;
import android.os.Bundle;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends c.a.p0.j.k.a<c.a.p0.a.h1.c.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1788637391, "Lc/a/p0/j/k/e/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1788637391, "Lc/a/p0/j/k/e/f;");
                return;
            }
        }
        boolean z = k.f7085a;
    }

    public f() {
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

    public static f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new f() : (f) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, c.a.p0.a.h1.c.e eVar, c.a.p0.a.h1.b bVar, c.a.p0.a.a2.e eVar2, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, eVar, bVar, eVar2, jSONObject)) == null) ? g(context, eVar, bVar, eVar2) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(c.a.p0.a.h1.c.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", eVar.f4666g);
            bundle.putDouble("latitude", eVar.n.f6541e);
            bundle.putDouble("longitude", eVar.n.f6542f);
            bundle.putDouble("scale", eVar.o);
            bundle.putString("name", eVar.D);
            bundle.putString("address", eVar.E);
            bundle.putStringArrayList("ignoredApps", eVar.F);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, c.a.p0.a.h1.c.e eVar, c.a.p0.a.h1.b bVar, c.a.p0.a.a2.e eVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, eVar, bVar, eVar2)) == null) {
            c.a.p0.a.e0.d.g("map", "OpenLocationAction start");
            if (!eVar.isValid()) {
                c.a.p0.a.e0.d.b("map", "model is invalid");
                return false;
            }
            c.a.p0.j.m.a.a3(f(eVar)).f3();
            c.a.p0.a.e0.d.g("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
