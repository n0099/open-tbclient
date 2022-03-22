package c.a.n0.a.q.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/canvas/remove");
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
            c.a.n0.a.q.b.a k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                c.a.n0.a.u.d.c("SwanAppCanvas", "remove action parse model is null");
                return false;
            }
            c.a.n0.a.s.c.d.a aVar = (c.a.n0.a.s.c.d.a) c.a.n0.a.s.d.a.a(k);
            if (aVar == null) {
                c.a.n0.a.u.d.c("SwanAppCanvas", "remove canvas fail: fina a null component");
                unitedSchemeEntity.result = l(1001);
                return false;
            }
            c.a.n0.a.s.b.c B = aVar.B();
            boolean a = B.a();
            if (!a) {
                c.a.n0.a.u.d.c("SwanAppCanvas", "remove canvas fail: " + B.f6103b);
            }
            j(unitedSchemeEntity, callbackHandler, a);
            return a;
        }
        return invokeLLLL.booleanValue;
    }
}
