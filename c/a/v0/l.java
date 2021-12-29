package c.a.v0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f27281f;

    /* renamed from: g  reason: collision with root package name */
    public static String f27282g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27283b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27284c;

    /* renamed from: d  reason: collision with root package name */
    public long f27285d;

    /* renamed from: e  reason: collision with root package name */
    public int f27286e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1352752478, "Lc/a/v0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1352752478, "Lc/a/v0/l;");
                return;
            }
        }
        f27281f = k.a & true;
        f27282g = "ControlData";
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
        this.f27283b = i2;
        this.f27284c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f27283b != 0 && this.f27284c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f27281f) {
                    String str = "id " + this.a + " mLimitUnit " + this.f27283b + " mLimitCnt " + this.f27284c + "mCount =  " + this.f27286e + " duration " + ((valueOf.longValue() - this.f27285d) / 1000);
                }
                if (this.f27285d != 0 && (valueOf.longValue() - this.f27285d) / 1000 <= this.f27283b && this.f27286e >= this.f27284c) {
                    boolean z = f27281f;
                    return true;
                }
                if (this.f27285d == 0) {
                    this.f27285d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f27285d) / 1000 > this.f27283b) {
                    this.f27285d = valueOf.longValue();
                    this.f27286e = 0;
                    boolean z2 = f27281f;
                }
                this.f27286e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f27286e;
            return i2 != 0 && i2 == this.f27284c;
        }
        return invokeV.booleanValue;
    }
}
