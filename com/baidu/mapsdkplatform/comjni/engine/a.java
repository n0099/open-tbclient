package com.baidu.mapsdkplatform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7971a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static SparseArray<List<Handler>> f7972b = new SparseArray<>();

    public static void a(int i2, int i3, int i4, long j) {
        synchronized (f7972b) {
            List<Handler> list = f7972b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message.obtain(handler, i2, i3, i4, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    public static void a(int i2, Handler handler) {
        synchronized (f7972b) {
            if (handler == null) {
                return;
            }
            List<Handler> list = f7972b.get(i2);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                f7972b.put(i2, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void b(int i2, Handler handler) {
        synchronized (f7972b) {
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                List<Handler> list = f7972b.get(i2);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
