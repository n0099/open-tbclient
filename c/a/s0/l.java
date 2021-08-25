package c.a.s0;

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
    public static final boolean f29940f;

    /* renamed from: g  reason: collision with root package name */
    public static String f29941g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f29942a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29943b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29944c;

    /* renamed from: d  reason: collision with root package name */
    public long f29945d;

    /* renamed from: e  reason: collision with root package name */
    public int f29946e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349981915, "Lc/a/s0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349981915, "Lc/a/s0/l;");
                return;
            }
        }
        f29940f = k.f29930a & true;
        f29941g = "ControlData";
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
        this.f29942a = str;
        this.f29943b = i2;
        this.f29944c = i3;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f29943b != 0 && this.f29944c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f29940f) {
                    String str = "id " + this.f29942a + " mLimitUnit " + this.f29943b + " mLimitCnt " + this.f29944c + "mCount =  " + this.f29946e + " duration " + ((valueOf.longValue() - this.f29945d) / 1000);
                }
                if (this.f29945d != 0 && (valueOf.longValue() - this.f29945d) / 1000 <= this.f29943b && this.f29946e >= this.f29944c) {
                    boolean z = f29940f;
                    return true;
                }
                if (this.f29945d == 0) {
                    this.f29945d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f29945d) / 1000 > this.f29943b) {
                    this.f29945d = valueOf.longValue();
                    this.f29946e = 0;
                    boolean z2 = f29940f;
                }
                this.f29946e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f29946e;
            return i2 != 0 && i2 == this.f29944c;
        }
        return invokeV.booleanValue;
    }
}
