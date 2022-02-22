package c.a.u0.z1.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25813b;

    /* renamed from: c  reason: collision with root package name */
    public String f25814c;

    /* renamed from: d  reason: collision with root package name */
    public int f25815d;

    /* renamed from: e  reason: collision with root package name */
    public String f25816e;

    /* renamed from: f  reason: collision with root package name */
    public String f25817f;

    /* renamed from: g  reason: collision with root package name */
    public String f25818g;

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
            if (TextUtils.isEmpty(this.f25814c)) {
                return false;
            }
            return this.f25815d == 2 ? (TextUtils.isEmpty(this.f25816e) || TextUtils.isEmpty(this.f25817f) || TextUtils.isEmpty(this.f25818g)) ? false : true : (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f25813b)) ? false : true;
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
        this.f25813b = jSONObject.optString("picNight");
        this.f25814c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f25815d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f25816e = optJSONObject.optString("title");
        this.f25817f = optJSONObject.optString("content");
        this.f25818g = optJSONObject.optString("imageUrl");
    }
}
