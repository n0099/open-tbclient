package b.a.q0.h0;

import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int j = 1;
    public static int k = 2;
    public static int l = 3;
    public static int m = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Fragment f12612a;

    /* renamed from: b  reason: collision with root package name */
    public int f12613b;

    /* renamed from: c  reason: collision with root package name */
    public String f12614c;

    /* renamed from: d  reason: collision with root package name */
    public int f12615d;

    /* renamed from: e  reason: collision with root package name */
    public int f12616e;

    /* renamed from: f  reason: collision with root package name */
    public int f12617f;

    /* renamed from: g  reason: collision with root package name */
    public String f12618g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.h0.e.a f12619h;

    /* renamed from: i  reason: collision with root package name */
    public int f12620i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-86239562, "Lb/a/q0/h0/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-86239562, "Lb/a/q0/h0/c;");
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
        this.f12620i = j;
    }
}
