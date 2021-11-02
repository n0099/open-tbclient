package b.a.p0.a.n2.f.b;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e0.d;
import b.a.p0.a.n2.f.a;
import b.a.p0.a.u.e.o.l;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.n2.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0320a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7001a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7002b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f7003c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7004d;

        public C0320a(a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity, callbackHandler, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7004d = aVar;
            this.f7001a = unitedSchemeEntity;
            this.f7002b = callbackHandler;
            this.f7003c = lVar;
        }

        @Override // b.a.p0.a.n2.f.a.c
        public void a(float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
                d.g("compass", "handle compass change, angle:" + f2 + ",accuracy: " + i2);
                this.f7004d.k(this.f7001a, this.f7002b, this.f7003c, f2, i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/startCompass");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.b("compass", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4160b;
                return false;
            } else if (context == null) {
                d.b("compass", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                boolean z2 = a0.f4160b;
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    boolean z3 = a0.f4160b;
                    d.b("compass", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    boolean z4 = a0.f4160b;
                    d.b("compass", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                d.g("compass", "init");
                l lVar = new l("compassChange", optParamsAsJo, optString);
                b.a.p0.a.n2.f.a i2 = b.a.p0.a.n2.f.a.i();
                i2.l(context);
                i2.o(new C0320a(this, unitedSchemeEntity, callbackHandler, lVar));
                d.g("compass", "start listen compass");
                i2.p();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                lVar.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, lVar, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("direction", f2);
                jSONObject.put("accuracy", b.a.p0.a.n2.f.a.h(i2));
                if (a0.f4160b) {
                    String str = "compassAngle : " + jSONObject.toString();
                }
                lVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                d.b("compass", "handle compass,json error，" + e2.toString());
                lVar.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
