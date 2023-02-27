package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ViewGroupUtils {
    public static final ThreadLocal<Matrix> sMatrix = new ThreadLocal<>();
    public static final ThreadLocal<RectF> sRectF = new ThreadLocal<>();

    public static void getDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
        rect.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRect(viewGroup, view2, rect);
    }

    public static void offsetDescendantMatrix(ViewParent viewParent, View view2, Matrix matrix) {
        ViewParent parent = view2.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view3 = (View) parent;
            offsetDescendantMatrix(viewParent, view3, matrix);
            matrix.preTranslate(-view3.getScrollX(), -view3.getScrollY());
        }
        matrix.preTranslate(view2.getLeft(), view2.getTop());
        if (!view2.getMatrix().isIdentity()) {
            matrix.preConcat(view2.getMatrix());
        }
    }

    public static void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
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
