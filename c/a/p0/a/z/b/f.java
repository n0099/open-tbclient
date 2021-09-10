package c.a.p0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.e2.c.i;
import c.a.p0.a.e2.c.j.b;
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
    public class a implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9904e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9906g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9907h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.c f9908i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9909j;
        public final /* synthetic */ String k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
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
            this.f9904e = callbackHandler;
            this.f9905f = unitedSchemeEntity;
            this.f9906g = context;
            this.f9907h = eVar;
            this.f9908i = cVar;
            this.f9909j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.l.p(this.f9906g, this.f9905f, this.f9904e, this.f9907h, this.f9908i, this.f9909j, this.k);
                    return;
                }
                c.a.p0.a.e2.c.d.o(iVar, this.f9904e, this.f9905f);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9912c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9913d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.c f9914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9915f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f9916g;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, CameraPreview cameraPreview, c.a.p0.a.z.e.c cVar, String str) {
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
            this.f9916g = fVar;
            this.f9910a = unitedSchemeEntity;
            this.f9911b = callbackHandler;
            this.f9912c = eVar;
            this.f9913d = cameraPreview;
            this.f9914e = cVar;
            this.f9915f = str;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9916g.r(this.f9910a, this.f9911b, this.f9912c, this.f9913d, this.f9914e, this.f9915f);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f9911b, this.f9910a, 10005);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9918b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.c f9919c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9920d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f9922f;

        public c(f fVar, String str, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f9922f = fVar;
            this.f9917a = str;
            this.f9918b = eVar;
            this.f9919c = cVar;
            this.f9920d = callbackHandler;
            this.f9921e = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9922f.k(this.f9921e, this.f9920d, false);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // c.a.p0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", c.a.p0.a.k2.b.J(this.f9917a, this.f9918b.f4558f));
                } catch (JSONException e2) {
                    c.a.p0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    c.a.p0.a.z.a b2 = c.a.p0.a.z.a.b();
                    c.a.p0.a.z.e.c cVar = this.f9919c;
                    b2.e(cVar.f4658g, cVar.f4657f, false);
                    if (a0.f4766b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f9920d, this.f9921e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.p0.a.c2.e eVar) {
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
                super((c.a.p0.a.c2.e) objArr2[0], (String) objArr2[1]);
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
            c.a.p0.a.z.e.c cVar = (c.a.p0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.p0.a.c0.c.c.a aVar = (c.a.p0.a.c0.c.c.a) c.a.p0.a.c0.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = c.a.p0.a.k2.b.x(eVar.f4558f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            c.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public c.a.p0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.z.e.c(l(unitedSchemeEntity)) : (c.a.p0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, CameraPreview cameraPreview, c.a.p0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String takePhotoPath = cameraPreview.getTakePhotoPath(str);
            try {
                cameraPreview.takePicture(takePhotoPath, new c(this, takePhotoPath, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
                c.a.p0.a.z.a.b().e(cVar.f4658g, cVar.f4657f, false);
                if (a0.f4766b) {
                    e2.printStackTrace();
                }
            }
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "take photo end");
        }
    }
}
