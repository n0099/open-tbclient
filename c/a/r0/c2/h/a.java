package c.a.r0.c2.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.k0.b.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f16515e;

    /* renamed from: f  reason: collision with root package name */
    public String f16516f;

    /* renamed from: g  reason: collision with root package name */
    public String f16517g;

    /* renamed from: h  reason: collision with root package name */
    public long f16518h;

    /* renamed from: i  reason: collision with root package name */
    public String f16519i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16520j;
    public boolean k;
    public int l;
    public boolean m;
    public long n;
    public int o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public boolean t;

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
                return;
            }
        }
        this.f16515e = "";
        this.f16516f = "";
        this.f16517g = "";
        this.f16518h = System.currentTimeMillis();
        this.f16519i = "";
        this.f16520j = false;
        this.k = false;
        this.l = 0;
        this.m = false;
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = true;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.s = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f16517g = str;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f16520j = z;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.p = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.t = z;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.q = str;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.m = z;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f16519i = str;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f16515e = str;
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f16516f = str;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.l = i2;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.r = str;
        }
    }

    public JSONObject N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_name", this.f16517g);
                jSONObject.put("thread_id", this.f16515e);
                jSONObject.put("thread_time", this.f16518h);
                jSONObject.put("thread_name", this.f16516f);
                jSONObject.put("post_id", this.f16519i);
                jSONObject.put("host_only", this.f16520j);
                jSONObject.put("squence", this.k);
                jSONObject.put("thread_type", this.l);
                jSONObject.put("is_manga", this.m);
                jSONObject.put("cartoon_id", this.n);
                jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.o);
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, this.p);
                jSONObject.put("live_id", this.q);
                jSONObject.put("user_name", this.r);
                jSONObject.put("live_description", this.s);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.o : invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f16517g : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (this.l == 49) {
                    String str3 = this.q;
                    if (str3 != null && (str2 = aVar.q) != null && str3.equals(str2)) {
                        return true;
                    }
                } else {
                    String str4 = this.f16515e;
                    if (str4 != null && (str = aVar.f16515e) != null && str4.equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f16519i : (String) invokeV.objValue;
    }

    @Override // c.a.q0.k0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.l == 49) {
                return this.q + "_ala";
            }
            return this.f16515e;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.k0.b.e
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? N().toString() : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int hashCode = TextUtils.isEmpty(this.f16515e) ? 120 : 119 + this.f16515e.hashCode();
            int hashCode2 = TextUtils.isEmpty(this.f16516f) ? (hashCode * 7) + 1 : (hashCode * 7) + this.f16516f.hashCode();
            int hashCode3 = ((TextUtils.isEmpty(this.f16517g) ? (hashCode2 * 7) + 1 : (hashCode2 * 7) + this.f16517g.hashCode()) * 7) + ((int) this.f16518h);
            int hashCode4 = TextUtils.isEmpty(this.f16519i) ? (hashCode3 * 7) + 1 : (hashCode3 * 7) + this.f16519i.hashCode();
            int hashCode5 = TextUtils.isEmpty(this.q) ? (hashCode4 * 7) + 1 : (hashCode4 * 7) + this.q.hashCode();
            return ((((TextUtils.isEmpty(this.s) ? (hashCode5 * 7) + 1 : (hashCode5 * 7) + this.s.hashCode()) * 7) + (this.f16520j ? 1 : 0)) * 7) + (this.k ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f16515e : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f16516f : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.l : invokeV.intValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f16518h : invokeV.longValue;
    }

    @Override // c.a.q0.k0.b.e
    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (str != null) {
                try {
                    return x(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f16520j : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean x(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jSONObject)) == null) {
            String optString = jSONObject.optString("forum_name");
            String optString2 = jSONObject.optString("thread_id");
            String optString3 = jSONObject.optString("thread_name");
            long optLong = jSONObject.optLong("thread_time");
            this.f16519i = jSONObject.optString("post_id");
            this.f16520j = jSONObject.optBoolean("host_only");
            this.k = jSONObject.optBoolean("squence");
            this.m = jSONObject.optBoolean("is_manga");
            this.n = jSONObject.optLong("cartoon_id");
            this.o = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            this.p = jSONObject.optBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            if (!TextUtils.isEmpty(optString)) {
                this.f16517g = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.f16515e = optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                this.f16516f = optString3;
            }
            if (optLong > 2000) {
                this.f16518h = optLong;
            }
            this.l = jSONObject.optInt("thread_type");
            this.q = jSONObject.optString("live_id", "");
            this.r = jSONObject.optString("user_name", "");
            this.s = jSONObject.optString("live_description", "");
            return true;
        }
        return invokeL.booleanValue;
    }

    public void y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j2) == null) {
            this.n = j2;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.o = i2;
        }
    }
}
