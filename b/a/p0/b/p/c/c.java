package b.a.p0.b.p.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.e0.d;
import b.a.p0.a.f2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.b.p.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
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
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0520b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f10049a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10050b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10051c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f10052d;

        public a(c cVar, Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10049a = context;
            this.f10050b = jSONObject;
            this.f10051c = callbackHandler;
            this.f10052d = str;
        }

        @Override // b.a.p0.b.p.c.b.InterfaceC0520b
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    b.d(this.f10049a);
                }
                try {
                    this.f10050b.put("canceled", z);
                } catch (JSONException e2) {
                    if (z.f5228b) {
                        e2.printStackTrace();
                    }
                }
                this.f10051c.handleSchemeDispatchCallback(this.f10052d, UnitedSchemeUtility.wrapCallbackParams(this.f10050b, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(eVar, "/swanAPI/guidePushSetting");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.c("GuidePushSettingAction", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.c("GuidePushSettingAction", "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (TextUtils.isEmpty(optParamsAsJo.optString("source"))) {
                d.c("GuidePushSettingAction", "openPushGuide source empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!(context instanceof Activity)) {
                d.c("GuidePushSettingAction", "illegal context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal context");
                return false;
            } else {
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                boolean b2 = b.b(context);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("authorized", b2);
                } catch (JSONException e2) {
                    if (z.f5228b) {
                        e2.printStackTrace();
                    }
                }
                if (b2) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } else {
                    b.e(context, k(context, jSONObject, optString, callbackHandler));
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("authorized", b2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                    return true;
                } catch (JSONException e3) {
                    if (z.f5228b) {
                        e3.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final b.InterfaceC0520b k(Context context, JSONObject jSONObject, String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, str, callbackHandler)) == null) ? new a(this, context, jSONObject, callbackHandler, str) : (b.InterfaceC0520b) invokeLLLL.objValue;
    }
}
