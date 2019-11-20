package com.airbnb.lottie.c;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.q;
import java.io.Closeable;
/* loaded from: classes2.dex */
public final class f {
    private static final PathMeasure fa = new PathMeasure();
    private static final Path fd = new Path();
    private static final Path ig = new Path();
    private static final float[] points = new float[4];
    private static final float ih = (float) Math.sqrt(2.0d);

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static float c(Matrix matrix) {
        points[0] = 0.0f;
        points[1] = 0.0f;
        points[2] = ih;
        points[3] = ih;
        matrix.mapPoints(points);
        return ((float) Math.hypot(points[2] - points[0], points[3] - points[1])) / 2.0f;
    }

    public static void a(Path path, @Nullable q qVar) {
        if (qVar != null) {
            a(path, qVar.bE().getValue().floatValue() / 100.0f, qVar.bF().getValue().floatValue() / 100.0f, qVar.bG().getValue().floatValue() / 360.0f);
        }
    }

    public static void a(Path path, float f, float f2, float f3) {
        com.airbnb.lottie.d.beginSection("applyTrimPathIfNeeded");
        fa.setPath(path, false);
        float length = fa.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.airbnb.lottie.d.D("applyTrimPathIfNeeded");
        } else if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            com.airbnb.lottie.d.D("applyTrimPathIfNeeded");
        } else {
            float f4 = length * f;
            float f5 = length * f2;
            float min = Math.min(f4, f5);
            float max = Math.max(f4, f5);
            float f6 = f3 * length;
            float f7 = min + f6;
            float f8 = max + f6;
            if (f7 >= length && f8 >= length) {
                f7 = e.k(f7, length);
                f8 = e.k(f8, length);
            }
            if (f7 < 0.0f) {
                f7 = e.k(f7, length);
            }
            if (f8 < 0.0f) {
                f8 = e.k(f8, length);
            }
            if (f7 == f8) {
                path.reset();
                com.airbnb.lottie.d.D("applyTrimPathIfNeeded");
                return;
            }
            if (f7 >= f8) {
                f7 -= length;
            }
            fd.reset();
            fa.getSegment(f7, f8, fd, true);
            if (f8 > length) {
                ig.reset();
                fa.getSegment(0.0f, f8 % length, ig, true);
                fd.addPath(ig);
            } else if (f7 < 0.0f) {
                ig.reset();
                fa.getSegment(f7 + length, length, ig, true);
                fd.addPath(ig);
            }
            path.set(fd);
            com.airbnb.lottie.d.D("applyTrimPathIfNeeded");
        }
    }

    public static boolean a(com.airbnb.lottie.e eVar, int i, int i2, int i3) {
        if (eVar.getMajorVersion() < i) {
            return false;
        }
        if (eVar.getMajorVersion() <= i) {
            if (eVar.getMinorVersion() < i2) {
                return false;
            }
            return eVar.getMinorVersion() > i2 || eVar.aT() >= i3;
        }
        return true;
    }

    public static int c(float f, float f2, float f3, float f4) {
        int i = 17;
        if (f != 0.0f) {
            i = (int) (527 * f);
        }
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        if (f4 != 0.0f) {
            return (int) (i * 31 * f4);
        }
        return i;
    }

    public static float Q(Context context) {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) : Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }
}
