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
import java.util.Map;
@TargetApi(19)
/* loaded from: classes2.dex */
public class CustomImageTransform extends Transition {
    public static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    public static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    public static final String TAG = "ChangeImageTransform";
    public static final String[] sTransitionProperties = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    public static TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>() { // from class: com.baidu.mobads.container.util.animation.CustomImageTransform.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    public static Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: com.baidu.mobads.container.util.animation.CustomImageTransform.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        @TargetApi(29)
        public void set(ImageView imageView, Matrix matrix) {
            imageView.animateTransform(matrix);
        }
    };
    public static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: com.baidu.mobads.container.util.animation.CustomImageTransform.3
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f2, float f3, float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f2, float f3, float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f2, float f3, float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f2, float f3, float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f2, float f3, float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f2, float f3, float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f2, float f3, float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f2, float f3) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f2, float f3) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f2, float f3) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f2, float f3) {
            oops();
        }
    };

    /* loaded from: classes2.dex */
    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public float[] mTempStartValues = new float[9];
        public float[] mTempEndValues = new float[9];
        public Matrix mTempMatrix = new Matrix();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mTempEndValues;
                float f3 = fArr[i];
                float[] fArr2 = this.mTempStartValues;
                fArr[i] = fArr2[i] + ((f3 - fArr2[i]) * f2);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    public CustomImageTransform() {
    }

    private void captureValues(TransitionValues transitionValues, boolean z) {
        ImageView imageView;
        Drawable drawable;
        Matrix matrix;
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

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator) new MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    private ObjectAnimator createNullAnimator(ImageView imageView) {
        Property<ImageView, Matrix> property = ANIMATED_TRANSFORM_PROPERTY;
        TypeEvaluator<Matrix> typeEvaluator = NULL_MATRIX_EVALUATOR;
        Matrix matrix = IDENTITY_MATRIX;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, false);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, true);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
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

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @TargetApi(21)
    public CustomImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
