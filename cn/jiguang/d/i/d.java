package cn.jiguang.d.i;

import android.content.ComponentName;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class d {
    private HashMap<Integer, Boolean> b = new HashMap<>();
    private ComponentName mF;

    public final void a(int i, boolean z) {
        this.b.put(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public final void a(ComponentName componentName) {
        this.mF = componentName;
    }

    public final HashMap<Integer, Boolean> b() {
        return this.b;
    }

    public final ComponentName ci() {
        return this.mF;
    }
}
