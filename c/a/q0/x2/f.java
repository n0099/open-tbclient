package c.a.q0.x2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements q, s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile f f28707h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<c.a.e.e.d.l<String>> f28708a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<c.a.e.e.d.l<String>> f28709b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, k> f28710c;

    /* renamed from: d  reason: collision with root package name */
    public int f28711d;

    /* renamed from: e  reason: collision with root package name */
    public String f28712e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28713f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28714g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f28715e;

        /* renamed from: c.a.q0.x2.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1339a implements l.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f28716a;

            public C1339a(a aVar) {
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
                this.f28716a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.e.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                    return;
                }
                Iterator it = this.f28716a.f28715e.q(str2).iterator();
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    if (kVar != null) {
                        this.f28716a.f28715e.f28710c.put(kVar.f28940a, kVar);
                        this.f28716a.f28715e.f28713f = true;
                    }
                }
            }
        }

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28715e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.e.e.d.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lVar = (c.a.e.e.d.l) this.f28715e.f28708a.get()) == null) {
                return;
            }
            lVar.f(this.f28715e.f28712e, new C1339a(this));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f28717e;

        /* loaded from: classes4.dex */
        public class a implements l.a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f28718a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28718a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.e.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    this.f28718a.f28717e.f28711d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    this.f28718a.f28717e.f28711d = 0;
                }
                this.f28718a.f28717e.f28714g = true;
            }
        }

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28717e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((c.a.e.e.d.l) this.f28717e.f28709b.get()).f(this.f28717e.f28712e, new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<c.a.e.e.d.l<String>> f28719a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28720b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f28721c;

        public /* synthetic */ c(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                Runnable runnable = this.f28721c;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public c(AtomicReference<c.a.e.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28719a = atomicReference;
            this.f28720b = str;
            this.f28721c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                if (this.f28719a.get() != null) {
                    return null;
                }
                synchronized (c.class) {
                    if (this.f28719a.get() == null) {
                        AtomicReference<c.a.e.e.d.l<String>> atomicReference = this.f28719a;
                        c.a.p0.s.r.a.f();
                        atomicReference.set(c.a.p0.s.r.a.g(this.f28720b));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

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
        this.f28708a = new AtomicReference<>(null);
        this.f28709b = new AtomicReference<>(null);
        this.f28713f = false;
        this.f28714g = false;
        this.f28710c = new HashMap<>();
        this.f28711d = 0;
        this.f28712e = r();
    }

    public static f t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f28707h == null) {
                synchronized (f.class) {
                    if (f28707h == null) {
                        f28707h = new f();
                    }
                }
            }
            return f28707h;
        }
        return (f) invokeV.objValue;
    }

    @Override // c.a.q0.x2.s
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (v(r())) {
                return this.f28711d;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.q0.x2.s
    public void b() {
        c.a.e.e.d.l<String> lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lVar = this.f28709b.get()) == null) {
            return;
        }
        p();
        int i2 = this.f28711d + 1;
        this.f28711d = i2;
        lVar.i(this.f28712e, Integer.toString(i2), 86400000L);
    }

    @Override // c.a.q0.x2.s
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f28714g) {
            return;
        }
        b bVar = new b(this);
        if (this.f28709b.get() == null) {
            new c(this.f28709b, "hot.splash.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // c.a.q0.x2.q
    public int d(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) ? s(str, true, z) : invokeLZ.intValue;
    }

    @Override // c.a.q0.x2.q
    public int e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) ? s(str, false, z) : invokeLZ.intValue;
    }

    @Override // c.a.q0.x2.q
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f28713f) {
            return;
        }
        a aVar = new a(this);
        if (this.f28708a.get() == null) {
            new c(this.f28708a, "frs.refresh.count", aVar, null).execute(new Void[0]);
        }
    }

    @Override // c.a.q0.x2.q
    public void g(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 1) {
                u(str, true, z);
            } else if (i2 == 2) {
                u(str, false, z);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String r = r();
            if (v(r)) {
                return;
            }
            this.f28710c.clear();
            this.f28711d = 0;
            this.f28712e = r;
        }
    }

    public final ArrayList<k> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList<k> arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(new k(jSONArray.optJSONObject(i2)));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date()) : (String) invokeV.objValue;
    }

    public final int s(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            k kVar = this.f28710c.get(str);
            if (kVar == null || !v(r())) {
                return 0;
            }
            return kVar.b(z, z2);
        }
        return invokeCommon.intValue;
    }

    public final void u(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            p();
            k kVar = this.f28710c.get(str);
            if (kVar == null) {
                kVar = new k();
                kVar.f28940a = str;
                this.f28710c.put(str, kVar);
            }
            kVar.a(z, z2);
            w(this.f28710c);
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(this.f28712e)) {
                return false;
            }
            return this.f28712e.equals(str);
        }
        return invokeL.booleanValue;
    }

    public final synchronized void w(HashMap<String, k> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) {
            synchronized (this) {
                c.a.e.e.d.l<String> lVar = this.f28708a.get();
                if (lVar == null) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, k> entry : hashMap.entrySet()) {
                    JSONObject c2 = entry.getValue().c();
                    if (c2 != null) {
                        jSONArray.put(c2);
                    }
                }
                lVar.i(this.f28712e, jSONArray.toString(), 86400000L);
            }
        }
    }
}
