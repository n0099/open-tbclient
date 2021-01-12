package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3168a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static SparseArray<List<Handler>> f3169b = new SparseArray<>();

    public static void a(int i, int i2, int i3, long j) {
        synchronized (f3169b) {
            List<Handler> list = f3169b.get(i);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message.obtain(handler, i, i2, i3, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    public static void a(int i, Handler handler) {
        synchronized (f3169b) {
            if (handler == null) {
                return;
            }
            List<Handler> list = f3169b.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                f3169b.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void b(int i, Handler handler) {
        synchronized (f3169b) {
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                List<Handler> list = f3169b.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
