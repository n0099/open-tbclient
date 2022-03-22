package c.a.a0.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public String f1532b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1533c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1534d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1535e;

    public c(@NonNull JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            this.a = jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
            this.f1532b = jSONObject.optString("deferred_cmd");
            this.f1533c = jSONObject.optString("download_url");
            this.f1534d = jSONObject.optString("key");
        } else {
            this.a = jSONObject.optString("apk_name");
            this.f1532b = jSONObject.optString("deferred_cmd");
            this.f1533c = jSONObject.optString("download_url");
            this.f1534d = jSONObject.optString("download_key");
        }
        this.f1535e = a();
    }

    @Nullable
    public static c b(@Nullable JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new c(jSONObject, false);
        }
        return (c) invokeL.objValue;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f1534d) || TextUtils.isEmpty(this.f1533c)) ? false : true : invokeV.booleanValue;
    }
}
