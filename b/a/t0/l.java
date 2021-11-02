package b.a.t0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f28823f;

    /* renamed from: g  reason: collision with root package name */
    public static String f28824g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f28825a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28826b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28827c;

    /* renamed from: d  reason: collision with root package name */
    public long f28828d;

    /* renamed from: e  reason: collision with root package name */
    public int f28829e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136607397, "Lb/a/t0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136607397, "Lb/a/t0/l;");
                return;
            }
        }
        f28823f = k.f28821a & true;
        f28824g = "ControlData";
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
        this.f28825a = str;
        this.f28826b = i2;
        this.f28827c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f28826b != 0 && this.f28827c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f28823f) {
                    String str = "id " + this.f28825a + " mLimitUnit " + this.f28826b + " mLimitCnt " + this.f28827c + "mCount =  " + this.f28829e + " duration " + ((valueOf.longValue() - this.f28828d) / 1000);
                }
                if (this.f28828d != 0 && (valueOf.longValue() - this.f28828d) / 1000 <= this.f28826b && this.f28829e >= this.f28827c) {
                    boolean z = f28823f;
                    return true;
                }
                if (this.f28828d == 0) {
                    this.f28828d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f28828d) / 1000 > this.f28826b) {
                    this.f28828d = valueOf.longValue();
                    this.f28829e = 0;
                    boolean z2 = f28823f;
                }
                this.f28829e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f28829e;
            return i2 != 0 && i2 == this.f28827c;
        }
        return invokeV.booleanValue;
    }
}
