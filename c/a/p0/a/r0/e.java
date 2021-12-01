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
    public c.a.p0.a.r0.f a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.l0.a f7599b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.r0.i f7600c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7602f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7603g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7604h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7605i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f7606j;

        /* renamed from: c.a.p0.a.r0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0433a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7607e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f7608f;

            public RunnableC0433a(a aVar, c.a.p0.a.r0.c cVar) {
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
                this.f7608f = aVar;
                this.f7607e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7608f.f7603g), "dirPath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7607e, "mkdir:", this.f7608f.f7604h);
                    a aVar = this.f7608f;
                    if (c.a.p0.a.r0.n.a(v, aVar.f7605i, hashMap, aVar.f7606j.f7599b)) {
                        c.a.p0.a.r0.o.b bVar = this.f7608f.f7605i;
                        bVar.errMsg = "mkdir:" + this.f7607e.f7592b;
                        a aVar2 = this.f7608f;
                        c.a.p0.a.r0.n.b(aVar2.f7605i, aVar2.f7604h);
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
            this.f7606j = eVar;
            this.f7601e = str;
            this.f7602f = bool;
            this.f7603g = i2;
            this.f7604h = map;
            this.f7605i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7606j.f7599b.runOnJSThread(new RunnableC0433a(this, this.f7606j.a.o(this.f7601e, this.f7602f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7611g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7612h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7613i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7614j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7615k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7616e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f7617f;

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
                this.f7617f = bVar;
                this.f7616e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7617f.f7611g), "srcPath");
                    hashMap.put(Integer.valueOf(this.f7617f.f7612h), "destPath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7616e, "copyFile:", this.f7617f.f7613i);
                    b bVar = this.f7617f;
                    if (c.a.p0.a.r0.n.a(v, bVar.f7614j, hashMap, bVar.f7615k.f7599b)) {
                        b bVar2 = this.f7617f;
                        c.a.p0.a.r0.n.b(bVar2.f7614j, bVar2.f7613i);
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
            this.f7615k = eVar;
            this.f7609e = str;
            this.f7610f = str2;
            this.f7611g = i2;
            this.f7612h = i3;
            this.f7613i = map;
            this.f7614j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7615k.f7599b.runOnJSThread(new a(this, this.f7615k.a.c(this.f7609e, this.f7610f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7618e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7619f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7620g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7621h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7622i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7623j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f7624k;
        public final /* synthetic */ c.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7625e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f7626f;

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
                this.f7626f = cVar;
                this.f7625e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7626f.f7624k), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7625e, "appendFile:", this.f7626f.f7621h);
                    c cVar = this.f7626f;
                    if (c.a.p0.a.r0.n.a(v, cVar.l, hashMap, cVar.m.f7599b)) {
                        c cVar2 = this.f7626f;
                        c.a.p0.a.r0.n.b(cVar2.l, cVar2.f7621h);
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
            this.f7618e = str;
            this.f7619f = str2;
            this.f7620g = bArr;
            this.f7621h = map;
            this.f7622i = str3;
            this.f7623j = i2;
            this.f7624k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c b2 = this.m.a.b(this.f7618e, TextUtils.isEmpty(this.f7619f) ? this.f7620g : this.f7619f, c.a.p0.a.r0.n.I("encoding", this.f7621h), false);
                if (!TextUtils.isEmpty(this.f7622i)) {
                    b2.f7592b = this.f7622i;
                    b2.a = -2;
                    c.a.p0.a.r0.n.d(this.m.f7599b, this.f7622i);
                } else {
                    int i2 = this.f7623j;
                    if (i2 != 7 && i2 != 12) {
                        b2.f7592b = "fail encoding must be a string";
                        b2.a = -2;
                        c.a.p0.a.r0.n.d(this.m.f7599b, b2.f7592b);
                    }
                }
                this.m.f7599b.runOnJSThread(new a(this, b2));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7627e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7628f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7629g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7630h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7631i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7632e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f7633f;

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
                this.f7633f = dVar;
                this.f7632e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7633f.f7628f), "path");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7632e, "access:", this.f7633f.f7629g);
                    d dVar = this.f7633f;
                    if (c.a.p0.a.r0.n.a(v, dVar.f7630h, hashMap, dVar.f7631i.f7599b)) {
                        d dVar2 = this.f7633f;
                        c.a.p0.a.r0.n.b(dVar2.f7630h, dVar2.f7629g);
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
            this.f7631i = eVar;
            this.f7627e = str;
            this.f7628f = i2;
            this.f7629g = map;
            this.f7630h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7631i.f7599b.runOnJSThread(new a(this, this.f7631i.a.a(this.f7627e, false)));
            }
        }
    }

    /* renamed from: c.a.p0.a.r0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0434e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7635f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7636g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7637h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7638i;

        /* renamed from: c.a.p0.a.r0.e$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7639e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ RunnableC0434e f7640f;

            public a(RunnableC0434e runnableC0434e, c.a.p0.a.r0.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0434e, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7640f = runnableC0434e;
                this.f7639e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7640f.f7635f), "path");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7639e, "stat:", this.f7640f.f7636g);
                    RunnableC0434e runnableC0434e = this.f7640f;
                    if (c.a.p0.a.r0.n.a(v, runnableC0434e.f7637h, hashMap, runnableC0434e.f7638i.f7599b)) {
                        c.a.p0.a.r0.o.h hVar = new c.a.p0.a.r0.o.h();
                        c.a.p0.a.r0.c cVar = this.f7639e;
                        hVar.stats = cVar.f7594d;
                        hVar.errMsg = cVar.f7592b;
                        c.a.p0.a.r0.n.b(hVar, this.f7640f.f7636g);
                    }
                }
            }
        }

        public RunnableC0434e(e eVar, String str, int i2, Map map, c.a.p0.a.r0.o.b bVar) {
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
            this.f7638i = eVar;
            this.f7634e = str;
            this.f7635f = i2;
            this.f7636g = map;
            this.f7637h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7638i.f7599b.runOnJSThread(new a(this, this.f7638i.a.y(this.f7634e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7642f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7643g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7644h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7645i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7646e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f7647f;

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
                this.f7647f = fVar;
                this.f7646e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7647f.f7642f), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7646e, "getFileInfo:", this.f7647f.f7643g);
                    f fVar = this.f7647f;
                    if (c.a.p0.a.r0.n.a(v, fVar.f7644h, hashMap, fVar.f7645i.f7599b)) {
                        c.a.p0.a.r0.o.c cVar = new c.a.p0.a.r0.o.c();
                        cVar.errMsg = "getFileInfo:" + this.f7646e.f7592b;
                        c.a.p0.a.r0.c cVar2 = this.f7646e;
                        cVar.digest = cVar2.f7597g;
                        cVar.size = (int) cVar2.f7595e;
                        c.a.p0.a.r0.n.b(cVar, this.f7647f.f7643g);
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
            this.f7645i = eVar;
            this.f7641e = str;
            this.f7642f = i2;
            this.f7643g = map;
            this.f7644h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7645i.f7599b.runOnJSThread(new a(this, this.f7645i.a.e(this.f7641e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f7648e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7649f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f7650g;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7651e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f7652f;

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
                this.f7652f = gVar;
                this.f7651e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7651e, "getSavedFileList:", this.f7652f.f7648e);
                    g gVar = this.f7652f;
                    if (c.a.p0.a.r0.n.a(v, gVar.f7649f, null, gVar.f7650g.f7599b)) {
                        c.a.p0.a.r0.o.d dVar = new c.a.p0.a.r0.o.d();
                        List<c.a.p0.a.r0.d> list = this.f7651e.f7596f;
                        int size = list == null ? 0 : list.size();
                        dVar.fileList = size == 0 ? new c.a.p0.a.r0.d[0] : (c.a.p0.a.r0.d[]) this.f7651e.f7596f.toArray(new c.a.p0.a.r0.d[size]);
                        g gVar2 = this.f7652f;
                        dVar.errMsg = gVar2.f7649f.errMsg;
                        c.a.p0.a.r0.n.b(dVar, gVar2.f7648e);
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
            this.f7650g = eVar;
            this.f7648e = map;
            this.f7649f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7650g.f7599b.runOnJSThread(new a(this, this.f7650g.a.i()));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7654f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7655g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7656h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7657i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7658e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f7659f;

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
                this.f7659f = hVar;
                this.f7658e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7659f.f7654f), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7658e, "removeSavedFile:", this.f7659f.f7655g);
                    h hVar = this.f7659f;
                    if (c.a.p0.a.r0.n.a(v, hVar.f7656h, hashMap, hVar.f7657i.f7599b)) {
                        h hVar2 = this.f7659f;
                        c.a.p0.a.r0.n.b(hVar2.f7656h, hVar2.f7655g);
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
            this.f7657i = eVar;
            this.f7653e = str;
            this.f7654f = i2;
            this.f7655g = map;
            this.f7656h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7657i.f7599b.runOnJSThread(new a(this, this.f7657i.a.t(this.f7653e)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7660e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7661f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f7662g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7663h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7664i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f7665j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f7666k;
        public final /* synthetic */ c.a.p0.a.r0.o.b l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7667e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f7668f;

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
                this.f7668f = iVar;
                this.f7667e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7668f.f7666k), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7667e, "writeFile:", this.f7668f.f7663h);
                    i iVar = this.f7668f;
                    if (c.a.p0.a.r0.n.a(v, iVar.l, hashMap, iVar.m.f7599b)) {
                        c.a.p0.a.r0.o.b bVar = this.f7668f.l;
                        bVar.errMsg = "writeFile:" + this.f7667e.f7592b;
                        i iVar2 = this.f7668f;
                        c.a.p0.a.r0.n.b(iVar2.l, iVar2.f7663h);
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
            this.f7660e = str;
            this.f7661f = str2;
            this.f7662g = bArr;
            this.f7663h = map;
            this.f7664i = str3;
            this.f7665j = i2;
            this.f7666k = i3;
            this.l = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c C = this.m.a.C(false, this.f7660e, TextUtils.isEmpty(this.f7661f) ? this.f7662g : this.f7661f, c.a.p0.a.r0.n.I("encoding", this.f7663h));
                if (!TextUtils.isEmpty(this.f7664i)) {
                    C.f7592b = this.f7664i;
                    C.a = -2;
                    c.a.p0.a.r0.n.d(this.m.f7599b, this.f7664i);
                } else {
                    int i2 = this.f7665j;
                    if (i2 != 7 && i2 != 12) {
                        C.f7592b = "fail encoding must be a string";
                        C.a = -2;
                        c.a.p0.a.r0.n.d(this.m.f7599b, C.f7592b);
                    }
                }
                this.m.f7599b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7670f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7671g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7672h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7673i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7674e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f7675f;

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
                this.f7675f = jVar;
                this.f7674e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7675f.f7670f), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7674e, "unlink:", this.f7675f.f7671g);
                    j jVar = this.f7675f;
                    if (c.a.p0.a.r0.n.a(v, jVar.f7672h, hashMap, jVar.f7673i.f7599b)) {
                        c.a.p0.a.r0.o.b bVar = this.f7675f.f7672h;
                        bVar.errMsg = "unlink:" + this.f7674e.f7592b;
                        j jVar2 = this.f7675f;
                        c.a.p0.a.r0.n.b(jVar2.f7672h, jVar2.f7671g);
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
            this.f7673i = eVar;
            this.f7669e = str;
            this.f7670f = i2;
            this.f7671g = map;
            this.f7672h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7673i.f7599b.runOnJSThread(new a(this, this.f7673i.a.z(this.f7669e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7676e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7677f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7678g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7679h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7680i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7681j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7682k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7683e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f7684f;

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
                this.f7684f = kVar;
                this.f7683e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7684f.f7678g), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.f7684f.f7679h), "targetPath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7683e, "unzip:", this.f7684f.f7680i);
                    k kVar = this.f7684f;
                    if (c.a.p0.a.r0.n.a(v, kVar.f7681j, hashMap, kVar.f7682k.f7599b)) {
                        c.a.p0.a.r0.o.b bVar = this.f7684f.f7681j;
                        bVar.errMsg = "unzip:" + this.f7683e.f7592b;
                        k kVar2 = this.f7684f;
                        c.a.p0.a.r0.n.b(kVar2.f7681j, kVar2.f7680i);
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
            this.f7682k = eVar;
            this.f7676e = str;
            this.f7677f = str2;
            this.f7678g = i2;
            this.f7679h = i3;
            this.f7680i = map;
            this.f7681j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7682k.f7599b.runOnJSThread(new a(this, this.f7682k.a.A(this.f7676e, this.f7677f)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7686f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7687g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7688h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7689i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7690j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7691k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7692e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l f7693f;

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
                this.f7693f = lVar;
                this.f7692e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7693f.f7687g), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.f7693f.f7688h), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7692e, "saveFile:", this.f7693f.f7689i);
                    l lVar = this.f7693f;
                    if (c.a.p0.a.r0.n.a(v, lVar.f7690j, hashMap, lVar.f7691k.f7599b)) {
                        c.a.p0.a.r0.o.g gVar = new c.a.p0.a.r0.o.g();
                        List<String> list = this.f7692e.f7593c;
                        gVar.savedFilePath = list != null ? list.get(0) : null;
                        gVar.errMsg = this.f7692e.f7592b;
                        c.a.p0.a.r0.n.b(gVar, this.f7693f.f7689i);
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
            this.f7691k = eVar;
            this.f7685e = str;
            this.f7686f = str2;
            this.f7687g = i2;
            this.f7688h = i3;
            this.f7689i = map;
            this.f7690j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7691k.f7599b.runOnJSThread(new a(this, this.f7691k.a.x(this.f7685e, this.f7686f, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7694e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7695f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Map f7696g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7697h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f7698i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7699e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m f7700f;

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
                this.f7700f = mVar;
                this.f7699e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7700f.f7695f), "dirPath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7699e, "readdir:", this.f7700f.f7696g);
                    m mVar = this.f7700f;
                    if (c.a.p0.a.r0.n.a(v, mVar.f7697h, hashMap, mVar.f7698i.f7599b)) {
                        c.a.p0.a.r0.o.e eVar = new c.a.p0.a.r0.o.e();
                        List<String> list = this.f7699e.f7593c;
                        int size = list == null ? 0 : list.size();
                        eVar.files = size == 0 ? new String[0] : (String[]) this.f7699e.f7593c.toArray(new String[size]);
                        eVar.errMsg = this.f7699e.f7592b;
                        c.a.p0.a.r0.n.b(eVar, this.f7700f.f7696g);
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
            this.f7698i = eVar;
            this.f7694e = str;
            this.f7695f = i2;
            this.f7696g = map;
            this.f7697h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7698i.f7599b.runOnJSThread(new a(this, this.f7698i.a.s(this.f7694e, false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Boolean f7702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7703g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f7704h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7705i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f7706j;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7707e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n f7708f;

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
                this.f7708f = nVar;
                this.f7707e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7708f.f7703g), "dirPath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7707e, "rmdir:", this.f7708f.f7704h);
                    n nVar = this.f7708f;
                    if (c.a.p0.a.r0.n.a(v, nVar.f7705i, hashMap, nVar.f7706j.f7599b)) {
                        n nVar2 = this.f7708f;
                        c.a.p0.a.r0.n.b(nVar2.f7705i, nVar2.f7704h);
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
            this.f7706j = eVar;
            this.f7701e = str;
            this.f7702f = bool;
            this.f7703g = i2;
            this.f7704h = map;
            this.f7705i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7706j.f7599b.runOnJSThread(new a(this, this.f7706j.a.v(this.f7701e, this.f7702f.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7710f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7711g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7712h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7713i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7714j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7715k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7716e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ o f7717f;

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
                this.f7717f = oVar;
                this.f7716e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7717f.f7712h), "filePath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7716e, "readFile:", this.f7717f.f7713i);
                    o oVar = this.f7717f;
                    if (c.a.p0.a.r0.n.a(v, oVar.f7714j, hashMap, oVar.f7715k.f7599b)) {
                        if (TextUtils.isEmpty(this.f7717f.f7710f)) {
                            c.a.p0.a.r0.o.a aVar = new c.a.p0.a.r0.o.a();
                            c.a.p0.a.r0.c cVar = this.f7716e;
                            if (cVar.f7598h == null) {
                                cVar.f7598h = new byte[0];
                            }
                            byte[] bArr = this.f7716e.f7598h;
                            aVar.data = new JsArrayBuffer(bArr, bArr.length);
                            aVar.errMsg = this.f7716e.f7592b;
                            c.a.p0.a.r0.n.b(aVar, this.f7717f.f7713i);
                            return;
                        }
                        List<String> list = this.f7716e.f7593c;
                        String str = list != null ? list.get(0) : null;
                        c.a.p0.a.r0.o.f fVar = new c.a.p0.a.r0.o.f();
                        fVar.data = str;
                        fVar.errMsg = this.f7716e.f7592b;
                        c.a.p0.a.r0.n.b(fVar, this.f7717f.f7713i);
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
            this.f7715k = eVar;
            this.f7709e = str;
            this.f7710f = str2;
            this.f7711g = i2;
            this.f7712h = i3;
            this.f7713i = map;
            this.f7714j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.r0.c q = this.f7715k.a.q(this.f7709e, this.f7710f, false);
                int i2 = this.f7711g;
                if (i2 != 7 && i2 != 12) {
                    q.f7592b = "fail encoding must be a string";
                    q.a = -2;
                    c.a.p0.a.r0.n.d(this.f7715k.f7599b, q.f7592b);
                }
                this.f7715k.f7599b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7719f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f7720g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7721h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Map f7722i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.r0.o.b f7723j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ e f7724k;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r0.c f7725e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ p f7726f;

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
                this.f7726f = pVar;
                this.f7725e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.f7726f.f7720g), "oldPath");
                    hashMap.put(Integer.valueOf(this.f7726f.f7721h), "newPath");
                    c.a.p0.a.r0.b v = c.a.p0.a.r0.n.v(this.f7725e, "rename:", this.f7726f.f7722i);
                    p pVar = this.f7726f;
                    if (c.a.p0.a.r0.n.a(v, pVar.f7723j, hashMap, pVar.f7724k.f7599b)) {
                        p pVar2 = this.f7726f;
                        c.a.p0.a.r0.n.b(pVar2.f7723j, pVar2.f7722i);
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
            this.f7724k = eVar;
            this.f7718e = str;
            this.f7719f = str2;
            this.f7720g = i2;
            this.f7721h = i3;
            this.f7722i = map;
            this.f7723j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7724k.f7599b.runOnJSThread(new a(this, this.f7724k.a.u(this.f7718e, this.f7719f, false)));
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
        this.f7599b = aVar;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("path", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("path", J);
            this.f7600c.h(new d(this, I, O, J, bVar), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("encoding", jsObject);
            int O2 = c.a.p0.a.r0.n.O("filePath", jsObject);
            int O3 = c.a.p0.a.r0.n.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : c.a.p0.a.r0.n.w(O3);
            byte[] r = c.a.p0.a.r0.n.r(jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("data", J);
            String I2 = c.a.p0.a.r0.n.I("filePath", J);
            this.f7600c.h(new c(this, I2, I, r, J, w, O, O2, bVar), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        c.a.p0.a.o2.f.d lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.d2.e a0 = c.a.p0.a.d2.e.a0();
            if (a0 != null) {
                lVar = a0.g0();
            } else {
                lVar = new c.a.p0.a.r0.l();
            }
            this.a = new c.a.p0.a.r0.f(AppRuntime.getAppContext(), c.a.p0.a.g1.f.U().z(), lVar);
            this.f7600c = c.a.p0.a.r0.i.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("srcPath", jsObject);
            int O2 = c.a.p0.a.r0.n.O("destPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("srcPath", J);
            String I2 = c.a.p0.a.r0.n.I("destPath", J);
            this.f7600c.h(new b(this, I, I2, O, O2, J, bVar), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str, str2);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("filePath", J);
            this.f7600c.h(new f(this, I, O, J, bVar), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        c.a.p0.a.r0.o.b bVar;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = c.a.p0.a.r0.n.J(this.a, jsObject, (bVar = new c.a.p0.a.r0.o.b()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.f7600c.h(new g(this, J, bVar), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("dirPath", J);
            this.f7600c.h(new a(this, I, (Boolean) c.a.p0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesmkdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("filePath", jsObject);
            int O2 = c.a.p0.a.r0.n.O("encoding", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("encoding", J);
            String I2 = c.a.p0.a.r0.n.I("filePath", J);
            this.f7600c.h(new o(this, I2, I, O2, O, J, bVar), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
                this.f7600c.k(str);
                c.a.p0.a.r0.c q = this.a.q(str, str2, true);
                c.a.p0.a.r0.n.d0(this.f7599b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.f7593c) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("dirPath", J);
            this.f7600c.h(new m(this, I, O, J, bVar), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
                this.f7600c.k(str);
                c.a.p0.a.r0.c s = this.a.s(str, true);
                c.a.p0.a.r0.n.d0(this.f7599b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.f7593c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.f7593c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.f7600c.h(new h(this, c.a.p0.a.r0.n.I("filePath", J), O, J, bVar), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("oldPath", jsObject);
            int O2 = c.a.p0.a.r0.n.O("newPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("oldPath", J);
            String I2 = c.a.p0.a.r0.n.I("newPath", J);
            this.f7600c.h(new p(this, I, I2, O, O2, J, bVar), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str, str2);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("dirPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("dirPath", J);
            this.f7600c.h(new n(this, I, (Boolean) c.a.p0.a.r0.n.H("recursive", J, Boolean.FALSE), O, J, bVar), "aigamesrmdir:", I);
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
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("tempFilePath", jsObject);
            int O2 = c.a.p0.a.r0.n.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("tempFilePath", J);
            String I2 = c.a.p0.a.r0.n.I("filePath", J);
            this.f7600c.h(new l(this, I, I2, O, i2, J, bVar), "aigamessaveFile:", I, I2);
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
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("path", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("path", J);
            this.f7600c.h(new RunnableC0434e(this, I, O, J, bVar), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public c.a.p0.a.r0.j statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
                this.f7600c.k(str);
                c.a.p0.a.r0.c y = this.a.y(str, true);
                c.a.p0.a.r0.n.d0(this.f7599b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.f7594d;
            }
            return null;
        }
        return (c.a.p0.a.r0.j) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("filePath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("filePath", J);
            this.f7600c.h(new j(this, I, O, J, bVar), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("zipFilePath", jsObject);
            int O2 = c.a.p0.a.r0.n.O("targetPath", jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("zipFilePath", J);
            String I2 = c.a.p0.a.r0.n.I("targetPath", J);
            this.f7600c.h(new k(this, I, I2, O, O2, J, bVar), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = c.a.p0.a.r0.n.O("filePath", jsObject);
            String w = c.a.p0.a.r0.n.w(c.a.p0.a.r0.n.O("data", jsObject));
            int O2 = c.a.p0.a.r0.n.O("encoding", jsObject);
            byte[] r = c.a.p0.a.r0.n.r(jsObject);
            c.a.p0.a.r0.o.b bVar = new c.a.p0.a.r0.o.b();
            Map<String, Object> J = c.a.p0.a.r0.n.J(this.a, jsObject, bVar, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = c.a.p0.a.r0.n.I("data", J);
            String I2 = c.a.p0.a.r0.n.I("filePath", J);
            this.f7600c.h(new i(this, I2, I, r, J, w, O2, O, bVar), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
                this.f7600c.k(str, str2);
                c.a.p0.a.r0.c x = this.a.x(str, str2, true);
                c.a.p0.a.r0.n.d0(this.f7599b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.f7593c) == null) {
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
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
            this.f7600c.k(str);
            c.a.p0.a.r0.n.d0(this.f7599b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (c.a.p0.a.r0.n.T(this.a, this.f7599b, null, null)) {
                this.f7600c.k(str);
                c.a.p0.a.r0.c q = this.a.q(str, null, true);
                c.a.p0.a.r0.n.d0(this.f7599b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.f7598h == null) {
                    q.f7598h = new byte[0];
                }
                byte[] bArr = q.f7598h;
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
