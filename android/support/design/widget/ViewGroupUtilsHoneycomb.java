package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes2.dex */
class ViewGroupUtilsHoneycomb {
    private static final ThreadLocal<Matrix> sMatrix = new ThreadLocal<>();
    private static final ThreadLocal<RectF> sRectF = new ThreadLocal<>();

    ViewGroupUtilsHoneycomb() {
    }

    public static void offsetDescendantRect(ViewGroup viewGroup, View view2, Rect rect) {
        Matrix matrix;
        Matrix matrix2 = sMatrix.get();
        if (matrix2 == null) {
            Matrix matrix3 = new Matrix();
            sMatrix.set(matrix3);
            matrix = matrix3;
        } else {
            matrix2.reset();
            matrix = matrix2;
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

    static void offsetDescendantMatrix(ViewParent viewParent, View view2, Matrix matrix) {
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
}
