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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f32125h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f32126i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, EventBus.Event> f32127a;

    /* renamed from: b  reason: collision with root package name */
    public final c.f.a.c.c f32128b;

    /* renamed from: c  reason: collision with root package name */
    public final c.f.a.c.a f32129c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f32130d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Object, List<String>> f32131e;

    /* renamed from: f  reason: collision with root package name */
    public final f f32132f;

    /* renamed from: g  reason: collision with root package name */
    public final ThreadLocal<c> f32133g;

    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1465b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32134a;
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
            f32134a = iArr;
            try {
                iArr[EventBus.ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32134a[EventBus.ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32134a[EventBus.ThreadMode.Async.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f32135a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f32136b;

        /* renamed from: c  reason: collision with root package name */
        public g f32137c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f32138d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32139e;

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
        f32125h = ApollonConstants.DEBUG;
        f32126i = b.class.getSimpleName();
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
        this.f32133g = new a(this);
        this.f32130d = new HashMap();
        this.f32131e = new HashMap();
        this.f32127a = new ConcurrentHashMap();
        this.f32128b = new c.f.a.c.c(this, Looper.getMainLooper(), 10);
        this.f32129c = new c.f.a.c.a(this);
        this.f32132f = new f();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f32127a) {
                this.f32127a.clear();
            }
        }
    }

    public void b(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            c cVar = this.f32133g.get();
            if (cVar.f32135a) {
                return;
            }
            cVar.f32136b = Looper.getMainLooper() == Looper.myLooper();
            cVar.f32135a = true;
            if (cVar.f32139e) {
                cVar.f32135a = false;
                boolean z = f32125h;
                return;
            }
            try {
                c(event, cVar);
            } finally {
                cVar.f32135a = false;
                cVar.f32136b = false;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [c.f.a.c.g, com.dxmpay.apollon.eventbus.EventBus$Event] */
    public final void c(EventBus.Event event, c cVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, event, cVar) == null) {
            synchronized (this) {
                copyOnWriteArrayList = this.f32130d.get(event.mEventKey);
            }
            boolean z = false;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    cVar.f32138d = event;
                    cVar.f32137c = next;
                    try {
                        f(next, event, cVar.f32136b);
                        if (cVar.f32139e) {
                            break;
                        }
                    } finally {
                        cVar.f32138d = null;
                        cVar.f32137c = null;
                        cVar.f32139e = false;
                    }
                }
                z = true;
            }
            if (z || !f32125h) {
                return;
            }
            String str = "No subscribers registered for event " + event.mEventKey;
        }
    }

    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            EventBus.Event event = dVar.f32144a;
            g gVar = dVar.f32145b;
            if (gVar.f32152e) {
                e(gVar, event);
            }
        }
    }

    public final void e(g gVar, EventBus.Event event) throws Error {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, gVar, event) == null) {
            try {
                gVar.f32149b.invoke(gVar.f32148a, event);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Unexpected exception", e2);
            } catch (InvocationTargetException e3) {
                e3.getCause();
                String str = "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.f32148a.getClass();
            }
        }
    }

    public final void f(g gVar, EventBus.Event event, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, gVar, event, z) == null) {
            int i2 = C1465b.f32134a[gVar.f32151d.ordinal()];
            if (i2 == 1) {
                e(gVar, event);
            } else if (i2 == 2) {
                if (z) {
                    e(gVar, event);
                } else {
                    this.f32128b.a(gVar, event);
                }
            } else if (i2 == 3) {
                this.f32129c.a(gVar, event);
            } else {
                throw new IllegalStateException("Unknown thread mode: " + gVar.f32151d);
            }
        }
    }

    public synchronized void g(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            synchronized (this) {
                if (obj != null) {
                    List<String> list = this.f32131e.get(obj);
                    if (list != null) {
                        for (String str : list) {
                            o(obj, str);
                        }
                        this.f32131e.remove(obj);
                    } else {
                        String str2 = f32126i;
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
                    List<String> list = this.f32131e.get(obj);
                    if (list != null) {
                        list.remove(str);
                    }
                    if (list != null && list.size() == 0) {
                        this.f32131e.remove(obj);
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
                j(obj, this.f32132f.a(obj.getClass()), z, i2, str, threadMode);
            }
        }
    }

    public final void j(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), str, threadMode}) == null) {
            CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f32130d.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f32130d.put(str, copyOnWriteArrayList);
            } else {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().f32148a.equals(obj)) {
                        if (f32125h) {
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
                    if (i3 == size || gVar.f32150c > copyOnWriteArrayList.get(i3).f32150c) {
                        copyOnWriteArrayList.add(i3, gVar);
                        break;
                    }
                }
            } else {
                copyOnWriteArrayList.add(gVar);
            }
            List<String> list = this.f32131e.get(obj);
            if (list == null) {
                list = new ArrayList<>();
                this.f32131e.put(obj, list);
            }
            list.add(str);
            if (z) {
                synchronized (this.f32127a) {
                    event = this.f32127a.get(str);
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
                k(obj, this.f32132f.a(obj.getClass()), z, i2, strArr, threadMode);
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            synchronized (this.f32127a) {
                this.f32127a.remove(str);
            }
        }
    }

    public void n(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, event) == null) {
            synchronized (this.f32127a) {
                this.f32127a.put(event.mEventKey, event);
            }
            b(event);
        }
    }

    public final void o(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, obj, str) == null) || (copyOnWriteArrayList = this.f32130d.get(str)) == null) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = copyOnWriteArrayList.get(i2);
            if (gVar.f32148a == obj) {
                gVar.f32152e = false;
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
            c cVar = this.f32133g.get();
            if (!cVar.f32135a) {
                throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
            }
            if (event != null) {
                if (cVar.f32138d == event) {
                    cVar.f32139e = true;
                    return;
                }
                throw new EventBusException("Only the currently handled event may be aborted");
            }
            throw new EventBusException("Event may not be null");
        }
    }
}
