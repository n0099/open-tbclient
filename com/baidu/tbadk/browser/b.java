package com.baidu.tbadk.browser;

import android.content.Context;
import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDocumentUtil;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.tbadkCore.e.b {
    private final Context mContext;
    private WebView mWebView;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, WebView webView) {
        this.mContext = context;
        this.mWebView = webView;
    }

    private String vx() {
        ba.bI(this.mContext);
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private String vy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
        return "";
    }

    private String vz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
        return "";
    }

    private void ds(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    new JSONObject(str3);
                    jsPromptResult.confirm(vx());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        ds(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if ("personPageRefresh".equals(str2)) {
                try {
                    jsPromptResult.confirm(vz());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if ("finishThisPage".equals(str2)) {
                try {
                    jsPromptResult.confirm(vy());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if ("registerShareData".equals(str2)) {
                try {
                    dt(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if ("gameShare".equals(str2)) {
                try {
                    du(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return true;
                }
            } else if ("getZid".equals(str2)) {
                jsPromptResult.confirm(vA());
                return true;
            } else if ("registerShareDataNew".equals(str2)) {
                jsPromptResult.confirm(dv(str3));
                return true;
            } else if ("share".equals(str2)) {
                jsPromptResult.confirm(dw(str3));
                return true;
            } else if ("getClipperInformation".equals(str2)) {
                jsPromptResult.confirm(vB());
                return true;
            } else if ("setClipperInformation".equals(str2)) {
                jsPromptResult.confirm(dx(str3));
                return true;
            }
        }
        return false;
    }

    private void dt(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
    }

    private void du(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            BdLog.e(e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            GameShareData gameShareData = new GameShareData();
            gameShareData.parseJson(jSONObject);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameShareActivityConfig(this.mContext, gameShareData)));
        }
    }

    private String vA() {
        String gz = FH.gz(TbadkCoreApplication.getInst());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("zid", gz);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String dv(String str) {
        int i = 0;
        if (!ao.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, str));
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String dw(String str) {
        int i;
        CustomResponsedMessage runTask;
        try {
            if (!ao.isEmpty(str) && (runTask = MessageManager.getInstance().runTask(2016568, com.baidu.tbadk.coreExtra.c.d.class, str)) != null) {
                com.baidu.tbadk.coreExtra.c.d dVar = (com.baidu.tbadk.coreExtra.c.d) runTask.getData();
                try {
                    int optInt = new JSONObject(str).optInt("channel");
                    if (optInt == 0) {
                        a(dVar);
                    } else {
                        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, optInt, dVar, true));
                    }
                    i = 1;
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resultCode", i);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
        i = 0;
    }

    protected void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    private String vB() {
        int i = 0;
        String clipBoardContent = UtilHelper.getClipBoardContent();
        if (!ao.isEmpty(clipBoardContent)) {
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put("data", clipBoardContent);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String dx(String str) {
        int i = 0;
        if (!ao.isEmpty(str)) {
            try {
                com.baidu.adp.lib.util.a.bg(new JSONObject(str).optString(AiAppDocumentUtil.TXT));
                i = 1;
            } catch (JSONException e) {
                BdLog.e(e);
                i = 1;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            return jSONObject.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public void a(int i, com.baidu.tbadk.coreExtra.c.d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", dVar.title);
            jSONObject2.put("desc", dVar.content);
            jSONObject2.put(SocialConstants.PARAM_IMG_URL, dVar.imageUri);
            jSONObject2.put("url", dVar.linkUrl);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", i);
            jSONObject3.put("shareData", jSONObject2);
            jSONObject.put("resultCode", 1);
            jSONObject.put("data", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        d("ShareSuccessNotification", jSONObject);
    }

    private void d(String str, JSONObject jSONObject) {
        if (this.mWebView != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.mWebView.evaluateJavascript("javascript:" + str + "('" + jSONObject.toString() + "')", null);
            } else {
                this.mWebView.loadUrl("javascript:" + str + "('" + jSONObject.toString() + "')");
            }
        }
    }
}
