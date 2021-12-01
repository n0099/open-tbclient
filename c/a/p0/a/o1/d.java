package c.a.p0.a.o1;

import androidx.annotation.NonNull;
import c.a.p0.a.d2.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<b> f7186b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(825501517, "Lc/a/p0/a/o1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(825501517, "Lc/a/p0/a/o1/d;");
                return;
            }
        }
        a = e.z;
        f7186b = Arrays.asList(new b());
    }

    public static JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject("{\"pages\":{},\"window\":{\"navigationBarBackgroundColor\":{},\"navigationBarTextStyle\":{},\"navigationBarTitleText\":{},\"navigationStyle\":{},\"backgroundColor\":{},\"backgroundTextStyle\":{},\"enablePullDownRefresh\":{},\"onReachBottomDistance\":{}},\"networkTimeout\":{\"request\":{},\"connectSocket\":{},\"uploadFile\":{},\"downloadFile\":{}},\"tabBar\":{\"color\":{},\"backgroundColor\":{},\"borderStyle\":{},\"list\":{},\"selectedColor\":{}},\"swanCookie\":{}}");
            if (a) {
                c.a.p0.a.e0.d.i("SwanNaUseMapManager", ">>> before intercept: " + jSONObject);
            }
            c(jSONObject);
            if (a) {
                c.a.p0.a.e0.d.i("SwanNaUseMapManager", ">>> after intercept: " + jSONObject);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static JSONObject b() {
        JSONObject jSONObject;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                jSONObject = a();
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                    c.a.p0.a.e0.d.k("SwanNaUseMapManager", ">>> NAUseMapException: " + e2.getMessage());
                }
                jSONObject = null;
            }
            return jSONObject != null ? jSONObject : new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            for (b bVar : f7186b) {
                if (bVar.a(keys.next())) {
                    keys.remove();
                }
            }
        }
    }
}
