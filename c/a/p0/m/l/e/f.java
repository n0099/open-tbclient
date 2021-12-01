package c.a.p0.m.l.e;

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
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends c.a.p0.m.l.a<c.a.p0.a.i1.c.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-826544531, "Lc/a/p0/m/l/e/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-826544531, "Lc/a/p0/m/l/e/f;");
                return;
            }
        }
        boolean z = k.a;
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
    @Override // c.a.p0.m.l.a
    /* renamed from: d */
    public boolean b(Context context, c.a.p0.a.i1.c.e eVar, c.a.p0.a.i1.b bVar, c.a.p0.a.d2.e eVar2, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, eVar, bVar, eVar2, jSONObject)) == null) ? g(context, eVar, bVar, eVar2) : invokeLLLLL.booleanValue;
    }

    public final Bundle f(c.a.p0.a.i1.c.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", eVar.f4378g);
            bundle.putDouble("latitude", eVar.n.f6330e);
            bundle.putDouble("longitude", eVar.n.f6331f);
            bundle.putDouble(AnimationProperty.SCALE, eVar.o);
            bundle.putString("name", eVar.D);
            bundle.putString("address", eVar.E);
            bundle.putStringArrayList("ignoredApps", eVar.F);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, c.a.p0.a.i1.c.e eVar, c.a.p0.a.i1.b bVar, c.a.p0.a.d2.e eVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, eVar, bVar, eVar2)) == null) {
            c.a.p0.a.e0.d.i("map", "OpenLocationAction start");
            if (!eVar.isValid()) {
                c.a.p0.a.e0.d.c("map", "model is invalid");
                return false;
            }
            c.a.p0.m.n.a.s3(f(eVar)).w3();
            c.a.p0.a.e0.d.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
