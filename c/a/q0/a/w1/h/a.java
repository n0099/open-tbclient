package c.a.q0.a.w1.h;

import android.text.TextUtils;
import android.util.Log;
import c.a.q0.a.d2.e;
import c.a.q0.a.k;
import c.a.q0.a.z2.o;
import c.a.q0.q.i.i;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialOperation;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1672263646, "Lc/a/q0/a/w1/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1672263646, "Lc/a/q0/a/w1/h/a;");
                return;
            }
        }
        a = k.a;
    }

    public static String a(String str, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j2), str2})) == null) {
            e L = e.L();
            String[] strArr = {L != null ? c.a.q0.a.v.a.a(L.N()) : "", str, String.valueOf(j2), str2};
            Arrays.sort(strArr);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 4; i2++) {
                sb.append(strArr[i2]);
            }
            try {
                return o.c("SHA-1", sb.toString().getBytes(), false);
            } catch (NoSuchAlgorithmException unused) {
                boolean z = a;
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iVar)) == null) {
            if (iVar == null) {
                return "";
            }
            String str = iVar.p;
            JSONObject jSONObject = new JSONObject();
            String uuid = UUID.randomUUID().toString();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                jSONObject.put("noncestr", uuid);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put(SocialOperation.GAME_SIGNATURE, a(uuid, currentTimeMillis, str));
            } catch (JSONException e2) {
                c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(String str, String str2, i iVar) {
        InterceptResult invokeLLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, iVar)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && iVar != null) {
                String str3 = iVar.q;
                if (TextUtils.isEmpty(str3)) {
                    return false;
                }
                try {
                    JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str);
                    if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
                        return false;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return c.a.q0.a.e2.a.b.b(new URI(str2).getHost(), arrayList);
                } catch (URISyntaxException | JSONException e2) {
                    c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
