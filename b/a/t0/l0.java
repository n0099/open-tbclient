package b.a.t0;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f29699a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f29700b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f29701c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f29702d;

    /* renamed from: e  reason: collision with root package name */
    public long f29703e;

    /* renamed from: f  reason: collision with root package name */
    public long f29704f;

    /* renamed from: g  reason: collision with root package name */
    public String f29705g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29706h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29707i;
    public int j;
    public long k;
    public int l;
    public boolean m;
    public int n;
    public JsonWriter o;
    public b.a.t0.p0.c p;
    public b.a.t0.p0.d q;
    public File r;
    public String s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-875091221, "Lb/a/t0/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-875091221, "Lb/a/t0/l0;");
                return;
            }
        }
        t = b0.m();
    }

    public l0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29702d = new HashSet();
        this.f29706h = false;
        this.f29707i = false;
        this.j = 0;
        this.k = 0L;
        this.l = 614400;
        this.m = false;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.f29699a = new JSONArray();
        this.f29700b = new SparseArray<>();
        this.f29701c = new ArrayList<>();
        this.f29703e = 0L;
        this.f29704f = 0L;
        this.f29705g = "0";
    }

    public static l0 g(File file, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, file, i2)) == null) ? new l0(file, i2) : (l0) invokeLI.objValue;
    }

    public static l0 h(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            String str = context.getFilesDir() + File.separator + "ubcsenddir";
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdir()) {
                return new l0();
            }
            do {
                file = new File(str, "upload_" + System.currentTimeMillis() + UUID.randomUUID().toString());
            } while (file.exists());
            return new l0(file);
        }
        return (l0) invokeL.objValue;
    }

    public static l0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new l0() : (l0) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29707i : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29706h : invokeV.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29707i = true;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j();
            this.n = 3;
        }
    }

    public final void E(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.j += i2;
    }

    public void F(String str) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        IOException e2;
        FileNotFoundException e3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && t) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(new b.a.t0.p0.b(new FileInputStream(this.r), 0));
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = gZIPInputStream.read(bArr, 0, 4096);
                            if (read < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        new String(byteArrayOutputStream.toByteArray());
                    } catch (FileNotFoundException e4) {
                        e3 = e4;
                        e3.printStackTrace();
                        b.a.t0.q0.a.b(byteArrayOutputStream);
                        b.a.t0.q0.a.b(gZIPInputStream);
                    } catch (IOException e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        b.a.t0.q0.a.b(byteArrayOutputStream);
                        b.a.t0.q0.a.b(gZIPInputStream);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.a.t0.q0.a.b(byteArrayOutputStream);
                    b.a.t0.q0.a.b(null);
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                gZIPInputStream = null;
                e3 = e6;
            } catch (IOException e7) {
                gZIPInputStream = null;
                e2 = e7;
            } catch (Throwable th3) {
                th = th3;
                b.a.t0.q0.a.b(byteArrayOutputStream);
                b.a.t0.q0.a.b(null);
                throw th;
            }
            b.a.t0.q0.a.b(byteArrayOutputStream);
            b.a.t0.q0.a.b(gZIPInputStream);
        }
    }

    public final void G(b.a.t0.p0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar instanceof n) {
            H(((n) aVar).l());
        } else if (aVar instanceof p) {
            p pVar = (p) aVar;
            I(pVar.k(), Integer.parseInt(pVar.l()));
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.f29701c.contains(str)) {
            return;
        }
        this.f29701c.add(str);
    }

    public final void I(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.f29700b.put(i2, Integer.valueOf(i3));
        }
    }

    public final void J(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            long j3 = this.f29703e;
            if ((j < j3 || j3 == 0) && j != 0) {
                this.f29703e = j;
            }
            if (j2 > this.f29704f) {
                this.f29704f = j2;
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f29705g = str;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f29706h = z;
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 < 0) {
            return;
        }
        this.l = i2;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                b.a.t0.p0.c cVar = new b.a.t0.p0.c(new FileOutputStream(this.r), 2);
                this.p = cVar;
                b.a.t0.p0.d dVar = new b.a.t0.p0.d(cVar);
                this.q = dVar;
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(dVar));
                this.o = jsonWriter;
                jsonWriter.beginObject();
                this.o.name("data");
                this.o.flush();
                this.q.f();
                this.o.beginArray();
                this.n = 1;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                D();
            } catch (IOException e3) {
                e3.printStackTrace();
                D();
            }
        }
    }

    public void a(Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, set) == null) || this.f29702d.containsAll(set)) {
            return;
        }
        this.f29702d.addAll(set);
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            this.f29699a.put(jSONObject);
        }
    }

    public final boolean c(b.a.t0.p0.a aVar, int i2) {
        InterceptResult invokeLI;
        JsonWriter jsonWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, aVar, i2)) == null) {
            if (!this.m) {
                try {
                    b(aVar.a());
                    G(aVar);
                    E(i2);
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            if (this.n == 0) {
                N();
            }
            if (this.n == 1 && (jsonWriter = this.o) != null) {
                try {
                    aVar.b(jsonWriter);
                    G(aVar);
                    E(i2);
                    return true;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    D();
                    return false;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? this.j >= i2 : invokeI.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f29700b.clear();
            this.f29701c.clear();
            this.f29699a = null;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            j();
            this.n = 0;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.m) {
            JsonWriter jsonWriter = this.o;
            if (jsonWriter != null) {
                b.a.t0.q0.a.b(jsonWriter);
                this.o = null;
            }
            b.a.t0.p0.d dVar = this.q;
            if (dVar != null) {
                b.a.t0.q0.a.b(dVar);
                this.q = null;
                this.p = null;
            }
            File file = this.r;
            if (file != null && file.exists()) {
                b.a.t0.q0.b.a(this.r);
            }
            this.f29700b.clear();
            this.f29701c.clear();
            this.r = null;
            this.s = null;
            this.j = 0;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.m) {
            if (this.j == 0) {
                f();
            }
            if (this.n != 1) {
                D();
                return;
            }
            JsonWriter jsonWriter = this.o;
            if (jsonWriter != null) {
                try {
                    try {
                        jsonWriter.endArray();
                        this.o.flush();
                        this.q.g();
                        if (this.f29703e == 0 || this.f29704f == 0) {
                            this.f29703e = this.f29704f;
                        }
                        String b2 = j0.b(this.q.a(), "", true);
                        if (!TextUtils.isEmpty(b2)) {
                            this.s = b2;
                        }
                        if (t) {
                            String c2 = this.q.c();
                            if (TextUtils.isEmpty(c2)) {
                                String str = "**********UploadData content: " + c2;
                            }
                        }
                        this.o.name("metadata");
                        this.o.beginObject();
                        this.o.name("mintime").value(Long.toString(this.f29703e));
                        this.o.name("maxtime").value(Long.toString(this.f29704f));
                        this.o.name("createtime").value(Long.toString(System.currentTimeMillis()));
                        this.o.name("uploadtime").value(Long.toString(System.currentTimeMillis()));
                        this.o.name(PackageTable.MD5).value(b2);
                        this.o.endObject();
                        this.o.name("isAbtest").value(this.f29705g);
                        this.o.name(Constant.IS_REAL).value(this.f29706h ? "1" : "0");
                        this.o.endObject();
                        this.o.flush();
                        b.a.t0.q0.a.b(this.o);
                        this.k = this.p.a();
                        if (this.r.exists() && !TextUtils.isEmpty(this.s)) {
                            File file = new File(this.r.getParentFile(), this.s);
                            if (!file.exists()) {
                                if (this.r.renameTo(file)) {
                                    this.r = file;
                                } else if (t) {
                                    String str2 = "rename error for file: " + this.r.getAbsolutePath();
                                }
                            }
                        }
                        this.n = 2;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        D();
                    }
                    b.a.t0.q0.a.b(this.o);
                    b.a.t0.q0.a.b(this.q);
                    this.o = null;
                    this.p = null;
                    this.q = null;
                } catch (Throwable th) {
                    b.a.t0.q0.a.b(this.o);
                    b.a.t0.q0.a.b(this.q);
                    throw th;
                }
            }
        }
    }

    public Set<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f29702d : (Set) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k : invokeV.longValue;
    }

    public JSONArray n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f29699a : (JSONArray) invokeV.objValue;
    }

    public File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.r : (File) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.m && this.r.exists()) {
                return this.r.getName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final ArrayList q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f29701c : (ArrayList) invokeV.objValue;
    }

    public final SparseArray<Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f29700b : (SparseArray) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f29704f : invokeV.longValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f29703e : invokeV.longValue;
    }

    public JSONObject u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("data", this.f29699a);
                if (this.f29703e == 0 || this.f29704f == 0) {
                    this.f29703e = this.f29704f;
                }
                jSONObject2.put("mintime", Long.toString(this.f29703e));
                jSONObject2.put("maxtime", Long.toString(this.f29704f));
                jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put(PackageTable.MD5, j0.c(this.f29699a.toString().getBytes(), true));
                jSONObject.put("metadata", jSONObject2);
                jSONObject.put("isAbtest", this.f29705g);
                jSONObject.put(Constant.IS_REAL, this.f29706h ? "1" : "0");
            } catch (JSONException unused) {
                boolean z = t;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.j : invokeV.intValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m && this.n == 3 : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!this.m) {
                return this.f29699a.length() == 0;
            }
            int i2 = this.n;
            return !(i2 == 2 || i2 == 1) || this.j == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.j >= this.l : invokeV.booleanValue;
    }

    public l0(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f29702d = new HashSet();
        this.f29706h = false;
        this.f29707i = false;
        this.j = 0;
        this.k = 0L;
        this.l = 614400;
        this.m = false;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.f29699a = new JSONArray();
        this.f29700b = new SparseArray<>();
        this.f29701c = new ArrayList<>();
        this.f29703e = 0L;
        this.f29704f = 0L;
        this.f29705g = "0";
        if (file != null) {
            this.r = file;
            this.m = true;
        }
    }

    public l0(File file, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f29702d = new HashSet();
        this.f29706h = false;
        this.f29707i = false;
        this.j = 0;
        this.k = 0L;
        this.l = 614400;
        this.m = false;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.r = file;
        this.m = true;
        this.j = i2;
    }
}
