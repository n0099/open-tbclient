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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends b.a.p0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9144f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9145g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9146h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.e.c f9147i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
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
            this.f9143e = callbackHandler;
            this.f9144f = unitedSchemeEntity;
            this.f9145g = context;
            this.f9146h = eVar;
            this.f9147i = cVar;
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
                    this.l.p(this.f9145g, this.f9144f, this.f9143e, this.f9146h, this.f9147i, this.j, this.k);
                    return;
                }
                b.a.p0.a.e2.c.d.o(iVar, this.f9143e, this.f9144f);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9148a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9149b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9150c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9151d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.e.c f9152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9153f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f9154g;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, CameraPreview cameraPreview, b.a.p0.a.z.e.c cVar, String str) {
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
            this.f9154g = fVar;
            this.f9148a = unitedSchemeEntity;
            this.f9149b = callbackHandler;
            this.f9150c = eVar;
            this.f9151d = cameraPreview;
            this.f9152e = cVar;
            this.f9153f = str;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9154g.r(this.f9148a, this.f9149b, this.f9150c, this.f9151d, this.f9152e, this.f9153f);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f9149b, this.f9148a, 10005);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9155a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f9156b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.e.c f9157c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9158d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9159e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f9160f;

        public c(f fVar, String str, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f9160f = fVar;
            this.f9155a = str;
            this.f9156b = eVar;
            this.f9157c = cVar;
            this.f9158d = callbackHandler;
            this.f9159e = unitedSchemeEntity;
        }

        @Override // b.a.p0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9160f.k(this.f9159e, this.f9158d, false);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // b.a.p0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", b.a.p0.a.k2.b.J(this.f9155a, this.f9156b.f3961f));
                } catch (JSONException e2) {
                    b.a.p0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    b.a.p0.a.z.a b2 = b.a.p0.a.z.a.b();
                    b.a.p0.a.z.e.c cVar = this.f9157c;
                    b2.e(cVar.f4057g, cVar.f4056f, false);
                    if (a0.f4160b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f9158d, this.f9159e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b.a.p0.a.c2.e eVar) {
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
            b.a.p0.a.z.e.c cVar = (b.a.p0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            b.a.p0.a.c0.c.c.a aVar = (b.a.p0.a.c0.c.c.a) b.a.p0.a.c0.d.a.a(cVar);
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
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.S().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            b.a.p0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            b.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public b.a.p0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new b.a.p0.a.z.e.c(l(unitedSchemeEntity)) : (b.a.p0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, CameraPreview cameraPreview, b.a.p0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            b.a.p0.a.e0.d.g("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String takePhotoPath = cameraPreview.getTakePhotoPath(str);
            try {
                cameraPreview.takePicture(takePhotoPath, new c(this, takePhotoPath, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                b.a.p0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
                b.a.p0.a.z.a.b().e(cVar.f4057g, cVar.f4056f, false);
                if (a0.f4160b) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.e0.d.g("SwanAppCameraManager", "take photo end");
        }
    }
}
