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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2, i2) == null) {
            onNestedScrollAccepted(view, view2, i2, 0);
        }
    }

    public void onStopNestedScroll(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            onStopNestedScroll(view, 0);
        }
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, view, view2, i2, i3) == null) {
            if (i3 == 1) {
                this.mNestedScrollAxesNonTouch = i2;
            } else {
                this.mNestedScrollAxesTouch = i2;
            }
        }
    }

    public void onStopNestedScroll(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, view, i2) == null) {
            if (i2 == 1) {
                this.mNestedScrollAxesNonTouch = 0;
            } else {
                this.mNestedScrollAxesTouch = 0;
            }
        }
    }
}
