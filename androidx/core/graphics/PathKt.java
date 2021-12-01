package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u0003\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\f\u0010\u0003\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\r\u0010\u0003¨\u0006\u000e"}, d2 = {"Landroid/graphics/Path;", "p", "and", "(Landroid/graphics/Path;Landroid/graphics/Path;)Landroid/graphics/Path;", "", "error", "", "Landroidx/core/graphics/PathSegment;", "flatten", "(Landroid/graphics/Path;F)Ljava/lang/Iterable;", "minus", "or", "plus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class PathKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(19)
    public static final Path and(Path path, Path path2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, path, path2)) == null) {
            Path path3 = new Path();
            path3.op(path, path2, Path.Op.INTERSECT);
            return path3;
        }
        return (Path) invokeLL.objValue;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, path, f2)) == null) {
            Collection<PathSegment> flatten = PathUtils.flatten(path, f2);
            Intrinsics.checkExpressionValueIsNotNull(flatten, "PathUtils.flatten(this, error)");
            return flatten;
        }
        return (Iterable) invokeLF.objValue;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return flatten(path, f2);
    }

    @RequiresApi(19)
    public static final Path minus(Path path, Path path2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, path, path2)) == null) {
            Path path3 = new Path(path);
            path3.op(path2, Path.Op.DIFFERENCE);
            return path3;
        }
        return (Path) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Path or(Path path, Path path2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, path, path2)) == null) {
            Path path3 = new Path(path);
            path3.op(path2, Path.Op.UNION);
            return path3;
        }
        return (Path) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path path2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, path, path2)) == null) {
            Path path3 = new Path(path);
            path3.op(path2, Path.Op.UNION);
            return path3;
        }
        return (Path) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path path2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, path, path2)) == null) {
            Path path3 = new Path(path);
            path3.op(path2, Path.Op.XOR);
            return path3;
        }
        return (Path) invokeLL.objValue;
    }
}
