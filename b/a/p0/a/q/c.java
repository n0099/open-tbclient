package b.a.p0.a.q;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
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
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7878f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7879g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f7880h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f7881i;

        public a(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, unitedSchemeEntity, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7881i = cVar;
            this.f7877e = callbackHandler;
            this.f7878f = unitedSchemeEntity;
            this.f7879g = str;
            this.f7880h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.h2.c.d.h(iVar)) {
                    b.a.p0.a.h2.c.d.p(iVar, this.f7877e, this.f7878f);
                } else {
                    this.f7881i.k(this.f7879g, this.f7880h, this.f7877e, this.f7878f);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f5228b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
            }
            String o = b.a.p0.a.f2.f.o0.a.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                b.a.p0.a.e0.d.i("AdLanding", "adLanding: url is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            g V = f.U().V();
            if (V == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals(b.a.p0.a.f2.f.o0.a.n(unitedSchemeEntity, "params", "invokeFrom"), "boxjs")) {
                k(o, V, callbackHandler, unitedSchemeEntity);
                return true;
            } else {
                eVar.d0().g(context, "mapp_i_open_adlanding", new a(this, callbackHandler, unitedSchemeEntity, o, V));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(b.a.p0.a.m1.b bVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, gVar) == null) {
            b.a.p0.a.e0.d.i("AdLanding", "openAdLanding: page url=" + bVar.f7016g);
            g.b i2 = gVar.i("adLanding");
            i2.n(g.f5478g, g.f5480i);
            i2.k("adLanding", bVar).b();
        }
    }

    public void k(String str, g gVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, gVar, callbackHandler, unitedSchemeEntity) == null) {
            j(b.a.p0.a.m1.b.e(str, str), gVar);
            b.a.p0.a.e0.d.i("AdLanding", "open adLanding page success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
    }
}
