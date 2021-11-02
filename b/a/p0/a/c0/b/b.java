package b.a.p0.a.c0.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.v2.n0;
import com.baidu.adp.widget.VerticalTranslateLayout;
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
public abstract class b implements b.a.p0.a.c0.b.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f4055e;

    /* renamed from: f  reason: collision with root package name */
    public String f4056f;

    /* renamed from: g  reason: collision with root package name */
    public String f4057g;

    /* renamed from: h  reason: collision with root package name */
    public String f4058h;

    /* renamed from: i  reason: collision with root package name */
    public String f4059i;
    public boolean j;
    public boolean k;
    @Nullable
    public b.a.p0.a.l1.e.a.a l;
    public String m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1454702802, "Lb/a/p0/a/c0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1454702802, "Lb/a/p0/a/c0/b/b;");
                return;
            }
        }
        boolean z = k.f6397a;
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
        this.f4055e = "unknown";
        this.f4056f = "";
        this.f4057g = "";
        this.f4058h = "";
        this.f4059i = "";
        this.j = false;
        this.k = false;
        this.m = "id";
        if (!TextUtils.isEmpty(str)) {
            this.f4055e = str;
        } else {
            b.a.p0.a.c0.g.a.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.m = str2;
        } else {
            b.a.p0.a.c0.g.a.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // b.a.p0.a.l1.a
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f4056f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f4056f = jSONObject.optString(this.m);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f4056f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f4056f = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.f4056f)) {
            d.b("Component-Model-Base", this.f4055e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.f4057g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f4055e + " component slaveId is empty");
        }
        this.f4058h = jSONObject.optString("parentId");
        this.f4059i = jSONObject.optString("cb");
        this.j = jSONObject.optBoolean("hide", false);
        this.k = TextUtils.equals(jSONObject.optString("gesture"), "1");
        g(jSONObject);
    }

    public final FrameLayout.LayoutParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.l1.e.a.a aVar = this.l;
            int g2 = aVar != null ? aVar.g() : -1;
            b.a.p0.a.l1.e.a.a aVar2 = this.l;
            int c2 = aVar2 != null ? aVar2.c() : -1;
            b.a.p0.a.l1.e.a.a aVar3 = this.l;
            int e2 = aVar3 != null ? aVar3.e() : 0;
            b.a.p0.a.l1.e.a.a aVar4 = this.l;
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
            b.a.p0.a.l1.e.a.a aVar = this.l;
            if (aVar != null) {
                bVar.l = (b.a.p0.a.l1.e.a.a) aVar.clone();
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
            sb.append(this.f4055e);
            sb.append("#");
            sb.append(TextUtils.isEmpty(this.f4056f) ? "" : this.f4056f);
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
            this.f4056f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f4056f = jSONObject.optString(this.m, bVar.f4056f);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f4056f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f4056f = jSONObject.optString("componentId", bVar.f4056f);
            }
        }
        if (TextUtils.isEmpty(this.f4056f)) {
            d.b("Component-Model-Base", this.f4055e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", bVar.f4057g);
        this.f4057g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f4055e + " component slaveId is empty");
        }
        this.f4058h = jSONObject.optString("parentId", bVar.f4058h);
        this.f4059i = jSONObject.optString("cb", bVar.f4059i);
        this.j = jSONObject.optBoolean("hide", bVar.j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", bVar.k ? "1" : "0"), "1");
        b.a.p0.a.l1.e.a.a aVar = bVar.l;
        this.l = aVar;
        if (aVar == null) {
            this.l = new b.a.p0.a.l1.e.a.a();
        }
        g(jSONObject);
    }

    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("position")) == null) {
            return;
        }
        b.a.p0.a.l1.e.a.a aVar = new b.a.p0.a.l1.e.a.a();
        this.l = aVar;
        aVar.m(n0.g(c(optJSONObject, "left", 0.0f)));
        this.l.n(n0.g(c(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
        this.l.o(n0.g(c(optJSONObject, "width", 0.0f)));
        this.l.k(n0.g(c(optJSONObject, "height", 0.0f)));
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (!TextUtils.equals(this.m, "ARCameraId")) {
                String optString = jSONObject.optString("componentId");
                this.f4056f = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.f4056f = jSONObject.optString(this.m, this.f4056f);
                }
            } else {
                String optString2 = jSONObject.optString(this.m);
                this.f4056f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.f4056f = jSONObject.optString("componentId", this.f4056f);
                }
            }
            if (TextUtils.isEmpty(this.f4056f)) {
                d.b("Component-Model-Base", this.f4055e + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.f4057g);
            this.f4057g = optString3;
            if (TextUtils.isEmpty(optString3)) {
                d.b("Component-Model-Base", this.f4055e + " component slaveId is empty");
            }
            this.f4058h = jSONObject.optString("parentId", this.f4058h);
            this.f4059i = jSONObject.optString("cb", this.f4059i);
            this.j = jSONObject.optBoolean("hide", this.j);
            this.k = TextUtils.equals(jSONObject.optString("gesture", this.k ? "1" : "0"), "1");
            g(jSONObject);
        }
    }

    @Override // b.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        b.a.p0.a.l1.e.a.a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f4056f) || TextUtils.isEmpty(this.f4057g) || (aVar = this.l) == null || !aVar.i()) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SwanAppBaseComponentModel{componentType='" + this.f4055e + ExtendedMessageFormat.QUOTE + ", componentId='" + this.f4056f + ExtendedMessageFormat.QUOTE + ", slaveId='" + this.f4057g + ExtendedMessageFormat.QUOTE + ", parentId='" + this.f4058h + ExtendedMessageFormat.QUOTE + ", callback='" + this.f4059i + ExtendedMessageFormat.QUOTE + ", hidden=" + this.j + ", gesture=" + this.k + ", position=" + this.l + ", mComponentIdKey='" + this.m + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
