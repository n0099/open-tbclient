package com.baidu.ar.bus;

import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Object, List<Class<?>>> kq;
    public final Map<Class<?>, CopyOnWriteArrayList<g>> kr;
    public f ks;
    public b kt;
    public b ku;
    public Looper kv;

    /* renamed from: com.baidu.ar.bus.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] kw;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-450876468, "Lcom/baidu/ar/bus/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-450876468, "Lcom/baidu/ar/bus/a$1;");
                    return;
                }
            }
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
                return;
            }
        }
        this.kr = new HashMap();
        this.kq = new HashMap();
        this.ks = new f();
        this.kt = new b(this, Looper.getMainLooper(), 10);
    }

    private void a(g gVar, Object obj) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, gVar, obj) == null) {
            int i2 = AnonymousClass1.kw[gVar.kW.kJ.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
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
    }

    private void a(Object obj, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, obj, eVar) == null) {
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
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, obj, cls) == null) || (copyOnWriteArrayList = this.kr.get(cls)) == null) {
            return;
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (i2 < size) {
            g gVar = copyOnWriteArrayList.get(i2);
            if (gVar.kV == obj) {
                gVar.kX = false;
                copyOnWriteArrayList.remove(i2);
                i2--;
                size--;
            }
            i2++;
        }
    }

    private boolean b(Object obj, Class<?> cls) {
        InterceptResult invokeLL;
        CopyOnWriteArrayList<g> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj, cls)) == null) {
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
        return invokeLL.booleanValue;
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            Object obj = cVar.kD;
            g gVar = cVar.kE;
            c.b(cVar);
            if (gVar.kX) {
                b(gVar, obj);
            }
        }
    }

    public void b(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, looper) == null) {
            b bVar = this.ku;
            if (bVar != null) {
                bVar.release();
            }
            this.kv = looper;
            this.ku = new b(this, looper, 10);
        }
    }

    public void b(g gVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, obj) == null) {
            try {
                gVar.kW.kI.invoke(gVar.kV, obj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean cG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Looper looper = this.kv;
            return looper != null && looper == Looper.myLooper();
        }
        return invokeV.booleanValue;
    }

    public void d(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            List<e> a2 = this.ks.a(obj.getClass());
            synchronized (this) {
                for (e eVar : a2) {
                    a(obj, eVar);
                }
            }
        }
    }

    public synchronized void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            synchronized (this) {
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
        }
    }

    public void f(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, obj) == null) || obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (b(obj, cls)) {
            return;
        }
        com.baidu.ar.h.b.aS("No subscribers registered for event " + cls);
    }

    public boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }
}
