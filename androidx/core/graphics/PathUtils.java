package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public final class PathUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PathUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, path)) == null) ? flatten(path, 0.5f) : (Collection) invokeL.objValue;
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, path, f2)) == null) {
            float[] approximate = path.approximate(f2);
            int length = approximate.length / 3;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 1; i < length; i++) {
                int i2 = i * 3;
                int i3 = (i - 1) * 3;
                float f3 = approximate[i2];
                float f4 = approximate[i2 + 1];
                float f5 = approximate[i2 + 2];
                float f6 = approximate[i3];
                float f7 = approximate[i3 + 1];
                float f8 = approximate[i3 + 2];
                if (f3 != f6 && (f4 != f7 || f5 != f8)) {
                    arrayList.add(new PathSegment(new PointF(f7, f8), f6, new PointF(f4, f5), f3));
                }
            }
            return arrayList;
        }
        return (Collection) invokeLF.objValue;
    }
}
