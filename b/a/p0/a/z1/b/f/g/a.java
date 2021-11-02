package b.a.p0.a.z1.b.f.g;

import android.content.Context;
import androidx.annotation.Nullable;
import b.a.p0.a.v2.n0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@Nullable Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, context, f2)) == null) ? n0.f(context, f2) : invokeLF.intValue;
    }
}
