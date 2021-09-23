package c.r.a.a.c.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.r.a.a.c.b.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f35558a;

    /* renamed from: b  reason: collision with root package name */
    public String f35559b;

    /* renamed from: c  reason: collision with root package name */
    public ReentrantLock f35560c;

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
        this.f35559b = "";
        this.f35560c = new ReentrantLock();
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f35561a : (a) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (!g()) {
                    String f2 = f();
                    if (!TextUtils.isEmpty(f2)) {
                        return f2;
                    }
                }
                boolean z = false;
                if (Build.VERSION.SDK_INT >= 29) {
                    String str = Build.MODEL;
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                        z = true;
                    }
                }
                if (!z) {
                    String e2 = Orange.a().e();
                    if (!TextUtils.isEmpty(e2) && !e2.startsWith("KWE")) {
                        return e2;
                    }
                }
                if (f.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                    String serial = Build.getSerial();
                    if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                        return serial;
                    }
                }
                String str2 = Build.SERIAL;
                return !TextUtils.isEmpty(str2) ? !str2.equals("unknown") ? str2 : "KWE_N" : "KWE_N";
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "KWE_N";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                try {
                    File file = new File("/sys/class/android_usb/android0/iSerial");
                    if (file.exists()) {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            String readLine = bufferedReader.readLine();
                            if (!TextUtils.isEmpty(readLine)) {
                                String trim = readLine.trim();
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th) {
                                    c.r.a.a.c.b.c.c(th);
                                }
                                return trim;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                c.r.a.a.c.b.c.c(th);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return null;
                            } catch (Throwable th3) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th4) {
                                        c.r.a.a.c.b.c.c(th4);
                                    }
                                }
                                throw th3;
                            }
                        }
                    } else {
                        bufferedReader = null;
                    }
                } catch (Throwable th5) {
                    c.r.a.a.c.b.c.c(th5);
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 26;
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                return System.currentTimeMillis() - SystemClock.elapsedRealtime();
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, IPUT, CONST, INVOKE, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:44:0x025f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context, c.r.a.a.d dVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, dVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f35560c.lock();
            } finally {
                try {
                    this.f35560c.unlock();
                    if (TextUtils.isEmpty(this.f35559b)) {
                    }
                    return this.f35559b;
                } finally {
                }
            }
            if (TextUtils.isEmpty(this.f35559b)) {
                JSONObject jSONObject = new JSONObject();
                String str = Build.MODEL;
                jSONObject.put("k27", f.f(TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "")));
                jSONObject.put("k64", f.f(b(context)));
                jSONObject.put("k31", f.f(z ? d.g() : d.i()));
                jSONObject.put("k66", f.f(c.r.a.a.c.b.a.a(context)));
                jSONObject.put("k39", f.f(Long.toString(h())));
                jSONObject.put("k101", f.f(f.c(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
                jSONObject.put("k102", f.f(f.c(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
                jSONObject.put("k57", f.f(d.f(context)));
                jSONObject.put("k68", f.f(d.b(context)));
                jSONObject.put("k105", f.f(Orange.a().c()));
                jSONObject.put("k83", f.f(d.j(context)));
                jSONObject.put("k86", f.f(d.k(context)));
                jSONObject.put("k3", f.f(d.h(context)));
                jSONObject.put("k109", f.f(Orange.a().g()));
                jSONObject.put("k36", f.f(c.r.a.a.c.b.c.a()));
                jSONObject.put("k14", f.f(c.r.a.a.c.b.c.d()));
                jSONObject.put("k5", f.f(Long.toString(d.a())));
                jSONObject.put("k46", f.f(Long.toString(d.e())));
                jSONObject.put("k111", f.f("KWE_NPN"));
                if (z2) {
                    c.r.a.a.a.a.b.c().j();
                }
                String str2 = c.r.a.a.b.f35551g;
                if (TextUtils.isEmpty(str2) || str2.startsWith("KWE")) {
                    str2 = new e(context).e();
                }
                jSONObject.put("k97", f.f(str2));
                CRC32 crc32 = new CRC32();
                for (int i2 = 1; i2 <= 111; i2++) {
                    String str3 = "k" + i2;
                    if (jSONObject.has(str3)) {
                        crc32.update(jSONObject.optString(str3).getBytes());
                    }
                }
                jSONObject.put("k14", f.f(c.r.a.a.c.b.c.d() + ":" + String.valueOf(crc32.getValue())));
                c.r.a.a.c.b.c.f("mimi :" + jSONObject.toString() + " " + jSONObject.toString().getBytes().length + " " + (System.currentTimeMillis() - currentTimeMillis));
                byte[] d2 = Orange.a().d(context, jSONObject.toString().getBytes(), 0);
                StringBuilder sb = new StringBuilder("get mini lenth ");
                sb.append(d2.length);
                c.r.a.a.c.b.c.b(sb.toString());
                this.f35559b = URLEncoder.encode(Base64.encodeToString(d2, 0), "utf-8");
                this.f35560c.unlock();
                if (TextUtils.isEmpty(this.f35559b)) {
                    this.f35559b = "KWE_N";
                }
                return this.f35559b;
            }
            return this.f35559b;
        }
        return (String) invokeCommon.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f35558a = str;
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return !TextUtils.isEmpty(this.f35558a) ? this.f35558a : "KWE_N";
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "KWE_N";
            }
        }
        return (String) invokeV.objValue;
    }
}
