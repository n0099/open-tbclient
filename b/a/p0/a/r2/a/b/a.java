package b.a.p0.a.r2.a.b;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.e0.d;
import b.a.p0.a.f2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.r2.a.a;
import b.a.p0.a.u.e.n.b;
import b.a.p0.a.u.e.n.m;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.r2.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0381a implements a.InterfaceC0380a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8141b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f8142c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f8143d;

        public C0381a(a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity, callbackHandler, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8143d = aVar;
            this.f8140a = unitedSchemeEntity;
            this.f8141b = callbackHandler;
            this.f8142c = mVar;
        }

        @Override // b.a.p0.a.r2.a.a.InterfaceC0380a
        public void a(double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                if (dArr != null && dArr.length == 3) {
                    d.i("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    this.f8143d.k(this.f8140a, this.f8141b, this.f8142c, dArr);
                    return;
                }
                d.c("accelerometer", "illegal accelerometers");
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.c("accelerometer", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = z.f5228b;
                return false;
            } else if (context == null) {
                d.c("accelerometer", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                boolean z2 = z.f5228b;
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    boolean z3 = z.f5228b;
                    d.c("accelerometer", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    boolean z4 = z.f5228b;
                    d.c("accelerometer", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                d.i("accelerometer", " init ");
                m mVar = new m("accelerometerChange", optParamsAsJo, optString);
                b.a.p0.a.r2.a.a a2 = b.a.p0.a.r2.a.a.a();
                a2.b(context, b.C0439b.a(optParamsAsJo.optString("interval")));
                a2.e(new C0381a(this, unitedSchemeEntity, callbackHandler, mVar));
                a2.f();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                mVar.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m mVar, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, mVar, dArr) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", dArr[0]);
                jSONObject.put("y", dArr[1]);
                jSONObject.put("z", dArr[2]);
                mVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                d.c("accelerometer", "handle compass,json error，" + e2.toString());
                mVar.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
