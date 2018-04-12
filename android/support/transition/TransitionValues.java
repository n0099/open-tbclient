package android.support.transition;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class TransitionValues {
    public final Map<String, Object> values = new HashMap();

    /* renamed from: view  reason: collision with root package name */
    public View f2view;

    public boolean equals(Object obj) {
        return (obj instanceof TransitionValues) && this.f2view == ((TransitionValues) obj).f2view && this.values.equals(((TransitionValues) obj).values);
    }

    public int hashCode() {
        return (this.f2view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String next;
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2view + "\n") + "    values:";
        Iterator<String> it = this.values.keySet().iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + "    " + it.next() + ": " + this.values.get(next) + "\n";
            } else {
                return str2;
            }
        }
    }
}
