package c.a.v0;

import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class p implements c.a.v0.p0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f26532b;

    /* renamed from: c  reason: collision with root package name */
    public String f26533c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f26534d;

    /* renamed from: e  reason: collision with root package name */
    public long f26535e;

    /* renamed from: f  reason: collision with root package name */
    public long f26536f;

    /* renamed from: g  reason: collision with root package name */
    public int f26537g;

    /* renamed from: h  reason: collision with root package name */
    public String f26538h;

    /* renamed from: i  reason: collision with root package name */
    public String f26539i;

    /* renamed from: j  reason: collision with root package name */
    public String f26540j;
    public JSONArray k;
    public JSONArray l;
    public boolean m;
    public int n;
    public int o;
    public String p;

    public p() {
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
        this.l = null;
        this.m = false;
        this.n = 0;
        this.o = 0;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.k = new JSONArray(str);
            this.n = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f26538h = str;
        }
    }

    @Override // c.a.v0.p0.a
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        JSONObject e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put(LaunchedTaskSpeedStats.KEY_START_TIME, Long.toString(this.f26535e));
            jSONObject.put("endtime", Long.toString(this.f26536f));
            jSONObject.put("type", "1");
            g o = g.o();
            jSONObject.put(Constant.IS_REAL, o.O(this.a) ? "1" : "0");
            int n = o.n(this.a);
            if (n != 0) {
                jSONObject.put("gflow", String.valueOf(n));
            }
            JSONObject jSONObject2 = this.f26534d;
            if (jSONObject2 != null) {
                jSONObject.put("content", jSONObject2.toString());
            } else if (!TextUtils.isEmpty(this.f26533c)) {
                jSONObject.put("content", this.f26533c);
            }
            if (!TextUtils.isEmpty(this.f26539i)) {
                jSONObject.put("abtest", this.f26539i);
            }
            if (!TextUtils.isEmpty(this.f26540j)) {
                jSONObject.put("c", this.f26540j);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject.put(SpeedStatsMainTable.PART, this.k);
            }
            if (this.m) {
                jSONObject.put("of", "1");
            }
            jSONObject.put(Constant.ID_TYPE, o.z(this.a));
            JSONArray jSONArray2 = this.l;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jSONObject.put("eventlist", this.l);
            }
            if (!TextUtils.isEmpty(this.p) && (e2 = e()) != null) {
                jSONObject.put("bizInfo", e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.a.v0.p0.a
    public void b(JsonWriter jsonWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsonWriter) == null) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.a);
            jsonWriter.name(LaunchedTaskSpeedStats.KEY_START_TIME).value(Long.toString(this.f26535e));
            jsonWriter.name("endtime").value(Long.toString(this.f26536f));
            jsonWriter.name("type").value("1");
            jsonWriter.name(Constant.IS_REAL).value(g.o().O(this.a) ? "1" : "0");
            int n = g.o().n(this.a);
            if (n != 0) {
                jsonWriter.name("gflow").value(n);
            }
            if (this.f26534d != null) {
                jsonWriter.name("content").value(this.f26534d.toString());
            } else if (!TextUtils.isEmpty(this.f26533c)) {
                jsonWriter.name("content").value(this.f26533c);
            }
            if (!TextUtils.isEmpty(this.f26539i)) {
                jsonWriter.name("abtest").value(this.f26539i);
            }
            if (!TextUtils.isEmpty(this.f26540j)) {
                jsonWriter.name("c").value(this.f26540j);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() > 0) {
                jsonWriter.name(SpeedStatsMainTable.PART);
                c.a.v0.q0.d.a(jsonWriter, this.k);
            }
            if (this.m) {
                jsonWriter.name("of").value("1");
            }
            jsonWriter.name(Constant.ID_TYPE).value(g.o().z(this.a));
            JSONArray jSONArray2 = this.l;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jsonWriter.name("eventlist");
                jsonWriter.beginArray();
                int length = this.l.length();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        JSONObject jSONObject = (JSONObject) this.l.get(i2);
                        if (jSONObject != null) {
                            jsonWriter.beginObject();
                            if (jSONObject.has("id")) {
                                String optString = jSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    jsonWriter.name("id").value(optString);
                                }
                            }
                            if (jSONObject.has("timestamp")) {
                                jsonWriter.name("timestamp").value(Long.toString(jSONObject.optLong("timestamp")));
                            }
                            if (jSONObject.has("content")) {
                                String optString2 = jSONObject.optString("content");
                                if (!TextUtils.isEmpty(optString2)) {
                                    jsonWriter.name("content").value(optString2);
                                }
                            }
                            jsonWriter.endObject();
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                jsonWriter.endArray();
            }
            if (!TextUtils.isEmpty(this.p) && e() != null) {
                jsonWriter.name("bizInfo");
                c.a.v0.q0.d.a(jsonWriter, e());
            }
            jsonWriter.endObject();
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26535e : invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (TextUtils.isEmpty(this.p)) {
                return null;
            }
            try {
                return new JSONObject(this.p);
            } catch (JSONException e2) {
                if (b0.m()) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26540j : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26533c : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h() {
        InterceptResult invokeV;
        int length;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.o;
            if (i2 > 0) {
                return i2;
            }
            int length2 = TextUtils.isEmpty(this.a) ? 0 : 0 + this.a.getBytes().length;
            JSONObject jSONObject = this.f26534d;
            if (jSONObject != null) {
                try {
                    length = jSONObject.toString().getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else {
                if (!TextUtils.isEmpty(this.f26533c)) {
                    length = this.f26533c.getBytes().length;
                }
                if (!TextUtils.isEmpty(this.f26539i)) {
                    length2 += this.f26539i.getBytes().length;
                }
                jSONArray = this.k;
                if (jSONArray != null && jSONArray.length() > 0) {
                    length2 += this.n;
                }
                if (!TextUtils.isEmpty(this.p)) {
                    length2 += this.p.getBytes().length;
                }
                this.o = length2;
                return length2;
            }
            length2 += length;
            if (!TextUtils.isEmpty(this.f26539i)) {
            }
            jSONArray = this.k;
            if (jSONArray != null) {
                length2 += this.n;
            }
            if (!TextUtils.isEmpty(this.p)) {
            }
            this.o = length2;
            return length2;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f26536f : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f26539i : (String) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f26532b : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f26534d : (JSONObject) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f26537g : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f26538h : (String) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.f26535e = j2;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.p = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f26540j = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f26533c = str;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.m = z;
        }
    }

    public void v(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.f26536f = j2;
        }
    }

    public void w(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jSONArray) == null) {
            this.l = jSONArray;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && g.o().a(this.a)) {
            this.f26539i = b0.i().h();
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f26539i = str;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f26532b = i2;
        }
    }

    public p(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = false;
        this.n = 0;
        this.o = 0;
        this.a = str;
        this.f26532b = i2;
        this.f26533c = str2;
        this.f26537g = i3;
    }

    public p(String str, int i2, JSONObject jSONObject, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), jSONObject, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = false;
        this.n = 0;
        this.o = 0;
        this.a = str;
        this.f26532b = i2;
        this.f26534d = jSONObject;
        this.f26537g = i3;
    }
}
