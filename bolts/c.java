package bolts;

import java.util.Locale;
/* loaded from: classes14.dex */
public class c {
    private final e Ct;

    public boolean hF() {
        return this.Ct.hF();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.Ct.hF()));
    }
}
