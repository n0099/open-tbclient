package b.a.p0.a.u.e.o.a;

import androidx.annotation.NonNull;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8896a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1802821694, "Lb/a/p0/a/u/e/o/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1802821694, "Lb/a/p0/a/u/e/o/a/a;");
                return;
            }
        }
        f8896a = b.a.p0.a.d2.e.z;
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

    @Override // b.a.p0.a.u.e.o.a.c
    public b.a.p0.a.u.h.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (b.a.p0.a.d2.e.a0() == null) {
                boolean z = f8896a;
                return d(1001);
            }
            g V = f.U().V();
            if (V == null) {
                boolean z2 = f8896a;
                return d(1001);
            }
            b.a.p0.a.h0.g.d m = V.m();
            if (m == null) {
                boolean z3 = f8896a;
                return d(1001);
            }
            return c(m);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public JSONObject b(int i2, int i3, int i4, int i5) throws JSONException {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("width", Integer.valueOf(i4 - i2));
            jSONObject.putOpt("height", Integer.valueOf(i5 - i3));
            jSONObject.putOpt("left", Integer.valueOf(i2));
            jSONObject.putOpt(HorizontalTranslateLayout.RIGHT, Integer.valueOf(i4));
            jSONObject.putOpt(VerticalTranslateLayout.TOP, Integer.valueOf(i3));
            jSONObject.putOpt("bottom", Integer.valueOf(i5));
            return jSONObject;
        }
        return (JSONObject) invokeIIII.objValue;
    }

    public abstract b.a.p0.a.u.h.b c(@NonNull b.a.p0.a.h0.g.d dVar);

    public abstract b.a.p0.a.u.h.b d(int i2);
}
