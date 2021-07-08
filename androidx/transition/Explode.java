package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Explode extends Visibility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    public static final TimeInterpolator sAccelerate;
    public static final TimeInterpolator sDecelerate;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] mTempLoc;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(737568314, "Landroidx/transition/Explode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(737568314, "Landroidx/transition/Explode;");
                return;
            }
        }
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    public static float calculateDistance(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (float) Math.sqrt((f2 * f2) + (f3 * f3)) : invokeCommon.floatValue;
    }

    public static float calculateMaxDistance(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, view, i2, i3)) == null) ? calculateDistance(Math.max(i2, view.getWidth() - i2), Math.max(i3, view.getHeight() - i3)) : invokeLII.floatValue;
    }

    private void calculateOut(View view, Rect rect, int[] iArr) {
        int centerY;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, view, rect, iArr) == null) {
            view.getLocationOnScreen(this.mTempLoc);
            int[] iArr2 = this.mTempLoc;
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            Rect epicenter = getEpicenter();
            if (epicenter == null) {
                i2 = (view.getWidth() / 2) + i3 + Math.round(view.getTranslationX());
                centerY = (view.getHeight() / 2) + i4 + Math.round(view.getTranslationY());
            } else {
                int centerX = epicenter.centerX();
                centerY = epicenter.centerY();
                i2 = centerX;
            }
            float centerX2 = rect.centerX() - i2;
            float centerY2 = rect.centerY() - centerY;
            if (centerX2 == 0.0f && centerY2 == 0.0f) {
                centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
                centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            }
            float calculateDistance = calculateDistance(centerX2, centerY2);
            float calculateMaxDistance = calculateMaxDistance(view, i2 - i3, centerY - i4);
            iArr[0] = Math.round((centerX2 / calculateDistance) * calculateMaxDistance);
            iArr[1] = Math.round(calculateMaxDistance * (centerY2 / calculateDistance));
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, transitionValues) == null) {
            View view = transitionValues.view;
            view.getLocationOnScreen(this.mTempLoc);
            int[] iArr = this.mTempLoc;
            int i2 = iArr[0];
            int i3 = iArr[1];
            transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
        }
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            super.captureEndValues(transitionValues);
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            super.captureStartValues(transitionValues);
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, view, transitionValues, transitionValues2)) == null) {
            if (transitionValues2 == null) {
                return null;
            }
            Rect rect = (Rect) transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
            float translationX = view.getTranslationX();
            float translationY = view.getTranslationY();
            calculateOut(viewGroup, rect, this.mTempLoc);
            int[] iArr = this.mTempLoc;
            return TranslationAnimationCreator.createAnimation(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, sDecelerate, this);
        }
        return (Animator) invokeLLLL.objValue;
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLLL;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, viewGroup, view, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null) {
                return null;
            }
            Rect rect = (Rect) transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
            int i2 = rect.left;
            int i3 = rect.top;
            float translationX = view.getTranslationX();
            float translationY = view.getTranslationY();
            int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
            if (iArr != null) {
                f2 = (iArr[0] - rect.left) + translationX;
                f3 = (iArr[1] - rect.top) + translationY;
                rect.offsetTo(iArr[0], iArr[1]);
            } else {
                f2 = translationX;
                f3 = translationY;
            }
            calculateOut(viewGroup, rect, this.mTempLoc);
            int[] iArr2 = this.mTempLoc;
            return TranslationAnimationCreator.createAnimation(view, transitionValues, i2, i3, translationX, translationY, f2 + iArr2[0], f3 + iArr2[1], sAccelerate, this);
        }
        return (Animator) invokeLLLL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }
}
