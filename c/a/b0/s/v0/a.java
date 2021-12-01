package c.a.b0.s.v0;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void a(@Nullable Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65536, null, activity, z) == null) || activity == null) {
            return;
        }
        if (z) {
            activity.setRequestedOrientation(8);
        } else {
            activity.setRequestedOrientation(0);
        }
        activity.getWindow().setFlags(1024, 1024);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, activity) == null) || activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }
}
