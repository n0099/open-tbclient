package c.a.p0.a.d2.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public long C;
    public long D;
    public int v;
    public String w;
    public String x;
    public int y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889437086, "Lc/a/p0/a/d2/s/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1889437086, "Lc/a/p0/a/d2/s/c;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    public c(String str, int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.w = str;
        this.y = i2;
        this.C = j2;
        this.D = j3;
        this.B = "0";
    }

    @Override // c.a.p0.a.d2.s.f, c.a.p0.a.d2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f4953h == null) {
                this.f4953h = new JSONObject();
            }
            try {
                if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                    this.f4953h.put("errorno", this.v);
                }
                String b2 = m.b(this.w);
                this.w = b2;
                this.f4953h.put("url", b2);
                this.f4953h.put("netStatus", this.y);
                if (!TextUtils.isEmpty(this.x)) {
                    this.f4953h.put("msg", this.x);
                }
                if (!TextUtils.isEmpty(this.z)) {
                    this.f4953h.put("pagetype", this.z);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    this.f4953h.put("curpage", this.A);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    this.f4953h.put("requesttype", this.B);
                }
                if (this.D - this.C > 0) {
                    this.f4953h.put(FetchLog.START_TIME, this.C);
                    this.f4953h.put(FetchLog.END_TIME, this.D);
                }
                ExtensionCore T = c.a.p0.a.x.u.g.U().T();
                if (T != null) {
                    this.f4953h.put("extension_ver", T.extensionCoreVersionName);
                }
            } catch (JSONException e2) {
                c.a.p0.a.u.d.e("SwanAppRequestEvent", "834", "#toJSONObject error", e2, false);
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.C : invokeV.longValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = this.f4953h;
            return jSONObject != null && TextUtils.equals(jSONObject.optString("requesttype"), "0");
        }
        return invokeV.booleanValue;
    }

    public void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            try {
                if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                    jSONObject.put("errorno", this.v);
                }
                jSONObject.put("url", m.b(this.w));
                jSONObject.put("netStatus", this.y);
                if (!TextUtils.isEmpty(this.x)) {
                    jSONObject.put("msg", this.x);
                }
                if (!TextUtils.isEmpty(this.B)) {
                    jSONObject.put("requesttype", this.B);
                }
                if (this.D - this.C > 0) {
                    jSONObject.put(FetchLog.START_TIME, this.C);
                    jSONObject.put(FetchLog.END_TIME, this.D);
                }
            } catch (JSONException e2) {
                c.a.p0.a.u.d.e("SwanAppRequestEvent", "834", "#mergeRequestInfo error", e2, false);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.A = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.z = str;
        }
    }

    public c(int i2, String str, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.v = i2;
        this.w = str;
        this.x = str2;
        this.y = i3;
        this.B = "1";
    }

    public c(int i2, String str, String str2, int i3, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v = i2;
        this.w = str;
        this.x = str2;
        this.y = i3;
        this.C = j2;
        this.D = j3;
        if (i2 == 200 && j3 - j2 >= 5000) {
            this.B = "2";
        } else {
            this.B = "1";
        }
    }
}
