package c.a.p0.b2.p;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f12564b;

    /* renamed from: c  reason: collision with root package name */
    public String f12565c;

    /* renamed from: d  reason: collision with root package name */
    public int f12566d;

    /* renamed from: e  reason: collision with root package name */
    public String f12567e;

    /* renamed from: f  reason: collision with root package name */
    public String f12568f;

    /* renamed from: g  reason: collision with root package name */
    public String f12569g;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f12565c)) {
                return false;
            }
            return this.f12566d == 2 ? (TextUtils.isEmpty(this.f12567e) || TextUtils.isEmpty(this.f12568f) || TextUtils.isEmpty(this.f12569g)) ? false : true : (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f12564b)) ? false : true;
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
        this.f12564b = jSONObject.optString("picNight");
        this.f12565c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f12566d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f12567e = optJSONObject.optString("title");
        this.f12568f = optJSONObject.optString("content");
        this.f12569g = optJSONObject.optString("imageUrl");
    }
}
