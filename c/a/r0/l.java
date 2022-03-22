package c.a.r0;

import android.util.Log;
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
    public static final boolean f21164f;

    /* renamed from: g  reason: collision with root package name */
    public static String f21165g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21166b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21167c;

    /* renamed from: d  reason: collision with root package name */
    public long f21168d;

    /* renamed from: e  reason: collision with root package name */
    public int f21169e;

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
        f21164f = k.a & true;
        f21165g = "ControlData";
    }

    public l(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f21166b = i;
        this.f21167c = i2;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f21166b != 0 && this.f21167c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f21164f) {
                    Log.d(f21165g, "id " + this.a + " mLimitUnit " + this.f21166b + " mLimitCnt " + this.f21167c + "mCount =  " + this.f21169e + " duration " + ((valueOf.longValue() - this.f21168d) / 1000));
                }
                if (this.f21168d != 0 && (valueOf.longValue() - this.f21168d) / 1000 <= this.f21166b && this.f21169e >= this.f21167c) {
                    if (f21164f) {
                        Log.d(f21165g, "control");
                    }
                    return true;
                }
                if (this.f21168d == 0) {
                    this.f21168d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.f21168d) / 1000 > this.f21166b) {
                    this.f21168d = valueOf.longValue();
                    this.f21169e = 0;
                    if (f21164f) {
                        Log.d(f21165g, "reset");
                    }
                }
                this.f21169e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.f21169e;
            return i != 0 && i == this.f21167c;
        }
        return invokeV.booleanValue;
    }
}
