package androidx.transition;

import android.os.Build;
import android.view.View;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ViewUtilsApi23 extends ViewUtilsApi22 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean sTryHiddenSetTransitionVisibility = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(905819948, "Landroidx/transition/ViewUtilsApi23;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(905819948, "Landroidx/transition/ViewUtilsApi23;");
        }
    }

    public ViewUtilsApi23() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionVisibility(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            if (Build.VERSION.SDK_INT == 28) {
                super.setTransitionVisibility(view2, i);
            } else if (sTryHiddenSetTransitionVisibility) {
                try {
                    view2.setTransitionVisibility(i);
                } catch (NoSuchMethodError unused) {
                    sTryHiddenSetTransitionVisibility = false;
                }
            }
        }
    }
}
