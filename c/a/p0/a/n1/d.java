package c.a.p0.a.n1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f6978j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f6979b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6980c;

    /* renamed from: d  reason: collision with root package name */
    public int f6981d;

    /* renamed from: e  reason: collision with root package name */
    public long f6982e;

    /* renamed from: f  reason: collision with root package name */
    public long f6983f;

    /* renamed from: g  reason: collision with root package name */
    public int f6984g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f6985h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6986i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(824577996, "Lc/a/p0/a/n1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(824577996, "Lc/a/p0/a/n1/d;");
                return;
            }
        }
        f6978j = c.a.p0.a.d2.e.z;
    }

    public d(String str, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6984g = 0;
        this.a = str;
        this.f6979b = str2;
        this.f6982e = System.currentTimeMillis();
        this.f6983f = j2;
        this.f6981d = 0;
        this.f6986i = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f6981d = 2;
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.f6983f;
            if (j2 > 0) {
                this.f6983f = j2 - (System.currentTimeMillis() - this.f6982e);
            }
            return this.f6983f;
        }
        return invokeV.longValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6981d == 2 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j2 = this.f6983f;
            if (j2 > 0) {
                this.f6983f = j2 - (System.currentTimeMillis() - this.f6982e);
                if (f6978j) {
                    String str = "pause, left " + this.f6983f + "ms";
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f6982e = System.currentTimeMillis();
        }
    }

    public void f(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) {
            new WeakReference(bitmap);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f6981d = 1;
        }
    }
}
