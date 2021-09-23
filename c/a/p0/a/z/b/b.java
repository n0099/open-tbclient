package c.a.p0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
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
import i.j;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f9865c;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9867f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9868g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.a f9869h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f9870i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.z.e.a aVar) {
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
            this.f9870i = bVar;
            this.f9866e = callbackHandler;
            this.f9867f = unitedSchemeEntity;
            this.f9868g = context;
            this.f9869h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.e2.c.d.h(iVar)) {
                    this.f9870i.q(this.f9868g, this.f9867f, this.f9866e, this.f9869h);
                    return;
                }
                c.a.p0.a.e2.c.d.o(iVar, this.f9866e, this.f9867f);
                if (this.f9870i.f9865c != null) {
                    this.f9870i.f9865c.onError(new Throwable());
                } else {
                    c.a.p0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* renamed from: c.a.p0.a.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0476b implements c.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z.e.a f9872b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9874d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9875e;

        public C0476b(b bVar, Context context, c.a.p0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            this.f9875e = bVar;
            this.f9871a = context;
            this.f9872b = aVar;
            this.f9873c = unitedSchemeEntity;
            this.f9874d = callbackHandler;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f9875e.k(this.f9873c, this.f9874d, this.f9875e.p(this.f9871a, this.f9872b));
                c.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f9874d, this.f9873c, 10005);
                if (this.f9875e.f9865c != null) {
                    this.f9875e.f9865c.onError(new Throwable());
                } else {
                    c.a.p0.a.e0.d.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                c.a.p0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.a.c2.e eVar) {
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
            c.a.p0.a.z.e.a aVar = (c.a.p0.a.z.e.a) r(unitedSchemeEntity);
            j x = new c.a.p0.a.c0.c.c.a(context, aVar).x();
            this.f9865c = x;
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, aVar));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, c.a.p0.a.z.e.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar)) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction start");
            if (context != null && aVar != null) {
                String str = aVar.f4665f;
                c.a.p0.a.l1.e.a.a aVar2 = aVar.l;
                if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.k()) {
                    j jVar = this.f9865c;
                    if (jVar == null) {
                        c.a.p0.a.c0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    jVar.onCompleted();
                    c.a.p0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                sb.append(aVar2 == null);
                c.a.p0.a.e0.d.b("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            sb2.append(context == null);
            sb2.append(" ; model is null ? = ");
            sb2.append(aVar == null);
            c.a.p0.a.e0.d.b("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.z.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, aVar) == null) {
            c.a.p0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            c.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0476b(this, context, aVar, unitedSchemeEntity, callbackHandler));
        }
    }

    public c.a.p0.a.c0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new c.a.p0.a.z.e.a(l(unitedSchemeEntity)) : (c.a.p0.a.c0.b.b) invokeL.objValue;
    }
}
