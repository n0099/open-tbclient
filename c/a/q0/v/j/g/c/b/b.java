package c.a.q0.v.j.g.c.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25717a;

    /* renamed from: b  reason: collision with root package name */
    public int f25718b;

    /* renamed from: c  reason: collision with root package name */
    public int f25719c;

    /* renamed from: d  reason: collision with root package name */
    public int f25720d;

    /* renamed from: e  reason: collision with root package name */
    public String f25721e;

    /* renamed from: f  reason: collision with root package name */
    public String f25722f;

    /* renamed from: g  reason: collision with root package name */
    public String f25723g;

    /* renamed from: h  reason: collision with root package name */
    public int f25724h;

    /* renamed from: i  reason: collision with root package name */
    public int f25725i;

    /* renamed from: j  reason: collision with root package name */
    public String f25726j;
    public String k;
    public List<d> l;
    public int m;
    public long n;

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
        this.m = -1;
        this.l = new ArrayList();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25723g : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public List<d> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.l == null) {
                this.l = new ArrayList();
            }
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25720d : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25721e : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25722f : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25724h : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25717a : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f25726j : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f25725i : invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f25718b == 1 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f25719c == 9 : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f25719c == 10 : invokeV.booleanValue;
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            this.f25719c = jSONObject.optInt("type");
            this.f25720d = jSONObject.optInt("mark_id");
            this.f25721e = jSONObject.optString("mark_name");
            this.f25723g = jSONObject.optString("description");
            this.f25725i = jSONObject.optInt("wear_status");
            this.f25722f = jSONObject.optString("mark_pic");
            this.f25724h = jSONObject.optInt("mark_rank");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optInt("weight");
            this.f25726j = jSONObject.optString("next_level_diff");
            jSONObject.optString("mark_dir_level");
            this.k = jSONObject.optString("expire_text");
            jSONObject.optString(ExternalTransferSpeedStats.UBC_APPLICATION_CREATE_KEY);
            jSONObject.optString("end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.e(optJSONArray.optJSONObject(i2));
                    this.l.add(dVar);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
            if (optJSONObject != null) {
                this.m = c.a.e.e.m.b.d(optJSONObject.optString("props_id"), -1);
                this.n = c.a.e.e.m.b.f(optJSONObject.optString("price"), 0L);
                optJSONObject.optString("buy_cycle");
                optJSONObject.optInt("buy_staus");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("nobility_info");
            if (optJSONObject2 != null) {
                optJSONObject2.optInt("nobility_type");
                optJSONObject2.optString("nobility_type_name");
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f25717a = str;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f25718b = i2;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f25725i = i2;
        }
    }
}
