package c.a.o0.a.i1.c.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.o0.a.c2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e0.d;
import c.a.o0.a.p.d.y;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.audio.SwanAppAudioPlayer;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.c.b f6579e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f6580f;

        /* renamed from: c.a.o0.a.i1.c.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0255a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6581e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f6582f;

            public RunnableC0255a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6582f = aVar;
                this.f6581e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f6582f;
                    c.a.o0.a.i1.c.b bVar = aVar.f6579e;
                    bVar.f6557c = this.f6581e;
                    aVar.f6580f.J(bVar);
                }
            }
        }

        public a(b bVar, c.a.o0.a.i1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6579e = bVar2;
            this.f6580f = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new RunnableC0255a(this, str));
            }
        }
    }

    /* renamed from: c.a.o0.a.i1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0256b implements c.a.o0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.c.b f6583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f6584f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6585g;

        /* renamed from: c.a.o0.a.i1.c.d.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6586e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0256b f6587f;

            public a(C0256b c0256b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0256b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6587f = c0256b;
                this.f6586e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0256b c0256b = this.f6587f;
                    c.a.o0.a.i1.c.b bVar = c0256b.f6583e;
                    bVar.f6557c = this.f6586e;
                    c0256b.f6584f.w(bVar, c0256b.f6585g);
                }
            }
        }

        public C0256b(b bVar, c.a.o0.a.i1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, swanAppAudioPlayer, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6583e = bVar2;
            this.f6584f = swanAppAudioPlayer;
            this.f6585g = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                q0.b0(new a(this, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/audio");
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    @Override // c.a.o0.a.c2.f.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        SwanAppAudioPlayer k;
        char c2;
        boolean z;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f4738b) {
                String str2 = "handleSubAction subAction: " + str;
            }
            if (eVar.d0()) {
                boolean z2 = a0.f4738b;
                int hashCode = str.hashCode();
                if (hashCode != 1726838360) {
                    if (hashCode == 1726864194 && str.equals("/swanAPI/audio/play")) {
                        c3 = 1;
                        if (c3 != 0) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                            return false;
                        } else if (c3 == 1) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                            return false;
                        }
                    }
                    c3 = 65535;
                    if (c3 != 0) {
                    }
                } else {
                    if (str.equals("/swanAPI/audio/open")) {
                        c3 = 0;
                        if (c3 != 0) {
                        }
                    }
                    c3 = 65535;
                    if (c3 != 0) {
                    }
                }
            }
            JSONObject j2 = j(unitedSchemeEntity.getParam("params"));
            if (j2 == null) {
                d.b(MediaStreamTrack.AUDIO_TRACK_KIND, "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (TextUtils.equals(str, "/swanAPI/audio/setInnerAudioOption")) {
                return m(j2, eVar, unitedSchemeEntity, callbackHandler);
            } else {
                if (TextUtils.equals(str, "/swanAPI/audio/getAvailableAudioSources")) {
                    return l(unitedSchemeEntity, callbackHandler, eVar);
                }
                String optString = j2.optString("audioId");
                if (TextUtils.equals(str, "/swanAPI/audio/open")) {
                    k = new SwanAppAudioPlayer(optString);
                } else {
                    k = k(optString);
                }
                if (k == null) {
                    d.b(MediaStreamTrack.AUDIO_TRACK_KIND, "player is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                c.a.o0.a.i1.c.b a2 = c.a.o0.a.i1.c.b.a(j2, k.t());
                if (!a2.b()) {
                    d.b(MediaStreamTrack.AUDIO_TRACK_KIND, "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                if (a0.f4738b) {
                    String str3 = "subAction is : " + str;
                }
                switch (str.hashCode()) {
                    case 1726838360:
                        if (str.equals("/swanAPI/audio/open")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1726864194:
                        if (str.equals("/swanAPI/audio/play")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1726946950:
                        if (str.equals("/swanAPI/audio/seek")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1726961680:
                        if (str.equals("/swanAPI/audio/stop")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1806024023:
                        if (str.equals("/swanAPI/audio/update")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1981190058:
                        if (str.equals("/swanAPI/audio/close")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1992873896:
                        if (str.equals("/swanAPI/audio/pause")) {
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
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "open, audio id:" + a2.f6555a);
                        n(context, callbackHandler, k, a2);
                        z = true;
                        break;
                    case 1:
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "update, audio id:" + a2.f6555a);
                        o(context, k, a2);
                        z = true;
                        break;
                    case 2:
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "play, audio id:" + a2.f6555a);
                        k.z();
                        z = true;
                        break;
                    case 3:
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "pause, audio id:" + a2.f6555a);
                        k.x();
                        z = true;
                        break;
                    case 4:
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "seek, audio id:" + a2.f6555a);
                        k.D(a2.f6562h);
                        z = true;
                        break;
                    case 5:
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "stop, audio id:" + a2.f6555a);
                        k.I();
                        z = true;
                        break;
                    case 6:
                        d.g(MediaStreamTrack.AUDIO_TRACK_KIND, "release, audio id:" + a2.f6555a);
                        k.B();
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
            }
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
                    if (a0.f4738b) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final SwanAppAudioPlayer k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                c.a.o0.a.i1.a e2 = c.a.o0.a.i1.b.e(str);
                if (e2 instanceof SwanAppAudioPlayer) {
                    return (SwanAppAudioPlayer) e2.i();
                }
            }
            return null;
        }
        return (SwanAppAudioPlayer) invokeL.objValue;
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                d.b("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            jSONArray.put("mic");
            jSONArray.put(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER);
            jSONArray.put("voice_communication");
            jSONArray.put("voice_recognition");
            try {
                jSONObject.put("audioSources", jSONArray.toString());
                if (a0.f4738b) {
                    String str = "audioSource:" + jSONObject.toString();
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                if (a0.f4738b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(JSONObject jSONObject, c.a.o0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, jSONObject, eVar, unitedSchemeEntity, callbackHandler)) == null) {
            if (eVar == null) {
                d.b("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
                eVar.J().h("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
                if (a0.f4738b) {
                    String str = "Audio Mix Changed to " + optBoolean;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } catch (Exception unused) {
                d.b("AudioPlayerAction", "set aiapps global var error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, c.a.o0.a.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, swanAppAudioPlayer, bVar) == null) {
            y k = c.a.o0.a.c1.a.k();
            if (k != null && c.a.o0.a.k2.b.s(bVar.f6557c) == PathType.CLOUD) {
                k.b(context, bVar.f6557c, new C0256b(this, bVar, swanAppAudioPlayer, callbackHandler));
            } else {
                swanAppAudioPlayer.w(bVar, callbackHandler);
            }
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, c.a.o0.a.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, swanAppAudioPlayer, bVar) == null) {
            if (TextUtils.isEmpty(bVar.f6557c) && c.a.o0.a.k2.b.s(bVar.f6557c) == PathType.CLOUD) {
                c.a.o0.a.c1.a.k().b(context, bVar.f6557c, new a(this, bVar, swanAppAudioPlayer));
            } else {
                swanAppAudioPlayer.J(bVar);
            }
        }
    }
}
