package c.a.p0.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12252a;

    /* renamed from: b  reason: collision with root package name */
    public a f12253b;

    /* renamed from: c  reason: collision with root package name */
    public b f12254c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f12255d;

    /* renamed from: e  reason: collision with root package name */
    public long f12256e;

    /* renamed from: f  reason: collision with root package name */
    public long f12257f;

    /* renamed from: g  reason: collision with root package name */
    public long f12258g;

    /* renamed from: h  reason: collision with root package name */
    public int f12259h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ArrayList> f12260i;

    /* renamed from: j  reason: collision with root package name */
    public HashMap<String, Long> f12261j;
    public m k;
    public d l;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
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
        this.f12252a = context;
        this.f12253b = new a(context);
        this.f12254c = new b(context);
        this.k = e.h().m();
        this.f12255d = new ArrayList(20);
        t g2 = t.g();
        this.f12256e = g2.getLong("ubc_last_upload_all_time", 0L);
        this.f12257f = g2.getLong("ubc_last_upload_non_real", 0L);
        this.f12258g = g2.getLong("ubc_reset_real_time_count_time", 0L);
        this.f12259h = g2.getInt("ubc_real_time_count", 0);
        d g3 = d.g();
        this.l = g3;
        g3.k(this, context);
    }

    public final boolean A(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            if (g(this.f12252a) && c()) {
                j();
                u uVar = new u();
                uVar.f12384g = true;
                JSONObject jSONObject = iVar.f12296e;
                try {
                    if (jSONObject != null && jSONObject.has("bizId")) {
                        r.a(jSONObject);
                        uVar.a(jSONObject);
                        long j2 = iVar.f12297f;
                        uVar.g(j2, j2);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                        JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                        if (jSONObject2 != null && jSONObject3 != null) {
                            jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                            jSONObject.remove(DI.APP_INFO_NAME);
                        }
                    } else {
                        JSONObject e2 = new r(iVar.a()).e();
                        e2.put("bizId", iVar.f12292a);
                        e2.put("timestamp", Long.toString(iVar.f12297f));
                        if (iVar.f12296e != null) {
                            e2.put("content", iVar.f12296e);
                        } else {
                            e2.put("content", iVar.f12295d);
                        }
                        e2.put("eventType", "0");
                        if (!TextUtils.isEmpty(iVar.f12299h)) {
                            e2.put("abtest", iVar.f12299h);
                            uVar.f12383f = "1";
                        }
                        if (!TextUtils.isEmpty(iVar.f12300i)) {
                            e2.put("c", iVar.f12300i);
                        }
                        if (iVar.f12301j) {
                            e2.put("of", "1");
                        }
                        e2.put(Constant.ID_TYPE, this.l.j(iVar.f12292a));
                        uVar.a(e2);
                        uVar.g(iVar.f12297f, iVar.f12297f);
                    }
                } catch (JSONException unused) {
                }
                if (this.f12260i == null) {
                    f();
                }
                if (this.f12260i.size() > 0) {
                    this.f12253b.m(this.f12260i.valueAt(0), uVar);
                }
                q(uVar);
                i();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g(this.f12252a) && c()) {
            u uVar = new u();
            uVar.f12384g = true;
            if (this.f12260i == null) {
                f();
            }
            if (this.f12260i.size() > 0) {
                if (e.h().s()) {
                    this.f12253b.l(uVar);
                } else {
                    this.f12253b.m(this.f12260i.valueAt(0), uVar);
                }
            }
            q(uVar);
            i();
        }
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            j();
            this.f12253b.d(str, i2);
            if (Math.abs(System.currentTimeMillis() - this.f12257f) >= d.g().h()) {
                z();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n(true);
            n(false);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (e.h().s()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f12258g) > 86400000) {
                this.f12259h = 0;
                this.f12258g = currentTimeMillis;
                t.g().putLong("ubc_reset_real_time_count_time", this.f12258g);
                t.g().putInt("ubc_real_time_count", this.f12259h);
            }
            int i2 = this.f12259h;
            if (i2 >= 1000) {
                if (i2 == 1000) {
                    this.f12259h = i2 + 1;
                    e.i(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, int i2, long j2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), jSONArray}) == null) {
            j();
            this.f12253b.j(str, i2, j2, jSONArray);
            if (this.l.b(str)) {
                B();
            }
            if (Math.abs(System.currentTimeMillis() - this.f12257f) >= d.g().h()) {
                z();
            }
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12253b : (a) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f12260i == null) {
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.f12260i = sparseArray;
            this.f12253b.v(sparseArray);
            this.f12261j = new HashMap<>();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f12260i.size(); i3++) {
                int keyAt = this.f12260i.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.f12261j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i2);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && g(this.f12252a)) {
            File file = new File(this.f12252a.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.i(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f12253b.h();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    j u = this.f12253b.u(listFiles[i2].getName());
                    if (u != null && TextUtils.equals("0", u.a())) {
                        s.a("processFailedData file, no need to send");
                    } else if (u != null && TextUtils.equals("1", u.a())) {
                        s.a("processFailedData file, send");
                        this.f12253b.G(listFiles[i2].getName(), "0");
                        v(listFiles[i2].getName());
                    } else {
                        s.a("processFailedData file, data in db, delete file");
                        listFiles[i2].delete();
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12259h++;
            t.g().putInt("ubc_real_time_count", this.f12259h);
        }
    }

    public final void j() {
        List<i> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.f12255d) == null || list.size() == 0) {
            return;
        }
        this.f12253b.z(this.f12255d);
        this.f12255d.clear();
    }

    public void k(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            boolean z = TextUtils.equals(iVar.f12292a, iVar.f12293b) && this.l.b(iVar.f12292a) && (iVar.f12298g & 64) == 0;
            if (z && !A(iVar)) {
                this.f12253b.y(iVar);
            } else if (Math.abs(System.currentTimeMillis() - this.f12257f) >= d.g().h()) {
                if (!z) {
                    this.f12255d.add(iVar);
                }
                z();
            } else if ((1 & iVar.f12298g) != 0) {
                if (z) {
                    return;
                }
                this.f12253b.y(iVar);
            } else {
                if (!z) {
                    this.f12255d.add(iVar);
                }
                if (this.f12255d.size() >= 20) {
                    j();
                }
            }
        }
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) {
            this.f12254c.d(iVar, this.l.b(iVar.f12292a));
        }
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            String str3 = this.f12252a.getFilesDir() + File.separator + "statistics_data";
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
                s.a("save to file suc");
            } catch (Exception e3) {
                e = e3;
                outputStream = fileOutputStream;
                e.printStackTrace();
                c.a.p0.t.d.d(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                c.a.p0.t.d.d(outputStream);
                throw th;
            }
            c.a.p0.t.d.d(outputStream);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            u uVar = new u();
            uVar.f12384g = z;
            if (this.f12254c.c(uVar, z)) {
                JSONArray jSONArray = uVar.f12378a;
                this.f12254c.b(z);
                n.f().s(jSONArray);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f12253b.C();
        }
    }

    public void p(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kVar) == null) {
            this.f12253b.B(kVar);
        }
    }

    public final void q(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, uVar) == null) || uVar.d()) {
            return;
        }
        JSONArray jSONArray = uVar.f12378a;
        String d2 = c.a.p0.t.f.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d2);
        this.f12253b.A(d2, uVar.f12384g);
        if (!this.f12253b.g(uVar.f12379b, uVar.f12380c, uVar.f12384g, d2)) {
            uVar.c();
            File file = new File(this.f12252a.getFilesDir() + File.separator + "statistics_data", d2);
            if (file.exists()) {
                file.delete();
            }
            this.f12253b.i(d2);
            return;
        }
        n.f().r(jSONArray, d2);
        uVar.c();
    }

    public void r(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, qVar) == null) {
            this.l.q(qVar.a());
            this.l.n(qVar.d() * 86400000);
            this.l.o(qVar.c());
            t.g().putString("ubc_version_md5", qVar.b());
            this.f12253b.D(qVar.a());
            qVar.a().clear();
            if (this.f12260i == null) {
                this.f12260i = new SparseArray<>();
            }
            this.f12260i.clear();
            if (this.f12261j == null) {
                this.f12261j = new HashMap<>();
            }
            this.f12261j.clear();
            this.f12253b.v(this.f12260i);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f12260i.size(); i3++) {
                int keyAt = this.f12260i.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.f12261j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i2);
        }
    }

    public void s(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i2, str2) == null) {
            this.f12253b.E(str, i2, str2);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && g(this.f12252a) && Math.abs(System.currentTimeMillis() - this.f12256e) >= 3600000) {
            this.f12253b.f();
            u uVar = new u();
            if (this.f12253b.l(uVar) == 0) {
                return;
            }
            u uVar2 = new u();
            uVar2.g(uVar.f12381d, uVar.f12382e);
            uVar2.f12383f = uVar.f12383f;
            uVar2.f12384g = true;
            u uVar3 = new u();
            uVar3.g(uVar.f12381d, uVar.f12382e);
            uVar3.f12383f = uVar.f12383f;
            uVar3.f12384g = false;
            SparseIntArray sparseIntArray = uVar.f12379b;
            int size = sparseIntArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.l.b(String.valueOf(sparseIntArray.valueAt(i2)))) {
                    uVar2.f(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
                } else {
                    uVar3.f(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
                }
            }
            ArrayList<String> arrayList = uVar.f12380c;
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = arrayList.get(i3);
                if (this.l.b(str)) {
                    uVar2.e(str);
                } else {
                    uVar3.e(str);
                }
            }
            JSONArray jSONArray = uVar.f12378a;
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject.has("bizId")) {
                    String str2 = null;
                    try {
                        str2 = optJSONObject.getString("bizId");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (this.l.b(str2)) {
                            uVar2.a(optJSONObject);
                        } else {
                            uVar3.a(optJSONObject);
                        }
                    }
                }
            }
            if (uVar2.f12378a.length() > 0) {
                q(uVar2);
            }
            if (uVar3.f12378a.length() > 0) {
                q(uVar3);
            }
            this.f12256e = System.currentTimeMillis();
            t.g().putLong("ubc_last_upload_all_time", this.f12256e);
            this.f12257f = this.f12256e;
            t.g().putLong("ubc_last_upload_non_real", this.f12257f);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, jSONArray, str) == null) {
            n.f().t(str, this.k.a(jSONArray));
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048599, this, str) != null) {
            return;
        }
        File file = new File(this.f12252a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    n.f().r(new JSONArray(c.a.p0.t.h.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                c.a.p0.t.d.d(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                c.a.p0.t.d.d(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                c.a.p0.t.d.d(inputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void w(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, jSONArray) == null) || this.k.a(jSONArray)) {
            return;
        }
        e.i(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            s.a("upload file fail");
            this.f12253b.F(str);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            File file = new File(this.f12252a.getFilesDir() + File.separator + "statistics_data", str);
            s.a("delete file");
            if (file.exists() && file.delete()) {
                s.a("delete file suc");
            }
            this.f12253b.i(str);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && g(this.f12252a)) {
            this.f12257f = System.currentTimeMillis();
            t.g().putLong("ubc_last_upload_non_real", this.f12257f);
            b();
            j();
            this.f12253b.f();
            HashSet hashSet = new HashSet();
            if (this.f12260i == null) {
                f();
            }
            u uVar = new u();
            uVar.f12384g = false;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f12260i.size(); i3++) {
                int keyAt = this.f12260i.keyAt(i3);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.f12261j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i2 |= this.f12253b.m(this.f12260i.valueAt(i3), uVar);
                        HashMap<String, Long> hashMap2 = this.f12261j;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i2 == 0) {
                return;
            }
            for (int i4 = 0; i4 < this.f12260i.size(); i4++) {
                int keyAt2 = this.f12260i.keyAt(i4);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (uVar.b(51200)) {
                        break;
                    }
                    this.f12253b.m(this.f12260i.valueAt(i4), uVar);
                }
            }
            q(uVar);
        }
    }
}
