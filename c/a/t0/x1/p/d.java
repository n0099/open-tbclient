package c.a.t0.x1.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f25246b;

    /* renamed from: c  reason: collision with root package name */
    public String f25247c;

    /* renamed from: d  reason: collision with root package name */
    public int f25248d;

    /* renamed from: e  reason: collision with root package name */
    public String f25249e;

    /* renamed from: f  reason: collision with root package name */
    public String f25250f;

    /* renamed from: g  reason: collision with root package name */
    public String f25251g;

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
            if (TextUtils.isEmpty(this.f25247c)) {
                return false;
            }
            return this.f25248d == 2 ? (TextUtils.isEmpty(this.f25249e) || TextUtils.isEmpty(this.f25250f) || TextUtils.isEmpty(this.f25251g)) ? false : true : (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f25246b)) ? false : true;
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
        this.f25246b = jSONObject.optString("picNight");
        this.f25247c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f25248d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f25249e = optJSONObject.optString("title");
        this.f25250f = optJSONObject.optString("content");
        this.f25251g = optJSONObject.optString("imageUrl");
    }
}
