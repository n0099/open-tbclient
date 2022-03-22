package c.a.n0.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a f9424b;

    /* renamed from: c  reason: collision with root package name */
    public b f9425c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f9426d;

    /* renamed from: e  reason: collision with root package name */
    public long f9427e;

    /* renamed from: f  reason: collision with root package name */
    public long f9428f;

    /* renamed from: g  reason: collision with root package name */
    public long f9429g;

    /* renamed from: h  reason: collision with root package name */
    public int f9430h;
    public SparseArray<ArrayList> i;
    public HashMap<String, Long> j;
    public m k;
    public d l;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f9424b = new a(context);
        this.f9425c = new b(context);
        this.k = e.g().m();
        this.f9426d = new ArrayList(20);
        t f2 = t.f();
        this.f9427e = f2.getLong("ubc_last_upload_all_time", 0L);
        this.f9428f = f2.getLong("ubc_last_upload_non_real", 0L);
        this.f9429g = f2.getLong("ubc_reset_real_time_count_time", 0L);
        this.f9430h = f2.getInt("ubc_real_time_count", 0);
        d g2 = d.g();
        this.l = g2;
        g2.k(this, context);
    }

    public final boolean A(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            if (g(this.a) && c()) {
                j();
                u uVar = new u();
                uVar.f9514g = true;
                JSONObject jSONObject = iVar.f9455e;
                try {
                    if (jSONObject != null && jSONObject.has("bizId")) {
                        r.a(jSONObject);
                        uVar.a(jSONObject);
                        long j = iVar.f9456f;
                        uVar.g(j, j);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                        JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                        if (jSONObject2 != null && jSONObject3 != null) {
                            jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                            jSONObject.remove(DI.APP_INFO_NAME);
                        }
                    } else {
                        JSONObject e2 = new r(iVar.a()).e();
                        e2.put("bizId", iVar.a);
                        e2.put("timestamp", Long.toString(iVar.f9456f));
                        if (iVar.f9455e != null) {
                            e2.put("content", iVar.f9455e);
                        } else {
                            e2.put("content", iVar.f9454d);
                        }
                        e2.put("eventType", "0");
                        if (!TextUtils.isEmpty(iVar.f9458h)) {
                            e2.put("abtest", iVar.f9458h);
                            uVar.f9513f = "1";
                        }
                        if (!TextUtils.isEmpty(iVar.i)) {
                            e2.put("c", iVar.i);
                        }
                        if (iVar.j) {
                            e2.put("of", "1");
                        }
                        e2.put(Constant.ID_TYPE, this.l.j(iVar.a));
                        uVar.a(e2);
                        uVar.g(iVar.f9456f, iVar.f9456f);
                    }
                } catch (JSONException unused) {
                }
                if (this.i == null) {
                    f();
                }
                if (this.i.size() > 0) {
                    this.f9424b.m(this.i.valueAt(0), uVar);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g(this.a) && c()) {
            u uVar = new u();
            uVar.f9514g = true;
            if (this.i == null) {
                f();
            }
            if (this.i.size() > 0) {
                if (e.g().s()) {
                    this.f9424b.l(uVar);
                } else {
                    this.f9424b.m(this.i.valueAt(0), uVar);
                }
            }
            q(uVar);
            i();
        }
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            j();
            this.f9424b.d(str, i);
            if (Math.abs(System.currentTimeMillis() - this.f9428f) >= d.g().h()) {
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
            if (e.g().s()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f9429g) > 86400000) {
                this.f9430h = 0;
                this.f9429g = currentTimeMillis;
                t.f().putLong("ubc_reset_real_time_count_time", this.f9429g);
                t.f().putInt("ubc_real_time_count", this.f9430h);
            }
            int i = this.f9430h;
            if (i >= 1000) {
                if (i == 1000) {
                    this.f9430h = i + 1;
                    e.h("23", "realLimit");
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, int i, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jSONArray}) == null) {
            j();
            this.f9424b.j(str, i, j, jSONArray);
            if (this.l.b(str)) {
                B();
            }
            if (Math.abs(System.currentTimeMillis() - this.f9428f) >= d.g().h()) {
                z();
            }
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9424b : (a) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.i == null) {
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.i = sparseArray;
            this.f9424b.v(sparseArray);
            this.j = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i);
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && g(this.a)) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.h("23", jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f9424b.h();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j u = this.f9424b.u(listFiles[i].getName());
                    if (u != null && TextUtils.equals("0", u.a())) {
                        s.a("processFailedData file, no need to send");
                    } else if (u != null && TextUtils.equals("1", u.a())) {
                        s.a("processFailedData file, send");
                        this.f9424b.G(listFiles[i].getName(), "0");
                        v(listFiles[i].getName());
                    } else {
                        s.a("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f9430h++;
            t.f().putInt("ubc_real_time_count", this.f9430h);
        }
    }

    public final void j() {
        List<i> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.f9426d) == null || list.size() == 0) {
            return;
        }
        this.f9424b.z(this.f9426d);
        this.f9426d.clear();
    }

    public void k(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            boolean z = TextUtils.equals(iVar.a, iVar.f9452b) && this.l.b(iVar.a) && (iVar.f9457g & 64) == 0;
            if (z && !A(iVar)) {
                this.f9424b.y(iVar);
            } else if (Math.abs(System.currentTimeMillis() - this.f9428f) >= d.g().h()) {
                if (!z) {
                    this.f9426d.add(iVar);
                }
                z();
            } else if ((1 & iVar.f9457g) != 0) {
                if (z) {
                    return;
                }
                this.f9424b.y(iVar);
            } else {
                if (!z) {
                    this.f9426d.add(iVar);
                }
                if (this.f9426d.size() >= 20) {
                    j();
                }
            }
        }
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) {
            this.f9425c.d(iVar, this.l.b(iVar.a));
        }
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            String str3 = this.a.getFilesDir() + File.separator + "statistics_data";
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
                c.a.n0.w.d.d(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                c.a.n0.w.d.d(outputStream);
                throw th;
            }
            c.a.n0.w.d.d(outputStream);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            u uVar = new u();
            uVar.f9514g = z;
            if (this.f9425c.c(uVar, z)) {
                JSONArray jSONArray = uVar.a;
                this.f9425c.b(z);
                n.f().s(jSONArray);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f9424b.C();
        }
    }

    public void p(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kVar) == null) {
            this.f9424b.B(kVar);
        }
    }

    public final void q(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, uVar) == null) || uVar.d()) {
            return;
        }
        JSONArray jSONArray = uVar.a;
        String d2 = c.a.n0.w.f.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d2);
        this.f9424b.A(d2, uVar.f9514g);
        if (!this.f9424b.g(uVar.f9509b, uVar.f9510c, uVar.f9514g, d2)) {
            uVar.c();
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", d2);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.f9424b.i(d2);
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
            t.f().putString("ubc_version_md5", qVar.b());
            this.f9424b.D(qVar.a());
            qVar.a().clear();
            if (this.i == null) {
                this.i = new SparseArray<>();
            }
            this.i.clear();
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            this.j.clear();
            this.f9424b.v(this.i);
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i);
        }
    }

    public void s(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i, str2) == null) {
            this.f9424b.E(str, i, str2);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && g(this.a) && Math.abs(System.currentTimeMillis() - this.f9427e) >= 3600000) {
            this.f9424b.f();
            u uVar = new u();
            if (this.f9424b.l(uVar) == 0) {
                return;
            }
            u uVar2 = new u();
            uVar2.g(uVar.f9511d, uVar.f9512e);
            uVar2.f9513f = uVar.f9513f;
            uVar2.f9514g = true;
            u uVar3 = new u();
            uVar3.g(uVar.f9511d, uVar.f9512e);
            uVar3.f9513f = uVar.f9513f;
            uVar3.f9514g = false;
            SparseIntArray sparseIntArray = uVar.f9509b;
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                if (this.l.b(String.valueOf(sparseIntArray.valueAt(i)))) {
                    uVar2.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
                } else {
                    uVar3.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
                }
            }
            ArrayList<String> arrayList = uVar.f9510c;
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = arrayList.get(i2);
                if (this.l.b(str)) {
                    uVar2.e(str);
                } else {
                    uVar3.e(str);
                }
            }
            JSONArray jSONArray = uVar.a;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
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
            if (uVar2.a.length() > 0) {
                q(uVar2);
            }
            if (uVar3.a.length() > 0) {
                q(uVar3);
            }
            this.f9427e = System.currentTimeMillis();
            t.f().putLong("ubc_last_upload_all_time", this.f9427e);
            this.f9428f = this.f9427e;
            t.f().putLong("ubc_last_upload_non_real", this.f9428f);
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
        File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    n.f().r(new JSONArray(c.a.n0.w.h.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                c.a.n0.w.d.d(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                c.a.n0.w.d.d(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                c.a.n0.w.d.d(inputStream);
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
        e.h("23", "sendFail");
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            s.a("upload file fail");
            this.f9424b.F(str);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
            s.a("delete file");
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
                s.a("delete file suc");
            }
            this.f9424b.i(str);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && g(this.a)) {
            this.f9428f = System.currentTimeMillis();
            t.f().putLong("ubc_last_upload_non_real", this.f9428f);
            b();
            j();
            this.f9424b.f();
            HashSet hashSet = new HashSet();
            if (this.i == null) {
                f();
            }
            u uVar = new u();
            uVar.f9514g = false;
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i |= this.f9424b.m(this.i.valueAt(i2), uVar);
                        HashMap<String, Long> hashMap2 = this.j;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i == 0) {
                return;
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                int keyAt2 = this.i.keyAt(i3);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (uVar.b(51200)) {
                        break;
                    }
                    this.f9424b.m(this.i.valueAt(i3), uVar);
                }
            }
            q(uVar);
        }
    }
}
