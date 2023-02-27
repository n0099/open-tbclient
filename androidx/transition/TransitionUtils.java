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

    static {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (Build.VERSION.SDK_INT >= 19) {
            z = true;
        } else {
            z = false;
        }
        HAS_IS_ATTACHED_TO_WINDOW = z;
        if (Build.VERSION.SDK_INT >= 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        HAS_OVERLAY = z2;
        if (Build.VERSION.SDK_INT < 28) {
            z3 = false;
        }
        HAS_PICTURE_BITMAP = z3;
    }

    /* loaded from: classes.dex */
    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public final float[] mTempStartValues = new float[9];
        public final float[] mTempEndValues = new float[9];
        public final Matrix mTempMatrix = new Matrix();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.mTempStartValues);
            matrix2.getValues(this.mTempEndValues);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mTempEndValues;
                float f2 = fArr[i];
                float[] fArr2 = this.mTempStartValues;
                fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
            }
            this.mTempMatrix.setValues(this.mTempEndValues);
            return this.mTempMatrix;
        }
    }

    public static View copyViewImage(ViewGroup viewGroup, View view2, View view3) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view3.getScrollX(), -view3.getScrollY());
        ViewUtils.transformMatrixToGlobal(view2, matrix);
        ViewUtils.transformMatrixToLocal(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view2.getWidth(), view2.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view2.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap createViewBitmap = createViewBitmap(view2, matrix, rectF, viewGroup);
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
    public static Bitmap createViewBitmap(View view2, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        ViewGroup viewGroup2;
        int i;
        int round;
        int round2;
        if (HAS_IS_ATTACHED_TO_WINDOW) {
            z = !view2.isAttachedToWindow();
            if (viewGroup != null) {
                z2 = viewGroup.isAttachedToWindow();
                Bitmap bitmap = null;
                if (!HAS_OVERLAY && z) {
                    if (!z2) {
                        return null;
                    }
                    viewGroup2 = (ViewGroup) view2.getParent();
                    i = viewGroup2.indexOfChild(view2);
                    viewGroup.getOverlay().add(view2);
                } else {
                    viewGroup2 = null;
                    i = 0;
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
                        view2.draw(beginRecording);
                        picture.endRecording();
                        bitmap = Bitmap.createBitmap(picture);
                    } else {
                        bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.concat(matrix);
                        view2.draw(canvas);
                    }
                }
                if (HAS_OVERLAY && z) {
                    viewGroup.getOverlay().remove(view2);
                    viewGroup2.addView(view2, i);
                }
                return bitmap;
            }
        } else {
            z = false;
        }
        z2 = false;
        Bitmap bitmap2 = null;
        if (!HAS_OVERLAY) {
        }
        viewGroup2 = null;
        i = 0;
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
            viewGroup.getOverlay().remove(view2);
            viewGroup2.addView(view2, i);
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
