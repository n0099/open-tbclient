package c.a.o0.a.c2.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f4941a;

        public a(o oVar, Activity activity, Uri uri, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, activity, uri, str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4941a = activity;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/openDocument");
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            } else if (eVar.d0()) {
                boolean z = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                    return false;
                }
                String optString = a2.optString("filePath");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal filePath");
                    return false;
                }
                String V = c.a.o0.a.a2.e.V();
                if (TextUtils.isEmpty(V)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                    return false;
                }
                String M = c.a.o0.a.k2.b.M(optString, V);
                if (TextUtils.isEmpty(M)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
                    return false;
                }
                String optString2 = a2.optString("fileType");
                String s = c.a.o0.t.d.s(M);
                if (!TextUtils.isEmpty(s)) {
                    optString2 = s;
                } else if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
                    return false;
                }
                String b2 = c.a.o0.a.v2.n.b(optString2);
                if (TextUtils.isEmpty(b2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
                    return false;
                }
                Uri parse = Uri.parse(M);
                if (parse == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
                    return false;
                }
                Uri fromFile = parse.getScheme() == null ? Uri.fromFile(new File(M)) : parse;
                SwanAppActivity x = eVar.x();
                if (x == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
                    return false;
                } else if (!c.a.o0.a.v2.n.a(b2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + b2);
                    return false;
                } else {
                    String optString3 = a2.optString("cb");
                    c.a.o0.a.p.d.d0 r = c.a.o0.a.c1.a.r();
                    if (!r.b(x, b2)) {
                        if (TextUtils.isEmpty(optString3)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + b2);
                            return false;
                        }
                        j(x, b2, fromFile, optString3, callbackHandler);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    r.c(x, fromFile, b2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Activity activity, String str, Uri uri, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, uri, str2, callbackHandler) == null) {
            c.a.o0.a.c1.a.r().a(activity, str, new a(this, activity, uri, str, callbackHandler, str2));
        }
    }
}
