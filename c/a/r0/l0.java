package c.a.r0;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
/* loaded from: classes3.dex */
public class l0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Integer> f21170b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f21171c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f21172d;

    /* renamed from: e  reason: collision with root package name */
    public long f21173e;

    /* renamed from: f  reason: collision with root package name */
    public long f21174f;

    /* renamed from: g  reason: collision with root package name */
    public String f21175g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21176h;
    public boolean i;
    public int j;
    public long k;
    public int l;
    public boolean m;
    public int n;
    public JsonWriter o;
    public c.a.r0.p0.c p;
    public c.a.r0.p0.d q;
    public File r;
    public String s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1128863028, "Lc/a/r0/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1128863028, "Lc/a/r0/l0;");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21172d = new HashSet();
        this.f21176h = false;
        this.i = false;
        this.j = 0;
        this.k = 0L;
        this.l = 614400;
        this.m = false;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.a = new JSONArray();
        this.f21170b = new SparseArray<>();
        this.f21171c = new ArrayList<>();
        this.f21173e = 0L;
        this.f21174f = 0L;
        this.f21175g = "0";
    }

    public static l0 g(File file, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, file, i)) == null) ? new l0(file, i) : (l0) invokeLI.objValue;
    }

    public static l0 h(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? new l0() : (l0) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21176h : invokeV.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i = true;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j();
            this.n = 3;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i <= 0) {
            return;
        }
        this.j += i;
    }

    public void F(String str) {
        GZIPInputStream gZIPInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || !t) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream2 = null;
        try {
            try {
                gZIPInputStream = new GZIPInputStream(new c.a.r0.p0.b(new FileInputStream(this.r), 0));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 4096);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str2 = new String(byteArrayOutputStream.toByteArray());
                    Log.d(str, "*************print upload log start***********");
                    Log.d(str, str2);
                    Log.d(str, "*************print upload log end***********");
                    c.a.r0.q0.a.b(byteArrayOutputStream);
                    c.a.r0.q0.a.b(gZIPInputStream);
                    return;
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            gZIPInputStream2 = gZIPInputStream;
            e.printStackTrace();
            c.a.r0.q0.a.b(byteArrayOutputStream);
            c.a.r0.q0.a.b(gZIPInputStream2);
        } catch (IOException e5) {
            e = e5;
            gZIPInputStream2 = gZIPInputStream;
            e.printStackTrace();
            c.a.r0.q0.a.b(byteArrayOutputStream);
            c.a.r0.q0.a.b(gZIPInputStream2);
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            c.a.r0.q0.a.b(byteArrayOutputStream);
            c.a.r0.q0.a.b(gZIPInputStream2);
            throw th;
        }
    }

    public final void G(c.a.r0.p0.a aVar) {
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.f21171c.contains(str)) {
            return;
        }
        this.f21171c.add(str);
    }

    public final void I(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.f21170b.put(i, Integer.valueOf(i2));
        }
    }

    public final void J(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            long j3 = this.f21173e;
            if ((j < j3 || j3 == 0) && j != 0) {
                this.f21173e = j;
            }
            if (j2 > this.f21174f) {
                this.f21174f = j2;
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f21175g = str;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f21176h = z;
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i < 0) {
            return;
        }
        this.l = i;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                c.a.r0.p0.c cVar = new c.a.r0.p0.c(new FileOutputStream(this.r), 2);
                this.p = cVar;
                c.a.r0.p0.d dVar = new c.a.r0.p0.d(cVar);
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
        if (!(interceptable == null || interceptable.invokeL(1048590, this, set) == null) || this.f21172d.containsAll(set)) {
            return;
        }
        this.f21172d.addAll(set);
    }

    public final void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            this.a.put(jSONObject);
        }
    }

    public final boolean c(c.a.r0.p0.a aVar, int i) {
        InterceptResult invokeLI;
        JsonWriter jsonWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, aVar, i)) == null) {
            if (!this.m) {
                try {
                    b(aVar.a());
                    G(aVar);
                    E(i);
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
                    E(i);
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

    public boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? this.j >= i : invokeI.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f21170b.clear();
            this.f21171c.clear();
            this.a = null;
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
                c.a.r0.q0.a.b(jsonWriter);
                this.o = null;
            }
            c.a.r0.p0.d dVar = this.q;
            if (dVar != null) {
                c.a.r0.q0.a.b(dVar);
                this.q = null;
                this.p = null;
            }
            File file = this.r;
            if (file != null && file.exists()) {
                c.a.r0.q0.b.a(this.r);
            }
            this.f21170b.clear();
            this.f21171c.clear();
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
            try {
                if (jsonWriter != null) {
                    try {
                        jsonWriter.endArray();
                        this.o.flush();
                        this.q.g();
                        if (this.f21173e == 0 || this.f21174f == 0) {
                            this.f21173e = this.f21174f;
                        }
                        String b2 = j0.b(this.q.a(), "", true);
                        if (!TextUtils.isEmpty(b2)) {
                            this.s = b2;
                        }
                        if (t) {
                            String c2 = this.q.c();
                            if (TextUtils.isEmpty(c2)) {
                                Log.d("UBCUploadData", "**********UploadData content: " + c2);
                            }
                        }
                        this.o.name(TtmlNode.TAG_METADATA);
                        this.o.beginObject();
                        this.o.name("mintime").value(Long.toString(this.f21173e));
                        this.o.name("maxtime").value(Long.toString(this.f21174f));
                        this.o.name("createtime").value(Long.toString(System.currentTimeMillis()));
                        this.o.name("uploadtime").value(Long.toString(System.currentTimeMillis()));
                        this.o.name(PackageTable.MD5).value(b2);
                        this.o.endObject();
                        this.o.name("isAbtest").value(this.f21175g);
                        this.o.name(Constant.IS_REAL).value(this.f21176h ? "1" : "0");
                        this.o.endObject();
                        this.o.flush();
                        c.a.r0.q0.a.b(this.o);
                        this.k = this.p.a();
                        if (this.r.exists() && !TextUtils.isEmpty(this.s)) {
                            File file = new File(this.r.getParentFile(), this.s);
                            if (!file.exists()) {
                                if (this.r.renameTo(file)) {
                                    this.r = file;
                                } else if (t) {
                                    Log.e("UBCUploadData", "rename error for file: " + this.r.getAbsolutePath());
                                }
                            }
                        }
                        this.n = 2;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        D();
                    }
                    c.a.r0.q0.a.b(this.o);
                    c.a.r0.q0.a.b(this.q);
                    this.o = null;
                    this.p = null;
                    this.q = null;
                }
            } catch (Throwable th) {
                c.a.r0.q0.a.b(this.o);
                c.a.r0.q0.a.b(this.q);
                throw th;
            }
        }
    }

    public Set<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f21172d : (Set) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k : invokeV.longValue;
    }

    public JSONArray n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.a : (JSONArray) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f21171c : (ArrayList) invokeV.objValue;
    }

    public final SparseArray<Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f21170b : (SparseArray) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f21174f : invokeV.longValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f21173e : invokeV.longValue;
    }

    public JSONObject u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("data", this.a);
                if (this.f21173e == 0 || this.f21174f == 0) {
                    this.f21173e = this.f21174f;
                }
                jSONObject2.put("mintime", Long.toString(this.f21173e));
                jSONObject2.put("maxtime", Long.toString(this.f21174f));
                jSONObject2.put("createtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                jSONObject2.put(PackageTable.MD5, j0.c(this.a.toString().getBytes(), true));
                jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                jSONObject.put("isAbtest", this.f21175g);
                jSONObject.put(Constant.IS_REAL, this.f21176h ? "1" : "0");
            } catch (JSONException unused) {
                if (t) {
                    Log.d("UBCUploadData", "json exception:");
                }
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
                return this.a.length() == 0;
            }
            int i = this.n;
            return !(i == 2 || i == 1) || this.j == 0;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f21172d = new HashSet();
        this.f21176h = false;
        this.i = false;
        this.j = 0;
        this.k = 0L;
        this.l = 614400;
        this.m = false;
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.a = new JSONArray();
        this.f21170b = new SparseArray<>();
        this.f21171c = new ArrayList<>();
        this.f21173e = 0L;
        this.f21174f = 0L;
        this.f21175g = "0";
        if (file != null) {
            this.r = file;
            this.m = true;
        }
    }

    public l0(File file, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f21172d = new HashSet();
        this.f21176h = false;
        this.i = false;
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
        this.j = i;
    }
}
