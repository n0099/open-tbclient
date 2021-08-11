package c.a.e0.b;

import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final b f3073g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.e0.a.b.a f3074a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3075b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3076c;

    /* renamed from: d  reason: collision with root package name */
    public int f3077d;

    /* renamed from: e  reason: collision with root package name */
    public int f3078e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3079f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(712040932, "Lc/a/e0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(712040932, "Lc/a/e0/b/b;");
                return;
            }
        }
        f3073g = new b();
    }

    public b() {
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
        c.a.e0.a.b.a aVar = c.a.e0.a.b.a.f3041a.get();
        this.f3074a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f3074a.o().getResources().getDisplayMetrics();
        this.f3076c = displayMetrics.heightPixels;
        this.f3075b = displayMetrics.widthPixels;
        this.f3079f = displayMetrics.densityDpi;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f3073g : (b) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f3077d;
            return i2 != 0 ? new int[]{i2, this.f3078e, this.f3079f} : new int[]{this.f3075b, this.f3076c, this.f3079f};
        }
        return (int[]) invokeV.objValue;
    }
}
