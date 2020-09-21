package bolts;

import java.util.Locale;
/* loaded from: classes16.dex */
public class c {
    private final e Ae;

    /* renamed from: if  reason: not valid java name */
    public boolean m7if() {
        return this.Ae.m8if();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.Ae.m8if()));
    }
}
