package android.support.v7.content.res;

import java.lang.reflect.Array;
/* loaded from: classes2.dex */
final class b {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !b.class.desiredAssertionStatus();
    }

    public static <T> T[] a(T[] tArr, int i, T t) {
        T[] tArr2;
        if ($assertionsDisabled || i <= tArr.length) {
            if (i + 1 > tArr.length) {
                tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), aE(i)));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static int[] a(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[aE(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static int aE(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    private b() {
    }
}
