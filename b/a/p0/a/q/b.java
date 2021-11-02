package b.a.p0.a.q;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
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
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7327e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7328f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7329g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f7330h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f7331i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7331i = bVar;
            this.f7327e = callbackHandler;
            this.f7328f = unitedSchemeEntity;
            this.f7329g = str;
            this.f7330h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.e2.c.d.h(iVar)) {
                    b.a.p0.a.e2.c.d.o(iVar, this.f7327e, this.f7328f);
                    return;
                }
                String str = this.f7329g;
                this.f7331i.k(b.a.p0.a.l1.b.e(str, str), this.f7330h);
                b.a.p0.a.e0.d.g("AdLanding", "open adLanding page success");
                UnitedSchemeUtility.callCallback(this.f7327e, this.f7328f, 0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/openAdLandingPage");
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
            if (a0.f4160b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String o = b.a.p0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.g("AdLanding", "adLanding: url is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            g U = f.T().U();
            if (U == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.S().g(context, "mapp_i_open_adlanding", new a(this, callbackHandler, unitedSchemeEntity, o, U));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(b.a.p0.a.l1.b bVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, gVar) == null) {
            b.a.p0.a.e0.d.g("AdLanding", "openAdLanding: page url=" + bVar.f6557g);
            g.b i2 = gVar.i("adLanding");
            i2.n(g.f5280g, g.f5282i);
            i2.k("adLanding", bVar).b();
        }
    }
}
