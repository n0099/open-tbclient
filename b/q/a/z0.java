package b.q.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static w0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT < 23) {
                return null;
            }
            t0 t0Var = new t0(context);
            try {
                try {
                    Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                    intent.setPackage("com.huawei.hwid");
                    if (context.bindService(intent, t0Var, 1)) {
                        com.win.opensdk.a aVar = (com.win.opensdk.a) com.win.opensdk.b.a(t0Var.a());
                        return new w0(aVar.a(), aVar.b());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            } finally {
                context.unbindService(t0Var);
            }
        }
        return (w0) invokeL.objValue;
    }
}
