package com.baidu.apollon.eventbus;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f37744a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f37745b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, EventBus.Event> f37746c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37747d;

    /* renamed from: e  reason: collision with root package name */
    public final com.baidu.apollon.eventbus.a f37748e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<g>> f37749f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, List<String>> f37750g;

    /* renamed from: h  reason: collision with root package name */
    public final f f37751h;

    /* renamed from: i  reason: collision with root package name */
    public final ThreadLocal<a> f37752i;

    /* renamed from: com.baidu.apollon.eventbus.b$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37754a;
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
            f37754a = iArr;
            try {
                iArr[EventBus.ThreadMode.PostThread.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37754a[EventBus.ThreadMode.MainThread.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37754a[EventBus.ThreadMode.Async.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f37755a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37756b;

        /* renamed from: c  reason: collision with root package name */
        public g f37757c;

        /* renamed from: d  reason: collision with root package name */
        public EventBus.Event f37758d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37759e;

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
        f37744a = ApollonConstants.DEBUG;
        f37745b = b.class.getSimpleName();
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
        this.f37752i = new ThreadLocal<a>(this) { // from class: com.baidu.apollon.eventbus.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37753a;

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
                this.f37753a = this;
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
        this.f37749f = new HashMap();
        this.f37750g = new HashMap();
        this.f37746c = new ConcurrentHashMap();
        this.f37747d = new c(this, Looper.getMainLooper(), 10);
        this.f37748e = new com.baidu.apollon.eventbus.a(this);
        this.f37751h = new f();
    }

    private void b(Object obj, String str) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, obj, str) == null) || (copyOnWriteArrayList = this.f37749f.get(str)) == null) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = copyOnWriteArrayList.get(i2);
            if (gVar.f37769a == obj) {
                gVar.f37774f = false;
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
                a(obj, this.f37751h.a(obj.getClass()), z, i2, strArr, threadMode);
            }
        }
    }

    public void c(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, event) == null) {
            a aVar = this.f37752i.get();
            if (!aVar.f37755a) {
                throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
            }
            if (event != null) {
                if (aVar.f37758d == event) {
                    aVar.f37759e = true;
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
                a(obj, this.f37751h.a(obj.getClass()), z, i2, str, threadMode);
            }
        }
    }

    private void a(Object obj, Method method, boolean z, int i2, String[] strArr, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), strArr, threadMode}) == null) {
            for (String str : strArr) {
                a(obj, method, z, i2, str, threadMode);
            }
        }
    }

    public void b(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) {
            synchronized (this.f37746c) {
                this.f37746c.put(event.mEventKey, event);
            }
            a(event);
        }
    }

    private void a(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{obj, method, Boolean.valueOf(z), Integer.valueOf(i2), str, threadMode}) == null) {
            CopyOnWriteArrayList<g> copyOnWriteArrayList = this.f37749f.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f37749f.put(str, copyOnWriteArrayList);
            } else {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().f37769a.equals(obj)) {
                        if (f37744a) {
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
                    if (i3 == size || gVar.f37771c > copyOnWriteArrayList.get(i3).f37771c) {
                        copyOnWriteArrayList.add(i3, gVar);
                        break;
                    }
                }
            } else {
                copyOnWriteArrayList.add(gVar);
            }
            List<String> list = this.f37750g.get(obj);
            if (list == null) {
                list = new ArrayList<>();
                this.f37750g.put(obj, list);
            }
            list.add(str);
            if (z) {
                synchronized (this.f37746c) {
                    event = this.f37746c.get(str);
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
                    List<String> list = this.f37750g.get(obj);
                    if (list != null) {
                        for (String str : list) {
                            b(obj, str);
                        }
                        this.f37750g.remove(obj);
                    } else {
                        String str2 = f37745b;
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
                    List<String> list = this.f37750g.get(obj);
                    if (list != null) {
                        list.remove(str);
                    }
                    if (list != null && list.size() == 0) {
                        this.f37750g.remove(obj);
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
            a aVar = this.f37752i.get();
            if (aVar.f37755a) {
                return;
            }
            aVar.f37756b = Looper.getMainLooper() == Looper.myLooper();
            aVar.f37755a = true;
            if (aVar.f37759e) {
                aVar.f37755a = false;
                boolean z = f37744a;
                return;
            }
            try {
                a(event, aVar);
            } finally {
                aVar.f37755a = false;
                aVar.f37756b = false;
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            synchronized (this.f37746c) {
                this.f37746c.remove(str);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f37746c) {
                this.f37746c.clear();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.baidu.apollon.eventbus.EventBus$Event, com.baidu.apollon.eventbus.g] */
    private void a(EventBus.Event event, a aVar) throws Error {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, event, aVar) == null) {
            synchronized (this) {
                copyOnWriteArrayList = this.f37749f.get(event.mEventKey);
            }
            boolean z = false;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<g> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    aVar.f37758d = event;
                    aVar.f37757c = next;
                    try {
                        a(next, event, aVar.f37756b);
                        if (aVar.f37759e) {
                            break;
                        }
                    } finally {
                        aVar.f37758d = null;
                        aVar.f37757c = null;
                        aVar.f37759e = false;
                    }
                }
                z = true;
            }
            if (z || !f37744a) {
                return;
            }
            String str = "No subscribers registered for event " + event.mEventKey;
        }
    }

    private void a(g gVar, EventBus.Event event, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, gVar, event, z) == null) {
            int i2 = AnonymousClass2.f37754a[gVar.f37773e.ordinal()];
            if (i2 == 1) {
                a(gVar, event);
            } else if (i2 == 2) {
                if (z) {
                    a(gVar, event);
                } else {
                    this.f37747d.a(gVar, event);
                }
            } else if (i2 == 3) {
                this.f37748e.a(gVar, event);
            } else {
                throw new IllegalStateException("Unknown thread mode: " + gVar.f37773e);
            }
        }
    }

    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            EventBus.Event event = dVar.f37764a;
            g gVar = dVar.f37765b;
            if (gVar.f37774f) {
                a(gVar, event);
            }
        }
    }

    private void a(g gVar, EventBus.Event event) throws Error {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, gVar, event) == null) {
            try {
                gVar.f37770b.invoke(gVar.f37769a, event);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Unexpected exception", e2);
            } catch (InvocationTargetException e3) {
                e3.getCause();
                String str = "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.f37769a.getClass();
            }
        }
    }
}
