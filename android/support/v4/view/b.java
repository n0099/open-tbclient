package android.support.v4.view;
/* loaded from: classes.dex */
class b implements d {
    private static int a(int i, int i2, int i3, int i4, int i5) {
        boolean z = (i2 & i3) != 0;
        int i6 = i4 | i5;
        boolean z2 = (i2 & i6) != 0;
        if (!z) {
            return z2 ? i & (i3 ^ (-1)) : i;
        } else if (z2) {
            throw new IllegalArgumentException("bad arguments");
        } else {
            return i & (i6 ^ (-1));
        }
    }

    public int a(int i) {
        int i2 = (i & 192) != 0 ? i | 1 : i;
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & 247;
    }

    @Override // android.support.v4.view.d
    public boolean a(int i, int i2) {
        return a(a(a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
    }

    @Override // android.support.v4.view.d
    public boolean b(int i) {
        return (a(i) & 247) == 0;
    }
}
