package com.baidu.searchbox.live.eventbus;

import android.os.Handler;
import android.os.Looper;
import com.baidu.live.arch.thread.MiniElasticExecutor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class MixEventBusCore implements IActionHandler {
    public Handler mainHandler = new Handler(Looper.getMainLooper());

    private boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.live.eventbus.IActionHandler
    public void execute(int i, final Object obj, final EventAction eventAction) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    eventAction.call(obj);
                } else {
                    MiniElasticExecutor.INSTANCE.execute(new Runnable() { // from class: com.baidu.searchbox.live.eventbus.MixEventBusCore.3
                        @Override // java.lang.Runnable
                        public void run() {
                            eventAction.call(obj);
                        }
                    });
                }
            } else if (isMainThread()) {
                MiniElasticExecutor.INSTANCE.execute(new Runnable() { // from class: com.baidu.searchbox.live.eventbus.MixEventBusCore.2
                    @Override // java.lang.Runnable
                    public void run() {
                        eventAction.call(obj);
                    }
                });
            } else {
                eventAction.call(obj);
            }
        } else if (isMainThread()) {
            eventAction.call(obj);
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.eventbus.MixEventBusCore.1
                @Override // java.lang.Runnable
                public void run() {
                    eventAction.call(obj);
                }
            });
        }
    }

    public synchronized void post(ConcurrentHashMap<Object, CopyOnWriteArrayList<EventPoster>> concurrentHashMap, Object obj) {
        if (obj != null && concurrentHashMap != null) {
            if (!concurrentHashMap.isEmpty()) {
                for (Map.Entry<Object, CopyOnWriteArrayList<EventPoster>> entry : concurrentHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        Iterator<EventPoster> it = entry.getValue().iterator();
                        while (it.hasNext()) {
                            EventPoster next = it.next();
                            if (next.isSupport(obj)) {
                                next.call(obj);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void register(ConcurrentHashMap<Object, CopyOnWriteArrayList<EventPoster>> concurrentHashMap, Object obj, Class<?> cls, int i, EventAction eventAction) {
        if (obj != null && cls != null && eventAction != null && concurrentHashMap != null) {
            CopyOnWriteArrayList<EventPoster> copyOnWriteArrayList = null;
            if (concurrentHashMap.containsKey(obj)) {
                copyOnWriteArrayList = concurrentHashMap.get(obj);
            }
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                concurrentHashMap.put(obj, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new EventPoster(i, cls, eventAction, this));
        }
    }

    public synchronized void unRegister(ConcurrentHashMap<Object, CopyOnWriteArrayList<EventPoster>> concurrentHashMap, Object obj) {
        if (obj != null && concurrentHashMap != null) {
            if (!concurrentHashMap.isEmpty() && concurrentHashMap.containsKey(obj)) {
                CopyOnWriteArrayList<EventPoster> remove = concurrentHashMap.remove(obj);
                if (remove != null && remove.size() > 0) {
                    Iterator<EventPoster> it = remove.iterator();
                    while (it.hasNext()) {
                        it.next().clear();
                    }
                }
                if (remove != null) {
                    remove.clear();
                }
            }
        }
    }
}
