package b.a.p0.a.h1.c.h;

import android.text.TextUtils;
import b.a.p0.a.k;
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
public class b implements b.a.p0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f5867e;

    /* renamed from: f  reason: collision with root package name */
    public String f5868f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5869g;

    /* renamed from: h  reason: collision with root package name */
    public g f5870h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865673700, "Lb/a/p0/a/h1/c/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865673700, "Lb/a/p0/a/h1/c/h/b;");
                return;
            }
        }
        boolean z = k.f6397a;
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
        this.f5868f = "";
        this.f5869g = false;
    }

    @Override // b.a.p0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f5867e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f5867e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f5870h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f5868f = jSONObject.optString("iconPath");
            this.f5869g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // b.a.p0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.f5870h;
            return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f5868f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
