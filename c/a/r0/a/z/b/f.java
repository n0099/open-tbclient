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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.r0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10026f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f10027g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f10028h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.c f10029i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f10030j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f10031k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, unitedSchemeEntity, context, eVar, cVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = fVar;
            this.f10025e = callbackHandler;
            this.f10026f = unitedSchemeEntity;
            this.f10027g = context;
            this.f10028h = eVar;
            this.f10029i = cVar;
            this.f10030j = cameraPreview;
            this.f10031k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.l.p(this.f10027g, this.f10026f, this.f10025e, this.f10028h, this.f10029i, this.f10030j, this.f10031k);
                    return;
                }
                c.a.r0.a.h2.c.d.p(iVar, this.f10025e, this.f10026f);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10033f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f10034g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f10035h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.c f10036i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f10037j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ f f10038k;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, CameraPreview cameraPreview, c.a.r0.a.z.e.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10038k = fVar;
            this.f10032e = unitedSchemeEntity;
            this.f10033f = callbackHandler;
            this.f10034g = eVar;
            this.f10035h = cameraPreview;
            this.f10036i = cVar;
            this.f10037j = str;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10038k.r(this.f10032e, this.f10033f, this.f10034g, this.f10035h, this.f10036i, this.f10037j);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f10033f, this.f10032e, 10005);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f10039b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z.e.c f10040c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10041d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f10042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f10043f;

        public c(f fVar, String str, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, eVar, cVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10043f = fVar;
            this.a = str;
            this.f10039b = eVar;
            this.f10040c = cVar;
            this.f10041d = callbackHandler;
            this.f10042e = unitedSchemeEntity;
        }

        @Override // c.a.r0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10043f.k(this.f10042e, this.f10041d, false);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // c.a.r0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", c.a.r0.a.o2.b.J(this.a, this.f10039b.f5660f));
                } catch (JSONException e2) {
                    c.a.r0.a.e0.d.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    c.a.r0.a.z.a b2 = c.a.r0.a.z.a.b();
                    c.a.r0.a.z.e.c cVar = this.f10040c;
                    b2.e(cVar.f5422g, cVar.f5421f, false);
                    if (z.f6340b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f10041d, this.f10042e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/camera/takePhoto");
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
            c.a.r0.a.z.e.c cVar = (c.a.r0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.r0.a.c0.c.c.a aVar = (c.a.r0.a.c0.c.c.a) c.a.r0.a.c0.d.a.a(cVar);
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
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, c.a.r0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            c.a.r0.a.e0.d.i("SwanAppCameraManager", "handleAuthorized start");
            c.a.r0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public c.a.r0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new c.a.r0.a.z.e.c(l(unitedSchemeEntity)) : (c.a.r0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, CameraPreview cameraPreview, c.a.r0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            c.a.r0.a.e0.d.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String takePhotoPath = cameraPreview.getTakePhotoPath(str);
            try {
                cameraPreview.takePicture(takePhotoPath, new c(this, takePhotoPath, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                c.a.r0.a.e0.d.c("SwanAppCameraManager", "take picture api occur exception");
                c.a.r0.a.z.a.b().e(cVar.f5422g, cVar.f5421f, false);
                if (z.f6340b) {
                    e2.printStackTrace();
                }
            }
            c.a.r0.a.e0.d.i("SwanAppCameraManager", "take photo end");
        }
    }
}
