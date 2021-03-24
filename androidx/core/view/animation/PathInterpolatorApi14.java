package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class PathInterpolatorApi14 implements Interpolator {
    public static final float PRECISION = 0.002f;
    public final float[] mX;
    public final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.mX = new float[i];
        this.mY = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.mX[i2] = fArr[0];
            this.mY[i2] = fArr[1];
        }
    }

    public static Path createCubic(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }

    public static Path createQuad(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.mX.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.mX;
        float f3 = fArr[length] - fArr[i];
        if (f3 == 0.0f) {
            return this.mY[i];
        }
        float[] fArr2 = this.mY;
        float f4 = fArr2[i];
        return f4 + (((f2 - fArr[i]) / f3) * (fArr2[length] - f4));
    }

    public PathInterpolatorApi14(float f2, float f3) {
        this(createQuad(f2, f3));
    }

    public PathInterpolatorApi14(float f2, float f3, float f4, float f5) {
        this(createCubic(f2, f3, f4, f5));
    }
}
