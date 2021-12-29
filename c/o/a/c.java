package c.o.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Map<String, Integer> f31175g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f31176h;

    /* renamed from: i  reason: collision with root package name */
    public static int f31177i;

    /* renamed from: j  reason: collision with root package name */
    public static int f31178j;

    /* renamed from: k  reason: collision with root package name */
    public static final Object f31179k;
    public static final Object l;
    public static String m;
    public static int n;
    public static HandlerThread o;
    public static Handler p;
    @SuppressLint({"UseSparseArrays"})
    public static final Map<Integer, c.o.a.a> q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f31180e;

    /* renamed from: f  reason: collision with root package name */
    public MethodChannel f31181f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodCall f31182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f31183f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31184g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f31185h;

        public a(c cVar, MethodCall methodCall, i iVar, c.o.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, methodCall, iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31185h = cVar;
            this.f31182e = methodCall;
            this.f31183f = iVar;
            this.f31184g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31185h.query(this.f31184g, new c.o.a.f.e(this.f31182e, this.f31183f));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodCall f31186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f31187f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31188g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f31189h;

        public b(c cVar, MethodCall methodCall, i iVar, c.o.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, methodCall, iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31189h = cVar;
            this.f31186e = methodCall;
            this.f31187f = iVar;
            this.f31188g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.o.a.f.e eVar = new c.o.a.f.e(this.f31186e, this.f31187f);
                boolean d2 = eVar.d();
                boolean f2 = eVar.f();
                ArrayList arrayList = new ArrayList();
                for (Map map : (List) this.f31186e.argument("operations")) {
                    c.o.a.f.c cVar = new c.o.a.f.c(map, d2);
                    String j2 = cVar.j();
                    char c2 = 65535;
                    switch (j2.hashCode()) {
                        case -1319569547:
                            if (j2.equals("execute")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1183792455:
                            if (j2.equals("insert")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -838846263:
                            if (j2.equals("update")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 107944136:
                            if (j2.equals("query")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                if (c2 == 3) {
                                    if (this.f31189h.update(this.f31188g, cVar)) {
                                        cVar.o(arrayList);
                                    } else if (f2) {
                                        cVar.n(arrayList);
                                    } else {
                                        cVar.m(this.f31187f);
                                        return;
                                    }
                                } else {
                                    i iVar = this.f31187f;
                                    iVar.error("bad_param", "Batch method '" + j2 + "' not supported", null);
                                    return;
                                }
                            } else if (this.f31189h.query(this.f31188g, cVar)) {
                                cVar.o(arrayList);
                            } else if (f2) {
                                cVar.n(arrayList);
                            } else {
                                cVar.m(this.f31187f);
                                return;
                            }
                        } else if (this.f31189h.insert(this.f31188g, cVar)) {
                            cVar.o(arrayList);
                        } else if (f2) {
                            cVar.n(arrayList);
                        } else {
                            cVar.m(this.f31187f);
                            return;
                        }
                    } else if (this.f31189h.o(this.f31188g, cVar)) {
                        cVar.o(arrayList);
                    } else if (f2) {
                        cVar.n(arrayList);
                    } else {
                        cVar.m(this.f31187f);
                        return;
                    }
                }
                if (d2) {
                    this.f31187f.success(null);
                } else {
                    this.f31187f.success(arrayList);
                }
            }
        }
    }

    /* renamed from: c.o.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1674c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodCall f31190e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f31191f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31192g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f31193h;

        public RunnableC1674c(c cVar, MethodCall methodCall, i iVar, c.o.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, methodCall, iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31193h = cVar;
            this.f31190e = methodCall;
            this.f31191f = iVar;
            this.f31192g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31193h.insert(this.f31192g, new c.o.a.f.e(this.f31190e, this.f31191f));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MethodCall f31195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f31196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f31197h;

        public d(c cVar, c.o.a.a aVar, MethodCall methodCall, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, methodCall, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31197h = cVar;
            this.f31194e = aVar;
            this.f31195f = methodCall;
            this.f31196g = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31197h.p(this.f31194e, this.f31195f, this.f31196g) == null) {
                return;
            }
            this.f31196g.success(null);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodCall f31198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f31199f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31200g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f31201h;

        public e(c cVar, MethodCall methodCall, i iVar, c.o.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, methodCall, iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31201h = cVar;
            this.f31198e = methodCall;
            this.f31199f = iVar;
            this.f31200g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31201h.update(this.f31200g, new c.o.a.f.e(this.f31198e, this.f31199f));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f31202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f31203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f31204g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Boolean f31205h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31206i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ MethodCall f31207j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ boolean f31208k;
        public final /* synthetic */ int l;
        public final /* synthetic */ c m;

        public f(c cVar, boolean z, String str, i iVar, Boolean bool, c.o.a.a aVar, MethodCall methodCall, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z), str, iVar, bool, aVar, methodCall, Boolean.valueOf(z2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = cVar;
            this.f31202e = z;
            this.f31203f = str;
            this.f31204g = iVar;
            this.f31205h = bool;
            this.f31206i = aVar;
            this.f31207j = methodCall;
            this.f31208k = z2;
            this.l = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (c.l) {
                    if (!this.f31202e) {
                        File file = new File(new File(this.f31203f).getParent());
                        if (!file.exists() && !file.mkdirs() && !file.exists()) {
                            this.f31204g.error("sqlite_error", "open_failed " + this.f31203f, null);
                            return;
                        }
                    }
                    try {
                        if (Boolean.TRUE.equals(this.f31205h)) {
                            this.f31206i.h();
                        } else {
                            this.f31206i.g();
                        }
                        synchronized (c.f31179k) {
                            if (this.f31208k) {
                                c.f31175g.put(this.f31203f, Integer.valueOf(this.l));
                            }
                            c.q.put(Integer.valueOf(this.l), this.f31206i);
                        }
                        if (c.o.a.b.b(this.f31206i.f31172d)) {
                            String str = this.f31206i.d() + "opened " + this.l + " " + this.f31203f;
                        }
                        this.f31204g.success(c.x(this.l, false, false));
                    } catch (Exception e2) {
                        this.m.v(e2, new c.o.a.f.e(this.f31207j, this.f31204g), this.f31206i);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f31210f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f31211g;

        public g(c cVar, c.o.a.a aVar, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31211g = cVar;
            this.f31209e = aVar;
            this.f31210f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (c.l) {
                    this.f31211g.k(this.f31209e);
                }
                this.f31210f.success(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.o.a.a f31212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f31213f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f31214g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f31215h;

        public h(c cVar, c.o.a.a aVar, String str, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, str, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31215h = cVar;
            this.f31212e = aVar;
            this.f31213f = str;
            this.f31214g = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (c.l) {
                    if (this.f31212e != null) {
                        this.f31215h.k(this.f31212e);
                    }
                    try {
                        if (c.o.a.b.c(c.f31178j)) {
                            String str = "delete database " + this.f31213f;
                        }
                        c.o.a.a.b(this.f31213f);
                    } catch (Exception e2) {
                        String str2 = "error " + e2 + " while closing database " + c.n;
                    }
                }
                this.f31214g.success(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements MethodChannel.Result {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;

        /* renamed from: b  reason: collision with root package name */
        public final MethodChannel.Result f31216b;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f31217e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f31218f;

            public a(i iVar, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31218f = iVar;
                this.f31217e = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f31218f.f31216b.success(this.f31217e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f31219e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f31220f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Object f31221g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ i f31222h;

            public b(i iVar, String str, String str2, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, str, str2, obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31222h = iVar;
                this.f31219e = str;
                this.f31220f = str2;
                this.f31221g = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f31222h.f31216b.error(this.f31219e, this.f31220f, this.f31221g);
                }
            }
        }

        /* renamed from: c.o.a.c$i$c  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1675c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f31223e;

            public RunnableC1675c(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31223e = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f31223e.f31216b.notImplemented();
                }
            }
        }

        public /* synthetic */ i(c cVar, MethodChannel.Result result, a aVar) {
            this(cVar, result);
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
                this.a.post(new b(this, str, str2, obj));
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.post(new RunnableC1675c(this));
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.a.post(new a(this, obj));
            }
        }

        public i(c cVar, MethodChannel.Result result) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, result};
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
            this.f31216b = result;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1495842370, "Lc/o/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1495842370, "Lc/o/a/c;");
                return;
            }
        }
        f31175g = new HashMap();
        f31176h = false;
        f31177i = 10;
        f31178j = 0;
        f31179k = new Object();
        l = new Object();
        n = 0;
        q = new HashMap();
    }

    public c() {
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

    public static String L(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof byte[]) {
                ArrayList arrayList = new ArrayList();
                for (byte b2 : (byte[]) obj) {
                    arrayList.add(Integer.valueOf(b2));
                }
                return arrayList.toString();
            } else if (obj instanceof Map) {
                return r((Map) obj).toString();
            } else {
                return obj.toString();
            }
        }
        return (String) invokeL.objValue;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.f31180e : (Context) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean insert(c.o.a.a aVar, c.o.a.f.f fVar) {
        InterceptResult invokeLL;
        Exception e2;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65549, this, aVar, fVar)) != null) {
            return invokeLL.booleanValue;
        }
        if (!q(aVar, fVar)) {
            return false;
        }
        Cursor cursor2 = null;
        if (fVar.d()) {
            fVar.success(null);
            return true;
        }
        try {
            try {
                cursor = aVar.f().rawQuery("SELECT changes(), last_insert_rowid()", null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                            if (cursor.getInt(0) == 0) {
                                if (c.o.a.b.b(aVar.f31172d)) {
                                    String str = aVar.d() + "no changes (id was " + cursor.getLong(1) + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                fVar.success(null);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return true;
                            }
                            long j2 = cursor.getLong(1);
                            if (c.o.a.b.b(aVar.f31172d)) {
                                String str2 = aVar.d() + "inserted " + j2;
                            }
                            fVar.success(Long.valueOf(j2));
                            if (cursor != null) {
                                cursor.close();
                            }
                            return true;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        v(e2, fVar, aVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    }
                }
                String str3 = aVar.d() + "fail to read changes for Insert";
                fVar.success(null);
                if (cursor != null) {
                    cursor.close();
                }
                return true;
            } catch (Throwable th) {
                th = th;
                cursor2 = "SELECT changes(), last_insert_rowid()";
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static List<Object> l(Cursor cursor, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, cursor, i2)) == null) {
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                Object n2 = n(cursor, i3);
                if (c.o.a.e.a.f31226c) {
                    String str = null;
                    if (n2 != null) {
                        str = n2.getClass().isArray() ? "array(" + n2.getClass().getComponentType().getName() + SmallTailInfo.EMOTION_SUFFIX : n2.getClass().getName();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("column ");
                    sb.append(i3);
                    sb.append(" ");
                    sb.append(cursor.getType(i3));
                    sb.append(": ");
                    sb.append(n2);
                    sb.append(str == null ? "" : " (" + str + SmallTailInfo.EMOTION_SUFFIX);
                    sb.toString();
                }
                arrayList.add(n2);
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    public static Map<String, Object> m(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, cursor)) == null) {
            HashMap hashMap = new HashMap();
            String[] columnNames = cursor.getColumnNames();
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (c.o.a.e.a.f31226c) {
                    String str = "column " + i2 + " " + cursor.getType(i2);
                }
                int type = cursor.getType(i2);
                if (type == 0) {
                    hashMap.put(columnNames[i2], null);
                } else if (type == 1) {
                    hashMap.put(columnNames[i2], Long.valueOf(cursor.getLong(i2)));
                } else if (type == 2) {
                    hashMap.put(columnNames[i2], Double.valueOf(cursor.getDouble(i2)));
                } else if (type == 3) {
                    hashMap.put(columnNames[i2], cursor.getString(i2));
                } else if (type == 4) {
                    hashMap.put(columnNames[i2], cursor.getBlob(i2));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Object n(Cursor cursor, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, cursor, i2)) == null) {
            int type = cursor.getType(i2);
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            return null;
                        }
                        return cursor.getBlob(i2);
                    }
                    return cursor.getString(i2);
                }
                return Double.valueOf(cursor.getDouble(i2));
            }
            return Long.valueOf(cursor.getLong(i2));
        }
        return invokeLI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x006f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x00a2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0041 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0041 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [c.o.a.f.g, java.lang.Object, c.o.a.f.f] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public boolean query(c.o.a.a aVar, c.o.a.f.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65554, this, aVar, fVar)) != null) {
            return invokeLL.booleanValue;
        }
        c.o.a.d b2 = fVar.b();
        ArrayList arrayList = new ArrayList();
        if (c.o.a.b.b(aVar.f31172d)) {
            String str = aVar.d() + b2;
        }
        boolean z = f31176h;
        Cursor cursor = 0;
        try {
            try {
                c.o.a.d i2 = b2.i();
                Cursor rawQuery = aVar.c().rawQuery(i2.e(), i2.b());
                ArrayList arrayList2 = null;
                int i3 = 0;
                while (rawQuery.moveToNext()) {
                    try {
                        if (z) {
                            Map<String, Object> m2 = m(rawQuery);
                            if (c.o.a.b.b(aVar.f31172d)) {
                                String str2 = aVar.d() + L(m2);
                            }
                            arrayList.add(m2);
                        } else {
                            if (cursor == 0) {
                                ArrayList arrayList3 = new ArrayList();
                                HashMap hashMap = new HashMap();
                                i3 = rawQuery.getColumnCount();
                                hashMap.put("columns", Arrays.asList(rawQuery.getColumnNames()));
                                hashMap.put("rows", arrayList3);
                                arrayList2 = arrayList3;
                                cursor = hashMap;
                            }
                            arrayList2.add(l(rawQuery, i3));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = rawQuery;
                        v(e, fVar, aVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (z) {
                    fVar.success(arrayList);
                } else {
                    if (cursor == 0) {
                        cursor = new HashMap();
                    }
                    fVar.success(cursor);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Map<String, Object> r(Map<Object, Object> map) {
        InterceptResult invokeL;
        Object L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, map)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Map) {
                    L = r((Map) value);
                } else {
                    L = L(value);
                }
                hashMap.put(L(entry.getKey()), L);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean update(c.o.a.a aVar, c.o.a.f.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65556, this, aVar, fVar)) != null) {
            return invokeLL.booleanValue;
        }
        if (!q(aVar, fVar)) {
            return false;
        }
        Cursor cursor = null;
        try {
            if (fVar.d()) {
                fVar.success(null);
                return true;
            }
            try {
                Cursor rawQuery = aVar.f().rawQuery("SELECT changes()", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0 && rawQuery.moveToFirst()) {
                            int i2 = rawQuery.getInt(0);
                            if (c.o.a.b.b(aVar.f31172d)) {
                                String str = aVar.d() + "changed " + i2;
                            }
                            fVar.success(Integer.valueOf(i2));
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = rawQuery;
                        v(e, fVar, aVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                String str2 = aVar.d() + "fail to read changes for Update/Delete";
                fVar.success(null);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? str == null || str.equals(":memory:") : invokeL.booleanValue;
    }

    public static Map x(int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", Integer.valueOf(i2));
            if (z) {
                hashMap.put("recovered", Boolean.TRUE);
            }
            if (z2) {
                hashMap.put("recoveredInTransaction", Boolean.TRUE);
            }
            return hashMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public final void A(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, methodCall, result) == null) {
            int intValue = ((Integer) methodCall.argument("id")).intValue();
            c.o.a.a t = t(methodCall, result);
            if (t == null) {
                return;
            }
            if (c.o.a.b.b(t.f31172d)) {
                String str = t.d() + "closing " + intValue + " " + t.f31170b;
            }
            String str2 = t.f31170b;
            synchronized (f31179k) {
                q.remove(Integer.valueOf(intValue));
                if (t.a) {
                    f31175g.remove(str2);
                }
            }
            p.post(new g(this, t, new i(this, result, null)));
        }
    }

    public final void B(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, methodCall, result) == null) {
            HashMap hashMap = new HashMap();
            if ("get".equals((String) methodCall.argument("cmd"))) {
                int i2 = f31178j;
                if (i2 > 0) {
                    hashMap.put("logLevel", Integer.valueOf(i2));
                }
                if (!q.isEmpty()) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry<Integer, c.o.a.a> entry : q.entrySet()) {
                        c.o.a.a value = entry.getValue();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("path", value.f31170b);
                        hashMap3.put("singleInstance", Boolean.valueOf(value.a));
                        int i3 = value.f31172d;
                        if (i3 > 0) {
                            hashMap3.put("logLevel", Integer.valueOf(i3));
                        }
                        hashMap2.put(entry.getKey().toString(), hashMap3);
                    }
                    hashMap.put("databases", hashMap2);
                }
            }
            result.success(hashMap);
        }
    }

    public final void C(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, methodCall, result) == null) {
            c.o.a.e.a.a = Boolean.TRUE.equals(methodCall.arguments());
            c.o.a.e.a.f31226c = c.o.a.e.a.f31225b && c.o.a.e.a.a;
            if (c.o.a.e.a.a) {
                if (c.o.a.e.a.f31226c) {
                    f31178j = 2;
                } else if (c.o.a.e.a.a) {
                    f31178j = 1;
                }
            } else {
                f31178j = 0;
            }
            result.success(null);
        }
    }

    public final void D(MethodCall methodCall, MethodChannel.Result result) {
        c.o.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, methodCall, result) == null) {
            String str = (String) methodCall.argument("path");
            synchronized (f31179k) {
                if (c.o.a.b.c(f31178j)) {
                    String str2 = "Look for " + str + " in " + f31175g.keySet();
                }
                Integer num = f31175g.get(str);
                if (num == null || (aVar = q.get(num)) == null || !aVar.f31173e.isOpen()) {
                    aVar = null;
                } else {
                    if (c.o.a.b.c(f31178j)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(aVar.d());
                        sb.append("found single instance ");
                        sb.append(aVar.f31174f ? "(in transaction) " : "");
                        sb.append(num);
                        sb.append(" ");
                        sb.append(str);
                        sb.toString();
                    }
                    q.remove(num);
                    f31175g.remove(str);
                }
            }
            h hVar = new h(this, aVar, str, new i(this, result, null));
            Handler handler = p;
            if (handler != null) {
                handler.post(hVar);
            } else {
                hVar.run();
            }
        }
    }

    public final void E(MethodCall methodCall, MethodChannel.Result result) {
        c.o.a.a t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, methodCall, result) == null) || (t = t(methodCall, result)) == null) {
            return;
        }
        p.post(new d(this, t, methodCall, new i(this, result, null)));
    }

    public void F(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, methodCall, result) == null) {
            if (m == null) {
                m = this.f31180e.getDatabasePath("tekartik_sqflite.db").getParent();
            }
            result.success(m);
        }
    }

    public final void G(MethodCall methodCall, MethodChannel.Result result) {
        c.o.a.a t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, methodCall, result) == null) || (t = t(methodCall, result)) == null) {
            return;
        }
        p.post(new RunnableC1674c(this, methodCall, new i(this, result, null), t));
    }

    public final void H(MethodCall methodCall, MethodChannel.Result result) {
        int i2;
        c.o.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, methodCall, result) == null) {
            String str = (String) methodCall.argument("path");
            Boolean bool = (Boolean) methodCall.argument("readOnly");
            boolean w = w(str);
            boolean z = (Boolean.FALSE.equals(methodCall.argument("singleInstance")) || w) ? false : true;
            if (z) {
                synchronized (f31179k) {
                    if (c.o.a.b.c(f31178j)) {
                        String str2 = "Look for " + str + " in " + f31175g.keySet();
                    }
                    Integer num = f31175g.get(str);
                    if (num != null && (aVar = q.get(num)) != null) {
                        if (!aVar.f31173e.isOpen()) {
                            if (c.o.a.b.c(f31178j)) {
                                String str3 = aVar.d() + "single instance database of " + str + " not opened";
                            }
                        } else {
                            if (c.o.a.b.c(f31178j)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(aVar.d());
                                sb.append("re-opened single instance ");
                                sb.append(aVar.f31174f ? "(in transaction) " : "");
                                sb.append(num);
                                sb.append(" ");
                                sb.append(str);
                                sb.toString();
                            }
                            result.success(x(num.intValue(), true, aVar.f31174f));
                            return;
                        }
                    }
                }
            }
            synchronized (f31179k) {
                i2 = n + 1;
                n = i2;
            }
            c.o.a.a aVar2 = new c.o.a.a(str, i2, z, f31178j);
            i iVar = new i(this, result, null);
            synchronized (f31179k) {
                if (p == null) {
                    HandlerThread handlerThread = new HandlerThread("Sqflite", f31177i);
                    o = handlerThread;
                    handlerThread.start();
                    p = new Handler(o.getLooper());
                    if (c.o.a.b.b(aVar2.f31172d)) {
                        String str4 = aVar2.d() + "starting thread" + o + " priority " + f31177i;
                    }
                }
                if (c.o.a.b.b(aVar2.f31172d)) {
                    String str5 = aVar2.d() + "opened " + i2 + " " + str;
                }
                p.post(new f(this, w, str, iVar, bool, aVar2, methodCall, z, i2));
            }
        }
    }

    public void I(MethodCall methodCall, MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, methodCall, result) == null) {
            Object argument = methodCall.argument("queryAsMapList");
            if (argument != null) {
                f31176h = Boolean.TRUE.equals(argument);
            }
            Object argument2 = methodCall.argument("androidThreadPriority");
            if (argument2 != null) {
                f31177i = ((Integer) argument2).intValue();
            }
            Integer a2 = c.o.a.b.a(methodCall);
            if (a2 != null) {
                f31178j = a2.intValue();
            }
            result.success(null);
        }
    }

    public final void J(MethodCall methodCall, MethodChannel.Result result) {
        c.o.a.a t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, methodCall, result) == null) || (t = t(methodCall, result)) == null) {
            return;
        }
        p.post(new a(this, methodCall, new i(this, result, null), t));
    }

    public final void K(MethodCall methodCall, MethodChannel.Result result) {
        c.o.a.a t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, methodCall, result) == null) || (t = t(methodCall, result)) == null) {
            return;
        }
        p.post(new e(this, methodCall, new i(this, result, null), t));
    }

    public final void k(c.o.a.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            try {
                if (c.o.a.b.b(aVar.f31172d)) {
                    String str2 = aVar.d() + "closing database " + o;
                }
                aVar.a();
            } catch (Exception e2) {
                str = "error " + e2 + " while closing database " + n;
            }
            synchronized (f31179k) {
                if (q.isEmpty() && p != null) {
                    if (c.o.a.b.b(aVar.f31172d)) {
                        r0 = aVar.d() + "stopping thread" + o;
                    }
                    o.quit();
                    o = null;
                    p = null;
                }
            }
        }
    }

    public final boolean o(c.o.a.a aVar, c.o.a.f.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, aVar, fVar)) == null) {
            if (q(aVar, fVar)) {
                fVar.success(null);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, flutterPluginBinding) == null) {
            y(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, flutterPluginBinding) == null) {
            this.f31180e = null;
            this.f31181f.setMethodCallHandler(null);
            this.f31181f = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, methodCall, result) == null) {
            String str = methodCall.method;
            switch (str.hashCode()) {
                case -1319569547:
                    if (str.equals("execute")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1253581933:
                    if (str.equals("closeDatabase")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1249474914:
                    if (str.equals("options")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1183792455:
                    if (str.equals("insert")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -838846263:
                    if (str.equals("update")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -263511994:
                    if (str.equals("deleteDatabase")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -198450538:
                    if (str.equals("debugMode")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -17190427:
                    if (str.equals("openDatabase")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93509434:
                    if (str.equals("batch")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 95458899:
                    if (str.equals("debug")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 107944136:
                    if (str.equals("query")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1385449135:
                    if (str.equals("getPlatformVersion")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1863829223:
                    if (str.equals("getDatabasesPath")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    result.success("Android " + Build.VERSION.RELEASE);
                    return;
                case 1:
                    A(methodCall, result);
                    return;
                case 2:
                    J(methodCall, result);
                    return;
                case 3:
                    G(methodCall, result);
                    return;
                case 4:
                    K(methodCall, result);
                    return;
                case 5:
                    E(methodCall, result);
                    return;
                case 6:
                    H(methodCall, result);
                    return;
                case 7:
                    z(methodCall, result);
                    return;
                case '\b':
                    I(methodCall, result);
                    return;
                case '\t':
                    F(methodCall, result);
                    return;
                case '\n':
                    D(methodCall, result);
                    return;
                case 11:
                    B(methodCall, result);
                    return;
                case '\f':
                    C(methodCall, result);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        }
    }

    public final c.o.a.a p(c.o.a.a aVar, MethodCall methodCall, MethodChannel.Result result) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, aVar, methodCall, result)) == null) {
            if (q(aVar, new c.o.a.f.d(result, u(methodCall), (Boolean) methodCall.argument("inTransaction")))) {
                return aVar;
            }
            return null;
        }
        return (c.o.a.a) invokeLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[SGET, INVOKE]}, finally: {[SGET, INVOKE, IPUT, IF] complete} */
    public final boolean q(c.o.a.a aVar, c.o.a.f.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, aVar, fVar)) == null) {
            c.o.a.d b2 = fVar.b();
            if (c.o.a.b.b(aVar.f31172d)) {
                String str = aVar.d() + b2;
            }
            Boolean c2 = fVar.c();
            try {
                try {
                    aVar.f().execSQL(b2.e(), b2.f());
                    if (Boolean.TRUE.equals(c2)) {
                        aVar.f31174f = true;
                    }
                    if (Boolean.FALSE.equals(c2)) {
                        aVar.f31174f = false;
                    }
                    return true;
                } catch (Exception e2) {
                    v(e2, fVar, aVar);
                    if (Boolean.FALSE.equals(c2)) {
                        aVar.f31174f = false;
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (Boolean.FALSE.equals(c2)) {
                    aVar.f31174f = false;
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public final c.o.a.a s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? q.get(Integer.valueOf(i2)) : (c.o.a.a) invokeI.objValue;
    }

    public final c.o.a.a t(MethodCall methodCall, MethodChannel.Result result) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, methodCall, result)) == null) {
            int intValue = ((Integer) methodCall.argument("id")).intValue();
            c.o.a.a s = s(intValue);
            if (s != null) {
                return s;
            }
            result.error("sqlite_error", "database_closed " + intValue, null);
            return null;
        }
        return (c.o.a.a) invokeLL.objValue;
    }

    public final c.o.a.d u(MethodCall methodCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, methodCall)) == null) ? new c.o.a.d((String) methodCall.argument("sql"), (List) methodCall.argument("arguments")) : (c.o.a.d) invokeL.objValue;
    }

    public final void v(Exception exc, c.o.a.f.f fVar, c.o.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, exc, fVar, aVar) == null) {
            if (exc instanceof SQLiteCantOpenDatabaseException) {
                fVar.error("sqlite_error", "open_failed " + aVar.f31170b, null);
            } else if (exc instanceof SQLException) {
                fVar.error("sqlite_error", exc.getMessage(), c.o.a.f.h.a(fVar));
            } else {
                fVar.error("sqlite_error", exc.getMessage(), c.o.a.f.h.a(fVar));
            }
        }
    }

    public final void y(Context context, BinaryMessenger binaryMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, binaryMessenger) == null) {
            this.f31180e = context;
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite");
            this.f31181f = methodChannel;
            methodChannel.setMethodCallHandler(this);
        }
    }

    public final void z(MethodCall methodCall, MethodChannel.Result result) {
        c.o.a.a t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, methodCall, result) == null) || (t = t(methodCall, result)) == null) {
            return;
        }
        p.post(new b(this, methodCall, new i(this, result, null), t));
    }
}
