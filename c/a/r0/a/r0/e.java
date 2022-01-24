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
    public c.a.r0.a.l0.a f8599b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.r0.i f8600c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8603g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8604h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8605i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8606j;

        /* renamed from: c.a.r0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0535a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8607e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8608f;

            public RunnableC0535a(a aVar, c.a.r0.a.r0.c cVar) {
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
                this.f8608f = aVar;
                this.f8607e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8608f.f8603g), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8607e, "mkdir:", this.f8608f.f8604h);
                    a aVar = this.f8608f;
                    if (c.a.r0.a.r0.n.a(v, aVar.f8605i, hashMap, aVar.f8606j.f8599b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8608f.f8605i;
                        bVar.errMsg = "mkdir:" + this.f8607e.f8592b;
                        a aVar2 = this.f8608f;
                        c.a.r0.a.r0.n.b(aVar2.f8605i, aVar2.f8604h);
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
            this.f8606j = eVar;
            this.f8601e = str;
            this.f8602f = bool;
            this.f8603g = i2;
            this.f8604h = map;
            this.f8605i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8606j.f8599b.runOnJSThread(new RunnableC0535a(this, this.f8606j.a.o(this.f8601e, this.f8602f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8611g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8612h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8613i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8614j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8615e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8616f;

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
                this.f8616f = bVar;
                this.f8615e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8616f.f8611g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8616f.f8612h), "destPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8615e, "copyFile:", this.f8616f.f8613i);
                    b bVar = this.f8616f;
                    if (c.a.r0.a.r0.n.a(v, bVar.f8614j, hashMap, bVar.k.f8599b)) {
                        b bVar2 = this.f8616f;
                        c.a.r0.a.r0.n.b(bVar2.f8614j, bVar2.f8613i);
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
            this.f8609e = str;
            this.f8610f = str2;
            this.f8611g = i2;
            this.f8612h = i3;
            this.f8613i = map;
            this.f8614j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8599b.runOnJSThread(new a(this, this.k.a.c(this.f8609e, this.f8610f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8618f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8619g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8620h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8621i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8622j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.r0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8623e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8624f;

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
                this.f8624f = cVar;
                this.f8623e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8624f.k), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8623e, "appendFile:", this.f8624f.f8620h);
                    c cVar = this.f8624f;
                    if (c.a.r0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f8599b)) {
                        c cVar2 = this.f8624f;
                        c.a.r0.a.r0.n.b(cVar2.l, cVar2.f8620h);
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
            this.f8617e = str;
            this.f8618f = str2;
            this.f8619g = bArr;
            this.f8620h = map;
            this.f8621i = str3;
            this.f8622j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c b2 = this.m.a.b(this.f8617e, TextUtils.isEmpty(this.f8618f) ? this.f8619g : this.f8618f, c.a.r0.a.r0.n.I("encoding", this.f8620h), false);
                if (!TextUtils.isEmpty(this.f8621i)) {
                    b2.f8592b = this.f8621i;
                    b2.a = -2;
                    c.a.r0.a.r0.n.d(this.m.f8599b, this.f8621i);
                } else {
                    int i2 = this.f8622j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8592b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.r0.a.r0.n.d(this.m.f8599b, b2.f8592b);
                    }
                }
                this.m.f8599b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8625e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8626f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8627g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8628h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8629i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8630e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8631f;

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
                this.f8631f = dVar;
                this.f8630e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8631f.f8626f), "path");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8630e, "access:", this.f8631f.f8627g);
                    d dVar = this.f8631f;
                    if (c.a.r0.a.r0.n.a(v, dVar.f8628h, hashMap, dVar.f8629i.f8599b)) {
                        d dVar2 = this.f8631f;
                        c.a.r0.a.r0.n.b(dVar2.f8628h, dVar2.f8627g);
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
            this.f8629i = eVar;
            this.f8625e = str;
            this.f8626f = i2;
            this.f8627g = map;
            this.f8628h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8629i.f8599b.runOnJSThread(new a(this, this.f8629i.a.a(this.f8625e, false)));
            }
        }
    }

    /* renamed from: c.a.r0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0536e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8634g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8635h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8636i;

        /* renamed from: c.a.r0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8637e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0536e f8638f;

            public a(RunnableC0536e runnableC0536e, c.a.r0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0536e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8638f = runnableC0536e;
                this.f8637e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8638f.f8633f), "path");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8637e, "stat:", this.f8638f.f8634g);
                    RunnableC0536e runnableC0536e = this.f8638f;
                    if (c.a.r0.a.r0.n.a(v, runnableC0536e.f8635h, hashMap, runnableC0536e.f8636i.f8599b)) {
                        c.a.r0.a.r0.o.h hVar = new c.a.r0.a.r0.o.h();
                        c.a.r0.a.r0.c cVar = this.f8637e;
                        hVar.stats = cVar.f8594d;
                        hVar.errMsg = cVar.f8592b;
                        c.a.r0.a.r0.n.b(hVar, this.f8638f.f8634g);
                    }
                }
            }
        }

        public RunnableC0536e(e eVar, String str, int i2, Map map, c.a.r0.a.r0.o.b bVar) {
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
            this.f8636i = eVar;
            this.f8632e = str;
            this.f8633f = i2;
            this.f8634g = map;
            this.f8635h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8636i.f8599b.runOnJSThread(new a(this, this.f8636i.a.y(this.f8632e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8641g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8642h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8643i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8644e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8645f;

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
                this.f8645f = fVar;
                this.f8644e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8645f.f8640f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8644e, "getFileInfo:", this.f8645f.f8641g);
                    f fVar = this.f8645f;
                    if (c.a.r0.a.r0.n.a(v, fVar.f8642h, hashMap, fVar.f8643i.f8599b)) {
                        c.a.r0.a.r0.o.c cVar = new c.a.r0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8644e.f8592b;
                        c.a.r0.a.r0.c cVar2 = this.f8644e;
                        cVar.digest = cVar2.f8597g;
                        cVar.size = (int) cVar2.f8595e;
                        c.a.r0.a.r0.n.b(cVar, this.f8645f.f8641g);
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
            this.f8643i = eVar;
            this.f8639e = str;
            this.f8640f = i2;
            this.f8641g = map;
            this.f8642h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8643i.f8599b.runOnJSThread(new a(this, this.f8643i.a.e(this.f8639e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8648g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8649e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8650f;

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
                this.f8650f = gVar;
                this.f8649e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8649e, "getSavedFileList:", this.f8650f.f8646e);
                    g gVar = this.f8650f;
                    if (c.a.r0.a.r0.n.a(v, gVar.f8647f, null, gVar.f8648g.f8599b)) {
                        c.a.r0.a.r0.o.d dVar = new c.a.r0.a.r0.o.d();
                        List<c.a.r0.a.r0.d> list = this.f8649e.f8596f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.r0.a.r0.d[0] : (c.a.r0.a.r0.d[]) this.f8649e.f8596f.toArray(new c.a.r0.a.r0.d[size]);
                        g gVar2 = this.f8650f;
                        dVar.errMsg = gVar2.f8647f.errMsg;
                        c.a.r0.a.r0.n.b(dVar, gVar2.f8646e);
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
            this.f8648g = eVar;
            this.f8646e = map;
            this.f8647f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8648g.f8599b.runOnJSThread(new a(this, this.f8648g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8651e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8652f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8653g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8654h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8655i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8656e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8657f;

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
                this.f8657f = hVar;
                this.f8656e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8657f.f8652f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8656e, "removeSavedFile:", this.f8657f.f8653g);
                    h hVar = this.f8657f;
                    if (c.a.r0.a.r0.n.a(v, hVar.f8654h, hashMap, hVar.f8655i.f8599b)) {
                        h hVar2 = this.f8657f;
                        c.a.r0.a.r0.n.b(hVar2.f8654h, hVar2.f8653g);
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
            this.f8655i = eVar;
            this.f8651e = str;
            this.f8652f = i2;
            this.f8653g = map;
            this.f8654h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8655i.f8599b.runOnJSThread(new a(this, this.f8655i.a.t(this.f8651e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8659f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8660g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8661h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8662i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8663j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.r0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8664e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8665f;

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
                this.f8665f = iVar;
                this.f8664e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8665f.k), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8664e, "writeFile:", this.f8665f.f8661h);
                    i iVar = this.f8665f;
                    if (c.a.r0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f8599b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8665f.l;
                        bVar.errMsg = "writeFile:" + this.f8664e.f8592b;
                        i iVar2 = this.f8665f;
                        c.a.r0.a.r0.n.b(iVar2.l, iVar2.f8661h);
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
            this.f8658e = str;
            this.f8659f = str2;
            this.f8660g = bArr;
            this.f8661h = map;
            this.f8662i = str3;
            this.f8663j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c C = this.m.a.C(false, this.f8658e, TextUtils.isEmpty(this.f8659f) ? this.f8660g : this.f8659f, c.a.r0.a.r0.n.I("encoding", this.f8661h));
                if (!TextUtils.isEmpty(this.f8662i)) {
                    C.f8592b = this.f8662i;
                    C.a = -2;
                    c.a.r0.a.r0.n.d(this.m.f8599b, this.f8662i);
                } else {
                    int i2 = this.f8663j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8592b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.r0.a.r0.n.d(this.m.f8599b, C.f8592b);
                    }
                }
                this.m.f8599b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8667f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8668g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8669h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8670i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8671e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8672f;

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
                this.f8672f = jVar;
                this.f8671e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8672f.f8667f), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8671e, "unlink:", this.f8672f.f8668g);
                    j jVar = this.f8672f;
                    if (c.a.r0.a.r0.n.a(v, jVar.f8669h, hashMap, jVar.f8670i.f8599b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8672f.f8669h;
                        bVar.errMsg = "unlink:" + this.f8671e.f8592b;
                        j jVar2 = this.f8672f;
                        c.a.r0.a.r0.n.b(jVar2.f8669h, jVar2.f8668g);
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
            this.f8670i = eVar;
            this.f8666e = str;
            this.f8667f = i2;
            this.f8668g = map;
            this.f8669h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8670i.f8599b.runOnJSThread(new a(this, this.f8670i.a.z(this.f8666e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8674f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8675g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8676h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8677i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8678j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8679e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8680f;

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
                this.f8680f = kVar;
                this.f8679e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8680f.f8675g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8680f.f8676h), "targetPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8679e, "unzip:", this.f8680f.f8677i);
                    k kVar = this.f8680f;
                    if (c.a.r0.a.r0.n.a(v, kVar.f8678j, hashMap, kVar.k.f8599b)) {
                        c.a.r0.a.r0.o.b bVar = this.f8680f.f8678j;
                        bVar.errMsg = "unzip:" + this.f8679e.f8592b;
                        k kVar2 = this.f8680f;
                        c.a.r0.a.r0.n.b(kVar2.f8678j, kVar2.f8677i);
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
            this.f8673e = str;
            this.f8674f = str2;
            this.f8675g = i2;
            this.f8676h = i3;
            this.f8677i = map;
            this.f8678j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8599b.runOnJSThread(new a(this, this.k.a.A(this.f8673e, this.f8674f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8681e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8682f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8683g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8684h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8685i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8686j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8687e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8688f;

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
                this.f8688f = lVar;
                this.f8687e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8688f.f8683g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8688f.f8684h), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8687e, "saveFile:", this.f8688f.f8685i);
                    l lVar = this.f8688f;
                    if (c.a.r0.a.r0.n.a(v, lVar.f8686j, hashMap, lVar.k.f8599b)) {
                        c.a.r0.a.r0.o.g gVar = new c.a.r0.a.r0.o.g();
                        List<String> list = this.f8687e.f8593c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8687e.f8592b;
                        c.a.r0.a.r0.n.b(gVar, this.f8688f.f8685i);
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
            this.f8681e = str;
            this.f8682f = str2;
            this.f8683g = i2;
            this.f8684h = i3;
            this.f8685i = map;
            this.f8686j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8599b.runOnJSThread(new a(this, this.k.a.x(this.f8681e, this.f8682f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8689e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8690f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8691g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8692h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8693i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8694e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8695f;

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
                this.f8695f = mVar;
                this.f8694e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8695f.f8690f), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8694e, "readdir:", this.f8695f.f8691g);
                    m mVar = this.f8695f;
                    if (c.a.r0.a.r0.n.a(v, mVar.f8692h, hashMap, mVar.f8693i.f8599b)) {
                        c.a.r0.a.r0.o.e eVar = new c.a.r0.a.r0.o.e();
                        List<String> list = this.f8694e.f8593c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8694e.f8593c.toArray(new String[size]);
                        eVar.errMsg = this.f8694e.f8592b;
                        c.a.r0.a.r0.n.b(eVar, this.f8695f.f8691g);
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
            this.f8693i = eVar;
            this.f8689e = str;
            this.f8690f = i2;
            this.f8691g = map;
            this.f8692h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8693i.f8599b.runOnJSThread(new a(this, this.f8693i.a.s(this.f8689e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8697f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8698g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8699h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8700i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8701j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8702e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8703f;

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
                this.f8703f = nVar;
                this.f8702e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8703f.f8698g), "dirPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8702e, "rmdir:", this.f8703f.f8699h);
                    n nVar = this.f8703f;
                    if (c.a.r0.a.r0.n.a(v, nVar.f8700i, hashMap, nVar.f8701j.f8599b)) {
                        n nVar2 = this.f8703f;
                        c.a.r0.a.r0.n.b(nVar2.f8700i, nVar2.f8699h);
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
            this.f8701j = eVar;
            this.f8696e = str;
            this.f8697f = bool;
            this.f8698g = i2;
            this.f8699h = map;
            this.f8700i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8701j.f8599b.runOnJSThread(new a(this, this.f8701j.a.v(this.f8696e, this.f8697f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8706g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8707h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8708i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8709j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8710e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8711f;

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
                this.f8711f = oVar;
                this.f8710e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8711f.f8707h), "filePath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8710e, "readFile:", this.f8711f.f8708i);
                    o oVar = this.f8711f;
                    if (c.a.r0.a.r0.n.a(v, oVar.f8709j, hashMap, oVar.k.f8599b)) {
                        if (TextUtils.isEmpty(this.f8711f.f8705f)) {
                            c.a.r0.a.r0.o.a aVar = new c.a.r0.a.r0.o.a();
                            c.a.r0.a.r0.c cVar = this.f8710e;
                            if (cVar.f8598h == null) {
                                cVar.f8598h = new byte[0];
                            }
                            byte[] bArr = this.f8710e.f8598h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8710e.f8592b;
                            c.a.r0.a.r0.n.b(aVar, this.f8711f.f8708i);
                            return;
                        }
                        List<String> list = this.f8710e.f8593c;
                        String str = list != null ? list.get(0) : null;
                        c.a.r0.a.r0.o.f fVar = new c.a.r0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8710e.f8592b;
                        c.a.r0.a.r0.n.b(fVar, this.f8711f.f8708i);
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
            this.f8704e = str;
            this.f8705f = str2;
            this.f8706g = i2;
            this.f8707h = i3;
            this.f8708i = map;
            this.f8709j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.r0.c q = this.k.a.q(this.f8704e, this.f8705f, false);
                int i2 = this.f8706g;
                if (i2 != 7 && i2 != 12) {
                    q.f8592b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.r0.a.r0.n.d(this.k.f8599b, q.f8592b);
                }
                this.k.f8599b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8714g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8715h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8716i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.r0.o.b f8717j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r0.c f8718e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8719f;

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
                this.f8719f = pVar;
                this.f8718e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8719f.f8714g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8719f.f8715h), "newPath");
                    c.a.r0.a.r0.b v = c.a.r0.a.r0.n.v(this.f8718e, "rename:", this.f8719f.f8716i);
                    p pVar = this.f8719f;
                    if (c.a.r0.a.r0.n.a(v, pVar.f8717j, hashMap, pVar.k.f8599b)) {
                        p pVar2 = this.f8719f;
                        c.a.r0.a.r0.n.b(pVar2.f8717j, pVar2.f8716i);
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
            this.f8712e = str;
            this.f8713f = str2;
            this.f8714g = i2;
            this.f8715h = i3;
            this.f8716i = map;
            this.f8717j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8599b.runOnJSThread(new a(this, this.k.a.u(this.f8712e, this.f8713f, false)));
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
        this.f8599b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("path", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("path", J);
            this.f8600c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
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
            this.f8600c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
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
            this.f8600c = c.a.r0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("srcPath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("destPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("srcPath", J);
            String I2 = c.a.r0.a.r0.n.I("destPath", J);
            this.f8600c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str, str2);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("filePath", J);
            this.f8600c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.r0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.r0.a.r0.n.J(this.a, jsObject, (bVar = new c.a.r0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8600c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8600c.h(new a(this, I, (Boolean) c.a.r0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("encoding", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("encoding", J);
            String I2 = c.a.r0.a.r0.n.I("filePath", J);
            this.f8600c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
                this.f8600c.k(str);
                c.a.r0.a.r0.c q = this.a.q(str, str2, true);
                c.a.r0.a.r0.n.d0(this.f8599b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f8593c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8600c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
                this.f8600c.k(str);
                c.a.r0.a.r0.c s = this.a.s(str, true);
                c.a.r0.a.r0.n.d0(this.f8599b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8593c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8593c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f8600c.h(new h(this, c.a.r0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("oldPath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("newPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("oldPath", J);
            String I2 = c.a.r0.a.r0.n.I("newPath", J);
            this.f8600c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str, str2);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("dirPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("dirPath", J);
            this.f8600c.h(new n(this, I, (Boolean) c.a.r0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
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
            this.f8600c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
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
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("path", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("path", J);
            this.f8600c.h(new RunnableC0536e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.r0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
                this.f8600c.k(str);
                c.a.r0.a.r0.c y = this.a.y(str, true);
                c.a.r0.a.r0.n.d0(this.f8599b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f8594d;
            }
            return null;
        }
        return (c.a.r0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("filePath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("filePath", J);
            this.f8600c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.r0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = c.a.r0.a.r0.n.O("targetPath", jsObject);
            c.a.r0.a.r0.o.b bVar = new c.a.r0.a.r0.o.b();
            Map<String, Object> J = c.a.r0.a.r0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.r0.a.r0.n.I("zipFilePath", J);
            String I2 = c.a.r0.a.r0.n.I("targetPath", J);
            this.f8600c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
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
            this.f8600c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
                this.f8600c.k(str, str2);
                c.a.r0.a.r0.c x = this.a.x(str, str2, true);
                c.a.r0.a.r0.n.d0(this.f8599b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f8593c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
            this.f8600c.k(str);
            c.a.r0.a.r0.n.d0(this.f8599b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.r0.a.r0.n.T(this.a, this.f8599b, null, null)) {
                this.f8600c.k(str);
                c.a.r0.a.r0.c q = this.a.q(str, null, true);
                c.a.r0.a.r0.n.d0(this.f8599b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8598h == null) {
                    q.f8598h = new byte[0];
                }
                byte[] bArr = q.f8598h;
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
