package c.a.t0;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
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
import java.io.Closeable;
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
/* loaded from: classes4.dex */
public class j0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f30037a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f30038b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f30039c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f30040d;

    /* renamed from: e  reason: collision with root package name */
    public long f30041e;

    /* renamed from: f  reason: collision with root package name */
    public long f30042f;

    /* renamed from: g  reason: collision with root package name */
    public String f30043g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30044h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30045i;

    /* renamed from: j  reason: collision with root package name */
    public int f30046j;
    public int k;
    public boolean l;
    public int m;
    public JsonWriter n;
    public c.a.t0.k0.d o;
    public File p;
    public String q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1071606648, "Lc/a/t0/j0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1071606648, "Lc/a/t0/j0;");
                return;
            }
        }
        r = AppConfig.isDebug();
    }

    public j0() {
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
        this.f30040d = new HashSet();
        this.f30044h = false;
        this.f30045i = false;
        this.f30046j = 0;
        this.k = 614400;
        this.l = false;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.q = null;
        this.f30037a = new JSONArray();
        this.f30038b = new SparseArray<>();
        this.f30039c = new ArrayList<>();
        this.f30041e = 0L;
        this.f30042f = 0L;
        this.f30043g = "0";
    }

    public static j0 g(File file, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, file, i2)) == null) ? new j0(file, i2) : (j0) invokeLI.objValue;
    }

    public static j0 h(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            String str = context.getFilesDir() + File.separator + "ubcsenddir";
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdir()) {
                return new j0();
            }
            do {
                file = new File(str, "upload_" + System.currentTimeMillis() + UUID.randomUUID().toString());
            } while (file.exists());
            return new j0(file);
        }
        return (j0) invokeL.objValue;
    }

    public static j0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new j0() : (j0) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30044h : invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30045i = true;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j();
            this.m = 3;
        }
    }

    public final void D(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f30046j += i2;
    }

    public void E(String str) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        IOException e2;
        FileNotFoundException e3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && r) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(new c.a.t0.k0.b(new FileInputStream(this.p), 0));
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
                        Closeables.closeSafely(byteArrayOutputStream);
                        Closeables.closeSafely(gZIPInputStream);
                    } catch (IOException e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        Closeables.closeSafely(byteArrayOutputStream);
                        Closeables.closeSafely(gZIPInputStream);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(byteArrayOutputStream);
                    Closeables.closeSafely((Closeable) null);
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
                Closeables.closeSafely(byteArrayOutputStream);
                Closeables.closeSafely((Closeable) null);
                throw th;
            }
            Closeables.closeSafely(byteArrayOutputStream);
            Closeables.closeSafely(gZIPInputStream);
        }
    }

    public final void F(c.a.t0.k0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar instanceof n) {
            G(((n) aVar).j());
        } else if (aVar instanceof p) {
            p pVar = (p) aVar;
            H(pVar.i(), Integer.parseInt(pVar.j()));
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f30039c.contains(str)) {
            return;
        }
        this.f30039c.add(str);
    }

    public final void H(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.f30038b.put(i2, Integer.valueOf(i3));
        }
    }

    public final void I(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            long j4 = this.f30041e;
            if ((j2 < j4 || j4 == 0) && j2 != 0) {
                this.f30041e = j2;
            }
            if (j3 > this.f30042f) {
                this.f30042f = j3;
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f30043g = str;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f30044h = z;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 < 0) {
            return;
        }
        this.k = i2;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                c.a.t0.k0.d dVar = new c.a.t0.k0.d(new c.a.t0.k0.c(new FileOutputStream(this.p), 2));
                this.o = dVar;
                JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(dVar));
                this.n = jsonWriter;
                jsonWriter.beginObject();
                this.n.name("data");
                this.n.flush();
                this.o.r();
                this.n.beginArray();
                this.m = 1;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                C();
            } catch (IOException e3) {
                e3.printStackTrace();
                C();
            }
        }
    }

    public void a(Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, set) == null) || this.f30040d.containsAll(set)) {
            return;
        }
        this.f30040d.addAll(set);
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            this.f30037a.put(jSONObject);
        }
    }

    public final boolean c(c.a.t0.k0.a aVar, int i2) {
        InterceptResult invokeLI;
        JsonWriter jsonWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, aVar, i2)) == null) {
            if (!this.l) {
                try {
                    b(aVar.a());
                    F(aVar);
                    D(i2);
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            if (this.m == 0) {
                M();
            }
            if (this.m == 1 && (jsonWriter = this.n) != null) {
                try {
                    aVar.b(jsonWriter);
                    F(aVar);
                    D(i2);
                    return true;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    C();
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? this.f30046j >= i2 : invokeI.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f30038b.clear();
            this.f30039c.clear();
            this.f30037a = null;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            j();
            this.m = 0;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.l) {
            JsonWriter jsonWriter = this.n;
            if (jsonWriter != null) {
                Closeables.closeSafely(jsonWriter);
                this.n = null;
            }
            c.a.t0.k0.d dVar = this.o;
            if (dVar != null) {
                Closeables.closeSafely(dVar);
                this.o = null;
            }
            File file = this.p;
            if (file != null && file.exists()) {
                FileUtils.deleteFile(this.p);
            }
            this.f30038b.clear();
            this.f30039c.clear();
            this.p = null;
            this.q = null;
            this.f30046j = 0;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.l) {
            if (this.f30046j == 0) {
                f();
            }
            if (this.m != 1) {
                C();
                return;
            }
            JsonWriter jsonWriter = this.n;
            try {
                if (jsonWriter != null) {
                    try {
                        jsonWriter.endArray();
                        this.n.flush();
                        this.o.s();
                        if (this.f30041e == 0 || this.f30042f == 0) {
                            this.f30041e = this.f30042f;
                        }
                        String a2 = h0.a(this.o.g(), "", true);
                        if (!TextUtils.isEmpty(a2)) {
                            this.q = a2;
                        }
                        if (r) {
                            String n = this.o.n();
                            if (TextUtils.isEmpty(n)) {
                                String str = "**********UploadData content: " + n;
                            }
                        }
                        this.n.name("metadata");
                        this.n.beginObject();
                        this.n.name("mintime").value(Long.toString(this.f30041e));
                        this.n.name("maxtime").value(Long.toString(this.f30042f));
                        this.n.name("createtime").value(Long.toString(System.currentTimeMillis()));
                        this.n.name("uploadtime").value(Long.toString(System.currentTimeMillis()));
                        this.n.name(PackageTable.MD5).value(a2);
                        this.n.endObject();
                        this.n.name("isAbtest").value(this.f30043g);
                        this.n.name(Constant.IS_REAL).value(this.f30044h ? "1" : "0");
                        this.n.endObject();
                        this.n.flush();
                        Closeables.closeSafely(this.n);
                        if (this.p.exists() && !TextUtils.isEmpty(this.q)) {
                            File file = new File(this.p.getParentFile(), this.q);
                            if (!file.exists()) {
                                if (this.p.renameTo(file)) {
                                    this.p = file;
                                } else if (r) {
                                    String str2 = "rename error for file: " + this.p.getAbsolutePath();
                                }
                            }
                        }
                        this.m = 2;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        C();
                    }
                    Closeables.closeSafely(this.n);
                    Closeables.closeSafely(this.o);
                    this.n = null;
                    this.o = null;
                }
            } catch (Throwable th) {
                Closeables.closeSafely(this.n);
                Closeables.closeSafely(this.o);
                throw th;
            }
        }
    }

    public Set<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f30040d : (Set) invokeV.objValue;
    }

    public JSONArray m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f30037a : (JSONArray) invokeV.objValue;
    }

    public File n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.p : (File) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.l && this.p.exists()) {
                return this.p.getName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final ArrayList p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f30039c : (ArrayList) invokeV.objValue;
    }

    public final SparseArray<Integer> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f30038b : (SparseArray) invokeV.objValue;
    }

    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f30042f : invokeV.longValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f30041e : invokeV.longValue;
    }

    public JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("data", this.f30037a);
                if (this.f30041e == 0 || this.f30042f == 0) {
                    this.f30041e = this.f30042f;
                }
                jSONObject2.put("mintime", Long.toString(this.f30041e));
                jSONObject2.put("maxtime", Long.toString(this.f30042f));
                jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put(PackageTable.MD5, h0.b(this.f30037a.toString().getBytes(), true));
                jSONObject.put("metadata", jSONObject2);
                jSONObject.put("isAbtest", this.f30043g);
                jSONObject.put(Constant.IS_REAL, this.f30044h ? "1" : "0");
            } catch (JSONException unused) {
                boolean z = r;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f30046j : invokeV.intValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.l && this.m == 3 : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!this.l) {
                return this.f30037a.length() == 0;
            }
            int i2 = this.m;
            return !(i2 == 2 || i2 == 1) || this.f30046j == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f30046j >= this.k : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f30045i : invokeV.booleanValue;
    }

    public j0(File file) {
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
        this.f30040d = new HashSet();
        this.f30044h = false;
        this.f30045i = false;
        this.f30046j = 0;
        this.k = 614400;
        this.l = false;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.q = null;
        this.f30037a = new JSONArray();
        this.f30038b = new SparseArray<>();
        this.f30039c = new ArrayList<>();
        this.f30041e = 0L;
        this.f30042f = 0L;
        this.f30043g = "0";
        if (file != null) {
            this.p = file;
            this.l = true;
        }
    }

    public j0(File file, int i2) {
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
        this.f30040d = new HashSet();
        this.f30044h = false;
        this.f30045i = false;
        this.f30046j = 0;
        this.k = 614400;
        this.l = false;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.q = null;
        this.p = file;
        this.l = true;
        this.f30046j = i2;
    }
}
