package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import java.util.Map;
@TargetApi(19)
/* loaded from: classes2.dex */
public class CustomImageTransform extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = null;
    public static final Matrix IDENTITY_MATRIX;
    public static TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = null;
    public static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    public static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    public static final String TAG = "ChangeImageTransform";
    public static final String[] sTransitionProperties;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] mTempEndValues;
        public Matrix mTempMatrix;
        public float[] mTempStartValues;

        public MatrixEvaluator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), matrix, matrix2})) == null) {
                matrix.getValues(this.mTempStartValues);
                matrix2.getValues(this.mTempEndValues);
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = this.mTempEndValues;
                    float f3 = fArr[i2];
                    float[] fArr2 = this.mTempStartValues;
                    fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
                }
                this.mTempMatrix.setValues(this.mTempEndValues);
                return this.mTempMatrix;
            }
            return (Matrix) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(472490144, "Lcom/baidu/mobads/container/util/animation/CustomImageTransform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(472490144, "Lcom/baidu/mobads/container/util/animation/CustomImageTransform;");
                return;
            }
        }
        sTransitionProperties = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
        NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>() { // from class: com.baidu.mobads.container.util.animation.CustomImageTransform.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.animation.TypeEvaluator
            public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), matrix, matrix2})) == null) {
                    return null;
                }
                return (Matrix) invokeCommon.objValue;
            }
        };
        ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: com.baidu.mobads.container.util.animation.CustomImageTransform.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8, r9);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r8, r9};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Class) objArr2[0], (String) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            public Matrix get(ImageView imageView) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, imageView)) == null) {
                    return null;
                }
                return (Matrix) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.util.Property
            @TargetApi(29)
            public void set(ImageView imageView, Matrix matrix) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, matrix) == null) {
                    imageView.animateTransform(matrix);
                }
            }
        };
        IDENTITY_MATRIX = new Matrix() { // from class: com.baidu.mobads.container.util.animation.CustomImageTransform.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void oops() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    throw new IllegalStateException("Matrix can not be modified");
                }
            }

            @Override // android.graphics.Matrix
            public boolean postConcat(Matrix matrix) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix)) == null) {
                    oops();
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postRotate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postScale(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postSkew(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postTranslate(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preConcat(Matrix matrix) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048585, this, matrix)) == null) {
                    oops();
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preRotate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preScale(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preSkew(float f2, float f3, float f4, float f5) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preTranslate(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public void reset() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048593, this) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void set(Matrix matrix) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, matrix) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public boolean setConcat(Matrix matrix, Matrix matrix2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048595, this, matrix, matrix2)) == null) {
                    oops();
                    return false;
                }
                return invokeLL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean setPolyToPoly(float[] fArr, int i2, float[] fArr2, int i3, int i4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048596, this, new Object[]{fArr, Integer.valueOf(i2), fArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048597, this, rectF, rectF2, scaleToFit)) == null) {
                    oops();
                    return false;
                }
                return invokeLLL.booleanValue;
            }

            @Override // android.graphics.Matrix
            public void setRotate(float f2, float f3, float f4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setScale(float f2, float f3, float f4, float f5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSinCos(float f2, float f3, float f4, float f5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSkew(float f2, float f3, float f4, float f5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setTranslate(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048606, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setValues(float[] fArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048607, this, fArr) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public boolean postRotate(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                    oops();
                    return false;
                }
                return invokeF.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postScale(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean postSkew(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preRotate(float f2) {
                InterceptResult invokeF;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeF = interceptable2.invokeF(1048586, this, f2)) == null) {
                    oops();
                    return false;
                }
                return invokeF.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preScale(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public boolean preSkew(float f2, float f3) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                    oops();
                    return false;
                }
                return invokeCommon.booleanValue;
            }

            @Override // android.graphics.Matrix
            public void setRotate(float f2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeF(1048598, this, f2) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setScale(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSinCos(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }

            @Override // android.graphics.Matrix
            public void setSkew(float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048604, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                    oops();
                }
            }
        };
    }

    public CustomImageTransform() {
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

    private void captureValues(TransitionValues transitionValues, boolean z) {
        ImageView imageView;
        Drawable drawable;
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, transitionValues, z) == null) {
            View view = transitionValues.view;
            if ((view instanceof ImageView) && view.getVisibility() == 0 && (drawable = (imageView = (ImageView) view).getDrawable()) != null) {
                Map map = transitionValues.values;
                Rect rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                map.put("android:changeImageTransform:bounds", rect);
                ImageView.ScaleType scaleType = imageView.getScaleType();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (scaleType == ImageView.ScaleType.FIT_XY && intrinsicWidth > 0 && intrinsicHeight > 0) {
                    float width = rect.width() / intrinsicWidth;
                    float height = rect.height() / intrinsicHeight;
                    matrix = new Matrix();
                    matrix.setScale(width, height);
                } else {
                    matrix = new Matrix(imageView.getImageMatrix());
                }
                map.put("android:changeImageTransform:matrix", matrix);
            }
        }
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, imageView, matrix, matrix2)) == null) ? ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator) new MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2}) : (ObjectAnimator) invokeLLL.objValue;
    }

    private ObjectAnimator createNullAnimator(ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, imageView)) == null) {
            Property<ImageView, Matrix> property = ANIMATED_TRANSFORM_PROPERTY;
            TypeEvaluator<Matrix> typeEvaluator = NULL_MATRIX_EVALUATOR;
            Matrix matrix = IDENTITY_MATRIX;
            return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            captureValues(transitionValues, false);
        }
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            captureValues(transitionValues, true);
        }
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null || transitionValues2 == null) {
                return null;
            }
            Rect rect = (Rect) transitionValues2.values.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("android:changeImageTransform:bounds");
            Matrix matrix = (Matrix) transitionValues2.values.get("android:changeImageTransform:matrix");
            Matrix matrix2 = (Matrix) transitionValues2.values.get("android:changeImageTransform:matrix");
            if (rect2 == null || rect == null || matrix2 == null || matrix == null) {
                return null;
            }
            ImageView imageView = (ImageView) transitionValues2.view;
            Drawable drawable = imageView.getDrawable();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                ANIMATED_TRANSFORM_PROPERTY.set(imageView, matrix2);
                return createMatrixAnimator(imageView, matrix2, matrix);
            }
            return createNullAnimator(imageView);
        }
        return (Animator) invokeLLL.objValue;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? sTransitionProperties : (String[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public CustomImageTransform(Context context, AttributeSet attributeSet) {
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
    }
}
