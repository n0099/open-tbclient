package c.a.e.h.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, b> f2812d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f2813e;

    /* renamed from: f  reason: collision with root package name */
    public static DateFormat f2814f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f2815a;

    /* renamed from: b  reason: collision with root package name */
    public String f2816b;

    /* renamed from: c  reason: collision with root package name */
    public long f2817c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1297341111, "Lc/a/e/h/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1297341111, "Lc/a/e/h/h/b;");
                return;
            }
        }
        f2812d = new HashMap();
        f2813e = new Object();
        f2814f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2815a = new LinkedList<>();
        this.f2816b = str;
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? d("plugin_load") : (b) invokeV.objValue;
    }

    public static b d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "Default";
            }
            if (!f2812d.containsKey(str)) {
                synchronized (f2813e) {
                    if (!f2812d.containsKey(str)) {
                        b bVar = new b(str);
                        f2812d.put(str, bVar);
                        return bVar;
                    }
                }
            }
            return f2812d.get(str);
        }
        return (b) invokeL.objValue;
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            c().f(str, str2);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.f2815a.size() >= 70) {
                this.f2815a.poll();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f2817c == 0) {
            this.f2817c = System.currentTimeMillis();
        }
    }

    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            b();
            a();
            this.f2815a.add(new a(str, str2));
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("trace_" + this.f2816b + "{begin@" + f2814f.format(new Date(this.f2817c)) + "->");
            for (int i2 = 0; i2 < this.f2815a.size(); i2++) {
                a aVar = this.f2815a.get(i2);
                sb.append(String.format("%s(%s)@%s", aVar.f2818a, aVar.f2819b, f2814f.format(new Date(aVar.f2820c))));
                if (i2 < this.f2815a.size() - 1) {
                    sb.append("->");
                }
            }
            sb.append("->end}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f2818a;

        /* renamed from: b  reason: collision with root package name */
        public String f2819b;

        /* renamed from: c  reason: collision with root package name */
        public long f2820c;

        public a(String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f2818a = str;
            this.f2819b = str2;
            this.f2820c = j2;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
