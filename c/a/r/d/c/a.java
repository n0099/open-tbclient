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
/* loaded from: classes4.dex */
public class a extends c.a.r.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f29417g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f29418h;

    /* renamed from: c.a.r.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC1368a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29419e;

        public CallableC1368a(a aVar) {
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
            this.f29419e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f29419e;
                aVar.i(aVar.f29418h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f29420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29421f;

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
            this.f29421f = aVar;
            this.f29420e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29421f.f29418h.f29432g == null) {
                    this.f29420e.a(-1, null, null);
                    return;
                }
                this.f29420e.onResult(this.f29421f.f29418h.f29432g.a(), null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f29422e;

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
            this.f29422e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29422e.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1369a> f29423a;

        /* renamed from: c.a.r.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1369a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f29424a;

            /* renamed from: b  reason: collision with root package name */
            public long f29425b;

            public C1369a(boolean z, long j2) {
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
                this.f29424a = z;
                this.f29425b = j2;
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
            this.f29423a = new HashMap();
        }

        public C1369a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f29423a.get(str) : (C1369a) invokeL.objValue;
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
                        this.f29423a.put(next, new C1369a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile c.a.r.h.b f29426a;

        /* renamed from: b  reason: collision with root package name */
        public volatile c.a.r.e.b f29427b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f29428c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f29429d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f29430e;

        /* renamed from: f  reason: collision with root package name */
        public volatile c.a.r.g.d.a f29431f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f29432g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, c.a.r.e.a> f29433h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, c.a.r.h.a> f29434i;

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
            this.f29433h = new HashMap();
            this.f29434i = new HashMap();
        }
    }

    /* loaded from: classes4.dex */
    public static class f<T> implements a.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f29435a;

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
            this.f29435a = cVar;
        }

        @Override // c.a.r.h.a.d
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.f29435a.a(i2, exc, bundle);
            }
        }

        @Override // c.a.r.h.a.d
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.f29435a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1370a> f29436a;

        /* renamed from: c.a.r.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C1370a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f29437a;

            public C1370a(boolean z) {
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
                this.f29437a = z;
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
            this.f29436a = new HashMap();
        }

        public C1370a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f29436a.get(str) : (C1370a) invokeL.objValue;
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
                        this.f29436a.put(next, new C1370a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C1379a f29438a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f29439b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f29440c;

        public h(a.C1379a c1379a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1379a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29438a = c1379a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f29438a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f29438a.d("lock"));
                    this.f29439b = fileOutputStream;
                    this.f29440c = fileOutputStream.getChannel().lock();
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
                FileLock fileLock = this.f29440c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f29439b;
                        if (fileOutputStream != null) {
                            c.a.r.g.c.a.c.b(fileOutputStream);
                            this.f29439b = null;
                        }
                        this.f29440c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f29439b;
                        if (fileOutputStream2 != null) {
                            c.a.r.g.c.a.c.b(fileOutputStream2);
                            this.f29439b = null;
                        }
                        this.f29440c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f29439b;
                        if (fileOutputStream3 != null) {
                            c.a.r.g.c.a.c.b(fileOutputStream3);
                            this.f29439b = null;
                        }
                        this.f29440c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f29441a;

        /* renamed from: b  reason: collision with root package name */
        public String f29442b;

        /* renamed from: c  reason: collision with root package name */
        public long f29443c;

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
            this.f29441a = str;
            this.f29442b = str2;
            this.f29443c = j2;
        }
    }

    /* loaded from: classes4.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f29444a;

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
            this.f29444a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (i iVar : this.f29444a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", iVar.f29441a);
                        jSONObject.put("aid", iVar.f29442b);
                        jSONObject.put("priority", iVar.f29443c);
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
                this.f29444a.add(new i(str, str2, j2));
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
            c.a.r.h.a aVar = this.f29418h.f29434i.get(str);
            if (aVar != null) {
                aVar.g(new f(cVar));
                return;
            }
            if (Config.SID.equals(str)) {
                executorService = this.f29406e.f29411d;
                cVar2 = new b(this, cVar);
            } else {
                executorService = this.f29406e.f29411d;
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
            List<TrustSubject> list = this.f29418h.f29429d.f40478a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.f40457a.equals(str)) {
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
            this.f29417g = this.f29406e.f29410c;
            this.f29418h = new e();
            this.f29418h.f29430e = this.f29406e.f29411d.submit(new CallableC1368a(this));
        }
    }

    @Override // c.a.r.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            h();
            c.a.r.h.a aVar = this.f29418h.f29434i.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.f29418h.f29430e.get();
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
            c.a.r.g.d.a aVar = new c.a.r.g.d.a(this.f29417g);
            eVar.f29431f = aVar;
            h hVar = new h(aVar.d().f("init"));
            try {
                hVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.f40475a = this.f29417g;
                aVar2.f40476b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                eVar.f29428c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                eVar.f29429d = trustSubjectManager.j(new TrustSubjectManager.c());
                c.a.r.h.b bVar = new c.a.r.h.b(this.f29406e.f29408a);
                eVar.f29426a = bVar;
                a.b bVar2 = new a.b();
                bVar2.f29620a = this.f29417g;
                bVar2.f29621b = aVar;
                bVar2.f29622c = eVar.f29429d;
                bVar2.f29623d = this.f29406e.f29411d;
                bVar2.f29624e = this.f29406e.f29412e;
                a.c cVar = new a.c();
                cVar.f29625a = false;
                List<c.a.r.h.a> b2 = bVar.b();
                ArrayList<c.a.r.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (eVar.f29429d.f40479b != null) {
                    gVar = new g();
                    gVar.b(eVar.f29429d.f40479b);
                } else {
                    gVar = null;
                }
                if (arrayList.size() > 0 && gVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        g.C1370a a2 = gVar.a(((c.a.r.h.a) it.next()).e());
                        if (a2 != null && !a2.f29437a) {
                            it.remove();
                        }
                    }
                }
                for (c.a.r.h.a aVar3 : arrayList) {
                    eVar.f29434i.put(aVar3.e(), aVar3);
                    aVar3.a(bVar2);
                    aVar3.f(cVar);
                }
                c.a.r.e.b bVar3 = new c.a.r.e.b(this.f29406e.f29409b);
                eVar.f29427b = bVar3;
                a.b bVar4 = new a.b();
                bVar4.f29460a = this.f29417g;
                bVar4.f29462c = bVar;
                bVar4.f29461b = aVar;
                List<c.a.r.e.a> a3 = bVar3.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && eVar.f29429d.f40479b != null) {
                    d dVar = new d();
                    dVar.b(eVar.f29429d.f40479b);
                    Iterator<c.a.r.e.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        c.a.r.e.a next = it2.next();
                        d.C1369a a4 = dVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.f29424a) {
                                it2.remove();
                            } else if (a4.f29425b > -1) {
                                next.g(a4.f29425b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, c.a.r.e.a.f29455e);
                a.d dVar2 = new a.d();
                a.e eVar2 = new a.e();
                for (c.a.r.e.a aVar4 : arrayList2) {
                    eVar.f29433h.put(aVar4.c(), aVar4);
                    aVar4.a(bVar4);
                    aVar4.e(dVar2);
                    aVar4.f(eVar2);
                }
                g.C1370a a5 = gVar != null ? gVar.a(Config.SID) : null;
                if (a5 == null || a5.f29437a) {
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
            List<TrustSubject> list2 = eVar.f29429d.f40478a;
            a.g gVar = new a.g();
            gVar.f29466a = true;
            eVar.f29432g = new j();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<c.a.r.e.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.h b2 = it.next().b(trustSubject.f40457a, gVar);
                        if (b2 != null && b2.d()) {
                            eVar.f29432g.b(trustSubject.f40457a, b2.f29467a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }
}
