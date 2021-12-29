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
        public final /* synthetic */ CallbackHandler f9987e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9988f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9989g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9990h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.b f9991i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9992j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f9993k;
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
            this.f9987e = callbackHandler;
            this.f9988f = unitedSchemeEntity;
            this.f9989g = context;
            this.f9990h = eVar;
            this.f9991i = bVar;
            this.f9992j = cameraPreview;
            this.f9993k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.l.r(this.f9989g, this.f9988f, this.f9987e, this.f9990h, this.f9991i, this.f9992j, this.f9993k);
                } else if (iVar != null && iVar.a() != null) {
                    String str = "authorize recorder failed : " + c.a.r0.a.h2.c.d.f(b2);
                    UnitedSchemeUtility.callCallback(this.f9987e, this.f9988f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
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
        public final /* synthetic */ UnitedSchemeEntity f9994e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9995f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9996g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f9997h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.b f9998i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9999j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f10000k;
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
            this.f9994e = unitedSchemeEntity;
            this.f9995f = callbackHandler;
            this.f9996g = context;
            this.f9997h = eVar;
            this.f9998i = bVar;
            this.f9999j = cameraPreview;
            this.f10000k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.l.t(this.f9996g, this.f9994e, this.f9995f, this.f9997h, this.f9998i, this.f9999j, this.f10000k);
                } else if (iVar != null && iVar.a() != null) {
                    this.l.s(iVar.b(), this.f9994e, this.f9995f);
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
        public final /* synthetic */ UnitedSchemeEntity f10001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10002f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f10003g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f10004h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.b f10005i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f10006j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ d f10007k;

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
            this.f10007k = dVar;
            this.f10001e = unitedSchemeEntity;
            this.f10002f = callbackHandler;
            this.f10003g = eVar;
            this.f10004h = cameraPreview;
            this.f10005i = bVar;
            this.f10006j = str;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10007k.w(this.f10001e, this.f10002f, this.f10003g, this.f10004h, this.f10005i, this.f10006j);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f10007k.s(10005, this.f10001e, this.f10002f);
            }
        }
    }

    /* renamed from: c.a.r0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0633d implements c.a.r0.a.z.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10008b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10009c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f10010d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f10011e;

        public C0633d(d dVar, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
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
            this.f10011e = dVar;
            this.a = cameraPreview;
            this.f10008b = unitedSchemeEntity;
            this.f10009c = callbackHandler;
            this.f10010d = hashMap;
        }

        @Override // c.a.r0.a.z.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.stopRecording();
                this.a.clearSaveMediaPath();
                this.f10011e.u(this.f10008b, this.f10009c, this.f10010d);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // c.a.r0.a.z.c.b
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.stopRecording();
                this.a.clearSaveMediaPath();
                this.f10011e.u(this.f10008b, this.f10009c, this.f10010d);
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
            String x = c.a.r0.a.o2.b.x(eVar.f5660f);
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
                    hashMap.put("tempVideoPath", c.a.r0.a.o2.b.J(cameraPreview.getVideoPath(), eVar.f5660f));
                    hashMap.put("tempThumbPath", c.a.r0.a.o2.b.J(cameraPreview.getThumbPath(), eVar.f5660f));
                    c.a.r0.a.z.a.b().i(31000, new C0633d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e2) {
                    e = e2;
                    c.a.r0.a.z.a.b().e(bVar.f5422g, bVar.f5421f, false);
                    if (z.f6340b) {
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
