package android.arch.lifecycle;

import java.util.HashMap;
/* loaded from: classes7.dex */
public class z {
    private final HashMap<String, w> zK = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, w wVar) {
        w put = this.zK.put(str, wVar);
        if (put != null) {
            put.onCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w aX(String str) {
        return this.zK.get(str);
    }

    public final void clear() {
        for (w wVar : this.zK.values()) {
            wVar.onCleared();
        }
        this.zK.clear();
    }
}
