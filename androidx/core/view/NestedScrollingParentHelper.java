package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class NestedScrollingParentHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mNestedScrollAxesNonTouch;
    public int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mNestedScrollAxesTouch | this.mNestedScrollAxesNonTouch : invokeV.intValue;
    }

    public void onNestedScrollAccepted(@NonNull View view2, @NonNull View view3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3, i) == null) {
            onNestedScrollAccepted(view2, view3, i, 0);
        }
    }

    public void onStopNestedScroll(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            onStopNestedScroll(view2, 0);
        }
    }

    public void onNestedScrollAccepted(@NonNull View view2, @NonNull View view3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, view2, view3, i, i2) == null) {
            if (i2 == 1) {
                this.mNestedScrollAxesNonTouch = i;
            } else {
                this.mNestedScrollAxesTouch = i;
            }
        }
    }

    public void onStopNestedScroll(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) {
            if (i == 1) {
                this.mNestedScrollAxesNonTouch = 0;
            } else {
                this.mNestedScrollAxesTouch = 0;
            }
        }
    }
}
