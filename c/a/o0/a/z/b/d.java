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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.o0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9840e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9841f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9842g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9843h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.b f9844i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9845j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, unitedSchemeEntity, context, eVar, bVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f9840e = callbackHandler;
            this.f9841f = unitedSchemeEntity;
            this.f9842g = context;
            this.f9843h = eVar;
            this.f9844i = bVar;
            this.f9845j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.l.r(this.f9842g, this.f9841f, this.f9840e, this.f9843h, this.f9844i, this.f9845j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    String str = "authorize recorder failed : " + c.a.o0.a.e2.c.d.f(b2);
                    UnitedSchemeUtility.callCallback(this.f9840e, this.f9841f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                    c.a.o0.a.e0.d.l("SwanAppAction", str);
                } else {
                    c.a.o0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9848g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9849h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.b f9850i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9851j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public b(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f9846e = unitedSchemeEntity;
            this.f9847f = callbackHandler;
            this.f9848g = context;
            this.f9849h = eVar;
            this.f9850i = bVar;
            this.f9851j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.l.t(this.f9848g, this.f9846e, this.f9847f, this.f9849h, this.f9850i, this.f9851j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    this.l.s(iVar.b(), this.f9846e, this.f9847f);
                } else {
                    c.a.o0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9852a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9853b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f9854c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9855d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.z.e.b f9856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9857f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f9858g;

        public c(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, CameraPreview cameraPreview, c.a.o0.a.z.e.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9858g = dVar;
            this.f9852a = unitedSchemeEntity;
            this.f9853b = callbackHandler;
            this.f9854c = eVar;
            this.f9855d = cameraPreview;
            this.f9856e = bVar;
            this.f9857f = str;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9858g.w(this.f9852a, this.f9853b, this.f9854c, this.f9855d, this.f9856e, this.f9857f);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f9858g.s(10005, this.f9852a, this.f9853b);
            }
        }
    }

    /* renamed from: c.a.o0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0475d implements c.a.o0.a.z.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9861c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f9862d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9863e;

        public C0475d(d dVar, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9863e = dVar;
            this.f9859a = cameraPreview;
            this.f9860b = unitedSchemeEntity;
            this.f9861c = callbackHandler;
            this.f9862d = hashMap;
        }

        @Override // c.a.o0.a.z.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9859a.stopRecording();
                this.f9859a.clearSaveMediaPath();
                this.f9863e.u(this.f9860b, this.f9861c, this.f9862d);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // c.a.o0.a.z.c.b
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9859a.stopRecording();
                this.f9859a.clearSaveMediaPath();
                this.f9863e.u(this.f9860b, this.f9861c, this.f9862d);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/startRecord");
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
            c.a.o0.a.z.e.b bVar = (c.a.o0.a.z.e.b) v(unitedSchemeEntity);
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
            }
            String x = c.a.o0.a.k2.b.x(eVar.f4530f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
        }
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + c.a.o0.a.e2.c.d.f(i2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
            c.a.o0.a.e0.d.l("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            if (c.a.o0.a.z.a.b().c(context) && c.a.o0.a.z.a.b().d(context)) {
                c.a.o0.a.e0.d.b("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
                return;
            }
            c.a.o0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
        }
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, hashMap) == null) || unitedSchemeEntity == null || callbackHandler == null || hashMap == null || (params = unitedSchemeEntity.getParams()) == null || params.isEmpty()) {
            return;
        }
        String str = params.get("params");
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).optString("timeoutCallback");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        j(unitedSchemeEntity, callbackHandler, hashMap, str2);
    }

    public c.a.o0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new c.a.o0.a.z.e.b(l(unitedSchemeEntity)) : (c.a.o0.a.c0.b.b) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, CameraPreview cameraPreview, c.a.o0.a.z.e.b bVar, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str}) == null) {
            c.a.o0.a.e0.d.g("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.startRecording(str);
                try {
                    hashMap.put("tempVideoPath", c.a.o0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f4530f));
                    hashMap.put("tempThumbPath", c.a.o0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f4530f));
                    c.a.o0.a.z.a.b().i(31000, new C0475d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e2) {
                    e = e2;
                    c.a.o0.a.z.a.b().e(bVar.f4630g, bVar.f4629f, false);
                    if (a0.f4738b) {
                        e.printStackTrace();
                    }
                    c.a.o0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
                    k(unitedSchemeEntity, callbackHandler, z);
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            k(unitedSchemeEntity, callbackHandler, z);
        }
    }
}
