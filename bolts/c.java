package bolts;

import java.util.Locale;
/* loaded from: classes7.dex */
public class c {
    private final e zt;

    public boolean gF() {
        return this.zt.gF();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.zt.gF()));
    }
}
