package c.a.t0;

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
    public static final boolean f30078f;

    /* renamed from: g  reason: collision with root package name */
    public static String f30079g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f30080a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30081b;

    /* renamed from: c  reason: collision with root package name */
    public final int f30082c;

    /* renamed from: d  reason: collision with root package name */
    public long f30083d;

    /* renamed from: e  reason: collision with root package name */
    public int f30084e;

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
        f30078f = k.f30068a & true;
        f30079g = "ControlData";
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
        this.f30080a = str;
        this.f30081b = i2;
        this.f30082c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f30081b != 0 && this.f30082c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f30078f) {
                    String str = "id " + this.f30080a + " mLimitUnit " + this.f30081b + " mLimitCnt " + this.f30082c + "mCount =  " + this.f30084e + " duration " + ((valueOf.longValue() - this.f30083d) / 1000);
                }
                if (this.f30083d != 0 && (valueOf.longValue() - this.f30083d) / 1000 <= this.f30081b && this.f30084e >= this.f30082c) {
                    boolean z = f30078f;
                    return true;
                }
                if (this.f30083d == 0) {
                    this.f30083d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f30083d) / 1000 > this.f30081b) {
                    this.f30083d = valueOf.longValue();
                    this.f30084e = 0;
                    boolean z2 = f30078f;
                }
                this.f30084e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f30084e;
            return i2 != 0 && i2 == this.f30082c;
        }
        return invokeV.booleanValue;
    }
}
