package c.a.r0.i0;

import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static int f12648j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static int f12649k = 2;
    public static int l = 3;
    public static int m = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public Fragment a;

    /* renamed from: b  reason: collision with root package name */
    public int f12650b;

    /* renamed from: c  reason: collision with root package name */
    public String f12651c;

    /* renamed from: d  reason: collision with root package name */
    public int f12652d;

    /* renamed from: e  reason: collision with root package name */
    public int f12653e;

    /* renamed from: f  reason: collision with root package name */
    public int f12654f;

    /* renamed from: g  reason: collision with root package name */
    public String f12655g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.i0.e.a f12656h;

    /* renamed from: i  reason: collision with root package name */
    public int f12657i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1786577013, "Lc/a/r0/i0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1786577013, "Lc/a/r0/i0/c;");
        }
    }

    public c() {
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
        this.f12657i = f12648j;
    }
}
