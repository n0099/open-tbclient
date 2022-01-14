package c.f.a.c;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.eventbus.EventBusException;
import com.dxmpay.apollon.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f28071h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f28072i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, EventBus.Event> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.f.a.c.c f28073b;

    /* renamed from: c  reason: collision with root package name */
    public final c.f.a.c.a f28074c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f28075d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Object, List<String>> f28076e;

    /* renamed from: f  reason: collision with root package name */
    public final f f28077f;

    /* renamed from: g  reason: collision with root package name */
    public final ThreadLocal<c> f28078g;

    /* loaded from: classes9.dex */
    public class a extends ThreadLocal<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public c initialValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c() : (c) invokeV.objValue;
        }
    }

    /* renamed from: c.f.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1635b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1790131766, "Lc/f/a/c/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1790131766, "Lc/f/a/c/b$b;");
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

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28079b;

        /* renamed from: c  reason: collision with root package name */
        public g f28080c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f28081d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28082e;

        public c() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1490872972, "Lc/f/a/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1490872972, "Lc/f/a/c/b;");
                return;
            }
        }
        f28071h = ApollonConstants.DEBUG;
        f28072i = b.class.getSimpleName();
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
        this.f28078g = new a(this);
        this.f28075d = new HashMap();
        this.f28076e = new HashMap();
        this.a = new ConcurrentHashMap();
        this.f28073b = new c.f.a.c.c(this, Looper.getMainLooper(), 10);
        this.f28074c = new c.f.a.c.a(this);
        this.f28077f = new f();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.a) {
                this.a.clear();
            }
        }
    }

    public void b(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            c cVar = this.f28078g.get();
            if (cVar.a) {
                return;
            }
            cVar.f28079b = Looper.getMainLooper() == Looper.myLooper();
            cVar.a = true;
            if (cVar.f28082e) {
                cVar.a = false;
                boolean z = f28071h;
                return;
            }
            try {
                c(event, cVar);
            } finally {
                cVar.a = false;
                cVar.f28079b = false;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [c.f.a.c.g, com.dxmpay.apollon.eventbus.EventBus$Event] */
    public final void c(EventBus.Event event, c cVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, event, cVar) == null) {
            synchronized (this) {
                copyOnWriteArrayList = this.f28075d.get(event.mEventKey);
            }
            boolean z = false;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    cVar.f28081d = event;
                    cVar.f28080c = next;
                    try {
                        f(next, event, cVar.f28079b);
                        if (cVar.f28082e) {
                            break;
                        }
                    } finally {
                        cVar.f28081d = null;
                        cVar.f28080c = null;
                        cVar.f28082e = false;
                    }
                }
                z = true;
            }
            if (z || !f28071h) {
                return;
            }
            String str = "No subscribers registered for event " + event.mEventKey;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            EventBus.Event event = dVar.a;
            g gVar = dVar.f28086b;
            if (gVar.f28090e) {
                e(gVar, event);
            }
        }
    }

    public final void e(g gVar, EventBus.Event event) throws Error {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, event) == null) {
            try {
                gVar.f28087b.invoke(gVar.a, event);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Unexpected exception", e2);
            } catch (InvocationTargetException e3) {
                e3.getCause();
                String str = "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.a.getClass();
            }
        }
    }

    public final void f(g gVar, EventBus.Event event, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, gVar, event, z) == null) {
            int i2 = C1635b.a[gVar.f28089d.ordinal()];
            if (i2 == 1) {
                e(gVar, event);
            } else if (i2 == 2) {
                if (z) {
                    e(gVar, event);
                } else {
                    this.f28073b.a(gVar, event);
                }
            } else if (i2 == 3) {
                this.f28074c.a(gVar, event);
            } else {
                throw new IllegalStateException("Unknown thread mode: " + gVar.f28089d);
            }
        }
    }

    public synchronized void g(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            synchronized (this) {
                if (obj != null) {
                    List<String> list = this.f28076e.get(obj);
                    if (list != null) {
                        for (String str : list) {
                            o(obj, str);
                        }
                        this.f28076e.remove(obj);
                    } else {
                        String str2 = f28072i;
                        LogUtil.w(str2, "Subscriber to unregister was not registered before: " + obj.getClass());
                    }
                } else {
                    throw new IllegalArgumentException("Provide at least one event class");
                }
            }
        }
    }

    public synchronized void h(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, obj, str) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str)) {
                    o(obj, str);
                    List<String> list = this.f28076e.get(obj);
                    if (list != null) {
                        list.remove(str);
                    }
                    if (list != null && list.size() == 0) {
                        this.f28076e.remove(obj);
                    }
                } else {
                    throw new IllegalArgumentException("Provide at least one event class");
                }
            }
        }
    }

    public synchronized void i(Object obj, String str, int i2, boolean z, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{obj, str, Integer.valueOf(i2), Boolean.valueOf(z), threadMode}) == null) {
            synchronized (this) {
                j(obj, this.f28077f.a(obj.getClass()), z, i2, str, threadMode);
            }
        }
    }

    public final void j(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), str, threadMode}) == null) {
            CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f28075d.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f28075d.put(str, copyOnWriteArrayList);
            } else {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().a.equals(obj)) {
                        if (f28071h) {
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
                    if (i3 == size || gVar.f28088c > copyOnWriteArrayList.get(i3).f28088c) {
                        copyOnWriteArrayList.add(i3, gVar);
                        break;
                    }
                }
            } else {
                copyOnWriteArrayList.add(gVar);
            }
            List<String> list = this.f28076e.get(obj);
            if (list == null) {
                list = new ArrayList<>();
                this.f28076e.put(obj, list);
            }
            list.add(str);
            if (z) {
                synchronized (this.a) {
                    event = this.a.get(str);
                }
                if (event != null) {
                    f(gVar, event, Looper.getMainLooper() == Looper.myLooper());
                }
            }
        }
    }

    public final void k(Object obj, Method method, boolean z, int i2, String[] strArr, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), strArr, threadMode}) == null) {
            for (String str : strArr) {
                j(obj, method, z, i2, str, threadMode);
            }
        }
    }

    public synchronized void l(Object obj, String[] strArr, int i2, boolean z, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{obj, strArr, Integer.valueOf(i2), Boolean.valueOf(z), threadMode}) == null) {
            synchronized (this) {
                k(obj, this.f28077f.a(obj.getClass()), z, i2, strArr, threadMode);
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            synchronized (this.a) {
                this.a.remove(str);
            }
        }
    }

    public void n(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, event) == null) {
            synchronized (this.a) {
                this.a.put(event.mEventKey, event);
            }
            b(event);
        }
    }

    public final void o(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, obj, str) == null) || (copyOnWriteArrayList = this.f28075d.get(str)) == null) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = copyOnWriteArrayList.get(i2);
            if (gVar.a == obj) {
                gVar.f28090e = false;
                copyOnWriteArrayList.remove(i2);
                i2--;
                size--;
            }
            i2++;
        }
    }

    public void p(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, event) == null) {
            c cVar = this.f28078g.get();
            if (!cVar.a) {
                throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
            }
            if (event != null) {
                if (cVar.f28081d == event) {
                    cVar.f28082e = true;
                    return;
                }
                throw new EventBusException("Only the currently handled event may be aborted");
            }
            throw new EventBusException("Event may not be null");
        }
    }
}
