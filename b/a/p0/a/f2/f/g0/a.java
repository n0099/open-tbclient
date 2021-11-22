package b.a.p0.a.f2.f.g0;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.c.d;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f4960c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f4961d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.f2.f.g0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0175a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4963f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f4965h;

        public C0175a(a aVar, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4965h = aVar;
            this.f4962e = callbackHandler;
            this.f4963f = str;
            this.f4964g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f4965h.k(this.f4964g, this.f4962e, this.f4963f);
                } else {
                    d.q(iVar, this.f4962e, this.f4963f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4966a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4968c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4966a = callbackHandler;
            this.f4967b = unitedSchemeEntity;
            this.f4968c = str;
        }

        @Override // b.a.p0.a.f2.f.g0.a.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null && jSONObject.length() != 0) {
                    b.a.p0.a.e0.d.i("history", "get history :" + jSONObject.toString());
                    UnitedSchemeUtility.safeCallback(this.f4966a, this.f4967b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f4968c);
                    return;
                }
                b.a.p0.a.e0.d.i("history", "none history");
                UnitedSchemeUtility.safeCallback(this.f4966a, this.f4967b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), this.f4968c);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(181061162, "Lb/a/p0/a/f2/f/g0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(181061162, "Lb/a/p0/a/f2/f/g0/a;");
                return;
            }
        }
        f4960c = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
        f4961d = SchemeConfig.getSchemeHead() + "://swangame/%s";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/getHistory");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                b.a.p0.a.e0.d.c("history", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                boolean z = z.f5228b;
                return false;
            }
            String optString = w.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.c("history", "none cb");
                boolean z2 = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.d0().g(context, "mapp_i_get_history", new C0175a(this, callbackHandler, optString, unitedSchemeEntity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, str) == null) {
            b.a.p0.a.e0.d.i("history", "start get history");
            b.a.p0.a.j0.c.b.j(new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
