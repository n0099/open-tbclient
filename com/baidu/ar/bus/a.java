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
    b ku;
    private Looper kv;
    private final Map<Class<?>, CopyOnWriteArrayList<g>> kr = new HashMap();
    private final Map<Object, List<Class<?>>> kq = new HashMap();
    f ks = new f();
    b kt = new b(this, Looper.getMainLooper(), 10);

    private void a(g gVar, Object obj) {
        switch (gVar.kW.kJ) {
            case POSTING:
                b(gVar, obj);
                return;
            case MAIN:
                if (isMainThread()) {
                    b(gVar, obj);
                    return;
                } else {
                    this.kt.c(gVar, obj);
                    return;
                }
            case CONTROLLER:
                if (cG()) {
                    b(gVar, obj);
                    return;
                } else {
                    this.ku.c(gVar, obj);
                    return;
                }
            default:
                com.baidu.ar.h.b.aS("Unknown thread mode: " + gVar.kW.kJ);
                return;
        }
    }

    private void a(Object obj, e eVar) {
        Class<?> cls = eVar.kK;
        g gVar = new g(obj, eVar);
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.kr.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.kr.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(gVar)) {
            com.baidu.ar.h.b.aS("Subscriber " + obj.getClass() + " already registered to event " + cls);
            return;
        }
        copyOnWriteArrayList.add(gVar);
        List<Class<?>> list = this.kq.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.kq.put(obj, list);
        }
        list.add(cls);
    }

    private void a(Object obj, Class<?> cls) {
        int i;
        int i2;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.kr.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i3 = 0;
            while (i3 < size) {
                g gVar = copyOnWriteArrayList.get(i3);
                if (gVar.kV == obj) {
                    gVar.kX = false;
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
            copyOnWriteArrayList = this.kr.get(cls);
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
        Object obj = cVar.kD;
        g gVar = cVar.kE;
        c.b(cVar);
        if (gVar.kX) {
            b(gVar, obj);
        }
    }

    public void b(Looper looper) {
        if (this.ku != null) {
            this.ku.release();
        }
        this.kv = looper;
        this.ku = new b(this, looper, 10);
    }

    void b(g gVar, Object obj) {
        try {
            gVar.kW.kI.invoke(gVar.kV, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cG() {
        return this.kv != null && this.kv == Looper.myLooper();
    }

    public void d(Object obj) {
        List<e> a2 = this.ks.a(obj.getClass());
        synchronized (this) {
            for (e eVar : a2) {
                a(obj, eVar);
            }
        }
    }

    public synchronized void e(Object obj) {
        List<Class<?>> list = this.kq.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                a(obj, cls);
            }
            this.kq.remove(obj);
        } else {
            com.baidu.ar.h.b.aS("Subscriber to unregister was not registered before: " + obj.getClass());
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
        com.baidu.ar.h.b.aS("No subscribers registered for event " + cls);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
