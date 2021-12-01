package c.a.b0.g0.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull c.a.b0.g0.u.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, aVar, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript:")) {
            str = "javascript:" + str;
        }
        aVar.loadUrl(str, null);
    }

    public static <T> void b(@NonNull c.a.b0.g0.u.a aVar, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            a(aVar, "NadJsControl.visibleRectChange(".concat(String.valueOf(i2)).concat(",").concat(String.valueOf(i3)).concat(",").concat(String.valueOf(i4)).concat(",").concat(String.valueOf(i5)).concat(");"));
        }
    }
}
