package c.a.l0.e;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q;
    public static String r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3784a;

    /* renamed from: b  reason: collision with root package name */
    public String f3785b;

    /* renamed from: c  reason: collision with root package name */
    public int f3786c;

    /* renamed from: d  reason: collision with root package name */
    public int f3787d;

    /* renamed from: e  reason: collision with root package name */
    public String f3788e;

    /* renamed from: f  reason: collision with root package name */
    public long f3789f;

    /* renamed from: g  reason: collision with root package name */
    public String f3790g;

    /* renamed from: h  reason: collision with root package name */
    public String f3791h;

    /* renamed from: i  reason: collision with root package name */
    public long f3792i;

    /* renamed from: j  reason: collision with root package name */
    public long f3793j;

    public i(Context context) {
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
        this.f3793j = 8000L;
        this.f3784a = context;
    }

    public static void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            if (TextUtils.equals(str, "cm")) {
                k = str2;
                l = str3;
            } else if (TextUtils.equals(str, "ct")) {
                m = str2;
                n = str3;
            } else if (TextUtils.equals(str, com.baidu.fsg.base.statistics.h.f39300a)) {
                o = str2;
                p = str3;
            }
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && str.length() == 11 && str.contains("*") && str.charAt(3) == '*') {
                    int g0 = c.a.l0.b.a.h(this.f3784a).g0();
                    if (g0 <= 11 - str.replace("*", "").trim().length()) {
                        return str;
                    }
                    char[] charArray = str.toCharArray();
                    StringBuilder sb = new StringBuilder();
                    int i2 = g0 + 3;
                    for (int i3 = 0; i3 < charArray.length; i3++) {
                        if (i3 < 3) {
                            sb.append(charArray[i3]);
                        } else if (i3 < i2) {
                            sb.append("*");
                        } else {
                            sb.append(charArray[i3]);
                        }
                    }
                    return sb.toString();
                }
                return str;
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            try {
                if (c.a.l0.c.a.c().h(i2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.f3786c);
                    jSONObject.put("1", this.f3788e);
                    jSONObject.put("3", this.f3785b);
                    jSONObject.put("4", c.a.l0.l.d.j(this.f3784a));
                    if (!TextUtils.isEmpty(this.f3790g)) {
                        jSONObject.put("5", c.a.l0.l.e.c(this.f3790g.getBytes(), c.a.l0.b.a.h(this.f3784a).k0()));
                    }
                    jSONObject.put("6", q);
                    String c2 = c.a.l0.b.c.b(this.f3784a).c(jSONObject, this.f3793j);
                    if (c.a.l0.c.a.c().h(i2)) {
                        if (!TextUtils.isEmpty(c2)) {
                            s();
                            JSONObject jSONObject2 = new JSONObject(c2);
                            int optInt = jSONObject2.optInt("0", -1);
                            c.a.l0.b.a.h(this.f3784a).A(System.currentTimeMillis());
                            if (optInt == 0) {
                                c.a.l0.b.a.h(this.f3784a).k(0);
                                JSONObject optJSONObject = new JSONObject(jSONObject2.optString("1")).optJSONObject("data");
                                f(i2, 0, 0, this.f3786c, jSONObject2.optString("1"), optInt, optJSONObject != null ? optJSONObject.optString("uk") : "");
                                return;
                            }
                            c.a.l0.b.a.h(this.f3784a).k(4);
                            f(i2, 4, a.a(optInt), this.f3786c, jSONObject2.optString("1"), optInt, "");
                            return;
                        }
                        f(i2, 4, 2005, this.f3786c, "server req empty.", -1, "");
                    }
                }
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
                d(i2, 3, 2009, this.f3786c, "post token unknown error.");
            }
        }
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            Message message = new Message();
            message.what = i2;
            message.arg1 = this.f3786c;
            message.arg2 = i3;
            d.a().c(message, this.f3793j);
        }
    }

    public void d(int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            f(i2, i3, i4, i5, str, -1, "");
        }
    }

    public synchronized void e(int i2, int i3, int i4, int i5, String str, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6)}) == null) {
            synchronized (this) {
                b bVar = new b();
                bVar.f3705a = i6;
                c.j().c(i2, i3, i4, i5, str, bVar, true);
            }
        }
    }

    public synchronized void f(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), str2}) == null) {
            synchronized (this) {
                b bVar = new b();
                bVar.f3705a = 2;
                bVar.f3707c = i6;
                bVar.f3708d = str2;
                c.j().c(i2, i3, i4, i5, str, bVar, true);
            }
        }
    }

    public void g(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) && c.a.l0.c.a.c().h(i2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i3);
                jSONObject.put("1", str);
                String e2 = c.a.l0.b.c.b(this.f3784a).e(jSONObject, this.f3793j);
                if (c.a.l0.c.a.c().h(i2)) {
                    if (TextUtils.isEmpty(e2)) {
                        m(i2, 4, 2005, this.f3786c, "server req empty.");
                    } else {
                        t();
                        JSONObject jSONObject2 = new JSONObject(e2);
                        int optInt = jSONObject2.optInt("0", -1);
                        String optString = jSONObject2.optString("1");
                        c.a.l0.b.a.h(this.f3784a).K(System.currentTimeMillis());
                        if (optInt == 0) {
                            c.a.l0.b.a.h(this.f3784a).q(0);
                            n(i2, 0, 0, this.f3786c, optString, optInt, "");
                        } else {
                            int a2 = a.a(optInt);
                            c.a.l0.b.a.h(this.f3784a).q(4);
                            n(i2, 4, a2, this.f3786c, optString, optInt, "");
                        }
                    }
                }
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
                m(i2, 3, 2009, this.f3786c, "post token unknown error.");
            }
        }
    }

    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, context, i2) == null) {
            q = UUID.randomUUID().toString();
            c.a.l0.b.c.b(context).f();
            s();
        }
    }

    public void i(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.f3793j = j2;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f3787d = i2;
        }
    }

    public void m(int i2, int i3, int i4, int i5, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
            n(i2, i3, i4, i5, str, -1, "");
        }
    }

    public void n(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), str2}) == null) {
            b bVar = new b();
            bVar.f3705a = 4;
            bVar.f3707c = i6;
            bVar.f3708d = str2;
            c.j().c(i2, i3, i4, i5, str, bVar, true);
        }
    }

    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, context, i2) == null) {
            r = UUID.randomUUID().toString();
            c.a.l0.b.c.b(context).f();
            t();
        }
    }

    public void p(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            c.a.l0.b.c.b(context).f();
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i2 = this.f3786c;
            return i2 == 1 ? (TextUtils.isEmpty(k) || TextUtils.isEmpty(l)) ? false : true : i2 == 3 ? (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) ? false : true : (i2 != 2 || TextUtils.isEmpty(o) || TextUtils.isEmpty(p)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f3788e = null;
            this.f3789f = 0L;
            this.f3790g = null;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f3791h = null;
            this.f3792i = 0L;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getClass().getSimpleName() : (String) invokeV.objValue;
    }
}
