package c.a.t0;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.i0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long f25925b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25926c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25927d;

    /* renamed from: e  reason: collision with root package name */
    public y f25928e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.b f25929f;

    /* renamed from: g  reason: collision with root package name */
    public int f25930g;

    /* renamed from: h  reason: collision with root package name */
    public long f25931h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f25932i;

    /* renamed from: j  reason: collision with root package name */
    public long f25933j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public u p;
    public g q;
    public int r;
    public int s;
    public int t;
    public i0 u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25934e;

        public a(c cVar) {
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
            this.f25934e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25934e.f25930g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f25934e.f25931h;
                    if (uptimeMillis >= 5000) {
                        if (c.y) {
                            String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis));
                        }
                        this.f25934e.z();
                        this.f25934e.f25930g = 0;
                        return;
                    }
                    c.a.t0.d.w().J(this, 5000 - uptimeMillis);
                } else if (this.f25934e.f25930g == 2) {
                    this.f25934e.f25930g = 0;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
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

        @Override // c.a.t0.t
        public void a(boolean z, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, nVar) == null) {
                if (!z) {
                    this.a.f25928e.z(nVar);
                    return;
                }
                this.a.f25928e.h();
                x.f().a(nVar.l(), false);
            }
        }
    }

    /* renamed from: c.a.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1581c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public n f25935b;

        /* renamed from: c  reason: collision with root package name */
        public File f25936c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f25937d;

        /* renamed from: e  reason: collision with root package name */
        public String f25938e;

        /* renamed from: f  reason: collision with root package name */
        public long f25939f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25940g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f25941h;

        /* renamed from: i  reason: collision with root package name */
        public t f25942i;

        public C1581c() {
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
            this.a = true;
            this.f25935b = null;
            this.f25936c = null;
            this.f25937d = null;
            this.f25938e = null;
            this.f25939f = -1L;
            this.f25940g = false;
            this.f25941h = false;
            this.f25942i = null;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
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
                }
            }
        }

        @Override // c.a.t0.i0.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.t0.d.w().P();
                c.a.t0.d.w().K();
            }
        }

        @Override // c.a.t0.i0.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.t0.d.w().P();
                c.a.t0.d.w().K();
                c.a.t0.d.w().E();
            }
        }

        @Override // c.a.t0.i0.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.t0.d.w().K();
            }
        }

        @Override // c.a.t0.i0.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                c.a.t0.d.w().P();
                c.a.t0.d.w().K();
                c.a.t0.d.w().E();
            }
        }

        @Override // c.a.t0.i0.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                c.a.t0.d.w().P();
                c.a.t0.d.w().K();
                c.a.t0.d.w().E();
            }
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905157, "Lc/a/t0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905157, "Lc/a/t0/c;");
                return;
            }
        }
        y = b0.m();
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25926c = false;
        this.f25930g = 0;
        this.f25931h = 0L;
        this.x = new a(this);
        this.f25927d = context;
        k0 a2 = k0.a();
        this.f25928e = new y(context);
        this.f25929f = new c.a.t0.b(context);
        this.p = b0.j();
        this.f25932i = new ArrayList(20);
        this.f25933j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        g o = g.o();
        this.q = o;
        o.D(this, context);
        this.f25925b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = g.o().I();
        this.w = g.o().x();
        x.f().g(this.f25928e);
        i0 m = i0.m();
        this.u = m;
        m.n(this.f25927d, this.f25928e, new d(this, null));
    }

    public void A(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nVar) == null) {
            boolean equals = TextUtils.equals(nVar.l(), nVar.k());
            boolean z = (equals && (this.q.e(nVar.l()) && (nVar.n() & 64) == 0)) || (equals && ((nVar.n() & 128) != 0));
            if (b0.i().d()) {
                if (!z) {
                    this.f25928e.z(nVar);
                    return;
                }
                List<String> j2 = b0.i().j();
                if (j2 != null && j2.contains(nVar.l())) {
                    if (!this.f25926c) {
                        if ((System.currentTimeMillis() - this.f25925b) / 1000 >= this.a) {
                            this.f25926c = true;
                        } else {
                            this.f25928e.z(nVar);
                            return;
                        }
                    }
                } else {
                    this.f25928e.z(nVar);
                    return;
                }
            }
            if (z && !V(nVar)) {
                if (this.q.K(nVar.l())) {
                    this.f25928e.z(nVar);
                    return;
                }
                return;
            }
            if (z) {
                x.f().a(nVar.l(), false);
            }
            if (b0.i().d()) {
                this.f25928e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.f25933j) >= g.o().t()) {
                if (!z && this.q.K(nVar.l())) {
                    g(nVar);
                }
                U();
            } else if ((nVar.n() & 1) == 0) {
                if (!z && this.q.K(nVar.l())) {
                    g(nVar);
                }
                if (this.f25932i.size() >= 20) {
                    z();
                }
            } else if (z || !this.q.K(nVar.l())) {
            } else {
                this.f25928e.z(nVar);
            }
        }
    }

    public void B(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar) == null) {
            this.f25929f.g(nVar, this.q.e(nVar.l()));
        }
    }

    public void C(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nVar) == null) && c.a.i0.b.a.a.g()) {
            this.f25929f.i(nVar);
        }
    }

    public final void D(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String str3 = this.f25927d.getFilesDir() + File.separator + "ubcsenddir";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(str3, str2);
            if (file2.exists()) {
                return;
            }
            OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStream = new Base64OutputStream(fileOutputStream, 0);
                outputStream.write(str.getBytes());
                outputStream.flush();
                a0.b("save to file suc");
                try {
                    outputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                outputStream = fileOutputStream;
                if (y) {
                    e.printStackTrace();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        e = e5;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        if (y) {
                            e6.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && j0.a(this.f25927d)) {
            if (this.n == null) {
                r();
            }
            l0 h2 = l0.h(this.f25927d);
            if (!x.f().d(h2) || h2 == null || h2.y()) {
                return;
            }
            h2.L(true);
            J(h2);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l0 i2 = l0.i();
            if (this.f25929f.e(i2)) {
                JSONObject u = i2.u();
                if (y) {
                    String str = "sendQualityData:" + u.toString();
                }
                c.a.t0.d.w().R(u);
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            l0 i2 = l0.i();
            i2.L(z);
            if (this.f25929f.f(i2, z)) {
                JSONObject u = i2.u();
                if (y) {
                    String str = "checkFileData:" + u.toString();
                }
                this.f25929f.c(z);
                c.a.t0.d.w().R(u);
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25928e.C();
        }
    }

    public void I(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f25928e.B(pVar);
        }
    }

    public final void J(l0 l0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, l0Var) == null) {
            l0Var.k();
            if (l0Var.y()) {
                return;
            }
            if (l0Var.x()) {
                str = l0Var.p();
            } else {
                try {
                    JSONObject u = l0Var.u();
                    String c2 = j0.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        a0.a(l0Var);
                        String str2 = "save send data to file " + c2;
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    l0Var.e();
                    return;
                }
            }
            if (!this.f25928e.g(l0Var, str)) {
                l0Var.e();
                File file = new File(this.f25927d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists()) {
                    file.delete();
                }
                this.f25928e.l(str);
                return;
            }
            d0.a().m(l0Var.B(), l0Var.v());
            c.a.t0.d.w().Q(l0Var, str);
            l0Var.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < MainTabActivity.SERVICE_BETWEEN_TIME) {
                return;
            }
            this.l = currentTimeMillis;
            k0.a().e("ubc_last_upload_failed_data_time", this.l);
            c.a.t0.d.w().E();
            c.a.t0.d.w().K();
        }
    }

    public void K(w wVar, boolean z, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(wVar, z, jSONArray);
            s(wVar, z, jSONArray);
            if (sVar != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    jSONObject.put("count", (this.r + this.s + this.t) + "," + this.r + "," + this.t);
                    sVar.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e2) {
                    if (y) {
                        e2.printStackTrace();
                    }
                }
            }
            this.q.Y(wVar.b());
            this.q.P(wVar.i() * 86400000);
            this.q.Q(wVar.h());
            this.q.R(wVar.c());
            this.q.U(wVar.f());
            this.q.T(wVar.e());
            this.q.S(wVar.d());
            this.q.W(wVar.j());
            this.q.X(wVar.k());
            SparseArray<ArrayList> sparseArray = this.n;
            if (sparseArray == null) {
                this.n = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            HashMap<String, Long> hashMap = this.o;
            if (hashMap == null) {
                this.o = new HashMap<>();
            } else {
                hashMap.clear();
            }
            this.f25928e.x(this.n);
            if (y) {
                String str = "mIdArray: " + this.n.toString();
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                this.o.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i2);
            wVar.b().clear();
        }
    }

    public void L(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i2, str2) == null) {
            this.f25928e.E(str, i2, str2);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && j0.a(this.f25927d)) {
            l0 h2 = l0.h(this.f25927d);
            int p = this.q.p();
            h2.L(false);
            if (this.v) {
                h2.M(this.w);
                this.f25928e.b(h2);
            } else {
                h2.M(p);
                this.f25928e.a(h2);
            }
            int v = h2.v();
            if (v > 0) {
                if (y) {
                    String str = "uploadBackLog size=" + v;
                }
                J(h2);
            }
        }
    }

    public final void N(C1581c c1581c) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, c1581c) == null) || c1581c == null) {
            return;
        }
        if (i0.m().p() && !j0.a(this.f25927d)) {
            c.a.t0.d.w().V(c1581c.f25938e, false);
            return;
        }
        if (c1581c.a) {
            a2 = this.p.b(c1581c.f25936c, c1581c.f25939f, c1581c.f25940g, c1581c.f25941h);
        } else {
            a2 = this.p.a(c1581c.f25937d, c1581c.f25940g, c1581c.f25941h);
        }
        t tVar = c1581c.f25942i;
        if (tVar != null) {
            tVar.a(a2, c1581c.f25935b);
        }
        if (TextUtils.isEmpty(c1581c.f25938e)) {
            return;
        }
        c.a.t0.d.w().V(c1581c.f25938e, a2);
    }

    public void O(o oVar) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, oVar) == null) || oVar == null) {
            return;
        }
        String a2 = oVar.a();
        File file = new File(this.f25927d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (!file.exists()) {
            return;
        }
        if (oVar.c()) {
            c.a.t0.d.w().Q(l0.g(file, (int) file.length()), a2);
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                if (y) {
                    String str = "uploadFile fileName:" + a2;
                }
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    JSONObject jSONObject = new JSONObject(c.a.t0.q0.e.b(inputStream));
                    JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                    jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                    jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                    c.a.t0.d.w().S(jSONObject, a2);
                    fileInputStream = inputStream;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = fileInputStream;
                if (y) {
                    String str2 = "error:" + e.getMessage();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (OutOfMemoryError e5) {
                e = e5;
                inputStream = fileInputStream;
                if (y) {
                    String str3 = "OutOfMemoryError:" + e.getMessage();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e = e6;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        if (y) {
                            e7.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
        } catch (OutOfMemoryError e9) {
            e = e9;
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (y) {
                String str2 = "upload file fail:" + str;
            }
            a0.b("upload file fail");
            this.f25928e.F(str);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.f25927d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                String str2 = "deleteUploadFile file:" + file.getAbsolutePath();
            }
            a0.b("delete file");
            if (file.exists() && file.delete()) {
                a0.b("delete file suc");
            }
            this.f25928e.l(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && j0.a(this.f25927d) && j()) {
            l0 h2 = l0.h(this.f25927d);
            h2.L(true);
            h2.C();
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            this.f25928e.r(arrayList, true, h2);
            J(h2);
            y();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && j0.a(this.f25927d)) {
            this.f25928e.e();
            l0 h2 = l0.h(this.f25927d);
            int p = this.q.p();
            h2.M(p);
            h2.L(true);
            l0 h3 = l0.h(this.f25927d);
            h3.M(p);
            h3.L(false);
            this.f25928e.n(h2, h3);
            int v = h2.v();
            int v2 = h3.v();
            if (y) {
                String str = "real size = " + v + "   no real  = " + v2;
            }
            if (v > 0) {
                if (h2.z()) {
                    d0.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
                }
                J(h2);
            }
            if (v2 > 0) {
                if (h3.z()) {
                    d0.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
                }
                J(h3);
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, l0 l0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, sparseArray, l0Var) == null) || sparseArray == null) {
            return;
        }
        boolean H = this.q.H();
        boolean G = this.q.G();
        int m = this.q.m();
        if (H && !G && sparseArray.get(m, null) == null) {
            sparseArray.put(m, new ArrayList(0));
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < sparseArray.size() && !l0Var.d(51200); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            if (keyAt == 0) {
                if (H && G) {
                    this.f25928e.r(new ArrayList<>(this.q.u()), false, l0Var);
                } else {
                    this.f25928e.r(sparseArray.valueAt(i2), true, l0Var);
                }
            } else if (this.v) {
                l0Var.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.f25928e.t(o, false, l0Var);
                    }
                } else {
                    this.f25928e.t(sparseArray.valueAt(i2), true, l0Var);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.f25928e.r(o2, false, l0Var);
                }
            } else {
                this.f25928e.r(sparseArray.valueAt(i2), true, l0Var);
            }
            if (l0Var.w()) {
                break;
            }
        }
        if (z) {
            sparseArray.remove(m);
        }
    }

    public final void U() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && j0.a(this.f25927d)) {
            boolean z2 = y;
            this.f25933j = System.currentTimeMillis();
            k0.a().e("ubc_last_upload_non_real", this.f25933j);
            i();
            z();
            this.f25928e.e();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                r();
            }
            l0 h2 = l0.h(this.f25927d);
            h2.L(false);
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.o;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    long j2 = (long) keyAt;
                    long j3 = 60000 * j2;
                    if (this.v) {
                        j3 = 1000 * j2;
                    }
                    if (longValue == 0 || (longValue + j3) - System.currentTimeMillis() < this.q.t()) {
                        if (this.v) {
                            h2.M(this.w);
                            this.f25928e.t(this.n.valueAt(i2), true, h2);
                        } else {
                            this.f25928e.r(this.n.valueAt(i2), true, h2);
                        }
                        if (h2.w()) {
                            break;
                        }
                        HashMap<String, Long> hashMap2 = this.o;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (h2.y()) {
                return;
            }
            boolean H = this.q.H();
            boolean G = this.q.G();
            int m = this.q.m();
            if (H && !G && this.n.get(m, null) == null) {
                this.n.put(m, new ArrayList(0));
                z = true;
            } else {
                z = false;
            }
            if (!this.v) {
                for (int i3 = 0; i3 < this.n.size(); i3++) {
                    int keyAt2 = this.n.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (h2.d(51200)) {
                            break;
                        }
                        if (H && !G && keyAt2 == m) {
                            ArrayList<String> o = o(this.n, keyAt2);
                            if (o != null) {
                                this.f25928e.r(o, false, h2);
                            }
                        } else {
                            this.f25928e.r(this.n.valueAt(i3), true, h2);
                        }
                        if (h2.w()) {
                            break;
                        }
                    }
                }
            }
            if (z) {
                this.n.remove(m);
            }
            boolean z3 = y;
            J(h2);
        }
    }

    public final boolean V(n nVar) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, nVar)) == null) {
            if (j0.a(this.f25927d) && j()) {
                z();
                l0 p = p(nVar, false);
                if (p == null || p.y()) {
                    return false;
                }
                if ((nVar.n() & 128) != 0) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(nVar.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(p, "0")) {
                        return true;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, p);
                J(p);
                y();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && j0.a(this.f25927d) && j()) {
            l0 h2 = l0.h(this.f25927d);
            h2.L(true);
            if (this.n == null) {
                r();
            }
            if (Y(h2, "1")) {
                return;
            }
            T(this.n, h2);
            J(h2);
            y();
        }
    }

    public boolean X(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, nVar)) == null) {
            if (j0.a(this.f25927d)) {
                nVar.A("1");
                l0 p = p(nVar, true);
                if (p == null || p.y()) {
                    return false;
                }
                this.f25928e.u(p);
                c.a.t0.d.w().U(p.u(), true, nVar, new b(this));
                p.e();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Y(l0 l0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, l0Var, str)) == null) {
            if (b0.i().d()) {
                List<String> j2 = b0.i().j();
                if (j2 != null && j2.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(j2);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.f25928e.r(arrayList, true, l0Var);
                    J(l0Var);
                    y();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, nVar) == null) {
            this.f25932i.add(nVar);
            int i2 = this.f25930g;
            if (i2 == 0) {
                this.f25931h = SystemClock.uptimeMillis();
                c.a.t0.d.w().J(this.x, 5000L);
                this.f25930g = 1;
            } else if (i2 == 2) {
                this.f25931h = SystemClock.uptimeMillis();
                this.f25930g = 1;
            }
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i2) == null) {
            z();
            this.f25928e.d(str, i2);
            if (!b0.i().d() && Math.abs(System.currentTimeMillis() - this.f25933j) >= g.o().t()) {
                if (y) {
                    String str2 = "cancel flow " + str + " invoke ->uploadNonRealTimeData ";
                }
                U();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            G(true);
            G(false);
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (y) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.k) > 86400000) {
                this.m = 0;
                this.k = currentTimeMillis;
                k0.a().e("ubc_reset_real_time_count_time", this.k);
                k0.a().d("ubc_real_time_count", this.m);
            }
            if (this.m >= 10000) {
                boolean z = y;
                int i2 = this.m;
                if (i2 == 10000) {
                    this.m = i2 + 1;
                    if (!y) {
                        d0.a().f(String.valueOf(10000));
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k(w wVar, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{wVar, Boolean.valueOf(z), jSONArray}) == null) || (a2 = wVar.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                j p = this.f25928e.p(next);
                String optString = a2.optString(next, "0");
                String j2 = p != null ? p.j() : "0";
                boolean z2 = Integer.parseInt(j2) >= Integer.parseInt(optString);
                if (z && j2 != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.f25928e.j(next)) {
                        jSONObject.put("valid", "0");
                        this.s++;
                    } else {
                        this.r++;
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e2) {
                if (y) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void l(String str, int i2, int i3, long j2, JSONArray jSONArray) {
        List<String> j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), jSONArray}) == null) {
            z();
            this.f25928e.m(str, i2, j2, jSONArray);
            if ((i3 & 128) != 0) {
                R(str);
                return;
            }
            boolean e2 = this.q.e(str);
            if (b0.i().d()) {
                if (!e2 || (j3 = b0.i().j()) == null || !j3.contains(str)) {
                    return;
                }
                if (!this.f25926c) {
                    if ((System.currentTimeMillis() - this.f25925b) / 1000 < this.a) {
                        return;
                    }
                    this.f25926c = true;
                }
            }
            if (e2) {
                if (y) {
                    String str2 = "endFlow flow " + str + " invoke ->uploadRealTimeFlow ";
                }
                W();
            }
            if (!b0.i().d() && Math.abs(System.currentTimeMillis() - this.f25933j) >= g.o().t()) {
                if (y) {
                    String str3 = "endFlow flow " + str + " invoke ->uploadNonRealTimeData ";
                }
                U();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            try {
                z();
            } catch (RuntimeException unused) {
                boolean z = y;
            }
        }
    }

    public y n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f25928e : (y) invokeV.objValue;
    }

    public final ArrayList o(SparseArray<ArrayList> sparseArray, int i2) {
        InterceptResult invokeLI;
        ArrayList valueAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, sparseArray, i2)) == null) {
            if (sparseArray == null || sparseArray.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                if (sparseArray.keyAt(i3) != i2 && (valueAt = sparseArray.valueAt(i3)) != null && valueAt.size() != 0) {
                    arrayList.addAll(valueAt);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public final l0 p(n nVar, boolean z) {
        InterceptResult invokeLZ;
        l0 h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, nVar, z)) == null) {
            if (z) {
                h2 = l0.i();
            } else {
                h2 = l0.h(this.f25927d);
            }
            if (h2.c(nVar, nVar.g())) {
                h2.L(true);
                if ((nVar.n() & 128) != 0) {
                    h2.C();
                }
                if (!TextUtils.isEmpty(nVar.h())) {
                    h2.K("1");
                }
                return h2;
            }
            return null;
        }
        return (l0) invokeLZ.objValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            g gVar = this.q;
            if (gVar != null) {
                return gVar.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.n == null) {
            boolean z = y;
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.n = sparseArray;
            this.f25928e.x(sparseArray);
            if (y) {
                String str = "mIdArray: " + this.n.toString();
            }
            this.o = new HashMap<>();
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                this.o.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i2);
        }
    }

    public void s(w wVar, boolean z, JSONArray jSONArray) {
        List<j> b2;
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        JSONObject jSONObject;
        String optString;
        String j2;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{wVar, Boolean.valueOf(z), jSONArray}) == null) || (b2 = wVar.b()) == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str = "1";
        if (this.f25928e.q() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((j) it.next()).c());
            }
            HashMap<String, String> o = this.f25928e.o(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                j jVar = (j) it2.next();
                String c2 = jVar.c();
                String str2 = o.get(c2);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jSONObject = new JSONObject(str2);
                        optString = jSONObject.optString("version");
                        j2 = jVar.j();
                        jSONObject2 = new JSONObject();
                        hashMap = o;
                        try {
                            arrayList = arrayList2;
                        } catch (NumberFormatException unused) {
                            arrayList = arrayList2;
                            boolean z2 = y;
                            o = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused2) {
                            arrayList = arrayList2;
                            boolean z3 = y;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused3) {
                        hashMap = o;
                    } catch (JSONException unused4) {
                        hashMap = o;
                    }
                    try {
                        boolean z4 = Integer.parseInt(optString) >= Integer.parseInt(j2);
                        if (z && optString != null && j2 != null && z4) {
                            it2.remove();
                            jSONObject2.put("product", "set/" + c2);
                            jSONObject2.put("valid", "2");
                            jSONObject2.put("version", j2);
                            jSONArray.put(jSONObject2);
                            this.t++;
                        } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && jVar.l()) {
                            it2.remove();
                        }
                    } catch (NumberFormatException unused5) {
                        boolean z22 = y;
                        o = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused6) {
                        boolean z32 = y;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                    o = hashMap;
                    arrayList2 = arrayList;
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        boolean D = this.f25928e.D(arrayList4);
        int size = arrayList4.size();
        if (D) {
            this.r += size;
        } else {
            this.s += size;
            str = "0";
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            j jVar2 = (j) it3.next();
            JSONObject jSONObject3 = new JSONObject();
            String c3 = jVar2.c();
            String j3 = jVar2.j();
            try {
                jSONObject3.put("product", "set/" + c3);
                jSONObject3.put("version", j3);
                jSONObject3.put("valid", str);
            } catch (JSONException unused7) {
                boolean z5 = y;
            }
            jSONArray.put(jSONObject3);
        }
        wVar.m(arrayList4);
    }

    public void t(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, nVar) == null) {
            boolean equals = TextUtils.equals(nVar.l(), nVar.k());
            boolean z = false;
            boolean z2 = this.q.e(nVar.l()) && (nVar.n() & 64) == 0;
            boolean z3 = (nVar.n() & 128) != 0;
            if ((equals && z2) || (equals && z3)) {
                z = true;
            }
            if (b0.i().d()) {
                if (!z) {
                    this.f25928e.z(nVar);
                    return;
                }
                List<String> j2 = b0.i().j();
                if (j2 != null && j2.contains(nVar.l())) {
                    if (!this.f25926c) {
                        if ((System.currentTimeMillis() - this.f25925b) / 1000 >= this.a) {
                            this.f25926c = true;
                        } else {
                            this.f25928e.z(nVar);
                            return;
                        }
                    }
                } else {
                    this.f25928e.z(nVar);
                    return;
                }
            }
            if (z) {
                this.f25928e.z(nVar);
            } else if ((nVar.n() & 1) == 0) {
                if (this.q.K(nVar.l())) {
                    g(nVar);
                }
                if (this.f25932i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(nVar.l())) {
                this.f25928e.z(nVar);
            }
            c.a.t0.d.w().I(nVar, z);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && j0.a(this.f25927d)) {
            if (!g.o().M() || System.currentTimeMillis() >= g.o().v()) {
                File file = new File(this.f25927d.getFilesDir() + File.separator + "ubcsenddir");
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    if (listFiles.length > 1000) {
                        if (!y) {
                            d0.a().d(String.valueOf(1000), listFiles.length);
                        }
                        for (File file2 : listFiles) {
                            file2.delete();
                        }
                        this.f25928e.i();
                    }
                    for (int i2 = 0; i2 < listFiles.length; i2++) {
                        if (y) {
                            String str = "uploadFailedData fileName:" + listFiles[i2].getAbsolutePath();
                        }
                        o w = this.f25928e.w(listFiles[i2].getName());
                        if (w != null && TextUtils.equals("0", w.b())) {
                            boolean z = y;
                            a0.b("processFailedData file, no need to send");
                        } else if (w != null && TextUtils.equals("1", w.b())) {
                            a0.b("processFailedData file, send");
                            this.f25928e.G(listFiles[i2].getName(), "0");
                            O(w);
                        } else {
                            boolean z2 = y;
                            a0.b("processFailedData file, data in db, delete file");
                            listFiles[i2].delete();
                        }
                    }
                }
            }
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && j0.a(this.f25927d)) {
            File file = new File(this.f25927d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    o w = this.f25928e.w(listFiles[i2].getName());
                    if (w != null && TextUtils.equals("1", w.b())) {
                        if (y) {
                            String str = "processOneFailedData send " + listFiles[i2].getAbsolutePath();
                        }
                        a0.b("processOneFailedData file, send");
                        this.f25928e.G(listFiles[i2].getName(), "0");
                        O(w);
                        return;
                    }
                }
            }
        }
    }

    public void w(n nVar, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, nVar, z) == null) {
            if (z) {
                if (!j0.a(this.f25927d) || !j()) {
                    return;
                }
                z();
                l0 h2 = l0.h(this.f25927d);
                h2.L(true);
                if ((nVar.n() & 128) != 0) {
                    h2.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(nVar.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(h2, "0")) {
                        return;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, h2);
                if (h2.y()) {
                    return;
                }
                J(h2);
                y();
            }
            x();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (b0.i().d()) {
                this.f25928e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.f25933j) >= g.o().t()) {
                U();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            k0.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (list = this.f25932i) == null || list.size() == 0) {
            return;
        }
        this.f25928e.A(this.f25932i);
        this.f25932i.clear();
        if (this.f25930g == 1) {
            this.f25930g = 2;
        }
    }
}
