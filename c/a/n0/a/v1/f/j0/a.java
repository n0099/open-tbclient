package c.a.n0.a.v1.f.j0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.k.e.h.a;
import c.a.n0.a.k.e.h.b;
import c.a.n0.a.p2.g1.c;
import c.a.n0.a.t1.e;
import c.a.n0.a.u.d;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
public final class a extends z implements b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public CallbackHandler f6782c;

    /* renamed from: c.a.n0.a.v1.f.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0495a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.c f6783b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f6784c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f6785d;

        public C0495a(a aVar, CallbackHandler callbackHandler, a.c cVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, cVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6785d = aVar;
            this.a = callbackHandler;
            this.f6783b = cVar;
            this.f6784c = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f6785d.k(iVar, this.a, this.f6783b, this.f6784c.m0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/getLocation");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.k.e.h.b.c
    public void b(a.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i) == null) || this.f6782c == null) {
            return;
        }
        d.c("GetLocationAction", "request location error code : " + i);
        this.f6782c.handleSchemeDispatchCallback(cVar.f5093c, UnitedSchemeUtility.wrapCallbackParams(i).toString());
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6924b) {
                Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.f6782c = callbackHandler;
            if (eVar == null) {
                d.c("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            a.c b2 = a.c.b(unitedSchemeEntity.getParam("params"));
            if (b2 != null && b2.a()) {
                if (TextUtils.isEmpty(b2.f5093c)) {
                    d.c("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                eVar.d0().g(context, "mapp_location", new C0495a(this, callbackHandler, b2, eVar));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.c("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.n0.a.k.e.h.b.c
    public void f(a.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) == null) || (callbackHandler = this.f6782c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.f5093c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    @Override // c.a.n0.a.k.e.h.b.c
    public void g(a.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, bVar) == null) {
            if (z.f6924b) {
                Log.d("GetLocationAction", "convert info : " + bVar.a());
            }
            CallbackHandler callbackHandler = this.f6782c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.f5093c, UnitedSchemeUtility.wrapCallbackParams(bVar.a(), 0).toString());
        }
    }

    public final void k(i<b.e> iVar, CallbackHandler callbackHandler, a.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{iVar, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            d.i("GetLocationAction", "authorized result is " + iVar);
            if (c.a.n0.a.x1.c.d.h(iVar)) {
                c.a.n0.a.k.e.h.b.d().e(cVar, this, z);
                return;
            }
            int b2 = iVar.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.f5093c, UnitedSchemeUtility.wrapCallbackParams(b2, c.a.n0.a.x1.c.d.f(b2)).toString());
        }
    }
}
