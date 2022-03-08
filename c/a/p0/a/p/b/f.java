package c.a.p0.a.p.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
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
public class f extends c.a.p0.a.p.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6776g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6777h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.c f6778i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f6779j;
        public final /* synthetic */ String k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.t1.e eVar, c.a.p0.a.p.e.c cVar, CameraPreview cameraPreview, String str) {
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
            this.f6774e = callbackHandler;
            this.f6775f = unitedSchemeEntity;
            this.f6776g = context;
            this.f6777h = eVar;
            this.f6778i = cVar;
            this.f6779j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.l.p(this.f6776g, this.f6775f, this.f6774e, this.f6777h, this.f6778i, this.f6779j, this.k);
                    return;
                }
                c.a.p0.a.x1.c.d.p(iVar, this.f6774e, this.f6775f);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6781f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6782g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f6783h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.c f6784i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6785j;
        public final /* synthetic */ f k;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, CameraPreview cameraPreview, c.a.p0.a.p.e.c cVar, String str) {
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
            this.k = fVar;
            this.f6780e = unitedSchemeEntity;
            this.f6781f = callbackHandler;
            this.f6782g = eVar;
            this.f6783h = cameraPreview;
            this.f6784i = cVar;
            this.f6785j = str;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.k.r(this.f6780e, this.f6781f, this.f6782g, this.f6783h, this.f6784i, this.f6785j);
                c.a.p0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f6781f, this.f6780e, 10005);
                c.a.p0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.p.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.c f6787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6788d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f6790f;

        public c(f fVar, String str, c.a.p0.a.t1.e eVar, c.a.p0.a.p.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f6790f = fVar;
            this.a = str;
            this.f6786b = eVar;
            this.f6787c = cVar;
            this.f6788d = callbackHandler;
            this.f6789e = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.p.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6790f.k(this.f6789e, this.f6788d, false);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // c.a.p0.a.p.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", c.a.p0.a.e2.b.J(this.a, this.f6786b.f7512f));
                } catch (JSONException e2) {
                    c.a.p0.a.u.d.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    c.a.p0.a.p.a b2 = c.a.p0.a.p.a.b();
                    c.a.p0.a.p.e.c cVar = this.f6787c;
                    b2.e(cVar.f7284g, cVar.f7283f, false);
                    if (z.f8176b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f6788d, this.f6789e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.p0.a.v1.e eVar) {
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
                super((c.a.p0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.p0.a.p.e.c cVar = (c.a.p0.a.p.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.p0.a.s.c.c.a aVar = (c.a.p0.a.s.c.c.a) c.a.p0.a.s.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = c.a.p0.a.e2.b.x(eVar.f7512f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.p.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            c.a.p0.a.u.d.i("SwanAppCameraManager", "handleAuthorized start");
            c.a.p0.a.l1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public c.a.p0.a.s.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.p.e.c(l(unitedSchemeEntity)) : (c.a.p0.a.s.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, CameraPreview cameraPreview, c.a.p0.a.p.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            c.a.p0.a.u.d.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String takePhotoPath = cameraPreview.getTakePhotoPath(str);
            try {
                cameraPreview.takePicture(takePhotoPath, new c(this, takePhotoPath, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                c.a.p0.a.u.d.c("SwanAppCameraManager", "take picture api occur exception");
                c.a.p0.a.p.a.b().e(cVar.f7284g, cVar.f7283f, false);
                if (z.f8176b) {
                    e2.printStackTrace();
                }
            }
            c.a.p0.a.u.d.i("SwanAppCameraManager", "take photo end");
        }
    }
}
