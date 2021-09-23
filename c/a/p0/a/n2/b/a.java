package c.a.p0.a.n2.b;

import android.content.Context;
import android.media.AudioManager;
import c.a.p0.a.c2.e;
import c.a.p0.a.c2.f.a0;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/getMediaVolumeSync");
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.p0.a.e0.d.b("getMediaVolumeSync", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = a0.f4774b;
                return false;
            } else if (context == null) {
                c.a.p0.a.e0.d.b("getMediaVolumeSync", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                boolean z2 = a0.f4774b;
                return false;
            } else {
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                if (audioManager == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "get AudioManager error");
                    boolean z3 = a0.f4774b;
                    return false;
                }
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                if (streamMaxVolume <= 0) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "max volume get 0");
                    boolean z4 = a0.f4774b;
                    return false;
                }
                double d2 = streamVolume / streamMaxVolume;
                if (d2 < 0.0d) {
                    d2 = 0.0d;
                } else if (d2 > 1.0d) {
                    d2 = 1.0d;
                }
                if (a0.f4774b) {
                    String str = "getMediaVolumeSync: " + d2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", d2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    return true;
                } catch (JSONException unused) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "json exception");
                    boolean z5 = a0.f4774b;
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
