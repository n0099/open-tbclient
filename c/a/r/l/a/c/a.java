package c.a.r.l.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.r.h.c.a.e;
import c.a.r.h.c.a.f;
import c.a.r.h.c.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f5262g;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5263b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f5264c;

    /* renamed from: d  reason: collision with root package name */
    public String f5265d;

    /* renamed from: e  reason: collision with root package name */
    public Context f5266e;

    /* renamed from: f  reason: collision with root package name */
    public int f5267f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1125507578, "Lc/a/r/l/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1125507578, "Lc/a/r/l/a/c/a;");
                return;
            }
        }
        f5262g = new byte[]{77, 73, 78, 71};
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
            }
        }
    }

    public static boolean e(String str, Context context, JSONObject jSONObject, Set<String> set) throws JSONException, PackageManager.NameNotFoundException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, context, jSONObject, set)) == null) {
            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = jSONArray.getString(i2);
            }
            String[] h2 = h(context.getPackageManager().getPackageInfo(str, 64).signatures);
            if (h2 != null && h2.length > 0) {
                Collections.addAll(set, h2);
            }
            return g(strArr, h2);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean g(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, strArr, strArr2)) == null) {
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            HashSet hashSet2 = new HashSet();
            for (String str2 : strArr2) {
                hashSet2.add(str2);
            }
            return hashSet.equals(hashSet2);
        }
        return invokeLL.booleanValue;
    }

    public static String[] h(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = f.c(signatureArr[i2].toByteArray());
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5264c : (Set) invokeV.objValue;
    }

    public final void b(Bundle bundle, c.a.r.h.b.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, aVar) == null) {
            try {
                if (aVar == null) {
                    this.f5267f |= 16;
                    return;
                }
                String string = bundle.getString("helios_data");
                if (TextUtils.isEmpty(string)) {
                    this.f5267f |= 1;
                    return;
                }
                String string2 = bundle.getString("helios_sf");
                if (TextUtils.isEmpty(string2)) {
                    this.f5267f |= 2;
                    return;
                }
                byte[] decode = Base64.decode(string.getBytes("utf-8"), 1);
                for (int i2 = 0; i2 < decode.length; i2++) {
                    decode[i2] = (byte) (decode[i2] ^ f5262g[i2 % f5262g.length]);
                }
                JSONObject jSONObject = new JSONObject(new String(decode));
                if (f(jSONObject)) {
                    HashSet hashSet = new HashSet();
                    this.f5264c = hashSet;
                    if (!e(this.f5265d, this.f5266e, jSONObject, hashSet)) {
                        this.f5267f |= 4;
                    } else if (!Arrays.equals(g.a(Base64.decode(string2, 0), aVar), f.b(decode))) {
                        this.f5267f |= 8;
                    } else {
                        this.a = jSONObject.getLong("priority");
                        this.f5263b = true;
                    }
                }
            } catch (Exception e2) {
                this.f5267f |= 256;
                Log.getStackTraceString(e2);
            }
        }
    }

    public void c(c.a.r.h.b.e.a aVar, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, aVar, z) == null) {
            PackageManager packageManager = this.f5266e.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(this.f5265d, 2);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null || (activityInfoArr = packageInfo.receivers) == null || activityInfoArr.length <= 0) {
                return;
            }
            for (ActivityInfo activityInfo2 : activityInfoArr) {
                if ("com.baidu.helios.DummyProvider".equals(activityInfo2.name)) {
                    try {
                        activityInfo = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        activityInfo = null;
                    }
                    if (activityInfo != null && (bundle = activityInfo.metaData) != null && bundle.containsKey("helios") && z) {
                        b(bundle, aVar);
                    }
                }
            }
        }
    }

    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
            this.f5265d = str;
            this.f5266e = context;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r10.equals(r9.f5265d) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r0.startsWith(r10) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            e eVar = new e();
            eVar.b(jSONObject.optLong("flags"));
            String optString = jSONObject.optString("package", "");
            long a = eVar.a(7L);
            if (!optString.equals("") || a == 4) {
                if (a != 0) {
                    if (a == 1) {
                        String str = this.f5265d;
                        if (str != null) {
                        }
                        i2 = this.f5267f | 32;
                        this.f5267f = i2;
                        return false;
                    } else if (a == 2) {
                        try {
                            if (!Pattern.compile(optString).matcher(this.f5265d).matches()) {
                                this.f5267f |= 32;
                                return false;
                            }
                        } catch (Exception unused) {
                            i2 = this.f5267f | 128;
                        }
                    } else if (a == 4) {
                        return true;
                    }
                    return true;
                }
            }
            i2 = this.f5267f | 64;
            this.f5267f = i2;
            return false;
        }
        return invokeL.booleanValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.longValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f5263b : invokeV.booleanValue;
    }
}
