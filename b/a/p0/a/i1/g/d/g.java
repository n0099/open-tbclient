package b.a.p0.a.i1.g.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6202a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1736236728, "Lb/a/p0/a/i1/g/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1736236728, "Lb/a/p0/a/i1/g/d/g;");
                return;
            }
        }
        f6202a = b.a.p0.a.k.f6397a;
    }

    public g(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public abstract boolean a(b.a.p0.a.i1.g.a aVar, b.a.p0.a.i1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar);

    @Nullable
    public b.a.p0.a.i1.g.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        b.a.p0.a.i1.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3, jSONObject)) == null) {
            if (TextUtils.isEmpty(str3) || (f2 = b.a.p0.a.i1.b.f(str, str2, str3)) == null || !(f2.i() instanceof b.a.p0.a.i1.g.a)) {
                return null;
            }
            return (b.a.p0.a.i1.g.a) f2.i();
        }
        return (b.a.p0.a.i1.g.a) invokeLLLLL.objValue;
    }

    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (f6202a) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                b.a.p0.a.e0.d.b("video", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            b.a.p0.a.i1.g.a b2 = b(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
            if (b2 != null && context != null) {
                b.a.p0.a.i1.g.c i2 = b.a.p0.a.i1.g.c.i(optParamsAsJo, b2.g());
                if (!i2.isValid()) {
                    b.a.p0.a.e0.d.b("video", "param is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                return a(b2, i2, context, unitedSchemeEntity, callbackHandler, eVar);
            }
            b.a.p0.a.e0.d.b("video", "player id is invalid or context is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
