package c.a.o0.a.u.e.o;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull c.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.o0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.o0.a.u.c.d.f8699c;
            if (l()) {
                c.a.o0.a.e0.d.b("Api-PhoneCallApi", "Api-PhoneCallApi does not supported when app is invisible.");
                return new c.a.o0.a.u.h.b(1001, "Api-PhoneCallApi does not supported when app is invisible.");
            }
            Intent intent = new Intent("android.intent.action.DIAL");
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-PhoneCallApi", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.o0.a.e0.d.b("Api-PhoneCallApi", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject != null) {
                String optString = jSONObject.optString("phoneNumber");
                if (!TextUtils.isEmpty(optString)) {
                    intent.setData(Uri.fromParts("tel", optString, null));
                }
            }
            if (c.a.o0.a.v2.f.g(i(), intent)) {
                return new c.a.o0.a.u.h.b(0);
            }
            return new c.a.o0.a.u.h.b(1001);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }
}
