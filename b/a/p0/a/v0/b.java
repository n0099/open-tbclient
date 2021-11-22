package b.a.p0.a.v0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.e;
import b.a.p0.a.o2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f9143a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9144b;

    /* renamed from: c  reason: collision with root package name */
    public String f9145c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f9146d;

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
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (b.a.p0.a.d2.d.J().l() == 0) {
                return c(this.f9146d, "bbasp_guide_");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray optJSONArray = this.f9146d.optJSONArray("custom_guide_list");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("appid", "");
                    if (e.f0() == null || TextUtils.equals(e.f0(), optString)) {
                        return c(optJSONObject, "");
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            boolean z = false;
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString(str + "count", "3");
            try {
                int intValue = !TextUtils.isEmpty(optString) ? Integer.valueOf(optString).intValue() : 0;
                String optString2 = jSONObject.optString(str + "interval", "72");
                long longValue = !TextUtils.isEmpty(optString2) ? Long.valueOf(optString2).longValue() : 0L;
                long optLong = jSONObject.optLong(str + "last_time", 0L);
                int optInt = jSONObject.optInt(str + "shown_count", 0);
                int optInt2 = jSONObject.optInt(str + "image_index", 0);
                boolean z2 = System.currentTimeMillis() - optLong > longValue * 3600000;
                boolean i2 = i(jSONObject.optJSONArray("scenes"));
                if (optInt < intValue && z2 && i2) {
                    z = true;
                }
                if (z) {
                    g(jSONObject, optInt2, str + "images");
                }
            } catch (NumberFormatException unused) {
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String string = h.a().getString("swan_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f9143a) {
                return "special";
            }
            if (this.f9144b) {
                return "normal";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9145c : (String) invokeV.objValue;
    }

    public final int g(JSONObject jSONObject, int i2, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, jSONObject, i2, str)) == null) {
            if (jSONObject == null || i2 < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i2 >= optJSONArray.length()) {
                i2 = 0;
            }
            this.f9145c = optJSONArray.optString(i2);
            return i2;
        }
        return invokeLIL.intValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f9143a = false;
            this.f9144b = false;
            this.f9145c = null;
            JSONObject d2 = d();
            this.f9146d = d2;
            if (d2 != null && d2.length() != 0) {
                boolean b2 = b();
                this.f9143a = b2;
                if (b2) {
                    return this;
                }
                this.f9144b = a();
            }
            return this;
        }
        return (b) invokeV.objValue;
    }

    public final boolean i(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return true;
            }
            String T = b.a.p0.a.d2.d.J().r().V().T();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals(T, jSONArray.optString(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f9144b || this.f9143a : invokeV.booleanValue;
    }
}
