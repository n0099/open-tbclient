package c.a.p0.o1.p;

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
    public String f22732a;

    /* renamed from: b  reason: collision with root package name */
    public String f22733b;

    /* renamed from: c  reason: collision with root package name */
    public String f22734c;

    /* renamed from: d  reason: collision with root package name */
    public int f22735d;

    /* renamed from: e  reason: collision with root package name */
    public String f22736e;

    /* renamed from: f  reason: collision with root package name */
    public String f22737f;

    /* renamed from: g  reason: collision with root package name */
    public String f22738g;

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
            if (TextUtils.isEmpty(this.f22734c)) {
                return false;
            }
            return this.f22735d == 2 ? (TextUtils.isEmpty(this.f22736e) || TextUtils.isEmpty(this.f22737f) || TextUtils.isEmpty(this.f22738g)) ? false : true : (TextUtils.isEmpty(this.f22732a) || TextUtils.isEmpty(this.f22733b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f22732a = jSONObject.optString("pic");
        this.f22733b = jSONObject.optString("picNight");
        this.f22734c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f22735d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f22736e = optJSONObject.optString("title");
        this.f22737f = optJSONObject.optString("content");
        this.f22738g = optJSONObject.optString("imageUrl");
    }
}
