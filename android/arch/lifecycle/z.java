package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes5.dex */
public class z {
    private final HashMap<String, w> cQ = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.cQ.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w C(String str) {
        return this.cQ.get(str);
    }

    public final void clear() {
        for (w wVar : this.cQ.values()) {
            wVar.onCleared();
        }
        this.cQ.clear();
    }
}
