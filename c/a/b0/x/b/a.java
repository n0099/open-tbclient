package c.a.b0.x.b;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.b0.r.g;
import c.a.b0.r.s.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d dVar = new d();
        dVar.k(str);
        dVar.g(3000);
        dVar.d("User-Agent", c.a.b0.e.a.d());
        dVar.c();
        g.b().a().a(dVar, null);
    }
}
