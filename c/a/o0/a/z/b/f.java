package c.a.o0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
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
public class f extends c.a.o0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9878g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9879h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.c f9880i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9881j;
        public final /* synthetic */ String k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
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
            this.f9876e = callbackHandler;
            this.f9877f = unitedSchemeEntity;
            this.f9878g = context;
            this.f9879h = eVar;
            this.f9880i = cVar;
            this.f9881j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.l.p(this.f9878g, this.f9877f, this.f9876e, this.f9879h, this.f9880i, this.f9881j, this.k);
                    return;
                }
                c.a.o0.a.e2.c.d.o(iVar, this.f9876e, this.f9877f);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9882a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9883b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9884c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9885d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.c f9886e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9887f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f9888g;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, CameraPreview cameraPreview, c.a.o0.a.z.e.c cVar, String str) {
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
            this.f9888g = fVar;
            this.f9882a = unitedSchemeEntity;
            this.f9883b = callbackHandler;
            this.f9884c = eVar;
            this.f9885d = cameraPreview;
            this.f9886e = cVar;
            this.f9887f = str;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9888g.r(this.f9882a, this.f9883b, this.f9884c, this.f9885d, this.f9886e, this.f9887f);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f9883b, this.f9882a, 10005);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.c f9891c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9892d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f9894f;

        public c(f fVar, String str, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f9894f = fVar;
            this.f9889a = str;
            this.f9890b = eVar;
            this.f9891c = cVar;
            this.f9892d = callbackHandler;
            this.f9893e = unitedSchemeEntity;
        }

        @Override // c.a.o0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9894f.k(this.f9893e, this.f9892d, false);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // c.a.o0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", c.a.o0.a.k2.b.J(this.f9889a, this.f9890b.f4530f));
                } catch (JSONException e2) {
                    c.a.o0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    c.a.o0.a.z.a b2 = c.a.o0.a.z.a.b();
                    c.a.o0.a.z.e.c cVar = this.f9891c;
                    b2.e(cVar.f4630g, cVar.f4629f, false);
                    if (a0.f4738b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f9892d, this.f9893e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.o0.a.c2.e eVar) {
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
                super((c.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
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
            c.a.o0.a.z.e.c cVar = (c.a.o0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.o0.a.c0.c.c.a aVar = (c.a.o0.a.c0.c.c.a) c.a.o0.a.c0.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = c.a.o0.a.k2.b.x(eVar.f4530f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            c.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public c.a.o0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new c.a.o0.a.z.e.c(l(unitedSchemeEntity)) : (c.a.o0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, CameraPreview cameraPreview, c.a.o0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String takePhotoPath = cameraPreview.getTakePhotoPath(str);
            try {
                cameraPreview.takePicture(takePhotoPath, new c(this, takePhotoPath, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
                c.a.o0.a.z.a.b().e(cVar.f4630g, cVar.f4629f, false);
                if (a0.f4738b) {
                    e2.printStackTrace();
                }
            }
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "take photo end");
        }
    }
}
