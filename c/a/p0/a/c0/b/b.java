package c.a.p0.a.c0.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import c.a.p0.a.v2.n0;
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
public abstract class b implements c.a.p0.a.l1.a, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f4656e;

    /* renamed from: f  reason: collision with root package name */
    public String f4657f;

    /* renamed from: g  reason: collision with root package name */
    public String f4658g;

    /* renamed from: h  reason: collision with root package name */
    public String f4659h;

    /* renamed from: i  reason: collision with root package name */
    public String f4660i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4661j;
    public boolean k;
    @Nullable
    public c.a.p0.a.l1.e.a.a l;
    public String m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(944168625, "Lc/a/p0/a/c0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(944168625, "Lc/a/p0/a/c0/b/b;");
                return;
            }
        }
        boolean z = k.f7077a;
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
        this.f4656e = "unknown";
        this.f4657f = "";
        this.f4658g = "";
        this.f4659h = "";
        this.f4660i = "";
        this.f4661j = false;
        this.k = false;
        this.m = "id";
        if (!TextUtils.isEmpty(str)) {
            this.f4656e = str;
        } else {
            c.a.p0.a.c0.g.a.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.m = str2;
        } else {
            c.a.p0.a.c0.g.a.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // c.a.p0.a.l1.a
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f4657f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f4657f = jSONObject.optString(this.m);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f4657f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f4657f = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.f4657f)) {
            d.b("Component-Model-Base", this.f4656e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.f4658g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f4656e + " component slaveId is empty");
        }
        this.f4659h = jSONObject.optString("parentId");
        this.f4660i = jSONObject.optString("cb");
        this.f4661j = jSONObject.optBoolean("hide", false);
        this.k = TextUtils.equals(jSONObject.optString("gesture"), "1");
        h(jSONObject);
    }

    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = (b) super.clone();
            c.a.p0.a.l1.e.a.a aVar = this.l;
            if (aVar != null) {
                bVar.l = (c.a.p0.a.l1.e.a.a) aVar.clone();
            } else {
                bVar.l = null;
            }
            return bVar;
        }
        return invokeV.objValue;
    }

    public final FrameLayout.LayoutParams d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.a.l1.e.a.a aVar = this.l;
            int i2 = aVar != null ? aVar.i() : -1;
            c.a.p0.a.l1.e.a.a aVar2 = this.l;
            int f2 = aVar2 != null ? aVar2.f() : -1;
            c.a.p0.a.l1.e.a.a aVar3 = this.l;
            int g2 = aVar3 != null ? aVar3.g() : 0;
            c.a.p0.a.l1.e.a.a aVar4 = this.l;
            int h2 = aVar4 != null ? aVar4.h() : 0;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, f2);
            layoutParams.setMargins(g2, h2, 0, 0);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final float e(JSONObject jSONObject, String str, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{jSONObject, str, Float.valueOf(f2)})) == null) ? jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2) : invokeCommon.floatValue;
    }

    @NonNull
    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("【");
            sb.append(this.f4656e);
            sb.append("#");
            sb.append(TextUtils.isEmpty(this.f4657f) ? "" : this.f4657f);
            sb.append("】");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void g(JSONObject jSONObject, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, bVar) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f4657f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f4657f = jSONObject.optString(this.m, bVar.f4657f);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f4657f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f4657f = jSONObject.optString("componentId", bVar.f4657f);
            }
        }
        if (TextUtils.isEmpty(this.f4657f)) {
            d.b("Component-Model-Base", this.f4656e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", bVar.f4658g);
        this.f4658g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f4656e + " component slaveId is empty");
        }
        this.f4659h = jSONObject.optString("parentId", bVar.f4659h);
        this.f4660i = jSONObject.optString("cb", bVar.f4660i);
        this.f4661j = jSONObject.optBoolean("hide", bVar.f4661j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", bVar.k ? "1" : "0"), "1");
        c.a.p0.a.l1.e.a.a aVar = bVar.l;
        this.l = aVar;
        if (aVar == null) {
            this.l = new c.a.p0.a.l1.e.a.a();
        }
        h(jSONObject);
    }

    public final void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("position")) == null) {
            return;
        }
        c.a.p0.a.l1.e.a.a aVar = new c.a.p0.a.l1.e.a.a();
        this.l = aVar;
        aVar.o(n0.g(e(optJSONObject, "left", 0.0f)));
        this.l.p(n0.g(e(optJSONObject, VerticalTranslateLayout.TOP, 0.0f)));
        this.l.q(n0.g(e(optJSONObject, "width", 0.0f)));
        this.l.m(n0.g(e(optJSONObject, "height", 0.0f)));
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (!TextUtils.equals(this.m, "ARCameraId")) {
                String optString = jSONObject.optString("componentId");
                this.f4657f = optString;
                if (TextUtils.isEmpty(optString)) {
                    this.f4657f = jSONObject.optString(this.m, this.f4657f);
                }
            } else {
                String optString2 = jSONObject.optString(this.m);
                this.f4657f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    this.f4657f = jSONObject.optString("componentId", this.f4657f);
                }
            }
            if (TextUtils.isEmpty(this.f4657f)) {
                d.b("Component-Model-Base", this.f4656e + " component componentId is empty");
            }
            String optString3 = jSONObject.optString("slaveId", this.f4658g);
            this.f4658g = optString3;
            if (TextUtils.isEmpty(optString3)) {
                d.b("Component-Model-Base", this.f4656e + " component slaveId is empty");
            }
            this.f4659h = jSONObject.optString("parentId", this.f4659h);
            this.f4660i = jSONObject.optString("cb", this.f4660i);
            this.f4661j = jSONObject.optBoolean("hide", this.f4661j);
            this.k = TextUtils.equals(jSONObject.optString("gesture", this.k ? "1" : "0"), "1");
            h(jSONObject);
        }
    }

    @Override // c.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        c.a.p0.a.l1.e.a.a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.f4657f) || TextUtils.isEmpty(this.f4658g) || (aVar = this.l) == null || !aVar.k()) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SwanAppBaseComponentModel{componentType='" + this.f4656e + ExtendedMessageFormat.QUOTE + ", componentId='" + this.f4657f + ExtendedMessageFormat.QUOTE + ", slaveId='" + this.f4658g + ExtendedMessageFormat.QUOTE + ", parentId='" + this.f4659h + ExtendedMessageFormat.QUOTE + ", callback='" + this.f4660i + ExtendedMessageFormat.QUOTE + ", hidden=" + this.f4661j + ", gesture=" + this.k + ", position=" + this.l + ", mComponentIdKey='" + this.m + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
