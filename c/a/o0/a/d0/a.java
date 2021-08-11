package c.a.o0.a.d0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
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

    /* renamed from: a  reason: collision with root package name */
    public int f12278a;

    /* renamed from: b  reason: collision with root package name */
    public int f12279b;

    /* renamed from: c  reason: collision with root package name */
    public int f12280c;

    /* renamed from: d  reason: collision with root package name */
    public int f12281d;

    /* renamed from: e  reason: collision with root package name */
    public String f12282e;

    /* renamed from: f  reason: collision with root package name */
    public String f12283f;

    /* renamed from: g  reason: collision with root package name */
    public String f12284g;

    /* renamed from: h  reason: collision with root package name */
    public String f12285h;

    /* renamed from: i  reason: collision with root package name */
    public int f12286i;

    /* renamed from: j  reason: collision with root package name */
    public String f12287j;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1011826407, "Lc/a/o0/a/d0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1011826407, "Lc/a/o0/a/d0/a;");
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
