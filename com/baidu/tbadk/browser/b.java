package com.baidu.tbadk.browser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.tencent.open.SocialConstants;
import java.util.List;
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

    private String wL() {
        if (this.mWebView == null) {
            ba.bJ(this.mContext);
        } else {
            ba.ak(this.mContext, this.mWebView.getOriginalUrl());
        }
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private String wM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
        return "";
    }

    private String wN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
        return "";
    }

    private void dI(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    new JSONObject(str3);
                    jsPromptResult.confirm(wL());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        dI(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if ("personPageRefresh".equals(str2)) {
                try {
                    jsPromptResult.confirm(wN());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if ("finishThisPage".equals(str2)) {
                try {
                    jsPromptResult.confirm(wM());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if ("registerShareData".equals(str2)) {
                try {
                    dJ(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if ("gameShare".equals(str2)) {
                try {
                    dK(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return true;
                }
            } else if ("getZid".equals(str2)) {
                jsPromptResult.confirm(wO());
                return true;
            } else if ("registerShareDataNew".equals(str2)) {
                jsPromptResult.confirm(dL(str3));
                return true;
            } else if ("share".equals(str2)) {
                jsPromptResult.confirm(dM(str3));
                return true;
            } else if ("getClipperInformation".equals(str2)) {
                jsPromptResult.confirm(wP());
                return true;
            } else if ("setClipperInformation".equals(str2)) {
                jsPromptResult.confirm(dN(str3));
                return true;
            } else if ("checkAppInstall".equals(str2)) {
                jsPromptResult.confirm(dO(str3));
                return true;
            } else if ("startApp".equals(str2)) {
                jsPromptResult.confirm(dP(str3));
                return true;
            }
        }
        return false;
    }

    private void dJ(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
    }

    private void dK(String str) {
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

    private String wO() {
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

    private String dL(String str) {
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

    private String dM(String str) {
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
            if (dVar.shareType != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            am amVar = new am("c10898");
            amVar.aA("obj_url", dVar.linkUrl);
            amVar.x("obj_type", 1);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    private String wP() {
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

    private String dN(String str) {
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

    public String dO(String str) {
        int i = 0;
        if (!ao.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("pkgName");
                if (!StringUtils.isNull(optString)) {
                    if (UtilHelper.isInstalledPackage(this.mContext, optString)) {
                        i = 1;
                    }
                }
            } catch (JSONException e) {
                BdLog.e(e);
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

    private boolean b(List<String> list, String str) {
        if (StringUtils.isNull(str) || v.I(list)) {
            return false;
        }
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String dP(String str) {
        boolean z;
        boolean z2;
        Intent launchIntentForPackage;
        if (ao.isEmpty(str)) {
            z2 = false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("pkgName");
                String optString2 = jSONObject.optString("schema");
                List<String> GB = com.baidu.tbadk.coreExtra.data.f.GB();
                if (b(GB, optString2)) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(optString2));
                    try {
                        this.mContext.startActivity(intent);
                        z2 = true;
                    } catch (ActivityNotFoundException e) {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (!z2) {
                    try {
                        if (b(GB, optString) && (launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(optString)) != null) {
                            this.mContext.startActivity(launchIntentForPackage);
                            z2 = true;
                        }
                    } catch (JSONException e2) {
                        z = z2;
                        e = e2;
                        BdLog.e(e);
                        z2 = z;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("resultCode", z2 ? 1 : 0);
                        return jSONObject2.toString();
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                z = false;
            }
        }
        try {
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", z2 ? 1 : 0);
            return jSONObject22.toString();
        } catch (JSONException e4) {
            BdLog.e(e4);
            return null;
        }
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
