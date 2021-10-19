package c.a.t0;

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
import com.baidu.ubc.UBC;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n implements c.a.t0.k0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30137a;

    /* renamed from: b  reason: collision with root package name */
    public String f30138b;

    /* renamed from: c  reason: collision with root package name */
    public int f30139c;

    /* renamed from: d  reason: collision with root package name */
    public String f30140d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f30141e;

    /* renamed from: f  reason: collision with root package name */
    public long f30142f;

    /* renamed from: g  reason: collision with root package name */
    public int f30143g;

    /* renamed from: h  reason: collision with root package name */
    public String f30144h;

    /* renamed from: i  reason: collision with root package name */
    public String f30145i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f30146j;
    public String k;
    public String l;

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
        this.f30140d = "";
        this.f30146j = false;
        this.k = "";
        this.l = "0";
        this.f30137a = str;
        this.f30138b = str;
        this.f30139c = -1;
        this.f30143g = 0;
    }

    @Override // c.a.t0.k0.a
    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f30137a);
            jSONObject.put("timestamp", Long.toString(this.f30142f));
            jSONObject.put("type", "0");
            JSONObject jSONObject2 = this.f30141e;
            if (jSONObject2 != null) {
                jSONObject.put("content", jSONObject2.toString());
            } else if (!TextUtils.isEmpty(this.f30140d)) {
                jSONObject.put("content", this.f30140d);
            }
            if (!TextUtils.isEmpty(this.f30144h)) {
                jSONObject.put("abtest", this.f30144h);
            }
            if (!TextUtils.isEmpty(this.f30145i)) {
                jSONObject.put("c", this.f30145i);
            }
            if (this.f30146j) {
                jSONObject.put("of", "1");
            }
            g n = g.n();
            jSONObject.put(Constant.ID_TYPE, n.v(this.f30137a));
            jSONObject.put(Constant.IS_REAL, n.F(this.f30137a) ? "1" : "0");
            int m = n.m(this.f30137a);
            if (m != 0) {
                jSONObject.put("gflow", String.valueOf(m));
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.a.t0.k0.a
    public void b(JsonWriter jsonWriter) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonWriter) == null) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(this.f30137a);
            jsonWriter.name("timestamp").value(Long.toString(this.f30142f));
            jsonWriter.name("type").value("0");
            if (this.f30141e != null) {
                jsonWriter.name("content").value(this.f30141e.toString());
            } else if (!TextUtils.isEmpty(this.f30140d)) {
                jsonWriter.name("content").value(this.f30140d);
            }
            if (!TextUtils.isEmpty(this.f30144h)) {
                jsonWriter.name("abtest").value(this.f30144h);
            }
            if (!TextUtils.isEmpty(this.f30145i)) {
                jsonWriter.name("c").value(this.f30145i);
            }
            if (this.f30146j) {
                jsonWriter.name("of").value("1");
            }
            jsonWriter.name(Constant.ID_TYPE).value(g.n().v(this.f30137a));
            jsonWriter.name(Constant.IS_REAL).value(g.n().F(this.f30137a) ? "1" : "0");
            int m = g.n().m(this.f30137a);
            if (m != 0) {
                jsonWriter.name("gflow").value(String.valueOf(m));
            }
            jsonWriter.endObject();
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30145i : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30140d : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e() {
        InterceptResult invokeV;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return invokeV.intValue;
        }
        int length2 = TextUtils.isEmpty(this.f30137a) ? 0 : 0 + this.f30137a.getBytes().length;
        JSONObject jSONObject = this.f30141e;
        if (jSONObject != null) {
            try {
                length = jSONObject.toString().getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        } else {
            if (!TextUtils.isEmpty(this.f30140d)) {
                length = this.f30140d.getBytes().length;
            }
            return TextUtils.isEmpty(this.f30144h) ? length2 + this.f30144h.getBytes().length : length2;
        }
        length2 += length;
        if (TextUtils.isEmpty(this.f30144h)) {
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30144h : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30139c : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30138b : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30137a : (String) invokeV.objValue;
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30141e : (JSONObject) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30143g : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30142f : invokeV.longValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f30146j : invokeV.booleanValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f30145i = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f30140d = str;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f30146j = z;
        }
    }

    public void s() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (str = this.f30137a) != null && str.equals(this.f30138b) && g.n().a(this.f30137a)) {
            this.f30144h = UBC.getUBCContext().h();
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f30144h = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.k = str;
        }
    }

    public void v(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f30141e = jSONObject;
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f30143g = i2;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
        }
    }

    public void y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.f30142f = j2;
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
        this.f30140d = "";
        this.f30146j = false;
        this.k = "";
        this.l = "0";
        this.f30137a = str;
        this.f30138b = str;
        this.f30139c = -1;
        this.f30140d = str2;
        this.f30143g = i2;
        if ((i2 & 2) == 0) {
            this.f30142f = System.currentTimeMillis();
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
        this.f30140d = "";
        this.f30146j = false;
        this.k = "";
        this.l = "0";
        this.f30137a = str;
        this.f30138b = str;
        this.f30139c = -1;
        this.f30141e = jSONObject;
        this.f30143g = i2;
        if ((i2 & 2) == 0) {
            this.f30142f = System.currentTimeMillis();
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
        this.f30140d = "";
        this.f30146j = false;
        this.k = "";
        this.l = "0";
        this.f30137a = str2;
        this.f30138b = str;
        this.f30139c = i2;
        this.f30140d = str3;
        this.f30143g = i3;
        if ((i3 & 2) == 0) {
            this.f30142f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f30140d = "";
        this.f30146j = false;
        this.k = "";
        this.l = "0";
        this.f30137a = str2;
        this.f30138b = str;
        this.f30139c = i2;
        this.f30140d = str3;
        this.f30143g = i3;
        if ((i3 & 2) == 0) {
            if (j2 > 0) {
                this.f30142f = j2;
            } else {
                this.f30142f = System.currentTimeMillis();
            }
        }
    }
}
