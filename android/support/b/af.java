package android.support.b;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class af {
    public final Map<String, Object> values = new HashMap();
    public View view;

    public boolean equals(Object obj) {
        return (obj instanceof af) && this.view == ((af) obj).view && this.values.equals(((af) obj).values);
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String next;
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
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
