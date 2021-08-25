package c.a.o0.a.m1;

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
    public static final boolean f7311j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f7312a;

    /* renamed from: b  reason: collision with root package name */
    public String f7313b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7314c;

    /* renamed from: d  reason: collision with root package name */
    public int f7315d;

    /* renamed from: e  reason: collision with root package name */
    public long f7316e;

    /* renamed from: f  reason: collision with root package name */
    public long f7317f;

    /* renamed from: g  reason: collision with root package name */
    public int f7318g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f7319h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7320i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1020167980, "Lc/a/o0/a/m1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1020167980, "Lc/a/o0/a/m1/d;");
                return;
            }
        }
        f7311j = c.a.o0.a.a2.e.y;
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
        this.f7318g = 0;
        this.f7312a = str;
        this.f7313b = str2;
        this.f7316e = System.currentTimeMillis();
        this.f7317f = j2;
        this.f7315d = 0;
        this.f7320i = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f7315d = 2;
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.f7317f;
            if (j2 > 0) {
                this.f7317f = j2 - (System.currentTimeMillis() - this.f7316e);
            }
            return this.f7317f;
        }
        return invokeV.longValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7315d == 2 : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j2 = this.f7317f;
            if (j2 > 0) {
                this.f7317f = j2 - (System.currentTimeMillis() - this.f7316e);
                if (f7311j) {
                    String str = "pause, left " + this.f7317f + "ms";
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f7316e = System.currentTimeMillis();
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
            this.f7315d = 1;
        }
    }
}
