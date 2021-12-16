package c.a.r0.t.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static Domain a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13631b;

    /* renamed from: c  reason: collision with root package name */
    public static b f13632c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-135249490, "Lc/a/r0/t/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-135249490, "Lc/a/r0/t/a/a;");
                return;
            }
        }
        a = Domain.DOMAIN_ONLINE;
        f13631b = true;
        f13632c = null;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (TbConfig.USE_OLD_LOGIN) {
                f13631b = true;
                return;
            }
            if (Build.VERSION.SDK_INT < 9) {
                if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                    f13631b = false;
                } else {
                    f13631b = true;
                }
            } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
                f13631b = false;
            } else {
                f13631b = true;
            }
            if (Build.VERSION.SDK_INT > 10 || f13631b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
                return;
            }
            TbadkCoreApplication.getInst().incPassportV6CrashCount();
            f13631b = true;
        }
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f13632c : (b) invokeV.objValue;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || f13632c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f13632c = (b) runTask.getData();
    }
}
