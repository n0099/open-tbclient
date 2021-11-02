package b.a.p0.a.e2.c.j;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends h<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.e2.c.c
    /* renamed from: P */
    public JSONObject m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) ? b.a.p0.a.e2.c.d.c(jSONObject) : (JSONObject) invokeL.objValue;
    }

    @Override // b.a.p0.a.e2.c.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", i2.k());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                v("data", jSONObject.toString());
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.e2.c.j.h
    public HttpRequest w(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) ? b.a.p0.a.c1.a.n().J(this.m, hVar.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // b.a.p0.a.e2.c.j.h
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SwanInterfaceType.OPEN_ID : (SwanInterfaceType) invokeV.objValue;
    }
}
