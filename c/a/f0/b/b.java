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
    public static final b f3370g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.f0.a.b.a f3371a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3372b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3373c;

    /* renamed from: d  reason: collision with root package name */
    public int f3374d;

    /* renamed from: e  reason: collision with root package name */
    public int f3375e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3376f;

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
        f3370g = new b();
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
        c.a.f0.a.b.a aVar = c.a.f0.a.b.a.f3337a.get();
        this.f3371a = aVar;
        aVar.t();
        DisplayMetrics displayMetrics = this.f3371a.p().getResources().getDisplayMetrics();
        this.f3373c = displayMetrics.heightPixels;
        this.f3372b = displayMetrics.widthPixels;
        this.f3376f = displayMetrics.densityDpi;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f3370g : (b) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f3374d;
            return i2 != 0 ? new int[]{i2, this.f3375e, this.f3376f} : new int[]{this.f3372b, this.f3373c, this.f3376f};
        }
        return (int[]) invokeV.objValue;
    }
}
