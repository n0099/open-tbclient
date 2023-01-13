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
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && !sSetFrameFetched) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                sSetFrameMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve setFrame method", e);
            }
            sSetFrameFetched = true;
        }
    }

    public void clearNonTransitionAlpha(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getVisibility() == 0) {
            view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091e8f, null);
        }
    }

    public float getTransitionAlpha(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            Float f = (Float) view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091e8f);
            if (f != null) {
                return view2.getAlpha() / f.floatValue();
            }
            return view2.getAlpha();
        }
        return invokeL.floatValue;
    }

    public void saveNonTransitionAlpha(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) && view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091e8f) == null) {
            view2.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091e8f, Float.valueOf(view2.getAlpha()));
        }
    }

    public void setAnimationMatrix(@NonNull View view2, @Nullable Matrix matrix) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, matrix) == null) {
            if (matrix != null && !matrix.isIdentity()) {
                float[] fArr = this.mMatrixValues;
                if (fArr == null) {
                    fArr = new float[9];
                    this.mMatrixValues = fArr;
                }
                matrix.getValues(fArr);
                float f = fArr[3];
                float sqrt = (float) Math.sqrt(1.0f - (f * f));
                if (fArr[0] < 0.0f) {
                    i = -1;
                } else {
                    i = 1;
                }
                float f2 = sqrt * i;
                float degrees = (float) Math.toDegrees(Math.atan2(f, f2));
                float f3 = fArr[0] / f2;
                float f4 = fArr[4] / f2;
                float f5 = fArr[2];
                float f6 = fArr[5];
                view2.setPivotX(0.0f);
                view2.setPivotY(0.0f);
                view2.setTranslationX(f5);
                view2.setTranslationY(f6);
                view2.setRotation(degrees);
                view2.setScaleX(f3);
                view2.setScaleY(f4);
                return;
            }
            view2.setPivotX(view2.getWidth() / 2);
            view2.setPivotY(view2.getHeight() / 2);
            view2.setTranslationX(0.0f);
            view2.setTranslationY(0.0f);
            view2.setScaleX(1.0f);
            view2.setScaleY(1.0f);
            view2.setRotation(0.0f);
        }
    }

    public void setLeftTopRightBottom(@NonNull View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            fetchSetFrame();
            Method method = sSetFrameMethod;
            if (method != null) {
                try {
                    method.invoke(view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                } catch (IllegalAccessException unused) {
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        }
    }

    public void setTransitionAlpha(@NonNull View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, view2, f) == null) {
            Float f2 = (Float) view2.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f091e8f);
            if (f2 != null) {
                view2.setAlpha(f2.floatValue() * f);
            } else {
                view2.setAlpha(f);
            }
        }
    }

    public void setTransitionVisibility(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view2, i) == null) {
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
                    sViewFlagsField.setInt(view2, i | (field.getInt(view2) & (-13)));
                } catch (IllegalAccessException unused2) {
                }
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view2, @NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, matrix) == null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                View view3 = (View) parent;
                transformMatrixToGlobal(view3, matrix);
                matrix.preTranslate(-view3.getScrollX(), -view3.getScrollY());
            }
            matrix.preTranslate(view2.getLeft(), view2.getTop());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix.preConcat(matrix2);
            }
        }
    }

    public void transformMatrixToLocal(@NonNull View view2, @NonNull Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, matrix) == null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                View view3 = (View) parent;
                transformMatrixToLocal(view3, matrix);
                matrix.postTranslate(view3.getScrollX(), view3.getScrollY());
            }
            matrix.postTranslate(-view2.getLeft(), -view2.getTop());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                Matrix matrix3 = new Matrix();
                if (matrix2.invert(matrix3)) {
                    matrix.postConcat(matrix3);
                }
            }
        }
    }
}
