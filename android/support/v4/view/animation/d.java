package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
class d implements Interpolator {
    private final float[] Bv;
    private final float[] Bw;

    public d(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.Bv = new float[i];
        this.Bw = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.Bv[i2] = fArr[0];
            this.Bw[i2] = fArr[1];
        }
    }

    public d(float f, float f2) {
        this(f(f, f2));
    }

    public d(float f, float f2, float f3, float f4) {
        this(c(f, f2, f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        int i;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f < 1.0f) {
            int i2 = 0;
            int length = this.Bv.length - 1;
            while (length - i2 > 1) {
                int i3 = (i2 + length) / 2;
                if (f < this.Bv[i3]) {
                    i = i2;
                } else {
                    int i4 = length;
                    i = i3;
                    i3 = i4;
                }
                i2 = i;
                length = i3;
            }
            float f2 = this.Bv[length] - this.Bv[i2];
            if (f2 == 0.0f) {
                return this.Bw[i2];
            }
            float f3 = (f - this.Bv[i2]) / f2;
            float f4 = this.Bw[i2];
            return (f3 * (this.Bw[length] - f4)) + f4;
        }
        return 1.0f;
    }

    private static Path f(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    private static Path c(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
