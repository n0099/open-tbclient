package c.a.o0.a.e2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
public class c extends h<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String m;
    public final Context n;

    public c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = str;
        this.n = context;
    }

    @Override // c.a.o0.a.e2.c.j.h
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SwanInterfaceType.CHECK_SESSION : (SwanInterfaceType) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.e2.c.c
    /* renamed from: Q */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? c.a.o0.a.e2.c.d.c(jSONObject) : (JSONObject) invokeL.objValue;
    }

    @Override // c.a.o0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_key", this.m);
                jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject.put("host_key_hash", c.a.o0.a.e2.c.d.g());
                String l = c.a.o0.a.c1.a.n().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject.put("host_api_key", l);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? c.a.o0.a.c1.a.n().a(this.n, hVar.C()) : (HttpRequest) invokeL.objValue;
    }
}
