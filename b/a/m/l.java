package b.a.m;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.m.b.a;
import b.a.m.b.b;
import b.a.m.f;
import b.a.m.g.a;
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
    public static boolean f3456g;

    /* renamed from: h  reason: collision with root package name */
    public static String f3457h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3458a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0095a f3459b;

    /* renamed from: c  reason: collision with root package name */
    public volatile FileLock f3460c;

    /* renamed from: d  reason: collision with root package name */
    public volatile RandomAccessFile f3461d;

    /* renamed from: e  reason: collision with root package name */
    public b f3462e;

    /* renamed from: f  reason: collision with root package name */
    public f f3463f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] k;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f3464a;

        /* renamed from: b  reason: collision with root package name */
        public String f3465b;

        /* renamed from: c  reason: collision with root package name */
        public String f3466c;

        /* renamed from: d  reason: collision with root package name */
        public long f3467d;

        /* renamed from: e  reason: collision with root package name */
        public String f3468e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3469f;

        /* renamed from: g  reason: collision with root package name */
        public String f3470g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f3471h;

        /* renamed from: i  reason: collision with root package name */
        public String f3472i;
        public int j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1074669221, "Lb/a/m/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1074669221, "Lb/a/m/l$a;");
                    return;
                }
            }
            k = new String[]{ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};
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
            this.f3471h = true;
            this.j = 1;
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f3472i = str;
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
                if (this.j == aVar.j && this.f3464a.equals(aVar.f3464a) && this.f3465b.equals(aVar.f3465b) && this.f3466c.equals(aVar.f3466c) && this.f3469f == aVar.f3469f && this.f3470g.equals(aVar.f3470g)) {
                    String str = this.f3468e;
                    String str2 = aVar.f3468e;
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
                    this.f3471h = z;
                }
            }
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3464a : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Arrays.hashCode(new Object[]{this.f3464a, this.f3465b, this.f3466c, Boolean.valueOf(this.f3469f), this.f3470g, this.f3468e, Integer.valueOf(this.j)}) : invokeV.intValue;
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f3468e : (String) invokeV.objValue;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3465b : (String) invokeV.objValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3469f : invokeV.booleanValue;
        }

        public String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3470g : (String) invokeV.objValue;
        }

        public synchronized boolean t() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                synchronized (this) {
                    z = this.f3471h;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3472i : (String) invokeV.objValue;
        }

        public void v() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                String l = l.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                this.f3469f = true;
                this.f3470g = l;
            }
        }

        public j w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                j jVar = new j();
                jVar.f3450a = this.f3464a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f3465b);
                if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.f3465b)) {
                    sb.append(this.f3466c);
                }
                if (!TextUtils.isEmpty(this.f3468e)) {
                    sb.append(this.f3468e);
                }
                jVar.f3451b = sb.toString().trim();
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
                    jSONObject.put("dik", this.f3464a);
                    jSONObject.put("v270fk", this.f3465b);
                    jSONObject.put("cck", this.f3466c);
                    jSONObject.put("vsk", this.j);
                    jSONObject.put("ctk", this.f3467d);
                    jSONObject.put("csk", this.f3469f);
                    if (!TextUtils.isEmpty(this.f3470g)) {
                        jSONObject.put("pmk", this.f3470g);
                    }
                    if (!TextUtils.isEmpty(this.f3472i)) {
                        jSONObject.put("ock", this.f3472i);
                    }
                    jSONObject.put("hrk", this.f3471h);
                    jSONObject.put("ek", this.f3468e);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    b.a.m.i.c.c(e2);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }

        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                String str = this.f3465b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f3464a);
                sb.append("|");
                sb.append(str);
                if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                    sb.append(this.f3466c);
                }
                if (!TextUtils.isEmpty(this.f3468e)) {
                    sb.append(this.f3468e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(655864248, "Lb/a/m/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(655864248, "Lb/a/m/l;");
        }
    }

    public l(Context context, b.a.m.g.a aVar, f fVar) {
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
        this.f3458a = context.getApplicationContext();
        a.C0095a b2 = aVar.e().b("bohrium");
        this.f3459b = b2;
        b2.d();
        this.f3463f = fVar;
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
                String optString6 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.f3464a = optString;
                    aVar.f3466c = optString2;
                    aVar.f3467d = optLong;
                    aVar.j = optInt;
                    aVar.f3468e = optString5;
                    aVar.f3465b = optString6;
                    aVar.f3469f = optBoolean;
                    aVar.f3470g = optString3;
                    aVar.f3471h = optBoolean2;
                    aVar.f3472i = optString4;
                    return aVar;
                }
            } catch (Exception e2) {
                b.a.m.i.c.c(e2);
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
                    aVar.f3464a = str;
                    aVar.f3466c = o;
                    aVar.f3467d = currentTimeMillis;
                    aVar.j = 1;
                    aVar.f3468e = str3;
                    aVar.f3465b = str2;
                    aVar.f3469f = z;
                    aVar.f3470g = str4;
                    return aVar;
                } catch (Exception e2) {
                    b.a.m.i.c.c(e2);
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
            String str = f3457h;
            if (str != null) {
                return str;
            }
            if (TextUtils.isEmpty(Build.MODEL)) {
                return "";
            }
            String substring = f.c.b(Build.MODEL.getBytes(), false).substring(3, 15);
            f3457h = substring;
            return substring;
        }
        return (String) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return new b.a.m.i.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new b.a.m.a.a().a(str.getBytes("UTF-8")));
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
            if (new File(this.f3459b.f(), "libbh.so").exists()) {
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
                aVar.f3467d = System.currentTimeMillis();
                aVar.j = 1;
                try {
                    boolean z = false;
                    aVar.f3465b = jVar.f3451b.substring(0, 1);
                    aVar.f3464a = jVar.f3450a;
                    aVar.f3466c = o(jVar.f3450a);
                    String[] strArr = a.k;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (strArr[i2].equals(aVar.f3465b)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z && (str = jVar.f3451b) != null && str.length() >= 2) {
                        aVar.f3468e = jVar.f3451b.substring(1);
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
            b.a.m.b.a a2 = this.f3462e.a(str2);
            a.g gVar = new a.g();
            gVar.f3335a = true;
            a.h b2 = a2.b(str, gVar);
            if (b2 == null || !b2.c()) {
                return null;
            }
            return b2.f3336a;
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
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.f3459b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public final void h(b.a.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            b bVar = new b(new c());
            a.b bVar2 = new a.b();
            bVar2.f3330a = this.f3458a;
            bVar2.f3331b = aVar;
            a.d dVar = new a.d();
            for (b.a.m.b.a aVar2 : bVar.b()) {
                aVar2.d(bVar2);
                aVar2.e(dVar);
            }
            this.f3462e = bVar;
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            a.e eVar = new a.e();
            for (b.a.m.b.a aVar2 : this.f3462e.b()) {
                aVar2.a(eVar, aVar);
            }
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.f3464a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.f3459b.f(), "libbh.so").exists() && (c2 = c(g(true))) != null) {
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
            return this.f3459b.e("libbh.so", aVar.x(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String f2 = f(this.f3458a);
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (f3456g) {
                    String str3 = "uuid: " + uuid;
                }
                str2 = str + f2 + uuid;
            } else {
                str2 = "com.baidu" + f2;
            }
            String b2 = f.c.b(str2.getBytes(), true);
            String l = l();
            a aVar = new a();
            aVar.f3467d = System.currentTimeMillis();
            aVar.j = 1;
            aVar.f3464a = b2;
            aVar.f3465b = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            aVar.f3466c = o(b2);
            aVar.f3469f = true;
            aVar.f3470g = l;
            aVar.f3468e = null;
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
            gVar.f3335a = true;
            List<b.a.m.b.a> b2 = this.f3462e.b();
            Collections.sort(b2, b.a.m.b.a.f3325e);
            List<e> h2 = this.f3463f.h(this.f3458a);
            if (h2 != null) {
                for (e eVar : h2) {
                    if (!eVar.f3435d && eVar.f3434c) {
                        for (b.a.m.b.a aVar2 : b2) {
                            a.h b3 = aVar2.b(eVar.f3432a.packageName, gVar);
                            if (b3 != null && b3.c() && (aVar = b3.f3336a) != null && !TextUtils.equals(aVar.h(), str)) {
                                if (!(aVar.q() && !TextUtils.equals(l(), aVar.r()))) {
                                    return b3.f3336a;
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
                File g2 = this.f3459b.g(".lock");
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
                                this.f3460c = randomAccessFile2.getChannel().lock();
                                this.f3461d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            randomAccessFile = randomAccessFile2;
                            b.a.m.i.c.c(e);
                            if (this.f3460c == null) {
                                b.a.m.i.c.b(randomAccessFile);
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
                if (this.f3460c != null) {
                    try {
                        this.f3460c.release();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.f3460c = null;
                }
                b.a.m.i.c.b(this.f3461d);
                this.f3461d = null;
            }
        }
    }
}
