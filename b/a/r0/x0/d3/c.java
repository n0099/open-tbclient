package b.a.r0.x0.d3;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Serializable;
import kotlin.TypeCastException;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final long d(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) ? bundle.getLong("extra_fid") : invokeL.longValue;
    }

    public static final String e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle)) == null) ? bundle.getString("extra_forum_name") : (String) invokeL.objValue;
    }

    public static final Frs$From f(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bundle)) == null) {
            Serializable serializable = bundle.getSerializable("extra_from");
            if (serializable != null) {
                return (Frs$From) serializable;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.module.frs.Frs.From");
        }
        return (Frs$From) invokeL.objValue;
    }
}
