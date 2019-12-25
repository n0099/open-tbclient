package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class z {
    private final HashMap<String, w> cR = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.cR.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w C(String str) {
        return this.cR.get(str);
    }

    public final void clear() {
        for (w wVar : this.cR.values()) {
            wVar.onCleared();
        }
        this.cR.clear();
    }
}
