package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MessageProxy {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<List<Handler>> f4716a = new SparseArray<>();

    public static void destroy() {
        int size = f4716a.size();
        for (int i = 0; i < size; i++) {
            List<Handler> list = f4716a.get(f4716a.keyAt(i));
            if (list != null) {
                list.clear();
            }
        }
        f4716a.clear();
    }

    public static void dispatchMessage(int i, int i2, int i3, long j) {
        if (i == 2000 || i == 2008 || i == 4099) {
            Log.d("BaseEngine", "Msg Receive, what: " + i);
        }
        synchronized (f4716a) {
            List<Handler> list = f4716a.get(i);
            if (list != null && !list.isEmpty()) {
                for (Handler handler : list) {
                    Message.obtain(handler, i, i2, i3, Long.valueOf(j)).sendToTarget();
                }
            }
        }
    }

    public static void registerMessageHandler(int i, Handler handler) {
        if (handler == null) {
            return;
        }
        synchronized (f4716a) {
            List<Handler> list = f4716a.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                f4716a.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void unRegisterMessageHandler(int i, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            synchronized (f4716a) {
                List<Handler> list = f4716a.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
