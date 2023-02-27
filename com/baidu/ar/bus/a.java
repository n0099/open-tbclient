package com.baidu.ar.bus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class a {
    public b ku;
    public Looper kv;
    public final Map<Class<?>, CopyOnWriteArrayList<g>> kr = new HashMap();
    public final Map<Object, List<Class<?>>> kq = new HashMap();
    public f ks = new f();
    public b kt = new b(this, Looper.getMainLooper(), 10);

    /* renamed from: com.baidu.ar.bus.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kw;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            kw = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                kw[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                kw[ThreadMode.CONTROLLER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void a(g gVar, Object obj) {
        b bVar;
        int i = AnonymousClass1.kw[gVar.kW.kJ.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    com.baidu.ar.h.b.aS("Unknown thread mode: " + gVar.kW.kJ);
                    return;
                } else if (!cG()) {
                    bVar = this.ku;
                    bVar.c(gVar, obj);
                    return;
                }
            } else if (!isMainThread()) {
                bVar = this.kt;
                bVar.c(gVar, obj);
                return;
            }
        }
        b(gVar, obj);
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
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.kr.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                g gVar = copyOnWriteArrayList.get(i);
                if (gVar.kV == obj) {
                    gVar.kX = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
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

    public void a(c cVar) {
        Object obj = cVar.kD;
        g gVar = cVar.kE;
        c.b(cVar);
        if (gVar.kX) {
            b(gVar, obj);
        }
    }

    public void b(Looper looper) {
        b bVar = this.ku;
        if (bVar != null) {
            bVar.release();
        }
        this.kv = looper;
        this.ku = new b(this, looper, 10);
    }

    public void b(g gVar, Object obj) {
        try {
            gVar.kW.kI.invoke(gVar.kV, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cG() {
        Looper looper = this.kv;
        return looper != null && looper == Looper.myLooper();
    }

    public void d(Object obj) {
        List<e> a = this.ks.a(obj.getClass());
        synchronized (this) {
            for (e eVar : a) {
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
