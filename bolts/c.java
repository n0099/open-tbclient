package bolts;

import java.util.Locale;
/* loaded from: classes5.dex */
public class c {
    private final e cY;

    public boolean aS() {
        return this.cY.aS();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.cY.aS()));
    }
}
