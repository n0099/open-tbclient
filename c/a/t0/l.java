package c.a.t0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f26048f;

    /* renamed from: g  reason: collision with root package name */
    public static String f26049g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26050b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26051c;

    /* renamed from: d  reason: collision with root package name */
    public long f26052d;

    /* renamed from: e  reason: collision with root package name */
    public int f26053e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905436, "Lc/a/t0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905436, "Lc/a/t0/l;");
                return;
            }
        }
        f26048f = k.a & true;
        f26049g = "ControlData";
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
        this.a = str;
        this.f26050b = i2;
        this.f26051c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f26050b != 0 && this.f26051c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f26048f) {
                    String str = "id " + this.a + " mLimitUnit " + this.f26050b + " mLimitCnt " + this.f26051c + "mCount =  " + this.f26053e + " duration " + ((valueOf.longValue() - this.f26052d) / 1000);
                }
                if (this.f26052d != 0 && (valueOf.longValue() - this.f26052d) / 1000 <= this.f26050b && this.f26053e >= this.f26051c) {
                    boolean z = f26048f;
                    return true;
                }
                if (this.f26052d == 0) {
                    this.f26052d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f26052d) / 1000 > this.f26050b) {
                    this.f26052d = valueOf.longValue();
                    this.f26053e = 0;
                    boolean z2 = f26048f;
                }
                this.f26053e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f26053e;
            return i2 != 0 && i2 == this.f26051c;
        }
        return invokeV.booleanValue;
    }
}
