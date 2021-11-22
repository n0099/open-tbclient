package b.a.p0.a.r0;

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
    public b.a.p0.a.r0.f f7980a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.l0.a f7981b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.r0.i f7982c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7984f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7986h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7987i;
        public final /* synthetic */ e j;

        /* renamed from: b.a.p0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0377a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7988e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7989f;

            public RunnableC0377a(a aVar, b.a.p0.a.r0.c cVar) {
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
                this.f7989f = aVar;
                this.f7988e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7989f.f7985g), "dirPath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f7988e, "mkdir:", this.f7989f.f7986h);
                    a aVar = this.f7989f;
                    if (b.a.p0.a.r0.n.a(v, aVar.f7987i, hashMap, aVar.j.f7981b)) {
                        b.a.p0.a.r0.o.b bVar = this.f7989f.f7987i;
                        bVar.errMsg = "mkdir:" + this.f7988e.f7973b;
                        a aVar2 = this.f7989f;
                        b.a.p0.a.r0.n.b(aVar2.f7987i, aVar2.f7986h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.j = eVar;
            this.f7983e = str;
            this.f7984f = bool;
            this.f7985g = i2;
            this.f7986h = map;
            this.f7987i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f7981b.runOnJSThread(new RunnableC0377a(this, this.j.f7980a.o(this.f7983e, this.f7984f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7993h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7994i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7995e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7996f;

            public a(b bVar, b.a.p0.a.r0.c cVar) {
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
                this.f7996f = bVar;
                this.f7995e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7996f.f7992g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f7996f.f7993h), "destPath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f7995e, "copyFile:", this.f7996f.f7994i);
                    b bVar = this.f7996f;
                    if (b.a.p0.a.r0.n.a(v, bVar.j, hashMap, bVar.k.f7981b)) {
                        b bVar2 = this.f7996f;
                        b.a.p0.a.r0.n.b(bVar2.j, bVar2.f7994i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f7990e = str;
            this.f7991f = str2;
            this.f7992g = i2;
            this.f7993h = i3;
            this.f7994i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7981b.runOnJSThread(new a(this, this.k.f7980a.c(this.f7990e, this.f7991f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7997e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7998f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7999g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8000h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8001i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ b.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8002e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8003f;

            public a(c cVar, b.a.p0.a.r0.c cVar2) {
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
                this.f8003f = cVar;
                this.f8002e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8003f.k), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8002e, "appendFile:", this.f8003f.f8000h);
                    c cVar = this.f8003f;
                    if (b.a.p0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f7981b)) {
                        c cVar2 = this.f8003f;
                        b.a.p0.a.r0.n.b(cVar2.l, cVar2.f8000h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, b.a.p0.a.r0.o.b bVar) {
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
            this.f7997e = str;
            this.f7998f = str2;
            this.f7999g = bArr;
            this.f8000h = map;
            this.f8001i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r0.c b2 = this.m.f7980a.b(this.f7997e, TextUtils.isEmpty(this.f7998f) ? this.f7999g : this.f7998f, b.a.p0.a.r0.n.I("encoding", this.f8000h), false);
                if (!TextUtils.isEmpty(this.f8001i)) {
                    b2.f7973b = this.f8001i;
                    b2.f7972a = -2;
                    b.a.p0.a.r0.n.d(this.m.f7981b, this.f8001i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f7973b = "fail encoding must be a string";
                        b2.f7972a = -2;
                        b.a.p0.a.r0.n.d(this.m.f7981b, b2.f7973b);
                    }
                }
                this.m.f7981b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8005f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8006g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8007h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8008i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8009e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8010f;

            public a(d dVar, b.a.p0.a.r0.c cVar) {
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
                this.f8010f = dVar;
                this.f8009e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8010f.f8005f), "path");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8009e, "access:", this.f8010f.f8006g);
                    d dVar = this.f8010f;
                    if (b.a.p0.a.r0.n.a(v, dVar.f8007h, hashMap, dVar.f8008i.f7981b)) {
                        d dVar2 = this.f8010f;
                        b.a.p0.a.r0.n.b(dVar2.f8007h, dVar2.f8006g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8008i = eVar;
            this.f8004e = str;
            this.f8005f = i2;
            this.f8006g = map;
            this.f8007h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8008i.f7981b.runOnJSThread(new a(this, this.f8008i.f7980a.a(this.f8004e, false)));
            }
        }
    }

    /* renamed from: b.a.p0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0378e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8012f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8013g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8014h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8015i;

        /* renamed from: b.a.p0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8016e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0378e f8017f;

            public a(RunnableC0378e runnableC0378e, b.a.p0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0378e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8017f = runnableC0378e;
                this.f8016e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8017f.f8012f), "path");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8016e, "stat:", this.f8017f.f8013g);
                    RunnableC0378e runnableC0378e = this.f8017f;
                    if (b.a.p0.a.r0.n.a(v, runnableC0378e.f8014h, hashMap, runnableC0378e.f8015i.f7981b)) {
                        b.a.p0.a.r0.o.h hVar = new b.a.p0.a.r0.o.h();
                        b.a.p0.a.r0.c cVar = this.f8016e;
                        hVar.stats = cVar.f7975d;
                        hVar.errMsg = cVar.f7973b;
                        b.a.p0.a.r0.n.b(hVar, this.f8017f.f8013g);
                    }
                }
            }
        }

        public RunnableC0378e(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8015i = eVar;
            this.f8011e = str;
            this.f8012f = i2;
            this.f8013g = map;
            this.f8014h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8015i.f7981b.runOnJSThread(new a(this, this.f8015i.f7980a.y(this.f8011e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8018e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8019f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8020g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8021h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8022i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8023e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8024f;

            public a(f fVar, b.a.p0.a.r0.c cVar) {
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
                this.f8024f = fVar;
                this.f8023e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8024f.f8019f), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8023e, "getFileInfo:", this.f8024f.f8020g);
                    f fVar = this.f8024f;
                    if (b.a.p0.a.r0.n.a(v, fVar.f8021h, hashMap, fVar.f8022i.f7981b)) {
                        b.a.p0.a.r0.o.c cVar = new b.a.p0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8023e.f7973b;
                        b.a.p0.a.r0.c cVar2 = this.f8023e;
                        cVar.digest = cVar2.f7978g;
                        cVar.size = (int) cVar2.f7976e;
                        b.a.p0.a.r0.n.b(cVar, this.f8024f.f8020g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8022i = eVar;
            this.f8018e = str;
            this.f8019f = i2;
            this.f8020g = map;
            this.f8021h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8022i.f7981b.runOnJSThread(new a(this, this.f8022i.f7980a.e(this.f8018e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8026f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8027g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8028e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8029f;

            public a(g gVar, b.a.p0.a.r0.c cVar) {
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
                this.f8029f = gVar;
                this.f8028e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8028e, "getSavedFileList:", this.f8029f.f8025e);
                    g gVar = this.f8029f;
                    if (b.a.p0.a.r0.n.a(v, gVar.f8026f, null, gVar.f8027g.f7981b)) {
                        b.a.p0.a.r0.o.d dVar = new b.a.p0.a.r0.o.d();
                        List<b.a.p0.a.r0.d> list = this.f8028e.f7977f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new b.a.p0.a.r0.d[0] : (b.a.p0.a.r0.d[]) this.f8028e.f7977f.toArray(new b.a.p0.a.r0.d[size]);
                        g gVar2 = this.f8029f;
                        dVar.errMsg = gVar2.f8026f.errMsg;
                        b.a.p0.a.r0.n.b(dVar, gVar2.f8025e);
                    }
                }
            }
        }

        public g(e eVar, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8027g = eVar;
            this.f8025e = map;
            this.f8026f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8027g.f7981b.runOnJSThread(new a(this, this.f8027g.f7980a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8030e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8031f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8032g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8033h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8034i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8035e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8036f;

            public a(h hVar, b.a.p0.a.r0.c cVar) {
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
                this.f8036f = hVar;
                this.f8035e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8036f.f8031f), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8035e, "removeSavedFile:", this.f8036f.f8032g);
                    h hVar = this.f8036f;
                    if (b.a.p0.a.r0.n.a(v, hVar.f8033h, hashMap, hVar.f8034i.f7981b)) {
                        h hVar2 = this.f8036f;
                        b.a.p0.a.r0.n.b(hVar2.f8033h, hVar2.f8032g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8034i = eVar;
            this.f8030e = str;
            this.f8031f = i2;
            this.f8032g = map;
            this.f8033h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8034i.f7981b.runOnJSThread(new a(this, this.f8034i.f7980a.t(this.f8030e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8038f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8039g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8040h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8041i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ b.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8042e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8043f;

            public a(i iVar, b.a.p0.a.r0.c cVar) {
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
                this.f8043f = iVar;
                this.f8042e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8043f.k), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8042e, "writeFile:", this.f8043f.f8040h);
                    i iVar = this.f8043f;
                    if (b.a.p0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f7981b)) {
                        b.a.p0.a.r0.o.b bVar = this.f8043f.l;
                        bVar.errMsg = "writeFile:" + this.f8042e.f7973b;
                        i iVar2 = this.f8043f;
                        b.a.p0.a.r0.n.b(iVar2.l, iVar2.f8040h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, b.a.p0.a.r0.o.b bVar) {
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
            this.f8037e = str;
            this.f8038f = str2;
            this.f8039g = bArr;
            this.f8040h = map;
            this.f8041i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r0.c C = this.m.f7980a.C(false, this.f8037e, TextUtils.isEmpty(this.f8038f) ? this.f8039g : this.f8038f, b.a.p0.a.r0.n.I("encoding", this.f8040h));
                if (!TextUtils.isEmpty(this.f8041i)) {
                    C.f7973b = this.f8041i;
                    C.f7972a = -2;
                    b.a.p0.a.r0.n.d(this.m.f7981b, this.f8041i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        C.f7973b = "fail encoding must be a string";
                        C.f7972a = -2;
                        b.a.p0.a.r0.n.d(this.m.f7981b, C.f7973b);
                    }
                }
                this.m.f7981b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8045f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8046g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8047h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8048i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8049e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8050f;

            public a(j jVar, b.a.p0.a.r0.c cVar) {
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
                this.f8050f = jVar;
                this.f8049e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8050f.f8045f), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8049e, "unlink:", this.f8050f.f8046g);
                    j jVar = this.f8050f;
                    if (b.a.p0.a.r0.n.a(v, jVar.f8047h, hashMap, jVar.f8048i.f7981b)) {
                        b.a.p0.a.r0.o.b bVar = this.f8050f.f8047h;
                        bVar.errMsg = "unlink:" + this.f8049e.f7973b;
                        j jVar2 = this.f8050f;
                        b.a.p0.a.r0.n.b(jVar2.f8047h, jVar2.f8046g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8048i = eVar;
            this.f8044e = str;
            this.f8045f = i2;
            this.f8046g = map;
            this.f8047h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8048i.f7981b.runOnJSThread(new a(this, this.f8048i.f7980a.z(this.f8044e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8051e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8052f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8053g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8054h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8055i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8056e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8057f;

            public a(k kVar, b.a.p0.a.r0.c cVar) {
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
                this.f8057f = kVar;
                this.f8056e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8057f.f8053g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8057f.f8054h), "targetPath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8056e, "unzip:", this.f8057f.f8055i);
                    k kVar = this.f8057f;
                    if (b.a.p0.a.r0.n.a(v, kVar.j, hashMap, kVar.k.f7981b)) {
                        b.a.p0.a.r0.o.b bVar = this.f8057f.j;
                        bVar.errMsg = "unzip:" + this.f8056e.f7973b;
                        k kVar2 = this.f8057f;
                        b.a.p0.a.r0.n.b(kVar2.j, kVar2.f8055i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8051e = str;
            this.f8052f = str2;
            this.f8053g = i2;
            this.f8054h = i3;
            this.f8055i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7981b.runOnJSThread(new a(this, this.k.f7980a.A(this.f8051e, this.f8052f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8059f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8060g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8061h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8062i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8063e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8064f;

            public a(l lVar, b.a.p0.a.r0.c cVar) {
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
                this.f8064f = lVar;
                this.f8063e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8064f.f8060g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8064f.f8061h), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8063e, "saveFile:", this.f8064f.f8062i);
                    l lVar = this.f8064f;
                    if (b.a.p0.a.r0.n.a(v, lVar.j, hashMap, lVar.k.f7981b)) {
                        b.a.p0.a.r0.o.g gVar = new b.a.p0.a.r0.o.g();
                        List<String> list = this.f8063e.f7974c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8063e.f7973b;
                        b.a.p0.a.r0.n.b(gVar, this.f8064f.f8062i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8058e = str;
            this.f8059f = str2;
            this.f8060g = i2;
            this.f8061h = i3;
            this.f8062i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7981b.runOnJSThread(new a(this, this.k.f7980a.x(this.f8058e, this.f8059f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8065e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8066f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8067g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8068h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8069i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8070e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8071f;

            public a(m mVar, b.a.p0.a.r0.c cVar) {
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
                this.f8071f = mVar;
                this.f8070e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8071f.f8066f), "dirPath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8070e, "readdir:", this.f8071f.f8067g);
                    m mVar = this.f8071f;
                    if (b.a.p0.a.r0.n.a(v, mVar.f8068h, hashMap, mVar.f8069i.f7981b)) {
                        b.a.p0.a.r0.o.e eVar = new b.a.p0.a.r0.o.e();
                        List<String> list = this.f8070e.f7974c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8070e.f7974c.toArray(new String[size]);
                        eVar.errMsg = this.f8070e.f7973b;
                        b.a.p0.a.r0.n.b(eVar, this.f8071f.f8067g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8069i = eVar;
            this.f8065e = str;
            this.f8066f = i2;
            this.f8067g = map;
            this.f8068h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8069i.f7981b.runOnJSThread(new a(this, this.f8069i.f7980a.s(this.f8065e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8072e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8073f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8074g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8075h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f8076i;
        public final /* synthetic */ e j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8077e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8078f;

            public a(n nVar, b.a.p0.a.r0.c cVar) {
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
                this.f8078f = nVar;
                this.f8077e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8078f.f8074g), "dirPath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8077e, "rmdir:", this.f8078f.f8075h);
                    n nVar = this.f8078f;
                    if (b.a.p0.a.r0.n.a(v, nVar.f8076i, hashMap, nVar.j.f7981b)) {
                        n nVar2 = this.f8078f;
                        b.a.p0.a.r0.n.b(nVar2.f8076i, nVar2.f8075h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.j = eVar;
            this.f8072e = str;
            this.f8073f = bool;
            this.f8074g = i2;
            this.f8075h = map;
            this.f8076i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f7981b.runOnJSThread(new a(this, this.j.f7980a.v(this.f8072e, this.f8073f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8081g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8082h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8083i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8084e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8085f;

            public a(o oVar, b.a.p0.a.r0.c cVar) {
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
                this.f8085f = oVar;
                this.f8084e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8085f.f8082h), "filePath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8084e, "readFile:", this.f8085f.f8083i);
                    o oVar = this.f8085f;
                    if (b.a.p0.a.r0.n.a(v, oVar.j, hashMap, oVar.k.f7981b)) {
                        if (TextUtils.isEmpty(this.f8085f.f8080f)) {
                            b.a.p0.a.r0.o.a aVar = new b.a.p0.a.r0.o.a();
                            b.a.p0.a.r0.c cVar = this.f8084e;
                            if (cVar.f7979h == null) {
                                cVar.f7979h = new byte[0];
                            }
                            byte[] bArr = this.f8084e.f7979h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8084e.f7973b;
                            b.a.p0.a.r0.n.b(aVar, this.f8085f.f8083i);
                            return;
                        }
                        List<String> list = this.f8084e.f7974c;
                        String str = list != null ? list.get(0) : null;
                        b.a.p0.a.r0.o.f fVar = new b.a.p0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8084e.f7973b;
                        b.a.p0.a.r0.n.b(fVar, this.f8085f.f8083i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8079e = str;
            this.f8080f = str2;
            this.f8081g = i2;
            this.f8082h = i3;
            this.f8083i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r0.c q = this.k.f7980a.q(this.f8079e, this.f8080f, false);
                int i2 = this.f8081g;
                if (i2 != 7 && i2 != 12) {
                    q.f7973b = "fail encoding must be a string";
                    q.f7972a = -2;
                    b.a.p0.a.r0.n.d(this.k.f7981b, q.f7973b);
                }
                this.k.f7981b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8086e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8087f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8088g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8089h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8090i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f8091e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8092f;

            public a(p pVar, b.a.p0.a.r0.c cVar) {
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
                this.f8092f = pVar;
                this.f8091e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8092f.f8088g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8092f.f8089h), "newPath");
                    b.a.p0.a.r0.b v = b.a.p0.a.r0.n.v(this.f8091e, "rename:", this.f8092f.f8090i);
                    p pVar = this.f8092f;
                    if (b.a.p0.a.r0.n.a(v, pVar.j, hashMap, pVar.k.f7981b)) {
                        p pVar2 = this.f8092f;
                        b.a.p0.a.r0.n.b(pVar2.j, pVar2.f8090i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f8086e = str;
            this.f8087f = str2;
            this.f8088g = i2;
            this.f8089h = i3;
            this.f8090i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7981b.runOnJSThread(new a(this, this.k.f7980a.u(this.f8086e, this.f8087f, false)));
            }
        }
    }

    public e(b.a.p0.a.l0.a aVar) {
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
        this.f7981b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("path", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("path", J);
            this.f7982c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("encoding", jsObject);
            int O2 = b.a.p0.a.r0.n.O("filePath", jsObject);
            int O3 = b.a.p0.a.r0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : b.a.p0.a.r0.n.w(O3);
            byte[] r = b.a.p0.a.r0.n.r(jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("data", J);
            String I2 = b.a.p0.a.r0.n.I("filePath", J);
            this.f7982c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        b.a.p0.a.o2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new b.a.p0.a.r0.l();
            }
            this.f7980a = new b.a.p0.a.r0.f(AppRuntime.getAppContext(), b.a.p0.a.g1.f.U().z(), lVar);
            this.f7982c = b.a.p0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("srcPath", jsObject);
            int O2 = b.a.p0.a.r0.n.O("destPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("srcPath", J);
            String I2 = b.a.p0.a.r0.n.I("destPath", J);
            this.f7982c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str, str2);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("filePath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("filePath", J);
            this.f7982c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        b.a.p0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, (bVar = new b.a.p0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f7982c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("dirPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("dirPath", J);
            this.f7982c.h(new a(this, I, (Boolean) b.a.p0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("filePath", jsObject);
            int O2 = b.a.p0.a.r0.n.O("encoding", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("encoding", J);
            String I2 = b.a.p0.a.r0.n.I("filePath", J);
            this.f7982c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
                this.f7982c.k(str);
                b.a.p0.a.r0.c q = this.f7980a.q(str, str2, true);
                b.a.p0.a.r0.n.d0(this.f7981b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f7972a != 0 || (list = q.f7974c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("dirPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("dirPath", J);
            this.f7982c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
                this.f7982c.k(str);
                b.a.p0.a.r0.c s = this.f7980a.s(str, true);
                b.a.p0.a.r0.n.d0(this.f7981b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f7972a != 0) {
                    return new String[0];
                }
                List<String> list = s.f7974c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f7974c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("filePath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f7982c.h(new h(this, b.a.p0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("oldPath", jsObject);
            int O2 = b.a.p0.a.r0.n.O("newPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("oldPath", J);
            String I2 = b.a.p0.a.r0.n.I("newPath", J);
            this.f7982c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str, str2);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("dirPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("dirPath", J);
            this.f7982c.h(new n(this, I, (Boolean) b.a.p0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("tempFilePath", jsObject);
            int O2 = b.a.p0.a.r0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("tempFilePath", J);
            String I2 = b.a.p0.a.r0.n.I("filePath", J);
            this.f7982c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, b.a.p0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("path", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("path", J);
            this.f7982c.h(new RunnableC0378e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public b.a.p0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
                this.f7982c.k(str);
                b.a.p0.a.r0.c y = this.f7980a.y(str, true);
                b.a.p0.a.r0.n.d0(this.f7981b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f7972a != 0) {
                    return null;
                }
                return y.f7975d;
            }
            return null;
        }
        return (b.a.p0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("filePath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("filePath", J);
            this.f7982c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = b.a.p0.a.r0.n.O("targetPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("zipFilePath", J);
            String I2 = b.a.p0.a.r0.n.I("targetPath", J);
            this.f7982c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = b.a.p0.a.r0.n.O("filePath", jsObject);
            String w = b.a.p0.a.r0.n.w(b.a.p0.a.r0.n.O("data", jsObject));
            int O2 = b.a.p0.a.r0.n.O("encoding", jsObject);
            byte[] r = b.a.p0.a.r0.n.r(jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> J = b.a.p0.a.r0.n.J(this.f7980a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = b.a.p0.a.r0.n.I("data", J);
            String I2 = b.a.p0.a.r0.n.I("filePath", J);
            this.f7982c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
                this.f7982c.k(str, str2);
                b.a.p0.a.r0.c x = this.f7980a.x(str, str2, true);
                b.a.p0.a.r0.n.d0(this.f7981b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f7972a != 0 || (list = x.f7974c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
            this.f7982c.k(str);
            b.a.p0.a.r0.n.d0(this.f7981b, this.f7980a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (b.a.p0.a.r0.n.T(this.f7980a, this.f7981b, null, null)) {
                this.f7982c.k(str);
                b.a.p0.a.r0.c q = this.f7980a.q(str, null, true);
                b.a.p0.a.r0.n.d0(this.f7981b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f7979h == null) {
                    q.f7979h = new byte[0];
                }
                byte[] bArr = q.f7979h;
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
