package c.a.s0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
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
import org.apache.commons.codec.binary4util.bdapp.Base64InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29802a;

    /* renamed from: b  reason: collision with root package name */
    public long f29803b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29804c;

    /* renamed from: d  reason: collision with root package name */
    public Context f29805d;

    /* renamed from: e  reason: collision with root package name */
    public y f29806e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.b f29807f;

    /* renamed from: g  reason: collision with root package name */
    public int f29808g;

    /* renamed from: h  reason: collision with root package name */
    public long f29809h;

    /* renamed from: i  reason: collision with root package name */
    public List<n> f29810i;

    /* renamed from: j  reason: collision with root package name */
    public long f29811j;
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
    public Runnable u;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29812e;

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
            this.f29812e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29812e.f29808g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f29812e.f29809h;
                    if (uptimeMillis >= 5000) {
                        if (c.v) {
                            String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis));
                        }
                        this.f29812e.w();
                        this.f29812e.f29808g = 0;
                        return;
                    }
                    d.v().E(this, 5000 - uptimeMillis);
                } else if (this.f29812e.f29808g == 2) {
                    this.f29812e.f29808g = 0;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f29813a;

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
            this.f29813a = cVar;
        }

        @Override // c.a.s0.t
        public void a(boolean z, n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, nVar) == null) {
                if (!z) {
                    this.f29813a.f29806e.u(nVar);
                } else {
                    this.f29813a.f29806e.f();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349981636, "Lc/a/s0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349981636, "Lc/a/s0/c;");
                return;
            }
        }
        v = AppConfig.isDebug();
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
        this.f29804c = false;
        this.f29808g = 0;
        this.f29809h = 0L;
        this.u = new a(this);
        this.f29805d = context;
        i0 e2 = i0.e();
        this.f29806e = new y(context);
        this.f29807f = new c.a.s0.b(context);
        this.p = g0.a();
        this.f29810i = new ArrayList(20);
        this.f29811j = e2.getLong("ubc_last_upload_non_real", 0L);
        this.k = e2.getLong("ubc_reset_real_time_count_time", 0L);
        this.l = e2.getLong("ubc_last_upload_failed_data_time", 0L);
        this.m = e2.getInt("ubc_real_time_count", 0);
        g n = g.n();
        this.q = n;
        n.x(this, context);
        this.f29803b = System.currentTimeMillis();
        this.f29802a = new Random().nextInt(31) + 60;
        x.f().g(this.f29806e);
    }

    public final void A(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            String str3 = this.f29805d.getFilesDir() + File.separator + "ubcsenddir";
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
                    outputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    outputStream = fileOutputStream;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && t(this.f29805d)) {
            if (this.n == null) {
                r();
            }
            j0 h2 = j0.h(this.f29805d);
            if (!x.f().d(h2) || h2 == null || h2.x()) {
                return;
            }
            h2.K(true);
            G(h2);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j0 i2 = j0.i();
            if (this.f29807f.e(i2)) {
                JSONObject t = i2.t();
                if (v) {
                    String str = "sendQualityData:" + t.toString();
                }
                d.v().L(t);
            }
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            j0 i2 = j0.i();
            i2.K(z);
            if (this.f29807f.f(i2, z)) {
                JSONObject t = i2.t();
                if (v) {
                    String str = "checkFileData:" + t.toString();
                }
                this.f29807f.c(z);
                d.v().L(t);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f29806e.x();
        }
    }

    public void F(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            this.f29806e.w(pVar);
        }
    }

    public final void G(j0 j0Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, j0Var) == null) {
            j0Var.k();
            if (j0Var.x()) {
                return;
            }
            if (j0Var.w()) {
                str = j0Var.o();
            } else {
                try {
                    JSONObject t = j0Var.t();
                    String b2 = h0.b(t.toString().getBytes(), true);
                    A(t.toString(), b2);
                    if (v) {
                        a0.a(j0Var);
                        String str2 = "save send data to file " + b2;
                    }
                    str = b2;
                } catch (OutOfMemoryError unused) {
                    j0Var.e();
                    return;
                }
            }
            if (!this.f29806e.e(j0Var, str)) {
                j0Var.e();
                File file = new File(this.f29805d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists()) {
                    file.delete();
                }
                this.f29806e.i(str);
                return;
            }
            b0.a().m(j0Var.A(), j0Var.u());
            d.v().K(j0Var, str);
            j0Var.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < MainTabActivity.SERVICE_BETWEEN_TIME) {
                return;
            }
            this.l = currentTimeMillis;
            i0.e().putLong("ubc_last_upload_failed_data_time", this.l);
            d.v().B();
            d.v().F();
        }
    }

    public void H(w wVar, boolean z, s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{wVar, Boolean.valueOf(z), sVar}) == null) {
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
                    int i2 = this.r + this.s + this.t;
                    jSONObject.put("count", i2 + "," + this.r + "," + this.t);
                    sVar.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e2) {
                    if (v) {
                        e2.printStackTrace();
                    }
                }
            }
            this.q.N(wVar.b());
            this.q.G(wVar.i() * 86400000);
            this.q.H(wVar.h());
            this.q.I(wVar.c());
            this.q.L(wVar.f());
            this.q.K(wVar.e());
            this.q.J(wVar.d());
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
            this.f29806e.s(this.n);
            int i3 = 0;
            for (int i4 = 0; i4 < this.n.size(); i4++) {
                int keyAt = this.n.keyAt(i4);
                if (keyAt != 0 && i3 == 0) {
                    i3 = keyAt;
                }
                HashMap<String, Long> hashMap2 = this.o;
                hashMap2.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.M(i3);
            wVar.b().clear();
        }
    }

    public void I(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, str2) == null) {
            this.f29806e.z(str, i2, str2);
        }
    }

    public final void J(File file, String str, boolean z, boolean z2, n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{file, str, Boolean.valueOf(z), Boolean.valueOf(z2), nVar, tVar}) == null) {
            boolean a2 = this.p.a(file, z, z2);
            if (tVar != null) {
                tVar.a(a2, nVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.v().P(str, a2);
        }
    }

    public final void K(JSONObject jSONObject, String str, boolean z, boolean z2, n nVar, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{jSONObject, str, Boolean.valueOf(z), Boolean.valueOf(z2), nVar, tVar}) == null) {
            boolean b2 = this.p.b(jSONObject, z, z2);
            if (tVar != null) {
                tVar.a(b2, nVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.v().P(str, b2);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e5 -> B:61:0x00e8). Please submit an issue!!! */
    public void L(o oVar) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, oVar) == null) || oVar == null) {
            return;
        }
        String a2 = oVar.a();
        File file = new File(this.f29805d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (file.exists()) {
            if (oVar.c()) {
                d.v().K(j0.g(file, (int) file.length()), a2);
                return;
            }
            InputStream inputStream = null;
            try {
                try {
                    try {
                        if (v) {
                            String str = "uploadFile fileName:" + a2;
                        }
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    JSONObject jSONObject = new JSONObject(StringUtil.getStringFromInput(inputStream));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                    jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                    jSONObject.put("metadata", jSONObject2);
                    d.v().M(jSONObject, a2);
                    fileInputStream = inputStream;
                }
                fileInputStream.close();
            } catch (Exception e5) {
                e = e5;
                inputStream = fileInputStream;
                if (v) {
                    String str2 = "error:" + e.getMessage();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                inputStream = fileInputStream;
                if (v) {
                    String str3 = "OutOfMemoryError:" + e.getMessage();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (v) {
                String str2 = "upload file fail:" + str;
            }
            a0.b("upload file fail");
            this.f29806e.A(str);
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            File file = new File(this.f29805d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (v) {
                String str2 = "deleteUploadFile file:" + file.getAbsolutePath();
            }
            a0.b("delete file");
            if (file.exists() && file.delete()) {
                a0.b("delete file suc");
            }
            this.f29806e.i(str);
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && t(this.f29805d) && j()) {
            j0 h2 = j0.h(this.f29805d);
            h2.K(true);
            h2.B();
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            this.f29806e.o(arrayList, true, h2);
            G(h2);
            v();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && t(this.f29805d)) {
            this.f29806e.c();
            j0 h2 = j0.h(this.f29805d);
            int o = this.q.o();
            h2.L(o);
            h2.K(true);
            j0 h3 = j0.h(this.f29805d);
            h3.L(o);
            h3.K(false);
            this.f29806e.k(h2, h3);
            int u = h2.u();
            int u2 = h3.u();
            if (v) {
                String str = "real size = " + u + "   no real  = " + u2;
            }
            if (u > 0) {
                if (h2.y()) {
                    b0.a().l("uploadAll", String.valueOf(o), String.valueOf(u));
                }
                G(h2);
            }
            if (u2 > 0) {
                if (h3.y()) {
                    b0.a().l("uploadAll", String.valueOf(o), String.valueOf(u2));
                }
                G(h3);
            }
        }
    }

    public final void Q(SparseArray<ArrayList> sparseArray, j0 j0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, sparseArray, j0Var) == null) || sparseArray == null) {
            return;
        }
        boolean B = this.q.B();
        boolean A = this.q.A();
        int l = this.q.l();
        if (B && !A && sparseArray.get(l, null) == null) {
            sparseArray.put(l, new ArrayList(0));
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < sparseArray.size() && !j0Var.d(51200); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            if (keyAt == 0) {
                if (B && A) {
                    this.f29806e.o(new ArrayList<>(this.q.t()), false, j0Var);
                } else {
                    this.f29806e.o(sparseArray.valueAt(i2), true, j0Var);
                }
            } else if (B && !A && keyAt == l) {
                ArrayList<String> o = o(sparseArray, keyAt);
                if (o != null) {
                    this.f29806e.o(o, false, j0Var);
                }
            } else {
                this.f29806e.o(sparseArray.valueAt(i2), true, j0Var);
            }
            if (j0Var.v()) {
                break;
            }
        }
        if (z) {
            sparseArray.remove(l);
        }
    }

    public final void R() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && t(this.f29805d)) {
            boolean z2 = v;
            this.f29811j = System.currentTimeMillis();
            i0.e().putLong("ubc_last_upload_non_real", this.f29811j);
            i();
            w();
            this.f29806e.c();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                r();
            }
            j0 h2 = j0.h(this.f29805d);
            h2.K(false);
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.o;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.q.s()) {
                        this.f29806e.o(this.n.valueAt(i2), true, h2);
                        if (h2.v()) {
                            break;
                        }
                        HashMap<String, Long> hashMap2 = this.o;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (h2.x()) {
                return;
            }
            boolean B = this.q.B();
            boolean A = this.q.A();
            int l = this.q.l();
            if (B && !A && this.n.get(l, null) == null) {
                this.n.put(l, new ArrayList(0));
                z = true;
            } else {
                z = false;
            }
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt2 = this.n.keyAt(i3);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (h2.d(51200)) {
                        break;
                    }
                    if (B && !A && keyAt2 == l) {
                        ArrayList<String> o = o(this.n, keyAt2);
                        if (o != null) {
                            this.f29806e.o(o, false, h2);
                        }
                    } else {
                        this.f29806e.o(this.n.valueAt(i3), true, h2);
                    }
                    if (h2.v()) {
                        break;
                    }
                }
            }
            if (z) {
                this.n.remove(l);
            }
            boolean z3 = v;
            G(h2);
        }
    }

    public final boolean S(n nVar) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, nVar)) == null) {
            if (t(this.f29805d) && j()) {
                w();
                j0 p = p(nVar, false);
                if (p == null || p.x()) {
                    return false;
                }
                if ((nVar.l() & 128) != 0) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(nVar.j());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (V(p, "0")) {
                        return true;
                    }
                    sparseArray = this.n;
                }
                Q(sparseArray, p);
                G(p);
                v();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && t(this.f29805d) && j()) {
            j0 h2 = j0.h(this.f29805d);
            h2.K(true);
            if (this.n == null) {
                r();
            }
            if (V(h2, "1")) {
                return;
            }
            Q(this.n, h2);
            G(h2);
            v();
        }
    }

    public boolean U(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, nVar)) == null) {
            if (t(this.f29805d)) {
                nVar.x("1");
                j0 p = p(nVar, true);
                if (p == null || p.x()) {
                    return false;
                }
                this.f29806e.p(p);
                d.v().O(p.t(), true, nVar, new b(this));
                p.e();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean V(j0 j0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, j0Var, str)) == null) {
            if (UBC.getUBCContext().a()) {
                List<String> b2 = UBC.getUBCContext().b();
                if (b2 != null && b2.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(b2);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.f29806e.o(arrayList, true, j0Var);
                    G(j0Var);
                    v();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, nVar) == null) {
            this.f29810i.add(nVar);
            int i2 = this.f29808g;
            if (i2 == 0) {
                this.f29809h = SystemClock.uptimeMillis();
                d.v().E(this.u, 5000L);
                this.f29808g = 1;
            } else if (i2 == 2) {
                this.f29809h = SystemClock.uptimeMillis();
                this.f29808g = 1;
            }
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i2) == null) {
            w();
            this.f29806e.b(str, i2);
            if (!UBC.getUBCContext().a() && Math.abs(System.currentTimeMillis() - this.f29811j) >= g.n().s()) {
                if (v) {
                    String str2 = "cancel flow " + str + " invoke ->uploadNonRealTimeData ";
                }
                R();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            D(true);
            D(false);
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (AppConfig.isDebug()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.k) > 86400000) {
                this.m = 0;
                this.k = currentTimeMillis;
                i0.e().putLong("ubc_reset_real_time_count_time", this.k);
                i0.e().putInt("ubc_real_time_count", this.m);
            }
            if (this.m >= 10000) {
                boolean z = v;
                int i2 = this.m;
                if (i2 == 10000) {
                    this.m = i2 + 1;
                    if (!v) {
                        b0.a().f(String.valueOf(10000));
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
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{wVar, Boolean.valueOf(z), jSONArray}) == null) || (a2 = wVar.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                j m = this.f29806e.m(next);
                String optString = a2.optString(next, "0");
                String k = m != null ? m.k() : "0";
                boolean z2 = Integer.parseInt(k) >= Integer.parseInt(optString);
                if (z && k != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.f29806e.h(next)) {
                        jSONObject.put("valid", "0");
                        this.s++;
                    } else {
                        this.r++;
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void l(String str, int i2, int i3, long j2, JSONArray jSONArray) {
        List<String> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), jSONArray}) == null) {
            w();
            this.f29806e.j(str, i2, j2, jSONArray);
            if ((i3 & 128) != 0) {
                O(str);
                return;
            }
            boolean e2 = this.q.e(str);
            if (UBC.getUBCContext().a()) {
                if (!e2 || (b2 = UBC.getUBCContext().b()) == null || !b2.contains(str)) {
                    return;
                }
                if (!this.f29804c) {
                    if ((System.currentTimeMillis() - this.f29803b) / 1000 < this.f29802a) {
                        return;
                    }
                    this.f29804c = true;
                }
            }
            if (e2) {
                if (v) {
                    String str2 = "endFlow flow " + str + " invoke ->uploadRealTimeFlow ";
                }
                T();
            }
            if (!UBC.getUBCContext().a() && Math.abs(System.currentTimeMillis() - this.f29811j) >= g.n().s()) {
                if (v) {
                    String str3 = "endFlow flow " + str + " invoke ->uploadNonRealTimeData ";
                }
                R();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            try {
                w();
            } catch (RuntimeException unused) {
                boolean z = v;
            }
        }
    }

    public y n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f29806e : (y) invokeV.objValue;
    }

    public final ArrayList o(SparseArray<ArrayList> sparseArray, int i2) {
        InterceptResult invokeLI;
        ArrayList valueAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, sparseArray, i2)) == null) {
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

    public final j0 p(n nVar, boolean z) {
        InterceptResult invokeLZ;
        j0 h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048607, this, nVar, z)) == null) {
            if (z) {
                h2 = j0.i();
            } else {
                h2 = j0.h(this.f29805d);
            }
            if (h2.c(nVar, nVar.e())) {
                h2.K(true);
                if ((nVar.l() & 128) != 0) {
                    h2.B();
                }
                if (!TextUtils.isEmpty(nVar.f())) {
                    h2.J("1");
                }
                return h2;
            }
            return null;
        }
        return (j0) invokeLZ.objValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            g gVar = this.q;
            if (gVar != null) {
                return gVar.w(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.n == null) {
            boolean z = v;
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.n = sparseArray;
            this.f29806e.s(sparseArray);
            this.o = new HashMap<>();
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.o;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.M(i2);
        }
    }

    public void s(w wVar, boolean z, JSONArray jSONArray) {
        List<j> b2;
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        JSONObject jSONObject;
        String optString;
        String k;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{wVar, Boolean.valueOf(z), jSONArray}) == null) || (b2 = wVar.b()) == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str = "1";
        if (this.f29806e.n() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((j) it.next()).c());
            }
            HashMap<String, String> l = this.f29806e.l(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                j jVar = (j) it2.next();
                String c2 = jVar.c();
                String str2 = l.get(c2);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jSONObject = new JSONObject(str2);
                        optString = jSONObject.optString("version");
                        k = jVar.k();
                        jSONObject2 = new JSONObject();
                        hashMap = l;
                        try {
                            arrayList = arrayList2;
                        } catch (NumberFormatException unused) {
                            arrayList = arrayList2;
                            boolean z2 = v;
                            l = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused2) {
                            arrayList = arrayList2;
                            boolean z3 = v;
                            l = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused3) {
                        hashMap = l;
                    } catch (JSONException unused4) {
                        hashMap = l;
                    }
                    try {
                        boolean z4 = Integer.parseInt(optString) >= Integer.parseInt(k);
                        if (z && optString != null && k != null && z4) {
                            it2.remove();
                            jSONObject2.put("product", "set/" + c2);
                            jSONObject2.put("valid", "2");
                            jSONObject2.put("version", k);
                            jSONArray.put(jSONObject2);
                            this.t++;
                        } else if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && jVar.m()) {
                            it2.remove();
                        }
                    } catch (NumberFormatException unused5) {
                        boolean z22 = v;
                        l = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused6) {
                        boolean z32 = v;
                        l = hashMap;
                        arrayList2 = arrayList;
                    }
                    l = hashMap;
                    arrayList2 = arrayList;
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        boolean y = this.f29806e.y(arrayList4);
        int size = arrayList4.size();
        if (y) {
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
            String k2 = jVar2.k();
            try {
                jSONObject3.put("product", "set/" + c3);
                jSONObject3.put("version", k2);
                jSONObject3.put("valid", str);
            } catch (JSONException unused7) {
                boolean z5 = v;
            }
            jSONArray.put(jSONObject3);
        }
        wVar.k(arrayList4);
    }

    @SuppressLint({"MissingPermission"})
    public final boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
                boolean z = v;
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && t(this.f29805d)) {
            File file = new File(this.f29805d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!v) {
                        b0.a().d(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f29806e.g();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    if (v) {
                        String str = "uploadFailedData fileName:" + listFiles[i2].getAbsolutePath();
                    }
                    o r = this.f29806e.r(listFiles[i2].getName());
                    if (r != null && TextUtils.equals("0", r.b())) {
                        boolean z = v;
                        a0.b("processFailedData file, no need to send");
                    } else if (r != null && TextUtils.equals("1", r.b())) {
                        a0.b("processFailedData file, send");
                        this.f29806e.B(listFiles[i2].getName(), "0");
                        L(r);
                    } else {
                        boolean z2 = v;
                        a0.b("processFailedData file, data in db, delete file");
                        listFiles[i2].delete();
                    }
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.m++;
            i0.e().putInt("ubc_real_time_count", this.m);
        }
    }

    public final void w() {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (list = this.f29810i) == null || list.size() == 0) {
            return;
        }
        this.f29806e.v(this.f29810i);
        this.f29810i.clear();
        if (this.f29808g == 1) {
            this.f29808g = 2;
        }
    }

    public void x(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, nVar) == null) {
            boolean equals = TextUtils.equals(nVar.j(), nVar.i());
            boolean z = false;
            boolean z2 = this.q.e(nVar.j()) && (nVar.l() & 64) == 0;
            boolean z3 = (nVar.l() & 128) != 0;
            if ((equals && z2) || (equals && z3)) {
                z = true;
            }
            if (UBC.getUBCContext().a()) {
                if (!z) {
                    this.f29806e.u(nVar);
                    return;
                }
                List<String> b2 = UBC.getUBCContext().b();
                if (b2 != null && b2.contains(nVar.j())) {
                    if (!this.f29804c) {
                        if ((System.currentTimeMillis() - this.f29803b) / 1000 >= this.f29802a) {
                            this.f29804c = true;
                        } else {
                            this.f29806e.u(nVar);
                            return;
                        }
                    }
                } else {
                    this.f29806e.u(nVar);
                    return;
                }
            }
            if (z && !S(nVar)) {
                if (this.q.D(nVar.j())) {
                    this.f29806e.u(nVar);
                }
            } else if (UBC.getUBCContext().a()) {
                this.f29806e.c();
            } else if (Math.abs(System.currentTimeMillis() - this.f29811j) >= g.n().s()) {
                if (!z && this.q.D(nVar.j())) {
                    g(nVar);
                }
                R();
            } else if ((nVar.l() & 1) == 0) {
                if (!z && this.q.D(nVar.j())) {
                    g(nVar);
                }
                if (this.f29810i.size() >= 20) {
                    w();
                }
            } else if (z || !this.q.D(nVar.j())) {
            } else {
                this.f29806e.u(nVar);
            }
        }
    }

    public void y(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, nVar) == null) {
            this.f29807f.g(nVar, this.q.e(nVar.j()));
        }
    }

    public void z(n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, nVar) == null) && c.a.h0.b.a.a.g()) {
            this.f29807f.i(nVar);
        }
    }
}
