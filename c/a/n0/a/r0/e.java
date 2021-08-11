package c.a.n0.a.r0;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.a.r0.f f7899a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.l0.a f7900b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.r0.i f7901c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7903f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7904g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7905h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7906i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f7907j;

        /* renamed from: c.a.n0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0346a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7908e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7909f;

            public RunnableC0346a(a aVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7909f = aVar;
                this.f7908e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7909f.f7904g), "dirPath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7908e, "mkdir:", this.f7909f.f7905h);
                    a aVar = this.f7909f;
                    if (c.a.n0.a.r0.n.a(t, aVar.f7906i, hashMap, aVar.f7907j.f7900b)) {
                        c.a.n0.a.r0.o.b bVar = this.f7909f.f7906i;
                        bVar.errMsg = "mkdir:" + this.f7908e.f7892b;
                        a aVar2 = this.f7909f;
                        c.a.n0.a.r0.n.b(aVar2.f7906i, aVar2.f7905h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, bool, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7907j = eVar;
            this.f7902e = str;
            this.f7903f = bool;
            this.f7904g = i2;
            this.f7905h = map;
            this.f7906i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7907j.f7900b.runOnJSThread(new RunnableC0346a(this, this.f7907j.f7899a.o(this.f7902e, this.f7903f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7912g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7913h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7914i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7915j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7916e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7917f;

            public a(b bVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7917f = bVar;
                this.f7916e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7917f.f7912g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f7917f.f7913h), "destPath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7916e, "copyFile:", this.f7917f.f7914i);
                    b bVar = this.f7917f;
                    if (c.a.n0.a.r0.n.a(t, bVar.f7915j, hashMap, bVar.k.f7900b)) {
                        b bVar2 = this.f7917f;
                        c.a.n0.a.r0.n.b(bVar2.f7915j, bVar2.f7914i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f7910e = str;
            this.f7911f = str2;
            this.f7912g = i2;
            this.f7913h = i3;
            this.f7914i = map;
            this.f7915j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7900b.runOnJSThread(new a(this, this.k.f7899a.c(this.f7910e, this.f7911f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7919f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7920g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7921h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7922i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7923j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.n0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7924e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f7925f;

            public a(c cVar, c.a.n0.a.r0.c cVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7925f = cVar;
                this.f7924e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7925f.k), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7924e, "appendFile:", this.f7925f.f7921h);
                    c cVar = this.f7925f;
                    if (c.a.n0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f7900b)) {
                        c cVar2 = this.f7925f;
                        c.a.n0.a.r0.n.b(cVar2.l, cVar2.f7921h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, bArr, map, str3, Integer.valueOf(i2), Integer.valueOf(i3), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f7918e = str;
            this.f7919f = str2;
            this.f7920g = bArr;
            this.f7921h = map;
            this.f7922i = str3;
            this.f7923j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.r0.c b2 = this.m.f7899a.b(this.f7918e, TextUtils.isEmpty(this.f7919f) ? this.f7920g : this.f7919f, c.a.n0.a.r0.n.F("encoding", this.f7921h), false);
                if (!TextUtils.isEmpty(this.f7922i)) {
                    b2.f7892b = this.f7922i;
                    b2.f7891a = -2;
                    c.a.n0.a.r0.n.d(this.m.f7900b, this.f7922i);
                } else {
                    int i2 = this.f7923j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f7892b = "fail encoding must be a string";
                        b2.f7891a = -2;
                        c.a.n0.a.r0.n.d(this.m.f7900b, b2.f7892b);
                    }
                }
                this.m.f7900b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7929h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7930i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7931e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f7932f;

            public a(d dVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7932f = dVar;
                this.f7931e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7932f.f7927f), "path");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7931e, "access:", this.f7932f.f7928g);
                    d dVar = this.f7932f;
                    if (c.a.n0.a.r0.n.a(t, dVar.f7929h, hashMap, dVar.f7930i.f7900b)) {
                        d dVar2 = this.f7932f;
                        c.a.n0.a.r0.n.b(dVar2.f7929h, dVar2.f7928g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7930i = eVar;
            this.f7926e = str;
            this.f7927f = i2;
            this.f7928g = map;
            this.f7929h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7930i.f7900b.runOnJSThread(new a(this, this.f7930i.f7899a.a(this.f7926e, false)));
            }
        }
    }

    /* renamed from: c.a.n0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0347e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7934f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7935g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7936h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7937i;

        /* renamed from: c.a.n0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7938e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0347e f7939f;

            public a(RunnableC0347e runnableC0347e, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0347e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7939f = runnableC0347e;
                this.f7938e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7939f.f7934f), "path");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7938e, "stat:", this.f7939f.f7935g);
                    RunnableC0347e runnableC0347e = this.f7939f;
                    if (c.a.n0.a.r0.n.a(t, runnableC0347e.f7936h, hashMap, runnableC0347e.f7937i.f7900b)) {
                        c.a.n0.a.r0.o.h hVar = new c.a.n0.a.r0.o.h();
                        c.a.n0.a.r0.c cVar = this.f7938e;
                        hVar.stats = cVar.f7894d;
                        hVar.errMsg = cVar.f7892b;
                        c.a.n0.a.r0.n.b(hVar, this.f7939f.f7935g);
                    }
                }
            }
        }

        public RunnableC0347e(e eVar, String str, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7937i = eVar;
            this.f7933e = str;
            this.f7934f = i2;
            this.f7935g = map;
            this.f7936h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7937i.f7900b.runOnJSThread(new a(this, this.f7937i.f7899a.y(this.f7933e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7941f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7942g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7943h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7944i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7945e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f7946f;

            public a(f fVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7946f = fVar;
                this.f7945e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7946f.f7941f), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7945e, "getFileInfo:", this.f7946f.f7942g);
                    f fVar = this.f7946f;
                    if (c.a.n0.a.r0.n.a(t, fVar.f7943h, hashMap, fVar.f7944i.f7900b)) {
                        c.a.n0.a.r0.o.c cVar = new c.a.n0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f7945e.f7892b;
                        c.a.n0.a.r0.c cVar2 = this.f7945e;
                        cVar.digest = cVar2.f7897g;
                        cVar.size = (int) cVar2.f7895e;
                        c.a.n0.a.r0.n.b(cVar, this.f7946f.f7942g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7944i = eVar;
            this.f7940e = str;
            this.f7941f = i2;
            this.f7942g = map;
            this.f7943h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7944i.f7900b.runOnJSThread(new a(this, this.f7944i.f7899a.e(this.f7940e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f7947e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7948f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f7949g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7950e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f7951f;

            public a(g gVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7951f = gVar;
                this.f7950e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7950e, "getSavedFileList:", this.f7951f.f7947e);
                    g gVar = this.f7951f;
                    if (c.a.n0.a.r0.n.a(t, gVar.f7948f, null, gVar.f7949g.f7900b)) {
                        c.a.n0.a.r0.o.d dVar = new c.a.n0.a.r0.o.d();
                        List<c.a.n0.a.r0.d> list = this.f7950e.f7896f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.n0.a.r0.d[0] : (c.a.n0.a.r0.d[]) this.f7950e.f7896f.toArray(new c.a.n0.a.r0.d[size]);
                        g gVar2 = this.f7951f;
                        dVar.errMsg = gVar2.f7948f.errMsg;
                        c.a.n0.a.r0.n.b(dVar, gVar2.f7947e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7949g = eVar;
            this.f7947e = map;
            this.f7948f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7949g.f7900b.runOnJSThread(new a(this, this.f7949g.f7899a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7953f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7954g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7955h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7956i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7957e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f7958f;

            public a(h hVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7958f = hVar;
                this.f7957e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7958f.f7953f), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7957e, "removeSavedFile:", this.f7958f.f7954g);
                    h hVar = this.f7958f;
                    if (c.a.n0.a.r0.n.a(t, hVar.f7955h, hashMap, hVar.f7956i.f7900b)) {
                        h hVar2 = this.f7958f;
                        c.a.n0.a.r0.n.b(hVar2.f7955h, hVar2.f7954g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7956i = eVar;
            this.f7952e = str;
            this.f7953f = i2;
            this.f7954g = map;
            this.f7955h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7956i.f7900b.runOnJSThread(new a(this, this.f7956i.f7899a.t(this.f7952e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7960f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7961g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7962h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7963i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7964j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.n0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7965e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f7966f;

            public a(i iVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7966f = iVar;
                this.f7965e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7966f.k), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7965e, "writeFile:", this.f7966f.f7962h);
                    i iVar = this.f7966f;
                    if (c.a.n0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f7900b)) {
                        c.a.n0.a.r0.o.b bVar = this.f7966f.l;
                        bVar.errMsg = "writeFile:" + this.f7965e.f7892b;
                        i iVar2 = this.f7966f;
                        c.a.n0.a.r0.n.b(iVar2.l, iVar2.f7962h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, bArr, map, str3, Integer.valueOf(i2), Integer.valueOf(i3), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f7959e = str;
            this.f7960f = str2;
            this.f7961g = bArr;
            this.f7962h = map;
            this.f7963i = str3;
            this.f7964j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.r0.c C = this.m.f7899a.C(false, this.f7959e, TextUtils.isEmpty(this.f7960f) ? this.f7961g : this.f7960f, c.a.n0.a.r0.n.F("encoding", this.f7962h));
                if (!TextUtils.isEmpty(this.f7963i)) {
                    C.f7892b = this.f7963i;
                    C.f7891a = -2;
                    c.a.n0.a.r0.n.d(this.m.f7900b, this.f7963i);
                } else {
                    int i2 = this.f7964j;
                    if (i2 != 7 && i2 != 12) {
                        C.f7892b = "fail encoding must be a string";
                        C.f7891a = -2;
                        c.a.n0.a.r0.n.d(this.m.f7900b, C.f7892b);
                    }
                }
                this.m.f7900b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7969g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7970h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7971i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7972e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f7973f;

            public a(j jVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7973f = jVar;
                this.f7972e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7973f.f7968f), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7972e, "unlink:", this.f7973f.f7969g);
                    j jVar = this.f7973f;
                    if (c.a.n0.a.r0.n.a(t, jVar.f7970h, hashMap, jVar.f7971i.f7900b)) {
                        c.a.n0.a.r0.o.b bVar = this.f7973f.f7970h;
                        bVar.errMsg = "unlink:" + this.f7972e.f7892b;
                        j jVar2 = this.f7973f;
                        c.a.n0.a.r0.n.b(jVar2.f7970h, jVar2.f7969g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7971i = eVar;
            this.f7967e = str;
            this.f7968f = i2;
            this.f7969g = map;
            this.f7970h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7971i.f7900b.runOnJSThread(new a(this, this.f7971i.f7899a.z(this.f7967e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7975f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7976g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7977h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7978i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7979j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7980e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f7981f;

            public a(k kVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7981f = kVar;
                this.f7980e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7981f.f7976g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f7981f.f7977h), "targetPath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7980e, "unzip:", this.f7981f.f7978i);
                    k kVar = this.f7981f;
                    if (c.a.n0.a.r0.n.a(t, kVar.f7979j, hashMap, kVar.k.f7900b)) {
                        c.a.n0.a.r0.o.b bVar = this.f7981f.f7979j;
                        bVar.errMsg = "unzip:" + this.f7980e.f7892b;
                        k kVar2 = this.f7981f;
                        c.a.n0.a.r0.n.b(kVar2.f7979j, kVar2.f7978i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f7974e = str;
            this.f7975f = str2;
            this.f7976g = i2;
            this.f7977h = i3;
            this.f7978i = map;
            this.f7979j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7900b.runOnJSThread(new a(this, this.k.f7899a.A(this.f7974e, this.f7975f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7983f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7984g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7985h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7986i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7987j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7988e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f7989f;

            public a(l lVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7989f = lVar;
                this.f7988e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7989f.f7984g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f7989f.f7985h), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7988e, "saveFile:", this.f7989f.f7986i);
                    l lVar = this.f7989f;
                    if (c.a.n0.a.r0.n.a(t, lVar.f7987j, hashMap, lVar.k.f7900b)) {
                        c.a.n0.a.r0.o.g gVar = new c.a.n0.a.r0.o.g();
                        List<String> list = this.f7988e.f7893c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f7988e.f7892b;
                        c.a.n0.a.r0.n.b(gVar, this.f7989f.f7986i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f7982e = str;
            this.f7983f = str2;
            this.f7984g = i2;
            this.f7985h = i3;
            this.f7986i = map;
            this.f7987j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7900b.runOnJSThread(new a(this, this.k.f7899a.x(this.f7982e, this.f7983f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f7993h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7994i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f7995e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f7996f;

            public a(m mVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7996f = mVar;
                this.f7995e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7996f.f7991f), "dirPath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f7995e, "readdir:", this.f7996f.f7992g);
                    m mVar = this.f7996f;
                    if (c.a.n0.a.r0.n.a(t, mVar.f7993h, hashMap, mVar.f7994i.f7900b)) {
                        c.a.n0.a.r0.o.e eVar = new c.a.n0.a.r0.o.e();
                        List<String> list = this.f7995e.f7893c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f7995e.f7893c.toArray(new String[size]);
                        eVar.errMsg = this.f7995e.f7892b;
                        c.a.n0.a.r0.n.b(eVar, this.f7996f.f7992g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7994i = eVar;
            this.f7990e = str;
            this.f7991f = i2;
            this.f7992g = map;
            this.f7993h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7994i.f7900b.runOnJSThread(new a(this, this.f7994i.f7899a.s(this.f7990e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7997e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7998f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7999g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8000h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f8001i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8002j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f8003e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8004f;

            public a(n nVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8004f = nVar;
                this.f8003e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8004f.f7999g), "dirPath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f8003e, "rmdir:", this.f8004f.f8000h);
                    n nVar = this.f8004f;
                    if (c.a.n0.a.r0.n.a(t, nVar.f8001i, hashMap, nVar.f8002j.f7900b)) {
                        n nVar2 = this.f8004f;
                        c.a.n0.a.r0.n.b(nVar2.f8001i, nVar2.f8000h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, bool, Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8002j = eVar;
            this.f7997e = str;
            this.f7998f = bool;
            this.f7999g = i2;
            this.f8000h = map;
            this.f8001i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8002j.f7900b.runOnJSThread(new a(this, this.f8002j.f7899a.v(this.f7997e, this.f7998f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8007g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8008h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8009i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f8010j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f8011e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8012f;

            public a(o oVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8012f = oVar;
                this.f8011e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8012f.f8008h), "filePath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f8011e, "readFile:", this.f8012f.f8009i);
                    o oVar = this.f8012f;
                    if (c.a.n0.a.r0.n.a(t, oVar.f8010j, hashMap, oVar.k.f7900b)) {
                        if (TextUtils.isEmpty(this.f8012f.f8006f)) {
                            c.a.n0.a.r0.o.a aVar = new c.a.n0.a.r0.o.a();
                            c.a.n0.a.r0.c cVar = this.f8011e;
                            if (cVar.f7898h == null) {
                                cVar.f7898h = new byte[0];
                            }
                            byte[] bArr = this.f8011e.f7898h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8011e.f7892b;
                            c.a.n0.a.r0.n.b(aVar, this.f8012f.f8009i);
                            return;
                        }
                        List<String> list = this.f8011e.f7893c;
                        String str = list != null ? list.get(0) : null;
                        c.a.n0.a.r0.o.f fVar = new c.a.n0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8011e.f7892b;
                        c.a.n0.a.r0.n.b(fVar, this.f8012f.f8009i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f8005e = str;
            this.f8006f = str2;
            this.f8007g = i2;
            this.f8008h = i3;
            this.f8009i = map;
            this.f8010j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.r0.c q = this.k.f7899a.q(this.f8005e, this.f8006f, false);
                int i2 = this.f8007g;
                if (i2 != 7 && i2 != 12) {
                    q.f7892b = "fail encoding must be a string";
                    q.f7891a = -2;
                    c.a.n0.a.r0.n.d(this.k.f7900b, q.f7892b);
                }
                this.k.f7900b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8013e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8014f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8015g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8016h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8017i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.r0.o.b f8018j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.r0.c f8019e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8020f;

            public a(p pVar, c.a.n0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8020f = pVar;
                this.f8019e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8020f.f8015g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8020f.f8016h), "newPath");
                    c.a.n0.a.r0.b t = c.a.n0.a.r0.n.t(this.f8019e, "rename:", this.f8020f.f8017i);
                    p pVar = this.f8020f;
                    if (c.a.n0.a.r0.n.a(t, pVar.f8018j, hashMap, pVar.k.f7900b)) {
                        p pVar2 = this.f8020f;
                        c.a.n0.a.r0.n.b(pVar2.f8018j, pVar2.f8017i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.n0.a.r0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f8013e = str;
            this.f8014f = str2;
            this.f8015g = i2;
            this.f8016h = i3;
            this.f8017i = map;
            this.f8018j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7900b.runOnJSThread(new a(this, this.k.f7899a.u(this.f8013e, this.f8014f, false)));
            }
        }
    }

    public e(c.a.n0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7900b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("path", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("path", G);
            this.f7901c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("encoding", jsObject);
            int L2 = c.a.n0.a.r0.n.L("filePath", jsObject);
            int L3 = c.a.n0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : c.a.n0.a.r0.n.u(L3);
            byte[] p2 = c.a.n0.a.r0.n.p(jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("data", G);
            String F2 = c.a.n0.a.r0.n.F("filePath", G);
            this.f7901c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.n0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
            if (Q != null) {
                lVar = Q.W();
            } else {
                lVar = new c.a.n0.a.r0.l();
            }
            this.f7899a = new c.a.n0.a.r0.f(AppRuntime.getAppContext(), c.a.n0.a.g1.f.V().A(), lVar);
            this.f7901c = c.a.n0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("srcPath", jsObject);
            int L2 = c.a.n0.a.r0.n.L("destPath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("srcPath", G);
            String F2 = c.a.n0.a.r0.n.F("destPath", G);
            this.f7901c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str, str2);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("filePath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("filePath", G);
            this.f7901c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.n0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, (bVar = new c.a.n0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f7901c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("dirPath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("dirPath", G);
            this.f7901c.h(new a(this, F, (Boolean) c.a.n0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            mkdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("filePath", jsObject);
            int L2 = c.a.n0.a.r0.n.L("encoding", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("encoding", G);
            String F2 = c.a.n0.a.r0.n.F("filePath", G);
            this.f7901c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
                this.f7901c.k(str);
                c.a.n0.a.r0.c q = this.f7899a.q(str, str2, true);
                c.a.n0.a.r0.n.Z(this.f7900b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f7891a != 0 || (list = q.f7893c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("dirPath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("dirPath", G);
            this.f7901c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
                this.f7901c.k(str);
                c.a.n0.a.r0.c s = this.f7899a.s(str, true);
                c.a.n0.a.r0.n.Z(this.f7900b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f7891a != 0) {
                    return new String[0];
                }
                List<String> list = s.f7893c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f7893c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("filePath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f7901c.h(new h(this, c.a.n0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("oldPath", jsObject);
            int L2 = c.a.n0.a.r0.n.L("newPath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("oldPath", G);
            String F2 = c.a.n0.a.r0.n.F("newPath", G);
            this.f7901c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str, str2);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("dirPath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("dirPath", G);
            this.f7901c.h(new n(this, F, (Boolean) c.a.n0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            rmdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = c.a.n0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("tempFilePath", G);
            String F2 = c.a.n0.a.r0.n.F("filePath", G);
            this.f7901c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.n0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("path", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("path", G);
            this.f7901c.h(new RunnableC0347e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public c.a.n0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
                this.f7901c.k(str);
                c.a.n0.a.r0.c y = this.f7899a.y(str, true);
                c.a.n0.a.r0.n.Z(this.f7900b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f7891a != 0) {
                    return null;
                }
                return y.f7894d;
            }
            return null;
        }
        return (c.a.n0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("filePath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("filePath", G);
            this.f7901c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = c.a.n0.a.r0.n.L("targetPath", jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("zipFilePath", G);
            String F2 = c.a.n0.a.r0.n.F("targetPath", G);
            this.f7901c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.n0.a.r0.n.L("filePath", jsObject);
            String u = c.a.n0.a.r0.n.u(c.a.n0.a.r0.n.L("data", jsObject));
            int L2 = c.a.n0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = c.a.n0.a.r0.n.p(jsObject);
            c.a.n0.a.r0.o.b bVar = new c.a.n0.a.r0.o.b();
            Map<String, Object> G = c.a.n0.a.r0.n.G(this.f7899a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.n0.a.r0.n.F("data", G);
            String F2 = c.a.n0.a.r0.n.F("filePath", G);
            this.f7901c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
                this.f7901c.k(str, str2);
                c.a.n0.a.r0.c x = this.f7899a.x(str, str2, true);
                c.a.n0.a.r0.n.Z(this.f7900b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f7891a != 0 || (list = x.f7893c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            appendFileSync(str, str2, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            writeFileSync(str, str2, "");
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, jsArrayBuffer, str2) == null) {
            appendFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
            this.f7901c.k(str);
            c.a.n0.a.r0.n.Z(this.f7900b, this.f7899a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.n0.a.r0.n.P(this.f7899a, this.f7900b, null, null)) {
                this.f7901c.k(str);
                c.a.n0.a.r0.c q = this.f7899a.q(str, null, true);
                c.a.n0.a.r0.n.Z(this.f7900b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f7898h == null) {
                    q.f7898h = new byte[0];
                }
                byte[] bArr = q.f7898h;
                return new JsArrayBuffer(bArr, bArr.length);
            }
            return null;
        }
        return (JsArrayBuffer) invokeL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jsArrayBuffer) == null) {
            appendFileSync(str, jsArrayBuffer, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, str, jsArrayBuffer, str2) == null) {
            writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }
}
