package c.a.r0.a.o0.d;

import android.net.Uri;
import c.a.r0.a.k;
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
    public static final boolean f8184e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public T f8185c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8186d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1032463885, "Lc/a/r0/a/o0/d/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1032463885, "Lc/a/r0/a/o0/d/h;");
                return;
            }
        }
        f8184e = k.a;
    }

    public h() {
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
        this.f8186d = true;
        this.a = "message";
    }

    @Override // c.a.r0.a.o0.d.b
    public void m(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Object obj = this.f8185c;
            if (obj instanceof String) {
                String str = (String) obj;
                if (this.f8186d) {
                    str = Uri.encode(str);
                }
                if (f8184e) {
                    String str2 = "mData: " + this.f8185c;
                    String str3 = "encode mData: " + str;
                }
                map.put("message", str);
            } else if (obj instanceof JSONObject) {
                map.put("message", obj);
            }
        }
    }
}
