package c.a.p0.a.h0;

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
    public c.a.p0.a.h0.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.b0.a f5427b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.h0.i f5428c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f5430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5431g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f5432h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5433i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f5434j;

        /* renamed from: c.a.p0.a.h0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0303a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5435e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f5436f;

            public RunnableC0303a(a aVar, c.a.p0.a.h0.c cVar) {
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
                this.f5436f = aVar;
                this.f5435e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5436f.f5431g), "dirPath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5435e, "mkdir:", this.f5436f.f5432h);
                    a aVar = this.f5436f;
                    if (c.a.p0.a.h0.n.a(v, aVar.f5433i, hashMap, aVar.f5434j.f5427b)) {
                        c.a.p0.a.h0.o.b bVar = this.f5436f.f5433i;
                        bVar.errMsg = "mkdir:" + this.f5435e.f5420b;
                        a aVar2 = this.f5436f;
                        c.a.p0.a.h0.n.b(aVar2.f5433i, aVar2.f5432h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5434j = eVar;
            this.f5429e = str;
            this.f5430f = bool;
            this.f5431g = i2;
            this.f5432h = map;
            this.f5433i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5434j.f5427b.runOnJSThread(new RunnableC0303a(this, this.f5434j.a.o(this.f5429e, this.f5430f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5438f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5439g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5440h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f5441i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5442j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5443e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f5444f;

            public a(b bVar, c.a.p0.a.h0.c cVar) {
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
                this.f5444f = bVar;
                this.f5443e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5444f.f5439g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f5444f.f5440h), "destPath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5443e, "copyFile:", this.f5444f.f5441i);
                    b bVar = this.f5444f;
                    if (c.a.p0.a.h0.n.a(v, bVar.f5442j, hashMap, bVar.k.f5427b)) {
                        b bVar2 = this.f5444f;
                        c.a.p0.a.h0.n.b(bVar2.f5442j, bVar2.f5441i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5437e = str;
            this.f5438f = str2;
            this.f5439g = i2;
            this.f5440h = i3;
            this.f5441i = map;
            this.f5442j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f5427b.runOnJSThread(new a(this, this.k.a.c(this.f5437e, this.f5438f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f5447g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f5448h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5449i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f5450j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.p0.a.h0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5451e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f5452f;

            public a(c cVar, c.a.p0.a.h0.c cVar2) {
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
                this.f5452f = cVar;
                this.f5451e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5452f.k), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5451e, "appendFile:", this.f5452f.f5448h);
                    c cVar = this.f5452f;
                    if (c.a.p0.a.h0.n.a(v, cVar.l, hashMap, cVar.m.f5427b)) {
                        c cVar2 = this.f5452f;
                        c.a.p0.a.h0.n.b(cVar2.l, cVar2.f5448h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.p0.a.h0.o.b bVar) {
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
            this.f5445e = str;
            this.f5446f = str2;
            this.f5447g = bArr;
            this.f5448h = map;
            this.f5449i = str3;
            this.f5450j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h0.c b2 = this.m.a.b(this.f5445e, TextUtils.isEmpty(this.f5446f) ? this.f5447g : this.f5446f, c.a.p0.a.h0.n.I("encoding", this.f5448h), false);
                if (!TextUtils.isEmpty(this.f5449i)) {
                    b2.f5420b = this.f5449i;
                    b2.a = -2;
                    c.a.p0.a.h0.n.d(this.m.f5427b, this.f5449i);
                } else {
                    int i2 = this.f5450j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f5420b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.p0.a.h0.n.d(this.m.f5427b, b2.f5420b);
                    }
                }
                this.m.f5427b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5453e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5454f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f5455g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5456h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f5457i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5458e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f5459f;

            public a(d dVar, c.a.p0.a.h0.c cVar) {
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
                this.f5459f = dVar;
                this.f5458e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5459f.f5454f), "path");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5458e, "access:", this.f5459f.f5455g);
                    d dVar = this.f5459f;
                    if (c.a.p0.a.h0.n.a(v, dVar.f5456h, hashMap, dVar.f5457i.f5427b)) {
                        d dVar2 = this.f5459f;
                        c.a.p0.a.h0.n.b(dVar2.f5456h, dVar2.f5455g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5457i = eVar;
            this.f5453e = str;
            this.f5454f = i2;
            this.f5455g = map;
            this.f5456h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5457i.f5427b.runOnJSThread(new a(this, this.f5457i.a.a(this.f5453e, false)));
            }
        }
    }

    /* renamed from: c.a.p0.a.h0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0304e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5461f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f5462g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5463h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f5464i;

        /* renamed from: c.a.p0.a.h0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5465e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0304e f5466f;

            public a(RunnableC0304e runnableC0304e, c.a.p0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0304e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5466f = runnableC0304e;
                this.f5465e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5466f.f5461f), "path");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5465e, "stat:", this.f5466f.f5462g);
                    RunnableC0304e runnableC0304e = this.f5466f;
                    if (c.a.p0.a.h0.n.a(v, runnableC0304e.f5463h, hashMap, runnableC0304e.f5464i.f5427b)) {
                        c.a.p0.a.h0.o.h hVar = new c.a.p0.a.h0.o.h();
                        c.a.p0.a.h0.c cVar = this.f5465e;
                        hVar.stats = cVar.f5422d;
                        hVar.errMsg = cVar.f5420b;
                        c.a.p0.a.h0.n.b(hVar, this.f5466f.f5462g);
                    }
                }
            }
        }

        public RunnableC0304e(e eVar, String str, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5464i = eVar;
            this.f5460e = str;
            this.f5461f = i2;
            this.f5462g = map;
            this.f5463h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5464i.f5427b.runOnJSThread(new a(this, this.f5464i.a.y(this.f5460e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5468f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f5469g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5470h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f5471i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5472e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f5473f;

            public a(f fVar, c.a.p0.a.h0.c cVar) {
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
                this.f5473f = fVar;
                this.f5472e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5473f.f5468f), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5472e, "getFileInfo:", this.f5473f.f5469g);
                    f fVar = this.f5473f;
                    if (c.a.p0.a.h0.n.a(v, fVar.f5470h, hashMap, fVar.f5471i.f5427b)) {
                        c.a.p0.a.h0.o.c cVar = new c.a.p0.a.h0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f5472e.f5420b;
                        c.a.p0.a.h0.c cVar2 = this.f5472e;
                        cVar.digest = cVar2.f5425g;
                        cVar.size = (int) cVar2.f5423e;
                        c.a.p0.a.h0.n.b(cVar, this.f5473f.f5469g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5471i = eVar;
            this.f5467e = str;
            this.f5468f = i2;
            this.f5469g = map;
            this.f5470h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5471i.f5427b.runOnJSThread(new a(this, this.f5471i.a.e(this.f5467e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f5474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5475f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f5476g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5477e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f5478f;

            public a(g gVar, c.a.p0.a.h0.c cVar) {
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
                this.f5478f = gVar;
                this.f5477e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5477e, "getSavedFileList:", this.f5478f.f5474e);
                    g gVar = this.f5478f;
                    if (c.a.p0.a.h0.n.a(v, gVar.f5475f, null, gVar.f5476g.f5427b)) {
                        c.a.p0.a.h0.o.d dVar = new c.a.p0.a.h0.o.d();
                        List<c.a.p0.a.h0.d> list = this.f5477e.f5424f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.p0.a.h0.d[0] : (c.a.p0.a.h0.d[]) this.f5477e.f5424f.toArray(new c.a.p0.a.h0.d[size]);
                        g gVar2 = this.f5478f;
                        dVar.errMsg = gVar2.f5475f.errMsg;
                        c.a.p0.a.h0.n.b(dVar, gVar2.f5474e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5476g = eVar;
            this.f5474e = map;
            this.f5475f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5476g.f5427b.runOnJSThread(new a(this, this.f5476g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f5481g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5482h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f5483i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5484e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f5485f;

            public a(h hVar, c.a.p0.a.h0.c cVar) {
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
                this.f5485f = hVar;
                this.f5484e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5485f.f5480f), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5484e, "removeSavedFile:", this.f5485f.f5481g);
                    h hVar = this.f5485f;
                    if (c.a.p0.a.h0.n.a(v, hVar.f5482h, hashMap, hVar.f5483i.f5427b)) {
                        h hVar2 = this.f5485f;
                        c.a.p0.a.h0.n.b(hVar2.f5482h, hVar2.f5481g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5483i = eVar;
            this.f5479e = str;
            this.f5480f = i2;
            this.f5481g = map;
            this.f5482h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5483i.f5427b.runOnJSThread(new a(this, this.f5483i.a.t(this.f5479e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5486e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5487f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f5488g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f5489h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5490i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f5491j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.p0.a.h0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5492e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f5493f;

            public a(i iVar, c.a.p0.a.h0.c cVar) {
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
                this.f5493f = iVar;
                this.f5492e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5493f.k), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5492e, "writeFile:", this.f5493f.f5489h);
                    i iVar = this.f5493f;
                    if (c.a.p0.a.h0.n.a(v, iVar.l, hashMap, iVar.m.f5427b)) {
                        c.a.p0.a.h0.o.b bVar = this.f5493f.l;
                        bVar.errMsg = "writeFile:" + this.f5492e.f5420b;
                        i iVar2 = this.f5493f;
                        c.a.p0.a.h0.n.b(iVar2.l, iVar2.f5489h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.p0.a.h0.o.b bVar) {
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
            this.f5486e = str;
            this.f5487f = str2;
            this.f5488g = bArr;
            this.f5489h = map;
            this.f5490i = str3;
            this.f5491j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h0.c C = this.m.a.C(false, this.f5486e, TextUtils.isEmpty(this.f5487f) ? this.f5488g : this.f5487f, c.a.p0.a.h0.n.I("encoding", this.f5489h));
                if (!TextUtils.isEmpty(this.f5490i)) {
                    C.f5420b = this.f5490i;
                    C.a = -2;
                    c.a.p0.a.h0.n.d(this.m.f5427b, this.f5490i);
                } else {
                    int i2 = this.f5491j;
                    if (i2 != 7 && i2 != 12) {
                        C.f5420b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.p0.a.h0.n.d(this.m.f5427b, C.f5420b);
                    }
                }
                this.m.f5427b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5494e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5495f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f5496g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5497h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f5498i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5499e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f5500f;

            public a(j jVar, c.a.p0.a.h0.c cVar) {
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
                this.f5500f = jVar;
                this.f5499e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5500f.f5495f), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5499e, "unlink:", this.f5500f.f5496g);
                    j jVar = this.f5500f;
                    if (c.a.p0.a.h0.n.a(v, jVar.f5497h, hashMap, jVar.f5498i.f5427b)) {
                        c.a.p0.a.h0.o.b bVar = this.f5500f.f5497h;
                        bVar.errMsg = "unlink:" + this.f5499e.f5420b;
                        j jVar2 = this.f5500f;
                        c.a.p0.a.h0.n.b(jVar2.f5497h, jVar2.f5496g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5498i = eVar;
            this.f5494e = str;
            this.f5495f = i2;
            this.f5496g = map;
            this.f5497h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5498i.f5427b.runOnJSThread(new a(this, this.f5498i.a.z(this.f5494e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5502f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5503g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5504h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f5505i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5506j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5507e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f5508f;

            public a(k kVar, c.a.p0.a.h0.c cVar) {
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
                this.f5508f = kVar;
                this.f5507e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5508f.f5503g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f5508f.f5504h), "targetPath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5507e, "unzip:", this.f5508f.f5505i);
                    k kVar = this.f5508f;
                    if (c.a.p0.a.h0.n.a(v, kVar.f5506j, hashMap, kVar.k.f5427b)) {
                        c.a.p0.a.h0.o.b bVar = this.f5508f.f5506j;
                        bVar.errMsg = "unzip:" + this.f5507e.f5420b;
                        k kVar2 = this.f5508f;
                        c.a.p0.a.h0.n.b(kVar2.f5506j, kVar2.f5505i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5501e = str;
            this.f5502f = str2;
            this.f5503g = i2;
            this.f5504h = i3;
            this.f5505i = map;
            this.f5506j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f5427b.runOnJSThread(new a(this, this.k.a.A(this.f5501e, this.f5502f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5510f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5511g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5512h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f5513i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5514j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5515e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f5516f;

            public a(l lVar, c.a.p0.a.h0.c cVar) {
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
                this.f5516f = lVar;
                this.f5515e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5516f.f5511g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f5516f.f5512h), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5515e, "saveFile:", this.f5516f.f5513i);
                    l lVar = this.f5516f;
                    if (c.a.p0.a.h0.n.a(v, lVar.f5514j, hashMap, lVar.k.f5427b)) {
                        c.a.p0.a.h0.o.g gVar = new c.a.p0.a.h0.o.g();
                        List<String> list = this.f5515e.f5421c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f5515e.f5420b;
                        c.a.p0.a.h0.n.b(gVar, this.f5516f.f5513i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5509e = str;
            this.f5510f = str2;
            this.f5511g = i2;
            this.f5512h = i3;
            this.f5513i = map;
            this.f5514j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f5427b.runOnJSThread(new a(this, this.k.a.x(this.f5509e, this.f5510f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5518f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f5519g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5520h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f5521i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5522e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f5523f;

            public a(m mVar, c.a.p0.a.h0.c cVar) {
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
                this.f5523f = mVar;
                this.f5522e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5523f.f5518f), "dirPath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5522e, "readdir:", this.f5523f.f5519g);
                    m mVar = this.f5523f;
                    if (c.a.p0.a.h0.n.a(v, mVar.f5520h, hashMap, mVar.f5521i.f5427b)) {
                        c.a.p0.a.h0.o.e eVar = new c.a.p0.a.h0.o.e();
                        List<String> list = this.f5522e.f5421c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f5522e.f5421c.toArray(new String[size]);
                        eVar.errMsg = this.f5522e.f5420b;
                        c.a.p0.a.h0.n.b(eVar, this.f5523f.f5519g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5521i = eVar;
            this.f5517e = str;
            this.f5518f = i2;
            this.f5519g = map;
            this.f5520h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5521i.f5427b.runOnJSThread(new a(this, this.f5521i.a.s(this.f5517e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5524e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f5525f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5526g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f5527h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5528i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f5529j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5530e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f5531f;

            public a(n nVar, c.a.p0.a.h0.c cVar) {
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
                this.f5531f = nVar;
                this.f5530e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5531f.f5526g), "dirPath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5530e, "rmdir:", this.f5531f.f5527h);
                    n nVar = this.f5531f;
                    if (c.a.p0.a.h0.n.a(v, nVar.f5528i, hashMap, nVar.f5529j.f5427b)) {
                        n nVar2 = this.f5531f;
                        c.a.p0.a.h0.n.b(nVar2.f5528i, nVar2.f5527h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5529j = eVar;
            this.f5524e = str;
            this.f5525f = bool;
            this.f5526g = i2;
            this.f5527h = map;
            this.f5528i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5529j.f5427b.runOnJSThread(new a(this, this.f5529j.a.v(this.f5524e, this.f5525f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5532e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5533f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5534g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5535h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f5536i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5537j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5538e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f5539f;

            public a(o oVar, c.a.p0.a.h0.c cVar) {
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
                this.f5539f = oVar;
                this.f5538e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5539f.f5535h), "filePath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5538e, "readFile:", this.f5539f.f5536i);
                    o oVar = this.f5539f;
                    if (c.a.p0.a.h0.n.a(v, oVar.f5537j, hashMap, oVar.k.f5427b)) {
                        if (TextUtils.isEmpty(this.f5539f.f5533f)) {
                            c.a.p0.a.h0.o.a aVar = new c.a.p0.a.h0.o.a();
                            c.a.p0.a.h0.c cVar = this.f5538e;
                            if (cVar.f5426h == null) {
                                cVar.f5426h = new byte[0];
                            }
                            byte[] bArr = this.f5538e.f5426h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f5538e.f5420b;
                            c.a.p0.a.h0.n.b(aVar, this.f5539f.f5536i);
                            return;
                        }
                        List<String> list = this.f5538e.f5421c;
                        String str = list != null ? list.get(0) : null;
                        c.a.p0.a.h0.o.f fVar = new c.a.p0.a.h0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f5538e.f5420b;
                        c.a.p0.a.h0.n.b(fVar, this.f5539f.f5536i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5532e = str;
            this.f5533f = str2;
            this.f5534g = i2;
            this.f5535h = i3;
            this.f5536i = map;
            this.f5537j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h0.c q = this.k.a.q(this.f5532e, this.f5533f, false);
                int i2 = this.f5534g;
                if (i2 != 7 && i2 != 12) {
                    q.f5420b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.p0.a.h0.n.d(this.k.f5427b, q.f5420b);
                }
                this.k.f5427b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5541f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5542g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5543h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f5544i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.o.b f5545j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h0.c f5546e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f5547f;

            public a(p pVar, c.a.p0.a.h0.c cVar) {
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
                this.f5547f = pVar;
                this.f5546e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f5547f.f5542g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f5547f.f5543h), "newPath");
                    c.a.p0.a.h0.b v = c.a.p0.a.h0.n.v(this.f5546e, "rename:", this.f5547f.f5544i);
                    p pVar = this.f5547f;
                    if (c.a.p0.a.h0.n.a(v, pVar.f5545j, hashMap, pVar.k.f5427b)) {
                        p pVar2 = this.f5547f;
                        c.a.p0.a.h0.n.b(pVar2.f5545j, pVar2.f5544i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.p0.a.h0.o.b bVar) {
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
            this.f5540e = str;
            this.f5541f = str2;
            this.f5542g = i2;
            this.f5543h = i3;
            this.f5544i = map;
            this.f5545j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f5427b.runOnJSThread(new a(this, this.k.a.u(this.f5540e, this.f5541f, false)));
            }
        }
    }

    public e(c.a.p0.a.b0.a aVar) {
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
        this.f5427b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("path", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("path", J);
            this.f5428c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("encoding", jsObject);
            int O2 = c.a.p0.a.h0.n.O("filePath", jsObject);
            int O3 = c.a.p0.a.h0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : c.a.p0.a.h0.n.w(O3);
            byte[] r = c.a.p0.a.h0.n.r(jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("data", J);
            String I2 = c.a.p0.a.h0.n.I("filePath", J);
            this.f5428c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.p0.a.e2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new c.a.p0.a.h0.l();
            }
            this.a = new c.a.p0.a.h0.f(AppRuntime.getAppContext(), c.a.p0.a.w0.f.U().z(), lVar);
            this.f5428c = c.a.p0.a.h0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("srcPath", jsObject);
            int O2 = c.a.p0.a.h0.n.O("destPath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("srcPath", J);
            String I2 = c.a.p0.a.h0.n.I("destPath", J);
            this.f5428c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str, str2);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("filePath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("filePath", J);
            this.f5428c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.p0.a.h0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.p0.a.h0.n.J(this.a, jsObject, (bVar = new c.a.p0.a.h0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f5428c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("dirPath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("dirPath", J);
            this.f5428c.h(new a(this, I, (Boolean) c.a.p0.a.h0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("filePath", jsObject);
            int O2 = c.a.p0.a.h0.n.O("encoding", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("encoding", J);
            String I2 = c.a.p0.a.h0.n.I("filePath", J);
            this.f5428c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
                this.f5428c.k(str);
                c.a.p0.a.h0.c q = this.a.q(str, str2, true);
                c.a.p0.a.h0.n.d0(this.f5427b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f5421c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("dirPath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("dirPath", J);
            this.f5428c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
                this.f5428c.k(str);
                c.a.p0.a.h0.c s = this.a.s(str, true);
                c.a.p0.a.h0.n.d0(this.f5427b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f5421c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f5421c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("filePath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f5428c.h(new h(this, c.a.p0.a.h0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("oldPath", jsObject);
            int O2 = c.a.p0.a.h0.n.O("newPath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("oldPath", J);
            String I2 = c.a.p0.a.h0.n.I("newPath", J);
            this.f5428c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str, str2);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("dirPath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("dirPath", J);
            this.f5428c.h(new n(this, I, (Boolean) c.a.p0.a.h0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("tempFilePath", jsObject);
            int O2 = c.a.p0.a.h0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("tempFilePath", J);
            String I2 = c.a.p0.a.h0.n.I("filePath", J);
            this.f5428c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.p0.a.h0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("path", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("path", J);
            this.f5428c.h(new RunnableC0304e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.p0.a.h0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
                this.f5428c.k(str);
                c.a.p0.a.h0.c y = this.a.y(str, true);
                c.a.p0.a.h0.n.d0(this.f5427b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f5422d;
            }
            return null;
        }
        return (c.a.p0.a.h0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("filePath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("filePath", J);
            this.f5428c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("zipFilePath", jsObject);
            int O2 = c.a.p0.a.h0.n.O("targetPath", jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("zipFilePath", J);
            String I2 = c.a.p0.a.h0.n.I("targetPath", J);
            this.f5428c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.h0.n.O("filePath", jsObject);
            String w = c.a.p0.a.h0.n.w(c.a.p0.a.h0.n.O("data", jsObject));
            int O2 = c.a.p0.a.h0.n.O("encoding", jsObject);
            byte[] r = c.a.p0.a.h0.n.r(jsObject);
            c.a.p0.a.h0.o.b bVar = new c.a.p0.a.h0.o.b();
            Map<String, Object> J = c.a.p0.a.h0.n.J(this.a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.h0.n.I("data", J);
            String I2 = c.a.p0.a.h0.n.I("filePath", J);
            this.f5428c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
                this.f5428c.k(str, str2);
                c.a.p0.a.h0.c x = this.a.x(str, str2, true);
                c.a.p0.a.h0.n.d0(this.f5427b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f5421c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
            this.f5428c.k(str);
            c.a.p0.a.h0.n.d0(this.f5427b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.p0.a.h0.n.T(this.a, this.f5427b, null, null)) {
                this.f5428c.k(str);
                c.a.p0.a.h0.c q = this.a.q(str, null, true);
                c.a.p0.a.h0.n.d0(this.f5427b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f5426h == null) {
                    q.f5426h = new byte[0];
                }
                byte[] bArr = q.f5426h;
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
