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
    public static boolean f4043g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4044a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0100a f4045b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f4046c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f4047d;

    /* renamed from: e  reason: collision with root package name */
    public b f4048e;

    /* renamed from: f  reason: collision with root package name */
    public f f4049f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f4050g;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f4051a;

        /* renamed from: b  reason: collision with root package name */
        public String f4052b;

        /* renamed from: c  reason: collision with root package name */
        public String f4053c;

        /* renamed from: d  reason: collision with root package name */
        public long f4054d;

        /* renamed from: e  reason: collision with root package name */
        public String f4055e;

        /* renamed from: f  reason: collision with root package name */
        public int f4056f;

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
            f4050g = new String[]{"V", "O", "0"};
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
            this.f4056f = 1;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4051a : (String) invokeV.objValue;
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
                if (this.f4056f == aVar.f4056f && this.f4051a.equals(aVar.f4051a) && this.f4052b.equals(aVar.f4052b) && this.f4053c.equals(aVar.f4053c)) {
                    String str = this.f4055e;
                    String str2 = aVar.f4055e;
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

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4055e : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Arrays.hashCode(new Object[]{this.f4051a, this.f4052b, this.f4053c, this.f4055e, Integer.valueOf(this.f4056f)}) : invokeV.intValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4052b : (String) invokeV.objValue;
        }

        public j l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                j jVar = new j();
                jVar.f4037a = this.f4051a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4052b);
                if ("V".equals(this.f4052b)) {
                    sb.append(this.f4053c);
                }
                if (!TextUtils.isEmpty(this.f4055e)) {
                    sb.append(this.f4055e);
                }
                jVar.f4038b = sb.toString().trim();
                return jVar;
            }
            return (j) invokeV.objValue;
        }

        public String m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.f4051a);
                    jSONObject.put("v270fk", this.f4052b);
                    jSONObject.put("cck", this.f4053c);
                    jSONObject.put("vsk", this.f4056f);
                    jSONObject.put("ctk", this.f4054d);
                    jSONObject.put("ek", this.f4055e);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    c.a.m.i.c.c(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = this.f4052b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4051a);
                sb.append("|");
                sb.append(str);
                if ("V".equals(str)) {
                    sb.append(this.f4053c);
                }
                if (!TextUtils.isEmpty(this.f4055e)) {
                    sb.append(this.f4055e);
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
        this.f4044a = context.getApplicationContext();
        a.C0100a b2 = aVar.e().b("bohrium");
        this.f4045b = b2;
        b2.d();
        this.f4049f = fVar;
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
                String optString3 = jSONObject.optString("ek", "");
                String optString4 = jSONObject.optString("v270fk", "V");
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.f4051a = optString;
                    aVar.f4053c = optString2;
                    aVar.f4054d = optLong;
                    aVar.f4056f = optInt;
                    aVar.f4055e = optString3;
                    aVar.f4052b = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                c.a.m.i.c.c(e2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a e(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String m = m(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.f4051a = str;
                    aVar.f4053c = m;
                    aVar.f4054d = currentTimeMillis;
                    aVar.f4056f = 1;
                    aVar.f4055e = str3;
                    aVar.f4052b = str2;
                    return aVar;
                } catch (Exception e2) {
                    c.a.m.i.c.c(e2);
                }
            }
            return null;
        }
        return (a) invokeLLL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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
            if (new File(this.f4045b.f(), "libbh.so").exists()) {
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
                aVar.f4054d = System.currentTimeMillis();
                aVar.f4056f = 1;
                try {
                    boolean z = false;
                    aVar.f4052b = jVar.f4038b.substring(0, 1);
                    aVar.f4051a = jVar.f4037a;
                    aVar.f4053c = m(jVar.f4037a);
                    String[] strArr = a.f4050g;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f4052b)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = jVar.f4038b) != null && str.length() >= 2) {
                        aVar.f4055e = jVar.f4038b.substring(1);
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
            c.a.m.b.a a2 = this.f4048e.a(str2);
            a.g gVar = new a.g();
            gVar.f3923a = true;
            a.h b2 = a2.b(str, gVar);
            if (b2 == null || !b2.c()) {
                return null;
            }
            return b2.f3924a;
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
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f4045b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public final void h(c.a.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            b bVar = new b(new c());
            a.b bVar2 = new a.b();
            bVar2.f3918a = this.f4044a;
            bVar2.f3919b = aVar;
            a.d dVar = new a.d();
            for (c.a.m.b.a aVar2 : bVar.b()) {
                aVar2.d(bVar2);
                aVar2.e(dVar);
            }
            this.f4048e = bVar;
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            a.e eVar = new a.e();
            for (c.a.m.b.a aVar2 : this.f4048e.b()) {
                aVar2.a(eVar, aVar);
            }
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.f4051a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.f4045b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
                        String n = c2.n();
                        if (!TextUtils.isEmpty(n) && n.equals(aVar.n())) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return this.f4045b.e("libbh.so", aVar.m(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String f2 = f(this.f4044a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (f4043g) {
                    String str3 = "uuid: " + uuid;
                }
                str2 = str + f2 + uuid;
            } else {
                str2 = "com.baidu" + f2;
            }
            String b2 = f.c.b(str2.getBytes(), true);
            a aVar = new a();
            aVar.f4054d = System.currentTimeMillis();
            aVar.f4056f = 1;
            aVar.f4051a = b2;
            aVar.f4052b = "V";
            aVar.f4053c = m(b2);
            aVar.f4055e = null;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public synchronized boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                File g2 = this.f4045b.g(".lock");
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
                                this.f4046c = randomAccessFile2.getChannel().lock();
                                this.f4047d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            randomAccessFile = randomAccessFile2;
                            c.a.m.i.c.c(e);
                            if (this.f4046c == null) {
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

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (this.f4046c != null) {
                    try {
                        this.f4046c.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f4046c = null;
                }
                c.a.m.i.c.b(this.f4047d);
                this.f4047d = null;
            }
        }
    }

    public a o() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a.g gVar = new a.g();
            gVar.f3923a = true;
            List<c.a.m.b.a> b2 = this.f4048e.b();
            Collections.sort(b2, c.a.m.b.a.f3913e);
            List<e> h2 = this.f4049f.h(this.f4044a);
            if (h2 != null) {
                for (e eVar : h2) {
                    if (!eVar.f4022d && eVar.f4021c) {
                        for (c.a.m.b.a aVar2 : b2) {
                            a.h b3 = aVar2.b(eVar.f4019a.packageName, gVar);
                            if (b3 != null && b3.c() && (aVar = b3.f3924a) != null) {
                                return aVar;
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (a) invokeV.objValue;
    }
}
