package b.a.x0.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30498a;

    /* renamed from: b  reason: collision with root package name */
    public String f30499b;

    /* renamed from: c  reason: collision with root package name */
    public String f30500c;

    /* renamed from: d  reason: collision with root package name */
    public String f30501d;

    /* renamed from: e  reason: collision with root package name */
    public int f30502e;

    /* renamed from: f  reason: collision with root package name */
    public String f30503f;

    /* renamed from: g  reason: collision with root package name */
    public int f30504g;

    /* renamed from: h  reason: collision with root package name */
    public String f30505h;

    public d() {
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
        this.f30498a = "";
        this.f30499b = "";
        this.f30500c = "";
        this.f30501d = "";
        this.f30503f = "";
        this.f30504g = 0;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30501d : (String) invokeV.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f30498a = jSONObject.optString("name");
                this.f30499b = jSONObject.optString("id");
                this.f30500c = jSONObject.optString("image");
                this.f30501d = jSONObject.optString("url");
                this.f30502e = jSONObject.optInt("progress");
                this.f30503f = jSONObject.optString("downloadPerSize");
                this.f30504g = jSONObject.optInt("status");
                this.f30505h = jSONObject.optString("savePath");
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f30503f = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f30502e = i2;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f30505h = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f30504g = i2;
        }
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f30498a);
                jSONObject.put("id", this.f30499b);
                jSONObject.put("image", this.f30500c);
                jSONObject.put("url", this.f30501d);
                jSONObject.put("progress", this.f30502e);
                jSONObject.put("downloadPerSize", this.f30503f);
                jSONObject.put("status", this.f30504g);
                jSONObject.put("savePath", this.f30505h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
