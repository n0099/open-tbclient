package com.baidu.swan.apps.component.d;

import androidx.annotation.IntRange;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cPc = 5;
    private int[] cPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@IntRange(from = 1) int i) {
        w(i, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@IntRange(from = 1) int i, boolean z) {
        w(i, z);
    }

    private void w(@IntRange(from = 1) int i, boolean z) {
        if (i <= 0) {
            String str = "number <= 0: " + i;
            c.e("Component-DiffBitMap", str);
            if (DEBUG) {
                throw new NegativeArraySizeException(str);
            }
            i = 500;
        }
        this.cPd = new int[hX(i - 1) + 1];
        int length = this.cPd.length;
        if (z) {
            for (int i2 = 0; i2 < length; i2++) {
                this.cPd[i2] = -1;
            }
        }
    }

    public void set(@IntRange(from = 0) int i) {
        if (i < 0) {
            c.e("Component-DiffBitMap", "diff < 0: " + i);
            if (DEBUG) {
                throw new IndexOutOfBoundsException("diff < 0: " + i);
            }
            return;
        }
        int length = (this.cPd.length << cPc) - 1;
        if (i > length) {
            String str = "diff > " + length + ": " + i;
            c.e("Component-DiffBitMap", str);
            if (DEBUG) {
                throw new IndexOutOfBoundsException(str);
            }
            return;
        }
        int[] iArr = this.cPd;
        int hX = hX(i);
        iArr[hX] = iArr[hX] | (1 << i);
    }

    public boolean get(@IntRange(from = 0) int i) {
        if (i < 0) {
            c.e("Component-DiffBitMap", "diff < 0: " + i);
            if (DEBUG) {
                throw new IndexOutOfBoundsException("diff < 0: " + i);
            }
            return false;
        }
        int length = (this.cPd.length << cPc) - 1;
        if (i > length) {
            String str = "diff > " + length + ": " + i;
            c.e("Component-DiffBitMap", str);
            if (DEBUG) {
                throw new IndexOutOfBoundsException(str);
            }
            return false;
        }
        return (this.cPd[hX(i)] & (1 << i)) != 0;
    }

    private int hX(int i) {
        return i >> cPc;
    }
}
