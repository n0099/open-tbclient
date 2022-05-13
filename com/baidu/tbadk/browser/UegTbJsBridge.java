package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bi;
import com.repackage.c85;
import com.repackage.dx4;
import com.repackage.lp;
import com.repackage.ok8;
import com.repackage.rq8;
import com.repackage.sk8;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
@lp
/* loaded from: classes2.dex */
public class UegTbJsBridge implements ok8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
    public static final String METHOD_CALL_NATIVE_SMS = "callNativeSMS";
    public static final String METHOD_COPY_TO_CLIPBOARD = "copyToClipboard";
    public static final String METHOD_RECORD_NOVEL_INFO = "recordNovelInfo";
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                bi.a(new JSONObject(str).optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public sk8 bindingMobileNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            sk8 sk8Var = new sk8();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, dx4.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sk8Var;
        }
        return (sk8) invokeV.objValue;
    }

    public sk8 callNativeSMS(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            sk8 sk8Var = new sk8();
            UtilHelper.smsTo(this.mTbPageContext.getPageActivity(), str, str2);
            return sk8Var;
        }
        return (sk8) invokeLL.objValue;
    }

    @Override // com.repackage.ok8
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
                    } catch (JSONException e) {
                        BdLog.e(e);
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
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                    }
                    return true;
                } else if ("bindMobileNumber".equals(str2)) {
                    jsPromptResult.confirm(bindingMobileNumber().a());
                    return true;
                } else if (METHOD_RECORD_NOVEL_INFO.equals(str2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str3);
                        recordNovelInfo(jSONObject3.optString("bookProgress"), jSONObject3.optString("gid"), jSONObject3.optString("lastReadChapterId"), jSONObject3.optString("lastReadChapterIndex"), jSONObject3.optString("lastReadChapterName"));
                        jsPromptResult.confirm("1");
                    } catch (JSONException e3) {
                        BdLog.e(e3);
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public sk8 recordNovelInfo(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, str, str2, str3, str4, str5)) == null) {
            sk8 sk8Var = new sk8();
            c85.c(str2, new ReadRecordsData(str, str2, str3, str4, str5));
            return sk8Var;
        }
        return (sk8) invokeLLLLL.objValue;
    }

    public sk8 setBlockPopInfo(int i, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            sk8 sk8Var = new sk8();
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                builder.can_post = Integer.valueOf(i);
                builder.block_info = str;
                builder.ahead_info = str2;
                builder.ahead_url = str3;
                builder.ok_info = str4;
                builder.ahead_type = Integer.valueOf(i2);
                BlockPopInfo build = builder.build(false);
                rq8.g(build);
                rq8.f(build);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sk8Var;
        }
        return (sk8) invokeCommon.objValue;
    }
}
