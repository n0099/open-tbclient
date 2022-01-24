package c.a.v0;

import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a implements u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f26369c;
    public transient /* synthetic */ FieldHolder $fh;
    public h0 a;

    /* renamed from: b  reason: collision with root package name */
    public String f26370b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1352752137, "Lc/a/v0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1352752137, "Lc/a/v0/a;");
                return;
            }
        }
        f26369c = b0.m();
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
        this.a = new h0();
        this.f26370b = "";
    }

    @Override // c.a.v0.u
    public boolean a(JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? i(this.f26370b, jSONObject, z, z2) : invokeCommon.booleanValue;
    }

    @Override // c.a.v0.u
    public boolean b(File file, long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{file, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? h(this.f26370b, file, j2, z, z2) : invokeCommon.booleanValue;
    }

    public final HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>(2);
            hashMap.put("Content-type", "application/x-www-form-urlencoded");
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public final String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (TextUtils.isEmpty(this.f26370b)) {
                this.f26370b = b0.k(z);
            }
            return this.f26370b;
        }
        return (String) invokeZ.objValue;
    }

    public final String e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean isUBCDebug = this.a.isUBCDebug();
            if (TextUtils.isEmpty(str)) {
                str = d(isUBCDebug);
            }
            if (z2) {
                c2 = b0.h(str);
            } else {
                c2 = b0.c(str);
            }
            if (isUBCDebug && !TextUtils.isEmpty(c2)) {
                c2 = c.a.v0.q0.f.a(c2, "debug", "1");
            }
            if (z) {
                c2 = c.a.v0.q0.f.a(c2, "reallog", "1");
            }
            return g.o().E() ? c.a.v0.q0.f.a(c2, "beta", "1") : c2;
        }
        return (String) invokeCommon.objValue;
    }

    public final boolean f(e0 e0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e0Var)) == null) {
            if (e0Var == null) {
                return false;
            }
            if (!e0Var.e()) {
                if (f26369c) {
                    String str = "postByteRequest, fail: " + e0Var.d();
                } else {
                    d0.a().i(e0Var.d(), null);
                }
                if (g.o().M()) {
                    g(e0Var.c());
                }
                e0Var.a();
                return false;
            }
            try {
                int i2 = new JSONObject(e0Var.b()).getInt("error");
                if (i2 != 0) {
                    boolean z = f26369c;
                    if (!f26369c) {
                        d0.a().k(i2);
                    }
                }
            } catch (Exception e2) {
                if (f26369c) {
                    String str2 = "body tostring fail:" + e2.getMessage();
                } else {
                    d0.a().j(Log.getStackTraceString(e2));
                }
            }
            e0Var.a();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i2) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048582, this, i2) != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        if (i2 == 403 || i2 == 408 || i2 == 499) {
            j2 = 60000;
        } else if (i2 < 500 || i2 >= 600) {
            z = false;
            if (z) {
                return;
            }
            g.o().Z(currentTimeMillis);
            return;
        } else {
            j2 = 300000;
        }
        currentTimeMillis += j2;
        if (z) {
        }
    }

    public final boolean h(String str, File file, long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, file, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return invokeCommon.booleanValue;
        }
        if (file == null || !file.exists()) {
            return false;
        }
        String e2 = e(str, z, z2);
        HashMap<String, String> c2 = c();
        if (i0.m().p() && j2 > 0) {
            c2.put("Content-Length", String.valueOf(j2));
        }
        InputStream inputStream2 = null;
        try {
            inputStream = new BufferedInputStream(new Base64InputStream(new FileInputStream(file), 2));
            try {
                try {
                    boolean f2 = f(j(e2, inputStream, c2));
                    c.a.v0.q0.a.b(inputStream);
                    return f2;
                } catch (Exception e3) {
                    e = e3;
                    if (!f26369c) {
                        d0.a().i(null, Log.getStackTraceString(e));
                    }
                    c.a.v0.q0.a.b(inputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                c.a.v0.q0.a.b(inputStream2);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            c.a.v0.q0.a.b(inputStream2);
            throw th;
        }
    }

    public boolean i(String str, JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (jSONObject != null && (a = c.a.v0.q0.c.a(jSONObject.toString().getBytes())) != null && a.length >= 2) {
                a[0] = ContentUtil.GZIP_HEAD_1;
                a[1] = ContentUtil.GZIP_HEAD_2;
                String e2 = e(str, z, z2);
                HashMap<String, String> c2 = c();
                if (i0.m().p()) {
                    c2.put("Content-Length", String.valueOf(a.length));
                }
                try {
                    return f(k(e2, a, c2));
                } catch (IOException e3) {
                    if (!f26369c) {
                        d0.a().i(null, Log.getStackTraceString(e3));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public abstract e0 j(String str, InputStream inputStream, Map<String, String> map) throws IOException;

    public abstract e0 k(String str, byte[] bArr, Map<String, String> map) throws IOException;
}
