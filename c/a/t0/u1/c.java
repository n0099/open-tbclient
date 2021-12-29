package c.a.t0.u1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25005b;

    /* renamed from: c  reason: collision with root package name */
    public String f25006c;

    /* renamed from: d  reason: collision with root package name */
    public int f25007d;

    /* renamed from: e  reason: collision with root package name */
    public int f25008e;

    /* renamed from: f  reason: collision with root package name */
    public String f25009f;

    /* renamed from: g  reason: collision with root package name */
    public long f25010g;

    /* renamed from: h  reason: collision with root package name */
    public int f25011h;

    /* renamed from: i  reason: collision with root package name */
    public String f25012i;

    /* renamed from: j  reason: collision with root package name */
    public int f25013j;

    /* renamed from: k  reason: collision with root package name */
    public long f25014k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;
    public String t;
    public AgreeData u;
    public JSONArray v;

    public c() {
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
        this.a = null;
        this.f25005b = null;
        this.f25006c = null;
        this.f25007d = 0;
        this.f25008e = 0;
        this.f25009f = null;
        this.f25010g = 0L;
        this.f25011h = 0;
        this.f25012i = "";
        this.f25013j = -1;
        this.f25014k = 0L;
        this.l = null;
        this.t = null;
        this.v = null;
    }

    public AgreeData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.u : (AgreeData) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25006c : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25008e : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25005b : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f25013j : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f25009f : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f25010g : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f25014k : invokeV.longValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f25011h : invokeV.intValue;
    }

    public JSONArray m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v : (JSONArray) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f25012i : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f25007d : invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jSONObject) == null) {
            try {
                this.f25014k = jSONObject.optLong("overall_index", 0L);
                this.l = jSONObject.optString("post_id");
                this.q = jSONObject.optString("user_id");
                this.r = jSONObject.optString("user_name");
                this.s = jSONObject.optString("nickname");
                boolean z = true;
                this.n = jSONObject.optInt("show_original_btn") == 1;
                this.o = jSONObject.optInt("is_blocked_pic") == 1;
                this.p = jSONObject.optInt("is_long_pic") == 1;
                this.f25013j = jSONObject.optInt("index", -1);
                this.m = jSONObject.optInt("is_first_post") == 1;
                this.t = jSONObject.optString("comment_num");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("agree");
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("agree_num");
                    optJSONObject2.optInt("disagree_num");
                    int optInt2 = optJSONObject2.optInt("agree_type");
                    if (optJSONObject2.optInt("has_agree") != 1) {
                        z = false;
                    }
                    if (this.u == null) {
                        this.u = new AgreeData();
                    }
                    this.u.agreeType = optInt2;
                    this.u.hasAgree = z;
                    this.u.agreeNum = optInt;
                }
                this.v = jSONObject.optJSONArray(TiebaStatic.Params.POST_CONTENT);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("img");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("original")) != null) {
                    this.a = optJSONObject.optString("id");
                    this.f25005b = optJSONObject.optString("url");
                    this.f25007d = optJSONObject.optInt("width", 0);
                    this.f25008e = optJSONObject.optInt("height", 0);
                    this.f25006c = optJSONObject.optString("big_cdn_src", null);
                    this.f25009f = optJSONObject.optString("original_src");
                    this.f25010g = optJSONObject.optInt("size");
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("pic_tagname");
                if (optJSONObject4 != null) {
                    this.f25011h = optJSONObject4.optInt("pic_type", 0);
                    this.f25012i = optJSONObject4.optString("tag_name");
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }
}
