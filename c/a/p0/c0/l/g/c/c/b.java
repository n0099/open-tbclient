package c.a.p0.c0.l.g.c.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f13333b;

    /* renamed from: c  reason: collision with root package name */
    public int f13334c;

    /* renamed from: d  reason: collision with root package name */
    public int f13335d;

    /* renamed from: e  reason: collision with root package name */
    public String f13336e;

    /* renamed from: f  reason: collision with root package name */
    public String f13337f;

    /* renamed from: g  reason: collision with root package name */
    public String f13338g;

    /* renamed from: h  reason: collision with root package name */
    public int f13339h;
    public int i;
    public String j;
    public String k;
    public List<d> l;
    public int m;
    public long n;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13338g : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13335d : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13336e : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13337f : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13339h : invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13334c : invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i : invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f13333b == 1 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f13334c == 9 : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f13334c == 10 : invokeV.booleanValue;
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            this.f13334c = jSONObject.optInt("type");
            this.f13335d = jSONObject.optInt("mark_id");
            this.f13336e = jSONObject.optString("mark_name");
            this.f13338g = jSONObject.optString("description");
            this.i = jSONObject.optInt("wear_status");
            this.f13337f = jSONObject.optString("mark_pic");
            this.f13339h = jSONObject.optInt("mark_rank");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optInt("weight");
            this.j = jSONObject.optString("next_level_diff");
            jSONObject.optString("mark_dir_level");
            this.k = jSONObject.optString("expire_text");
            jSONObject.optString("begin_time");
            jSONObject.optString("end_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("mark_other");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    d dVar = new d();
                    dVar.e(optJSONArray.optJSONObject(i));
                    this.l.add(dVar);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
            if (optJSONObject != null) {
                this.m = c.a.d.f.m.b.e(optJSONObject.optString("props_id"), -1);
                this.n = c.a.d.f.m.b.g(optJSONObject.optString("price"), 0L);
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
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f13333b = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.i = i;
        }
    }
}
