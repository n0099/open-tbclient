package b.a.r.f.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.r.b;
import b.a.r.f.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // b.a.r.f.a.i
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? b.a.r.b.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // b.a.r.f.a.i
    public JSONArray b(Context context) {
        InterceptResult invokeL;
        T t;
        b.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d dVar = new d();
            b.a.r.b.e(context).n(dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b a2 = dVar.a();
                if (a2 != null && (t = a2.f14464a) != 0 && (eVar = (b.e) t) != null && eVar.b() != null) {
                    for (b.f fVar : eVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", fVar.f14345b);
                            jSONObject.put("pkg", fVar.f14344a);
                            jSONObject.put("priority", fVar.f14346c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                dVar.c();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // b.a.r.f.a.i
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            d dVar = new d();
            b.a.r.b.e(context).m(dVar);
            if (!dVar.b(10000)) {
                dVar.c();
                return null;
            }
            d.b a2 = dVar.a();
            if (a2 == null || TextUtils.isEmpty((CharSequence) a2.f14464a)) {
                return null;
            }
            return (String) a2.f14464a;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.r.f.a.i
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            d dVar = new d();
            b.a.r.b.e(context).k(dVar);
            if (!dVar.b(10000)) {
                dVar.c();
                return null;
            }
            d.b a2 = dVar.a();
            if (a2 == null || TextUtils.isEmpty((CharSequence) a2.f14464a)) {
                return null;
            }
            return (String) a2.f14464a;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.r.f.a.i
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? b.a.r.b.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }
}
