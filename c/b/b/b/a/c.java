package c.b.b.b.a;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import ms.bd.c.a2;
import ms.bd.c.b;
import ms.bd.c.c0;
import ms.bd.c.o1;
import ms.bd.c.p1;
import ms.bd.c.q1;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.mobsec.metasec.ml.b f31364a;

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
                    return;
                }
            }
            this.f31364a = null;
        }

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                Context a2 = ms.bd.c.a.c().a();
                if (this.f31364a == null) {
                    synchronized (this) {
                        if (this.f31364a == null) {
                            com.bytedance.mobsec.metasec.ml.b bVar = new com.bytedance.mobsec.metasec.ml.b(a2);
                            this.f31364a = bVar;
                            bVar.a();
                        }
                    }
                    return null;
                }
                return null;
            }
            return invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            Display defaultDisplay;
            Point point;
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                try {
                    defaultDisplay = ((WindowManager) ms.bd.c.a.c().a().getSystemService("window")).getDefaultDisplay();
                    point = new Point();
                } catch (Throwable unused) {
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else if (Build.VERSION.SDK_INT < 13) {
                    p1.f79083a = defaultDisplay.getWidth();
                    height = defaultDisplay.getHeight();
                    p1.f79084b = height;
                    return p1.f79083a + "*" + p1.f79084b;
                } else {
                    defaultDisplay.getSize(point);
                }
                p1.f79083a = point.x;
                height = point.y;
                p1.f79084b = height;
                return p1.f79083a + "*" + p1.f79084b;
            }
            return invokeCommon.objValue;
        }
    }

    /* renamed from: c.b.b.b.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1445c extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1445c() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            String str2;
            TelephonyManager telephonyManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                Context a2 = ms.bd.c.a.c().a();
                if (c0.a() == 1) {
                    try {
                        telephonyManager = (TelephonyManager) a2.getSystemService("phone");
                    } catch (Throwable unused) {
                    }
                    if (telephonyManager != null) {
                        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(c0.b("67657443656c6c4c6f636174696f6e")), new Class[0]);
                        declaredMethod.setAccessible(true);
                        CellLocation cellLocation = (CellLocation) declaredMethod.invoke(telephonyManager, new Object[0]);
                        if (cellLocation != null) {
                            str2 = cellLocation.toString();
                            return a2.a(str2);
                        }
                        str2 = null;
                        return a2.a(str2);
                    }
                }
                return "";
            }
            return invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            String str2;
            LocationManager locationManager;
            Class<?> cls;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                Context a2 = ms.bd.c.a.c().a();
                if (c0.a() == 1) {
                    try {
                        locationManager = (LocationManager) a2.getSystemService("location");
                    } catch (Throwable unused) {
                    }
                    if (locationManager == null) {
                        throw new NullPointerException("null LM");
                    }
                    Method declaredMethod = locationManager.getClass().getDeclaredMethod(new String(c0.b("6765744c6173744b6e6f776e4c6f636174696f6e")), String.class);
                    declaredMethod.setAccessible(true);
                    Location location = (Location) declaredMethod.invoke(locationManager, "gps");
                    if (location == null && (location = (Location) declaredMethod.invoke(locationManager, "network")) == null) {
                        location = (Location) declaredMethod.invoke(locationManager, "passive");
                    }
                    if (location != null && (cls = Class.forName(new String(c0.b("616e64726f69642e6c6f636174696f6e2e4c6f636174696f6e")))) != null) {
                        Method method = cls.getMethod(new String(c0.b("6765744c6f6e676974756465")), new Class[0]);
                        Method method2 = cls.getMethod(new String(c0.b("6765744c61746974756465")), new Class[0]);
                        if (method != null && method2 != null) {
                            method.setAccessible(true);
                            method2.setAccessible(true);
                            str2 = "" + method.invoke(location, new Object[0]) + "," + method2.invoke(location, new Object[0]);
                            return a2.a(str2);
                        }
                    }
                }
                str2 = null;
                return a2.a(str2);
            }
            return invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            String str2;
            TelephonyManager telephonyManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                try {
                    telephonyManager = (TelephonyManager) ms.bd.c.a.c().a().getSystemService("phone");
                } catch (Throwable unused) {
                    str2 = "";
                }
                if (telephonyManager != null) {
                    Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(c0.b("6765744465766963654964")), new Class[0]);
                    declaredMethod.setAccessible(true);
                    str2 = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                    return a2.a(str2);
                }
                throw new NullPointerException("null TM");
            }
            return invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            String str2;
            TelephonyManager telephonyManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                try {
                    telephonyManager = (TelephonyManager) ms.bd.c.a.c().a().getSystemService("phone");
                } catch (Throwable unused) {
                    str2 = null;
                }
                if (telephonyManager != null) {
                    Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(c0.b("676574537562736372696265724964")), new Class[0]);
                    declaredMethod.setAccessible(true);
                    str2 = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                    return a2.a(str2);
                }
                throw new NullPointerException("null TM");
            }
            return invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) ? o1.c() : invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) ? q1.a(ms.bd.c.a.c().a()) : invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            String str2;
            String str3;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                String str4 = "0";
                String str5 = StringUtil.NULL_STRING;
                try {
                    WifiInfo connectionInfo = ((WifiManager) ms.bd.c.a.c().a().getSystemService("wifi")).getConnectionInfo();
                    Class<?> cls = connectionInfo.getClass();
                    Method declaredMethod = cls.getDeclaredMethod(new String(c0.b("6765744253534944")), new Class[0]);
                    declaredMethod.setAccessible(true);
                    str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod2 = cls.getDeclaredMethod(new String(c0.b("67657453534944")), new Class[0]);
                        declaredMethod2.setAccessible(true);
                        str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                        try {
                            Method declaredMethod3 = cls.getDeclaredMethod(new String(c0.b("676574497041646472657373")), new Class[0]);
                            declaredMethod3.setAccessible(true);
                            String num = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                            String a2 = a2.a(str3);
                            String a3 = a2.a(str2);
                            String a4 = a2.a(num);
                            sb = new StringBuilder();
                            sb.append((a3 == null || a3.length() <= 0) ? StringUtil.NULL_STRING : a3.trim());
                            sb.append("[<!>]");
                            if (a2 != null && a2.length() > 0) {
                                str5 = a2.trim();
                            }
                            sb.append(str5);
                            sb.append("[<!>]");
                            if (a4 != null && a4.length() > 0) {
                                str4 = a4.trim();
                            }
                        } catch (Throwable unused) {
                            String a5 = a2.a(str3);
                            String a6 = a2.a(str2);
                            String a7 = a2.a(null);
                            sb = new StringBuilder();
                            sb.append((a6 == null || a6.length() <= 0) ? StringUtil.NULL_STRING : a6.trim());
                            sb.append("[<!>]");
                            if (a5 != null && a5.length() > 0) {
                                str5 = a5.trim();
                            }
                            sb.append(str5);
                            sb.append("[<!>]");
                            if (a7 != null && a7.length() > 0) {
                                str4 = a7.trim();
                            }
                            sb.append(str4);
                            sb.append("[<!>]");
                            return sb.toString().trim();
                        }
                    } catch (Throwable unused2) {
                        str3 = null;
                    }
                } catch (Throwable unused3) {
                    str2 = null;
                    str3 = null;
                }
                sb.append(str4);
                sb.append("[<!>]");
                return sb.toString().trim();
            }
            return invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j extends b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
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

        @Override // ms.bd.c.b.a
        public Object b(int i2, long j2, String str, Object obj) throws Throwable {
            InterceptResult invokeCommon;
            String str2;
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
                Context a2 = ms.bd.c.a.c().a();
                if (a2 == null) {
                    return null;
                }
                String str3 = "null_";
                try {
                    string = Settings.Secure.getString(a2.getContentResolver(), "default_input_method");
                } catch (Throwable th) {
                    try {
                        str2 = "null_" + th.getMessage();
                    } catch (Throwable unused) {
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains("/")) {
                        str2 = string.split("/")[0];
                        str3 = str2;
                    } else {
                        str3 = string;
                    }
                }
                StringBuilder sb = new StringBuilder(str3);
                try {
                    for (InputMethodInfo inputMethodInfo : ((InputMethodManager) a2.getSystemService("input_method")).getInputMethodList()) {
                        String packageName = inputMethodInfo.getPackageName();
                        if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                            sb.append("[<!>]");
                            sb.append(packageName);
                        }
                    }
                } catch (Throwable unused2) {
                }
                return sb.toString();
            }
            return invokeCommon.objValue;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ms.bd.c.b.a((int) RouterCallback.CODE_ERROR, new b());
            ms.bd.c.b.a((int) RouterCallback.CODE_NOT_FOUND, new C1445c());
            ms.bd.c.b.a((int) RouterCallback.CODE_INVALID, new d());
            ms.bd.c.b.a((int) RouterCallback.CODE_ROUTER_NOT_REGISTER, new e());
            ms.bd.c.b.a((int) RouterCallback.CODE_NOT_IMPLEMENT, new f());
            ms.bd.c.b.a(268435462, new g());
            ms.bd.c.b.a(268435463, new h());
            ms.bd.c.b.a(268435464, new i());
            ms.bd.c.b.a(268435465, new j());
            ms.bd.c.b.a(268435466, new a());
        }
    }
}
