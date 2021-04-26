package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class TransitionUtils {
    public static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    public static final boolean HAS_OVERLAY;
    public static final boolean HAS_PICTURE_BITMAP;
    public static final int MAX_IMAGE_SIZE = 1048576;

    /* loaded from: classes.dex */
    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public final float[] mTempStartValues = new float[9];
        public final float[] mTempEndValues = new float[9];
        public final Matrix mTempMatrix = new Matrix();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.mTempEndValues;
                float f3 = fArr[i2];
                float[] fArr2 = this.mTempStartValues;
                fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    static {
        HAS_IS_ATTACHED_TO_WINDOW = Build.VERSION.SDK_INT >= 19;
        HAS_OVERLAY = Build.VERSION.SDK_INT >= 18;
        HAS_PICTURE_BITMAP = Build.VERSION.SDK_INT >= 28;
    }

    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ViewUtils.transformMatrixToGlobal(view, matrix);
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap createViewBitmap = createViewBitmap(view, matrix, rectF, viewGroup);
        if (createViewBitmap != null) {
            imageView.setImageBitmap(createViewBitmap);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        ViewGroup viewGroup2;
        int i2;
        int round;
        int round2;
        if (HAS_IS_ATTACHED_TO_WINDOW) {
            z = !view.isAttachedToWindow();
            if (viewGroup != null) {
                z2 = viewGroup.isAttachedToWindow();
                Bitmap bitmap = null;
                if (HAS_OVERLAY || !z) {
                    viewGroup2 = null;
                    i2 = 0;
                } else if (!z2) {
                    return null;
                } else {
                    viewGroup2 = (ViewGroup) view.getParent();
                    i2 = viewGroup2.indexOfChild(view);
                    viewGroup.getOverlay().add(view);
                }
                round = Math.round(rectF.width());
                round2 = Math.round(rectF.height());
                if (round > 0 && round2 > 0) {
                    float min = Math.min(1.0f, 1048576.0f / (round * round2));
                    int round3 = Math.round(round * min);
                    int round4 = Math.round(round2 * min);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(min, min);
                    if (!HAS_PICTURE_BITMAP) {
                        Picture picture = new Picture();
                        Canvas beginRecording = picture.beginRecording(round3, round4);
                        beginRecording.concat(matrix);
                        view.draw(beginRecording);
                        picture.endRecording();
                        bitmap = Bitmap.createBitmap(picture);
                    } else {
                        bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.concat(matrix);
                        view.draw(canvas);
                    }
                }
                if (HAS_OVERLAY && z) {
                    viewGroup.getOverlay().remove(view);
                    viewGroup2.addView(view, i2);
                }
                return bitmap;
            }
        } else {
            z = false;
        }
        z2 = false;
        Bitmap bitmap2 = null;
        if (HAS_OVERLAY) {
        }
        viewGroup2 = null;
        i2 = 0;
        round = Math.round(rectF.width());
        round2 = Math.round(rectF.height());
        if (round > 0) {
            float min2 = Math.min(1.0f, 1048576.0f / (round * round2));
            int round32 = Math.round(round * min2);
            int round42 = Math.round(round2 * min2);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min2, min2);
            if (!HAS_PICTURE_BITMAP) {
            }
        }
        if (HAS_OVERLAY) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i2);
        }
        return bitmap2;
    }

    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
