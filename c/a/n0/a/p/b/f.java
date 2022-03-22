package c.a.n0.a.p.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.n0.a.p.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5694b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f5695c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f5696d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.c f5697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f5698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5699g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f5700h;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.n0.a.t1.e eVar, c.a.n0.a.p.e.c cVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, unitedSchemeEntity, context, eVar, cVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5700h = fVar;
            this.a = callbackHandler;
            this.f5694b = unitedSchemeEntity;
            this.f5695c = context;
            this.f5696d = eVar;
            this.f5697e = cVar;
            this.f5698f = cameraPreview;
            this.f5699g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f5700h.p(this.f5695c, this.f5694b, this.a, this.f5696d, this.f5697e, this.f5698f, this.f5699g);
                    return;
                }
                c.a.n0.a.x1.c.d.p(iVar, this.a, this.f5694b);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5701b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f5702c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f5703d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.c f5704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5705f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f5706g;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, CameraPreview cameraPreview, c.a.n0.a.p.e.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5706g = fVar;
            this.a = unitedSchemeEntity;
            this.f5701b = callbackHandler;
            this.f5702c = eVar;
            this.f5703d = cameraPreview;
            this.f5704e = cVar;
            this.f5705f = str;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5706g.r(this.a, this.f5701b, this.f5702c, this.f5703d, this.f5704e, this.f5705f);
                c.a.n0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.f5701b, this.a, 10005);
                c.a.n0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.p.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f5707b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.c f5708c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5709d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5711f;

        public c(f fVar, String str, c.a.n0.a.t1.e eVar, c.a.n0.a.p.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, eVar, cVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5711f = fVar;
            this.a = str;
            this.f5707b = eVar;
            this.f5708c = cVar;
            this.f5709d = callbackHandler;
            this.f5710e = unitedSchemeEntity;
        }

        @Override // c.a.n0.a.p.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5711f.k(this.f5710e, this.f5709d, false);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // c.a.n0.a.p.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", c.a.n0.a.e2.b.J(this.a, this.f5707b.f6344b));
                } catch (JSONException e2) {
                    c.a.n0.a.u.d.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    c.a.n0.a.p.a b2 = c.a.n0.a.p.a.b();
                    c.a.n0.a.p.e.c cVar = this.f5708c;
                    b2.e(cVar.f6097c, cVar.f6096b, false);
                    if (z.f6924b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f5709d, this.f5710e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/camera/takePhoto");
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
                super((c.a.n0.a.v1.e) objArr2[0], (String) objArr2[1]);
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
            c.a.n0.a.p.e.c cVar = (c.a.n0.a.p.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.n0.a.s.c.c.a aVar = (c.a.n0.a.s.c.c.a) c.a.n0.a.s.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = c.a.n0.a.e2.b.x(eVar.f6344b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.p.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            c.a.n0.a.u.d.i("SwanAppCameraManager", "handleAuthorized start");
            c.a.n0.a.l1.e.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public c.a.n0.a.s.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new c.a.n0.a.p.e.c(l(unitedSchemeEntity)) : (c.a.n0.a.s.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, CameraPreview cameraPreview, c.a.n0.a.p.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            c.a.n0.a.u.d.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.j);
            String g2 = cameraPreview.g(str);
            try {
                cameraPreview.o(g2, new c(this, g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                c.a.n0.a.u.d.c("SwanAppCameraManager", "take picture api occur exception");
                c.a.n0.a.p.a.b().e(cVar.f6097c, cVar.f6096b, false);
                if (z.f6924b) {
                    e2.printStackTrace();
                }
            }
            c.a.n0.a.u.d.i("SwanAppCameraManager", "take photo end");
        }
    }
}
