package c.a.q0.a.r0;

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
    public c.a.q0.a.r0.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.a.l0.a f7908b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.a.r0.i f7909c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7912g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7913h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7914i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f7915j;

        /* renamed from: c.a.q0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0467a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7916e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7917f;

            public RunnableC0467a(a aVar, c.a.q0.a.r0.c cVar) {
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
                this.f7917f = aVar;
                this.f7916e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7917f.f7912g), "dirPath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7916e, "mkdir:", this.f7917f.f7913h);
                    a aVar = this.f7917f;
                    if (c.a.q0.a.r0.n.a(v, aVar.f7914i, hashMap, aVar.f7915j.f7908b)) {
                        c.a.q0.a.r0.o.b bVar = this.f7917f.f7914i;
                        bVar.errMsg = "mkdir:" + this.f7916e.f7901b;
                        a aVar2 = this.f7917f;
                        c.a.q0.a.r0.n.b(aVar2.f7914i, aVar2.f7913h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7915j = eVar;
            this.f7910e = str;
            this.f7911f = bool;
            this.f7912g = i2;
            this.f7913h = map;
            this.f7914i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7915j.f7908b.runOnJSThread(new RunnableC0467a(this, this.f7915j.a.o(this.f7910e, this.f7911f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7919f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7920g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7921h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7922i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7923j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7924k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7925e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7926f;

            public a(b bVar, c.a.q0.a.r0.c cVar) {
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
                this.f7926f = bVar;
                this.f7925e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7926f.f7920g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f7926f.f7921h), "destPath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7925e, "copyFile:", this.f7926f.f7922i);
                    b bVar = this.f7926f;
                    if (c.a.q0.a.r0.n.a(v, bVar.f7923j, hashMap, bVar.f7924k.f7908b)) {
                        b bVar2 = this.f7926f;
                        c.a.q0.a.r0.n.b(bVar2.f7923j, bVar2.f7922i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7924k = eVar;
            this.f7918e = str;
            this.f7919f = str2;
            this.f7920g = i2;
            this.f7921h = i3;
            this.f7922i = map;
            this.f7923j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7924k.f7908b.runOnJSThread(new a(this, this.f7924k.a.c(this.f7918e, this.f7919f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7927e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7928f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7929g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7930h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7931i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7932j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f7933k;
        public final /* synthetic */ c.a.q0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7934e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f7935f;

            public a(c cVar, c.a.q0.a.r0.c cVar2) {
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
                this.f7935f = cVar;
                this.f7934e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7935f.f7933k), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7934e, "appendFile:", this.f7935f.f7930h);
                    c cVar = this.f7935f;
                    if (c.a.q0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f7908b)) {
                        c cVar2 = this.f7935f;
                        c.a.q0.a.r0.n.b(cVar2.l, cVar2.f7930h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.q0.a.r0.o.b bVar) {
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
            this.f7927e = str;
            this.f7928f = str2;
            this.f7929g = bArr;
            this.f7930h = map;
            this.f7931i = str3;
            this.f7932j = i2;
            this.f7933k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.r0.c b2 = this.m.a.b(this.f7927e, TextUtils.isEmpty(this.f7928f) ? this.f7929g : this.f7928f, c.a.q0.a.r0.n.I("encoding", this.f7930h), false);
                if (!TextUtils.isEmpty(this.f7931i)) {
                    b2.f7901b = this.f7931i;
                    b2.a = -2;
                    c.a.q0.a.r0.n.d(this.m.f7908b, this.f7931i);
                } else {
                    int i2 = this.f7932j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f7901b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.q0.a.r0.n.d(this.m.f7908b, b2.f7901b);
                    }
                }
                this.m.f7908b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7937f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7938g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7939h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7940i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7941e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f7942f;

            public a(d dVar, c.a.q0.a.r0.c cVar) {
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
                this.f7942f = dVar;
                this.f7941e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7942f.f7937f), "path");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7941e, "access:", this.f7942f.f7938g);
                    d dVar = this.f7942f;
                    if (c.a.q0.a.r0.n.a(v, dVar.f7939h, hashMap, dVar.f7940i.f7908b)) {
                        d dVar2 = this.f7942f;
                        c.a.q0.a.r0.n.b(dVar2.f7939h, dVar2.f7938g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7940i = eVar;
            this.f7936e = str;
            this.f7937f = i2;
            this.f7938g = map;
            this.f7939h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7940i.f7908b.runOnJSThread(new a(this, this.f7940i.a.a(this.f7936e, false)));
            }
        }
    }

    /* renamed from: c.a.q0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0468e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7944f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7945g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7946h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7947i;

        /* renamed from: c.a.q0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7948e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0468e f7949f;

            public a(RunnableC0468e runnableC0468e, c.a.q0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0468e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7949f = runnableC0468e;
                this.f7948e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7949f.f7944f), "path");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7948e, "stat:", this.f7949f.f7945g);
                    RunnableC0468e runnableC0468e = this.f7949f;
                    if (c.a.q0.a.r0.n.a(v, runnableC0468e.f7946h, hashMap, runnableC0468e.f7947i.f7908b)) {
                        c.a.q0.a.r0.o.h hVar = new c.a.q0.a.r0.o.h();
                        c.a.q0.a.r0.c cVar = this.f7948e;
                        hVar.stats = cVar.f7903d;
                        hVar.errMsg = cVar.f7901b;
                        c.a.q0.a.r0.n.b(hVar, this.f7949f.f7945g);
                    }
                }
            }
        }

        public RunnableC0468e(e eVar, String str, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7947i = eVar;
            this.f7943e = str;
            this.f7944f = i2;
            this.f7945g = map;
            this.f7946h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7947i.f7908b.runOnJSThread(new a(this, this.f7947i.a.y(this.f7943e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7952g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7953h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7954i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7955e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f7956f;

            public a(f fVar, c.a.q0.a.r0.c cVar) {
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
                this.f7956f = fVar;
                this.f7955e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7956f.f7951f), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7955e, "getFileInfo:", this.f7956f.f7952g);
                    f fVar = this.f7956f;
                    if (c.a.q0.a.r0.n.a(v, fVar.f7953h, hashMap, fVar.f7954i.f7908b)) {
                        c.a.q0.a.r0.o.c cVar = new c.a.q0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f7955e.f7901b;
                        c.a.q0.a.r0.c cVar2 = this.f7955e;
                        cVar.digest = cVar2.f7906g;
                        cVar.size = (int) cVar2.f7904e;
                        c.a.q0.a.r0.n.b(cVar, this.f7956f.f7952g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7954i = eVar;
            this.f7950e = str;
            this.f7951f = i2;
            this.f7952g = map;
            this.f7953h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7954i.f7908b.runOnJSThread(new a(this, this.f7954i.a.e(this.f7950e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f7957e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7958f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f7959g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7960e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f7961f;

            public a(g gVar, c.a.q0.a.r0.c cVar) {
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
                this.f7961f = gVar;
                this.f7960e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7960e, "getSavedFileList:", this.f7961f.f7957e);
                    g gVar = this.f7961f;
                    if (c.a.q0.a.r0.n.a(v, gVar.f7958f, null, gVar.f7959g.f7908b)) {
                        c.a.q0.a.r0.o.d dVar = new c.a.q0.a.r0.o.d();
                        List<c.a.q0.a.r0.d> list = this.f7960e.f7905f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.q0.a.r0.d[0] : (c.a.q0.a.r0.d[]) this.f7960e.f7905f.toArray(new c.a.q0.a.r0.d[size]);
                        g gVar2 = this.f7961f;
                        dVar.errMsg = gVar2.f7958f.errMsg;
                        c.a.q0.a.r0.n.b(dVar, gVar2.f7957e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7959g = eVar;
            this.f7957e = map;
            this.f7958f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7959g.f7908b.runOnJSThread(new a(this, this.f7959g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7963f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7965h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7966i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7967e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f7968f;

            public a(h hVar, c.a.q0.a.r0.c cVar) {
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
                this.f7968f = hVar;
                this.f7967e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7968f.f7963f), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7967e, "removeSavedFile:", this.f7968f.f7964g);
                    h hVar = this.f7968f;
                    if (c.a.q0.a.r0.n.a(v, hVar.f7965h, hashMap, hVar.f7966i.f7908b)) {
                        h hVar2 = this.f7968f;
                        c.a.q0.a.r0.n.b(hVar2.f7965h, hVar2.f7964g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7966i = eVar;
            this.f7962e = str;
            this.f7963f = i2;
            this.f7964g = map;
            this.f7965h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7966i.f7908b.runOnJSThread(new a(this, this.f7966i.a.t(this.f7962e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7971g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7972h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7973i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7974j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f7975k;
        public final /* synthetic */ c.a.q0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7976e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f7977f;

            public a(i iVar, c.a.q0.a.r0.c cVar) {
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
                this.f7977f = iVar;
                this.f7976e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7977f.f7975k), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7976e, "writeFile:", this.f7977f.f7972h);
                    i iVar = this.f7977f;
                    if (c.a.q0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f7908b)) {
                        c.a.q0.a.r0.o.b bVar = this.f7977f.l;
                        bVar.errMsg = "writeFile:" + this.f7976e.f7901b;
                        i iVar2 = this.f7977f;
                        c.a.q0.a.r0.n.b(iVar2.l, iVar2.f7972h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.q0.a.r0.o.b bVar) {
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
            this.f7969e = str;
            this.f7970f = str2;
            this.f7971g = bArr;
            this.f7972h = map;
            this.f7973i = str3;
            this.f7974j = i2;
            this.f7975k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.r0.c C = this.m.a.C(false, this.f7969e, TextUtils.isEmpty(this.f7970f) ? this.f7971g : this.f7970f, c.a.q0.a.r0.n.I("encoding", this.f7972h));
                if (!TextUtils.isEmpty(this.f7973i)) {
                    C.f7901b = this.f7973i;
                    C.a = -2;
                    c.a.q0.a.r0.n.d(this.m.f7908b, this.f7973i);
                } else {
                    int i2 = this.f7974j;
                    if (i2 != 7 && i2 != 12) {
                        C.f7901b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.q0.a.r0.n.d(this.m.f7908b, C.f7901b);
                    }
                }
                this.m.f7908b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7980g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7981h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7982i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7983e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f7984f;

            public a(j jVar, c.a.q0.a.r0.c cVar) {
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
                this.f7984f = jVar;
                this.f7983e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7984f.f7979f), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7983e, "unlink:", this.f7984f.f7980g);
                    j jVar = this.f7984f;
                    if (c.a.q0.a.r0.n.a(v, jVar.f7981h, hashMap, jVar.f7982i.f7908b)) {
                        c.a.q0.a.r0.o.b bVar = this.f7984f.f7981h;
                        bVar.errMsg = "unlink:" + this.f7983e.f7901b;
                        j jVar2 = this.f7984f;
                        c.a.q0.a.r0.n.b(jVar2.f7981h, jVar2.f7980g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7982i = eVar;
            this.f7978e = str;
            this.f7979f = i2;
            this.f7980g = map;
            this.f7981h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7982i.f7908b.runOnJSThread(new a(this, this.f7982i.a.z(this.f7978e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7986f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7987g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7988h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7989i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7990j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7991k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f7992e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f7993f;

            public a(k kVar, c.a.q0.a.r0.c cVar) {
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
                this.f7993f = kVar;
                this.f7992e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7993f.f7987g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f7993f.f7988h), "targetPath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f7992e, "unzip:", this.f7993f.f7989i);
                    k kVar = this.f7993f;
                    if (c.a.q0.a.r0.n.a(v, kVar.f7990j, hashMap, kVar.f7991k.f7908b)) {
                        c.a.q0.a.r0.o.b bVar = this.f7993f.f7990j;
                        bVar.errMsg = "unzip:" + this.f7992e.f7901b;
                        k kVar2 = this.f7993f;
                        c.a.q0.a.r0.n.b(kVar2.f7990j, kVar2.f7989i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f7991k = eVar;
            this.f7985e = str;
            this.f7986f = str2;
            this.f7987g = i2;
            this.f7988h = i3;
            this.f7989i = map;
            this.f7990j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7991k.f7908b.runOnJSThread(new a(this, this.f7991k.a.A(this.f7985e, this.f7986f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7996g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7997h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7998i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f7999j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8000k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f8001e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8002f;

            public a(l lVar, c.a.q0.a.r0.c cVar) {
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
                this.f8002f = lVar;
                this.f8001e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8002f.f7996g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8002f.f7997h), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f8001e, "saveFile:", this.f8002f.f7998i);
                    l lVar = this.f8002f;
                    if (c.a.q0.a.r0.n.a(v, lVar.f7999j, hashMap, lVar.f8000k.f7908b)) {
                        c.a.q0.a.r0.o.g gVar = new c.a.q0.a.r0.o.g();
                        List<String> list = this.f8001e.f7902c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8001e.f7901b;
                        c.a.q0.a.r0.n.b(gVar, this.f8002f.f7998i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f8000k = eVar;
            this.f7994e = str;
            this.f7995f = str2;
            this.f7996g = i2;
            this.f7997h = i3;
            this.f7998i = map;
            this.f7999j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8000k.f7908b.runOnJSThread(new a(this, this.f8000k.a.x(this.f7994e, this.f7995f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8004f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8005g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f8006h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8007i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f8008e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8009f;

            public a(m mVar, c.a.q0.a.r0.c cVar) {
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
                this.f8009f = mVar;
                this.f8008e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8009f.f8004f), "dirPath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f8008e, "readdir:", this.f8009f.f8005g);
                    m mVar = this.f8009f;
                    if (c.a.q0.a.r0.n.a(v, mVar.f8006h, hashMap, mVar.f8007i.f7908b)) {
                        c.a.q0.a.r0.o.e eVar = new c.a.q0.a.r0.o.e();
                        List<String> list = this.f8008e.f7902c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8008e.f7902c.toArray(new String[size]);
                        eVar.errMsg = this.f8008e.f7901b;
                        c.a.q0.a.r0.n.b(eVar, this.f8009f.f8005g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f8007i = eVar;
            this.f8003e = str;
            this.f8004f = i2;
            this.f8005g = map;
            this.f8006h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8007i.f7908b.runOnJSThread(new a(this, this.f8007i.a.s(this.f8003e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8010e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8011f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8012g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8013h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f8014i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8015j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f8016e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8017f;

            public a(n nVar, c.a.q0.a.r0.c cVar) {
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
                this.f8017f = nVar;
                this.f8016e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8017f.f8012g), "dirPath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f8016e, "rmdir:", this.f8017f.f8013h);
                    n nVar = this.f8017f;
                    if (c.a.q0.a.r0.n.a(v, nVar.f8014i, hashMap, nVar.f8015j.f7908b)) {
                        n nVar2 = this.f8017f;
                        c.a.q0.a.r0.n.b(nVar2.f8014i, nVar2.f8013h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f8015j = eVar;
            this.f8010e = str;
            this.f8011f = bool;
            this.f8012g = i2;
            this.f8013h = map;
            this.f8014i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8015j.f7908b.runOnJSThread(new a(this, this.f8015j.a.v(this.f8010e, this.f8011f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8019f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8020g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8021h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8022i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f8023j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8024k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f8025e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8026f;

            public a(o oVar, c.a.q0.a.r0.c cVar) {
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
                this.f8026f = oVar;
                this.f8025e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8026f.f8021h), "filePath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f8025e, "readFile:", this.f8026f.f8022i);
                    o oVar = this.f8026f;
                    if (c.a.q0.a.r0.n.a(v, oVar.f8023j, hashMap, oVar.f8024k.f7908b)) {
                        if (TextUtils.isEmpty(this.f8026f.f8019f)) {
                            c.a.q0.a.r0.o.a aVar = new c.a.q0.a.r0.o.a();
                            c.a.q0.a.r0.c cVar = this.f8025e;
                            if (cVar.f7907h == null) {
                                cVar.f7907h = new byte[0];
                            }
                            byte[] bArr = this.f8025e.f7907h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8025e.f7901b;
                            c.a.q0.a.r0.n.b(aVar, this.f8026f.f8022i);
                            return;
                        }
                        List<String> list = this.f8025e.f7902c;
                        String str = list != null ? list.get(0) : null;
                        c.a.q0.a.r0.o.f fVar = new c.a.q0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8025e.f7901b;
                        c.a.q0.a.r0.n.b(fVar, this.f8026f.f8022i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f8024k = eVar;
            this.f8018e = str;
            this.f8019f = str2;
            this.f8020g = i2;
            this.f8021h = i3;
            this.f8022i = map;
            this.f8023j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.r0.c q = this.f8024k.a.q(this.f8018e, this.f8019f, false);
                int i2 = this.f8020g;
                if (i2 != 7 && i2 != 12) {
                    q.f7901b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.q0.a.r0.n.d(this.f8024k.f7908b, q.f7901b);
                }
                this.f8024k.f7908b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8028f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8029g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8030h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8031i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.r0.o.b f8032j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8033k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.r0.c f8034e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8035f;

            public a(p pVar, c.a.q0.a.r0.c cVar) {
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
                this.f8035f = pVar;
                this.f8034e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8035f.f8029g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8035f.f8030h), "newPath");
                    c.a.q0.a.r0.b v = c.a.q0.a.r0.n.v(this.f8034e, "rename:", this.f8035f.f8031i);
                    p pVar = this.f8035f;
                    if (c.a.q0.a.r0.n.a(v, pVar.f8032j, hashMap, pVar.f8033k.f7908b)) {
                        p pVar2 = this.f8035f;
                        c.a.q0.a.r0.n.b(pVar2.f8032j, pVar2.f8031i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.q0.a.r0.o.b bVar) {
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
            this.f8033k = eVar;
            this.f8027e = str;
            this.f8028f = str2;
            this.f8029g = i2;
            this.f8030h = i3;
            this.f8031i = map;
            this.f8032j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8033k.f7908b.runOnJSThread(new a(this, this.f8033k.a.u(this.f8027e, this.f8028f, false)));
            }
        }
    }

    public e(c.a.q0.a.l0.a aVar) {
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
        this.f7908b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("path", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("path", J);
            this.f7909c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("encoding", jsObject);
            int O2 = c.a.q0.a.r0.n.O("filePath", jsObject);
            int O3 = c.a.q0.a.r0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : c.a.q0.a.r0.n.w(O3);
            byte[] r = c.a.q0.a.r0.n.r(jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("data", J);
            String I2 = c.a.q0.a.r0.n.I("filePath", J);
            this.f7909c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.q0.a.o2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.a.d2.e a0 = c.a.q0.a.d2.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new c.a.q0.a.r0.l();
            }
            this.a = new c.a.q0.a.r0.f(AppRuntime.getAppContext(), c.a.q0.a.g1.f.U().z(), lVar);
            this.f7909c = c.a.q0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("srcPath", jsObject);
            int O2 = c.a.q0.a.r0.n.O("destPath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("srcPath", J);
            String I2 = c.a.q0.a.r0.n.I("destPath", J);
            this.f7909c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str, str2);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("filePath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("filePath", J);
            this.f7909c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.q0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.q0.a.r0.n.J(this.a, jsObject, (bVar = new c.a.q0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f7909c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("dirPath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("dirPath", J);
            this.f7909c.h(new a(this, I, (Boolean) c.a.q0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("filePath", jsObject);
            int O2 = c.a.q0.a.r0.n.O("encoding", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("encoding", J);
            String I2 = c.a.q0.a.r0.n.I("filePath", J);
            this.f7909c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
                this.f7909c.k(str);
                c.a.q0.a.r0.c q = this.a.q(str, str2, true);
                c.a.q0.a.r0.n.d0(this.f7908b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f7902c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("dirPath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("dirPath", J);
            this.f7909c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
                this.f7909c.k(str);
                c.a.q0.a.r0.c s = this.a.s(str, true);
                c.a.q0.a.r0.n.d0(this.f7908b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f7902c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f7902c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("filePath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f7909c.h(new h(this, c.a.q0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("oldPath", jsObject);
            int O2 = c.a.q0.a.r0.n.O("newPath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("oldPath", J);
            String I2 = c.a.q0.a.r0.n.I("newPath", J);
            this.f7909c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str, str2);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("dirPath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("dirPath", J);
            this.f7909c.h(new n(this, I, (Boolean) c.a.q0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("tempFilePath", jsObject);
            int O2 = c.a.q0.a.r0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("tempFilePath", J);
            String I2 = c.a.q0.a.r0.n.I("filePath", J);
            this.f7909c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.q0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("path", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("path", J);
            this.f7909c.h(new RunnableC0468e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.q0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
                this.f7909c.k(str);
                c.a.q0.a.r0.c y = this.a.y(str, true);
                c.a.q0.a.r0.n.d0(this.f7908b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f7903d;
            }
            return null;
        }
        return (c.a.q0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("filePath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("filePath", J);
            this.f7909c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = c.a.q0.a.r0.n.O("targetPath", jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("zipFilePath", J);
            String I2 = c.a.q0.a.r0.n.I("targetPath", J);
            this.f7909c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.q0.a.r0.n.O("filePath", jsObject);
            String w = c.a.q0.a.r0.n.w(c.a.q0.a.r0.n.O("data", jsObject));
            int O2 = c.a.q0.a.r0.n.O("encoding", jsObject);
            byte[] r = c.a.q0.a.r0.n.r(jsObject);
            c.a.q0.a.r0.o.b bVar = new c.a.q0.a.r0.o.b();
            Map<String, Object> J = c.a.q0.a.r0.n.J(this.a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.q0.a.r0.n.I("data", J);
            String I2 = c.a.q0.a.r0.n.I("filePath", J);
            this.f7909c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
                this.f7909c.k(str, str2);
                c.a.q0.a.r0.c x = this.a.x(str, str2, true);
                c.a.q0.a.r0.n.d0(this.f7908b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f7902c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
            this.f7909c.k(str);
            c.a.q0.a.r0.n.d0(this.f7908b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.q0.a.r0.n.T(this.a, this.f7908b, null, null)) {
                this.f7909c.k(str);
                c.a.q0.a.r0.c q = this.a.q(str, null, true);
                c.a.q0.a.r0.n.d0(this.f7908b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f7907h == null) {
                    q.f7907h = new byte[0];
                }
                byte[] bArr = q.f7907h;
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
