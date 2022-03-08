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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e extends c.a.p0.a.p.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6763f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6764g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6765h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f6766i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f6767j;
        public final /* synthetic */ e k;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.t1.e eVar2, c.a.p0.a.p.e.b bVar, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity, context, eVar2, bVar, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f6762e = callbackHandler;
            this.f6763f = unitedSchemeEntity;
            this.f6764g = context;
            this.f6765h = eVar2;
            this.f6766i = bVar;
            this.f6767j = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.k.o(this.f6764g, this.f6763f, this.f6762e, this.f6765h, this.f6766i, this.f6767j);
                    return;
                }
                c.a.p0.a.x1.c.d.p(iVar, this.f6762e, this.f6763f);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6768e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6769f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6770g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f6771h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f6772i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f6773j;

        public b(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar2, CameraPreview cameraPreview, c.a.p0.a.p.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, unitedSchemeEntity, callbackHandler, eVar2, cameraPreview, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6773j = eVar;
            this.f6768e = unitedSchemeEntity;
            this.f6769f = callbackHandler;
            this.f6770g = eVar2;
            this.f6771h = cameraPreview;
            this.f6772i = bVar;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6773j.r(this.f6768e, this.f6769f, this.f6770g, this.f6771h, this.f6772i);
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f6769f, this.f6768e, 10005);
                c.a.p0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/camera/stopRecord");
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
            c.a.p0.a.p.e.b bVar = (c.a.p0.a.p.e.b) q(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.p0.a.s.c.c.a aVar = (c.a.p0.a.s.c.c.a) c.a.p0.a.s.d.a.a(bVar);
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
            } else if (TextUtils.isEmpty(c.a.p0.a.e2.b.x(eVar.f7512f))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                eVar.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.p.e.b bVar, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview}) == null) {
            c.a.p0.a.u.d.i("SwanAppCameraManager", "handleAuthorized start");
            if (c.a.p0.a.p.a.b().c(context) && c.a.p0.a.p.a.b().d(context)) {
                c.a.p0.a.u.d.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
                return;
            }
            c.a.p0.a.l1.e.g(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                return file.exists() && file.length() > 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public c.a.p0.a.s.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.p.e.b(l(unitedSchemeEntity)) : (c.a.p0.a.s.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, CameraPreview cameraPreview, c.a.p0.a.p.e.b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar) == null) {
            c.a.p0.a.u.d.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.stopRecording();
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            try {
                c.a.p0.a.p.a.b().j();
            } catch (Exception e3) {
                e = e3;
                cameraPreview.clearSaveMediaPath();
                c.a.p0.a.p.a.b().e(bVar.f7284g, bVar.f7283f, false);
                if (z.f8176b) {
                    e.printStackTrace();
                }
                c.a.p0.a.u.d.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.clearSaveMediaPath();
                c.a.p0.a.u.d.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", c.a.p0.a.e2.b.J(videoPath2, eVar.f7512f));
                hashMap.put("tempThumbPath", c.a.p0.a.e2.b.J(thumbPath2, eVar.f7512f));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.clearSaveMediaPath();
            c.a.p0.a.u.d.i("SwanAppCameraManager", "stop record end");
        }
    }
}
