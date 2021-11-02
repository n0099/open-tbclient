package b.a.p0.a.i1.h.d;

import android.content.Context;
import b.a.p0.a.c2.f.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public a f6211c;

    /* renamed from: d  reason: collision with root package name */
    public e f6212d;

    /* renamed from: e  reason: collision with root package name */
    public d f6213e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/vrvideo");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            b.a.p0.a.e0.d.a("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        char c2;
        boolean c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            b.a.p0.a.e0.d.a("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", a0.a(unitedSchemeEntity, "params"));
            int hashCode = str.hashCode();
            if (hashCode == 533456719) {
                if (str.equals("/swanAPI/vrvideo/open")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 1626770505) {
                if (hashCode == 1722535054 && str.equals("/swanAPI/vrvideo/update")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("/swanAPI/vrvideo/remove")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                if (this.f6211c == null) {
                    this.f6211c = new a("/swanAPI/vrvideo/open");
                }
                c3 = this.f6211c.c(context, unitedSchemeEntity, callbackHandler, eVar);
            } else if (c2 == 1) {
                if (this.f6212d == null) {
                    this.f6212d = new e("/swanAPI/vrvideo/update");
                }
                c3 = this.f6212d.c(context, unitedSchemeEntity, callbackHandler, eVar);
            } else if (c2 != 2) {
                c3 = false;
            } else {
                if (this.f6213e == null) {
                    this.f6213e = new d("/swanAPI/vrvideo/remove");
                }
                c3 = this.f6213e.c(context, unitedSchemeEntity, callbackHandler, eVar);
            }
            return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        return invokeLLLLL.booleanValue;
    }
}
