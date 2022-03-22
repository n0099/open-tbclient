package c.a.n0.a.d1;

import android.graphics.Bitmap;
import c.a.n0.a.d2.i;
import c.a.n0.a.d2.n;
import c.a.n0.a.v0.e.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(d dVar, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{dVar, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e2 = c.e();
            if (dVar != null) {
                try {
                    e2.put("page", dVar.f4091b);
                } catch (JSONException e3) {
                    if (c.a.n0.a.t1.e.v) {
                        e3.printStackTrace();
                    }
                }
            }
            e2.put("firstPage", z2);
            if (z && bitmap != null) {
                e2.put("image", c.c(bitmap));
            }
            return e2;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (dVar != null) {
                try {
                    jSONObject.put("isH5Componet", dVar.f4096g == 0 ? "0" : "1");
                } catch (JSONException e2) {
                    if (c.a.n0.a.t1.e.v) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(d dVar, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{dVar, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(dVar, i, false, null, z, i2);
        }
    }

    public static void d(d dVar, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{dVar, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
            aVar.k(5L);
            aVar.i(i);
            if (!i.f4140d || z2) {
                aVar.f(a(dVar, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            c.a.n0.a.d2.s.d dVar2 = new c.a.n0.a.d2.s.d();
            dVar2.p(aVar);
            dVar2.q(n.n(c.a.n0.a.t1.d.J().l()));
            dVar2.m(c.a.n0.a.t1.d.J().getAppId());
            dVar2.s = dVar.f4091b;
            dVar2.n(false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            b.a V = a0 == null ? null : a0.V();
            if (!i.f4140d || z2) {
                dVar2.s(valueOf);
                dVar2.r(V);
                dVar2.e(b(dVar));
                dVar2.e(c.a.n0.a.c2.a.d().e());
                dVar2.e(c.a.n0.a.c2.a.d().g());
            }
            n.R(dVar2);
        }
    }
}
