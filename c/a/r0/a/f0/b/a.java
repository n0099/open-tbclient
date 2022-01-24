package c.a.r0.a.f0.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.a.r0.a.f2.e;
import c.a.r0.a.f2.f.z;
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
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f5939c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/setPhoneContact");
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

    @SuppressLint({"BDOfflineUrl"})
    private void insert(Context context, c.a.r0.a.f0.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, context, aVar, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
            intent.putExtra("name", aVar.d());
            intent.putExtra("email", aVar.r);
            intent.putParcelableArrayListExtra("data", k(aVar));
            intent.setFlags(268435456);
            l(context, intent, callbackHandler);
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (context != null && callbackHandler != null && eVar != null) {
                if (eVar.m0()) {
                    boolean z = z.f6343b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (z.f6343b) {
                    String str = "handle params:" + optParamsAsJo;
                }
                String optString = optParamsAsJo.optString("action");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                c.a.r0.a.f0.a a = c.a.r0.a.f0.a.a(optParamsAsJo);
                if (!a.t()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                this.f5939c = optParamsAsJo.optString("cb");
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -1183792455) {
                    if (hashCode == 3108362 && optString.equals("edit")) {
                        c2 = 1;
                    }
                } else if (optString.equals("insert")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    insert(context, a, callbackHandler);
                    return true;
                } else if (c2 != 1) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    j(context, a, callbackHandler);
                    return true;
                }
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context, c.a.r0.a.f0.a aVar, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, callbackHandler) == null) {
            Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
            intent.setType("vnd.android.cursor.item/contact");
            intent.putExtra("name", aVar.d());
            intent.putExtra("email", aVar.r);
            intent.putParcelableArrayListExtra("data", k(aVar));
            intent.setFlags(268435456);
            l(context, intent, callbackHandler);
        }
    }

    public final ArrayList<ContentValues> k(c.a.r0.a.f0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            ArrayList<ContentValues> arrayList = new ArrayList<>(16);
            arrayList.add(aVar.j());
            arrayList.add(aVar.h());
            arrayList.add(aVar.s());
            arrayList.add(aVar.i());
            arrayList.add(aVar.g());
            arrayList.add(aVar.r());
            arrayList.add(aVar.k());
            arrayList.add(aVar.o());
            arrayList.add(aVar.n());
            arrayList.add(aVar.m());
            arrayList.add(aVar.l());
            arrayList.add(aVar.b());
            arrayList.add(aVar.p());
            arrayList.add(aVar.e());
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void l(Context context, Intent intent, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, intent, callbackHandler) == null) {
            try {
                context.startActivity(intent);
                if (TextUtils.isEmpty(this.f5939c)) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(this.f5939c, UnitedSchemeUtility.wrapCallbackParams(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG).toString());
            } catch (Exception e2) {
                if (z.f6343b) {
                    String str = "startContactActivity:" + e2.toString();
                }
                if (TextUtils.isEmpty(this.f5939c)) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(this.f5939c, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
            }
        }
    }
}
