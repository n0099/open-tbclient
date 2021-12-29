package c.a.r0.a.p.e.j;

import androidx.annotation.NonNull;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f8342b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f8343c;

    /* renamed from: d  reason: collision with root package name */
    public long f8344d;

    /* renamed from: e  reason: collision with root package name */
    public long f8345e;

    /* renamed from: f  reason: collision with root package name */
    public long f8346f;

    /* renamed from: g  reason: collision with root package name */
    public String f8347g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(412429054, "Lc/a/r0/a/p/e/j/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(412429054, "Lc/a/r0/a/p/e/j/d;");
                return;
            }
        }
        boolean z = k.a;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8347g = "1";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f8347g;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "unknown" : "fip" : "ftp" : "fcp" : "fmp";
        }
        return (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.f8346f;
            if (j2 > 0) {
                return j2;
            }
            long[] jArr = {this.f8344d, this.f8345e, this.f8342b};
            long j3 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < 3; i2++) {
                long j4 = jArr[i2];
                if (j4 > 0 && j4 < j3) {
                    j3 = j4;
                }
            }
            if (j3 != Long.MAX_VALUE) {
                this.f8346f = j3;
            }
            return this.f8346f;
        }
        return invokeV.longValue;
    }

    public String c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? j2 == this.f8344d ? "2" : j2 == this.f8345e ? "3" : (j2 != this.f8342b && j2 == this.f8343c) ? "0" : "1" : (String) invokeJ.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "WebViewPaintTiming{fp=" + this.a + ", fcp=" + this.f8342b + ", fmp=" + this.f8343c + ", ftp=" + this.f8344d + ", fip=" + this.f8345e + ", mMinCache=" + this.f8346f + ", fmpType='" + this.f8347g + ExtendedMessageFormat.QUOTE + ", fmpTypeName='" + a() + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
