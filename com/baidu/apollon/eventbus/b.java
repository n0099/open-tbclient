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
    public static final boolean f3679a = ApollonConstants.DEBUG;

    /* renamed from: b  reason: collision with root package name */
    public static final String f3680b = b.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    public final ThreadLocal<a> f3687i = new ThreadLocal<a>() { // from class: com.baidu.apollon.eventbus.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public a initialValue() {
            return new a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f3684f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, List<String>> f3685g = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, EventBus.Event> f3681c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final c f3682d = new c(this, Looper.getMainLooper(), 10);

    /* renamed from: e  reason: collision with root package name */
    public final com.baidu.apollon.eventbus.a f3683e = new com.baidu.apollon.eventbus.a(this);

    /* renamed from: h  reason: collision with root package name */
    public final f f3686h = new f();

    /* renamed from: com.baidu.apollon.eventbus.b$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3689a;

        static {
            int[] iArr = new int[EventBus.ThreadMode.values().length];
            f3689a = iArr;
            try {
                iArr[EventBus.ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3689a[EventBus.ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3689a[EventBus.ThreadMode.Async.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3690a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3691b;

        /* renamed from: c  reason: collision with root package name */
        public g f3692c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f3693d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3694e;
    }

    private void b(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f3684f.get(str);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                g gVar = copyOnWriteArrayList.get(i2);
                if (gVar.f3704a == obj) {
                    gVar.f3709f = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public synchronized void a(Object obj, String[] strArr, int i2, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.f3686h.a(obj.getClass()), z, i2, strArr, threadMode);
    }

    public void c(EventBus.Event event) {
        a aVar = this.f3687i.get();
        if (!aVar.f3690a) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (event != null) {
            if (aVar.f3693d == event) {
                aVar.f3694e = true;
                return;
            }
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        throw new EventBusException("Event may not be null");
    }

    public synchronized void a(Object obj, String str, int i2, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.f3686h.a(obj.getClass()), z, i2, str, threadMode);
    }

    private void a(Object obj, Method method, boolean z, int i2, String[] strArr, EventBus.ThreadMode threadMode) {
        for (String str : strArr) {
            a(obj, method, z, i2, str, threadMode);
        }
    }

    public void b(EventBus.Event event) {
        synchronized (this.f3681c) {
            this.f3681c.put(event.mEventKey, event);
        }
        a(event);
    }

    private void a(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f3684f.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f3684f.put(str, copyOnWriteArrayList);
        } else {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f3704a.equals(obj)) {
                    if (f3679a) {
                        String str2 = f3680b;
                        Log.d(str2, "Subscriber " + obj.getClass() + " already registered to event " + str);
                        return;
                    }
                    return;
                }
            }
        }
        g gVar = new g(obj, method, str, i2, threadMode);
        int size = copyOnWriteArrayList.size();
        if (size > 0) {
            for (int i3 = 0; i3 <= size; i3++) {
                if (i3 == size || gVar.f3706c > copyOnWriteArrayList.get(i3).f3706c) {
                    copyOnWriteArrayList.add(i3, gVar);
                    break;
                }
            }
        } else {
            copyOnWriteArrayList.add(gVar);
        }
        List<String> list = this.f3685g.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f3685g.put(obj, list);
        }
        list.add(str);
        if (z) {
            synchronized (this.f3681c) {
                event = this.f3681c.get(str);
            }
            if (event != null) {
                a(gVar, event, Looper.getMainLooper() == Looper.myLooper());
            }
        }
    }

    public synchronized void a(Object obj) {
        if (obj != null) {
            List<String> list = this.f3685g.get(obj);
            if (list != null) {
                for (String str : list) {
                    b(obj, str);
                }
                this.f3685g.remove(obj);
            } else {
                String str2 = f3680b;
                LogUtil.w(str2, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public synchronized void a(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            b(obj, str);
            List<String> list = this.f3685g.get(obj);
            if (list != null) {
                list.remove(str);
            }
            if (list != null && list.size() == 0) {
                this.f3685g.remove(obj);
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public void a(EventBus.Event event) {
        a aVar = this.f3687i.get();
        if (aVar.f3690a) {
            return;
        }
        aVar.f3691b = Looper.getMainLooper() == Looper.myLooper();
        aVar.f3690a = true;
        if (aVar.f3694e) {
            aVar.f3690a = false;
            if (f3679a) {
                Log.d(f3680b, "Event has already been cancelled");
                return;
            }
            return;
        }
        try {
            a(event, aVar);
        } finally {
            aVar.f3690a = false;
            aVar.f3691b = false;
        }
    }

    public void a(String str) {
        synchronized (this.f3681c) {
            this.f3681c.remove(str);
        }
    }

    public void a() {
        synchronized (this.f3681c) {
            this.f3681c.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.apollon.eventbus.EventBus$Event, com.baidu.apollon.eventbus.g] */
    private void a(EventBus.Event event, a aVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f3684f.get(event.mEventKey);
        }
        boolean z = false;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator<g> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                g next = it.next();
                aVar.f3693d = event;
                aVar.f3692c = next;
                try {
                    a(next, event, aVar.f3691b);
                    if (aVar.f3694e) {
                        break;
                    }
                } finally {
                    aVar.f3693d = null;
                    aVar.f3692c = null;
                    aVar.f3694e = false;
                }
            }
            z = true;
        }
        if (z || !f3679a) {
            return;
        }
        String str = f3680b;
        Log.d(str, "No subscribers registered for event " + event.mEventKey);
    }

    private void a(g gVar, EventBus.Event event, boolean z) {
        int i2 = AnonymousClass2.f3689a[gVar.f3708e.ordinal()];
        if (i2 == 1) {
            a(gVar, event);
        } else if (i2 == 2) {
            if (z) {
                a(gVar, event);
            } else {
                this.f3682d.a(gVar, event);
            }
        } else if (i2 == 3) {
            this.f3683e.a(gVar, event);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + gVar.f3708e);
        }
    }

    public void a(d dVar) {
        EventBus.Event event = dVar.f3699a;
        g gVar = dVar.f3700b;
        if (gVar.f3709f) {
            a(gVar, event);
        }
    }

    private void a(g gVar, EventBus.Event event) throws Error {
        try {
            gVar.f3705b.invoke(gVar.f3704a, event);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            String str = f3680b;
            Log.e(str, "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.f3704a.getClass(), cause);
        }
    }
}
