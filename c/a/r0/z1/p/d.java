package c.a.r0.z1.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25475b;

    /* renamed from: c  reason: collision with root package name */
    public String f25476c;

    /* renamed from: d  reason: collision with root package name */
    public int f25477d;

    /* renamed from: e  reason: collision with root package name */
    public String f25478e;

    /* renamed from: f  reason: collision with root package name */
    public String f25479f;

    /* renamed from: g  reason: collision with root package name */
    public String f25480g;

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
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f25476c)) {
                return false;
            }
            return this.f25477d == 2 ? (TextUtils.isEmpty(this.f25478e) || TextUtils.isEmpty(this.f25479f) || TextUtils.isEmpty(this.f25480g)) ? false : true : (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f25475b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("pic");
        this.f25475b = jSONObject.optString("picNight");
        this.f25476c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f25477d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f25478e = optJSONObject.optString("title");
        this.f25479f = optJSONObject.optString("content");
        this.f25480g = optJSONObject.optString("imageUrl");
    }
}
