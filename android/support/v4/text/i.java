package android.support.v4.text;
/* loaded from: classes.dex */
class i implements j {
    public static final i bt = new i();

    @Override // android.support.v4.text.j
    public int a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 2;
        while (i < i3 && i4 == 2) {
            i4 = TextDirectionHeuristicsCompat.h(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return i4;
    }

    private i() {
    }
}
