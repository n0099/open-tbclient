package c.a.p0.i.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.k;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends c.a.p0.i.e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f9896c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(505797629, "Lc/a/p0/i/b/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(505797629, "Lc/a/p0/i/b/c/f;");
                return;
            }
        }
        f9896c = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f() {
        super("openApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.i.e.a
    public c.a.p0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.p0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f9896c) {
                String str = "handle: " + jSONObject;
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                bVar.onFail(31010, "package name is empty");
                return null;
            }
            c.a.p0.i.b.i.c.a(optString, "openApp", null, null, null);
            if (!c.a.p0.i.b.e.a.h(AppRuntime.getAppContext(), optString)) {
                bVar.onFail(31011, "app is not installed");
                c.a.p0.i.b.i.c.a(optString, "openApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(31011), null);
                return null;
            }
            if (c.a.p0.i.b.e.a.l(AppRuntime.getAppContext(), optString)) {
                bVar.a(null);
                c.a.p0.i.b.i.c.a(optString, "openApp", "success", null, null);
            } else {
                bVar.onFail(31019, "open app fail");
                c.a.p0.i.b.i.c.a(optString, "openApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(31019), null);
            }
            return null;
        }
        return (c.a.p0.a.u.h.b) invokeLL.objValue;
    }
}
