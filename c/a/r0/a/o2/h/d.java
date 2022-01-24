package c.a.r0.a.o2.h;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.util.Pair;
import c.a.r0.a.k;
import c.a.r0.a.n2.c;
import c.a.r0.a.z2.q;
import c.a.r0.w.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
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
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f8235b;

    /* renamed from: c  reason: collision with root package name */
    public static int f8236c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8238f;

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
            this.f8237e = str;
            this.f8238f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.b bVar = new c.b(10010);
                bVar.l(String.valueOf(d.f8236c));
                bVar.k(this.f8237e);
                bVar.j(String.valueOf(this.f8238f));
                bVar.h(c.a.r0.a.d2.e.f0());
                bVar.m();
                if (this.f8238f == 3) {
                    int unused = d.f8236c = 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.d.i.a<Pair<String, File>> {
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
        @Override // c.a.r0.d.i.a
        /* renamed from: a */
        public void run(@NonNull Pair<String, File> pair) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pair) == null) {
                if (d.f8235b != null && pair.first != null && d.f8235b.contains(pair.first)) {
                    new c.a.r0.a.o2.h.c(c.a.r0.a.c1.a.c(), pair.first).clearAll();
                    return;
                }
                File file = pair.second;
                if (file != null) {
                    c.a.r0.w.d.L(file);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callable<SharedPreferences> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.o2.h.c f8239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f8240f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f8241g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8242h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f8243i;

        public c(d dVar, c.a.r0.a.o2.h.c cVar, long j2, Context context, String str) {
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
            this.f8243i = dVar;
            this.f8239e = cVar;
            this.f8240f = j2;
            this.f8241g = context;
            this.f8242h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public SharedPreferences call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f8239e.setCustomMeta(this.f8240f | 1)) {
                    String l = this.f8243i.l(this.f8241g, this.f8242h);
                    if (d.a) {
                        String.format("customMeta=%d, name=%s, spName=%s", Long.valueOf(this.f8240f), this.f8242h, l);
                    }
                    if (l == null) {
                        return null;
                    }
                    return this.f8241g.getSharedPreferences(l, 0);
                }
                return null;
            }
            return (SharedPreferences) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r0.a.o2.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0498d {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755316239, "Lc/a/r0/a/o2/h/d$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-755316239, "Lc/a/r0/a/o2/h/d$d;");
                    return;
                }
            }
            a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975086543, "Lc/a/r0/a/o2/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-975086543, "Lc/a/r0/a/o2/h/d;");
                return;
            }
        }
        a = k.a;
        f8235b = new CopyOnWriteArraySet();
        f8236c = 0;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    @AnyThread
    public static void i(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, str) == null) {
            q.f().execute(new a(str, i2));
        }
    }

    public static d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? C0498d.a : (d) invokeV.objValue;
    }

    public final c.a.r0.w.b f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new j(str) : (c.a.r0.w.b) invokeL.objValue;
    }

    public void g(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, set, z) == null) {
            h(str, set, z);
            c.a.r0.a.n0.e.c(new File(c.a.r0.a.o2.h.c.e()), str, SwanKV.PREFS_SUFFIX, set, z, new b(this));
        }
    }

    public void h(@NonNull String str, Set<String> set, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, set, z) == null) {
            c.a.r0.a.n0.e.b(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), str, ActivityChooserModel.HISTORY_FILE_EXTENSION, set, z);
        }
    }

    @NonNull
    @AnyThread
    public c.a.r0.w.b k(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, context, str, z)) == null) {
            try {
                c.a.r0.a.o2.h.c cVar = new c.a.r0.a.o2.h.c(context, str, z ? 2 : 1);
                f8235b.add(str);
                m(context, str, cVar);
                if (f8236c > 0) {
                    i(3, str);
                }
                return cVar;
            } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                boolean z2 = a;
                f8236c++;
                i(2, str);
                return f(str);
            }
        }
        return (c.a.r0.w.b) invokeLLZ.objValue;
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
                if (j.e(context, str).exists()) {
                    return str;
                }
                str = context.getPackageName() + "_preferences";
            }
            if (j.e(context, str).exists()) {
                return str;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final void m(Context context, String str, @NonNull c.a.r0.a.o2.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, cVar) == null) {
            long customMeta = cVar.getCustomMeta();
            if ((customMeta & 1) == 1) {
                return;
            }
            cVar.d(new c(this, cVar, customMeta, context, str));
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
