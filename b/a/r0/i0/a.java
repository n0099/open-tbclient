package b.a.r0.i0;

import android.telephony.TelephonyManager;
import b.a.e.e.p.j;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f17814c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f17815d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f17816e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f17817f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f17818a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f17819b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1657494232, "Lb/a/r0/i0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1657494232, "Lb/a/r0/i0/a;");
                return;
            }
        }
        f17814c = new String[]{"119.75.222.62", "119.75.222.63"};
        f17815d = new String[]{"111.13.100.247", "117.185.16.61"};
        f17816e = new String[]{"111.206.37.190"};
        f17817f = new String[]{"115.239.211.146", "180.97.33.196"};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b();
            if (j.H()) {
                return f17817f[new Random().nextInt(f17817f.length)];
            }
            if (j.x()) {
                if (this.f17818a == 1) {
                    return f17814c[new Random().nextInt(f17814c.length)];
                }
                if (this.f17818a == 2) {
                    return f17815d[new Random().nextInt(f17815d.length)];
                }
                if (this.f17818a == 3) {
                    return f17816e[new Random().nextInt(f17816e.length)];
                }
            }
            return "119.75.222.62";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            try {
                this.f17819b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f17818a = 0;
            if (this.f17819b != null) {
                if (!this.f17819b.startsWith("46000") && !this.f17819b.startsWith("46002") && !this.f17819b.startsWith("46007")) {
                    if (!this.f17819b.startsWith("46001") && !this.f17819b.startsWith("46006")) {
                        if (this.f17819b.startsWith("46003") || this.f17819b.startsWith("46005")) {
                            this.f17818a = 3;
                            return;
                        }
                        return;
                    }
                    this.f17818a = 2;
                    return;
                }
                this.f17818a = 1;
            }
        }
    }
}
