package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes14.dex */
public class z {
    private final HashMap<String, w> AW = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.AW.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w ba(String str) {
        return this.AW.get(str);
    }

    public final void clear() {
        for (w wVar : this.AW.values()) {
            wVar.onCleared();
        }
        this.AW.clear();
    }
}
