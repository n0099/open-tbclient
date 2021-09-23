package c.a.f0.b;

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
    public static final b f3371g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.f0.a.b.a f3372a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3373b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3374c;

    /* renamed from: d  reason: collision with root package name */
    public int f3375d;

    /* renamed from: e  reason: collision with root package name */
    public int f3376e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3377f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1599544613, "Lc/a/f0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1599544613, "Lc/a/f0/b/b;");
                return;
            }
        }
        f3371g = new b();
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
        c.a.f0.a.b.a aVar = c.a.f0.a.b.a.f3338a.get();
        this.f3372a = aVar;
        aVar.t();
        DisplayMetrics displayMetrics = this.f3372a.p().getResources().getDisplayMetrics();
        this.f3374c = displayMetrics.heightPixels;
        this.f3373b = displayMetrics.widthPixels;
        this.f3377f = displayMetrics.densityDpi;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f3371g : (b) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f3375d;
            return i2 != 0 ? new int[]{i2, this.f3376e, this.f3377f} : new int[]{this.f3373b, this.f3374c, this.f3377f};
        }
        return (int[]) invokeV.objValue;
    }
}
