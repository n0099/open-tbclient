package c.a.q0.a.i1.c.h;

import android.text.TextUtils;
import c.a.q0.a.k;
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
public class b implements c.a.q0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f6635e;

    /* renamed from: f  reason: collision with root package name */
    public String f6636f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6637g;

    /* renamed from: h  reason: collision with root package name */
    public g f6638h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(119208155, "Lc/a/q0/a/i1/c/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(119208155, "Lc/a/q0/a/i1/c/h/b;");
                return;
            }
        }
        boolean z = k.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6636f = "";
        this.f6637g = false;
    }

    @Override // c.a.q0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f6635e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f6635e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f6638h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f6636f = jSONObject.optString("iconPath");
            this.f6637g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // c.a.q0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.f6638h;
            return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f6636f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
