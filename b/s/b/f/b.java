package b.s.b.f;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.open.deviceidentifiertest.VirtualDevice;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f33729a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                if (f33729a == null) {
                    f33729a = new VirtualDevice().getDeviceID(context);
                }
                return f33729a;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
