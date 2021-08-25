package c.a.o0.a.c2.f.k0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e0.d;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.u.e.i.a;
import c.a.o0.a.u.e.i.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class a extends a0 implements b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f4916c;

    /* renamed from: c.a.o0.a.c2.f.k0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0137a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.c f4918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4919g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f4920h;

        public C0137a(a aVar, CallbackHandler callbackHandler, a.c cVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, cVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4920h = aVar;
            this.f4917e = callbackHandler;
            this.f4918f = cVar;
            this.f4919g = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f4920h.k(iVar, this.f4917e, this.f4918f, this.f4919g.d0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getLocation");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.u.e.i.b.c
    public void b(a.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) || this.f4916c == null) {
            return;
        }
        d.b("GetLocationAction", "request location error code : " + i2);
        this.f4916c.handleSchemeDispatchCallback(cVar.f8918c, UnitedSchemeUtility.wrapCallbackParams(i2).toString());
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            this.f4916c = callbackHandler;
            if (eVar == null) {
                d.b("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            a.c b2 = a.c.b(unitedSchemeEntity.getParam("params"));
            if (b2 != null && b2.a()) {
                if (TextUtils.isEmpty(b2.f8918c)) {
                    d.b("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                eVar.T().g(context, "mapp_location", new C0137a(this, callbackHandler, b2, eVar));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.b("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.o0.a.u.e.i.b.c
    public void f(a.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) == null) || (callbackHandler = this.f4916c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.f8918c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    @Override // c.a.o0.a.u.e.i.b.c
    public void g(a.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, bVar) == null) {
            if (a0.f4738b) {
                String str = "convert info : " + bVar.a();
            }
            CallbackHandler callbackHandler = this.f4916c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.f8918c, UnitedSchemeUtility.wrapCallbackParams(bVar.a(), 0).toString());
        }
    }

    public final void k(i<b.e> iVar, CallbackHandler callbackHandler, a.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{iVar, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            d.g("GetLocationAction", "authorized result is " + iVar);
            if (c.a.o0.a.e2.c.d.h(iVar)) {
                c.a.o0.a.u.e.i.b.d().e(cVar, this, z);
                return;
            }
            int b2 = iVar.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.f8918c, UnitedSchemeUtility.wrapCallbackParams(b2, c.a.o0.a.e2.c.d.f(b2)).toString());
        }
    }
}
