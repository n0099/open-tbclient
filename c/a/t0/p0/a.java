package c.a.t0.p0;

import android.telephony.TelephonyManager;
import c.a.d.f.p.l;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f20372c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f20373d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f20374e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f20375f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f20376b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(983694972, "Lc/a/t0/p0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(983694972, "Lc/a/t0/p0/a;");
                return;
            }
        }
        f20372c = new String[]{"119.75.222.62", "119.75.222.63"};
        f20373d = new String[]{"111.13.100.247", "117.185.16.61"};
        f20374e = new String[]{"111.206.37.190"};
        f20375f = new String[]{"115.239.211.146", "180.97.33.196"};
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
            if (l.H()) {
                return f20375f[new Random().nextInt(f20375f.length)];
            }
            if (l.x()) {
                if (this.a == 1) {
                    return f20372c[new Random().nextInt(f20372c.length)];
                }
                if (this.a == 2) {
                    return f20373d[new Random().nextInt(f20373d.length)];
                }
                if (this.a == 3) {
                    return f20374e[new Random().nextInt(f20374e.length)];
                }
            }
            return "119.75.222.62";
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && PermissionUtil.isAgreePrivacyPolicy() && PermissionUtil.checkReadPhoneState(TbadkCoreApplication.getInst().getContext())) {
            try {
                this.f20376b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.a = 0;
            if (this.f20376b != null) {
                if (!this.f20376b.startsWith("46000") && !this.f20376b.startsWith("46002") && !this.f20376b.startsWith("46007")) {
                    if (!this.f20376b.startsWith("46001") && !this.f20376b.startsWith("46006")) {
                        if (this.f20376b.startsWith("46003") || this.f20376b.startsWith("46005")) {
                            this.a = 3;
                            return;
                        }
                        return;
                    }
                    this.a = 2;
                    return;
                }
                this.a = 1;
            }
        }
    }
}
