package c.a.p0.h0;

import android.telephony.TelephonyManager;
import c.a.e.e.p.j;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f18094c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f18095d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f18096e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f18097f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f18098a;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f18099b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1699967240, "Lc/a/p0/h0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1699967240, "Lc/a/p0/h0/a;");
                return;
            }
        }
        f18094c = new String[]{"119.75.222.62", "119.75.222.63"};
        f18095d = new String[]{"111.13.100.247", "117.185.16.61"};
        f18096e = new String[]{"111.206.37.190"};
        f18097f = new String[]{"115.239.211.146", "180.97.33.196"};
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
                return f18097f[new Random().nextInt(f18097f.length)];
            }
            if (j.x()) {
                if (this.f18098a == 1) {
                    return f18094c[new Random().nextInt(f18094c.length)];
                }
                if (this.f18098a == 2) {
                    return f18095d[new Random().nextInt(f18095d.length)];
                }
                if (this.f18098a == 3) {
                    return f18096e[new Random().nextInt(f18096e.length)];
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
                this.f18099b = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            this.f18098a = 0;
            if (this.f18099b != null) {
                if (!this.f18099b.startsWith("46000") && !this.f18099b.startsWith("46002") && !this.f18099b.startsWith("46007")) {
                    if (!this.f18099b.startsWith("46001") && !this.f18099b.startsWith("46006")) {
                        if (this.f18099b.startsWith("46003") || this.f18099b.startsWith("46005")) {
                            this.f18098a = 3;
                            return;
                        }
                        return;
                    }
                    this.f18098a = 2;
                    return;
                }
                this.f18098a = 1;
            }
        }
    }
}
