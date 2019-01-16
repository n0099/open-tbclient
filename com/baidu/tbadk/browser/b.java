package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDocumentUtil;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.e;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.tbadkCore.e.b {
    private n amY;
    private String amZ;
    private final Context mContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private WebView mWebView;
    private com.baidu.tbadk.coreExtra.c.d shareItem;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, WebView webView) {
        this.mContext = context;
        this.mWebView = webView;
    }

    private String dK(String str) {
        if (this.mWebView == null) {
            ba.bJ(this.mContext);
        } else {
            ba.j(this.mContext, this.mWebView.getOriginalUrl(), str);
        }
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private String wS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
        return "";
    }

    private String wT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
        return "";
    }

    private void dL(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    jsPromptResult.confirm(dK(new JSONObject(str3).optString("cssUrl")));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        dL(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if ("personPageRefresh".equals(str2)) {
                try {
                    jsPromptResult.confirm(wT());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if ("finishThisPage".equals(str2)) {
                try {
                    jsPromptResult.confirm(wS());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if ("registerShareData".equals(str2)) {
                try {
                    dQ(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if ("gameShare".equals(str2)) {
                try {
                    dR(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return true;
                }
            } else if ("getZid".equals(str2)) {
                jsPromptResult.confirm(wW());
                return true;
            } else if ("registerShareDataNew".equals(str2)) {
                jsPromptResult.confirm(dS(str3));
                return true;
            } else if ("share".equals(str2)) {
                jsPromptResult.confirm(dT(str3));
                return true;
            } else if ("getClipperInformation".equals(str2)) {
                jsPromptResult.confirm(wX());
                return true;
            } else if ("setClipperInformation".equals(str2)) {
                jsPromptResult.confirm(dU(str3));
                return true;
            } else if ("checkAppInstall".equals(str2)) {
                jsPromptResult.confirm(dV(str3));
                return true;
            } else if ("startApp".equals(str2)) {
                jsPromptResult.confirm(dW(str3));
                return true;
            } else if ("loadThirdPartyLogin".equals(str2)) {
                jsPromptResult.confirm(dP(str3));
            } else if ("hasNotificationPermission".equals(str2)) {
                jsPromptResult.confirm(wZ());
                return true;
            } else if ("goToNotificationSetting".equals(str2)) {
                xa();
            } else if ("startDownloadCss".equals(str2)) {
                jsPromptResult.confirm(dX(str3));
            } else if ("springFestivalTimer".equals(str2)) {
                jsPromptResult.confirm(dO(str3));
            } else if ("isDisableGoBack".equals(str2)) {
                jsPromptResult.confirm(xb());
            } else if ("playVibrate".equals(str2)) {
                jsPromptResult.confirm(wV());
            } else if ("playSound".equals(str2)) {
                jsPromptResult.confirm(dN(str3));
            } else if ("startAccelerometer".equals(str2)) {
                jsPromptResult.confirm(dM(str3));
            }
        }
        return false;
    }

    private n wU() {
        if (this.amY == null) {
            this.amY = new n(this.mContext, new n.a() { // from class: com.baidu.tbadk.browser.b.1
                @Override // com.baidu.tbadk.BdToken.n.a
                public void vZ() {
                    if (!TextUtils.isEmpty(b.this.amZ)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("resultCode", 1);
                            b.this.e(b.this.amZ, jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.amY;
    }

    private String dM(String str) {
        int i;
        try {
            this.amZ = new JSONObject(str).optString("method_name");
            if (!wU().isOpen()) {
                wU().open();
            }
            i = 1;
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
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

    private String dN(String str) {
        int i = 0;
        try {
            String optString = new JSONObject(str).optString("soundUrl");
            if (j.kV()) {
                wU().dD(optString);
                i = 1;
            } else if (this.mContext != null) {
                l.showToast(this.mContext, e.j.neterror);
            }
        } catch (JSONException e) {
            e.printStackTrace();
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

    private String wV() {
        int i = 0;
        if (wU().vY()) {
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

    private String dO(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("open");
            String optString = jSONObject.optString("method_name");
            i iVar = new i();
            iVar.cl(optBoolean);
            iVar.setMethod(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156673, iVar));
            i = 1;
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resultCode", i);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
    }

    private String dP(String str) {
        int i;
        try {
            if (!ao.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    g(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId"));
                    i = 1;
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                return jSONObject2.toString();
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            return jSONObject22.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
        i = 0;
    }

    private void g(int i, String str) {
        if (this.mContext != null) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            if (this.mWebView != null) {
                loginActivityConfig.setUrl(this.mWebView.getOriginalUrl());
            }
            ba.a(loginActivityConfig);
        }
    }

    private void dQ(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
    }

    private void dR(String str) {
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

    private String wW() {
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

    private String dS(String str) {
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

    private void setShareItem(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.shareItem = dVar;
    }

    private void w(String str, final int i) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.EG();
            this.mPermissionJudgement.c(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.B(currentActivity)) {
                k kVar = new k(currentActivity, str, new k.a() { // from class: com.baidu.tbadk.browser.b.2
                    @Override // com.baidu.tbadk.util.k.a
                    public void onError(int i2, String str2) {
                    }

                    @Override // com.baidu.tbadk.util.k.a
                    public void onSuccess(String str2) {
                        if (new File(str2).exists()) {
                            if (b.this.shareItem != null) {
                                b.this.shareItem.shareType = 1;
                                b.this.shareItem.hq(str2);
                            }
                            if (i != 0) {
                                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mContext, i, b.this.shareItem, true));
                            }
                        }
                    }
                });
                kVar.setFrom(1);
                kVar.execute(new String[0]);
            }
        }
    }

    private String dT(String str) {
        int i;
        CustomResponsedMessage runTask;
        try {
            if (!ao.isEmpty(str) && (runTask = MessageManager.getInstance().runTask(2016568, com.baidu.tbadk.coreExtra.c.d.class, str)) != null) {
                com.baidu.tbadk.coreExtra.c.d dVar = (com.baidu.tbadk.coreExtra.c.d) runTask.getData();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("channel");
                    int optInt2 = jSONObject.optInt("shareimg");
                    String optString = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                    if (optInt == 0) {
                        if (dVar != null && !ao.isEmpty(optString) && optInt2 == 1) {
                            setShareItem(dVar);
                            w(optString, optInt);
                        }
                        a(dVar);
                    } else if (dVar != null && !ao.isEmpty(optString) && optInt2 == 1) {
                        setShareItem(dVar);
                        w(optString, optInt);
                    } else {
                        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, optInt, dVar, true));
                    }
                    i = 1;
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                return jSONObject2.toString();
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            return jSONObject22.toString();
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
            amVar.aB("obj_url", dVar.linkUrl);
            amVar.y("obj_type", 1);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    private String wX() {
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

    private String dU(String str) {
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
        e("ShareSuccessNotification", jSONObject);
    }

    public void h(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
            jSONObject.put("socialType", i);
            jSONObject.put("activityId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        e("thirdPartyLoginResultToH5", jSONObject);
    }

    public String dV(String str) {
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
    public String dW(String str) {
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
                List<String> GP = com.baidu.tbadk.coreExtra.data.f.GP();
                if (b(GP, optString2)) {
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
                        if (b(GP, optString) && (launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(optString)) != null) {
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

    public void wY() {
        e("clickGoBackToH5", new JSONObject());
    }

    public void d(String str, JSONObject jSONObject) {
        e(str, jSONObject);
    }

    public String wZ() {
        int i = 1;
        if (Build.VERSION.SDK_INT >= 19 && !NotificationManagerCompat.from(this.mContext).areNotificationsEnabled()) {
            i = 0;
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

    public void xa() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName()));
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public String dX(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!ao.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("downloadUrl");
                if (ao.isEmpty(optString)) {
                    jSONObject.put("resultCode", 0);
                    return jSONObject.toString();
                }
                String fA = com.baidu.tbadk.core.util.l.fA(optString);
                String fB = com.baidu.tbadk.core.util.l.fB(optString);
                if (!com.baidu.tbadk.core.util.l.fq(fB)) {
                    jSONObject.put("resultCode", 0);
                    return jSONObject.toString();
                }
                DownloadData downloadData = new DownloadData(fA, fA, optString, null);
                downloadData.setPath(fB);
                com.baidu.tbadk.download.d.Mj().f(downloadData);
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return jSONObject.toString();
    }

    private String xb() {
        int i = 0;
        if (this.mContext instanceof TbWebViewActivity) {
            ((TbWebViewActivity) this.mContext).isDisableGoBack = true;
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

    public void onDestroy() {
        if (this.amY != null && this.amY.isOpen()) {
            this.amY.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, JSONObject jSONObject) {
        if (this.mWebView != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.mWebView.evaluateJavascript("javascript:" + str + "('" + jSONObject.toString() + "')", null);
            } else {
                this.mWebView.loadUrl("javascript:" + str + "('" + jSONObject.toString() + "')");
            }
        }
    }
}
