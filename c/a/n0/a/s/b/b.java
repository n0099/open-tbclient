package c.a.n0.a.s.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import c.a.n0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b implements c.a.n0.a.s.b.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f6096b;

    /* renamed from: c  reason: collision with root package name */
    public String f6097c;

    /* renamed from: d  reason: collision with root package name */
    public String f6098d;

    /* renamed from: e  reason: collision with root package name */
    public String f6099e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6100f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6101g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.a.c1.e.a.a f6102h;
    public String i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766182089, "Lc/a/n0/a/s/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766182089, "Lc/a/n0/a/s/b/b;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    public b(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "unknown";
        this.f6096b = "";
        this.f6097c = "";
        this.f6098d = "";
        this.f6099e = "";
        this.f6100f = false;
        this.f6101g = false;
        this.i = "id";
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
        } else {
            c.a.n0.a.s.g.a.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.i = str2;
        } else {
            c.a.n0.a.s.g.a.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // c.a.n0.a.c1.a
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f6096b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f6096b = jSONObject.optString(this.i);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.f6096b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f6096b = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.f6096b)) {
            d.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.f6097c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.f6098d = jSONObject.optString("parentId");
        this.f6099e = jSONObject.optString("cb");
        this.f6100f = jSONObject.optBoolean("hide", false);
        this.f6101g = TextUtils.equals(jSONObject.optString("gesture"), "1");
        f(jSONObject);
    }

    public final FrameLayout.LayoutParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.c1.e.a.a aVar = this.f6102h;
            int f2 = aVar != null ? aVar.f() : -1;
            c.a.n0.a.c1.e.a.a aVar2 = this.f6102h;
            int c2 = aVar2 != null ? aVar2.c() : -1;
            c.a.n0.a.c1.e.a.a aVar3 = this.f6102h;
            int d2 = aVar3 != null ? aVar3.d() : 0;
            c.a.n0.a.c1.e.a.a aVar4 = this.f6102h;
            int e2 = aVar4 != null ? aVar4.e() : 0;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, c2);
            layoutParams.setMargins(d2, e2, 0, 0);
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
            c.a.n0.a.c1.e.a.a aVar = this.f6102h;
            if (aVar != null) {
                bVar.f6102h = (c.a.n0.a.c1.e.a.a) aVar.clone();
            } else {
                bVar.f6102h = null;
            }
            return bVar;
        }
        return invokeV.objValue;
    }

    @NonNull
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("【");
            sb.append(this.a);
            sb.append("#");
            sb.append(TextUtils.isEmpty(this.f6096b) ? "" : this.f6096b);
            sb.append("】");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void e(JSONObject jSONObject, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, bVar) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.i, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f6096b = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f6096b = jSONObject.optString(this.i, bVar.f6096b);
            }
        } else {
            String optString2 = jSONObject.optString(this.i);
            this.f6096b = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f6096b = jSONObject.optString("componentId", bVar.f6096b);
            }
        }
        if (TextUtils.isEmpty(this.f6096b)) {
            d.c("Component-Model-Base", this.a + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", bVar.f6097c);
        this.f6097c = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.c("Component-Model-Base", this.a + " component slaveId is empty");
        }
        this.f6098d = jSONObject.optString("parentId", bVar.f6098d);
        this.f6099e = jSONObject.optString("cb", bVar.f6099e);
        this.f6100f = jSONObject.optBoolean("hide", bVar.f6100f);
        this.f6101g = TextUtils.equals(jSONObject.optString("gesture", bVar.f6101g ? "1" : "0"), "1");
        c.a.n0.a.c1.e.a.a aVar = bVar.f6102h;
        this.f6102h = aVar;
        if (aVar == null) {
            this.f6102h = new c.a.n0.a.c1.e.a.a();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("position")) == null) {
            return;
        }
        c.a.n0.a.c1.e.a.a aVar = new c.a.n0.a.c1.e.a.a();
        this.f6102h = aVar;
        aVar.l(n0.g(c(optJSONObject, "left", 0.0f)));
        this.f6102h.m(n0.g(c(optJSONObject, AnimationProperty.TOP, 0.0f)));
        this.f6102h.n(n0.g(c(optJSONObject, "width", 0.0f)));
        this.f6102h.j(n0.g(c(optJSONObject, "height", 0.0f)));
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (!TextUtils.equals(this.i, "ARCameraId")) {
                String optString = jSONObject.optString("componentId");
                this.f6096b = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.f6096b = jSONObject.optString(this.i, this.f6096b);
                }
            } else {
                String optString2 = jSONObject.optString(this.i);
                this.f6096b = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.f6096b = jSONObject.optString("componentId", this.f6096b);
                }
            }
            if (TextUtils.isEmpty(this.f6096b)) {
                d.c("Component-Model-Base", this.a + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.f6097c);
            this.f6097c = optString3;
            if (TextUtils.isEmpty(optString3)) {
                d.c("Component-Model-Base", this.a + " component slaveId is empty");
            }
            this.f6098d = jSONObject.optString("parentId", this.f6098d);
            this.f6099e = jSONObject.optString("cb", this.f6099e);
            this.f6100f = jSONObject.optBoolean("hide", this.f6100f);
            this.f6101g = TextUtils.equals(jSONObject.optString("gesture", this.f6101g ? "1" : "0"), "1");
            f(jSONObject);
        }
    }

    @Override // c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        c.a.n0.a.c1.e.a.a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f6096b) || TextUtils.isEmpty(this.f6097c) || (aVar = this.f6102h) == null || !aVar.h()) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SwanAppBaseComponentModel{componentType='" + this.a + "', componentId='" + this.f6096b + "', slaveId='" + this.f6097c + "', parentId='" + this.f6098d + "', callback='" + this.f6099e + "', hidden=" + this.f6100f + ", gesture=" + this.f6101g + ", position=" + this.f6102h + ", mComponentIdKey='" + this.i + "'}";
        }
        return (String) invokeV.objValue;
    }
}
