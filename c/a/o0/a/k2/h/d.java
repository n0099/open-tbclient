package c.a.o0.a.k2.h;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.util.Pair;
import c.a.o0.a.j2.c;
import c.a.o0.a.k;
import c.a.o0.a.v2.q;
import c.a.o0.t.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7128a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f7129b;

    /* renamed from: c  reason: collision with root package name */
    public static int f7130c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7131e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7132f;

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7131e = str;
            this.f7132f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(10010);
                bVar.l(String.valueOf(d.f7130c));
                bVar.k(this.f7131e);
                bVar.j(String.valueOf(this.f7132f));
                bVar.h(c.a.o0.a.a2.e.V());
                bVar.m();
                if (this.f7132f == 3) {
                    int unused = d.f7130c = 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.d.i.a<Pair<String, File>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
        @Override // c.a.o0.d.i.a
        /* renamed from: a */
        public void run(@NonNull Pair<String, File> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                if (d.f7129b != null && pair.first != null && d.f7129b.contains(pair.first)) {
                    new c.a.o0.a.k2.h.c(c.a.o0.a.c1.a.b(), pair.first).f();
                    return;
                }
                File file = pair.second;
                if (file != null) {
                    c.a.o0.t.d.K(file);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callable<SharedPreferences> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.k2.h.c f7133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7134f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7135g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7136h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f7137i;

        public c(d dVar, c.a.o0.a.k2.h.c cVar, long j2, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar, Long.valueOf(j2), context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7137i = dVar;
            this.f7133e = cVar;
            this.f7134f = j2;
            this.f7135g = context;
            this.f7136h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f7133e.setCustomMeta(this.f7134f | 1)) {
                    String l = this.f7137i.l(this.f7135g, this.f7136h);
                    if (d.f7128a) {
                        String.format("customMeta=%d, name=%s, spName=%s", Long.valueOf(this.f7134f), this.f7136h, l);
                    }
                    if (l == null) {
                        return null;
                    }
                    return this.f7135g.getSharedPreferences(l, 0);
                }
                return null;
            }
            return (SharedPreferences) invokeV.objValue;
        }
    }

    /* renamed from: c.a.o0.a.k2.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0280d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f7138a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-598757104, "Lc/a/o0/a/k2/h/d$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-598757104, "Lc/a/o0/a/k2/h/d$d;");
                    return;
                }
            }
            f7138a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-617382128, "Lc/a/o0/a/k2/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-617382128, "Lc/a/o0/a/k2/h/d;");
                return;
            }
        }
        f7128a = k.f7049a;
        f7129b = new CopyOnWriteArraySet();
        f7130c = 0;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    @AnyThread
    public static void i(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, str) == null) {
            q.e().execute(new a(str, i2));
        }
    }

    public static d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? C0280d.f7138a : (d) invokeV.objValue;
    }

    public final c.a.o0.t.b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new j(str) : (c.a.o0.t.b) invokeL.objValue;
    }

    public void g(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, set, z) == null) {
            h(str, set, z);
            c.a.o0.a.n0.e.c(new File(c.a.o0.a.k2.h.c.A()), str, ".kv", set, z, new b(this));
        }
    }

    public void h(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, set, z) == null) {
            c.a.o0.a.n0.e.b(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ActivityChooserModel.HISTORY_FILE_EXTENSION, set, z);
        }
    }

    @NonNull
    @AnyThread
    public c.a.o0.t.b k(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, context, str, z)) == null) {
            try {
                c.a.o0.a.k2.h.c cVar = new c.a.o0.a.k2.h.c(context, str, z ? 2 : 1);
                f7129b.add(str);
                m(context, str, cVar);
                if (f7130c > 0) {
                    i(3, str);
                }
                return cVar;
            } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                boolean z2 = f7128a;
                f7130c++;
                i(2, str);
                return f(str);
            }
        }
        return (c.a.o0.t.b) invokeLLZ.objValue;
    }

    @Nullable
    public final String l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            if (str == null) {
                str = context.getPackageName() + "_preferences";
            }
            if ("default".equals(str)) {
                if (j.f(context, str).exists()) {
                    return str;
                }
                str = context.getPackageName() + "_preferences";
            }
            if (j.f(context, str).exists()) {
                return str;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final void m(Context context, String str, @NonNull c.a.o0.a.k2.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, cVar) == null) {
            long customMeta = cVar.getCustomMeta();
            if ((customMeta & 1) == 1) {
                return;
            }
            cVar.z(new c(this, cVar, customMeta, context, str));
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
