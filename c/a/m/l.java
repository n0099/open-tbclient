package c.a.m;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.m.b.a;
import c.a.m.b.b;
import c.a.m.f;
import c.a.m.g.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4049g;

    /* renamed from: h  reason: collision with root package name */
    public static String f4050h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4051a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0100a f4052b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f4053c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f4054d;

    /* renamed from: e  reason: collision with root package name */
    public b f4055e;

    /* renamed from: f  reason: collision with root package name */
    public f f4056f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] k;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4057a;

        /* renamed from: b  reason: collision with root package name */
        public String f4058b;

        /* renamed from: c  reason: collision with root package name */
        public String f4059c;

        /* renamed from: d  reason: collision with root package name */
        public long f4060d;

        /* renamed from: e  reason: collision with root package name */
        public String f4061e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4062f;

        /* renamed from: g  reason: collision with root package name */
        public String f4063g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4064h;

        /* renamed from: i  reason: collision with root package name */
        public String f4065i;

        /* renamed from: j  reason: collision with root package name */
        public int f4066j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1271182726, "Lc/a/m/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1271182726, "Lc/a/m/l$a;");
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
            this.f4064h = true;
            this.f4066j = 1;
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4065i = str;
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
                if (this.f4066j == aVar.f4066j && this.f4057a.equals(aVar.f4057a) && this.f4058b.equals(aVar.f4058b) && this.f4059c.equals(aVar.f4059c) && this.f4062f == aVar.f4062f && this.f4063g.equals(aVar.f4063g)) {
                    String str = this.f4061e;
                    String str2 = aVar.f4061e;
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

        public synchronized void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                synchronized (this) {
                    this.f4064h = z;
                }
            }
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4057a : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(new Object[]{this.f4057a, this.f4058b, this.f4059c, Boolean.valueOf(this.f4062f), this.f4063g, this.f4061e, Integer.valueOf(this.f4066j)}) : invokeV.intValue;
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4061e : (String) invokeV.objValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f4058b : (String) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4062f : invokeV.booleanValue;
        }

        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f4063g : (String) invokeV.objValue;
        }

        public synchronized boolean t() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                synchronized (this) {
                    z = this.f4064h;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f4065i : (String) invokeV.objValue;
        }

        public void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                String l = l.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                this.f4062f = true;
                this.f4063g = l;
            }
        }

        public j w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                j jVar = new j();
                jVar.f4043a = this.f4057a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4058b);
                if ("V".equals(this.f4058b)) {
                    sb.append(this.f4059c);
                }
                if (!TextUtils.isEmpty(this.f4061e)) {
                    sb.append(this.f4061e);
                }
                jVar.f4044b = sb.toString().trim();
                return jVar;
            }
            return (j) invokeV.objValue;
        }

        public String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.f4057a);
                    jSONObject.put("v270fk", this.f4058b);
                    jSONObject.put("cck", this.f4059c);
                    jSONObject.put("vsk", this.f4066j);
                    jSONObject.put("ctk", this.f4060d);
                    jSONObject.put("csk", this.f4062f);
                    if (!TextUtils.isEmpty(this.f4063g)) {
                        jSONObject.put("pmk", this.f4063g);
                    }
                    if (!TextUtils.isEmpty(this.f4065i)) {
                        jSONObject.put("ock", this.f4065i);
                    }
                    jSONObject.put("hrk", this.f4064h);
                    jSONObject.put("ek", this.f4061e);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    c.a.m.i.c.c(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                String str = this.f4058b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4057a);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f4059c);
                }
                if (!TextUtils.isEmpty(this.f4061e)) {
                    sb.append(this.f4061e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1896292713, "Lc/a/m/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1896292713, "Lc/a/m/l;");
        }
    }

    public l(Context context, c.a.m.g.a aVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, fVar};
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
        this.f4051a = context.getApplicationContext();
        a.C0100a b2 = aVar.e().b("bohrium");
        this.f4052b = b2;
        b2.d();
        this.f4056f = fVar;
        h(aVar);
    }

    public static a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
                    aVar.f4057a = optString;
                    aVar.f4059c = optString2;
                    aVar.f4060d = optLong;
                    aVar.f4066j = optInt;
                    aVar.f4061e = optString5;
                    aVar.f4058b = optString6;
                    aVar.f4062f = optBoolean;
                    aVar.f4063g = optString3;
                    aVar.f4064h = optBoolean2;
                    aVar.f4065i = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                c.a.m.i.c.c(e2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a e(String str, String str2, String str3, boolean z, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4})) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String o = o(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.f4057a = str;
                    aVar.f4059c = o;
                    aVar.f4060d = currentTimeMillis;
                    aVar.f4066j = 1;
                    aVar.f4061e = str3;
                    aVar.f4058b = str2;
                    aVar.f4062f = z;
                    aVar.f4063g = str4;
                    return aVar;
                } catch (Exception e2) {
                    c.a.m.i.c.c(e2);
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = f4050h;
            if (str != null) {
                return str;
            }
            if (TextUtils.isEmpty(Build.MODEL)) {
                return "";
            }
            String substring = f.c.b(Build.MODEL.getBytes(), false).substring(3, 15);
            f4050h = substring;
            return substring;
        }
        return (String) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return new c.a.m.i.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new c.a.m.a.a().a(str.getBytes("UTF-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (new File(this.f4052b.f(), "libbh.so").exists()) {
                return c(g(true));
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public a b(j jVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
            if (jVar != null) {
                a aVar = new a();
                aVar.f4060d = System.currentTimeMillis();
                aVar.f4066j = 1;
                try {
                    boolean z = false;
                    aVar.f4058b = jVar.f4044b.substring(0, 1);
                    aVar.f4057a = jVar.f4043a;
                    aVar.f4059c = o(jVar.f4043a);
                    String[] strArr = a.k;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f4058b)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = jVar.f4044b) != null && str.length() >= 2) {
                        aVar.f4061e = jVar.f4044b.substring(1);
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

    public a d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            c.a.m.b.a a2 = this.f4055e.a(str2);
            a.g gVar = new a.g();
            gVar.f3927a = true;
            a.h b2 = a2.b(str, gVar);
            if (b2 == null || !b2.c()) {
                return null;
            }
            return b2.f3928a;
        }
        return (a) invokeLL.objValue;
    }

    public final String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    public final String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f4052b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public final void h(c.a.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            b bVar = new b(new c());
            a.b bVar2 = new a.b();
            bVar2.f3922a = this.f4051a;
            bVar2.f3923b = aVar;
            a.d dVar = new a.d();
            for (c.a.m.b.a aVar2 : bVar.b()) {
                aVar2.d(bVar2);
                aVar2.e(dVar);
            }
            this.f4055e = bVar;
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            a.e eVar = new a.e();
            for (c.a.m.b.a aVar2 : this.f4055e.b()) {
                aVar2.a(eVar, aVar);
            }
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.f4057a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.f4052b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
                        String y = c2.y();
                        boolean z3 = !TextUtils.isEmpty(y) && y.equals(aVar.y());
                        boolean z4 = c2.q() && !TextUtils.isEmpty(c2.r()) && TextUtils.equals(c2.r(), l());
                        if (z3 && z4) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return this.f4052b.e("libbh.so", aVar.x(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String f2 = f(this.f4051a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (f4049g) {
                    String str3 = "uuid: " + uuid;
                }
                str2 = str + f2 + uuid;
            } else {
                str2 = "com.baidu" + f2;
            }
            String b2 = f.c.b(str2.getBytes(), true);
            String l = l();
            a aVar = new a();
            aVar.f4060d = System.currentTimeMillis();
            aVar.f4066j = 1;
            aVar.f4057a = b2;
            aVar.f4058b = "V";
            aVar.f4059c = o(b2);
            aVar.f4062f = true;
            aVar.f4063g = l;
            aVar.f4061e = null;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public a m(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            a.g gVar = new a.g();
            gVar.f3927a = true;
            List<c.a.m.b.a> b2 = this.f4055e.b();
            Collections.sort(b2, c.a.m.b.a.f3917e);
            List<e> h2 = this.f4056f.h(this.f4051a);
            if (h2 != null) {
                for (e eVar : h2) {
                    if (!eVar.f4028d && eVar.f4027c) {
                        for (c.a.m.b.a aVar2 : b2) {
                            a.h b3 = aVar2.b(eVar.f4025a.packageName, gVar);
                            if (b3 != null && b3.c() && (aVar = b3.f3928a) != null && !TextUtils.equals(aVar.h(), str)) {
                                if (!(aVar.q() && !TextUtils.equals(l(), aVar.r()))) {
                                    return b3.f3928a;
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

    public synchronized boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                File g2 = this.f4052b.g(".lock");
                if (!g2.exists()) {
                    try {
                        g2.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                RandomAccessFile randomAccessFile = null;
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(g2, "rw");
                    for (int i2 = 0; i2 < 100; i2++) {
                        try {
                            try {
                                this.f4053c = randomAccessFile2.getChannel().lock();
                                this.f4054d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            randomAccessFile = randomAccessFile2;
                            c.a.m.i.c.c(e);
                            if (this.f4053c == null) {
                                c.a.m.i.c.b(randomAccessFile);
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

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.f4053c != null) {
                    try {
                        this.f4053c.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f4053c = null;
                }
                c.a.m.i.c.b(this.f4054d);
                this.f4054d = null;
            }
        }
    }
}
