package c.a.o0.h0;

import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int k = 1;
    public static int l = 2;
    public static int m = 3;
    public static int n = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public Fragment a;

    /* renamed from: b  reason: collision with root package name */
    public int f10296b;

    /* renamed from: c  reason: collision with root package name */
    public String f10297c;

    /* renamed from: d  reason: collision with root package name */
    public int f10298d;

    /* renamed from: e  reason: collision with root package name */
    public int f10299e;

    /* renamed from: f  reason: collision with root package name */
    public int f10300f;

    /* renamed from: g  reason: collision with root package name */
    public String f10301g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.h0.g.a f10302h;
    public int i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(852189783, "Lc/a/o0/h0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(852189783, "Lc/a/o0/h0/c;");
        }
    }

    public c() {
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
        this.i = k;
    }
}
