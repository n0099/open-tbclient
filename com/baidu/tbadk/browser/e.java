package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.i;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.tbadkCore.e.b {
    private final TbPageContext<?> mTbPageContext;

    public e(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("callNativeSMS".equals(str2)) {
                vs(str3);
                jsPromptResult.confirm("1");
                return true;
            } else if ("copyToClipboard".equals(str2)) {
                copyToClipboard(str3);
                jsPromptResult.confirm("1");
                return true;
            } else if ("setBlockPopInfo".equals(str2)) {
                vt(str3);
                jsPromptResult.confirm("1");
                return true;
            } else if ("bindMobileNumber".equals(str2)) {
                vu(str3);
                jsPromptResult.confirm("1");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void vs(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            UtilHelper.smsTo(this.mTbPageContext.getPageActivity(), jSONObject.optString("phoneNumber"), jSONObject.optString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void copyToClipboard(String str) {
        try {
            com.baidu.adp.lib.util.a.copyToClipboard(new JSONObject(str).optString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vt(String str) {
        try {
            BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
            JSONObject jSONObject = new JSONObject(str);
            builder.can_post = Integer.valueOf(jSONObject.optInt("can_post"));
            builder.block_info = jSONObject.optString("block_info");
            builder.ahead_info = jSONObject.optString("ahead_info");
            builder.ahead_url = jSONObject.optString("ahead_url");
            builder.ok_info = jSONObject.optString("ok_info");
            builder.ahead_type = Integer.valueOf(jSONObject.optInt("ahead_type"));
            BlockPopInfo build = builder.build(false);
            com.baidu.tieba.ueg.d.d(build);
            com.baidu.tieba.ueg.d.e(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vu(String str) {
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, i.aZZ()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
