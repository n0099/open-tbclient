package c.a.n0.m.f.e;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c.a.n0.m.f.a<c.a.n0.a.y0.c.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699384015, "Lc/a/n0/m/f/e/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699384015, "Lc/a/n0/m/f/e/f;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    @Override // c.a.n0.m.f.a
    /* renamed from: d */
    public boolean b(Context context, c.a.n0.a.y0.c.e eVar, c.a.n0.a.y0.b bVar, c.a.n0.a.t1.e eVar2, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, eVar, bVar, eVar2, jSONObject)) == null) ? g(context, eVar, bVar, eVar2) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(c.a.n0.a.y0.c.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", eVar.f6097c);
            bundle.putDouble("latitude", eVar.j.a);
            bundle.putDouble("longitude", eVar.j.f7704b);
            bundle.putDouble(AnimationProperty.SCALE, eVar.k);
            bundle.putString("name", eVar.z);
            bundle.putString("address", eVar.A);
            bundle.putStringArrayList("ignoredApps", eVar.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, c.a.n0.a.y0.c.e eVar, c.a.n0.a.y0.b bVar, c.a.n0.a.t1.e eVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, eVar, bVar, eVar2)) == null) {
            c.a.n0.a.u.d.i("map", "OpenLocationAction start");
            if (!eVar.isValid()) {
                c.a.n0.a.u.d.c("map", "model is invalid");
                return false;
            }
            c.a.n0.m.h.a.p3(f(eVar)).t3();
            c.a.n0.a.u.d.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
