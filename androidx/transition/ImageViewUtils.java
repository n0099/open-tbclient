package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class ImageViewUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static Field sDrawMatrixField = null;
    public static boolean sDrawMatrixFieldFetched = false;
    public static boolean sTryHiddenAnimateTransform = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-995831382, "Landroidx/transition/ImageViewUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-995831382, "Landroidx/transition/ImageViewUtils;");
        }
    }

    public ImageViewUtils() {
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

    public static void animateTransform(@NonNull ImageView imageView, @Nullable Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, imageView, matrix) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                imageView.animateTransform(matrix);
            } else if (matrix == null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                    imageView.invalidate();
                }
            } else if (i2 >= 21) {
                hiddenAnimateTransform(imageView, matrix);
            } else {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                    Matrix matrix2 = null;
                    fetchDrawMatrixField();
                    Field field = sDrawMatrixField;
                    if (field != null) {
                        try {
                            Matrix matrix3 = (Matrix) field.get(imageView);
                            if (matrix3 == null) {
                                try {
                                    matrix2 = new Matrix();
                                    sDrawMatrixField.set(imageView, matrix2);
                                } catch (IllegalAccessException unused) {
                                }
                            }
                            matrix2 = matrix3;
                        } catch (IllegalAccessException unused2) {
                        }
                    }
                    if (matrix2 != null) {
                        matrix2.set(matrix);
                    }
                    imageView.invalidate();
                }
            }
        }
    }

    public static void fetchDrawMatrixField() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || sDrawMatrixFieldFetched) {
            return;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
            sDrawMatrixField = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        sDrawMatrixFieldFetched = true;
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    public static void hiddenAnimateTransform(@NonNull ImageView imageView, @Nullable Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65540, null, imageView, matrix) == null) && sTryHiddenAnimateTransform) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenAnimateTransform = false;
            }
        }
    }
}
