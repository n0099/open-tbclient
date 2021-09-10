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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9868e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9869f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9870g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9871h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.b f9872i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9873j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
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
            this.f9868e = callbackHandler;
            this.f9869f = unitedSchemeEntity;
            this.f9870g = context;
            this.f9871h = eVar;
            this.f9872i = bVar;
            this.f9873j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.l.r(this.f9870g, this.f9869f, this.f9868e, this.f9871h, this.f9872i, this.f9873j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    String str = "authorize recorder failed : " + c.a.p0.a.e2.c.d.f(b2);
                    UnitedSchemeUtility.callCallback(this.f9868e, this.f9869f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                    c.a.p0.a.e0.d.l("SwanAppAction", str);
                } else {
                    c.a.p0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9874e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9875f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9876g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9877h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.b f9878i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9879j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public b(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
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
            this.f9874e = unitedSchemeEntity;
            this.f9875f = callbackHandler;
            this.f9876g = context;
            this.f9877h = eVar;
            this.f9878i = bVar;
            this.f9879j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.l.t(this.f9876g, this.f9874e, this.f9875f, this.f9877h, this.f9878i, this.f9879j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    this.l.s(iVar.b(), this.f9874e, this.f9875f);
                } else {
                    c.a.p0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9880a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9881b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f9882c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9883d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.b f9884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9885f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f9886g;

        public c(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, CameraPreview cameraPreview, c.a.p0.a.z.e.b bVar, String str) {
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
            this.f9886g = dVar;
            this.f9880a = unitedSchemeEntity;
            this.f9881b = callbackHandler;
            this.f9882c = eVar;
            this.f9883d = cameraPreview;
            this.f9884e = bVar;
            this.f9885f = str;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9886g.w(this.f9880a, this.f9881b, this.f9882c, this.f9883d, this.f9884e, this.f9885f);
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f9886g.s(10005, this.f9880a, this.f9881b);
            }
        }
    }

    /* renamed from: c.a.p0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0477d implements c.a.p0.a.z.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f9887a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9888b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9889c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f9890d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f9891e;

        public C0477d(d dVar, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
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
            this.f9891e = dVar;
            this.f9887a = cameraPreview;
            this.f9888b = unitedSchemeEntity;
            this.f9889c = callbackHandler;
            this.f9890d = hashMap;
        }

        @Override // c.a.p0.a.z.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9887a.stopRecording();
                this.f9887a.clearSaveMediaPath();
                this.f9891e.u(this.f9888b, this.f9889c, this.f9890d);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // c.a.p0.a.z.c.b
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9887a.stopRecording();
                this.f9887a.clearSaveMediaPath();
                this.f9891e.u(this.f9888b, this.f9889c, this.f9890d);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.p0.a.c2.e eVar) {
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
            c.a.p0.a.z.e.b bVar = (c.a.p0.a.z.e.b) v(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            c.a.p0.a.c0.c.c.a aVar = (c.a.p0.a.c0.c.c.a) c.a.p0.a.c0.d.a.a(bVar);
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
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
        }
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + c.a.p0.a.e2.c.d.f(i2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
            c.a.p0.a.e0.d.l("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, c.a.p0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            if (c.a.p0.a.z.a.b().c(context) && c.a.p0.a.z.a.b().d(context)) {
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
                return;
            }
            c.a.p0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public c.a.p0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.z.e.b(l(unitedSchemeEntity)) : (c.a.p0.a.c0.b.b) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar, CameraPreview cameraPreview, c.a.p0.a.z.e.b bVar, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str}) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.startRecording(str);
                try {
                    hashMap.put("tempVideoPath", c.a.p0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f4558f));
                    hashMap.put("tempThumbPath", c.a.p0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f4558f));
                    c.a.p0.a.z.a.b().i(31000, new C0477d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e2) {
                    e = e2;
                    c.a.p0.a.z.a.b().e(bVar.f4658g, bVar.f4657f, false);
                    if (a0.f4766b) {
                        e.printStackTrace();
                    }
                    c.a.p0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
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
