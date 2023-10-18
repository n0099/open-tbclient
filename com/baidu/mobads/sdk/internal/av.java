package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class av {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "bqt_ad_tag";
    public static volatile a[] b;
    public static final a[] c;
    public static final Map<String, a> d;
    public static final a e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadLocal<String> a;

        @NonNull
        public abstract String a();

        public abstract void a(int i, String str, String str2, Throwable th);

        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                return true;
            }
            return invokeI.booleanValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ThreadLocal<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                String str = this.a.get();
                if (str != null) {
                    this.a.remove();
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        private String g(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, th)) == null) {
                StringWriter stringWriter = new StringWriter(256);
                PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
                th.printStackTrace(printWriter);
                printWriter.flush();
                return stringWriter.toString();
            }
            return (String) invokeL.objValue;
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                b(2, null, str);
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
                b(3, null, str);
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
                b(4, null, str);
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
                b(5, null, str);
            }
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
                b(6, null, str);
            }
        }

        private void b(int i, Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(65538, this, i, th, str) == null) {
                String b = b();
                if (!a(b, i)) {
                    return;
                }
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th == null) {
                        return;
                    }
                    str = g(th);
                } else if (th != null) {
                    str = str + "\n" + g(th);
                }
                a(i, b, str, th);
            }
        }

        private String g(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, objArr)) == null) {
                StringBuilder sb = new StringBuilder();
                for (Object obj : objArr) {
                    sb.append(obj);
                    sb.append(WebvttCueParser.CHAR_SPACE);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                b(3, null, b(obj));
            }
        }

        public void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
                b(3, th, null);
            }
        }

        public void c(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, th) == null) {
                b(4, th, null);
            }
        }

        public void d(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, th) == null) {
                b(5, th, null);
            }
        }

        public void e(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, th) == null) {
                b(6, th, null);
            }
        }

        public void f(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, th) == null) {
                b(7, th, null);
            }
        }

        public String a(String str, Object[] objArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr)) == null) {
                return String.format(str, objArr);
            }
            return (String) invokeLL.objValue;
        }

        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048594, this, th, str) == null) {
                b(3, th, str);
            }
        }

        public void c(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048598, this, th, str) == null) {
                b(4, th, str);
            }
        }

        public void d(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048602, this, th, str) == null) {
                b(5, th, str);
            }
        }

        public void e(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048606, this, th, str) == null) {
                b(6, th, str);
            }
        }

        public void f(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048610, this, th, str) == null) {
                b(7, th, str);
            }
        }

        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
                b(i, null, str);
            }
        }

        public void a(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, th) == null) {
                b(i, th, null);
            }
        }

        public void a(int i, Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i, th, str) == null) {
                b(i, th, str);
            }
        }

        public void a(int i, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, objArr) == null) {
                b(i, null, g(objArr));
            }
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    c("Empty/Null json content");
                    return;
                }
                try {
                    String trim = str.trim();
                    if (trim.startsWith("{")) {
                        b(3, null, new JSONObject(trim).toString(2));
                    } else if (trim.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                        b(3, null, new JSONArray(trim).toString(2));
                    } else {
                        f("Invalid Json");
                    }
                } catch (Exception unused) {
                    f("Invalid Json");
                }
            }
        }

        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
                b(2, th, null);
            }
        }

        public void b(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, objArr) == null) {
                b(3, null, g(objArr));
            }
        }

        public void c(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, objArr) == null) {
                b(4, null, g(objArr));
            }
        }

        public void d(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048603, this, objArr) == null) {
                b(5, null, g(objArr));
            }
        }

        public void e(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, objArr) == null) {
                b(6, null, g(objArr));
            }
        }

        public void f(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048611, this, objArr) == null) {
                b(7, null, g(objArr));
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
                b(7, null, str);
            }
        }

        public void a(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, th, str) == null) {
                b(2, th, str);
            }
        }

        public void a(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, objArr) == null) {
                b(2, null, g(objArr));
            }
        }

        public boolean a(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
                return a(i);
            }
            return invokeLI.booleanValue;
        }

        public String b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
                if (obj == null) {
                    return StringUtil.NULL_STRING;
                }
                if (!obj.getClass().isArray()) {
                    return obj.toString();
                }
                if (obj instanceof boolean[]) {
                    return Arrays.toString((boolean[]) obj);
                }
                if (obj instanceof byte[]) {
                    return Arrays.toString((byte[]) obj);
                }
                if (obj instanceof char[]) {
                    return Arrays.toString((char[]) obj);
                }
                if (obj instanceof short[]) {
                    return Arrays.toString((short[]) obj);
                }
                if (obj instanceof int[]) {
                    return Arrays.toString((int[]) obj);
                }
                if (obj instanceof long[]) {
                    return Arrays.toString((long[]) obj);
                }
                if (obj instanceof float[]) {
                    return Arrays.toString((float[]) obj);
                }
                if (obj instanceof double[]) {
                    return Arrays.toString((double[]) obj);
                }
                if (obj instanceof Object[]) {
                    return Arrays.deepToString((Object[]) obj);
                }
                return "Couldn't find a correct type for the object";
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833693114, "Lcom/baidu/mobads/sdk/internal/av;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833693114, "Lcom/baidu/mobads/sdk/internal/av;");
                return;
            }
        }
        c = new a[0];
        d = new HashMap();
        b = c;
        e = new aw();
    }

    public av() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                i("local");
                i("debug");
            } catch (Throwable unused) {
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return e;
        }
        return (a) invokeV.objValue;
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            for (a aVar : b) {
                aVar.a.set(a);
            }
            return e;
        }
        return (a) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            synchronized (d) {
                d.clear();
                b = c;
            }
        }
    }

    public static List<a> e() {
        InterceptResult invokeV;
        List<a> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            synchronized (d) {
                unmodifiableList = Collections.unmodifiableList(new ArrayList(d.values()));
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            synchronized (d) {
                size = d.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public static void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            e.a(i, str);
        }
    }

    public static void b(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, th, str) == null) {
            e.b(th, str);
        }
    }

    public static void c(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, th, str) == null) {
            e.c(th, str);
        }
    }

    public static void d(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, th, str) == null) {
            e.d(th, str);
        }
    }

    public static void e(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, th, str) == null) {
            e.e(th, str);
        }
    }

    public static void f(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65574, null, th, str) == null) {
            e.f(th, str);
        }
    }

    public static void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, th) == null) {
            e.a(i, th);
        }
    }

    public static void a(int i, Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65541, null, i, th, str) == null) {
            e.a(i, th, str);
        }
    }

    public static void a(int i, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65542, null, i, objArr) == null) {
            e.a(i, objArr);
        }
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, aVar) != null) || aVar == null || aVar == e) {
            return;
        }
        synchronized (d) {
            d.put(aVar.a(), aVar);
            b = (a[]) d.values().toArray(new a[0]);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65578, null, str) == null) {
            synchronized (d) {
                if (d.remove(str) == null) {
                    return;
                }
                b = (a[]) d.values().toArray(new a[0]);
            }
        }
    }

    public static void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, obj) == null) {
            e.a(obj);
        }
    }

    public static void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, aVar) == null) {
            i(aVar.a());
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            e.c(str);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, str) == null) {
            e.d(str);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, str) == null) {
            e.e(str);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, str) == null) {
            e.f(str);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, str) == null) {
            e.g(str);
        }
    }

    public static a h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            for (a aVar : b) {
                aVar.a.set(str);
            }
            return e;
        }
        return (a) invokeL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            e.a(str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            e.b(str);
        }
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, th) == null) {
            e.c(th);
        }
    }

    public static void d(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, th) == null) {
            e.d(th);
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, th) == null) {
            e.e(th);
        }
    }

    public static void f(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, th) == null) {
            e.f(th);
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, th) == null) {
            e.a(th);
        }
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, th) == null) {
            e.b(th);
        }
    }

    public static void c(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, objArr) == null) {
            e.c(objArr);
        }
    }

    public static void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, objArr) == null) {
            e.d(objArr);
        }
    }

    public static void e(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, objArr) == null) {
            e.e(objArr);
        }
    }

    public static void f(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, null, objArr) == null) {
            e.f(objArr);
        }
    }

    public static void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, th, str) == null) {
            e.a(th, str);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            try {
                a();
                if (cj.a) {
                    a((a) new at());
                } else if (z) {
                    a((a) new as());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, objArr) == null) {
            e.b(objArr);
        }
    }

    public static void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, objArr) == null) {
            e.a(objArr);
        }
    }
}
