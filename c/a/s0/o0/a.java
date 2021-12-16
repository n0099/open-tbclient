package c.a.s0.o0;

import android.telephony.TelephonyManager;
import c.a.d.f.p.k;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f20559c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f20560d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f20561e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f20562f;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f20563b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-760038884, "Lc/a/s0/o0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-760038884, "Lc/a/s0/o0/a;");
                return;
            }
        }
        f20559c = new String[]{"119.75.222.62", "119.75.222.63"};
        f20560d = new String[]{"111.13.100.247", "117.185.16.61"};
        f20561e = new String[]{"111.206.37.190"};
        f20562f = new String[]{"115.239.211.146", "180.97.33.196"};
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
            if (k.H()) {
                return f20562f[new Random().nextInt(f20562f.length)];
            }
            if (k.x()) {
                if (this.a == 1) {
                    return f20559c[new Random().nextInt(f20559c.length)];
                }
                if (this.a == 2) {
                    return f20560d[new Random().nextInt(f20560d.length)];
                }
                if (this.a == 3) {
                    return f20561e[new Random().nextInt(f20561e.length)];
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
                this.f20563b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.a = 0;
            if (this.f20563b != null) {
                if (!this.f20563b.startsWith("46000") && !this.f20563b.startsWith("46002") && !this.f20563b.startsWith("46007")) {
                    if (!this.f20563b.startsWith("46001") && !this.f20563b.startsWith("46006")) {
                        if (this.f20563b.startsWith("46003") || this.f20563b.startsWith("46005")) {
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
