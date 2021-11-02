package b.a.p0.a.n2.a.b;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e0.d;
import b.a.p0.a.n2.a.a;
import b.a.p0.a.u.e.o.a;
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

    /* renamed from: b.a.p0.a.n2.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0316a implements a.InterfaceC0315a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f6975c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f6976d;

        public C0316a(a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar) {
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
            this.f6976d = aVar;
            this.f6973a = unitedSchemeEntity;
            this.f6974b = callbackHandler;
            this.f6975c = lVar;
        }

        @Override // b.a.p0.a.n2.a.a.InterfaceC0315a
        public void a(double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                if (dArr != null && dArr.length == 3) {
                    d.g("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    this.f6976d.k(this.f6973a, this.f6974b, this.f6975c, dArr);
                    return;
                }
                d.b("accelerometer", "illegal accelerometers");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/startAccelerometer");
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
                d.b("accelerometer", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4160b;
                return false;
            } else if (context == null) {
                d.b("accelerometer", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                boolean z2 = a0.f4160b;
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    boolean z3 = a0.f4160b;
                    d.b("accelerometer", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    boolean z4 = a0.f4160b;
                    d.b("accelerometer", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                d.g("accelerometer", " init ");
                l lVar = new l("accelerometerChange", optParamsAsJo, optString);
                b.a.p0.a.n2.a.a a2 = b.a.p0.a.n2.a.a.a();
                a2.b(context, a.b.a(optParamsAsJo.optString("interval")));
                a2.e(new C0316a(this, unitedSchemeEntity, callbackHandler, lVar));
                a2.f();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                lVar.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, lVar, dArr) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", dArr[0]);
                jSONObject.put("y", dArr[1]);
                jSONObject.put("z", dArr[2]);
                lVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                d.b("accelerometer", "handle compass,json error，" + e2.toString());
                lVar.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
