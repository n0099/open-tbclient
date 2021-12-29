package c.a.t0.k1;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1148a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC1148a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.e();
            }
        }
    }

    public static boolean b(NetWork netWork) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, netWork)) == null) {
            if (netWork == null) {
                return false;
            }
            if ((netWork.isNetSuccess() ? netWork.getServerErrorCode() : netWork.getNetErrorCode()) == 1990055) {
                d();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            switch (i2) {
                case 202001:
                case 205001:
                case 309456:
                case CmdConfigHttp.CMD_CHECK_REAL_NAME /* 1003325 */:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (!n.B()) {
                TbadkCoreApplication.getInst().handler.post(new RunnableC1148a());
            } else {
                e();
            }
        }
    }

    public static final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
            c.a.s0.m.a.s(applicationContext, "", UrlSchemaHelper.REAL_NAME_AUTH_URL + "&u=" + URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW), true, true, true, true, true, false);
        }
    }
}
