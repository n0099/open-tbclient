package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
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
                cU(str3);
                jsPromptResult.confirm("1");
                return true;
            } else if ("copyToClipboard".equals(str2)) {
                aN(str3);
                jsPromptResult.confirm("1");
                return true;
            } else if ("setBlockPopInfo".equals(str2)) {
                cV(str3);
                jsPromptResult.confirm("1");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void cU(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            UtilHelper.smsTo(this.mTbPageContext.getPageActivity(), jSONObject.optString("phoneNumber"), jSONObject.optString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aN(String str) {
        try {
            com.baidu.adp.lib.util.a.aN(new JSONObject(str).optString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cV(String str) {
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
            com.baidu.tieba.s.b.d(build);
            com.baidu.tieba.s.b.e(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
