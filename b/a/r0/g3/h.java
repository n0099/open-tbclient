package b.a.r0.g3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16849a;

    /* renamed from: b  reason: collision with root package name */
    public String f16850b;

    /* renamed from: c  reason: collision with root package name */
    public int f16851c;

    /* renamed from: d  reason: collision with root package name */
    public String f16852d;

    /* renamed from: e  reason: collision with root package name */
    public int f16853e;

    /* renamed from: f  reason: collision with root package name */
    public String f16854f;

    /* renamed from: g  reason: collision with root package name */
    public a f16855g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f16856h;

    public h() {
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
        this.f16855g = new a();
        this.f16856h = new ArrayList<>();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16853e : invokeV.intValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16855g : (a) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16854f : (String) invokeV.objValue;
    }

    public ArrayList<i> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16856h : (ArrayList) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16851c : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16850b : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16852d : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16849a : invokeV.intValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || str == null) {
            return;
        }
        try {
            j(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f16855g.c(jSONObject.optJSONObject("error"));
            this.f16849a = jSONObject.optInt("show_dialog");
            this.f16850b = jSONObject.optString("sign_notice");
            this.f16851c = jSONObject.optInt("is_timeout");
            this.f16852d = jSONObject.optString("timeout_notice");
            this.f16853e = jSONObject.optInt("error_code");
            this.f16854f = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f16856h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
