package c.a.r0.a.r0;

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
    public c.a.r0.a.r0.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.l0.a f8643b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.r0.i f8644c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8646f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8647g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8648h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8649i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8650j;

        /* renamed from: c.a.r0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0517a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8651e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8652f;

            public RunnableC0517a(a aVar, c.a.r0.a.r0.c cVar) {
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
                this.f8652f = aVar;
                this.f8651e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8652f.f8647g), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8651e, "mkdir:", this.f8652f.f8648h);
                    a aVar = this.f8652f;
                    if (c.a.r0.a.r0.n.a(v, aVar.f8649i, hashMap, aVar.f8650j.f8643b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8652f.f8649i;
                        bVar.errMsg = "mkdir:" + this.f8651e.f8636b;
                        a aVar2 = this.f8652f;
                        c.a.r0.a.r0.n.b(aVar2.f8649i, aVar2.f8648h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8650j = eVar;
            this.f8645e = str;
            this.f8646f = bool;
            this.f8647g = i2;
            this.f8648h = map;
            this.f8649i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8650j.f8643b.runOnJSThread(new RunnableC0517a(this, this.f8650j.a.o(this.f8645e, this.f8646f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8654f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8655g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8656h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8657i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8658j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8659k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8660e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8661f;

            public a(b bVar, c.a.r0.a.r0.c cVar) {
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
                this.f8661f = bVar;
                this.f8660e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8661f.f8655g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8661f.f8656h), "destPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8660e, "copyFile:", this.f8661f.f8657i);
                    b bVar = this.f8661f;
                    if (c.a.r0.a.r0.n.a(v, bVar.f8658j, hashMap, bVar.f8659k.f8643b)) {
                        b bVar2 = this.f8661f;
                        c.a.r0.a.r0.n.b(bVar2.f8658j, bVar2.f8657i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8659k = eVar;
            this.f8653e = str;
            this.f8654f = str2;
            this.f8655g = i2;
            this.f8656h = i3;
            this.f8657i = map;
            this.f8658j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8659k.f8643b.runOnJSThread(new a(this, this.f8659k.a.c(this.f8653e, this.f8654f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8663f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8664g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8665h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8666i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8667j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f8668k;
        public final /* synthetic */ c.a.r0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8669e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8670f;

            public a(c cVar, c.a.r0.a.r0.c cVar2) {
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
                this.f8670f = cVar;
                this.f8669e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8670f.f8668k), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8669e, "appendFile:", this.f8670f.f8665h);
                    c cVar = this.f8670f;
                    if (c.a.r0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f8643b)) {
                        c cVar2 = this.f8670f;
                        c.a.r0.a.r0.n.b(cVar2.l, cVar2.f8665h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.r0.a.r0.o.b bVar) {
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
            this.f8662e = str;
            this.f8663f = str2;
            this.f8664g = bArr;
            this.f8665h = map;
            this.f8666i = str3;
            this.f8667j = i2;
            this.f8668k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c b2 = this.m.a.b(this.f8662e, TextUtils.isEmpty(this.f8663f) ? this.f8664g : this.f8663f, c.a.r0.a.r0.n.I("encoding", this.f8665h), false);
                if (!TextUtils.isEmpty(this.f8666i)) {
                    b2.f8636b = this.f8666i;
                    b2.a = -2;
                    c.a.r0.a.r0.n.d(this.m.f8643b, this.f8666i);
                } else {
                    int i2 = this.f8667j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8636b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.r0.a.r0.n.d(this.m.f8643b, b2.f8636b);
                    }
                }
                this.m.f8643b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8672f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8673g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8674h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8675i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8676e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8677f;

            public a(d dVar, c.a.r0.a.r0.c cVar) {
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
                this.f8677f = dVar;
                this.f8676e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8677f.f8672f), "path");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8676e, "access:", this.f8677f.f8673g);
                    d dVar = this.f8677f;
                    if (c.a.r0.a.r0.n.a(v, dVar.f8674h, hashMap, dVar.f8675i.f8643b)) {
                        d dVar2 = this.f8677f;
                        c.a.r0.a.r0.n.b(dVar2.f8674h, dVar2.f8673g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8675i = eVar;
            this.f8671e = str;
            this.f8672f = i2;
            this.f8673g = map;
            this.f8674h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8675i.f8643b.runOnJSThread(new a(this, this.f8675i.a.a(this.f8671e, false)));
            }
        }
    }

    /* renamed from: c.a.r0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0518e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8681h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8682i;

        /* renamed from: c.a.r0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8683e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0518e f8684f;

            public a(RunnableC0518e runnableC0518e, c.a.r0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0518e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8684f = runnableC0518e;
                this.f8683e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8684f.f8679f), "path");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8683e, "stat:", this.f8684f.f8680g);
                    RunnableC0518e runnableC0518e = this.f8684f;
                    if (c.a.r0.a.r0.n.a(v, runnableC0518e.f8681h, hashMap, runnableC0518e.f8682i.f8643b)) {
                        c.a.r0.a.r0.o.h hVar = new c.a.r0.a.r0.o.h();
                        c.a.r0.a.r0.c cVar = this.f8683e;
                        hVar.stats = cVar.f8638d;
                        hVar.errMsg = cVar.f8636b;
                        c.a.r0.a.r0.n.b(hVar, this.f8684f.f8680g);
                    }
                }
            }
        }

        public RunnableC0518e(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8682i = eVar;
            this.f8678e = str;
            this.f8679f = i2;
            this.f8680g = map;
            this.f8681h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8682i.f8643b.runOnJSThread(new a(this, this.f8682i.a.y(this.f8678e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8686f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8687g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8688h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8689i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8690e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8691f;

            public a(f fVar, c.a.r0.a.r0.c cVar) {
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
                this.f8691f = fVar;
                this.f8690e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8691f.f8686f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8690e, "getFileInfo:", this.f8691f.f8687g);
                    f fVar = this.f8691f;
                    if (c.a.r0.a.r0.n.a(v, fVar.f8688h, hashMap, fVar.f8689i.f8643b)) {
                        c.a.r0.a.r0.o.c cVar = new c.a.r0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8690e.f8636b;
                        c.a.r0.a.r0.c cVar2 = this.f8690e;
                        cVar.digest = cVar2.f8641g;
                        cVar.size = (int) cVar2.f8639e;
                        c.a.r0.a.r0.n.b(cVar, this.f8691f.f8687g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8689i = eVar;
            this.f8685e = str;
            this.f8686f = i2;
            this.f8687g = map;
            this.f8688h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8689i.f8643b.runOnJSThread(new a(this, this.f8689i.a.e(this.f8685e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8693f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8694g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8695e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8696f;

            public a(g gVar, c.a.r0.a.r0.c cVar) {
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
                this.f8696f = gVar;
                this.f8695e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8695e, "getSavedFileList:", this.f8696f.f8692e);
                    g gVar = this.f8696f;
                    if (c.a.r0.a.r0.n.a(v, gVar.f8693f, null, gVar.f8694g.f8643b)) {
                        c.a.r0.a.r0.o.d dVar = new c.a.r0.a.r0.o.d();
                        List<c.a.r0.a.r0.d> list = this.f8695e.f8640f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.r0.a.r0.d[0] : (c.a.r0.a.r0.d[]) this.f8695e.f8640f.toArray(new c.a.r0.a.r0.d[size]);
                        g gVar2 = this.f8696f;
                        dVar.errMsg = gVar2.f8693f.errMsg;
                        c.a.r0.a.r0.n.b(dVar, gVar2.f8692e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8694g = eVar;
            this.f8692e = map;
            this.f8693f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8694g.f8643b.runOnJSThread(new a(this, this.f8694g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8699g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8700h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8701i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8702e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8703f;

            public a(h hVar, c.a.r0.a.r0.c cVar) {
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
                this.f8703f = hVar;
                this.f8702e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8703f.f8698f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8702e, "removeSavedFile:", this.f8703f.f8699g);
                    h hVar = this.f8703f;
                    if (c.a.r0.a.r0.n.a(v, hVar.f8700h, hashMap, hVar.f8701i.f8643b)) {
                        h hVar2 = this.f8703f;
                        c.a.r0.a.r0.n.b(hVar2.f8700h, hVar2.f8699g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8701i = eVar;
            this.f8697e = str;
            this.f8698f = i2;
            this.f8699g = map;
            this.f8700h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8701i.f8643b.runOnJSThread(new a(this, this.f8701i.a.t(this.f8697e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8706g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8707h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8708i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8709j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f8710k;
        public final /* synthetic */ c.a.r0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8711e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8712f;

            public a(i iVar, c.a.r0.a.r0.c cVar) {
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
                this.f8712f = iVar;
                this.f8711e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8712f.f8710k), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8711e, "writeFile:", this.f8712f.f8707h);
                    i iVar = this.f8712f;
                    if (c.a.r0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f8643b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8712f.l;
                        bVar.errMsg = "writeFile:" + this.f8711e.f8636b;
                        i iVar2 = this.f8712f;
                        c.a.r0.a.r0.n.b(iVar2.l, iVar2.f8707h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.r0.a.r0.o.b bVar) {
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
            this.f8704e = str;
            this.f8705f = str2;
            this.f8706g = bArr;
            this.f8707h = map;
            this.f8708i = str3;
            this.f8709j = i2;
            this.f8710k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c C = this.m.a.C(false, this.f8704e, TextUtils.isEmpty(this.f8705f) ? this.f8706g : this.f8705f, c.a.r0.a.r0.n.I("encoding", this.f8707h));
                if (!TextUtils.isEmpty(this.f8708i)) {
                    C.f8636b = this.f8708i;
                    C.a = -2;
                    c.a.r0.a.r0.n.d(this.m.f8643b, this.f8708i);
                } else {
                    int i2 = this.f8709j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8636b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.r0.a.r0.n.d(this.m.f8643b, C.f8636b);
                    }
                }
                this.m.f8643b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8714f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8715g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8716h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8717i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8718e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8719f;

            public a(j jVar, c.a.r0.a.r0.c cVar) {
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
                this.f8719f = jVar;
                this.f8718e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8719f.f8714f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8718e, "unlink:", this.f8719f.f8715g);
                    j jVar = this.f8719f;
                    if (c.a.r0.a.r0.n.a(v, jVar.f8716h, hashMap, jVar.f8717i.f8643b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8719f.f8716h;
                        bVar.errMsg = "unlink:" + this.f8718e.f8636b;
                        j jVar2 = this.f8719f;
                        c.a.r0.a.r0.n.b(jVar2.f8716h, jVar2.f8715g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8717i = eVar;
            this.f8713e = str;
            this.f8714f = i2;
            this.f8715g = map;
            this.f8716h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8717i.f8643b.runOnJSThread(new a(this, this.f8717i.a.z(this.f8713e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8720e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8721f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8722g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8723h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8724i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8725j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8726k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8727e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8728f;

            public a(k kVar, c.a.r0.a.r0.c cVar) {
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
                this.f8728f = kVar;
                this.f8727e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8728f.f8722g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8728f.f8723h), "targetPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8727e, "unzip:", this.f8728f.f8724i);
                    k kVar = this.f8728f;
                    if (c.a.r0.a.r0.n.a(v, kVar.f8725j, hashMap, kVar.f8726k.f8643b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8728f.f8725j;
                        bVar.errMsg = "unzip:" + this.f8727e.f8636b;
                        k kVar2 = this.f8728f;
                        c.a.r0.a.r0.n.b(kVar2.f8725j, kVar2.f8724i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8726k = eVar;
            this.f8720e = str;
            this.f8721f = str2;
            this.f8722g = i2;
            this.f8723h = i3;
            this.f8724i = map;
            this.f8725j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8726k.f8643b.runOnJSThread(new a(this, this.f8726k.a.A(this.f8720e, this.f8721f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8730f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8731g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8732h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8733i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8734j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8735k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8736e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8737f;

            public a(l lVar, c.a.r0.a.r0.c cVar) {
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
                this.f8737f = lVar;
                this.f8736e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8737f.f8731g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8737f.f8732h), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8736e, "saveFile:", this.f8737f.f8733i);
                    l lVar = this.f8737f;
                    if (c.a.r0.a.r0.n.a(v, lVar.f8734j, hashMap, lVar.f8735k.f8643b)) {
                        c.a.r0.a.r0.o.g gVar = new c.a.r0.a.r0.o.g();
                        List<String> list = this.f8736e.f8637c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8736e.f8636b;
                        c.a.r0.a.r0.n.b(gVar, this.f8737f.f8733i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8735k = eVar;
            this.f8729e = str;
            this.f8730f = str2;
            this.f8731g = i2;
            this.f8732h = i3;
            this.f8733i = map;
            this.f8734j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8735k.f8643b.runOnJSThread(new a(this, this.f8735k.a.x(this.f8729e, this.f8730f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8739f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8740g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8741h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8742i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8743e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8744f;

            public a(m mVar, c.a.r0.a.r0.c cVar) {
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
                this.f8744f = mVar;
                this.f8743e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8744f.f8739f), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8743e, "readdir:", this.f8744f.f8740g);
                    m mVar = this.f8744f;
                    if (c.a.r0.a.r0.n.a(v, mVar.f8741h, hashMap, mVar.f8742i.f8643b)) {
                        c.a.r0.a.r0.o.e eVar = new c.a.r0.a.r0.o.e();
                        List<String> list = this.f8743e.f8637c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8743e.f8637c.toArray(new String[size]);
                        eVar.errMsg = this.f8743e.f8636b;
                        c.a.r0.a.r0.n.b(eVar, this.f8744f.f8740g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8742i = eVar;
            this.f8738e = str;
            this.f8739f = i2;
            this.f8740g = map;
            this.f8741h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8742i.f8643b.runOnJSThread(new a(this, this.f8742i.a.s(this.f8738e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8745e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8746f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8747g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8748h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8749i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8750j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8751e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8752f;

            public a(n nVar, c.a.r0.a.r0.c cVar) {
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
                this.f8752f = nVar;
                this.f8751e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8752f.f8747g), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8751e, "rmdir:", this.f8752f.f8748h);
                    n nVar = this.f8752f;
                    if (c.a.r0.a.r0.n.a(v, nVar.f8749i, hashMap, nVar.f8750j.f8643b)) {
                        n nVar2 = this.f8752f;
                        c.a.r0.a.r0.n.b(nVar2.f8749i, nVar2.f8748h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8750j = eVar;
            this.f8745e = str;
            this.f8746f = bool;
            this.f8747g = i2;
            this.f8748h = map;
            this.f8749i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8750j.f8643b.runOnJSThread(new a(this, this.f8750j.a.v(this.f8745e, this.f8746f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8753e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8755g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8756h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8757i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8758j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8759k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8760e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8761f;

            public a(o oVar, c.a.r0.a.r0.c cVar) {
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
                this.f8761f = oVar;
                this.f8760e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8761f.f8756h), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8760e, "readFile:", this.f8761f.f8757i);
                    o oVar = this.f8761f;
                    if (c.a.r0.a.r0.n.a(v, oVar.f8758j, hashMap, oVar.f8759k.f8643b)) {
                        if (TextUtils.isEmpty(this.f8761f.f8754f)) {
                            c.a.r0.a.r0.o.a aVar = new c.a.r0.a.r0.o.a();
                            c.a.r0.a.r0.c cVar = this.f8760e;
                            if (cVar.f8642h == null) {
                                cVar.f8642h = new byte[0];
                            }
                            byte[] bArr = this.f8760e.f8642h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8760e.f8636b;
                            c.a.r0.a.r0.n.b(aVar, this.f8761f.f8757i);
                            return;
                        }
                        List<String> list = this.f8760e.f8637c;
                        String str = list != null ? list.get(0) : null;
                        c.a.r0.a.r0.o.f fVar = new c.a.r0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8760e.f8636b;
                        c.a.r0.a.r0.n.b(fVar, this.f8761f.f8757i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8759k = eVar;
            this.f8753e = str;
            this.f8754f = str2;
            this.f8755g = i2;
            this.f8756h = i3;
            this.f8757i = map;
            this.f8758j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c q = this.f8759k.a.q(this.f8753e, this.f8754f, false);
                int i2 = this.f8755g;
                if (i2 != 7 && i2 != 12) {
                    q.f8636b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.r0.a.r0.n.d(this.f8759k.f8643b, q.f8636b);
                }
                this.f8759k.f8643b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8763f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8764g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8765h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8766i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8767j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f8768k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8769e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8770f;

            public a(p pVar, c.a.r0.a.r0.c cVar) {
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
                this.f8770f = pVar;
                this.f8769e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8770f.f8764g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8770f.f8765h), "newPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8769e, "rename:", this.f8770f.f8766i);
                    p pVar = this.f8770f;
                    if (c.a.r0.a.r0.n.a(v, pVar.f8767j, hashMap, pVar.f8768k.f8643b)) {
                        p pVar2 = this.f8770f;
                        c.a.r0.a.r0.n.b(pVar2.f8767j, pVar2.f8766i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8768k = eVar;
            this.f8762e = str;
            this.f8763f = str2;
            this.f8764g = i2;
            this.f8765h = i3;
            this.f8766i = map;
            this.f8767j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8768k.f8643b.runOnJSThread(new a(this, this.f8768k.a.u(this.f8762e, this.f8763f, false)));
            }
        }
    }

    public e(c.a.r0.a.l0.a aVar) {
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
        this.f8643b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("path", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("path", J);
            this.f8644c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("encoding", jsObject);
            int O2 = c.a.r0.a.r0.n.O("filePath", jsObject);
            int O3 = c.a.r0.a.r0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : c.a.r0.a.r0.n.w(O3);
            byte[] r = c.a.r0.a.r0.n.r(jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("data", J);
            String I2 = c.a.r0.a.r0.n.I("filePath", J);
            this.f8644c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.r0.a.o2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new c.a.r0.a.r0.l();
            }
            this.a = new c.a.r0.a.r0.f(AppRuntime.getAppContext(), c.a.r0.a.g1.f.U().z(), lVar);
            this.f8644c = c.a.r0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("srcPath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("destPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("srcPath", J);
            String I2 = c.a.r0.a.r0.n.I("destPath", J);
            this.f8644c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str, str2);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("filePath", J);
            this.f8644c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.r0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.r0.a.r0.n.J(this.a, jsObject, (bVar = new c.a.r0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8644c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8644c.h(new a(this, I, (Boolean) c.a.r0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("encoding", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("encoding", J);
            String I2 = c.a.r0.a.r0.n.I("filePath", J);
            this.f8644c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
                this.f8644c.k(str);
                c.a.r0.a.r0.c q = this.a.q(str, str2, true);
                c.a.r0.a.r0.n.d0(this.f8643b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f8637c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8644c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
                this.f8644c.k(str);
                c.a.r0.a.r0.c s = this.a.s(str, true);
                c.a.r0.a.r0.n.d0(this.f8643b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8637c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8637c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f8644c.h(new h(this, c.a.r0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("oldPath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("newPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("oldPath", J);
            String I2 = c.a.r0.a.r0.n.I("newPath", J);
            this.f8644c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str, str2);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8644c.h(new n(this, I, (Boolean) c.a.r0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("tempFilePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("tempFilePath", J);
            String I2 = c.a.r0.a.r0.n.I("filePath", J);
            this.f8644c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.r0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("path", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("path", J);
            this.f8644c.h(new RunnableC0518e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.r0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
                this.f8644c.k(str);
                c.a.r0.a.r0.c y = this.a.y(str, true);
                c.a.r0.a.r0.n.d0(this.f8643b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f8638d;
            }
            return null;
        }
        return (c.a.r0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("filePath", J);
            this.f8644c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("targetPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("zipFilePath", J);
            String I2 = c.a.r0.a.r0.n.I("targetPath", J);
            this.f8644c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            String w = c.a.r0.a.r0.n.w(c.a.r0.a.r0.n.O("data", jsObject));
            int O2 = c.a.r0.a.r0.n.O("encoding", jsObject);
            byte[] r = c.a.r0.a.r0.n.r(jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("data", J);
            String I2 = c.a.r0.a.r0.n.I("filePath", J);
            this.f8644c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
                this.f8644c.k(str, str2);
                c.a.r0.a.r0.c x = this.a.x(str, str2, true);
                c.a.r0.a.r0.n.d0(this.f8643b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f8637c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
            this.f8644c.k(str);
            c.a.r0.a.r0.n.d0(this.f8643b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8643b, null, null)) {
                this.f8644c.k(str);
                c.a.r0.a.r0.c q = this.a.q(str, null, true);
                c.a.r0.a.r0.n.d0(this.f8643b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8642h == null) {
                    q.f8642h = new byte[0];
                }
                byte[] bArr = q.f8642h;
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
