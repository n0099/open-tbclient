package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes14.dex */
public class z {
    private final HashMap<String, w> Ab = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.Ab.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w aX(String str) {
        return this.Ab.get(str);
    }

    public final void clear() {
        for (w wVar : this.Ab.values()) {
            wVar.onCleared();
        }
        this.Ab.clear();
    }
}
