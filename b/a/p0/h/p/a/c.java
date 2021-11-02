package b.a.p0.h.p.a;

import android.text.TextUtils;
import b.a.p0.a.k2.g.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? TextUtils.equals(h.b("swan_debug_feature").getString("KEY_DEBUG_SWAN_GAME_CORE_MODE", "none"), str) : invokeL.booleanValue;
    }
}
