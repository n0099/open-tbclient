package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f2558e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f2559f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f2560a;

    /* renamed from: b  reason: collision with root package name */
    public String f2561b;

    /* renamed from: c  reason: collision with root package name */
    public int f2562c;

    /* renamed from: d  reason: collision with root package name */
    public int f2563d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1701138855, "Lcom/baidu/android/bbalbs/common/util/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1701138855, "Lcom/baidu/android/bbalbs/common/util/b;");
                return;
            }
        }
        f2558e = a(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
        f2559f = a(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
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
        this.f2562c = 3;
    }

    public static b a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? b(context, str) : (b) invokeLL.objValue;
    }

    public static b a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (aVar != null) {
                b bVar = new b();
                bVar.a(aVar.a());
                bVar.b(aVar.b());
                return bVar;
            }
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        return (b) invokeL.objValue;
    }

    public static String a(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(com.baidu.android.bbalbs.common.a.b.a(bArr2)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            File d2 = d(context);
            if (d2.exists()) {
                return d(d.a(d2));
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static b b(Context context, String str) {
        InterceptResult invokeLL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            b bVar = new b();
            boolean z = Build.VERSION.SDK_INT < 23;
            String a2 = d.a(context);
            if (z) {
                String e2 = e(context);
                if (TextUtils.isEmpty(e2)) {
                    e2 = UUID.randomUUID().toString();
                    c(context, e2);
                }
                sb = new StringBuilder();
                sb.append(a2);
                sb.append(e2);
            } else {
                sb = new StringBuilder();
                sb.append("com.baidu");
                sb.append(a2);
            }
            bVar.a(com.baidu.android.bbalbs.common.a.c.a(sb.toString().getBytes(), true));
            bVar.b(str);
            bVar.a(Build.VERSION.SDK_INT);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            try {
                return new JSONObject().put(i("ZGV2aWNlaWQ="), this.f2560a).put(i("ZmxhZw=="), this.f2561b == null ? "0" : this.f2561b).put(i("dmVy"), this.f2562c).put(i("c2Rr"), this.f2563d).toString();
            } catch (JSONException e2) {
                d.a(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(i("ZmxhZw=="), "0");
                String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
                int optInt = jSONObject.optInt(i("c2Rr"), 0);
                if (!TextUtils.isEmpty(string)) {
                    b bVar = new b();
                    bVar.a(string);
                    bVar.b(optString);
                    bVar.a(optInt);
                    return bVar;
                }
            } catch (JSONException e2) {
                d.a(e2);
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) && TextUtils.isEmpty(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k")) && d.b(context)) {
            d.a(context, "XL5g0WZAHpIaKspIHIHYg5k", g(str));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, context)) == null) {
            String e2 = e(b());
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = context.openFileOutput("libcuid_v3.so", 0);
                    fileOutputStream.write(e2.getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (Exception e3) {
                            d.a(e3);
                            return true;
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    d.a(e4);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                            d.a(e5);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e6) {
                        d.a(e6);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static b d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? c(f(str)) : (b) invokeL.objValue;
    }

    public static File d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? new File(context.getFilesDir(), "libcuid_v3.so") : (File) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? h(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k")) : (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(f2558e, f2559f, str.getBytes()), "utf-8");
            } catch (UnsupportedEncodingException | Exception e2) {
                d.a(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(com.baidu.android.bbalbs.common.a.a.b(f2558e, f2559f, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
            } catch (Exception e2) {
                d.a(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(f2559f, f2558e, str.getBytes()), "utf-8");
            } catch (UnsupportedEncodingException | Exception e2) {
                d.a(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(com.baidu.android.bbalbs.common.a.a.b(f2559f, f2558e, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
            } catch (Exception e2) {
                d.a(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? new String(com.baidu.android.bbalbs.common.a.b.a(str.getBytes())) : (String) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f2561b)) {
                this.f2561b = "0";
            }
            return this.f2560a + "|" + this.f2561b;
        }
        return (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f2563d = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f2560a = str;
        }
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? c(context) : invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f2561b = str;
        }
    }
}
