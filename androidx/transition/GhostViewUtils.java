package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class GhostViewUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GhostViewUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static GhostView addGhost(@NonNull View view, @NonNull ViewGroup viewGroup, @Nullable Matrix matrix) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view, viewGroup, matrix)) == null) {
            if (Build.VERSION.SDK_INT == 28) {
                return GhostViewPlatform.addGhost(view, viewGroup, matrix);
            }
            return GhostViewPort.addGhost(view, viewGroup, matrix);
        }
        return (GhostView) invokeLLL.objValue;
    }

    public static void removeGhost(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, view) == null) {
            if (Build.VERSION.SDK_INT == 28) {
                GhostViewPlatform.removeGhost(view);
            } else {
                GhostViewPort.removeGhost(view);
            }
        }
    }
}
