package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2288a = a.class.getSimpleName();
    private static SparseArray<List<Handler>> b = new SparseArray<>();

    public static void a(int i, int i2, int i3, long j) {
        synchronized (b) {
            List<Handler> list = b.get(i);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message.obtain(handler, i, i2, i3, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    public static void a(int i, Handler handler) {
        synchronized (b) {
            if (handler == null) {
                return;
            }
            List<Handler> list = b.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                b.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void b(int i, Handler handler) {
        synchronized (b) {
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                List<Handler> list = b.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
