package b.a.p0.a.c0.c.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.c0.c.e.b.c;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
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
public class b extends b.a.p0.a.c2.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.c0.c.e.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.c0.c.e.b.b f4069a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4070b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f4071c;

        public a(b bVar, b.a.p0.a.c0.c.e.b.b bVar2, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4071c = bVar;
            this.f4069a = bVar2;
            this.f4070b = callbackHandler;
        }

        @Override // b.a.p0.a.c0.c.e.b.a
        public void a(int i2, View view, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, view, obj) == null) {
                c cVar = (c) this.f4069a.n();
                if (i2 == 0 || i2 == 1) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "loadState");
                        jSONObject.put("parentId", cVar.f4058h);
                        jSONObject.put("viewId", cVar.f4056f);
                        jSONObject.put("loadState", i2 == 1 ? ConstantHelper.LOG_FINISH : "error");
                    } catch (JSONException e2) {
                        d.c("Component-Action-ImageCover", "loadState callback error", e2);
                    }
                    this.f4071c.s(this.f4070b, jSONObject, cVar.f4059i);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/coverimage");
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
                super((e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.c2.f.b
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverimage" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            boolean z = a0.f4160b;
            c r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-ImageCover", "model is null");
                return false;
            }
            b.a.p0.a.c0.c.e.b.b bVar = new b.a.p0.a.c0.c.e.b.b(context, r);
            bVar.e0(new a(this, bVar, callbackHandler));
            b.a.p0.a.c0.b.c insert = bVar.insert();
            boolean a2 = insert.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.f4061b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            boolean z = a0.f4160b;
            c r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-ImageCover", "model is null");
                return false;
            }
            b.a.p0.a.c0.c.e.b.b bVar = (b.a.p0.a.c0.c.e.b.b) b.a.p0.a.c0.d.a.a(r);
            if (bVar == null) {
                String str2 = "can't find imageCoverView component:#" + r.f4056f;
                d.b("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            b.a.p0.a.c0.b.c B = bVar.B();
            boolean a2 = B.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.f4061b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            boolean z = a0.f4160b;
            c r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-ImageCover", "model is null");
                return false;
            }
            b.a.p0.a.c0.c.e.b.b bVar = (b.a.p0.a.c0.c.e.b.b) b.a.p0.a.c0.d.a.a(r);
            if (bVar == null) {
                String str2 = "can't find imageCoverView component:#" + r.f4056f;
                d.b("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            b.a.p0.a.c0.b.c update = bVar.update((b.a.p0.a.c0.c.e.b.b) r);
            boolean a2 = update.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.f4061b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final c r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.b("Component-Action-ImageCover", "params is null");
                return null;
            }
            c cVar = new c();
            try {
                cVar.a(k);
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.c("Component-Action-ImageCover", "model parse exception:", e2);
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, callbackHandler, jSONObject, str) == null) {
            d.g("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
