package b.a.t0;

import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n implements b.a.t0.p0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29715a;

    /* renamed from: b  reason: collision with root package name */
    public String f29716b;

    /* renamed from: c  reason: collision with root package name */
    public int f29717c;

    /* renamed from: d  reason: collision with root package name */
    public String f29718d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f29719e;

    /* renamed from: f  reason: collision with root package name */
    public long f29720f;

    /* renamed from: g  reason: collision with root package name */
    public int f29721g;

    /* renamed from: h  reason: collision with root package name */
    public String f29722h;

    /* renamed from: i  reason: collision with root package name */
    public String f29723i;
    public boolean j;
    public String k;
    public String l;
    public String m;

    public n(String str) {
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
        this.f29718d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f29715a = str;
        this.f29716b = str;
        this.f29717c = -1;
        this.f29721g = 0;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.l = str;
        }
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f29720f = j;
        }
    }

    @Override // b.a.t0.p0.a
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        JSONObject d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f29715a);
            jSONObject.put("timestamp", Long.toString(this.f29720f));
            jSONObject.put("type", "0");
            JSONObject jSONObject2 = this.f29719e;
            if (jSONObject2 != null) {
                jSONObject.put("content", jSONObject2.toString());
            } else if (!TextUtils.isEmpty(this.f29718d)) {
                jSONObject.put("content", this.f29718d);
            }
            if (!TextUtils.isEmpty(this.f29722h)) {
                jSONObject.put("abtest", this.f29722h);
            }
            if (!TextUtils.isEmpty(this.f29723i)) {
                jSONObject.put("c", this.f29723i);
            }
            if (this.j) {
                jSONObject.put("of", "1");
            }
            g o = g.o();
            jSONObject.put(Constant.ID_TYPE, o.z(this.f29715a));
            jSONObject.put(Constant.IS_REAL, o.O(this.f29715a) ? "1" : "0");
            int n = o.n(this.f29715a);
            if (n != 0) {
                jSONObject.put("gflow", String.valueOf(n));
            }
            if (!TextUtils.isEmpty(this.m) && (d2 = d()) != null) {
                jSONObject.put("bizInfo", d2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // b.a.t0.p0.a
    public void b(JsonWriter jsonWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsonWriter) == null) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.f29715a);
            jsonWriter.name("timestamp").value(Long.toString(this.f29720f));
            jsonWriter.name("type").value("0");
            if (this.f29719e != null) {
                jsonWriter.name("content").value(this.f29719e.toString());
            } else if (!TextUtils.isEmpty(this.f29718d)) {
                jsonWriter.name("content").value(this.f29718d);
            }
            if (!TextUtils.isEmpty(this.f29722h)) {
                jsonWriter.name("abtest").value(this.f29722h);
            }
            if (!TextUtils.isEmpty(this.f29723i)) {
                jsonWriter.name("c").value(this.f29723i);
            }
            if (this.j) {
                jsonWriter.name("of").value("1");
            }
            jsonWriter.name(Constant.ID_TYPE).value(g.o().z(this.f29715a));
            jsonWriter.name(Constant.IS_REAL).value(g.o().O(this.f29715a) ? "1" : "0");
            int n = g.o().n(this.f29715a);
            if (n != 0) {
                jsonWriter.name("gflow").value(String.valueOf(n));
            }
            if (!TextUtils.isEmpty(this.m) && d() != null) {
                jsonWriter.name("bizInfo");
                b.a.t0.q0.d.a(jsonWriter, d());
            }
            jsonWriter.endObject();
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.m)) {
                return null;
            }
            try {
                return new JSONObject(this.m);
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

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29723i : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29718d : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return invokeV.intValue;
        }
        int length2 = TextUtils.isEmpty(this.f29715a) ? 0 : 0 + this.f29715a.getBytes().length;
        JSONObject jSONObject = this.f29719e;
        if (jSONObject != null) {
            try {
                length = jSONObject.toString().getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        } else {
            if (!TextUtils.isEmpty(this.f29718d)) {
                length = this.f29718d.getBytes().length;
            }
            if (!TextUtils.isEmpty(this.f29722h)) {
                length2 += this.f29722h.getBytes().length;
            }
            return TextUtils.isEmpty(this.m) ? length2 + this.m.getBytes().length : length2;
        }
        length2 += length;
        if (!TextUtils.isEmpty(this.f29722h)) {
        }
        if (TextUtils.isEmpty(this.m)) {
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29722h : (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29717c : invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f29716b : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f29715a : (String) invokeV.objValue;
    }

    public JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f29719e : (JSONObject) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f29721g : invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f29720f : invokeV.longValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.m = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f29723i = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f29718d = str;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.j = z;
        }
    }

    public void v() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (str = this.f29715a) != null && str.equals(this.f29716b) && g.o().a(this.f29715a)) {
            this.f29722h = b0.i().h();
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.f29722h = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.k = str;
        }
    }

    public void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f29719e = jSONObject;
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f29721g = i2;
        }
    }

    public n(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29718d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f29715a = str;
        this.f29716b = str;
        this.f29717c = -1;
        this.f29718d = str2;
        this.f29721g = i2;
        if ((i2 & 2) == 0) {
            this.f29720f = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f29718d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f29715a = str;
        this.f29716b = str;
        this.f29717c = -1;
        this.f29719e = jSONObject;
        this.f29721g = i2;
        if ((i2 & 2) == 0) {
            this.f29720f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f29718d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f29715a = str2;
        this.f29716b = str;
        this.f29717c = i2;
        this.f29718d = str3;
        this.f29721g = i3;
        if ((i3 & 2) == 0) {
            this.f29720f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i2, String str3, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f29718d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f29715a = str2;
        this.f29716b = str;
        this.f29717c = i2;
        this.f29718d = str3;
        this.f29721g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f29720f = j;
            } else {
                this.f29720f = System.currentTimeMillis();
            }
        }
    }
}
