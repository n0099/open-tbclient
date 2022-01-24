package c.a.r0.a.f2.f.i0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.c2.b.f.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.u.e.f.i;
import c.a.r0.a.z2.q0;
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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6148e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6149f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6150g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6151h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f6152i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ boolean f6153j;
        public final /* synthetic */ e k;

        public a(e eVar, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f6148e = context;
            this.f6149f = callbackHandler;
            this.f6150g = unitedSchemeEntity;
            this.f6151h = str;
            this.f6152i = i2;
            this.f6153j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.r(this.f6148e, this.f6149f, this.f6150g, this.f6151h, this.f6152i, this.f6153j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6155f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6156g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6157h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f6158i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Drawable f6159j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ e l;

        public b(e eVar, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, Drawable drawable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f6154e = context;
            this.f6155f = callbackHandler;
            this.f6156g = unitedSchemeEntity;
            this.f6157h = str;
            this.f6158i = i2;
            this.f6159j = drawable;
            this.k = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.l.p(this.f6154e, this.f6155f, this.f6156g, this.f6157h, this.f6158i, this.f6159j, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6160e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6161f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6162g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6163h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f6164i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ boolean f6165j;
        public final /* synthetic */ e k;

        public c(e eVar, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = eVar;
            this.f6160e = context;
            this.f6161f = callbackHandler;
            this.f6162g = unitedSchemeEntity;
            this.f6163h = str;
            this.f6164i = i2;
            this.f6165j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.q(this.f6160e, this.f6161f, this.f6162g, this.f6163h, this.f6164i, this.f6165j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6167f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6168g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6169h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f6170i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6171j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;

        public d(e eVar, Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = eVar;
            this.f6166e = context;
            this.f6167f = callbackHandler;
            this.f6168g = unitedSchemeEntity;
            this.f6169h = str;
            this.f6170i = i2;
            this.f6171j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.l.o(this.f6166e, this.f6167f, this.f6168g, this.f6169h, this.f6170i, this.f6171j, this.k);
            }
        }
    }

    /* renamed from: c.a.r0.a.f2.f.i0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0337e implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6172b;

        public C0337e(e eVar, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f6172b = callbackHandler;
        }

        @Override // c.a.r0.a.c2.b.f.e.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            this.f6172b.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/showToast");
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) != null) {
            return invokeLLLL.booleanValue;
        }
        if (eVar != null && eVar.m0()) {
            boolean z = z.f6343b;
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0) {
            String str = params.get("params");
            if (TextUtils.isEmpty(str)) {
                c.a.r0.a.e0.d.c("ShowToastAction", "the key params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("type", "1");
                int F = i.F(jSONObject);
                String optString2 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    c.a.r0.a.e0.d.c("ShowToastAction", "message is null");
                    return false;
                }
                boolean optBoolean = jSONObject.optBoolean("mask");
                String optString3 = jSONObject.optString("image", "-1");
                if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(eVar).getPath())) {
                    optString3 = q0.w(eVar, optString3);
                }
                Drawable L = i.L(context, optString3, eVar);
                if (z.f6343b) {
                    String str2 = "imagepath = " + optString3;
                }
                if (!TextUtils.equals(optString3, "-1") && L == null && TextUtils.equals(optString, "2")) {
                    optString = "1";
                }
                String optString4 = jSONObject.optString("cb");
                String optString5 = jSONObject.optString("buttonText");
                switch (optString.hashCode()) {
                    case 49:
                        if (optString.equals("1")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 50:
                        if (optString.equals("2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51:
                        if (optString.equals("3")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 52:
                        if (optString.equals("4")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                try {
                    if (c2 == 0) {
                        q0.e0(new a(this, context, callbackHandler, unitedSchemeEntity, optString2, F, optBoolean));
                    } else if (c2 == 1) {
                        q0.e0(new b(this, context, callbackHandler, unitedSchemeEntity, optString2, F, L, optBoolean));
                    } else if (c2 == 2) {
                        q0.e0(new c(this, context, callbackHandler, unitedSchemeEntity, optString2, F, optBoolean));
                    } else if (c2 != 3) {
                        n(unitedSchemeEntity);
                        return false;
                    } else {
                        q0.e0(new d(this, context, callbackHandler, unitedSchemeEntity, optString2, F, optString5, optString4));
                    }
                    return true;
                } catch (JSONException e2) {
                    e = e2;
                    if (z.f6343b) {
                        e.printStackTrace();
                    }
                    c.a.r0.a.e0.d.c("ShowToastAction", "json exception");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            c.a.r0.a.e0.d.c("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity) == null) {
            boolean z = z.f6343b;
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        }
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, @NonNull String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), str2, str3}) == null) {
            c.a.r0.a.c2.b.f.e e2 = c.a.r0.a.c2.b.f.e.e(context);
            e2.r(str);
            e2.k(str2);
            e2.l(i2);
            e2.u(new C0337e(this, str3, callbackHandler));
            e2.w();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void p(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)}) == null) {
            c.a.r0.a.c2.b.f.e g2 = c.a.r0.a.c2.b.f.e.g(context, i.H(str, 14));
            g2.n(drawable);
            g2.l(i2);
            g2.s(z);
            g2.B();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void q(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.a.r0.a.c2.b.f.e g2 = c.a.r0.a.c2.b.f.e.g(context, i.H(str, 14));
            g2.l(i2);
            g2.s(z);
            g2.z();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void r(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.a.r0.a.c2.b.f.e g2 = c.a.r0.a.c2.b.f.e.g(context, str);
            g2.l(i2);
            g2.s(z);
            g2.q(2);
            g2.G();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }
}
