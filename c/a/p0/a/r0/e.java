package c.a.p0.a.r0;

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
    public c.a.p0.a.r0.f f8173a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.l0.a f8174b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.r0.i f8175c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8176e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8177f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8178g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8179h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8180i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8181j;

        /* renamed from: c.a.p0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0356a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8182e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8183f;

            public RunnableC0356a(a aVar, c.a.p0.a.r0.c cVar) {
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
                this.f8183f = aVar;
                this.f8182e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8183f.f8178g), "dirPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8182e, "mkdir:", this.f8183f.f8179h);
                    a aVar = this.f8183f;
                    if (c.a.p0.a.r0.n.a(t, aVar.f8180i, hashMap, aVar.f8181j.f8174b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8183f.f8180i;
                        bVar.errMsg = "mkdir:" + this.f8182e.f8166b;
                        a aVar2 = this.f8183f;
                        c.a.p0.a.r0.n.b(aVar2.f8180i, aVar2.f8179h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8181j = eVar;
            this.f8176e = str;
            this.f8177f = bool;
            this.f8178g = i2;
            this.f8179h = map;
            this.f8180i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8181j.f8174b.runOnJSThread(new RunnableC0356a(this, this.f8181j.f8173a.o(this.f8176e, this.f8177f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8184e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8185f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8186g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8187h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8188i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8189j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8190e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8191f;

            public a(b bVar, c.a.p0.a.r0.c cVar) {
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
                this.f8191f = bVar;
                this.f8190e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8191f.f8186g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8191f.f8187h), "destPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8190e, "copyFile:", this.f8191f.f8188i);
                    b bVar = this.f8191f;
                    if (c.a.p0.a.r0.n.a(t, bVar.f8189j, hashMap, bVar.k.f8174b)) {
                        b bVar2 = this.f8191f;
                        c.a.p0.a.r0.n.b(bVar2.f8189j, bVar2.f8188i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8184e = str;
            this.f8185f = str2;
            this.f8186g = i2;
            this.f8187h = i3;
            this.f8188i = map;
            this.f8189j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8174b.runOnJSThread(new a(this, this.k.f8173a.c(this.f8184e, this.f8185f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8194g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8195h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8196i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8197j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8198e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8199f;

            public a(c cVar, c.a.p0.a.r0.c cVar2) {
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
                this.f8199f = cVar;
                this.f8198e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8199f.k), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8198e, "appendFile:", this.f8199f.f8195h);
                    c cVar = this.f8199f;
                    if (c.a.p0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f8174b)) {
                        c cVar2 = this.f8199f;
                        c.a.p0.a.r0.n.b(cVar2.l, cVar2.f8195h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.p0.a.r0.o.b bVar) {
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
            this.f8192e = str;
            this.f8193f = str2;
            this.f8194g = bArr;
            this.f8195h = map;
            this.f8196i = str3;
            this.f8197j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c b2 = this.m.f8173a.b(this.f8192e, TextUtils.isEmpty(this.f8193f) ? this.f8194g : this.f8193f, c.a.p0.a.r0.n.F("encoding", this.f8195h), false);
                if (!TextUtils.isEmpty(this.f8196i)) {
                    b2.f8166b = this.f8196i;
                    b2.f8165a = -2;
                    c.a.p0.a.r0.n.d(this.m.f8174b, this.f8196i);
                } else {
                    int i2 = this.f8197j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8166b = "fail encoding must be a string";
                        b2.f8165a = -2;
                        c.a.p0.a.r0.n.d(this.m.f8174b, b2.f8166b);
                    }
                }
                this.m.f8174b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8201f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8202g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8203h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8204i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8205e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8206f;

            public a(d dVar, c.a.p0.a.r0.c cVar) {
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
                this.f8206f = dVar;
                this.f8205e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8206f.f8201f), "path");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8205e, "access:", this.f8206f.f8202g);
                    d dVar = this.f8206f;
                    if (c.a.p0.a.r0.n.a(t, dVar.f8203h, hashMap, dVar.f8204i.f8174b)) {
                        d dVar2 = this.f8206f;
                        c.a.p0.a.r0.n.b(dVar2.f8203h, dVar2.f8202g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8204i = eVar;
            this.f8200e = str;
            this.f8201f = i2;
            this.f8202g = map;
            this.f8203h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8204i.f8174b.runOnJSThread(new a(this, this.f8204i.f8173a.a(this.f8200e, false)));
            }
        }
    }

    /* renamed from: c.a.p0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0357e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8208f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8209g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8210h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8211i;

        /* renamed from: c.a.p0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8212e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0357e f8213f;

            public a(RunnableC0357e runnableC0357e, c.a.p0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0357e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8213f = runnableC0357e;
                this.f8212e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8213f.f8208f), "path");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8212e, "stat:", this.f8213f.f8209g);
                    RunnableC0357e runnableC0357e = this.f8213f;
                    if (c.a.p0.a.r0.n.a(t, runnableC0357e.f8210h, hashMap, runnableC0357e.f8211i.f8174b)) {
                        c.a.p0.a.r0.o.h hVar = new c.a.p0.a.r0.o.h();
                        c.a.p0.a.r0.c cVar = this.f8212e;
                        hVar.stats = cVar.f8168d;
                        hVar.errMsg = cVar.f8166b;
                        c.a.p0.a.r0.n.b(hVar, this.f8213f.f8209g);
                    }
                }
            }
        }

        public RunnableC0357e(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8211i = eVar;
            this.f8207e = str;
            this.f8208f = i2;
            this.f8209g = map;
            this.f8210h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8211i.f8174b.runOnJSThread(new a(this, this.f8211i.f8173a.y(this.f8207e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8215f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8216g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8217h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8218i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8219e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8220f;

            public a(f fVar, c.a.p0.a.r0.c cVar) {
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
                this.f8220f = fVar;
                this.f8219e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8220f.f8215f), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8219e, "getFileInfo:", this.f8220f.f8216g);
                    f fVar = this.f8220f;
                    if (c.a.p0.a.r0.n.a(t, fVar.f8217h, hashMap, fVar.f8218i.f8174b)) {
                        c.a.p0.a.r0.o.c cVar = new c.a.p0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8219e.f8166b;
                        c.a.p0.a.r0.c cVar2 = this.f8219e;
                        cVar.digest = cVar2.f8171g;
                        cVar.size = (int) cVar2.f8169e;
                        c.a.p0.a.r0.n.b(cVar, this.f8220f.f8216g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8218i = eVar;
            this.f8214e = str;
            this.f8215f = i2;
            this.f8216g = map;
            this.f8217h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8218i.f8174b.runOnJSThread(new a(this, this.f8218i.f8173a.e(this.f8214e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8222f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8223g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8224e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8225f;

            public a(g gVar, c.a.p0.a.r0.c cVar) {
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
                this.f8225f = gVar;
                this.f8224e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8224e, "getSavedFileList:", this.f8225f.f8221e);
                    g gVar = this.f8225f;
                    if (c.a.p0.a.r0.n.a(t, gVar.f8222f, null, gVar.f8223g.f8174b)) {
                        c.a.p0.a.r0.o.d dVar = new c.a.p0.a.r0.o.d();
                        List<c.a.p0.a.r0.d> list = this.f8224e.f8170f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.p0.a.r0.d[0] : (c.a.p0.a.r0.d[]) this.f8224e.f8170f.toArray(new c.a.p0.a.r0.d[size]);
                        g gVar2 = this.f8225f;
                        dVar.errMsg = gVar2.f8222f.errMsg;
                        c.a.p0.a.r0.n.b(dVar, gVar2.f8221e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8223g = eVar;
            this.f8221e = map;
            this.f8222f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8223g.f8174b.runOnJSThread(new a(this, this.f8223g.f8173a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8227f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8228g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8229h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8230i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8231e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8232f;

            public a(h hVar, c.a.p0.a.r0.c cVar) {
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
                this.f8232f = hVar;
                this.f8231e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8232f.f8227f), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8231e, "removeSavedFile:", this.f8232f.f8228g);
                    h hVar = this.f8232f;
                    if (c.a.p0.a.r0.n.a(t, hVar.f8229h, hashMap, hVar.f8230i.f8174b)) {
                        h hVar2 = this.f8232f;
                        c.a.p0.a.r0.n.b(hVar2.f8229h, hVar2.f8228g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8230i = eVar;
            this.f8226e = str;
            this.f8227f = i2;
            this.f8228g = map;
            this.f8229h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8230i.f8174b.runOnJSThread(new a(this, this.f8230i.f8173a.t(this.f8226e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8234f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8235g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8236h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8237i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8238j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8239e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8240f;

            public a(i iVar, c.a.p0.a.r0.c cVar) {
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
                this.f8240f = iVar;
                this.f8239e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8240f.k), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8239e, "writeFile:", this.f8240f.f8236h);
                    i iVar = this.f8240f;
                    if (c.a.p0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f8174b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8240f.l;
                        bVar.errMsg = "writeFile:" + this.f8239e.f8166b;
                        i iVar2 = this.f8240f;
                        c.a.p0.a.r0.n.b(iVar2.l, iVar2.f8236h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.p0.a.r0.o.b bVar) {
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
            this.f8233e = str;
            this.f8234f = str2;
            this.f8235g = bArr;
            this.f8236h = map;
            this.f8237i = str3;
            this.f8238j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c C = this.m.f8173a.C(false, this.f8233e, TextUtils.isEmpty(this.f8234f) ? this.f8235g : this.f8234f, c.a.p0.a.r0.n.F("encoding", this.f8236h));
                if (!TextUtils.isEmpty(this.f8237i)) {
                    C.f8166b = this.f8237i;
                    C.f8165a = -2;
                    c.a.p0.a.r0.n.d(this.m.f8174b, this.f8237i);
                } else {
                    int i2 = this.f8238j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8166b = "fail encoding must be a string";
                        C.f8165a = -2;
                        c.a.p0.a.r0.n.d(this.m.f8174b, C.f8166b);
                    }
                }
                this.m.f8174b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8243g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8244h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8245i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8246e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8247f;

            public a(j jVar, c.a.p0.a.r0.c cVar) {
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
                this.f8247f = jVar;
                this.f8246e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8247f.f8242f), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8246e, "unlink:", this.f8247f.f8243g);
                    j jVar = this.f8247f;
                    if (c.a.p0.a.r0.n.a(t, jVar.f8244h, hashMap, jVar.f8245i.f8174b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8247f.f8244h;
                        bVar.errMsg = "unlink:" + this.f8246e.f8166b;
                        j jVar2 = this.f8247f;
                        c.a.p0.a.r0.n.b(jVar2.f8244h, jVar2.f8243g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8245i = eVar;
            this.f8241e = str;
            this.f8242f = i2;
            this.f8243g = map;
            this.f8244h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8245i.f8174b.runOnJSThread(new a(this, this.f8245i.f8173a.z(this.f8241e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8250g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8251h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8252i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8253j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8254e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8255f;

            public a(k kVar, c.a.p0.a.r0.c cVar) {
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
                this.f8255f = kVar;
                this.f8254e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8255f.f8250g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8255f.f8251h), "targetPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8254e, "unzip:", this.f8255f.f8252i);
                    k kVar = this.f8255f;
                    if (c.a.p0.a.r0.n.a(t, kVar.f8253j, hashMap, kVar.k.f8174b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8255f.f8253j;
                        bVar.errMsg = "unzip:" + this.f8254e.f8166b;
                        k kVar2 = this.f8255f;
                        c.a.p0.a.r0.n.b(kVar2.f8253j, kVar2.f8252i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8248e = str;
            this.f8249f = str2;
            this.f8250g = i2;
            this.f8251h = i3;
            this.f8252i = map;
            this.f8253j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8174b.runOnJSThread(new a(this, this.k.f8173a.A(this.f8248e, this.f8249f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8258g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8259h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8260i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8261j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8262e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8263f;

            public a(l lVar, c.a.p0.a.r0.c cVar) {
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
                this.f8263f = lVar;
                this.f8262e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8263f.f8258g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8263f.f8259h), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8262e, "saveFile:", this.f8263f.f8260i);
                    l lVar = this.f8263f;
                    if (c.a.p0.a.r0.n.a(t, lVar.f8261j, hashMap, lVar.k.f8174b)) {
                        c.a.p0.a.r0.o.g gVar = new c.a.p0.a.r0.o.g();
                        List<String> list = this.f8262e.f8167c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8262e.f8166b;
                        c.a.p0.a.r0.n.b(gVar, this.f8263f.f8260i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8256e = str;
            this.f8257f = str2;
            this.f8258g = i2;
            this.f8259h = i3;
            this.f8260i = map;
            this.f8261j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8174b.runOnJSThread(new a(this, this.k.f8173a.x(this.f8256e, this.f8257f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8265f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8266g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8267h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8268i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8269e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8270f;

            public a(m mVar, c.a.p0.a.r0.c cVar) {
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
                this.f8270f = mVar;
                this.f8269e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8270f.f8265f), "dirPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8269e, "readdir:", this.f8270f.f8266g);
                    m mVar = this.f8270f;
                    if (c.a.p0.a.r0.n.a(t, mVar.f8267h, hashMap, mVar.f8268i.f8174b)) {
                        c.a.p0.a.r0.o.e eVar = new c.a.p0.a.r0.o.e();
                        List<String> list = this.f8269e.f8167c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8269e.f8167c.toArray(new String[size]);
                        eVar.errMsg = this.f8269e.f8166b;
                        c.a.p0.a.r0.n.b(eVar, this.f8270f.f8266g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8268i = eVar;
            this.f8264e = str;
            this.f8265f = i2;
            this.f8266g = map;
            this.f8267h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8268i.f8174b.runOnJSThread(new a(this, this.f8268i.f8173a.s(this.f8264e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8272f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8273g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8274h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8275i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8276j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8277e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8278f;

            public a(n nVar, c.a.p0.a.r0.c cVar) {
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
                this.f8278f = nVar;
                this.f8277e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8278f.f8273g), "dirPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8277e, "rmdir:", this.f8278f.f8274h);
                    n nVar = this.f8278f;
                    if (c.a.p0.a.r0.n.a(t, nVar.f8275i, hashMap, nVar.f8276j.f8174b)) {
                        n nVar2 = this.f8278f;
                        c.a.p0.a.r0.n.b(nVar2.f8275i, nVar2.f8274h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8276j = eVar;
            this.f8271e = str;
            this.f8272f = bool;
            this.f8273g = i2;
            this.f8274h = map;
            this.f8275i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8276j.f8174b.runOnJSThread(new a(this, this.f8276j.f8173a.v(this.f8271e, this.f8272f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8280f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8281g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8282h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8283i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8284j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8285e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8286f;

            public a(o oVar, c.a.p0.a.r0.c cVar) {
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
                this.f8286f = oVar;
                this.f8285e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8286f.f8282h), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8285e, "readFile:", this.f8286f.f8283i);
                    o oVar = this.f8286f;
                    if (c.a.p0.a.r0.n.a(t, oVar.f8284j, hashMap, oVar.k.f8174b)) {
                        if (TextUtils.isEmpty(this.f8286f.f8280f)) {
                            c.a.p0.a.r0.o.a aVar = new c.a.p0.a.r0.o.a();
                            c.a.p0.a.r0.c cVar = this.f8285e;
                            if (cVar.f8172h == null) {
                                cVar.f8172h = new byte[0];
                            }
                            byte[] bArr = this.f8285e.f8172h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8285e.f8166b;
                            c.a.p0.a.r0.n.b(aVar, this.f8286f.f8283i);
                            return;
                        }
                        List<String> list = this.f8285e.f8167c;
                        String str = list != null ? list.get(0) : null;
                        c.a.p0.a.r0.o.f fVar = new c.a.p0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8285e.f8166b;
                        c.a.p0.a.r0.n.b(fVar, this.f8286f.f8283i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8279e = str;
            this.f8280f = str2;
            this.f8281g = i2;
            this.f8282h = i3;
            this.f8283i = map;
            this.f8284j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c q = this.k.f8173a.q(this.f8279e, this.f8280f, false);
                int i2 = this.f8281g;
                if (i2 != 7 && i2 != 12) {
                    q.f8166b = "fail encoding must be a string";
                    q.f8165a = -2;
                    c.a.p0.a.r0.n.d(this.k.f8174b, q.f8166b);
                }
                this.k.f8174b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8288f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8289g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8290h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8291i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8292j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8293e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8294f;

            public a(p pVar, c.a.p0.a.r0.c cVar) {
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
                this.f8294f = pVar;
                this.f8293e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8294f.f8289g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8294f.f8290h), "newPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8293e, "rename:", this.f8294f.f8291i);
                    p pVar = this.f8294f;
                    if (c.a.p0.a.r0.n.a(t, pVar.f8292j, hashMap, pVar.k.f8174b)) {
                        p pVar2 = this.f8294f;
                        c.a.p0.a.r0.n.b(pVar2.f8292j, pVar2.f8291i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f8287e = str;
            this.f8288f = str2;
            this.f8289g = i2;
            this.f8290h = i3;
            this.f8291i = map;
            this.f8292j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8174b.runOnJSThread(new a(this, this.k.f8173a.u(this.f8287e, this.f8288f, false)));
            }
        }
    }

    public e(c.a.p0.a.l0.a aVar) {
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
        this.f8174b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("path", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("path", G);
            this.f8175c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("encoding", jsObject);
            int L2 = c.a.p0.a.r0.n.L("filePath", jsObject);
            int L3 = c.a.p0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : c.a.p0.a.r0.n.u(L3);
            byte[] p2 = c.a.p0.a.r0.n.p(jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("data", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8175c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.p0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q != null) {
                lVar = Q.W();
            } else {
                lVar = new c.a.p0.a.r0.l();
            }
            this.f8173a = new c.a.p0.a.r0.f(AppRuntime.getAppContext(), c.a.p0.a.g1.f.V().A(), lVar);
            this.f8175c = c.a.p0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("srcPath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("destPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("srcPath", G);
            String F2 = c.a.p0.a.r0.n.F("destPath", G);
            this.f8175c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str, str2);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("filePath", G);
            this.f8175c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.p0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, (bVar = new c.a.p0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8175c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("dirPath", G);
            this.f8175c.h(new a(this, F, (Boolean) c.a.p0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("encoding", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("encoding", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8175c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
                this.f8175c.k(str);
                c.a.p0.a.r0.c q = this.f8173a.q(str, str2, true);
                c.a.p0.a.r0.n.Z(this.f8174b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f8165a != 0 || (list = q.f8167c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("dirPath", G);
            this.f8175c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
                this.f8175c.k(str);
                c.a.p0.a.r0.c s = this.f8173a.s(str, true);
                c.a.p0.a.r0.n.Z(this.f8174b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f8165a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8167c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8167c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f8175c.h(new h(this, c.a.p0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("oldPath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("newPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("oldPath", G);
            String F2 = c.a.p0.a.r0.n.F("newPath", G);
            this.f8175c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str, str2);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("dirPath", G);
            this.f8175c.h(new n(this, F, (Boolean) c.a.p0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("tempFilePath", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8175c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.p0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("path", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("path", G);
            this.f8175c.h(new RunnableC0357e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public c.a.p0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
                this.f8175c.k(str);
                c.a.p0.a.r0.c y = this.f8173a.y(str, true);
                c.a.p0.a.r0.n.Z(this.f8174b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f8165a != 0) {
                    return null;
                }
                return y.f8168d;
            }
            return null;
        }
        return (c.a.p0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("filePath", G);
            this.f8175c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("targetPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("zipFilePath", G);
            String F2 = c.a.p0.a.r0.n.F("targetPath", G);
            this.f8175c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            String u = c.a.p0.a.r0.n.u(c.a.p0.a.r0.n.L("data", jsObject));
            int L2 = c.a.p0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = c.a.p0.a.r0.n.p(jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8173a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("data", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8175c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
                this.f8175c.k(str, str2);
                c.a.p0.a.r0.c x = this.f8173a.x(str, str2, true);
                c.a.p0.a.r0.n.Z(this.f8174b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f8165a != 0 || (list = x.f8167c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
            this.f8175c.k(str);
            c.a.p0.a.r0.n.Z(this.f8174b, this.f8173a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8173a, this.f8174b, null, null)) {
                this.f8175c.k(str);
                c.a.p0.a.r0.c q = this.f8173a.q(str, null, true);
                c.a.p0.a.r0.n.Z(this.f8174b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8172h == null) {
                    q.f8172h = new byte[0];
                }
                byte[] bArr = q.f8172h;
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
