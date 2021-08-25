package c.r.a.a.c.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
/* loaded from: classes4.dex */
public class f implements c.r.a.a.a.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35443e;

    public f(Context context) {
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
        this.f35443e = context;
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            String str = null;
            try {
                str = h(String.format("/proc/%d/cmdline", Integer.valueOf(i2)));
                if (!TextUtils.isEmpty(str)) {
                    return str.trim();
                }
            } catch (Throwable th) {
                c.c(th);
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    public static String b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            if (z) {
                z = false;
            } else {
                sb.append('\n');
            }
            sb.append(readLine);
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                e a2 = d.a(new String[]{str}, false, true);
                return !TextUtils.isEmpty(a2.f35441b) ? a2.f35441b : (TextUtils.isEmpty(a2.f35442c) || !a2.f35442c.contains("denied")) ? TextUtils.isEmpty(a2.f35441b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
            } catch (Throwable th) {
                c.c(th);
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof UnknownHostException) {
                    return "UnknownHostException";
                }
                try {
                } catch (Throwable th3) {
                    c.c(th3);
                    return "";
                }
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, strArr)) == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                try {
                    if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                        return false;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? TextUtils.isEmpty(str) ? "KWE_N" : str : (String) invokeL.objValue;
    }

    public static boolean g(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, strArr)) == null) {
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    if (context.checkPermission(strArr[i2], Process.myPid(), Process.myUid()) == 0) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String b2 = b(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return b2;
            } catch (Throwable th) {
                th = th;
                try {
                    c.c(th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    @Override // c.r.a.a.a.b.b
    public void a(c.r.a.a.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        try {
            c.b("meizu enter");
            aVar.a(c(), this);
        } catch (Throwable th) {
            c.c(th);
        }
    }

    @Override // c.r.a.a.a.b.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.r.a.a.a.b.b
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.r.a.a.a.b.e.a a2 = c.r.a.a.a.b.e.a.a(this.f35443e);
            String c2 = !a2.d() ? null : a2.c("oaid");
            return TextUtils.isEmpty(c2) ? "" : c2;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.r.a.a.a.b.b
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.r.a.a.a.b.e.a.a(this.f35443e).d() : invokeV.booleanValue;
    }

    @Override // c.r.a.a.a.b.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
