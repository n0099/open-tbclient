package com.baidu.tbadk.browser;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.xiuba.JSResultData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.e.b {
    private final TbPageContext<?> mTbPageContext;

    public g(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private String oa() {
        TbadkCoreApplication.m9getInst().login(this.mTbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.mTbPageContext.getPageActivity(), true)));
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str) && "startLoginModule".equals(str2)) {
            try {
                new JSONObject(str3);
                jsPromptResult.confirm(oa());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
