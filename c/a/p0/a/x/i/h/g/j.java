package c.a.p0.a.x.i.h.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends a<JSONObject, c.a.p0.a.k.h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.x.i.h.g.e
    @NonNull
    /* renamed from: c */
    public c.a.p0.a.k.h.b a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (b()) {
                if (a.a) {
                    c.a.p0.a.u.d.b("Api-HandleException", "has triggered fmp before remove skeleton");
                }
                return new c.a.p0.a.k.h.b(0);
            } else if (jSONObject == null) {
                return new c.a.p0.a.k.h.b(202);
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    return new c.a.p0.a.k.h.b(202, "data is required");
                }
                String optString = optJSONObject.optString("path");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.k.h.b(202, "path is required");
                }
                c.a.p0.a.x.i.h.e eVar = new c.a.p0.a.x.i.h.e();
                eVar.g(optString);
                eVar.e();
                return new c.a.p0.a.k.h.b(0);
            }
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }
}
