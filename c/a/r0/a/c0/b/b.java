package c.a.r0.a.c0.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.d;
import c.a.r0.a.k;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b implements c.a.r0.a.c0.b.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f5307e;

    /* renamed from: f  reason: collision with root package name */
    public String f5308f;

    /* renamed from: g  reason: collision with root package name */
    public String f5309g;

    /* renamed from: h  reason: collision with root package name */
    public String f5310h;

    /* renamed from: i  reason: collision with root package name */
    public String f5311i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5312j;
    public boolean k;
    @Nullable
    public c.a.r0.a.m1.e.a.a l;
    public String m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1202334063, "Lc/a/r0/a/c0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1202334063, "Lc/a/r0/a/c0/b/b;");
                return;
            }
        }
        boolean z = k.a;
    }

    public b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5307e = "unknown";
        this.f5308f = "";
        this.f5309g = "";
        this.f5310h = "";
        this.f5311i = "";
        this.f5312j = false;
        this.k = false;
        this.m = "id";
        if (!TextUtils.isEmpty(str)) {
            this.f5307e = str;
        } else {
            c.a.r0.a.c0.g.a.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.m = str2;
        } else {
            c.a.r0.a.c0.g.a.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // c.a.r0.a.m1.a
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f5308f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f5308f = jSONObject.optString(this.m);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f5308f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f5308f = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.f5308f)) {
            d.c("Component-Model-Base", this.f5307e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.f5309g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.c("Component-Model-Base", this.f5307e + " component slaveId is empty");
        }
        this.f5310h = jSONObject.optString("parentId");
        this.f5311i = jSONObject.optString("cb");
        this.f5312j = jSONObject.optBoolean("hide", false);
        this.k = TextUtils.equals(jSONObject.optString("gesture"), "1");
        g(jSONObject);
    }

    public final FrameLayout.LayoutParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.a.m1.e.a.a aVar = this.l;
            int g2 = aVar != null ? aVar.g() : -1;
            c.a.r0.a.m1.e.a.a aVar2 = this.l;
            int c2 = aVar2 != null ? aVar2.c() : -1;
            c.a.r0.a.m1.e.a.a aVar3 = this.l;
            int e2 = aVar3 != null ? aVar3.e() : 0;
            c.a.r0.a.m1.e.a.a aVar4 = this.l;
            int f2 = aVar4 != null ? aVar4.f() : 0;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, c2);
            layoutParams.setMargins(e2, f2, 0, 0);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final float c(JSONObject jSONObject, String str, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONObject, str, Float.valueOf(f2)})) == null) ? jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2) : invokeCommon.floatValue;
    }

    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b bVar = (b) super.clone();
            c.a.r0.a.m1.e.a.a aVar = this.l;
            if (aVar != null) {
                bVar.l = (c.a.r0.a.m1.e.a.a) aVar.clone();
            } else {
                bVar.l = null;
            }
            return bVar;
        }
        return invokeV.objValue;
    }

    @NonNull
    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("【");
            sb.append(this.f5307e);
            sb.append("#");
            sb.append(TextUtils.isEmpty(this.f5308f) ? "" : this.f5308f);
            sb.append("】");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void f(JSONObject jSONObject, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, bVar) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f5308f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f5308f = jSONObject.optString(this.m, bVar.f5308f);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f5308f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f5308f = jSONObject.optString("componentId", bVar.f5308f);
            }
        }
        if (TextUtils.isEmpty(this.f5308f)) {
            d.c("Component-Model-Base", this.f5307e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", bVar.f5309g);
        this.f5309g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.c("Component-Model-Base", this.f5307e + " component slaveId is empty");
        }
        this.f5310h = jSONObject.optString("parentId", bVar.f5310h);
        this.f5311i = jSONObject.optString("cb", bVar.f5311i);
        this.f5312j = jSONObject.optBoolean("hide", bVar.f5312j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", bVar.k ? "1" : "0"), "1");
        c.a.r0.a.m1.e.a.a aVar = bVar.l;
        this.l = aVar;
        if (aVar == null) {
            this.l = new c.a.r0.a.m1.e.a.a();
        }
        g(jSONObject);
    }

    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("position")) == null) {
            return;
        }
        c.a.r0.a.m1.e.a.a aVar = new c.a.r0.a.m1.e.a.a();
        this.l = aVar;
        aVar.m(n0.g(c(optJSONObject, "left", 0.0f)));
        this.l.n(n0.g(c(optJSONObject, "top", 0.0f)));
        this.l.o(n0.g(c(optJSONObject, "width", 0.0f)));
        this.l.k(n0.g(c(optJSONObject, "height", 0.0f)));
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (!TextUtils.equals(this.m, "ARCameraId")) {
                String optString = jSONObject.optString("componentId");
                this.f5308f = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.f5308f = jSONObject.optString(this.m, this.f5308f);
                }
            } else {
                String optString2 = jSONObject.optString(this.m);
                this.f5308f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.f5308f = jSONObject.optString("componentId", this.f5308f);
                }
            }
            if (TextUtils.isEmpty(this.f5308f)) {
                d.c("Component-Model-Base", this.f5307e + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.f5309g);
            this.f5309g = optString3;
            if (TextUtils.isEmpty(optString3)) {
                d.c("Component-Model-Base", this.f5307e + " component slaveId is empty");
            }
            this.f5310h = jSONObject.optString("parentId", this.f5310h);
            this.f5311i = jSONObject.optString("cb", this.f5311i);
            this.f5312j = jSONObject.optBoolean("hide", this.f5312j);
            this.k = TextUtils.equals(jSONObject.optString("gesture", this.k ? "1" : "0"), "1");
            g(jSONObject);
        }
    }

    @Override // c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        c.a.r0.a.m1.e.a.a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f5308f) || TextUtils.isEmpty(this.f5309g) || (aVar = this.l) == null || !aVar.i()) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SwanAppBaseComponentModel{componentType='" + this.f5307e + ExtendedMessageFormat.QUOTE + ", componentId='" + this.f5308f + ExtendedMessageFormat.QUOTE + ", slaveId='" + this.f5309g + ExtendedMessageFormat.QUOTE + ", parentId='" + this.f5310h + ExtendedMessageFormat.QUOTE + ", callback='" + this.f5311i + ExtendedMessageFormat.QUOTE + ", hidden=" + this.f5312j + ", gesture=" + this.k + ", position=" + this.l + ", mComponentIdKey='" + this.m + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
