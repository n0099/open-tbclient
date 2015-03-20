package android.support.v4.text;

import java.nio.CharBuffer;
/* loaded from: classes.dex */
abstract class k implements TextDirectionHeuristicCompat {
    private final j mz;

    protected abstract boolean dD();

    public k(j jVar) {
        this.mz = jVar;
    }

    @Override // android.support.v4.text.TextDirectionHeuristicCompat
    public boolean isRtl(char[] cArr, int i, int i2) {
        return isRtl(CharBuffer.wrap(cArr), i, i2);
    }

    @Override // android.support.v4.text.TextDirectionHeuristicCompat
    public boolean isRtl(CharSequence charSequence, int i, int i2) {
        if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
            throw new IllegalArgumentException();
        }
        return this.mz == null ? dD() : b(charSequence, i, i2);
    }

    private boolean b(CharSequence charSequence, int i, int i2) {
        switch (this.mz.a(charSequence, i, i2)) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return dD();
        }
    }
}
