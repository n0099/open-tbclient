package c.a.r.e.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r.e.a;
import c.a.r.f.a;
import c.a.r.h.d.a;
import c.a.r.j.a;
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
/* loaded from: classes.dex */
public class a extends c.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f4780g;

    /* renamed from: h  reason: collision with root package name */
    public volatile f f4781h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f4782i;

    /* renamed from: c.a.r.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0234a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4783e;

        public CallableC0234a(a aVar) {
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
            this.f4783e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f4783e;
                aVar.o(aVar.f4781h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4784e;

        public b(a aVar) {
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
            this.f4784e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f4784e;
                aVar.j(aVar.f4781h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f4785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4786f;

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
            this.f4786f = aVar;
            this.f4785e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4786f.f4781h.f4795h == null) {
                    this.f4785e.a(-1, null, null);
                    return;
                }
                this.f4785e.onResult(this.f4786f.f4781h.f4795h.a(), null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f4787e;

        public d(a aVar, a.c cVar) {
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
            this.f4787e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4787e.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, C0235a> a;

        /* renamed from: c.a.r.e.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0235a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;

            /* renamed from: b  reason: collision with root package name */
            public long f4788b;

            public C0235a(boolean z, long j2) {
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
                this.a = z;
                this.f4788b = j2;
            }
        }

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
            this.a = new HashMap();
        }

        public C0235a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (C0235a) invokeL.objValue;
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
                        this.a.put(next, new C0235a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile c.a.r.j.b a;

        /* renamed from: b  reason: collision with root package name */
        public volatile c.a.r.f.b f4789b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f4790c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f4791d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f4792e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Future<Boolean> f4793f;

        /* renamed from: g  reason: collision with root package name */
        public volatile c.a.r.h.d.a f4794g;

        /* renamed from: h  reason: collision with root package name */
        public volatile k f4795h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, c.a.r.f.a> f4796i;

        /* renamed from: j  reason: collision with root package name */
        public volatile Map<String, c.a.r.j.a> f4797j;

        public f() {
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
            this.f4796i = new HashMap();
            this.f4797j = new HashMap();
        }
    }

    /* loaded from: classes.dex */
    public static class g<T> implements a.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a.c<T> a;

        public g(a.c<T> cVar) {
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
            this.a = cVar;
        }

        @Override // c.a.r.j.a.c
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.a.a(i2, exc, bundle);
            }
        }

        @Override // c.a.r.j.a.c
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, C0236a> a;

        /* renamed from: c.a.r.e.c.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0236a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean a;

            public C0236a(boolean z) {
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
                this.a = z;
            }
        }

        public h() {
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
            this.a = new HashMap();
        }

        public C0236a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.get(str) : (C0236a) invokeL.objValue;
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
                        this.a.put(next, new C0236a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a.C0250a a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f4798b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f4799c;

        public i(a.C0250a c0250a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0250a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c0250a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.a.d("lock"));
                    this.f4798b = fileOutputStream;
                    this.f4799c = fileOutputStream.getChannel().lock();
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
                FileLock fileLock = this.f4799c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f4798b;
                        if (fileOutputStream != null) {
                            c.a.r.h.c.a.c.b(fileOutputStream);
                            this.f4798b = null;
                        }
                        this.f4799c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f4798b;
                        if (fileOutputStream2 != null) {
                            c.a.r.h.c.a.c.b(fileOutputStream2);
                            this.f4798b = null;
                        }
                        this.f4799c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f4798b;
                        if (fileOutputStream3 != null) {
                            c.a.r.h.c.a.c.b(fileOutputStream3);
                            this.f4798b = null;
                        }
                        this.f4799c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f4800b;

        /* renamed from: c  reason: collision with root package name */
        public long f4801c;

        public j(String str, String str2, long j2) {
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
            this.a = str;
            this.f4800b = str2;
            this.f4801c = j2;
        }
    }

    /* loaded from: classes.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<j> a;

        public k() {
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
            this.a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (j jVar : this.a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", jVar.a);
                        jSONObject.put("aid", jVar.f4800b);
                        jSONObject.put("priority", jVar.f4801c);
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
                this.a.add(new j(str, str2, j2));
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
                return;
            }
        }
        this.f4782i = new Object();
    }

    @Override // c.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            m(str);
            c.a.r.j.a aVar = this.f4781h.f4797j.get(str);
            if (aVar != null) {
                aVar.g(new g(cVar));
                return;
            }
            if (Config.SID.equals(str)) {
                executorService = this.f4772e.f4776d;
                dVar = new c(this, cVar);
            } else {
                executorService = this.f4772e.f4776d;
                dVar = new d(this, cVar);
            }
            executorService.submit(dVar);
        }
    }

    @Override // c.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i();
        }
    }

    @Override // c.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            n();
            List<TrustSubject> list = this.f4781h.f4791d.a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f4780g = this.f4772e.f4775c;
            this.f4781h = new f();
            this.f4781h.f4792e = this.f4772e.f4776d.submit(new CallableC0234a(this));
        }
    }

    @Override // c.a.r.e.a
    public a.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            m(str);
            c.a.r.j.a aVar = this.f4781h.f4797j.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.f4782i) {
                if (this.f4781h.f4793f != null) {
                    return;
                }
                this.f4781h.f4793f = this.f4772e.f4776d.submit(new b(this));
            }
        }
    }

    public final void j(f fVar) {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            c.a.r.h.d.a aVar = new c.a.r.h.d.a(this.f4780g);
            fVar.f4794g = aVar;
            i iVar = new i(aVar.d().f("init"));
            try {
                iVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.a = this.f4780g;
                aVar2.f34587b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                fVar.f4790c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                fVar.f4791d = trustSubjectManager.query(new TrustSubjectManager.c());
                if (fVar.a == null) {
                    fVar.a = new c.a.r.j.b(this.f4772e.a);
                }
                c.a.r.j.b bVar = fVar.a;
                a.C0251a c0251a = new a.C0251a();
                c0251a.a = this.f4780g;
                c0251a.f4976b = aVar;
                c0251a.f4977c = fVar.f4791d;
                c0251a.f4978d = this.f4772e.f4776d;
                c0251a.f4979e = this.f4772e.f4777e;
                a.b bVar2 = new a.b();
                bVar2.a = false;
                List<c.a.r.j.a> b2 = bVar.b();
                ArrayList<c.a.r.j.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (fVar.f4791d.f34588b != null) {
                    hVar = new h();
                    hVar.b(fVar.f4791d.f34588b);
                } else {
                    hVar = null;
                }
                if (arrayList.size() > 0 && hVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        h.C0236a a = hVar.a(((c.a.r.j.a) it.next()).e());
                        if (a != null && !a.a) {
                            it.remove();
                        }
                    }
                }
                for (c.a.r.j.a aVar3 : arrayList) {
                    fVar.f4797j.put(aVar3.e(), aVar3);
                    aVar3.a(c0251a);
                    aVar3.f(bVar2);
                }
                c.a.r.f.b bVar3 = new c.a.r.f.b(this.f4772e.f4774b);
                fVar.f4789b = bVar3;
                a.C0238a c0238a = new a.C0238a();
                c0238a.a = this.f4780g;
                c0238a.f4816c = bVar;
                c0238a.f4815b = aVar;
                List<c.a.r.f.a> a2 = bVar3.a();
                ArrayList arrayList2 = a2 == null ? new ArrayList() : new ArrayList(a2);
                if (arrayList2.size() > 0 && fVar.f4791d.f34588b != null) {
                    e eVar = new e();
                    eVar.b(fVar.f4791d.f34588b);
                    Iterator<c.a.r.f.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        c.a.r.f.a next = it2.next();
                        e.C0235a a3 = eVar.a(next.c());
                        if (a3 != null) {
                            if (!a3.a) {
                                it2.remove();
                            } else if (a3.f4788b > -1) {
                                next.g(a3.f4788b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, c.a.r.f.a.f4811e);
                a.c cVar = new a.c();
                a.d dVar = new a.d();
                for (c.a.r.f.a aVar4 : arrayList2) {
                    fVar.f4796i.put(aVar4.c(), aVar4);
                    aVar4.a(c0238a);
                    aVar4.e(cVar);
                    aVar4.f(dVar);
                }
                h.C0236a a4 = hVar != null ? hVar.a(Config.SID) : null;
                if (a4 == null || a4.a) {
                    k(fVar, arrayList2);
                }
            } finally {
                iVar.b();
            }
        }
    }

    public final void k(f fVar, List<c.a.r.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fVar, list) == null) {
            List<TrustSubject> list2 = fVar.f4791d.a;
            a.f fVar2 = new a.f();
            fVar2.a = true;
            fVar.f4795h = new k();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<c.a.r.f.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.g b2 = it.next().b(trustSubject.a, fVar2);
                        if (b2 != null && b2.e()) {
                            fVar.f4795h.b(trustSubject.a, b2.a, trustSubject.o());
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.equals(str, "iid")) {
                q();
            } else {
                n();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                i();
                this.f4781h.f4793f.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void o(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            c.a.r.h.d.a aVar = new c.a.r.h.d.a(this.f4780g);
            fVar.f4794g = aVar;
            i iVar = new i(aVar.d().f("init"));
            try {
                iVar.a();
                c.a.r.j.b bVar = new c.a.r.j.b(this.f4772e.a);
                fVar.a = bVar;
                c.a.r.j.a a = bVar.a("iid");
                a.C0251a c0251a = new a.C0251a();
                c0251a.a = this.f4780g;
                c0251a.f4976b = aVar;
                c0251a.f4978d = this.f4772e.f4776d;
                c0251a.f4979e = this.f4772e.f4777e;
                a.b bVar2 = new a.b();
                bVar2.a = false;
                fVar.f4797j.put(a.e(), a);
                a.a(c0251a);
                a.f(bVar2);
            } finally {
                iVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.f4781h.f4792e.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }
}
