package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class z {
    private final HashMap<String, w> yL = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.yL.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w aS(String str) {
        return this.yL.get(str);
    }

    public final void clear() {
        for (w wVar : this.yL.values()) {
            wVar.onCleared();
        }
        this.yL.clear();
    }
}
