package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.h.a;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.h;
import com.baidu.sofire.utility.v;
import com.baidu.sofire.utility.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class F implements FI {
    public static /* synthetic */ Interceptable $ic;
    public static F instance;
    public static Asc sAsc;
    public transient /* synthetic */ FieldHolder $fh;

    public F() {
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

    public static synchronized F getInstance() {
        InterceptResult invokeV;
        F f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (F.class) {
                if (instance == null) {
                    instance = new F();
                }
                f2 = instance;
            }
            return f2;
        }
        return (F) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] a2 = h.a(bArr2, bArr);
                        if (a2 != null && a2.length != 0) {
                            return a2;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused) {
                    c.a();
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] a2 = h.a(bArr2, bArr, true);
                        if (a2 != null && a2.length != 0) {
                            return a2;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused) {
                    c.a();
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r8.onEnd(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        return;
     */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, callback, clsArr, objArr}) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    f a2 = f.a();
                    if (a2 == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                            return;
                        }
                        return;
                    }
                    ApkInfo d2 = a2.d(str2);
                    if (a2.d(str) == null || d2 == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                            return;
                        }
                        return;
                    }
                    Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                    Object a4 = c.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, null), str3, clsArr, objArr);
                    if (callback != null) {
                        callback.onEnd(a4);
                    }
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, clsArr, objArr})) == null) {
            try {
                com.baidu.sofire.core.c a2 = com.baidu.sofire.core.c.a();
                if (a2 == null) {
                    return new Pair<>(4, null);
                }
                return a2.a(i2, str, clsArr, objArr);
            } catch (Throwable unused) {
                c.a();
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean cp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (context == null) {
                return false;
            }
            return v.a(context);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) {
            if (context == null) {
                return null;
            }
            return a.a(context).a(str);
        }
        return (SharedPreferences) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformPrivateSharedPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return a.a(context).f45340a;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformSharedSharedPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return a.a(context).f45342c;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f45156d;
                if (aVar != null) {
                    return aVar.b();
                }
                return null;
            } catch (Throwable unused) {
                c.a();
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        InterceptResult invokeL;
        ApkInfo d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                f a2 = f.a();
                return (a2 == null || (d2 = a2.d(str)) == null) ? "" : d2.libPath;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) ? context == null ? "" : com.baidu.sofire.utility.e.b(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            try {
                ApkInfo apkInfo = f.a().f45297a.get(str);
                if (apkInfo == null) {
                    return null;
                }
                return apkInfo.pkgPath;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        f a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, intentFilter, str2, str3) == null) {
            try {
                if (TextUtils.isEmpty(str) || intentFilter == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a2 = f.a()) == null) {
                    return;
                }
                a2.a(new g(str, intentFilter, str2, str3));
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] c2 = h.c(bArr, bArr2);
                        if (c2 != null && c2.length != 0) {
                            return c2;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused) {
                    c.a();
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] b2 = h.b(bArr, bArr2);
                        if (b2 != null && b2.length != 0) {
                            return b2;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused) {
                    c.a();
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, context) == null) || context == null) {
            return;
        }
        try {
            z.a(context).b(new U(context.getApplicationContext(), 5, true));
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            try {
                com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f45156d;
                if (aVar != null) {
                    int i3 = z ? 1 : 0;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("s", Integer.valueOf(i3));
                    SQLiteDatabase sQLiteDatabase = aVar.f45159c;
                    sQLiteDatabase.update("pgn", contentValues, "k=" + i2 + " and n=1", null);
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, str, z) == null) {
            try {
                com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f45156d;
                if (aVar != null) {
                    int i2 = z ? 1 : 0;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("s", Integer.valueOf(i2));
                    aVar.f45159c.update("pgn", contentValues, "p=? and n=1", new String[]{str});
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            try {
                com.baidu.sofire.core.c.a().a(str);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        f a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048597, this, str, intentFilter, str2, str3) == null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a2 = f.a()) == null) {
                    return;
                }
                a2.b(new g(str, intentFilter, str2, str3));
            } catch (Throwable unused) {
                c.a();
            }
        }
    }
}
