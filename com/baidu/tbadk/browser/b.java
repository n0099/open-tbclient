package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.s;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.tbadkCore.e.b {
    private final String SHOW_MORE_FORUM_ICON;
    private WebView djT;
    private t djU;
    private String djV;
    private final Context mContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private ShareItem shareItem;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, WebView webView) {
        this.SHOW_MORE_FORUM_ICON = "1";
        this.mContext = context;
        this.djT = webView;
    }

    private String ta(String str) {
        if (this.djT == null) {
            bc.checkUpIsLogin(this.mContext);
        } else {
            bc.q(this.mContext, this.djT.getOriginalUrl(), str);
        }
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private String aHw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FINISH_THIS_PAGE));
        return "";
    }

    private String aHx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_PAGE_REFRESH));
        return "";
    }

    private void tb(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    jsPromptResult.confirm(ta(new JSONObject(str3).optString("cssUrl")));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        tb(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if ("personPageRefresh".equals(str2)) {
                try {
                    jsPromptResult.confirm(aHx());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if ("finishThisPage".equals(str2)) {
                try {
                    jsPromptResult.confirm(aHw());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if ("registerShareData".equals(str2)) {
                try {
                    ti(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if ("gameShare".equals(str2)) {
                try {
                    tj(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return true;
                }
            } else if ("getZid".equals(str2)) {
                jsPromptResult.confirm(getZid());
                return true;
            } else if ("registerShareDataNew".equals(str2)) {
                jsPromptResult.confirm(tk(str3));
                return true;
            } else if (TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                jsPromptResult.confirm(tl(str3));
                return true;
            } else if ("getClipperInformation".equals(str2)) {
                jsPromptResult.confirm(aHC());
                return true;
            } else if ("setClipperInformation".equals(str2)) {
                jsPromptResult.confirm(tm(str3));
                return true;
            } else if ("checkAppInstall".equals(str2)) {
                jsPromptResult.confirm(to(str3));
                return true;
            } else if ("startApp".equals(str2)) {
                jsPromptResult.confirm(tp(str3));
                return true;
            } else if ("loadThirdPartyLogin".equals(str2)) {
                jsPromptResult.confirm(th(str3));
            } else if ("hasNotificationPermission".equals(str2)) {
                jsPromptResult.confirm(aHG());
                return true;
            } else if ("goToNotificationSetting".equals(str2)) {
                aHH();
            } else if ("startDownloadCss".equals(str2)) {
                jsPromptResult.confirm(tq(str3));
            } else if ("springFestivalTimer".equals(str2)) {
                jsPromptResult.confirm(tg(str3));
            } else if ("isDisableGoBack".equals(str2)) {
                jsPromptResult.confirm(aHI());
            } else if ("playVibrate".equals(str2)) {
                jsPromptResult.confirm(aHB());
            } else if ("playSound".equals(str2)) {
                jsPromptResult.confirm(tf(str3));
            } else if ("startAccelerometer".equals(str2)) {
                jsPromptResult.confirm(te(str3));
            } else if ("toastPopupView".equals(str2)) {
                jsPromptResult.confirm(tc(str3));
            } else if ("gamePush".equals(str2)) {
                jsPromptResult.confirm(td(str3));
                return true;
            } else if ("gamePushStatus".equals(str2)) {
                jsPromptResult.confirm(aHA());
                return true;
            } else if ("getSupplementInfo".equals(str2)) {
                jsPromptResult.confirm(aHJ());
                return true;
            } else if ("getDeviceInfo".equals(str2)) {
                jsPromptResult.confirm(getDeviceInfo());
                return true;
            } else if ("generalPreferences".equals(str2)) {
                jsPromptResult.confirm(aHz());
            } else if ("completeTask".equals(str2)) {
                jsPromptResult.confirm(tr(str3));
            } else if ("getModalData".equals(str2)) {
                jsPromptResult.confirm(aHK());
            } else if ("showTipToast".equals(str2)) {
                jsPromptResult.confirm(ts(str3));
            } else if ("jumpToHTMLPage".equals(str2)) {
                jsPromptResult.confirm(tt(str3));
            } else if ("closeNativeMask".equals(str2)) {
                jsPromptResult.confirm(tn(str3));
            }
        }
        return false;
    }

    private t aHy() {
        if (this.djU == null) {
            this.djU = new t(this.mContext, new t.a() { // from class: com.baidu.tbadk.browser.b.1
                @Override // com.baidu.tbadk.BdToken.t.a
                public void aGy() {
                    if (!TextUtils.isEmpty(b.this.djV)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("resultCode", 1);
                            b.this.m(b.this.djV, jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.djU;
    }

    private String tc(String str) {
        int i;
        try {
            com.baidu.tbadk.BdToken.completeTask.a aVar = new com.baidu.tbadk.BdToken.completeTask.a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.showType = jSONObject.optInt("show_type");
            aVar.diH = jSONObject.optInt("ahead_type");
            aVar.message = jSONObject.optString("message");
            aVar.btnText = jSONObject.optString("btn_text");
            aVar.duration = jSONObject.optInt("toast_duration");
            aVar.schema = jSONObject.optString("schema");
            aVar.token = jSONObject.optString("token");
            aVar.opacity = jSONObject.optDouble("opacity");
            aVar.imgUrl = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            aVar.url = jSONObject.optString("url");
            aVar.activityId = jSONObject.optInt("activity_id");
            aVar.missionId = jSONObject.optInt("mission_id");
            aVar.btn_color = jSONObject.optString("btn_color");
            aVar.message_color = jSONObject.optString("message_color");
            aVar.btn_text_color = jSONObject.optString("btn_text_color");
            if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.diB) {
                h.b(TbadkCoreApplication.getInst().getCurrentActivity(), aVar).aNf();
            } else if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.diC) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                com.baidu.tbadk.core.business.b bVar = new com.baidu.tbadk.core.business.b(currentActivity);
                if (currentActivity != null) {
                    bVar.a(currentActivity, aVar);
                    bVar.show();
                }
            } else if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.diD) {
                if (aVar.diH == com.baidu.tbadk.BdToken.completeTask.a.diF) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), aVar.schema) && !aq.isEmpty(aVar.url)) {
                        sR(aVar.url + "?page_type=open_full_screen_opacity_web_page");
                    }
                } else if (aVar.diH == com.baidu.tbadk.BdToken.completeTask.a.diG && !aq.isEmpty(aVar.url)) {
                    sR(aVar.url + "?page_type=open_full_screen_opacity_web_page");
                }
            }
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

    private String td(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921404, str));
        return "1";
    }

    private String aHz() {
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_bawu_task_toast", -1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String aHA() {
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_match_id_list_football", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_match_id_list_basketball", "");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("football", "[" + string + "]");
            jSONObject.put("basketball", "[" + string2 + "]");
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private void sR(String str) {
        TbPageContext<?> n;
        if (!aq.isEmpty(str) && (n = n(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aOY().b(n, new String[]{str});
        }
    }

    private TbPageContext n(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    private String te(String str) {
        int i;
        try {
            this.djV = new JSONObject(str).optString("method_name");
            if (!aHy().isOpen()) {
                aHy().open();
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

    private String tf(String str) {
        int i = 0;
        try {
            String optString = new JSONObject(str).optString("soundUrl");
            if (j.isNetWorkAvailable()) {
                aHy().sQ(optString);
                i = 1;
            } else if (this.mContext != null) {
                l.showToast(this.mContext, (int) R.string.neterror);
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

    private String aHB() {
        int i = 0;
        if (aHy().aGx()) {
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

    private String tg(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("open");
            String optString = jSONObject.optString("method_name");
            i iVar = new i();
            iVar.setOpen(optBoolean);
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

    private String th(String str) {
        int i;
        try {
            if (!aq.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    af(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId"));
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

    private void af(int i, String str) {
        if (this.mContext != null) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            if (this.djT != null) {
                loginActivityConfig.setUrl(this.djT.getOriginalUrl());
            }
            bc.a(loginActivityConfig);
        }
    }

    private void ti(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE, str));
    }

    private void tj(String str) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameShareActivityConfig(this.mContext, gameShareData)));
        }
    }

    private String getZid() {
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

    private String tk(String str) {
        int i = 0;
        if (!aq.isEmpty(str)) {
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

    private void setShareItem(ShareItem shareItem) {
        this.shareItem = shareItem;
    }

    private void ad(String str, final int i) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(currentActivity)) {
                o oVar = new o(currentActivity, str, new o.a() { // from class: com.baidu.tbadk.browser.b.2
                    @Override // com.baidu.tbadk.util.o.a
                    public void onError(int i2, String str2) {
                    }

                    @Override // com.baidu.tbadk.util.o.a
                    public void onSuccess(String str2) {
                        if (new File(str2).exists()) {
                            if (b.this.shareItem != null) {
                                b.this.shareItem.shareType = 1;
                                b.this.shareItem.localFile = str2;
                            }
                            if (i != 0) {
                                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mContext, i, b.this.shareItem, true));
                            }
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    private String tl(String str) {
        int i;
        CustomResponsedMessage runTask;
        int optInt;
        int optInt2;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        String optString5;
        try {
            if (!aq.isEmpty(str) && (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, str)) != null) {
                ShareItem shareItem = (ShareItem) runTask.getData();
                if (shareItem != null) {
                    shareItem.dQx = 17;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    optInt = jSONObject.optInt("channel");
                    optInt2 = jSONObject.optInt("shareimg");
                    optString = jSONObject.optString("img");
                    optString2 = jSONObject.optString("isShowMoreForum");
                    optString3 = jSONObject.optString("url");
                    optString4 = jSONObject.optString("title");
                    optString5 = jSONObject.optString("desc");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                if ("1".equals(optString2)) {
                    shareItem.imageUrl = optString;
                    shareItem.linkUrl = optString3;
                    shareItem.title = optString4 + " " + optString5;
                    shareItem.dQr = true;
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    com.baidu.tieba.c.e.bGe().b(shareDialogConfig);
                    return "";
                }
                if (optInt == 0) {
                    if (shareItem != null && !aq.isEmpty(optString) && optInt2 == 1) {
                        setShareItem(shareItem);
                        ad(optString, optInt);
                    }
                    a(shareItem);
                } else if (shareItem != null && !aq.isEmpty(optString) && optInt2 == 1) {
                    setShareItem(shareItem);
                    ad(optString, optInt);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, optInt, shareItem, true));
                }
                i = 1;
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

    protected void a(ShareItem shareItem) {
        if (shareItem != null) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true);
            if (shareItem.shareType != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cI(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.af("obj_type", 1);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private String aHC() {
        int i = 0;
        String clipBoardContent = UtilHelper.getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent)) {
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

    private String tm(String str) {
        int i = 0;
        if (!aq.isEmpty(str)) {
            try {
                com.baidu.adp.lib.util.a.copyToClipboard(new JSONObject(str).optString(DocumentOpenUtil.TXT));
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

    public void aHD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skin", am.aON());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m("changeSkinType", jSONObject);
    }

    private String tn(String str) {
        int i = 1;
        try {
            if (!StringUtils.isNull(str)) {
                try {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(new JSONObject(str).optInt("result", 0) == 1)));
                } catch (JSONException e) {
                    e.printStackTrace();
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

    public void a(int i, ShareItem shareItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", shareItem.title);
            jSONObject2.put("desc", shareItem.content);
            jSONObject2.put("img", shareItem.imageUri);
            jSONObject2.put("url", shareItem.linkUrl);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", i);
            jSONObject3.put("shareData", jSONObject2);
            jSONObject.put("resultCode", 1);
            jSONObject.put("data", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m("ShareSuccessNotification", jSONObject);
    }

    public void ag(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
            jSONObject.put("socialType", i);
            jSONObject.put("activityId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m("thirdPartyLoginResultToH5", jSONObject);
    }

    public void gm(boolean z) {
        if (z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            m("loginResultToH5", jSONObject);
        }
    }

    public void aHE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m("reshow", jSONObject);
    }

    public String to(String str) {
        int i = 0;
        if (!aq.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString(PushClientConstants.TAG_PKG_NAME);
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

    private boolean e(List<String> list, String str) {
        if (StringUtils.isNull(str) || v.isEmpty(list)) {
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
    public String tp(String str) {
        boolean z;
        boolean z2;
        Intent launchIntentForPackage;
        if (aq.isEmpty(str)) {
            z2 = false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
                String optString2 = jSONObject.optString("schema");
                List<String> aRN = com.baidu.tbadk.coreExtra.data.f.aRN();
                if (e(aRN, optString2)) {
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
                        if (e(aRN, optString) && (launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(optString)) != null) {
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

    public void aHF() {
        m("clickGoBackToH5", new JSONObject());
    }

    public void l(String str, JSONObject jSONObject) {
        m(str, jSONObject);
    }

    public String aHG() {
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

    public void aHH() {
        try {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public String tq(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!aq.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("downloadUrl");
                if (aq.isEmpty(optString)) {
                    jSONObject.put("resultCode", 0);
                    return jSONObject.toString();
                }
                String ux = m.ux(optString);
                String uy = m.uy(optString);
                if (!m.uw(uy)) {
                    jSONObject.put("resultCode", 0);
                    return jSONObject.toString();
                }
                DownloadData downloadData = new DownloadData(ux, ux, optString, null);
                downloadData.setPath(uy);
                com.baidu.tbadk.download.d.aWL().f(downloadData);
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return jSONObject.toString();
    }

    private String aHI() {
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
        if (this.djU != null && this.djU.isOpen()) {
            this.djU.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, JSONObject jSONObject) {
        if (this.djT != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.djT.evaluateJavascript("javascript:" + str + "('" + jSONObject.toString() + "')", null);
            } else {
                this.djT.loadUrl("javascript:" + str + "('" + jSONObject.toString() + "')");
            }
        }
    }

    private String aHJ() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        String imei = TbadkCoreApplication.getInst().getImei();
        stringBuffer.append("imei=");
        stringBuffer.append(imei);
        String cuid = TbadkCoreApplication.getInst().getCuid();
        stringBuffer.append("cuid=");
        stringBuffer.append(cuid);
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        stringBuffer.append("shoubai_cuid=");
        stringBuffer.append(cuidGalaxy2);
        String str = Build.BRAND;
        stringBuffer.append("brand=");
        stringBuffer.append(str);
        stringBuffer.append("client_type=");
        stringBuffer.append("Android");
        String version = TbConfig.getVersion();
        stringBuffer.append("client_version=");
        stringBuffer.append(version);
        String gz = FH.gz(TbadkCoreApplication.getInst());
        stringBuffer.append("zid=");
        stringBuffer.append(gz);
        stringBuffer.append("tiebaclient!!!");
        String md5 = s.toMd5(stringBuffer.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", imei);
            jSONObject.put("cuid", cuid);
            jSONObject.put("shoubai_cuid", cuidGalaxy2);
            jSONObject.put(Constants.PHONE_BRAND, str);
            jSONObject.put("client_type", "Android");
            jSONObject.put("client_version", version);
            jSONObject.put("zid", gz);
            jSONObject.put("sign", md5);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return "";
        }
    }

    private String getDeviceInfo() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        String imei = TbadkCoreApplication.getInst().getImei();
        stringBuffer.append("imei=");
        stringBuffer.append(imei);
        String androidId = TbadkCoreApplication.getInst().getAndroidId();
        stringBuffer.append("androidId=");
        stringBuffer.append(androidId);
        String iMsi = TbadkCoreApplication.getInst().getIMsi();
        if (iMsi == null) {
            iMsi = "";
        }
        stringBuffer.append("imsi=");
        stringBuffer.append(iMsi);
        String str = Build.MODEL;
        stringBuffer.append("model=");
        stringBuffer.append(Build.MODEL);
        String str2 = Build.BRAND;
        stringBuffer.append("brand=");
        stringBuffer.append(str2);
        stringBuffer.append("platform=");
        stringBuffer.append("Android");
        String packageName = TbadkCoreApplication.getInst().getPackageName();
        stringBuffer.append("pkgName=");
        stringBuffer.append(packageName);
        String str3 = "" + j.netType();
        stringBuffer.append("network=");
        stringBuffer.append(str3);
        String str4 = "" + j.curOperatorType();
        stringBuffer.append("carrier=");
        stringBuffer.append(str4);
        String Td = g.Td();
        stringBuffer.append("manufacturer=");
        stringBuffer.append(Td);
        String str5 = Build.HARDWARE;
        stringBuffer.append("hardware=");
        stringBuffer.append(str5);
        String str6 = Build.BOARD;
        stringBuffer.append("board=");
        stringBuffer.append(str6);
        String str7 = g.dC(TbadkCoreApplication.getInst()) ? "1" : "0";
        stringBuffer.append("imu=");
        stringBuffer.append(str7);
        stringBuffer.append("tiebaclient!!!");
        String md5 = s.toMd5(stringBuffer.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", imei);
            jSONObject.put("androidId", androidId);
            jSONObject.put("imsi", iMsi);
            jSONObject.put("model", str);
            jSONObject.put(Constants.PHONE_BRAND, str2);
            jSONObject.put("platform", "Android");
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, packageName);
            jSONObject.put("network", str3);
            jSONObject.put("carrier", str4);
            jSONObject.put(HttpConstants.HTTP_MANUFACTURER, Td);
            jSONObject.put(HttpConstants.HTTP_HARDWARE, str5);
            jSONObject.put(HttpConstants.HTTP_BOARD, str6);
            jSONObject.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str7);
            jSONObject.put("sign", md5);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return "";
        }
    }

    private String tr(String str) {
        int i = 0;
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("activityId");
                String optString2 = jSONObject.optString("missionId");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(optString, optString2);
                    CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                    completeTaskReqMsg.completeId = jSONObject2.toString();
                    completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                    MessageManager.getInstance().sendMessage(completeTaskReqMsg);
                    i = 1;
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("resultCode", i);
            return jSONObject3.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
    }

    private String ts(String str) {
        int i = 0;
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("content");
                String optString2 = jSONObject.optString("linkUrl");
                String optString3 = jSONObject.optString("key");
                if (!TextUtils.isEmpty(optString) && (this.mContext instanceof Activity)) {
                    Activity activity = (Activity) this.mContext;
                    if (!TextUtils.isEmpty(optString3)) {
                        String str2 = "showToast_" + optString3;
                        int optInt = jSONObject.optInt("maxTimes");
                        int i2 = com.baidu.tbadk.core.sharedPref.b.aNV().getInt(str2, 0);
                        if (i2 < optInt) {
                            int i3 = i2 + 1;
                            com.baidu.tbadk.core.sharedPref.b.aNV().putInt(str2, i2);
                            com.baidu.tbadk.mutiprocess.g.publishEvent(new TipEvent(activity.getIntent(), optString, optString2));
                        }
                    } else {
                        com.baidu.tbadk.mutiprocess.g.publishEvent(new TipEvent(activity.getIntent(), optString, optString2));
                    }
                    i = 1;
                    activity.finish();
                }
                i = i;
            } catch (Exception e) {
                BdLog.e(e);
            }
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

    private String aHK() {
        JSONObject jSONObject;
        String aUk;
        int i = 0;
        try {
            aUk = com.baidu.tbadk.coreExtra.messageCenter.f.aUi().aUk();
        } catch (Exception e) {
            BdLog.e(e);
        }
        try {
            if (!TextUtils.isEmpty(aUk)) {
                jSONObject = new JSONObject(aUk);
                i = 1;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                jSONObject2.put("user_info", jSONObject);
                return jSONObject2.toString();
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            jSONObject22.put("user_info", jSONObject);
            return jSONObject22.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
        jSONObject = null;
    }

    private String tt(String str) {
        if (!aq.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt("finish_this_page", 1);
                if (!TextUtils.isEmpty(optString) && this.mContext != null) {
                    a.startWebActivity(this.mContext, optString);
                    if (optInt == 1 && (this.mContext instanceof Activity)) {
                        ((Activity) this.mContext).finish();
                        return "";
                    }
                    return "";
                }
                return "";
            } catch (Exception e) {
                BdLog.e(e);
                return "";
            }
        }
        return "";
    }
}
