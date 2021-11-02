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
    public b.a.p0.a.r0.f f7466a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.l0.a f7467b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.r0.i f7468c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7470f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7471g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7472h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7473i;
        public final /* synthetic */ e j;

        /* renamed from: b.a.p0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0351a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7474e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7475f;

            public RunnableC0351a(a aVar, b.a.p0.a.r0.c cVar) {
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
                this.f7475f = aVar;
                this.f7474e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7475f.f7471g), "dirPath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7474e, "mkdir:", this.f7475f.f7472h);
                    a aVar = this.f7475f;
                    if (b.a.p0.a.r0.n.a(t, aVar.f7473i, hashMap, aVar.j.f7467b)) {
                        b.a.p0.a.r0.o.b bVar = this.f7475f.f7473i;
                        bVar.errMsg = "mkdir:" + this.f7474e.f7459b;
                        a aVar2 = this.f7475f;
                        b.a.p0.a.r0.n.b(aVar2.f7473i, aVar2.f7472h);
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
            this.f7469e = str;
            this.f7470f = bool;
            this.f7471g = i2;
            this.f7472h = map;
            this.f7473i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f7467b.runOnJSThread(new RunnableC0351a(this, this.j.f7466a.o(this.f7469e, this.f7470f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7477f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7478g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7479h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7480i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7481e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7482f;

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
                this.f7482f = bVar;
                this.f7481e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7482f.f7478g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f7482f.f7479h), "destPath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7481e, "copyFile:", this.f7482f.f7480i);
                    b bVar = this.f7482f;
                    if (b.a.p0.a.r0.n.a(t, bVar.j, hashMap, bVar.k.f7467b)) {
                        b bVar2 = this.f7482f;
                        b.a.p0.a.r0.n.b(bVar2.j, bVar2.f7480i);
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
            this.f7476e = str;
            this.f7477f = str2;
            this.f7478g = i2;
            this.f7479h = i3;
            this.f7480i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7467b.runOnJSThread(new a(this, this.k.f7466a.c(this.f7476e, this.f7477f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7486h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7487i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ b.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7488e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f7489f;

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
                this.f7489f = cVar;
                this.f7488e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7489f.k), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7488e, "appendFile:", this.f7489f.f7486h);
                    c cVar = this.f7489f;
                    if (b.a.p0.a.r0.n.a(t, cVar.l, hashMap, cVar.m.f7467b)) {
                        c cVar2 = this.f7489f;
                        b.a.p0.a.r0.n.b(cVar2.l, cVar2.f7486h);
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
            this.f7483e = str;
            this.f7484f = str2;
            this.f7485g = bArr;
            this.f7486h = map;
            this.f7487i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r0.c b2 = this.m.f7466a.b(this.f7483e, TextUtils.isEmpty(this.f7484f) ? this.f7485g : this.f7484f, b.a.p0.a.r0.n.F("encoding", this.f7486h), false);
                if (!TextUtils.isEmpty(this.f7487i)) {
                    b2.f7459b = this.f7487i;
                    b2.f7458a = -2;
                    b.a.p0.a.r0.n.d(this.m.f7467b, this.f7487i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f7459b = "fail encoding must be a string";
                        b2.f7458a = -2;
                        b.a.p0.a.r0.n.d(this.m.f7467b, b2.f7459b);
                    }
                }
                this.m.f7467b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7491f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7492g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7493h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7494i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7495e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f7496f;

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
                this.f7496f = dVar;
                this.f7495e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7496f.f7491f), "path");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7495e, "access:", this.f7496f.f7492g);
                    d dVar = this.f7496f;
                    if (b.a.p0.a.r0.n.a(t, dVar.f7493h, hashMap, dVar.f7494i.f7467b)) {
                        d dVar2 = this.f7496f;
                        b.a.p0.a.r0.n.b(dVar2.f7493h, dVar2.f7492g);
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
            this.f7494i = eVar;
            this.f7490e = str;
            this.f7491f = i2;
            this.f7492g = map;
            this.f7493h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7494i.f7467b.runOnJSThread(new a(this, this.f7494i.f7466a.a(this.f7490e, false)));
            }
        }
    }

    /* renamed from: b.a.p0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0352e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7498f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7499g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7500h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7501i;

        /* renamed from: b.a.p0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7502e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0352e f7503f;

            public a(RunnableC0352e runnableC0352e, b.a.p0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0352e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7503f = runnableC0352e;
                this.f7502e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7503f.f7498f), "path");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7502e, "stat:", this.f7503f.f7499g);
                    RunnableC0352e runnableC0352e = this.f7503f;
                    if (b.a.p0.a.r0.n.a(t, runnableC0352e.f7500h, hashMap, runnableC0352e.f7501i.f7467b)) {
                        b.a.p0.a.r0.o.h hVar = new b.a.p0.a.r0.o.h();
                        b.a.p0.a.r0.c cVar = this.f7502e;
                        hVar.stats = cVar.f7461d;
                        hVar.errMsg = cVar.f7459b;
                        b.a.p0.a.r0.n.b(hVar, this.f7503f.f7499g);
                    }
                }
            }
        }

        public RunnableC0352e(e eVar, String str, int i2, Map map, b.a.p0.a.r0.o.b bVar) {
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
            this.f7501i = eVar;
            this.f7497e = str;
            this.f7498f = i2;
            this.f7499g = map;
            this.f7500h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7501i.f7467b.runOnJSThread(new a(this, this.f7501i.f7466a.y(this.f7497e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7506g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7507h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7508i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7509e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f7510f;

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
                this.f7510f = fVar;
                this.f7509e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7510f.f7505f), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7509e, "getFileInfo:", this.f7510f.f7506g);
                    f fVar = this.f7510f;
                    if (b.a.p0.a.r0.n.a(t, fVar.f7507h, hashMap, fVar.f7508i.f7467b)) {
                        b.a.p0.a.r0.o.c cVar = new b.a.p0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f7509e.f7459b;
                        b.a.p0.a.r0.c cVar2 = this.f7509e;
                        cVar.digest = cVar2.f7464g;
                        cVar.size = (int) cVar2.f7462e;
                        b.a.p0.a.r0.n.b(cVar, this.f7510f.f7506g);
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
            this.f7508i = eVar;
            this.f7504e = str;
            this.f7505f = i2;
            this.f7506g = map;
            this.f7507h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7508i.f7467b.runOnJSThread(new a(this, this.f7508i.f7466a.e(this.f7504e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f7511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7512f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f7513g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7514e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f7515f;

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
                this.f7515f = gVar;
                this.f7514e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7514e, "getSavedFileList:", this.f7515f.f7511e);
                    g gVar = this.f7515f;
                    if (b.a.p0.a.r0.n.a(t, gVar.f7512f, null, gVar.f7513g.f7467b)) {
                        b.a.p0.a.r0.o.d dVar = new b.a.p0.a.r0.o.d();
                        List<b.a.p0.a.r0.d> list = this.f7514e.f7463f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new b.a.p0.a.r0.d[0] : (b.a.p0.a.r0.d[]) this.f7514e.f7463f.toArray(new b.a.p0.a.r0.d[size]);
                        g gVar2 = this.f7515f;
                        dVar.errMsg = gVar2.f7512f.errMsg;
                        b.a.p0.a.r0.n.b(dVar, gVar2.f7511e);
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
            this.f7513g = eVar;
            this.f7511e = map;
            this.f7512f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7513g.f7467b.runOnJSThread(new a(this, this.f7513g.f7466a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7518g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7519h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7520i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7521e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f7522f;

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
                this.f7522f = hVar;
                this.f7521e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7522f.f7517f), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7521e, "removeSavedFile:", this.f7522f.f7518g);
                    h hVar = this.f7522f;
                    if (b.a.p0.a.r0.n.a(t, hVar.f7519h, hashMap, hVar.f7520i.f7467b)) {
                        h hVar2 = this.f7522f;
                        b.a.p0.a.r0.n.b(hVar2.f7519h, hVar2.f7518g);
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
            this.f7520i = eVar;
            this.f7516e = str;
            this.f7517f = i2;
            this.f7518g = map;
            this.f7519h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7520i.f7467b.runOnJSThread(new a(this, this.f7520i.f7466a.t(this.f7516e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7524f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7525g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7526h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7527i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ b.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7528e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f7529f;

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
                this.f7529f = iVar;
                this.f7528e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7529f.k), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7528e, "writeFile:", this.f7529f.f7526h);
                    i iVar = this.f7529f;
                    if (b.a.p0.a.r0.n.a(t, iVar.l, hashMap, iVar.m.f7467b)) {
                        b.a.p0.a.r0.o.b bVar = this.f7529f.l;
                        bVar.errMsg = "writeFile:" + this.f7528e.f7459b;
                        i iVar2 = this.f7529f;
                        b.a.p0.a.r0.n.b(iVar2.l, iVar2.f7526h);
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
            this.f7523e = str;
            this.f7524f = str2;
            this.f7525g = bArr;
            this.f7526h = map;
            this.f7527i = str3;
            this.j = i2;
            this.k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r0.c C = this.m.f7466a.C(false, this.f7523e, TextUtils.isEmpty(this.f7524f) ? this.f7525g : this.f7524f, b.a.p0.a.r0.n.F("encoding", this.f7526h));
                if (!TextUtils.isEmpty(this.f7527i)) {
                    C.f7459b = this.f7527i;
                    C.f7458a = -2;
                    b.a.p0.a.r0.n.d(this.m.f7467b, this.f7527i);
                } else {
                    int i2 = this.j;
                    if (i2 != 7 && i2 != 12) {
                        C.f7459b = "fail encoding must be a string";
                        C.f7458a = -2;
                        b.a.p0.a.r0.n.d(this.m.f7467b, C.f7459b);
                    }
                }
                this.m.f7467b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7530e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7531f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7532g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7533h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7534i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7535e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f7536f;

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
                this.f7536f = jVar;
                this.f7535e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7536f.f7531f), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7535e, "unlink:", this.f7536f.f7532g);
                    j jVar = this.f7536f;
                    if (b.a.p0.a.r0.n.a(t, jVar.f7533h, hashMap, jVar.f7534i.f7467b)) {
                        b.a.p0.a.r0.o.b bVar = this.f7536f.f7533h;
                        bVar.errMsg = "unlink:" + this.f7535e.f7459b;
                        j jVar2 = this.f7536f;
                        b.a.p0.a.r0.n.b(jVar2.f7533h, jVar2.f7532g);
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
            this.f7534i = eVar;
            this.f7530e = str;
            this.f7531f = i2;
            this.f7532g = map;
            this.f7533h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7534i.f7467b.runOnJSThread(new a(this, this.f7534i.f7466a.z(this.f7530e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7537e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7538f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7539g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7540h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7541i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7542e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f7543f;

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
                this.f7543f = kVar;
                this.f7542e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7543f.f7539g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f7543f.f7540h), "targetPath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7542e, "unzip:", this.f7543f.f7541i);
                    k kVar = this.f7543f;
                    if (b.a.p0.a.r0.n.a(t, kVar.j, hashMap, kVar.k.f7467b)) {
                        b.a.p0.a.r0.o.b bVar = this.f7543f.j;
                        bVar.errMsg = "unzip:" + this.f7542e.f7459b;
                        k kVar2 = this.f7543f;
                        b.a.p0.a.r0.n.b(kVar2.j, kVar2.f7541i);
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
            this.f7537e = str;
            this.f7538f = str2;
            this.f7539g = i2;
            this.f7540h = i3;
            this.f7541i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7467b.runOnJSThread(new a(this, this.k.f7466a.A(this.f7537e, this.f7538f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7546g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7547h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7548i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7549e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f7550f;

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
                this.f7550f = lVar;
                this.f7549e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7550f.f7546g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f7550f.f7547h), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7549e, "saveFile:", this.f7550f.f7548i);
                    l lVar = this.f7550f;
                    if (b.a.p0.a.r0.n.a(t, lVar.j, hashMap, lVar.k.f7467b)) {
                        b.a.p0.a.r0.o.g gVar = new b.a.p0.a.r0.o.g();
                        List<String> list = this.f7549e.f7460c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f7549e.f7459b;
                        b.a.p0.a.r0.n.b(gVar, this.f7550f.f7548i);
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
            this.f7544e = str;
            this.f7545f = str2;
            this.f7546g = i2;
            this.f7547h = i3;
            this.f7548i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7467b.runOnJSThread(new a(this, this.k.f7466a.x(this.f7544e, this.f7545f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7552f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7553g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7554h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7555i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7556e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f7557f;

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
                this.f7557f = mVar;
                this.f7556e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7557f.f7552f), "dirPath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7556e, "readdir:", this.f7557f.f7553g);
                    m mVar = this.f7557f;
                    if (b.a.p0.a.r0.n.a(t, mVar.f7554h, hashMap, mVar.f7555i.f7467b)) {
                        b.a.p0.a.r0.o.e eVar = new b.a.p0.a.r0.o.e();
                        List<String> list = this.f7556e.f7460c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f7556e.f7460c.toArray(new String[size]);
                        eVar.errMsg = this.f7556e.f7459b;
                        b.a.p0.a.r0.n.b(eVar, this.f7557f.f7553g);
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
            this.f7555i = eVar;
            this.f7551e = str;
            this.f7552f = i2;
            this.f7553g = map;
            this.f7554h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7555i.f7467b.runOnJSThread(new a(this, this.f7555i.f7466a.s(this.f7551e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7558e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7559f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7560g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7561h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.r0.o.b f7562i;
        public final /* synthetic */ e j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7563e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f7564f;

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
                this.f7564f = nVar;
                this.f7563e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7564f.f7560g), "dirPath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7563e, "rmdir:", this.f7564f.f7561h);
                    n nVar = this.f7564f;
                    if (b.a.p0.a.r0.n.a(t, nVar.f7562i, hashMap, nVar.j.f7467b)) {
                        n nVar2 = this.f7564f;
                        b.a.p0.a.r0.n.b(nVar2.f7562i, nVar2.f7561h);
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
            this.f7558e = str;
            this.f7559f = bool;
            this.f7560g = i2;
            this.f7561h = map;
            this.f7562i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.f7467b.runOnJSThread(new a(this, this.j.f7466a.v(this.f7558e, this.f7559f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7565e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7566f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7567g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7568h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7569i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7570e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f7571f;

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
                this.f7571f = oVar;
                this.f7570e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7571f.f7568h), "filePath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7570e, "readFile:", this.f7571f.f7569i);
                    o oVar = this.f7571f;
                    if (b.a.p0.a.r0.n.a(t, oVar.j, hashMap, oVar.k.f7467b)) {
                        if (TextUtils.isEmpty(this.f7571f.f7566f)) {
                            b.a.p0.a.r0.o.a aVar = new b.a.p0.a.r0.o.a();
                            b.a.p0.a.r0.c cVar = this.f7570e;
                            if (cVar.f7465h == null) {
                                cVar.f7465h = new byte[0];
                            }
                            byte[] bArr = this.f7570e.f7465h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f7570e.f7459b;
                            b.a.p0.a.r0.n.b(aVar, this.f7571f.f7569i);
                            return;
                        }
                        List<String> list = this.f7570e.f7460c;
                        String str = list != null ? list.get(0) : null;
                        b.a.p0.a.r0.o.f fVar = new b.a.p0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f7570e.f7459b;
                        b.a.p0.a.r0.n.b(fVar, this.f7571f.f7569i);
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
            this.f7565e = str;
            this.f7566f = str2;
            this.f7567g = i2;
            this.f7568h = i3;
            this.f7569i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.r0.c q = this.k.f7466a.q(this.f7565e, this.f7566f, false);
                int i2 = this.f7567g;
                if (i2 != 7 && i2 != 12) {
                    q.f7459b = "fail encoding must be a string";
                    q.f7458a = -2;
                    b.a.p0.a.r0.n.d(this.k.f7467b, q.f7459b);
                }
                this.k.f7467b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7573f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7574g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7575h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7576i;
        public final /* synthetic */ b.a.p0.a.r0.o.b j;
        public final /* synthetic */ e k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r0.c f7577e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f7578f;

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
                this.f7578f = pVar;
                this.f7577e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7578f.f7574g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f7578f.f7575h), "newPath");
                    b.a.p0.a.r0.b t = b.a.p0.a.r0.n.t(this.f7577e, "rename:", this.f7578f.f7576i);
                    p pVar = this.f7578f;
                    if (b.a.p0.a.r0.n.a(t, pVar.j, hashMap, pVar.k.f7467b)) {
                        p pVar2 = this.f7578f;
                        b.a.p0.a.r0.n.b(pVar2.j, pVar2.f7576i);
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
            this.f7572e = str;
            this.f7573f = str2;
            this.f7574g = i2;
            this.f7575h = i3;
            this.f7576i = map;
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.f7467b.runOnJSThread(new a(this, this.k.f7466a.u(this.f7572e, this.f7573f, false)));
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
        this.f7467b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("path", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("path", G);
            this.f7468c.h(new d(this, F, L, G, bVar), "aigamesaccess:", F);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("encoding", jsObject);
            int L2 = b.a.p0.a.r0.n.L("filePath", jsObject);
            int L3 = b.a.p0.a.r0.n.L("data", jsObject);
            String u = (L3 == 5 || L3 == 2 || L3 == 3) ? "fail data argument must not be a number" : b.a.p0.a.r0.n.u(L3);
            byte[] p2 = b.a.p0.a.r0.n.p(jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("data", G);
            String F2 = b.a.p0.a.r0.n.F("filePath", G);
            this.f7468c.h(new c(this, F2, F, p2, G, u, L, L2, bVar), "aigamesappendFile:", F2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        b.a.p0.a.k2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P != null) {
                lVar = P.V();
            } else {
                lVar = new b.a.p0.a.r0.l();
            }
            this.f7466a = new b.a.p0.a.r0.f(AppRuntime.getAppContext(), b.a.p0.a.g1.f.T().z(), lVar);
            this.f7468c = b.a.p0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("srcPath", jsObject);
            int L2 = b.a.p0.a.r0.n.L("destPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("srcPath", G);
            String F2 = b.a.p0.a.r0.n.F("destPath", G);
            this.f7468c.h(new b(this, F, F2, L, L2, G, bVar), "aigamescopyFile:", F, F2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str, str2);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("filePath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("filePath", G);
            this.f7468c.h(new f(this, F, L, G, bVar), "aigamesgetFileInfo:", F);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        b.a.p0.a.r0.o.b bVar;
        Map<String, Object> G;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, (bVar = new b.a.p0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f7468c.h(new g(this, G, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("dirPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("dirPath", G);
            this.f7468c.h(new a(this, F, (Boolean) b.a.p0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesmkdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("filePath", jsObject);
            int L2 = b.a.p0.a.r0.n.L("encoding", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("encoding", G);
            String F2 = b.a.p0.a.r0.n.F("filePath", G);
            this.f7468c.h(new o(this, F2, F, L2, L, G, bVar), "aigamesreadFile:", F2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
                this.f7468c.k(str);
                b.a.p0.a.r0.c q = this.f7466a.q(str, str2, true);
                b.a.p0.a.r0.n.Z(this.f7467b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.f7458a != 0 || (list = q.f7460c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("dirPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("dirPath", G);
            this.f7468c.h(new m(this, F, L, G, bVar), "aigamesreaddir:", F);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
                this.f7468c.k(str);
                b.a.p0.a.r0.c s = this.f7466a.s(str, true);
                b.a.p0.a.r0.n.Z(this.f7467b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.f7458a != 0) {
                    return new String[0];
                }
                List<String> list = s.f7460c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f7460c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("filePath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            this.f7468c.h(new h(this, b.a.p0.a.r0.n.F("filePath", G), L, G, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("oldPath", jsObject);
            int L2 = b.a.p0.a.r0.n.L("newPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("oldPath", G);
            String F2 = b.a.p0.a.r0.n.F("newPath", G);
            this.f7468c.h(new p(this, F, F2, L, L2, G, bVar), "aigamesrename:", F, F2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str, str2);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("dirPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("dirPath", G);
            this.f7468c.h(new n(this, F, (Boolean) b.a.p0.a.r0.n.E("recursive", G, Boolean.FALSE), L, G, bVar), "aigamesrmdir:", F);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("tempFilePath", jsObject);
            int L2 = b.a.p0.a.r0.n.L("filePath", jsObject);
            int i2 = L2 == 12 ? 7 : L2;
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("tempFilePath", G);
            String F2 = b.a.p0.a.r0.n.F("filePath", G);
            this.f7468c.h(new l(this, F, F2, L, i2, G, bVar), "aigamessaveFile:", F, F2);
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
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("path", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("path", G);
            this.f7468c.h(new RunnableC0352e(this, F, L, G, bVar), "aigamesstat:", F);
        }
    }

    @JavascriptInterface
    public b.a.p0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
                this.f7468c.k(str);
                b.a.p0.a.r0.c y = this.f7466a.y(str, true);
                b.a.p0.a.r0.n.Z(this.f7467b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.f7458a != 0) {
                    return null;
                }
                return y.f7461d;
            }
            return null;
        }
        return (b.a.p0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("filePath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("filePath", G);
            this.f7468c.h(new j(this, F, L, G, bVar), "aigamesunlink:", F);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("zipFilePath", jsObject);
            int L2 = b.a.p0.a.r0.n.L("targetPath", jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("zipFilePath", G);
            String F2 = b.a.p0.a.r0.n.F("targetPath", G);
            this.f7468c.h(new k(this, F, F2, L, L2, G, bVar), "aigamesunzip:", F, F2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int L = b.a.p0.a.r0.n.L("filePath", jsObject);
            String u = b.a.p0.a.r0.n.u(b.a.p0.a.r0.n.L("data", jsObject));
            int L2 = b.a.p0.a.r0.n.L("encoding", jsObject);
            byte[] p2 = b.a.p0.a.r0.n.p(jsObject);
            b.a.p0.a.r0.o.b bVar = new b.a.p0.a.r0.o.b();
            Map<String, Object> G = b.a.p0.a.r0.n.G(this.f7466a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (G == null) {
                return;
            }
            String F = b.a.p0.a.r0.n.F("data", G);
            String F2 = b.a.p0.a.r0.n.F("filePath", G);
            this.f7468c.h(new i(this, F2, F, p2, G, u, L2, L, bVar), "aigameswriteFile:", F2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
                this.f7468c.k(str, str2);
                b.a.p0.a.r0.c x = this.f7466a.x(str, str2, true);
                b.a.p0.a.r0.n.Z(this.f7467b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.f7458a != 0 || (list = x.f7460c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
            this.f7468c.k(str);
            b.a.p0.a.r0.n.Z(this.f7467b, this.f7466a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (b.a.p0.a.r0.n.P(this.f7466a, this.f7467b, null, null)) {
                this.f7468c.k(str);
                b.a.p0.a.r0.c q = this.f7466a.q(str, null, true);
                b.a.p0.a.r0.n.Z(this.f7467b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f7465h == null) {
                    q.f7465h = new byte[0];
                }
                byte[] bArr = q.f7465h;
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
