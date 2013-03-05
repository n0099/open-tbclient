package cn.jingling.lib.file;

import android.graphics.Color;
/* loaded from: classes.dex */
public final class Shared {
    public static final int INFINITY = Integer.MAX_VALUE;
    public static final int INVALID = -1;

    public static int argb(float f, float f2, float f3, float f4) {
        return Color.argb((int) (f * 255.0f), (int) (f2 * 255.0f), (int) (f3 * 255.0f), (int) (255.0f * f4));
    }

    public static boolean isPowerOf2(int i) {
        return ((-i) & i) == i;
    }

    public static int midPointIterator(int i) {
        if (i != 0) {
            return ((i + (-1)) % 2 == 0 ? 1 : -1) * (((i - 1) / 2) + 1);
        }
        return 0;
    }

    public static int nextPowerOf2(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 16);
        int i4 = i3 | (i3 >>> 8);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 2);
        return (i6 | (i6 >>> 1)) + 1;
    }

    public static int prevPowerOf2(int i) {
        return isPowerOf2(i) ? nextPowerOf2(i) : nextPowerOf2(i) - 1;
    }

    public static int clamp(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    public static long clamp(long j, long j2, long j3) {
        if (j < j2) {
            return j2;
        }
        return j > j3 ? j3 : j;
    }

    public static float scaleToFit(float f, float f2, float f3, float f4, boolean z) {
        float f5 = f3 / f;
        float f6 = f4 / f2;
        if (z) {
            if (f5 > f6) {
                return f5;
            }
        } else if (f5 < f6) {
            return f5;
        }
        return f6;
    }

    public static float normalizePositive(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f2 = f / 360.0f;
        int i = 0;
        if (f < 0.0f) {
            i = (int) (f2 - 1.0f);
        } else if (f > 360.0f) {
            i = (int) f2;
        }
        float f3 = f - (i * 360.0f);
        if (f3 != 360.0f) {
            return f3;
        }
        return 0.0f;
    }

    public static int degreesToExifOrientation(float f) {
        if (f == 0.0f) {
            return 1;
        }
        if (f == 90.0f) {
            return 6;
        }
        if (f == 180.0f) {
            return 3;
        }
        return f == 270.0f ? 8 : 1;
    }

    public static float exifOrientationToDegrees(int i) {
        if (i == 6) {
            return 90.0f;
        }
        if (i == 3) {
            return 180.0f;
        }
        if (i == 8) {
            return 270.0f;
        }
        return 0.0f;
    }
}
