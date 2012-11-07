package cn.jingling.lib.file;

import android.graphics.Color;
/* loaded from: classes.dex */
public final class Shared {
    public static final int INFINITY = Integer.MAX_VALUE;
    public static final int INVALID = -1;

    public static int argb(float a, float r, float g, float b) {
        return Color.argb((int) (a * 255.0f), (int) (r * 255.0f), (int) (g * 255.0f), (int) (255.0f * b));
    }

    public static boolean isPowerOf2(int n) {
        return ((-n) & n) == n;
    }

    public static int midPointIterator(int i) {
        if (i != 0) {
            int tick = ((i - 1) / 2) + 1;
            int pass = (i + (-1)) % 2 == 0 ? 1 : -1;
            return tick * pass;
        }
        return 0;
    }

    public static int nextPowerOf2(int n) {
        int n2 = n - 1;
        int n3 = n2 | (n2 >>> 16);
        int n4 = n3 | (n3 >>> 8);
        int n5 = n4 | (n4 >>> 4);
        int n6 = n5 | (n5 >>> 2);
        return (n6 | (n6 >>> 1)) + 1;
    }

    public static int prevPowerOf2(int n) {
        return isPowerOf2(n) ? nextPowerOf2(n) : nextPowerOf2(n) - 1;
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static long clamp(long value, long min, long max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static float scaleToFit(float srcWidth, float srcHeight, float outerWidth, float outerHeight, boolean clipToFit) {
        float scaleX = outerWidth / srcWidth;
        float scaleY = outerHeight / srcHeight;
        if (clipToFit) {
            if (scaleX > scaleY) {
                return scaleX;
            }
        } else if (scaleX < scaleY) {
            return scaleX;
        }
        return scaleY;
    }

    public static float normalizePositive(float angleToRotate) {
        if (angleToRotate == 0.0f) {
            return 0.0f;
        }
        float nf = angleToRotate / 360.0f;
        int n = 0;
        if (angleToRotate < 0.0f) {
            n = (int) (nf - 1.0f);
        } else if (angleToRotate > 360.0f) {
            n = (int) nf;
        }
        float angleToRotate2 = angleToRotate - (n * 360.0f);
        if (angleToRotate2 == 360.0f) {
            return 0.0f;
        }
        return angleToRotate2;
    }

    public static int degreesToExifOrientation(float normalizedAngle) {
        if (normalizedAngle == 0.0f) {
            return 1;
        }
        if (normalizedAngle == 90.0f) {
            return 6;
        }
        if (normalizedAngle == 180.0f) {
            return 3;
        }
        return normalizedAngle == 270.0f ? 8 : 1;
    }

    public static float exifOrientationToDegrees(int exifOrientation) {
        if (exifOrientation == 6) {
            return 90.0f;
        }
        if (exifOrientation == 3) {
            return 180.0f;
        }
        if (exifOrientation == 8) {
            return 270.0f;
        }
        return 0.0f;
    }
}
