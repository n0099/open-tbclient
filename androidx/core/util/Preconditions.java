package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Locale;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class Preconditions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static float checkArgumentFinite(float f2, String str) {
        if (!Float.isNaN(f2)) {
            if (Float.isInfinite(f2)) {
                throw new IllegalArgumentException(str + " must not be infinite");
            }
            return f2;
        }
        throw new IllegalArgumentException(str + " must not be NaN");
    }

    public static float checkArgumentInRange(float f2, float f3, float f4, String str) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        } else if (f2 >= f3) {
            if (f2 <= f4) {
                return f2;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f3), Float.valueOf(f4)));
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f3), Float.valueOf(f4)));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkArgumentPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static float[] checkArrayElementsInRange(float[] fArr, float f2, float f3, String str) {
        checkNotNull(fArr, str + " must not be null");
        for (int i = 0; i < fArr.length; i++) {
            float f4 = fArr[i];
            if (Float.isNaN(f4)) {
                throw new IllegalArgumentException(str + "[" + i + "] must not be NaN");
            } else if (f4 < f2) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", str, Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)));
            } else {
                if (f4 > f3) {
                    throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", str, Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)));
                }
            }
        }
        return fArr;
    }

    public static <T> T[] checkArrayElementsNotNull(T[] tArr, String str) {
        if (tArr != null) {
            for (int i = 0; i < tArr.length; i++) {
                if (tArr[i] == null) {
                    throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", str, Integer.valueOf(i)));
                }
            }
            return tArr;
        }
        throw new NullPointerException(str + " must not be null");
    }

    @NonNull
    public static <C extends Collection<T>, T> C checkCollectionElementsNotNull(C c2, String str) {
        if (c2 != null) {
            long j = 0;
            for (Object obj : c2) {
                if (obj == null) {
                    throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", str, Long.valueOf(j)));
                }
                j++;
            }
            return c2;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> collection, String str) {
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException(str + " is empty");
            }
            return collection;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static int checkFlagsArgument(int i, int i2) {
        if ((i & i2) == i) {
            return i;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i2) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(T t) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException();
        }
        return t;
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z) {
        checkState(z, null);
    }

    public static long checkArgumentNonnegative(long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(T t, Object obj) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t;
    }

    public static long checkArgumentNonnegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkArgumentInRange(int i, int i2, int i3, String str) {
        if (i >= i2) {
            if (i <= i3) {
                return i;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    public static long checkArgumentInRange(long j, long j2, long j3, String str) {
        if (j >= j2) {
            if (j <= j3) {
                return j;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j2), Long.valueOf(j3)));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j2), Long.valueOf(j3)));
    }
}
