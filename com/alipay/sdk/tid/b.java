package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1976a = "alipay_tid_storage";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1977b = "tidinfo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1978c = "upgraded_from_db";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1979d = "tid";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1980e = "client_key";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1981f = "timestamp";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1982g = "vimei";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1983h = "vimsi";

    /* renamed from: i  reason: collision with root package name */
    public static Context f1984i;
    public static b o;
    public transient /* synthetic */ FieldHolder $fh;
    public String j;
    public String k;
    public long l;
    public String m;
    public String n;
    public boolean p;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(971321369, "Lcom/alipay/sdk/tid/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(971321369, "Lcom/alipay/sdk/tid/b;");
        }
    }

    public b() {
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
        this.p = false;
    }

    public static synchronized b a(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (b.class) {
                if (o == null) {
                    c.b("TidStorage", "getInstance");
                    o = new b();
                }
                if (f1984i == null) {
                    o.b(context);
                }
                bVar = o;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            if (context != null) {
                c.b("TidStorage", "TidStorage.initialize context != null");
                f1984i = context.getApplicationContext();
            }
            if (this.p) {
                return;
            }
            this.p = true;
            k();
            l();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
        if (r5 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        Context context;
        com.alipay.sdk.tid.a aVar;
        Throwable th;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (context = f1984i) == null) {
            return;
        }
        if (a.d(f1976a, f1978c)) {
            c.b("TidStorage", "transferTidFromOldDb: already migrated. returning");
            return;
        }
        try {
            c.b("TidStorage", "transferTidFromOldDb: tid from db: ");
            aVar = new com.alipay.sdk.tid.a(context);
            try {
                String b2 = com.alipay.sdk.util.a.a(context).b();
                String a2 = com.alipay.sdk.util.a.a(context).a();
                String a3 = aVar.a(b2, a2);
                String b3 = aVar.b(b2, a2);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b3)) {
                    c.b("TidStorage", "transferTidFromOldDb: tid from db is " + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + b3);
                    a(a3, b3);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    c.a(th);
                } finally {
                    if (aVar != null) {
                        aVar.close();
                    }
                }
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
        }
        aVar.close();
        try {
            c.b("TidStorage", "transferTidFromOldDb: removing database table");
            com.alipay.sdk.tid.a aVar2 = new com.alipay.sdk.tid.a(context);
            try {
                aVar2.a();
                aVar2.close();
            } catch (Throwable th4) {
                th = th4;
                aVar = aVar2;
                try {
                    c.a(th);
                    a.a(f1976a, f1978c, "updated", false);
                } finally {
                    if (aVar != null) {
                        aVar.close();
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
        a.a(f1976a, f1978c, "updated", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l() {
        String str;
        String str2;
        String str3;
        String str4;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65544, this) != null) {
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            a2 = a.a(f1976a, f1977b, true);
        } catch (Exception e2) {
            e = e2;
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(a2)) {
            JSONObject jSONObject = new JSONObject(a2);
            str = jSONObject.optString("tid", "");
            try {
                str2 = jSONObject.optString(f1980e, "");
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str3 = jSONObject.optString(f1982g, "");
                } catch (Exception e3) {
                    e = e3;
                    str3 = null;
                }
            } catch (Exception e4) {
                e = e4;
                str2 = null;
                str3 = str2;
                c.a(e);
                str4 = null;
                str5 = str;
                c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
                if (!a(str5, str2, str3, str4)) {
                }
            }
            try {
                str4 = jSONObject.optString(f1983h, "");
            } catch (Exception e5) {
                e = e5;
                c.a(e);
                str4 = null;
                str5 = str;
                c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
                if (!a(str5, str2, str3, str4)) {
                }
            }
            str5 = str;
            c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
            if (!a(str5, str2, str3, str4)) {
                m();
                return;
            }
            this.j = str5;
            this.k = str2;
            this.l = valueOf.longValue();
            this.m = str3;
            this.n = str4;
            return;
        }
        str4 = null;
        str2 = null;
        str3 = null;
        c.b("TidStorage", "TidStorage.load " + str5 + " " + str2 + " " + valueOf + " " + str3 + " " + str4);
        if (!a(str5, str2, str3, str4)) {
        }
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.j = "";
            this.k = f();
            this.l = System.currentTimeMillis();
            this.m = n();
            this.n = n();
            a.b(f1976a, f1977b);
        }
    }

    private String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            Random random = new Random();
            return hexString + (random.nextInt(9000) + 1000);
        }
        return (String) invokeV.objValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", this.j);
                jSONObject.put(f1980e, this.k);
                jSONObject.put("timestamp", this.l);
                jSONObject.put(f1982g, this.m);
                jSONObject.put(f1983h, this.n);
                a.a(f1976a, f1977b, jSONObject.toString(), true);
            } catch (Exception e2) {
                c.a(e2);
            }
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.b("TidStorage", "TidStorage.getVirtualImei " + this.m);
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.b("TidStorage", "TidStorage.getVirtualImsi " + this.n);
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n) : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String hexString = Long.toHexString(System.currentTimeMillis());
            return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String format = String.format("TidStorage::delete > %s，%s，%s，%s，%s", this.j, this.k, Long.valueOf(this.l), this.m, this.n);
            c.b("TidStorage", "TidStorage.delete " + format);
            m();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? e() : invokeV.booleanValue;
    }

    public Long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Long.valueOf(this.l) : (Long) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "!@#23457" : (String) invokeV.objValue;
        }

        public static boolean a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
                if (b.f1984i == null) {
                    return false;
                }
                return b.f1984i.getSharedPreferences(str, 0).contains(str2);
            }
            return invokeLL.booleanValue;
        }

        public static void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) || b.f1984i == null) {
                return;
            }
            b.f1984i.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? a(str, str2, true) : (String) invokeLL.objValue;
        }

        public static boolean d(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
                if (b.f1984i == null) {
                    return false;
                }
                return b.f1984i.getSharedPreferences(str, 0).contains(str2);
            }
            return invokeLL.booleanValue;
        }

        public static String a(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, str2, z)) == null) {
                if (b.f1984i == null) {
                    return null;
                }
                String string = b.f1984i.getSharedPreferences(str, 0).getString(str2, null);
                if (TextUtils.isEmpty(string) || !z) {
                    str3 = string;
                } else {
                    String b2 = b();
                    str3 = com.alipay.sdk.encrypt.b.b(string, b2);
                    if (TextUtils.isEmpty(str3)) {
                        str3 = com.alipay.sdk.encrypt.b.b(string, a());
                        if (!TextUtils.isEmpty(str3)) {
                            a(str, str2, str3, true);
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        String.format("LocalPreference::getLocalPreferences failed %s，%s", string, b2);
                        c.b("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences failed");
                    }
                }
                c.b("TidStorage", "TidStorage.save LocalPreference::getLocalPreferences value " + string);
                return str3;
            }
            return (String) invokeLLZ.objValue;
        }

        public static String b() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
                try {
                    str = b.f1984i.getApplicationContext().getPackageName();
                } catch (Throwable th) {
                    c.a(th);
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = "unknow";
                }
                return (str + "00000000").substring(0, 8);
            }
            return (String) invokeV.objValue;
        }

        public static void a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
                a(str, str2, str3, true);
            }
        }

        public static void a(String str, String str2, String str3, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || b.f1984i == null) {
                return;
            }
            SharedPreferences sharedPreferences = b.f1984i.getSharedPreferences(str, 0);
            if (z) {
                String b2 = b();
                String a2 = com.alipay.sdk.encrypt.b.a(str3, b2);
                if (TextUtils.isEmpty(a2)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, b2);
                }
                str3 = a2;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.b("TidStorage", "TidStorage.getTid " + this.j);
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.b("TidStorage", "TidStorage.getClientKey " + this.k);
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, str3, str4)) == null) ? TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) : invokeLLLL.booleanValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            c.b("TidStorage", "TidStorage.save " + ("tid=" + str + ",clientKey=" + str2));
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.j = str;
            this.k = str2;
            this.l = System.currentTimeMillis();
            p();
            o();
        }
    }

    private void a(String str, String str2, String str3, String str4, Long l) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65539, this, str, str2, str3, str4, l) == null) || a(str, str2, str3, str4)) {
            return;
        }
        this.j = str;
        this.k = str2;
        this.m = str3;
        this.n = str4;
        if (l == null) {
            this.l = System.currentTimeMillis();
        } else {
            this.l = l.longValue();
        }
        p();
    }
}
