package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class z {
    private final HashMap<String, w> zl = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.zl.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w aT(String str) {
        return this.zl.get(str);
    }

    public final void clear() {
        for (w wVar : this.zl.values()) {
            wVar.onCleared();
        }
        this.zl.clear();
    }
}
