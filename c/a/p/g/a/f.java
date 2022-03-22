package c.a.p.g.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.p.b;
import c.a.p.g.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p.g.a.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.p.c.b().a() : (String) invokeV.objValue;
    }

    @Override // c.a.p.g.a.i
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d dVar = new d();
            c.a.p.b.e(context).j(dVar);
            if (dVar.b(10000)) {
                d.b c2 = dVar.c();
                if (c2 != null && !TextUtils.isEmpty((CharSequence) c2.a)) {
                    return (String) c2.a;
                }
            } else {
                dVar.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p.g.a.i
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? c.a.p.b.e(context.getApplicationContext()).d() : (String) invokeL.objValue;
    }

    @Override // c.a.p.g.a.i
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? c.a.p.b.e(context.getApplicationContext()).b() : (String) invokeL.objValue;
    }

    @Override // c.a.p.g.a.i
    public JSONArray d(Context context) {
        InterceptResult invokeL;
        T t;
        b.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            d dVar = new d();
            c.a.p.b.e(context).n(dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.a) != 0 && (eVar = (b.e) t) != null && eVar.b() != null) {
                    for (b.f fVar : eVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", fVar.f11612b);
                            jSONObject.put("pkg", fVar.a);
                            jSONObject.put("priority", fVar.f11613c);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                dVar.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // c.a.p.g.a.i
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            d dVar = new d();
            c.a.p.b.e(context).l(dVar);
            if (dVar.b(10000)) {
                d.b c2 = dVar.c();
                if (c2 != null && !TextUtils.isEmpty((CharSequence) c2.a)) {
                    return (String) c2.a;
                }
            } else {
                dVar.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p.g.a.i
    public JSONArray f(Context context) {
        InterceptResult invokeL;
        T t;
        List<c.a.p.i.b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            d dVar = new d();
            c.a.p.c.b().e(context, dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (c.a.p.i.b bVar : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", bVar.a);
                            jSONObject.put("sigs", Arrays.toString(bVar.f11794b));
                            jSONObject.put("vc", bVar.f11795c);
                            jSONObject.put("va", bVar.f11796d);
                            jSONObject.put("installts", bVar.f11797e);
                            jSONObject.put("lstupdatets", bVar.f11798f);
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else {
                dVar.a();
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Override // c.a.p.g.a.i
    public JSONObject g(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            d dVar = new d();
            c.a.p.c.b().c(context, dVar);
            boolean b2 = dVar.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.a) != 0) {
                    c.a.p.i.a aVar = (c.a.p.i.a) t;
                }
            } else {
                dVar.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
