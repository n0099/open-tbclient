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
    public c.a.p0.a.r0.f f8181a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.l0.a f8182b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.r0.i f8183c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8184e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8185f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8186g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8187h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8188i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8189j;

        /* renamed from: c.a.p0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0356a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8190e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8191f;

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
                this.f8191f = aVar;
                this.f8190e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8191f.f8186g), "dirPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8190e, "mkdir:", this.f8191f.f8187h);
                    a aVar = this.f8191f;
                    if (c.a.p0.a.r0.n.a(t, aVar.f8188i, hashMap, aVar.f8189j.f8182b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8191f.f8188i;
                        bVar.errMsg = "mkdir:" + this.f8190e.f8174b;
                        a aVar2 = this.f8191f;
                        c.a.p0.a.r0.n.b(aVar2.f8188i, aVar2.f8187h);
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
            this.f8189j = eVar;
            this.f8184e = str;
            this.f8185f = bool;
            this.f8186g = i2;
            this.f8187h = map;
            this.f8188i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8189j.f8182b.runOnJSThread(new RunnableC0356a(this, this.f8189j.f8181a.o(this.f8184e, this.f8185f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8194g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8195h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8196i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8197j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8198e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8199f;

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
                this.f8199f = bVar;
                this.f8198e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8199f.f8194g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8199f.f8195h), "destPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8198e, "copyFile:", this.f8199f.f8196i);
                    b bVar = this.f8199f;
                    if (c.a.p0.a.r0.n.a(t, bVar.f8197j, hashMap, bVar.k.f8182b)) {
                        b bVar2 = this.f8199f;
                        c.a.p0.a.r0.n.b(bVar2.f8197j, bVar2.f8196i);
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
            this.f8192e = str;
            this.f8193f = str2;
            this.f8194g = i2;
            this.f8195h = i3;
            this.f8196i = map;
            this.f8197j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8182b.runOnJSThread(new a(this, this.k.f8181a.c(this.f8192e, this.f8193f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8201f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8202g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8203h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8204i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8205j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8206e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8207f;

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
                this.f8207f = cVar;
                this.f8206e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8207f.k), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8206e, "appendFile:", this.f8207f.f8203h);
                    c cVar = this.f8207f;
                    if (c.a.p0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f8182b)) {
                        c cVar2 = this.f8207f;
                        c.a.p0.a.r0.n.b(cVar2.l, cVar2.f8203h);
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
            this.f8200e = str;
            this.f8201f = str2;
            this.f8202g = bArr;
            this.f8203h = map;
            this.f8204i = str3;
            this.f8205j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c b2 = this.m.f8181a.b(this.f8200e, TextUtils.isEmpty(this.f8201f) ? this.f8202g : this.f8201f, c.a.p0.a.r0.n.F("encoding", this.f8203h), false);
                if (!TextUtils.isEmpty(this.f8204i)) {
                    b2.f8174b = this.f8204i;
                    b2.f8173a = -2;
                    c.a.p0.a.r0.n.d(this.m.f8182b, this.f8204i);
                } else {
                    int i2 = this.f8205j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8174b = "fail encoding must be a string";
                        b2.f8173a = -2;
                        c.a.p0.a.r0.n.d(this.m.f8182b, b2.f8174b);
                    }
                }
                this.m.f8182b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8209f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8210g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8211h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8212i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8213e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8214f;

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
                this.f8214f = dVar;
                this.f8213e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8214f.f8209f), "path");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8213e, "access:", this.f8214f.f8210g);
                    d dVar = this.f8214f;
                    if (c.a.p0.a.r0.n.a(t, dVar.f8211h, hashMap, dVar.f8212i.f8182b)) {
                        d dVar2 = this.f8214f;
                        c.a.p0.a.r0.n.b(dVar2.f8211h, dVar2.f8210g);
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
            this.f8212i = eVar;
            this.f8208e = str;
            this.f8209f = i2;
            this.f8210g = map;
            this.f8211h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8212i.f8182b.runOnJSThread(new a(this, this.f8212i.f8181a.a(this.f8208e, false)));
            }
        }
    }

    /* renamed from: c.a.p0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0357e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8215e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8216f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8217g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8218h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8219i;

        /* renamed from: c.a.p0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8220e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0357e f8221f;

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
                this.f8221f = runnableC0357e;
                this.f8220e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8221f.f8216f), "path");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8220e, "stat:", this.f8221f.f8217g);
                    RunnableC0357e runnableC0357e = this.f8221f;
                    if (c.a.p0.a.r0.n.a(t, runnableC0357e.f8218h, hashMap, runnableC0357e.f8219i.f8182b)) {
                        c.a.p0.a.r0.o.h hVar = new c.a.p0.a.r0.o.h();
                        c.a.p0.a.r0.c cVar = this.f8220e;
                        hVar.stats = cVar.f8176d;
                        hVar.errMsg = cVar.f8174b;
                        c.a.p0.a.r0.n.b(hVar, this.f8221f.f8217g);
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
            this.f8219i = eVar;
            this.f8215e = str;
            this.f8216f = i2;
            this.f8217g = map;
            this.f8218h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8219i.f8182b.runOnJSThread(new a(this, this.f8219i.f8181a.y(this.f8215e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8224g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8225h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8226i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8227e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8228f;

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
                this.f8228f = fVar;
                this.f8227e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8228f.f8223f), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8227e, "getFileInfo:", this.f8228f.f8224g);
                    f fVar = this.f8228f;
                    if (c.a.p0.a.r0.n.a(t, fVar.f8225h, hashMap, fVar.f8226i.f8182b)) {
                        c.a.p0.a.r0.o.c cVar = new c.a.p0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8227e.f8174b;
                        c.a.p0.a.r0.c cVar2 = this.f8227e;
                        cVar.digest = cVar2.f8179g;
                        cVar.size = (int) cVar2.f8177e;
                        c.a.p0.a.r0.n.b(cVar, this.f8228f.f8224g);
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
            this.f8226i = eVar;
            this.f8222e = str;
            this.f8223f = i2;
            this.f8224g = map;
            this.f8225h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8226i.f8182b.runOnJSThread(new a(this, this.f8226i.f8181a.e(this.f8222e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8231g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8232e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8233f;

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
                this.f8233f = gVar;
                this.f8232e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8232e, "getSavedFileList:", this.f8233f.f8229e);
                    g gVar = this.f8233f;
                    if (c.a.p0.a.r0.n.a(t, gVar.f8230f, null, gVar.f8231g.f8182b)) {
                        c.a.p0.a.r0.o.d dVar = new c.a.p0.a.r0.o.d();
                        List<c.a.p0.a.r0.d> list = this.f8232e.f8178f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.p0.a.r0.d[0] : (c.a.p0.a.r0.d[]) this.f8232e.f8178f.toArray(new c.a.p0.a.r0.d[size]);
                        g gVar2 = this.f8233f;
                        dVar.errMsg = gVar2.f8230f.errMsg;
                        c.a.p0.a.r0.n.b(dVar, gVar2.f8229e);
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
            this.f8231g = eVar;
            this.f8229e = map;
            this.f8230f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8231g.f8182b.runOnJSThread(new a(this, this.f8231g.f8181a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8236g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8237h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8238i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8239e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8240f;

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
                this.f8240f = hVar;
                this.f8239e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8240f.f8235f), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8239e, "removeSavedFile:", this.f8240f.f8236g);
                    h hVar = this.f8240f;
                    if (c.a.p0.a.r0.n.a(t, hVar.f8237h, hashMap, hVar.f8238i.f8182b)) {
                        h hVar2 = this.f8240f;
                        c.a.p0.a.r0.n.b(hVar2.f8237h, hVar2.f8236g);
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
            this.f8238i = eVar;
            this.f8234e = str;
            this.f8235f = i2;
            this.f8236g = map;
            this.f8237h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8238i.f8182b.runOnJSThread(new a(this, this.f8238i.f8181a.t(this.f8234e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8241e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8242f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8243g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8244h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8245i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8246j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8247e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8248f;

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
                this.f8248f = iVar;
                this.f8247e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8248f.k), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8247e, "writeFile:", this.f8248f.f8244h);
                    i iVar = this.f8248f;
                    if (c.a.p0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f8182b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8248f.l;
                        bVar.errMsg = "writeFile:" + this.f8247e.f8174b;
                        i iVar2 = this.f8248f;
                        c.a.p0.a.r0.n.b(iVar2.l, iVar2.f8244h);
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
            this.f8241e = str;
            this.f8242f = str2;
            this.f8243g = bArr;
            this.f8244h = map;
            this.f8245i = str3;
            this.f8246j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c C = this.m.f8181a.C(false, this.f8241e, TextUtils.isEmpty(this.f8242f) ? this.f8243g : this.f8242f, c.a.p0.a.r0.n.F("encoding", this.f8244h));
                if (!TextUtils.isEmpty(this.f8245i)) {
                    C.f8174b = this.f8245i;
                    C.f8173a = -2;
                    c.a.p0.a.r0.n.d(this.m.f8182b, this.f8245i);
                } else {
                    int i2 = this.f8246j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8174b = "fail encoding must be a string";
                        C.f8173a = -2;
                        c.a.p0.a.r0.n.d(this.m.f8182b, C.f8174b);
                    }
                }
                this.m.f8182b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8250f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8251g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8252h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8253i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8254e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8255f;

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
                this.f8255f = jVar;
                this.f8254e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8255f.f8250f), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8254e, "unlink:", this.f8255f.f8251g);
                    j jVar = this.f8255f;
                    if (c.a.p0.a.r0.n.a(t, jVar.f8252h, hashMap, jVar.f8253i.f8182b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8255f.f8252h;
                        bVar.errMsg = "unlink:" + this.f8254e.f8174b;
                        j jVar2 = this.f8255f;
                        c.a.p0.a.r0.n.b(jVar2.f8252h, jVar2.f8251g);
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
            this.f8253i = eVar;
            this.f8249e = str;
            this.f8250f = i2;
            this.f8251g = map;
            this.f8252h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8253i.f8182b.runOnJSThread(new a(this, this.f8253i.f8181a.z(this.f8249e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
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
            public final /* synthetic */ k f8263f;

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
                this.f8263f = kVar;
                this.f8262e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8263f.f8258g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8263f.f8259h), "targetPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8262e, "unzip:", this.f8263f.f8260i);
                    k kVar = this.f8263f;
                    if (c.a.p0.a.r0.n.a(t, kVar.f8261j, hashMap, kVar.k.f8182b)) {
                        c.a.p0.a.r0.o.b bVar = this.f8263f.f8261j;
                        bVar.errMsg = "unzip:" + this.f8262e.f8174b;
                        k kVar2 = this.f8263f;
                        c.a.p0.a.r0.n.b(kVar2.f8261j, kVar2.f8260i);
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
                this.k.f8182b.runOnJSThread(new a(this, this.k.f8181a.A(this.f8256e, this.f8257f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8265f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8266g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8267h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8268i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8269j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8270e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8271f;

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
                this.f8271f = lVar;
                this.f8270e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8271f.f8266g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8271f.f8267h), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8270e, "saveFile:", this.f8271f.f8268i);
                    l lVar = this.f8271f;
                    if (c.a.p0.a.r0.n.a(t, lVar.f8269j, hashMap, lVar.k.f8182b)) {
                        c.a.p0.a.r0.o.g gVar = new c.a.p0.a.r0.o.g();
                        List<String> list = this.f8270e.f8175c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8270e.f8174b;
                        c.a.p0.a.r0.n.b(gVar, this.f8271f.f8268i);
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
            this.f8264e = str;
            this.f8265f = str2;
            this.f8266g = i2;
            this.f8267h = i3;
            this.f8268i = map;
            this.f8269j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8182b.runOnJSThread(new a(this, this.k.f8181a.x(this.f8264e, this.f8265f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8273f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8274g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8275h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8276i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8277e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8278f;

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
                this.f8278f = mVar;
                this.f8277e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8278f.f8273f), "dirPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8277e, "readdir:", this.f8278f.f8274g);
                    m mVar = this.f8278f;
                    if (c.a.p0.a.r0.n.a(t, mVar.f8275h, hashMap, mVar.f8276i.f8182b)) {
                        c.a.p0.a.r0.o.e eVar = new c.a.p0.a.r0.o.e();
                        List<String> list = this.f8277e.f8175c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8277e.f8175c.toArray(new String[size]);
                        eVar.errMsg = this.f8277e.f8174b;
                        c.a.p0.a.r0.n.b(eVar, this.f8278f.f8274g);
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
            this.f8276i = eVar;
            this.f8272e = str;
            this.f8273f = i2;
            this.f8274g = map;
            this.f8275h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8276i.f8182b.runOnJSThread(new a(this, this.f8276i.f8181a.s(this.f8272e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8279e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8280f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8281g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8282h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8283i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8284j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8285e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8286f;

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
                this.f8286f = nVar;
                this.f8285e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8286f.f8281g), "dirPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8285e, "rmdir:", this.f8286f.f8282h);
                    n nVar = this.f8286f;
                    if (c.a.p0.a.r0.n.a(t, nVar.f8283i, hashMap, nVar.f8284j.f8182b)) {
                        n nVar2 = this.f8286f;
                        c.a.p0.a.r0.n.b(nVar2.f8283i, nVar2.f8282h);
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
            this.f8284j = eVar;
            this.f8279e = str;
            this.f8280f = bool;
            this.f8281g = i2;
            this.f8282h = map;
            this.f8283i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8284j.f8182b.runOnJSThread(new a(this, this.f8284j.f8181a.v(this.f8279e, this.f8280f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
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
            public final /* synthetic */ o f8294f;

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
                this.f8294f = oVar;
                this.f8293e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8294f.f8290h), "filePath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8293e, "readFile:", this.f8294f.f8291i);
                    o oVar = this.f8294f;
                    if (c.a.p0.a.r0.n.a(t, oVar.f8292j, hashMap, oVar.k.f8182b)) {
                        if (TextUtils.isEmpty(this.f8294f.f8288f)) {
                            c.a.p0.a.r0.o.a aVar = new c.a.p0.a.r0.o.a();
                            c.a.p0.a.r0.c cVar = this.f8293e;
                            if (cVar.f8180h == null) {
                                cVar.f8180h = new byte[0];
                            }
                            byte[] bArr = this.f8293e.f8180h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8293e.f8174b;
                            c.a.p0.a.r0.n.b(aVar, this.f8294f.f8291i);
                            return;
                        }
                        List<String> list = this.f8293e.f8175c;
                        String str = list != null ? list.get(0) : null;
                        c.a.p0.a.r0.o.f fVar = new c.a.p0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8293e.f8174b;
                        c.a.p0.a.r0.n.b(fVar, this.f8294f.f8291i);
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
                c.a.p0.a.r0.c q = this.k.f8181a.q(this.f8287e, this.f8288f, false);
                int i2 = this.f8289g;
                if (i2 != 7 && i2 != 12) {
                    q.f8174b = "fail encoding must be a string";
                    q.f8173a = -2;
                    c.a.p0.a.r0.n.d(this.k.f8182b, q.f8174b);
                }
                this.k.f8182b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8296f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8297g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8298h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8299i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f8300j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f8301e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8302f;

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
                this.f8302f = pVar;
                this.f8301e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8302f.f8297g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8302f.f8298h), "newPath");
                    c.a.p0.a.r0.b t = c.a.p0.a.r0.n.t(this.f8301e, "rename:", this.f8302f.f8299i);
                    p pVar = this.f8302f;
                    if (c.a.p0.a.r0.n.a(t, pVar.f8300j, hashMap, pVar.k.f8182b)) {
                        p pVar2 = this.f8302f;
                        c.a.p0.a.r0.n.b(pVar2.f8300j, pVar2.f8299i);
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
            this.f8295e = str;
            this.f8296f = str2;
            this.f8297g = i2;
            this.f8298h = i3;
            this.f8299i = map;
            this.f8300j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8182b.runOnJSThread(new a(this, this.k.f8181a.u(this.f8295e, this.f8296f, false)));
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
        this.f8182b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("path", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("path", G);
            this.f8183c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("encoding", jsObject);
            int L2 = c.a.p0.a.r0.n.L("filePath", jsObject);
            int L3 = c.a.p0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : c.a.p0.a.r0.n.u(L3);
            byte[] p2 = c.a.p0.a.r0.n.p(jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("data", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8183c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
            this.f8181a = new c.a.p0.a.r0.f(AppRuntime.getAppContext(), c.a.p0.a.g1.f.V().A(), lVar);
            this.f8183c = c.a.p0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("srcPath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("destPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("srcPath", G);
            String F2 = c.a.p0.a.r0.n.F("destPath", G);
            this.f8183c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str, str2);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("filePath", G);
            this.f8183c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.p0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, (bVar = new c.a.p0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8183c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("dirPath", G);
            this.f8183c.h(new a(this, F, (Boolean) c.a.p0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("encoding", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("encoding", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8183c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
                this.f8183c.k(str);
                c.a.p0.a.r0.c q = this.f8181a.q(str, str2, true);
                c.a.p0.a.r0.n.Z(this.f8182b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f8173a != 0 || (list = q.f8175c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("dirPath", G);
            this.f8183c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
                this.f8183c.k(str);
                c.a.p0.a.r0.c s = this.f8181a.s(str, true);
                c.a.p0.a.r0.n.Z(this.f8182b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f8173a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8175c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8175c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f8183c.h(new h(this, c.a.p0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("oldPath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("newPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("oldPath", G);
            String F2 = c.a.p0.a.r0.n.F("newPath", G);
            this.f8183c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str, str2);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("dirPath", G);
            this.f8183c.h(new n(this, F, (Boolean) c.a.p0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("tempFilePath", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8183c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
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
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("path", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("path", G);
            this.f8183c.h(new RunnableC0357e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public c.a.p0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
                this.f8183c.k(str);
                c.a.p0.a.r0.c y = this.f8181a.y(str, true);
                c.a.p0.a.r0.n.Z(this.f8182b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f8173a != 0) {
                    return null;
                }
                return y.f8176d;
            }
            return null;
        }
        return (c.a.p0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("filePath", G);
            this.f8183c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = c.a.p0.a.r0.n.L("targetPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("zipFilePath", G);
            String F2 = c.a.p0.a.r0.n.F("targetPath", G);
            this.f8183c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.p0.a.r0.n.L("filePath", jsObject);
            String u = c.a.p0.a.r0.n.u(c.a.p0.a.r0.n.L("data", jsObject));
            int L2 = c.a.p0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = c.a.p0.a.r0.n.p(jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> G = c.a.p0.a.r0.n.G(this.f8181a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.p0.a.r0.n.F("data", G);
            String F2 = c.a.p0.a.r0.n.F("filePath", G);
            this.f8183c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
                this.f8183c.k(str, str2);
                c.a.p0.a.r0.c x = this.f8181a.x(str, str2, true);
                c.a.p0.a.r0.n.Z(this.f8182b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f8173a != 0 || (list = x.f8175c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
            this.f8183c.k(str);
            c.a.p0.a.r0.n.Z(this.f8182b, this.f8181a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.p0.a.r0.n.P(this.f8181a, this.f8182b, null, null)) {
                this.f8183c.k(str);
                c.a.p0.a.r0.c q = this.f8181a.q(str, null, true);
                c.a.p0.a.r0.n.Z(this.f8182b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8180h == null) {
                    q.f8180h = new byte[0];
                }
                byte[] bArr = q.f8180h;
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
