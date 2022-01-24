package c.a.r0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
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
public class d extends c.a.r0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9914g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9915h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.b f9916i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9917j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
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
            this.f9912e = callbackHandler;
            this.f9913f = unitedSchemeEntity;
            this.f9914g = context;
            this.f9915h = eVar;
            this.f9916i = bVar;
            this.f9917j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.l.r(this.f9914g, this.f9913f, this.f9912e, this.f9915h, this.f9916i, this.f9917j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    String str = "authorize recorder failed : " + c.a.r0.a.h2.c.d.f(b2);
                    UnitedSchemeUtility.callCallback(this.f9912e, this.f9913f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                    c.a.r0.a.e0.d.o("SwanAppAction", str);
                } else {
                    c.a.r0.a.e0.d.c("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9918e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9919f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9920g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9921h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.b f9922i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9923j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public b(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
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
            this.f9918e = unitedSchemeEntity;
            this.f9919f = callbackHandler;
            this.f9920g = context;
            this.f9921h = eVar;
            this.f9922i = bVar;
            this.f9923j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.l.t(this.f9920g, this.f9918e, this.f9919f, this.f9921h, this.f9922i, this.f9923j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    this.l.s(iVar.b(), this.f9918e, this.f9919f);
                } else {
                    c.a.r0.a.e0.d.c("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9924e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9925f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9926g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9927h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.b f9928i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9929j;
        public final /* synthetic */ d k;

        public c(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, CameraPreview cameraPreview, c.a.r0.a.z.e.b bVar, String str) {
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
            this.k = dVar;
            this.f9924e = unitedSchemeEntity;
            this.f9925f = callbackHandler;
            this.f9926g = eVar;
            this.f9927h = cameraPreview;
            this.f9928i = bVar;
            this.f9929j = str;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.k.w(this.f9924e, this.f9925f, this.f9926g, this.f9927h, this.f9928i, this.f9929j);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.k.s(10005, this.f9924e, this.f9925f);
            }
        }
    }

    /* renamed from: c.a.r0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0651d implements c.a.r0.a.z.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9930b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9931c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f9932d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9933e;

        public C0651d(d dVar, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
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
            this.f9933e = dVar;
            this.a = cameraPreview;
            this.f9930b = unitedSchemeEntity;
            this.f9931c = callbackHandler;
            this.f9932d = hashMap;
        }

        @Override // c.a.r0.a.z.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.stopRecording();
                this.a.clearSaveMediaPath();
                this.f9933e.u(this.f9930b, this.f9931c, this.f9932d);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // c.a.r0.a.z.c.b
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.stopRecording();
                this.a.clearSaveMediaPath();
                this.f9933e.u(this.f9930b, this.f9931c, this.f9932d);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.r0.a.f2.e eVar) {
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
                super((c.a.r0.a.f2.e) objArr2[0], (String) objArr2[1]);
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
            c.a.r0.a.z.e.b bVar = (c.a.r0.a.z.e.b) v(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.r0.a.c0.c.c.a aVar = (c.a.r0.a.c0.c.c.a) c.a.r0.a.c0.d.a.a(bVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = c.a.r0.a.o2.b.x(eVar.f5679f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
        }
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + c.a.r0.a.h2.c.d.f(i2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
            c.a.r0.a.e0.d.o("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            c.a.r0.a.e0.d.i("SwanAppCameraManager", "handleAuthorized start");
            if (c.a.r0.a.z.a.b().c(context) && c.a.r0.a.z.a.b().d(context)) {
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
                return;
            }
            c.a.r0.a.v1.e.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public c.a.r0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new c.a.r0.a.z.e.b(l(unitedSchemeEntity)) : (c.a.r0.a.c0.b.b) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, CameraPreview cameraPreview, c.a.r0.a.z.e.b bVar, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str}) == null) {
            c.a.r0.a.e0.d.i("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.startRecording(str);
                try {
                    hashMap.put("tempVideoPath", c.a.r0.a.o2.b.J(cameraPreview.getVideoPath(), eVar.f5679f));
                    hashMap.put("tempThumbPath", c.a.r0.a.o2.b.J(cameraPreview.getThumbPath(), eVar.f5679f));
                    c.a.r0.a.z.a.b().i(31000, new C0651d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e2) {
                    e = e2;
                    c.a.r0.a.z.a.b().e(bVar.f5451g, bVar.f5450f, false);
                    if (z.f6343b) {
                        e.printStackTrace();
                    }
                    c.a.r0.a.e0.d.c("SwanAppCameraManager", "start recording api occur exception");
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
