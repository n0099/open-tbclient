package b.a.r0.n1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22781a;

    /* renamed from: b  reason: collision with root package name */
    public String f22782b;

    /* renamed from: c  reason: collision with root package name */
    public String f22783c;

    /* renamed from: d  reason: collision with root package name */
    public int f22784d;

    /* renamed from: e  reason: collision with root package name */
    public int f22785e;

    /* renamed from: f  reason: collision with root package name */
    public String f22786f;

    /* renamed from: g  reason: collision with root package name */
    public long f22787g;

    /* renamed from: h  reason: collision with root package name */
    public int f22788h;

    /* renamed from: i  reason: collision with root package name */
    public String f22789i;
    public int j;
    public long k;
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
        this.f22781a = null;
        this.f22782b = null;
        this.f22783c = null;
        this.f22784d = 0;
        this.f22785e = 0;
        this.f22786f = null;
        this.f22787g = 0L;
        this.f22788h = 0;
        this.f22789i = "";
        this.j = -1;
        this.k = 0L;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22783c : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22785e : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22781a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22782b : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f22786f : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22787g : invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.longValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f22788h : invokeV.intValue;
    }

    public JSONArray m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v : (JSONArray) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f22789i : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f22784d : invokeV.intValue;
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
                this.k = jSONObject.optLong("overall_index", 0L);
                this.l = jSONObject.optString("post_id");
                this.q = jSONObject.optString("user_id");
                this.r = jSONObject.optString("user_name");
                this.s = jSONObject.optString("nickname");
                boolean z = true;
                this.n = jSONObject.optInt("show_original_btn") == 1;
                this.o = jSONObject.optInt("is_blocked_pic") == 1;
                this.p = jSONObject.optInt("is_long_pic") == 1;
                this.j = jSONObject.optInt("index", -1);
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
                this.v = jSONObject.optJSONArray("post_content");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("img");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("original")) != null) {
                    this.f22781a = optJSONObject.optString("id");
                    this.f22782b = optJSONObject.optString("url");
                    this.f22784d = optJSONObject.optInt("width", 0);
                    this.f22785e = optJSONObject.optInt("height", 0);
                    this.f22783c = optJSONObject.optString("big_cdn_src", null);
                    this.f22786f = optJSONObject.optString("original_src");
                    this.f22787g = optJSONObject.optInt("size");
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("pic_tagname");
                if (optJSONObject4 != null) {
                    this.f22788h = optJSONObject4.optInt("pic_type", 0);
                    this.f22789i = optJSONObject4.optString("tag_name");
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }
}
