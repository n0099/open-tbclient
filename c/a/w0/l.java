package c.a.w0;

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
    public static final boolean f26728f;

    /* renamed from: g  reason: collision with root package name */
    public static String f26729g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26730b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26731c;

    /* renamed from: d  reason: collision with root package name */
    public long f26732d;

    /* renamed from: e  reason: collision with root package name */
    public int f26733e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1353675999, "Lc/a/w0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1353675999, "Lc/a/w0/l;");
                return;
            }
        }
        f26728f = k.a & true;
        f26729g = "ControlData";
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
        this.f26730b = i2;
        this.f26731c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f26730b != 0 && this.f26731c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f26728f) {
                    String str = "id " + this.a + " mLimitUnit " + this.f26730b + " mLimitCnt " + this.f26731c + "mCount =  " + this.f26733e + " duration " + ((valueOf.longValue() - this.f26732d) / 1000);
                }
                if (this.f26732d != 0 && (valueOf.longValue() - this.f26732d) / 1000 <= this.f26730b && this.f26733e >= this.f26731c) {
                    boolean z = f26728f;
                    return true;
                }
                if (this.f26732d == 0) {
                    this.f26732d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f26732d) / 1000 > this.f26730b) {
                    this.f26732d = valueOf.longValue();
                    this.f26733e = 0;
                    boolean z2 = f26728f;
                }
                this.f26733e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f26733e;
            return i2 != 0 && i2 == this.f26731c;
        }
        return invokeV.booleanValue;
    }
}
