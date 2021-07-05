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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TransitionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean HAS_IS_ATTACHED_TO_WINDOW;
    public static final boolean HAS_OVERLAY;
    public static final boolean HAS_PICTURE_BITMAP;
    public static final int MAX_IMAGE_SIZE = 1048576;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class MatrixEvaluator implements TypeEvaluator<Matrix> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float[] mTempEndValues;
        public final Matrix mTempMatrix;
        public final float[] mTempStartValues;

        public MatrixEvaluator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTempStartValues = new float[9];
            this.mTempEndValues = new float[9];
            this.mTempMatrix = new Matrix();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), matrix, matrix2})) == null) {
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
            return (Matrix) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-936915425, "Landroidx/transition/TransitionUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-936915425, "Landroidx/transition/TransitionUtils;");
                return;
            }
        }
        HAS_IS_ATTACHED_TO_WINDOW = Build.VERSION.SDK_INT >= 19;
        HAS_OVERLAY = Build.VERSION.SDK_INT >= 18;
        HAS_PICTURE_BITMAP = Build.VERSION.SDK_INT >= 28;
    }

    public TransitionUtils() {
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

    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, viewGroup, view, view2)) == null) {
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
        return (View) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        InterceptResult invokeLLLL;
        boolean z;
        boolean z2;
        ViewGroup viewGroup2;
        int i2;
        int round;
        int round2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, view, matrix, rectF, viewGroup)) == null) {
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
        return (Bitmap) invokeLLLL.objValue;
    }

    public static Animator mergeAnimators(Animator animator, Animator animator2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, animator, animator2)) == null) {
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
        return (Animator) invokeLL.objValue;
    }
}
