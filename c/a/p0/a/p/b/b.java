package c.a.p0.a.p.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
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
import i.j;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.p.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f6729c;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6731f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6732g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.a f6733h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f6734i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.p.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6734i = bVar;
            this.f6730e = callbackHandler;
            this.f6731f = unitedSchemeEntity;
            this.f6732g = context;
            this.f6733h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f6734i.q(this.f6732g, this.f6731f, this.f6730e, this.f6733h);
                    return;
                }
                c.a.p0.a.x1.c.d.p(iVar, this.f6730e, this.f6731f);
                if (this.f6734i.f6729c != null) {
                    this.f6734i.f6729c.onError(new Throwable());
                } else {
                    c.a.p0.a.u.d.c("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                c.a.p0.a.u.d.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* renamed from: c.a.p0.a.p.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0418b implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.a f6736f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6737g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6738h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f6739i;

        public C0418b(b bVar, Context context, c.a.p0.a.p.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, aVar, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6739i = bVar;
            this.f6735e = context;
            this.f6736f = aVar;
            this.f6737g = unitedSchemeEntity;
            this.f6738h = callbackHandler;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f6739i.k(this.f6737g, this.f6738h, this.f6739i.p(this.f6735e, this.f6736f));
                c.a.p0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f6738h, this.f6737g, 10005);
                if (this.f6739i.f6729c != null) {
                    this.f6739i.f6729c.onError(new Throwable());
                } else {
                    c.a.p0.a.u.d.c("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                c.a.p0.a.u.d.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/camera/insert");
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
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            c.a.p0.a.p.e.a aVar = (c.a.p0.a.p.e.a) r(unitedSchemeEntity);
            j w = new c.a.p0.a.s.c.c.a(context, aVar).w();
            this.f6729c = w;
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.u.d.c("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            eVar.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, aVar));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, c.a.p0.a.p.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar)) == null) {
            c.a.p0.a.u.d.i("SwanAppCameraManager", "handle insert camera instruction start");
            if (context != null && aVar != null) {
                String str = aVar.f7283f;
                c.a.p0.a.c1.e.a.a aVar2 = aVar.l;
                if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                    j jVar = this.f6729c;
                    if (jVar == null) {
                        c.a.p0.a.s.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    jVar.onCompleted();
                    c.a.p0.a.u.d.i("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                sb.append(aVar2 == null);
                c.a.p0.a.u.d.c("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            sb2.append(context == null);
            sb2.append(" ; model is null ? = ");
            sb2.append(aVar == null);
            c.a.p0.a.u.d.c("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.p.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, aVar) == null) {
            c.a.p0.a.u.d.i("SwanAppCameraManager", "handleAuthorized start");
            c.a.p0.a.l1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0418b(this, context, aVar, unitedSchemeEntity, callbackHandler));
        }
    }

    public c.a.p0.a.s.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.p.e.a(l(unitedSchemeEntity)) : (c.a.p0.a.s.b.b) invokeL.objValue;
    }
}
