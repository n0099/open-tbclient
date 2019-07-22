package com.baidu.swan.apps.b.c.a;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class c {
    private final ArrayList<a> akI = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void a(Activity activity, int i, int i2, Intent intent);
    }

    /* loaded from: classes2.dex */
    private static class b {
        public static final c akJ = new c();
    }

    public static c xB() {
        return b.akJ;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (c.class) {
                if (!this.akI.contains(aVar)) {
                    this.akI.add(aVar);
                }
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (c.class) {
                if (this.akI.contains(aVar)) {
                    this.akI.remove(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Activity activity, int i, int i2, Intent intent) {
        Object[] o = o(this.akI);
        if (o != null) {
            for (Object obj : o) {
                ((a) obj).a(activity, i, i2, intent);
            }
        }
    }

    private <T extends List> Object[] o(T t) {
        Object[] objArr = null;
        synchronized (c.class) {
            if (t.size() > 0) {
                objArr = t.toArray();
            }
        }
        return objArr;
    }
}
