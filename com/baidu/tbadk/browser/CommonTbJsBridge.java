package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.app.NotificationManagerCompat;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.business.a;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@com.baidu.c.a.a
/* loaded from: classes.dex */
public class CommonTbJsBridge implements com.baidu.tieba.tbadkCore.e.b {
    private static final String CHANGE_SKIN_TYPE = "changeSkinType";
    private static final String CHECK_APP_INSTALL = "checkAppInstall";
    private static final String CLICK_GO_BACK_TO_H5 = "clickGoBackToH5";
    private static final String CLOSE_NATIVE_MASK = "closeNativeMask";
    private static final String COMPLETE_TASK = "completeTask";
    private static final String DELETE_OFFLINE_BUNDLE = "deleteOfflineBundle";
    private static final String DisableSlideBack = "disableSlideBack";
    private static final String FETCH_OFFLINE_USER_INFO = "getOfflineUserInfo";
    private static final String FINISH_THIS_PAGE = "finishThisPage";
    private static final String GAME_PUSH = "gamePush";
    private static final String GAME_PUSH_STATUS = "gamePushStatus";
    private static final String GAME_SHARE = "gameShare";
    private static final String GENERAL_PREFERENCES = "generalPreferences";
    private static final String GET_APIS = "getAPIs";
    private static final String GET_CLIPPER_INFORMATION = "getClipperInformation";
    private static final String GET_DEVICE_INFO = "getDeviceInfo";
    private static final String GET_MODAL_DATA = "getModalData";
    private static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    private static final String GET_ZID = "getZid";
    private static final String GO_TO_BAR_DETAIL_PAGE = "jumpBarDetail";
    private static final String GO_TO_GOODS_SHOP = "goToGoodsShop";
    private static final String GO_TO_HOT_TREND = "goToHotTrend";
    private static final String GO_TO_MY_LIVE = "goToMyLive";
    private static final String GO_TO_MY_POST = "goToMyPost";
    private static final String GO_TO_NOTIFICATIONSETTING = "goToNotificationSetting";
    private static final String GO_TO_PB = "goToPB";
    private static final String HAS_NOTIFICATION_PERMISSION = "hasNotificationPermission";
    private static final String HIDE_WEBVIEW_LOADING = "hideWebLoading";
    protected static final String INTERFACE_NAME = "CommonJSBridge";
    private static final String IS_DISABLE_GO_BACK = "isDisableGoBack";
    private static final String JUMP_TO_HTML_PAGE = "jumpToHTMLPage";
    private static final String LOAD_THIRD_PARTY_LOGIN = "loadThirdPartyLogin";
    private static final String LOGIN_RESULT_TO_H5 = "loginResultToH5";
    private static final String ORIGINAL_THREAD = "1";
    private static final String PERSON_PAGE_REFRESH = "personPageRefresh";
    private static final String PERSON_PAGE_SHARE = "registerShareData";
    private static final String PLAY_SOUND = "playSound";
    private static final String PLAY_VIBRATE = "playVibrate";
    private static final String RESULT_THIRD_PARTY_LOGIN = "thirdPartyLoginResultToH5";
    private static final String RE_SHOW = "reshow";
    private static final String SAVE_IMAGE = "saveImage";
    private static final String SET_CLIPPER_INFORMATION = "setClipperInformation";
    private static final String SET_SHARE_INFO = "registerShareDataNew";
    private static final String SHARE = "share";
    private static final String SHARE_SUCCCESS_NOTIFICATION = "ShareSuccessNotification";
    private static final String SHOW_ALERTVIEW = "showAlertView";
    private static final String SHOW_TIP_TOAST = "showTipToast";
    private static final String SPRING_FESTIVAL_TIMER = "springFestivalTimer";
    private static final String START_ACCELEROMETER = "startAccelerometer";
    private static final String START_APP = "startApp";
    private static final String START_DOWNLOAD_CSS = "startDownloadCss";
    private static final String START_LOGIN_MODULE = "startLoginModule";
    private static final String SWITCH_OFFLINE_BUNDLE_STATUS = "switchOfflineBundleStatus";
    private static final String SWITCH_OFFLINE_INTERFACE = "switchOfflineInterface";
    private static final String SWITCH_URL_HOST = "switchUrlHost";
    private static final String TAG = "CommonTbJsBridge";
    private static final String THREAD_FLOOR = "2";
    private static final String THREAD_MEZZANINE_FLOOR = "3";
    private static final String TOAST_POPUPVIEW = "toastPopupView";
    private static final String UPDATE_OFFLINE_BUNDLE = "updateOfflineBundle";
    private static String tempUrl = TbConfig.SERVER_ADDRESS + TbConfig.WEBVIEW_CACHE_URL;
    private final String SHOW_MORE_FORUM_ICON;
    private com.baidu.tieba.tbadkCore.e.a jsPromptBridge;
    private final Context mContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private JsPromptResult mResult;
    private v mShakeController;
    private WebView mWebView;
    private String shakeCallbackjsMethod;
    private ShareItem shareItem;

