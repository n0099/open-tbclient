package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ViewUtilsBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewUtilsBase";
    public static final int VISIBILITY_MASK = 12;
    public static boolean sSetFrameFetched;
    public static Method sSetFrameMethod;
    public static Field sViewFlagsField;
    public static boolean sViewFlagsFieldFetched;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] mMatrixValues;

    public ViewUtilsBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private void fetchSetFrame() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || sSetFrameFetched) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            sSetFrameMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Failed to retrieve setFrame method", e2);
        }
        sSetFrameFetched = true;
    }

    public void clearNonTransitionAlpha(@NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getVisibility() == 0) {
            view.setTag(R$id.save_non_transition_alpha, null);
        }
    }

    public float getTransitionAlpha(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            Float f2 = (Float) view.getTag(R$id.save_non_transition_alpha);
            if (f2 != null) {
                return view.getAlpha() / f2.floatValue();
            }
            return view.getAlpha();
        }
        return invokeL.floatValue;
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && view.getTag(R$id.save_non_transition_alpha) == null) {
            view.setTag(R$id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, matrix) == null) {
            if (matrix != null && !matrix.isIdentity()) {
                float[] fArr = this.mMatrixValues;
                if (fArr == null) {
                    fArr = new float[9];
                    this.mMatrixValues = fArr;
                }
                matrix.getValues(fArr);
                float f2 = fArr[3];
                float sqrt = ((float) Math.sqrt(1.0f - (f2 * f2))) * (fArr[0] < 0.0f ? -1 : 1);
                float degrees = (float) Math.toDegrees(Math.atan2(f2, sqrt));
                float f3 = fArr[0] / sqrt;
                float f4 = fArr[4] / sqrt;
                float f5 = fArr[2];
                float f6 = fArr[5];
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                view.setTranslationX(f5);
                view.setTranslationY(f6);
                view.setRotation(degrees);
                view.setScaleX(f3);
                view.setScaleY(f4);
                return;
            }
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
        }
    }

    public void setLeftTopRightBottom(@NonNull View view, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            fetchSetFrame();
            Method method = sSetFrameMethod;
            if (method != null) {
                try {
                    method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                } catch (IllegalAccessException unused) {
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }
    }

    public void setTransitionAlpha(@NonNull View view, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, view, f2) == null) {
            Float f3 = (Float) view.getTag(R$id.save_non_transition_alpha);
            if (f3 != null) {
                view.setAlpha(f3.floatValue() * f2);
            } else {
                view.setAlpha(f2);
            }
        }
    }

    public void setTransitionVisibility(@NonNull View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view, i) == null) {
            if (!sViewFlagsFieldFetched) {
                try {
                    Field declaredField = View.class.getDeclaredField("mViewFlags");
                    sViewFlagsField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                    Log.i(TAG, "fetchViewFlagsField: ");
                }
                sViewFlagsFieldFetched = true;
            }
            Field field = sViewFlagsField;
            if (field != null) {
                try {
                    sViewFlagsField.setInt(view, i | (field.getInt(view) & (-13)));
                } catch (IllegalAccessException unused2) {
                }
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, matrix) == null) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                transformMatrixToGlobal(view2, matrix);
                matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
            }
            matrix.preTranslate(view.getLeft(), view.getTop());
            Matrix matrix2 = view.getMatrix();
            if (matrix2.isIdentity()) {
                return;
            }
            matrix.preConcat(matrix2);
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, matrix) == null) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                transformMatrixToLocal(view2, matrix);
                matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
            }
            matrix.postTranslate(-view.getLeft(), -view.getTop());
            Matrix matrix2 = view.getMatrix();
            if (matrix2.isIdentity()) {
                return;
            }
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
