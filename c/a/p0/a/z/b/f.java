package c.a.p0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h2.c.i;
import c.a.p0.a.h2.c.j.b;
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
public class f extends c.a.p0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8981e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8982f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f8983g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f8984h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.c f8985i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f8986j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f8987k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.d2.e eVar, c.a.p0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
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
            this.f8981e = callbackHandler;
            this.f8982f = unitedSchemeEntity;
            this.f8983g = context;
            this.f8984h = eVar;
            this.f8985i = cVar;
            this.f8986j = cameraPreview;
            this.f8987k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    this.l.p(this.f8983g, this.f8982f, this.f8981e, this.f8984h, this.f8985i, this.f8986j, this.f8987k);
                    return;
                }
                c.a.p0.a.h2.c.d.p(iVar, this.f8981e, this.f8982f);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8989f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f8990g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f8991h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.c f8992i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f8993j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ f f8994k;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, CameraPreview cameraPreview, c.a.p0.a.z.e.c cVar, String str) {
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
            this.f8994k = fVar;
            this.f8988e = unitedSchemeEntity;
            this.f8989f = callbackHandler;
            this.f8990g = eVar;
            this.f8991h = cameraPreview;
            this.f8992i = cVar;
            this.f8993j = str;
        }

        @Override // c.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f8994k.r(this.f8988e, this.f8989f, this.f8990g, this.f8991h, this.f8992i, this.f8993j);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f8989f, this.f8988e, 10005);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f8995b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.c f8996c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8997d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8998e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f8999f;

        public c(f fVar, String str, c.a.p0.a.d2.e eVar, c.a.p0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f8999f = fVar;
            this.a = str;
            this.f8995b = eVar;
            this.f8996c = cVar;
            this.f8997d = callbackHandler;
            this.f8998e = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8999f.k(this.f8998e, this.f8997d, false);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // c.a.p0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", c.a.p0.a.o2.b.J(this.a, this.f8995b.f4616f));
                } catch (JSONException e2) {
                    c.a.p0.a.e0.d.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    c.a.p0.a.z.a b2 = c.a.p0.a.z.a.b();
                    c.a.p0.a.z.e.c cVar = this.f8996c;
                    b2.e(cVar.f4378g, cVar.f4377f, false);
                    if (z.f5296b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f8997d, this.f8998e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.p0.a.f2.e eVar) {
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
                super((c.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
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
            c.a.p0.a.z.e.c cVar = (c.a.p0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.p0.a.c0.c.c.a aVar = (c.a.p0.a.c0.c.c.a) c.a.p0.a.c0.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = c.a.p0.a.o2.b.x(eVar.f4616f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            c.a.p0.a.e0.d.i("SwanAppCameraManager", "handleAuthorized start");
            c.a.p0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public c.a.p0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.z.e.c(l(unitedSchemeEntity)) : (c.a.p0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, CameraPreview cameraPreview, c.a.p0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            c.a.p0.a.e0.d.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String takePhotoPath = cameraPreview.getTakePhotoPath(str);
            try {
                cameraPreview.takePicture(takePhotoPath, new c(this, takePhotoPath, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                c.a.p0.a.e0.d.c("SwanAppCameraManager", "take picture api occur exception");
                c.a.p0.a.z.a.b().e(cVar.f4378g, cVar.f4377f, false);
                if (z.f5296b) {
                    e2.printStackTrace();
                }
            }
            c.a.p0.a.e0.d.i("SwanAppCameraManager", "take photo end");
        }
    }
}
