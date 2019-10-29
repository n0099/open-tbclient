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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.util.m;
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
    private WebView bUD;
    private t bUE;
    private String bUF;
    private final Context mContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private com.baidu.tbadk.coreExtra.c.e shareItem;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, WebView webView) {
        this.SHOW_MORE_FORUM_ICON = "1";
        this.mContext = context;
        this.bUD = webView;
    }

    private String mi(String str) {
        if (this.bUD == null) {
            bc.checkUpIsLogin(this.mContext);
        } else {
            bc.n(this.mContext, this.bUD.getOriginalUrl(), str);
        }
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private String afI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FINISH_THIS_PAGE));
        return "";
    }

    private String afJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_PAGE_REFRESH));
        return "";
    }

    private void mj(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    jsPromptResult.confirm(mi(new JSONObject(str3).optString("cssUrl")));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        mj(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if ("personPageRefresh".equals(str2)) {
                try {
                    jsPromptResult.confirm(afJ());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if ("finishThisPage".equals(str2)) {
                try {
                    jsPromptResult.confirm(afI());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if ("registerShareData".equals(str2)) {
                try {
                    mq(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if ("gameShare".equals(str2)) {
                try {
                    mr(str3);
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
                jsPromptResult.confirm(ms(str3));
                return true;
            } else if (TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                jsPromptResult.confirm(mt(str3));
                return true;
            } else if ("getClipperInformation".equals(str2)) {
                jsPromptResult.confirm(afO());
                return true;
            } else if ("setClipperInformation".equals(str2)) {
                jsPromptResult.confirm(mu(str3));
                return true;
            } else if ("checkAppInstall".equals(str2)) {
                jsPromptResult.confirm(mv(str3));
                return true;
            } else if ("startApp".equals(str2)) {
                jsPromptResult.confirm(mw(str3));
                return true;
            } else if ("loadThirdPartyLogin".equals(str2)) {
                jsPromptResult.confirm(mp(str3));
            } else if ("hasNotificationPermission".equals(str2)) {
                jsPromptResult.confirm(afR());
                return true;
            } else if ("goToNotificationSetting".equals(str2)) {
                afS();
            } else if ("startDownloadCss".equals(str2)) {
                jsPromptResult.confirm(mx(str3));
            } else if ("springFestivalTimer".equals(str2)) {
                jsPromptResult.confirm(mo(str3));
            } else if ("isDisableGoBack".equals(str2)) {
                jsPromptResult.confirm(afT());
            } else if ("playVibrate".equals(str2)) {
                jsPromptResult.confirm(afN());
            } else if ("playSound".equals(str2)) {
                jsPromptResult.confirm(mn(str3));
            } else if ("startAccelerometer".equals(str2)) {
                jsPromptResult.confirm(mm(str3));
            } else if ("toastPopupView".equals(str2)) {
                jsPromptResult.confirm(mk(str3));
            } else if ("gamePush".equals(str2)) {
                jsPromptResult.confirm(ml(str3));
                return true;
            } else if ("gamePushStatus".equals(str2)) {
                jsPromptResult.confirm(afM());
                return true;
            } else if ("getSupplementInfo".equals(str2)) {
                jsPromptResult.confirm(afU());
                return true;
            } else if ("generalPreferences".equals(str2)) {
                jsPromptResult.confirm(afL());
            } else if ("completeTask".equals(str2)) {
                jsPromptResult.confirm(my(str3));
            }
        }
        return false;
    }

    private t afK() {
        if (this.bUE == null) {
            this.bUE = new t(this.mContext, new t.a() { // from class: com.baidu.tbadk.browser.b.1
                @Override // com.baidu.tbadk.BdToken.t.a
                public void aeL() {
                    if (!TextUtils.isEmpty(b.this.bUF)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("resultCode", 1);
                            b.this.l(b.this.bUF, jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.bUE;
    }

    private String mk(String str) {
        int i;
        try {
            com.baidu.tbadk.BdToken.completeTask.a aVar = new com.baidu.tbadk.BdToken.completeTask.a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.showType = jSONObject.optInt("show_type");
            aVar.bTs = jSONObject.optInt("ahead_type");
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
            if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.bTm) {
                h.b(TbadkCoreApplication.getInst().getCurrentActivity(), aVar).akZ();
            } else if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.bTn) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                com.baidu.tbadk.core.business.b bVar = new com.baidu.tbadk.core.business.b(currentActivity);
                if (currentActivity != null) {
                    bVar.a(currentActivity, aVar);
                    bVar.show();
                }
            } else if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.bTo) {
                if (aVar.bTs == com.baidu.tbadk.BdToken.completeTask.a.bTq) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), aVar.schema) && !aq.isEmpty(aVar.url)) {
                        lY(aVar.url + "?page_type=open_full_screen_opacity_web_page");
                    }
                } else if (aVar.bTs == com.baidu.tbadk.BdToken.completeTask.a.bTr && !aq.isEmpty(aVar.url)) {
                    lY(aVar.url + "?page_type=open_full_screen_opacity_web_page");
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

    private String ml(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921404, str));
        return "1";
    }

    private String afL() {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_bawu_task_toast", -1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String afM() {
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_match_id_list_football", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("key_match_id_list_basketball", "");
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

    private void lY(String str) {
        TbPageContext<?> X;
        if (!aq.isEmpty(str) && (X = X(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.amQ().b(X, new String[]{str});
        }
    }

    private TbPageContext X(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    private String mm(String str) {
        int i;
        try {
            this.bUF = new JSONObject(str).optString("method_name");
            if (!afK().isOpen()) {
                afK().open();
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

    private String mn(String str) {
        int i = 0;
        try {
            String optString = new JSONObject(str).optString("soundUrl");
            if (j.isNetWorkAvailable()) {
                afK().lX(optString);
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

    private String afN() {
        int i = 0;
        if (afK().aeK()) {
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

    private String mo(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("open");
            String optString = jSONObject.optString("method_name");
            i iVar = new i();
            iVar.eW(optBoolean);
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

    private String mp(String str) {
        int i;
        try {
            if (!aq.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    D(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId"));
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

    private void D(int i, String str) {
        if (this.mContext != null) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            if (this.bUD != null) {
                loginActivityConfig.setUrl(this.bUD.getOriginalUrl());
            }
            bc.a(loginActivityConfig);
        }
    }

    private void mq(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE, str));
    }

    private void mr(String str) {
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

    private String ms(String str) {
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

    private void setShareItem(com.baidu.tbadk.coreExtra.c.e eVar) {
        this.shareItem = eVar;
    }

    private void M(String str, final int i) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(currentActivity)) {
                m mVar = new m(currentActivity, str, new m.a() { // from class: com.baidu.tbadk.browser.b.2
                    @Override // com.baidu.tbadk.util.m.a
                    public void onError(int i2, String str2) {
                    }

                    @Override // com.baidu.tbadk.util.m.a
                    public void onSuccess(String str2) {
                        if (new File(str2).exists()) {
                            if (b.this.shareItem != null) {
                                b.this.shareItem.shareType = 1;
                                b.this.shareItem.cyG = str2;
                            }
                            if (i != 0) {
                                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mContext, i, b.this.shareItem, true));
                            }
                        }
                    }
                });
                mVar.setFrom(1);
                mVar.execute(new String[0]);
            }
        }
    }

    private String mt(String str) {
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
            if (!aq.isEmpty(str) && (runTask = MessageManager.getInstance().runTask(2016568, com.baidu.tbadk.coreExtra.c.e.class, str)) != null) {
                com.baidu.tbadk.coreExtra.c.e eVar = (com.baidu.tbadk.coreExtra.c.e) runTask.getData();
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
                    eVar.imageUrl = optString;
                    eVar.linkUrl = optString3;
                    eVar.title = optString4 + HanziToPinyin.Token.SEPARATOR + optString5;
                    eVar.cyC = true;
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    com.baidu.tieba.c.e.bcj().a(shareDialogConfig);
                    return "";
                }
                if (optInt == 0) {
                    if (eVar != null && !aq.isEmpty(optString) && optInt2 == 1) {
                        setShareItem(eVar);
                        M(optString, optInt);
                    }
                    a(eVar);
                } else if (eVar != null && !aq.isEmpty(optString) && optInt2 == 1) {
                    setShareItem(eVar);
                    M(optString, optInt);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, optInt, eVar, true));
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

    protected void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, eVar, true);
            if (eVar.shareType != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
            anVar.O("obj_type", 1);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private String afO() {
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

    private String mu(String str) {
        int i = 0;
        if (!aq.isEmpty(str)) {
            try {
                com.baidu.adp.lib.util.a.copyToClipboard(new JSONObject(str).optString("txt"));
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

    public void a(int i, com.baidu.tbadk.coreExtra.c.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", eVar.title);
            jSONObject2.put("desc", eVar.content);
            jSONObject2.put("img", eVar.imageUri);
            jSONObject2.put("url", eVar.linkUrl);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", i);
            jSONObject3.put("shareData", jSONObject2);
            jSONObject.put("resultCode", 1);
            jSONObject.put("data", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        l("ShareSuccessNotification", jSONObject);
    }

    public void E(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
            jSONObject.put("socialType", i);
            jSONObject.put("activityId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        l("thirdPartyLoginResultToH5", jSONObject);
    }

    public void dQ(boolean z) {
        if (z) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            l("loginResultToH5", jSONObject);
        }
    }

    public void afP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        l("reshow", jSONObject);
    }

    public String mv(String str) {
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
    public String mw(String str) {
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
                List<String> apc = com.baidu.tbadk.coreExtra.data.f.apc();
                if (e(apc, optString2)) {
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
                        if (e(apc, optString) && (launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(optString)) != null) {
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

    public void afQ() {
        l("clickGoBackToH5", new JSONObject());
    }

    public void k(String str, JSONObject jSONObject) {
        l(str, jSONObject);
    }

    public String afR() {
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

    public void afS() {
        try {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public String mx(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!aq.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("downloadUrl");
                if (aq.isEmpty(optString)) {
                    jSONObject.put("resultCode", 0);
                    return jSONObject.toString();
                }
                String nH = com.baidu.tbadk.core.util.m.nH(optString);
                String nI = com.baidu.tbadk.core.util.m.nI(optString);
                if (!com.baidu.tbadk.core.util.m.nG(nI)) {
                    jSONObject.put("resultCode", 0);
                    return jSONObject.toString();
                }
                DownloadData downloadData = new DownloadData(nH, nH, optString, null);
                downloadData.setPath(nI);
                com.baidu.tbadk.download.d.atV().f(downloadData);
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return jSONObject.toString();
    }

    private String afT() {
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
        if (this.bUE != null && this.bUE.isOpen()) {
            this.bUE.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, JSONObject jSONObject) {
        if (this.bUD != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.bUD.evaluateJavascript("javascript:" + str + "('" + jSONObject.toString() + "')", null);
            } else {
                this.bUD.loadUrl("javascript:" + str + "('" + jSONObject.toString() + "')");
            }
        }
    }

    private String afU() {
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

    private String my(String str) {
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
}
