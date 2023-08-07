package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.b.b;
import com.baidu.sofire.b.h;
import com.baidu.sofire.b.i;
import com.baidu.sofire.b.j;
import com.baidu.sofire.c.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.k.d;
import com.baidu.sofire.k.f;
import com.baidu.sofire.k.k;
import com.baidu.sofire.k.m;
import com.baidu.sofire.k.n;
import com.baidu.sofire.k.o;
import com.baidu.sofire.k.q;
import com.baidu.sofire.k.r;
import com.baidu.sofire.k.u;
import com.baidu.sofire.rp.Report;
import com.baidu.tieba.k20;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class F implements FI {
    public static /* synthetic */ Interceptable $ic;
    public static F instance;
    public static Asc sAsc;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public F() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized F getInstance() {
        InterceptResult invokeV;
        F f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (F.class) {
                if (instance == null) {
                    instance = new F();
                }
                f = instance;
            }
            return f;
        }
        return (F) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Context gct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (b.d == null) {
                return null;
            }
            return b.e;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Boolean, DeviceInfoCallback> getDeviceInfoCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new Pair<>(Boolean.FALSE, q.a);
        }
        return (Pair) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Long, Throwable> gg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            boolean z = k.a;
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(k.c);
            k.c.clear();
            return concurrentHashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Long, Throwable> gi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            boolean z = k.a;
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(k.b);
            k.b.clear();
            return concurrentHashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                a aVar = a.d;
                if (aVar != null) {
                    return aVar.c();
                }
                return null;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return null;
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        byte[] a = f.a(bArr2, bArr, true);
                        if (a != null && a.length != 0) {
                            return a;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
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
                        byte[] b = f.b(bArr2, bArr, true);
                        if (b != null && b.length != 0) {
                            return b;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048602, this, str, z) == null) {
            try {
                a aVar = a.d;
                if (aVar != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("s", Integer.valueOf(z ? 1 : 0));
                    aVar.b.update("pgn", contentValues, "p=? and n=1", new String[]{str});
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        r8.onEnd(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
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
                    i iVar = i.g;
                    if (iVar == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                            return;
                        }
                        return;
                    }
                    ApkInfo b = iVar.b(str2);
                    if (iVar.b(str) != null && b != null) {
                        Class<?> a = ((h) b.classLoader).a(com.baidu.sofire.k.b.b(b.es));
                        Object a2 = com.baidu.sofire.k.b.a(a.getDeclaredMethod("getInstance", Context.class).invoke(a, null), str3, clsArr, objArr);
                        if (callback != null) {
                            callback.onEnd(a2);
                        }
                    } else if (callback != null) {
                        callback.onEnd(new Object[0]);
                    }
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            try {
                b bVar = b.d;
                if (bVar == null) {
                    return new Pair<>(4, null);
                }
                return bVar.a(i, str, clsArr, objArr);
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
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
            return r.a(context);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformPrivateSharedPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return com.baidu.sofire.j.a.a(context).a;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformSharedSharedPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (context == null) {
                return null;
            }
            return com.baidu.sofire.j.a.a(context).c;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        InterceptResult invokeL;
        ApkInfo b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            try {
                i iVar = i.g;
                if (iVar == null || (b = iVar.b(str)) == null) {
                    return "";
                }
                return b.libPath;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            if (context == null) {
                return "";
            }
            return d.a(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            try {
                ApkInfo apkInfo = i.g.d.get(str);
                if (apkInfo == null) {
                    return null;
                }
                return apkInfo.pkgPath;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, context) != null) || context == null) {
            return;
        }
        try {
            u.a(context).b(new U(context.getApplicationContext(), 5, true));
        } catch (Throwable unused) {
            int i = com.baidu.sofire.a.b.a;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            try {
                b.d.b(str);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
            if (context == null) {
                return null;
            }
            return com.baidu.sofire.j.a.a(context).a(str);
        }
        return (SharedPreferences) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                a aVar = a.d;
                if (aVar != null) {
                    aVar.a(i, z ? 1 : 0);
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gm(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    i iVar = i.g;
                    if (iVar == null) {
                        return "-2";
                    }
                    ApkInfo b = iVar.b(str);
                    if (b == null) {
                        return "-3";
                    }
                    if (!str2.equals(b.versionName)) {
                        return EventType.PayEventID.QUERY_PRODUCT_LIST_FAIL;
                    }
                    String str3 = b.apkMD5;
                    if (U.sRealtimeMd5Map != null) {
                        String str4 = U.sRealtimeMd5Map.get(b.key + b.versionName);
                        if (!TextUtils.isEmpty(str4)) {
                            return str4;
                        }
                        return str3;
                    }
                    return str3;
                }
                return "-1";
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
                return EventType.PayEventID.QUERY_PRODUCT_LIST_SUCCESS;
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String goh(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            if (i.a(context).a()) {
                synchronized (o.class) {
                    Object obj = o.a;
                    String[] strArr = {""};
                    boolean[] zArr = {false};
                    k20.f(context).o(new m(strArr, zArr));
                    if (!zArr[0]) {
                        try {
                            synchronized (o.a) {
                                o.a.wait(o.c.longValue());
                            }
                        } catch (InterruptedException unused) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                    }
                    str = strArr[0];
                }
                return str;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public String gom(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            if (i.a(context).a()) {
                synchronized (o.class) {
                    Object obj = o.a;
                    String[] strArr = {""};
                    boolean[] zArr = {false};
                    if (MdidSdkHelper.InitSdk(context, false, new n(strArr, zArr)) != 1008610) {
                        zArr[0] = true;
                    }
                    if (!zArr[0]) {
                        try {
                            synchronized (o.b) {
                                o.b.wait(o.c.longValue());
                            }
                        } catch (InterruptedException unused) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                    }
                    str = strArr[0];
                }
                return str;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048597, this, str, intentFilter, str2, str3) == null) {
            try {
                if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (iVar = i.g) != null) {
                    iVar.a(new j(str, intentFilter, str2, str3));
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048606, this, str, intentFilter, str2, str3) == null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (iVar = i.g) != null) {
                    iVar.b(new j(str, intentFilter, str2, str3));
                }
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0025, code lost:
        if (r5.length > 0) goto L28;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x002e -> B:25:0x0027). Please submit an issue!!! */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] bArr3;
        byte[] bArr4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        Asc asc = f.a;
                        try {
                        } catch (Throwable unused) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                        if (bArr2.length > 0 && bArr.length > 0) {
                            Asc asc2 = f.a;
                            if (asc2 != null) {
                                bArr3 = asc2.dr(bArr, bArr2);
                                if (bArr3 != null) {
                                }
                            }
                            bArr3 = new byte[0];
                            bArr4 = bArr3;
                            if (bArr4 != null && bArr4.length != 0) {
                                return bArr4;
                            }
                            return new byte[0];
                        }
                        bArr3 = new byte[0];
                        bArr4 = bArr3;
                        if (bArr4 != null) {
                            return bArr4;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0025, code lost:
        if (r5.length > 0) goto L28;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x002e -> B:25:0x0027). Please submit an issue!!! */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] re(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] bArr3;
        byte[] bArr4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                        Asc asc = f.a;
                        try {
                        } catch (Throwable unused) {
                            int i = com.baidu.sofire.a.b.a;
                        }
                        if (bArr2.length > 0 && bArr.length > 0) {
                            Asc asc2 = f.a;
                            if (asc2 != null) {
                                bArr3 = asc2.ar(bArr, bArr2);
                                if (bArr3 != null) {
                                }
                            }
                            bArr3 = new byte[0];
                            bArr4 = bArr3;
                            if (bArr4 != null && bArr4.length != 0) {
                                return bArr4;
                            }
                            return new byte[0];
                        }
                        bArr3 = new byte[0];
                        bArr4 = bArr3;
                        if (bArr4 != null) {
                            return bArr4;
                        }
                        return new byte[0];
                    }
                } catch (Throwable unused2) {
                    int i2 = com.baidu.sofire.a.b.a;
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.baidu.sofire.ac.FI
    public void sse(Context context, String str, Map<String, Object> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{context, str, map, Boolean.valueOf(z)}) == null) {
            com.baidu.sofire.k.b.a(context, str, map, z);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sser(Context context, String str, Map<String, Object> map) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048604, this, context, str, map) == null) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("0", System.currentTimeMillis());
                jSONObject2.put("1", "");
                jSONObject2.put("2", "");
                String[] o = com.baidu.sofire.k.b.o(context);
                if (o.length != 2 || TextUtils.isEmpty(o[0]) || TextUtils.isEmpty(o[1])) {
                    str2 = "3";
                } else {
                    str2 = o[0];
                }
                jSONObject2.put("3", str2);
                jSONObject2.put("4", 0);
                jSONObject2.put("5", 0);
                jSONObject2.put("6", 1);
                jSONObject2.put("7", 0);
                jSONObject2.put("8", "sofire");
                jSONObject2.put("9", "3.6.0.4");
                jSONObject2.put("10", str);
                jSONObject.put("Common_section", jSONObject2);
                if (map != null && map.size() > 0) {
                    jSONObject.put("Module_section", new JSONObject(map));
                } else {
                    jSONObject.put("Module_section", new JSONObject());
                }
                Report.getInstance(context).sr(jSONObject.toString());
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
