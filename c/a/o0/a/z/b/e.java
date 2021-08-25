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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e extends c.a.o0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9865f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9866g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9867h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.b f9868i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9869j;
        public final /* synthetic */ e k;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.o0.a.a2.e eVar2, c.a.o0.a.z.e.b bVar, CameraPreview cameraPreview) {
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
            this.f9864e = callbackHandler;
            this.f9865f = unitedSchemeEntity;
            this.f9866g = context;
            this.f9867h = eVar2;
            this.f9868i = bVar;
            this.f9869j = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.k.o(this.f9866g, this.f9865f, this.f9864e, this.f9867h, this.f9868i, this.f9869j);
                    return;
                }
                c.a.o0.a.e2.c.d.o(iVar, this.f9864e, this.f9865f);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9872c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9873d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.b f9874e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f9875f;

        public b(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar2, CameraPreview cameraPreview, c.a.o0.a.z.e.b bVar) {
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
            this.f9875f = eVar;
            this.f9870a = unitedSchemeEntity;
            this.f9871b = callbackHandler;
            this.f9872c = eVar2;
            this.f9873d = cameraPreview;
            this.f9874e = bVar;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9875f.r(this.f9870a, this.f9871b, this.f9872c, this.f9873d, this.f9874e);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f9871b, this.f9870a, 10005);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.o0.a.c2.e eVar) {
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
            c.a.o0.a.z.e.b bVar = (c.a.o0.a.z.e.b) q(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.o0.a.c0.c.c.a aVar = (c.a.o0.a.c0.c.c.a) c.a.o0.a.c0.d.a.a(bVar);
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
            } else if (TextUtils.isEmpty(c.a.o0.a.k2.b.x(eVar.f4530f))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.b bVar, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview}) == null) {
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            if (c.a.o0.a.z.a.b().c(context) && c.a.o0.a.z.a.b().d(context)) {
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
                return;
            }
            c.a.o0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
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

    public c.a.o0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.o0.a.z.e.b(l(unitedSchemeEntity)) : (c.a.o0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, CameraPreview cameraPreview, c.a.o0.a.z.e.b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar) == null) {
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.stopRecording();
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            try {
                c.a.o0.a.z.a.b().j();
            } catch (Exception e3) {
                e = e3;
                cameraPreview.clearSaveMediaPath();
                c.a.o0.a.z.a.b().e(bVar.f4630g, bVar.f4629f, false);
                if (a0.f4738b) {
                    e.printStackTrace();
                }
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.clearSaveMediaPath();
                c.a.o0.a.e0.d.g("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", c.a.o0.a.k2.b.J(videoPath2, eVar.f4530f));
                hashMap.put("tempThumbPath", c.a.o0.a.k2.b.J(thumbPath2, eVar.f4530f));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.clearSaveMediaPath();
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "stop record end");
        }
    }
}
