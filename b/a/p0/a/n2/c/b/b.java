package b.a.p0.a.n2.c.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e0.d;
import b.a.p0.a.n2.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean j(Context context, b.a.p0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, eVar, unitedSchemeEntity)) == null) {
            if (eVar == null) {
                d.b("battery", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4160b;
                return false;
            } else if (context == null) {
                d.b("battery", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                boolean z2 = a0.f4160b;
                return false;
            } else {
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    @Nullable
    public JSONObject k(@NonNull a.C0317a c0317a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0317a)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                int i2 = 100;
                if (c0317a.f6986a <= 100) {
                    i2 = c0317a.f6986a;
                }
                jSONObject.put(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, String.valueOf(i2));
                jSONObject.put("isCharging", c0317a.f6987b);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
