package c.a.w.e.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class e implements c.a.w.e.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f30429a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.w.e.c.a f30430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f30431f;

        public a(e eVar, c.a.w.e.c.a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30430e = aVar;
            this.f30431f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30430e.call(this.f30431f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.w.e.c.a f30432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f30433f;

        public b(e eVar, c.a.w.e.c.a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30432e = aVar;
            this.f30433f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30432e.call(this.f30433f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.w.e.c.a f30434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f30435f;

        public c(e eVar, c.a.w.e.c.a aVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30434e = aVar;
            this.f30435f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f30434e.call(this.f30435f);
            }
        }
    }

    public e() {
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
        this.f30429a = new Handler(Looper.getMainLooper());
    }

    @Override // c.a.w.e.c.c
    public void a(int i2, Object obj, c.a.w.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, aVar) == null) {
            if (i2 == 2) {
                if (b()) {
                    aVar.call(obj);
                } else {
                    this.f30429a.post(new a(this, aVar, obj));
                }
            } else if (i2 != 3) {
                if (i2 != 4) {
                    aVar.call(obj);
                } else {
                    c.a.w.e.f.a.a(new c(this, aVar, obj));
                }
            } else if (b()) {
                c.a.w.e.f.a.a(new b(this, aVar, obj));
            } else {
                aVar.call(obj);
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public synchronized void c(WeakHashMap<Object, List<c.a.w.e.c.b>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, weakHashMap, obj) == null) {
            synchronized (this) {
                for (Map.Entry<Object, List<c.a.w.e.c.b>> entry : weakHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        for (c.a.w.e.c.b bVar : entry.getValue()) {
                            if (bVar.c(obj)) {
                                bVar.a(obj);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(WeakHashMap<Object, List<c.a.w.e.c.b>> weakHashMap, Object obj, Class<?> cls, int i2, c.a.w.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{weakHashMap, obj, cls, Integer.valueOf(i2), aVar}) == null) {
            synchronized (this) {
                List<c.a.w.e.c.b> list = weakHashMap.containsKey(obj) ? weakHashMap.get(obj) : null;
                if (list == null) {
                    list = new ArrayList<>();
                    weakHashMap.put(obj, list);
                }
                list.add(new c.a.w.e.c.b(i2, cls, aVar, this));
            }
        }
    }

    public void e(WeakHashMap<Object, List<c.a.w.e.c.b>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, weakHashMap, obj) == null) {
            List<c.a.w.e.c.b> remove = weakHashMap.remove(obj);
            if (!c.a.w.e.g.d.c(remove)) {
                for (c.a.w.e.c.b bVar : remove) {
                    bVar.b();
                }
            }
            remove.clear();
        }
    }
}
