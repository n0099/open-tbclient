package c.a.p0.a.v2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Context context, @NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, context, file) == null) && file.exists()) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.SEND");
            intent.setTypeAndNormalize(q0.s(file));
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("android.intent.extra.STREAM", s0.a(context, file));
                intent.addFlags(1);
            } else {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            }
            context.startActivity(intent);
        }
    }
}
