package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cb2;
import com.repackage.du2;
import com.repackage.g32;
import com.repackage.hl2;
import com.repackage.mm2;
import com.repackage.xz1;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class SwanAppJsBridge extends hl2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, xz1 xz1Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, xz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unitedSchemeMainDispatcher, callbackHandler, xz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (UnitedSchemeMainDispatcher) objArr2[1], (CallbackHandler) objArr2[2], (xz1) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private String doSchemeDispatch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith(UnitedSchemeEntity.UNITED_SCHEME)) {
                UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(str));
                if (hl2.DEBUG) {
                    Log.d(TAG, "doSchemeDispatch scheme: " + str + " mCallbackHandler: " + this.mCallbackHandler);
                }
                SchemeTimeCostMoniter.getInstance().schemeStart(str);
                this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
                SchemeTimeCostMoniter.getInstance().schemeEnd(str);
                JSONObject jSONObject = unitedSchemeEntity.result;
                return jSONObject != null ? jSONObject.toString() : "";
            }
            return UnitedSchemeUtility.wrapCallbackParams(201).toString();
        }
        return (String) invokeL.objValue;
    }

    @JavascriptInterface
    public String dispatch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (g32.a(this.mJsContainer, str)) {
                return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
            }
            return doSchemeDispatch(str);
        }
        return (String) invokeL.objValue;
    }

    @JavascriptInterface
    public String setData(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (hl2.DEBUG) {
                Log.d(TAG, "slave id: " + str + " data: " + str2);
            }
            xz1 xz1Var = this.mJsContainer;
            if (g32.a(xz1Var, "setData - " + str2)) {
                return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
            }
            du2.a("postMessage", "PostMsg setData handle");
            int i = 0;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                i = 202;
            } else {
                cb2 cb2Var = new cb2(str, str2);
                du2.a("postMessage", "PostMsg setData start");
                mm2.U().y(cb2Var, false);
                du2.a("postMessage", "PostMsg setData end");
            }
            return UnitedSchemeUtility.wrapCallbackParams(i).toString();
        }
        return (String) invokeLL.objValue;
    }
}
