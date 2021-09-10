package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.core.view.InputDeviceCompat;
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
import java.io.IOException;
import java.io.StringReader;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f36682e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36683a;

    /* renamed from: b  reason: collision with root package name */
    public String f36684b;

    /* renamed from: c  reason: collision with root package name */
    public int f36685c;

    /* renamed from: d  reason: collision with root package name */
    public int f36686d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1701138824, "Lcom/baidu/android/bbalbs/common/util/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1701138824, "Lcom/baidu/android/bbalbs/common/util/a;");
                return;
            }
        }
        String str = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        String str2 = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        f36682e = str + str2;
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
        this.f36685c = 0;
        this.f36686d = 2;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            File c2 = c(context);
            if (c2.exists()) {
                return c2.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? d(d.a(c(context))) : (a) invokeL.objValue;
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 >= 14 : invokeI.booleanValue;
    }

    public static a c(String str) {
        InterceptResult invokeL;
        JsonReader jsonReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) != null) {
            return (a) invokeL.objValue;
        }
        JsonReader jsonReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jsonReader = new JsonReader(new StringReader(str));
            try {
                jsonReader.beginObject();
                String g2 = g("ZGV2aWNlaWQ=");
                String g3 = g("dmVy");
                String str2 = "0";
                String str3 = "";
                int i2 = 2;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (g2.equals(nextName)) {
                        str3 = jsonReader.nextString();
                    } else if (g3.equals(nextName)) {
                        i2 = jsonReader.nextInt();
                    } else {
                        str2 = jsonReader.nextString();
                    }
                }
                jsonReader.endObject();
                int i3 = 0;
                if (i2 == 2 && !TextUtils.isEmpty(str2)) {
                    i3 = str2.length();
                }
                try {
                    jsonReader.close();
                } catch (Exception e2) {
                    d.a(e2);
                }
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                a aVar = new a();
                aVar.a(str3);
                aVar.a(i3);
                if (!aVar.d()) {
                    aVar.b(str2);
                }
                return aVar;
            } catch (IOException unused) {
                if (jsonReader != null) {
                    try {
                        jsonReader.close();
                    } catch (Exception e3) {
                        d.a(e3);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                jsonReader2 = jsonReader;
                if (jsonReader2 != null) {
                    try {
                        jsonReader2.close();
                    } catch (Exception e4) {
                        d.a(e4);
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            jsonReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? new File(context.getFilesDir(), "libcuid.so") : (File) invokeL.objValue;
    }

    public static a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? c(f(str)) : (a) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(com.baidu.android.bbalbs.common.a.a.b(f36682e, f36682e, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? new String(com.baidu.android.bbalbs.common.a.b.a(str.getBytes())) : (String) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36683a : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f36685c = i2;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f36683a = str;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36684b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f36684b = str;
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (d()) {
                str = "O";
            } else if (!e()) {
                return false;
            } else {
                str = "0";
            }
            this.f36684b = str;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? b(this.f36685c) : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? e(this.f36684b) : invokeV.booleanValue;
    }
}
