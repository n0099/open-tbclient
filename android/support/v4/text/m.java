package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
class m extends k {
    public static final m bw = new m();

    public m() {
        super(null);
    }

    @Override // android.support.v4.text.k
    protected boolean af() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
}
