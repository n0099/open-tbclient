package com.baidu.tbadk.browser;

import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import d.a.e.a.a;
import d.a.i0.s.c.l;
import d.a.j0.d3.l0.b;
import d.a.j0.d3.l0.d.c;
import d.a.j0.l3.d;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
@a
/* loaded from: classes3.dex */
public class UegTbJsBridge implements b {
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String METHOD_BIND_MOBILE_NUMBER = "bindMobileNumber";
    public static final String METHOD_CALL_NATIVE_SMS = "callNativeSMS";
    public static final String METHOD_COPY_TO_CLIPBOARD = "copyToClipboard";
    public static final String METHOD_SET_BLOCK_POP_INFO = "setBlockPopInfo";
    public static final String SUCCESS_CODE = "1";
    public final TbPageContext<?> mTbPageContext;

    public UegTbJsBridge(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private void bindingMobileNumber(String str) {
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2921372, l.b()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void copyToClipboard(String str) {
        try {
            d.a.c.e.p.a.a(new JSONObject(str).optString("content"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public c callNativeSMS(String str, String str2) {
        c cVar = new c();
        UtilHelper.smsTo(this.mTbPageContext.getPageActivity(), str, str2);
        return cVar;
    }

    @Override // d.a.j0.d3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
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
                bindingMobileNumber(str3);
                jsPromptResult.confirm("1");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public c setBlockPopInfo(int i2, String str, String str2, String str3, String str4, int i3) {
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
}
