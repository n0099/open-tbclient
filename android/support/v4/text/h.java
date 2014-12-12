package android.support.v4.text;
/* loaded from: classes.dex */
class h implements j {
    public static final h bq = new h(true);
    public static final h br = new h(false);
    private final boolean bp;

    @Override // android.support.v4.text.j
    public int a(CharSequence charSequence, int i, int i2) {
        int g;
        int i3 = i + i2;
        boolean z = false;
        while (i < i3) {
            g = TextDirectionHeuristicsCompat.g(Character.getDirectionality(charSequence.charAt(i)));
            switch (g) {
                case 0:
                    if (!this.bp) {
                        z = true;
                        break;
                    } else {
                        return 0;
                    }
                case 1:
                    if (this.bp) {
                        z = true;
                        break;
                    } else {
                        return 1;
                    }
            }
            i++;
        }
        if (z) {
            return !this.bp ? 0 : 1;
        }
        return 2;
    }

    private h(boolean z) {
        this.bp = z;
    }
}
