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
import androidx.transition.TransitionUtils;
import java.util.Map;
/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    public static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    public static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    public static final String[] sTransitionProperties = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    public static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>() { // from class: androidx.transition.ChangeImageTransform.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    public static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.ChangeImageTransform.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.animateTransform(imageView, matrix);
        }
    };

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
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

    public ChangeImageTransform() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = transitionValues.values;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", copyImageMatrix(imageView));
        }
    }

    public static Matrix centerCropMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f2 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f3 = intrinsicHeight;
        float max = Math.max(width / f2, height / f3);
        int round = Math.round((width - (f2 * max)) / 2.0f);
        int round2 = Math.round((height - (f3 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }

    public static Matrix copyImageMatrix(ImageView imageView) {
        int i = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return new Matrix(imageView.getImageMatrix());
            }
            return centerCropMatrix(imageView);
        }
        return fitXYMatrix(imageView);
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator) new TransitionUtils.MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    private ObjectAnimator createNullAnimator(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) ANIMATED_TRANSFORM_PROPERTY, (TypeEvaluator) NULL_MATRIX_EVALUATOR, (Object[]) new Matrix[]{null, null});
    }

    public static Matrix fitXYMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator createNullAnimator;
        if (transitionValues != null && transitionValues2 != null) {
            Rect rect = (Rect) transitionValues.values.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) transitionValues.values.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) transitionValues2.values.get("android:changeImageTransform:matrix");
                boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) transitionValues2.view;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                ImageViewUtils.startAnimateTransform(imageView);
                if (intrinsicWidth != 0 && intrinsicHeight != 0) {
                    if (matrix == null) {
                        matrix = MatrixUtils.IDENTITY_MATRIX;
                    }
                    if (matrix2 == null) {
                        matrix2 = MatrixUtils.IDENTITY_MATRIX;
                    }
                    ANIMATED_TRANSFORM_PROPERTY.set(imageView, matrix);
                    createNullAnimator = createMatrixAnimator(imageView, matrix, matrix2);
                } else {
                    createNullAnimator = createNullAnimator(imageView);
                }
                ImageViewUtils.reserveEndAnimateTransform(imageView, createNullAnimator);
                return createNullAnimator;
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
