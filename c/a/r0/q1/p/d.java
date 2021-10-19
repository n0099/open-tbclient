package c.a.r0.q1.p;

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

    /* renamed from: a  reason: collision with root package name */
    public String f23845a;

    /* renamed from: b  reason: collision with root package name */
    public String f23846b;

    /* renamed from: c  reason: collision with root package name */
    public String f23847c;

    /* renamed from: d  reason: collision with root package name */
    public int f23848d;

    /* renamed from: e  reason: collision with root package name */
    public String f23849e;

    /* renamed from: f  reason: collision with root package name */
    public String f23850f;

    /* renamed from: g  reason: collision with root package name */
    public String f23851g;

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
            if (TextUtils.isEmpty(this.f23847c)) {
                return false;
            }
            return this.f23848d == 2 ? (TextUtils.isEmpty(this.f23849e) || TextUtils.isEmpty(this.f23850f) || TextUtils.isEmpty(this.f23851g)) ? false : true : (TextUtils.isEmpty(this.f23845a) || TextUtils.isEmpty(this.f23846b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f23845a = jSONObject.optString("pic");
        this.f23846b = jSONObject.optString("picNight");
        this.f23847c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f23848d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f23849e = optJSONObject.optString("title");
        this.f23850f = optJSONObject.optString("content");
        this.f23851g = optJSONObject.optString("imageUrl");
    }
}
