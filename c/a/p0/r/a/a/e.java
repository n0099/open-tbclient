package c.a.p0.r.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, context, intent, bundle) == null) {
            context.startActivity(intent, bundle);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, activity, intent, i2, bundle) == null) {
            activity.startActivityForResult(intent, i2, bundle);
        }
    }
}
