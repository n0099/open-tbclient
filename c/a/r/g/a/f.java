package c.a.r.g.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.r.b;
import c.a.r.g.a.d;
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
/* loaded from: classes.dex */
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

    @Override // c.a.r.g.a.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r.c.b().a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.g.a.i
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d dVar = new d();
            c.a.r.b.f(context).m(dVar);
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

    @Override // c.a.r.g.a.i
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? c.a.r.b.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }

    @Override // c.a.r.g.a.i
    public JSONArray c(Context context) {
        InterceptResult invokeL;
        T t;
        b.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            d dVar = new d();
            c.a.r.b.f(context).q(dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.a) != 0 && (fVar = (b.f) t) != null && fVar.b() != null) {
                    for (b.g gVar : fVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", gVar.f4912b);
                            jSONObject.put("pkg", gVar.a);
                            jSONObject.put("priority", gVar.f4913c);
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

    @Override // c.a.r.g.a.i
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? c.a.r.b.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // c.a.r.g.a.i
    public JSONObject e(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            d dVar = new d();
            c.a.r.c.b().c(context, dVar);
            boolean b2 = dVar.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.a) != 0) {
                    c.a.r.i.a aVar = (c.a.r.i.a) t;
                }
            } else {
                dVar.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // c.a.r.g.a.i
    public String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            d dVar = new d();
            c.a.r.b.f(context).o(dVar);
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

    @Override // c.a.r.g.a.i
    public JSONArray g(Context context) {
        InterceptResult invokeL;
        T t;
        List<c.a.r.i.b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            d dVar = new d();
            c.a.r.c.b().e(context, dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (c.a.r.i.b bVar : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", bVar.a);
                            jSONObject.put("sigs", Arrays.toString(bVar.f5111b));
                            jSONObject.put("vc", bVar.f5112c);
                            jSONObject.put("va", bVar.f5113d);
                            jSONObject.put("installts", bVar.f5114e);
                            jSONObject.put("lstupdatets", bVar.f5115f);
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
}
