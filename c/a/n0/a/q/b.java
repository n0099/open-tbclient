package c.a.n0.a.q;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.a.c2.e;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.e2.c.i;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.g1.f;
import c.a.n0.a.h0.g.g;
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
    public class a implements c.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7753e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7755g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f7756h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f7757i;

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
            this.f7757i = bVar;
            this.f7753e = callbackHandler;
            this.f7754f = unitedSchemeEntity;
            this.f7755g = str;
            this.f7756h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.e2.c.d.h(iVar)) {
                    c.a.n0.a.e2.c.d.o(iVar, this.f7753e, this.f7754f);
                    return;
                }
                String str = this.f7755g;
                this.f7757i.k(c.a.n0.a.l1.b.g(str, str), this.f7756h);
                c.a.n0.a.e0.d.g("AdLanding", "open adLanding page success");
                UnitedSchemeUtility.callCallback(this.f7753e, this.f7754f, 0);
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

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4492b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String o = c.a.n0.a.c2.f.p0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                c.a.n0.a.e0.d.g("AdLanding", "adLanding: url is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            g W = f.V().W();
            if (W == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            eVar.T().g(context, "mapp_i_open_adlanding", new a(this, callbackHandler, unitedSchemeEntity, o, W));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(c.a.n0.a.l1.b bVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, gVar) == null) {
            c.a.n0.a.e0.d.g("AdLanding", "openAdLanding: page url=" + bVar.f6964g);
            g.b i2 = gVar.i("adLanding");
            i2.n(g.f5654g, g.f5656i);
            i2.k("adLanding", bVar).b();
        }
    }
}
