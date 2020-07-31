package bolts;

import java.util.Locale;
/* loaded from: classes19.dex */
public class c {
    private final e zv;

    public boolean gF() {
        return this.zv.gF();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.zv.gF()));
    }
}
