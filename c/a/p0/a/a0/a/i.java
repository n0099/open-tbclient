package c.a.p0.a.a0.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/canvas/update");
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
                super((c.a.p0.a.f2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.p0.a.a0.b.a k2 = k(unitedSchemeEntity);
            if (k2 == null) {
                unitedSchemeEntity.result = l(201);
                c.a.p0.a.e0.d.c("SwanAppCanvas", "update action parse model is null");
                return false;
            }
            String str = k2.f4377f;
            c.a.p0.a.m1.e.a.a aVar = k2.l;
            if (!TextUtils.isEmpty(str) && aVar != null && aVar.i()) {
                c.a.p0.a.c0.c.d.a aVar2 = (c.a.p0.a.c0.c.d.a) c.a.p0.a.c0.d.a.a(k2);
                if (aVar2 == null) {
                    c.a.p0.a.e0.d.c("SwanAppCanvas", "update canvas fail: fina a null component");
                    unitedSchemeEntity.result = l(1001);
                    return false;
                }
                c.a.p0.a.c0.b.c update = aVar2.update((c.a.p0.a.c0.c.d.a) k2);
                boolean a = update.a();
                if (!a) {
                    c.a.p0.a.e0.d.c("SwanAppCanvas", "update canvas fail: " + update.f4383b);
                }
                j(unitedSchemeEntity, callbackHandler, a);
                return a;
            }
            c.a.p0.a.e0.d.c("SwanAppCanvas", "some params invalid");
            unitedSchemeEntity.result = l(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
