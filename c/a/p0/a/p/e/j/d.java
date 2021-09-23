package c.a.p0.a.p.e.j;

import androidx.annotation.NonNull;
import c.a.p0.a.k;
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

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f7898h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f7899a;

    /* renamed from: b  reason: collision with root package name */
    public long f7900b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f7901c;

    /* renamed from: d  reason: collision with root package name */
    public long f7902d;

    /* renamed from: e  reason: collision with root package name */
    public long f7903e;

    /* renamed from: f  reason: collision with root package name */
    public long f7904f;

    /* renamed from: g  reason: collision with root package name */
    public String f7905g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999235068, "Lc/a/p0/a/p/e/j/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999235068, "Lc/a/p0/a/p/e/j/d;");
                return;
            }
        }
        f7898h = k.f7085a;
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
        this.f7905g = "1";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public String a() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.f7905g;
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
            long j2 = this.f7904f;
            if (j2 > 0) {
                return j2;
            }
            long[] jArr = {this.f7902d, this.f7903e, this.f7900b};
            long j3 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < 3; i2++) {
                long j4 = jArr[i2];
                if (j4 > 0 && j4 < j3) {
                    j3 = j4;
                }
            }
            if (j3 != Long.MAX_VALUE) {
                this.f7904f = j3;
            }
            return this.f7904f;
        }
        return invokeV.longValue;
    }

    public String c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? j2 == this.f7902d ? "2" : j2 == this.f7903e ? "3" : (j2 != this.f7900b && j2 == this.f7901c) ? "0" : "1" : (String) invokeJ.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f7901c > 0 && this.f7901c != this.f7902d && this.f7901c != this.f7903e && this.f7901c != this.f7900b) {
                if (f7898h) {
                    String str = "tryCalibrateFmp: miss with real fmp=" + this.f7901c;
                }
            } else if (this.f7902d > 0) {
                if (f7898h) {
                    String str2 = "tryCalibrateFmp: hit with ftp=" + this.f7902d;
                }
                this.f7901c = this.f7902d;
                this.f7905g = "2";
            } else if (this.f7903e > 0) {
                if (f7898h) {
                    String str3 = "tryCalibrateFmp: hit with fip=" + this.f7903e;
                }
                this.f7901c = this.f7903e;
                this.f7905g = "3";
            } else if (this.f7900b > 0) {
                if (f7898h) {
                    String str4 = "tryCalibrateFmp: hit with fcp=" + this.f7900b;
                }
                this.f7901c = this.f7900b;
                this.f7905g = "1";
            } else if (f7898h) {
                throw new RuntimeException("ftp fcp fip 至少收到上述一个回调才能校准 fmp \n" + toString());
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "WebViewPaintTiming{fp=" + this.f7899a + ", fcp=" + this.f7900b + ", fmp=" + this.f7901c + ", ftp=" + this.f7902d + ", fip=" + this.f7903e + ", mMinCache=" + this.f7904f + ", fmpType='" + this.f7905g + ExtendedMessageFormat.QUOTE + ", fmpTypeName='" + a() + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
