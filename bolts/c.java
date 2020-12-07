package bolts;

import java.util.Locale;
/* loaded from: classes10.dex */
public class c {
    private final e Bp;

    public boolean ig() {
        return this.Bp.ig();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.Bp.ig()));
    }
}
