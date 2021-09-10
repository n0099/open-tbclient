package c.a.p0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.e2.c.i;
import c.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class g extends c.a.p0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f9926h;

        public a(g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9926h = gVar;
            this.f9923e = unitedSchemeEntity;
            this.f9924f = callbackHandler;
            this.f9925g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.p0.a.z.e.a aVar = (c.a.p0.a.z.e.a) this.f9926h.q(this.f9923e);
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f9926h.p(this.f9925g, this.f9923e, this.f9924f, aVar);
                    return;
                }
                c.a.p0.a.e2.c.d.o(iVar, this.f9924f, this.f9923e);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.a f9927a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9929c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f9930d;

        public b(g gVar, c.a.p0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9930d = gVar;
            this.f9927a = aVar;
            this.f9928b = unitedSchemeEntity;
            this.f9929c = callbackHandler;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9930d.k(this.f9928b, this.f9929c, this.f9930d.o(this.f9927a));
                c.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f9929c, this.f9928b, 10005);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/update");
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
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, unitedSchemeEntity, callbackHandler, context));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(c.a.p0.a.z.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "handle update camera instruction start");
            if (aVar == null) {
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "Model is null");
                return false;
            }
            String str = aVar.f4657f;
            c.a.p0.a.l1.e.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.k()) {
                c.a.p0.a.c0.c.c.a aVar3 = (c.a.p0.a.c0.c.c.a) c.a.p0.a.c0.d.a.a(aVar);
                if (aVar3 == null) {
                    c.a.p0.a.e0.d.b("SwanAppCameraManager", "update camera with a null component");
                    return false;
                }
                c.a.p0.a.c0.b.c G = aVar3.G(aVar);
                boolean a2 = G.a();
                if (!a2) {
                    c.a.p0.a.e0.d.b("SwanAppCameraManager", "update camera fail: " + G.f4663b);
                }
                return a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            c.a.p0.a.e0.d.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.z.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, aVar) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            c.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(this, aVar, unitedSchemeEntity, callbackHandler));
        }
    }

    public c.a.p0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.z.e.a(l(unitedSchemeEntity)) : (c.a.p0.a.c0.b.b) invokeL.objValue;
    }
}
