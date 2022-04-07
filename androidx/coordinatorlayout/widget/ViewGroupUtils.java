package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ViewGroupUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<Matrix> sMatrix;
    public static final ThreadLocal<RectF> sRectF;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1915370280, "Landroidx/coordinatorlayout/widget/ViewGroupUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1915370280, "Landroidx/coordinatorlayout/widget/ViewGroupUtils;");
                return;
            }
        }
        sMatrix = new ThreadLocal<>();
        sRectF = new ThreadLocal<>();
    }

    public ViewGroupUtils() {
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

    public static void getDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, viewGroup, view2, rect) == null) {
            rect.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRect(viewGroup, view2, rect);
        }
    }

    public static void offsetDescendantMatrix(ViewParent viewParent, View view2, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, viewParent, view2, matrix) == null) {
            ViewParent parent = view2.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                View view3 = (View) parent;
                offsetDescendantMatrix(viewParent, view3, matrix);
                matrix.preTranslate(-view3.getScrollX(), -view3.getScrollY());
            }
            matrix.preTranslate(view2.getLeft(), view2.getTop());
            if (view2.getMatrix().isIdentity()) {
                return;
            }
            matrix.preConcat(view2.getMatrix());
        }
    }

    public static void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, view2, rect) == null) {
            Matrix matrix = sMatrix.get();
            if (matrix == null) {
                matrix = new Matrix();
                sMatrix.set(matrix);
            } else {
                matrix.reset();
            }
            offsetDescendantMatrix(viewGroup, view2, matrix);
            RectF rectF = sRectF.get();
            if (rectF == null) {
                rectF = new RectF();
                sRectF.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }
    }
}
