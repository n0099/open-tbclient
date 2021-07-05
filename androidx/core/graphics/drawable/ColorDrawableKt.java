package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/graphics/Color;", "Landroid/graphics/drawable/ColorDrawable;", "toDrawable", "(Landroid/graphics/Color;)Landroid/graphics/drawable/ColorDrawable;", "", "(I)Landroid/graphics/drawable/ColorDrawable;", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ColorDrawableKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ColorDrawable toDrawable(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? new ColorDrawable(i2) : (ColorDrawable) invokeI.objValue;
    }

    @RequiresApi(26)
    public static final ColorDrawable toDrawable(Color color) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, color)) == null) ? new ColorDrawable(color.toArgb()) : (ColorDrawable) invokeL.objValue;
    }
}
