package androidx.core.graphics;

import android.graphics.Matrix;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\n\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "degrees", "px", "py", "Landroid/graphics/Matrix;", "rotationMatrix", "(FFF)Landroid/graphics/Matrix;", "sx", "sy", "scaleMatrix", "(FF)Landroid/graphics/Matrix;", "tx", "ty", "translationMatrix", "m", "times", "(Landroid/graphics/Matrix;Landroid/graphics/Matrix;)Landroid/graphics/Matrix;", "", SavedStateHandle.VALUES, "(Landroid/graphics/Matrix;)[F", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class MatrixKt {
    public static final Matrix rotationMatrix(float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f2, f3, f4);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f2, float f3, float f4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        return rotationMatrix(f2, f3, f4);
    }

    public static final Matrix scaleMatrix(float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f3);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        return scaleMatrix(f2, f3);
    }

    public static final Matrix times(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final Matrix translationMatrix(float f2, float f3) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f2, f3);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        return translationMatrix(f2, f3);
    }

    public static final float[] values(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
