package c.a.r0.a.j1.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.r0.a.f2.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.j1.c.c;
import c.a.r0.a.j1.c.d;
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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/backgroundAudio");
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity != null) {
                d.b("AudioBGPlayerAction", "#handle entity.uri=" + unitedSchemeEntity.getUri());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.r0.a.f2.f.z
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        c.a.r0.a.j1.c.a b2;
        char c2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (eVar == null) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2001, "SwanApp is null", 1001, "SwanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            d.b("AudioBGPlayerAction", "#handleSubAction subAction=" + str + " entity.uri=" + unitedSchemeEntity.getUri());
            JSONObject j2 = j(unitedSchemeEntity.getParam("params"));
            if (j2 == null) {
                c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2001, "param is null", 201, "param is null");
                c.a.r0.a.e0.d.c("backgroundAudio", "param is null!");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            c O = eVar.O();
            if (TextUtils.equals(str, "/swanAPI/backgroundAudio/open")) {
                b2 = c.a.r0.a.j1.c.a.b(j2, new c.a.r0.a.j1.c.a());
            } else {
                b2 = c.a.r0.a.j1.c.a.b(j2, O.q());
            }
            d.b("AudioBGPlayerAction", "#handleSubAction playerParams=" + b2);
            JSONObject jSONObject = null;
            switch (str.hashCode()) {
                case 312101659:
                    if (str.equals("/swanAPI/backgroundAudio/getParamsSync")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 335869926:
                    if (str.equals("/swanAPI/backgroundAudio/open")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 335895760:
                    if (str.equals("/swanAPI/backgroundAudio/play")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 335978516:
                    if (str.equals("/swanAPI/backgroundAudio/seek")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 335993246:
                    if (str.equals("/swanAPI/backgroundAudio/stop")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 820188005:
                    if (str.equals("/swanAPI/backgroundAudio/update")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1822525402:
                    if (str.equals("/swanAPI/backgroundAudio/pause")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    c.a.r0.a.e0.d.i("backgroundAudio", "open, audioId " + b2.a);
                    O.z(b2, callbackHandler);
                    z = true;
                    break;
                case 1:
                    c.a.r0.a.e0.d.i("backgroundAudio", "update, audioId " + b2.a);
                    O.update(b2);
                    z = true;
                    break;
                case 2:
                    c.a.r0.a.e0.d.i("backgroundAudio", "play, audioId " + b2.a);
                    O.F();
                    z = true;
                    break;
                case 3:
                    c.a.r0.a.e0.d.i("backgroundAudio", "pause, audioId " + b2.a);
                    O.A();
                    z = true;
                    break;
                case 4:
                    c.a.r0.a.e0.d.i("backgroundAudio", "seek, audioId " + b2.a + " position " + b2.l);
                    O.G(b2.l);
                    z = true;
                    break;
                case 5:
                    c.a.r0.a.e0.d.i("backgroundAudio", "stop, audioId " + b2.a);
                    O.L();
                    z = true;
                    break;
                case 6:
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(b2.m, O.t(b2.m));
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        return true;
                    } catch (JSONException e2) {
                        c.a.r0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "json exception", -1, "");
                        c.a.r0.a.e0.d.c("backgroundAudio", "getParams error " + e2.toString());
                        d.c("backgroundAudio", "getParamsSync error", e2);
                        break;
                    }
                default:
                    z = false;
                    break;
            }
            d.b("AudioBGPlayerAction", "#handleSubAction invokeSuccess=" + z);
            if (z) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
            return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        return invokeLLLLL.booleanValue;
    }

    public final JSONObject j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e2) {
                    if (z.f6343b) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }
}
