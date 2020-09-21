package com.baidu.ar.bus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    b kf;
    private Looper kg;
    private final Map<Class<?>, CopyOnWriteArrayList<g>> kc = new HashMap();
    private final Map<Object, List<Class<?>>> kb = new HashMap();
    f kd = new f();
    b ke = new b(this, Looper.getMainLooper(), 10);

    private void a(g gVar, Object obj) {
        switch (gVar.kH.ku) {
            case POSTING:
                b(gVar, obj);
                return;
            case MAIN:
                if (isMainThread()) {
                    b(gVar, obj);
                    return;
                } else {
                    this.ke.c(gVar, obj);
                    return;
                }
            case CONTROLLER:
                if (cH()) {
                    b(gVar, obj);
                    return;
                } else {
                    this.kf.c(gVar, obj);
                    return;
                }
            default:
                com.baidu.ar.g.b.aP("Unknown thread mode: " + gVar.kH.ku);
                return;
        }
    }

    private void a(Object obj, e eVar) {
        Class<?> cls = eVar.kv;
        g gVar = new g(obj, eVar);
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.kc.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.kc.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(gVar)) {
            com.baidu.ar.g.b.aP("Subscriber " + obj.getClass() + " already registered to event " + cls);
            return;
        }
        copyOnWriteArrayList.add(gVar);
        List<Class<?>> list = this.kb.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.kb.put(obj, list);
        }
        list.add(cls);
    }

    private void a(Object obj, Class<?> cls) {
        int i;
        int i2;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.kc.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i3 = 0;
            while (i3 < size) {
                g gVar = copyOnWriteArrayList.get(i3);
                if (gVar.kG == obj) {
                    gVar.kI = false;
                    copyOnWriteArrayList.remove(i3);
                    i = i3 - 1;
                    i2 = size - 1;
                } else {
                    i = i3;
                    i2 = size;
                }
                size = i2;
                i3 = i + 1;
            }
        }
    }

    private boolean b(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.kc.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<g> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        Object obj = cVar.ko;
        g gVar = cVar.kp;
        c.b(cVar);
        if (gVar.kI) {
            b(gVar, obj);
        }
    }

    public void b(Looper looper) {
        if (this.kf != null) {
            this.kf.release();
        }
        this.kg = looper;
        this.kf = new b(this, looper, 10);
    }

    void b(g gVar, Object obj) {
        try {
            gVar.kH.kt.invoke(gVar.kG, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cH() {
        return this.kg != null && this.kg == Looper.myLooper();
    }

    public void d(Object obj) {
        List<e> a = this.kd.a(obj.getClass());
        synchronized (this) {
            for (e eVar : a) {
                a(obj, eVar);
            }
        }
    }

    public synchronized void e(Object obj) {
        List<Class<?>> list = this.kb.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                a(obj, cls);
            }
            this.kb.remove(obj);
        } else {
            com.baidu.ar.g.b.aP("Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void f(Object obj) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (b(obj, cls)) {
            return;
        }
        com.baidu.ar.g.b.aP("No subscribers registered for event " + cls);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
