package bolts;

import java.util.Locale;
/* loaded from: classes2.dex */
public class c {
    private final e bZ;

    public boolean aG() {
        return this.bZ.aG();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.bZ.aG()));
    }
}
