package com.baidu.apollon.eventbus;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3632a = ApollonConstants.DEBUG;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3633b = b.class.getSimpleName();
    public final ThreadLocal<a> i = new ThreadLocal<a>() { // from class: com.baidu.apollon.eventbus.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public a initialValue() {
            return new a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f3637f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, List<String>> f3638g = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, EventBus.Event> f3634c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final c f3635d = new c(this, Looper.getMainLooper(), 10);

    /* renamed from: e  reason: collision with root package name */
    public final com.baidu.apollon.eventbus.a f3636e = new com.baidu.apollon.eventbus.a(this);

    /* renamed from: h  reason: collision with root package name */
    public final f f3639h = new f();

    /* renamed from: com.baidu.apollon.eventbus.b$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3641a;

        static {
            int[] iArr = new int[EventBus.ThreadMode.values().length];
            f3641a = iArr;
            try {
                iArr[EventBus.ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3641a[EventBus.ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3641a[EventBus.ThreadMode.Async.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3642a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3643b;

        /* renamed from: c  reason: collision with root package name */
        public g f3644c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f3645d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3646e;
    }

    private void b(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f3637f.get(str);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                g gVar = copyOnWriteArrayList.get(i);
                if (gVar.f3656a == obj) {
                    gVar.f3661f = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public synchronized void a(Object obj, String[] strArr, int i, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.f3639h.a(obj.getClass()), z, i, strArr, threadMode);
    }

    public void c(EventBus.Event event) {
        a aVar = this.i.get();
        if (!aVar.f3642a) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (event != null) {
            if (aVar.f3645d == event) {
                aVar.f3646e = true;
                return;
            }
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        throw new EventBusException("Event may not be null");
    }

    public synchronized void a(Object obj, String str, int i, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.f3639h.a(obj.getClass()), z, i, str, threadMode);
    }

    private void a(Object obj, Method method, boolean z, int i, String[] strArr, EventBus.ThreadMode threadMode) {
        for (String str : strArr) {
            a(obj, method, z, i, str, threadMode);
        }
    }

    public void b(EventBus.Event event) {
        synchronized (this.f3634c) {
            this.f3634c.put(event.mEventKey, event);
        }
        a(event);
    }

    private void a(Object obj, Method method, boolean z, int i, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f3637f.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f3637f.put(str, copyOnWriteArrayList);
        } else {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f3656a.equals(obj)) {
                    if (f3632a) {
                        String str2 = f3633b;
                        Log.d(str2, "Subscriber " + obj.getClass() + " already registered to event " + str);
                        return;
                    }
                    return;
                }
            }
        }
        g gVar = new g(obj, method, str, i, threadMode);
        int size = copyOnWriteArrayList.size();
        if (size > 0) {
            for (int i2 = 0; i2 <= size; i2++) {
                if (i2 == size || gVar.f3658c > copyOnWriteArrayList.get(i2).f3658c) {
                    copyOnWriteArrayList.add(i2, gVar);
                    break;
                }
            }
        } else {
            copyOnWriteArrayList.add(gVar);
        }
        List<String> list = this.f3638g.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f3638g.put(obj, list);
        }
        list.add(str);
        if (z) {
            synchronized (this.f3634c) {
                event = this.f3634c.get(str);
            }
            if (event != null) {
                a(gVar, event, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    public synchronized void a(Object obj) {
        if (obj != null) {
            List<String> list = this.f3638g.get(obj);
            if (list != null) {
                for (String str : list) {
                    b(obj, str);
                }
                this.f3638g.remove(obj);
            } else {
                String str2 = f3633b;
                LogUtil.w(str2, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public synchronized void a(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            b(obj, str);
            List<String> list = this.f3638g.get(obj);
            if (list != null) {
                list.remove(str);
            }
            if (list != null && list.size() == 0) {
                this.f3638g.remove(obj);
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public void a(EventBus.Event event) {
        a aVar = this.i.get();
        if (aVar.f3642a) {
            return;
        }
        aVar.f3643b = Looper.getMainLooper() == Looper.myLooper();
        aVar.f3642a = true;
        if (aVar.f3646e) {
            aVar.f3642a = false;
            if (f3632a) {
                Log.d(f3633b, "Event has already been cancelled");
                return;
            }
            return;
        }
        try {
            a(event, aVar);
        } finally {
            aVar.f3642a = false;
            aVar.f3643b = false;
        }
    }

    public void a(String str) {
        synchronized (this.f3634c) {
            this.f3634c.remove(str);
        }
    }

    public void a() {
        synchronized (this.f3634c) {
            this.f3634c.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.apollon.eventbus.EventBus$Event, com.baidu.apollon.eventbus.g] */
    private void a(EventBus.Event event, a aVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f3637f.get(event.mEventKey);
        }
        boolean z = false;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                aVar.f3645d = event;
                aVar.f3644c = next;
                try {
                    a(next, event, aVar.f3643b);
                    if (aVar.f3646e) {
                        break;
                    }
                } finally {
                    aVar.f3645d = null;
                    aVar.f3644c = null;
                    aVar.f3646e = false;
                }
            }
            z = true;
        }
        if (z || !f3632a) {
            return;
        }
        String str = f3633b;
        Log.d(str, "No subscribers registered for event " + event.mEventKey);
    }

    private void a(g gVar, EventBus.Event event, boolean z) {
        int i = AnonymousClass2.f3641a[gVar.f3660e.ordinal()];
        if (i == 1) {
            a(gVar, event);
        } else if (i == 2) {
            if (z) {
                a(gVar, event);
            } else {
                this.f3635d.a(gVar, event);
            }
        } else if (i == 3) {
            this.f3636e.a(gVar, event);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + gVar.f3660e);
        }
    }

    public void a(d dVar) {
        EventBus.Event event = dVar.f3651a;
        g gVar = dVar.f3652b;
        if (gVar.f3661f) {
            a(gVar, event);
        }
    }

    private void a(g gVar, EventBus.Event event) throws Error {
        try {
            gVar.f3657b.invoke(gVar.f3656a, event);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            String str = f3633b;
            Log.e(str, "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.f3656a.getClass(), cause);
        }
    }
}
