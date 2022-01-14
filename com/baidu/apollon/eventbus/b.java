package com.baidu.apollon.eventbus;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f32420b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, EventBus.Event> f32421c;

    /* renamed from: d  reason: collision with root package name */
    public final c f32422d;

    /* renamed from: e  reason: collision with root package name */
    public final com.baidu.apollon.eventbus.a f32423e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f32424f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, List<String>> f32425g;

    /* renamed from: h  reason: collision with root package name */
    public final f f32426h;

    /* renamed from: i  reason: collision with root package name */
    public final ThreadLocal<a> f32427i;

    /* renamed from: com.baidu.apollon.eventbus.b$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394041930, "Lcom/baidu/apollon/eventbus/b$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-394041930, "Lcom/baidu/apollon/eventbus/b$2;");
                    return;
                }
            }
            int[] iArr = new int[EventBus.ThreadMode.values().length];
            a = iArr;
            try {
                iArr[EventBus.ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EventBus.ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EventBus.ThreadMode.Async.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f32428b;

        /* renamed from: c  reason: collision with root package name */
        public g f32429c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f32430d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32431e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1631693116, "Lcom/baidu/apollon/eventbus/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1631693116, "Lcom/baidu/apollon/eventbus/b;");
                return;
            }
        }
        a = ApollonConstants.DEBUG;
        f32420b = b.class.getSimpleName();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32427i = new ThreadLocal<a>(this) { // from class: com.baidu.apollon.eventbus.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public a initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new a() : (a) invokeV.objValue;
            }
        };
        this.f32424f = new HashMap();
        this.f32425g = new HashMap();
        this.f32421c = new ConcurrentHashMap();
        this.f32422d = new c(this, Looper.getMainLooper(), 10);
        this.f32423e = new com.baidu.apollon.eventbus.a(this);
        this.f32426h = new f();
    }

    private void b(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, obj, str) == null) || (copyOnWriteArrayList = this.f32424f.get(str)) == null) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = copyOnWriteArrayList.get(i2);
            if (gVar.a == obj) {
                gVar.f32441f = false;
                copyOnWriteArrayList.remove(i2);
                i2--;
                size--;
            }
            i2++;
        }
    }

    public synchronized void a(Object obj, String[] strArr, int i2, boolean z, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{obj, strArr, Integer.valueOf(i2), Boolean.valueOf(z), threadMode}) == null) {
            synchronized (this) {
                a(obj, this.f32426h.a(obj.getClass()), z, i2, strArr, threadMode);
            }
        }
    }

    public void c(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, event) == null) {
            a aVar = this.f32427i.get();
            if (!aVar.a) {
                throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
            }
            if (event != null) {
                if (aVar.f32430d == event) {
                    aVar.f32431e = true;
                    return;
                }
                throw new EventBusException("Only the currently handled event may be aborted");
            }
            throw new EventBusException("Event may not be null");
        }
    }

    public synchronized void a(Object obj, String str, int i2, boolean z, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{obj, str, Integer.valueOf(i2), Boolean.valueOf(z), threadMode}) == null) {
            synchronized (this) {
                a(obj, this.f32426h.a(obj.getClass()), z, i2, str, threadMode);
            }
        }
    }

    private void a(Object obj, Method method, boolean z, int i2, String[] strArr, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), strArr, threadMode}) == null) {
            for (String str : strArr) {
                a(obj, method, z, i2, str, threadMode);
            }
        }
    }

    public void b(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) {
            synchronized (this.f32421c) {
                this.f32421c.put(event.mEventKey, event);
            }
            a(event);
        }
    }

    private void a(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), str, threadMode}) == null) {
            CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f32424f.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f32424f.put(str, copyOnWriteArrayList);
            } else {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().a.equals(obj)) {
                        if (a) {
                            String str2 = "Subscriber " + obj.getClass() + " already registered to event " + str;
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
                    if (i3 == size || gVar.f32438c > copyOnWriteArrayList.get(i3).f32438c) {
                        copyOnWriteArrayList.add(i3, gVar);
                        break;
                    }
                }
            } else {
                copyOnWriteArrayList.add(gVar);
            }
            List<String> list = this.f32425g.get(obj);
            if (list == null) {
                list = new ArrayList<>();
                this.f32425g.put(obj, list);
            }
            list.add(str);
            if (z) {
                synchronized (this.f32421c) {
                    event = this.f32421c.get(str);
                }
                if (event != null) {
                    a(gVar, event, Looper.getMainLooper() == Looper.myLooper());
                }
            }
        }
    }

    public synchronized void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            synchronized (this) {
                if (obj != null) {
                    List<String> list = this.f32425g.get(obj);
                    if (list != null) {
                        for (String str : list) {
                            b(obj, str);
                        }
                        this.f32425g.remove(obj);
                    } else {
                        String str2 = f32420b;
                        LogUtil.w(str2, "Subscriber to unregister was not registered before: " + obj.getClass());
                    }
                } else {
                    throw new IllegalArgumentException("Provide at least one event class");
                }
            }
        }
    }

    public synchronized void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, obj, str) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str)) {
                    b(obj, str);
                    List<String> list = this.f32425g.get(obj);
                    if (list != null) {
                        list.remove(str);
                    }
                    if (list != null && list.size() == 0) {
                        this.f32425g.remove(obj);
                    }
                } else {
                    throw new IllegalArgumentException("Provide at least one event class");
                }
            }
        }
    }

    public void a(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            a aVar = this.f32427i.get();
            if (aVar.a) {
                return;
            }
            aVar.f32428b = Looper.getMainLooper() == Looper.myLooper();
            aVar.a = true;
            if (aVar.f32431e) {
                aVar.a = false;
                boolean z = a;
                return;
            }
            try {
                a(event, aVar);
            } finally {
                aVar.a = false;
                aVar.f32428b = false;
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            synchronized (this.f32421c) {
                this.f32421c.remove(str);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f32421c) {
                this.f32421c.clear();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.baidu.apollon.eventbus.EventBus$Event, com.baidu.apollon.eventbus.g] */
    private void a(EventBus.Event event, a aVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, event, aVar) == null) {
            synchronized (this) {
                copyOnWriteArrayList = this.f32424f.get(event.mEventKey);
            }
            boolean z = false;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    aVar.f32430d = event;
                    aVar.f32429c = next;
                    try {
                        a(next, event, aVar.f32428b);
                        if (aVar.f32431e) {
                            break;
                        }
                    } finally {
                        aVar.f32430d = null;
                        aVar.f32429c = null;
                        aVar.f32431e = false;
                    }
                }
                z = true;
            }
            if (z || !a) {
                return;
            }
            String str = "No subscribers registered for event " + event.mEventKey;
        }
    }

    private void a(g gVar, EventBus.Event event, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, gVar, event, z) == null) {
            int i2 = AnonymousClass2.a[gVar.f32440e.ordinal()];
            if (i2 == 1) {
                a(gVar, event);
            } else if (i2 == 2) {
                if (z) {
                    a(gVar, event);
                } else {
                    this.f32422d.a(gVar, event);
                }
            } else if (i2 == 3) {
                this.f32423e.a(gVar, event);
            } else {
                throw new IllegalStateException("Unknown thread mode: " + gVar.f32440e);
            }
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            EventBus.Event event = dVar.a;
            g gVar = dVar.f32435b;
            if (gVar.f32441f) {
                a(gVar, event);
            }
        }
    }

    private void a(g gVar, EventBus.Event event) throws Error {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, gVar, event) == null) {
            try {
                gVar.f32437b.invoke(gVar.a, event);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Unexpected exception", e2);
            } catch (InvocationTargetException e3) {
                e3.getCause();
                String str = "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.a.getClass();
            }
        }
    }
}
