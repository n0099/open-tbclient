package c.a.w.f.b;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<Matrix> a;

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<RectF> f26362b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1749248275, "Lc/a/w/f/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1749248275, "Lc/a/w/f/b/b;");
                return;
            }
        }
        a = new ThreadLocal<>();
        f26362b = new ThreadLocal<>();
    }

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, viewGroup, view, rect) == null) {
            rect.set(0, 0, view.getWidth(), view.getHeight());
            c(viewGroup, view, rect);
        }
    }

    public static void b(ViewParent viewParent, View view, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, viewParent, view, matrix) == null) {
            ViewParent parent = view.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                View view2 = (View) parent;
                b(viewParent, view2, matrix);
                matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
            }
            matrix.preTranslate(view.getLeft(), view.getTop());
            if (view.getMatrix().isIdentity()) {
                return;
            }
            matrix.preConcat(view.getMatrix());
        }
    }

    public static void c(ViewGroup viewGroup, View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, viewGroup, view, rect) == null) {
            Matrix matrix = a.get();
            if (matrix == null) {
                matrix = new Matrix();
                a.set(matrix);
            } else {
                matrix.reset();
            }
            b(viewGroup, view, matrix);
            RectF rectF = f26362b.get();
            if (rectF == null) {
                rectF = new RectF();
                f26362b.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }
    }
}
