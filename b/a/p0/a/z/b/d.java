package b.a.p0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b.a.p0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9111f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9112g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9113h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.e.b f9114i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, unitedSchemeEntity, context, eVar, bVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f9110e = callbackHandler;
            this.f9111f = unitedSchemeEntity;
            this.f9112g = context;
            this.f9113h = eVar;
            this.f9114i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.l.r(this.f9112g, this.f9111f, this.f9110e, this.f9113h, this.f9114i, this.j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    String str = "authorize recorder failed : " + b.a.p0.a.e2.c.d.f(b2);
                    UnitedSchemeUtility.callCallback(this.f9110e, this.f9111f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                    b.a.p0.a.e0.d.l("SwanAppAction", str);
                } else {
                    b.a.p0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9117g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9118h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.e.b f9119i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public b(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f9115e = unitedSchemeEntity;
            this.f9116f = callbackHandler;
            this.f9117g = context;
            this.f9118h = eVar;
            this.f9119i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.l.t(this.f9117g, this.f9115e, this.f9116f, this.f9118h, this.f9119i, this.j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    this.l.s(iVar.b(), this.f9115e, this.f9116f);
                } else {
                    b.a.p0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9120a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9122c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9123d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.e.b f9124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9125f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f9126g;

        public c(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, CameraPreview cameraPreview, b.a.p0.a.z.e.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9126g = dVar;
            this.f9120a = unitedSchemeEntity;
            this.f9121b = callbackHandler;
            this.f9122c = eVar;
            this.f9123d = cameraPreview;
            this.f9124e = bVar;
            this.f9125f = str;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9126g.w(this.f9120a, this.f9121b, this.f9122c, this.f9123d, this.f9124e, this.f9125f);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f9126g.s(10005, this.f9120a, this.f9121b);
            }
        }
    }

    /* renamed from: b.a.p0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0472d implements b.a.p0.a.z.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9127a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9129c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f9130d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9131e;

        public C0472d(d dVar, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9131e = dVar;
            this.f9127a = cameraPreview;
            this.f9128b = unitedSchemeEntity;
            this.f9129c = callbackHandler;
            this.f9130d = hashMap;
        }

        @Override // b.a.p0.a.z.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9127a.stopRecording();
                this.f9127a.clearSaveMediaPath();
                this.f9131e.u(this.f9128b, this.f9129c, this.f9130d);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // b.a.p0.a.z.c.b
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9127a.stopRecording();
                this.f9127a.clearSaveMediaPath();
                this.f9131e.u(this.f9128b, this.f9129c, this.f9130d);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/startRecord");
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
                super((b.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
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
            b.a.p0.a.z.e.b bVar = (b.a.p0.a.z.e.b) v(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            b.a.p0.a.c0.c.c.a aVar = (b.a.p0.a.c0.c.c.a) b.a.p0.a.c0.d.a.a(bVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = b.a.p0.a.k2.b.x(eVar.f3961f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            eVar.S().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            eVar.S().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
        }
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + b.a.p0.a.e2.c.d.f(i2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
            b.a.p0.a.e0.d.l("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            b.a.p0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            if (b.a.p0.a.z.a.b().c(context) && b.a.p0.a.z.a.b().d(context)) {
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
                return;
            }
            b.a.p0.a.s1.e.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
        }
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, hashMap) == null) || unitedSchemeEntity == null || callbackHandler == null || hashMap == null || (params = unitedSchemeEntity.getParams()) == null || params.isEmpty()) {
            return;
        }
        String str = params.get("params");
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).optString("timeoutCallback");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        j(unitedSchemeEntity, callbackHandler, hashMap, str2);
    }

    public b.a.p0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new b.a.p0.a.z.e.b(l(unitedSchemeEntity)) : (b.a.p0.a.c0.b.b) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, CameraPreview cameraPreview, b.a.p0.a.z.e.b bVar, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str}) == null) {
            b.a.p0.a.e0.d.g("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.startRecording(str);
                try {
                    hashMap.put("tempVideoPath", b.a.p0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f3961f));
                    hashMap.put("tempThumbPath", b.a.p0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f3961f));
                    b.a.p0.a.z.a.b().i(31000, new C0472d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e2) {
                    e = e2;
                    b.a.p0.a.z.a.b().e(bVar.f4057g, bVar.f4056f, false);
                    if (a0.f4160b) {
                        e.printStackTrace();
                    }
                    b.a.p0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
                    k(unitedSchemeEntity, callbackHandler, z);
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            k(unitedSchemeEntity, callbackHandler, z);
        }
    }
}
