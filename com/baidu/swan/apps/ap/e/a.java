package com.baidu.swan.apps.ap.e;

import android.os.Handler;
import java.util.Collection;
/* loaded from: classes3.dex */
public final class a {
    public static <T> void a(b<T> bVar, T... tArr) {
        a((Handler) null, (b) bVar, (Object[]) tArr);
    }

    public static <T> void a(b<T> bVar, Collection<T> collection) {
        a((Handler) null, (b) bVar, (Collection) collection);
    }

    public static <T> void a(Handler handler, b<T> bVar, T... tArr) {
        if (bVar != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                a(handler, bVar, t);
            }
        }
    }

    public static <T> void a(Handler handler, b<T> bVar, Collection<T> collection) {
        if (bVar != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                a(handler, bVar, t);
            }
        }
    }

    public static <T> void a(Handler handler, final b<T> bVar, final T t) {
        if (handler == null) {
            bVar.J(t);
        } else {
            handler.post(new Runnable() { // from class: com.baidu.swan.apps.ap.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.J(t);
                }
            });
        }
    }
}
