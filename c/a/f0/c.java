package c.a.f0;

import android.os.Bundle;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bundle) == null) {
            if (bundle == null) {
                PaymentManager.i(3, "闪付返回信息为空");
                return;
            }
            String string = bundle.getString(EnterDxmPayServiceAction.SERVICE_STATUS_CODE);
            try {
                PaymentManager.i(Integer.parseInt(string), bundle.getString("payInfo"));
            } catch (NumberFormatException e2) {
                PaymentManager.i(3, e2.getMessage());
            }
        }
    }

    public static void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bundle) == null) {
            a.a().g(bundle);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && ProcessUtils.isMainProcess()) {
            a.a().h("");
        }
    }
}