    public CommonTbJsBridge(Context context) {
        this(context, null);
    }

    public CommonTbJsBridge(Context context, WebView webView) {
        this.SHOW_MORE_FORUM_ICON = "1";
        this.mContext = context;
        this.mWebView = webView;
    }

    public void setJsPromptBridge(com.baidu.tieba.tbadkCore.e.a aVar) {
        this.jsPromptBridge = aVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c startLoginModule(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (this.mWebView == null) {
            bg.checkUpIsLogin(this.mContext);
        } else {
            bg.t(this.mContext, this.mWebView.getOriginalUrl(), str);
        }
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        cVar.setData(OrmObject.jsonStrWithObject(jSResultData));
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c finishPage() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).finish();
        }
        return cVar;
    }

    private String refreshPage() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_PAGE_REFRESH));
        return "";
    }

    private void hideWebviewLoading(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (START_LOGIN_MODULE.equals(str2)) {
                try {
                    jsPromptResult.confirm(startLoginModule(new JSONObject(str3).optString("cssUrl")).getData());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (HIDE_WEBVIEW_LOADING.equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        hideWebviewLoading(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (PERSON_PAGE_REFRESH.equals(str2)) {
                try {
                    jsPromptResult.confirm(refreshPage());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (FINISH_THIS_PAGE.equals(str2)) {
                try {
                    jsPromptResult.confirm(finishPage().getData());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (PERSON_PAGE_SHARE.equals(str2)) {
                try {
                    showRightShare(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (GAME_SHARE.equals(str2)) {
                try {
                    goToGameShare(str3);
                    jsPromptResult.confirm();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                return true;
            } else if (GET_ZID.equals(str2)) {
                jsPromptResult.confirm(getZid().getData());
                return true;
            } else if (SET_SHARE_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(setShareInfo(jSONObject.optString("title"), jSONObject.optString("desc"), jSONObject.optString("img"), jSONObject.optString("url"), jSONObject.optString(AlbumActivityConfig.FROM_TOPIC), jSONObject.optString("wbtitle"), jSONObject.optString("wbcontent"), jSONObject.optString("isShowMoreForum"), jSONObject.optInt("shareimg"), jSONObject.optString("extdata")).getData());
                } catch (JSONException e7) {
                    BdLog.e(e7);
                }
                return true;
            } else if ("share".equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(share(jSONObject2.optInt("channel"), jSONObject2.optInt("shareimg"), jSONObject2.optString("img"), jSONObject2.optString("isShowMoreForum"), jSONObject2.optString("url"), jSONObject2.optString("title"), jSONObject2.optString("desc"), jSONObject2.optString(AlbumActivityConfig.FROM_TOPIC), jSONObject2.optString("wbtitle"), jSONObject2.optString("wbcontent"), jSONObject2.optInt("weixin_disable"), jSONObject2.optString("extdata")).getData());
                } catch (JSONException e8) {
                    BdLog.e(e8);
                }
                return true;
            } else if (GET_CLIPPER_INFORMATION.equals(str2)) {
                jsPromptResult.confirm(getClipperInformation().getData());
                return true;
            } else if (SET_CLIPPER_INFORMATION.equals(str2)) {
                try {
                    jsPromptResult.confirm(setClipperInformation(new JSONObject(str3).optString(DocumentOpenUtil.TXT)).getData());
                } catch (JSONException e9) {
                    BdLog.e(e9);
                }
                return true;
            } else if (CHECK_APP_INSTALL.equals(str2)) {
                try {
                    jsPromptResult.confirm(checkAppInstall(new JSONObject(str3).optString(PushClientConstants.TAG_PKG_NAME)).getData());
                } catch (JSONException e10) {
                    BdLog.e(e10);
                }
                return true;
            } else if (START_APP.equals(str2)) {
                jsPromptResult.confirm(startApp(str3));
                return true;
            } else if (LOAD_THIRD_PARTY_LOGIN.equals(str2)) {
                jsPromptResult.confirm(loadThirdPartyLogin(str3));
            } else if (HAS_NOTIFICATION_PERMISSION.equals(str2)) {
                jsPromptResult.confirm(hasNotificationPermission().getData());
                return true;
            } else if (GO_TO_NOTIFICATIONSETTING.equals(str2)) {
                goToNotificationSetting();
            } else if (START_DOWNLOAD_CSS.equals(str2)) {
                try {
                    jsPromptResult.confirm(startDownloadCss(new JSONObject(str3).optString("downloadUrl")).getData());
                } catch (JSONException e11) {
                    BdLog.e(e11);
                }
            } else if (SPRING_FESTIVAL_TIMER.equals(str2)) {
                jsPromptResult.confirm(parseSpringFestivalTimer(str3));
            } else if (IS_DISABLE_GO_BACK.equals(str2)) {
                jsPromptResult.confirm(setDisableGoBack().getData());
            } else if (PLAY_VIBRATE.equals(str2)) {
                jsPromptResult.confirm(playVibrate().getData());
            } else if (PLAY_SOUND.equals(str2)) {
                try {
                    jsPromptResult.confirm(playSound(new JSONObject(str3).optString("soundUrl")).getData());
                } catch (JSONException e12) {
                    BdLog.e(e12);
                }
            } else if (SHOW_ALERTVIEW.equals(str2)) {
                try {
                    this.mResult = jsPromptResult;
                    JSONObject jSONObject3 = new JSONObject(str3);
                    showAlertView(jSONObject3.optString("title"), jSONObject3.optString("sub_title"), jSONObject3.optInt("btn_corner"), jSONObject3.optInt("btn_borderWidth"), jSONObject3.optString("cancel_btn_text"), jSONObject3.optString("cancel_btn_color"), jSONObject3.optString("cancel_btn_borderColor"), jSONObject3.optString("confirm_btn_text"), jSONObject3.optString("confirm_btn_color"), jSONObject3.optString("confirm_btn_borderColor"), jSONObject3.optString("confirm_btn_url"));
                } catch (JSONException e13) {
                    BdLog.e(e13);
                }
            } else if (START_ACCELEROMETER.equals(str2)) {
                jsPromptResult.confirm(startAcceleromter(str3));
            } else if (DisableSlideBack.equals(str2)) {
                try {
                    jsPromptResult.confirm(disableBack(new JSONObject(str3).optInt("disable")).getData());
                } catch (JSONException e14) {
                    BdLog.e(e14);
                }
            } else if (TOAST_POPUPVIEW.equals(str2)) {
                try {
                    JSONObject jSONObject4 = new JSONObject(str3);
                    jsPromptResult.confirm(showLowerHairHint(jSONObject4.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject4.optInt("ahead_type"), jSONObject4.optString("message"), jSONObject4.optString("btn_text"), jSONObject4.optInt("toast_duration"), jSONObject4.optString("schema"), jSONObject4.optString("token"), jSONObject4.optDouble("opacity"), jSONObject4.optString(BigdayActivityConfig.IMG_URL), jSONObject4.optString("url"), jSONObject4.optInt("mission_id"), jSONObject4.optString("btn_color"), jSONObject4.optString("message_color"), jSONObject4.optString("btn_text_color"), jSONObject4.optInt("status"), jSONObject4.optInt(FINISH_THIS_PAGE)).getData());
                } catch (JSONException e15) {
                    BdLog.e(e15);
                }
            } else if (GAME_PUSH.equals(str2)) {
                jsPromptResult.confirm(handleGamePush(str3));
                return true;
            } else if (GAME_PUSH_STATUS.equals(str2)) {
                jsPromptResult.confirm(handleGamePushStatus());
                return true;
            } else if (GO_TO_MY_POST.equals(str2)) {
                try {
                    jsPromptResult.confirm(handleGoToMyPost(new JSONObject(str3).optString("uid")).getData());
                } catch (JSONException e16) {
                    BdLog.e(e16);
                }
                return true;
            } else if (GO_TO_MY_LIVE.equals(str2)) {
                try {
                    jsPromptResult.confirm(handleGoToMyLive(new JSONObject(str3).optString("uid")).getData());
                } catch (JSONException e17) {
                    BdLog.e(e17);
                }
                return true;
            } else if (SAVE_IMAGE.equals(str2)) {
                try {
                    jsPromptResult.confirm(handleSaveImage(new JSONObject(str3).optString("imgUrl")).getData());
                } catch (JSONException e18) {
                    BdLog.e(e18);
                }
                return true;
            } else if (GET_SUPPLEMENT_INFO.equals(str2)) {
                jsPromptResult.confirm(getSupplementInfo().getData());
                return true;
            } else if (GET_DEVICE_INFO.equals(str2)) {
                jsPromptResult.confirm(getDeviceInfo().getData());
                return true;
            } else if (GENERAL_PREFERENCES.equals(str2)) {
                jsPromptResult.confirm(generalSharePreferences());
            } else if (COMPLETE_TASK.equals(str2)) {
                try {
                    JSONObject jSONObject5 = new JSONObject(str3);
                    jsPromptResult.confirm(sendCompleteTaskReqMsg(jSONObject5.optString("activityId"), jSONObject5.optString("missionId")).getData());
                } catch (JSONException e19) {
                    BdLog.e(e19);
                }
            } else if (GET_MODAL_DATA.equals(str2)) {
                jsPromptResult.confirm(getGetModalData());
            } else if (SHOW_TIP_TOAST.equals(str2)) {
                try {
                    JSONObject jSONObject6 = new JSONObject(str3);
                    jsPromptResult.confirm(showTipToast(jSONObject6.optString("content"), jSONObject6.optString("linkUrl"), jSONObject6.optString("key"), jSONObject6.optInt("maxTimes"), jSONObject6.optInt(FINISH_THIS_PAGE)).getData());
                } catch (JSONException e20) {
                    BdLog.e(e20);
                }
            } else if (JUMP_TO_HTML_PAGE.equals(str2)) {
                try {
                    JSONObject jSONObject7 = new JSONObject(str3);
                    jsPromptResult.confirm(jumpToHtmlPage(jSONObject7.optString("url"), jSONObject7.optInt("finish_this_page", 1)).toString());
                } catch (JSONException e21) {
                    BdLog.e(e21);
                }
            } else if (CLOSE_NATIVE_MASK.equals(str2)) {
                jsPromptResult.confirm(closeNativeMask(str3));
            } else if (GO_TO_HOT_TREND.equals(str2)) {
                jumpToHotTrendPage();
                jsPromptResult.confirm();
            } else if (GO_TO_PB.equals(str2)) {
                try {
                    JSONObject jSONObject8 = new JSONObject(str3);
                    String optString2 = jSONObject8.optString("tid");
                    String optString3 = jSONObject8.optString("fr");
                    if (!StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                        jumpToPbPage(optString2, optString3);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e22) {
                    e22.printStackTrace();
                }
            } else if (GET_APIS.equals(str2)) {
                jsPromptResult.confirm(getAPIs());
                return true;
            }
        }
        return false;
    }

    private v getShakeController() {
        if (this.mShakeController == null) {
            this.mShakeController = new v(this.mContext, new v.a() { // from class: com.baidu.tbadk.browser.CommonTbJsBridge.1
                @Override // com.baidu.tbadk.BdToken.v.a
                public void bmb() {
                    if (!TextUtils.isEmpty(CommonTbJsBridge.this.shakeCallbackjsMethod)) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("resultCode", 1);
                            CommonTbJsBridge.this.callJsMethod(CommonTbJsBridge.this.shakeCallbackjsMethod, jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.mShakeController;
    }

    public com.baidu.tieba.tbadkCore.e.a.c showLowerHairHint(int i, int i2, String str, String str2, int i3, String str3, String str4, double d, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        com.baidu.tbadk.BdToken.completeTask.a aVar = new com.baidu.tbadk.BdToken.completeTask.a();
        aVar.showType = i;
        aVar.eIg = i2;
        aVar.message = str;
        aVar.btnText = str2;
        aVar.duration = i3;
        aVar.schema = str3;
        aVar.token = str4;
        aVar.opacity = d;
        aVar.imgUrl = str5;
        aVar.url = str6;
        aVar.missionId = i4;
        aVar.btn_color = str7;
        aVar.message_color = str8;
        aVar.btn_text_color = str9;
        if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.eHZ) {
            h.b(TbadkCoreApplication.getInst().getCurrentActivity(), aVar).bun();
        } else if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.eIa) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            com.baidu.tbadk.core.business.c cVar2 = new com.baidu.tbadk.core.business.c(currentActivity);
            if (currentActivity != null) {
                cVar2.a(currentActivity, aVar);
                cVar2.show();
            }
        } else if (aVar.showType == com.baidu.tbadk.BdToken.completeTask.a.eIb) {
            if (aVar.eIg == com.baidu.tbadk.BdToken.completeTask.a.eIe) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), aVar.schema) && !at.isEmpty(aVar.url)) {
                    dealJump(aVar.url + "?page_type=open_full_screen_opacity_web_page");
                }
            } else if (aVar.eIg == com.baidu.tbadk.BdToken.completeTask.a.eIf && !at.isEmpty(aVar.url)) {
                dealJump(aVar.url + "?page_type=open_full_screen_opacity_web_page");
            }
        } else if (i == com.baidu.tbadk.BdToken.completeTask.a.eId) {
            if (i6 == 1 && (this.mContext instanceof Activity)) {
                ((Activity) this.mContext).finish();
            }
            g.publishEvent(new TopToastEvent(i5, str));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    private String handleGamePush(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921404, str));
        return "1";
    }

    private String generalSharePreferences() {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_bawu_task_toast", -1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String handleGamePushStatus() {
        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_match_id_list_football", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_match_id_list_basketball", "");
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

    public com.baidu.tieba.tbadkCore.e.a.c handleGoToMyPost(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mContext, str, 0, null)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 0);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c handleGoToBarDetail(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.mContext, str, ForumDetailActivityConfig.FromType.BLUEV_SETTLE)));
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c handleGoToMyLive(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mContext, str, "", "", 0, true)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c handleSaveImage(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        if (!(this.mContext instanceof Activity)) {
            cVar.dPI();
            return cVar;
        }
        this.mPermissionJudgement.appendRequestPermission((Activity) this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission((Activity) this.mContext)) {
            cVar.Ts("权限申请");
            return cVar;
        }
        new o((Activity) this.mContext, str, new o.a() { // from class: com.baidu.tbadk.browser.CommonTbJsBridge.2
            @Override // com.baidu.tbadk.util.o.a
            public void onError(int i, String str2) {
                if (CommonTbJsBridge.this.jsPromptBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("result", -1);
                    CommonTbJsBridge.this.jsPromptBridge.a(CommonTbJsBridge.this.mWebView, "saveImageSuccess", linkedHashMap);
                }
            }

            @Override // com.baidu.tbadk.util.o.a
            public void onSuccess(String str2) {
                if (CommonTbJsBridge.this.jsPromptBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("result", 0);
                    CommonTbJsBridge.this.jsPromptBridge.a(CommonTbJsBridge.this.mWebView, "saveImageSuccess", linkedHashMap);
                }
            }
        }).execute(new String[0]);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 0);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c saveImageSuccess(HashMap<String, Integer> hashMap) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (hashMap != null && hashMap.get("result").intValue() == -1) {
            cVar.Ts("图片保存错误");
        }
        return cVar;
    }

    private void dealJump(String str) {
        TbPageContext<?> currentActivityPageContext;
        if (!at.isEmpty(str) && (currentActivityPageContext = getCurrentActivityPageContext(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.bwv().b(currentActivityPageContext, new String[]{str});
        }
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    private String startAcceleromter(String str) {
        int i;
        try {
            this.shakeCallbackjsMethod = new JSONObject(str).optString("method_name");
            if (!getShakeController().isOpen()) {
                getShakeController().open();
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

    public com.baidu.tieba.tbadkCore.e.a.c playSound(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        int i = 0;
        if (j.isNetWorkAvailable()) {
            getShakeController().Af(str);
            i = 1;
        } else if (this.mContext != null) {
            l.showToast(this.mContext, R.string.neterror);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c playVibrate() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        int i = 0;
        if (getShakeController().bma()) {
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return cVar;
    }

    private String parseSpringFestivalTimer(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("open");
            String optString = jSONObject.optString("method_name");
            com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
            lVar.setOpen(optBoolean);
            lVar.setMethod(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156673, lVar));
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

    private String loadThirdPartyLogin(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return jumpLoginActivity(jSONObject.optInt("socialType", 0), jSONObject.optString("activityId")).getData();
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return null;
    }

    public com.baidu.tieba.tbadkCore.e.a.c jumpLoginActivity(int i, String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        JSONObject jSONObject = new JSONObject();
        if (this.mContext == null) {
            try {
                jSONObject.put("resultCode", 0);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            cVar.setData(jSONObject.toString());
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.mContext, true);
            loginActivityConfig.setThirdPartyLoginForResult(i, str);
            if (this.mWebView != null) {
                loginActivityConfig.setUrl(this.mWebView.getOriginalUrl());
            }
            bg.a(loginActivityConfig);
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            cVar.setData(jSONObject.toString());
        }
        return cVar;
    }

    private void showRightShare(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE, str));
    }

    private void goToGameShare(String str) {
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

    public com.baidu.tieba.tbadkCore.e.a.c getZid() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        String zid = TbadkCoreApplication.getInst().getZid();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("zid", zid);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c setShareInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9) {
        int i2;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", str);
            jSONObject.put("desc", str2);
            jSONObject.put("img", str3);
            jSONObject.put("url", str4);
            jSONObject.put(AlbumActivityConfig.FROM_TOPIC, str5);
            jSONObject.put("wbtitle", str6);
            jSONObject.put("wbcontent", str7);
            jSONObject.put("isShowMoreForum", str8);
            jSONObject.put("shareimg", i);
            jSONObject.put("extdata", str9);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        String jSONObject2 = jSONObject.toString();
        if (at.isEmpty(jSONObject2)) {
            i2 = 0;
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, jSONObject2));
            i2 = 1;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("resultCode", i2);
            cVar.setData(jSONObject3.toString());
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return cVar;
    }

    private ShareItem getShareItem() {
        return this.shareItem;
    }

    private void setShareItem(ShareItem shareItem) {
        this.shareItem = shareItem;
    }

    private void shareLoacalImage(String str, final int i) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(currentActivity)) {
                o oVar = new o(currentActivity, str, new o.a() { // from class: com.baidu.tbadk.browser.CommonTbJsBridge.3
                    @Override // com.baidu.tbadk.util.o.a
                    public void onError(int i2, String str2) {
                    }

                    @Override // com.baidu.tbadk.util.o.a
                    public void onSuccess(String str2) {
                        if (new File(str2).exists()) {
                            if (CommonTbJsBridge.this.shareItem != null) {
                                CommonTbJsBridge.this.shareItem.shareType = 1;
                                CommonTbJsBridge.this.shareItem.localFile = str2;
                            }
                            if (i != 0) {
                                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(CommonTbJsBridge.this.mContext, i, CommonTbJsBridge.this.shareItem, true));
                            }
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c share(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9) {
        int i4;
        CustomResponsedMessage runTask;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", i);
            jSONObject.put("shareimg", i2);
            jSONObject.put("img", str);
            jSONObject.put("isShowMoreForum", str2);
            jSONObject.put("url", str3);
            jSONObject.put("title", str4);
            jSONObject.put("desc", str5);
            jSONObject.put(AlbumActivityConfig.FROM_TOPIC, str6);
            jSONObject.put("wbtitle", str7);
            jSONObject.put("wbcontent", str8);
            jSONObject.put("weixin_disable", i3);
            jSONObject.put("extdata", str9);
        } catch (JSONException e) {
            BdLog.e(e);
        }
        String jSONObject2 = jSONObject.toString();
        if (at.isEmpty(jSONObject2) || (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject2)) == null) {
            i4 = 0;
        } else {
            ShareItem shareItem = (ShareItem) runTask.getData();
            if (shareItem != null) {
                shareItem.fxo = 17;
            }
            if ("1".equals(str2) && shareItem != null) {
                shareItem.imageUrl = str;
                shareItem.linkUrl = str3;
                shareItem.title = str4 + " " + str5;
                shareItem.fxi = true;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.cwf().b(shareDialogConfig);
                cVar.setData("");
                return cVar;
            }
            if (i == 0) {
                if (shareItem != null && !at.isEmpty(str) && i2 == 1) {
                    setShareItem(shareItem);
                    shareLoacalImage(str, i);
                }
                showShareDialog(shareItem);
            } else if (shareItem != null && !at.isEmpty(str) && i2 == 1) {
                setShareItem(shareItem);
                shareLoacalImage(str, i);
            } else {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, i, shareItem, true));
            }
            i4 = 1;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("resultCode", i4);
            cVar.setData(jSONObject3.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    protected void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true);
            if (shareItem.shareType != 0) {
                shareDialogConfig.hideMode |= 32;
            }
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dX(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.an("obj_type", 1);
            TiebaStatic.log(aqVar);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c getClipperInformation() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        int i = 0;
        String clipBoardContent = UtilHelper.getClipBoardContent();
        if (!at.isEmpty(clipBoardContent)) {
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            jSONObject.put("data", clipBoardContent);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c setClipperInformation(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        com.baidu.adp.lib.util.a.copyToClipboard(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c goToEditPost(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if ("1".equals(str)) {
            WriteActivityConfig.newInstance(this.mContext).setType(9).setForumWriteData(new ForumWriteData(str6, str7, null, null)).setIsSaveDraft(false).setContent(str5).setFrom("frs").setCallFrom("2").send();
        } else if ("2".equals(str)) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str2, null, null);
            createNormalCfg.setJumpToCommentArea(true);
            createNormalCfg.showOpenEditorTips(str5);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        } else if ("3".equals(str)) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.mContext).createSubPbActivityConfig(str2, str4, "mention", false, "", false, str4, 0);
            createSubPbActivityConfig.showOpenEditorTips(str5);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c changeSkinTypeInH5(HashMap hashMap) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (hashMap != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callJsMethod(CHANGE_SKIN_TYPE, jSONObject);
            cVar.setData(jSONObject.toString());
        }
        return cVar;
    }

    private String closeNativeMask(String str) {
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

    public com.baidu.tieba.tbadkCore.e.a.c shareSuccessNotification(HashMap hashMap) {
        int intValue = ((Integer) hashMap.get("shareChannel")).intValue();
        ShareItem shareItem = (ShareItem) hashMap.get("shareItem");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", shareItem.title);
            jSONObject2.put("desc", shareItem.content);
            jSONObject2.put("img", shareItem.imageUri);
            jSONObject2.put("url", shareItem.linkUrl);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", intValue);
            jSONObject3.put("shareData", jSONObject2);
            jSONObject.put("resultCode", 1);
            jSONObject.put("data", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callJsMethod(SHARE_SUCCCESS_NOTIFICATION, jSONObject);
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        cVar.setData(jSONObject.toString());
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c thirdPartyLoginResultToH5(HashMap hashMap) {
        if (hashMap == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
            jSONObject.put("socialType", hashMap.get(LoginActivityConfig.SOCIAL_TYPE));
            jSONObject.put("activityId", hashMap.get("activityId"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callJsMethod(RESULT_THIRD_PARTY_LOGIN, jSONObject);
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        cVar.setData(jSONObject.toString());
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c onUserLoginChanged(HashMap hashMap) {
        if (hashMap == null || hashMap.get("isLogin") == null) {
            return null;
        }
        if (((Boolean) hashMap.get("isLogin")).booleanValue()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callJsMethod(LOGIN_RESULT_TO_H5, jSONObject);
            com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
            cVar.setData(jSONObject.toString());
            return cVar;
        }
        return null;
    }

    public com.baidu.tieba.tbadkCore.e.a.c reShow(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callJsMethod(RE_SHOW, jSONObject);
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        cVar.setData(jSONObject.toString());
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c checkAppInstall(String str) {
        int i = 0;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (!StringUtils.isNull(str) && UtilHelper.isInstalledPackage(this.mContext, str)) {
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c disableBack(int i) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (this.mContext instanceof TbWebViewActivity) {
            if (i == 0) {
                ((TbWebViewActivity) this.mContext).setSwipeBackEnabled(true);
            } else {
                ((TbWebViewActivity) this.mContext).setSwipeBackEnabled(false);
            }
        }
        return cVar;
    }

    private boolean isLegalSchema(List<String> list, String str) {
        if (StringUtils.isNull(str) || x.isEmpty(list)) {
            return false;
        }
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public String startApp(String str) {
        if (!at.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return startApp(jSONObject.optString(PushClientConstants.TAG_PKG_NAME), jSONObject.optString("schema")).getData();
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resultCode", 0);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c startApp(String str, String str2) {
        boolean z;
        Intent launchIntentForPackage;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        List<String> bzI = com.baidu.tbadk.coreExtra.data.g.bzI();
        if (isLegalSchema(bzI, str2)) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str2));
            try {
                this.mContext.startActivity(intent);
                z = true;
            } catch (ActivityNotFoundException e) {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && isLegalSchema(bzI, str) && (launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(str)) != null) {
            this.mContext.startActivity(launchIntentForPackage);
            z = true;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", z ? 1 : 0);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c dealClickGoBackToH5(HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resultCode", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callJsMethod(CLICK_GO_BACK_TO_H5, jSONObject);
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        cVar.setData(jSONObject.toString());
        return cVar;
    }

    public void dealSpringFestivalTimer(String str, JSONObject jSONObject) {
        callJsMethod(str, jSONObject);
    }

    public com.baidu.tieba.tbadkCore.e.a.c hasNotificationPermission() {
        int i = 1;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (Build.VERSION.SDK_INT >= 19 && !NotificationManagerCompat.from(this.mContext).areNotificationsEnabled()) {
            i = 0;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c goToNotificationSetting() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        try {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c startDownloadCss(String str) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        JSONObject jSONObject = new JSONObject();
        if (!at.isEmpty(str)) {
            try {
                if (at.isEmpty(str)) {
                    jSONObject.put("resultCode", 0);
                    cVar.setData(jSONObject.toString());
                } else {
                    String BL = n.BL(str);
                    String BM = n.BM(str);
                    if (!n.BK(BM)) {
                        jSONObject.put("resultCode", 0);
                        cVar.setData(jSONObject.toString());
                    } else {
                        DownloadData downloadData = new DownloadData(BL, BL, str, null);
                        downloadData.setPath(BM);
                        com.baidu.tbadk.download.d.bEF().f(downloadData);
                        jSONObject.put("resultCode", 1);
                    }
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return cVar;
        }
        cVar.setData(jSONObject.toString());
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c setDisableGoBack() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        int i = 0;
        if (this.mContext instanceof TbWebViewActivity) {
            ((TbWebViewActivity) this.mContext).isDisableGoBack = true;
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    public void onDestroy() {
        if (this.mShakeController != null && this.mShakeController.isOpen()) {
            this.mShakeController.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callJsMethod(String str, JSONObject jSONObject) {
        if (this.mWebView != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.mWebView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')", null);
            } else {
                this.mWebView.loadUrl("javascript:" + str + "&&" + str + "('" + jSONObject.toString() + "')");
            }
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c getSupplementInfo() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
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
        String zid = TbadkCoreApplication.getInst().getZid();
        stringBuffer.append("zid=");
        stringBuffer.append(zid);
        stringBuffer.append("tiebaclient!!!");
        String md5 = s.toMd5(stringBuffer.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", imei);
            jSONObject.put("cuid", cuid);
            jSONObject.put(AdExtParam.KEY_SHOUBAI_CUID, cuidGalaxy2);
            jSONObject.put(Constants.PHONE_BRAND, str);
            jSONObject.put("client_type", "Android");
            jSONObject.put("client_version", version);
            jSONObject.put("zid", zid);
            jSONObject.put("sign", md5);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
            cVar.setData("");
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c getDeviceInfo() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
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
        String apc = com.baidu.tbadk.core.util.g.apc();
        stringBuffer.append("manufacturer=");
        stringBuffer.append(apc);
        String str5 = Build.HARDWARE;
        stringBuffer.append("hardware=");
        stringBuffer.append(str5);
        String str6 = Build.BOARD;
        stringBuffer.append("board=");
        stringBuffer.append(str6);
        String str7 = com.baidu.tbadk.core.util.g.eZ(TbadkCoreApplication.getInst()) ? "1" : "0";
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
            jSONObject.put(HttpConstants.HTTP_MANUFACTURER, apc);
            jSONObject.put(HttpConstants.HTTP_HARDWARE, str5);
            jSONObject.put(HttpConstants.HTTP_BOARD, str6);
            jSONObject.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str7);
            jSONObject.put("sign", md5);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            cVar.setData("");
            return cVar;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c sendCompleteTaskReqMsg(String str, String str2) {
        int i = 0;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, str2);
                CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                completeTaskReqMsg.completeId = jSONObject.toString();
                completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                MessageManager.getInstance().sendMessage(completeTaskReqMsg);
                i = 1;
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resultCode", i);
            cVar.setData(jSONObject2.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            return cVar;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c showTipToast(String str, String str2, String str3, int i, int i2) {
        int i3 = 1;
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (TextUtils.isEmpty(str) || !(this.mContext instanceof Activity)) {
            i3 = 0;
        } else {
            Activity activity = (Activity) this.mContext;
            if (!TextUtils.isEmpty(str3)) {
                String str4 = "showToast_" + str3;
                int i4 = com.baidu.tbadk.core.sharedPref.b.bvr().getInt(str4, 0);
                if (i4 < i) {
                    int i5 = i4 + 1;
                    com.baidu.tbadk.core.sharedPref.b.bvr().putInt(str4, i4);
                    g.publishEvent(new TipEvent(activity.getIntent(), str, str2, i2 == 1));
                }
            } else {
                g.publishEvent(new TipEvent(activity.getIntent(), str, str2, i2 == 1));
            }
            if (i2 == 1) {
                activity.finish();
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i3);
            cVar.setData(jSONObject.toString());
            return cVar;
        } catch (JSONException e) {
            BdLog.e(e);
            return cVar;
        }
    }

    private String getGetModalData() {
        JSONObject jSONObject;
        String bCe;
        int i = 0;
        try {
            bCe = com.baidu.tbadk.coreExtra.messageCenter.f.bCc().bCe();
        } catch (Exception e) {
            BdLog.e(e);
        }
        try {
            if (!TextUtils.isEmpty(bCe)) {
                jSONObject = new JSONObject(bCe);
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

    public com.baidu.tieba.tbadkCore.e.a.c jumpToHtmlPage(String str, int i) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            a.startWebActivity(this.mContext, str);
            if (i == 1 && (this.mContext instanceof Activity)) {
                ((Activity) this.mContext).finish();
            }
        }
        return cVar;
    }

    public com.baidu.tieba.tbadkCore.e.a.c jumpToHotTrendPage() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        com.baidu.tbadk.core.e.b.d(this.mContext, 16, false);
        return cVar;
    }

    private String jumpToPbPage(String str, String str2) {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext).createNormalCfg(str, null, str2);
        createNormalCfg.setStartFrom(5);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        return null;
    }

    private String getAPIs() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", 0);
            jSONObject.put("message", TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
            if (OpenJsSdkSwitch.isOn()) {
                jSONObject.put("data", new JSONArray(DescriptionTableInfo.getDescriptionTable()));
            } else {
                jSONObject.put("data", new JSONArray());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    public com.baidu.tieba.tbadkCore.e.a.c showAlertView(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
        com.baidu.tbadk.BdToken.completeTask.a aVar = new com.baidu.tbadk.BdToken.completeTask.a();
        aVar.title = str;
        aVar.subTitle = str2;
        aVar.eIn = i;
        aVar.eIo = i2;
        aVar.eIp = str3;
        aVar.eIq = str4;
        aVar.eIr = str5;
        aVar.eIs = str6;
        aVar.eIt = str7;
        aVar.eIu = str8;
        aVar.eIv = str9;
        com.baidu.tbadk.core.business.a aVar2 = new com.baidu.tbadk.core.business.a(TbadkCoreApplication.getInst().getCurrentActivity());
        aVar2.a(new a.InterfaceC0576a() { // from class: com.baidu.tbadk.browser.CommonTbJsBridge.4
            @Override // com.baidu.tbadk.core.business.a.InterfaceC0576a
            public void bnV() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 1);
                    if (CommonTbJsBridge.this.mResult != null) {
                        CommonTbJsBridge.this.mResult.confirm(jSONObject.toString());
                    }
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }

            @Override // com.baidu.tbadk.core.business.a.InterfaceC0576a
            public void onCancel() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 0);
                    if (CommonTbJsBridge.this.mResult != null) {
                        CommonTbJsBridge.this.mResult.confirm(jSONObject.toString());
                    }
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
        });
        aVar2.a(aVar);
        aVar2.boH().boI();
        return cVar;
    }
}
