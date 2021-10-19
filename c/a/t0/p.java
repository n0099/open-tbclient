package c.a.t0;

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
import com.baidu.ubc.UBC;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p implements c.a.t0.k0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30150a;

    /* renamed from: b  reason: collision with root package name */
    public int f30151b;

    /* renamed from: c  reason: collision with root package name */
    public String f30152c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f30153d;

    /* renamed from: e  reason: collision with root package name */
    public long f30154e;

    /* renamed from: f  reason: collision with root package name */
    public long f30155f;

    /* renamed from: g  reason: collision with root package name */
    public int f30156g;

    /* renamed from: h  reason: collision with root package name */
    public String f30157h;

    /* renamed from: i  reason: collision with root package name */
    public String f30158i;

    /* renamed from: j  reason: collision with root package name */
    public String f30159j;
    public JSONArray k;
    public JSONArray l;
    public boolean m;
    public int n;
    public int o;

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

    public void A(JsonWriter jsonWriter, Object obj) throws IOException {
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jsonWriter, obj) == null) {
            if (obj != null && obj != JSONObject.NULL) {
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    jsonWriter.beginArray();
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        Object opt2 = jSONArray.opt(i2);
                        if (opt2 != null) {
                            A(jsonWriter, opt2);
                        }
                    }
                    jsonWriter.endArray();
                    return;
                } else if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    jsonWriter.beginObject();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (opt = jSONObject.opt(next)) != null) {
                            jsonWriter.name(next);
                            A(jsonWriter, opt);
                        }
                    }
                    jsonWriter.endObject();
                    return;
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                    return;
                } else if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                    return;
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                    return;
                } else {
                    jsonWriter.value(obj.toString());
                    return;
                }
            }
            jsonWriter.nullValue();
        }
    }

    @Override // c.a.t0.k0.a
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f30150a);
            jSONObject.put(LaunchedTaskSpeedStats.KEY_START_TIME, Long.toString(this.f30154e));
            jSONObject.put("endtime", Long.toString(this.f30155f));
            jSONObject.put("type", "1");
            g n = g.n();
            jSONObject.put(Constant.IS_REAL, n.F(this.f30150a) ? "1" : "0");
            int m = n.m(this.f30150a);
            if (m != 0) {
                jSONObject.put("gflow", String.valueOf(m));
            }
            JSONObject jSONObject2 = this.f30153d;
            if (jSONObject2 != null) {
                jSONObject.put("content", jSONObject2.toString());
            } else if (!TextUtils.isEmpty(this.f30152c)) {
                jSONObject.put("content", this.f30152c);
            }
            if (!TextUtils.isEmpty(this.f30158i)) {
                jSONObject.put("abtest", this.f30158i);
            }
            if (!TextUtils.isEmpty(this.f30159j)) {
                jSONObject.put("c", this.f30159j);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject.put(SpeedStatsMainTable.PART, this.k);
            }
            if (this.m) {
                jSONObject.put("of", "1");
            }
            jSONObject.put(Constant.ID_TYPE, n.v(this.f30150a));
            JSONArray jSONArray2 = this.l;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                jSONObject.put("eventlist", this.l);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.a.t0.k0.a
    public void b(JsonWriter jsonWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonWriter) == null) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.f30150a);
            jsonWriter.name(LaunchedTaskSpeedStats.KEY_START_TIME).value(Long.toString(this.f30154e));
            jsonWriter.name("endtime").value(Long.toString(this.f30155f));
            jsonWriter.name("type").value("1");
            jsonWriter.name(Constant.IS_REAL).value(g.n().F(this.f30150a) ? "1" : "0");
            int m = g.n().m(this.f30150a);
            if (m != 0) {
                jsonWriter.name("gflow").value(m);
            }
            if (this.f30153d != null) {
                jsonWriter.name("content").value(this.f30153d.toString());
            } else if (!TextUtils.isEmpty(this.f30152c)) {
                jsonWriter.name("content").value(this.f30152c);
            }
            if (!TextUtils.isEmpty(this.f30158i)) {
                jsonWriter.name("abtest").value(this.f30158i);
            }
            if (!TextUtils.isEmpty(this.f30159j)) {
                jsonWriter.name("c").value(this.f30159j);
            }
            JSONArray jSONArray = this.k;
            if (jSONArray != null && jSONArray.length() > 0) {
                jsonWriter.name(SpeedStatsMainTable.PART);
                A(jsonWriter, this.k);
            }
            if (this.m) {
                jsonWriter.name("of").value("1");
            }
            jsonWriter.name(Constant.ID_TYPE).value(g.n().v(this.f30150a));
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
            jsonWriter.endObject();
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30154e : invokeV.longValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30159j : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30152c : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f() {
        InterceptResult invokeV;
        int length;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.o;
            if (i2 > 0) {
                return i2;
            }
            int length2 = TextUtils.isEmpty(this.f30150a) ? 0 : 0 + this.f30150a.getBytes().length;
            JSONObject jSONObject = this.f30153d;
            if (jSONObject != null) {
                try {
                    length = jSONObject.toString().getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            } else {
                if (!TextUtils.isEmpty(this.f30152c)) {
                    length = this.f30152c.getBytes().length;
                }
                if (!TextUtils.isEmpty(this.f30158i)) {
                    length2 += this.f30158i.getBytes().length;
                }
                jSONArray = this.k;
                if (jSONArray != null && jSONArray.length() > 0) {
                    length2 += this.n;
                }
                this.o = length2;
                return length2;
            }
            length2 += length;
            if (!TextUtils.isEmpty(this.f30158i)) {
            }
            jSONArray = this.k;
            if (jSONArray != null) {
                length2 += this.n;
            }
            this.o = length2;
            return length2;
        }
        return invokeV.intValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30155f : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30158i : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30151b : invokeV.intValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30150a : (String) invokeV.objValue;
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30153d : (JSONObject) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f30156g : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30157h : (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void o(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.f30154e = j2;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f30159j = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f30152c = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.m = z;
        }
    }

    public void s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.f30155f = j2;
        }
    }

    public void t(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jSONArray) == null) {
            this.l = jSONArray;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && g.n().a(this.f30150a)) {
            this.f30158i = UBC.getUBCContext().h();
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f30158i = str;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f30151b = i2;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f30150a = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || TextUtils.isEmpty(str)) {
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

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.f30157h = str;
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
        this.f30150a = str;
        this.f30151b = i2;
        this.f30152c = str2;
        this.f30156g = i3;
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
        this.f30150a = str;
        this.f30151b = i2;
        this.f30153d = jSONObject;
        this.f30156g = i3;
    }
}
