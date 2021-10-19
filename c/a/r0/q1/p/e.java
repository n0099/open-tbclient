package c.a.r0.q1.p;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, e> f23852f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f23853a;

    /* renamed from: b  reason: collision with root package name */
    public String f23854b;

    /* renamed from: c  reason: collision with root package name */
    public String f23855c;

    /* renamed from: d  reason: collision with root package name */
    public int f23856d;

    /* renamed from: e  reason: collision with root package name */
    public String f23857e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1747661337, "Lc/a/r0/q1/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1747661337, "Lc/a/r0/q1/p/e;");
                return;
            }
        }
        f23852f = new HashMap<>();
    }

    public e() {
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
        this.f23854b = "";
    }

    public static e a(long j2, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j2, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(j2);
            sb.append("_");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return f23852f.get(sb.toString());
        }
        return (e) invokeJL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f23853a);
            sb.append("_");
            sb.append(TextUtils.isEmpty(this.f23854b) ? "" : this.f23854b);
            f23852f.put(sb.toString(), this);
        }
    }
}
