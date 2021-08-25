package c.a.o0.a.r0;

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
    public c.a.o0.a.r0.f f8145a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.a.l0.a f8146b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.a.r0.i f8147c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8149f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8150g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8151h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8152i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8153j;

        /* renamed from: c.a.o0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0354a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8154e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f8155f;

            public RunnableC0354a(a aVar, c.a.o0.a.r0.c cVar) {
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
                this.f8155f = aVar;
                this.f8154e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8155f.f8150g), "dirPath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8154e, "mkdir:", this.f8155f.f8151h);
                    a aVar = this.f8155f;
                    if (c.a.o0.a.r0.n.a(t, aVar.f8152i, hashMap, aVar.f8153j.f8146b)) {
                        c.a.o0.a.r0.o.b bVar = this.f8155f.f8152i;
                        bVar.errMsg = "mkdir:" + this.f8154e.f8138b;
                        a aVar2 = this.f8155f;
                        c.a.o0.a.r0.n.b(aVar2.f8152i, aVar2.f8151h);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8153j = eVar;
            this.f8148e = str;
            this.f8149f = bool;
            this.f8150g = i2;
            this.f8151h = map;
            this.f8152i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8153j.f8146b.runOnJSThread(new RunnableC0354a(this, this.f8153j.f8145a.o(this.f8148e, this.f8149f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8158g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8159h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8160i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8161j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8162e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f8163f;

            public a(b bVar, c.a.o0.a.r0.c cVar) {
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
                this.f8163f = bVar;
                this.f8162e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8163f.f8158g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f8163f.f8159h), "destPath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8162e, "copyFile:", this.f8163f.f8160i);
                    b bVar = this.f8163f;
                    if (c.a.o0.a.r0.n.a(t, bVar.f8161j, hashMap, bVar.k.f8146b)) {
                        b bVar2 = this.f8163f;
                        c.a.o0.a.r0.n.b(bVar2.f8161j, bVar2.f8160i);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i2, int i3, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8156e = str;
            this.f8157f = str2;
            this.f8158g = i2;
            this.f8159h = i3;
            this.f8160i = map;
            this.f8161j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8146b.runOnJSThread(new a(this, this.k.f8145a.c(this.f8156e, this.f8157f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8167h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8168i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8169j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.o0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8170e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8171f;

            public a(c cVar, c.a.o0.a.r0.c cVar2) {
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
                this.f8171f = cVar;
                this.f8170e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8171f.k), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8170e, "appendFile:", this.f8171f.f8167h);
                    c cVar = this.f8171f;
                    if (c.a.o0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f8146b)) {
                        c cVar2 = this.f8171f;
                        c.a.o0.a.r0.n.b(cVar2.l, cVar2.f8167h);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.o0.a.r0.o.b bVar) {
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
            this.f8164e = str;
            this.f8165f = str2;
            this.f8166g = bArr;
            this.f8167h = map;
            this.f8168i = str3;
            this.f8169j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.r0.c b2 = this.m.f8145a.b(this.f8164e, TextUtils.isEmpty(this.f8165f) ? this.f8166g : this.f8165f, c.a.o0.a.r0.n.F("encoding", this.f8167h), false);
                if (!TextUtils.isEmpty(this.f8168i)) {
                    b2.f8138b = this.f8168i;
                    b2.f8137a = -2;
                    c.a.o0.a.r0.n.d(this.m.f8146b, this.f8168i);
                } else {
                    int i2 = this.f8169j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f8138b = "fail encoding must be a string";
                        b2.f8137a = -2;
                        c.a.o0.a.r0.n.d(this.m.f8146b, b2.f8138b);
                    }
                }
                this.m.f8146b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8173f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8174g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8175h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8176i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8177e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f8178f;

            public a(d dVar, c.a.o0.a.r0.c cVar) {
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
                this.f8178f = dVar;
                this.f8177e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8178f.f8173f), "path");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8177e, "access:", this.f8178f.f8174g);
                    d dVar = this.f8178f;
                    if (c.a.o0.a.r0.n.a(t, dVar.f8175h, hashMap, dVar.f8176i.f8146b)) {
                        d dVar2 = this.f8178f;
                        c.a.o0.a.r0.n.b(dVar2.f8175h, dVar2.f8174g);
                    }
                }
            }
        }

        public d(e eVar, String str, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8176i = eVar;
            this.f8172e = str;
            this.f8173f = i2;
            this.f8174g = map;
            this.f8175h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8176i.f8146b.runOnJSThread(new a(this, this.f8176i.f8145a.a(this.f8172e, false)));
            }
        }
    }

    /* renamed from: c.a.o0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0355e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8179e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8180f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8181g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8182h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8183i;

        /* renamed from: c.a.o0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8184e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0355e f8185f;

            public a(RunnableC0355e runnableC0355e, c.a.o0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0355e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8185f = runnableC0355e;
                this.f8184e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8185f.f8180f), "path");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8184e, "stat:", this.f8185f.f8181g);
                    RunnableC0355e runnableC0355e = this.f8185f;
                    if (c.a.o0.a.r0.n.a(t, runnableC0355e.f8182h, hashMap, runnableC0355e.f8183i.f8146b)) {
                        c.a.o0.a.r0.o.h hVar = new c.a.o0.a.r0.o.h();
                        c.a.o0.a.r0.c cVar = this.f8184e;
                        hVar.stats = cVar.f8140d;
                        hVar.errMsg = cVar.f8138b;
                        c.a.o0.a.r0.n.b(hVar, this.f8185f.f8181g);
                    }
                }
            }
        }

        public RunnableC0355e(e eVar, String str, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8183i = eVar;
            this.f8179e = str;
            this.f8180f = i2;
            this.f8181g = map;
            this.f8182h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8183i.f8146b.runOnJSThread(new a(this, this.f8183i.f8145a.y(this.f8179e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8187f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8188g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8189h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8190i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8191e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f8192f;

            public a(f fVar, c.a.o0.a.r0.c cVar) {
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
                this.f8192f = fVar;
                this.f8191e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8192f.f8187f), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8191e, "getFileInfo:", this.f8192f.f8188g);
                    f fVar = this.f8192f;
                    if (c.a.o0.a.r0.n.a(t, fVar.f8189h, hashMap, fVar.f8190i.f8146b)) {
                        c.a.o0.a.r0.o.c cVar = new c.a.o0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f8191e.f8138b;
                        c.a.o0.a.r0.c cVar2 = this.f8191e;
                        cVar.digest = cVar2.f8143g;
                        cVar.size = (int) cVar2.f8141e;
                        c.a.o0.a.r0.n.b(cVar, this.f8192f.f8188g);
                    }
                }
            }
        }

        public f(e eVar, String str, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8190i = eVar;
            this.f8186e = str;
            this.f8187f = i2;
            this.f8188g = map;
            this.f8189h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8190i.f8146b.runOnJSThread(new a(this, this.f8190i.f8145a.e(this.f8186e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f8193e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8194f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f8195g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8196e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f8197f;

            public a(g gVar, c.a.o0.a.r0.c cVar) {
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
                this.f8197f = gVar;
                this.f8196e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8196e, "getSavedFileList:", this.f8197f.f8193e);
                    g gVar = this.f8197f;
                    if (c.a.o0.a.r0.n.a(t, gVar.f8194f, null, gVar.f8195g.f8146b)) {
                        c.a.o0.a.r0.o.d dVar = new c.a.o0.a.r0.o.d();
                        List<c.a.o0.a.r0.d> list = this.f8196e.f8142f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.o0.a.r0.d[0] : (c.a.o0.a.r0.d[]) this.f8196e.f8142f.toArray(new c.a.o0.a.r0.d[size]);
                        g gVar2 = this.f8197f;
                        dVar.errMsg = gVar2.f8194f.errMsg;
                        c.a.o0.a.r0.n.b(dVar, gVar2.f8193e);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8195g = eVar;
            this.f8193e = map;
            this.f8194f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8195g.f8146b.runOnJSThread(new a(this, this.f8195g.f8145a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8198e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8199f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8200g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8201h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8202i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8203e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f8204f;

            public a(h hVar, c.a.o0.a.r0.c cVar) {
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
                this.f8204f = hVar;
                this.f8203e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8204f.f8199f), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8203e, "removeSavedFile:", this.f8204f.f8200g);
                    h hVar = this.f8204f;
                    if (c.a.o0.a.r0.n.a(t, hVar.f8201h, hashMap, hVar.f8202i.f8146b)) {
                        h hVar2 = this.f8204f;
                        c.a.o0.a.r0.n.b(hVar2.f8201h, hVar2.f8200g);
                    }
                }
            }
        }

        public h(e eVar, String str, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8202i = eVar;
            this.f8198e = str;
            this.f8199f = i2;
            this.f8200g = map;
            this.f8201h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8202i.f8146b.runOnJSThread(new a(this, this.f8202i.f8145a.t(this.f8198e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8206f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f8207g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8208h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f8209i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f8210j;
        public final /* synthetic */ int k;
        public final /* synthetic */ c.a.o0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8211e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f8212f;

            public a(i iVar, c.a.o0.a.r0.c cVar) {
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
                this.f8212f = iVar;
                this.f8211e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8212f.k), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8211e, "writeFile:", this.f8212f.f8208h);
                    i iVar = this.f8212f;
                    if (c.a.o0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f8146b)) {
                        c.a.o0.a.r0.o.b bVar = this.f8212f.l;
                        bVar.errMsg = "writeFile:" + this.f8211e.f8138b;
                        i iVar2 = this.f8212f;
                        c.a.o0.a.r0.n.b(iVar2.l, iVar2.f8208h);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i2, int i3, c.a.o0.a.r0.o.b bVar) {
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
            this.f8205e = str;
            this.f8206f = str2;
            this.f8207g = bArr;
            this.f8208h = map;
            this.f8209i = str3;
            this.f8210j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.r0.c C = this.m.f8145a.C(false, this.f8205e, TextUtils.isEmpty(this.f8206f) ? this.f8207g : this.f8206f, c.a.o0.a.r0.n.F("encoding", this.f8208h));
                if (!TextUtils.isEmpty(this.f8209i)) {
                    C.f8138b = this.f8209i;
                    C.f8137a = -2;
                    c.a.o0.a.r0.n.d(this.m.f8146b, this.f8209i);
                } else {
                    int i2 = this.f8210j;
                    if (i2 != 7 && i2 != 12) {
                        C.f8138b = "fail encoding must be a string";
                        C.f8137a = -2;
                        c.a.o0.a.r0.n.d(this.m.f8146b, C.f8138b);
                    }
                }
                this.m.f8146b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8213e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8214f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8215g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8216h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8217i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8218e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f8219f;

            public a(j jVar, c.a.o0.a.r0.c cVar) {
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
                this.f8219f = jVar;
                this.f8218e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8219f.f8214f), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8218e, "unlink:", this.f8219f.f8215g);
                    j jVar = this.f8219f;
                    if (c.a.o0.a.r0.n.a(t, jVar.f8216h, hashMap, jVar.f8217i.f8146b)) {
                        c.a.o0.a.r0.o.b bVar = this.f8219f.f8216h;
                        bVar.errMsg = "unlink:" + this.f8218e.f8138b;
                        j jVar2 = this.f8219f;
                        c.a.o0.a.r0.n.b(jVar2.f8216h, jVar2.f8215g);
                    }
                }
            }
        }

        public j(e eVar, String str, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8217i = eVar;
            this.f8213e = str;
            this.f8214f = i2;
            this.f8215g = map;
            this.f8216h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8217i.f8146b.runOnJSThread(new a(this, this.f8217i.f8145a.z(this.f8213e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8221f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8222g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8223h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8224i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8225j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8226e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f8227f;

            public a(k kVar, c.a.o0.a.r0.c cVar) {
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
                this.f8227f = kVar;
                this.f8226e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8227f.f8222g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f8227f.f8223h), "targetPath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8226e, "unzip:", this.f8227f.f8224i);
                    k kVar = this.f8227f;
                    if (c.a.o0.a.r0.n.a(t, kVar.f8225j, hashMap, kVar.k.f8146b)) {
                        c.a.o0.a.r0.o.b bVar = this.f8227f.f8225j;
                        bVar.errMsg = "unzip:" + this.f8226e.f8138b;
                        k kVar2 = this.f8227f;
                        c.a.o0.a.r0.n.b(kVar2.f8225j, kVar2.f8224i);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i2, int i3, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8220e = str;
            this.f8221f = str2;
            this.f8222g = i2;
            this.f8223h = i3;
            this.f8224i = map;
            this.f8225j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8146b.runOnJSThread(new a(this, this.k.f8145a.A(this.f8220e, this.f8221f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8230g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8231h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8232i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8233j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8234e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f8235f;

            public a(l lVar, c.a.o0.a.r0.c cVar) {
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
                this.f8235f = lVar;
                this.f8234e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8235f.f8230g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f8235f.f8231h), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8234e, "saveFile:", this.f8235f.f8232i);
                    l lVar = this.f8235f;
                    if (c.a.o0.a.r0.n.a(t, lVar.f8233j, hashMap, lVar.k.f8146b)) {
                        c.a.o0.a.r0.o.g gVar = new c.a.o0.a.r0.o.g();
                        List<String> list = this.f8234e.f8139c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f8234e.f8138b;
                        c.a.o0.a.r0.n.b(gVar, this.f8235f.f8232i);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i2, int i3, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8228e = str;
            this.f8229f = str2;
            this.f8230g = i2;
            this.f8231h = i3;
            this.f8232i = map;
            this.f8233j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8146b.runOnJSThread(new a(this, this.k.f8145a.x(this.f8228e, this.f8229f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8237f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f8238g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8239h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f8240i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8241e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f8242f;

            public a(m mVar, c.a.o0.a.r0.c cVar) {
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
                this.f8242f = mVar;
                this.f8241e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8242f.f8237f), "dirPath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8241e, "readdir:", this.f8242f.f8238g);
                    m mVar = this.f8242f;
                    if (c.a.o0.a.r0.n.a(t, mVar.f8239h, hashMap, mVar.f8240i.f8146b)) {
                        c.a.o0.a.r0.o.e eVar = new c.a.o0.a.r0.o.e();
                        List<String> list = this.f8241e.f8139c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f8241e.f8139c.toArray(new String[size]);
                        eVar.errMsg = this.f8241e.f8138b;
                        c.a.o0.a.r0.n.b(eVar, this.f8242f.f8238g);
                    }
                }
            }
        }

        public m(e eVar, String str, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8240i = eVar;
            this.f8236e = str;
            this.f8237f = i2;
            this.f8238g = map;
            this.f8239h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8240i.f8146b.runOnJSThread(new a(this, this.f8240i.f8145a.s(this.f8236e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f8244f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8245g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f8246h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8247i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f8248j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8249e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f8250f;

            public a(n nVar, c.a.o0.a.r0.c cVar) {
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
                this.f8250f = nVar;
                this.f8249e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8250f.f8245g), "dirPath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8249e, "rmdir:", this.f8250f.f8246h);
                    n nVar = this.f8250f;
                    if (c.a.o0.a.r0.n.a(t, nVar.f8247i, hashMap, nVar.f8248j.f8146b)) {
                        n nVar2 = this.f8250f;
                        c.a.o0.a.r0.n.b(nVar2.f8247i, nVar2.f8246h);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i2, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8248j = eVar;
            this.f8243e = str;
            this.f8244f = bool;
            this.f8245g = i2;
            this.f8246h = map;
            this.f8247i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8248j.f8146b.runOnJSThread(new a(this, this.f8248j.f8145a.v(this.f8243e, this.f8244f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8252f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8253g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8254h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8255i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8256j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8257e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f8258f;

            public a(o oVar, c.a.o0.a.r0.c cVar) {
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
                this.f8258f = oVar;
                this.f8257e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8258f.f8254h), "filePath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8257e, "readFile:", this.f8258f.f8255i);
                    o oVar = this.f8258f;
                    if (c.a.o0.a.r0.n.a(t, oVar.f8256j, hashMap, oVar.k.f8146b)) {
                        if (TextUtils.isEmpty(this.f8258f.f8252f)) {
                            c.a.o0.a.r0.o.a aVar = new c.a.o0.a.r0.o.a();
                            c.a.o0.a.r0.c cVar = this.f8257e;
                            if (cVar.f8144h == null) {
                                cVar.f8144h = new byte[0];
                            }
                            byte[] bArr = this.f8257e.f8144h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f8257e.f8138b;
                            c.a.o0.a.r0.n.b(aVar, this.f8258f.f8255i);
                            return;
                        }
                        List<String> list = this.f8257e.f8139c;
                        String str = list != null ? list.get(0) : null;
                        c.a.o0.a.r0.o.f fVar = new c.a.o0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f8257e.f8138b;
                        c.a.o0.a.r0.n.b(fVar, this.f8258f.f8255i);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i2, int i3, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8251e = str;
            this.f8252f = str2;
            this.f8253g = i2;
            this.f8254h = i3;
            this.f8255i = map;
            this.f8256j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.r0.c q = this.k.f8145a.q(this.f8251e, this.f8252f, false);
                int i2 = this.f8253g;
                if (i2 != 7 && i2 != 12) {
                    q.f8138b = "fail encoding must be a string";
                    q.f8137a = -2;
                    c.a.o0.a.r0.n.d(this.k.f8146b, q.f8138b);
                }
                this.k.f8146b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f8261g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8262h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f8263i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.r0.o.b f8264j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.r0.c f8265e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f8266f;

            public a(p pVar, c.a.o0.a.r0.c cVar) {
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
                this.f8266f = pVar;
                this.f8265e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f8266f.f8261g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f8266f.f8262h), "newPath");
                    c.a.o0.a.r0.b t = c.a.o0.a.r0.n.t(this.f8265e, "rename:", this.f8266f.f8263i);
                    p pVar = this.f8266f;
                    if (c.a.o0.a.r0.n.a(t, pVar.f8264j, hashMap, pVar.k.f8146b)) {
                        p pVar2 = this.f8266f;
                        c.a.o0.a.r0.n.b(pVar2.f8264j, pVar2.f8263i);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i2, int i3, Map map, c.a.o0.a.r0.o.b bVar) {
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
            this.f8259e = str;
            this.f8260f = str2;
            this.f8261g = i2;
            this.f8262h = i3;
            this.f8263i = map;
            this.f8264j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f8146b.runOnJSThread(new a(this, this.k.f8145a.u(this.f8259e, this.f8260f, false)));
            }
        }
    }

    public e(c.a.o0.a.l0.a aVar) {
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
        this.f8146b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("path", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("path", G);
            this.f8147c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("encoding", jsObject);
            int L2 = c.a.o0.a.r0.n.L("filePath", jsObject);
            int L3 = c.a.o0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : c.a.o0.a.r0.n.u(L3);
            byte[] p2 = c.a.o0.a.r0.n.p(jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("data", G);
            String F2 = c.a.o0.a.r0.n.F("filePath", G);
            this.f8147c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.o0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
            if (Q != null) {
                lVar = Q.W();
            } else {
                lVar = new c.a.o0.a.r0.l();
            }
            this.f8145a = new c.a.o0.a.r0.f(AppRuntime.getAppContext(), c.a.o0.a.g1.f.V().A(), lVar);
            this.f8147c = c.a.o0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("srcPath", jsObject);
            int L2 = c.a.o0.a.r0.n.L("destPath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("srcPath", G);
            String F2 = c.a.o0.a.r0.n.F("destPath", G);
            this.f8147c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str, str2);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("filePath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("filePath", G);
            this.f8147c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.o0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, (bVar = new c.a.o0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f8147c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("dirPath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("dirPath", G);
            this.f8147c.h(new a(this, F, (Boolean) c.a.o0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("filePath", jsObject);
            int L2 = c.a.o0.a.r0.n.L("encoding", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("encoding", G);
            String F2 = c.a.o0.a.r0.n.F("filePath", G);
            this.f8147c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
                this.f8147c.k(str);
                c.a.o0.a.r0.c q = this.f8145a.q(str, str2, true);
                c.a.o0.a.r0.n.Z(this.f8146b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f8137a != 0 || (list = q.f8139c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("dirPath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("dirPath", G);
            this.f8147c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
                this.f8147c.k(str);
                c.a.o0.a.r0.c s = this.f8145a.s(str, true);
                c.a.o0.a.r0.n.Z(this.f8146b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f8137a != 0) {
                    return new String[0];
                }
                List<String> list = s.f8139c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f8139c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("filePath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f8147c.h(new h(this, c.a.o0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("oldPath", jsObject);
            int L2 = c.a.o0.a.r0.n.L("newPath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("oldPath", G);
            String F2 = c.a.o0.a.r0.n.F("newPath", G);
            this.f8147c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str, str2);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("dirPath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("dirPath", G);
            this.f8147c.h(new n(this, F, (Boolean) c.a.o0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = c.a.o0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("tempFilePath", G);
            String F2 = c.a.o0.a.r0.n.F("filePath", G);
            this.f8147c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.o0.a.r0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("path", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("path", G);
            this.f8147c.h(new RunnableC0355e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public c.a.o0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
                this.f8147c.k(str);
                c.a.o0.a.r0.c y = this.f8145a.y(str, true);
                c.a.o0.a.r0.n.Z(this.f8146b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f8137a != 0) {
                    return null;
                }
                return y.f8140d;
            }
            return null;
        }
        return (c.a.o0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("filePath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("filePath", G);
            this.f8147c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = c.a.o0.a.r0.n.L("targetPath", jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("zipFilePath", G);
            String F2 = c.a.o0.a.r0.n.F("targetPath", G);
            this.f8147c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = c.a.o0.a.r0.n.L("filePath", jsObject);
            String u = c.a.o0.a.r0.n.u(c.a.o0.a.r0.n.L("data", jsObject));
            int L2 = c.a.o0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = c.a.o0.a.r0.n.p(jsObject);
            c.a.o0.a.r0.o.b bVar = new c.a.o0.a.r0.o.b();
            Map<String, Object> G = c.a.o0.a.r0.n.G(this.f8145a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = c.a.o0.a.r0.n.F("data", G);
            String F2 = c.a.o0.a.r0.n.F("filePath", G);
            this.f8147c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
                this.f8147c.k(str, str2);
                c.a.o0.a.r0.c x = this.f8145a.x(str, str2, true);
                c.a.o0.a.r0.n.Z(this.f8146b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f8137a != 0 || (list = x.f8139c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
            this.f8147c.k(str);
            c.a.o0.a.r0.n.Z(this.f8146b, this.f8145a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.o0.a.r0.n.P(this.f8145a, this.f8146b, null, null)) {
                this.f8147c.k(str);
                c.a.o0.a.r0.c q = this.f8145a.q(str, null, true);
                c.a.o0.a.r0.n.Z(this.f8146b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f8144h == null) {
                    q.f8144h = new byte[0];
                }
                byte[] bArr = q.f8144h;
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
