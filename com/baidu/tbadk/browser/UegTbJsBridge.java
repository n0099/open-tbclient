package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
import c.a.f.a.a;
import c.a.r0.t.c.m;
import c.a.s0.d4.d;
import c.a.s0.v3.n0.b;
import c.a.s0.v3.n0.d.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
@a
/* loaded from: classes11.dex */
public class UegTbJsBridge implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
    public static final String METHOD_CALL_NATIVE_SMS = "callNativeSMS";
    public static final String METHOD_COPY_TO_CLIPBOARD = "copyToClipboard";
    public static final String METHOD_SET_BLOCK_POP_INFO = "setBlockPopInfo";
    public static final String SUCCESS_CODE = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> mTbPageContext;

    public UegTbJsBridge(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTbPageContext = tbPageContext;
    }

    private void copyToClipboard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            try {
                c.a.d.f.p.b.a(new JSONObject(str).optString("content"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public c bindingMobileNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = new c();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, m.b()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public c callNativeSMS(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            c cVar = new c();
            UtilHelper.smsTo(this.mTbPageContext.getPageActivity(), str, str2);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.s0.v3.n0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, jsPromptResult)) == null) {
            if ("CommonJSBridge".equals(str)) {
                if (METHOD_CALL_NATIVE_SMS.equals(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        callNativeSMS(jSONObject.optString("phoneNumber"), jSONObject.optString("content"));
                        jsPromptResult.confirm("1");
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                    }
                    return true;
                } else if (METHOD_COPY_TO_CLIPBOARD.equals(str2)) {
                    copyToClipboard(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if (METHOD_SET_BLOCK_POP_INFO.equals(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        setBlockPopInfo(jSONObject2.optInt("can_post"), jSONObject2.optString("block_info"), jSONObject2.optString("ahead_info"), jSONObject2.optString("ahead_url"), jSONObject2.optString("ok_info"), jSONObject2.optInt("ahead_type"));
                        jsPromptResult.confirm("1");
                    } catch (JSONException e3) {
                        BdLog.e(e3);
                    }
                    return true;
                } else if ("bindMobileNumber".equals(str2)) {
                    jsPromptResult.confirm(bindingMobileNumber().a());
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public c setBlockPopInfo(int i2, String str, String str2, String str3, String str4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, Integer.valueOf(i3)})) == null) {
            c cVar = new c();
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                builder.can_post = Integer.valueOf(i2);
                builder.block_info = str;
                builder.ahead_info = str2;
                builder.ahead_url = str3;
                builder.ok_info = str4;
                builder.ahead_type = Integer.valueOf(i3);
                BlockPopInfo build = builder.build(false);
                d.g(build);
                d.f(build);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }
}
