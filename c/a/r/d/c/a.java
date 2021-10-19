package c.a.r.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.r.d.a;
import c.a.r.e.a;
import c.a.r.g.d.a;
import c.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.r.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f15279g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f15280h;

    /* renamed from: c.a.r.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CallableC0726a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15281e;

        public CallableC0726a(a aVar) {
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
            this.f15281e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f15281e;
                aVar.i(aVar.f15280h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f15282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15283f;

        public b(a aVar, a.c cVar) {
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
            this.f15283f = aVar;
            this.f15282e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f15283f.f15280h.f15294g == null) {
                    this.f15282e.a(-1, null, null);
                    return;
                }
                this.f15282e.onResult(this.f15283f.f15280h.f15294g.a(), null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f15284e;

        public c(a aVar, a.c cVar) {
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
            this.f15284e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15284e.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C0727a> f15285a;

        /* renamed from: c.a.r.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0727a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f15286a;

            /* renamed from: b  reason: collision with root package name */
            public long f15287b;

            public C0727a(boolean z, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15286a = z;
                this.f15287b = j2;
            }
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15285a = new HashMap();
        }

        public C0727a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f15285a.get(str) : (C0727a) invokeL.objValue;
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trustSubject) == null) {
                try {
                    String m = trustSubject.m("config-cs");
                    if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("cs")) == null) {
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject = optJSONObject.getJSONObject(next);
                        this.f15285a.put(next, new C0727a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile c.a.r.h.b f15288a;

        /* renamed from: b  reason: collision with root package name */
        public volatile c.a.r.e.b f15289b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f15290c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f15291d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f15292e;

        /* renamed from: f  reason: collision with root package name */
        public volatile c.a.r.g.d.a f15293f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f15294g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, c.a.r.e.a> f15295h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, c.a.r.h.a> f15296i;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15295h = new HashMap();
            this.f15296i = new HashMap();
        }
    }

    /* loaded from: classes3.dex */
    public static class f<T> implements a.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f15297a;

        public f(a.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15297a = cVar;
        }

        @Override // c.a.r.h.a.d
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.f15297a.a(i2, exc, bundle);
            }
        }

        @Override // c.a.r.h.a.d
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.f15297a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C0728a> f15298a;

        /* renamed from: c.a.r.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0728a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f15299a;

            public C0728a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15299a = z;
            }
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15298a = new HashMap();
        }

        public C0728a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f15298a.get(str) : (C0728a) invokeL.objValue;
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, trustSubject) == null) {
                try {
                    String m = trustSubject.m("config-ids");
                    if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("ids")) == null) {
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.f15298a.put(next, new C0728a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C0737a f15300a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f15301b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f15302c;

        public h(a.C0737a c0737a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0737a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15300a = c0737a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f15300a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f15300a.d("lock"));
                    this.f15301b = fileOutputStream;
                    this.f15302c = fileOutputStream.getChannel().lock();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                FileLock fileLock = this.f15302c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f15301b;
                        if (fileOutputStream != null) {
                            c.a.r.g.c.a.c.b(fileOutputStream);
                            this.f15301b = null;
                        }
                        this.f15302c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f15301b;
                        if (fileOutputStream2 != null) {
                            c.a.r.g.c.a.c.b(fileOutputStream2);
                            this.f15301b = null;
                        }
                        this.f15302c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f15301b;
                        if (fileOutputStream3 != null) {
                            c.a.r.g.c.a.c.b(fileOutputStream3);
                            this.f15301b = null;
                        }
                        this.f15302c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f15303a;

        /* renamed from: b  reason: collision with root package name */
        public String f15304b;

        /* renamed from: c  reason: collision with root package name */
        public long f15305c;

        public i(String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15303a = str;
            this.f15304b = str2;
            this.f15305c = j2;
        }
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f15306a;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15306a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (i iVar : this.f15306a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", iVar.f15303a);
                        jSONObject.put("aid", iVar.f15304b);
                        jSONObject.put("priority", iVar.f15305c);
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception unused) {
                }
                return jSONArray.toString();
            }
            return (String) invokeV.objValue;
        }

        public void b(String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
                this.f15306a.add(new i(str, str2, j2));
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            h();
            c.a.r.h.a aVar = this.f15280h.f15296i.get(str);
            if (aVar != null) {
                aVar.g(new f(cVar));
                return;
            }
            if (Config.SID.equals(str)) {
                executorService = this.f15268e.f15273d;
                cVar2 = new b(this, cVar);
            } else {
                executorService = this.f15268e.f15273d;
                cVar2 = new c(this, cVar);
            }
            executorService.submit(cVar2);
        }
    }

    @Override // c.a.r.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            h();
            List<TrustSubject> list = this.f15280h.f15291d.f40655a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.f40634a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f15279g = this.f15268e.f15272c;
            this.f15280h = new e();
            this.f15280h.f15292e = this.f15268e.f15273d.submit(new CallableC0726a(this));
        }
    }

    @Override // c.a.r.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            h();
            c.a.r.h.a aVar = this.f15280h.f15296i.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.f15280h.f15292e.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void i(e eVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            c.a.r.g.d.a aVar = new c.a.r.g.d.a(this.f15279g);
            eVar.f15293f = aVar;
            h hVar = new h(aVar.d().f("init"));
            try {
                hVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.f40652a = this.f15279g;
                aVar2.f40653b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                eVar.f15290c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                eVar.f15291d = trustSubjectManager.j(new TrustSubjectManager.c());
                c.a.r.h.b bVar = new c.a.r.h.b(this.f15268e.f15270a);
                eVar.f15288a = bVar;
                a.b bVar2 = new a.b();
                bVar2.f15482a = this.f15279g;
                bVar2.f15483b = aVar;
                bVar2.f15484c = eVar.f15291d;
                bVar2.f15485d = this.f15268e.f15273d;
                bVar2.f15486e = this.f15268e.f15274e;
                a.c cVar = new a.c();
                cVar.f15487a = false;
                List<c.a.r.h.a> b2 = bVar.b();
                ArrayList<c.a.r.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (eVar.f15291d.f40656b != null) {
                    gVar = new g();
                    gVar.b(eVar.f15291d.f40656b);
                } else {
                    gVar = null;
                }
                if (arrayList.size() > 0 && gVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        g.C0728a a2 = gVar.a(((c.a.r.h.a) it.next()).e());
                        if (a2 != null && !a2.f15299a) {
                            it.remove();
                        }
                    }
                }
                for (c.a.r.h.a aVar3 : arrayList) {
                    eVar.f15296i.put(aVar3.e(), aVar3);
                    aVar3.a(bVar2);
                    aVar3.f(cVar);
                }
                c.a.r.e.b bVar3 = new c.a.r.e.b(this.f15268e.f15271b);
                eVar.f15289b = bVar3;
                a.b bVar4 = new a.b();
                bVar4.f15322a = this.f15279g;
                bVar4.f15324c = bVar;
                bVar4.f15323b = aVar;
                List<c.a.r.e.a> a3 = bVar3.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && eVar.f15291d.f40656b != null) {
                    d dVar = new d();
                    dVar.b(eVar.f15291d.f40656b);
                    Iterator<c.a.r.e.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        c.a.r.e.a next = it2.next();
                        d.C0727a a4 = dVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.f15286a) {
                                it2.remove();
                            } else if (a4.f15287b > -1) {
                                next.g(a4.f15287b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, c.a.r.e.a.f15317e);
                a.d dVar2 = new a.d();
                a.e eVar2 = new a.e();
                for (c.a.r.e.a aVar4 : arrayList2) {
                    eVar.f15295h.put(aVar4.c(), aVar4);
                    aVar4.a(bVar4);
                    aVar4.e(dVar2);
                    aVar4.f(eVar2);
                }
                g.C0728a a5 = gVar != null ? gVar.a(Config.SID) : null;
                if (a5 == null || a5.f15299a) {
                    j(eVar, arrayList2);
                }
            } finally {
                hVar.b();
            }
        }
    }

    public final void j(e eVar, List<c.a.r.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, list) == null) {
            List<TrustSubject> list2 = eVar.f15291d.f40655a;
            a.g gVar = new a.g();
            gVar.f15328a = true;
            eVar.f15294g = new j();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<c.a.r.e.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.h b2 = it.next().b(trustSubject.f40634a, gVar);
                        if (b2 != null && b2.d()) {
                            eVar.f15294g.b(trustSubject.f40634a, b2.f15329a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }
}
