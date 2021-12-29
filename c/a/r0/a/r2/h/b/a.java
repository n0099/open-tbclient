package c.a.r0.a.r2.h.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.e0.d;
import c.a.r0.a.f2.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.r2.h.a;
import c.a.r0.a.u.e.n.m;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.r2.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0529a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8851b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ m f8852c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f8853d;

        public C0529a(a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m mVar) {
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
            this.f8853d = aVar;
            this.a = unitedSchemeEntity;
            this.f8851b = callbackHandler;
            this.f8852c = mVar;
        }

        @Override // c.a.r0.a.r2.h.a.b
        public void a(float[] fArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fArr) == null) && fArr != null && fArr.length == 3) {
                this.f8853d.k(this.a, this.f8851b, this.f8852c, fArr);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/startDeviceMotion");
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.c("StartDeviceMotionAction", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
                return false;
            } else if (context == null) {
                d.c("StartDeviceMotionAction", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    d.c("StartDeviceMotionAction", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d.c("StartDeviceMotionAction", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = optParamsAsJo.optString("interval");
                if ("ui".equals(optString2)) {
                    i2 = 2;
                } else {
                    i2 = "game".equals(optString2) ? 1 : 3;
                }
                d.i("StartDeviceMotionAction", "startSensor===");
                m mVar = new m("deviceMotionChange", optParamsAsJo, optString);
                if (!c.a.r0.a.r2.h.a.h().l(i2, new C0529a(this, unitedSchemeEntity, callbackHandler, mVar))) {
                    d.c("StartDeviceMotionAction", "start system sensor fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "start system sensor fail");
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                mVar.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m mVar, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, mVar, fArr) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] dArr = new double[3];
            double d2 = fArr[0] - 1.5707963267948966d;
            if (d2 < 0.0d) {
                d2 += 6.283185307179586d;
            }
            dArr[0] = Math.toDegrees(d2);
            dArr[1] = Math.toDegrees(-fArr[2]);
            dArr[2] = Math.toDegrees(-fArr[1]);
            if (z.f6340b) {
                String str = "deviceMotionChange: " + Arrays.toString(dArr);
            }
            try {
                jSONObject.put(AnimationProperty.OPACITY, (float) dArr[0]);
                jSONObject.put("beta", (float) dArr[1]);
                jSONObject.put("gamma", (float) dArr[2]);
                mVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                d.c("StartDeviceMotionAction", "handle orientation,json error，" + e2.toString());
                mVar.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
