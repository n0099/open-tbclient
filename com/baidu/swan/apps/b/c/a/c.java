package com.baidu.swan.apps.b.c.a;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class c {
    private final ArrayList<a> ajP = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void a(Activity activity, int i, int i2, Intent intent);
    }

    /* loaded from: classes2.dex */
    private static class b {
        public static final c ajQ = new c();
    }

    public static c wk() {
        return b.ajQ;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (c.class) {
                if (!this.ajP.contains(aVar)) {
                    this.ajP.add(aVar);
                }
            }
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (c.class) {
                if (this.ajP.contains(aVar)) {
                    this.ajP.remove(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Activity activity, int i, int i2, Intent intent) {
        Object[] n = n(this.ajP);
        if (n != null) {
            for (Object obj : n) {
                ((a) obj).a(activity, i, i2, intent);
            }
        }
    }

    private <T extends List> Object[] n(T t) {
        Object[] objArr = null;
        synchronized (c.class) {
            if (t.size() > 0) {
                objArr = t.toArray();
            }
        }
        return objArr;
    }
}
