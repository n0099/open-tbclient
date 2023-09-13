package com.baidu.tbadk.browser;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tieba.iia;
import com.baidu.tieba.is5;
import com.baidu.tieba.mia;
import com.baidu.tieba.oo;
import com.baidu.tieba.sc5;
import com.baidu.tieba.ypa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
@oo
/* loaded from: classes4.dex */
public class UegTbJsBridge implements iia {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
    public static final String METHOD_CALL_NATIVE_SMS = "callNativeSMS";
    public static final String METHOD_COPY_TO_CLIPBOARD = "copyToClipboard";
    public static final String METHOD_NOVEL_PAY_RESULT_TO_CLIENT = "novelPayResultToClient";
    public static final String METHOD_RECORD_NOVEL_INFO = "recordNovelInfo";
    public static final String METHOD_SET_BLOCK_POP_INFO = "setBlockPopInfo";
    public static final String SUCCESS_CODE = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public TbPageContext<?> mTbPageContext;

    public UegTbJsBridge(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private void copyToClipboard(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            try {
                AndroidUtils.copyToClipboard(new JSONObject(str).optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public mia novelPayResultToClient(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            mia miaVar = new mia();
            if (z) {
                is5.c();
            }
            return miaVar;
        }
        return (mia) invokeZ.objValue;
    }

    public UegTbJsBridge(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTbPageContext = tbPageContext;
    }

    public mia bindingMobileNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            mia miaVar = new mia();
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921372, sc5.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return miaVar;
        }
        return (mia) invokeV.objValue;
    }

    public mia callNativeSMS(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            mia miaVar = new mia();
            Context pageActivity = this.mTbPageContext.getPageActivity();
            if (pageActivity == null) {
                pageActivity = this.mContext;
            }
            UtilHelper.smsTo(pageActivity, str, str2);
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.iia
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, jsPromptResult)) == null) {
            if (!"CommonJSBridge".equals(str)) {
                return false;
            }
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
            } else if (METHOD_BIND_MOBILE_NUMBER.equals(str2)) {
                jsPromptResult.confirm(bindingMobileNumber().a());
                return true;
            } else if (METHOD_RECORD_NOVEL_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(str3);
                    recordNovelInfo(jSONObject3.optString("bookProgress"), jSONObject3.optString(TbEnum.ParamKey.GID), jSONObject3.optString("lastReadChapterId"), jSONObject3.optString("lastReadChapterIndex"), jSONObject3.optString("lastReadChapterName"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e3) {
                    BdLog.e(e3);
                }
                return true;
            } else if (!METHOD_NOVEL_PAY_RESULT_TO_CLIENT.equals(str2)) {
                return false;
            } else {
                try {
                    novelPayResultToClient(new JSONObject(str3).optBoolean("isPaySuccess"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e4) {
                    BdLog.e(e4);
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public mia recordNovelInfo(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, str, str2, str3, str4, str5)) == null) {
            mia miaVar = new mia();
            ReadRecordsData readRecordsData = new ReadRecordsData(str, str2, str3, str4, str5);
            readRecordsData.O(true);
            is5.d(str2, readRecordsData);
            return miaVar;
        }
        return (mia) invokeLLLLL.objValue;
    }

    public mia setBlockPopInfo(int i, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            mia miaVar = new mia();
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                builder.can_post = Integer.valueOf(i);
                builder.block_info = str;
                builder.ahead_info = str2;
                builder.ahead_url = str3;
                builder.ok_info = str4;
                builder.ahead_type = Integer.valueOf(i2);
                BlockPopInfo build = builder.build(false);
                ypa.h(build);
                ypa.g(build);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }
}
