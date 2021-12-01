package c.a.p0.a.j1.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.p0.a.f2.e;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.j1.c.d;
import c.a.p0.a.p.d.y;
import c.a.p0.a.z2.g1.c;
import c.a.p0.a.z2.q0;
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
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.c.b f6434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f6435f;

        /* renamed from: c.a.p0.a.j1.c.e.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0342a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6436e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f6437f;

            public RunnableC0342a(a aVar, String str) {
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
                this.f6437f = aVar;
                this.f6436e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f6437f;
                    c.a.p0.a.j1.c.b bVar = aVar.f6434e;
                    bVar.f6414c = this.f6436e;
                    aVar.f6435f.update(bVar);
                }
            }
        }

        public a(b bVar, c.a.p0.a.j1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer) {
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
            this.f6434e = bVar2;
            this.f6435f = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 3001, "cloud url is null", -1, "");
                }
                q0.e0(new RunnableC0342a(this, str));
            }
        }
    }

    /* renamed from: c.a.p0.a.j1.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0343b implements c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.c.b f6438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f6439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6440g;

        /* renamed from: c.a.p0.a.j1.c.e.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f6441e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0343b f6442f;

            public a(C0343b c0343b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0343b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6442f = c0343b;
                this.f6441e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0343b c0343b = this.f6442f;
                    c.a.p0.a.j1.c.b bVar = c0343b.f6438e;
                    bVar.f6414c = this.f6441e;
                    c0343b.f6439f.x(bVar, c0343b.f6440g);
                }
            }
        }

        public C0343b(b bVar, c.a.p0.a.j1.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
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
            this.f6438e = bVar2;
            this.f6439f = swanAppAudioPlayer;
            this.f6440g = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 3001, "cloud url is null", -1, "");
                }
                q0.e0(new a(this, str));
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity != null) {
                d.b("AudioPlayerAction", "#handle entity.uri=" + unitedSchemeEntity.getUri());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[ADDED_TO_REGION] */
    @Override // c.a.p0.a.f2.f.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        SwanAppAudioPlayer k2;
        char c2;
        boolean z;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            d.b("AudioPlayerAction", "#handleSubAction subAction=" + str + " entity.uri=" + unitedSchemeEntity.getUri());
            if (eVar.m0()) {
                boolean z2 = z.f5296b;
                int hashCode = str.hashCode();
                if (hashCode != 1726838360) {
                    if (hashCode == 1726864194 && str.equals("/swanAPI/audio/play")) {
                        c3 = 1;
                        if (c3 != 0 || c3 == 1) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                            return false;
                        }
                    }
                    c3 = 65535;
                    if (c3 != 0) {
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                if (str.equals("/swanAPI/audio/open")) {
                    c3 = 0;
                    if (c3 != 0) {
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                c3 = 65535;
                if (c3 != 0) {
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            JSONObject j2 = j(unitedSchemeEntity.getParam("params"));
            if (j2 == null) {
                c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 1001, "param is null", 201, "param is null");
                c.a.p0.a.e0.d.c(MediaStreamTrack.AUDIO_TRACK_KIND, "object is null");
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
                    k2 = new SwanAppAudioPlayer(optString);
                } else {
                    k2 = k(optString);
                }
                if (k2 == null) {
                    c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2001, "player is null", 201, "player is null");
                    c.a.p0.a.e0.d.c(MediaStreamTrack.AUDIO_TRACK_KIND, "player is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                c.a.p0.a.j1.c.b a2 = c.a.p0.a.j1.c.b.a(j2, k2.u());
                if (!a2.b()) {
                    c.a.p0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2001, "param is invalid", 201, "param is invalid");
                    c.a.p0.a.e0.d.c(MediaStreamTrack.AUDIO_TRACK_KIND, "params is invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
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
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "open, audio id:" + a2.a);
                        n(context, callbackHandler, k2, a2);
                        z = true;
                        break;
                    case 1:
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "update, audio id:" + a2.a);
                        o(context, k2, a2);
                        z = true;
                        break;
                    case 2:
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "play, audio id:" + a2.a);
                        k2.A();
                        z = true;
                        break;
                    case 3:
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "pause, audio id:" + a2.a);
                        k2.y();
                        z = true;
                        break;
                    case 4:
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "seek, audio id:" + a2.a);
                        k2.E(a2.f6419h);
                        z = true;
                        break;
                    case 5:
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "stop, audio id:" + a2.a);
                        k2.J();
                        z = true;
                        break;
                    case 6:
                        c.a.p0.a.e0.d.i(MediaStreamTrack.AUDIO_TRACK_KIND, "release, audio id:" + a2.a);
                        k2.C();
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                d.b("AudioPlayerAction", "#handleSubAction invokeSuccess=" + z);
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
                    if (z.f5296b) {
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
                c.a.p0.a.j1.a e2 = c.a.p0.a.j1.b.e(str);
                if (e2 instanceof SwanAppAudioPlayer) {
                    return (SwanAppAudioPlayer) e2.i();
                }
            }
            return null;
        }
        return (SwanAppAudioPlayer) invokeL.objValue;
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.p0.a.e0.d.c("AudioPlayerAction", "aiapp or entity is null");
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
                if (z.f5296b) {
                    String str = "audioSource:" + jSONObject.toString();
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                if (z.f5296b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(JSONObject jSONObject, c.a.p0.a.d2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, jSONObject, eVar, unitedSchemeEntity, callbackHandler)) == null) {
            if (eVar == null) {
                c.a.p0.a.e0.d.c("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
                eVar.T().h("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
                if (z.f5296b) {
                    String str = "Audio Mix Changed to " + optBoolean;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } catch (Exception unused) {
                c.a.p0.a.e0.d.c("AudioPlayerAction", "set aiapps global var error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, c.a.p0.a.j1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, swanAppAudioPlayer, bVar) == null) {
            y l = c.a.p0.a.c1.a.l();
            if (l != null && c.a.p0.a.o2.b.s(bVar.f6414c) == PathType.CLOUD) {
                l.b(context, bVar.f6414c, new C0343b(this, bVar, swanAppAudioPlayer, callbackHandler));
            } else {
                swanAppAudioPlayer.x(bVar, callbackHandler);
            }
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, c.a.p0.a.j1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, swanAppAudioPlayer, bVar) == null) {
            if (TextUtils.isEmpty(bVar.f6414c) && c.a.p0.a.o2.b.s(bVar.f6414c) == PathType.CLOUD) {
                c.a.p0.a.c1.a.l().b(context, bVar.f6414c, new a(this, bVar, swanAppAudioPlayer));
            } else {
                swanAppAudioPlayer.update(bVar);
            }
        }
    }
}
