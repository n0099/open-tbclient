package c.a.m;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.i.a;
import c.a.m.l.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4254g;

    /* renamed from: h  reason: collision with root package name */
    public static String f4255h;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0199a f4256b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f4257c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f4258d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.m.i.b f4259e;

    /* renamed from: f  reason: collision with root package name */
    public c f4260f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] k;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f4261b;

        /* renamed from: c  reason: collision with root package name */
        public String f4262c;

        /* renamed from: d  reason: collision with root package name */
        public long f4263d;

        /* renamed from: e  reason: collision with root package name */
        public String f4264e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4265f;

        /* renamed from: g  reason: collision with root package name */
        public String f4266g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4267h;

        /* renamed from: i  reason: collision with root package name */
        public String f4268i;

        /* renamed from: j  reason: collision with root package name */
        public int f4269j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1271331681, "Lc/a/m/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1271331681, "Lc/a/m/g$a;");
                    return;
                }
            }
            k = new String[]{"V", "O", "0"};
        }

        public a() {
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
            this.f4267h = true;
            this.f4269j = 1;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = g.n();
                if (TextUtils.isEmpty(n)) {
                    return;
                }
                this.f4265f = true;
                this.f4266g = n;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f4269j == aVar.f4269j && this.a.equals(aVar.a) && this.f4261b.equals(aVar.f4261b) && this.f4262c.equals(aVar.f4262c) && this.f4265f == aVar.f4265f && this.f4266g.equals(aVar.f4266g)) {
                    String str = this.f4264e;
                    String str2 = aVar.f4264e;
                    if (str == str2) {
                        return true;
                    }
                    if (str != null && str.equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f4268i = str;
            }
        }

        public synchronized void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                synchronized (this) {
                    this.f4267h = z;
                }
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(new Object[]{this.a, this.f4261b, this.f4262c, Boolean.valueOf(this.f4265f), this.f4266g, this.f4264e, Integer.valueOf(this.f4269j)}) : invokeV.intValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4265f : invokeV.booleanValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4264e : (String) invokeV.objValue;
        }

        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                String str = this.f4261b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f4262c);
                }
                if (!TextUtils.isEmpty(this.f4264e)) {
                    sb.append(this.f4264e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }

        public String t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4268i : (String) invokeV.objValue;
        }

        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f4266g : (String) invokeV.objValue;
        }

        public String v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f4261b : (String) invokeV.objValue;
        }

        public synchronized boolean w() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                synchronized (this) {
                    z = this.f4267h;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.a);
                    jSONObject.put("v270fk", this.f4261b);
                    jSONObject.put("cck", this.f4262c);
                    jSONObject.put("vsk", this.f4269j);
                    jSONObject.put("ctk", this.f4263d);
                    jSONObject.put("csk", this.f4265f);
                    if (!TextUtils.isEmpty(this.f4266g)) {
                        jSONObject.put("pmk", this.f4266g);
                    }
                    if (!TextUtils.isEmpty(this.f4268i)) {
                        jSONObject.put("ock", this.f4268i);
                    }
                    jSONObject.put("hrk", this.f4267h);
                    jSONObject.put("ek", this.f4264e);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    c.a.m.m.c.c(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public e y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                e eVar = new e();
                eVar.a = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4261b);
                if ("V".equals(this.f4261b)) {
                    sb.append(this.f4262c);
                }
                if (!TextUtils.isEmpty(this.f4264e)) {
                    sb.append(this.f4264e);
                }
                eVar.f4250b = sb.toString().trim();
                return eVar;
            }
            return (e) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1896292868, "Lc/a/m/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1896292868, "Lc/a/m/g;");
        }
    }

    public g(Context context, c.a.m.l.a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.a = context.getApplicationContext();
        a.C0199a f2 = aVar.f().f("bohrium");
        this.f4256b = f2;
        f2.d();
        this.f4260f = cVar;
        h(aVar);
    }

    public static a c(String str, String str2, String str3, boolean z, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4})) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String e2 = e(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.a = str;
                    aVar.f4262c = e2;
                    aVar.f4263d = currentTimeMillis;
                    aVar.f4269j = 1;
                    aVar.f4264e = str3;
                    aVar.f4261b = str2;
                    aVar.f4265f = z;
                    aVar.f4266g = str4;
                    return aVar;
                } catch (Exception e3) {
                    c.a.m.m.c.c(e3);
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return new c.a.m.m.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new c.a.m.h.a().a(str.getBytes("UTF-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static a l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("dik", "");
                String optString2 = jSONObject.optString("cck", "");
                long optLong = jSONObject.optLong("ctk", 0L);
                int optInt = jSONObject.optInt("vsk", 1);
                boolean optBoolean = jSONObject.optBoolean("csk", false);
                String optString3 = jSONObject.optString("pmk", "");
                boolean optBoolean2 = jSONObject.optBoolean("hrk", true);
                String optString4 = jSONObject.optString("ock", null);
                String optString5 = jSONObject.optString("ek", "");
                String optString6 = jSONObject.optString("v270fk", "V");
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.a = optString;
                    aVar.f4262c = optString2;
                    aVar.f4263d = optLong;
                    aVar.f4269j = optInt;
                    aVar.f4264e = optString5;
                    aVar.f4261b = optString6;
                    aVar.f4265f = optBoolean;
                    aVar.f4266g = optString3;
                    aVar.f4267h = optBoolean2;
                    aVar.f4268i = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                c.a.m.m.c.c(e2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = f4255h;
            if (str != null) {
                return str;
            }
            if (TextUtils.isEmpty(Build.MODEL)) {
                return "";
            }
            String substring = c.a.m.k.b.b(Build.MODEL.getBytes(), false).substring(3, 15);
            f4255h = substring;
            return substring;
        }
        return (String) invokeV.objValue;
    }

    public a a(e eVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            if (eVar != null) {
                a aVar = new a();
                aVar.f4263d = System.currentTimeMillis();
                aVar.f4269j = 1;
                try {
                    boolean z = false;
                    aVar.f4261b = eVar.f4250b.substring(0, 1);
                    aVar.a = eVar.a;
                    aVar.f4262c = e(eVar.a);
                    String[] strArr = a.k;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f4261b)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = eVar.f4250b) != null && str.length() >= 2) {
                        aVar.f4264e = eVar.f4250b.substring(1);
                    }
                    return aVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        return (a) invokeL.objValue;
    }

    public a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            c.a.m.i.a a2 = this.f4259e.a(str2);
            a.g gVar = new a.g();
            gVar.a = true;
            a.h b2 = a2.b(str, gVar);
            if (b2 == null || !b2.d()) {
                return null;
            }
            return b2.a;
        }
        return (a) invokeLL.objValue;
    }

    public final String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    public final String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? this.f4256b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            a.e eVar = new a.e();
            for (c.a.m.i.a aVar2 : this.f4259e.b()) {
                aVar2.a(eVar, aVar);
            }
        }
    }

    public final void h(c.a.m.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            c.a.m.i.b bVar = new c.a.m.i.b(new c.a.m.a());
            a.b bVar2 = new a.b();
            bVar2.a = this.a;
            bVar2.f4285b = aVar;
            a.d dVar = new a.d();
            for (c.a.m.i.a aVar2 : bVar.b()) {
                aVar2.d(bVar2);
                aVar2.e(dVar);
            }
            this.f4259e = bVar;
        }
    }

    public synchronized boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                File b2 = this.f4256b.b(".lock");
                if (!b2.exists()) {
                    try {
                        b2.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                RandomAccessFile randomAccessFile = null;
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(b2, "rw");
                    for (int i2 = 0; i2 < 100; i2++) {
                        try {
                            try {
                                this.f4257c = randomAccessFile2.getChannel().lock();
                                this.f4258d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            randomAccessFile = randomAccessFile2;
                            c.a.m.m.c.c(e);
                            if (this.f4257c == null) {
                                c.a.m.m.c.b(randomAccessFile);
                            }
                            return false;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.f4256b.g(), "libbh.so").exists() && (l = l(f(true))) != null) {
                        String r = l.r();
                        boolean z3 = !TextUtils.isEmpty(r) && r.equals(aVar.r());
                        boolean z4 = l.m() && !TextUtils.isEmpty(l.u()) && TextUtils.equals(l.u(), n());
                        if (z3 && z4) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return this.f4256b.e("libbh.so", aVar.x(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (new File(this.f4256b.g(), "libbh.so").exists()) {
                return l(f(true));
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public a m(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String d2 = d(this.a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (f4254g) {
                    String str3 = "uuid: " + uuid;
                }
                str2 = str + d2 + uuid;
            } else {
                str2 = "com.baidu" + d2;
            }
            String b2 = c.a.m.k.b.b(str2.getBytes(), true);
            String n = n();
            a aVar = new a();
            aVar.f4263d = System.currentTimeMillis();
            aVar.f4269j = 1;
            aVar.a = b2;
            aVar.f4261b = "V";
            aVar.f4262c = e(b2);
            aVar.f4265f = true;
            aVar.f4266g = n;
            aVar.f4264e = null;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public a o(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            a.g gVar = new a.g();
            gVar.a = true;
            List<c.a.m.i.a> b2 = this.f4259e.b();
            Collections.sort(b2, c.a.m.i.a.f4281e);
            List<b> h2 = this.f4260f.h(this.a);
            if (h2 != null) {
                for (b bVar : h2) {
                    if (!bVar.f4248d && bVar.f4247c) {
                        for (c.a.m.i.a aVar2 : b2) {
                            a.h b3 = aVar2.b(bVar.a.packageName, gVar);
                            if (b3 != null && b3.d() && (aVar = b3.a) != null && !TextUtils.equals(aVar.n(), str)) {
                                if (!(aVar.m() && !TextUtils.equals(n(), aVar.u()))) {
                                    return b3.a;
                                }
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.f4257c != null) {
                    try {
                        this.f4257c.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f4257c = null;
                }
                c.a.m.m.c.b(this.f4258d);
                this.f4258d = null;
            }
        }
    }
}
