package c.a.p0.h.a.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9963b;

    /* renamed from: c  reason: collision with root package name */
    public String f9964c;

    /* renamed from: d  reason: collision with root package name */
    public String f9965d;

    /* renamed from: e  reason: collision with root package name */
    public String f9966e;

    /* renamed from: f  reason: collision with root package name */
    public String f9967f;

    /* renamed from: g  reason: collision with root package name */
    public String f9968g;

    /* renamed from: h  reason: collision with root package name */
    public String f9969h;

    /* renamed from: i  reason: collision with root package name */
    public String f9970i;

    /* renamed from: j  reason: collision with root package name */
    public String f9971j;

    public a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            this.a = jSONObject.optString("download_state", "");
            this.f9971j = jSONObject.optString("download_hint", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("app_info");
            if (optJSONObject != null) {
                this.f9963b = optJSONObject.optString("app_name", "");
                this.f9964c = optJSONObject.optString("developer_name", "");
                this.f9965d = optJSONObject.optString("app_icon", "");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("privacy");
                if (optJSONObject2 != null) {
                    this.f9967f = optJSONObject2.optString("cmd", "");
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("permission");
                if (optJSONObject3 != null) {
                    this.f9968g = optJSONObject3.optString("cmd", "");
                }
                this.f9969h = optJSONObject.optString("apk_url", "");
                this.f9966e = optJSONObject.optString("version", "");
                this.f9970i = optJSONObject.optString("apk_size", "");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f9970i : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f9969h : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f9963b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f9964c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f9971j : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f9965d : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9968g : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f9967f : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f9966e : (String) invokeV.objValue;
    }
}
