package b.a.f0.b;

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
    public static final b f2814g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.f0.a.b.a f2815a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2816b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2817c;

    /* renamed from: d  reason: collision with root package name */
    public int f2818d;

    /* renamed from: e  reason: collision with root package name */
    public int f2819e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2820f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-898471324, "Lb/a/f0/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-898471324, "Lb/a/f0/b/b;");
                return;
            }
        }
        f2814g = new b();
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
        b.a.f0.a.b.a aVar = b.a.f0.a.b.a.f2781a.get();
        this.f2815a = aVar;
        aVar.s();
        DisplayMetrics displayMetrics = this.f2815a.o().getResources().getDisplayMetrics();
        this.f2817c = displayMetrics.heightPixels;
        this.f2816b = displayMetrics.widthPixels;
        this.f2820f = displayMetrics.densityDpi;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f2814g : (b) invokeV.objValue;
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f2818d;
            return i2 != 0 ? new int[]{i2, this.f2819e, this.f2820f} : new int[]{this.f2816b, this.f2817c, this.f2820f};
        }
        return (int[]) invokeV.objValue;
    }
}
