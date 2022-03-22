package c.a.n0.a.z0.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.f.d.y;
import c.a.n0.a.p2.g1.c;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.e;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.z0.c.d;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.z0.c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f7786b;

        /* renamed from: c.a.n0.a.z0.c.e.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0601a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f7787b;

            public RunnableC0601a(a aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7787b = aVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f7787b;
                    c.a.n0.a.z0.c.b bVar = aVar.a;
                    bVar.f7772c = this.a;
                    aVar.f7786b.update(bVar);
                }
            }
        }

        public a(b bVar, c.a.n0.a.z0.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, swanAppAudioPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar2;
            this.f7786b = swanAppAudioPlayer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    c.a.n0.a.d2.u.a.b("audio", 3001, "cloud url is null", -1, "");
                }
                q0.e0(new RunnableC0601a(this, str));
            }
        }
    }

    /* renamed from: c.a.n0.a.z0.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0602b implements c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.z0.c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppAudioPlayer f7788b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7789c;

        /* renamed from: c.a.n0.a.z0.c.e.b$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C0602b f7790b;

            public a(C0602b c0602b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0602b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7790b = c0602b;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0602b c0602b = this.f7790b;
                    c.a.n0.a.z0.c.b bVar = c0602b.a;
                    bVar.f7772c = this.a;
                    c0602b.f7788b.x(bVar, c0602b.f7789c);
                }
            }
        }

        public C0602b(b bVar, c.a.n0.a.z0.c.b bVar2, SwanAppAudioPlayer swanAppAudioPlayer, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, swanAppAudioPlayer, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar2;
            this.f7788b = swanAppAudioPlayer;
            this.f7789c = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    c.a.n0.a.d2.u.a.b("audio", 3001, "cloud url is null", -1, "");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
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
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[ADDED_TO_REGION] */
    @Override // c.a.n0.a.v1.f.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLLL;
        SwanAppAudioPlayer k;
        char c2;
        boolean z;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            d.b("AudioPlayerAction", "#handleSubAction subAction=" + str + " entity.uri=" + unitedSchemeEntity.getUri());
            if (eVar.m0()) {
                if (z.f6924b) {
                    Log.d("AudioPlayerAction", "AudioPlayerAction does not supported when app is invisible.");
                }
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
            JSONObject j = j(unitedSchemeEntity.getParam("params"));
            if (j == null) {
                c.a.n0.a.d2.u.a.b("audio", 1001, "param is null", 201, "param is null");
                c.a.n0.a.u.d.c("audio", "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (TextUtils.equals(str, "/swanAPI/audio/setInnerAudioOption")) {
                return m(j, eVar, unitedSchemeEntity, callbackHandler);
            } else {
                if (TextUtils.equals(str, "/swanAPI/audio/getAvailableAudioSources")) {
                    return l(unitedSchemeEntity, callbackHandler, eVar);
                }
                String optString = j.optString("audioId");
                if (TextUtils.equals(str, "/swanAPI/audio/open")) {
                    k = new SwanAppAudioPlayer(optString);
                } else {
                    k = k(optString);
                }
                if (k == null) {
                    c.a.n0.a.d2.u.a.b("audio", 2001, "player is null", 201, "player is null");
                    c.a.n0.a.u.d.c("audio", "player is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                c.a.n0.a.z0.c.b a2 = c.a.n0.a.z0.c.b.a(j, k.u());
                if (!a2.b()) {
                    c.a.n0.a.d2.u.a.b("audio", 2001, "param is invalid", 201, "param is invalid");
                    c.a.n0.a.u.d.c("audio", "params is invalid");
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
                        c.a.n0.a.u.d.i("audio", "open, audio id:" + a2.a);
                        n(context, callbackHandler, k, a2);
                        z = true;
                        break;
                    case 1:
                        c.a.n0.a.u.d.i("audio", "update, audio id:" + a2.a);
                        o(context, k, a2);
                        z = true;
                        break;
                    case 2:
                        c.a.n0.a.u.d.i("audio", "play, audio id:" + a2.a);
                        k.A();
                        z = true;
                        break;
                    case 3:
                        c.a.n0.a.u.d.i("audio", "pause, audio id:" + a2.a);
                        k.y();
                        z = true;
                        break;
                    case 4:
                        c.a.n0.a.u.d.i("audio", "seek, audio id:" + a2.a);
                        k.E(a2.f7777h);
                        z = true;
                        break;
                    case 5:
                        c.a.n0.a.u.d.i("audio", "stop, audio id:" + a2.a);
                        k.J();
                        z = true;
                        break;
                    case 6:
                        c.a.n0.a.u.d.i("audio", "release, audio id:" + a2.a);
                        k.C();
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
                    if (z.f6924b) {
                        Log.d("AudioPlayerAction", Log.getStackTraceString(e2));
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
                c.a.n0.a.z0.a e2 = c.a.n0.a.z0.b.e(str);
                if (e2 instanceof SwanAppAudioPlayer) {
                    return (SwanAppAudioPlayer) e2.i();
                }
            }
            return null;
        }
        return (SwanAppAudioPlayer) invokeL.objValue;
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.n0.a.u.d.c("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("auto");
            jSONArray.put("mic");
            jSONArray.put(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER);
            jSONArray.put("voice_communication");
            jSONArray.put("voice_recognition");
            try {
                jSONObject.put("audioSources", jSONArray.toString());
                if (z.f6924b) {
                    Log.d("AudioPlayerAction", "audioSource:" + jSONObject.toString());
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                if (z.f6924b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean m(JSONObject jSONObject, c.a.n0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, jSONObject, eVar, unitedSchemeEntity, callbackHandler)) == null) {
            if (eVar == null) {
                c.a.n0.a.u.d.c("AudioPlayerAction", "aiapp or entity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            try {
                boolean optBoolean = jSONObject.optBoolean("mixWithOther", false);
                eVar.T().h("key_audio_is_mix_with_other", Boolean.valueOf(optBoolean));
                if (z.f6924b) {
                    Log.d("AudioPlayerAction", "Audio Mix Changed to " + optBoolean);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            } catch (Exception unused) {
                c.a.n0.a.u.d.c("AudioPlayerAction", "set aiapps global var error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(Context context, CallbackHandler callbackHandler, SwanAppAudioPlayer swanAppAudioPlayer, c.a.n0.a.z0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, swanAppAudioPlayer, bVar) == null) {
            y l = c.a.n0.a.s0.a.l();
            if (l != null && c.a.n0.a.e2.b.s(bVar.f7772c) == PathType.CLOUD) {
                l.b(context, bVar.f7772c, new C0602b(this, bVar, swanAppAudioPlayer, callbackHandler));
            } else {
                swanAppAudioPlayer.x(bVar, callbackHandler);
            }
        }
    }

    public final void o(Context context, SwanAppAudioPlayer swanAppAudioPlayer, c.a.n0.a.z0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, swanAppAudioPlayer, bVar) == null) {
            if (TextUtils.isEmpty(bVar.f7772c) && c.a.n0.a.e2.b.s(bVar.f7772c) == PathType.CLOUD) {
                c.a.n0.a.s0.a.l().b(context, bVar.f7772c, new a(this, bVar, swanAppAudioPlayer));
            } else {
                swanAppAudioPlayer.update(bVar);
            }
        }
    }
}
