package b.a.r.e.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r.e.a;
import b.a.r.f.a;
import b.a.r.h.d.a;
import b.a.r.j.a;
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
public class a extends b.a.r.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public Context f15128g;

    /* renamed from: h  reason: collision with root package name */
    public volatile f f15129h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f15130i;

    /* renamed from: b.a.r.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class CallableC0758a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15131e;

        public CallableC0758a(a aVar) {
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
            this.f15131e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f15131e;
                aVar.o(aVar.f15129h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15132e;

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
            this.f15132e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = this.f15132e;
                aVar.j(aVar.f15129h);
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f15133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15134f;

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
            this.f15134f = aVar;
            this.f15133e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f15134f.f15129h.f15146h == null) {
                    this.f15133e.a(-1, null, null);
                    return;
                }
                this.f15133e.onResult(this.f15134f.f15129h.f15146h.a(), null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f15135e;

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
            this.f15135e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15135e.a(-1, null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C0759a> f15136a;

        /* renamed from: b.a.r.e.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0759a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f15137a;

            /* renamed from: b  reason: collision with root package name */
            public long f15138b;

            public C0759a(boolean z, long j) {
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
                this.f15137a = z;
                this.f15138b = j;
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
            this.f15136a = new HashMap();
        }

        public C0759a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f15136a.get(str) : (C0759a) invokeL.objValue;
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
                        this.f15136a.put(next, new C0759a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile b.a.r.j.b f15139a;

        /* renamed from: b  reason: collision with root package name */
        public volatile b.a.r.f.b f15140b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f15141c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f15142d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f15143e;

        /* renamed from: f  reason: collision with root package name */
        public volatile Future<Boolean> f15144f;

        /* renamed from: g  reason: collision with root package name */
        public volatile b.a.r.h.d.a f15145g;

        /* renamed from: h  reason: collision with root package name */
        public volatile k f15146h;

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, b.a.r.f.a> f15147i;
        public volatile Map<String, b.a.r.j.a> j;

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
            this.f15147i = new HashMap();
            this.j = new HashMap();
        }
    }

    /* loaded from: classes4.dex */
    public static class g<T> implements a.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f15148a;

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
            this.f15148a = cVar;
        }

        @Override // b.a.r.j.a.c
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.f15148a.a(i2, exc, bundle);
            }
        }

        @Override // b.a.r.j.a.c
        public void onResult(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                this.f15148a.onResult(t, bundle);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C0760a> f15149a;

        /* renamed from: b.a.r.e.c.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0760a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f15150a;

            public C0760a(boolean z) {
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
                this.f15150a = z;
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
            this.f15149a = new HashMap();
        }

        public C0760a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f15149a.get(str) : (C0760a) invokeL.objValue;
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
                        this.f15149a.put(next, new C0760a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a.C0774a f15151a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f15152b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f15153c;

        public i(a.C0774a c0774a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0774a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15151a = c0774a;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f15151a.a();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f15151a.d("lock"));
                    this.f15152b = fileOutputStream;
                    this.f15153c = fileOutputStream.getChannel().lock();
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
                FileLock fileLock = this.f15153c;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                        FileOutputStream fileOutputStream = this.f15152b;
                        if (fileOutputStream != null) {
                            b.a.r.h.c.a.c.b(fileOutputStream);
                            this.f15152b = null;
                        }
                        this.f15153c = null;
                        return true;
                    } catch (IOException unused) {
                        FileOutputStream fileOutputStream2 = this.f15152b;
                        if (fileOutputStream2 != null) {
                            b.a.r.h.c.a.c.b(fileOutputStream2);
                            this.f15152b = null;
                        }
                        this.f15153c = null;
                        return false;
                    } catch (Throwable th) {
                        FileOutputStream fileOutputStream3 = this.f15152b;
                        if (fileOutputStream3 != null) {
                            b.a.r.h.c.a.c.b(fileOutputStream3);
                            this.f15152b = null;
                        }
                        this.f15153c = null;
                        throw th;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f15154a;

        /* renamed from: b  reason: collision with root package name */
        public String f15155b;

        /* renamed from: c  reason: collision with root package name */
        public long f15156c;

        public j(String str, String str2, long j) {
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
            this.f15154a = str;
            this.f15155b = str2;
            this.f15156c = j;
        }
    }

    /* loaded from: classes4.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<j> f15157a;

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
            this.f15157a = new ArrayList();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (j jVar : this.f15157a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pkg", jVar.f15154a);
                        jSONObject.put("aid", jVar.f15155b);
                        jSONObject.put("priority", jVar.f15156c);
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
                this.f15157a.add(new j(str, str2, j));
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
        this.f15130i = new Object();
    }

    @Override // b.a.r.e.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            m(str);
            b.a.r.j.a aVar = this.f15129h.j.get(str);
            if (aVar != null) {
                aVar.g(new g(cVar));
                return;
            }
            if (Config.SID.equals(str)) {
                executorService = this.f15117e.f15122d;
                dVar = new c(this, cVar);
            } else {
                executorService = this.f15117e.f15122d;
                dVar = new d(this, cVar);
            }
            executorService.submit(dVar);
        }
    }

    @Override // b.a.r.e.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i();
        }
    }

    @Override // b.a.r.e.a
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            n();
            List<TrustSubject> list = this.f15129h.f15142d.f39381a;
            if (list != null) {
                for (TrustSubject trustSubject : list) {
                    if (trustSubject.f39360a.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r.e.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f15128g = this.f15117e.f15121c;
            this.f15129h = new f();
            this.f15129h.f15143e = this.f15117e.f15122d.submit(new CallableC0758a(this));
        }
    }

    @Override // b.a.r.e.a
    public a.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            m(str);
            b.a.r.j.a aVar = this.f15129h.j.get(str);
            return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
        }
        return (a.d) invokeLL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.f15130i) {
                if (this.f15129h.f15144f != null) {
                    return;
                }
                this.f15129h.f15144f = this.f15117e.f15122d.submit(new b(this));
            }
        }
    }

    public final void j(f fVar) {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            b.a.r.h.d.a aVar = new b.a.r.h.d.a(this.f15128g);
            fVar.f15145g = aVar;
            i iVar = new i(aVar.d().f("init"));
            try {
                iVar.a();
                TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
                aVar2.f39378a = this.f15128g;
                aVar2.f39379b = aVar;
                TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
                fVar.f15141c = trustSubjectManager;
                trustSubjectManager.f(aVar2);
                trustSubjectManager.i(new TrustSubjectManager.b());
                fVar.f15142d = trustSubjectManager.query(new TrustSubjectManager.c());
                if (fVar.f15139a == null) {
                    fVar.f15139a = new b.a.r.j.b(this.f15117e.f15119a);
                }
                b.a.r.j.b bVar = fVar.f15139a;
                a.C0775a c0775a = new a.C0775a();
                c0775a.f15385a = this.f15128g;
                c0775a.f15386b = aVar;
                c0775a.f15387c = fVar.f15142d;
                c0775a.f15388d = this.f15117e.f15122d;
                c0775a.f15389e = this.f15117e.f15123e;
                a.b bVar2 = new a.b();
                bVar2.f15390a = false;
                List<b.a.r.j.a> b2 = bVar.b();
                ArrayList<b.a.r.j.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
                if (fVar.f15142d.f39382b != null) {
                    hVar = new h();
                    hVar.b(fVar.f15142d.f39382b);
                } else {
                    hVar = null;
                }
                if (arrayList.size() > 0 && hVar != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        h.C0760a a2 = hVar.a(((b.a.r.j.a) it.next()).e());
                        if (a2 != null && !a2.f15150a) {
                            it.remove();
                        }
                    }
                }
                for (b.a.r.j.a aVar3 : arrayList) {
                    fVar.j.put(aVar3.e(), aVar3);
                    aVar3.a(c0775a);
                    aVar3.f(bVar2);
                }
                b.a.r.f.b bVar3 = new b.a.r.f.b(this.f15117e.f15120b);
                fVar.f15140b = bVar3;
                a.C0762a c0762a = new a.C0762a();
                c0762a.f15172a = this.f15128g;
                c0762a.f15174c = bVar;
                c0762a.f15173b = aVar;
                List<b.a.r.f.a> a3 = bVar3.a();
                ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
                if (arrayList2.size() > 0 && fVar.f15142d.f39382b != null) {
                    e eVar = new e();
                    eVar.b(fVar.f15142d.f39382b);
                    Iterator<b.a.r.f.a> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        b.a.r.f.a next = it2.next();
                        e.C0759a a4 = eVar.a(next.c());
                        if (a4 != null) {
                            if (!a4.f15137a) {
                                it2.remove();
                            } else if (a4.f15138b > -1) {
                                next.g(a4.f15138b);
                            }
                        }
                    }
                }
                Collections.sort(arrayList2, b.a.r.f.a.f15167e);
                a.c cVar = new a.c();
                a.d dVar = new a.d();
                for (b.a.r.f.a aVar4 : arrayList2) {
                    fVar.f15147i.put(aVar4.c(), aVar4);
                    aVar4.a(c0762a);
                    aVar4.e(cVar);
                    aVar4.f(dVar);
                }
                h.C0760a a5 = hVar != null ? hVar.a(Config.SID) : null;
                if (a5 == null || a5.f15150a) {
                    k(fVar, arrayList2);
                }
            } finally {
                iVar.b();
            }
        }
    }

    public final void k(f fVar, List<b.a.r.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fVar, list) == null) {
            List<TrustSubject> list2 = fVar.f15142d.f39381a;
            a.f fVar2 = new a.f();
            fVar2.f15178a = true;
            fVar.f15146h = new k();
            if (list2 != null) {
                for (TrustSubject trustSubject : list2) {
                    Iterator<b.a.r.f.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a.g b2 = it.next().b(trustSubject.f39360a, fVar2);
                        if (b2 != null && b2.e()) {
                            fVar.f15146h.b(trustSubject.f39360a, b2.f15180a, trustSubject.o());
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
                this.f15129h.f15144f.get();
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
            b.a.r.h.d.a aVar = new b.a.r.h.d.a(this.f15128g);
            fVar.f15145g = aVar;
            i iVar = new i(aVar.d().f("init"));
            try {
                iVar.a();
                b.a.r.j.b bVar = new b.a.r.j.b(this.f15117e.f15119a);
                fVar.f15139a = bVar;
                b.a.r.j.a a2 = bVar.a("iid");
                a.C0775a c0775a = new a.C0775a();
                c0775a.f15385a = this.f15128g;
                c0775a.f15386b = aVar;
                c0775a.f15388d = this.f15117e.f15122d;
                c0775a.f15389e = this.f15117e.f15123e;
                a.b bVar2 = new a.b();
                bVar2.f15390a = false;
                fVar.j.put(a2.e(), a2);
                a2.a(c0775a);
                a2.f(bVar2);
            } finally {
                iVar.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                this.f15129h.f15143e.get();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            } catch (ExecutionException e3) {
                throw new RuntimeException(e3);
            }
        }
    }
}
