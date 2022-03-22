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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e extends c.a.n0.a.p.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5683b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f5684c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f5685d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f5686e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f5687f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f5688g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.n0.a.t1.e eVar2, c.a.n0.a.p.e.b bVar, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity, context, eVar2, bVar, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5688g = eVar;
            this.a = callbackHandler;
            this.f5683b = unitedSchemeEntity;
            this.f5684c = context;
            this.f5685d = eVar2;
            this.f5686e = bVar;
            this.f5687f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f5688g.o(this.f5684c, this.f5683b, this.a, this.f5685d, this.f5686e, this.f5687f);
                    return;
                }
                c.a.n0.a.x1.c.d.p(iVar, this.a, this.f5683b);
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
        public final /* synthetic */ CallbackHandler f5689b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f5690c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f5691d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f5692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5693f;

        public b(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar2, CameraPreview cameraPreview, c.a.n0.a.p.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, unitedSchemeEntity, callbackHandler, eVar2, cameraPreview, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5693f = eVar;
            this.a = unitedSchemeEntity;
            this.f5689b = callbackHandler;
            this.f5690c = eVar2;
            this.f5691d = cameraPreview;
            this.f5692e = bVar;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5693f.r(this.a, this.f5689b, this.f5690c, this.f5691d, this.f5692e);
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.f5689b, this.a, 10005);
                c.a.n0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/camera/stopRecord");
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
            c.a.n0.a.p.e.b bVar = (c.a.n0.a.p.e.b) q(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.n0.a.s.c.c.a aVar = (c.a.n0.a.s.c.c.a) c.a.n0.a.s.d.a.a(bVar);
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
            } else if (TextUtils.isEmpty(c.a.n0.a.e2.b.x(eVar.f6344b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                eVar.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.p.e.b bVar, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview}) == null) {
            c.a.n0.a.u.d.i("SwanAppCameraManager", "handleAuthorized start");
            if (c.a.n0.a.p.a.b().c(context) && c.a.n0.a.p.a.b().d(context)) {
                c.a.n0.a.u.d.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
                return;
            }
            c.a.n0.a.l1.e.g(context, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
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

    public c.a.n0.a.s.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.n0.a.p.e.b(l(unitedSchemeEntity)) : (c.a.n0.a.s.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, CameraPreview cameraPreview, c.a.n0.a.p.e.b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar) == null) {
            c.a.n0.a.u.d.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.n();
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            try {
                c.a.n0.a.p.a.b().j();
            } catch (Exception e3) {
                e = e3;
                cameraPreview.e();
                c.a.n0.a.p.a.b().e(bVar.f6097c, bVar.f6096b, false);
                if (z.f6924b) {
                    e.printStackTrace();
                }
                c.a.n0.a.u.d.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.e();
                c.a.n0.a.u.d.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", c.a.n0.a.e2.b.J(videoPath2, eVar.f6344b));
                hashMap.put("tempThumbPath", c.a.n0.a.e2.b.J(thumbPath2, eVar.f6344b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.e();
            c.a.n0.a.u.d.i("SwanAppCameraManager", "stop record end");
        }
    }
}
