package c.a.r;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.r.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f15253e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15254a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r.d.a f15255b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r.d.b f15256c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f15257d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r.c f15258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Looper f15259f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f15260g;

        public a(b bVar, c.a.r.c cVar, Looper looper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15260g = bVar;
            this.f15258e = cVar;
            this.f15259f = looper;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.d f2 = this.f15260g.f15255b.f("aid", null);
                d dVar = new d(this.f15258e, this.f15259f);
                if (f2.b()) {
                    dVar.b(f2.f15275a, null);
                } else {
                    dVar.a(f2.f15276b, f2.f15277c, null);
                }
            }
        }
    }

    /* renamed from: c.a.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0724b implements a.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15261a;

        public C0724b(b bVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15261a = dVar;
        }

        @Override // c.a.r.d.a.c
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.f15261a.a(i2, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r.d.a.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.f15261a.b(e.a(str), bundle);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15262a;

        public c(b bVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15262a = dVar;
        }

        @Override // c.a.r.d.a.c
        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                this.f15262a.a(i2, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r.d.a.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.f15262a.b(str, bundle);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d<T> extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.r.c<T> f15263a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c.a.r.c<T> cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15263a = cVar;
        }

        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                obtainMessage(1, i2, 0, Pair.create(exc, bundle)).sendToTarget();
            }
        }

        public void b(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.a.r.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    Pair pair = (Pair) message.obj;
                    this.f15263a.onResult(pair.first, (Bundle) pair.second);
                } else if (i2 != 1) {
                } else {
                    Pair pair2 = (Pair) message.obj;
                    this.f15263a.onError(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<f> f15264a;

        public e(List<f> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f15264a = arrayList;
            arrayList.addAll(list);
        }

        public static e a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        arrayList.add(new f(jSONObject.getString("pkg"), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                    }
                    return new e(arrayList);
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public List<f> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15264a : (List) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "sids {" + this.f15264a + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f15265a;

        /* renamed from: b  reason: collision with root package name */
        public final String f15266b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15267c;

        public f(String str, String str2, long j2) {
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
            this.f15265a = str;
            this.f15266b = str2;
            this.f15267c = j2;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "aid {packageName='" + this.f15265a + ExtendedMessageFormat.QUOTE + ", aid='" + this.f15266b + ExtendedMessageFormat.QUOTE + ", priority=" + this.f15267c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15254a = context.getApplicationContext();
        c.a.r.d.b bVar = new c.a.r.d.b(new c.a.r.i.a());
        this.f15256c = bVar;
        this.f15255b = bVar.a();
        a.C0725a c0725a = new a.C0725a();
        c0725a.f15270a = new c.a.r.i.c();
        c0725a.f15271b = new c.a.r.i.b();
        c0725a.f15272c = this.f15254a;
        c0725a.f15273d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c0725a.f15274e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f15257d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f15255b.b(c0725a);
        this.f15255b.c(new a.b());
    }

    public static synchronized b e(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (b.class) {
                if (f15253e == null) {
                    f15253e = new b(context.getApplicationContext());
                }
                bVar = f15253e;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15255b.f("aid", null).f15275a : (String) invokeV.objValue;
    }

    public c.a.r.d.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15255b : (c.a.r.d.a) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15255b.f("iid", null).f15275a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15255b.f("oid", null).f15275a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15255b.f(Config.SSAID, null).f15275a : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f15255b.d(this.f15254a.getPackageName()) : invokeV.booleanValue;
    }

    public void i(c.a.r.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            j(cVar, Looper.getMainLooper());
        }
    }

    public void j(c.a.r.c<String> cVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, looper) == null) {
            this.f15257d.submit(new a(this, cVar, looper));
        }
    }

    public void k(c.a.r.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            l(Config.GAID, cVar, Looper.getMainLooper());
        }
    }

    public final void l(String str, c.a.r.c<String> cVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, cVar, looper) == null) {
            this.f15255b.a(str, null, new c(this, new d(cVar, looper)));
        }
    }

    public void m(c.a.r.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            l("oid", cVar, Looper.getMainLooper());
        }
    }

    public void n(c.a.r.c<e> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            o(cVar, Looper.getMainLooper());
        }
    }

    public void o(c.a.r.c<e> cVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, cVar, looper) == null) {
            this.f15255b.a(Config.SID, null, new C0724b(this, new d(cVar, looper)));
        }
    }
}
