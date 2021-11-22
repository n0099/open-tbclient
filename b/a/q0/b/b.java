package b.a.q0.b;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f12622b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a> f12623a;

    public b() {
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
        this.f12623a = new HashMap<>();
        HashMap<String, a> d2 = d();
        this.f12623a.clear();
        this.f12623a.putAll(d2);
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f12622b == null) {
                synchronized (b.class) {
                    if (f12622b == null) {
                        f12622b = new b();
                    }
                }
            }
            return f12622b;
        }
        return (b) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static SharedPreferences g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences(f(), 0) : (SharedPreferences) invokeV.objValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? "a".equalsIgnoreCase(e().b(str, "")) : invokeL.booleanValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                synchronized (this.f12623a) {
                    this.f12623a.clear();
                }
                SharedPreferences.Editor edit = g().edit();
                edit.clear();
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            a c2 = c(str);
            return (c2 == null || TextUtils.isEmpty(c2.f12621a)) ? str2 : c2.f12621a;
        }
        return (String) invokeLL.objValue;
    }

    public synchronized a c(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                aVar = this.f12623a.get(str);
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final HashMap<String, a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, a> hashMap = new HashMap<>();
            try {
                JSONArray jSONArray = new JSONArray(g().getString("pref_key_abtest_switchs", "[]"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("name");
                        hashMap.put(optString, new a(optString, jSONObject.optString("branch"), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME)));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void i(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) {
            try {
                if (jSONArray == null) {
                    a();
                    return;
                }
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("name");
                        hashMap.put(optString, new a(optString, jSONObject.optString("branch"), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME)));
                    }
                }
                synchronized (this.f12623a) {
                    this.f12623a.clear();
                    this.f12623a.putAll(hashMap);
                }
                EditorHelper.putString(g(), "pref_key_abtest_switchs", jSONArray.toString());
                b.a.q0.s.e0.b.j().v("perf_start_open", h("performance_start_small_flow") ? 1 : 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
