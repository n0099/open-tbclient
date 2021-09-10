package c.a.x0.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f30857a;

    /* renamed from: b  reason: collision with root package name */
    public String f30858b;

    /* renamed from: c  reason: collision with root package name */
    public String f30859c;

    /* renamed from: d  reason: collision with root package name */
    public String f30860d;

    /* renamed from: e  reason: collision with root package name */
    public int f30861e;

    /* renamed from: f  reason: collision with root package name */
    public String f30862f;

    /* renamed from: g  reason: collision with root package name */
    public int f30863g;

    /* renamed from: h  reason: collision with root package name */
    public String f30864h;

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
        this.f30857a = "";
        this.f30858b = "";
        this.f30859c = "";
        this.f30860d = "";
        this.f30862f = "";
        this.f30863g = 0;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30860d : (String) invokeV.objValue;
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
                this.f30857a = jSONObject.optString("name");
                this.f30858b = jSONObject.optString("id");
                this.f30859c = jSONObject.optString("image");
                this.f30860d = jSONObject.optString("url");
                this.f30861e = jSONObject.optInt("progress");
                this.f30862f = jSONObject.optString("downloadPerSize");
                this.f30863g = jSONObject.optInt("status");
                this.f30864h = jSONObject.optString("savePath");
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
            this.f30862f = str;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f30861e = i2;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f30864h = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f30863g = i2;
        }
    }

    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f30857a);
                jSONObject.put("id", this.f30858b);
                jSONObject.put("image", this.f30859c);
                jSONObject.put("url", this.f30860d);
                jSONObject.put("progress", this.f30861e);
                jSONObject.put("downloadPerSize", this.f30862f);
                jSONObject.put("status", this.f30863g);
                jSONObject.put("savePath", this.f30864h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
