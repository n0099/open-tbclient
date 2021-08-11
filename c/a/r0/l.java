package c.a.r0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f29571f;

    /* renamed from: g  reason: collision with root package name */
    public static String f29572g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f29573a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29574b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29575c;

    /* renamed from: d  reason: collision with root package name */
    public long f29576d;

    /* renamed from: e  reason: collision with root package name */
    public int f29577e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349058394, "Lc/a/r0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349058394, "Lc/a/r0/l;");
                return;
            }
        }
        f29571f = k.f29561a & true;
        f29572g = "ControlData";
    }

    public l(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29573a = str;
        this.f29574b = i2;
        this.f29575c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f29574b != 0 && this.f29575c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f29571f) {
                    String str = "id " + this.f29573a + " mLimitUnit " + this.f29574b + " mLimitCnt " + this.f29575c + "mCount =  " + this.f29577e + " duration " + ((valueOf.longValue() - this.f29576d) / 1000);
                }
                if (this.f29576d != 0 && (valueOf.longValue() - this.f29576d) / 1000 <= this.f29574b && this.f29577e >= this.f29575c) {
                    boolean z = f29571f;
                    return true;
                }
                if (this.f29576d == 0) {
                    this.f29576d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f29576d) / 1000 > this.f29574b) {
                    this.f29576d = valueOf.longValue();
                    this.f29577e = 0;
                    boolean z2 = f29571f;
                }
                this.f29577e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f29577e;
            return i2 != 0 && i2 == this.f29575c;
        }
        return invokeV.booleanValue;
    }
}
