package com.baidu.tbadk.browser;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.xiuba.JSResultData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.tbadkCore.e.b {
    private final TbPageContext<?> mTbPageContext;

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private String nS() {
        TbadkCoreApplication.m9getInst().login(this.mTbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.mTbPageContext.getPageActivity(), true)));
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private void bV(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WEBVIEW_LOGIN, str));
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    new JSONObject(str3);
                    jsPromptResult.confirm(nS());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        bV(optString);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
