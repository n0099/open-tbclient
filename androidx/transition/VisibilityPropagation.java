package androidx.transition;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    public static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    public static final String[] VISIBILITY_PROPAGATION_VALUES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(440773345, "Landroidx/transition/VisibilityPropagation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(440773345, "Landroidx/transition/VisibilityPropagation;");
                return;
            }
        }
        VISIBILITY_PROPAGATION_VALUES = new String[]{PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};
    }

    public VisibilityPropagation() {
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

    @Override // androidx.transition.TransitionPropagation
    public String[] getPropagationProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return VISIBILITY_PROPAGATION_VALUES;
        }
        return (String[]) invokeV.objValue;
    }

    public static int getViewCoordinate(TransitionValues transitionValues, int i) {
        InterceptResult invokeLI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, transitionValues, i)) == null) {
            if (transitionValues == null || (iArr = (int[]) transitionValues.values.get(PROPNAME_VIEW_CENTER)) == null) {
                return -1;
            }
            return iArr[i];
        }
        return invokeLI.intValue;
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            View view2 = transitionValues.f1028view;
            Integer num = (Integer) transitionValues.values.get(Visibility.PROPNAME_VISIBILITY);
            if (num == null) {
                num = Integer.valueOf(view2.getVisibility());
            }
            transitionValues.values.put(PROPNAME_VISIBILITY, num);
            view2.getLocationOnScreen(r2);
            int[] iArr = {iArr[0] + Math.round(view2.getTranslationX())};
            iArr[0] = iArr[0] + (view2.getWidth() / 2);
            iArr[1] = iArr[1] + Math.round(view2.getTranslationY());
            iArr[1] = iArr[1] + (view2.getHeight() / 2);
            transitionValues.values.put(PROPNAME_VIEW_CENTER, iArr);
        }
    }

    public int getViewVisibility(TransitionValues transitionValues) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transitionValues)) == null) {
            if (transitionValues == null || (num = (Integer) transitionValues.values.get(PROPNAME_VISIBILITY)) == null) {
                return 8;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public int getViewX(TransitionValues transitionValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, transitionValues)) == null) {
            return getViewCoordinate(transitionValues, 0);
        }
        return invokeL.intValue;
    }

    public int getViewY(TransitionValues transitionValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, transitionValues)) == null) {
            return getViewCoordinate(transitionValues, 1);
        }
        return invokeL.intValue;
    }
}
