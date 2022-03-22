package c.a.n0.a.p.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
/* loaded from: classes.dex */
public class g extends c.a.n0.a.p.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5712b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f5713c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f5714d;

        public a(g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5714d = gVar;
            this.a = unitedSchemeEntity;
            this.f5712b = callbackHandler;
            this.f5713c = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                c.a.n0.a.p.e.a aVar = (c.a.n0.a.p.e.a) this.f5714d.q(this.a);
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f5714d.p(this.f5713c, this.a, this.f5712b, aVar);
                    return;
                }
                c.a.n0.a.x1.c.d.p(iVar, this.f5712b, this.a);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5715b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5716c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f5717d;

        public b(g gVar, c.a.n0.a.p.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5717d = gVar;
            this.a = aVar;
            this.f5715b = unitedSchemeEntity;
            this.f5716c = callbackHandler;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5717d.k(this.f5715b, this.f5716c, this.f5717d.o(this.a));
                c.a.n0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.f5716c, this.f5715b, 10005);
                c.a.n0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/camera/update");
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
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.n0.a.u.d.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, unitedSchemeEntity, callbackHandler, context));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(c.a.n0.a.p.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            c.a.n0.a.u.d.i("SwanAppCameraManager", "handle update camera instruction start");
            if (aVar == null) {
                c.a.n0.a.u.d.c("SwanAppCameraManager", "Model is null");
                return false;
            }
            String str = aVar.f6096b;
            c.a.n0.a.c1.e.a.a aVar2 = aVar.f6102h;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.h()) {
                c.a.n0.a.s.c.c.a aVar3 = (c.a.n0.a.s.c.c.a) c.a.n0.a.s.d.a.a(aVar);
                if (aVar3 == null) {
                    c.a.n0.a.u.d.c("SwanAppCameraManager", "update camera with a null component");
                    return false;
                }
                c.a.n0.a.s.b.c update = aVar3.update((c.a.n0.a.s.c.c.a) aVar);
                boolean a2 = update.a();
                if (!a2) {
                    c.a.n0.a.u.d.c("SwanAppCameraManager", "update camera fail: " + update.f6103b);
                }
                return a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            c.a.n0.a.u.d.c("SwanAppCameraManager", sb.toString());
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.p.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, aVar) == null) {
            c.a.n0.a.u.d.i("SwanAppCameraManager", "handleAuthorized start");
            c.a.n0.a.l1.e.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 100, context, new b(this, aVar, unitedSchemeEntity, callbackHandler));
        }
    }

    public c.a.n0.a.s.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.n0.a.p.e.a(l(unitedSchemeEntity)) : (c.a.n0.a.s.b.b) invokeL.objValue;
    }
}
