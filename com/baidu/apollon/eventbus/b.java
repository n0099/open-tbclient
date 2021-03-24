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
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3596a = ApollonConstants.DEBUG;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3597b = b.class.getSimpleName();
    public final ThreadLocal<a> i = new ThreadLocal<a>() { // from class: com.baidu.apollon.eventbus.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public a initialValue() {
            return new a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f3601f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, List<String>> f3602g = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, EventBus.Event> f3598c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final c f3599d = new c(this, Looper.getMainLooper(), 10);

    /* renamed from: e  reason: collision with root package name */
    public final com.baidu.apollon.eventbus.a f3600e = new com.baidu.apollon.eventbus.a(this);

    /* renamed from: h  reason: collision with root package name */
    public final f f3603h = new f();

    /* renamed from: com.baidu.apollon.eventbus.b$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3605a;

        static {
            int[] iArr = new int[EventBus.ThreadMode.values().length];
            f3605a = iArr;
            try {
                iArr[EventBus.ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3605a[EventBus.ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3605a[EventBus.ThreadMode.Async.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3606a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3607b;

        /* renamed from: c  reason: collision with root package name */
        public g f3608c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f3609d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3610e;
    }

    private void b(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f3601f.get(str);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                g gVar = copyOnWriteArrayList.get(i);
                if (gVar.f3620a == obj) {
                    gVar.f3625f = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public synchronized void a(Object obj, String[] strArr, int i, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.f3603h.a(obj.getClass()), z, i, strArr, threadMode);
    }

    public void c(EventBus.Event event) {
        a aVar = this.i.get();
        if (!aVar.f3606a) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (event != null) {
            if (aVar.f3609d == event) {
                aVar.f3610e = true;
                return;
            }
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        throw new EventBusException("Event may not be null");
    }

    public synchronized void a(Object obj, String str, int i, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.f3603h.a(obj.getClass()), z, i, str, threadMode);
    }

    private void a(Object obj, Method method, boolean z, int i, String[] strArr, EventBus.ThreadMode threadMode) {
        for (String str : strArr) {
            a(obj, method, z, i, str, threadMode);
        }
    }

    public void b(EventBus.Event event) {
        synchronized (this.f3598c) {
            this.f3598c.put(event.mEventKey, event);
        }
        a(event);
    }

    private void a(Object obj, Method method, boolean z, int i, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f3601f.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f3601f.put(str, copyOnWriteArrayList);
        } else {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f3620a.equals(obj)) {
                    if (f3596a) {
                        String str2 = f3597b;
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
                if (i2 == size || gVar.f3622c > copyOnWriteArrayList.get(i2).f3622c) {
                    copyOnWriteArrayList.add(i2, gVar);
                    break;
                }
            }
        } else {
            copyOnWriteArrayList.add(gVar);
        }
        List<String> list = this.f3602g.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f3602g.put(obj, list);
        }
        list.add(str);
        if (z) {
            synchronized (this.f3598c) {
                event = this.f3598c.get(str);
            }
            if (event != null) {
                a(gVar, event, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    public synchronized void a(Object obj) {
        if (obj != null) {
            List<String> list = this.f3602g.get(obj);
            if (list != null) {
                for (String str : list) {
                    b(obj, str);
                }
                this.f3602g.remove(obj);
            } else {
                String str2 = f3597b;
                LogUtil.w(str2, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public synchronized void a(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            b(obj, str);
            List<String> list = this.f3602g.get(obj);
            if (list != null) {
                list.remove(str);
            }
            if (list != null && list.size() == 0) {
                this.f3602g.remove(obj);
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public void a(EventBus.Event event) {
        a aVar = this.i.get();
        if (aVar.f3606a) {
            return;
        }
        aVar.f3607b = Looper.getMainLooper() == Looper.myLooper();
        aVar.f3606a = true;
        if (aVar.f3610e) {
            aVar.f3606a = false;
            if (f3596a) {
                Log.d(f3597b, "Event has already been cancelled");
                return;
            }
            return;
        }
        try {
            a(event, aVar);
        } finally {
            aVar.f3606a = false;
            aVar.f3607b = false;
        }
    }

    public void a(String str) {
        synchronized (this.f3598c) {
            this.f3598c.remove(str);
        }
    }

    public void a() {
        synchronized (this.f3598c) {
            this.f3598c.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.apollon.eventbus.EventBus$Event, com.baidu.apollon.eventbus.g] */
    private void a(EventBus.Event event, a aVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f3601f.get(event.mEventKey);
        }
        boolean z = false;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                aVar.f3609d = event;
                aVar.f3608c = next;
                try {
                    a(next, event, aVar.f3607b);
                    if (aVar.f3610e) {
                        break;
                    }
                } finally {
                    aVar.f3609d = null;
                    aVar.f3608c = null;
                    aVar.f3610e = false;
                }
            }
            z = true;
        }
        if (z || !f3596a) {
            return;
        }
        String str = f3597b;
        Log.d(str, "No subscribers registered for event " + event.mEventKey);
    }

    private void a(g gVar, EventBus.Event event, boolean z) {
        int i = AnonymousClass2.f3605a[gVar.f3624e.ordinal()];
        if (i == 1) {
            a(gVar, event);
        } else if (i == 2) {
            if (z) {
                a(gVar, event);
            } else {
                this.f3599d.a(gVar, event);
            }
        } else if (i == 3) {
            this.f3600e.a(gVar, event);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + gVar.f3624e);
        }
    }

    public void a(d dVar) {
        EventBus.Event event = dVar.f3615a;
        g gVar = dVar.f3616b;
        if (gVar.f3625f) {
            a(gVar, event);
        }
    }

    private void a(g gVar, EventBus.Event event) throws Error {
        try {
            gVar.f3621b.invoke(gVar.f3620a, event);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            String str = f3597b;
            Log.e(str, "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.f3620a.getClass(), cause);
        }
    }
}
