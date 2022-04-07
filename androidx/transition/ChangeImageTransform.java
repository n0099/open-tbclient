package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.TransitionUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY;
    public static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR;
    public static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    public static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    public static final String[] sTransitionProperties;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(749145867, "Landroidx/transition/ChangeImageTransform$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(749145867, "Landroidx/transition/ChangeImageTransform$3;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-754526854, "Landroidx/transition/ChangeImageTransform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-754526854, "Landroidx/transition/ChangeImageTransform;");
                return;
            }
        }
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>() { // from class: androidx.transition.ChangeImageTransform.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.animation.TypeEvaluator
            public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), matrix, matrix2})) == null) {
                    return null;
                }
                return (Matrix) invokeCommon.objValue;
            }
        };
        ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.ChangeImageTransform.2
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public void set(ImageView imageView, Matrix matrix) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imageView, matrix) == null) {
                    ImageViewUtils.animateTransform(imageView, matrix);
                }
            }
        };
    }

    public ChangeImageTransform() {
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

    private void captureValues(TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, transitionValues) == null) {
            View view2 = transitionValues.f980view;
            if ((view2 instanceof ImageView) && view2.getVisibility() == 0) {
                ImageView imageView = (ImageView) view2;
                if (imageView.getDrawable() == null) {
                    return;
                }
                Map<String, Object> map = transitionValues.values;
                map.put(PROPNAME_BOUNDS, new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
                map.put(PROPNAME_MATRIX, copyImageMatrix(imageView));
            }
        }
    }

    public static Matrix centerCropMatrix(ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, imageView)) == null) {
            Drawable drawable = imageView.getDrawable();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            float width = imageView.getWidth();
            float f = intrinsicWidth;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float height = imageView.getHeight();
            float f2 = intrinsicHeight;
            float max = Math.max(width / f, height / f2);
            int round = Math.round((width - (f * max)) / 2.0f);
            int round2 = Math.round((height - (f2 * max)) / 2.0f);
            Matrix matrix = new Matrix();
            matrix.postScale(max, max);
            matrix.postTranslate(round, round2);
            return matrix;
        }
        return (Matrix) invokeL.objValue;
    }

    @NonNull
    public static Matrix copyImageMatrix(@NonNull ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, imageView)) == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                int i = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
                if (i == 1) {
                    return fitXYMatrix(imageView);
                }
                if (i == 2) {
                    return centerCropMatrix(imageView);
                }
            }
            return new Matrix(imageView.getImageMatrix());
        }
        return (Matrix) invokeL.objValue;
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, imageView, matrix, matrix2)) == null) ? ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator) new TransitionUtils.MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2}) : (ObjectAnimator) invokeLLL.objValue;
    }

    @NonNull
    private ObjectAnimator createNullAnimator(@NonNull ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, imageView)) == null) {
            Property<ImageView, Matrix> property = ANIMATED_TRANSFORM_PROPERTY;
            TypeEvaluator<Matrix> typeEvaluator = NULL_MATRIX_EVALUATOR;
            Matrix matrix = MatrixUtils.IDENTITY_MATRIX;
            return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    public static Matrix fitXYMatrix(ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, imageView)) == null) {
            Drawable drawable = imageView.getDrawable();
            Matrix matrix = new Matrix();
            matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
            return matrix;
        }
        return (Matrix) invokeL.objValue;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transitionValues) == null) {
            captureValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, transitionValues, transitionValues2)) == null) {
            if (transitionValues == null || transitionValues2 == null) {
                return null;
            }
            Rect rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            if (rect == null || rect2 == null) {
                return null;
            }
            Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
            Matrix matrix2 = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
            boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
            if (rect.equals(rect2) && z) {
                return null;
            }
            ImageView imageView = (ImageView) transitionValues2.f980view;
            Drawable drawable = imageView.getDrawable();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                if (matrix == null) {
                    matrix = MatrixUtils.IDENTITY_MATRIX;
                }
                if (matrix2 == null) {
                    matrix2 = MatrixUtils.IDENTITY_MATRIX;
                }
                ANIMATED_TRANSFORM_PROPERTY.set(imageView, matrix);
                return createMatrixAnimator(imageView, matrix, matrix2);
            }
            return createNullAnimator(imageView);
        }
        return (Animator) invokeLLL.objValue;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? sTransitionProperties : (String[]) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
