package bolts;

import java.util.Locale;
/* loaded from: classes19.dex */
public class c {
    private final e Av;

    public boolean ig() {
        return this.Av.ig();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.Av.ig()));
    }
}
