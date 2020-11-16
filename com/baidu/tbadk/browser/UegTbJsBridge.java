package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.j;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
@com.baidu.c.a.a
/* loaded from: classes.dex */
public class UegTbJsBridge implements com.baidu.tieba.tbadkCore.e.b {
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
    public static final String METHOD_CALL_NATIVE_SMS = "callNativeSMS";
    public static final String METHOD_COPY_TO_CLIPBOARD = "copyToClipboard";
    public static final String METHOD_SET_BLOCK_POP_INFO = "setBlockPopInfo";
    public static final String SUCCESS_CODE = "1";
    private final TbPageContext<?> mTbPageContext;

    public UegTbJsBridge(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
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
            } else if (METHOD_BIND_MOBILE_NUMBER.equals(str2)) {
                bindingMobileNumber(str3);
                jsPromptResult.confirm("1");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public com.baidu.tieba.tbadkCore.e.a.b callNativeSMS(String str, String str2) {
        com.baidu.tieba.tbadkCore.e.a.b bVar = new com.baidu.tieba.tbadkCore.e.a.b();
        UtilHelper.smsTo(this.mTbPageContext.getPageActivity(), str, str2);
        return bVar;
    }

    private void copyToClipboard(String str) {
        try {
            com.baidu.adp.lib.util.a.copyToClipboard(new JSONObject(str).optString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.b setBlockPopInfo(int i, String str, String str2, String str3, String str4, int i2) {
        com.baidu.tieba.tbadkCore.e.a.b bVar = new com.baidu.tieba.tbadkCore.e.a.b();
        try {
            BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
            builder.can_post = Integer.valueOf(i);
            builder.block_info = str;
            builder.ahead_info = str2;
            builder.ahead_url = str3;
            builder.ok_info = str4;
            builder.ahead_type = Integer.valueOf(i2);
            BlockPopInfo build = builder.build(false);
            com.baidu.tieba.ueg.d.d(build);
            com.baidu.tieba.ueg.d.e(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bVar;
    }

    private void bindingMobileNumber(String str) {
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, j.btP()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
