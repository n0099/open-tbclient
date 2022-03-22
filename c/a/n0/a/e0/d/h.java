package c.a.n0.a.e0.d;

import android.net.Uri;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h<T> extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f4242e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public T f4243c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4244d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1833896979, "Lc/a/n0/a/e0/d/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1833896979, "Lc/a/n0/a/e0/d/h;");
                return;
            }
        }
        f4242e = c.a.n0.a.a.a;
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4244d = true;
        this.a = "message";
    }

    @Override // c.a.n0.a.e0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Object obj = this.f4243c;
            if (obj instanceof String) {
                String str = (String) obj;
                if (this.f4244d) {
                    str = Uri.encode(str);
                }
                if (f4242e) {
                    Log.d("SwanAppWebMessage", "mData: " + this.f4243c);
                    Log.d("SwanAppWebMessage", "encode mData: " + str);
                }
                map.put("message", str);
            } else if (obj instanceof JSONObject) {
                map.put("message", obj);
            }
        }
    }
}
