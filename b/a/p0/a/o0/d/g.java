package b.a.p0.a.o0.d;

import android.net.Uri;
import b.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g<T> extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7117e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public T f7118c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7119d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-780095177, "Lb/a/p0/a/o0/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-780095177, "Lb/a/p0/a/o0/d/g;");
                return;
            }
        }
        f7117e = k.f6397a;
    }

    public g() {
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
        this.f7119d = true;
        this.f7099a = "message";
    }

    @Override // b.a.p0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            T t = this.f7118c;
            if (!(t instanceof String)) {
                return t instanceof JSONObject ? b.a.p0.a.o0.a.d(str, "message", (JSONObject) t) : "";
            }
            String str2 = (String) t;
            if (this.f7119d) {
                str2 = Uri.encode(str2);
            }
            if (f7117e) {
                String str3 = "mData: " + this.f7118c;
                String str4 = "encode mData: " + str2;
            }
            return b.a.p0.a.o0.a.c(str, "message", str2);
        }
        return (String) invokeL.objValue;
    }
}
