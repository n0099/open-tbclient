package com.baidu.platform.comjni.engine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class MessageProxy {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<List<Handler>> f3165a = new SparseArray<>();

    public static void destroy() {
        int size = f3165a.size();
        for (int i = 0; i < size; i++) {
            List<Handler> list = f3165a.get(f3165a.keyAt(i));
            if (list != null) {
                list.clear();
            }
        }
        f3165a.clear();
    }

    public static void dispatchMessage(int i, int i2, int i3, long j) {
        if (i == 2000 || i == 2008 || i == 4099) {
            Log.d("BaseEngine", "Msg Receive, what: " + i);
        }
        synchronized (f3165a) {
            List<Handler> list = f3165a.get(i);
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
        synchronized (f3165a) {
            List<Handler> list = f3165a.get(i);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(handler);
                f3165a.put(i, arrayList);
            } else if (!list.contains(handler)) {
                list.add(handler);
            }
        }
    }

    public static void unRegisterMessageHandler(int i, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            synchronized (f3165a) {
                List<Handler> list = f3165a.get(i);
                if (list != null) {
                    list.remove(handler);
                }
            }
        }
    }
}
