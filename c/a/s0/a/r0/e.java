package c.a.s0.a.r0;

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
    public c.a.s0.a.r0.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.a.l0.a f8699b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.a.r0.i f8700c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8703g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8704h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8705i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8706j;

        /* renamed from: c.a.s0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0546a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8707e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8708f;

            public RunnableC0546a(a aVar, c.a.s0.a.r0.c cVar) {
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
                this.f8708f = aVar;
                this.f8707e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8708f.f8703g), "dirPath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8707e, "mkdir:", this.f8708f.f8704h);
                    a aVar = this.f8708f;
                    if (c.a.s0.a.r0.n.a(v, aVar.f8705i, hashMap, aVar.f8706j.f8699b)) {
                        c.a.s0.a.r0.o.b bVar = this.f8708f.f8705i;
                        bVar.errMsg = "mkdir:" + this.f8707e.f8692b;
                        a aVar2 = this.f8708f;
                        c.a.s0.a.r0.n.b(aVar2.f8705i, aVar2.f8704h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8706j = eVar;
            this.f8701e = str;
            this.f8702f = bool;
            this.f8703g = i2;
            this.f8704h = map;
            this.f8705i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8706j.f8699b.runOnJSThread(new RunnableC0546a(this, this.f8706j.a.o(this.f8701e, this.f8702f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8711g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8712h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8713i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8714j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8715e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8716f;

            public a(b bVar, c.a.s0.a.r0.c cVar) {
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
                this.f8716f = bVar;
                this.f8715e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8716f.f8711g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8716f.f8712h), "destPath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8715e, "copyFile:", this.f8716f.f8713i);
                    b bVar = this.f8716f;
                    if (c.a.s0.a.r0.n.a(v, bVar.f8714j, hashMap, bVar.k.f8699b)) {
                        b bVar2 = this.f8716f;
                        c.a.s0.a.r0.n.b(bVar2.f8714j, bVar2.f8713i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8709e = str;
            this.f8710f = str2;
            this.f8711g = i2;
            this.f8712h = i3;
            this.f8713i = map;
            this.f8714j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8699b.runOnJSThread(new a(this, this.k.a.c(this.f8709e, this.f8710f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8717e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8718f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8719g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8720h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8721i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8722j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.s0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8723e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8724f;

            public a(c cVar, c.a.s0.a.r0.c cVar2) {
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
                this.f8724f = cVar;
                this.f8723e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8724f.k), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8723e, "appendFile:", this.f8724f.f8720h);
                    c cVar = this.f8724f;
                    if (c.a.s0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f8699b)) {
                        c cVar2 = this.f8724f;
                        c.a.s0.a.r0.n.b(cVar2.l, cVar2.f8720h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.s0.a.r0.o.b bVar) {
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
            this.f8717e = str;
            this.f8718f = str2;
            this.f8719g = bArr;
            this.f8720h = map;
            this.f8721i = str3;
            this.f8722j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.r0.c b2 = this.m.a.b(this.f8717e, TextUtils.isEmpty(this.f8718f) ? this.f8719g : this.f8718f, c.a.s0.a.r0.n.I("encoding", this.f8720h), false);
                if (!TextUtils.isEmpty(this.f8721i)) {
                    b2.f8692b = this.f8721i;
                    b2.a = -2;
                    c.a.s0.a.r0.n.d(this.m.f8699b, this.f8721i);
                } else {
                    int i2 = this.f8722j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8692b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.s0.a.r0.n.d(this.m.f8699b, b2.f8692b);
                    }
                }
                this.m.f8699b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8726f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8727g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8728h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8729i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8730e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8731f;

            public a(d dVar, c.a.s0.a.r0.c cVar) {
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
                this.f8731f = dVar;
                this.f8730e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8731f.f8726f), "path");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8730e, "access:", this.f8731f.f8727g);
                    d dVar = this.f8731f;
                    if (c.a.s0.a.r0.n.a(v, dVar.f8728h, hashMap, dVar.f8729i.f8699b)) {
                        d dVar2 = this.f8731f;
                        c.a.s0.a.r0.n.b(dVar2.f8728h, dVar2.f8727g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8729i = eVar;
            this.f8725e = str;
            this.f8726f = i2;
            this.f8727g = map;
            this.f8728h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8729i.f8699b.runOnJSThread(new a(this, this.f8729i.a.a(this.f8725e, false)));
            }
        }
    }

    /* renamed from: c.a.s0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0547e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8733f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8734g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8735h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8736i;

        /* renamed from: c.a.s0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8737e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0547e f8738f;

            public a(RunnableC0547e runnableC0547e, c.a.s0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0547e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8738f = runnableC0547e;
                this.f8737e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8738f.f8733f), "path");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8737e, "stat:", this.f8738f.f8734g);
                    RunnableC0547e runnableC0547e = this.f8738f;
                    if (c.a.s0.a.r0.n.a(v, runnableC0547e.f8735h, hashMap, runnableC0547e.f8736i.f8699b)) {
                        c.a.s0.a.r0.o.h hVar = new c.a.s0.a.r0.o.h();
                        c.a.s0.a.r0.c cVar = this.f8737e;
                        hVar.stats = cVar.f8694d;
                        hVar.errMsg = cVar.f8692b;
                        c.a.s0.a.r0.n.b(hVar, this.f8738f.f8734g);
                    }
                }
            }
        }

        public RunnableC0547e(e eVar, String str, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8736i = eVar;
            this.f8732e = str;
            this.f8733f = i2;
            this.f8734g = map;
            this.f8735h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8736i.f8699b.runOnJSThread(new a(this, this.f8736i.a.y(this.f8732e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8739e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8740f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8741g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8742h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8743i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8744e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8745f;

            public a(f fVar, c.a.s0.a.r0.c cVar) {
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
                this.f8745f = fVar;
                this.f8744e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8745f.f8740f), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8744e, "getFileInfo:", this.f8745f.f8741g);
                    f fVar = this.f8745f;
                    if (c.a.s0.a.r0.n.a(v, fVar.f8742h, hashMap, fVar.f8743i.f8699b)) {
                        c.a.s0.a.r0.o.c cVar = new c.a.s0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8744e.f8692b;
                        c.a.s0.a.r0.c cVar2 = this.f8744e;
                        cVar.digest = cVar2.f8697g;
                        cVar.size = (int) cVar2.f8695e;
                        c.a.s0.a.r0.n.b(cVar, this.f8745f.f8741g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8743i = eVar;
            this.f8739e = str;
            this.f8740f = i2;
            this.f8741g = map;
            this.f8742h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8743i.f8699b.runOnJSThread(new a(this, this.f8743i.a.e(this.f8739e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8747f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8748g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8749e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8750f;

            public a(g gVar, c.a.s0.a.r0.c cVar) {
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
                this.f8750f = gVar;
                this.f8749e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8749e, "getSavedFileList:", this.f8750f.f8746e);
                    g gVar = this.f8750f;
                    if (c.a.s0.a.r0.n.a(v, gVar.f8747f, null, gVar.f8748g.f8699b)) {
                        c.a.s0.a.r0.o.d dVar = new c.a.s0.a.r0.o.d();
                        List<c.a.s0.a.r0.d> list = this.f8749e.f8696f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.s0.a.r0.d[0] : (c.a.s0.a.r0.d[]) this.f8749e.f8696f.toArray(new c.a.s0.a.r0.d[size]);
                        g gVar2 = this.f8750f;
                        dVar.errMsg = gVar2.f8747f.errMsg;
                        c.a.s0.a.r0.n.b(dVar, gVar2.f8746e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8748g = eVar;
            this.f8746e = map;
            this.f8747f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8748g.f8699b.runOnJSThread(new a(this, this.f8748g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8751e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8752f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8753g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8754h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8755i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8756e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8757f;

            public a(h hVar, c.a.s0.a.r0.c cVar) {
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
                this.f8757f = hVar;
                this.f8756e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8757f.f8752f), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8756e, "removeSavedFile:", this.f8757f.f8753g);
                    h hVar = this.f8757f;
                    if (c.a.s0.a.r0.n.a(v, hVar.f8754h, hashMap, hVar.f8755i.f8699b)) {
                        h hVar2 = this.f8757f;
                        c.a.s0.a.r0.n.b(hVar2.f8754h, hVar2.f8753g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8755i = eVar;
            this.f8751e = str;
            this.f8752f = i2;
            this.f8753g = map;
            this.f8754h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8755i.f8699b.runOnJSThread(new a(this, this.f8755i.a.t(this.f8751e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8759f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8760g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8761h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8762i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8763j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.s0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8764e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8765f;

            public a(i iVar, c.a.s0.a.r0.c cVar) {
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
                this.f8765f = iVar;
                this.f8764e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8765f.k), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8764e, "writeFile:", this.f8765f.f8761h);
                    i iVar = this.f8765f;
                    if (c.a.s0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f8699b)) {
                        c.a.s0.a.r0.o.b bVar = this.f8765f.l;
                        bVar.errMsg = "writeFile:" + this.f8764e.f8692b;
                        i iVar2 = this.f8765f;
                        c.a.s0.a.r0.n.b(iVar2.l, iVar2.f8761h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.s0.a.r0.o.b bVar) {
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
            this.f8758e = str;
            this.f8759f = str2;
            this.f8760g = bArr;
            this.f8761h = map;
            this.f8762i = str3;
            this.f8763j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.r0.c C = this.m.a.C(false, this.f8758e, TextUtils.isEmpty(this.f8759f) ? this.f8760g : this.f8759f, c.a.s0.a.r0.n.I("encoding", this.f8761h));
                if (!TextUtils.isEmpty(this.f8762i)) {
                    C.f8692b = this.f8762i;
                    C.a = -2;
                    c.a.s0.a.r0.n.d(this.m.f8699b, this.f8762i);
                } else {
                    int i2 = this.f8763j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8692b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.s0.a.r0.n.d(this.m.f8699b, C.f8692b);
                    }
                }
                this.m.f8699b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8767f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8768g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8769h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8770i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8771e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8772f;

            public a(j jVar, c.a.s0.a.r0.c cVar) {
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
                this.f8772f = jVar;
                this.f8771e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8772f.f8767f), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8771e, "unlink:", this.f8772f.f8768g);
                    j jVar = this.f8772f;
                    if (c.a.s0.a.r0.n.a(v, jVar.f8769h, hashMap, jVar.f8770i.f8699b)) {
                        c.a.s0.a.r0.o.b bVar = this.f8772f.f8769h;
                        bVar.errMsg = "unlink:" + this.f8771e.f8692b;
                        j jVar2 = this.f8772f;
                        c.a.s0.a.r0.n.b(jVar2.f8769h, jVar2.f8768g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8770i = eVar;
            this.f8766e = str;
            this.f8767f = i2;
            this.f8768g = map;
            this.f8769h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8770i.f8699b.runOnJSThread(new a(this, this.f8770i.a.z(this.f8766e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8774f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8775g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8776h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8777i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8778j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8779e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8780f;

            public a(k kVar, c.a.s0.a.r0.c cVar) {
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
                this.f8780f = kVar;
                this.f8779e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8780f.f8775g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8780f.f8776h), "targetPath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8779e, "unzip:", this.f8780f.f8777i);
                    k kVar = this.f8780f;
                    if (c.a.s0.a.r0.n.a(v, kVar.f8778j, hashMap, kVar.k.f8699b)) {
                        c.a.s0.a.r0.o.b bVar = this.f8780f.f8778j;
                        bVar.errMsg = "unzip:" + this.f8779e.f8692b;
                        k kVar2 = this.f8780f;
                        c.a.s0.a.r0.n.b(kVar2.f8778j, kVar2.f8777i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8773e = str;
            this.f8774f = str2;
            this.f8775g = i2;
            this.f8776h = i3;
            this.f8777i = map;
            this.f8778j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8699b.runOnJSThread(new a(this, this.k.a.A(this.f8773e, this.f8774f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8782f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8783g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8784h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8785i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8786j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8787e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8788f;

            public a(l lVar, c.a.s0.a.r0.c cVar) {
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
                this.f8788f = lVar;
                this.f8787e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8788f.f8783g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8788f.f8784h), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8787e, "saveFile:", this.f8788f.f8785i);
                    l lVar = this.f8788f;
                    if (c.a.s0.a.r0.n.a(v, lVar.f8786j, hashMap, lVar.k.f8699b)) {
                        c.a.s0.a.r0.o.g gVar = new c.a.s0.a.r0.o.g();
                        List<String> list = this.f8787e.f8693c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8787e.f8692b;
                        c.a.s0.a.r0.n.b(gVar, this.f8788f.f8785i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8781e = str;
            this.f8782f = str2;
            this.f8783g = i2;
            this.f8784h = i3;
            this.f8785i = map;
            this.f8786j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8699b.runOnJSThread(new a(this, this.k.a.x(this.f8781e, this.f8782f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8791g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8792h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8793i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8794e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8795f;

            public a(m mVar, c.a.s0.a.r0.c cVar) {
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
                this.f8795f = mVar;
                this.f8794e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8795f.f8790f), "dirPath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8794e, "readdir:", this.f8795f.f8791g);
                    m mVar = this.f8795f;
                    if (c.a.s0.a.r0.n.a(v, mVar.f8792h, hashMap, mVar.f8793i.f8699b)) {
                        c.a.s0.a.r0.o.e eVar = new c.a.s0.a.r0.o.e();
                        List<String> list = this.f8794e.f8693c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8794e.f8693c.toArray(new String[size]);
                        eVar.errMsg = this.f8794e.f8692b;
                        c.a.s0.a.r0.n.b(eVar, this.f8795f.f8791g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8793i = eVar;
            this.f8789e = str;
            this.f8790f = i2;
            this.f8791g = map;
            this.f8792h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8793i.f8699b.runOnJSThread(new a(this, this.f8793i.a.s(this.f8789e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8796e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8797f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8798g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8799h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8800i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8801j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8802e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8803f;

            public a(n nVar, c.a.s0.a.r0.c cVar) {
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
                this.f8803f = nVar;
                this.f8802e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8803f.f8798g), "dirPath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8802e, "rmdir:", this.f8803f.f8799h);
                    n nVar = this.f8803f;
                    if (c.a.s0.a.r0.n.a(v, nVar.f8800i, hashMap, nVar.f8801j.f8699b)) {
                        n nVar2 = this.f8803f;
                        c.a.s0.a.r0.n.b(nVar2.f8800i, nVar2.f8799h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8801j = eVar;
            this.f8796e = str;
            this.f8797f = bool;
            this.f8798g = i2;
            this.f8799h = map;
            this.f8800i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8801j.f8699b.runOnJSThread(new a(this, this.f8801j.a.v(this.f8796e, this.f8797f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8805f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8806g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8807h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8808i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8809j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8810e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8811f;

            public a(o oVar, c.a.s0.a.r0.c cVar) {
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
                this.f8811f = oVar;
                this.f8810e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8811f.f8807h), "filePath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8810e, "readFile:", this.f8811f.f8808i);
                    o oVar = this.f8811f;
                    if (c.a.s0.a.r0.n.a(v, oVar.f8809j, hashMap, oVar.k.f8699b)) {
                        if (TextUtils.isEmpty(this.f8811f.f8805f)) {
                            c.a.s0.a.r0.o.a aVar = new c.a.s0.a.r0.o.a();
                            c.a.s0.a.r0.c cVar = this.f8810e;
                            if (cVar.f8698h == null) {
                                cVar.f8698h = new byte[0];
                            }
                            byte[] bArr = this.f8810e.f8698h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8810e.f8692b;
                            c.a.s0.a.r0.n.b(aVar, this.f8811f.f8808i);
                            return;
                        }
                        List<String> list = this.f8810e.f8693c;
                        String str = list != null ? list.get(0) : null;
                        c.a.s0.a.r0.o.f fVar = new c.a.s0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8810e.f8692b;
                        c.a.s0.a.r0.n.b(fVar, this.f8811f.f8808i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8804e = str;
            this.f8805f = str2;
            this.f8806g = i2;
            this.f8807h = i3;
            this.f8808i = map;
            this.f8809j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.r0.c q = this.k.a.q(this.f8804e, this.f8805f, false);
                int i2 = this.f8806g;
                if (i2 != 7 && i2 != 12) {
                    q.f8692b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.s0.a.r0.n.d(this.k.f8699b, q.f8692b);
                }
                this.k.f8699b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8814g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8815h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8816i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.r0.o.b f8817j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.r0.c f8818e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8819f;

            public a(p pVar, c.a.s0.a.r0.c cVar) {
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
                this.f8819f = pVar;
                this.f8818e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8819f.f8814g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8819f.f8815h), "newPath");
                    c.a.s0.a.r0.b v = c.a.s0.a.r0.n.v(this.f8818e, "rename:", this.f8819f.f8816i);
                    p pVar = this.f8819f;
                    if (c.a.s0.a.r0.n.a(v, pVar.f8817j, hashMap, pVar.k.f8699b)) {
                        p pVar2 = this.f8819f;
                        c.a.s0.a.r0.n.b(pVar2.f8817j, pVar2.f8816i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.s0.a.r0.o.b bVar) {
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
            this.f8812e = str;
            this.f8813f = str2;
            this.f8814g = i2;
            this.f8815h = i3;
            this.f8816i = map;
            this.f8817j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8699b.runOnJSThread(new a(this, this.k.a.u(this.f8812e, this.f8813f, false)));
            }
        }
    }

    public e(c.a.s0.a.l0.a aVar) {
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
        this.f8699b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("path", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("path", J);
            this.f8700c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("encoding", jsObject);
            int O2 = c.a.s0.a.r0.n.O("filePath", jsObject);
            int O3 = c.a.s0.a.r0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : c.a.s0.a.r0.n.w(O3);
            byte[] r = c.a.s0.a.r0.n.r(jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("data", J);
            String I2 = c.a.s0.a.r0.n.I("filePath", J);
            this.f8700c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.s0.a.o2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new c.a.s0.a.r0.l();
            }
            this.a = new c.a.s0.a.r0.f(AppRuntime.getAppContext(), c.a.s0.a.g1.f.U().z(), lVar);
            this.f8700c = c.a.s0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("srcPath", jsObject);
            int O2 = c.a.s0.a.r0.n.O("destPath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("srcPath", J);
            String I2 = c.a.s0.a.r0.n.I("destPath", J);
            this.f8700c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str, str2);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("filePath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("filePath", J);
            this.f8700c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.s0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.s0.a.r0.n.J(this.a, jsObject, (bVar = new c.a.s0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8700c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("dirPath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("dirPath", J);
            this.f8700c.h(new a(this, I, (Boolean) c.a.s0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("filePath", jsObject);
            int O2 = c.a.s0.a.r0.n.O("encoding", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("encoding", J);
            String I2 = c.a.s0.a.r0.n.I("filePath", J);
            this.f8700c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
                this.f8700c.k(str);
                c.a.s0.a.r0.c q = this.a.q(str, str2, true);
                c.a.s0.a.r0.n.d0(this.f8699b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f8693c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("dirPath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("dirPath", J);
            this.f8700c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
                this.f8700c.k(str);
                c.a.s0.a.r0.c s = this.a.s(str, true);
                c.a.s0.a.r0.n.d0(this.f8699b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8693c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8693c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("filePath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f8700c.h(new h(this, c.a.s0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("oldPath", jsObject);
            int O2 = c.a.s0.a.r0.n.O("newPath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("oldPath", J);
            String I2 = c.a.s0.a.r0.n.I("newPath", J);
            this.f8700c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str, str2);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("dirPath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("dirPath", J);
            this.f8700c.h(new n(this, I, (Boolean) c.a.s0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("tempFilePath", jsObject);
            int O2 = c.a.s0.a.r0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("tempFilePath", J);
            String I2 = c.a.s0.a.r0.n.I("filePath", J);
            this.f8700c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.s0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("path", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("path", J);
            this.f8700c.h(new RunnableC0547e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.s0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
                this.f8700c.k(str);
                c.a.s0.a.r0.c y = this.a.y(str, true);
                c.a.s0.a.r0.n.d0(this.f8699b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f8694d;
            }
            return null;
        }
        return (c.a.s0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("filePath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("filePath", J);
            this.f8700c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = c.a.s0.a.r0.n.O("targetPath", jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("zipFilePath", J);
            String I2 = c.a.s0.a.r0.n.I("targetPath", J);
            this.f8700c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.s0.a.r0.n.O("filePath", jsObject);
            String w = c.a.s0.a.r0.n.w(c.a.s0.a.r0.n.O("data", jsObject));
            int O2 = c.a.s0.a.r0.n.O("encoding", jsObject);
            byte[] r = c.a.s0.a.r0.n.r(jsObject);
            c.a.s0.a.r0.o.b bVar = new c.a.s0.a.r0.o.b();
            Map<String, Object> J = c.a.s0.a.r0.n.J(this.a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.s0.a.r0.n.I("data", J);
            String I2 = c.a.s0.a.r0.n.I("filePath", J);
            this.f8700c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
                this.f8700c.k(str, str2);
                c.a.s0.a.r0.c x = this.a.x(str, str2, true);
                c.a.s0.a.r0.n.d0(this.f8699b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f8693c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
            this.f8700c.k(str);
            c.a.s0.a.r0.n.d0(this.f8699b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.s0.a.r0.n.T(this.a, this.f8699b, null, null)) {
                this.f8700c.k(str);
                c.a.s0.a.r0.c q = this.a.q(str, null, true);
                c.a.s0.a.r0.n.d0(this.f8699b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8698h == null) {
                    q.f8698h = new byte[0];
                }
                byte[] bArr = q.f8698h;
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
