package c.a.q0.a.h2.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.h2.c.j.b;
import c.a.q0.a.k;
import c.a.q0.a.n2.c;
import c.a.q0.a.n2.n;
import c.a.q0.a.z2.q0;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, C0363d> f6536b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6537e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6537e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context e2 = d.e();
                Toast.makeText(e2, "aiapps-oauth :: " + this.f6537e, 0).show();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6538e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6538e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (i2 == -2) {
                    d.k("onNegBtn", Boolean.FALSE);
                    n.q("click", this.f6538e.f6544b, false);
                    d.d(this.f6538e.f6544b, false);
                } else if (i2 == -1) {
                    d.k("onPosBtn", Boolean.FALSE);
                    n.q("click", this.f6538e.f6544b, true);
                    d.d(this.f6538e.f6544b, true);
                }
                c.a.q0.a.c1.b.n().a("na_authorize_end");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6539e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6539e = fVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                d.k("onCancel", Boolean.FALSE);
                n.q("click", this.f6539e.f6544b, false);
                d.d(this.f6539e.f6544b, false);
            }
        }
    }

    /* renamed from: c.a.q0.a.h2.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0363d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<c.a.q0.a.h2.c.a> a;

        public C0363d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashSet();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273090608, "Lc/a/q0/a/h2/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273090608, "Lc/a/q0/a/h2/c/d;");
                return;
            }
        }
        a = k.a;
        f6536b = new HashMap();
    }

    public static RequestBody b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    key = "";
                }
                if (TextUtils.isEmpty(value)) {
                    value = "";
                }
                if (a) {
                    k("query :: " + key + " = " + value, Boolean.FALSE);
                }
                builder.add(key, value);
            }
            return builder.build();
        }
        return (RequestBody) invokeL.objValue;
    }

    public static JSONObject c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            String C = c.a.q0.a.c1.a.o().C();
            return (jSONObject == null || TextUtils.isEmpty(C)) ? jSONObject : jSONObject.optJSONObject(C);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void d(String str, boolean z) {
        C0363d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            synchronized (f6536b) {
                remove = f6536b.remove(str);
            }
            if (remove == null || remove.a.isEmpty()) {
                return;
            }
            for (c.a.q0.a.h2.c.a aVar : remove.a) {
                if (aVar != null) {
                    aVar.onResult(z);
                }
            }
        }
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static String f(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            switch (i2) {
                case 10001:
                    str = "internal error";
                    break;
                case 10002:
                    str = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
                    break;
                case 10003:
                    str = "user deny";
                    break;
                case 10004:
                    str = "user not logged in";
                    break;
                case 10005:
                    str = "system deny";
                    break;
                case 10006:
                    str = "no data";
                    break;
                default:
                    str = "Permission denied";
                    break;
            }
            if (a) {
                String str2 = i2 + " " + str;
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String g() {
        InterceptResult invokeV;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                PackageInfo packageInfo = e().getPackageManager().getPackageInfo(e().getPackageName(), 64);
                return (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? "" : c.a.q0.w.f.d(signatureArr[0].toByteArray(), false);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean h(i<b.e> iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iVar)) == null) ? iVar != null && iVar.c() && iVar.a.f6597b : invokeL.booleanValue;
    }

    public static boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), RetrieveTaskManager.KEY);
        }
        return invokeL.booleanValue;
    }

    public static boolean j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
        }
        return invokeL.booleanValue;
    }

    public static void k(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, bool) == null) {
            c.a.q0.a.e0.d.k("aiapps-oauth", str);
            if (a && bool.booleanValue()) {
                q0.a0(new a(str));
            }
        }
    }

    @Deprecated
    public static void l(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, runnable) == null) {
            q0.a0(runnable);
        }
    }

    public static synchronized void m(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, jSONObject) == null) {
            synchronized (d.class) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("code")) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject.put("data", jSONObject2);
                    } catch (JSONException e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void n(c.a.q0.a.h2.d.a aVar, CallbackHandler callbackHandler, String str) {
        c.a.q0.a.u2.a aVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, null, aVar, callbackHandler, str) == null) || aVar == null || (aVar2 = aVar.f6617j) == null) {
            return;
        }
        int i2 = -1;
        try {
            i2 = (int) aVar2.a();
        } catch (ClassCastException e2) {
            if (a) {
                e2.toString();
            }
        }
        if (i2 < 0) {
            return;
        }
        o(i2, callbackHandler, str);
    }

    public static void o(int i2, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65551, null, i2, callbackHandler, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String f2 = f(i2);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, f2).toString());
        c.a.q0.a.e0.d.o("OAuthUtils", "authorize failed : " + f2);
    }

    public static void p(i<b.e> iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, iVar, callbackHandler, unitedSchemeEntity) == null) {
            if (iVar != null && iVar.a() != null) {
                int b2 = iVar.b();
                String f2 = f(b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f2));
                c.a.q0.a.e0.d.o("OAuthUtils", "authorize failed : " + f2);
                return;
            }
            c.a.q0.a.e0.d.c("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void q(i<b.e> iVar, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, iVar, callbackHandler, str) == null) {
            if (iVar != null && iVar.a() != null) {
                o(iVar.b(), callbackHandler, str);
            } else {
                c.a.q0.a.e0.d.c("OAuthUtils", "authorize failed : result is invalid");
            }
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            f6536b.clear();
        }
    }

    public static void s(int i2, @NonNull String str, @NonNull String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65555, null, i2, str, str2) == null) {
            try {
                String f0 = c.a.q0.a.d2.e.f0();
                if (TextUtils.isEmpty(f0)) {
                    f0 = "NotSwanAppProcess";
                }
                String str4 = str + "===";
                if (str2.length() > 1024) {
                    str3 = (str4 + str2.substring(0, 1024)) + "...";
                } else {
                    str3 = str4 + str2;
                }
                c.b bVar = new c.b(i2);
                bVar.h(f0);
                bVar.i(str3);
                bVar.m();
                c.a.q0.a.e0.d.k("OAuthUtils", "error reported: " + i2 + " ,content: " + str3);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static synchronized void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (d.class) {
                s(10004, str, str2);
            }
        }
    }

    public static void u(Context context, c.a.q0.a.d2.e eVar, f fVar, JSONObject jSONObject, c.a.q0.a.h2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65557, null, context, eVar, fVar, jSONObject, aVar) == null) {
            if (fVar != null && !TextUtils.isEmpty(fVar.f6544b)) {
                synchronized (f6536b) {
                    C0363d c0363d = f6536b.get(fVar.f6544b);
                    if (c0363d != null) {
                        c0363d.a.add(aVar);
                        return;
                    }
                    C0363d c0363d2 = new C0363d(fVar.f6544b);
                    c0363d2.a.add(aVar);
                    f6536b.put(fVar.f6544b, c0363d2);
                    b bVar = new b(fVar);
                    c cVar = new c(fVar);
                    n.q("show", fVar.f6544b, false);
                    c.a.q0.a.c1.b.n().a("na_authorize_start");
                    v(context, eVar, fVar, jSONObject, bVar, cVar);
                    return;
                }
            }
            aVar.onResult(false);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void v(Context context, c.a.q0.a.d2.e eVar, f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, eVar, fVar, jSONObject, onClickListener, onCancelListener}) == null) {
            SwanAppAlertDialog.a a2 = c.a.q0.a.c1.a.i0().a(context, eVar, fVar, jSONObject, onClickListener);
            if (a2 == null) {
                if (a) {
                    throw new RuntimeException("auth dialog builder is null");
                }
                return;
            }
            SwanAppAlertDialog c2 = a2.c();
            c2.setEnableImmersion(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setWindowAnimations(c.a.q0.a.i.action_sheet_animation);
            }
            SwanAppActivity x = eVar == null ? null : eVar.x();
            if (x == null || x.isFinishing()) {
                return;
            }
            c2.show();
        }
    }
}
