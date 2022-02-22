package c.a.s0.a.u.e.o.a;

import androidx.annotation.NonNull;
import c.a.s0.a.g1.f;
import c.a.s0.a.h0.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1875361862, "Lc/a/s0/a/u/e/o/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1875361862, "Lc/a/s0/a/u/e/o/a/a;");
                return;
            }
        }
        a = c.a.s0.a.d2.e.z;
    }

    public a() {
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

    @Override // c.a.s0.a.u.e.o.a.c
    public c.a.s0.a.u.h.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c.a.s0.a.d2.e.a0() == null) {
                boolean z = a;
                return d(1001);
            }
            g V = f.U().V();
            if (V == null) {
                boolean z2 = a;
                return d(1001);
            }
            c.a.s0.a.h0.g.d m = V.m();
            if (m == null) {
                boolean z3 = a;
                return d(1001);
            }
            return c(m);
        }
        return (c.a.s0.a.u.h.b) invokeV.objValue;
    }

    public JSONObject b(int i2, int i3, int i4, int i5) throws JSONException {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("width", Integer.valueOf(i4 - i2));
            jSONObject.putOpt("height", Integer.valueOf(i5 - i3));
            jSONObject.putOpt("left", Integer.valueOf(i2));
            jSONObject.putOpt("right", Integer.valueOf(i4));
            jSONObject.putOpt("top", Integer.valueOf(i3));
            jSONObject.putOpt("bottom", Integer.valueOf(i5));
            return jSONObject;
        }
        return (JSONObject) invokeIIII.objValue;
    }

    public abstract c.a.s0.a.u.h.b c(@NonNull c.a.s0.a.h0.g.d dVar);

    public abstract c.a.s0.a.u.h.b d(int i2);
}
