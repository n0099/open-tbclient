package c.a.x.g.c;

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
/* loaded from: classes9.dex */
public class e implements c.a.x.g.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.x.g.c.a f26691e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f26692f;

        public a(e eVar, c.a.x.g.c.a aVar, Object obj) {
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
            this.f26691e = aVar;
            this.f26692f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26691e.call(this.f26692f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.x.g.c.a f26693e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f26694f;

        public b(e eVar, c.a.x.g.c.a aVar, Object obj) {
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
            this.f26693e = aVar;
            this.f26694f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26693e.call(this.f26694f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.x.g.c.a f26695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f26696f;

        public c(e eVar, c.a.x.g.c.a aVar, Object obj) {
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
            this.f26695e = aVar;
            this.f26696f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26695e.call(this.f26696f);
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
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override // c.a.x.g.c.c
    public void a(int i2, Object obj, c.a.x.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, aVar) == null) {
            if (i2 == 2) {
                if (b()) {
                    aVar.call(obj);
                } else {
                    this.a.post(new a(this, aVar, obj));
                }
            } else if (i2 != 3) {
                if (i2 != 4) {
                    aVar.call(obj);
                } else {
                    c.a.x.g.f.a.a(new c(this, aVar, obj));
                }
            } else if (b()) {
                c.a.x.g.f.a.a(new b(this, aVar, obj));
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

    public synchronized void c(WeakHashMap<Object, List<c.a.x.g.c.b>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, weakHashMap, obj) == null) {
            synchronized (this) {
                for (Map.Entry<Object, List<c.a.x.g.c.b>> entry : weakHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        for (c.a.x.g.c.b bVar : entry.getValue()) {
                            if (bVar.b(obj)) {
                                bVar.call(obj);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(WeakHashMap<Object, List<c.a.x.g.c.b>> weakHashMap, Object obj, Class<?> cls, int i2, c.a.x.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{weakHashMap, obj, cls, Integer.valueOf(i2), aVar}) == null) {
            synchronized (this) {
                List<c.a.x.g.c.b> list = weakHashMap.containsKey(obj) ? weakHashMap.get(obj) : null;
                if (list == null) {
                    list = new ArrayList<>();
                    weakHashMap.put(obj, list);
                }
                list.add(new c.a.x.g.c.b(i2, cls, aVar, this));
            }
        }
    }

    public void e(WeakHashMap<Object, List<c.a.x.g.c.b>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, weakHashMap, obj) == null) {
            List<c.a.x.g.c.b> remove = weakHashMap.remove(obj);
            if (!c.a.x.g.g.d.c(remove)) {
                for (c.a.x.g.c.b bVar : remove) {
                    bVar.a();
                }
            }
            remove.clear();
        }
    }
}
