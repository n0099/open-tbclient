package androidx.core.graphics;

import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/graphics/Paint;", "Landroidx/core/graphics/BlendModeCompat;", "blendModeCompat", "", "setBlendMode", "(Landroid/graphics/Paint;Landroidx/core/graphics/BlendModeCompat;)Z", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class PaintKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, paint, blendModeCompat)) == null) ? PaintCompat.setBlendMode(paint, blendModeCompat) : invokeLL.booleanValue;
    }
}
