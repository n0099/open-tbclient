package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7929a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static SparseArray<List<Handler>> f7930b = new SparseArray<>();

    public static void a(int i, int i2, int i3, long j) {
        synchronized (f7930b) {
            List<Handler> list = f7930b.get(i);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message.obtain(handler, i, i2, i3, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    public static void a(int i, Handler handler) {
        synchronized (f7930b) {
            if (handler == null) {
                return;
            }
            List<Handler> list = f7930b.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                f7930b.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void b(int i, Handler handler) {
        synchronized (f7930b) {
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                List<Handler> list = f7930b.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
