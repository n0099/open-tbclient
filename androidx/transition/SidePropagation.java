package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mPropagationSpeed;
    public int mSide;

    public SidePropagation() {
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
        this.mSide = 80;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if ((androidx.core.view.ViewCompat.getLayoutDirection(r7) == 1) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        r0 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        r0 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
        if ((androidx.core.view.ViewCompat.getLayoutDirection(r7) == 1) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int distance(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)})) == null) {
            int i9 = this.mSide;
            if (i9 != 8388611) {
                if (i9 == 8388613) {
                }
            }
            if (i9 != 3) {
                if (i9 != 5) {
                    if (i9 != 48) {
                        if (i9 != 80) {
                            return 0;
                        }
                        return (i2 - i6) + Math.abs(i3 - i);
                    }
                    return (i8 - i2) + Math.abs(i3 - i);
                }
                return (i - i5) + Math.abs(i4 - i2);
            }
            return (i7 - i) + Math.abs(i4 - i2);
        }
        return invokeCommon.intValue;
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, viewGroup)) == null) {
            int i = this.mSide;
            if (i != 3 && i != 5 && i != 8388611 && i != 8388613) {
                return viewGroup.getHeight();
            }
            return viewGroup.getWidth();
        }
        return invokeL.intValue;
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, viewGroup, transition, transitionValues, transitionValues2)) == null) {
            TransitionValues transitionValues3 = transitionValues;
            if (transitionValues3 == null && transitionValues2 == null) {
                return 0L;
            }
            Rect epicenter = transition.getEpicenter();
            if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
                i = -1;
            } else {
                transitionValues3 = transitionValues2;
                i = 1;
            }
            int viewX = getViewX(transitionValues3);
            int viewY = getViewY(transitionValues3);
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = iArr[0] + Math.round(viewGroup.getTranslationX());
            int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
            int width = round + viewGroup.getWidth();
            int height = round2 + viewGroup.getHeight();
            if (epicenter != null) {
                i2 = epicenter.centerX();
                i3 = epicenter.centerY();
            } else {
                i2 = (round + width) / 2;
                i3 = (round2 + height) / 2;
            }
            float distance = distance(viewGroup, viewX, viewY, i2, i3, round, round2, width, height) / getMaxDistance(viewGroup);
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

    public void setSide(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.mSide = i;
        }
    }
}
