package c.a.p0.m.f;

import android.content.Context;
import c.a.p0.a.t1.e;
import c.a.p0.a.y0.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a<T extends c.a.p0.a.y0.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract boolean b(Context context, T t, c.a.p0.a.y0.b bVar, e eVar, JSONObject jSONObject);

    public boolean c(Context context, T t, c.a.p0.a.y0.b bVar, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, t, bVar, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!b(context, t, bVar, eVar, jSONObject)) {
                bVar.d(1001);
                c.a.p0.a.u.d.c("map", "doAction fail");
                return false;
            }
            if (jSONObject.length() <= 0) {
                jSONObject = null;
            }
            bVar.e(jSONObject);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
