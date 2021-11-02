package b.a.p0.a.c2.f.j0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.u.e.g.h;
import b.a.p0.a.v2.q0;
import b.a.p0.a.z1.b.f.e;
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
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4310f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4311g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4312h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4313i;
        public final /* synthetic */ boolean j;
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
            this.f4309e = context;
            this.f4310f = callbackHandler;
            this.f4311g = unitedSchemeEntity;
            this.f4312h = str;
            this.f4313i = i2;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.r(this.f4309e, this.f4310f, this.f4311g, this.f4312h, this.f4313i, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4315f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4316g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4317h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4318i;
        public final /* synthetic */ Drawable j;
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
            this.f4314e = context;
            this.f4315f = callbackHandler;
            this.f4316g = unitedSchemeEntity;
            this.f4317h = str;
            this.f4318i = i2;
            this.j = drawable;
            this.k = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.l.p(this.f4314e, this.f4315f, this.f4316g, this.f4317h, this.f4318i, this.j, this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4321g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4322h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4323i;
        public final /* synthetic */ boolean j;
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
            this.f4319e = context;
            this.f4320f = callbackHandler;
            this.f4321g = unitedSchemeEntity;
            this.f4322h = str;
            this.f4323i = i2;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.k.q(this.f4319e, this.f4320f, this.f4321g, this.f4322h, this.f4323i, this.j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4325f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4326g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4327h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f4328i;
        public final /* synthetic */ String j;
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
            this.f4324e = context;
            this.f4325f = callbackHandler;
            this.f4326g = unitedSchemeEntity;
            this.f4327h = str;
            this.f4328i = i2;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.l.o(this.f4324e, this.f4325f, this.f4326g, this.f4327h, this.f4328i, this.j, this.k);
            }
        }
    }

    /* renamed from: b.a.p0.a.c2.f.j0.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0133e implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4329a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4330b;

        public C0133e(e eVar, String str, CallbackHandler callbackHandler) {
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
            this.f4329a = str;
            this.f4330b = callbackHandler;
        }

        @Override // b.a.p0.a.z1.b.f.e.c
        public void onToastClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f4329a)) {
                return;
            }
            this.f4330b.handleSchemeDispatchCallback(this.f4329a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b.a.p0.a.c2.e eVar) {
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) != null) {
            return invokeLLLL.booleanValue;
        }
        if (eVar != null && eVar.c0()) {
            boolean z = a0.f4160b;
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0) {
            String str = params.get("params");
            if (TextUtils.isEmpty(str)) {
                b.a.p0.a.e0.d.b("ShowToastAction", "the key params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("type", "1");
                int y = h.y(jSONObject);
                String optString2 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    b.a.p0.a.e0.d.b("ShowToastAction", "message is null");
                    return false;
                }
                boolean optBoolean = jSONObject.optBoolean("mask");
                String optString3 = jSONObject.optString("image", "-1");
                if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(eVar).getPath())) {
                    optString3 = q0.w(eVar, optString3);
                }
                Drawable E = h.E(context, optString3, eVar);
                if (a0.f4160b) {
                    String str2 = "imagepath = " + optString3;
                }
                if (!TextUtils.equals(optString3, "-1") && E == null && TextUtils.equals(optString, "2")) {
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
                        q0.b0(new a(this, context, callbackHandler, unitedSchemeEntity, optString2, y, optBoolean));
                    } else if (c2 == 1) {
                        q0.b0(new b(this, context, callbackHandler, unitedSchemeEntity, optString2, y, E, optBoolean));
                    } else if (c2 == 2) {
                        q0.b0(new c(this, context, callbackHandler, unitedSchemeEntity, optString2, y, optBoolean));
                    } else if (c2 != 3) {
                        n(unitedSchemeEntity);
                        return false;
                    } else {
                        q0.b0(new d(this, context, callbackHandler, unitedSchemeEntity, optString2, y, optString5, optString4));
                    }
                    return true;
                } catch (JSONException e2) {
                    e = e2;
                    if (a0.f4160b) {
                        e.printStackTrace();
                    }
                    b.a.p0.a.e0.d.b("ShowToastAction", "json exception");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            b.a.p0.a.e0.d.b("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity) == null) {
            boolean z = a0.f4160b;
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        }
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, @NonNull String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), str2, str3}) == null) {
            b.a.p0.a.z1.b.f.e e2 = b.a.p0.a.z1.b.f.e.e(context);
            e2.q(str);
            e2.k(str2);
            e2.l(i2);
            e2.t(new C0133e(this, str3, callbackHandler));
            e2.v();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void p(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, h.A(str, 14));
            g2.n(drawable);
            g2.l(i2);
            g2.r(z);
            g2.A();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void q(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, h.A(str, 14));
            g2.l(i2);
            g2.r(z);
            g2.y();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void r(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, callbackHandler, unitedSchemeEntity, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, str);
            g2.l(i2);
            g2.r(z);
            g2.p(2);
            g2.F();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }
}
