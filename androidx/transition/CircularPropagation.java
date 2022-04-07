package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mPropagationSpeed;

    public CircularPropagation() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPropagationSpeed = 3.0f;
    }

    public static float distance(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float f5 = f3 - f;
            float f6 = f4 - f2;
            return (float) Math.sqrt((f5 * f5) + (f6 * f6));
        }
        return invokeCommon.floatValue;
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        int i;
        int round;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, viewGroup, transition, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null && transitionValues2 == null) {
                return 0L;
            }
            if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
                i = -1;
            } else {
                transitionValues = transitionValues2;
                i = 1;
            }
            int viewX = getViewX(transitionValues);
            int viewY = getViewY(transitionValues);
            Rect epicenter = transition.getEpicenter();
            if (epicenter != null) {
                i2 = epicenter.centerX();
                round = epicenter.centerY();
            } else {
                int[] iArr = new int[2];
                viewGroup.getLocationOnScreen(iArr);
                int round2 = Math.round(iArr[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
                round = Math.round(iArr[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
                i2 = round2;
            }
            float distance = distance(viewX, viewY, i2, round) / distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
            long duration = transition.getDuration();
            if (duration < 0) {
                duration = 300;
            }
            return Math.round((((float) (duration * i)) / this.mPropagationSpeed) * distance);
        }
        return invokeLLLL.longValue;
    }

    public void setPropagationSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            if (f != 0.0f) {
                this.mPropagationSpeed = f;
                return;
            }
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
    }
}
