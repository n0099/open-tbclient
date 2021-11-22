package b.a.r.g.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.r.b;
import b.a.r.g.a.d;
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

    @Override // b.a.r.g.a.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r.c.b().a() : (String) invokeV.objValue;
    }

    @Override // b.a.r.g.a.i
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            d dVar = new d();
            b.a.r.b.f(context).m(dVar);
            if (dVar.b(10000)) {
                d.b c2 = dVar.c();
                if (c2 != null && !TextUtils.isEmpty((CharSequence) c2.f15285a)) {
                    return (String) c2.f15285a;
                }
            } else {
                dVar.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.r.g.a.i
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? b.a.r.b.f(context.getApplicationContext()).e() : (String) invokeL.objValue;
    }

    @Override // b.a.r.g.a.i
    public JSONArray c(Context context) {
        InterceptResult invokeL;
        T t;
        b.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            d dVar = new d();
            b.a.r.b.f(context).q(dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.f15285a) != 0 && (fVar = (b.f) t) != null && fVar.b() != null) {
                    for (b.g gVar : fVar.b()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("aid", gVar.f15114b);
                            jSONObject.put("pkg", gVar.f15113a);
                            jSONObject.put("priority", gVar.f15115c);
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

    @Override // b.a.r.g.a.i
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? b.a.r.b.f(context.getApplicationContext()).c() : (String) invokeL.objValue;
    }

    @Override // b.a.r.g.a.i
    public JSONObject e(Context context) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            d dVar = new d();
            b.a.r.c.b().c(context, dVar);
            boolean b2 = dVar.b(10000);
            JSONObject jSONObject = new JSONObject();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.f15285a) != 0) {
                    b.a.r.i.a aVar = (b.a.r.i.a) t;
                }
            } else {
                dVar.a();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // b.a.r.g.a.i
    public String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            d dVar = new d();
            b.a.r.b.f(context).o(dVar);
            if (dVar.b(10000)) {
                d.b c2 = dVar.c();
                if (c2 != null && !TextUtils.isEmpty((CharSequence) c2.f15285a)) {
                    return (String) c2.f15285a;
                }
            } else {
                dVar.a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.r.g.a.i
    public JSONArray g(Context context) {
        InterceptResult invokeL;
        T t;
        List<b.a.r.i.b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            d dVar = new d();
            b.a.r.c.b().e(context, dVar);
            boolean b2 = dVar.b(10000);
            JSONArray jSONArray = new JSONArray();
            if (b2) {
                d.b c2 = dVar.c();
                if (c2 != null && (t = c2.f15285a) != 0 && (list = (List) t) != null && list.size() > 0) {
                    for (b.a.r.i.b bVar : list) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("pkg", bVar.f15376a);
                            jSONObject.put("sigs", Arrays.toString(bVar.f15377b));
                            jSONObject.put("vc", bVar.f15378c);
                            jSONObject.put("va", bVar.f15379d);
                            jSONObject.put("installts", bVar.f15380e);
                            jSONObject.put("lstupdatets", bVar.f15381f);
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
