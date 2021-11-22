package b.a.p0.q.k.i.t;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.q.c;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, b> f11939a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, b> f11940b;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    @NonNull
    public static b a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (f11939a == null) {
                synchronized (a.class) {
                    if (f11939a == null) {
                        HashMap<String, b> hashMap = new HashMap<>();
                        f11939a = hashMap;
                        e(hashMap, "download_api_ctrl");
                    }
                }
            }
            return c(str, f11939a);
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public static b b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f11940b == null) {
                synchronized (a.class) {
                    if (f11940b == null) {
                        HashMap<String, b> hashMap = new HashMap<>();
                        f11940b = hashMap;
                        e(hashMap, "preload_api_ctrl");
                    }
                }
            }
            return c(str, f11940b);
        }
        return (b) invokeL.objValue;
    }

    @NonNull
    public static b c(@Nullable String str, @NonNull HashMap<String, b> hashMap) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, hashMap)) == null) {
            if (TextUtils.isEmpty(str) || (bVar = hashMap.get(str)) == null) {
                b bVar2 = hashMap.get("default");
                return bVar2 != null ? bVar2 : b.a();
            }
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.c().a("SwanDownloadApiStrategy").getString("version", "0") : (String) invokeV.objValue;
    }

    public static void e(@NonNull HashMap<String, b> hashMap, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, hashMap, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(c.c().a("SwanDownloadApiStrategy").getString("data", StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            hashMap.put(next, b.b(optJSONObject.optJSONObject(next)));
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void f(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        b.a.p0.w.b a2 = c.c().a("SwanDownloadApiStrategy");
        a2.putString("version", optString);
        a2.putString("data", optJSONObject != null ? optJSONObject.toString() : null);
    }
}
