package c.a.p0.o2.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.k0.b.e;
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
/* loaded from: classes2.dex */
public class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f16857b;

    /* renamed from: c  reason: collision with root package name */
    public String f16858c;

    /* renamed from: d  reason: collision with root package name */
    public long f16859d;

    /* renamed from: e  reason: collision with root package name */
    public String f16860e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16861f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16862g;

    /* renamed from: h  reason: collision with root package name */
    public int f16863h;
    public boolean i;
    public long j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public boolean p;

    public a() {
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
        this.a = "";
        this.f16857b = "";
        this.f16858c = "";
        this.f16859d = System.currentTimeMillis();
        this.f16860e = "";
        this.f16861f = false;
        this.f16862g = false;
        this.f16863h = 0;
        this.i = false;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = true;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.o = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f16858c = str;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f16861f = z;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.p = z;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i = z;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f16860e = str;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f16862g = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.a = str;
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f16857b = str;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f16863h = i;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.n = str;
        }
    }

    public JSONObject N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_name", this.f16858c);
                jSONObject.put("thread_id", this.a);
                jSONObject.put("thread_time", this.f16859d);
                jSONObject.put("thread_name", this.f16857b);
                jSONObject.put("post_id", this.f16860e);
                jSONObject.put("host_only", this.f16861f);
                jSONObject.put("squence", this.f16862g);
                jSONObject.put("thread_type", this.f16863h);
                jSONObject.put("is_manga", this.i);
                jSONObject.put("cartoon_id", this.j);
                jSONObject.put(MangaBrowserActivityConfig.CHAPTER_ID, this.k);
                jSONObject.put(VideoPlayActivityConfig.IS_SHARE_THREAD, this.l);
                jSONObject.put("live_id", this.m);
                jSONObject.put("user_name", this.n);
                jSONObject.put("live_description", this.o);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f16858c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (this.f16863h == 49) {
                    String str3 = this.m;
                    if (str3 != null && (str2 = aVar.m) != null && str3.equals(str2)) {
                        return true;
                    }
                } else {
                    String str4 = this.a;
                    if (str4 != null && (str = aVar.a) != null && str4.equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f16860e : (String) invokeV.objValue;
    }

    @Override // c.a.o0.k0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f16863h == 49) {
                return this.m + "_ala";
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int hashCode = TextUtils.isEmpty(this.a) ? 120 : 119 + this.a.hashCode();
            int hashCode2 = TextUtils.isEmpty(this.f16857b) ? (hashCode * 7) + 1 : (hashCode * 7) + this.f16857b.hashCode();
            int hashCode3 = ((TextUtils.isEmpty(this.f16858c) ? (hashCode2 * 7) + 1 : (hashCode2 * 7) + this.f16858c.hashCode()) * 7) + ((int) this.f16859d);
            int hashCode4 = TextUtils.isEmpty(this.f16860e) ? (hashCode3 * 7) + 1 : (hashCode3 * 7) + this.f16860e.hashCode();
            int hashCode5 = TextUtils.isEmpty(this.m) ? (hashCode4 * 7) + 1 : (hashCode4 * 7) + this.m.hashCode();
            return ((((TextUtils.isEmpty(this.o) ? (hashCode5 * 7) + 1 : (hashCode5 * 7) + this.o.hashCode()) * 7) + (this.f16861f ? 1 : 0)) * 7) + (this.f16862g ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f16857b : (String) invokeV.objValue;
    }

    @Override // c.a.o0.k0.b.e
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? N().toString() : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f16863h : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f16859d : invokeV.longValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f16861f : invokeV.booleanValue;
    }

    @Override // c.a.o0.k0.b.e
    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (str != null) {
                try {
                    return v(new JSONObject(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f16862g : invokeV.booleanValue;
    }

    public boolean v(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, jSONObject)) == null) {
            String optString = jSONObject.optString("forum_name");
            String optString2 = jSONObject.optString("thread_id");
            String optString3 = jSONObject.optString("thread_name");
            long optLong = jSONObject.optLong("thread_time");
            this.f16860e = jSONObject.optString("post_id");
            this.f16861f = jSONObject.optBoolean("host_only");
            this.f16862g = jSONObject.optBoolean("squence");
            this.i = jSONObject.optBoolean("is_manga");
            this.j = jSONObject.optLong("cartoon_id");
            this.k = jSONObject.optInt(MangaBrowserActivityConfig.CHAPTER_ID);
            this.l = jSONObject.optBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            if (!TextUtils.isEmpty(optString)) {
                this.f16858c = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.a = optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                this.f16857b = optString3;
            }
            if (optLong > 2000) {
                this.f16859d = optLong;
            }
            this.f16863h = jSONObject.optInt("thread_type");
            this.m = jSONObject.optString("live_id", "");
            this.n = jSONObject.optString("user_name", "");
            this.o = jSONObject.optString("live_description", "");
            return true;
        }
        return invokeL.booleanValue;
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.j = j;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.k = i;
        }
    }
}
