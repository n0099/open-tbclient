package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(22)
/* loaded from: classes.dex */
public class ViewUtilsApi22 extends ViewUtilsApi21 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean sTryHiddenSetLeftTopRightBottom = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(905819917, "Landroidx/transition/ViewUtilsApi22;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(905819917, "Landroidx/transition/ViewUtilsApi22;");
        }
    }

    public ViewUtilsApi22() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(@NonNull View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && sTryHiddenSetLeftTopRightBottom) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}
