package com.baidu.pass.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SharedPreferencesUtil implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferencesUtil a = null;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f37658b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f37659c = "sapi_system";

    /* renamed from: d  reason: collision with root package name */
    public static String f37660d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f37661e;
    public transient /* synthetic */ FieldHolder $fh;

    public SharedPreferencesUtil(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f37658b = context.getSharedPreferences(str, 0);
        f37661e = context.getApplicationContext();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (TextUtils.isEmpty(f37660d)) {
                try {
                    f37660d = SecurityUtil.md5((f37661e.getPackageName() + PassUtil.getPackageSign(f37661e, f37661e.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            return f37660d;
        }
        return (String) invokeV.objValue;
    }

    public static <T> T get(String str, T t) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, t)) == null) {
            String simpleName = t.getClass().getSimpleName();
            try {
                int hashCode = simpleName.hashCode();
                if (hashCode == -672261858) {
                    if (simpleName.equals("Integer")) {
                        c2 = 3;
                    }
                    c2 = 65535;
                } else if (hashCode == 2374300) {
                    if (simpleName.equals("Long")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode != 67973692) {
                    if (hashCode == 1729365000 && simpleName.equals("Boolean")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (simpleName.equals("Float")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                return (T) f37658b.getString(str, (String) t);
                            }
                            return (T) Integer.valueOf(f37658b.getInt(str, ((Integer) t).intValue()));
                        }
                        return (T) Float.valueOf(f37658b.getFloat(str, ((Float) t).floatValue()));
                    }
                    return (T) Long.valueOf(f37658b.getLong(str, ((Long) t).longValue()));
                }
                return (T) Boolean.valueOf(f37658b.getBoolean(str, ((Boolean) t).booleanValue()));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    public static String getEncryptStr(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            String a2 = a();
            String stringBuffer = new StringBuffer(a2).reverse().toString();
            String str3 = (String) get(str, str2);
            try {
                return new String(SecurityUtil.aesDecrypt(SecurityUtil.base64Decode(str3.getBytes()), stringBuffer, a2)).trim();
            } catch (Exception e2) {
                Log.e(e2);
                return str3;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized void getInstance(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (SharedPreferencesUtil.class) {
                if (a == null) {
                    a = new SharedPreferencesUtil(context, f37659c);
                }
            }
        }
    }

    public static boolean put(String str, Object obj) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, obj)) == null) {
            SharedPreferences.Editor edit = f37658b.edit();
            String simpleName = obj.getClass().getSimpleName();
            boolean z = false;
            try {
                int hashCode = simpleName.hashCode();
                if (hashCode == -672261858) {
                    if (simpleName.equals("Integer")) {
                        c2 = 3;
                    }
                    c2 = 65535;
                } else if (hashCode == 2374300) {
                    if (simpleName.equals("Long")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode != 67973692) {
                    if (hashCode == 1729365000 && simpleName.equals("Boolean")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (simpleName.equals("Float")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (c2 == 1) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (c2 == 2) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                } else if (c2 != 3) {
                    edit.putString(str, (String) obj);
                } else {
                    edit.putInt(str, ((Integer) obj).intValue());
                }
                z = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            edit.apply();
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static void putEncryptStr(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
            String a2 = a();
            try {
                str2 = SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(str2, new StringBuffer(a2).reverse().toString(), a2));
            } catch (Exception e2) {
                Log.e(e2);
            }
            put(str, str2);
        }
    }

    public static void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f37658b.edit().remove(str).apply();
        }
    }
}
