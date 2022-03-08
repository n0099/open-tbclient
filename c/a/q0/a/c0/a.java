package c.a.q0.a.c0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = 3;
    public static int B = 4;
    public static int C = 5;
    public static int D = 1;
    public static int E = 2;
    public static int y = 1;
    public static int z = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f11808b;

    /* renamed from: c  reason: collision with root package name */
    public int f11809c;

    /* renamed from: d  reason: collision with root package name */
    public int f11810d;

    /* renamed from: e  reason: collision with root package name */
    public String f11811e;

    /* renamed from: f  reason: collision with root package name */
    public String f11812f;

    /* renamed from: g  reason: collision with root package name */
    public String f11813g;

    /* renamed from: h  reason: collision with root package name */
    public String f11814h;

    /* renamed from: i  reason: collision with root package name */
    public int f11815i;

    /* renamed from: j  reason: collision with root package name */
    public String f11816j;
    public String k;
    public String l;
    public String m;
    public double n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public long t;
    public long u;
    public ArrayList<String> v;
    public ArrayList<String> w;
    public int x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(617875876, "Lc/a/q0/a/c0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(617875876, "Lc/a/q0/a/c0/a;");
        }
    }

    public a() {
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
        this.v = new ArrayList<>();
        this.w = new ArrayList<>();
        this.x = 0;
    }
}
