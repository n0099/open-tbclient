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
    public c.a.r0.a.l0.a f8457b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.r0.i f8458c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8461g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8462h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8463i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8464j;

        /* renamed from: c.a.r0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0526a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8465e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8466f;

            public RunnableC0526a(a aVar, c.a.r0.a.r0.c cVar) {
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
                this.f8466f = aVar;
                this.f8465e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8466f.f8461g), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8465e, "mkdir:", this.f8466f.f8462h);
                    a aVar = this.f8466f;
                    if (c.a.r0.a.r0.n.a(v, aVar.f8463i, hashMap, aVar.f8464j.f8457b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8466f.f8463i;
                        bVar.errMsg = "mkdir:" + this.f8465e.f8450b;
                        a aVar2 = this.f8466f;
                        c.a.r0.a.r0.n.b(aVar2.f8463i, aVar2.f8462h);
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
            this.f8464j = eVar;
            this.f8459e = str;
            this.f8460f = bool;
            this.f8461g = i2;
            this.f8462h = map;
            this.f8463i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8464j.f8457b.runOnJSThread(new RunnableC0526a(this, this.f8464j.a.o(this.f8459e, this.f8460f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8469g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8470h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8471i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8472j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8473e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8474f;

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
                this.f8474f = bVar;
                this.f8473e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8474f.f8469g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8474f.f8470h), "destPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8473e, "copyFile:", this.f8474f.f8471i);
                    b bVar = this.f8474f;
                    if (c.a.r0.a.r0.n.a(v, bVar.f8472j, hashMap, bVar.k.f8457b)) {
                        b bVar2 = this.f8474f;
                        c.a.r0.a.r0.n.b(bVar2.f8472j, bVar2.f8471i);
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
            this.k = eVar;
            this.f8467e = str;
            this.f8468f = str2;
            this.f8469g = i2;
            this.f8470h = i3;
            this.f8471i = map;
            this.f8472j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8457b.runOnJSThread(new a(this, this.k.a.c(this.f8467e, this.f8468f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8476f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8477g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8478h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8479i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8480j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.r0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8481e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8482f;

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
                this.f8482f = cVar;
                this.f8481e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8482f.k), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8481e, "appendFile:", this.f8482f.f8478h);
                    c cVar = this.f8482f;
                    if (c.a.r0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f8457b)) {
                        c cVar2 = this.f8482f;
                        c.a.r0.a.r0.n.b(cVar2.l, cVar2.f8478h);
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
            this.f8475e = str;
            this.f8476f = str2;
            this.f8477g = bArr;
            this.f8478h = map;
            this.f8479i = str3;
            this.f8480j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c b2 = this.m.a.b(this.f8475e, TextUtils.isEmpty(this.f8476f) ? this.f8477g : this.f8476f, c.a.r0.a.r0.n.I("encoding", this.f8478h), false);
                if (!TextUtils.isEmpty(this.f8479i)) {
                    b2.f8450b = this.f8479i;
                    b2.a = -2;
                    c.a.r0.a.r0.n.d(this.m.f8457b, this.f8479i);
                } else {
                    int i2 = this.f8480j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8450b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.r0.a.r0.n.d(this.m.f8457b, b2.f8450b);
                    }
                }
                this.m.f8457b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8486h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8487i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8488e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8489f;

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
                this.f8489f = dVar;
                this.f8488e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8489f.f8484f), "path");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8488e, "access:", this.f8489f.f8485g);
                    d dVar = this.f8489f;
                    if (c.a.r0.a.r0.n.a(v, dVar.f8486h, hashMap, dVar.f8487i.f8457b)) {
                        d dVar2 = this.f8489f;
                        c.a.r0.a.r0.n.b(dVar2.f8486h, dVar2.f8485g);
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
            this.f8487i = eVar;
            this.f8483e = str;
            this.f8484f = i2;
            this.f8485g = map;
            this.f8486h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8487i.f8457b.runOnJSThread(new a(this, this.f8487i.a.a(this.f8483e, false)));
            }
        }
    }

    /* renamed from: c.a.r0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0527e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8491f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8492g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8493h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8494i;

        /* renamed from: c.a.r0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8495e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0527e f8496f;

            public a(RunnableC0527e runnableC0527e, c.a.r0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0527e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8496f = runnableC0527e;
                this.f8495e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8496f.f8491f), "path");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8495e, "stat:", this.f8496f.f8492g);
                    RunnableC0527e runnableC0527e = this.f8496f;
                    if (c.a.r0.a.r0.n.a(v, runnableC0527e.f8493h, hashMap, runnableC0527e.f8494i.f8457b)) {
                        c.a.r0.a.r0.o.h hVar = new c.a.r0.a.r0.o.h();
                        c.a.r0.a.r0.c cVar = this.f8495e;
                        hVar.stats = cVar.f8452d;
                        hVar.errMsg = cVar.f8450b;
                        c.a.r0.a.r0.n.b(hVar, this.f8496f.f8492g);
                    }
                }
            }
        }

        public RunnableC0527e(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8494i = eVar;
            this.f8490e = str;
            this.f8491f = i2;
            this.f8492g = map;
            this.f8493h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8494i.f8457b.runOnJSThread(new a(this, this.f8494i.a.y(this.f8490e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8498f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8499g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8500h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8501i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8502e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8503f;

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
                this.f8503f = fVar;
                this.f8502e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8503f.f8498f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8502e, "getFileInfo:", this.f8503f.f8499g);
                    f fVar = this.f8503f;
                    if (c.a.r0.a.r0.n.a(v, fVar.f8500h, hashMap, fVar.f8501i.f8457b)) {
                        c.a.r0.a.r0.o.c cVar = new c.a.r0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8502e.f8450b;
                        c.a.r0.a.r0.c cVar2 = this.f8502e;
                        cVar.digest = cVar2.f8455g;
                        cVar.size = (int) cVar2.f8453e;
                        c.a.r0.a.r0.n.b(cVar, this.f8503f.f8499g);
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
            this.f8501i = eVar;
            this.f8497e = str;
            this.f8498f = i2;
            this.f8499g = map;
            this.f8500h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8501i.f8457b.runOnJSThread(new a(this, this.f8501i.a.e(this.f8497e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8506g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8507e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8508f;

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
                this.f8508f = gVar;
                this.f8507e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8507e, "getSavedFileList:", this.f8508f.f8504e);
                    g gVar = this.f8508f;
                    if (c.a.r0.a.r0.n.a(v, gVar.f8505f, null, gVar.f8506g.f8457b)) {
                        c.a.r0.a.r0.o.d dVar = new c.a.r0.a.r0.o.d();
                        List<c.a.r0.a.r0.d> list = this.f8507e.f8454f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.r0.a.r0.d[0] : (c.a.r0.a.r0.d[]) this.f8507e.f8454f.toArray(new c.a.r0.a.r0.d[size]);
                        g gVar2 = this.f8508f;
                        dVar.errMsg = gVar2.f8505f.errMsg;
                        c.a.r0.a.r0.n.b(dVar, gVar2.f8504e);
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
            this.f8506g = eVar;
            this.f8504e = map;
            this.f8505f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8506g.f8457b.runOnJSThread(new a(this, this.f8506g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8510f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8511g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8512h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8513i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8514e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8515f;

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
                this.f8515f = hVar;
                this.f8514e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8515f.f8510f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8514e, "removeSavedFile:", this.f8515f.f8511g);
                    h hVar = this.f8515f;
                    if (c.a.r0.a.r0.n.a(v, hVar.f8512h, hashMap, hVar.f8513i.f8457b)) {
                        h hVar2 = this.f8515f;
                        c.a.r0.a.r0.n.b(hVar2.f8512h, hVar2.f8511g);
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
            this.f8513i = eVar;
            this.f8509e = str;
            this.f8510f = i2;
            this.f8511g = map;
            this.f8512h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8513i.f8457b.runOnJSThread(new a(this, this.f8513i.a.t(this.f8509e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8518g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8519h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8520i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8521j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.r0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8522e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8523f;

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
                this.f8523f = iVar;
                this.f8522e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8523f.k), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8522e, "writeFile:", this.f8523f.f8519h);
                    i iVar = this.f8523f;
                    if (c.a.r0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f8457b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8523f.l;
                        bVar.errMsg = "writeFile:" + this.f8522e.f8450b;
                        i iVar2 = this.f8523f;
                        c.a.r0.a.r0.n.b(iVar2.l, iVar2.f8519h);
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
            this.f8516e = str;
            this.f8517f = str2;
            this.f8518g = bArr;
            this.f8519h = map;
            this.f8520i = str3;
            this.f8521j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c C = this.m.a.C(false, this.f8516e, TextUtils.isEmpty(this.f8517f) ? this.f8518g : this.f8517f, c.a.r0.a.r0.n.I("encoding", this.f8519h));
                if (!TextUtils.isEmpty(this.f8520i)) {
                    C.f8450b = this.f8520i;
                    C.a = -2;
                    c.a.r0.a.r0.n.d(this.m.f8457b, this.f8520i);
                } else {
                    int i2 = this.f8521j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8450b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.r0.a.r0.n.d(this.m.f8457b, C.f8450b);
                    }
                }
                this.m.f8457b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8524e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8525f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8526g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8527h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8528i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8529e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8530f;

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
                this.f8530f = jVar;
                this.f8529e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8530f.f8525f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8529e, "unlink:", this.f8530f.f8526g);
                    j jVar = this.f8530f;
                    if (c.a.r0.a.r0.n.a(v, jVar.f8527h, hashMap, jVar.f8528i.f8457b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8530f.f8527h;
                        bVar.errMsg = "unlink:" + this.f8529e.f8450b;
                        j jVar2 = this.f8530f;
                        c.a.r0.a.r0.n.b(jVar2.f8527h, jVar2.f8526g);
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
            this.f8528i = eVar;
            this.f8524e = str;
            this.f8525f = i2;
            this.f8526g = map;
            this.f8527h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8528i.f8457b.runOnJSThread(new a(this, this.f8528i.a.z(this.f8524e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8531e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8532f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8533g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8534h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8535i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8536j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8537e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8538f;

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
                this.f8538f = kVar;
                this.f8537e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8538f.f8533g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8538f.f8534h), "targetPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8537e, "unzip:", this.f8538f.f8535i);
                    k kVar = this.f8538f;
                    if (c.a.r0.a.r0.n.a(v, kVar.f8536j, hashMap, kVar.k.f8457b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8538f.f8536j;
                        bVar.errMsg = "unzip:" + this.f8537e.f8450b;
                        k kVar2 = this.f8538f;
                        c.a.r0.a.r0.n.b(kVar2.f8536j, kVar2.f8535i);
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
            this.k = eVar;
            this.f8531e = str;
            this.f8532f = str2;
            this.f8533g = i2;
            this.f8534h = i3;
            this.f8535i = map;
            this.f8536j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8457b.runOnJSThread(new a(this, this.k.a.A(this.f8531e, this.f8532f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8539e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8540f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8541g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8542h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8543i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8544j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8545e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8546f;

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
                this.f8546f = lVar;
                this.f8545e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8546f.f8541g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8546f.f8542h), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8545e, "saveFile:", this.f8546f.f8543i);
                    l lVar = this.f8546f;
                    if (c.a.r0.a.r0.n.a(v, lVar.f8544j, hashMap, lVar.k.f8457b)) {
                        c.a.r0.a.r0.o.g gVar = new c.a.r0.a.r0.o.g();
                        List<String> list = this.f8545e.f8451c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8545e.f8450b;
                        c.a.r0.a.r0.n.b(gVar, this.f8546f.f8543i);
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
            this.k = eVar;
            this.f8539e = str;
            this.f8540f = str2;
            this.f8541g = i2;
            this.f8542h = i3;
            this.f8543i = map;
            this.f8544j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8457b.runOnJSThread(new a(this, this.k.a.x(this.f8539e, this.f8540f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8547e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8548f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8549g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8550h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8551i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8552e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8553f;

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
                this.f8553f = mVar;
                this.f8552e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8553f.f8548f), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8552e, "readdir:", this.f8553f.f8549g);
                    m mVar = this.f8553f;
                    if (c.a.r0.a.r0.n.a(v, mVar.f8550h, hashMap, mVar.f8551i.f8457b)) {
                        c.a.r0.a.r0.o.e eVar = new c.a.r0.a.r0.o.e();
                        List<String> list = this.f8552e.f8451c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8552e.f8451c.toArray(new String[size]);
                        eVar.errMsg = this.f8552e.f8450b;
                        c.a.r0.a.r0.n.b(eVar, this.f8553f.f8549g);
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
            this.f8551i = eVar;
            this.f8547e = str;
            this.f8548f = i2;
            this.f8549g = map;
            this.f8550h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8551i.f8457b.runOnJSThread(new a(this, this.f8551i.a.s(this.f8547e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8555f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8556g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8557h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8558i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8559j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8560e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8561f;

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
                this.f8561f = nVar;
                this.f8560e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8561f.f8556g), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8560e, "rmdir:", this.f8561f.f8557h);
                    n nVar = this.f8561f;
                    if (c.a.r0.a.r0.n.a(v, nVar.f8558i, hashMap, nVar.f8559j.f8457b)) {
                        n nVar2 = this.f8561f;
                        c.a.r0.a.r0.n.b(nVar2.f8558i, nVar2.f8557h);
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
            this.f8559j = eVar;
            this.f8554e = str;
            this.f8555f = bool;
            this.f8556g = i2;
            this.f8557h = map;
            this.f8558i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8559j.f8457b.runOnJSThread(new a(this, this.f8559j.a.v(this.f8554e, this.f8555f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8563f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8564g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8565h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8566i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8567j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8568e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8569f;

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
                this.f8569f = oVar;
                this.f8568e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8569f.f8565h), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8568e, "readFile:", this.f8569f.f8566i);
                    o oVar = this.f8569f;
                    if (c.a.r0.a.r0.n.a(v, oVar.f8567j, hashMap, oVar.k.f8457b)) {
                        if (TextUtils.isEmpty(this.f8569f.f8563f)) {
                            c.a.r0.a.r0.o.a aVar = new c.a.r0.a.r0.o.a();
                            c.a.r0.a.r0.c cVar = this.f8568e;
                            if (cVar.f8456h == null) {
                                cVar.f8456h = new byte[0];
                            }
                            byte[] bArr = this.f8568e.f8456h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8568e.f8450b;
                            c.a.r0.a.r0.n.b(aVar, this.f8569f.f8566i);
                            return;
                        }
                        List<String> list = this.f8568e.f8451c;
                        String str = list != null ? list.get(0) : null;
                        c.a.r0.a.r0.o.f fVar = new c.a.r0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8568e.f8450b;
                        c.a.r0.a.r0.n.b(fVar, this.f8569f.f8566i);
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
            this.k = eVar;
            this.f8562e = str;
            this.f8563f = str2;
            this.f8564g = i2;
            this.f8565h = i3;
            this.f8566i = map;
            this.f8567j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c q = this.k.a.q(this.f8562e, this.f8563f, false);
                int i2 = this.f8564g;
                if (i2 != 7 && i2 != 12) {
                    q.f8450b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.r0.a.r0.n.d(this.k.f8457b, q.f8450b);
                }
                this.k.f8457b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8570e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8571f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8572g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8573h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8574i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8575j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8576e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8577f;

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
                this.f8577f = pVar;
                this.f8576e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8577f.f8572g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8577f.f8573h), "newPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8576e, "rename:", this.f8577f.f8574i);
                    p pVar = this.f8577f;
                    if (c.a.r0.a.r0.n.a(v, pVar.f8575j, hashMap, pVar.k.f8457b)) {
                        p pVar2 = this.f8577f;
                        c.a.r0.a.r0.n.b(pVar2.f8575j, pVar2.f8574i);
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
            this.k = eVar;
            this.f8570e = str;
            this.f8571f = str2;
            this.f8572g = i2;
            this.f8573h = i3;
            this.f8574i = map;
            this.f8575j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8457b.runOnJSThread(new a(this, this.k.a.u(this.f8570e, this.f8571f, false)));
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
        this.f8457b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("path", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("path", J);
            this.f8458c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
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
            this.f8458c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
            this.f8458c = c.a.r0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("srcPath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("destPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("srcPath", J);
            String I2 = c.a.r0.a.r0.n.I("destPath", J);
            this.f8458c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str, str2);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("filePath", J);
            this.f8458c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.r0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.r0.a.r0.n.J(this.a, jsObject, (bVar = new c.a.r0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8458c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8458c.h(new a(this, I, (Boolean) c.a.r0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("encoding", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("encoding", J);
            String I2 = c.a.r0.a.r0.n.I("filePath", J);
            this.f8458c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
                this.f8458c.k(str);
                c.a.r0.a.r0.c q = this.a.q(str, str2, true);
                c.a.r0.a.r0.n.d0(this.f8457b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f8451c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8458c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
                this.f8458c.k(str);
                c.a.r0.a.r0.c s = this.a.s(str, true);
                c.a.r0.a.r0.n.d0(this.f8457b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8451c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8451c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f8458c.h(new h(this, c.a.r0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("oldPath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("newPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("oldPath", J);
            String I2 = c.a.r0.a.r0.n.I("newPath", J);
            this.f8458c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str, str2);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8458c.h(new n(this, I, (Boolean) c.a.r0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
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
            this.f8458c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
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
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("path", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("path", J);
            this.f8458c.h(new RunnableC0527e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.r0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
                this.f8458c.k(str);
                c.a.r0.a.r0.c y = this.a.y(str, true);
                c.a.r0.a.r0.n.d0(this.f8457b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f8452d;
            }
            return null;
        }
        return (c.a.r0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("filePath", J);
            this.f8458c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("targetPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("zipFilePath", J);
            String I2 = c.a.r0.a.r0.n.I("targetPath", J);
            this.f8458c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
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
            this.f8458c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
                this.f8458c.k(str, str2);
                c.a.r0.a.r0.c x = this.a.x(str, str2, true);
                c.a.r0.a.r0.n.d0(this.f8457b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f8451c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
            this.f8458c.k(str);
            c.a.r0.a.r0.n.d0(this.f8457b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8457b, null, null)) {
                this.f8458c.k(str);
                c.a.r0.a.r0.c q = this.a.q(str, null, true);
                c.a.r0.a.r0.n.d0(this.f8457b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8456h == null) {
                    q.f8456h = new byte[0];
                }
                byte[] bArr = q.f8456h;
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
