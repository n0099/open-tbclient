package c.a.n0.a.h0;

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
    public c.a.n0.a.h0.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.b0.a f4593b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.h0.i f4594c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Boolean f4595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4596c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f4597d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f4599f;

        /* renamed from: c.a.n0.a.h0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0291a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f4600b;

            public RunnableC0291a(a aVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4600b = aVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4600b.f4596c), "dirPath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "mkdir:", this.f4600b.f4597d);
                    a aVar = this.f4600b;
                    if (c.a.n0.a.h0.n.a(v, aVar.f4598e, hashMap, aVar.f4599f.f4593b)) {
                        c.a.n0.a.h0.o.b bVar = this.f4600b.f4598e;
                        bVar.errMsg = "mkdir:" + this.a.f4586b;
                        a aVar2 = this.f4600b;
                        c.a.n0.a.h0.n.b(aVar2.f4598e, aVar2.f4597d);
                    }
                }
            }
        }

        public a(e eVar, String str, Boolean bool, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, bool, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4599f = eVar;
            this.a = str;
            this.f4595b = bool;
            this.f4596c = i;
            this.f4597d = map;
            this.f4598e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4599f.f4593b.runOnJSThread(new RunnableC0291a(this, this.f4599f.a.o(this.a, this.f4595b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4601b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4602c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4603d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f4604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4605f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4606g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f4607b;

            public a(b bVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4607b = bVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4607b.f4602c), "srcPath");
                    hashMap.put(Integer.valueOf(this.f4607b.f4603d), "destPath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "copyFile:", this.f4607b.f4604e);
                    b bVar = this.f4607b;
                    if (c.a.n0.a.h0.n.a(v, bVar.f4605f, hashMap, bVar.f4606g.f4593b)) {
                        b bVar2 = this.f4607b;
                        c.a.n0.a.h0.n.b(bVar2.f4605f, bVar2.f4604e);
                    }
                }
            }
        }

        public b(e eVar, String str, String str2, int i, int i2, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4606g = eVar;
            this.a = str;
            this.f4601b = str2;
            this.f4602c = i;
            this.f4603d = i2;
            this.f4604e = map;
            this.f4605f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4606g.f4593b.runOnJSThread(new a(this, this.f4606g.a.c(this.a, this.f4601b, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f4609c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f4610d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4612f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4613g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4614h;
        public final /* synthetic */ e i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f4615b;

            public a(c cVar, c.a.n0.a.h0.c cVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4615b = cVar;
                this.a = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4615b.f4613g), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "appendFile:", this.f4615b.f4610d);
                    c cVar = this.f4615b;
                    if (c.a.n0.a.h0.n.a(v, cVar.f4614h, hashMap, cVar.i.f4593b)) {
                        c cVar2 = this.f4615b;
                        c.a.n0.a.h0.n.b(cVar2.f4614h, cVar2.f4610d);
                    }
                }
            }
        }

        public c(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = eVar;
            this.a = str;
            this.f4608b = str2;
            this.f4609c = bArr;
            this.f4610d = map;
            this.f4611e = str3;
            this.f4612f = i;
            this.f4613g = i2;
            this.f4614h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.c b2 = this.i.a.b(this.a, TextUtils.isEmpty(this.f4608b) ? this.f4609c : this.f4608b, c.a.n0.a.h0.n.I("encoding", this.f4610d), false);
                if (!TextUtils.isEmpty(this.f4611e)) {
                    b2.f4586b = this.f4611e;
                    b2.a = -2;
                    c.a.n0.a.h0.n.d(this.i.f4593b, this.f4611e);
                } else {
                    int i = this.f4612f;
                    if (i != 7 && i != 12) {
                        b2.f4586b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.n0.a.h0.n.d(this.i.f4593b, b2.f4586b);
                    }
                }
                this.i.f4593b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4616b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f4617c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4618d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4619e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f4620b;

            public a(d dVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4620b = dVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4620b.f4616b), "path");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "access:", this.f4620b.f4617c);
                    d dVar = this.f4620b;
                    if (c.a.n0.a.h0.n.a(v, dVar.f4618d, hashMap, dVar.f4619e.f4593b)) {
                        d dVar2 = this.f4620b;
                        c.a.n0.a.h0.n.b(dVar2.f4618d, dVar2.f4617c);
                    }
                }
            }
        }

        public d(e eVar, String str, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4619e = eVar;
            this.a = str;
            this.f4616b = i;
            this.f4617c = map;
            this.f4618d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4619e.f4593b.runOnJSThread(new a(this, this.f4619e.a.a(this.a, false)));
            }
        }
    }

    /* renamed from: c.a.n0.a.h0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0292e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4621b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f4622c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4623d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4624e;

        /* renamed from: c.a.n0.a.h0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RunnableC0292e f4625b;

            public a(RunnableC0292e runnableC0292e, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0292e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4625b = runnableC0292e;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4625b.f4621b), "path");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "stat:", this.f4625b.f4622c);
                    RunnableC0292e runnableC0292e = this.f4625b;
                    if (c.a.n0.a.h0.n.a(v, runnableC0292e.f4623d, hashMap, runnableC0292e.f4624e.f4593b)) {
                        c.a.n0.a.h0.o.h hVar = new c.a.n0.a.h0.o.h();
                        c.a.n0.a.h0.c cVar = this.a;
                        hVar.stats = cVar.f4588d;
                        hVar.errMsg = cVar.f4586b;
                        c.a.n0.a.h0.n.b(hVar, this.f4625b.f4622c);
                    }
                }
            }
        }

        public RunnableC0292e(e eVar, String str, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4624e = eVar;
            this.a = str;
            this.f4621b = i;
            this.f4622c = map;
            this.f4623d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4624e.f4593b.runOnJSThread(new a(this, this.f4624e.a.y(this.a, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4626b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f4627c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4628d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4629e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f4630b;

            public a(f fVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4630b = fVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4630b.f4626b), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "getFileInfo:", this.f4630b.f4627c);
                    f fVar = this.f4630b;
                    if (c.a.n0.a.h0.n.a(v, fVar.f4628d, hashMap, fVar.f4629e.f4593b)) {
                        c.a.n0.a.h0.o.c cVar = new c.a.n0.a.h0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.a.f4586b;
                        c.a.n0.a.h0.c cVar2 = this.a;
                        cVar.digest = cVar2.f4591g;
                        cVar.size = (int) cVar2.f4589e;
                        c.a.n0.a.h0.n.b(cVar, this.f4630b.f4627c);
                    }
                }
            }
        }

        public f(e eVar, String str, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4629e = eVar;
            this.a = str;
            this.f4626b = i;
            this.f4627c = map;
            this.f4628d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4629e.f4593b.runOnJSThread(new a(this, this.f4629e.a.e(this.a)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4631b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f4632c;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f4633b;

            public a(g gVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4633b = gVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "getSavedFileList:", this.f4633b.a);
                    g gVar = this.f4633b;
                    if (c.a.n0.a.h0.n.a(v, gVar.f4631b, null, gVar.f4632c.f4593b)) {
                        c.a.n0.a.h0.o.d dVar = new c.a.n0.a.h0.o.d();
                        List<c.a.n0.a.h0.d> list = this.a.f4590f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.n0.a.h0.d[0] : (c.a.n0.a.h0.d[]) this.a.f4590f.toArray(new c.a.n0.a.h0.d[size]);
                        g gVar2 = this.f4633b;
                        dVar.errMsg = gVar2.f4631b.errMsg;
                        c.a.n0.a.h0.n.b(dVar, gVar2.a);
                    }
                }
            }
        }

        public g(e eVar, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4632c = eVar;
            this.a = map;
            this.f4631b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4632c.f4593b.runOnJSThread(new a(this, this.f4632c.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f4635c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4636d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4637e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f4638b;

            public a(h hVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4638b = hVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4638b.f4634b), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "removeSavedFile:", this.f4638b.f4635c);
                    h hVar = this.f4638b;
                    if (c.a.n0.a.h0.n.a(v, hVar.f4636d, hashMap, hVar.f4637e.f4593b)) {
                        h hVar2 = this.f4638b;
                        c.a.n0.a.h0.n.b(hVar2.f4636d, hVar2.f4635c);
                    }
                }
            }
        }

        public h(e eVar, String str, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4637e = eVar;
            this.a = str;
            this.f4634b = i;
            this.f4635c = map;
            this.f4636d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4637e.f4593b.runOnJSThread(new a(this, this.f4637e.a.t(this.a)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f4640c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f4641d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4643f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4644g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4645h;
        public final /* synthetic */ e i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ i f4646b;

            public a(i iVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4646b = iVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4646b.f4644g), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "writeFile:", this.f4646b.f4641d);
                    i iVar = this.f4646b;
                    if (c.a.n0.a.h0.n.a(v, iVar.f4645h, hashMap, iVar.i.f4593b)) {
                        c.a.n0.a.h0.o.b bVar = this.f4646b.f4645h;
                        bVar.errMsg = "writeFile:" + this.a.f4586b;
                        i iVar2 = this.f4646b;
                        c.a.n0.a.h0.n.b(iVar2.f4645h, iVar2.f4641d);
                    }
                }
            }
        }

        public i(e eVar, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = eVar;
            this.a = str;
            this.f4639b = str2;
            this.f4640c = bArr;
            this.f4641d = map;
            this.f4642e = str3;
            this.f4643f = i;
            this.f4644g = i2;
            this.f4645h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.c C = this.i.a.C(false, this.a, TextUtils.isEmpty(this.f4639b) ? this.f4640c : this.f4639b, c.a.n0.a.h0.n.I("encoding", this.f4641d));
                if (!TextUtils.isEmpty(this.f4642e)) {
                    C.f4586b = this.f4642e;
                    C.a = -2;
                    c.a.n0.a.h0.n.d(this.i.f4593b, this.f4642e);
                } else {
                    int i = this.f4643f;
                    if (i != 7 && i != 12) {
                        C.f4586b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.n0.a.h0.n.d(this.i.f4593b, C.f4586b);
                    }
                }
                this.i.f4593b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4647b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f4648c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4649d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4650e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ j f4651b;

            public a(j jVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4651b = jVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4651b.f4647b), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "unlink:", this.f4651b.f4648c);
                    j jVar = this.f4651b;
                    if (c.a.n0.a.h0.n.a(v, jVar.f4649d, hashMap, jVar.f4650e.f4593b)) {
                        c.a.n0.a.h0.o.b bVar = this.f4651b.f4649d;
                        bVar.errMsg = "unlink:" + this.a.f4586b;
                        j jVar2 = this.f4651b;
                        c.a.n0.a.h0.n.b(jVar2.f4649d, jVar2.f4648c);
                    }
                }
            }
        }

        public j(e eVar, String str, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4650e = eVar;
            this.a = str;
            this.f4647b = i;
            this.f4648c = map;
            this.f4649d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4650e.f4593b.runOnJSThread(new a(this, this.f4650e.a.z(this.a, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4652b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4653c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4654d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f4655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4656f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4657g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ k f4658b;

            public a(k kVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4658b = kVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4658b.f4653c), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f4658b.f4654d), "targetPath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "unzip:", this.f4658b.f4655e);
                    k kVar = this.f4658b;
                    if (c.a.n0.a.h0.n.a(v, kVar.f4656f, hashMap, kVar.f4657g.f4593b)) {
                        c.a.n0.a.h0.o.b bVar = this.f4658b.f4656f;
                        bVar.errMsg = "unzip:" + this.a.f4586b;
                        k kVar2 = this.f4658b;
                        c.a.n0.a.h0.n.b(kVar2.f4656f, kVar2.f4655e);
                    }
                }
            }
        }

        public k(e eVar, String str, String str2, int i, int i2, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4657g = eVar;
            this.a = str;
            this.f4652b = str2;
            this.f4653c = i;
            this.f4654d = i2;
            this.f4655e = map;
            this.f4656f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4657g.f4593b.runOnJSThread(new a(this, this.f4657g.a.A(this.a, this.f4652b)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4660c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4661d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f4662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4663f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4664g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f4665b;

            public a(l lVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4665b = lVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4665b.f4660c), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f4665b.f4661d), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "saveFile:", this.f4665b.f4662e);
                    l lVar = this.f4665b;
                    if (c.a.n0.a.h0.n.a(v, lVar.f4663f, hashMap, lVar.f4664g.f4593b)) {
                        c.a.n0.a.h0.o.g gVar = new c.a.n0.a.h0.o.g();
                        List<String> list = this.a.f4587c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.a.f4586b;
                        c.a.n0.a.h0.n.b(gVar, this.f4665b.f4662e);
                    }
                }
            }
        }

        public l(e eVar, String str, String str2, int i, int i2, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4664g = eVar;
            this.a = str;
            this.f4659b = str2;
            this.f4660c = i;
            this.f4661d = i2;
            this.f4662e = map;
            this.f4663f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4664g.f4593b.runOnJSThread(new a(this, this.f4664g.a.x(this.a, this.f4659b, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4666b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f4667c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4668d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4669e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f4670b;

            public a(m mVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4670b = mVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4670b.f4666b), "dirPath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "readdir:", this.f4670b.f4667c);
                    m mVar = this.f4670b;
                    if (c.a.n0.a.h0.n.a(v, mVar.f4668d, hashMap, mVar.f4669e.f4593b)) {
                        c.a.n0.a.h0.o.e eVar = new c.a.n0.a.h0.o.e();
                        List<String> list = this.a.f4587c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.a.f4587c.toArray(new String[size]);
                        eVar.errMsg = this.a.f4586b;
                        c.a.n0.a.h0.n.b(eVar, this.f4670b.f4667c);
                    }
                }
            }
        }

        public m(e eVar, String str, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4669e = eVar;
            this.a = str;
            this.f4666b = i;
            this.f4667c = map;
            this.f4668d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4669e.f4593b.runOnJSThread(new a(this, this.f4669e.a.s(this.a, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Boolean f4671b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4672c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f4673d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f4675f;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ n f4676b;

            public a(n nVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4676b = nVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4676b.f4672c), "dirPath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "rmdir:", this.f4676b.f4673d);
                    n nVar = this.f4676b;
                    if (c.a.n0.a.h0.n.a(v, nVar.f4674e, hashMap, nVar.f4675f.f4593b)) {
                        n nVar2 = this.f4676b;
                        c.a.n0.a.h0.n.b(nVar2.f4674e, nVar2.f4673d);
                    }
                }
            }
        }

        public n(e eVar, String str, Boolean bool, int i, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, bool, Integer.valueOf(i), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4675f = eVar;
            this.a = str;
            this.f4671b = bool;
            this.f4672c = i;
            this.f4673d = map;
            this.f4674e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4675f.f4593b.runOnJSThread(new a(this, this.f4675f.a.v(this.a, this.f4671b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4677b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4678c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4679d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f4680e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4681f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4682g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f4683b;

            public a(o oVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4683b = oVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4683b.f4679d), "filePath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "readFile:", this.f4683b.f4680e);
                    o oVar = this.f4683b;
                    if (c.a.n0.a.h0.n.a(v, oVar.f4681f, hashMap, oVar.f4682g.f4593b)) {
                        if (TextUtils.isEmpty(this.f4683b.f4677b)) {
                            c.a.n0.a.h0.o.a aVar = new c.a.n0.a.h0.o.a();
                            c.a.n0.a.h0.c cVar = this.a;
                            if (cVar.f4592h == null) {
                                cVar.f4592h = new byte[0];
                            }
                            byte[] bArr = this.a.f4592h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.a.f4586b;
                            c.a.n0.a.h0.n.b(aVar, this.f4683b.f4680e);
                            return;
                        }
                        List<String> list = this.a.f4587c;
                        String str = list != null ? list.get(0) : null;
                        c.a.n0.a.h0.o.f fVar = new c.a.n0.a.h0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.a.f4586b;
                        c.a.n0.a.h0.n.b(fVar, this.f4683b.f4680e);
                    }
                }
            }
        }

        public o(e eVar, String str, String str2, int i, int i2, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4682g = eVar;
            this.a = str;
            this.f4677b = str2;
            this.f4678c = i;
            this.f4679d = i2;
            this.f4680e = map;
            this.f4681f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.c q = this.f4682g.a.q(this.a, this.f4677b, false);
                int i = this.f4678c;
                if (i != 7 && i != 12) {
                    q.f4586b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.n0.a.h0.n.d(this.f4682g.f4593b, q.f4586b);
                }
                this.f4682g.f4593b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4684b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4685c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f4686d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f4687e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.o.b f4688f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4689g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.h0.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ p f4690b;

            public a(p pVar, c.a.n0.a.h0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4690b = pVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f4690b.f4685c), "oldPath");
                    hashMap.put(Integer.valueOf(this.f4690b.f4686d), "newPath");
                    c.a.n0.a.h0.b v = c.a.n0.a.h0.n.v(this.a, "rename:", this.f4690b.f4687e);
                    p pVar = this.f4690b;
                    if (c.a.n0.a.h0.n.a(v, pVar.f4688f, hashMap, pVar.f4689g.f4593b)) {
                        p pVar2 = this.f4690b;
                        c.a.n0.a.h0.n.b(pVar2.f4688f, pVar2.f4687e);
                    }
                }
            }
        }

        public p(e eVar, String str, String str2, int i, int i2, Map map, c.a.n0.a.h0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4689g = eVar;
            this.a = str;
            this.f4684b = str2;
            this.f4685c = i;
            this.f4686d = i2;
            this.f4687e = map;
            this.f4688f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4689g.f4593b.runOnJSThread(new a(this, this.f4689g.a.u(this.a, this.f4684b, false)));
            }
        }
    }

    public e(c.a.n0.a.b0.a aVar) {
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
        this.f4593b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("path", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("path", J);
            this.f4594c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("encoding", jsObject);
            int O2 = c.a.n0.a.h0.n.O("filePath", jsObject);
            int O3 = c.a.n0.a.h0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : c.a.n0.a.h0.n.w(O3);
            byte[] r = c.a.n0.a.h0.n.r(jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("data", J);
            String I2 = c.a.n0.a.h0.n.I("filePath", J);
            this.f4594c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.n0.a.e2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new c.a.n0.a.h0.l();
            }
            this.a = new c.a.n0.a.h0.f(AppRuntime.getAppContext(), c.a.n0.a.w0.f.U().z(), lVar);
            this.f4594c = c.a.n0.a.h0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("srcPath", jsObject);
            int O2 = c.a.n0.a.h0.n.O("destPath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("srcPath", J);
            String I2 = c.a.n0.a.h0.n.I("destPath", J);
            this.f4594c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str, str2);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("filePath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("filePath", J);
            this.f4594c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.n0.a.h0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.n0.a.h0.n.J(this.a, jsObject, (bVar = new c.a.n0.a.h0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f4594c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("dirPath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("dirPath", J);
            this.f4594c.h(new a(this, I, (Boolean) c.a.n0.a.h0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("filePath", jsObject);
            int O2 = c.a.n0.a.h0.n.O("encoding", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("encoding", J);
            String I2 = c.a.n0.a.h0.n.I("filePath", J);
            this.f4594c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
                this.f4594c.k(str);
                c.a.n0.a.h0.c q = this.a.q(str, str2, true);
                c.a.n0.a.h0.n.d0(this.f4593b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f4587c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("dirPath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("dirPath", J);
            this.f4594c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
                this.f4594c.k(str);
                c.a.n0.a.h0.c s = this.a.s(str, true);
                c.a.n0.a.h0.n.d0(this.f4593b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f4587c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f4587c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("filePath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f4594c.h(new h(this, c.a.n0.a.h0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("oldPath", jsObject);
            int O2 = c.a.n0.a.h0.n.O("newPath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("oldPath", J);
            String I2 = c.a.n0.a.h0.n.I("newPath", J);
            this.f4594c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str, str2);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("dirPath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("dirPath", J);
            this.f4594c.h(new n(this, I, (Boolean) c.a.n0.a.h0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("tempFilePath", jsObject);
            int O2 = c.a.n0.a.h0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("tempFilePath", J);
            String I2 = c.a.n0.a.h0.n.I("filePath", J);
            this.f4594c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, c.a.n0.a.h0.a.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("path", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("path", J);
            this.f4594c.h(new RunnableC0292e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.n0.a.h0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
                this.f4594c.k(str);
                c.a.n0.a.h0.c y = this.a.y(str, true);
                c.a.n0.a.h0.n.d0(this.f4593b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f4588d;
            }
            return null;
        }
        return (c.a.n0.a.h0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("filePath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("filePath", J);
            this.f4594c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("zipFilePath", jsObject);
            int O2 = c.a.n0.a.h0.n.O("targetPath", jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("zipFilePath", J);
            String I2 = c.a.n0.a.h0.n.I("targetPath", J);
            this.f4594c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.n0.a.h0.n.O("filePath", jsObject);
            String w = c.a.n0.a.h0.n.w(c.a.n0.a.h0.n.O("data", jsObject));
            int O2 = c.a.n0.a.h0.n.O("encoding", jsObject);
            byte[] r = c.a.n0.a.h0.n.r(jsObject);
            c.a.n0.a.h0.o.b bVar = new c.a.n0.a.h0.o.b();
            Map<String, Object> J = c.a.n0.a.h0.n.J(this.a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.n0.a.h0.n.I("data", J);
            String I2 = c.a.n0.a.h0.n.I("filePath", J);
            this.f4594c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
                this.f4594c.k(str, str2);
                c.a.n0.a.h0.c x = this.a.x(str, str2, true);
                c.a.n0.a.h0.n.d0(this.f4593b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f4587c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
            this.f4594c.k(str);
            c.a.n0.a.h0.n.d0(this.f4593b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.n0.a.h0.n.T(this.a, this.f4593b, null, null)) {
                this.f4594c.k(str);
                c.a.n0.a.h0.c q = this.a.q(str, null, true);
                c.a.n0.a.h0.n.d0(this.f4593b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f4592h == null) {
                    q.f4592h = new byte[0];
                }
                byte[] bArr = q.f4592h;
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
