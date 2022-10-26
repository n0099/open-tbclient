package com.baidu.swan.apps.jsbridge;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.k22;
import com.baidu.tieba.pd2;
import com.baidu.tieba.qw2;
import com.baidu.tieba.t52;
import com.baidu.tieba.un2;
import com.baidu.tieba.zo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppJsBridge extends un2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_aiapps_jsbridge";
    public static final String TAG = "SwanAppJsBridge";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppJsBridge(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, k22 k22Var) {
        super(context, unitedSchemeMainDispatcher, callbackHandler, k22Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unitedSchemeMainDispatcher, callbackHandler, k22Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (UnitedSchemeMainDispatcher) objArr2[1], (CallbackHandler) objArr2[2], (k22) objArr2[3]);
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
                if (un2.DEBUG) {
                    Log.d(TAG, "doSchemeDispatch scheme: " + str + " mCallbackHandler: " + this.mCallbackHandler);
                }
                SchemeTimeCostMoniter.getInstance().schemeStart(str);
                this.mMainDispatcher.dispatch(getDispatchContext(), unitedSchemeEntity, this.mCallbackHandler);
                SchemeTimeCostMoniter.getInstance().schemeEnd(str);
                JSONObject jSONObject = unitedSchemeEntity.result;
                if (jSONObject != null) {
                    return jSONObject.toString();
                }
                return "";
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
            if (t52.a(this.mJsContainer, str)) {
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
            if (un2.DEBUG) {
                Log.d(TAG, "slave id: " + str + " data: " + str2);
            }
            k22 k22Var = this.mJsContainer;
            if (t52.a(k22Var, "setData - " + str2)) {
                return UnitedSchemeUtility.wrapCallbackParams(1001).toString();
            }
            qw2.a("postMessage", "PostMsg setData handle");
            int i = 0;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                pd2 pd2Var = new pd2(str, str2);
                qw2.a("postMessage", "PostMsg setData start");
                zo2.U().y(pd2Var, false);
                qw2.a("postMessage", "PostMsg setData end");
            } else {
                i = 202;
            }
            return UnitedSchemeUtility.wrapCallbackParams(i).toString();
        }
        return (String) invokeLL.objValue;
    }
}
