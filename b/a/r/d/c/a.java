package b.a.r.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.r.d.a;
import b.a.r.e.a;
import b.a.r.g.d.a;
import b.a.r.h.a;
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
public class a extends b.a.r.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f14358g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f14359h;

    /* renamed from: b.a.r.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC0722a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14360e;

        public CallableC0722a(a aVar) {
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
            this.f14360e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f14360e;
                aVar.i(aVar.f14359h);
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
        public final /* synthetic */ a.c f14361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14362f;

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
            this.f14362f = aVar;
            this.f14361e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f14362f.f14359h.f14373g == null) {
                    this.f14361e.a(-1, null, null);
                    return;
                }
                this.f14361e.onResult(this.f14362f.f14359h.f14373g.a(), null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f14363e;

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
            this.f14363e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14363e.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C0723a> f14364a;

        /* renamed from: b.a.r.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0723a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f14365a;

            /* renamed from: b  reason: collision with root package name */
            public long f14366b;

            public C0723a(boolean z, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14365a = z;
                this.f14366b = j;
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
            this.f14364a = new HashMap();
        }

        public C0723a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f14364a.get(str) : (C0723a) invokeL.objValue;
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
                        this.f14364a.put(next, new C0723a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
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
        public volatile b.a.r.h.b f14367a;

        /* renamed from: b  reason: collision with root package name */
        public volatile b.a.r.e.b f14368b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f14369c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f14370d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f14371e;

        /* renamed from: f  reason: collision with root package name */
        public volatile b.a.r.g.d.a f14372f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f14373g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, b.a.r.e.a> f14374h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, b.a.r.h.a> f14375i;

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
            this.f14374h = new HashMap();
            this.f14375i = new HashMap();
        }
    }

    /* loaded from: classes4.dex */
    public static class f<T> implements a.d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f14376a;

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
            this.f14376a = cVar;
        }

        @Override // b.a.r.h.a.d
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.f14376a.a(i2, exc, bundle);
            }
        }

        @Override // b.a.r.h.a.d
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.f14376a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C0724a> f14377a;

        /* renamed from: b.a.r.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0724a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f14378a;

            public C0724a(boolean z) {
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
                this.f14378a = z;
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
            this.f14377a = new HashMap();
        }

        public C0724a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f14377a.get(str) : (C0724a) invokeL.objValue;
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
                        this.f14377a.put(next, new C0724a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
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
        public a.C0733a f14379a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f14380b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f14381c;

        public h(a.C0733a c0733a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0733a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14379a = c0733a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f14379a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f14379a.d("lock"));
                    this.f14380b = fileOutputStream;
                    this.f14381c = fileOutputStream.getChannel().lock();
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
                FileLock fileLock = this.f14381c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f14380b;
                        if (fileOutputStream != null) {
                            b.a.r.g.c.a.c.b(fileOutputStream);
                            this.f14380b = null;
                        }
                        this.f14381c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f14380b;
                        if (fileOutputStream2 != null) {
                            b.a.r.g.c.a.c.b(fileOutputStream2);
                            this.f14380b = null;
                        }
                        this.f14381c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f14380b;
                        if (fileOutputStream3 != null) {
                            b.a.r.g.c.a.c.b(fileOutputStream3);
                            this.f14380b = null;
                        }
                        this.f14381c = null;
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
        public String f14382a;

        /* renamed from: b  reason: collision with root package name */
        public String f14383b;

        /* renamed from: c  reason: collision with root package name */
        public long f14384c;

        public i(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14382a = str;
            this.f14383b = str2;
            this.f14384c = j;
        }
    }

    /* loaded from: classes4.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<i> f14385a;

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
            this.f14385a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (i iVar : this.f14385a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", iVar.f14382a);
                        jSONObject.put("aid", iVar.f14383b);
                        jSONObject.put("priority", iVar.f14384c);
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception unused) {
                }
                return jSONArray.toString();
            }
            return (String) invokeV.objValue;
        }

        public void b(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
                this.f14385a.add(new i(str, str2, j));
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

    @Override // b.a.r.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            h();
            b.a.r.h.a aVar = this.f14359h.f14375i.get(str);
            if (aVar != null) {
                aVar.g(new f(cVar));
                return;
            }
            if (Config.SID.equals(str)) {
                executorService = this.f14347e.f14352d;
                cVar2 = new b(this, cVar);
            } else {
                executorService = this.f14347e.f14352d;
                cVar2 = new c(this, cVar);
            }
            executorService.submit(cVar2);
        }
    }

    @Override // b.a.r.d.a
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            h();
            List<TrustSubject> list = this.f14359h.f14370d.f38549a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.f38528a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r.d.a
    public void e(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f14358g = this.f14347e.f14351c;
            this.f14359h = new e();
            this.f14359h.f14371e = this.f14347e.f14352d.submit(new CallableC0722a(this));
        }
    }

    @Override // b.a.r.d.a
    public a.d f(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            h();
            b.a.r.h.a aVar = this.f14359h.f14375i.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.f14359h.f14371e.get();
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
            b.a.r.g.d.a aVar = new b.a.r.g.d.a(this.f14358g);
            eVar.f14372f = aVar;
            h hVar = new h(aVar.d().f("init"));
            try {
                hVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.f38546a = this.f14358g;
                aVar2.f38547b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                eVar.f14369c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                eVar.f14370d = trustSubjectManager.query(new TrustSubjectManager.c());
                b.a.r.h.b bVar = new b.a.r.h.b(this.f14347e.f14349a);
                eVar.f14367a = bVar;
                a.b bVar2 = new a.b();
                bVar2.f14560a = this.f14358g;
                bVar2.f14561b = aVar;
                bVar2.f14562c = eVar.f14370d;
                bVar2.f14563d = this.f14347e.f14352d;
                bVar2.f14564e = this.f14347e.f14353e;
                a.c cVar = new a.c();
                cVar.f14565a = false;
                List<b.a.r.h.a> b2 = bVar.b();
                ArrayList<b.a.r.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (eVar.f14370d.f38550b != null) {
                    gVar = new g();
                    gVar.b(eVar.f14370d.f38550b);
                } else {
                    gVar = null;
                }
                if (arrayList.size() > 0 && gVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        g.C0724a a2 = gVar.a(((b.a.r.h.a) it.next()).e());
                        if (a2 != null && !a2.f14378a) {
                            it.remove();
                        }
                    }
                }
                for (b.a.r.h.a aVar3 : arrayList) {
                    eVar.f14375i.put(aVar3.e(), aVar3);
                    aVar3.a(bVar2);
                    aVar3.f(cVar);
                }
                b.a.r.e.b bVar3 = new b.a.r.e.b(this.f14347e.f14350b);
                eVar.f14368b = bVar3;
                a.b bVar4 = new a.b();
                bVar4.f14400a = this.f14358g;
                bVar4.f14402c = bVar;
                bVar4.f14401b = aVar;
                List<b.a.r.e.a> a3 = bVar3.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && eVar.f14370d.f38550b != null) {
                    d dVar = new d();
                    dVar.b(eVar.f14370d.f38550b);
                    Iterator<b.a.r.e.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        b.a.r.e.a next = it2.next();
                        d.C0723a a4 = dVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.f14365a) {
                                it2.remove();
                            } else if (a4.f14366b > -1) {
                                next.g(a4.f14366b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, b.a.r.e.a.f14395e);
                a.d dVar2 = new a.d();
                a.e eVar2 = new a.e();
                for (b.a.r.e.a aVar4 : arrayList2) {
                    eVar.f14374h.put(aVar4.c(), aVar4);
                    aVar4.a(bVar4);
                    aVar4.e(dVar2);
                    aVar4.f(eVar2);
                }
                g.C0724a a5 = gVar != null ? gVar.a(Config.SID) : null;
                if (a5 == null || a5.f14378a) {
                    j(eVar, arrayList2);
                }
            } finally {
                hVar.b();
            }
        }
    }

    public final void j(e eVar, List<b.a.r.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, list) == null) {
            List<TrustSubject> list2 = eVar.f14370d.f38549a;
            a.g gVar = new a.g();
            gVar.f14406a = true;
            eVar.f14373g = new j();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<b.a.r.e.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.h b2 = it.next().b(trustSubject.f38528a, gVar);
                        if (b2 != null && b2.d()) {
                            eVar.f14373g.b(trustSubject.f38528a, b2.f14407a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }
}
