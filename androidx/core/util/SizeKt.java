package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0087\n¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\u0004H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/util/Size;", "", "component1", "(Landroid/util/Size;)I", "Landroid/util/SizeF;", "", "(Landroid/util/SizeF;)F", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class SizeKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final float component1(SizeF sizeF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sizeF)) == null) {
            return sizeF.getWidth();
        }
        return invokeL.floatValue;
    }

    public static final float component2(SizeF sizeF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sizeF)) == null) {
            return sizeF.getHeight();
        }
        return invokeL.floatValue;
    }

    public static final int component1(Size size) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, size)) == null) {
            return size.getWidth();
        }
        return invokeL.intValue;
    }

    public static final int component2(Size size) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, size)) == null) {
            return size.getHeight();
        }
        return invokeL.intValue;
    }
}
