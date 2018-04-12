package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes2.dex */
class ViewCompatHC {
    ViewCompatHC() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    public static float getAlpha(View view2) {
        return view2.getAlpha();
    }

    public static void setLayerType(View view2, int i, Paint paint) {
        view2.setLayerType(i, paint);
    }

    public static int getLayerType(View view2) {
        return view2.getLayerType();
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int getMeasuredWidthAndState(View view2) {
        return view2.getMeasuredWidthAndState();
    }

    public static int getMeasuredHeightAndState(View view2) {
        return view2.getMeasuredHeightAndState();
    }

    public static int getMeasuredState(View view2) {
        return view2.getMeasuredState();
    }

    public static float getTranslationX(View view2) {
        return view2.getTranslationX();
    }

    public static float getTranslationY(View view2) {
        return view2.getTranslationY();
    }

    public static float getX(View view2) {
        return view2.getX();
    }

    public static float getY(View view2) {
        return view2.getY();
    }

    public static float getRotation(View view2) {
        return view2.getRotation();
    }

    public static float getRotationX(View view2) {
        return view2.getRotationX();
    }

    public static float getRotationY(View view2) {
        return view2.getRotationY();
    }

    public static float getScaleX(View view2) {
        return view2.getScaleX();
    }

    public static float getScaleY(View view2) {
        return view2.getScaleY();
    }

    public static void setTranslationX(View view2, float f) {
        view2.setTranslationX(f);
    }

    public static void setTranslationY(View view2, float f) {
        view2.setTranslationY(f);
    }

    public static Matrix getMatrix(View view2) {
        return view2.getMatrix();
    }

    public static void setAlpha(View view2, float f) {
        view2.setAlpha(f);
    }

    public static void setX(View view2, float f) {
        view2.setX(f);
    }

    public static void setY(View view2, float f) {
        view2.setY(f);
    }

    public static void setRotation(View view2, float f) {
        view2.setRotation(f);
    }

    public static void setRotationX(View view2, float f) {
        view2.setRotationX(f);
    }

    public static void setRotationY(View view2, float f) {
        view2.setRotationY(f);
    }

    public static void setScaleX(View view2, float f) {
        view2.setScaleX(f);
    }

    public static void setScaleY(View view2, float f) {
        view2.setScaleY(f);
    }

    public static void setPivotX(View view2, float f) {
        view2.setPivotX(f);
    }

    public static void setPivotY(View view2, float f) {
        view2.setPivotY(f);
    }

    public static float getPivotX(View view2) {
        return view2.getPivotX();
    }

    public static float getPivotY(View view2) {
        return view2.getPivotY();
    }

    public static void jumpDrawablesToCurrentState(View view2) {
        view2.jumpDrawablesToCurrentState();
    }

    public static void setSaveFromParentEnabled(View view2, boolean z) {
        view2.setSaveFromParentEnabled(z);
    }

    public static void setActivated(View view2, boolean z) {
        view2.setActivated(z);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetTopAndBottom(View view2, int i) {
        view2.offsetTopAndBottom(i);
        if (view2.getVisibility() == 0) {
            tickleInvalidationFlag(view2);
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offsetLeftAndRight(View view2, int i) {
        view2.offsetLeftAndRight(i);
        if (view2.getVisibility() == 0) {
            tickleInvalidationFlag(view2);
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void tickleInvalidationFlag(View view2) {
        float translationY = view2.getTranslationY();
        view2.setTranslationY(1.0f + translationY);
        view2.setTranslationY(translationY);
    }
}
